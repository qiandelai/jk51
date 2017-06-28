package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Finance;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.service.FinanceService;
import cn.itcast.jk.utils.UtilFuns;

/**
 * @Description:	FinanceService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-9 19:20:14
 */

public class FinanceServiceImpl implements FinanceService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Finance> find(String hql, Class<Finance> entityClass, Object[] params) {
		return baseDao.find(hql, Finance.class, params);
	}

	public Finance get(Class<Finance> entityClass, Serializable id) {
		return baseDao.get(Finance.class, id);
	}

	public Page<Finance> findPage(String hql, Page<Finance> page, Class<Finance> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Finance.class, params);
	}

	public void saveOrUpdate(Finance entity) {
		Finance finance = baseDao.get(Finance.class, entity.getId());		
		if(UtilFuns.isNotEmpty(finance)){				//判断数据库中是否有这个对象，存在则更新				
			baseDao.saveOrUpdate(entity);
		}else{															//不存在代表新增，将状态设置成0
			entity.setState(0.0);								
			baseDao.saveOrUpdate(entity);
		}
	}



	public void saveOrUpdateAll(Collection<Finance> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Finance> entityClass, Serializable id) {
		baseDao.deleteById(Finance.class, id);
	}

	public void delete(Class<Finance> entityClass, Serializable[] ids) {
		baseDao.delete(Finance.class, ids);
	}

}

