package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder$LinkedListSupplier;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.Multimaps;

class MultimapBuilder$MultimapBuilderWithKeys$2 extends MultimapBuilder$ListMultimapBuilder {
   // $FF: synthetic field
   final MultimapBuilder$MultimapBuilderWithKeys this$0;

   MultimapBuilder$MultimapBuilderWithKeys$2(MultimapBuilder$MultimapBuilderWithKeys var1) {
      this.this$0 = var1;
   }

   public ListMultimap build() {
      return Multimaps.newListMultimap(this.this$0.createMap(), MultimapBuilder$LinkedListSupplier.instance());
   }
}
