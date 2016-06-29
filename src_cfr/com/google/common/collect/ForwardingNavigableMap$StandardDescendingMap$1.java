/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;

class ForwardingNavigableMap$StandardDescendingMap$1
implements Iterator {
    private Map.Entry toRemove;
    private Map.Entry nextOrNull;
    final /* synthetic */ ForwardingNavigableMap$StandardDescendingMap this$1;

    ForwardingNavigableMap$StandardDescendingMap$1(ForwardingNavigableMap$StandardDescendingMap forwardingNavigableMap$StandardDescendingMap) {
        this.this$1 = forwardingNavigableMap$StandardDescendingMap;
        this.toRemove = null;
        this.nextOrNull = this.this$1.forward().lastEntry();
    }

    @Override
    public boolean hasNext() {
        if (this.nextOrNull == null) return false;
        return true;
    }

    public Map.Entry next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            Map.Entry entry = this.nextOrNull;
            return entry;
        }
        finally {
            this.toRemove = this.nextOrNull;
            this.nextOrNull = this.this$1.forward().lowerEntry(this.nextOrNull.getKey());
        }
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$1.forward().remove(this.toRemove.getKey());
        this.toRemove = null;
    }
}

