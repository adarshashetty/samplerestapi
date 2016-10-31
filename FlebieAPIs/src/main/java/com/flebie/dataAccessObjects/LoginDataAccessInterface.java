package com.flebie.dataAccessObjects;

public interface LoginDataAccessInterface {
	public String doLogin(String username, String password);
	public String doLogout(String username, String password);
}
