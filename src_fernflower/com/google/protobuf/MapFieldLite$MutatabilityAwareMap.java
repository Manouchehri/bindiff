package com.google.protobuf;

import com.google.protobuf.MapFieldLite$MutatabilityAwareCollection;
import com.google.protobuf.MapFieldLite$MutatabilityAwareSet;
import com.google.protobuf.MutabilityOracle;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

class MapFieldLite$MutatabilityAwareMap implements Map {
   private final MutabilityOracle mutabilityOracle;
   private final Map delegate;

   MapFieldLite$MutatabilityAwareMap(MutabilityOracle var1, Map var2) {
      this.mutabilityOracle = var1;
      this.delegate = var2;
   }

   public int size() {
      return this.delegate.size();
   }

   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   public boolean containsKey(Object var1) {
      return this.delegate.containsKey(var1);
   }

   public boolean containsValue(Object var1) {
      return this.delegate.containsValue(var1);
   }

   public Object get(Object var1) {
      return this.delegate.get(var1);
   }

   public Object put(Object var1, Object var2) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.put(var1, var2);
   }

   public Object remove(Object var1) {
      this.mutabilityOracle.ensureMutable();
      return this.delegate.remove(var1);
   }

   public void putAll(Map var1) {
      this.mutabilityOracle.ensureMutable();
      this.delegate.putAll(var1);
   }

   public void clear() {
      this.mutabilityOracle.ensureMutable();
      this.delegate.clear();
   }

   public Set keySet() {
      return new MapFieldLite$MutatabilityAwareSet(this.mutabilityOracle, this.delegate.keySet());
   }

   public Collection values() {
      return new MapFieldLite$MutatabilityAwareCollection(this.mutabilityOracle, this.delegate.values());
   }

   public Set entrySet() {
      return new MapFieldLite$MutatabilityAwareSet(this.mutabilityOracle, this.delegate.entrySet());
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
