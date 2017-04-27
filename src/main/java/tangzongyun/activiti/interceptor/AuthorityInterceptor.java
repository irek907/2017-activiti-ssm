package tangzongyun.activiti.interceptor;

import java.util.Map;

import tangzongyun.activiti.sys.domain.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		System.out.println("-------------------");
		/*System.out.println("begin check login interceptor!");
        // 对LoginAction不做该项拦截
        Object action = actionInvocation.getAction();
        if (action instanceof LoginAction) {
            System.out.println("exit check login, because this is login action.");
            return actionInvocation.invoke();
        }
 
        // 确认Session中是否存在LOGIN
        Map session = actionInvocation.getInvocationContext().getSession();
        String login = (String) session.get(LOGIN_KEY);
        if (login != null && login.length() > 0) {
            // 存在的情况下进行后续操作。
            System.out.println("already login!");
            return actionInvocation.invoke();
        } else {
            // 否则终止后续操作，返回LOGIN
            System.out.println("no login, forward login page!");
            return LOGIN_PAGE;
        }*/
		User user = (User) context.getSession().get("user");
		if(user!=null)
		return invocation.invoke();
		
		else
	
		return "login";
	}

}
