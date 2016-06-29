package com.google.common.collect;

import javax.annotation.*;

final class LinkedListMultimap$Node extends AbstractMapEntry
{
    final Object key;
    Object value;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node previous;
    LinkedListMultimap$Node nextSibling;
    LinkedListMultimap$Node previousSibling;
    
    LinkedListMultimap$Node(@Nullable final Object key, @Nullable final Object value) {
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
    public Object setValue(@Nullable final Object value) {
        final Object value2 = this.value;
        this.value = value;
        return value2;
    }
}
