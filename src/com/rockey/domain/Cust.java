package com.rockey.domain;

import java.io.Serializable;
import java.sql.Date;

public class Cust implements Serializable {
	private int id;
	private String name;
	private String gender;
	private String birthday;
	private String cellphone;
	private String email;
	private String preference;
	private String type;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString(){
		return "id:"+id+" name: "+name+" gender: "+gender+" birthday: "+birthday
				+" cellphone: "+cellphone+" email: "+email+" preference: "+preference
				+" type: "+type+" description: "+description;
	}
}
