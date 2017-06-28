package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	LoginLog
 * @Author:			
 * @Company:		
 * @CreateDate:		2017-6-8 19:51:40
 */

public class LoginLog extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private String id;	  	
	private String loginName;			
	private String ipAddress;			
	private Date loginTime;			

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getLoginName() {
		return this.loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}	
	
	public String getIpAddress() {
		return this.ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}	
	
	public Date getLoginTime() {
		return this.loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}	
}
