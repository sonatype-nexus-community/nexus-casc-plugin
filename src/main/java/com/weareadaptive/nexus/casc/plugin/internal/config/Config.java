package com.weareadaptive.nexus.casc.plugin.internal.config;

import java.util.List;

public class Config {
    private ConfigCore core;
    private ConfigRepository repository;
    private ConfigSecurity security;
    private Boolean pruneCapabilitiesByType;
    private List<ConfigCapability> capabilities;

    public ConfigCore getCore() {
        return core;
    }

    public void setCore(ConfigCore core) {
        this.core = core;
    }

    public ConfigRepository getRepository() {
        return repository;
    }

    public void setRepository(ConfigRepository repository) {
        this.repository = repository;
    }

    public ConfigSecurity getSecurity() {
        return security;
    }

    public void setSecurity(ConfigSecurity security) {
        this.security = security;
    }

    public Boolean getPruneCapabilitiesByType() {
        return pruneCapabilitiesByType;
    }

    public void setPruneCapabilitiesByType(Boolean pruneCapabilitiesByType) {
        this.pruneCapabilitiesByType = pruneCapabilitiesByType;
    }

    public List<ConfigCapability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<ConfigCapability> capabilities) {
        this.capabilities = capabilities;
    }
}
