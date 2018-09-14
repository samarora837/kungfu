package com.VO;

import java.io.Serializable;

public class ClassSessionVO implements Serializable {

	private static final long serialVersionUID = 1005779639671505336L;

	private long id;
	private String level_Name;
	private String start_at;
	private String end_at;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevel_Name() {
		return level_Name;
	}
	public void setLevel_Name(String level_Name) {
		this.level_Name = level_Name;
	}
	public String getStart_at() {
		return start_at;
	}
	public void setStart_at(String start_at) {
		this.start_at = start_at;
	}
	public String getEnd_at() {
		return end_at;
	}
	public void setEnd_at(String end_at) {
		this.end_at = end_at;
	}
	
}
