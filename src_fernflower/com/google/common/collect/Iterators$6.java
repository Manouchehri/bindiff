package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class Iterators$6 extends UnmodifiableIterator {
   // $FF: synthetic field
   final Iterator val$iterator;
   // $FF: synthetic field
   final int val$size;
   // $FF: synthetic field
   final boolean val$pad;

   Iterators$6(Iterator var1, int var2, boolean var3) {
      this.val$iterator = var1;
      this.val$size = var2;
      this.val$pad = var3;
   }

   public boolean hasNext() {
      return this.val$iterator.hasNext();
   }

   public List next() {
      if(!this.hasNext()) {
         throw new NoSuchElementException();
      } else {
         Object[] var1 = new Object[this.val$size];

         int var2;
         for(var2 = 0; var2 < this.val$size && this.val$iterator.hasNext(); ++var2) {
            var1[var2] = this.val$iterator.next();
         }

         for(int var3 = var2; var3 < this.val$size; ++var3) {
            var1[var3] = null;
         }

         List var4 = Collections.unmodifiableList(Arrays.asList(var1));
         return !this.val$pad && var2 != this.val$size?var4.subList(0, var2):var4;
      }
   }
}
