package com.google.common.cache;

import java.util.*;
import javax.annotation.*;

final class LocalCache$WriteThroughEntry implements Entry
{
    final Object key;
    Object value;
    final /* synthetic */ LocalCache this$0;
    
    LocalCache$WriteThroughEntry(final LocalCache this$0, final Object key, final Object value) {
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
    public Object setValue(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.getKey());
        final String value2 = String.valueOf(this.getValue());
        return new StringBuilder(1 + String.valueOf(value).length() + String.valueOf(value2).length()).append(value).append("=").append(value2).toString();
    }
}
