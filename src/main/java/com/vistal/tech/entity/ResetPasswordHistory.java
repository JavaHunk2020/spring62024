package com.vistal.tech.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reset_password_history")
public class ResetPasswordHistory {
	

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int rphid;
	private String code;
	private Timestamp createDate;
	private Timestamp linkexpOn;
	private String notes;
	@Column(columnDefinition = "varchar(20) default 'yes'")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "f_username", nullable = false)
	private Signup signup;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getRphid() {
		return rphid;
	}

	public void setRphid(int rphid) {
		this.rphid = rphid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLinkexpOn() {
		return linkexpOn;
	}

	public void setLinkexpOn(Timestamp linkexpOn) {
		this.linkexpOn = linkexpOn;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Signup getSignup() {
		return signup;
	}

	public void setSignup(Signup signup) {
		this.signup = signup;
	}

}
