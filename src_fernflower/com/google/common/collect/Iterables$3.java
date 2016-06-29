package com.google.common.collect;

import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

final class Iterables$3 extends TransformedIterator {
   Iterables$3(Iterator var1) {
      super(var1);
   }

   Iterator transform(Iterable var1) {
      return var1.iterator();
   }
}
