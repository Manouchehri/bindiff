package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

abstract class ImmutableMap$IteratorBasedImmutableMap extends ImmutableMap {
   abstract UnmodifiableIterator entryIterator();

   ImmutableSet createEntrySet() {
      return new ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(this);
   }
}
