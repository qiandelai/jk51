package cn.itcast.jk.action.cargo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Invoice;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.utils.DownloadUtil;
import cn.itcast.jk.utils.FastJsonUtils;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.service.InvoiceService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.service.ShippingOrderService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @Description: InvoiceService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-6-9 17:54:50
 */

public class InvoiceAction extends BaseAction implements ModelDriven<Invoice> {
	// 注入service
	private InvoiceService invoiceService;

	public void setInvoiceService(InvoiceService invoiceService) {
		this.invoiceService = invoiceService;
	}

	// 注入委托单
	public ShippingOrderService shippingOrderService;

	public void setShippingOrderService(ShippingOrderService shippingOrderService) {
		this.shippingOrderService = shippingOrderService;
	}

	// 注入装箱
	private PackingListService packingListService;

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	// model驱动

	private Invoice model = new Invoice();

	public Invoice getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from Invoice o"; // 查询所有内容
		// 给页面提供分页数据
		page.setUrl("invoiceAction_list"); // 配置分页按钮的转向链接
		page = invoiceService.findPage(hql, page, Invoice.class, null);
		super.push(page);

		return "plist"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		page = shippingOrderService.findPage("from ShippingOrder where state =2", page, ShippingOrder.class, null);
		page.setUrl("invoiceAction_tocreate");
		super.put("page", page);

		return "pcreate";
	}

	// 新增保存
	public String insert() {

		invoiceService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {

		// 准备修改的数据
		Invoice obj = invoiceService.get(Invoice.class, model.getId());
		super.push(obj);

		return "pupdate";
	}

	// 修改保存
	public String update() {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性

		invoice.setScNo(model.getScNo());
		invoice.setBlNo(model.getBlNo());
		invoice.setTradeTerms(model.getTradeTerms());
		invoice.setState(model.getState());
		invoice.setCreateBy(model.getCreateBy());
		invoice.setCreateDept(model.getCreateDept());
		invoice.setCreateTime(model.getCreateTime());

		invoiceService.saveOrUpdate(invoice);

		return "alist";
	}

	// 删除一条
	public String deleteById() {
		invoiceService.deleteById(Invoice.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		invoiceService.delete(Invoice.class, model.getId().split(", "));

		return "alist";
	}

	// 查看
	public String toview() {
		Invoice obj = invoiceService.get(Invoice.class, model.getId());
		super.push(obj);
		
		
		page = shippingOrderService.findPage("from ShippingOrder where id ='"+model.getId()+"'", page, ShippingOrder.class, null);
		page.setUrl("invoiceAction_tocreate");
		super.put("page", page);

		return "pview"; // 转向查看页面
	}

	// 多条件查询功能实现
	public String paramsSelect() throws Exception {
		String createBy = model.getCreateBy();
		String createDept = model.getCreateDept();
		Date createTime = model.getCreateTime();

		String hql = "from Invoice where 1 = 1 ";

		// 加入查询条件
		if (createBy != null && !"".equals(createBy.trim())) {
			hql += " and createBy like '%" + createBy + "%' ";
		}
		if (createDept != null && !"".equals(createDept.trim())) {
			hql += " and createDept like '%" + createDept + "%' ";
		}
		if (createTime != null && !"".equals(createTime.toString().trim())) {
			// 转换时间格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = dateFormat.format(createTime);
			hql += " and to_char(createTime,'yyyy-MM-dd') = '" + dateStr + "' ";
		}

		invoiceService.findPage(hql, page, Invoice.class, null);
		page.setUrl("invoiceAction_paramsSelect");

		super.push(page);

		return "plist";
	}

	// 提交
	public String submit() throws Exception {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		invoice.setState(1.0);
		invoiceService.saveOrUpdate(invoice);

		return "alist";
	}

	// 取消
	public String cancel() throws Exception {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		invoice.setState(0.0);
		invoiceService.saveOrUpdate(invoice);

		return "alist";
	}

	// ajax获取状态
	public void getState() throws Exception {
		Invoice invoice = invoiceService.get(Invoice.class, model.getId());
		String state = invoice.getState().toString();

		ServletActionContext.getResponse().getWriter().write(state);
		;

	}

	// 打印
	public String print() throws Exception {

		InputStream is = new FileInputStream(
				ServletActionContext.getServletContext().getRealPath("/make/xlsprint/tINVOICE.xls"));
		Workbook wb = new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		String id = model.getId();
		PackingList packingList = packingListService.get(PackingList.class, id);
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, id);
		Invoice invoice = invoiceService.get(Invoice.class, id);
		Row row = null;
		Cell cell = null;
		row = sheet.getRow(3);
		cell = row.getCell(0);
		cell.setCellValue(packingList.getSeller());

		row = sheet.getRow(3);
		cell = row.getCell(5);
		String title = invoice.getCreateTime().toString().replace("-0", "-").replace("-", "年") + "月份出货表";
		cell.setCellValue(title);

		row = sheet.getRow(8);
		cell = row.getCell(0);
		cell.setCellValue(packingList.getBuyer());

		row = sheet.getRow(15);
		cell = row.createCell(0);
		cell.setCellValue(invoice.getScNo());
		cell = row.createCell(2);
		cell.setCellValue(invoice.getCreateTime().toString());
		cell = row.getCell(5);
		cell.setCellValue(invoice.getScNo());
		cell = row.createCell(9);
		cell.setCellValue(invoice.getBlNo());

		/*
		 * row = sheet.createRow(19); cell = row.createCell(0);
		 * cell.setCellValue(shippingOrder.getLcNo());
		 */

		// 下载
		DownloadUtil down = new DownloadUtil();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		wb.write(byteArrayOutputStream);
		down.download(byteArrayOutputStream, ServletActionContext.getResponse(), title + ".xls");

		return NONE;
	}
}
