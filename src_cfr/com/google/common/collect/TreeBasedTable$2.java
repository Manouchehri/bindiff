/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.TreeBasedTable;
import java.util.Comparator;
import java.util.Iterator;

class TreeBasedTable$2
extends AbstractIterator {
    Object lastValue;
    final /* synthetic */ Iterator val$merged;
    final /* synthetic */ Comparator val$comparator;
    final /* synthetic */ TreeBasedTable this$0;

    TreeBasedTable$2(TreeBasedTable treeBasedTable, Iterator iterator, Comparator comparator) {
        this.this$0 = treeBasedTable;
        this.val$merged = iterator;
        this.val$comparator = comparator;
    }

    @Override
    protected Object computeNext() {
        Object e2;
        boolean bl2;
        do {
            if (!this.val$merged.hasNext()) {
                this.lastValue = null;
                return this.endOfData();
            }
            e2 = this.val$merged.next();
        } while (bl2 = this.lastValue != null && this.val$comparator.compare(e2, this.lastValue) == 0);
        this.lastValue = e2;
        return this.lastValue;
    }
}

