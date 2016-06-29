package com.google.common.collect;

import com.google.common.base.*;

class MultimapBuilder$MultimapBuilderWithKeys$1 extends MultimapBuilder$ListMultimapBuilder
{
    final /* synthetic */ int val$expectedValuesPerKey;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    
    MultimapBuilder$MultimapBuilderWithKeys$1(final MultimapBuilder$MultimapBuilderWithKeys this$0, final int val$expectedValuesPerKey) {
        this.this$0 = this$0;
        this.val$expectedValuesPerKey = val$expectedValuesPerKey;
    }
    
    @Override
    public ListMultimap build() {
        return Multimaps.newListMultimap(this.this$0.createMap(), new MultimapBuilder$ArrayListSupplier(this.val$expectedValuesPerKey));
    }
}
