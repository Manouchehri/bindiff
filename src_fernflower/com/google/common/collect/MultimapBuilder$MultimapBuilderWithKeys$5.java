package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SortedSetMultimapBuilder;
import com.google.common.collect.MultimapBuilder$TreeSetSupplier;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SortedSetMultimap;
import java.util.Comparator;

class MultimapBuilder$MultimapBuilderWithKeys$5 extends MultimapBuilder$SortedSetMultimapBuilder {
   // $FF: synthetic field
   final Comparator val$comparator;
   // $FF: synthetic field
   final MultimapBuilder$MultimapBuilderWithKeys this$0;

   MultimapBuilder$MultimapBuilderWithKeys$5(MultimapBuilder$MultimapBuilderWithKeys var1, Comparator var2) {
      this.this$0 = var1;
      this.val$comparator = var2;
   }

   public SortedSetMultimap build() {
      return Multimaps.newSortedSetMultimap(this.this$0.createMap(), new MultimapBuilder$TreeSetSupplier(this.val$comparator));
   }
}
