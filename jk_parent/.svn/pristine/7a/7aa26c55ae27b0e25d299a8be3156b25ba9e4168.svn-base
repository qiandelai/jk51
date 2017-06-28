package cn.itcast.jk.action.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.itcast.jk.utils.Encrypt;

public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	/**
	 * 密码比较
	 */
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		String password = new String(upToken.getPassword());
		String formPassword = Encrypt.md5(password, username);
		String dbPassword = (String) info.getCredentials();
		return super.equals(formPassword, dbPassword);
	}
	
}
