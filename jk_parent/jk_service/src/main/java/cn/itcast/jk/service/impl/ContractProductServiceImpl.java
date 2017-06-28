package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.UtilFuns;

public class ContractProductServiceImpl implements ContractProductService {
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public List<ContractProduct> find(String hql, Class<ContractProduct> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}
	
	public ContractProduct get(Class<ContractProduct> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}

	public Page<ContractProduct> findPage(String hql, Page<ContractProduct> page, Class<ContractProduct> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}

	public void saveOrUpdate(ContractProduct entity) {
		if(UtilFuns.isEmpty(entity.getId())){
			Double amount = 0.0;
			if(UtilFuns.isNotEmpty(entity.getCnumber())&&UtilFuns.isNotEmpty(entity.getPrice())){
				amount = entity.getCnumber() * entity.getPrice();
				entity.setAmount(amount);
				Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
				contract.setTotalAmount(contract.getTotalAmount() + amount);
				baseDao.saveOrUpdate(contract);
			}
		}else{
			Double oldAmount = entity.getAmount();
			Double amount = 0.0;
			if(UtilFuns.isNotEmpty(entity.getCnumber())&&UtilFuns.isNotEmpty(entity.getPrice())){
				amount = entity.getCnumber() * entity.getPrice();
				entity.setAmount(amount);
				Contract contract = baseDao.get(Contract.class, entity.getContract().getId());
				contract.setTotalAmount(contract.getTotalAmount() - oldAmount + amount);
				baseDao.saveOrUpdate(contract);
			}
		}
		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<ContractProduct> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}
	
	
	public void deleteById(Class<ContractProduct> entityClass, Serializable id) {
		ContractProduct contractProduct = baseDao.get(ContractProduct.class, id);
		Contract contract = contractProduct.getContract();
		Set<ExtCproduct> extCproducts = contractProduct.getExtCproducts();
		for (ExtCproduct extCproduct : extCproducts) {
			Double extCproductAmount = extCproduct.getAmount();
			contract.setTotalAmount(contract.getTotalAmount() - extCproductAmount);
		}
		Double contractProductAmount = contractProduct.getAmount();
		contract.setTotalAmount(contract.getTotalAmount() - contractProductAmount);
		baseDao.saveOrUpdate(contract);		
		baseDao.deleteById(entityClass, id);
	}
	
	
	public void delete(Class<ContractProduct> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);
	}
	
}
