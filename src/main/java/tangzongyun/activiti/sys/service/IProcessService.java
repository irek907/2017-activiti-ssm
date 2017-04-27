package tangzongyun.activiti.sys.service;

import java.io.InputStream;
import java.util.List;



import tangzongyun.activiti.sys.domain.FlowLog;
import tangzongyun.activiti.sys.domain.UserTask;



/**
 * 
 * @Title: ProcessService.java
 * @Description: org.activiti.demo.service
 * @Package org.activiti.demo.service
 * @author hncdyj123@163.com
 * @date 2013-3-19
 * @version V1.0
 * 
 */
public interface IProcessService {
	/**
	 * 查询个人代办
	 * 
	 * @param userTask
	 * @return
	 * @throws Exception
	 */
	public List<UserTask> queryPersonalTask(UserTask userTask) throws Exception;

	/**
	 * 查询个人代办数量
	 * 
	 * @param userTask
	 * @return
	 * @throws Exception
	 */
	public int queryPersonalTaskCount(UserTask userTask) throws Exception;

	/**
	 * 处理个人代办
	 * 
	 * @param userTask
	 * @param processInstance
	 * @throws Exception
	 */
	public String handlePersonalTask(UserTask userTask) throws Exception;

	/**
	 * 获取流程日志
	 * 
	 * @param flowLog
	 * @return
	 * @throws Exception
	 */
	public List<FlowLog> listFlowLog(FlowLog flowLog) throws Exception;

	/**
	 * 根据taskId获取图片流
	 * 
	 * @param taskId
	 * @return
	 * @throws Exception
	 */
	public InputStream getProcessImage(String taskId) throws Exception;

}
