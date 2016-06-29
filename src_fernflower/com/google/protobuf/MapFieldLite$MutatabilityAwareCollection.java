package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareIterator;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;

class MapFieldLite$MutatabilityAwareCollection implements Collection {
   private final MutabilityOracle mutabilityOracle;
   private final Collection delegate;

   MapFieldLite$MutatabilityAwareCollection(MutabilityOracle var1, Collection var2) {
      this.mutabilityOracle = var1;
      this.delegate = var2;
   }

   public int size() {
      return this.delegate.size();
   }

   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   public boolean contains(Object var1) {
      return this.delegate.contains(var1);
   }

   public Iterator iterator() {
      return new MapFieldLite$MutatabilityAwareIterator(this.mutabilityOracle, this.delegate.iterator());
   }

   public Object[] toArray() {
      return this.delegate.toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.delegate.toArray(var1);
   }

   public boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   public boolean remove(Object var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.delegate.containsAll(var1);
   }

   public boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(Collection var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.removeAll(var1);
   }

   public boolean retainAll(Collection var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.retainAll(var1);
   }

   public void clear() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.clear();
   }

   public boolean equals(Object var1) {
      return this.delegate.equals(var1);
   }

   public int hashCode() {
      return this.delegate.hashCode();
   }

   public String toString() {
      return this.delegate.toString();
   }
}
