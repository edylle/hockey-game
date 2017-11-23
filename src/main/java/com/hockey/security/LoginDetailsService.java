package com.hockey.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.Seat;
import com.hockey.repository.SeatRepository;

@Service
public class LoginDetailsService implements UserDetailsService {

	@Autowired
	private SeatRepository seatRepository;

	private static final String ROLE_PREFIX = "ROLE_";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Seat user;

		user = seatRepository.findOne(username);

		if (user == null)
			throw new UsernameNotFoundException("Seat " + username + " not found");

		return new LoggedUser(user.getUsername(), user.getPassword(), getAuthorizations(user), user);
	}

	private Set<GrantedAuthority> getAuthorizations(Seat user) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX.concat("SEAT")));

		return authorities;
	}

}
