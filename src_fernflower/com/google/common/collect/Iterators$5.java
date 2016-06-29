package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class Iterators$5 implements Iterator {
   Iterator current;
   Iterator removeFrom;
   // $FF: synthetic field
   final Iterator val$inputs;

   Iterators$5(Iterator var1) {
      this.val$inputs = var1;
      this.current = Iterators.emptyIterator();
   }

   public boolean hasNext() {
      boolean var1;
      while(!(var1 = ((Iterator)Preconditions.checkNotNull(this.current)).hasNext()) && this.val$inputs.hasNext()) {
         this.current = (Iterator)this.val$inputs.next();
      }

      return var1;
   }

   public Object next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         this.removeFrom = this.current;
         return this.current.next();
      }
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.removeFrom != null);
      this.removeFrom.remove();
      this.removeFrom = null;
   }
}
