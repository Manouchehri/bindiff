package y.f.h.a;

import java.util.Iterator;
import y.c.x;
import y.f.h.a.j;

class l implements Iterator {
   x a;
   private final j b;

   l(j var1) {
      this.b = var1;
      this.a = this.b.b.o();
   }

   public boolean hasNext() {
      return this.a.f();
   }

   public Object next() {
      y.c.q var1 = this.a.e();
      this.a.g();
      return var1;
   }

   public void remove() {
      throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
   }
}
