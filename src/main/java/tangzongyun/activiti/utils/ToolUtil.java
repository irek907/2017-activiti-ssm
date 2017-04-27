package tangzongyun.activiti.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import tangzongyun.activiti.constants.Constants;
import tangzongyun.activiti.sys.domain.FlowLog;
import tangzongyun.activiti.engine.ProcessEngineCore;


public class ToolUtil {
	private static final Logger logger = Logger.getLogger(ToolUtil.class);

	private static Map<String, String> noteMap = null;

	static {
		noteMap = new HashMap<String, String>();
		noteMap.put(Constants.IBATIS_OPT_ADD_KEY, Constants.IBATIS_OPT_ADD_VALUE);
		noteMap.put(Constants.IBATIS_OPT_UPDATE_KEY, Constants.IBATIS_OPT_UPDATE_VALUE);
		noteMap.put(Constants.IBATIS_OPT_DELETE_KEY, Constants.IBATIS_OPT_DELETE_VALUE);
		noteMap.put(Constants.IBATIS_OPT_LIST_KEY, Constants.IBATIS_OPT_LIST_VALUE);
		noteMap.put(Constants.IBATIS_OPT_LISTCOUNT_KEY, Constants.IBATIS_OPT_LISTCOUNT_VALUE);
		noteMap.put(Constants.IBATIS_OPT_FIND_KEY, Constants.IBATIS_OPT_FIND_VALUE);
		noteMap.put(Constants.IBATIS_OPT_FINDID_KEY, Constants.IBATIS_OPT_FINDID_VALUE);
	}

	public static String getCommonDaoNodePath(String opt, Object obj) {
		// 组装节点如：com.isoftstone.dynamicform.obj.listObject
		StringBuffer nodePath = new StringBuffer();
		nodePath.append(Constants.IBATIS_SQL_PATH);
		nodePath.append(Constants.IBATIS_OPT_POINT);
		nodePath.append(obj.getClass().getSimpleName());
		nodePath.append(Constants.IBATIS_OPT_POINT);
		nodePath.append(StringUtil.formatterString(noteMap.get(opt), obj.getClass().getSimpleName()));
		logger.debug("ObjectNodePath：" + nodePath.toString());
		return nodePath.toString();
	}

	/**
	 * 获取流程日志对象
	 * 
	 * @param userID
	 *            用户ID
	 * @param domStatus
	 *            记录状态
	 * @param recordID
	 *            记录主键
	 * @param action
	 *            状态(1.同意 2.不同意)
	 * @param opinion
	 *            意见
	 * @param processInstance
	 *            流程对象
	 * @return
	 */
	public static FlowLog getFlowLog(String userID, String recordID, String action, String opinion, String taskID, String definitionId, String instanceId) {
		FlowLog flowLog = new FlowLog();
		flowLog.setFormID(null);
		flowLog.setUserID(userID);
		flowLog.setAction(action);
		flowLog.setLogTime(DateUtil.getCurDateTime());
		flowLog.setOpinion(opinion);
		flowLog.setTaskID(taskID);
		flowLog.setTaskName(definitionId);
		flowLog.setFlowID(instanceId);
		flowLog.setRecordID(recordID);
		return flowLog;
	}

	/**
	 * 获取下一节点审批人
	 * 
	 * @param processEngineCore
	 * @param userTask
	 * @return
	 */
	public static String getNextAppersonal(ProcessEngineCore processEngineCore, String executionId) {
		List<Task> taskList = processEngineCore.queryByExecutionId(executionId);
		String nextApp = "";
		for (int i = 0; i < taskList.size(); i++) {
			nextApp += taskList.get(i).getAssignee() + (i == taskList.size() - 1 ? "" : ",");
		}
		return nextApp;
	}

}
