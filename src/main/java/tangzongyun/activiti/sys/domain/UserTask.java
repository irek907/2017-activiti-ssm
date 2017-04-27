package tangzongyun.activiti.sys.domain;

import java.io.Serializable;

/**
 * 用户任务实体类
 * 
 * @Title: UserTask.java
 * @Description: org.activiti.demo.domain
 * @Package org.activiti.demo.domain
 * @author hncdyj123@163.com
 * @date 2013-3-19
 * @version V1.0
 * 
 */
public class UserTask  implements Serializable{
	/** 任务ID **/
	private String ID;
	/** 执行ID **/
	private String executionId;
	/** 流程ID **/
	private String procinstId;
	/** 流程KEY **/
	private String prodefId;
	/** 当前处理人 **/
	private String assignee;
	/** 任务创建时间 **/
	private String createTime;
	/** 用户ID **/
	private String userID;
	/** 用户名 **/
	private String userName;
	/** 提交时间 **/
	private String logTime;
	/** 记录ID **/
	private String recordID;

	/** 提交动作 **/
	private String action;
	/** 审批意见 **/
	private String opinion;
	/** formID **/
	private String formID;
	/** 流程定义key **/
	private String definitionId;
	/** 流程ID **/
	private String instanceId;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public String getProcinstId() {
		return procinstId;
	}

	public void setProcinstId(String procinstId) {
		this.procinstId = procinstId;
	}

	public String getProdefId() {
		return prodefId;
	}

	public void setProdefId(String prodefId) {
		this.prodefId = prodefId;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getRecordID() {
		return recordID;
	}

	public void setRecordID(String recordID) {
		this.recordID = recordID;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getFormID() {
		return formID;
	}

	public void setFormID(String formID) {
		this.formID = formID;
	}

	public String getDefinitionId() {
		return definitionId;
	}

	public void setDefinitionId(String definitionId) {
		this.definitionId = definitionId;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

}
