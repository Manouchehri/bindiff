package y.f.c.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class dz implements Iterator {
   private final Object[] a;
   private int b;

   dz(Object[] var1) {
      this.a = var1;
      this.b = 0;
   }

   public boolean hasNext() {
      return this.b < this.a.length;
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.a[this.b++];
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
