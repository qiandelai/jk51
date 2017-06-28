package cn.itcast.jk.action.cargo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.Export;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.service.ExportService;
import cn.itcast.jk.service.PackingListService;
import cn.itcast.jk.utils.Page;
import cn.itcast.jk.utils.SetDataUtils;

/**
 * @Description: PackingListService接口
 * @Author: rent
 * @Company: http://java.itcast.cn
 * @CreateDate: 2017-6-8 16:33:24
 */

public class PackingListAction extends BaseAction implements ModelDriven<PackingList> {
	// 注入service
	private PackingListService packingListService;

	public void setPackingListService(PackingListService packingListService) {
		this.packingListService = packingListService;
	}

	private ExportService exportService;

	public void setExportService(ExportService exportService) {
		this.exportService = exportService;
	}

	// model驱动
	private PackingList model = new PackingList();

	public PackingList getModel() {
		return this.model;
	}

	// 作为属性驱动，接收并封装页面参数
	private Page page = new Page(); // 封装页面的参数，主要当前页参数

	public void setPage(Page page) {
		this.page = page;
	}

	// 列表展示
	public String list() {
		String hql = "from PackingList o"; // 查询所有内容
		// 给页面提供分页数据
		page.setUrl("packingListAction_list"); // 配置分页按钮的转向链接
		page = packingListService.findPage(hql, page, PackingList.class, null);
		super.push(page);
		return "plist"; // page list
	}

	// 转向新增页面
	public String tocreate() {
		// 查询所有已上报的出口报运
		page = exportService.findPage("from Export where state = 2", page, Export.class, null);
		page.setUrl("packingListAction_tocreate");
		super.push(page);
		return "pcreate";
	}

	// 新增保存
	public String insert() {
		packingListService.saveOrUpdate(model);

		return "alist"; // 返回列表，重定向action_list
	}

	// 转向修改页面
	public String toupdate() {
		// 准备数据
		PackingList obj = packingListService.get(PackingList.class, model.getId());
		super.push(obj);
		List<Export> list = exportService.find("from Export where state = 2", Export.class, null);
		String ids = obj.getExportIds();
		if (ids != null) {
			String[] exportIds = ids.split(", ");
			for (String exportId : exportIds) {
				Export export = exportService.get(Export.class, exportId);
				list.add(export);
			}
		}
		super.put("list", list);
		;
		return "pupdate";
	}

	// 修改保存
	public String update() throws Exception {
		PackingList packingList = packingListService.get(PackingList.class, model.getId());
		// 将修改前的出口报运状态置为已报运
		String[] exportIds = packingList.getExportIds().split(", ");
		for (String exportid : exportIds) {
			Export export = exportService.get(Export.class, exportid);
			export.setState(2);
			exportService.saveOrUpdate(export);
		}
		// 设置修改的属性，根据业务去掉自动生成多余的属性
		packingList.setSeller(model.getSeller());
		packingList.setBuyer(model.getBuyer());
		packingList.setInvoiceNo(model.getInvoiceNo());
		packingList.setInvoiceDate(model.getInvoiceDate());
		packingList.setMarks(model.getMarks());
		packingList.setDescriptions(model.getDescriptions());
		packingList.setExportIds(model.getExportIds());

		packingListService.saveOrUpdate(packingList);

		return "alist";
	}

	// 删除一条
	public String deleteById() {
		packingListService.deleteById(PackingList.class, model.getId());

		return "alist";
	}

	// 删除多条
	public String delete() {
		packingListService.delete(PackingList.class, model.getId().split(", "));

		return "alist";
	}

	// 查看
	public String toview() {
		PackingList obj = packingListService.get(PackingList.class, model.getId());
		super.push(obj);
		String exportIds = obj.getExportIds();
		List<Export> list = new ArrayList<Export>();
		if (exportIds != null) {
			String[] ids = exportIds.split(", ");
			for (String id : ids) {
				Export export = exportService.get(Export.class, id);
				list.add(export);
			}
		}
		super.put("list", list);
		return "pview"; // 转向查看页面
	}

	// 多条件查询功能实现
	public String paramsSelect() throws Exception {
		String buyer = model.getBuyer();
		String invoiceNo = model.getInvoiceNo();
		Date invoiceDate = model.getInvoiceDate();

		String hql = "from PackingList where 1 = 1 ";

		// 加入查询条件
		if (buyer != null && !"".equals(buyer.trim())) {
			hql += " and buyer like '%" + buyer + "%' ";
		}
		if (invoiceNo != null && !"".equals(invoiceNo.trim())) {
			hql += " and invoiceNo like '%" + invoiceNo + "%' ";
		}
		if (invoiceDate != null && !"".equals(invoiceDate.toString().trim())) {
			// 转换时间格式
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = dateFormat.format(invoiceDate);
			hql += " and to_char(invoiceDate,'yyyy-MM-dd') = '" + dateStr + "' ";
		}

		packingListService.findPage(hql, page, PackingList.class, null);
		page.setUrl("packingListAction_paramsSelect");
		super.push(page);
		return "plist";

	}
}
