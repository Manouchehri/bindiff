package y.f;

import y.f.B;
import y.f.C;
import y.f.E;
import y.f.I;
import y.f.L;
import y.f.X;
import y.f.ae;
import y.f.am;

public class K implements E {
   public Object c() {
      return new L(20.0D, 20.0D, 0.0D);
   }

   public Object a(y.d.n var1, I var2, am var3, am var4) {
      if(ae.a(var1)) {
         throw new IllegalArgumentException("Invalid label bounds: " + var1);
      } else {
         y.d.t var5;
         y.d.t var6;
         label23: {
            var5 = var2.getSourcePoint();
            var5 = new y.d.t(var5.a() + var3.getX() + var3.getWidth() / 2.0D, var5.b() + var3.getY() + var3.getHeight() / 2.0D);
            if(var2.pointCount() == 0) {
               var6 = var2.getTargetPoint();
               var6 = new y.d.t(var6.a() + var4.getX() + var4.getWidth() / 2.0D, var6.b() + var4.getY() + var4.getHeight() / 2.0D);
               if(!X.j) {
                  break label23;
               }
            }

            var6 = var2.getPoint(0);
         }

         double var7 = this.a(var5, var6);
         y.d.y var9 = var1.h();
         y.d.t var10 = new y.d.t(var9.c() + var9.a() / 2.0D, var9.d() + var9.b() / 2.0D);
         double var11 = this.a(var5, var10);
         double var13 = var11 - var7;
         double var15 = var10.a() - var5.a();
         double var17 = var10.b() - var5.b();
         double var19 = var15 == 0.0D && var17 == 0.0D?0.0D:Math.sqrt(var15 * var15 + var17 * var17);
         Object var21 = this.a(var19, var13, var1.j());
         return var21;
      }
   }

   private Object a(double var1, double var3, double var5) {
      return new L(var1, var3, var5);
   }

   private double a(y.d.t var1, y.d.t var2) {
      double var3 = var2.a() - var1.a();
      double var5 = var2.b() - var1.b();
      double var7 = var3 == 0.0D && var5 == 0.0D?0.0D:Math.atan2(var5, var3);
      return var7;
   }

   public y.d.n a(y.d.q var1, I var2, am var3, am var4, Object var5) {
      y.d.t var6;
      y.d.t var7;
      label16: {
         var6 = var2.getSourcePoint();
         var6 = new y.d.t(var6.a() + var3.getX() + var3.getWidth() / 2.0D, var6.b() + var3.getY() + var3.getHeight() / 2.0D);
         if(var2.pointCount() == 0) {
            var7 = var2.getTargetPoint();
            var7 = new y.d.t(var7.a() + var4.getX() + var4.getWidth() / 2.0D, var7.b() + var4.getY() + var4.getHeight() / 2.0D);
            if(!X.j) {
               break label16;
            }
         }

         var7 = var2.getPoint(0);
      }

      double var8 = this.a(var6, var7);
      L var10 = var5 != null?(L)var5:(L)this.c();
      double var11 = var8 + var10.b;
      double var13 = Math.cos(var11);
      double var15 = Math.sin(var11);
      y.d.n var17 = new y.d.n(0.0D, 0.0D, var1.a(), var1.b());
      var17.a(var10.a());
      y.d.y var18 = var17.h();
      y.d.t var19 = new y.d.t(var6.a() + var13 * var10.a - var18.a() / 2.0D, var6.b() + var15 * var10.a - var18.b() / 2.0D);
      var17.e(var19.a + var18.a() * 0.5D, var19.b + var18.b() * 0.5D);
      return var17;
   }

   public y.c.D a(C var1, I var2, am var3, am var4) {
      y.c.D var5 = new y.c.D();
      var5.add(new B(var1.getOrientedBox(), var1.getModelParameter(), var1));
      return var5;
   }
}
