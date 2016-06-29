package com.google.common.collect;

enum MapMakerInternalMap$NullEntry implements MapMakerInternalMap$ReferenceEntry
{
    INSTANCE("INSTANCE", 0);
    
    private MapMakerInternalMap$NullEntry(final String s, final int n) {
    }
    
    @Override
    public MapMakerInternalMap$ValueReference getValueReference() {
        return null;
    }
    
    @Override
    public void setValueReference(final MapMakerInternalMap$ValueReference mapMakerInternalMap$ValueReference) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNext() {
        return null;
    }
    
    @Override
    public int getHash() {
        return 0;
    }
    
    @Override
    public Object getKey() {
        return null;
    }
    
    @Override
    public long getExpirationTime() {
        return 0L;
    }
    
    @Override
    public void setExpirationTime(final long n) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextExpirable() {
        return this;
    }
    
    @Override
    public void setNextExpirable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousExpirable() {
        return this;
    }
    
    @Override
    public void setPreviousExpirable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getNextEvictable() {
        return this;
    }
    
    @Override
    public void setNextEvictable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }
    
    @Override
    public MapMakerInternalMap$ReferenceEntry getPreviousEvictable() {
        return this;
    }
    
    @Override
    public void setPreviousEvictable(final MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry) {
    }
}
