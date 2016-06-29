/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import java.util.Map;

class Internal$MapAdapter$EntryAdapter
implements Map.Entry {
    private final Map.Entry realEntry;
    final /* synthetic */ Internal$MapAdapter this$0;

    public Internal$MapAdapter$EntryAdapter(Internal$MapAdapter mapAdapter, Map.Entry entry) {
        this.this$0 = mapAdapter;
        this.realEntry = entry;
    }

    public Object getKey() {
        return this.realEntry.getKey();
    }

    public Object getValue() {
        return Internal$MapAdapter.access$000(this.this$0).doForward(this.realEntry.getValue());
    }

    public Object setValue(Object object) {
        Object object2 = this.realEntry.setValue(Internal$MapAdapter.access$000(this.this$0).doBackward(object));
        if (object2 != null) return Internal$MapAdapter.access$000(this.this$0).doForward(object2);
        return null;
    }
}

