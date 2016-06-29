package y.f.c.a;

import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.z;

class cp implements z {
   public static final Object a = "y.layout.hierarchic.incremental.BorderBasedDDC.LEFT_BORDER_DPKEY";
   public static final Object b = "y.layout.hierarchic.incremental.BorderBasedDDC.RIGHT_BORDER_DPKEY";
   public static final Object c = "y.layout.hierarchic.incremental.BorderBasedDDC.LEFT_MIN_DISTANCE_DPKEY";
   public static final Object d = "y.layout.hierarchic.incremental.BorderBasedDDC.RIGHT_MIN_DISTANCE_DPKEY";
   private y.c.c e;
   private y.c.c f;
   private y.c.c g;
   private y.c.c h;
   private boolean i;

   public void a(y.f.X var1, aU var2, aV var3) {
      this.e = var1.c(a);
      this.f = var1.c(b);
      this.g = var1.c(c);
      this.h = var1.c(d);
      this.i = this.g != null || this.h != null || this.e != null || this.f != null;
   }

   public void b(y.f.X var1, aU var2, aV var3) {
      this.g = null;
      this.h = null;
      this.e = null;
      this.f = null;
      this.i = false;
   }

   public double a(y.f.X var1, aQ var2, aV var3, y.c.q var4, y.c.q var5) {
      if(!this.i) {
         return 0.0D;
      } else {
         double var6 = this.e != null && var5 != null?this.e.c(var5):0.0D;
         double var8 = this.f != null && var4 != null?this.f.c(var4):0.0D;
         double var10 = Math.max(this.g != null && var5 != null?this.g.c(var5):0.0D, this.h != null && var4 != null?this.h.c(var4):0.0D);
         return Math.max(var6 + var8, var10);
      }
   }
}
