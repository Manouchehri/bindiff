package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

class ImmutableMultiset$1 extends UnmodifiableIterator {
   int remaining;
   Object element;
   // $FF: synthetic field
   final Iterator val$entryIterator;
   // $FF: synthetic field
   final ImmutableMultiset this$0;

   ImmutableMultiset$1(ImmutableMultiset var1, Iterator var2) {
      this.this$0 = var1;
      this.val$entryIterator = var2;
   }

   public boolean hasNext() {
      return this.remaining > 0 || this.val$entryIterator.hasNext();
   }

   public Object next() {
      if(this.remaining <= 0) {
         Multiset$Entry var1 = (Multiset$Entry)this.val$entryIterator.next();
         this.element = var1.getElement();
         this.remaining = var1.getCount();
      }

      --this.remaining;
      return this.element;
   }
}
