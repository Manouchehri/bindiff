/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.common.config;

import com.google.security.zynamics.common.config.TypedPropertiesWrapper;

public abstract class AbstractConfigItem {
    public abstract void load(TypedPropertiesWrapper var1);

    public void loadWithKeyPrefix(TypedPropertiesWrapper typedPropertiesWrapper, String string) {
        String string2 = typedPropertiesWrapper.getKeyPrefix();
        typedPropertiesWrapper.setKeyPrefix(string);
        this.load(typedPropertiesWrapper);
        typedPropertiesWrapper.setKeyPrefix(string2);
    }

    public abstract void store(TypedPropertiesWrapper var1);

    public void storeWithKeyPrefix(TypedPropertiesWrapper typedPropertiesWrapper, String string) {
        String string2 = typedPropertiesWrapper.getKeyPrefix();
        typedPropertiesWrapper.setKeyPrefix(string);
        this.store(typedPropertiesWrapper);
        typedPropertiesWrapper.setKeyPrefix(string2);
    }
}

