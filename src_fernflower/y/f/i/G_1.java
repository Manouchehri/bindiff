package y.f.i;

import y.f.i.E;
import y.f.i.F;
import y.f.i.J;

class G extends J {
   private final double b;
   private final double c;
   private final double d;
   private final double e;

   G(double var1, double var3, double var5, double var7) {
      this.b = var1;
      this.c = var3;
      this.d = var5;
      this.e = var7;
   }

   public String toString() {
      return "EdgeObject{}";
   }

   F a(boolean var1, double var2) {
      return new F(var1, var2, Math.min(this.c, this.e), Math.max(this.c, this.e), this);
   }

   double a(y.c.d var1, double var2, double var4, double var6, E var8) {
      if(var6 < this.c && var6 < this.e) {
         return 0.0D;
      } else if(var4 > this.c && var4 > this.e) {
         return 0.0D;
      } else {
         double var9 = var8.b();
         double var11;
         if(this.d != this.b) {
            var11 = (this.e - this.c) / (this.d - this.b);
            double var13 = this.c + var11 * (var2 - this.b);
            return var13 <= var6 && var13 >= var4?var9:0.0D;
         } else {
            var11 = var8.d();
            return this.e > this.c?(var4 <= this.e && var6 >= this.c?var11:0.0D):(var4 <= this.c && var6 >= this.e?var11:0.0D);
         }
      }
   }
}
