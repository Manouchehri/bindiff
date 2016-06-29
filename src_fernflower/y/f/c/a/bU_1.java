package y.f.c.a;

import java.util.Comparator;
import y.f.c.a.bT;

class bU implements Comparator {
   private final bT a;

   bU(bT var1) {
      this.a = var1;
   }

   public int compare(Object var1, Object var2) {
      return y.g.e.a((int)bT.a(this.a)[((y.c.d)var1).c().d()], (int)bT.a(this.a)[((y.c.d)var2).c().d()]);
   }
}
