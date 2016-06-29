package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import java.io.File;
import java.io.IOException;

public class DiffDirectories {
   private static File getDiffsSubDirectory(Diff var0, String var1) {
      File var2 = var0.getMatchesDatabase();
      String var3 = String.format("%s%s%s - %s", new Object[]{var2.getParent(), File.separator, var1, var2.getName()});
      return new File(var3);
   }

   public static File createDiffCommentsDirectory(Diff var0) {
      File var1 = getDiffCommentsDirectory(var0);
      if(!var1.exists() && !var1.mkdir()) {
         Logger.logSevere("Severe: Couldn\'t create diffs comments folder. Save view comment failed.", new Object[0]);
         throw new IOException("Couldn\'t create diffs comments folder. Save view comment failed.");
      } else {
         return var1;
      }
   }

   public static File createDiffDirectory(File var0, File var1) {
      String var2 = String.format("%s%s%s", new Object[]{var0.getPath(), File.separator, var1.getName()});
      File var3 = new File(var2);
      var3.mkdir();
      if(!var3.exists()) {
         throw new IOException();
      } else {
         return var3;
      }
   }

   public static File createDiffReportsDirectory(Diff var0) {
      File var1 = getDiffReportsDirectory(var0);
      if(!var1.exists() && !var1.mkdir()) {
         Logger.logSevere("Severe: Couldn\'t create diffs reports folder. Generate report failed.", new Object[0]);
         throw new IOException("Couldn\'t create diffs reports folder. Generate report failed.");
      } else {
         return var1;
      }
   }

   public static File createDiffViewsDirectory(Diff var0) {
      File var1 = getDiffViewsDirectory(var0);
      if(!var1.exists() && !var1.mkdir()) {
         Logger.logSevere("Severe: Couldn\'t create views folder. Save view failed.", new Object[0]);
         throw new IOException("Couldn\'t create user views folder. Save view failed.");
      } else {
         return var1;
      }
   }

   public static File getBinExportFile(File var0, DiffMetaData var1, ESide var2) {
      return new File(String.format("%s%s%s.%s", new Object[]{var0.getParent(), File.separator, var1.getIdbName(var2), "BinExport"}));
   }

   public static File getDiffCommentsDirectory(Diff var0) {
      return getDiffsSubDirectory(var0, "Comments");
   }

   public static String getDiffDestinationDirectoryName(String var0, String var1) {
      // $FF: Couldn't be decompiled
   }

   public static File getDiffDirectory(File var0, File var1) {
      return new File(String.format("%s%s%s", new Object[]{var0.getPath(), File.separator, var1.getName()}));
   }

   public static File getDiffDirectoryFile(String var0, String var1, String var2) {
      return new File(String.format("%s%s%s vs %s", new Object[]{var0, File.separator, var1, var2}));
   }

   public static File getDiffReportsDirectory(Diff var0) {
      return getDiffsSubDirectory(var0, "Reports");
   }

   public static File getDiffViewsDirectory(Diff var0) {
      return getDiffsSubDirectory(var0, "Views");
   }
}
