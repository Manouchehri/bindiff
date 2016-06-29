package y.f.e.a;

import y.f.e.a.Y;

class S implements Y {
   public double a(double var1) {
      return this.b(var1)?0.0D:2.0D * var1 - 1.0D;
   }

   public boolean b(double var1) {
      return var1 <= 0.5D;
   }
}
