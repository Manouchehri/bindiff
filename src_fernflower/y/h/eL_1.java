package y.h;

import java.awt.geom.AffineTransform;
import y.h.eM;

final class eL extends eM {
   double a;
   double b;
   double c;
   double d;
   double e;
   double f;

   public int a() {
      return 2;
   }

   public int a(double[] var1) {
      var1[0] = this.a;
      var1[1] = this.b;
      var1[2] = this.c;
      var1[3] = this.d;
      var1[4] = this.e;
      var1[5] = this.f;
      return 3;
   }

   public int a(float[] var1) {
      var1[0] = (float)this.a;
      var1[1] = (float)this.b;
      var1[2] = (float)this.c;
      var1[3] = (float)this.d;
      var1[4] = (float)this.e;
      var1[5] = (float)this.f;
      return 3;
   }

   int a(float[] var1, AffineTransform var2) {
      var1[0] = (float)this.a;
      var1[1] = (float)this.b;
      var1[2] = (float)this.c;
      var1[3] = (float)this.d;
      var1[4] = (float)this.e;
      var1[5] = (float)this.f;
      var2.transform(var1, 0, var1, 0, 3);
      return 3;
   }

   int a(double[] var1, AffineTransform var2) {
      var1[0] = this.a;
      var1[1] = this.b;
      var1[2] = this.c;
      var1[3] = this.d;
      var1[4] = this.e;
      var1[5] = this.f;
      var2.transform(var1, 0, var1, 0, 3);
      return 3;
   }
}
