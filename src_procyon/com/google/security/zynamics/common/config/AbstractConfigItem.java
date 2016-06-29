package com.google.security.zynamics.common.config;

public abstract class AbstractConfigItem
{
    public abstract void load(final TypedPropertiesWrapper p0);
    
    public void loadWithKeyPrefix(final TypedPropertiesWrapper typedPropertiesWrapper, final String keyPrefix) {
        final String keyPrefix2 = typedPropertiesWrapper.getKeyPrefix();
        typedPropertiesWrapper.setKeyPrefix(keyPrefix);
        this.load(typedPropertiesWrapper);
        typedPropertiesWrapper.setKeyPrefix(keyPrefix2);
    }
    
    public abstract void store(final TypedPropertiesWrapper p0);
    
    public void storeWithKeyPrefix(final TypedPropertiesWrapper typedPropertiesWrapper, final String keyPrefix) {
        final String keyPrefix2 = typedPropertiesWrapper.getKeyPrefix();
        typedPropertiesWrapper.setKeyPrefix(keyPrefix);
        this.store(typedPropertiesWrapper);
        typedPropertiesWrapper.setKeyPrefix(keyPrefix2);
    }
}
