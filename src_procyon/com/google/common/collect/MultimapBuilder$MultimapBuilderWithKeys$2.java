package com.google.common.collect;

class MultimapBuilder$MultimapBuilderWithKeys$2 extends MultimapBuilder$ListMultimapBuilder
{
    final /* synthetic */ MultimapBuilder$MultimapBuilderWithKeys this$0;
    
    MultimapBuilder$MultimapBuilderWithKeys$2(final MultimapBuilder$MultimapBuilderWithKeys this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public ListMultimap build() {
        return Multimaps.newListMultimap(this.this$0.createMap(), MultimapBuilder$LinkedListSupplier.instance());
    }
}
