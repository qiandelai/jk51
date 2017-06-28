package cn.itcast.jk.action.cargo;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ExtCproductService;
import cn.itcast.jk.service.FactoryService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

public class ExtCproductAction extends BaseAction implements ModelDriven<ExtCproduct> {

	private ExtCproduct model = new ExtCproduct();
	public ExtCproduct getModel() {
		return model;
	}
	private ExtCproductService extCproductService;
	public void setExtCproductService(ExtCproductService extCproductService) {
		this.extCproductService = extCproductService;
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
	 * 到附件添加和附件列表页面
	 * @return
	 * @throws Exception
	 */
	public String tocreate() throws Exception {
		List<Factory> factoryList = factoryService.find("from Factory where state=? and ctype=?", Factory.class, new Object[]{1,"附件"});
		super.put("factoryList", factoryList);
		extCproductService.findPage("from ExtCproduct where contractProduct.id=?", page, ExtCproduct.class, new Object[]{model.getContractProduct().getId()});
		super.push(page);
		return "tocreate";
	}
	/**
	 * 添加附件
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		extCproductService.saveOrUpdate(model);
		return tocreate();
	}
	/**
	 * 到修改附件页面
	 * @return
	 * @throws Exception
	 */
	public String toupdate() throws Exception {
		ExtCproduct extCproduct = extCproductService.get(ExtCproduct.class, model.getId());
		super.push(extCproduct);
		List<Factory> factoryList = factoryService.find("from Factory where state=? and ctype=?", Factory.class, new Object[]{1,"附件"});
		super.put("factoryList", factoryList);
		return "toupdate";
	}
	/**
	 * 修改附件
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		ExtCproduct extCproduct = extCproductService.get(ExtCproduct.class, model.getId());
		SetDataUtils.set(model, extCproduct);
		extCproductService.saveOrUpdate(extCproduct);
		return tocreate();
	}
	/**
	 * 删除附件
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		extCproductService.deleteById(ExtCproduct.class, model.getId());
		return tocreate();
	}
}
