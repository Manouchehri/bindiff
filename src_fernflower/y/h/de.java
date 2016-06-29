package y.h;

import java.util.ArrayList;

final class de implements Comparable {
   final double a;
   final ArrayList b = new ArrayList();

   de(double var1) {
      this.a = var1;
   }

   public int compareTo(Object var1) {
      de var2 = (de)var1;
      return y.g.e.a(this.a, var2.a);
   }

   public String toString() {
      return "Entry{nodes=" + this.b + ", size=" + this.a + '}';
   }
}
