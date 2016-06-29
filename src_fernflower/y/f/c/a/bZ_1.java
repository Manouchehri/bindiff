package y.f.c.a;

final class bZ implements Comparable {
   double a;
   Object b;

   bZ(double var1, Object var3) {
      this.a = var1;
      this.b = var3;
   }

   public int compareTo(Object var1) {
      return y.g.e.a(this.a, ((bZ)var1).a);
   }
}
