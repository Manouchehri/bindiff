package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class AbstractIndexedListIterator extends UnmodifiableListIterator {
   private final int size;
   private int position;

   protected abstract Object get(int var1);

   protected AbstractIndexedListIterator(int var1) {
      this(var1, 0);
   }

   protected AbstractIndexedListIterator(int var1, int var2) {
      Preconditions.checkPositionIndex(var2, var1);
      this.size = var1;
      this.position = var2;
   }

   public final boolean hasNext() {
      return this.position < this.size;
   }

   public final Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         return this.get(this.position++);
      }
   }

   public final int nextIndex() {
      return this.position;
   }

   public final boolean hasPrevious() {
      return this.position > 0;
   }

   public final Object previous() {
      if(!this.hasPrevious()) {
         throw new NoSuchElementException();
      } else {
         return this.get(--this.position);
      }
   }

   public final int previousIndex() {
      return this.position - 1;
   }
}
