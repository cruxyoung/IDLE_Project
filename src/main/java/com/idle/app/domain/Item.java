package com.idle.app.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Item")
public class Item implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long id;

	
	@Column(name="item_name")
	private String name;

	@OneToMany(mappedBy="item",cascade=CascadeType.ALL)
	List<Comment> comments;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL)
	List<ViewRecord> viewRecords;
	

	@OneToMany(mappedBy="item",cascade=CascadeType.ALL)
	 List<Order> order;

	
	@Column(name="item_photo")
	private String photo;

	@Column(name="item_quantity")
	private Long quantity;

	@Column(name="item_description")
	private String description;


	


	@Column(name="item_price")
	private Double price;

	@Column(name="item_priority")
	private Integer priority;
	// wait a second

	@ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="owner_id")
    private User owner;

	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="catetory_id")
	private Category category;

	@Column(name="create_time")
    private Date createTime;
	
	@Column(name="last_edit_time")
    private Date lastEditTime;
	
	@Column(name="isbanner")
	private String isbanner;
	
	@Column(name="visit_time")
	private Long visitTime;
	

	public Long getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(Long visitTime) {
		this.visitTime = visitTime;
	}

	public String getIsbanner() {
		return isbanner;
	}

	public void setIsbanner(String isbanner) {
		this.isbanner = isbanner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}





	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", comments=" + comments + ", viewRecords=" + viewRecords
				+ ", order=" + order + ", photo=" + photo + ", quantity=" + quantity + ", description=" + description
				+ ", price=" + price + ", priority=" + priority + ", owner=" + owner + ", category=" + category
				+ ", createTime=" + createTime + ", lastEditTime=" + lastEditTime + ", isbanner=" + isbanner
				+ ", visitTime=" + visitTime + "]";
	}
	
	
}
