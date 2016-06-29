package org.jfree.base.config;

import java.util.Enumeration;
import java.util.Iterator;
import org.jfree.util.Configuration;

public interface ModifiableConfiguration extends Configuration {
   void setConfigProperty(String var1, String var2);

   Enumeration getConfigProperties();

   Iterator findPropertyKeys(String var1);
}
