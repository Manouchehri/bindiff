package com.google.common.collect;

final class MapMakerInternalMap$KeyIterator extends MapMakerInternalMap$HashIterator
{
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$KeyIterator(final MapMakerInternalMap this$0) {
        this.this$0 = this$0;
        super(this$0);
    }
    
    @Override
    public Object next() {
        return this.nextEntry().getKey();
    }
}
