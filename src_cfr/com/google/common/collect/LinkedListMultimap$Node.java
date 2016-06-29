/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import javax.annotation.Nullable;

final class LinkedListMultimap$Node
extends AbstractMapEntry {
    final Object key;
    Object value;
    LinkedListMultimap$Node next;
    LinkedListMultimap$Node previous;
    LinkedListMultimap$Node nextSibling;
    LinkedListMultimap$Node previousSibling;

    LinkedListMultimap$Node(@Nullable Object object, @Nullable Object object2) {
        this.key = object;
        this.value = object2;
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
    public Object setValue(@Nullable Object object) {
        Object object2 = this.value;
        this.value = object;
        return object2;
    }
}

