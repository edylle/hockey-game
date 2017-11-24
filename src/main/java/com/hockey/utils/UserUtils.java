package com.hockey.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import com.hockey.model.entity.Seat;
import com.hockey.security.LoggedUser;

public class UserUtils {

	public static Seat getUser() {
		return ((LoggedUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
	}

	public static boolean isUserLogged() {
		return !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
	}

}
