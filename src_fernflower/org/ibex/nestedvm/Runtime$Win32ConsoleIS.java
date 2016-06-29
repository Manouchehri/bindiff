package org.ibex.nestedvm;

import java.io.InputStream;

class Runtime$Win32ConsoleIS extends InputStream {
   private int pushedBack = -1;
   private final InputStream parent;

   public Runtime$Win32ConsoleIS(InputStream var1) {
      this.parent = var1;
   }

   public int read() {
      int var1;
      if(this.pushedBack != -1) {
         var1 = this.pushedBack;
         this.pushedBack = -1;
         return var1;
      } else {
         var1 = this.parent.read();
         if(var1 == 13 && (var1 = this.parent.read()) != 10) {
            this.pushedBack = var1;
            return 13;
         } else {
            return var1;
         }
      }
   }

   public int read(byte[] var1, int var2, int var3) {
      boolean var4 = false;
      if(this.pushedBack != -1 && var3 > 0) {
         var1[0] = (byte)this.pushedBack;
         this.pushedBack = -1;
         ++var2;
         --var3;
         var4 = true;
      }

      int var5 = this.parent.read(var1, var2, var3);
      if(var5 == -1) {
         return var4?1:-1;
      } else {
         for(int var6 = 0; var6 < var5; ++var6) {
            if(var1[var2 + var6] == 13) {
               if(var6 == var5 - 1) {
                  int var7 = this.parent.read();
                  if(var7 == 10) {
                     var1[var2 + var6] = 10;
                  } else {
                     this.pushedBack = var7;
                  }
               } else if(var1[var2 + var6 + 1] == 10) {
                  System.arraycopy(var1, var2 + var6 + 1, var1, var2 + var6, var3 - var6 - 1);
                  --var5;
               }
            }
         }

         return var5 + (var4?1:0);
      }
   }
}
