package y.h;

import y.h.aA;
import y.h.aB;
import y.h.bu;
import y.h.dB;
import y.h.dD;
import y.h.dE;
import y.h.dh;
import y.h.fj;
import y.h.gu;
import y.h.gv;
import y.h.iq;
import y.h.ir;
import y.h.it;

class in implements dE {
   private gu a;
   private dh b;
   private y.d.n c;
   private gv d;
   private gv e;
   private y.d.t f;
   private double g;
   private double h;

   in(gu var1) {
      this.a = var1;
   }

   public void a(dD var1) {
      this.g = var1.c();
      this.h = var1.d();
      aA var2 = (aA)var1.b();
      this.c = var2.getOrientedBox();
      this.f = this.c.k();
      Object var3 = var2.getModelParameter();
      gv var4 = (gv)(var3 instanceof gv?var3:this.a.c());
      this.d = var4;
      this.e = var4;
      dB var5 = var1.a();
      if(var5.e()) {
         this.b = var5.c();
         this.b.a(var5.view);
         this.b.a(new y.d.t(this.g, this.h), (aA)var1.b());
      }

   }

   public void b(dD var1) {
      it var2;
      label32: {
         boolean var13 = fj.z;
         var2 = new it(this, var1);
         if(var1.e()) {
            y.c.D var5;
            label28: {
               aA var3 = (aA)var1.b();
               iq var4 = this.a(var3.getEdge())?this.a(var2):this.b(var2);
               var5 = new y.c.D();
               if(var4 == null) {
                  var2.d();
                  if(!var13) {
                     break label28;
                  }
               }

               var5.add(var4);
               var2.f = var4.c();
            }

            y.d.t var6 = var2.a(var5);
            y.d.n var7 = var2.c();
            double var8 = var2.b();
            double var10 = var8 < 1.0D?0.1D:0.1D / var8;
            if(y.d.t.a(var7.k(), var6) <= var10) {
               break label32;
            }

            aB var12 = var2.a.getRealizer();
            var2.e.b(var6);
            var2.f = (gv)var2.b.b(var2.e, var12, var12.getSourceRealizer(), var12.getTargetRealizer());
            if(!var13) {
               break label32;
            }
         }

         this.b.h();
         var2.d();
      }

      this.e = var2.f;
      var2.a.setModelParameter(var2.f);
   }

   private boolean a(y.c.d var1) {
      bu var2 = (bu)var1.a();
      aB var3 = var2.i(var1);
      return var1.e() && var3.bendCount() == 1;
   }

   public void c(dD var1) {
      this.b();
   }

   public void a() {
      this.b();
   }

   private void b() {
      this.a = null;
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
   }

   private iq a(it var1) {
      double var2 = var1.a();
      gu var4 = var1.b;
      y.d.n var5 = var1.e;
      aA var6 = var1.a;
      aB var7 = var6.getRealizer();
      gv var8 = var4.a(var5, var7, this.d, (byte)0);
      y.d.t var9 = var7.firstBend().e();
      if(y.d.t.a(var5.k(), var9) < var2) {
         ir var10 = new ir();
         var10.a(var9);
         var10.a(var1.d);
         return new iq(var8, var9, var10);
      } else {
         return null;
      }
   }

   private iq b(it var1) {
      boolean var26 = fj.z;
      double var2 = var1.a();
      gu var4 = var1.b;
      gv var5 = var1.c;
      y.d.n var6 = var1.e;
      aA var7 = var1.a;
      aB var8 = var7.getRealizer();
      fj var9 = var8.getSourceRealizer();
      fj var10 = var8.getTargetRealizer();
      gv var11 = var4.a(var6, var8, var5, (byte)0);
      y.d.t var12 = var4.a(var6.d(), var8, var9, var10, var11).k();
      y.d.m var13 = var11.g();
      ir var14 = null;
      if(var13 != null) {
         y.d.t var15 = var13.c();
         y.d.t var16 = var13.d();
         var14 = new ir(var15.a(), var15.b(), var16.a(), var16.b());
         var14.a(var1.d);
      }

      if(y.d.t.a(var6.k(), var12) >= var2) {
         return null;
      } else {
         y.f.D var27 = new y.f.D();
         var27.setModelParameter(var11);
         var27.a((y.f.E)var4);
         var27.a((y.d.n)var6);
         var27.a(var7.getPreferredPlacementDescriptor());
         y.c.D var28 = var4.a((y.f.C)var27, var8, var9, var10);
         y.f.B var17 = null;
         double var18 = var2 * 0.5D;
         if(var28 != null && !var28.isEmpty()) {
            int var20 = var8.pointCount() + 1;
            y.c.C var21 = var28.m();

            while(var21.f()) {
               y.f.B var22 = (y.f.B)var21.d();
               y.d.t var23 = var22.d().k();
               if(var26) {
                  return new iq(var11, var12, var14);
               }

               if(var14 != null && a(var11, var22.b(), var20)) {
                  var14.a(var23);
                  double var24 = y.d.t.a(var23, var12);
                  if(var24 < var18) {
                     var17 = var22;
                     var18 = var24;
                  }
               }

               var21.g();
               if(var26) {
                  break;
               }
            }
         }

         if(var17 != null) {
            return new iq((gv)var17.b(), var17.d().k(), var14);
         } else {
            return new iq(var11, var12, var14);
         }
      }
   }

   private static boolean a(Object var0, Object var1, int var2) {
      gv var3 = (gv)var0;
      int var4 = var3.a();
      int var5 = var4 < 0?var4 + var2:var4;
      gv var6 = (gv)var1;
      int var7 = var6.a();
      int var8 = var7 < 0?var7 + var2:var7;
      return var5 == var8 && var3.e() == var6.e();
   }

   static double a(in var0) {
      return var0.g;
   }

   static double b(in var0) {
      return var0.h;
   }

   static y.d.t c(in var0) {
      return var0.f;
   }

   static gu d(in var0) {
      return var0.a;
   }

   static gv e(in var0) {
      return var0.e;
   }

   static gv f(in var0) {
      return var0.d;
   }

   static dh g(in var0) {
      return var0.b;
   }

   static y.d.n h(in var0) {
      return var0.c;
   }
}
