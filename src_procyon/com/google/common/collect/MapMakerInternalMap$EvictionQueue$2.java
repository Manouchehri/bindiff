package com.google.common.collect;

class MapMakerInternalMap$EvictionQueue$2 extends AbstractSequentialIterator
{
    final /* synthetic */ MapMakerInternalMap$EvictionQueue this$0;
    
    MapMakerInternalMap$EvictionQueue$2(final MapMakerInternalMap$EvictionQueue this$0, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.this$0 = this$0;
        super(mapMakerInternalMap$ReferenceEntry);
    }
    
    protected MapMakerInternalMap$ReferenceEntry computeNext(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        final MapMakerInternalMap$ReferenceEntry nextEvictable = mapMakerInternalMap$ReferenceEntry.getNextEvictable();
        return (nextEvictable == this.this$0.head) ? null : nextEvictable;
    }
}
