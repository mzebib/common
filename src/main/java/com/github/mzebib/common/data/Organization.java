package com.github.mzebib.common.data;

import java.util.Set;

/**
 * @author mzebib
 */
public interface Organization {

    Set<? extends User> getUsers();

    void setUsers(Set<? extends User> users);

}