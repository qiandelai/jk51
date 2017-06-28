package cn.itcast.jk.action.memorandum;

import java.util.List;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Memorandum;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;
import cn.itcast.jk.service.MemorandumService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description:	MemorandumService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-8 21:28:35
 */

public class MemorandumAction extends BaseAction implements ModelDriven<Memorandum> {
	//注入service
	private MemorandumService memorandumService;
	public void setMemorandumService(MemorandumService memorandumService) {
		this.memorandumService = memorandumService;
	}
	
	//model驱动
	private Memorandum model = new Memorandum();
	public Memorandum getModel() {
		return this.model;
	}
	
	
	//转向新增页面
	public String tocreate(){
		return "pcreate";
	}
	
	//新增保存
	public String insert(){
		memorandumService.saveOrUpdate(model);
		return "alist";			//返回列表，重定向action_list
	}

	//转向修改页面
	public String toupdate(){
		Memorandum obj = memorandumService.get(Memorandum.class, model.getId());
		super.push(obj);
		return "pupdate";
	}
	
	//修改保存
	public String update() throws Exception{
		Memorandum memorandum = memorandumService.get(Memorandum.class, model.getId());
		
		SetDataUtils.set(model, memorandum);
		
		memorandumService.saveOrUpdate(memorandum);
		
		return "alist";
	}
	
	//删除一条
	public String deleteById(){
		memorandumService.deleteById(Memorandum.class, model.getId());
		return "alist";
	}
	
	
	
	/**
	 * 修改备忘录的坐标
	 * @return
	 * @throws Exception
	 */
	public String updateLocation() throws Exception {
		for (int i = 0; i < mr_id.length;i++){
			Memorandum obj = memorandumService.get(Memorandum.class, mr_id[i]);
			obj.setLeft(posX[i]);
			obj.setTop(posY[i]);
			memorandumService.saveOrUpdate(obj);
		}
		return "alist";
	}
	private String[] mr_id;
	private Double[] posX;
	private Double[] posY;
	public String[] getMr_id() {
		return mr_id;
	}

	public void setMr_id(String[] mr_id) {
		this.mr_id = mr_id;
	}

	public Double[] getPosX() {
		return posX;
	}

	public void setPosX(Double[] posX) {
		this.posX = posX;
	}

	public Double[] getPosY() {
		return posY;
	}

	public void setPosY(Double[] posY) {
		this.posY = posY;
	}
	
	
}   
