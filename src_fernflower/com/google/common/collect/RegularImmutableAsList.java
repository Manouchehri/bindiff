package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.j2objc.annotations.Weak;

@GwtCompatible(
   emulated = true
)
class RegularImmutableAsList extends ImmutableAsList {
   @Weak
   private final ImmutableCollection delegate;
   private final ImmutableList delegateList;

   RegularImmutableAsList(ImmutableCollection var1, ImmutableList var2) {
      this.delegate = var1;
      this.delegateList = var2;
   }

   RegularImmutableAsList(ImmutableCollection var1, Object[] var2) {
      this(var1, ImmutableList.asImmutableList(var2));
   }

   ImmutableCollection delegateCollection() {
      return this.delegate;
   }

   ImmutableList delegateList() {
      return this.delegateList;
   }

   public UnmodifiableListIterator listIterator(int var1) {
      return this.delegateList.listIterator(var1);
   }

   @GwtIncompatible("not present in emulated superclass")
   int copyIntoArray(Object[] var1, int var2) {
      return this.delegateList.copyIntoArray(var1, var2);
   }

   public Object get(int var1) {
      return this.delegateList.get(var1);
   }
}
