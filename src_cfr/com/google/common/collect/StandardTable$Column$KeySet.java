/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;
import java.util.Map;

class StandardTable$Column$KeySet
extends Maps$KeySet {
    final /* synthetic */ StandardTable$Column this$1;

    StandardTable$Column$KeySet(StandardTable$Column standardTable$Column) {
        this.this$1 = standardTable$Column;
        super(standardTable$Column);
    }

    @Override
    public boolean contains(Object object) {
        return this.this$1.this$0.contains(object, this.this$1.columnKey);
    }

    @Override
    public boolean remove(Object object) {
        if (this.this$1.this$0.remove(object, this.this$1.columnKey) == null) return false;
        return true;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}

