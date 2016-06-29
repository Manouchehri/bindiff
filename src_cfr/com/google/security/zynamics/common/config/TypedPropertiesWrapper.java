/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.common.config;

import java.awt.Color;
import java.util.Properties;

public class TypedPropertiesWrapper {
    private final Properties properties;
    private String keyPrefix;

    public TypedPropertiesWrapper() {
        this(new Properties());
    }

    public TypedPropertiesWrapper(Properties properties) {
        this.properties = properties;
        this.keyPrefix = "";
    }

    public Properties getProperties() {
        return this.properties;
    }

    public void setKeyPrefix(String string) {
        this.keyPrefix = string;
    }

    public String getKeyPrefix() {
        return this.keyPrefix;
    }

    public boolean getBoolean(String string, boolean bl2) {
        String string2;
        String string3 = String.valueOf(this.keyPrefix);
        String string4 = String.valueOf(string);
        if (string4.length() != 0) {
            string2 = string3.concat(string4);
            return Boolean.valueOf(this.properties.getProperty(string2, String.valueOf(bl2)));
        }
        string2 = new String(string3);
        return Boolean.valueOf(this.properties.getProperty(string2, String.valueOf(bl2)));
    }

    public void setBoolean(String string, boolean bl2) {
        String string2 = String.valueOf(this.keyPrefix);
        String string3 = String.valueOf(string);
        this.properties.setProperty(string3.length() != 0 ? string2.concat(string3) : new String(string2), String.valueOf(bl2));
    }

    public Color getColor(String string, Color color) {
        try {
            String string2;
            String string3 = String.valueOf(this.keyPrefix);
            String string4 = String.valueOf(string);
            if (string4.length() != 0) {
                string2 = string3.concat(string4);
                return Color.decode(this.properties.getProperty(string2, String.valueOf(color.getRGB())));
            }
            string2 = new String(string3);
            return Color.decode(this.properties.getProperty(string2, String.valueOf(color.getRGB())));
        }
        catch (NumberFormatException var3_3) {
            return color;
        }
    }

    public void setColor(String string, Color color) {
        String string2 = String.valueOf(this.keyPrefix);
        String string3 = String.valueOf(string);
        this.properties.setProperty(string3.length() != 0 ? string2.concat(string3) : new String(string2), String.valueOf(color.getRGB()));
    }

    public int getInteger(String string, int n2) {
        try {
            String string2;
            String string3 = String.valueOf(this.keyPrefix);
            String string4 = String.valueOf(string);
            if (string4.length() != 0) {
                string2 = string3.concat(string4);
                return Integer.valueOf(this.properties.getProperty(string2, String.valueOf(n2)));
            }
            string2 = new String(string3);
            return Integer.valueOf(this.properties.getProperty(string2, String.valueOf(n2)));
        }
        catch (NumberFormatException var3_3) {
            return n2;
        }
    }

    public void setInteger(String string, int n2) {
        String string2 = String.valueOf(this.keyPrefix);
        String string3 = String.valueOf(string);
        this.properties.setProperty(string3.length() != 0 ? string2.concat(string3) : new String(string2), String.valueOf(n2));
    }

    public long getLong(String string, long l2) {
        try {
            String string2;
            String string3 = String.valueOf(this.keyPrefix);
            String string4 = String.valueOf(string);
            if (string4.length() != 0) {
                string2 = string3.concat(string4);
                return Long.valueOf(this.properties.getProperty(string2, String.valueOf(l2)));
            }
            string2 = new String(string3);
            return Long.valueOf(this.properties.getProperty(string2, String.valueOf(l2)));
        }
        catch (NumberFormatException var4_3) {
            return l2;
        }
    }

    public void setLong(String string, long l2) {
        String string2 = String.valueOf(this.keyPrefix);
        String string3 = String.valueOf(string);
        this.properties.setProperty(string3.length() != 0 ? string2.concat(string3) : new String(string2), String.valueOf(l2));
    }

    public String getString(String string, String string2) {
        String string3;
        String string4 = String.valueOf(this.keyPrefix);
        String string5 = String.valueOf(string);
        if (string5.length() != 0) {
            string3 = string4.concat(string5);
            return this.properties.getProperty(string3, string2);
        }
        string3 = new String(string4);
        return this.properties.getProperty(string3, string2);
    }

    public void setString(String string, String string2) {
        String string3 = String.valueOf(this.keyPrefix);
        String string4 = String.valueOf(string);
        this.properties.setProperty(string4.length() != 0 ? string3.concat(string4) : new String(string3), string2);
    }
}

