package y.f.c.a;

import java.util.Comparator;

final class w implements Comparator {
   final float[] a;

   w(float[] var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a(this.a[((y.c.q)var1).d()], this.a[((y.c.q)var2).d()]);
   }
}
