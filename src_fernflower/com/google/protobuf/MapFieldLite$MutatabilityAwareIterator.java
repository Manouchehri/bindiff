package com.google.protobuf;

import com.google.protobuf.MutabilityOracle;
import java.util.Iterator;

class MapFieldLite$MutatabilityAwareIterator implements Iterator {
   private final MutabilityOracle mutabilityOracle;
   private final Iterator delegate;

   MapFieldLite$MutatabilityAwareIterator(MutabilityOracle var1, Iterator var2) {
      this.mutabilityOracle = var1;
      this.delegate = var2;
   }

   public boolean hasNext() {
      return this.delegate.hasNext();
   }

   public Object next() {
      return this.delegate.next();
   }

   public void remove() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.remove();
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
