package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableMultiset$EntrySet;
import com.google.common.collect.ImmutableMultiset$SerializedForm;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public abstract class ImmutableMultiset extends ImmutableCollection implements Multiset {
   @LazyInit
   private transient ImmutableSet entrySet;

   public static ImmutableMultiset of() {
      return RegularImmutableMultiset.EMPTY;
   }

   public static ImmutableMultiset of(Object var0) {
      return copyFromElements(new Object[]{var0});
   }

   public static ImmutableMultiset of(Object var0, Object var1) {
      return copyFromElements(new Object[]{var0, var1});
   }

   public static ImmutableMultiset of(Object var0, Object var1, Object var2) {
      return copyFromElements(new Object[]{var0, var1, var2});
   }

   public static ImmutableMultiset of(Object var0, Object var1, Object var2, Object var3) {
      return copyFromElements(new Object[]{var0, var1, var2, var3});
   }

   public static ImmutableMultiset of(Object var0, Object var1, Object var2, Object var3, Object var4) {
      return copyFromElements(new Object[]{var0, var1, var2, var3, var4});
   }

   public static ImmutableMultiset of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object... var6) {
      return (new ImmutableMultiset$Builder()).add(var0).add(var1).add(var2).add(var3).add(var4).add(var5).add(var6).build();
   }

   public static ImmutableMultiset copyOf(Object[] var0) {
      return copyFromElements(var0);
   }

   public static ImmutableMultiset copyOf(Iterable var0) {
      if(var0 instanceof ImmutableMultiset) {
         ImmutableMultiset var1 = (ImmutableMultiset)var0;
         if(!var1.isPartialView()) {
            return var1;
         }
      }

      Object var2 = var0 instanceof Multiset?Multisets.cast(var0):LinkedHashMultiset.create(var0);
      return copyFromEntries(((Multiset)var2).entrySet());
   }

   private static ImmutableMultiset copyFromElements(Object... var0) {
      LinkedHashMultiset var1 = LinkedHashMultiset.create();
      Collections.addAll(var1, var0);
      return copyFromEntries(var1.entrySet());
   }

   static ImmutableMultiset copyFromEntries(Collection var0) {
      return (ImmutableMultiset)(var0.isEmpty()?of():new RegularImmutableMultiset(var0));
   }

   public static ImmutableMultiset copyOf(Iterator var0) {
      LinkedHashMultiset var1 = LinkedHashMultiset.create();
      Iterators.addAll(var1, var0);
      return copyFromEntries(var1.entrySet());
   }

   public UnmodifiableIterator iterator() {
      UnmodifiableIterator var1 = this.entrySet().iterator();
      return new ImmutableMultiset$1(this, var1);
   }

   public boolean contains(@Nullable Object var1) {
      return this.count(var1) > 0;
   }

   @Deprecated
   public final int add(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final int remove(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final int setCount(Object var1, int var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final boolean setCount(Object var1, int var2, int var3) {
      throw new UnsupportedOperationException();
   }

   @GwtIncompatible("not present in emulated superclass")
   int copyIntoArray(Object[] var1, int var2) {
      Multiset$Entry var4;
      for(UnmodifiableIterator var3 = this.entrySet().iterator(); var3.hasNext(); var2 += var4.getCount()) {
         var4 = (Multiset$Entry)var3.next();
         Arrays.fill(var1, var2, var2 + var4.getCount(), var4.getElement());
      }

      return var2;
   }

   public boolean equals(@Nullable Object var1) {
      return Multisets.equalsImpl(this, var1);
   }

   public int hashCode() {
      return Sets.hashCodeImpl(this.entrySet());
   }

   public String toString() {
      return this.entrySet().toString();
   }

   public ImmutableSet entrySet() {
      ImmutableSet var1 = this.entrySet;
      return var1 == null?(this.entrySet = this.createEntrySet()):var1;
   }

   private final ImmutableSet createEntrySet() {
      return (ImmutableSet)(this.isEmpty()?ImmutableSet.of():new ImmutableMultiset$EntrySet(this, (ImmutableMultiset$1)null));
   }

   abstract Multiset$Entry getEntry(int var1);

   Object writeReplace() {
      return new ImmutableMultiset$SerializedForm(this);
   }

   public static ImmutableMultiset$Builder builder() {
      return new ImmutableMultiset$Builder();
   }
}
