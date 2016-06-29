package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.h;
import y.f.h.a.p;

class q implements Iterator {
   h a;
   private final p b;

   q(p var1) {
      this.b = var1;
      this.a = this.b.a;
   }

   public boolean hasNext() {
      return this.a.b != this.b.a;
   }

   public Object next() {
      this.a = this.a.b;
      return this.a.a();
   }

   public void remove() {
      h var1 = this.a.c;
      this.a.b();
      this.a = var1;
   }
}
