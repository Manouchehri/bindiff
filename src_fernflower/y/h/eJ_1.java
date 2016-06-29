package y.h;

import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import y.h.eM;

final class eJ implements PathIterator {
   private eM a;
   private final AffineTransform b;
   private final int c;

   eJ(eM var1, AffineTransform var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int currentSegment(float[] var1) {
      return this.a.a(var1, this.b);
   }

   public int currentSegment(double[] var1) {
      return this.a.a(var1, this.b);
   }

   public int getWindingRule() {
      return this.c;
   }

   public boolean isDone() {
      return this.a == null;
   }

   public void next() {
      this.a = this.a.g;
   }
}
