package com.google.protobuf;

import com.google.protobuf.SmallSortedMap$EmptySet$1;
import com.google.protobuf.SmallSortedMap$EmptySet$2;
import java.util.Iterator;

class SmallSortedMap$EmptySet {
   private static final Iterator ITERATOR = new SmallSortedMap$EmptySet$1();
   private static final Iterable ITERABLE = new SmallSortedMap$EmptySet$2();

   static Iterable iterable() {
      return ITERABLE;
   }

   // $FF: synthetic method
   static Iterator access$700() {
      return ITERATOR;
   }
}
