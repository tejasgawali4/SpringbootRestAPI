package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	Integer id;
	@Column(name = "first_name", length = 50)
	String firstname;
	@Column(name = "last_name", length = 50)
	String lastname;
	@Column(name = "city", length = 50)
	String city;
	
	public Users() {
	}

	public Users(Integer id) {
		this.id = id;
	}

	public Users(String firstname, String lastname, String city) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.city = city;
}
	

	public Users(Integer id, String firstname, String lastname, String city) {
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.city = city;
}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id: ").append(this.id).append(", firstname: ").append(this.firstname).append(", lastname: ")
				.append(this.lastname).append(", city: ").append(this.city);
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		Users toCompare = (Users) obj;
		return id.equals(toCompare.id);
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
	
}
