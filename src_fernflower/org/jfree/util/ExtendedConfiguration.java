package org.jfree.util;

import org.jfree.util.Configuration;

public interface ExtendedConfiguration extends Configuration {
   boolean isPropertySet(String var1);

   int getIntProperty(String var1);

   int getIntProperty(String var1, int var2);

   boolean getBoolProperty(String var1);

   boolean getBoolProperty(String var1, boolean var2);
}
