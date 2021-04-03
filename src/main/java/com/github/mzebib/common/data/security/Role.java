package com.github.mzebib.common.data.security;

import com.github.mzebib.common.util.SetNameDescription;

import java.util.Set;

/**
 * @author mzebib
 */
public interface Role
        extends SetNameDescription {

    Set<Permission> getPermissions();

    void setPermissions(Set<Permission> permissions);

    void addPermission(Permission permission);

    void removePermission(Permission permission);

}
