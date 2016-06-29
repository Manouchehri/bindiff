package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder$1;

public abstract class MultimapBuilder$ListMultimapBuilder extends MultimapBuilder {
   MultimapBuilder$ListMultimapBuilder() {
      super((MultimapBuilder$1)null);
   }

   public abstract ListMultimap build();

   public ListMultimap build(Multimap var1) {
      return (ListMultimap)super.build(var1);
   }
}
