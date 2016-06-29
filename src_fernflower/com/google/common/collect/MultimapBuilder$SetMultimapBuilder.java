package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder$1;
import com.google.common.collect.SetMultimap;

public abstract class MultimapBuilder$SetMultimapBuilder extends MultimapBuilder {
   MultimapBuilder$SetMultimapBuilder() {
      super((MultimapBuilder$1)null);
   }

   public abstract SetMultimap build();

   public SetMultimap build(Multimap var1) {
      return (SetMultimap)super.build(var1);
   }
}
