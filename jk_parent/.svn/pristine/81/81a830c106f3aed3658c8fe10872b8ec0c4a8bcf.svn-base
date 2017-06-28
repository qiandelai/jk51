package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.utils.UtilFuns;

/**
 * @Description:	PackingListService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-8 16:33:24
 */

public class PackingListServiceImpl implements PackingListService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<PackingList> find(String hql, Class<PackingList> entityClass, Object[] params) {
		return baseDao.find(hql, PackingList.class, params);
	}

	public PackingList get(Class<PackingList> entityClass, Serializable id) {
		return baseDao.get(PackingList.class, id);
	}

	public Page<PackingList> findPage(String hql, Page<PackingList> page, Class<PackingList> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, PackingList.class, params);
	}

	public void saveOrUpdate(PackingList entity) {
		if(entity.getId()==null){								
			//代表新增
			entity.setState(0.0);
			String exportIds = entity.getExportIds();
			if(exportIds!= null){
				String[] ids = exportIds.split(", ");
				for (String id : ids) {
					Export export = baseDao.get(Export.class, id);
					export.setState(3);
					baseDao.saveOrUpdate(export);
				}
			}
			baseDao.saveOrUpdate(entity);
		}else{
			//修改
			String exportIds = entity.getExportIds();
			if(exportIds!=null){
				String[] ids = exportIds.split(", ");
				for (String exportId : ids) {
					//获得出口报运对象
					Export export = baseDao.get(Export.class, exportId);
					//出口报运状态设置为已装箱
					export.setState(3);
					baseDao.saveOrUpdate(export);
				}
			}
			baseDao.saveOrUpdate(entity);
		}
	}



	public void saveOrUpdateAll(Collection<PackingList> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<PackingList> entityClass, Serializable id) {
		baseDao.deleteById(PackingList.class, id);
	}

	public void delete(Class<PackingList> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			PackingList packingList = baseDao.get(PackingList.class, id);
			String exportIds = packingList.getExportIds();
			if(exportIds!=null){
				String[] strs = exportIds.split(", ");
				for (String exportId : strs) {
					Export export = baseDao.get(Export.class, exportId);
					export.setState(2);
					baseDao.saveOrUpdate(export);
				}
			}
		}
		baseDao.delete(PackingList.class, ids);
	}

	public List<PackingList> findPackingList() {
		String hql="from PackingList where state = 1";
		List<PackingList> list =	baseDao.find(hql, PackingList.class, null);
		return list;
	}

}

