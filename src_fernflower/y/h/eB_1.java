package y.h;

import y.h.dV;

final class eB implements Comparable {
   final double a;
   final y.c.q b;

   private eB(double var1, y.c.q var3) {
      this.a = var1;
      this.b = var3;
   }

   public int compareTo(Object var1) {
      return y.g.e.a(this.a, ((eB)var1).a);
   }

   public String toString() {
      return "SweepEntry{coordinate=" + this.a + ", node=" + this.b + '}';
   }

   eB(double var1, y.c.q var3, dV var4) {
      this(var1, var3);
   }
}
