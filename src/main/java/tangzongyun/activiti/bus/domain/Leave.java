package tangzongyun.activiti.bus.domain;

import java.io.Serializable;


/**
 * 
 * @Title: Leave.java
 * @Description: 请假实体类
 * @Package org.activiti.demo.domain
 * @author hncdyj123@163.com
 * @date 2013-3-15
 * @version V1.0
 * 
 */
public class Leave  implements Serializable{
	private int ID;
	private String leavePerson;
	private String superior;
	private String startTime;
	private String endTime;
	private String leaveReasons;
	private String createTime;
	private String userID;
	private String domStatus;

	public int getID() {
		return ID;
	}

	public String getLeavePerson() {
		return leavePerson;
	}

	public String getSuperior() {
		return superior;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public String getLeaveReasons() {
		return leaveReasons;
	}

	public String getCreateTime() {
		return createTime;
	}

	public String getUserID() {
		return userID;
	}

	public String getDomStatus() {
		return domStatus;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public void setLeavePerson(String leavePerson) {
		this.leavePerson = leavePerson;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setLeaveReasons(String leaveReasons) {
		this.leaveReasons = leaveReasons;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setDomStatus(String domStatus) {
		this.domStatus = domStatus;
	}

}