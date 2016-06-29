package y.f.h.a;

import java.util.Iterator;
import y.f.h.a.f;
import y.f.h.a.o;

class g implements Iterator {
   o a;
   o b;
   private final f c;

   g(f var1) {
      this.c = var1;
      this.a = null;
      this.b = f.e(this.c);
   }

   public boolean hasNext() {
      return this.b.a(this.a) != f.f(this.c);
   }

   public Object next() {
      o var1 = this.b;
      this.b = this.b.a(this.a);
      this.a = var1;
      return this.b.a();
   }

   public void remove() {
      o var1 = this.a;
      this.a = this.a.a(this.b);
      this.b = var1;
      this.b.a(this.a).b();
   }
}
