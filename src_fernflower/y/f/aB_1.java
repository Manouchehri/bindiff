package y.f;

import y.f.aA;
import y.f.ax;

final class aB implements aA {
   ax a;
   int b;
   int c;

   aB(ax var1, int var2) {
      this.a = var1;
      this.c = var2;
      this.b = var2;
   }

   public aB(aB var1) {
      this(var1.a, var1.c);
   }

   public int b() {
      return this.b;
   }

   public ax a() {
      return this.a;
   }

   public String toString() {
      return "PortCandidateSet.Entry(candidate=" + this.a + ", connections=" + this.b + ')';
   }
}
