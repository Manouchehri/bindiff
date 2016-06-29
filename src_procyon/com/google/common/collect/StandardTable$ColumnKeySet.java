package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

class StandardTable$ColumnKeySet extends StandardTable$TableSet
{
    final /* synthetic */ StandardTable this$0;
    
    private StandardTable$ColumnKeySet(final StandardTable this$0) {
        this.this$0 = this$0;
        super(this$0, null);
    }
    
    @Override
    public Iterator iterator() {
        return this.this$0.createColumnKeyIterator();
    }
    
    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }
    
    @Override
    public boolean remove(final Object o) {
        if (o == null) {
            return false;
        }
        boolean b = false;
        final Iterator<Map> iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            final Map map = iterator.next();
            if (map.keySet().remove(o)) {
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
    public boolean removeAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean b = false;
        final Iterator<Map> iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            final Map map = iterator.next();
            if (Iterators.removeAll(map.keySet().iterator(), collection)) {
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
    public boolean retainAll(final Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean b = false;
        final Iterator<Map> iterator = this.this$0.backingMap.values().iterator();
        while (iterator.hasNext()) {
            final Map map = iterator.next();
            if (map.keySet().retainAll(collection)) {
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
    public boolean contains(final Object o) {
        return this.this$0.containsColumn(o);
    }
}
