package y.h;

import java.util.ArrayList;
import java.util.Iterator;

final class hM implements Iterator {
   private final Iterator a;

   hM(ArrayList var1) {
      this.a = var1.iterator();
   }

   public boolean hasNext() {
      return this.a.hasNext();
   }

   public Object next() {
      return this.a.next();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
