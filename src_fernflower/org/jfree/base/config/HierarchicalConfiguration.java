package org.jfree.base.config;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import org.jfree.base.config.ModifiableConfiguration;
import org.jfree.util.Configuration;
import org.jfree.util.PublicCloneable;

public class HierarchicalConfiguration implements ModifiableConfiguration, PublicCloneable {
   private Properties configuration;
   private transient Configuration parentConfiguration;

   public HierarchicalConfiguration() {
      this.configuration = new Properties();
   }

   public HierarchicalConfiguration(Configuration var1) {
      this();
      this.parentConfiguration = var1;
   }

   public String getConfigProperty(String var1) {
      return this.getConfigProperty(var1, (String)null);
   }

   public String getConfigProperty(String var1, String var2) {
      String var3 = this.configuration.getProperty(var1);
      if(var3 == null) {
         if(this.isRootConfig()) {
            var3 = var2;
         } else {
            var3 = this.parentConfiguration.getConfigProperty(var1, var2);
         }
      }

      return var3;
   }

   public void setConfigProperty(String var1, String var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         if(var2 == null) {
            this.configuration.remove(var1);
         } else {
            this.configuration.setProperty(var1, var2);
         }

      }
   }

   private boolean isRootConfig() {
      return this.parentConfiguration == null;
   }

   public boolean isLocallyDefined(String var1) {
      return this.configuration.containsKey(var1);
   }

   protected Properties getConfiguration() {
      return this.configuration;
   }

   public void insertConfiguration(HierarchicalConfiguration var1) {
      var1.setParentConfig(this.getParentConfig());
      this.setParentConfig(var1);
   }

   protected void setParentConfig(Configuration var1) {
      if(this.parentConfiguration == this) {
         throw new IllegalArgumentException("Cannot add myself as parent configuration.");
      } else {
         this.parentConfiguration = var1;
      }
   }

   protected Configuration getParentConfig() {
      return this.parentConfiguration;
   }

   public Enumeration getConfigProperties() {
      return this.configuration.keys();
   }

   public Iterator findPropertyKeys(String var1) {
      TreeSet var2 = new TreeSet();
      this.collectPropertyKeys(var1, this, var2);
      return Collections.unmodifiableSet(var2).iterator();
   }

   private void collectPropertyKeys(String var1, Configuration var2, TreeSet var3) {
      Enumeration var4 = var2.getConfigProperties();

      while(var4.hasMoreElements()) {
         String var5 = (String)var4.nextElement();
         if(var5.startsWith(var1) && !var3.contains(var5)) {
            var3.add(var5);
         }
      }

      if(var2 instanceof HierarchicalConfiguration) {
         HierarchicalConfiguration var6 = (HierarchicalConfiguration)var2;
         if(var6.parentConfiguration != null) {
            this.collectPropertyKeys(var1, var6.parentConfiguration, var3);
         }
      }

   }

   protected boolean isParentSaved() {
      return true;
   }

   protected void configurationLoaded() {
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      if(!this.isParentSaved()) {
         var1.writeBoolean(false);
      } else {
         var1.writeBoolean(true);
         var1.writeObject(this.parentConfiguration);
      }

   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      boolean var2 = var1.readBoolean();
      if(var2) {
         this.parentConfiguration = (ModifiableConfiguration)var1.readObject();
      } else {
         this.parentConfiguration = null;
      }

      this.configurationLoaded();
   }

   public Object clone() {
      HierarchicalConfiguration var1 = (HierarchicalConfiguration)super.clone();
      var1.configuration = (Properties)this.configuration.clone();
      return var1;
   }
}
