package com.xll.pojo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@JsonIgnoreProperties(value={"goodsBuyInfos"})
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "receiver_name")
	private String receiverName;
	
	@Column(name = "receiver_phone")
	private String receiverPhone;
	
	/**配送信息*/
	@Column
	private String remark;
	
	@Column(name = "place_order_date")
	private Date placeOrderDate;
	
	/**订单总金额*/
	@Column
	private double total;
	
	/**邮编*/
	@Column(name = "post_code")
	private String postCode;
	
	/**收件人地址*/
	@Column(name = "receiver_address")
	private String receiverAddress;
	
	/**用户id*/
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name="user_id" , referencedColumnName="id")
	private User uid;
	
	/**订单状态id*/
	@OneToOne(targetEntity = OrderStatus.class)
	@JoinColumn(name="order_status_id" , referencedColumnName="id")
	private OrderStatus sid;
	
	@OneToMany(targetEntity = GoodsBuyInfo.class)
	@Cascade({CascadeType.ALL})
	private Set<GoodsBuyInfo> goodsBuyInfos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getPlaceOrderDate() {
		return placeOrderDate;
	}

	public void setPlaceOrderDate(Date placeOrderDate) {
		this.placeOrderDate = placeOrderDate;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public OrderStatus getSid() {
		return sid;
	}

	public void setSid(OrderStatus sid) {
		this.sid = sid;
	}

	public Set<GoodsBuyInfo> getGoodsBuyInfos() {
		return goodsBuyInfos;
	}

	public void setGoodsBuyInfos(Set<GoodsBuyInfo> goodsBuyInfos) {
		this.goodsBuyInfos = goodsBuyInfos;
	}
}
