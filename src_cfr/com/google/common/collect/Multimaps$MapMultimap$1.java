/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$MapMultimap$1$1;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;
import java.util.Map;

class Multimaps$MapMultimap$1
extends Sets$ImprovedAbstractSet {
    final /* synthetic */ Object val$key;
    final /* synthetic */ Multimaps$MapMultimap this$0;

    Multimaps$MapMultimap$1(Multimaps$MapMultimap multimaps$MapMultimap, Object object) {
        this.this$0 = multimaps$MapMultimap;
        this.val$key = object;
    }

    @Override
    public Iterator iterator() {
        return new Multimaps$MapMultimap$1$1(this);
    }

    @Override
    public int size() {
        if (!this.this$0.map.containsKey(this.val$key)) return 0;
        return 1;
    }
}

