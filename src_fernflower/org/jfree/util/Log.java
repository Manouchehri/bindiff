package org.jfree.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.jfree.util.LogContext;
import org.jfree.util.LogTarget;

public class Log {
   private int debuglevel = 100;
   private LogTarget[] logTargets = new LogTarget[0];
   private HashMap logContexts = new HashMap();
   private static Log singleton;

   public static synchronized Log getInstance() {
      if(singleton == null) {
         singleton = new Log();
      }

      return singleton;
   }

   protected static synchronized void defineLog(Log var0) {
      singleton = var0;
   }

   public int getDebuglevel() {
      return this.debuglevel;
   }

   protected void setDebuglevel(int var1) {
      this.debuglevel = var1;
   }

   public synchronized void addTarget(LogTarget var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         LogTarget[] var2 = new LogTarget[this.logTargets.length + 1];
         System.arraycopy(this.logTargets, 0, var2, 0, this.logTargets.length);
         var2[this.logTargets.length] = var1;
         this.logTargets = var2;
      }
   }

   public synchronized void removeTarget(LogTarget var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         ArrayList var2 = new ArrayList();
         var2.addAll(Arrays.asList(this.logTargets));
         var2.remove(var1);
         LogTarget[] var3 = new LogTarget[var2.size()];
         this.logTargets = (LogTarget[])((LogTarget[])var2.toArray(var3));
      }
   }

   public LogTarget[] getTargets() {
      return (LogTarget[])((LogTarget[])this.logTargets.clone());
   }

   public synchronized void replaceTargets(LogTarget var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.logTargets = new LogTarget[]{var1};
      }
   }

   public static void debug(Object var0) {
      log(3, var0);
   }

   public static void debug(Object var0, Exception var1) {
      log(3, var0, var1);
   }

   public static void info(Object var0) {
      log(2, var0);
   }

   public static void info(Object var0, Exception var1) {
      log(2, var0, var1);
   }

   public static void warn(Object var0) {
      log(1, var0);
   }

   public static void warn(Object var0, Exception var1) {
      log(1, var0, var1);
   }

   public static void error(Object var0) {
      log(0, var0);
   }

   public static void error(Object var0, Exception var1) {
      log(0, var0, var1);
   }

   protected void doLog(int var1, Object var2) {
      if(var1 > 3) {
         var1 = 3;
      }

      if(var1 <= this.debuglevel) {
         for(int var3 = 0; var3 < this.logTargets.length; ++var3) {
            LogTarget var4 = this.logTargets[var3];
            var4.log(var1, var2);
         }
      }

   }

   public static void log(int var0, Object var1) {
      getInstance().doLog(var0, var1);
   }

   public static void log(int var0, Object var1, Exception var2) {
      getInstance().doLog(var0, var1, var2);
   }

   protected void doLog(int var1, Object var2, Exception var3) {
      if(var1 > 3) {
         var1 = 3;
      }

      if(var1 <= this.debuglevel) {
         for(int var4 = 0; var4 < this.logTargets.length; ++var4) {
            LogTarget var5 = this.logTargets[var4];
            var5.log(var1, var2, var3);
         }
      }

   }

   public void init() {
   }

   public static boolean isDebugEnabled() {
      return getInstance().getDebuglevel() >= 3;
   }

   public static boolean isInfoEnabled() {
      return getInstance().getDebuglevel() >= 2;
   }

   public static boolean isWarningEnabled() {
      return getInstance().getDebuglevel() >= 1;
   }

   public static boolean isErrorEnabled() {
      return getInstance().getDebuglevel() >= 0;
   }

   public static LogContext createContext(Class var0) {
      return createContext(var0.getName());
   }

   public static LogContext createContext(String var0) {
      return getInstance().internalCreateContext(var0);
   }

   protected LogContext internalCreateContext(String var1) {
      synchronized(this) {
         LogContext var3 = (LogContext)this.logContexts.get(var1);
         if(var3 == null) {
            var3 = new LogContext(var1);
            this.logContexts.put(var1, var3);
         }

         return var3;
      }
   }
}
