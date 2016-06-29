/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.config;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import org.jfree.base.config.HierarchicalConfiguration;
import org.jfree.util.Log;
import org.jfree.util.ObjectUtilities;

public class PropertyFileConfiguration
extends HierarchicalConfiguration {
    static Class class$org$jfree$base$config$PropertyFileConfiguration;

    public void load(String string) {
        Class class_ = class$org$jfree$base$config$PropertyFileConfiguration == null ? (PropertyFileConfiguration.class$org$jfree$base$config$PropertyFileConfiguration = PropertyFileConfiguration.class$("org.jfree.base.config.PropertyFileConfiguration")) : class$org$jfree$base$config$PropertyFileConfiguration;
        InputStream inputStream = ObjectUtilities.getResourceRelativeAsStream(string, class_);
        if (inputStream != null) {
            this.load(inputStream);
            return;
        }
        Log.debug(new StringBuffer().append("Configuration file not found in the classpath: ").append(string).toString());
    }

    public void load(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException();
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            this.getConfiguration().putAll(properties);
            bufferedInputStream.close();
            return;
        }
        catch (IOException var2_3) {
            Log.warn("Unable to read configuration", var2_3);
        }
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

