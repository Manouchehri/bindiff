package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableEnumSet$1;
import com.google.common.collect.ImmutableEnumSet$EnumSerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Collection;
import java.util.EnumSet;

@GwtCompatible(
   serializable = true,
   emulated = true
)
final class ImmutableEnumSet extends ImmutableSet {
   private final transient EnumSet delegate;
   @LazyInit
   private transient int hashCode;

   static ImmutableSet asImmutable(EnumSet var0) {
      switch(var0.size()) {
      case 0:
         return ImmutableSet.of();
      case 1:
         return ImmutableSet.of(Iterables.getOnlyElement(var0));
      default:
         return new ImmutableEnumSet(var0);
      }
   }

   private ImmutableEnumSet(EnumSet var1) {
      this.delegate = var1;
   }

   boolean isPartialView() {
      return false;
   }

   public UnmodifiableIterator iterator() {
      return Iterators.unmodifiableIterator(this.delegate.iterator());
   }

   public int size() {
      return this.delegate.size();
   }

   public boolean contains(Object var1) {
      return this.delegate.contains(var1);
   }

   public boolean containsAll(Collection var1) {
      if(var1 instanceof ImmutableEnumSet) {
         var1 = ((ImmutableEnumSet)var1).delegate;
      }

      return this.delegate.containsAll((Collection)var1);
   }

   public boolean isEmpty() {
      return this.delegate.isEmpty();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else {
         if(var1 instanceof ImmutableEnumSet) {
            var1 = ((ImmutableEnumSet)var1).delegate;
         }

         return this.delegate.equals(var1);
      }
   }

   boolean isHashCodeFast() {
      return true;
   }

   public int hashCode() {
      int var1 = this.hashCode;
      return var1 == 0?(this.hashCode = this.delegate.hashCode()):var1;
   }

   public String toString() {
      return this.delegate.toString();
   }

   Object writeReplace() {
      return new ImmutableEnumSet$EnumSerializedForm(this.delegate);
   }

   // $FF: synthetic method
   ImmutableEnumSet(EnumSet var1, ImmutableEnumSet$1 var2) {
      this(var1);
   }
}
