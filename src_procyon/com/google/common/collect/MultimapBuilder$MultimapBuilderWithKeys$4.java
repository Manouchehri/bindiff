package com.google.common.collect;

import com.google.common.base.*;

class MultimapBuilder$MultimapBuilderWithKeys$4 extends MultimapBuilder$SetMultimapBuilder
{
    final /* synthetic */ int val$expectedValuesPerKey;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    
    MultimapBuilder$MultimapBuilderWithKeys$4(final MultimapBuilder$MultimapBuilderWithKeys this$0, final int val$expectedValuesPerKey) {
        this.this$0 = this$0;
        this.val$expectedValuesPerKey = val$expectedValuesPerKey;
    }
    
    @Override
    public SetMultimap build() {
        return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder$LinkedHashSetSupplier(this.val$expectedValuesPerKey));
    }
}