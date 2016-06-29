package y.f.i;

import y.f.i.E;
import y.f.i.F;
import y.f.i.J;

class I extends J {
   private final y.c.q b;
   private final double c;
   private final double d;
   private final double e;
   private final double f;

   I(y.c.q var1, double var2, double var4, double var6, double var8) {
      this.b = var1;
      this.c = var2;
      this.d = var4;
      this.e = var6 + var2;
      this.f = var8 + var4;
   }

   double a(y.c.d var1, double var2, double var4, double var6, E var8) {
      y.c.i var9 = var1.a();
      y.c.c var10 = var9.c(y.f.b.f.d);
      y.c.c var11 = var9.c(y.f.b.f.b);
      y.c.c var12 = var9.c(y.f.b.f.c);
      if(var11 != null && var12 != null && var10 != null && var10.d(this.b)) {
         Object var13 = var11.b(this.b);
         Object var14 = var12.b(var1.c());
         Object var15 = var12.b(var1.d());
         if(var14 != null && var14.equals(var13) || var15 != null && var15.equals(var13)) {
            return 0.0D;
         }
      }

      if(this.b != var1.c() && this.b != var1.d()) {
         if(var2 >= this.c && var2 <= this.e && var4 <= this.f && var6 >= this.d) {
            return var8.c();
         } else {
            return 0.0D;
         }
      } else {
         return 0.0D;
      }
   }

   F a(boolean var1, double var2) {
      return new F(var1, var2, this.d, this.f, this);
   }

   public String toString() {
      return "NodeObject{node=" + this.b + '}';
   }
}
