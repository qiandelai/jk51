package cn.itcast.jk.action.stat;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.itcast.jk.action.BaseAction;
import cn.itcast.jk.service.SqlService;
import cn.itcast.jk.utils.file.FileUtil;

public class StatChartAction extends BaseAction{
	private SqlService sqlService;
	public void setSqlService(SqlService sqlService) {
		this.sqlService = sqlService;
	}
	
	
	/**
	 * 厂家的销售排名图:旧版
	 * @return
	 * @throws Exception
	 */
	public String factorysaleBar() throws Exception {
		//1.查询
		String sql="select factory_name , sum(amount) samount from contract_product_c "
				+ "group by factory_name order by samount desc";
		List<String> list = sqlService.executeSQL(sql);
	
		//2.把最后n项合同成其他项
		list = deleteLastItems(list,6);
		
		//3.组织符合要求的xml数据
		String content = genPieDataSet(list);
		
		//4.将字符串写入data.xml文件中
		writeXml("stat\\chart\\factorysale\\data.xml",content);
		
		return "factorysaleBar";
	}
	
	
	/**
	 * 厂家的销售排名图:新版
	 * @return
	 * @throws Exception
	 */
	public String factorysale() throws Exception {
		//1.查询
		String sql="select factory_name , sum(amount) samount from contract_product_c "
				+ "group by factory_name order by samount desc";
		List<String> list = sqlService.executeSQL(sql);
		
		//3.组织符合要求的json数据
		String[]color = {"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215",
				"#0D8ECF","#0D52D1","#2A0CD0","#8A0CCF","#CD0D74","#754DEB","#DDDDDD","#999999","#333333","#000000"};
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int j=0;
			for (int i = 0; i < list.size(); i++) {
				sb.append("{\"country\": \"").append(list.get(i++));
				sb.append("\",\"visits\":").append(list.get(i));
				
				
				//相同排行的颜色一样
				if (i<list.size()-2) {
					if (list.get(i).equals(list.get(i+2))) {
						sb.append(",\"color\": \""+color[j]+"\"}");
					}else{
						sb.append(",\"color\": \""+color[j++]+"\"}");
					}
				}else{
					sb.append(",\"color\": \""+color[j++]+"\"}");
				}
				
				if (j>=color.length) {
					j=0;
				}
				if (i!=list.size()-1) {
					sb.append(",");
				}
			}
		sb.append("]");
		String json = sb.toString();
		super.put("json",json);
		return "factorysale";
		
	}
	/*
	 * IP登录前十的排序
	 */
	public String ipAccount() throws Exception {
		//1.查询
		String sql="select * from "
				+ "(select ip_address ip ,count(*) sum from login_log_p group by ip_address order by sum desc)"
				+ " where rownum<9";
		List<String> list = sqlService.executeSQL(sql);
		//3.组织符合要求的json数据
		String[]color = {"#FF0F00","#FF6600","#FF9E01","#FCD202","#F8FF01","#B0DE09","#04D215",
				"#0D8ECF","#0D52D1","#2A0CD0","#8A0CCF","#CD0D74","#754DEB","#DDDDDD","#999999","#333333","#000000"};
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int j=0;
		for (int i = 0; i < list.size(); i++) {
			sb.append("{\"country\": \"").append(list.get(i++));
			sb.append("\",\"visits\":").append(list.get(i));
			//相同排行的颜色一样
			if (i<list.size()-2) {
				if (list.get(i).equals(list.get(i+2))) {
					sb.append(",\"color\": \""+color[j]+"\"}");
				}else{
					sb.append(",\"color\": \""+color[j++]+"\"}");
				}
			}else{
				sb.append(",\"color\": \""+color[j++]+"\"}");
			}
			if (j>=color.length) {
				j=0;
			}
			if (i!=list.size()-1) {
				sb.append(",");
			}
		}
		sb.append("]");
		String json = sb.toString();
		System.out.println(json);
		super.put("json",json);
		return "ipAccount";
	}
	/*
	 * 价格排名前十的商品排序
	 */
	public String productPrice() throws Exception {
		//1.查询
		String sql="select product_no,price from product_c order by price desc";
		List<String> list = sqlService.executeSQL(sql);
		List<String> listName=new ArrayList<String>();
		List<String> listData =new ArrayList<String>();
		Integer  a = list.size();
		for (int i = 0; i < list.size(); i++) {
			if (i%2==0) {
				listName.add(list.get(i));
			}else{
				listData.add(list.get(i));
				
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("['");
		for (int i = 0; i < listName.size(); i++) {
			sb.append(listName.get(i)).append("','");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("]");
		super.put("listName",sb.toString());
		super.put("listData",listData.toString());
		return "productPriceHishChart";
	}
	
	
/**
 * 产品的销售排名图:前15名
 * @return
 * @throws Exception
 */
	public String productsale() throws Exception {
		//1.查询
		String sql="select product_no,samount from (select product_no,sum(amount) samount  from contract_product_c group by product_no order by samount desc)where rownum<16";
		List<String> list = sqlService.executeSQL(sql);
	
		//2.组织符合要求的xml数据
		String content = genBarDataSet2(list);
		
		//3.将字符串写入data.xml文件中
		writeXml("stat\\chart\\productsale\\data.xml",content);
		
		return "productsale";
	}
	/**
	 * 在线人数统计
	 * @return
	 * @throws Exception
	 */
	public String onlineinfo() throws Exception {
		//1.查询
		/*String sql="select a.a1,nvl(b.count,0) from "
				+ "(select * from online_info_t) a left join "
				+ "(select to_char(login_time,'HH24') a1,count(*) count from login_log_p "
				+ "group by  to_char(login_time,'HH24') order by a1) b on a.a1=b.a1 order by a.a1";*/
	
		String sql="select a1,(select count(*) from login_log_p where to_char(login_time,'HH24') = a1) num from online_info_t";
		List<String> list = sqlService.executeSQL(sql);
	
		//2.组织符合要求的xml数据
		String content = genBarDataSet(list);
		
		//3.将字符串写入data.xml文件中
		writeXml("stat\\chart\\onlineinfo\\data.xml",content);
		
		return "onlineinfo";
	}
	
	
	//把最后n项合同成其他项
	private List<String> deleteLastItems(List<String> list,Integer n) {
		Double data = 0d;
		for (int i = list.size()-(2*n-1); i <list.size(); i++) {
			data += Double.parseDouble(list.get(i++));
		}
		for (int i = list.size()-2*n; i <list.size(); i++) {
			list.remove(i--);
		}
		list.add("其他");
		list.add(data+"");
		return list;
	}
	
	//生成饼图的设计图
	private String genBarDataSet(List<String> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<chart><series>");
		int j =0;
		for (int i = 0; i < list.size(); i++) {
			sb.append("<value xid=\""+(j++)+"\">"+list.get(i++)+"</value>");
		}
		sb.append("</series><graphs><graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
		j=0;
		for (int i = 0; i < list.size(); i++) {
			sb.append("<value xid=\""+(j++)+"\" description=\"\" url=\"\">"+list.get(++i)+"</value>");
		}
		sb.append("</graph></graphs>");
		sb.append("</chart>");
		return sb.toString();
	}
	private String genBarDataSet2(List<String> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<chart><series>");
		int j =0;
		for (int i = 0; i < list.size(); i++) {
			sb.append("<value xid=\""+(j++)+"\">"+list.get(i++)+"</value>");
		}
		sb.append("</series><graphs><graph gid=\"30\" color=\"#FFCC00\" gradient_fill_colors=\"#111111, #1A897C\">");
		j=0;
		for (int i = 0; i < list.size(); i++) {
			sb.append("<value xid=\""+(j++)+"\" description=\"\" url=\"\">"+list.get(++i)+"</value>");
		}
		sb.append("</graph></graphs>");
		/*
		 *  <labels>         
			    <label lid="0">
			      <x>0</x>                   
			      <y>20</y>                  
			      <rotate></rotate>          
			      <width></width>            
			      <align>center</align>        
			      <text_color></text_color>  
			      <text_size></text_size>    
			      <text>                     
			        <![CDATA[<b>陕西公司现有班组2388个, 班组长2890名, 班组员工24236名</b>]]>
			      </text>        
			    </label>
			  </labels>	
		 * */
		sb.append("<labels>");
		sb.append("<label lid=\"0\">");
		sb.append("<x>0</x>");
		sb.append("<y>20</y>");
		sb.append("<align>center</align>");
		sb.append("<text_color>#FF0000</text_color>");
		sb.append("<text_size>20</text_size>");
		sb.append("<text>");
		sb.append("<![CDATA[<b>产品的销售排名--前15名</b>]]>");
		sb.append("</text>");
		sb.append("</label>");
		sb.append("</labels>");
		sb.append("</chart>");
		return sb.toString();
	}
	//生成饼图的设计图
	private String genPieDataSet(List<String> list) {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<pie>");
		for (int i = 0; i < list.size(); i++) {
			sb.append("<slice title=\""+list.get(i)+"\" pull_out=\"true\">"+list.get(++i)+"</slice>");
		}
		sb.append("</pie>");
		return sb.toString();
	}
	//给Data.Xml文件写入数据
	private void writeXml( String fileName ,String sb) throws FileNotFoundException {
		FileUtil fileUtil = new FileUtil();
		String sPath = ServletActionContext.getServletContext().getRealPath("/");
		fileUtil.createTxt(sPath, fileName, sb, "utf-8");
	}
	
	
}
