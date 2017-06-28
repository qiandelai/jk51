package cn.itcast.jk.action.cargo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Finance;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.UtilFuns;
import cn.itcast.jk.utils.file.FileUtil;
import cn.itcast.jk.service.FinanceService;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.jk.service.PackingListService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description: FinanceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-6-9 19:20:14
 */

public class FinanceAction extends BaseAction implements ModelDriven<Finance> {
	// 注入service
	private FinanceService financeService;

	public void setFinanceService(FinanceService financeService) {
		this.financeService = financeService;
	}

	// 注入packingListService
	private PackingListService packingListService;

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	//注入invoiceService
	private InvoiceService invoiceService;
	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}
	//model驱动

	private Finance model = new Finance();

	public Finance getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from Finance o"; // 查询所有内容
		// 给页面提供分页数据
		page.setUrl("financeAction_list"); // 配置分页按钮的转向链接
		page = financeService.findPage(hql, page, Finance.class, null);
		super.push(page);
		return "plist"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		// 准备装箱单数据
	/*	List<Invoice> invoiceList = invoiceService.invoiceList();
		super.put("invoiceList", invoiceList);		//页面就可以访问invoiceList */	
		page = invoiceService.findPage("from Invoice where state = 1", page, Invoice.class, null);
		page.setUrl("financeAction_tocreate");
		super.push(page);
	return "pcreate";

	}

	// 新增保存
	public String insert() {
		//新增财务报运，将选中的发票状态更改为
		financeService.saveOrUpdate(model);
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		invoice.setState(2.0);
		invoiceService.saveOrUpdate(invoice);
		return "alist";			//返回列表，重定向action_list

	}

	// 转向修改页面
	public String toupdate() {
		// 准备数据
		/*
		 * List<Finance> financeList = financeService.financeList();
		 * super.put("financeList", financeList); //页面就可以访问financeList
		 */
		// 准备修改的数据
		Finance obj = financeService.get(Finance.class, model.getId());
		super.push(obj);

		return "pupdate";
	}

	// 修改保存
	public String update() {
		Finance finance = financeService.get(Finance.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性
		finance.setId(model.getId());
		finance.setInputDate(model.getInputDate());
		finance.setInputBy(model.getInputBy());
		finance.setCreateBy(model.getCreateBy());
		finance.setCreateDept(model.getCreateDept());
		finance.setCreateTime(model.getCreateTime());
		financeService.saveOrUpdate(finance);

		return "alist";
	}

	// 删除一条
	public String deleteById() {
		financeService.deleteById(Finance.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		//草稿状态下删除，将发票状态改回1
		financeService.delete(Finance.class, model.getId().split(", "));

		//获取传入的发票单列表，遍历修改状态
		 String[] ids = model.getId().split(", ");
		 for (String id : ids) {
				Invoice invoice = invoiceService.get(Invoice.class, id);
				invoice.setState(1.0);
				invoiceService.saveOrUpdate(invoice);
		}
		

		return "alist";
	}

	// 查看
	public String toview() {

		Finance finance = financeService.get(Finance.class, model.getId());
		super.push(finance);
		return "pview";			//转向查看页面

	
	}

	//提交财务报表
	public String submit() throws Exception {
		//提交多个
		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			Finance finance = financeService.get(Finance.class, id);
			finance.setState(1.0);
			financeService.saveOrUpdate(finance);
		}
		
		return "alist";
	}
	//取消提交
	public String cancel() throws Exception {
		String[] ids = model.getId().split(", ");
		for (String id : ids) {
			Finance finance = financeService.get(Finance.class, id);
			finance.setState(0.0);
			financeService.saveOrUpdate(finance);
		}
		return "alist";
	}


	// 多条件查询功能实现
	public String paramsSelect() throws Exception {
		String inputBy = model.getInputBy();
		Date inputDate = model.getInputDate();

		String hql = "from Finance where 1 = 1 ";

		// 加入查询条件
		if (inputBy != null && !"".equals(inputBy.trim())) {
			hql += " and inputBy like '%" + inputBy + "%' ";
		}
		if (inputDate != null && !"".equals(inputDate.toString().trim())) {
			// 转换时间格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = dateFormat.format(inputDate);
			hql += " and to_char(inputDate,'yyyy-MM-dd') = '" + dateStr + "' ";
		}

		financeService.findPage(hql, page, Finance.class, null);
		page.setUrl("financeAction_paramsSelect");
		super.push(page);
		return "plist";

	}

}
