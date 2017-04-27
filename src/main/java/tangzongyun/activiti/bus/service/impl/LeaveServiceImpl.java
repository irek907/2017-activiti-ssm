package tangzongyun.activiti.bus.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;















//import org.activiti.demo.constants.Constants;
//import org.activiti.demo.dao.CommonDao;
//import org.activiti.demo.domain.FlowLog;
//import org.activiti.demo.domain.Leave;
//import org.activiti.demo.engine.ProcessEngineCore;
//import org.activiti.demo.utils.StringUtil;
//import org.activiti.demo.utils.ToolUtil;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tangzongyun.activiti.bus.domain.Leave;
import tangzongyun.activiti.bus.service.ILeaveService;
import tangzongyun.activiti.constants.Constants;
import tangzongyun.activiti.engine.ProcessEngineCore;
import tangzongyun.activiti.sys.dao.ICommonDao;
import tangzongyun.activiti.sys.domain.FlowLog;
import tangzongyun.activiti.sys.domain.User;
import tangzongyun.activiti.utils.StringUtil;
import tangzongyun.activiti.utils.ToolUtil;

/**
 * 
 * @Title: LeaveServiceImpl.java
 * @Description: org.activiti.demo.service
 * @Package org.activiti.demo.service
 * @author hncdyj123@163.com
 * @date 2013-3-15
 * @version V1.0
 * 
 */
@Service("leaveService")
public class LeaveServiceImpl implements ILeaveService {
	@Resource(name = "commonDao")
	private ICommonDao commonDao;
	@Resource(name = "processEngineCore")
	private ProcessEngineCore processEngineCore;

	@Override
	public List<Leave> listLeave(Leave leave) throws Exception {
		return commonDao.listObject(leave);
	}

	@Override
	public int listLeaveCount(Leave leave) throws Exception {
		return commonDao.listObjectCount(leave);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void deleteLeave(Leave leave) throws Exception {
		commonDao.deleteObject(leave);
	}
	
	public long days(Leave leave) throws ParseException{
		Date a1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(leave.getStartTime());
		Date b1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(leave.getEndTime());
		//获取相减后天数
		long day = (b1.getTime()-a1.getTime())/(24*60*60*1000);
		return day;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public String insertLeave(Leave leave,User user) throws Exception {
		commonDao.insertObject(leave);
		// 当前新增记录ID
		String recordID = commonDao.getNextSequence(leave);
		// 下一节点审批人
		String nextApp = "";
		// 提交 则启动流程
		if (StringUtil.isEqualString(leave.getDomStatus(), Constants.FLOW_DOM_SUMBIT)) {
			// 当前登录用户提交申请
			Map<String, Object> proMap = new HashMap<String, Object>();
			proMap.put("loginUser", leave.getUserID());
			proMap.put("days", days(leave));
			proMap.put("bm", "bm");
			proMap.put("jl", "jl");
			proMap.put("zj", "zj");
			proMap.put("rs", "rs");
			proMap.put("xj", "xj");
			proMap.put("wo", user.getUsername());
			
			String psName = "WF_" + leave.getClass().getSimpleName();
			// 启动流程并且完成第一节点TASK
			//启动流程，设置流程中运行参数
			ProcessInstance processInstance = processEngineCore.startInstance(psName, proMap);
			//获取当前任务
			Task task = processEngineCore.queryByExecutionIdSingle(processInstance.getProcessInstanceId());
			//执行任务，任务参数为null
			processEngineCore.completeUserTask(task.getId(), null);
			//获取下一个任务执行人，根据流程实例ID获取
			nextApp = ToolUtil.getNextAppersonal(processEngineCore, task.getExecutionId());
			// 创建流程日志
			FlowLog flowLog = ToolUtil.getFlowLog(leave.getUserID(), recordID, "1", null, task.getId(), processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
			commonDao.insertObject(flowLog);
		}
		return nextApp;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public String updateLeave(Leave leave,User user) throws Exception {
		Leave ltemp = (Leave) commonDao.findObject(leave);
		commonDao.updateObject(leave);
		// 下一节点审批人
		String nextApp = "";
		// 提交 dom启动流程
		if (StringUtil.isEqualString(ltemp.getDomStatus(), Constants.FLOW_DOM_SAVE) && StringUtil.isEqualString(leave.getDomStatus(), Constants.FLOW_DOM_SUMBIT)) {
			// 当前登录用户提交申请
			Map<String, Object> proMap = new HashMap<String, Object>();
			proMap.put("loginUser", leave.getUserID());
			proMap.put("days", days(leave));
			proMap.put("bm", "bm");
			proMap.put("jl", "jl");
			proMap.put("zj", "zj");
			proMap.put("rs", "rs");
			proMap.put("xj", "xj");
			proMap.put("wo", user.getUsername());
			// 启动流程并且完成第一节点TASK
			String psName = "WF_" + leave.getClass().getSimpleName();
			ProcessInstance processInstance = processEngineCore.startInstance(psName, proMap);
			Task task = processEngineCore.queryByExecutionIdSingle(processInstance.getProcessInstanceId());
			processEngineCore.completeUserTask(task.getId(), null);
			nextApp = ToolUtil.getNextAppersonal(processEngineCore, task.getExecutionId());
			// 创建流程日志
			FlowLog flowLog = ToolUtil.getFlowLog(leave.getUserID(), Integer.toString(leave.getID()), "1", null, task.getId(), processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
			commonDao.insertObject(flowLog);
		} else if (StringUtil.isEqualString(ltemp.getDomStatus(), Constants.FLOW_DOM_NOTPASS) && StringUtil.isEqualString(leave.getDomStatus(), Constants.FLOW_DOM_SUMBIT)){
			
			// 流程打回提交
			FlowLog f = new FlowLog();
			f.setRecordID(Integer.toString(ltemp.getID()));
			// 获取流程日志集合
			List<FlowLog> list = commonDao.listObject(f);
			if (!StringUtil.isEmptyArray(list)) {
				f = list.get(0);
			}
			// 根据流程ID查询task 未考虑子流程
			Task task = processEngineCore.queryByExecutionIdSingle(f.getFlowID());
			if (task != null) {
				// 提交完成当前任务
				processEngineCore.completeUserTask(task.getId(), null);
				nextApp = ToolUtil.getNextAppersonal(processEngineCore, task.getExecutionId());
				// 创建流程日志
				FlowLog flowLog = ToolUtil.getFlowLog(leave.getUserID(), Integer.toString(leave.getID()), "1", null, task.getId(), task.getProcessDefinitionId(), task.getProcessInstanceId());
				commonDao.insertObject(flowLog);
			}
			
		}
		return nextApp;
	}

	@Override
	public Leave getByIDLeave(Leave leave) throws Exception {
		return (Leave) commonDao.findObject(leave);
	}

	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public void setProcessEngineCore(ProcessEngineCore processEngineCore) {
		this.processEngineCore = processEngineCore;
	}

}
