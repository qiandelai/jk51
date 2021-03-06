package cn.itcast.jk.action.cargo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.domain.ShippingOrder;
import cn.itcast.jk.domain.User;
import cn.itcast.jk.exception.SysException;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.service.ShippingOrderService;
import cn.itcast.jk.utils.DownloadUtil;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SysConstant;

/**
 * @Description: ShippingOrder
 * @Author:
 * @Company:
 * @CreateDate: 2016-8-16 0:31:31
 */

public class ShippingOrderAction extends BaseAction implements ModelDriven<ShippingOrder> {
	// 注入service
	private ShippingOrderService shippingOrderService;

	public void setShippingOrderService(ShippingOrderService shippingOrderService) {
		this.shippingOrderService = shippingOrderService;
	}

	private PackingListService packingListService;

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	// model驱动
	private ShippingOrder model = new ShippingOrder();

	public ShippingOrder getModel() {
		return this.model;
	}

	private String buttonName;

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		/*
		 * this.setButtonName("shippingOrderAction"); // 要实现的功能是细粒度查询, 功能,
		 * 从export表中查询出数据, 放入pageBean对象中 User user = super.getCurUser(); //
		 * 获取当前用户对象
		 */ 
		String hql = "from ShippingOrder where 1=1 ";
		 User user = (User) session.get(SysConstant.CURRENT_USER_INFO);
		 // 查询所有内容
		  int degree = user.getUserInfo().getDegree(); // 获取用户的权限等级
		  	if (degree == 4) {
			  // 四级是普通员工只能自己看
			  hql += "and createBy = '" + user.getId() +"'"; 
		  	}else if (degree == 3) {
			  // 三级管理本部门, 可以看所有本部门的信息
			  hql += "and createDept like '" + user.getDept().getId() + "%'"; } 
		   else if(degree == 2) { 
			  // 二级管理所有下属部门, 可以查看管辖区域内的信息
			  hql += " and createDept like '" + user.getDept().getParent().getId() + "%'";
		   } else if (degree == 1) { 
			  // 细粒度没有做得很完整, 高等级依然只能以部门查看
			  hql +=" and createDept like '" + user.getDept().getParent().getId() + "%'";
		  		} else if (degree == 0) {
			  // 细粒度没有做得很完整, 高等级依然只能以部门查看
			  hql +=" and createDept like '" + user.getDept().getParent().getId() + "%'";
				 }
		// 给页面提供分页数据
		page.setUrl("shippingOrderAction_list"); // 配置分页按钮的转向链接
		page = shippingOrderService.findPage(hql, page, ShippingOrder.class, null);
		super.put("page", page);

		return "plist"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		// 准备数据
		String hql = "from PackingList Where State=1";
		page = packingListService.findPage(hql, page, PackingList.class, null);
		super.put("page", page); // 页面就可以访问shippingOrderList

		return "pcreate";
	}

	// 新增保存
	public String insert() {

		model.setState((double) 0); // 0是草稿 2是已委托 默认草稿
		 PackingList packingList = packingListService.get(PackingList.class, model.getId());
		 packingList.setState((double) 2);
		 packingListService.saveOrUpdate(packingList);
		shippingOrderService.saveOrUpdate(model);
		// 跳转页面
		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {
		// 准备数据 查询出数据
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		// 压入栈顶
		super.push(shippingOrder);

		// 页面就可以访问shippingOrderList

		// 准备修改的数据

		return "pupdate";
	}

	// 修改保存
	public String update() {
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());

		// 设置修改的属性，根据业务去掉自动生成多余的属性
		shippingOrder.setOrderType(model.getOrderType());
		shippingOrder.setShipper(model.getShipper());
		shippingOrder.setConsignee(model.getConsignee());
		shippingOrder.setNotifyParty(model.getNotifyParty());
		shippingOrder.setLcNo(model.getLcNo());
		shippingOrder.setPortOfLoading(model.getPortOfLoading());
		shippingOrder.setPortOfTrans(model.getPortOfTrans());
		shippingOrder.setPortOfDischarge(model.getPortOfDischarge());
		shippingOrder.setLoadingDate(model.getLoadingDate());
		shippingOrder.setLimitDate(model.getLimitDate());
		shippingOrder.setIsBatch(model.getIsBatch());
		shippingOrder.setIsTrans(model.getIsTrans());
		shippingOrder.setCopyNum(model.getCopyNum());
		shippingOrder.setRemark(model.getRemark());
		shippingOrder.setSpecialCondition(model.getSpecialCondition());
		shippingOrder.setFreight(model.getFreight());
		shippingOrder.setCheckBy(model.getCheckBy());
		// shippingOrder.setState(model.getState());
		// shippingOrder.setCreateBy(model.getCreateBy());
		// shippingOrder.setCreateDept(model.getCreateDept());
		// shippingOrder.setCreateTime(model.getCreateTime());

		shippingOrderService.saveOrUpdate(shippingOrder);

		return "alist";
	}

	// 删除一条
	public String deleteById() {
		 PackingList packingList = packingListService.get(PackingList.class, model.getId());
		 packingList.setState((double) 1);
		 packingListService.saveOrUpdate(packingList);
		shippingOrderService.deleteById(ShippingOrder.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		shippingOrderService.delete(ShippingOrder.class, model.getId().split(", "));
		 PackingList packingList = packingListService.get(PackingList.class, model.getId());
		 packingList.setState((double) 1);
		 packingListService.saveOrUpdate(packingList);
		return "alist";
	}

	// 查看
	public String toview() throws Exception {
		try {
			ShippingOrder obj = shippingOrderService.get(ShippingOrder.class, model.getId());
			String hql = "from PackingList Where id=?";
			page = packingListService.findPage(hql, page, PackingList.class, new Object[]{model.getId()});
			super.put("page", page); // 页面就可以访问shippingOrderList
			super.push(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SysException("请选择一项进行提交");
		}

		return "pview"; // 转向查看页面
	}

	// 提交
	public String submit() throws Exception {
		// 根据id获取state状态
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		shippingOrder.setState(2.0);

		shippingOrderService.saveOrUpdate(shippingOrder);
		// 跳转页面
		return "alist";
	}

	// 装箱后发票按钮
	public String finish() throws Exception {
		// 根据id获取state状态
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		shippingOrder.setState(2.0);
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 跳转页面
		return "alist";
	}

	// 取消
	public String cancel() throws Exception {
		// 根据id获取state状态
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		if (shippingOrder.getState() == 2) {
			shippingOrder.setState((double) 0);
		}
		shippingOrderService.saveOrUpdate(shippingOrder);
		// 跳转页面
		return "alist";
	}

	// ===============打印================================
	// 大标题的样式
	public CellStyle bigTitle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 16);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 字体加粗

		style.setFont(font);

		style.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

		return style;
	}

	// 小标题的样式
	public CellStyle title(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 12);

		style.setFont(font);

		style.setAlignment(CellStyle.ALIGN_CENTER); // 横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

		style.setBorderTop(CellStyle.BORDER_THIN); // 上细线
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下细线
		style.setBorderLeft(CellStyle.BORDER_THIN); // 左细线
		style.setBorderRight(CellStyle.BORDER_THIN); // 右细线

		return style;
	}

	// 文字样式
	public CellStyle text(Workbook wb) {
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 10);

		style.setFont(font);

		style.setAlignment(CellStyle.ALIGN_LEFT); // 横向居左
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER); // 纵向居中

		style.setBorderTop(CellStyle.BORDER_THIN); // 上细线
		style.setBorderBottom(CellStyle.BORDER_THIN); // 下细线
		style.setBorderLeft(CellStyle.BORDER_THIN); // 左细线
		style.setBorderRight(CellStyle.BORDER_THIN); // 右细线

		return style;
	}

	// =======================================使用模板打印========================================
	public String print() throws Exception {
		// 通用变量
		int rowNo = 0, cellNo = 1;
		Row nRow = null;
		Cell nCell = null;

		// 1.读取工作簿
		String path = ServletActionContext.getRequest().getRealPath("/") + "/make/xlsprint/tSHIPPINGORDER.xls";
		// 输入流
		InputStream is = new FileInputStream(path);
		Workbook wb = new HSSFWorkbook(is);

		// 2.读取工作表
		Sheet sheet = wb.getSheetAt(0);
		// ===========读取数据
		// 根据id查询委托单
		String[] ids = model.getId().split(", ");
		if (ids.length != 1) {
			return "alist";
		}
		ShippingOrder shippingOrder = shippingOrderService.get(ShippingOrder.class, model.getId());
		// 根据id查询装箱单
		PackingList packingList = packingListService.get(PackingList.class, shippingOrder.getId());

		nRow = sheet.getRow(3);
		nCell = nRow.getCell(0);
		nCell.setCellValue(shippingOrder.getShipper());

		nRow = sheet.getRow(8);
		nCell = nRow.getCell(1);
		nCell.setCellValue(shippingOrder.getConsignee());

		nRow = sheet.getRow(15);
		nCell = nRow.getCell(0);
		nCell.setCellValue(shippingOrder.getNotifyParty());

		if (packingList != null) {
			// 发票号
			nRow = sheet.getRow(19);
			nCell = nRow.createCell(0);
			nCell.setCellValue(packingList.getInvoiceNo());
		}
		// 日期
		nRow = sheet.getRow(19);
		nCell = nRow.createCell(3);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format = df.format(new Date());
		nCell.setCellValue(format);
		// 信用证号
		nRow = sheet.getRow(19);
		nCell = nRow.createCell(6);
		nCell.setCellValue(shippingOrder.getLcNo());

		// 船运港
		nRow = sheet.getRow(23);
		nCell = nRow.createCell(0);
		nCell.setCellValue(shippingOrder.getPortOfLoading());

		// 转船港
		nRow = sheet.getRow(23);
		nCell = nRow.createCell(3);
		nCell.setCellValue(shippingOrder.getPortOfTrans());

		// 卸货港
		nRow = sheet.getRow(23);
		nCell = nRow.createCell(6);
		nCell.setCellValue(shippingOrder.getPortOfDischarge());

		// 装期
		nRow = sheet.getRow(27);
		nCell = nRow.createCell(0);
		nCell.setCellValue(shippingOrder.getLoadingDate());

		// 效期
		nRow = sheet.getRow(27);
		nCell = nRow.createCell(2);
		nCell.setCellValue(shippingOrder.getLimitDate());

		// 分批
		nRow = sheet.getRow(27);
		nCell = nRow.createCell(3);
		nCell.setCellValue(shippingOrder.getIsBatch());

		// 转船
		nRow = sheet.getRow(27);
		nCell = nRow.createCell(5);
		nCell.setCellValue(shippingOrder.getIsTrans());

		// 份数
		nRow = sheet.getRow(27);
		nCell = nRow.createCell(7);
		nCell.setCellValue(shippingOrder.getCopyNum());

		// 运输要求
		nRow = sheet.getRow(37);
		nCell = nRow.createCell(1);
		nCell.setCellValue(shippingOrder.getSpecialCondition());

		// ======================================输出到客户端（下载）========================================
		DownloadUtil downUtil = new DownloadUtil();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();// 流 内存中的缓存区
		wb.write(baos);// 将excel表格中的内容输出到缓存
		baos.close();// 刷新缓存

		HttpServletResponse response = ServletActionContext.getResponse();// 得到response对象

		downUtil.download(baos, response, "委托单.xlsx");// 如果是中文，下载时可能会产生乱码，如何解决？

		return NONE;
	}

	// 多条件查询功能实现
	public String paramsSelect() throws Exception {
		String orderType = model.getOrderType();
		String shipper = model.getShipper();
		String portOfLoading = model.getPortOfLoading();

		String hql = "from ShippingOrder where 1 = 1 ";

		// 加入查询条件
		if (orderType != null && !"".equals(orderType.trim())) {
			hql += " and orderType like '%" + orderType + "%' ";
		}
		if (shipper != null && !"".equals(shipper.trim())) {
			hql += " and shipper like '%" + shipper + "%' ";
		}
		if (portOfLoading != null && !"".equals(portOfLoading.trim())) {
			hql += " and portOfLoading like '%" + portOfLoading + "%' ";
		}

		shippingOrderService.findPage(hql, page, ShippingOrder.class, null);
		page.setUrl("shippingOrderAction_paramsSelect");
		super.put("page", page);
		return "plist";

	}

}
