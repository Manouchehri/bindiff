package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

class StandardTable$Column extends Maps$ViewCachingAbstractMap
{
    final Object columnKey;
    final /* synthetic */ StandardTable this$0;
    
    StandardTable$Column(final StandardTable this$0, final Object o) {
        this.this$0 = this$0;
        this.columnKey = Preconditions.checkNotNull(o);
    }
    
    @Override
    public Object put(final Object o, final Object o2) {
        return this.this$0.put(o, this.columnKey, o2);
    }
    
    @Override
    public Object get(final Object o) {
        return this.this$0.get(o, this.columnKey);
    }
    
    @Override
    public boolean containsKey(final Object o) {
        return this.this$0.contains(o, this.columnKey);
    }
    
    @Override
    public Object remove(final Object o) {
        return this.this$0.remove(o, this.columnKey);
    }
    
    boolean removeFromColumnIf(final Predicate predicate) {
        boolean b = false;
        final Iterator<Map.Entry<K, Map>> iterator = this.this$0.backingMap.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<K, Map> entry = iterator.next();
            final Map<K, Object> map = entry.getValue();
            final Object value = map.get(this.columnKey);
            if (value != null && predicate.apply(Maps.immutableEntry(entry.getKey(), value))) {
                map.remove(this.columnKey);
                b = true;
                if (!map.isEmpty()) {
                    continue;
                }
                iterator.remove();
            }
        }
        return b;
    }
    
    @Override
    Set createEntrySet() {
        return new StandardTable$Column$EntrySet(this, null);
    }
    
    @Override
    Set createKeySet() {
        return new StandardTable$Column$KeySet(this);
    }
    
    @Override
    Collection createValues() {
        return new StandardTable$Column$Values(this);
    }
}
