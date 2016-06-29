package org.jfree.util;

import java.util.*;

public class ExtendedConfigurationWrapper implements ExtendedConfiguration
{
    private Configuration parent;
    
    public ExtendedConfigurationWrapper(final Configuration parent) {
        if (parent == null) {
            throw new NullPointerException("Parent given must not be null");
        }
        this.parent = parent;
    }
    
    public boolean getBoolProperty(final String s) {
        return this.getBoolProperty(s, false);
    }
    
    public boolean getBoolProperty(final String s, final boolean b) {
        return "true".equals(this.parent.getConfigProperty(s, String.valueOf(b)));
    }
    
    public int getIntProperty(final String s) {
        return this.getIntProperty(s, 0);
    }
    
    public int getIntProperty(final String s, final int n) {
        final String configProperty = this.parent.getConfigProperty(s);
        if (configProperty == null) {
            return n;
        }
        try {
            return Integer.parseInt(configProperty);
        }
        catch (Exception ex) {
            return n;
        }
    }
    
    public boolean isPropertySet(final String s) {
        return this.parent.getConfigProperty(s) != null;
    }
    
    public Iterator findPropertyKeys(final String s) {
        return this.parent.findPropertyKeys(s);
    }
    
    public String getConfigProperty(final String s) {
        return this.parent.getConfigProperty(s);
    }
    
    public String getConfigProperty(final String s, final String s2) {
        return this.parent.getConfigProperty(s, s2);
    }
    
    public Enumeration getConfigProperties() {
        return this.parent.getConfigProperties();
    }
    
    public Object clone() {
        ((ExtendedConfigurationWrapper)super.clone()).parent = (Configuration)this.parent.clone();
        return this.parent;
    }
}
