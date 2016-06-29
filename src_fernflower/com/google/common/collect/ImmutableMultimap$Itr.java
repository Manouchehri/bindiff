package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class ImmutableMultimap$Itr extends UnmodifiableIterator {
   final Iterator mapIterator;
   Object key;
   Iterator valueIterator;
   // $FF: synthetic field
   final ImmutableMultimap this$0;

   private ImmutableMultimap$Itr(ImmutableMultimap var1) {
      this.this$0 = var1;
      this.mapIterator = this.this$0.asMap().entrySet().iterator();
      this.key = null;
      this.valueIterator = Iterators.emptyIterator();
   }

   abstract Object output(Object var1, Object var2);

   public boolean hasNext() {
      return this.mapIterator.hasNext() || this.valueIterator.hasNext();
   }

   public Object next() {
      if(!this.valueIterator.hasNext()) {
         Entry var1 = (Entry)this.mapIterator.next();
         this.key = var1.getKey();
         this.valueIterator = ((Collection)var1.getValue()).iterator();
      }

      return this.output(this.key, this.valueIterator.next());
   }

   // $FF: synthetic method
   ImmutableMultimap$Itr(ImmutableMultimap var1, ImmutableMultimap$1 var2) {
      this(var1);
   }
}
