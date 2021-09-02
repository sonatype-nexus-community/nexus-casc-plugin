package com.weareadaptive.nexus.casc.plugin.internal.config;

import java.util.List;

public class ConfigSecurity {
    private Boolean anonymousAccess;
    private Boolean pruneUsers;
    private Boolean pruneRolesBySource;
    private List<ConfigSecurityPrivilege> privileges;
    private List<ConfigSecurityRole> roles;
    private List<ConfigSecurityUser> users;
    private List<ConfigSecurityRealm> realms;

    public Boolean getAnonymousAccess() {
        return anonymousAccess;
    }

    public void setAnonymousAccess(Boolean anonymousAccess) {
        this.anonymousAccess = anonymousAccess;
    }

    public Boolean getPruneUsers() {
        return pruneUsers;
    }

    public void setPruneUsers(Boolean pruneUsers) {
        this.pruneUsers = pruneUsers;
    }

    public Boolean getPruneRolesBySource() {
        return pruneRolesBySource;
    }

    public void setPruneRolesBySource(Boolean pruneRolesBySource) {
        this.pruneRolesBySource = pruneRolesBySource;
    }

    public List<ConfigSecurityPrivilege> getPrivileges() { return privileges; }

    public void setPrivileges(List<ConfigSecurityPrivilege> privileges) { this.privileges = privileges; }

    public List<ConfigSecurityUser> getUsers() {
        return users;
    }

    public void setUsers(List<ConfigSecurityUser> users) {
        this.users = users;
    }

    public List<ConfigSecurityRealm> getRealms() {
        return realms;
    }

    public void setRealms(List<ConfigSecurityRealm> realms) {
        this.realms = realms;
    }

    public List<ConfigSecurityRole> getRoles() { return roles; }

    public void setRoles(List<ConfigSecurityRole> roles) { this.roles = roles; }
}
