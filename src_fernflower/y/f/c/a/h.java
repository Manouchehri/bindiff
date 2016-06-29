package y.f.c.a;

import y.f.c.a.N;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.f;
import y.f.c.a.i;

class h {
   private double[] a;
   private double[] b;
   private double c;
   private double d;
   private int e;
   private final f f;

   public h(f var1) {
      this.f = var1;
      this.a = new double[f.a(var1).f()];
      this.b = new double[f.a(var1).f()];
   }

   public void a(i var1, aU var2) {
      boolean var12 = N.x;
      aU var3 = var1.b();
      if(var3.b() != 0) {
         if(var2.b() == 0) {
            this.a((aU)var3, var2, 0);
            if(!var12) {
               return;
            }
         }

         double[][] var4 = var1.e();
         double var5 = 0.0D;
         int var7 = 0;
         int var8 = 0;

         while(var8 <= var2.b()) {
            y.d.q var9 = this.a(var4, var2, var8);
            if(var12) {
               return;
            }

            if(var9.a == this.d && var9.b == this.c) {
               var7 = var8;
               if(!var12) {
                  break;
               }
            }

            double var10 = var9.a / var9.b;
            if(var8 == 0 || f.a(this.f, var10, var5)) {
               var7 = var8;
               var5 = var10;
            }

            ++var8;
            if(var12) {
               break;
            }
         }

         this.a(var3, var2, var7);
      }
   }

   private y.d.q a(double[][] var1, aU var2, int var3) {
      boolean var16 = N.x;
      double var4 = this.c;
      double var6 = this.d;
      int var8 = var2.b();
      int var9 = 0;

      while(var9 < var1.length) {
         int var10 = var9 + var3;

         int var10000;
         while(true) {
            if(var8 <= var10) {
               var10000 = var8;
               if(var16) {
                  break;
               }

               if(var8 > 0) {
                  var4 += 30.0D;
               }

               ++var8;
               if(!var16) {
                  continue;
               }
            }

            double var17;
            var10000 = (var17 = this.b[var10] - 0.0D) == 0.0D?0:(var17 < 0.0D?-1:1);
            break;
         }

         boolean var11 = var10000 == 0 && this.a[var10] == 0.0D;
         double var12 = this.a[var10] + var1[var9][1] + (var11?0.0D:30.0D);
         var6 = Math.max(var6, var12);
         double var14 = var1[var9][0] - this.b[var10];
         if(var14 > 0.0D) {
            var4 += var14;
         }

         ++var9;
         if(var16) {
            break;
         }
      }

      return new y.d.q(var6, var4);
   }

   private void a(aU var1, aU var2, int var3) {
      boolean var12 = N.x;
      int var4 = 0;

      do {
         int var10000 = var4;

         int var6;
         double var8;
         label51:
         while(true) {
            aQ var5;
            label40:
            while(true) {
               if(var10000 >= var1.b()) {
                  return;
               }

               var5 = var1.a(var4);
               var6 = var4 + var3;

               while(true) {
                  if(var2.b() > var6) {
                     break label40;
                  }

                  var2.a(var5.e(), var2.b());
                  var10000 = this.e;
                  if(var12) {
                     break;
                  }

                  if(var10000 > 0) {
                     this.c += 30.0D;
                  }

                  ++this.e;
                  if(var12) {
                     break label40;
                  }
               }
            }

            aQ var7 = var2.a(var6);
            var8 = 0.0D;
            y.c.p var10 = var5.d().k();

            while(true) {
               if(var10 == null) {
                  break label51;
               }

               y.c.q var11 = (y.c.q)var10.c();
               var8 = Math.max(var8, f.a(this.f, var11));
               var10000 = var7.d().isEmpty();
               if(var12) {
                  break;
               }

               if(var10000 == 0) {
                  this.a[var6] += 30.0D;
               }

               this.a[var6] += f.b(this.f, var11);
               var7.a(var11);
               var10 = var10.a();
               if(var12) {
                  break label51;
               }
            }
         }

         double var13 = var8 - this.b[var6];
         if(var13 > 0.0D) {
            this.b[var6] += var13;
            this.c += var13;
         }

         this.d = Math.max(this.d, this.a[var6]);
         ++var4;
      } while(!var12);

   }
}
