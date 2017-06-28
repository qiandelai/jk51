package cn.itcast.jk.action.cargo;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.service.ContractProductService;
import cn.itcast.jk.utils.DownloadUtil;
import cn.itcast.jk.utils.UtilFuns;

public class OutProductAction extends BaseAction {
	private String inputDate;
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	private ContractProductService contractProductService;
	public void setContractProductService(ContractProductService contractProductService) {
		this.contractProductService = contractProductService;
	}
	/**
	 * 到出货表页面
	 * @return
	 * @throws Exception
	 */
	public String toedit() throws Exception {
		return "toedit";
	}
	/**
	 * 打印出货表,读模板方法
	 * @return
	 * @throws Exception
	 */
	public String print() throws Exception {
		InputStream is = new FileInputStream(ServletActionContext.getServletContext().getRealPath("/make/xlsprint/tOUTPRODUCT.xls"));
		Workbook wb = new HSSFWorkbook(is);
		Sheet sheet = wb.getSheetAt(0);
		int rowNo = 0;
		int cellNo = 1;
		Row row = null;
		Cell cell = null;
		//大标题
		row = sheet.getRow(rowNo++);
		cell = row.getCell(cellNo);
		String title = inputDate.replace("-0", "-").replace("-", "年")+"月份出货表";
		cell.setCellValue(title);
		//小标题
		rowNo++;
		//内容
		CellStyle[] styles = new CellStyle[8];
		row = sheet.getRow(rowNo);
		for (int i = 0; i < styles.length; i++) {
			cell = row.getCell(cellNo++);
			styles[i] = cell.getCellStyle();
		}
		String hql = "from ContractProduct where to_char(contract.shipTime,'yyyy-MM')=?";
		List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, new Object[]{inputDate});
		for (ContractProduct contractProduct : list) {
			cellNo = 1;
			row = sheet.createRow(rowNo++);
			row.setHeightInPoints(24f);
			String[] contents = {contractProduct.getContract().getCustomName(),contractProduct.getContract().getContractNo(),
					contractProduct.getProductNo(),contractProduct.getCnumber().toString(),contractProduct.getFactoryName(),
					UtilFuns.dateTimeFormat(contractProduct.getContract().getDeliveryPeriod()),
					UtilFuns.dateTimeFormat(contractProduct.getContract().getShipTime()),
					contractProduct.getContract().getTradeTerms()};
			for (int i = 0; i < contents.length; i++) {
				cell = row.createCell(cellNo++);
				cell.setCellStyle(styles[i]);
				cell.setCellValue(contents[i]);
			}
		}
		//下载
		DownloadUtil downloadUtil = new DownloadUtil();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		wb.write(byteArrayOutputStream);
		downloadUtil.download(byteArrayOutputStream, ServletActionContext.getResponse(), title+".xls");
		return NONE;
	}
	/**
	 * 打印出货表,原始方法
	 * @return
	 * @throws Exception
	 */
	public String print1() throws Exception {
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		int rowNo = 0;
		int cellNo = 1;
		Row row = null;
		Cell cell = null;
		//大标题
		row = sheet.createRow(rowNo++);
		row.setHeightInPoints(36f);
		// 合并单元格
		sheet.addMergedRegion(new CellRangeAddress(0,0,1,8));
		cell = row.createCell(cellNo);
		String title = inputDate.replace("-0", "-").replace("-", "年")+"月份出货表";
		cell.setCellValue(title);
		cell.setCellStyle(this.bigTitle(wb));
		//小标题
		sheet.setColumnWidth(0, (int)Math.floor((10*7+5)*1.0/7*256));
		sheet.setColumnWidth(1, (int)Math.floor((26*7+5)*1.0/7*256));
		sheet.setColumnWidth(2, (int)Math.floor((15*7+5)*1.0/7*256));
		sheet.setColumnWidth(3, (int)Math.floor((26*7+5)*1.0/7*256));
		sheet.setColumnWidth(4, (int)Math.floor((15*7+5)*1.0/7*256));
		sheet.setColumnWidth(5, (int)Math.floor((20*7+5)*1.0/7*256));
		sheet.setColumnWidth(6, (int)Math.floor((20*7+5)*1.0/7*256));
		sheet.setColumnWidth(7, (int)Math.floor((15*7+5)*1.0/7*256));
		sheet.setColumnWidth(8, (int)Math.floor((15*7+5)*1.0/7*256));
		row = sheet.createRow(rowNo++);
		row.setHeightInPoints(27f);
		String [] titles = {"客户","订单号","货号","数量","工厂","工厂交期","船期","贸易条款"};
		for (String t : titles) {
			cell = row.createCell(cellNo++);
			cell.setCellValue(t);
			cell.setCellStyle(this.title(wb));
		}
		//内容
		String hql = "from ContractProduct where to_char(contract.shipTime,'yyyy-MM')=?";
		List<ContractProduct> list = contractProductService.find(hql, ContractProduct.class, new Object[]{inputDate});
		for (ContractProduct contractProduct : list) {
			cellNo = 1;
			row = sheet.createRow(rowNo++);
			row.setHeightInPoints(24f);
			String[] contents = {contractProduct.getContract().getCustomName(),contractProduct.getContract().getContractNo(),
					contractProduct.getProductNo(),contractProduct.getCnumber().toString(),contractProduct.getFactoryName(),
					UtilFuns.dateTimeFormat(contractProduct.getContract().getDeliveryPeriod()),
					UtilFuns.dateTimeFormat(contractProduct.getContract().getShipTime()),
					contractProduct.getContract().getTradeTerms()};
			for (String content : contents) {
				cell = row.createCell(cellNo++);
				cell.setCellStyle(this.text(wb));
				cell.setCellValue(content);
			}
		}
		//下载
		DownloadUtil downloadUtil = new DownloadUtil();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		wb.write(byteArrayOutputStream);
		downloadUtil.download(byteArrayOutputStream, ServletActionContext.getResponse(), title+".xls");
		return NONE;
	}
	//大标题的样式
	public CellStyle bigTitle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short)16);
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		return style;
	}
	//小标题的样式
	public CellStyle title(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short)12);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
	
	//文字样式
	public CellStyle text(Workbook wb){
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short)10);
		
		style.setFont(font);
		
		style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中
		
		style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
		style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
		style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
		style.setBorderRight(CellStyle.BORDER_THIN);				//右细线
		
		return style;
	}
}
