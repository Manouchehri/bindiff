package y.f.e.a;

import y.f.e.a.Y;

class L implements Y {
   public double a(double var1) {
      return this.b(var1)?0.0D:Math.sqrt(var1);
   }

   public boolean b(double var1) {
      return var1 <= 0.0D;
   }
}
