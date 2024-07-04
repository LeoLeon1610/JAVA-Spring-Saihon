package com.saihon.Spring.dto;

public class ChangePassword {
	private String password;
	private String npassword;
	
	public ChangePassword() {
		
	}
	
	public ChangePassword(String password, String npassword) {
		this.password = password;
		this.npassword = npassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}
	
	
}
