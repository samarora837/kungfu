package com.VO;

import java.io.Serializable;


public class FeesVO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1636532305898379780L;
	private long id;
	
	private String item_Name;  
	private int item_Fees;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem_Name() {
		return item_Name;
	}
	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}
	public int getItem_Fees() {
		return item_Fees;
	}
	public void setItem_Fees(int item_Fees) {
		this.item_Fees = item_Fees;
	}
	

}
