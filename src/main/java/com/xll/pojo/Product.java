package com.xll.pojo;

import java.text.ParseException;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 *商品实体类
 *其中注解@Cache是为Product实体类启用二级缓存,缓存策略是READ_WRITE，允许更改数据
 *@author xialonglei
 */
@Entity
@Table
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties(value={"goodsBuyInfos"})
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length = 255 , name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_pic")
	private String productPicturePath;
	
	@Column(name = "product_sim_desc")
	private String productSimDesc;
	
	@Column(name = "product_de_desc")
	private String productDeDesc;
	
	@Column(name = "product_produce_date")
	private String productProduceDate;
	
	/* 是否为推荐商品,推荐商品才有可能显示在商城首页 */
	@Column(name = "product_display")
	private boolean productDisplay;
	
	@Column(name = "product_is_valid")
	private boolean productIsValid;
	
	@ManyToOne
	@JoinColumn(name="category_id" , referencedColumnName="id")
	private Category category;
	
	@OneToMany(targetEntity = GoodsBuyInfo.class)
	@Cascade({CascadeType.ALL})
	private Set<GoodsBuyInfo> goodsBuyInfos; 
	
	public Product(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductPicturePath() {
		return productPicturePath;
	}

	public void setProductPicturePath(String productPicturePath) {
		this.productPicturePath = productPicturePath;
	}

	public String getProductSimDesc() {
		return productSimDesc;
	}

	public void setProductRemark(String productSimDesc) {
		this.productSimDesc = productSimDesc;
	}

	public String getproductDeDesc() {
		return productDeDesc;
	}

	public void setProductDeRemark(String productDeDesc) {
		this.productDeDesc = productDeDesc;
	}

	public String getProductProduceDate() {
		return productProduceDate;
	}

	public void setProductProduceDate(String productProduceDate) throws ParseException {
		this.productProduceDate = productProduceDate;
	}

	public boolean isProductDisplay() {
		return productDisplay;
	}

	public void setProductDisplay(boolean productDisplay) {
		this.productDisplay = productDisplay;
	}

	public boolean isProductIsValid() {
		return productIsValid;
	}

	public void setProductIsValid(boolean productIsValid) {
		this.productIsValid = productIsValid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<GoodsBuyInfo> getGoodsBuyInfos() {
		return goodsBuyInfos;
	}

	public void setGoodsBuyInfos(Set<GoodsBuyInfo> goodsBuyInfos) {
		this.goodsBuyInfos = goodsBuyInfos;
	}
}
