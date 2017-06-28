package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Memorandum;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.MemorandumService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SysConstant;

/**
 * @Description:	MemorandumService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-8 21:28:35
 */

public class MemorandumServiceImpl implements MemorandumService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Memorandum> find(String hql, Class<Memorandum> entityClass, Object[] params) {
		return baseDao.find(hql, Memorandum.class, params);
	}

	public Memorandum get(Class<Memorandum> entityClass, Serializable id) {
		return baseDao.get(Memorandum.class, id);
	}

	public Page<Memorandum> findPage(String hql, Page<Memorandum> page, Class<Memorandum> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Memorandum.class, params);
	}

	public void saveOrUpdate(Memorandum entity) {
		if(entity.getId()==null){								//代表新增
			entity.setBackground(entity.getBackground().substring(1));
			User user = (User) ServletActionContext.getRequest().getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
//			List<Memorandum> mList = baseDao.find("from Memorandum where userid=?", Memorandum.class, new Object[]{user.getId()});
//			entity.setTop(70d);
//			TreeSet<Double> tree = new TreeSet<>();
//			for (Memorandum memorandum : mList) {
//				tree.add(memorandum.getLeft());
//			}
//			//entity.setLeft(40d + mList.size() * 270d);
//			//新增备忘录在空缺的位置//
//			int i = 0;
//			for (Double left : tree) {
//				if((40d + i * 270d)!=left){
//					entity.setLeft((40d + i * 270d));
//					break;
//				}
//				i++;
//			}
//			
//			if(entity.getLeft()==null){
//				entity.setLeft(40d + mList.size() * 270d);
//			}
			entity.setLeft(860d);
			entity.setTop(70d);
			entity.setUserid(user.getId());
		}
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<Memorandum> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Memorandum> entityClass, Serializable id) {
		baseDao.deleteById(Memorandum.class, id);
	}

	public void delete(Class<Memorandum> entityClass, Serializable[] ids) {
		baseDao.delete(Memorandum.class, ids);
	}

}

