package com.google.protobuf;

import com.google.protobuf.Internal$ProtobufList;
import java.util.AbstractList;
import java.util.Collection;

abstract class AbstractProtobufList extends AbstractList implements Internal$ProtobufList {
   private boolean isMutable = true;

   public boolean add(Object var1) {
      this.ensureIsMutable();
      return super.add(var1);
   }

   public void add(int var1, Object var2) {
      this.ensureIsMutable();
      super.add(var1, var2);
   }

   public boolean addAll(Collection var1) {
      this.ensureIsMutable();
      return super.addAll(var1);
   }

   public boolean addAll(int var1, Collection var2) {
      this.ensureIsMutable();
      return super.addAll(var1, var2);
   }

   public void clear() {
      this.ensureIsMutable();
      super.clear();
   }

   public boolean isModifiable() {
      return this.isMutable;
   }

   public final void makeImmutable() {
      this.isMutable = false;
   }

   public Object remove(int var1) {
      this.ensureIsMutable();
      return super.remove(var1);
   }

   public boolean remove(Object var1) {
      this.ensureIsMutable();
      return super.remove(var1);
   }

   public boolean removeAll(Collection var1) {
      this.ensureIsMutable();
      return super.removeAll(var1);
   }

   public boolean retainAll(Collection var1) {
      this.ensureIsMutable();
      return super.retainAll(var1);
   }

   public Object set(int var1, Object var2) {
      this.ensureIsMutable();
      return super.set(var1, var2);
   }

   protected void ensureIsMutable() {
      if(!this.isMutable) {
         throw new UnsupportedOperationException();
      }
   }
}
