package com.simplify.sample.security.domain;

import org.springframework.security.core.userdetails.User;
/*
 * Spring에서 인정하는 User 형태 
 *  org.springframework.security.core.userdetails.User 
 * */

public class SecurityMember extends User {

	private static final long serialVersionUID = 1L;
	private String ip;
	
	public SecurityMember(Member member) { //생성자
		super(member.getUsername(), member.getPassword(), member.getAuthorities());
		// TODO Auto-generated constructor stub
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	
}
