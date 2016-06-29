/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SubSet;
import java.util.Set;

class Sets$PowerSet$1
extends AbstractIndexedListIterator {
    final /* synthetic */ Sets$PowerSet this$0;

    Sets$PowerSet$1(Sets$PowerSet powerSet, int n2) {
        this.this$0 = powerSet;
        super(n2);
    }

    @Override
    protected Set get(int n2) {
        return new Sets$SubSet(this.this$0.inputSet, n2);
    }
}

