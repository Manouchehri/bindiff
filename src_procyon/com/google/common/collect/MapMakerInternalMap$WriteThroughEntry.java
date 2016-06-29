package com.google.common.collect;

import javax.annotation.*;
import java.util.*;

final class MapMakerInternalMap$WriteThroughEntry extends AbstractMapEntry
{
    final Object key;
    Object value;
    final /* synthetic */ MapMakerInternalMap this$0;
    
    MapMakerInternalMap$WriteThroughEntry(final MapMakerInternalMap this$0, final Object key, final Object value) {
        this.this$0 = this$0;
        this.key = key;
        this.value = value;
    }
    
    @Override
    public Object getKey() {
        return this.key;
    }
    
    @Override
    public Object getValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Entry) {
            final Entry entry = (Entry)o;
            return this.key.equals(entry.getKey()) && this.value.equals(entry.getValue());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.key.hashCode() ^ this.value.hashCode();
    }
    
    @Override
    public Object setValue(final Object value) {
        final Object put = this.this$0.put(this.key, value);
        this.value = value;
        return put;
    }
}
