package com.google.security.zynamics.common.config;

import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;

public final class ConfigHelper {
   public static String getConfigurationDirectory(String var0, String var1) {
      String var2 = getZynamicsDirectory(var0);
      String var3 = String.valueOf(File.separator);
      return (new StringBuilder(0 + String.valueOf(var2).length() + String.valueOf(var1).length() + String.valueOf(var3).length())).append(var2).append(var1).append(var3).toString();
   }

   public static String getZynamicsDirectory(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static final String getMachineConfigFileName(String var0, String var1) {
      // $FF: Couldn't be decompiled
   }

   public static String getConfigFileName(String var0, String var1, String var2) {
      // $FF: Couldn't be decompiled
   }
}
