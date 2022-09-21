package com.johncuevas.beltexam.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Username is required.")
	@Size(min = 3, max = 30, message = "Username must be between 3 and 30 characers.")
	private String userName;

	@NotEmpty(message = "Email is required.")
	@Email(message = "Please enter a valid email.")
	private String email;

	@NotEmpty(message = "Password is required.")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters.")
	private String password;

//	This password is not saved in the database
	@Transient
	@NotEmpty(message = "Confirm password is required.")
	@Size(min = 8, max = 128, message = "Confirm password must be between 8 and 128 characters.")
	private String confirm;

//	ONE TO MANY RELATIONSHIP FOR BABY NAMES

	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
	private List<Baby> babyNames;
	
//	MANY TO MANY 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "baby_id")
			)
	
	private List<Baby> likedNames;

//	CONSTRUCTOR

	public User() {
	}

	public User(String userName, String email, String password, String confirm) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}

//	GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Baby> getBabyNames() {
		return babyNames;
	}

	public void setBabyNames(List<Baby> babyNames) {
		this.babyNames = babyNames;
	}
	
	public List<Baby> getLikedNames() {
		return likedNames;
	}

	public void setLikedNames(List<Baby> likedNames) {
		this.likedNames = likedNames;
	}

}
