package com.xll.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *商品被购买的信息
 *@author xialonglei
 *@since 2017/8/7 
 */
@Entity
@Table(name = "goods_buy_info")
public class GoodsBuyInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/**被购买的商品名称*/
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Column
	private int number;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "pid" , referencedColumnName = "id")
	private Product product;
	
	@ManyToOne(targetEntity = Orders.class)
	@JoinColumn(name = "oid" , referencedColumnName = "id")
	private Orders order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
}
