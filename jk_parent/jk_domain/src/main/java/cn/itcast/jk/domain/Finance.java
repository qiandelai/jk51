package cn.itcast.jk.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @Description:	FinanceService接口
 * @Author:			rent
 * @Company:		http://java.itcast.cn
 * @CreateDate:		2017-6-9 18:08:32
 */

public class Finance extends BaseEntity {
			private static final long serialVersionUID = 1L;
			//和装箱单一对一
			private PackingList packingList;
			private String id;	  	
			private Date inputDate;			
			private String inputBy;			
			private Double state;			//0草稿 1已上报

	
	public PackingList getPackingList() {
				return packingList;
			}
	public void setPackingList(PackingList packingList) {
				this.packingList = packingList;
			}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public Date getInputDate() {
		return this.inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}	
	
	public String getInputBy() {
		return this.inputBy;
	}
	public void setInputBy(String inputBy) {
		this.inputBy = inputBy;
	}	
	
	public Double getState() {
		return this.state;
	}
	public void setState(Double state) {
		this.state = state;
	}	
	
	
	
}
