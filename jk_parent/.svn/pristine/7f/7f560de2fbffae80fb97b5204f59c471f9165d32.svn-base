package cn.itcast.jk.action.sysadmin;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Module;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

public class ModuleAction extends BaseAction implements ModelDriven<Module>{
	private Module model = new Module();
	public Module getModel() {
		return model;
	}
	private ModuleService moduleService;
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 分页查询所有模块
	 */
	public String list() throws Exception {
		moduleService.findPage("from Module", page, Module.class, null);
		page.setUrl("moduleAction_list");
		super.push(page);
		return "list";
	}
	/**
	 * 查看模块
	 */
	public String toview() throws Exception {
		Module obj = moduleService.get(Module.class, model.getId());
		super.push(obj);
		return "toview";
	}
	/**
	 * 到新增模块页面
	 */
	public String tocreate() throws Exception {
		return "tocreate";
	}
	/**
	 * 新增模块
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		moduleService.saveOrUpdate(model);
		return "alist";
	}
	/**
	 * 到修改模块页面
	 */
	public String toupdate() throws Exception {
		Module module = moduleService.get(Module.class, model.getId());
		super.push(module);
		return "toupdate";
	}
	/**
	 * 修改模块
	 */
	public String update() throws Exception {
		Module obj = moduleService.get(Module.class, model.getId());
		SetDataUtils.set(model, obj);
		moduleService.saveOrUpdate(obj);
		return "alist";
	}
	/**
	 * 批量删除部门
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		moduleService.delete(Module.class, ids);
		return "alist";
	}
}
