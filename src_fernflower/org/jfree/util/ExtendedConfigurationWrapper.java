package org.jfree.util;

import java.util.Enumeration;
import java.util.Iterator;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;

public class ExtendedConfigurationWrapper implements ExtendedConfiguration {
   private Configuration parent;

   public ExtendedConfigurationWrapper(Configuration var1) {
      if(var1 == null) {
         throw new NullPointerException("Parent given must not be null");
      } else {
         this.parent = var1;
      }
   }

   public boolean getBoolProperty(String var1) {
      return this.getBoolProperty(var1, false);
   }

   public boolean getBoolProperty(String var1, boolean var2) {
      return "true".equals(this.parent.getConfigProperty(var1, String.valueOf(var2)));
   }

   public int getIntProperty(String var1) {
      return this.getIntProperty(var1, 0);
   }

   public int getIntProperty(String var1, int var2) {
      String var3 = this.parent.getConfigProperty(var1);
      if(var3 == null) {
         return var2;
      } else {
         try {
            return Integer.parseInt(var3);
         } catch (Exception var5) {
            return var2;
         }
      }
   }

   public boolean isPropertySet(String var1) {
      return this.parent.getConfigProperty(var1) != null;
   }

   public Iterator findPropertyKeys(String var1) {
      return this.parent.findPropertyKeys(var1);
   }

   public String getConfigProperty(String var1) {
      return this.parent.getConfigProperty(var1);
   }

   public String getConfigProperty(String var1, String var2) {
      return this.parent.getConfigProperty(var1, var2);
   }

   public Enumeration getConfigProperties() {
      return this.parent.getConfigProperties();
   }

   public Object clone() {
      ExtendedConfigurationWrapper var1 = (ExtendedConfigurationWrapper)super.clone();
      var1.parent = (Configuration)this.parent.clone();
      return this.parent;
   }
}
