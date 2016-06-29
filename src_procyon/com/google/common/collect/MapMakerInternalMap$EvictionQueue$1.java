package com.google.common.collect;

class MapMakerInternalMap$EvictionQueue$1 extends MapMakerInternalMap$AbstractReferenceEntry
{
    MapMakerInternalMap$ReferenceEntry nextEvictable;
    MapMakerInternalMap$ReferenceEntry previousEvictable;
    final /* synthetic */ MapMakerInternalMap$EvictionQueue this$0;
    
    MapMakerInternalMap$EvictionQueue$1(final MapMakerInternalMap$EvictionQueue this$0) {
        this.this$0 = this$0;
        this.nextEvictable = this;
        this.previousEvictable = this;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        return this.nextEvictable;
    }
    
    @Override
    public void setNextEvictable(final MapMakerInternalMap$ReferenceEntry nextEvictable) {
        this.nextEvictable = nextEvictable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        return this.previousEvictable;
    }
    
    @Override
    public void setPreviousEvictable(final MapMakerInternalMap$ReferenceEntry previousEvictable) {
        this.previousEvictable = previousEvictable;
    }
}
