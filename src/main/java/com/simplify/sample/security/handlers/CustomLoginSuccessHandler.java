package com.simplify.sample.security.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.simplify.sample.security.domain.SecurityMember;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	// AuthenticationSuccessHandler 구현하기
	//1.로그인한 사용자의 IP 정보 저장하기
	//2.로그인 이전에 요청했던 URL이 있으면, 로그인이 성공한 뒤, 그 URL로 Redirect 해 주기

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		// TODO  로그인이 성공했을때에 대한 처리
		
		((SecurityMember)authentication.getPrincipal()).setIp(getClientIp(request));
		HttpSession session = request.getSession();
		if( session != null ) {
			//이전페이지로 
			String redirectUrl = (String) session.getAttribute("prevPage");
			if(redirectUrl != null) {
				session.removeAttribute("prevPage");
				getRedirectStrategy().sendRedirect(request, response, redirectUrl);
			}else {
				super.onAuthenticationSuccess(request, response, authentication);
			}
			
		}else {
			super.onAuthenticationSuccess(request, response, authentication);
		}
	}

	private String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("WL-Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("HTTP_CLIENT_IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("HTTP_X_FORWARDED_FOR");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getRemoteAddr();
         }

		return ip;
	}
	
	

}
