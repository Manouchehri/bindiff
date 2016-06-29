/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.config;

import java.util.Enumeration;
import java.util.Vector;
import org.jfree.base.config.HierarchicalConfiguration;

public class SystemPropertyConfiguration
extends HierarchicalConfiguration {
    @Override
    public void setConfigProperty(String string, String string2) {
        throw new UnsupportedOperationException("The SystemPropertyConfiguration is readOnly");
    }

    @Override
    public String getConfigProperty(String string, String string2) {
        try {
            String string3 = System.getProperty(string);
            if (string3 == null) return super.getConfigProperty(string, string2);
            return string3;
        }
        catch (SecurityException var3_4) {
            // empty catch block
        }
        return super.getConfigProperty(string, string2);
    }

    @Override
    public boolean isLocallyDefined(String string) {
        try {
            return System.getProperties().containsKey(string);
        }
        catch (SecurityException var2_2) {
            return false;
        }
    }

    @Override
    public Enumeration getConfigProperties() {
        try {
            return System.getProperties().keys();
        }
        catch (SecurityException var1_1) {
            return new Vector().elements();
        }
    }
}

