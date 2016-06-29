package y.h.a;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import y.h.a.v;

abstract class G implements Iterator {
   final y.c.d a;
   y.c.d b;
   y.c.d c;
   y.c.q d;
   boolean e;
   private final int f;
   private boolean g;
   private final v h;

   G(v var1, y.c.q var2) {
      this.h = var1;
      this.a = var2.f();
      this.b = this.a;
      this.f = v.f(var1);
      this.g = true;
      this.e = false;
   }

   public boolean hasNext() {
      this.c();
      return this.b();
   }

   public Object next() {
      this.c();
      if(this.b()) {
         this.g = true;
         return this.d;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }

   private boolean b() {
      if(this.g) {
         this.a();
         this.g = false;
      }

      return this.e;
   }

   private void c() {
      if(v.f(this.h) != this.f) {
         throw new ConcurrentModificationException();
      }
   }

   abstract y.c.d a(y.c.q var1);

   abstract y.c.d a(y.c.d var1);

   abstract void a();
}
