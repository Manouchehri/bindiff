package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$Row extends Maps$IteratorBasedAbstractMap
{
    final Object rowKey;
    Map backingRowMap;
    final /* synthetic */ StandardTable this$0;
    
    StandardTable$Row(final StandardTable this$0, final Object o) {
        this.this$0 = this$0;
        this.rowKey = Preconditions.checkNotNull(o);
    }
    
    Map backingRowMap() {
        return (this.backingRowMap == null || (this.backingRowMap.isEmpty() && this.this$0.backingMap.containsKey(this.rowKey))) ? (this.backingRowMap = this.computeBackingRowMap()) : this.backingRowMap;
    }
    
    Map computeBackingRowMap() {
        return this.this$0.backingMap.get(this.rowKey);
    }
    
    void maintainEmptyInvariant() {
        if (this.backingRowMap() != null && this.backingRowMap.isEmpty()) {
            this.this$0.backingMap.remove(this.rowKey);
            this.backingRowMap = null;
        }
    }
    
    @Override
    public boolean containsKey(final Object o) {
        final Map backingRowMap = this.backingRowMap();
        return o != null && backingRowMap != null && Maps.safeContainsKey(backingRowMap, o);
    }
    
    @Override
    public Object get(final Object o) {
        final Map backingRowMap = this.backingRowMap();
        return (o != null && backingRowMap != null) ? Maps.safeGet(backingRowMap, o) : null;
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(o2);
        if (this.backingRowMap != null && !this.backingRowMap.isEmpty()) {
            return this.backingRowMap.put(o, o2);
        }
        return this.this$0.put(this.rowKey, o, o2);
    }
    
    @Override
    public Object remove(final Object o) {
        final Map backingRowMap = this.backingRowMap();
        if (backingRowMap == null) {
            return null;
        }
        final Object safeRemove = Maps.safeRemove(backingRowMap, o);
        this.maintainEmptyInvariant();
        return safeRemove;
    }
    
    @Override
    public void clear() {
        final Map backingRowMap = this.backingRowMap();
        if (backingRowMap != null) {
            backingRowMap.clear();
        }
        this.maintainEmptyInvariant();
    }
    
    @Override
    public int size() {
        final Map backingRowMap = this.backingRowMap();
        return (backingRowMap == null) ? 0 : backingRowMap.size();
    }
    
    @Override
    Iterator entryIterator() {
        final Map backingRowMap = this.backingRowMap();
        if (backingRowMap == null) {
            return Iterators.emptyModifiableIterator();
        }
        return new StandardTable$Row$1(this, backingRowMap.entrySet().iterator());
    }
}
