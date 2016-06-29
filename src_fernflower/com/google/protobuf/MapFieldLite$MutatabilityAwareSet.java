package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareIterator;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

class MapFieldLite$MutatabilityAwareSet implements Set {
   private final MutabilityOracle mutabilityOracle;
   private final Set delegate;

   MapFieldLite$MutatabilityAwareSet(MutabilityOracle var1, Set var2) {
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
      this.mutabilityOracle.ensureMutable();
      return this.delegate.add(var1);
   }

   public boolean remove(Object var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(var1);
   }

   public boolean containsAll(Collection var1) {
      return this.delegate.containsAll(var1);
   }

   public boolean addAll(Collection var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.addAll(var1);
   }

   public boolean retainAll(Collection var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.retainAll(var1);
   }

   public boolean removeAll(Collection var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.removeAll(var1);
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
