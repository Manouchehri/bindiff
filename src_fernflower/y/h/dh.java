package y.h;

import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;
import y.h.aA;
import y.h.ch;
import y.h.di;
import y.h.e;
import y.h.eR;
import y.h.fj;
import y.h.gw;
import y.h.gy;
import y.h.gz;

public class dh extends e {
   private y.f.al a;
   private fj b;
   private eR c;
   private boolean d;
   private y.d.n e;
   private double f;
   private double g;

   public dh() {
      this((ch)null);
   }

   public dh(ch var1) {
      super(var1);
      this.c(30.0D);
      this.b(5.0D);
      this.d = false;
   }

   public void f() {
      super.f();
      this.n();
   }

   private void n() {
      this.c = null;
      this.b = null;
      this.a = null;
      this.d = false;
      this.e = null;
   }

   public void a(y.d.t var1, aA var2) {
      this.n();
      this.a(var1);
      this.a(this.m());
      this.g();
      this.e = var2.getOrientedBox();
      this.d = true;
   }

   public void a(y.d.t var1, eR var2) {
      this.n();
      this.a(var1);
      this.a(this.l());
      this.g();
      this.c = var2;
      this.b = var2.g();
      this.e = var2.getOrientedBox();
      this.a = var2.a();
      this.d = true;
   }

   public y.d.t b(y.d.t var1) {
      y.c.D var2 = new y.c.D();
      y.f.al var3 = this.a;
      double var4;
      if(var3 instanceof gw) {
         var4 = ((gw)var3).a();
         this.a(var4, var1, var2);
         if(!fj.z) {
            return this.b(var2, var1);
         }
      }

      if(var3 instanceof y.f.M) {
         var4 = this.c.e();
         this.a(var4, var1, var2);
      }

      return this.b(var2, var1);
   }

   public y.d.t b(List var1, y.d.t var2) {
      this.h();
      return !this.d?var2:this.a((List)var1, (y.d.t)var2);
   }

   private void a(double var1, y.d.t var3, List var4) {
      y.d.n var5 = this.e;
      y.d.n var6 = new y.d.n(var5.h());
      var6.b(var6.e() + 2.0D * var1, var6.f() + 2.0D * var1);
      var6.b(var3);
      List var7 = this.o();
      if(var7 != null && !var7.isEmpty()) {
         this.a(var3, new y.d.t(var6.e() * 0.5D, var6.f() * 0.5D), var7, var4);
      }

      List var8 = this.p();
      if(var8 != null && !var8.isEmpty()) {
         this.a(var3, new y.d.t(var5.e() * 0.5D, var5.f() * 0.5D), var8, var4);
      }

      y.c.D var9 = new y.c.D();
      y.d.y var10 = this.c.getBox();
      double var11 = var10.c() + var10.a() * 0.5D;
      double var13 = var10.d() + var10.b() * 0.5D;
      y.d.t var15 = var5.k();
      var9.add(new di((byte)1, var15, Math.min(var15.b(), var13), Math.max(var15.b(), var13)));
      var9.add(new di((byte)0, var15, Math.min(var15.a(), var11), Math.max(var15.a(), var11)));
      this.a(var3, new y.d.t(var5.e() * 0.5D, var5.f() * 0.5D), var9, var4);
   }

   private void a(y.d.t var1, y.d.t var2, List var3, List var4) {
      boolean var19 = fj.z;
      double var5 = this.e() / this.c().getZoom();
      Iterator var7 = var3.iterator();

      while(var7.hasNext()) {
         gy var8 = (gy)var7.next();
         double var9;
         double var11;
         double var13;
         double var15;
         double var17;
         if(var8.c() == 1) {
            var9 = var8.b().a();
            var11 = var1.a();
            if(var8.d() == 16) {
               var13 = var9 - var11;
               if(Math.abs(var13) >= var5) {
                  continue;
               }

               var15 = var5 - Math.abs(var13);
               var4.add(gz.a(var15, var8, true, var11 + var13));
               if(!var19) {
                  continue;
               }
            }

            var13 = var2.a();
            if(var8.d() == 4) {
               var15 = var9 - (var11 + var13);
               if(Math.abs(var15) >= var5) {
                  continue;
               }

               var17 = var5 - Math.abs(var15);
               var4.add(gz.a(var17, var8, true, var11 + var15));
               if(!var19) {
                  continue;
               }
            }

            if(var8.d() != 8) {
               continue;
            }

            var15 = var9 - (var11 - var13);
            if(Math.abs(var15) >= var5) {
               continue;
            }

            var17 = var5 - Math.abs(var15);
            var4.add(gz.a(var17, var8, true, var11 + var15));
            if(!var19) {
               continue;
            }
         }

         var9 = var8.b().b();
         var11 = var1.b();
         if(var8.d() == 16) {
            var13 = var9 - var11;
            if(Math.abs(var13) >= var5) {
               continue;
            }

            var15 = var5 - Math.abs(var13);
            var4.add(gz.a(var15, var8, false, var11 + var13));
            if(!var19) {
               continue;
            }
         }

         var13 = var2.b();
         if(var8.d() == 1) {
            var15 = var9 - (var11 + var13);
            if(Math.abs(var15) >= var5) {
               continue;
            }

            var17 = var5 - Math.abs(var15);
            var4.add(gz.a(var17, var8, false, var11 + var15));
            if(!var19) {
               continue;
            }
         }

         if(var8.d() == 2) {
            var15 = var9 - (var11 - var13);
            if(Math.abs(var15) < var5) {
               var17 = var5 - Math.abs(var15);
               var4.add(gz.a(var17, var8, false, var11 + var15));
               if(var19) {
                  break;
               }
            }
         }
      }

   }

   private List o() {
      y.c.D var1 = new y.c.D();
      fj var2 = this.b;
      if(this.a(var2)) {
         double var3 = var2.getX();
         double var5 = var2.getY();
         double var7 = var2.getWidth();
         double var9 = var2.getHeight();
         double var11 = var3 + var7 * 0.5D;
         double var13 = var5 + var9 * 0.5D;
         y.d.t var15 = this.c.getOrientedBox().k();
         double var16 = var15.b();
         double var18 = Math.min(var13, var16);
         double var20 = Math.max(var13, var16);
         var1.add(b((byte)16, var11, var13, var18, var20));
         var1.add(b((byte)4, var3, var13, var18, var20));
         var1.add(b((byte)16, var3, var13, var18, var20));
         var1.add(b((byte)8, var3, var13, var18, var20));
         var1.add(b((byte)4, var3 + var7, var13, var18, var20));
         var1.add(b((byte)16, var3 + var7, var13, var18, var20));
         var1.add(b((byte)8, var3 + var7, var13, var18, var20));
         double var22 = var15.a();
         var18 = Math.min(var11, var22);
         var20 = Math.max(var11, var22);
         var1.add(a((byte)16, var11, var13, var18, var20));
         var1.add(a((byte)1, var11, var5, var18, var20));
         var1.add(a((byte)16, var11, var5, var18, var20));
         var1.add(a((byte)2, var11, var5, var18, var20));
         var1.add(a((byte)1, var11, var5 + var9, var18, var20));
         var1.add(a((byte)16, var11, var5 + var9, var18, var20));
         var1.add(a((byte)2, var11, var5 + var9, var18, var20));
      }

      return var1;
   }

   private List p() {
      boolean var29 = fj.z;
      y.c.D var1 = new y.c.D();
      fj var2 = this.b;
      y.d.n var3 = this.c.getOrientedBox();
      y.d.y var4 = this.c.getBox();
      double var5 = var4.c() + var4.a() * 0.5D;
      double var7 = var4.d() + var4.b() * 0.5D;
      int var9 = 0;

      while(var9 < var2.labelCount()) {
         eR var10 = var2.getLabel(var9);
         y.d.n var11 = var10.getOrientedBox();
         if(!var3.equals(var11) && this.a(var11)) {
            y.d.y var12 = var10.getBox();
            double var13 = var12.c();
            double var15 = var12.d();
            double var17 = var12.a();
            double var19 = var12.b();
            double var21 = var13 + var17 * 0.5D;
            double var23 = var15 + var19 * 0.5D;
            double var25 = Math.min(var23, var7);
            double var27 = Math.max(var23, var7);
            var1.add(b((byte)8, var13, var23, var25, var27));
            var1.add(b((byte)16, var21, var23, var25, var27));
            var1.add(b((byte)4, var13 + var17, var23, var25, var27));
            var25 = Math.min(var21, var5);
            var27 = Math.max(var21, var5);
            var1.add(a((byte)2, var21, var15, var25, var27));
            var1.add(a((byte)16, var21, var23, var25, var27));
            var1.add(a((byte)1, var21, var15 + var19, var25, var27));
         }

         ++var9;
         if(var29) {
            break;
         }
      }

      return var1;
   }

   private static gy a(byte var0, double var1, double var3, double var5, double var7) {
      return a((byte)0, var0, var1, var3, var5, var7);
   }

   private static gy b(byte var0, double var1, double var3, double var5, double var7) {
      return a((byte)1, var0, var1, var3, var5, var7);
   }

   private static gy a(byte var0, byte var1, double var2, double var4, double var6, double var8) {
      return new gy(var0, var1, new y.d.t(var2, var4), var6, var8, (Object)null, 1.0D);
   }

   private boolean a(y.d.n var1) {
      Rectangle2D var2 = this.c().getVisibleRect2D();
      return y.d.n.a(var1, new y.d.y(var2.getX(), var2.getY(), var2.getWidth(), var2.getHeight()), 0.0D);
   }

   public double l() {
      return this.f;
   }

   public void b(double var1) {
      this.f = var1;
   }

   public double m() {
      return this.g;
   }

   public void c(double var1) {
      this.g = var1;
   }
}
