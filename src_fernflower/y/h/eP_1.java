package y.h;

import java.awt.geom.PathIterator;
import y.h.eM;

final class eP implements PathIterator {
   private eM a;
   private final int b;

   eP(eM var1, int var2) {
      this.b = var2;
      this.a = var1;
   }

   public int currentSegment(float[] var1) {
      return this.a.a(var1);
   }

   public int currentSegment(double[] var1) {
      return this.a.a(var1);
   }

   public int getWindingRule() {
      return this.b;
   }

   public boolean isDone() {
      return this.a == null;
   }

   public void next() {
      this.a = this.a.g;
   }
}
