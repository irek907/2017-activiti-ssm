package tangzongyun.activiti.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import tangzongyun.activiti.sys.domain.User;

/*public class SessionFilter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		HttpSession session = request.getSession();

		System.out.println("------path"+path);

		return true;

	}


}
 */

public class SessionFilter extends  OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
					throws ServletException, IOException {
		// TODO Auto-generated method 

		String URI = request.getRequestURI();
		System.out.println(URI);

		User user =  (User) request.getSession().getAttribute("user");
		
		System.out.println("--------------------user="+user);

		if(URI.endsWith(".jsp") || URI.endsWith("index.html") ||  URI.endsWith("index.action") ){

			if(URI.endsWith("login.jsp")){
				filterChain.doFilter(request, response);
			}else{
				if(user!=null )
					filterChain.doFilter(request, response);
				else{
					response.sendRedirect("login.jsp");
				}
			}
		}else
			filterChain.doFilter(request, response);







	}



}