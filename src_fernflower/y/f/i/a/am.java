package y.f.i.a;

import y.f.i.a.ab;
import y.f.i.a.ai;

class am {
   private final int a;
   private final byte[] b;

   am(y.c.i var1) {
      this.a = 2 * var1.h();
      this.b = new byte[this.a * (this.a - 1) / 2];
   }

   int a() {
      return this.a;
   }

   void a(ai var1, ai var2, int var3) {
      boolean var4 = y.f.y.a == var1.h() || y.f.y.b == var1.h();
      boolean var5 = y.f.y.a == var2.h() || y.f.y.b == var2.h();
      int var6 = var1.i().b() + (var4?0:this.a / 2);
      int var7 = var2.i().b() + (var5?0:this.a / 2);
      this.a(var6, var7, var3);
      int var8 = var1.i().b() + (var4?this.a / 2:0);
      int var9 = var2.i().b() + (var5?this.a / 2:0);
      this.a(var8, var9, -var3);
   }

   void a(int var1, int var2, int var3) {
      int var4;
      if(var1 < var2) {
         var4 = var2;
         var2 = var1;
         var1 = var4;
         var3 = -var3;
      }

      var4 = var1 * (var1 - 1) / 2 + var2;
      byte var5 = this.b[var4];
      if(var3 > 0) {
         this.b[var4] = (byte)Math.min(var5 + var3, 127);
         if(ab.a == 0) {
            return;
         }
      }

      this.b[var4] = (byte)Math.max(var5 + var3, -128);
   }

   byte a(int var1, int var2) {
      return var1 < var2?(byte)(-this.b[var2 * (var2 - 1) / 2 + var1]):(var1 > var2?this.b[var1 * (var1 - 1) / 2 + var2]:0);
   }

   public String toString() {
      int var5 = ab.a;
      StringBuffer var1 = new StringBuffer();
      var1.append("Edge Order Matrix:\n");
      int var2 = 0;

      do {
         int var10000 = var2;
         int var10001 = this.a;

         label60:
         while(true) {
            if(var10000 >= var10001) {
               return var1.toString();
            }

            int var3;
            if(var2 == this.a / 2) {
               label72: {
                  var3 = 0;

                  while(var3 < this.a) {
                     var1.append("----");
                     ++var3;
                     if(var5 != 0) {
                        break label72;
                     }

                     if(var5 != 0) {
                        break;
                     }
                  }

                  var1.append("\n");
               }
            }

            var3 = 0;

            while(true) {
               if(var3 >= this.a) {
                  break label60;
               }

               var10000 = var3;
               var10001 = this.a / 2;
               if(var5 != 0) {
                  break;
               }

               if(var3 == var10001) {
                  var1.append("| ");
               }

               byte var4;
               label55: {
                  var4 = this.a(var3, var2);
                  if(var4 >= 0) {
                     var1.append("+");
                     if(var5 == 0) {
                        break label55;
                     }
                  }

                  var1.append("-");
               }

               if(Math.abs(var4) < 10) {
                  var1.append(0);
               }

               var1.append(Math.abs(var4));
               var1.append(" ");
               ++var3;
               if(var5 != 0) {
                  break label60;
               }
            }
         }

         var1.append("\n");
         ++var2;
      } while(var5 == 0);

      return var1.toString();
   }
}
