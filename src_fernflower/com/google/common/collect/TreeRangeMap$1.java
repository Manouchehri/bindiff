package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class TreeRangeMap$1 implements RangeMap {
   @Nullable
   public Object get(Comparable var1) {
      return null;
   }

   @Nullable
   public Entry getEntry(Comparable var1) {
      return null;
   }

   public Range span() {
      throw new NoSuchElementException();
   }

   public void put(Range var1, Object var2) {
      Preconditions.checkNotNull(var1);
      String var3 = String.valueOf(var1);
      throw new IllegalArgumentException((new StringBuilder(46 + String.valueOf(var3).length())).append("Cannot insert range ").append(var3).append(" into an empty subRangeMap").toString());
   }

   public void putAll(RangeMap var1) {
      if(!var1.asMapOfRanges().isEmpty()) {
         throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
      }
   }

   public void clear() {
   }

   public void remove(Range var1) {
      Preconditions.checkNotNull(var1);
   }

   public Map asMapOfRanges() {
      return Collections.emptyMap();
   }

   public Map asDescendingMapOfRanges() {
      return Collections.emptyMap();
   }

   public RangeMap subRangeMap(Range var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }
}
