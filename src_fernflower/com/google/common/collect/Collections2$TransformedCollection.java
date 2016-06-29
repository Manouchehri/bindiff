package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

class Collections2$TransformedCollection extends AbstractCollection {
   final Collection fromCollection;
   final Function function;

   Collections2$TransformedCollection(Collection var1, Function var2) {
      this.fromCollection = (Collection)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public void clear() {
      this.fromCollection.clear();
   }

   public boolean isEmpty() {
      return this.fromCollection.isEmpty();
   }

   public Iterator iterator() {
      return Iterators.transform(this.fromCollection.iterator(), this.function);
   }

   public int size() {
      return this.fromCollection.size();
   }
}
