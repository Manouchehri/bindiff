package y.h.b;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import y.h.eR;
import y.h.b.a;
import y.h.b.f;
import y.h.b.i;
import y.h.b.l;
import y.h.b.n;
import y.h.b.q;
import y.h.b.r;

public final class h extends l {
   public h() {
      this(3.0D);
   }

   public h(double var1) {
      super(var1);
   }

   public Object c() {
      return super.c();
   }

   n a(y.d.y var1, q var2) {
      double var3 = this.a();
      double var5 = var1.c + var1.a * 0.5D;
      Rectangle2D var7 = var2.h();
      if(var5 < var7.getX()) {
         return new n(var2.a, false, 0.0D);
      } else if(var5 > var7.getMaxX()) {
         return new n(var2.a, false, 1.0D);
      } else {
         double var8 = var1.c;
         double var10 = var7.getWidth() - var1.a - 2.0D * var3;
         double var12 = var7.getX() + var3;
         double var14 = var12 + var10;
         return var8 < var12?new n(var2.a, true, 0.0D):(var8 > var14?new n(var2.a, true, 1.0D):new n(var2.a, true, (var8 - var12) / var10));
      }
   }

   y.d.t a(y.d.q var1, q var2, n var3) {
      int var13 = a.H;
      double var4 = this.a();
      Rectangle2D var6 = var2.h();
      double var7 = var6.getCenterY() - var1.b * 0.5D;
      double var9;
      if(var3.b) {
         double var11 = var6.getWidth() - var1.a - 2.0D * var4;
         var9 = var6.getX() + var4 + var11 * var3.c;
         if(var13 == 0) {
            return new y.d.t(var9, var7);
         }
      }

      if(var3.c < 0.5D) {
         var9 = var6.getX() - var1.a - var4;
         if(var13 == 0) {
            return new y.d.t(var9, var7);
         }
      }

      var9 = var6.getMaxX() + var4;
      return new y.d.t(var9, var7);
   }

   Collection a(i var1) {
      return var1.o();
   }

   public static f a(eR var0) {
      return var0.a() instanceof h?(f)a((a)var0.g(), (h)var0.a(), a((Object)var0.getModelParameter())):null;
   }

   public static f a(a var0, Object var1) {
      return (f)a(var0, new h(), a((Object)var1));
   }

   public static Collection a(f var0) {
      int var7 = a.H;
      a var1 = a.a(var0);
      ArrayList var2 = new ArrayList(var1.labelCount());
      Object var3 = ((r)var0).a;
      int var4 = 0;
      int var5 = var1.labelCount();

      while(var4 < var5) {
         eR var6 = var1.getLabel(var4);
         if(var6.a() instanceof h && var3 == a((Object)var6.getModelParameter()).a) {
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
