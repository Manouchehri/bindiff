package com.google.security.zynamics.bindiff.processes;

import com.google.common.base.Joiner;
import com.google.security.zynamics.bindiff.exceptions.DifferException;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.processes.ProcessOutputStreamReader;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import java.io.File;
import java.io.IOException;

public class DiffProcess {
   private static void handleExitCode(int var0) {
      if(var0 != 0) {
         if(var0 == 1) {
            throw new DifferException("An error occued while diffing. Exit code 1.");
         } else if(var0 == 2) {
            throw new DifferException("An error occured while diffing. Exit code 2.");
         } else if(var0 == 3) {
            throw new DifferException("Machine ran out of memory. Exit code 3.");
         } else {
            throw new DifferException(String.format("Unknown error occured while diffing. Exit code %d.", new Object[]{Integer.valueOf(var0)}));
         }
      }
   }

   public static String getBinDiffFileName(String var0, String var1) {
      try {
         String var2 = CFileUtils.removeFileExtension(var0);
         String var3 = var1.substring(var1.lastIndexOf(File.separator) + 1);
         var3 = CFileUtils.removeFileExtension(var3);
         String var5 = String.valueOf("BinDiff");
         return (new StringBuilder(5 + String.valueOf(var2).length() + String.valueOf(var3).length() + String.valueOf(var5).length())).append(var2).append("_vs_").append(var3).append(".").append(var5).toString();
      } catch (Exception var6) {
         throw new DifferException(var6, "Adding Diff to workspace.");
      }
   }

   public static void startDiffProcess(String var0, String var1, String var2, File var3) {
      File var4 = new File(var0);
      if(!var4.exists()) {
         throw new DifferException((new StringBuilder(29 + String.valueOf(var0).length())).append("Can\'t find Diff engine at \'").append(var0).append("\'.").toString());
      } else if(!var4.canExecute()) {
         throw new DifferException((new StringBuilder(37 + String.valueOf(var0).length())).append("Diff engine is not an executeable \'").append(var0).append("\'.").toString());
      } else {
         ProcessBuilder var5 = new ProcessBuilder(new String[]{var0, "--primary", var1, "--secondary", var2, "--output_dir", var3.getPath(), "--bin_format"});
         Logger.logInfo(Joiner.on(' ').join((Iterable)var5.command()), new Object[0]);
         byte var6 = -1;
         Process var7 = null;
         ProcessOutputStreamReader var8 = null;
         ProcessOutputStreamReader var9 = null;

         try {
            var5.redirectErrorStream(true);
            var7 = var5.start();
            var8 = new ProcessOutputStreamReader("Diff Process - stdout", var7.getInputStream());
            var9 = new ProcessOutputStreamReader("Diff Process - stderr", var7.getErrorStream());
            var8.start();
            var9.start();
            int var22 = var7.waitFor();
            var8.interruptThread();
            var9.interruptThread();
            handleExitCode(var22);
         } catch (DifferException var17) {
            throw var17;
         } catch (IOException var18) {
            throw new DifferException(var18, String.format("Couldn\'t start diffing process. Exit code %d.", new Object[]{Integer.valueOf(var6)}));
         } catch (InterruptedException var19) {
            throw new DifferException(var19, String.format("Diffing process was interruped unexpectedly. Exit code %d.", new Object[]{Integer.valueOf(var6)}));
         } catch (Exception var20) {
            throw new DifferException(var20, String.format("Diffing process failed. Exit code %d.", new Object[]{Integer.valueOf(var6)}));
         } finally {
            if(var8 != null) {
               var8.interruptThread();
            }

            if(var9 != null) {
               var9.interruptThread();
            }

         }

      }
   }
}
