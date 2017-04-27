package tangzongyun.activiti.sys.domain;

import java.io.Serializable;

/**
 * 
 * @Title: SysUser.java
 * @Description: org.activiti.demo.domain
 * @Package org.activiti.demo.domain
 * @author hncdyj123@163.com
 * @date 2013-3-7
 * @version V1.0
 * 
 */
public class User  implements Serializable{

	private int ID;
	private String username;
	private String password;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
