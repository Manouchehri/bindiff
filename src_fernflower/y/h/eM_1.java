package y.h;

import java.awt.geom.AffineTransform;
import y.h.eI;

abstract class eM implements eI {
   eM g;
   eM h;

   abstract int a(double[] var1, AffineTransform var2);

   abstract int a(float[] var1, AffineTransform var2);

   public eI b() {
      return this.g;
   }
}
