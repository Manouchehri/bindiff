package y.f.c.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import y.f.c.a.aU;

final class dB implements Iterator {
   private final aU a;
   private int b;

   dB(aU var1) {
      this.a = var1;
      this.b = 0;
   }

   public boolean hasNext() {
      return this.b < this.a.b();
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.a.a(this.b++).d();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
