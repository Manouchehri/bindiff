package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ImmutableMapBuilder$ImmutableHashMap extends HashMap {
   transient volatile Set keySet;
   transient volatile Collection values;
   transient volatile Set entrySet;
   @LazyInit
   transient Integer cachedHashCode;
   private static final long serialVersionUID = -5187626034923451074L;

   ImmutableMapBuilder$ImmutableHashMap(int var1) {
      super(var1);
   }

   public Set keySet() {
      if(this.keySet == null) {
         this.keySet = Collections.unmodifiableSet(super.keySet());
      }

      return this.keySet;
   }

   public Collection values() {
      if(this.values == null) {
         this.values = Collections.unmodifiableCollection(super.values());
      }

      return this.values;
   }

   public Set entrySet() {
      if(this.entrySet == null) {
         this.entrySet = Maps.unmodifiableEntrySet(super.entrySet());
      }

      return this.entrySet;
   }

   public int hashCode() {
      Integer var1 = this.cachedHashCode;
      if(var1 == null) {
         int var2 = super.hashCode();
         this.cachedHashCode = Integer.valueOf(var2);
         return var2;
      } else {
         return var1.intValue();
      }
   }

   private void secretPut(Object var1, Object var2) {
      super.put(var1, var2);
   }

   public Object put(Object var1, Object var2) {
      throw up();
   }

   public void putAll(Map var1) {
      throw up();
   }

   public Object remove(Object var1) {
      throw up();
   }

   public void clear() {
      throw up();
   }

   static UnsupportedOperationException up() {
      return new UnsupportedOperationException();
   }

   // $FF: synthetic method
   static void access$000(ImmutableMapBuilder$ImmutableHashMap var0, Object var1, Object var2) {
      var0.secretPut(var1, var2);
   }
}
