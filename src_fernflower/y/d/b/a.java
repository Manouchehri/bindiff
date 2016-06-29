package y.d.b;

import java.util.Comparator;
import y.d.b.c;
import y.d.b.u;

public class a {
   protected u a;
   private Object[] c;
   private Object[] d;
   private Object e;
   private Object f;
   private Object g;
   private Object h;
   int b;

   public a(Object[] var1, boolean var2, u var3) {
      boolean var4;
      int var11;
      label47: {
         var11 = c.a;
         super();
         this.a = var3;
         var4 = false;
         int var5 = this.a(var1);
         if(var2) {
            this.b = var5;
            if(var11 == 0) {
               break label47;
            }
         }

         this.b = 0;
         if(var5 == 1) {
            var4 = true;
         }
      }

      int var6 = var1.length;
      this.c = new Object[var6];
      this.d = new Object[var6];
      Comparator var7 = this.a.d();
      Comparator var8 = this.a.e();
      this.e = var1[0];
      this.f = var1[0];
      this.g = var1[0];
      this.h = var1[0];
      int var9 = 0;

      while(var9 < var6) {
         Object var10;
         label38: {
            var10 = var1[var9];
            if(var4) {
               this.c[var6 - var9 - 1] = var10;
               this.d[var6 - var9 - 1] = this.a.c(var10, var1[(var9 - 1) % var6]);
               if(var11 == 0) {
                  break label38;
               }
            }

            this.c[var9] = var10;
            this.d[var9] = this.a.c(var10, var1[(var9 + 1) % var6]);
         }

         if(var7.compare(var10, this.e) < 0) {
            this.e = var10;
         }

         if(var7.compare(var10, this.f) > 0) {
            this.f = var10;
         }

         if(var8.compare(var10, this.g) < 0) {
            this.g = var10;
         }

         if(var8.compare(var10, this.h) > 0) {
            this.h = var10;
         }

         ++var9;
         if(var11 != 0) {
            break;
         }
      }

   }

   public int a(Object var1) {
      int var15 = c.a;
      Comparator var2 = this.a.c();
      int var3 = var2.compare(var1, this.e);
      int var4 = var2.compare(var1, this.f);
      int var5 = var2.compare(var1, this.g);
      int var6 = var2.compare(var1, this.h);
      if(var3 >= 0 && var4 <= 0 && var5 >= 0 && var6 <= 0) {
         int var7 = 0;

         u var10000;
         while(true) {
            if(var7 < this.d.length) {
               var10000 = this.a;
               if(var15 != 0) {
                  break;
               }

               if(var10000.e(this.d[var7], var1)) {
                  return 0;
               }

               ++var7;
               if(var15 == 0) {
                  continue;
               }
            }

            var10000 = this.a;
            break;
         }

         Comparator var16 = var10000.d();
         int var8 = 0;
         int var9 = 0;

         int var17;
         while(true) {
            if(var9 < this.d.length) {
               Object var10 = this.d[var9];
               Object var11 = this.a.c(var10);
               Object var12 = this.a.d(var10);
               int var13 = var16.compare(var11, var12);
               var17 = var13;
               if(var15 != 0) {
                  break;
               }

               if(var13 != 0) {
                  if(var13 > 0) {
                     Object var14 = var11;
                     var11 = var12;
                     var12 = var14;
                  }

                  if(var16.compare(var11, var1) <= 0 && var16.compare(var1, var12) < 0 && this.a.c(var11, var12, var1) < 0) {
                     ++var8;
                  }
               }

               ++var9;
               if(var15 == 0) {
                  continue;
               }
            }

            var17 = var8 % 2;
            break;
         }

         return var17 == 0?2:1;
      } else {
         return 2;
      }
   }

   public int b(Object var1) {
      int var2 = this.a(var1);
      switch(var2) {
      case 0:
         return 0;
      case 1:
         return this.b == 0?1:-1;
      case 2:
         return this.b == 0?-1:1;
      default:
         throw new RuntimeException("Illegal return value of regionOf: " + var2);
      }
   }

   public int a() {
      return this.b;
   }

   protected int a(Object[] var1) {
      int var10 = c.a;
      int var2 = var1.length;
      Object var3 = var1[0];
      int var4 = 0;
      Comparator var5 = this.a.c();
      int var6 = 1;

      Object var7;
      int var10000;
      while(true) {
         if(var6 < var2) {
            var7 = var1[var6];
            var10000 = var5.compare(var7, var3);
            if(var10 != 0) {
               break;
            }

            if(var10000 < 0) {
               var3 = var7;
               var4 = var6;
            }

            ++var6;
            if(var10 == 0) {
               continue;
            }
         }

         var10000 = var4;
         break;
      }

      var6 = var10000 > 0?var4 - 1:var1.length - 1;
      var7 = var1[var6];
      boolean var8 = false;

      while(true) {
         Object var9 = var1[var4++ % var2];
         int var11 = this.a.c(var7, var3, var9);
         var10000 = var11;

         while(var10000 != 0 || var9 == var7) {
            var10000 = var11;
            if(var10 == 0) {
               return var11 >= 0?0:1;
            }
         }
      }
   }
}
