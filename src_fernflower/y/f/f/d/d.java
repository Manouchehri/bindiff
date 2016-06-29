package y.f.f.d;

import java.awt.Dimension;
import y.f.X;
import y.f.f.d.M;
import y.f.f.d.f;
import y.f.f.d.o;
import y.f.f.d.t;

class d implements M {
   private y.f.f.b.h a;
   private y.c.A b;
   private y.c.A c;
   private y.c.A d;
   private int e;
   private int f;

   public d(int var1) {
      this.f = var1;
   }

   public void a(y.f.f.b.h var1) {
      boolean var26 = o.p;
      y.g.o.a(this, "Prescribed size model !");
      this.a = var1;
      X var2 = (X)var1.a();
      this.b = var2.t();
      this.c = var2.t();
      this.d = var2.t();
      double var3 = (double)this.f;
      y.c.c var5 = var2.c(t.a);
      y.c.c var6 = var2.c("MIN_DIST_DP_KEY");
      y.c.x var7 = var2.o();

      y.c.q var8;
      int var11;
      int var12;
      int var13;
      int var10000;
      while(true) {
         if(var7.f()) {
            var8 = var7.e();
            var10000 = var1.d(var8);
            if(var26) {
               break;
            }

            label128: {
               if(var10000 != 0) {
                  this.b.a(var8, true);
                  int[][] var9 = var1.i(var8);
                  int[] var10 = new int[4];
                  var11 = 0;

                  int var14;
                  label124:
                  do {
                     var10000 = var11;
                     int var10001 = 4;

                     do {
                        if(var10000 >= var10001) {
                           break label124;
                        }

                        var12 = var9[var11][0];
                        var13 = var9[var11][2];
                        var10000 = var12;
                        var10001 = var13;
                     } while(var26);

                     label140: {
                        if(var12 == var13) {
                           var10[var11] = var12;
                           if(!var26) {
                              break label140;
                           }
                        }

                        var14 = var12 < var13?var13:var12;
                        var10[var11] = Math.max(0, var14 - (1 - var9[var11][1]));
                     }

                     ++var11;
                  } while(!var26);

                  var11 = 0;
                  if(var5 != null) {
                     var11 = var5.a(var8);
                  }

                  var12 = 0;
                  var13 = 0;
                  var14 = 0;
                  int var15 = 0;
                  if(var6 != null) {
                     f var16 = (f)var6.b(var8);
                     if(var16 != null) {
                        var12 = var16.a();
                        var13 = var16.b();
                        var14 = var16.c();
                        var15 = var16.d();
                     }
                  }

                  int var31 = var10[1] > var10[3]?var10[1]:var10[3];
                  int var17 = var10[0] > var10[2]?var10[0]:var10[2];
                  double var18 = (var2.p(var8) - (double)var14 - (double)var15) / 2.0D;
                  double var20 = (var2.q(var8) - (double)var12 - (double)var13) / 2.0D;
                  if((double)var11 > Math.min(var18, var20)) {
                     var11 = (int)Math.floor(Math.min(var18, var20));
                  }

                  var18 -= (double)var11;
                  var20 -= (double)var11;
                  double var22 = 2.147483647E9D;
                  double var24 = 2.147483647E9D;
                  if(var31 > 0) {
                     var24 = var20 / (double)var31;
                  }

                  if(var24 < var3) {
                     var3 = var24;
                  }

                  if(var17 > 0) {
                     var22 = var18 / (double)var17;
                  }

                  if(var22 >= var3) {
                     break label128;
                  }

                  var3 = var22;
                  if(!var26) {
                     break label128;
                  }
               }

               this.b.a(var8, false);
            }

            var7.g();
            if(!var26) {
               continue;
            }
         }

         double var35;
         var10000 = (var35 = var3 - 0.0D) == 0.0D?0:(var35 < 0.0D?-1:1);
         break;
      }

      if(var10000 == 0) {
         var3 = 1.0D;
      }

      label90: {
         if(var3 > 1.0D) {
            var3 = Math.floor(var3);
            if(!var26) {
               break label90;
            }
         }

         var3 = 1.0D / Math.ceil(1.0D / var3);
      }

      this.e = (int)Math.ceil((double)this.f / var3);
      var3 = (double)this.f / (double)this.e;
      var7 = var2.o();

      while(var7.f()) {
         var8 = var7.e();
         if(var1.d(var8)) {
            int var27 = 0;
            if(var5 != null) {
               var27 = var5.a(var8);
            }

            int var28 = 0;
            var11 = 0;
            var12 = 0;
            var13 = 0;
            if(var6 != null) {
               f var29 = (f)var6.b(var8);
               if(var29 != null) {
                  var28 = var29.a();
                  var11 = var29.b();
                  var12 = var29.c();
                  var13 = var29.d();
               }
            }

            double var30 = var2.p(var8) / 2.0D;
            double var32 = var2.q(var8) / 2.0D;
            int var33 = (int)Math.ceil(var30 / (double)this.f) * 2;
            int var19 = (int)Math.ceil(var32 / (double)this.f) * 2;
            if((double)var27 > Math.min((2.0D * var30 - (double)var12 - (double)var13) / 2.0D, (2.0D * var32 - (double)var28 - (double)var11) / 2.0D)) {
               var27 = (int)Math.floor(Math.min((2.0D * var30 - (double)var12 - (double)var13) / 2.0D, (2.0D * var32 - (double)var28 - (double)var11) / 2.0D));
            }

            int var34 = (int)((double)(var33 * this.e / 2) - Math.floor((var30 - (double)var27) / var3));
            int var21 = (int)((double)(var19 * this.e / 2) - Math.floor((var32 - (double)var27) / var3));
            this.d.a(var8, new Dimension(var34, var21));
            this.c.a(var8, new Dimension(var33, var19));
         }

         var7.g();
         if(var26) {
            break;
         }
      }

   }

   public boolean a() {
      return false;
   }

   public int e(y.c.q var1) {
      Dimension var2 = (Dimension)this.d.b(var1);
      return var2.width;
   }

   public int f(y.c.q var1) {
      Dimension var2 = (Dimension)this.d.b(var1);
      return var2.height;
   }

   public boolean a(y.c.q var1) {
      return this.b.d(var1);
   }

   public int b(y.c.q var1) {
      Dimension var2 = (Dimension)this.c.b(var1);
      return var2.width;
   }

   public int c(y.c.q var1) {
      Dimension var2 = (Dimension)this.c.b(var1);
      return var2.height;
   }

   public boolean d(y.c.q var1) {
      return this.a(var1);
   }

   public double b() {
      return (double)this.e;
   }

   public boolean c() {
      return true;
   }

   public void d() {
      this.a.a().a(this.b);
      this.a.a().a(this.c);
      this.a.a().a(this.d);
   }
}
