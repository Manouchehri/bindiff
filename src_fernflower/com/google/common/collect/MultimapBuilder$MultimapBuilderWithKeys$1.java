package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder$ArrayListSupplier;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Multimaps;

class MultimapBuilder$MultimapBuilderWithKeys$1 extends MultimapBuilder$ListMultimapBuilder {
   // $FF: synthetic field
   final int val$expectedValuesPerKey;
   // $FF: synthetic field
   final MultimapBuilder$MultimapBuilderWithKeys this$0;

   MultimapBuilder$MultimapBuilderWithKeys$1(MultimapBuilder$MultimapBuilderWithKeys var1, int var2) {
      this.this$0 = var1;
      this.val$expectedValuesPerKey = var2;
   }

   public ListMultimap build() {
      return Multimaps.newListMultimap(this.this$0.createMap(), new MultimapBuilder$ArrayListSupplier(this.val$expectedValuesPerKey));
   }
}
