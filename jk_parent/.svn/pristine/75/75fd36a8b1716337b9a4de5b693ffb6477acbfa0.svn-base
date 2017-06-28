package cn.itcast.jk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import cn.itcast.jk.domain.LoginLog;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.LoginLogService;
import cn.itcast.jk.utils.SysConstant;

@Aspect
public class LoginExtend {
	private LoginLogService loginLogService;
	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}
	
	@After(value="execution(* cn.itcast.jk.action.LoginAction.login(..))")
	public void rizhi(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		if (user!=null) {
		LoginLog log = new LoginLog();
		log.setIpAddress(request.getRemoteAddr());
		log.setLoginName(user.getUserName());
		loginLogService.saveOrUpdate(log);
		}
	}
}
