package y.h;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class hL implements Iterator {
   private final ArrayList a;
   private int b;

   hL(ArrayList var1) {
      this.a = var1;
      this.b = var1.size() - 1;
   }

   public boolean hasNext() {
      return this.b > -1;
   }

   public Object next() {
      try {
         return this.a.get(this.b--);
      } catch (IndexOutOfBoundsException var2) {
         throw new NoSuchElementException();
      }
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
