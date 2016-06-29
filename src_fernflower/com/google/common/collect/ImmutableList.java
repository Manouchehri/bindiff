package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList$1;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList$ReverseImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ImmutableList$SubList;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.SingletonImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible(
   serializable = true,
   emulated = true
)
public abstract class ImmutableList extends ImmutableCollection implements List, RandomAccess {
   public static ImmutableList of() {
      return RegularImmutableList.EMPTY;
   }

   public static ImmutableList of(Object var0) {
      return new SingletonImmutableList(var0);
   }

   public static ImmutableList of(Object var0, Object var1) {
      return construct(new Object[]{var0, var1});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2) {
      return construct(new Object[]{var0, var1, var2});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3) {
      return construct(new Object[]{var0, var1, var2, var3});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4) {
      return construct(new Object[]{var0, var1, var2, var3, var4});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5, var6});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5, var6, var7});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5, var6, var7, var8});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5, var6, var7, var8, var9});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10) {
      return construct(new Object[]{var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10});
   }

   public static ImmutableList of(Object var0, Object var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object... var12) {
      Object[] var13 = new Object[12 + var12.length];
      var13[0] = var0;
      var13[1] = var1;
      var13[2] = var2;
      var13[3] = var3;
      var13[4] = var4;
      var13[5] = var5;
      var13[6] = var6;
      var13[7] = var7;
      var13[8] = var8;
      var13[9] = var9;
      var13[10] = var10;
      var13[11] = var11;
      System.arraycopy(var12, 0, var13, 12, var12.length);
      return construct(var13);
   }

   public static ImmutableList copyOf(Iterable var0) {
      Preconditions.checkNotNull(var0);
      return var0 instanceof Collection?copyOf((Collection)var0):copyOf(var0.iterator());
   }

   public static ImmutableList copyOf(Collection var0) {
      if(var0 instanceof ImmutableCollection) {
         ImmutableList var1 = ((ImmutableCollection)var0).asList();
         return var1.isPartialView()?asImmutableList(var1.toArray()):var1;
      } else {
         return construct(var0.toArray());
      }
   }

   public static ImmutableList copyOf(Iterator var0) {
      if(!var0.hasNext()) {
         return of();
      } else {
         Object var1 = var0.next();
         return !var0.hasNext()?of(var1):(new ImmutableList$Builder()).add(var1).addAll(var0).build();
      }
   }

   public static ImmutableList copyOf(Object[] var0) {
      switch(var0.length) {
      case 0:
         return of();
      case 1:
         return new SingletonImmutableList(var0[0]);
      default:
         return new RegularImmutableList(ObjectArrays.checkElementsNotNull((Object[])var0.clone()));
      }
   }

   private static ImmutableList construct(Object... var0) {
      return asImmutableList(ObjectArrays.checkElementsNotNull(var0));
   }

   static ImmutableList asImmutableList(Object[] var0) {
      return asImmutableList(var0, var0.length);
   }

   static ImmutableList asImmutableList(Object[] var0, int var1) {
      switch(var1) {
      case 0:
         return of();
      case 1:
         SingletonImmutableList var2 = new SingletonImmutableList(var0[0]);
         return var2;
      default:
         if(var1 < var0.length) {
            var0 = ObjectArrays.arraysCopyOf(var0, var1);
         }

         return new RegularImmutableList(var0);
      }
   }

   public UnmodifiableIterator iterator() {
      return this.listIterator();
   }

   public UnmodifiableListIterator listIterator() {
      return this.listIterator(0);
   }

   public UnmodifiableListIterator listIterator(int var1) {
      return new ImmutableList$1(this, this.size(), var1);
   }

   public int indexOf(@Nullable Object var1) {
      return var1 == null?-1:Lists.indexOfImpl(this, var1);
   }

   public int lastIndexOf(@Nullable Object var1) {
      return var1 == null?-1:Lists.lastIndexOfImpl(this, var1);
   }

   public boolean contains(@Nullable Object var1) {
      return this.indexOf(var1) >= 0;
   }

   public ImmutableList subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.size());
      int var3 = var2 - var1;
      if(var3 == this.size()) {
         return this;
      } else {
         switch(var3) {
         case 0:
            return of();
         case 1:
            return of(this.get(var1));
         default:
            return this.subListUnchecked(var1, var2);
         }
      }
   }

   ImmutableList subListUnchecked(int var1, int var2) {
      return new ImmutableList$SubList(this, var1, var2 - var1);
   }

   @Deprecated
   public final boolean addAll(int var1, Collection var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Object set(int var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void add(int var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final Object remove(int var1) {
      throw new UnsupportedOperationException();
   }

   public final ImmutableList asList() {
      return this;
   }

   int copyIntoArray(Object[] var1, int var2) {
      int var3 = this.size();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var2 + var4] = this.get(var4);
      }

      return var2 + var3;
   }

   public ImmutableList reverse() {
      return (ImmutableList)(this.size() <= 1?this:new ImmutableList$ReverseImmutableList(this));
   }

   public boolean equals(@Nullable Object var1) {
      return Lists.equalsImpl(this, var1);
   }

   public int hashCode() {
      int var1 = 1;
      int var2 = this.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1 = 31 * var1 + this.get(var3).hashCode();
         var1 = ~(~var1);
      }

      return var1;
   }

   private void readObject(ObjectInputStream var1) {
      throw new InvalidObjectException("Use SerializedForm");
   }

   Object writeReplace() {
      return new ImmutableList$SerializedForm(this.toArray());
   }

   public static ImmutableList$Builder builder() {
      return new ImmutableList$Builder();
   }
}
