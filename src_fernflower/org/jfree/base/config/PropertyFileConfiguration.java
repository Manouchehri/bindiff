package org.jfree.base.config;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.jfree.base.config.HierarchicalConfiguration;
import org.jfree.util.Log;
import org.jfree.util.ObjectUtilities;

public class PropertyFileConfiguration extends HierarchicalConfiguration {
   static Class class$org$jfree$base$config$PropertyFileConfiguration;

   public void load(String var1) {
      InputStream var2 = ObjectUtilities.getResourceRelativeAsStream(var1, class$org$jfree$base$config$PropertyFileConfiguration == null?(class$org$jfree$base$config$PropertyFileConfiguration = class$("org.jfree.base.config.PropertyFileConfiguration")):class$org$jfree$base$config$PropertyFileConfiguration);
      if(var2 != null) {
         this.load(var2);
      } else {
         Log.debug("Configuration file not found in the classpath: " + var1);
      }

   }

   public void load(InputStream var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         try {
            BufferedInputStream var2 = new BufferedInputStream(var1);
            Properties var3 = new Properties();
            var3.load(var2);
            this.getConfiguration().putAll(var3);
            var2.close();
         } catch (IOException var4) {
            Log.warn("Unable to read configuration", var4);
         }

      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
