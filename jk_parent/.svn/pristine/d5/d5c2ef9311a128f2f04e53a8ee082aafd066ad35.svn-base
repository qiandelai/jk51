package cn.itcast.jk.action.sysadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Module;
import cn.itcast.jk.domain.Role;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.exception.SysException;
import cn.itcast.jk.service.ModuleService;
import cn.itcast.jk.service.RoleService;
import cn.itcast.jk.service.UserService;
import cn.itcast.jk.utils.FastJsonUtils;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

public class RoleAction extends BaseAction implements ModelDriven<Role>{
	private Role model = new Role();
	public Role getModel() {
		return model;
	}
	private RoleService roleService;
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
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
	private String moduleIds;
	public void setModuleIds(String moduleIds) {
		this.moduleIds = moduleIds;
	}
	/**
	 * 分页查询所有角色
	 */
	public String list() throws Exception {
		roleService.findPage("from Role", page, Role.class, null);
		page.setUrl("roleAction_list");
		super.push(page);
		return "list";
	}
	/**
	 * 查看角色
	 */
	public String toview() throws Exception {
		Role obj = roleService.get(Role.class, model.getId());
		super.push(obj);
		return "toview";
	}
	/**
	 * 到新增角色页面
	 */
	public String tocreate() throws Exception {
		return "tocreate";
	}
	/**
	 * 新增角色
	 * @return
	 * @throws Exception
	 */
	public String insert() throws Exception {
		roleService.saveOrUpdate(model);
		return "alist";
	}
	/**
	 * 到修改角色页面
	 */
	public String toupdate() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		super.push(role);
		return "toupdate";
	}
	/**
	 * 修改角色
	 */
	public String update() throws Exception {
		Role obj = roleService.get(Role.class, model.getId());
		SetDataUtils.set(model, obj);
		roleService.saveOrUpdate(obj);
		return "alist";
	}
	/**
	 * 删除角色
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		String[] ids = model.getId().split(", ");
		roleService.delete(Role.class, ids);
		return "alist";
	}
	
	/**
	 * 到达给角色分配权限页面
	 * @return
	 * @throws Exception
	 */
	public String tomodule() throws SysException {
		try {
			Role role = roleService.get(Role.class, model.getId());
			super.push(role);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SysException("玩啥呢，先选择一项在操作啊。小伙子！");
		}
		return "tomodule";
	}
	/**
	 * 页面发送ajax请求，给页面返回所有模块和当前角色模块的json串
	 * @throws Exception
	 * //json串:[{"id":"模块id","pId":"父模块id","name":"模块名称","checked":"true|false"},{"id":"模块id","pId":"父模块id","name":"模块名称","checked":"true|false"}]
	 */
	public void roleModuleJsonStr1() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		Set<Module> modules = role.getModules();
		List<Module> list = moduleService.find("from Module where state=1", Module.class, null);
		int size = list.size();
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Module module : list) {
			size --;
			sb.append("{\"id\":\"").append(module.getId())
			.append("\",\"pId\":\"").append(module.getParentId())
			.append("\",\"name\":\"").append(module.getName())
			.append("\",\"checked\":\"");
			if(modules.contains(module))
				sb.append("true");
			else
				sb.append("false");
			sb.append("\"}");
			if(size > 0)
				sb.append(",");
		}
		sb.append("]");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(sb.toString());
	}
	/**
	 * 页面发送ajax请求，给页面返回所有模块和当前角色模块的json串
	 * fastjson方式
	 * @throws Exception
	 */
	public void roleModuleJsonStr() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		Set<Module> modules = role.getModules();
		List<Module> list = moduleService.find("from Module where state=1", Module.class, null);
		List<Map<String, String>> JsonList = new ArrayList<>();
		for (Module module : list) {
			Map<String, String> map = new HashMap<>();
			map.put("id", module.getId());
			map.put("pId", module.getParentId());
			map.put("name", module.getName());
			map.put("checked", modules.contains(module)?"true":"false");
			JsonList.add(map);
		}
		String jsonString = FastJsonUtils.toJSONString(JsonList);
		FastJsonUtils.write_json(ServletActionContext.getResponse(), jsonString);
	}
	/**
	 * 给角色分配权限
	 * @return
	 * @throws Exception
	 */
	public String module() throws Exception {
		Role role = roleService.get(Role.class, model.getId());
		String[] ids = moduleIds.split(",");
		Set<Module> modules = new HashSet<>();
		for (String id : ids) {
			Module module = moduleService.get(Module.class, id);
			modules.add(module);
		}
		role.setModules(modules);
		roleService.saveOrUpdate(role);
		return "alist";
	}
}
