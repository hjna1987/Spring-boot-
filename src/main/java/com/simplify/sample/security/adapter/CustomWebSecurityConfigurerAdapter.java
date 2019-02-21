package com.simplify.sample.security.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.simplify.sample.security.handlers.CustomLoginSuccessHandler;
import com.simplify.sample.security.service.CustomUserDetailsService;

/*
 WebSecurityConfigurerAdapter 상속받는 Adapter 구현하기
 
- 여기에서 암호화 방식에 대한 password encoder 를 정의하고, 
- 각종 요청에 대한 ignore 처리, 
- login page에 대한 처리 등이 구현됩니다. 
 
 [로그인 테스트]
 url : http://localhost:8080/login 
 계정/비밀번호 = abc / abcd 
*/
	
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomUserDetailsService  customUserDetailsService; 
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationSuccessHandler successHandler() {
      return new CustomLoginSuccessHandler();
    }


	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/openapi/**", "/resources/**");
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().formLogin().successHandler(successHandler());
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}


	
}
