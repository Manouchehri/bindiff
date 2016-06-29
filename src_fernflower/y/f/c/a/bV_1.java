package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bT;

class bV implements Comparator {
   private final bT a;

   bV(bT var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a((int)bT.a(this.a)[((y.c.d)var1).d().d()], (int)bT.a(this.a)[((y.c.d)var2).d().d()]);
   }
}
