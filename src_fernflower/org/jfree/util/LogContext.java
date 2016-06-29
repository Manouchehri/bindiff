package org.jfree.util;

import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;

public class LogContext {
   private String contextPrefix;

   public LogContext(String var1) {
      this.contextPrefix = var1;
   }

   public boolean isDebugEnabled() {
      return Log.isDebugEnabled();
   }

   public boolean isInfoEnabled() {
      return Log.isInfoEnabled();
   }

   public boolean isWarningEnabled() {
      return Log.isWarningEnabled();
   }

   public boolean isErrorEnabled() {
      return Log.isErrorEnabled();
   }

   public void debug(Object var1) {
      this.log(3, var1);
   }

   public void debug(Object var1, Exception var2) {
      this.log(3, var1, var2);
   }

   public void info(Object var1) {
      this.log(2, var1);
   }

   public void info(Object var1, Exception var2) {
      this.log(2, var1, var2);
   }

   public void warn(Object var1) {
      this.log(1, var1);
   }

   public void warn(Object var1, Exception var2) {
      this.log(1, var1, var2);
   }

   public void error(Object var1) {
      this.log(0, var1);
   }

   public void error(Object var1, Exception var2) {
      this.log(0, var1, var2);
   }

   public void log(int var1, Object var2) {
      if(this.contextPrefix != null) {
         Log.getInstance().doLog(var1, new Log$SimpleMessage(this.contextPrefix, ":", var2));
      } else {
         Log.getInstance().doLog(var1, var2);
      }

   }

   public void log(int var1, Object var2, Exception var3) {
      if(this.contextPrefix != null) {
         Log.getInstance().doLog(var1, new Log$SimpleMessage(this.contextPrefix, ":", var2), var3);
      } else {
         Log.getInstance().doLog(var1, var2, var3);
      }

   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof LogContext)) {
         return false;
      } else {
         LogContext var2 = (LogContext)var1;
         if(this.contextPrefix != null) {
            if(!this.contextPrefix.equals(var2.contextPrefix)) {
               return false;
            }
         } else if(var2.contextPrefix != null) {
            return false;
         }

         return true;
      }
   }

   public int hashCode() {
      return this.contextPrefix != null?this.contextPrefix.hashCode():0;
   }
}
