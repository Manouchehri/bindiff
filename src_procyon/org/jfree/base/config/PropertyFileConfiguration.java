package org.jfree.base.config;

import org.jfree.util.*;
import java.util.*;
import java.io.*;

public class PropertyFileConfiguration extends HierarchicalConfiguration
{
    static Class class$org$jfree$base$config$PropertyFileConfiguration;
    
    public void load(final String s) {
        final InputStream resourceRelativeAsStream = ObjectUtilities.getResourceRelativeAsStream(s, (PropertyFileConfiguration.class$org$jfree$base$config$PropertyFileConfiguration == null) ? (PropertyFileConfiguration.class$org$jfree$base$config$PropertyFileConfiguration = class$("org.jfree.base.config.PropertyFileConfiguration")) : PropertyFileConfiguration.class$org$jfree$base$config$PropertyFileConfiguration);
        if (resourceRelativeAsStream != null) {
            this.load(resourceRelativeAsStream);
        }
        else {
            Log.debug("Configuration file not found in the classpath: " + s);
        }
    }
    
    public void load(final InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException();
        }
        try {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            final Properties properties = new Properties();
            properties.load(bufferedInputStream);
            this.getConfiguration().putAll(properties);
            bufferedInputStream.close();
        }
        catch (IOException ex) {
            Log.warn("Unable to read configuration", ex);
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
