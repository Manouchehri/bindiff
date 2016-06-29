package y.h;

import y.h.fj;
import y.h.t;
import y.h.u;
import y.h.v;

public class s implements y.f.E {
   private double a = 0.0D;
   private double b = 0.5D;
   private double c = 0.5D;
   private double d;
   private double e = 0.0D;
   private double f = 1.0D;

   public double a() {
      return this.f;
   }

   public double b() {
      return this.d;
   }

   public double d() {
      return this.b;
   }

   public double e() {
      return this.c;
   }

   public double f() {
      return this.a;
   }

   public void a(double var1) {
      this.a = var1;
   }

   public Object c() {
      return new u(0.5D, -1);
   }

   public y.d.n a(y.d.q var1, y.f.I var2, y.f.am var3, y.f.am var4, Object var5) {
      if(!(var5 instanceof u)) {
         var5 = this.c();
      }

      u var6 = (u)var5;
      v var7 = new v((t)null);
      this.a(var2, var3, var4, var6, var7);
      return this.a(var1.a, var1.b, var7);
   }

   private y.d.n a(double var1, double var3, v var5) {
      double var6 = var5.c + this.b();
      double var8 = Math.sin(var6);
      double var10 = -Math.cos(var6);
      double var12 = var3 * (this.e() - 1.0D);
      double var14 = -var1 * this.d();
      double var16 = var5.a + var8 * var12 - var10 * var14;
      double var18 = var5.b + var10 * var12 + var8 * var14;
      return new y.d.n(var16, var18, var1, var3, var8, var10);
   }

   protected y.d.v a(y.f.I var1, y.f.am var2, y.f.am var3) {
      return y.f.ae.a(var1, var2, var3, this.e);
   }

   private void a(y.f.I var1, y.f.am var2, y.f.am var3, u var4, v var5) {
      boolean var25 = fj.z;
      int var10 = var4.b();
      y.d.v var11 = this.a(var1, var2, var3);
      double var6;
      double var8;
      y.d.t var13;
      double var14;
      if(var11.h() <= 0) {
         double var16;
         label58: {
            y.d.t var12 = var1.getSourcePoint();
            var13 = var1.getTargetPoint();
            var6 = var12.a * (1.0D - var4.a()) + var13.a * var4.a();
            var8 = var12.b * (1.0D - var4.a()) + var13.b * var4.a();
            var14 = var13.a - var12.a;
            var16 = var13.b - var12.b;
            double var18 = Math.sqrt(var14 * var14 + var16 * var16);
            if(var18 > 0.0D) {
               var14 /= var18;
               var16 /= var18;
               if(!var25) {
                  break label58;
               }
            }

            var14 = 1.0D;
            var16 = 0.0D;
         }

         this.a(var5, var6, var8, var14, var16);
         if(!var25) {
            return;
         }
      }

      double var19;
      if(var10 < 0) {
         double var26 = var11.k();
         var14 = var26 * var4.a();
         y.d.u var29 = var11.b();
         y.d.t var17 = var29.a();
         var26 = 0.0D;
         var29.g();

         label48: {
            while(var29.f()) {
               y.d.t var31 = var29.a();
               var19 = var31.a - var17.a;
               double var21 = var31.b - var17.b;
               double var23 = Math.sqrt(var19 * var19 + var21 * var21);
               if(var25) {
                  break label48;
               }

               if(var26 + var23 >= var14) {
                  label29: {
                     var14 -= var26;
                     var14 /= var23;
                     var6 = var17.a * (1.0D - var14) + var31.a * var14;
                     var8 = var17.b * (1.0D - var14) + var31.b * var14;
                     if(var23 > 0.0D) {
                        var19 /= var23;
                        var21 /= var23;
                        if(!var25) {
                           break label29;
                        }
                     }

                     var19 = 1.0D;
                     var21 = 0.0D;
                  }

                  this.a(var5, var6, var8, var19, var21);
                  return;
               }

               var17 = var31;
               var26 += var23;
               var29.g();
               if(var25) {
                  break;
               }
            }

            this.a(var5, var17.a, var17.b, 1.0D, 0.0D);
         }

         if(!var25) {
            return;
         }
      }

      double var15;
      double var30;
      label35: {
         y.d.m var27 = var11.a(Math.min(var10, var11.h() - 2));
         var13 = var27.c();
         y.d.t var28 = var27.d();
         var6 = var13.a * (1.0D - var4.a()) + var28.a * var4.a();
         var8 = var13.b * (1.0D - var4.a()) + var28.b * var4.a();
         var15 = var28.a - var13.a;
         var30 = var28.b - var13.b;
         var19 = Math.sqrt(var15 * var15 + var30 * var30);
         if(var19 > 0.0D) {
            var15 /= var19;
            var30 /= var19;
            if(!var25) {
               break label35;
            }
         }

         var15 = 1.0D;
         var30 = 0.0D;
      }

      this.a(var5, var6, var8, var15, var30);
   }

   void a(v var1, double var2, double var4, double var6, double var8) {
      double var10 = this.f();
      var1.a = var2 - var8 * var10;
      var1.b = var4 + var6 * var10;
      var1.c = this.a(var6, var8);
   }

   protected double a(double var1, double var3) {
      return Math.atan2(var3, var1);
   }

   public y.c.D a(y.f.C var1, y.f.I var2, y.f.am var3, y.f.am var4) {
      boolean var36 = fj.z;
      y.c.D var5 = new y.c.D();
      y.d.n var6 = var1.getOrientedBox();
      v var7 = new v((t)null);
      y.d.v var8 = this.a(var2, var3, var4);
      int var9 = 0;
      double var10 = this.a();
      double var12 = var6.e();
      double var14 = var6.f();
      y.d.n var16 = new y.d.n(0.0D, 0.0D, var12, var14);
      var16.a(-this.b());
      double var17 = var16.h().a();
      y.d.s var19 = var8.j();

      int var10000;
      while(true) {
         if(var19.f()) {
            y.d.t var20 = var19.a().c();
            y.d.t var21 = var19.a().d();
            double var22 = var19.a().g();
            double var38;
            var10000 = (var38 = var22 - 0.1D) == 0.0D?0:(var38 < 0.0D?-1:1);
            if(var36) {
               break;
            }

            if(var10000 > 0) {
               double var24 = var21.a - var20.a;
               double var26 = var21.b - var20.b;
               this.a(var7, var20.a, var20.b, var24 / var22, var26 / var22);
               u var28 = new u(0.0D, var9);
               var5.add(new y.f.Q(this.a(var12, var14, var7), var28, var1, false));
               int var29 = Math.min(100, (int)Math.floor(var10 * var22 / var17));
               double var30 = var29 == 0?1.0D:1.0D / (double)var29;
               double var32 = var30;
               int var34 = 0;
               int var35 = var29 - 1;

               while(true) {
                  if(var34 < var35) {
                     this.a(var7, var20.a * (1.0D - var32) + var21.a * var32, var20.b * (1.0D - var32) + var21.b * var32, var24 / var22, var26 / var22);
                     var28 = new u(var32, var9);
                     var5.add(new y.f.Q(this.a(var12, var14, var7), var28, var1, false));
                     var32 += var30;
                     ++var34;
                     if(var36) {
                        break;
                     }

                     if(!var36) {
                        continue;
                     }
                  }

                  this.a(var7, var21.a, var21.b, var24 / var22, var26 / var22);
                  var28 = new u(1.0D, var9);
                  break;
               }

               var5.add(new y.f.Q(this.a(var12, var14, var7), var28, var1, false));
            }

            var19.g();
            ++var9;
            if(!var36) {
               continue;
            }
         }

         var10000 = var5.isEmpty();
         break;
      }

      if(var10000 != 0) {
         u var37 = (u)this.c();
         this.a(var2, var3, var4, var37, var7);
         var5.add(new y.f.Q(this.a(var12, var14, var7), var37, var1, false));
      }

      return var5;
   }

   public Object a(y.d.n var1, y.f.I var2, y.f.am var3, y.f.am var4) {
      return this.c();
   }
}
