package com.google.common.collect;

import com.google.common.collect.ForwardingMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

class Multisets$UnmodifiableMultiset extends ForwardingMultiset implements Serializable {
   final Multiset delegate;
   transient Set elementSet;
   transient Set entrySet;
   private static final long serialVersionUID = 0L;

   Multisets$UnmodifiableMultiset(Multiset var1) {
      this.delegate = var1;
   }

   protected Multiset delegate() {
      return this.delegate;
   }

   Set createElementSet() {
      return Collections.unmodifiableSet(this.delegate.elementSet());
   }

   public Set elementSet() {
      Set var1 = this.elementSet;
      return var1 == null?(this.elementSet = this.createElementSet()):var1;
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 == null?(this.entrySet = Collections.unmodifiableSet(this.delegate.entrySet())):var1;
   }

   public Iterator iterator() {
      return Iterators.unmodifiableIterator(this.delegate.iterator());
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public int add(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   public int remove(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public void clear() {
      throw new UnsupportedOperationException();
   }

   public int setCount(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   public boolean setCount(Object var1, int var2, int var3) {
      throw new UnsupportedOperationException();
   }
}
