package cn.itcast.jk.POITest;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

public class POITest {
	@Test
	public void f1() throws Exception{
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet();
		sheet.setColumnWidth(1, (int)Math.floor(((26.1*7+5)*1.0)/7*256));
		Row row = sheet.createRow(0);
		row.setHeightInPoints(100f);
		Cell cell = row.createCell(1);
		cell.setCellValue("黑马");
		CellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)56);
		font.setFontName("楷体");
		style.setFont(font);
		cell.setCellStyle(style);
		OutputStream os = new FileOutputStream("d://111.xls");
		wb.write(os);
		os.close();
		wb.close();
	}
}
