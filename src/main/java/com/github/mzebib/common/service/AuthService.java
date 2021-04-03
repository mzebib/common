package com.github.mzebib.common.service;

/**
 * @author mzebib
 */
public interface AuthService<A> extends Service {

    A authenticate(String username, String password)
            throws NullPointerException, IllegalArgumentException, SecurityException;


    A authenticate(String token)
            throws NullPointerException, IllegalArgumentException, SecurityException;


}
