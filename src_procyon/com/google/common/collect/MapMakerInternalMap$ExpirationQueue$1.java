package com.google.common.collect;

class MapMakerInternalMap$ExpirationQueue$1 extends MapMakerInternalMap$AbstractReferenceEntry
{
    MapMakerInternalMap$ReferenceEntry nextExpirable;
    MapMakerInternalMap$ReferenceEntry previousExpirable;
    final /* synthetic */ MapMakerInternalMap$ExpirationQueue this$0;
    
    MapMakerInternalMap$ExpirationQueue$1(final MapMakerInternalMap$ExpirationQueue this$0) {
        this.this$0 = this$0;
        this.nextExpirable = this;
        this.previousExpirable = this;
    }
    
    @Override
    public long getExpirationTime() {
        return Long.MAX_VALUE;
    }
    
    @Override
    public void setExpirationTime(final long n) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        return this.nextExpirable;
    }
    
    @Override
    public void setNextExpirable(final MapMakerInternalMap$ReferenceEntry nextExpirable) {
        this.nextExpirable = nextExpirable;
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        return this.previousExpirable;
    }
    
    @Override
    public void setPreviousExpirable(final MapMakerInternalMap$ReferenceEntry previousExpirable) {
        this.previousExpirable = previousExpirable;
    }
}
