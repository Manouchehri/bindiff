package org.jfree.util;

import java.util.Iterator;

public class ReadOnlyIterator implements Iterator {
   private Iterator base;

   public ReadOnlyIterator(Iterator var1) {
      if(var1 == null) {
         throw new NullPointerException("Base iterator is null.");
      } else {
         this.base = var1;
      }
   }

   public boolean hasNext() {
      return this.base.hasNext();
   }

   public Object next() {
      return this.base.next();
   }

   public void remove() {
      throw new UnsupportedOperationException();
   }
}
