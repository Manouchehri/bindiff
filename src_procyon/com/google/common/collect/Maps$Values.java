package com.google.common.collect;

import com.google.j2objc.annotations.*;
import com.google.common.base.*;
import java.util.*;
import javax.annotation.*;

class Maps$Values extends AbstractCollection
{
    @Weak
    final Map map;
    
    Maps$Values(final Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }
    
    final Map map() {
        return this.map;
    }
    
    @Override
    public Iterator iterator() {
        return Maps.valueIterator(this.map().entrySet().iterator());
    }
    
    @Override
    public boolean remove(final Object o) {
        try {
            return super.remove(o);
        }
        catch (UnsupportedOperationException ex) {
            for (final Map.Entry<K, Object> entry : this.map().entrySet()) {
                if (Objects.equal(o, entry.getValue())) {
                    this.map().remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }
    
    @Override
    public boolean removeAll(final Collection collection) {
        try {
            return super.removeAll((Collection<?>)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException ex) {
            final HashSet hashSet = Sets.newHashSet();
            for (final Map.Entry<K, Object> entry : this.map().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.map().keySet().removeAll(hashSet);
        }
    }
    
    @Override
    public boolean retainAll(final Collection collection) {
        try {
            return super.retainAll((Collection<?>)Preconditions.checkNotNull(collection));
        }
        catch (UnsupportedOperationException ex) {
            final HashSet hashSet = Sets.newHashSet();
            for (final Map.Entry<K, Object> entry : this.map().entrySet()) {
                if (collection.contains(entry.getValue())) {
                    hashSet.add(entry.getKey());
                }
            }
            return this.map().keySet().retainAll(hashSet);
        }
    }
    
    @Override
    public int size() {
        return this.map().size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.map().isEmpty();
    }
    
    @Override
    public boolean contains(@Nullable final Object o) {
        return this.map().containsValue(o);
    }
    
    @Override
    public void clear() {
        this.map().clear();
    }
}
