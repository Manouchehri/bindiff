package com.google.common.collect;

import com.google.common.collect.MultimapBuilder$EnumSetSupplier;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;

class MultimapBuilder$MultimapBuilderWithKeys$6 extends MultimapBuilder$SetMultimapBuilder {
   // $FF: synthetic field
   final Class val$valueClass;
   // $FF: synthetic field
   final MultimapBuilder$MultimapBuilderWithKeys this$0;

   MultimapBuilder$MultimapBuilderWithKeys$6(MultimapBuilder$MultimapBuilderWithKeys var1, Class var2) {
      this.this$0 = var1;
      this.val$valueClass = var2;
   }

   public SetMultimap build() {
      MultimapBuilder$EnumSetSupplier var1 = new MultimapBuilder$EnumSetSupplier(this.val$valueClass);
      return Multimaps.newSetMultimap(this.this$0.createMap(), var1);
   }
}
