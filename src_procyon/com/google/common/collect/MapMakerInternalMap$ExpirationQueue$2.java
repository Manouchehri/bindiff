package com.google.common.collect;

class MapMakerInternalMap$ExpirationQueue$2 extends AbstractSequentialIterator
{
    final /* synthetic */ MapMakerInternalMap$ExpirationQueue this$0;
    
    MapMakerInternalMap$ExpirationQueue$2(final MapMakerInternalMap$ExpirationQueue this$0, final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        this.this$0 = this$0;
        super(mapMakerInternalMap$ReferenceEntry);
    }
    
    protected MapMakerInternalMap$ReferenceEntry computeNext(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
        final MapMakerInternalMap$ReferenceEntry nextExpirable = mapMakerInternalMap$ReferenceEntry.getNextExpirable();
        return (nextExpirable == this.this$0.head) ? null : nextExpirable;
    }
}
