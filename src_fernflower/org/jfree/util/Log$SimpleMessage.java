package org.jfree.util;

public class Log$SimpleMessage {
   private String message;
   private Object[] param;

   public Log$SimpleMessage(String var1, Object var2) {
      this.message = var1;
      this.param = new Object[]{var2};
   }

   public Log$SimpleMessage(String var1, Object var2, Object var3) {
      this.message = var1;
      this.param = new Object[]{var2, var3};
   }

   public Log$SimpleMessage(String var1, Object var2, Object var3, Object var4) {
      this.message = var1;
      this.param = new Object[]{var2, var3, var4};
   }

   public Log$SimpleMessage(String var1, Object var2, Object var3, Object var4, Object var5) {
      this.message = var1;
      this.param = new Object[]{var2, var3, var4, var5};
   }

   public Log$SimpleMessage(String var1, Object[] var2) {
      this.message = var1;
      this.param = var2;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append(this.message);
      if(this.param != null) {
         for(int var2 = 0; var2 < this.param.length; ++var2) {
            var1.append(this.param[var2]);
         }
      }

      return var1.toString();
   }
}
