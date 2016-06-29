package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableAsList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public abstract class ImmutableCollection extends AbstractCollection implements Serializable {
   @LazyInit
   private transient ImmutableList asList;

   public abstract UnmodifiableIterator iterator();

   public final Object[] toArray() {
      int var1 = this.size();
      if(var1 == 0) {
         return ObjectArrays.EMPTY_ARRAY;
      } else {
         Object[] var2 = new Object[var1];
         this.copyIntoArray(var2, 0);
         return var2;
      }
   }

   public final Object[] toArray(Object[] var1) {
      Preconditions.checkNotNull(var1);
      int var2 = this.size();
      if(var1.length < var2) {
         var1 = ObjectArrays.newArray(var1, var2);
      } else if(var1.length > var2) {
         var1[var2] = null;
      }

      this.copyIntoArray(var1, 0);
      return var1;
   }

   public abstract boolean contains(@Nullable Object var1);

   @Deprecated
   public final boolean add(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final boolean remove(Object var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final boolean addAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final boolean removeAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final boolean retainAll(Collection var1) {
      throw new UnsupportedOperationException();
   }

   @Deprecated
   public final void clear() {
      throw new UnsupportedOperationException();
   }

   public ImmutableList asList() {
      ImmutableList var1 = this.asList;
      return var1 == null?(this.asList = this.createAsList()):var1;
   }

   ImmutableList createAsList() {
      switch(this.size()) {
      case 0:
         return ImmutableList.of();
      case 1:
         return ImmutableList.of(this.iterator().next());
      default:
         return new RegularImmutableAsList(this, this.toArray());
      }
   }

   abstract boolean isPartialView();

   int copyIntoArray(Object[] var1, int var2) {
      Object var4;
      for(UnmodifiableIterator var3 = this.iterator(); var3.hasNext(); var1[var2++] = var4) {
         var4 = var3.next();
      }

      return var2;
   }

   Object writeReplace() {
      return new ImmutableList$SerializedForm(this.toArray());
   }
}
