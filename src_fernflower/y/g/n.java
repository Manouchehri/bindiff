package y.g;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class n implements Iterator {
   private final y.c.C a;

   public n(y.c.C var1) {
      this.a = var1;
   }

   public boolean hasNext() {
      return this.a.f();
   }

   public Object next() {
      if(this.a.f()) {
         Object var1 = this.a.d();
         this.a.g();
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException("Removal not supported in Cursors!");
   }
}
