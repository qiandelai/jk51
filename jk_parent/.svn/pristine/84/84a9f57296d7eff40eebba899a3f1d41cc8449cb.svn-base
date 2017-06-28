package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.ExportProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.ExtEproduct;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.UtilFuns;

public class ExportServiceImpl implements ExportService {
	
	private BaseDao baseDao;
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public List<Export> find(String hql, Class<Export> entityClass, Object[] params) {
		return baseDao.find(hql, entityClass, params);
	}
	
	public Export get(Class<Export> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}
	
	public Page<Export> findPage(String hql, Page<Export> page, Class<Export> entityClass, Object[] params) {
		return baseDao.findPage(hql, page, entityClass, params);
	}
	
	/**
	 * 保存或者更新用户
	 * @throws MailInfoException 
	 */
	public void saveOrUpdate(Export entity){
		if(UtilFuns.isEmpty(entity.getId())){
			//页面没有的数据	1.状态	2.制单日期		3.合同及确认书号customerContract
			entity.setState(0);
			entity.setInputDate(new Date());
			//修改合同状态
			StringBuilder sb = new StringBuilder();
			String[] ids = entity.getContractIds().split(", ");
			for (String id : ids) {
				Contract contract = baseDao.get(Contract.class, id);
				contract.setState(2);
				sb.append(contract.getCustomName()).append(",");
				baseDao.saveOrUpdate(contract);
			}
			entity.setCustomerContract(sb.toString());
			//数据搬家
			String hql = "from ContractProduct where contract.id in ("+UtilFuns.joinInStr(ids)+")";
			List<ContractProduct> list = baseDao.find(hql, ContractProduct.class, null);
			Set<ExportProduct> exportProductSet = new HashSet<>();
			for (ContractProduct contractProduct : list) {
				ExportProduct exportProduct = new ExportProduct();
				BeanUtils.copyProperties(contractProduct, exportProduct);
				exportProduct.setId(null);
				exportProductSet.add(exportProduct);
				exportProduct.setExport(entity);//维护外键
				Set<ExtCproduct> extCproductSet = contractProduct.getExtCproducts();
				Set<ExtEproduct> extEproductSet = new HashSet<>();
				for (ExtCproduct extCproduct : extCproductSet) {
					ExtEproduct extEproduct = new ExtEproduct();
					BeanUtils.copyProperties(extCproduct, extEproduct);
					extEproduct.setId(null);
					extEproductSet.add(extEproduct);
					extEproduct.setExportProduct(exportProduct);
				}
				exportProduct.setExtEproducts(extEproductSet);
			}
			entity.setExportProducts(exportProductSet);
		}
		baseDao.saveOrUpdate(entity);
	}

	public void saveOrUpdateAll(Collection<Export> entitys) {
		baseDao.saveOrUpdateAll(entitys);
	}
	
	public void deleteById(Class<Export> entityClass, Serializable id) {
		baseDao.deleteById(entityClass, id);
	}
	
	public void delete(Class<Export> entityClass, Serializable[] ids) {
		baseDao.delete(entityClass, ids);
	}

	@Override
	public void updateState(String[] ids, int state) {
		for (String id : ids) {
			Export export = baseDao.get(Export.class, id);
			export.setState(state);
			baseDao.saveOrUpdate(export);
		}
	}
	/**
	 * 电子报运
	 */
	@Override
	public void update(Export obj) {
		Export export = baseDao.get(Export.class, obj.getId());
		export.setState(obj.getState());
		export.setRemark(obj.getRemark());
		Set<ExportProduct> exportProducts = obj.getExportProducts();
		for (ExportProduct exportProduct : exportProducts) {
			ExportProduct product = baseDao.get(ExportProduct.class, exportProduct.getId());
			product.setTax(exportProduct.getTax());
			baseDao.saveOrUpdate(product);
		}
		baseDao.saveOrUpdate(export);
	}
}
