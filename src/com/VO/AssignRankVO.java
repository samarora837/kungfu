package com.VO;

import java.io.Serializable;
import java.util.Date;

public class AssignRankVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer assign_rank_id;
	private Date assign_rank_date;
	private String student_NUM ;
	private String rankName ;
	
	
	public Integer getAssign_rank_id() {
		return assign_rank_id;
	}
	public void setAssign_rank_id(Integer assign_rank_id) {
		this.assign_rank_id = assign_rank_id;
	}
	public Date getAssign_rank_date() {
		return assign_rank_date;
	}
	public void setAssign_rank_date(Date assign_rank_date) {
		this.assign_rank_date = assign_rank_date;
	}
	public String getStudent_NUM() {
		return student_NUM;
	}
	public void setStudent_NUM(String student_NUM) {
		this.student_NUM = student_NUM;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	
	
}
