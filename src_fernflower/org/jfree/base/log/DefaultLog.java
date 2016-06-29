package org.jfree.base.log;

import org.jfree.base.log.LogConfiguration;
import org.jfree.util.Log;
import org.jfree.util.LogTarget;
import org.jfree.util.PrintStreamLogTarget;

public class DefaultLog extends Log {
   private static final PrintStreamLogTarget DEFAULT_LOG_TARGET = new PrintStreamLogTarget();
   private static final DefaultLog defaultLogInstance = new DefaultLog();

   public void init() {
      this.removeTarget(DEFAULT_LOG_TARGET);
      String var1 = LogConfiguration.getLogLevel();
      if(var1.equalsIgnoreCase("error")) {
         this.setDebuglevel(0);
      } else if(var1.equalsIgnoreCase("warn")) {
         this.setDebuglevel(1);
      } else if(var1.equalsIgnoreCase("info")) {
         this.setDebuglevel(2);
      } else if(var1.equalsIgnoreCase("debug")) {
         this.setDebuglevel(3);
      }

   }

   public synchronized void addTarget(LogTarget var1) {
      super.addTarget(var1);
      if(var1 != DEFAULT_LOG_TARGET) {
         this.removeTarget(DEFAULT_LOG_TARGET);
      }

   }

   public static DefaultLog getDefaultLog() {
      return defaultLogInstance;
   }

   public static void installDefaultLog() {
      Log.defineLog(defaultLogInstance);
   }

   static {
      defaultLogInstance.addTarget(DEFAULT_LOG_TARGET);

      try {
         String var0 = System.getProperty("org.jfree.DebugDefault", "false");
         if(Boolean.valueOf(var0).booleanValue()) {
            defaultLogInstance.setDebuglevel(3);
         } else {
            defaultLogInstance.setDebuglevel(1);
         }
      } catch (SecurityException var1) {
         defaultLogInstance.setDebuglevel(1);
      }

   }
}
