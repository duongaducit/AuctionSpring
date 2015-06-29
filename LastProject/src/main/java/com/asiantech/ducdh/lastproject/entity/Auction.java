package com.asiantech.ducdh.lastproject.entity;

import java.util.Date;

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
@Table(name = "Auction")
public class Auction {

	@Id
	@NotNull
	@GeneratedValue
	@Column(name = "id_auction")
	private int idAuction;
	
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user_Bid;
	
	@Column(name = "time_Bid")
	private String time_Bid;
	
	@Column(name = "money_Bid")
	private int money_Bid;
	
	@Column(name = "status_auction")
	private String statusAuction;

	public int getIdAuction() {
		return idAuction;
	}

	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser_Bid() {
		return user_Bid;
	}

	public void setUser_Bid(User user_Bid) {
		this.user_Bid = user_Bid;
	}

	public String getTime_Bid() {
		return time_Bid;
	}

	public void setTime_Bid(String time_Bid) {
		this.time_Bid = time_Bid;
	}

	public int getMoney_Bid() {
		return money_Bid;
	}

	public void setMoney_Bid(int money_Bid) {
		this.money_Bid = money_Bid;
	}

	public String getStatusAuction() {
		return statusAuction;
	}

	public void setStatusAuction(String statusAuction) {
		this.statusAuction = statusAuction;
	}

	public Auction(int idAuction, Product product, User user_Bid,
			String time_Bid, int money_Bid, String statusAuction) {
		super();
		this.idAuction = idAuction;
		this.product = product;
		this.user_Bid = user_Bid;
		this.time_Bid = time_Bid;
		this.money_Bid = money_Bid;
		this.statusAuction = statusAuction;
	}

	public Auction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
