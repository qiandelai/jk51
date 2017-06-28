package cn.itcast.jk.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.domain.User;
import cn.itcast.jk.utils.SysConstant;
import cn.itcast.jk.utils.UtilFuns;

/**
 * 登录和退出类
 */
public class LoginAction  {

	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	//shiro安全框架登录
	public String login() throws Exception {
		if(UtilFuns.isEmpty(username)){
			return "login";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			subject.login(token);
			User user = (User) subject.getPrincipal();
			request.getSession().setAttribute(SysConstant.CURRENT_USER_INFO, user);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorInfo", "用户名或密码错误");
			return "login";
		}
		
//		if(true){
//			String msg = "登录错误，请重新填写用户名密码!";
//			this.addActionError(msg);
//			throw new Exception(msg);
//		}
//		User user = new User(username, password);
//		User login = userService.login(user);
//		if (login != null) {
//			ActionContext.getContext().getValueStack().push(user);
//			session.put(SysConstant.CURRENT_USER_INFO, login);	//记录session
//			return SUCCESS;
//		}
//		return "login";
	}
	
	
	//退出
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute(SysConstant.CURRENT_USER_INFO);		//删除session
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "logout";
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

