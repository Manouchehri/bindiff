package org.jfree.base;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import org.jfree.base.BootableProjectInfo;
import org.jfree.base.config.HierarchicalConfiguration;
import org.jfree.base.config.PropertyFileConfiguration;
import org.jfree.base.config.SystemPropertyConfiguration;
import org.jfree.base.modules.PackageManager;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;
import org.jfree.util.ExtendedConfigurationWrapper;
import org.jfree.util.Log;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractBoot implements SubSystem {
   private ExtendedConfigurationWrapper extWrapper;
   private PackageManager packageManager;
   private Configuration globalConfig;
   private boolean bootInProgress;
   private boolean bootDone;

   public synchronized PackageManager getPackageManager() {
      if(this.packageManager == null) {
         this.packageManager = PackageManager.createInstance(this);
      }

      return this.packageManager;
   }

   public synchronized Configuration getGlobalConfig() {
      if(this.globalConfig == null) {
         this.globalConfig = this.loadConfiguration();
      }

      return this.globalConfig;
   }

   public final synchronized boolean isBootInProgress() {
      return this.bootInProgress;
   }

   public final synchronized boolean isBootDone() {
      return this.bootDone;
   }

   protected abstract Configuration loadConfiguration();

   public final void start() {
      synchronized(this) {
         if(this.isBootDone()) {
            return;
         }

         while(this.isBootInProgress()) {
            try {
               this.wait();
            } catch (InterruptedException var11) {
               ;
            }
         }

         if(this.isBootDone()) {
            return;
         }

         this.bootInProgress = true;
      }

      BootableProjectInfo var1 = this.getProjectInfo();
      if(var1 != null) {
         BootableProjectInfo[] var2 = var1.getDependencies();

         for(int var3 = 0; var3 < var2.length; ++var3) {
            AbstractBoot var4 = this.loadBooter(var2[var3].getBootClass());
            if(var4 != null) {
               synchronized(var4) {
                  var4.start();

                  while(!var4.isBootDone()) {
                     try {
                        var4.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }
               }
            }
         }
      }

      this.performBoot();
      if(var1 != null) {
         Log.info(var1.getName() + " " + var1.getVersion() + " started.");
      } else {
         Log.info(this.getClass() + " started.");
      }

      synchronized(this) {
         this.bootInProgress = false;
         this.bootDone = true;
         this.notifyAll();
      }
   }

   protected abstract void performBoot();

   protected abstract BootableProjectInfo getProjectInfo();

   protected AbstractBoot loadBooter(String var1) {
      if(var1 == null) {
         return null;
      } else {
         try {
            Class var2 = ObjectUtilities.getClassLoader(this.getClass()).loadClass(var1);
            Method var3 = var2.getMethod("getInstance", (Class[])null);
            return (AbstractBoot)var3.invoke((Object)null, (Object[])null);
         } catch (Exception var4) {
            Log.info("Unable to boot dependent class: " + var1);
            return null;
         }
      }
   }

   protected Configuration createDefaultHierarchicalConfiguration(String var1, String var2, boolean var3) {
      HierarchicalConfiguration var4 = new HierarchicalConfiguration();
      if(var1 != null) {
         PropertyFileConfiguration var5 = new PropertyFileConfiguration();
         var5.load(var1);
         var4.insertConfiguration(var5);
         var4.insertConfiguration(this.getPackageManager().getPackageConfiguration());
      }

      if(var2 != null) {
         String var13;
         if(var2.startsWith("/")) {
            var13 = var2.substring(1);
         } else {
            var13 = var2;
         }

         try {
            Enumeration var6 = ObjectUtilities.getClassLoader(this.getClass()).getResources(var13);
            ArrayList var7 = new ArrayList();

            PropertyFileConfiguration var9;
            while(var6.hasMoreElements()) {
               URL var8 = (URL)var6.nextElement();

               try {
                  var9 = new PropertyFileConfiguration();
                  InputStream var10 = var8.openStream();
                  var9.load(var10);
                  var10.close();
                  var7.add(var9);
               } catch (IOException var11) {
                  Log.warn("Failed to load the user configuration at " + var8, var11);
               }
            }

            for(int var15 = var7.size() - 1; var15 >= 0; --var15) {
               var9 = (PropertyFileConfiguration)var7.get(var15);
               var4.insertConfiguration(var9);
            }
         } catch (IOException var12) {
            Log.warn("Failed to lookup the user configurations.", var12);
         }
      }

      SystemPropertyConfiguration var14 = new SystemPropertyConfiguration();
      var4.insertConfiguration(var14);
      return var4;
   }

   public synchronized ExtendedConfiguration getExtendedConfig() {
      if(this.extWrapper == null) {
         this.extWrapper = new ExtendedConfigurationWrapper(this.getGlobalConfig());
      }

      return this.extWrapper;
   }
}
