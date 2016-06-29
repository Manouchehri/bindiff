package com.google.security.zynamics.bindiff.utils;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.resources.Constants;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.IdaHelpers;
import java.io.File;

public class ExternalAppUtils {
   public static String getCommandLineDiffer() {
      // $FF: Couldn't be decompiled
   }

   public static File getIdaExe(File var0) {
      String var1 = CFileUtils.getFileExtension(var0.getPath());
      GeneralSettingsConfigItem var2 = BinDiffConfigFile.getInstance().getMainSettings();
      String var3;
      char var4;
      String var5;
      if(var1.equalsIgnoreCase("idb")) {
         var3 = var2.getIdaDirectory();
         var4 = File.separatorChar;
         var5 = String.valueOf(IdaHelpers.IDA32_EXECUTABLE);
         return new File((new StringBuilder(1 + String.valueOf(var3).length() + String.valueOf(var5).length())).append(var3).append(var4).append(var5).toString());
      } else if(var1.equalsIgnoreCase("i64")) {
         var3 = var2.getIdaDirectory();
         var4 = File.separatorChar;
         var5 = String.valueOf(IdaHelpers.IDA64_EXECUTABLE);
         return new File((new StringBuilder(1 + String.valueOf(var3).length() + String.valueOf(var5).length())).append(var3).append(var4).append(var5).toString());
      } else {
         return null;
      }
   }
}
