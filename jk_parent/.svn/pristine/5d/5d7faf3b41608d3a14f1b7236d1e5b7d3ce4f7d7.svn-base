package cn.itcast.jk.action.cargo;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

public class ContractProductAction extends BaseAction implements ModelDriven<ContractProduct> {

	private ContractProduct model = new ContractProduct();
	public ContractProduct getModel() {
		return model;
	}
	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}
	private FactoryService factoryService;
	public void setFactoryService(FactoryService factoryService) {
		this.factoryService = factoryService;
	}
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	/**
	 * 到货物列表和新增货物页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		contractProductService.findPage("from ContractProduct where contract.id=?", 
				page, ContractProduct.class, new Object[]{model.getContract().getId()});
		super.push(page);
		List<Factory> factoryList = factoryService.find("from Factory where state=? and ctype=?", Factory.class, new Object[]{1,"货物"});
		super.put("factoryList", factoryList);
		return "tocreate";
	}
	/**
	 * 新增货物
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		contractProductService.saveOrUpdate(model);
		return tocreate();
	}
	/**
	 * 到修改货物页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		ContractProduct contractProduct = contractProductService.get(ContractProduct.class, model.getId());
		super.push(contractProduct);
		List<Factory> factoryList = factoryService.find("from Factory where state=? and ctype=?", Factory.class, new Object[]{1,"货物"});
		super.put("factoryList", factoryList);
		return "toupdate";
	}
	/**
	 * 修改货物
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ContractProduct contractProduct = contractProductService.get(ContractProduct.class, model.getId());
		SetDataUtils.set(model, contractProduct);
		contractProductService.saveOrUpdate(contractProduct);
		return tocreate();
	}
	/**
	 * 删除货物
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		contractProductService.deleteById(ContractProduct.class, model.getId());
		return tocreate();
	}
}
