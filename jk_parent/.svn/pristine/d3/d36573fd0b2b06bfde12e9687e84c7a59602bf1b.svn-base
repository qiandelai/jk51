package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.jk.utils.UtilFuns;

/**
 * @Description:	InvoiceService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-9 17:54:50
 */

public class InvoiceServiceImpl implements InvoiceService {
	//spring注入dao
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<Invoice> find(String hql, Class<Invoice> entityClass, Object[] params) {
		return baseDao.find(hql, Invoice.class, params);
	}

	public Invoice get(Class<Invoice> entityClass, Serializable id) {
		return baseDao.get(Invoice.class, id);
	}

	public Page<Invoice> findPage(String hql, Page<Invoice> page, Class<Invoice> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, Invoice.class, params);
	}

	public void saveOrUpdate(Invoice entity) {
		if(UtilFuns.isEmpty(entity.getState()+"")){								//代表新增
			//String uuid = UUID.randomUUID().toString().replace("-","");
			
			//设置草稿状态--发票
			entity.setState(0.0);
			//设置委托的已发票状态
			ShippingOrder shippingOrder = baseDao.get(ShippingOrder.class,entity.getId());
			shippingOrder.setState(3.0);
			baseDao.saveOrUpdate(shippingOrder);
			//更新装箱的发票号发票日期
			PackingList packingList = baseDao.get(PackingList.class, entity.getId());
			packingList.setInvoiceNo(entity.getScNo());
			packingList.setInvoiceDate(entity.getCreateTime());
			baseDao.saveOrUpdate(packingList);
		}
		
		baseDao.saveOrUpdate(entity);
	}



	public void saveOrUpdateAll(Collection<Invoice> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}

	public void deleteById(Class<Invoice> entityClass, Serializable id) {
		baseDao.deleteById(Invoice.class, id);
	}

	public void delete(Class<Invoice> entityClass, Serializable[] ids) {
		for (Serializable id : ids) {
			ShippingOrder shippingOrder = baseDao.get(ShippingOrder.class,id);
			shippingOrder.setState(2.0);
			baseDao.saveOrUpdate(shippingOrder);
		}
		
		baseDao.delete(Invoice.class, ids);
	}



}

