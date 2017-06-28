package cn.itcast.jk.action.sysadmin;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Dept;
import cn.itcast.jk.service.DeptService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

public class DeptAction extends BaseAction implements ModelDriven<Dept>{
	private Dept model = new Dept();
	public Dept getModel() {
		return model;
	}
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	private Page page = new Page();
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	/**
	 * 分页查询所有部门
	 */
	public String list() throws Exception {
		deptService.findPage("from Dept where state=1", page, Dept.class, null);
		page.setUrl("deptAction_list");
		super.push(page);
		return "list";
	}
	/**
	 * 查看部门
	 */
	public String toview() throws Exception {
		Dept obj = deptService.get(Dept.class, model.getId());
		super.push(obj);
		return "toview";
	}
	/**
	 * 到新增部门页面
	 */
	public String tocreate() throws Exception {
		List<Dept> deptList = deptService.find("from Dept where state=1", Dept.class, null);
		super.put("deptList", deptList);
		return "tocreate";
	}
	/**
	 * 新增部门
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		deptService.saveOrUpdate(model);
		return "alist";
	}
	/**
	 * 到修改部门页面
	 */
	public String toupdate() throws Exception {
		List<Dept> list = deptService.find("from Dept where state=1", Dept.class, null);
		super.put("deptList", list);
		Dept dept = deptService.get(Dept.class, model.getId());
		super.push(dept);
		//从列表中移除当前修改的部门，解决自己成为自己的父部门的问题
		list.remove(dept);
		return "toupdate";
	}
	/**
	 * 修改部门
	 */
	public String update() throws Exception {
		Dept obj = deptService.get(Dept.class, model.getId());
		SetDataUtils.set(model, obj);
//		BeanUtils.populate(obj,ServletActionContext.getRequest().getParameterMap());
		deptService.saveOrUpdate(obj);
		return "alist";
	}
	/**
	 * 批量删除部门
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		deptService.delete(Dept.class, ids);
		return "alist";
	}
}
