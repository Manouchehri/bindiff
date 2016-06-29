/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import com.google.protobuf.Internal$MapAdapter$IteratorAdapter;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

class Internal$MapAdapter$SetAdapter
extends AbstractSet {
    private final Set realSet;
    final /* synthetic */ Internal$MapAdapter this$0;

    public Internal$MapAdapter$SetAdapter(Internal$MapAdapter internal$MapAdapter, Set set) {
        this.this$0 = internal$MapAdapter;
        this.realSet = set;
    }

    @Override
    public Iterator iterator() {
        return new Internal$MapAdapter$IteratorAdapter(this.this$0, this.realSet.iterator());
    }

    @Override
    public int size() {
        return this.realSet.size();
    }
}

