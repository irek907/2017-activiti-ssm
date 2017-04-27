package tangzongyun.activiti.sys.action;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tangzongyun.activiti.base.BaseAction;
import tangzongyun.activiti.sys.domain.User;
import tangzongyun.activiti.sys.service.IUserService;
import tangzongyun.activiti.utils.StringUtil;


/**
 * 
 * @Title: SysUserAction.java
 * @Description: org.activiti.demo.action
 * @Package org.activiti.demo.action
 * @author hncdyj123@163.com
 * @date 2013-3-14
 * @version V1.0
 * 
 */
@Controller("sysUserAction")
@Scope("protype")
@Namespace("/activiti/user")
@ParentPackage("json-default")
public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger =Logger.getLogger(UserAction.class);
	@Resource(name = "userService")
	private IUserService userService;
	private User user;

	@Action(value = "login", results = { @Result(type = "json", params = { "root", "result" }) })
	public String login() {
		if (user == null) {
			user = new User();
		}
		try {
			User loginUser = userService.findSysUserByID(user);
			if (loginUser != null && StringUtil.isEqualString(loginUser.getPassword(), user.getPassword())) {
				super.getSession().put("user", loginUser);
			} else {
				super.setMessage("用户名不存在或密码错误!");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			super.setSuccess(false);
			return ERROR;
		}
		return SUCCESS;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
