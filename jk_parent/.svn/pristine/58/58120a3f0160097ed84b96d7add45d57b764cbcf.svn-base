package cn.itcast.jk.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import cn.itcast.jk.dao.BaseDao;
import cn.itcast.jk.domain.Module;

public class MyShortCutInteceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获取到所有二级菜单的url，存入集合menuList
		List<String> menuList = (List<String>) ServletActionContext.getRequest().getSession().getAttribute("menu");
		if(menuList == null || menuList.size() == 0){
			menuList = new ArrayList<>();
			ApplicationContext ac = (ApplicationContext) invocation.getInvocationContext().getApplication().get(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
			BaseDao baseDao = (BaseDao) ac.getBean("baseDao");
			List<Module> moduleList = baseDao.find("from Module where layerNum=?", Module.class, new Object[]{2});
			for (Module module : moduleList) {
				if(module.getCurl()!=null)
					menuList.add(module.getCurl()+"1234"+module.getCpermission());
			}
			ServletActionContext.getRequest().getSession().setAttribute("menu", menuList);
		}
		//从session中获取到map集合，map集合存的是key=url1234模块名称，value=次数
		Map<String, Integer> allMap = (Map<String, Integer>) ServletActionContext.getRequest().getSession().getAttribute("allMap");
		if(allMap == null || allMap.size() == 0){
			allMap = new TreeMap<String,Integer>();
			ServletActionContext.getRequest().getSession().setAttribute("allMap", allMap);
		}
		String uri = ServletActionContext.getRequest().getRequestURI();
		for (String string : menuList) {
			if(uri.contains(string.split("1234")[0])){
				//System.out.println(uri);
				//添加次数集合写在这里
				if(allMap.keySet().contains(string)){
					allMap.put(string, allMap.get(string)+1);
				}else{
					allMap.put(string, 1);
				}
				break;
			}
		}
//		List<Map<String, Integer>> allList = (List<Map<String, Integer>>) ServletActionContext.getRequest().getSession().getAttribute("allList");
//		if(allList == null || allList.size() == 0){
//			allList = new ArrayList<>();
//		}
//		String uri = ServletActionContext.getRequest().getRequestURI();
//		for (String string : menuList) {
//			if(uri.contains(string)){
//				//System.out.println(uri);
//				//添加次数集合写在这里
//				for (Map<String, Integer> map : allList) {
//					if(map.keySet().contains(string)){
//						
//					}
//				}
//			}
//		}
		
		return invocation.invoke();
	}

}
