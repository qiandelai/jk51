package cn.itcast.jk.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.domain.Memorandum;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.service.MemorandumService;
import cn.itcast.jk.utils.SysConstant;

/**
 * 主页
 * @author Administrator
 */
public class HomeAction extends BaseAction{
	
	private static final long serialVersionUID = -1084129033785013035L;
	private MemorandumService memorandumService;
	public void setMemorandumService(MemorandumService memorandumService) {
		this.memorandumService = memorandumService;
	}
	private String moduleName;		//动态指定跳转的模块，在struts.xml中配置动态的result
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String fmain(){
		return "fmain";
	}
	
	public String title(){
		//获取session
		//User curUser = (User)session.get(SysConstant.CURRENT_USER_INFO);
		//ActionContext.getContext().getValueStack().push(curUser);
		
		return "title";
	}
	
	//转向moduleName指向的模块
	public String tomain(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		this.setModuleName(moduleName);
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute(SysConstant.CURRENT_USER_INFO);
		List<Memorandum> mList = memorandumService.find("from Memorandum where userid=?", Memorandum.class, new Object[]{user.getId()});
		super.put("mList", mList);
		
		return "tomain";
	}
	
	public String toleft(){
		//获取request
		String moduleName = (String)request.get("moduleName");
		this.setModuleName(moduleName);
		if("home".equals(moduleName)){
			Map<String, Integer> allMap = (Map<String, Integer>) ServletActionContext.getRequest().getSession().getAttribute("allMap");
			
			List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(allMap.entrySet());  
	        
	        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {  
	            //升序排序  
	            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
	                return o2.getValue().compareTo(o1.getValue());
	            }  
	        });
	        List<Entry<String, Integer>> mList = new ArrayList<>();
	        for (Entry<String, Integer> entry : list) {
				if(mList.size()<3){
					mList.add(entry);
				}
			}
			super.put("mlist", mList);
		}
		
		return "toleft";
	}
	/**
	 * 清除快捷菜单
	 * @return
	 * @throws Exception
	 */
	public String DelFastMenu() throws Exception {
		Map<String, Integer> allMap = (Map<String, Integer>) ServletActionContext.getRequest().getSession().getAttribute("allMap");
		allMap.clear();
		//String moduleName = (String)request.get("moduleName");
		request.put("moduleName", "home");
		return toleft();
	}
}
