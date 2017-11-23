package com.hockey.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hockey.model.entity.Seat;

public class LoggedUser extends org.springframework.security.core.userdetails.User implements UserDetails {

	private static final long serialVersionUID = 3021171609299255196L;

	private final Seat user;

	public LoggedUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Seat user) {
		super(username, password, authorities);
		this.user = user;
	}

	public Seat getUser() {
		return user;
	}

}
