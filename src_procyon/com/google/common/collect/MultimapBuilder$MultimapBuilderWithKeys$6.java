package com.google.common.collect;

import com.google.common.base.*;

class MultimapBuilder$MultimapBuilderWithKeys$6 extends MultimapBuilder$SetMultimapBuilder
{
    final /* synthetic */ Class val$valueClass;
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    
    MultimapBuilder$MultimapBuilderWithKeys$6(final MultimapBuilder$MultimapBuilderWithKeys this$0, final Class val$valueClass) {
        this.this$0 = this$0;
        this.val$valueClass = val$valueClass;
    }
    
    @Override
    public SetMultimap build() {
        return Multimaps.newSetMultimap(this.this$0.createMap(), new MultimapBuilder$EnumSetSupplier(this.val$valueClass));
    }
}
