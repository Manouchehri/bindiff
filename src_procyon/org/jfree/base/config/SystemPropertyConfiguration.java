package org.jfree.base.config;

import java.util.*;

public class SystemPropertyConfiguration extends HierarchicalConfiguration
{
    public void setConfigProperty(final String s, final String s2) {
        throw new UnsupportedOperationException("The SystemPropertyConfiguration is readOnly");
    }
    
    public String getConfigProperty(final String s, final String s2) {
        try {
            final String property = System.getProperty(s);
            if (property != null) {
                return property;
            }
        }
        catch (SecurityException ex) {}
        return super.getConfigProperty(s, s2);
    }
    
    public boolean isLocallyDefined(final String s) {
        try {
            return System.getProperties().containsKey(s);
        }
        catch (SecurityException ex) {
            return false;
        }
    }
    
    public Enumeration getConfigProperties() {
        try {
            return System.getProperties().keys();
        }
        catch (SecurityException ex) {
            return new Vector().elements();
        }
    }
}
