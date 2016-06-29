package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.j;

class k implements Iterator {
   y.c.e a;
   private final y.c.q b;
   private final j c;

   k(j var1, y.c.q var2) {
      this.c = var1;
      this.b = var2;
      this.a = this.b.j();
   }

   public boolean hasNext() {
      return this.a.f();
   }

   public Object next() {
      y.c.d var1 = this.a.a();
      this.a.g();
      return var1;
   }

   public void remove() {
      throw new UnsupportedOperationException("You cannot remove an element from a tree ordering!");
   }
}
