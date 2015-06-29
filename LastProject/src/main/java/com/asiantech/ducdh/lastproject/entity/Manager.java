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
@Table(name = "ManagerUser")
public class Manager {
	
	@Id
	@NotNull
	@GeneratedValue
	@Column(name = "id_manager")
	private int idManager;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name = "status_user")
	private String statusUser;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "lock_start")
	private Date lockStart;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "lock_End")
	private Date lockEnd;

	public int getIdManager() {
		return idManager;
	}

	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatusUser() {
		return statusUser;
	}

	public void setStatusUser(String statusUser) {
		this.statusUser = statusUser;
	}

	public Date getLockStart() {
		return lockStart;
	}

	public void setLockStart(Date lockStart) {
		this.lockStart = lockStart;
	}

	public Date getLockEnd() {
		return lockEnd;
	}

	public void setLock_End(Date lockEnd) {
		this.lockEnd = lockEnd;
	}

	public Manager(User user, String statusUser,
			Date lockStart, Date lockEnd) {
		super();
		this.user = user;
		this.statusUser = statusUser;
		this.lockStart = lockStart;
		this.lockEnd = lockEnd;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

}
