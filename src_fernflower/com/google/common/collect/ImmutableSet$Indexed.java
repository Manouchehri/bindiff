package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Indexed$1;
import com.google.common.collect.UnmodifiableIterator;

abstract class ImmutableSet$Indexed extends ImmutableSet {
   abstract Object get(int var1);

   public UnmodifiableIterator iterator() {
      return this.asList().iterator();
   }

   ImmutableList createAsList() {
      return new ImmutableSet$Indexed$1(this);
   }
}
