package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.exceptions.BinExportException;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.IdaException;
import com.google.security.zynamics.zylib.system.IdaHelpers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ExportProcess {
   private static File createIDAScript(File var0, String var1) {
      String var3 = String.valueOf(var0.getPath());
      String var4 = String.valueOf(File.separator);
      String var5 = String.valueOf("export.idc");
      File var2 = new File((new StringBuilder(0 + String.valueOf(var3).length() + String.valueOf(var4).length() + String.valueOf(var5).length())).append(var3).append(var4).append(var5).toString());
      PrintWriter var11 = null;

      try {
         var11 = new PrintWriter(new FileOutputStream(var2));
         var11.println("#include <idc.idc>");
         var11.println("static main() {");
         var11.println("  Batch(0);");
         var11.println("  Wait();");
         Object[] var10002 = new Object[]{"BinExport2Diff8", null};
         var4 = String.valueOf(var0.getPath());
         var5 = String.valueOf(File.separator);
         var10002[1] = (new StringBuilder(0 + String.valueOf(var4).length() + String.valueOf(var5).length() + String.valueOf(var1).length())).append(var4).append(var5).append(var1).toString().replace("\\", "\\\\");
         var11.println(String.format("  Exit(%s(\"%s\"));", var10002));
         var11.println("}");
         if(var11.checkError()) {
            throw new BinExportException("Couldn\'t write IDA export script.");
         }
      } catch (FileNotFoundException var9) {
         throw new BinExportException(var9, "Couldn\'t create IDA export script file.");
      } finally {
         if(var11 != null) {
            var11.close();
         }

      }

      return var2;
   }

   public static String getExportedFileName(String var0, File var1) {
      // $FF: Couldn't be decompiled
   }

   public static void startExportProcess(File var0, File var1, File var2, String var3) {
      File var4 = createIDAScript(var1, var3);

      try {
         String var5 = BinDiffConfigFile.getInstance().getMainSettings().getIdaDirectory();
         char var6 = File.separatorChar;
         String var7 = String.valueOf(var0.getName());
         IdaHelpers.createIdaProcess((new StringBuilder(1 + String.valueOf(var5).length() + String.valueOf(var7).length())).append(var5).append(var6).append(var7).toString(), var4, var2.getAbsolutePath(), "");
      } catch (IdaException var11) {
         throw new BinExportException(var11);
      } finally {
         var4.delete();
      }

   }
}
