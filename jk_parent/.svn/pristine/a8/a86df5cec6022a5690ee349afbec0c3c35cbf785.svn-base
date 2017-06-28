package cn.itcast.jk.action.shiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.UserService;

public class AuthRealm extends AuthorizingRealm {
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User user = (User) principals.iterator().next();
		Set<Role> roles = user.getRoles();
		List<String> list = new ArrayList<>();
		if(roles!=null&&roles.size()>0){
			for (Role role : roles) {
				Set<Module> modules = role.getModules();
				if(modules!=null&&modules.size()>0){
					for (Module module : modules) {
						list.add(module.getName());
					}
				}
			}
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.addStringPermissions(list);
			return info;
		}
		return null;
	}

	/**
	 * 认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		List<User> list = userService.find("from User where userName=?", User.class, new Object[]{username});
		if(list!=null && list.size() > 0){
			User user = list.get(0);
			AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
			return info;
		}
		return null;
	}

	

}
