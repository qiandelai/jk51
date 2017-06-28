package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.domain.Memorandum;
import cn.itcast.jk.utils.Page;

/**
 * @Description:	MemorandumService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-8 21:28:35
 */

public interface MemorandumService {

	public List<Memorandum> find(String hql, Class<Memorandum> entityClass, Object[] params);
	public Memorandum get(Class<Memorandum> entityClass, Serializable id);
	public Page<Memorandum> findPage(String hql, Page<Memorandum> page, Class<Memorandum> entityClass, Object[] params);
	
	public void saveOrUpdate(Memorandum entity);
	public void saveOrUpdateAll(Collection<Memorandum> entitys);
	
	public void deleteById(Class<Memorandum> entityClass, Serializable id);
	public void delete(Class<Memorandum> entityClass, Serializable[] ids);
}
