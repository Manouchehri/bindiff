package y.f.c.a;

import y.f.c.a.B;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bK;
import y.f.c.a.bM;
import y.f.c.a.bN;
import y.f.c.a.bs;
import y.f.c.a.cB;
import y.f.c.a.cc;
import y.f.c.a.cp;
import y.f.c.a.z;

public class q implements z {
   private static final double a = Math.sqrt(2.0D);
   private double b = 30.0D;
   private double c = 15.0D;
   private double d = 20.0D;
   private boolean e = true;
   private bM f = new bM();
   private cc g = new cc();
   private bN h = new bN();
   private cp i = new cp();
   private boolean j;

   public void a(y.f.X var1, aU var2, aV var3) {
      this.f.c(this.c());
      this.f.a(this.a());
      this.f.b(this.b());
      this.f.a(var1, var2, var3);
      this.g.a(Math.max(this.c(), this.b()));
      this.g.a(var1, var2, var3);
      this.h.a(var1, var2, var3);
      this.i.a(var1, var2, var3);
   }

   public void b(y.f.X var1, aU var2, aV var3) {
      this.f.b(var1, var2, var3);
      this.g.b(var1, var2, var3);
      this.h.b(var1, var2, var3);
      this.i.b(var1, var2, var3);
   }

   private double b(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      double var6 = 0.0D;
      aX var8;
      byte var9;
      boolean var10;
      y.c.q var11;
      y.c.d var12;
      B var13;
      bs var14;
      boolean var15;
      double var16;
      if(var4 != null) {
         var8 = var3.a(var4);
         var9 = var8.b();
         var10 = var9 == 8 || var9 == 9;
         if(var10 || var9 == 3 || var9 == 2) {
            var11 = var8.f();
            var12 = var8.g();
            var13 = var3.a(var12).k();
            if(var13 != null && var1.j(var4) < var1.j(var11)) {
               var14 = var13.h();
               var15 = var10 && var14.a() == 1 || var9 == 3 && var14.d() == 1 || var9 == 2 && var14.c() == 1;
               if(var15) {
                  var16 = var13.i() / a;
                  var6 += var10?2.0D * var16:var16;
               }
            }
         }
      }

      if(var5 != null) {
         var8 = var3.a(var5);
         var9 = var8.b();
         var10 = var9 == 8 || var9 == 9;
         if(var10 || var9 == 3 || var9 == 2) {
            var11 = var8.f();
            var12 = var8.g();
            var13 = var3.a(var12).k();
            if(var13 != null && var1.j(var5) > var1.j(var11)) {
               var14 = var13.h();
               var15 = var10 && var14.a() == 1 || var9 == 3 && var14.d() == 1 || var9 == 2 && var14.c() == 1;
               if(var15) {
                  var16 = var13.i() / a;
                  var6 += var10?2.0D * var16:var16;
               }
            }
         }
      }

      return var6;
   }

   public double a(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      aX var6 = var4 != null?var3.a(var4):null;
      aX var7 = var5 != null?var3.a(var5):null;
      if(var4 == null || var5 == null) {
         if(var4 != null && var6.b() == 15) {
            return this.c();
         }

         if(var5 != null && var7.b() == 15) {
            return this.c();
         }
      }

      if(this.j && var4 != null && var5 != null) {
         bK var10 = var6.h();
         bK var11 = var7.h();
         if(var10 != null && var11 != null && var10.j() != var11.j()) {
            return 0.0D;
         }
      }

      double var8 = this.e?this.g.a(var1, var2, var3, var4, var5):0.0D;
      if(var8 > this.c()) {
         var8 = 0.0D;
      }

      if(var8 == Double.MAX_VALUE || var8 <= 0.0D) {
         var8 = this.f.a(var1, var2, var3, var4, var5);
      }

      var8 = Math.max(var8, var8 + this.h.a(var1, var2, var3, var4, var5));
      var8 = Math.max(var8, this.i.a(var1, var2, var3, var4, var5));
      cB var13 = cB.b((y.c.i)var1);
      if(var13 != null) {
         var8 = Math.max(var8, var13.a(var1, var3, var4, var5));
      }

      double var14 = this.b(var1, var2, var3, var4, var5);
      var8 = Math.max(var8, var8 + var14);
      return var8;
   }

   public double a() {
      return this.b;
   }

   public void a(double var1) {
      this.b = var1;
   }

   public double b() {
      return this.c;
   }

   public void b(double var1) {
      this.c = var1;
   }

   public double c() {
      return this.d;
   }

   public void c(double var1) {
      this.d = var1;
   }
}
