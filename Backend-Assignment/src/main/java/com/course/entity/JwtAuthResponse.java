package com.course.entity;


public class JwtAuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    
    
    
	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
    
    
}