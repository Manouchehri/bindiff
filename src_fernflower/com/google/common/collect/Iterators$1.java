package com.google.common.collect;

import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

final class Iterators$1 extends UnmodifiableListIterator {
   public boolean hasNext() {
      return false;
   }

   public Object next() {
      throw new NoSuchElementException();
   }

   public boolean hasPrevious() {
      return false;
   }

   public Object previous() {
      throw new NoSuchElementException();
   }

   public int nextIndex() {
      return 0;
   }

   public int previousIndex() {
      return -1;
   }
}
