package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eN extends eM {
   byte a;
   double b;
   double c;

   public int a() {
      return this.a;
   }

   public int a(double[] var1) {
      var1[0] = this.b;
      var1[1] = this.c;
      return this.a;
   }

   public int a(float[] var1) {
      var1[0] = (float)this.b;
      var1[1] = (float)this.c;
      return this.a;
   }

   int a(float[] var1, AffineTransform var2) {
      var1[0] = (float)this.b;
      var1[1] = (float)this.c;
      var2.transform(var1, 0, var1, 0, 1);
      return this.a;
   }

   int a(double[] var1, AffineTransform var2) {
      var1[0] = this.b;
      var1[1] = this.c;
      var2.transform(var1, 0, var1, 0, 1);
      return this.a;
   }
}
