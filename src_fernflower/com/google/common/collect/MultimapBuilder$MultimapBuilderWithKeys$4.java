package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$LinkedHashSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

class MultimapBuilder$MultimapBuilderWithKeys$4 extends MultimapBuilder$SetMultimapBuilder {
   // $FF: synthetic field
   final int val$expectedValuesPerKey;
   // $FF: synthetic field
   final MultimapBuilder$MultimapBuilderWithKeys this$0;

   MultimapBuilder$MultimapBuilderWithKeys$4(MultimapBuilder$MultimapBuilderWithKeys var1, int var2) {
      this.this$0 = var1;
      this.val$expectedValuesPerKey = var2;
   }

   public SetMultimap build() {
      return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder$LinkedHashSetSupplier(this.val$expectedValuesPerKey));
   }
}
