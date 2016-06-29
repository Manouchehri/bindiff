package org.jfree.base;

import org.jfree.JCommon;
import org.jfree.base.AbstractBoot;
import org.jfree.base.BootableProjectInfo;
import org.jfree.base.config.ModifiableConfiguration;
import org.jfree.util.Configuration;
import org.jfree.util.ObjectUtilities;

public class BaseBoot extends AbstractBoot {
   private static BaseBoot singleton;
   private BootableProjectInfo bootableProjectInfo;
   static Class class$org$jfree$base$log$DefaultLogModule;

   private BaseBoot() {
      this.bootableProjectInfo = JCommon.INFO;
   }

   public static ModifiableConfiguration getConfiguration() {
      return (ModifiableConfiguration)getInstance().getGlobalConfig();
   }

   protected synchronized Configuration loadConfiguration() {
      return this.createDefaultHierarchicalConfiguration("/org/jfree/base/jcommon.properties", "/jcommon.properties", true);
   }

   public static synchronized AbstractBoot getInstance() {
      if(singleton == null) {
         singleton = new BaseBoot();
      }

      return singleton;
   }

   protected void performBoot() {
      ObjectUtilities.setClassLoaderSource(getConfiguration().getConfigProperty("org.jfree.ClassLoader"));
      this.getPackageManager().addModule((class$org$jfree$base$log$DefaultLogModule == null?(class$org$jfree$base$log$DefaultLogModule = class$("org.jfree.base.log.DefaultLogModule")):class$org$jfree$base$log$DefaultLogModule).getName());
      this.getPackageManager().load("org.jfree.jcommon.modules.");
      this.getPackageManager().initializeModules();
   }

   protected BootableProjectInfo getProjectInfo() {
      return this.bootableProjectInfo;
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
