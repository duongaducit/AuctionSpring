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
@Table(name = "Notify")
public class Notify {
	
	@Id
	@NotNull
	@GeneratedValue
	@Column(name = "id_notify")
	private int idNotify;
	
	@ManyToOne
	@JoinColumn(name = "user_notify")
	private User userNotify;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "time_notify")
	private String timeNotify;

	public int getIdNotify() {
		return idNotify;
	}

	public void setIdNotify(int idNotify) {
		this.idNotify = idNotify;
	}

	public User getUserNotify() {
		return userNotify;
	}

	public void setUserNotify(User userNotify) {
		this.userNotify = userNotify;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimeNotify() {
		return timeNotify;
	}

	public void setTimeNotify(String timeNotify) {
		this.timeNotify = timeNotify;
	}

	public Notify(User userNotify, String content, String timeNotify) {
		super();
		this.userNotify = userNotify;
		this.content = content;
		this.timeNotify = timeNotify;
	}

	public Notify() {
		super();
		// TODO Auto-generated constructor stub
	}

}
