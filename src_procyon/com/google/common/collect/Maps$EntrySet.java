package com.google.common.collect;

import com.google.common.base.*;
import java.util.*;

abstract class Maps$EntrySet extends Sets$ImprovedAbstractSet
{
    abstract Map map();
    
    @Override
    public int size() {
        return this.map().size();
    }
    
    @Override
    public void clear() {
        this.map().clear();
    }
    
    @Override
    public boolean contains(final Object o) {
        if (o instanceof Map.Entry) {
            final Map.Entry entry = (Map.Entry)o;
            final Object key = entry.getKey();
            final Object safeGet = Maps.safeGet(this.map(), key);
            return Objects.equal(safeGet, entry.getValue()) && (safeGet != null || this.map().containsKey(key));
        }
        return false;
    }
    
    @Override
    public boolean isEmpty() {
        return this.map().isEmpty();
    }
    
    @Override
    public boolean remove(final Object o) {
        return this.contains(o) && this.map().keySet().remove(((Map.Entry)o).getKey());
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        try {
            return super.removeAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException ex) {
            return Sets.removeAllImpl(this, collection.iterator());
        }
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        try {
            return super.retainAll((Collection)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException ex) {
            final HashSet hashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
            for (final Map.Entry<Object, V> next : collection) {
                if (this.contains(next)) {
                    hashSetWithExpectedSize.add(next.getKey());
                }
            }
            return this.map().keySet().retainAll(hashSetWithExpectedSize);
        }
    }
}
