package org.jfree.base.config;

import java.util.Enumeration;
import java.util.Vector;
import org.jfree.base.config.HierarchicalConfiguration;

public class SystemPropertyConfiguration extends HierarchicalConfiguration {
   public void setConfigProperty(String var1, String var2) {
      throw new UnsupportedOperationException("The SystemPropertyConfiguration is readOnly");
   }

   public String getConfigProperty(String var1, String var2) {
      try {
         String var3 = System.getProperty(var1);
         if(var3 != null) {
            return var3;
         }
      } catch (SecurityException var4) {
         ;
      }

      return super.getConfigProperty(var1, var2);
   }

   public boolean isLocallyDefined(String var1) {
      try {
         return System.getProperties().containsKey(var1);
      } catch (SecurityException var3) {
         return false;
      }
   }

   public Enumeration getConfigProperties() {
      try {
         return System.getProperties().keys();
      } catch (SecurityException var2) {
         return (new Vector()).elements();
      }
   }
}
