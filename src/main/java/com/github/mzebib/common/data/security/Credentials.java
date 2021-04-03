package com.github.mzebib.common.data.security;

/**
 * @author mzebib
 */
public interface Credentials {

    String getPassword();

    void setPassword(String password);


    String getToken();

    void setToken(String token);

}