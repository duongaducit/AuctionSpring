package com.asiantech.ducdh.lastproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "id_product")
	private int idProduct;
	
	@Column(name = "name_product")
	private String nameProduct;
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "description_product")
	private String descriptionProduct;
	
	@Column(name = "path_img")
	private String pathImg;
	
	@Column(name = "status_product")
	private String statusProduct;
	
	@Column(name = "start_bid")
	private String startBid;
	
	@Column(name = "end_bid")
	private String endBid;
	
	@Column(name = "inc_bid")
	private int incBid;
	
	@Column(name = "min_bid")
	private int minBid;

	
	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getDescriptionProduct() {
		return descriptionProduct;
	}

	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}

	public String getStatusProduct() {
		return statusProduct;
	}

	public void setStatusProduct(String statusProduct) {
		this.statusProduct = statusProduct;
	}

	public String getStartBid() {
		return startBid;
	}

	public void setStartBid(String startBid) {
		this.startBid = startBid;
	}

	public String getEndBid() {
		return endBid;
	}

	public void setEndBid(String endBid) {
		this.endBid = endBid;
	}

	public int getIncBid() {
		return incBid;
	}

	public void setIncBid(int incBid) {
		this.incBid = incBid;
	}

	public int getMinBid() {
		return minBid;
	}

	public void setMinBid(int minBid) {
		this.minBid = minBid;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public Product(String nameProduct ,Category category, User user,
			String descriptionProduct, String pathImg, String statusProduct, String startBid,
			String endBid, int incBid, int minBid) {
		super();
		this.nameProduct = nameProduct;
		this.category = category;
		this.user = user;
		this.descriptionProduct = descriptionProduct;
		this.pathImg = pathImg;
		this.statusProduct = statusProduct;
		this.startBid = startBid;
		this.endBid = endBid;
		this.incBid = incBid;
		this.minBid = minBid;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

}
