package tangzongyun.activiti.sys.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import tangzongyun.activiti.constants.Constants;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tangzongyun.activiti.bus.domain.Leave;
import tangzongyun.activiti.engine.ProcessEngineCore;
import tangzongyun.activiti.sys.dao.ICommonDao;
import tangzongyun.activiti.sys.domain.FlowLog;
import tangzongyun.activiti.sys.domain.UserTask;
import tangzongyun.activiti.sys.service.IProcessService;
import tangzongyun.activiti.utils.StringUtil;
import tangzongyun.activiti.utils.ToolUtil;

/**
 * 
 * @Title: ProcessServiceImpl.java
 * @Description: org.activiti.demo.service
 * @Package org.activiti.demo.service
 * @author hncdyj123@163.com
 * @date 2013-3-19
 * @version V1.0
 * 
 */
@Service("processService")
public class ProcessServiceImpl implements IProcessService {

	@Resource(name = "commonDao")
	private ICommonDao commonDao;
	@Resource(name = "processEngineCore")
	private ProcessEngineCore processEngineCore;

	@Override
	public List<UserTask> queryPersonalTask(UserTask userTask) throws Exception {
		return (List<UserTask>) commonDao.listObject(userTask);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public String handlePersonalTask(UserTask userTask) throws Exception {
		// 处理当前代办
		Map<String, Object> proMap = new HashMap<String, Object>();
		proMap.put("action", userTask.getAction());
		processEngineCore.completeUserTask(userTask.getID(), proMap);
		// 获取下一节点审批人
		String nextApp = ToolUtil.getNextAppersonal(processEngineCore, userTask.getInstanceId());
		// 创建流程日志
		FlowLog flowLog = ToolUtil.getFlowLog(userTask.getUserID(), userTask.getRecordID(), userTask.getAction(), userTask.getOpinion(), userTask.getID(), userTask.getDefinitionId(), userTask.getInstanceId());
		commonDao.insertObject(flowLog);
		// 查看流程是否结束
		boolean isend = processEngineCore.queryProcessIsEnd(userTask.getInstanceId());
		Leave leave = new Leave();
		leave.setID(Integer.parseInt(flowLog.getRecordID()));
		if (StringUtil.isEqualString(userTask.getAction(), Constants.FLOW_AGREE) && isend) {
			leave.setDomStatus(Constants.FLOW_DOM_PASS);
			// 修改记录
			commonDao.updateObject(leave);
		}
		if (StringUtil.isEqualString(userTask.getAction(), Constants.FLOW_DISAGREE)) {
			leave.setDomStatus(Constants.FLOW_DOM_NOTPASS);
			// 修改记录
			commonDao.updateObject(leave);
		}
		
		return nextApp;
	}

	@Override
	public List<FlowLog> listFlowLog(FlowLog flowLog) throws Exception {
		return (List<FlowLog>) commonDao.listObject(flowLog);
	}

	@Override
	public int queryPersonalTaskCount(UserTask userTask) throws Exception {
		return commonDao.listObjectCount(userTask);
	}

	@Override
	public InputStream getProcessImage(String taskId) throws Exception {
		return processEngineCore.getImageStream(taskId);
	}

	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public void setProcessEngineCore(ProcessEngineCore processEngineCore) {
		this.processEngineCore = processEngineCore;
	}

}
