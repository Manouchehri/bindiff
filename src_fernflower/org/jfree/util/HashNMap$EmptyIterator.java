package org.jfree.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jfree.util.HashNMap$1;

final class HashNMap$EmptyIterator implements Iterator {
   private HashNMap$EmptyIterator() {
   }

   public boolean hasNext() {
      return false;
   }

   public Object next() {
      throw new NoSuchElementException("This iterator is empty.");
   }

   public void remove() {
      throw new UnsupportedOperationException("This iterator is empty, no remove supported.");
   }

   HashNMap$EmptyIterator(HashNMap$1 var1) {
      this();
   }
}
