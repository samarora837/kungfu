package com.VO;

import java.io.Serializable;
import java.util.Date;

public class AttendanceVO implements Serializable  {

	private static final long serialVersionUID = -723176261986335422L;

	private long id;
	private Date attendance_date;
	private String student_Num;
	private String csvo;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getAttendance_date() {
		return attendance_date;
	}
	public void setAttendance_date(Date attendance_date) {
		this.attendance_date = attendance_date;
	}
	public String getStudent_Num() {
		return student_Num;
	}
	public void setStudent_Num(String student_Num) {
		this.student_Num = student_Num;
	}
	public String getCsvo() {
		return csvo;
	}
	public void setCsvo(String csvo) {
		this.csvo = csvo;
	}

	
}
