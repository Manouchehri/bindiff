package org.jfree.base.log;

import org.jfree.base.log.DefaultLog;
import org.jfree.base.log.LogConfiguration;
import org.jfree.base.modules.AbstractModule;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Log;
import org.jfree.util.PrintStreamLogTarget;

public class DefaultLogModule extends AbstractModule {
   static Class class$org$jfree$util$PrintStreamLogTarget;

   public DefaultLogModule() {
      this.loadModuleInfo();
   }

   public void initialize(SubSystem var1) {
      if(!LogConfiguration.isDisableLogging()) {
         if(LogConfiguration.getLogTarget().equals((class$org$jfree$util$PrintStreamLogTarget == null?(class$org$jfree$util$PrintStreamLogTarget = class$("org.jfree.util.PrintStreamLogTarget")):class$org$jfree$util$PrintStreamLogTarget).getName())) {
            DefaultLog.installDefaultLog();
            Log.getInstance().addTarget(new PrintStreamLogTarget());
            if("true".equals(var1.getGlobalConfig().getConfigProperty("org.jfree.base.LogAutoInit"))) {
               Log.getInstance().init();
            }

            Log.info("Default log target started ... previous log messages could have been ignored.");
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
