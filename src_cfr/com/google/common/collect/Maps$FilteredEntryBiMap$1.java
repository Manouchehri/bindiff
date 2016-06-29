/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map;

final class Maps$FilteredEntryBiMap$1
implements Predicate {
    final /* synthetic */ Predicate val$forwardPredicate;

    Maps$FilteredEntryBiMap$1(Predicate predicate) {
        this.val$forwardPredicate = predicate;
    }

    public boolean apply(Map.Entry entry) {
        return this.val$forwardPredicate.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
    }
}

