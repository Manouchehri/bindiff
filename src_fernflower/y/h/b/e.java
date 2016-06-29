package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import y.h.eR;
import y.h.b.a;
import y.h.b.c;
import y.h.b.i;
import y.h.b.l;
import y.h.b.n;
import y.h.b.q;
import y.h.b.t;

public final class e extends l {
   public e() {
      this(3.0D);
   }

   public e(double var1) {
      super(var1);
   }

   public Object c() {
      return super.c();
   }

   n a(y.d.y var1, q var2) {
      double var3 = this.a();
      double var5 = var1.d + var1.b * 0.5D;
      Rectangle2D var7 = var2.h();
      if(var5 < var7.getY()) {
         return new n(var2.a, false, 0.0D);
      } else if(var5 > var7.getMaxY()) {
         return new n(var2.a, false, 1.0D);
      } else {
         double var8 = var1.d;
         double var10 = var7.getHeight() - var1.b - 2.0D * var3;
         double var12 = var7.getY() + var3;
         double var14 = var12 + var10;
         return var8 < var12?new n(var2.a, true, 0.0D):(var8 > var14?new n(var2.a, true, 1.0D):new n(var2.a, true, (var8 - var12) / var10));
      }
   }

   y.d.t a(y.d.q var1, q var2, n var3) {
      int var13 = a.H;
      double var4 = this.a();
      Rectangle2D var6 = var2.h();
      double var7 = var6.getCenterX() - var1.a * 0.5D;
      double var9;
      if(var3.b) {
         double var11 = var6.getHeight() - var1.b - 2.0D * var4;
         var9 = var6.getY() + var4 + var11 * var3.c;
         if(var13 == 0) {
            return new y.d.t(var7, var9);
         }
      }

      if(var3.c < 0.5D) {
         var9 = var6.getY() - var1.b - var4;
         if(var13 == 0) {
            return new y.d.t(var7, var9);
         }
      }

      var9 = var6.getMaxY() + var4;
      return new y.d.t(var7, var9);
   }

   Collection a(i var1) {
      return var1.l();
   }

   public static c a(eR var0) {
      return var0.a() instanceof e?(c)a((a)var0.g(), (e)var0.a(), a((Object)var0.getModelParameter())):null;
   }

   public static c a(a var0, Object var1) {
      return (c)a(var0, new e(), a((Object)var1));
   }

   public static Collection a(c var0) {
      int var7 = a.H;
      a var1 = a.a(var0);
      ArrayList var2 = new ArrayList(var1.labelCount());
      Object var3 = ((t)var0).a;
      int var4 = 0;
      int var5 = var1.labelCount();

      while(var4 < var5) {
         eR var6 = var1.getLabel(var4);
         if(var6.a() instanceof e && var3 == a((Object)var6.getModelParameter()).a) {
            var2.add(var6);
         }

         ++var4;
         if(var7 != 0) {
            break;
         }
      }

      return var2;
   }
}
