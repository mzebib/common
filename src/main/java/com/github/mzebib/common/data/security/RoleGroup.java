package com.github.mzebib.common.data.security;

import com.github.mzebib.common.util.SetNameDescription;

import java.util.Set;

/**
 * @author mzebib
 */
public interface RoleGroup
        extends SetNameDescription {

    Set<Role> getRoles();

    void setRoles(Set<Role> roles);

    void addRole(Role role);

    void removeRole(Role role);


    Set<Permission> getPermissions();

    void setPermissions(Set<Permission> permissions);

    void addPermission(Permission permission);

    void removePermission(Permission permission);

}
