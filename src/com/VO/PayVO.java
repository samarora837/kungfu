package com.VO;

import java.io.Serializable;
import java.util.Date;

public class PayVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6640708813621563146L;
	private long id;
	private String item_Name;
	private String Student_Number;
	private Date payment_Date;
	private String paid_Fees;
	private String comment;
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
	public String getStudent_Number() {
		return Student_Number;
	}
	public void setStudent_Number(String student_Number) {
		Student_Number = student_Number;
	}
	public Date getPayment_Date() {
		return payment_Date;
	}
	public void setPayment_Date(Date payment_Date) {
		this.payment_Date = payment_Date;
	}
	public String getPaid_Fees() {
		return paid_Fees;
	}
	public void setPaid_Fees(String paid_Fees) {
		this.paid_Fees = paid_Fees;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
