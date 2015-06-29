package com.asiantech.ducdh.lastproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "full_name")
	private String fullName;

	@NotNull
	@Column(name = "password")
	private String password;

	@Column(name = "email_user")
	private String emailUser;

	@Column(name = "address_user")
	private String addressUser;

	@Column(name = "path_img")
	private String pathImg;

	@Column(name = "role_user")
	private String roleUser;

	@Column(name = "status_user")
	private String statusUser;

	@Column(name = "rate_user")
	private int rateUser;

	@Column(name = "partici_bid")
	private int particiBid;

	@Column(name = "win_bid")
	private int winBid;

	@Column(name = "description")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public String getRoleUser() {
		return roleUser;
	}

	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	public String getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}

	public int getRateUser() {
		return rateUser;
	}

	public void setRateUser(int rateUser) {
		this.rateUser = rateUser;
	}

	public int getParticiBid() {
		return particiBid;
	}

	public void setParticiBid(int particiBid) {
		this.particiBid = particiBid;
	}

	public int getWinBid() {
		return winBid;
	}

	public void setWinBid(int winBid) {
		this.winBid = winBid;
	}

	public String getPathImg() {
		return pathImg;
	}

	public void setPathImg(String pathImg) {
		this.pathImg = pathImg;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String emailUser,
			String addressUser) {
		super();
		this.username = username;
		this.fullName = "Additional";
		this.password = password;
		this.emailUser = emailUser;
		this.addressUser = addressUser;
		this.pathImg = "user.jpg";
		this.roleUser = "ROLE_USER";
		this.statusUser = "ACTIVE";
		this.rateUser = 5;
		this.particiBid = 0;
		this.winBid = 0;
		this.description = "Nothing";
	}
	
	public String toString(){
		return "User name: " + username + " Full name: " + fullName + " email: " + emailUser + " address: " + addressUser + " rate: " + rateUser + " participate: " + particiBid;
	}

}
