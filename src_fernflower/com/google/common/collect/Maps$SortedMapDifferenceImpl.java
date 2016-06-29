package com.google.common.collect;

import com.google.common.collect.Maps$MapDifferenceImpl;
import com.google.common.collect.SortedMapDifference;
import java.util.SortedMap;

class Maps$SortedMapDifferenceImpl extends Maps$MapDifferenceImpl implements SortedMapDifference {
   Maps$SortedMapDifferenceImpl(SortedMap var1, SortedMap var2, SortedMap var3, SortedMap var4) {
      super(var1, var2, var3, var4);
   }

   public SortedMap entriesDiffering() {
      return (SortedMap)super.entriesDiffering();
   }

   public SortedMap entriesInCommon() {
      return (SortedMap)super.entriesInCommon();
   }

   public SortedMap entriesOnlyOnLeft() {
      return (SortedMap)super.entriesOnlyOnLeft();
   }

   public SortedMap entriesOnlyOnRight() {
      return (SortedMap)super.entriesOnlyOnRight();
   }
}
