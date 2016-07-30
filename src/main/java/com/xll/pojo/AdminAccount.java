package com.xll.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *@author xialonglei
 *@since  2016/6/12
 */
@Entity
@Table(name = "admin_account")
@JsonIgnoreProperties(value={"categories"})  //½â¾öËÀÑ­»·
public class AdminAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=64 , name = "login_name")
	private String loginName;
	
	@Column(length=64)
	private String name;
	
	@Column(length=64)
	private String pwd;
	
	@OneToMany(targetEntity=Category.class)
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<Category> categories;
	public AdminAccount(){}
	
	public AdminAccount(long id){
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
