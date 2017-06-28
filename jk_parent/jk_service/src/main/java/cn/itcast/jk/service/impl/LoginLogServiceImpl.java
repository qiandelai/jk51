package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.LoginLog;
import cn.itcast.jk.service.LoginLogService;
import cn.itcast.jk.utils.Page;

/**
 * @Description:	LoginLog
 * @Author:			
 * @Company:		
 * @CreateDate:		2017-6-8 19:51:42
 */
public class LoginLogServiceImpl implements LoginLogService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<LoginLog> find(String hql, Class<LoginLog> entityClass, Object[] params) {
		return baseDao.find(hql, LoginLog.class, params);
	}

	public LoginLog get(Class<LoginLog> entityClass, Serializable id) {
		return baseDao.get(LoginLog.class, id);
	}

	public Page<LoginLog> findPage(String hql, Page<LoginLog> page, Class<LoginLog> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, LoginLog.class, params);
	}

	public void saveOrUpdate(LoginLog entity) {
		if(entity.getId()==null){								//代表新增
			//entity.setState(1);									//状态：0停用1启用 默认启用
		}
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<LoginLog> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<LoginLog> entityClass, Serializable id) {
		baseDao.deleteById(LoginLog.class, id);
	}

	public void delete(Class<LoginLog> entityClass, Serializable[] ids) {
		baseDao.delete(LoginLog.class, ids);
	}

}

