package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Feedback;
import cn.itcast.jk.service.FeedbackService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

/**
 * @Description:	Feedback
 * @Author:			24K纯帅
 * @Company:
 * @CreateDate:		2017-6-9 17:18:49
 */

public class FeedbackServiceImpl implements FeedbackService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Feedback> find(String hql, Class<Feedback> entityClass, Object[] params) {
		return baseDao.find(hql, Feedback.class, params);
	}

	public Feedback get(Class<Feedback> entityClass, Serializable id) {
		return baseDao.get(Feedback.class, id);
	}

	public Page findPage(String hql, Page page, Class<Feedback> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Feedback.class, params);
	}
	
	public void saveOrUpdate(Feedback entity) {
		if(entity.getId()==null){								//代表新增
		    //设置初始状态为未处理
			entity.setState("0");								//状态：0未处理  1代表已处理
			
			
			
			baseDao.saveOrUpdate(entity);
		}else{
                  try {
                        // 获取修改前对象
                        Feedback feedback = baseDao.get(Feedback.class,entity.getId());
                        /**
                         * 自定义工具类修改数据替换原有数据
                         * 第一个参数是传入的对象,
                         * 第二个参数是查询到的对象
                         */
                        SetDataUtils.set(entity, feedback);
                        baseDao.saveOrUpdate(feedback);
                        
                  } catch (Exception e) {
                        e.printStackTrace();
                  }

            }
	}



	public void saveOrUpdateAll(Collection<Feedback> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Feedback> entityClass, String id) {
		baseDao.deleteById(Feedback.class, id);
	}

	public void delete(Class<Feedback> entityClass, String[] ids) {
	      for(String id : ids){
	            baseDao.deleteById(Feedback.class, id);
	            }
	}

     
    


}
