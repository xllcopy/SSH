package com.xll.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *@author xialonglei
 *@since  2016/6/12
 */
@Entity
@Table(name = "admin_account")
@JsonIgnoreProperties(value={"categories"})  //�����ѭ��
public class AdminAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=64 , name = "login_name")
	private String loginName;
	
	@Column(length=64)
	private String name;
	
	@Column(length=64)
	private String pwd;
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "adminAccount")
	private Set<Category> categories;
	public AdminAccount(){}
	
	public AdminAccount(long id){
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}
