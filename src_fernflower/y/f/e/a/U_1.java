package y.f.e.a;

import y.f.e.a.Y;

class U implements Y {
   public double a(double var1) {
      return this.b(var1)?0.0D:-4.0D * var1 / 3.0D + 1.0D;
   }

   public boolean b(double var1) {
      return var1 >= 0.75D;
   }
}
