/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Enumeration;
import java.util.Iterator;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;

public class ExtendedConfigurationWrapper
implements ExtendedConfiguration {
    private Configuration parent;

    public ExtendedConfigurationWrapper(Configuration configuration) {
        if (configuration == null) {
            throw new NullPointerException("Parent given must not be null");
        }
        this.parent = configuration;
    }

    @Override
    public boolean getBoolProperty(String string) {
        return this.getBoolProperty(string, false);
    }

    @Override
    public boolean getBoolProperty(String string, boolean bl2) {
        return "true".equals(this.parent.getConfigProperty(string, String.valueOf(bl2)));
    }

    @Override
    public int getIntProperty(String string) {
        return this.getIntProperty(string, 0);
    }

    @Override
    public int getIntProperty(String string, int n2) {
        String string2 = this.parent.getConfigProperty(string);
        if (string2 == null) {
            return n2;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (Exception var4_4) {
            return n2;
        }
    }

    @Override
    public boolean isPropertySet(String string) {
        if (this.parent.getConfigProperty(string) == null) return false;
        return true;
    }

    @Override
    public Iterator findPropertyKeys(String string) {
        return this.parent.findPropertyKeys(string);
    }

    @Override
    public String getConfigProperty(String string) {
        return this.parent.getConfigProperty(string);
    }

    @Override
    public String getConfigProperty(String string, String string2) {
        return this.parent.getConfigProperty(string, string2);
    }

    @Override
    public Enumeration getConfigProperties() {
        return this.parent.getConfigProperties();
    }

    @Override
    public Object clone() {
        ExtendedConfigurationWrapper extendedConfigurationWrapper = (ExtendedConfigurationWrapper)super.clone();
        extendedConfigurationWrapper.parent = (Configuration)this.parent.clone();
        return this.parent;
    }
}

