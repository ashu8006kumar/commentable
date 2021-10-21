package com.arha.commentable.bo;

public class TokenBo {
	private final String token;

	public String getToken() {
		return String.format("Bearer %s", token);
	}

	public TokenBo(String token) {
		super();
		this.token = token;
	}
}
