package tangzongyun.activiti.sys.domain;

import java.io.Serializable;

/**
 * 
 * @Title: FlowLog.java
 * @Description: org.activiti.demo.domain
 * @Package org.activiti.demo.domain
 * @author hncdyj123@163.com
 * @date 2013-3-15
 * @version V1.0
 * 
 */
public class FlowLog  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 **/
	private int ID;
	/** 关联ID(表单ID) **/
	private String formID;
	/** 审核用户 **/
	private String userID;
	/** 用户类型(0:超级管理员、1:普通管理员、2:普通用户、3:开发者) **/
	private String userType;
	/** 操作类型(1:提交成功、2:审批通过、3:审批不通过) **/
	private String action;
	/** 操作时间,时间格式：yyyy-MM-dd hh:mm:ss **/
	private String logTime;
	/** 意见 **/
	private String opinion;
	/** 任务ID **/
	private String taskID;
	/** 任务名称 **/
	private String taskName;
	/** 流程ID **/
	private String flowID;
	/** 记录ID **/
	private String recordID;

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFormID() {
		return formID;
	}

	public void setFormID(String formID) {
		this.formID = formID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getFlowID() {
		return flowID;
	}

	public void setFlowID(String flowID) {
		this.flowID = flowID;
	}

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}
}
