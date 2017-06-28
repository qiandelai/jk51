package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.itcast.jk.domain.LoginLog;
import cn.itcast.jk.utils.Page;

/**
 * @Description:	LoginLog
 * @Author:			
 * @Company:		
 * @CreateDate:		2017-6-8 19:51:41
 */
public interface LoginLogService {

	public List<LoginLog> find(String hql, Class<LoginLog> entityClass, Object[] params);
	public LoginLog get(Class<LoginLog> entityClass, Serializable id);
	public Page<LoginLog> findPage(String hql, Page<LoginLog> page, Class<LoginLog> entityClass, Object[] params);
	
	//public void save(LoginLog entity);
	public void saveOrUpdate(LoginLog entity);
	public void saveOrUpdateAll(Collection<LoginLog> entitys);
	
	public void deleteById(Class<LoginLog> entityClass, Serializable id);
	public void delete(Class<LoginLog> entityClass, Serializable[] ids);
}
