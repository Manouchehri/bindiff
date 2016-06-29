package org.jfree.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import org.jfree.base.config.ModifiableConfiguration;

public class DefaultConfiguration extends Properties implements ModifiableConfiguration {
   public String getConfigProperty(String var1) {
      return this.getProperty(var1);
   }

   public String getConfigProperty(String var1, String var2) {
      return this.getProperty(var1, var2);
   }

   public Iterator findPropertyKeys(String var1) {
      TreeSet var2 = new TreeSet();
      Enumeration var3 = this.keys();

      while(var3.hasMoreElements()) {
         String var4 = (String)var3.nextElement();
         if(var4.startsWith(var1) && !var2.contains(var4)) {
            var2.add(var4);
         }
      }

      return Collections.unmodifiableSet(var2).iterator();
   }

   public Enumeration getConfigProperties() {
      return this.keys();
   }

   public void setConfigProperty(String var1, String var2) {
      if(var2 == null) {
         this.remove(var1);
      } else {
         this.setProperty(var1, var2);
      }

   }
}
