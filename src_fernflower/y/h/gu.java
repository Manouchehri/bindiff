package y.h;

import y.h.aB;
import y.h.dE;
import y.h.dF;
import y.h.fj;
import y.h.gv;
import y.h.ik;
import y.h.in;

public class gu implements y.f.E, dF {
   private double a = 10.0D;
   private boolean b;
   private double c;
   private boolean d;

   public boolean b() {
      return this.b;
   }

   public boolean d() {
      return this.d;
   }

   public double e() {
      return this.c;
   }

   public double f() {
      return this.a;
   }

   public Object c() {
      return new gv(this.f(), this.e());
   }

   private static ik g() {
      return new ik();
   }

   public y.d.n a(y.d.q var1, y.f.I var2, y.f.am var3, y.f.am var4, Object var5) {
      gv var6 = (gv)(var5 == null?this.c():var5);
      ik var7 = g();
      this.a(var7, var6, this.b());
      return var7.a(var1, var2, var3, var4, var6);
   }

   private void a(ik var1, gv var2, boolean var3) {
      this.a(var1, var2.e(), var2, var3);
   }

   private void a(ik var1, byte var2, gv var3, boolean var4) {
      var1.c(var3.d());
      var1.b(var3.f());
      var1.a(var3.c());
      var1.a(var4);
      var1.b(this.d());
      var1.a(var2);
   }

   private void a(ik var1, byte var2, y.d.n var3, boolean var4, boolean var5, gv var6, boolean var7) {
      if(var5 || var6 == null) {
         var1.c(var4);
         var1.b(6.283185307179586D - var3.j());
         var1.a(this.f());
         var1.a(var7);
         var1.b(this.d());
         var1.a(var2);
         if(!fj.z) {
            return;
         }
      }

      this.a(var1, var2, var6, var7);
   }

   public y.c.D a(y.f.C var1, y.f.I var2, y.f.am var3, y.f.am var4) {
      gv var6;
      label11: {
         Object var5 = var1.getModelParameter();
         if(var5 instanceof gv) {
            var6 = (gv)var5;
            if(!fj.z) {
               break label11;
            }
         }

         var6 = (gv)this.c();
      }

      y.c.D var7 = new y.c.D();
      ik var8 = g();
      this.a(var8, (byte)0, var6, this.b());
      var7.a(var8.a((y.f.C)var1, var2, var3, var4, (Object)var6));
      this.a(var8, (byte)2, var6, this.b());
      var7.a(var8.a((y.f.C)var1, var2, var3, var4, (Object)var6));
      this.a(var8, (byte)1, var6, this.b());
      var7.a(var8.a((y.f.C)var1, var2, var3, var4, (Object)var6));
      return var7;
   }

   public Object a(y.d.n var1, y.f.I var2, y.f.am var3, y.f.am var4) {
      if(a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         return this.a(var1, var2, var3, var4, (gv)null, (byte)0, true);
      }
   }

   public Object b(y.d.n var1, y.f.I var2, y.f.am var3, y.f.am var4) {
      if(a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         return this.a(var1, var2, var3, var4, (gv)null, (byte)0, false);
      }
   }

   public dE a() {
      return new in(this);
   }

   private gv a(y.d.n var1, y.f.I var2, y.f.am var3, y.f.am var4, gv var5, byte var6, boolean var7) {
      boolean var8;
      boolean var9;
      boolean var10;
      ik var11;
      gv var12;
      double var13;
      double var15;
      label104: {
         var8 = !var7 && this.b();
         var9 = var7 && this.b();
         var10 = c(var1, var2, var3, var4);
         var11 = g();
         var12 = var5;
         if(var5 == null) {
            var13 = Double.MAX_VALUE;
            var15 = Double.MAX_VALUE;
            if(!fj.z) {
               break label104;
            }
         }

         this.a(var11, var5, var8);
         var13 = this.a(var11, var5, var1, var2, var3, var4);
         var15 = a(var5);
      }

      boolean var17 = 2 == var6;
      gv var18;
      double var19;
      if(var10) {
         this.a(var11, (byte)0, var1, false, var17, var5, var8);
         var18 = var11.a(var1, var2, var3, var4, var5, var6, var9);
         var19 = this.a(var11, var18, var1, var2, var3, var4);
         if(a(var18, var19, var5, var13, var15)) {
            var12 = var18;
            var13 = var19;
            var15 = a(var18);
         }

         if(var13 < 1.0E-4D && var12.b() >= 0.0D && var12.b() <= 1.0D) {
            return var12;
         }
      }

      gv var21;
      double var22;
      if(var5 == null && !var10 || var5 != null && !var5.d()) {
         this.a(var11, (byte)1, var1, false, var17, var5, var8);
         var18 = var11.a(var1, var2, var3, var4, var5, var6, var9);
         var19 = this.a(var11, var18, var1, var2, var3, var4);
         if(a(var18, var19, var12, var13, var15)) {
            var12 = var18;
            var13 = var19;
            var15 = a(var18);
         }

         this.a(var11, (byte)2, var1, false, var17, var5, var8);
         var21 = var11.a(var1, var2, var3, var4, var5, var6, var9);
         var22 = this.a(var11, var21, var1, var2, var3, var4);
         if(a(var21, var22, var12, var13, var15)) {
            var12 = var21;
            var13 = var22;
            var15 = a(var21);
         }

         if(var13 < 1.0E-4D && var12.b() >= 0.0D && var12.b() <= 1.0D) {
            return var12;
         }
      }

      if(var5 == null || var5.d() || var10 && var17) {
         this.a(var11, (byte)1, var1, true, var17, var5, var8);
         var18 = var11.a(var1, var2, var3, var4, var5, var6, var9);
         var19 = this.a(var11, var18, var1, var2, var3, var4);
         if(a(var18, var19, var12, var13, var15)) {
            var12 = var18;
            var13 = var19;
            var15 = a(var18);
         }

         this.a(var11, (byte)2, var1, true, var17, var5, var8);
         var21 = var11.a(var1, var2, var3, var4, var5, var6, var9);
         var22 = this.a(var11, var21, var1, var2, var3, var4);
         if(a(var21, var22, var12, var13, var15)) {
            var12 = var21;
            var13 = var22;
         }

         if(var13 < 1.0E-4D && var12.b() >= 0.0D && var12.b() <= 1.0D) {
            return var12;
         }
      }

      if(var12 == null) {
         return (gv)this.c();
      } else if(var5 != null && var12.equals(var5)) {
         this.a(var11, var5, var8);
         return var11.a(var1, var2, var3, var4, var5, (byte)1, var9);
      } else {
         return var12;
      }
   }

   private double a(ik var1, gv var2, y.d.n var3, y.f.I var4, y.f.am var5, y.f.am var6) {
      y.d.n var7 = var1.a(var3.d(), var4, var5, var6, var2);
      return y.d.n.a(var3, var7, 1.0E-4D)?0.0D:y.d.t.a(var3.k(), var7.k());
   }

   private static double a(gv var0) {
      return var0.e() == 0?Math.abs(var0.b()):Math.abs(var0.c()) + Math.abs(var0.b());
   }

   private static boolean a(gv var0, double var1, gv var3, double var4, double var6) {
      return var3 == null || var1 + 1.0E-4D < var4 || var4 + 1.0E-4D > var1 && a(var0) < var6;
   }

   private static boolean c(y.d.n var0, y.f.I var1, y.f.am var2, y.f.am var3) {
      boolean var7 = fj.z;
      y.d.v var4 = y.f.ae.a(var1, var2, var3, 0.0D);
      int var5 = 0;

      boolean var10000;
      while(true) {
         if(var5 < var4.h() - 1) {
            y.d.m var6 = var4.a(var5);
            var10000 = y.d.n.a(var0, var6, 0.0D);
            if(var7) {
               break;
            }

            if(var10000) {
               return true;
            }

            ++var5;
            if(!var7) {
               continue;
            }
         }

         var10000 = false;
         break;
      }

      return var10000;
   }

   gv a(y.d.n var1, aB var2, gv var3, byte var4) {
      if(a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         return this.a(var1, var2, var2.getSourceRealizer(), var2.getTargetRealizer(), var3, var4, false);
      }
   }

   static boolean a(y.d.n var0) {
      return Double.isNaN(var0.b()) || Double.isNaN(var0.c()) || Double.isNaN(var0.e()) || Double.isNaN(var0.f()) || Double.isNaN(var0.g()) || Double.isNaN(var0.i());
   }
}
