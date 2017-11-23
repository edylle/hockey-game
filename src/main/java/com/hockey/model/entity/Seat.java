package com.hockey.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "SEAT")
public class Seat implements Serializable {

	private static final long serialVersionUID = -5784063606618892093L;
	private static final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Id
	@NotEmpty(message = "{validation.field.required.seat.number}")
	@Size(max = 3, message = "{validation.length.seat.number}")
	@Column(name = "USERNAME", length = 3)
	private String username;

	@NotEmpty(message = "{validation.field.required.password}")
	@Column(name = "PASSWORD", length = 80, nullable = false)
	private String password;

	@Size(max = 128, message = "{validation.length.fan.name}")
	@Column(name = "FAN_NAME", length = 128)
	private String fanName;

	@Column(name = "POINTS", length = 6)
	private Integer points;

	public Seat() {

	}

	public Seat(String username, String password) {
		this.username = username;
		setPassword(password);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seat other = (Seat) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	// GETTERS AND SETTERS
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
		this.password = bcrypt.encode(password);
	}

	public String getFanName() {
		return fanName;
	}

	public void setFanName(String fanName) {
		this.fanName = fanName;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

}
