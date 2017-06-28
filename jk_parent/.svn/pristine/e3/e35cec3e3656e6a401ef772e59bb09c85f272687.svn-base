package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.UtilFuns;

public class DeptServiceImpl implements DeptService {
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	@Override
	public List<Dept> find(String hql, Class<Dept> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}
	@Override
	public Dept get(Class<Dept> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}
	@Override
	public Page<Dept> findPage(String hql, Page<Dept> page, Class<Dept> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}
	@Override
	public void saveOrUpdate(Dept entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			entity.setState(1);
		}
		baseDao.saveOrUpdate(entity);
	}
	@Override
	public void saveOrUpdateAll(Collection<Dept> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}
	/**
	 * 递归删除部门
	 */
	public void deleteById(Class<Dept> entityClass, Serializable id) {
		List<Dept> list = baseDao.find("from Dept where parent.id=?", Dept.class, new Object[]{id});
		if(list!=null && list.size() > 0){
			for (Dept dept : list) {
				this.deleteById(entityClass,dept.getId());
			}
		}
		//删前先判断该部门是否存在，可能在递归过程中该部门已经被删除了
		Dept dept = baseDao.get(entityClass, id);
		if(dept!=null){
			baseDao.deleteById(entityClass, id);
		}
	}
	/**
	 * 批量删除部门
	 */
	public void delete(Class<Dept> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			this.deleteById(entityClass,id);
		}
	}
	
}
