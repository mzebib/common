package com.github.mzebib.common.util;

public class AuthInfo {

    private String username;
    private String password;
    private String token;

    public AuthInfo() {
    }

    public AuthInfo(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public AuthInfo(String token) {
        setToken(token);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}