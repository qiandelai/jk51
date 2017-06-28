package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.UtilFuns;

public class ExtCproductServiceImpl implements ExtCproductService {
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<ExtCproduct> find(String hql, Class<ExtCproduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}
	
	public ExtCproduct get(Class<ExtCproduct> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public Page<ExtCproduct> findPage(String hql, Page<ExtCproduct> page, Class<ExtCproduct> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	public void saveOrUpdate(ExtCproduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			Double amount = 0.0;
			if(UtilFuns.isNotEmpty(entity.getCnumber())&&UtilFuns.isNotEmpty(entity.getPrice())){
				amount = entity.getCnumber() * entity.getPrice();
				entity.setAmount(amount);
				Contract contract = baseDao.get(Contract.class, entity.getContractProduct().getContract().getId());
				contract.setTotalAmount(contract.getTotalAmount() + amount);
				baseDao.saveOrUpdate(contract);
			}
		}else{
			Double oldAmount = entity.getAmount();
			Double amount = 0.0;
			if(UtilFuns.isNotEmpty(entity.getCnumber())&&UtilFuns.isNotEmpty(entity.getPrice())){
				amount = entity.getCnumber() * entity.getPrice();
				entity.setAmount(amount);
				Contract contract = baseDao.get(Contract.class, entity.getContractProduct().getContract().getId());
				contract.setTotalAmount(contract.getTotalAmount() -oldAmount + amount);
				baseDao.saveOrUpdate(contract);
			}
		}
		baseDao.saveOrUpdate(entity);
	}

	@Override
	public void saveOrUpdateAll(Collection<ExtCproduct> entitys) {
		// TODO Auto-generated method stub
		baseDao.saveOrUpdateAll(entitys);
	}
	
	
	public void deleteById(Class<ExtCproduct> entityClass, Serializable id) {
		ExtCproduct extCproduct = baseDao.get(ExtCproduct.class, id);
		Contract contract = extCproduct.getContractProduct().getContract();
		contract.setTotalAmount(contract.getTotalAmount() - extCproduct.getAmount());
		baseDao.saveOrUpdate(contract);
		baseDao.deleteById(entityClass, id);
	}
	
	
	public void delete(Class<ExtCproduct> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);
	}
	
}
