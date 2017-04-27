package tangzongyun.activiti.sys.domain.result;

import java.io.Serializable;


/**
 * 
 * @Title: Result.java
 * @Description: ajax请求返回信息
 * @Package com.isoftstone.workflowplugin.utils
 * @author hncdyj123@163.com
 * @date 2012-5-24
 * @version V1.0
 *
 */
public class Result  implements Serializable{
	/** 返回成功与否 */
	private boolean success;
	/** 返回消息 */
	private String msg;

	public Result() {
		this.success = true;
		this.msg = "";
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
