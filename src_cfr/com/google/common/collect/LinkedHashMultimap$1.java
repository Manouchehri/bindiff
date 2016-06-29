/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class LinkedHashMultimap$1
implements Iterator {
    LinkedHashMultimap$ValueEntry nextEntry;
    LinkedHashMultimap$ValueEntry toRemove;
    final /* synthetic */ LinkedHashMultimap this$0;

    LinkedHashMultimap$1(LinkedHashMultimap linkedHashMultimap) {
        this.this$0 = linkedHashMultimap;
        this.nextEntry = LinkedHashMultimap.access$300((LinkedHashMultimap)this.this$0).successorInMultimap;
    }

    @Override
    public boolean hasNext() {
        if (this.nextEntry == LinkedHashMultimap.access$300(this.this$0)) return false;
        return true;
    }

    public Map.Entry next() {
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.toRemove = linkedHashMultimap$ValueEntry = this.nextEntry;
        this.nextEntry = this.nextEntry.successorInMultimap;
        return linkedHashMultimap$ValueEntry;
    }

    @Override
    public void remove() {
        CollectPreconditions.checkRemove(this.toRemove != null);
        this.this$0.remove(this.toRemove.getKey(), this.toRemove.getValue());
        this.toRemove = null;
    }
}

