package org.jfree.base.log;

import org.jfree.base.BaseBoot;

public class LogConfiguration {
   public static final String DISABLE_LOGGING_DEFAULT = "false";
   public static final String LOGLEVEL = "org.jfree.base.LogLevel";
   public static final String LOGLEVEL_DEFAULT = "Info";
   public static final String LOGTARGET = "org.jfree.base.LogTarget";
   public static final String LOGTARGET_DEFAULT;
   public static final String DISABLE_LOGGING = "org.jfree.base.NoDefaultDebug";
   static Class class$org$jfree$util$PrintStreamLogTarget;

   public static String getLogTarget() {
      return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogTarget", LOGTARGET_DEFAULT);
   }

   public static void setLogTarget(String var0) {
      BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogTarget", var0);
   }

   public static String getLogLevel() {
      return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.LogLevel", "Info");
   }

   public static void setLogLevel(String var0) {
      BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.LogLevel", var0);
   }

   public static boolean isDisableLogging() {
      return BaseBoot.getInstance().getGlobalConfig().getConfigProperty("org.jfree.base.NoDefaultDebug", "false").equalsIgnoreCase("true");
   }

   public static void setDisableLogging(boolean var0) {
      BaseBoot.getConfiguration().setConfigProperty("org.jfree.base.NoDefaultDebug", String.valueOf(var0));
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }

   static {
      LOGTARGET_DEFAULT = (class$org$jfree$util$PrintStreamLogTarget == null?(class$org$jfree$util$PrintStreamLogTarget = class$("org.jfree.util.PrintStreamLogTarget")):class$org$jfree$util$PrintStreamLogTarget).getName();
   }
}
