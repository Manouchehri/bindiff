package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.SortedSetMultimap;

public abstract class MultimapBuilder$SortedSetMultimapBuilder extends MultimapBuilder$SetMultimapBuilder {
   public abstract SortedSetMultimap build();

   public SortedSetMultimap build(Multimap var1) {
      return (SortedSetMultimap)super.build(var1);
   }
}
