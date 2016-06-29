package y.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

class V implements Iterator {
   public boolean hasNext() {
      return false;
   }

   public Object next() {
      throw new NoSuchElementException();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
