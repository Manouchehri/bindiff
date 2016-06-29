package com.google.security.zynamics.common.config;

import java.util.*;
import java.awt.*;

public class TypedPropertiesWrapper
{
    private final Properties properties;
    private String keyPrefix;
    
    public TypedPropertiesWrapper() {
        this(new Properties());
    }
    
    public TypedPropertiesWrapper(final Properties properties) {
        this.properties = properties;
        this.keyPrefix = "";
    }
    
    public Properties getProperties() {
        return this.properties;
    }
    
    public void setKeyPrefix(final String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }
    
    public String getKeyPrefix() {
        return this.keyPrefix;
    }
    
    public boolean getBoolean(final String s, final boolean b) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        return Boolean.valueOf(properties.getProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(b)));
    }
    
    public void setBoolean(final String s, final boolean b) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        properties.setProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(b));
    }
    
    public Color getColor(final String s, final Color color) {
        try {
            final Properties properties = this.properties;
            final String value = String.valueOf(this.keyPrefix);
            final String value2 = String.valueOf(s);
            return Color.decode(properties.getProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(color.getRGB())));
        }
        catch (NumberFormatException ex) {
            return color;
        }
    }
    
    public void setColor(final String s, final Color color) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        properties.setProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(color.getRGB()));
    }
    
    public int getInteger(final String s, final int n) {
        try {
            final Properties properties = this.properties;
            final String value = String.valueOf(this.keyPrefix);
            final String value2 = String.valueOf(s);
            return Integer.valueOf(properties.getProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(n)));
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public void setInteger(final String s, final int n) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        properties.setProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(n));
    }
    
    public long getLong(final String s, final long n) {
        try {
            final Properties properties = this.properties;
            final String value = String.valueOf(this.keyPrefix);
            final String value2 = String.valueOf(s);
            return Long.valueOf(properties.getProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(n)));
        }
        catch (NumberFormatException ex) {
            return n;
        }
    }
    
    public void setLong(final String s, final long n) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        properties.setProperty((value2.length() != 0) ? value.concat(value2) : new String(value), String.valueOf(n));
    }
    
    public String getString(final String s, final String s2) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        return properties.getProperty((value2.length() != 0) ? value.concat(value2) : new String(value), s2);
    }
    
    public void setString(final String s, final String s2) {
        final Properties properties = this.properties;
        final String value = String.valueOf(this.keyPrefix);
        final String value2 = String.valueOf(s);
        properties.setProperty((value2.length() != 0) ? value.concat(value2) : new String(value), s2);
    }
}
