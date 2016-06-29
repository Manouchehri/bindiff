package com.google.common.io;

abstract class LineBuffer {
   private StringBuilder line = new StringBuilder();
   private boolean sawReturn;

   protected void add(char[] var1, int var2, int var3) {
      int var4 = var2;
      if(this.sawReturn && var3 > 0 && this.finishLine(var1[var2] == 10)) {
         var4 = var2 + 1;
      }

      int var5 = var4;

      for(int var6 = var2 + var3; var4 < var6; ++var4) {
         switch(var1[var4]) {
         case '\n':
            this.line.append(var1, var5, var4 - var5);
            this.finishLine(true);
            var5 = var4 + 1;
            break;
         case '\r':
            this.line.append(var1, var5, var4 - var5);
            this.sawReturn = true;
            if(var4 + 1 < var6 && this.finishLine(var1[var4 + 1] == 10)) {
               ++var4;
            }

            var5 = var4 + 1;
         }
      }

      this.line.append(var1, var5, var2 + var3 - var5);
   }

   private boolean finishLine(boolean var1) {
      this.handleLine(this.line.toString(), this.sawReturn?(var1?"\r\n":"\r"):(var1?"\n":""));
      this.line = new StringBuilder();
      this.sawReturn = false;
      return var1;
   }

   protected void finish() {
      if(this.sawReturn || this.line.length() > 0) {
         this.finishLine(false);
      }

   }

   protected abstract void handleLine(String var1, String var2);
}
