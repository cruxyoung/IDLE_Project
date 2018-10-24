package com.idle.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private Long id;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "item_id")
	private Item item;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "buyer_id")
	private User buyer;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "seller_id")
	private User seller;

	@Column(name = "refund_reason")
	private String refundReason;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "buyer_address_id")
	private Address buyerAddress;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "seller_address_id")
	private Address sellerAddress;

	@Column(name = "order_status")
	private Long orderStatus;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "last_edit_time")
	private Date lastEditTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public Address getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(Address buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public Address getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(Address sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public Long getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Long orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

}
