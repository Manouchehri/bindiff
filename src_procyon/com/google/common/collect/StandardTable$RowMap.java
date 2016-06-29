package com.google.common.collect;

import java.util.*;

class StandardTable$RowMap extends Maps$ViewCachingAbstractMap
{
    final /* synthetic */ StandardTable this$0;
    
    StandardTable$RowMap(final StandardTable this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.this$0.containsRow(o);
    }
    
    @Override
    public Map get(final Object o) {
        return this.this$0.containsRow(o) ? this.this$0.row(o) : null;
    }
    
    @Override
    public Map remove(final Object o) {
        return (o == null) ? null : this.this$0.backingMap.remove(o);
    }
    
    protected Set createEntrySet() {
        return new StandardTable$RowMap$EntrySet(this);
    }
}
