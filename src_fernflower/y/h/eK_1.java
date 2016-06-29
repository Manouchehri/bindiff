package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eK extends eM {
   double a;
   double b;
   double c;
   double d;

   public int a() {
      return 2;
   }

   public int a(double[] var1) {
      var1[0] = this.a;
      var1[1] = this.b;
      var1[2] = this.c;
      var1[3] = this.d;
      return 2;
   }

   public int a(float[] var1) {
      var1[0] = (float)this.a;
      var1[1] = (float)this.b;
      var1[2] = (float)this.c;
      var1[3] = (float)this.d;
      return 2;
   }

   int a(float[] var1, AffineTransform var2) {
      var1[0] = (float)this.a;
      var1[1] = (float)this.b;
      var1[2] = (float)this.c;
      var1[3] = (float)this.d;
      var2.transform(var1, 0, var1, 0, 2);
      return 2;
   }

   int a(double[] var1, AffineTransform var2) {
      var1[0] = this.a;
      var1[1] = this.b;
      var1[2] = this.c;
      var1[3] = this.d;
      var2.transform(var1, 0, var1, 0, 2);
      return 2;
   }
}
