/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.StandardTable$Column;
import java.util.Collection;
import java.util.Map;

class StandardTable$Column$Values
extends Maps$Values {
    final /* synthetic */ StandardTable$Column this$1;

    StandardTable$Column$Values(StandardTable$Column standardTable$Column) {
        this.this$1 = standardTable$Column;
        super(standardTable$Column);
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) return false;
        if (!this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(object)))) return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(collection)));
    }

    @Override
    public boolean retainAll(Collection collection) {
        return this.this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(collection))));
    }
}

