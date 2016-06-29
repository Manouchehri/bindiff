package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$IteratorBasedAbstractMap$1;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Set;

abstract class Maps$IteratorBasedAbstractMap extends AbstractMap {
   public abstract int size();

   abstract Iterator entryIterator();

   public Set entrySet() {
      return new Maps$IteratorBasedAbstractMap$1(this);
   }

   public void clear() {
      Iterators.clear(this.entryIterator());
   }
}
