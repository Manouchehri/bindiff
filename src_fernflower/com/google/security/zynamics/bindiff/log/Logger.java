package com.google.security.zynamics.bindiff.log;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.log.LogFormatter;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.io.FileUtils;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;

public class Logger {
   private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("BinDiff");
   private static FileHandler fileHandler = null;
   private static LogFormatter formatter = null;
   private static boolean logInfo = false;
   private static boolean logVerbose = false;
   private static boolean logWarning = false;
   private static boolean logSevere = false;
   private static boolean logException = false;
   private static boolean enableFileLogger = false;
   private static boolean enableConsoleLogger = false;

   private static void logExceptionIntern(Level var0, Throwable var1, String var2) {
      // $FF: Couldn't be decompiled
   }

   private static boolean logIf(boolean var0) {
      return var0 && (enableFileLogger || enableConsoleLogger);
   }

   private static void logIf(boolean var0, Level var1, String var2, Object... var3) {
      if(var0) {
         java.util.logging.Logger var10000 = logger;
         String var4 = String.valueOf(var1.toString());
         String var5 = String.valueOf(String.format(var2, var3));
         var10000.log(var1, (new StringBuilder(2 + String.valueOf(var4).length() + String.valueOf(var5).length())).append(var4).append(": ").append(var5).toString());
      }
   }

   public static void addFileLogger(FileHandler var0) {
      if(fileHandler != null) {
         logger.removeHandler(var0);
      }

      fileHandler = var0;
      fileHandler.setFormatter(formatter);
   }

   public static void enableConsoleLogger(boolean var0) {
      logger.setUseParentHandlers(var0);
      enableConsoleLogger = var0;
   }

   public static void enableFileLogger(boolean var0) {
      Preconditions.checkArgument(fileHandler != null, "File handler cannot be null. Add a valid file handler first.");
      if(!var0) {
         logger.removeHandler(fileHandler);
      } else {
         logger.addHandler(fileHandler);
      }

      enableFileLogger = var0;
   }

   public static boolean getConsoleLogging() {
      return enableConsoleLogger;
   }

   public static String getDefaultLoggingDirectoryPath() {
      // $FF: Couldn't be decompiled
   }

   public static boolean getFileLogging() {
      return enableFileLogger;
   }

   public static boolean getLogExceptions() {
      return logException;
   }

   public static String getLoggingFilePath(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean getLogInfo() {
      return logInfo;
   }

   public static boolean getLogSevere() {
      return logSevere;
   }

   public static boolean getLogVerbose() {
      return logVerbose;
   }

   public static boolean getLogWarning() {
      return logWarning;
   }

   public static void logException(Level var0, Throwable var1, String var2) {
      if(logIf(logException)) {
         logExceptionIntern(var0, var1, var2);
      }

   }

   public static void logException(Throwable var0) {
      logException(var0, (String)null);
   }

   public static void logException(Throwable var0, String var1) {
      logException(Level.SEVERE, var0, var1);
   }

   public static void logInfo(String var0, Object... var1) {
      logIf(logIf(logInfo), Level.INFO, var0, var1);
   }

   public static void logSevere(String var0, Object... var1) {
      logIf(logIf(logSevere), Level.SEVERE, var0, var1);
   }

   public static void logVerbose(String var0, Object... var1) {
      logIf(logIf(logVerbose), Level.INFO, var0, var1);
   }

   public static void logWarning(Exception var0, String var1) {
      if(logIf(logWarning)) {
         logExceptionIntern(Level.WARNING, var0, var1);
      }

   }

   public static void logWarning(String var0, Object... var1) {
      logIf(logIf(logWarning), Level.WARNING, var0, var1);
   }

   public static void removeFileHandler() {
      if(fileHandler != null) {
         logger.removeHandler(fileHandler);
      }

      enableFileLogger = false;
   }

   public static void setLogExceptions(boolean var0) {
      logException = var0;
   }

   public static void setLogInfos(boolean var0) {
      logInfo = var0;
   }

   public static void setLogSevere(boolean var0) {
      logSevere = var0;
   }

   public static void setLogVerboseInfos(boolean var0) {
      logVerbose = var0;
   }

   public static void setLogWarnings(boolean var0) {
      logWarning = var0;
   }

   public static void setVeryVerboseLogging(boolean var0) {
      LogFormatter.setVerboseLogging(var0);
   }

   static {
      formatter = new LogFormatter();
      logger.setLevel(Level.INFO);
      logger.setUseParentHandlers(false);
      Handler[] var0 = logger.getParent().getHandlers();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         Handler var3 = var0[var2];
         var3.setFormatter(formatter);
      }

   }
}
