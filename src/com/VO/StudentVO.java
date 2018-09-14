package com.VO;

import java.io.Serializable;
import java.util.Date;

public class StudentVO implements Serializable {

	private static final long serialVersionUID = -1959893444921187866L;

	private long id;
	private String Student_Number;
	private String first_Name;
	private String last_Name;
	private String mobile;
	private String email;
	private String street;
	private String city;
	private String province;
	private String country;
	private String postal_Code;
	private Date dateofbirth;
	private Date dateofjoining;
	private String f_Num;
	private String father_Name;
	private String father_Mobile;
	private String father_Email;
	private String m_Num;
	private String mother_Name;
	private String mother_Mobile;
	private String mother_Email;
	private String rank;
	private AssignRankVO assignRankVO;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudent_Number() {
		return Student_Number;
	}
	public void setStudent_Number(String student_Number) {
		Student_Number = student_Number;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostal_Code() {
		return postal_Code;
	}
	public void setPostal_Code(String postal_Code) {
		this.postal_Code = postal_Code;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public Date getDateofjoining() {
		return dateofjoining;
	}
	public void setDateofjoining(Date dateofjoining) {
		this.dateofjoining = dateofjoining;
	}
	public String getF_Num() {
		return f_Num;
	}
	public void setF_Num(String f_Num) {
		this.f_Num = f_Num;
	}
	public String getFather_Name() {
		return father_Name;
	}
	public void setFather_Name(String father_Name) {
		this.father_Name = father_Name;
	}
	public String getFather_Mobile() {
		return father_Mobile;
	}
	public void setFather_Mobile(String father_Mobile) {
		this.father_Mobile = father_Mobile;
	}
	public String getFather_Email() {
		return father_Email;
	}
	public void setFather_Email(String father_Email) {
		this.father_Email = father_Email;
	}
	public String getM_Num() {
		return m_Num;
	}
	public void setM_Num(String m_Num) {
		this.m_Num = m_Num;
	}
	public String getMother_Name() {
		return mother_Name;
	}
	public void setMother_Name(String mother_Name) {
		this.mother_Name = mother_Name;
	}
	public String getMother_Mobile() {
		return mother_Mobile;
	}
	public void setMother_Mobile(String mother_Mobile) {
		this.mother_Mobile = mother_Mobile;
	}
	public String getMother_Email() {
		return mother_Email;
	}
	public void setMother_Email(String mother_Email) {
		this.mother_Email = mother_Email;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public AssignRankVO getAssignRankVO() {
		return assignRankVO;
	}
	public void setAssignRankVO(AssignRankVO assignRankVO) {
		this.assignRankVO = assignRankVO;
	}
	
}
