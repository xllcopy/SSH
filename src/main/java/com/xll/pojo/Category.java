package com.xll.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 *@author xialonglei
 *@since  2016/6/10
 */
@Entity
@Table
@JsonIgnoreProperties(value={"products"})
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** 类别名称 */
	@Column(length = 64)
	private String type;

	/** 是否为热点类别 */
	@Column(length = 1)
	private boolean hot;
	
	@ManyToOne
	@JoinColumn(name="account_id" , referencedColumnName="id")
	private AdminAccount adminAccount;
	@OneToMany(targetEntity=Product.class)
	@Cascade({CascadeType.SAVE_UPDATE})
	private Set<Product> products;

	public Category() {
	}

	public Category(String type, boolean hot , AdminAccount adminAccount) {
		this.type = type;
		this.hot = hot;
		this.adminAccount = adminAccount;
	}
	

	public Category(long id, String type, boolean hot, AdminAccount adminAccount) {
		super();
		this.id = id;
		this.type = type;
		this.hot = hot;
		this.adminAccount = adminAccount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	public AdminAccount getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(AdminAccount adminAccount) {
		this.adminAccount = adminAccount;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
