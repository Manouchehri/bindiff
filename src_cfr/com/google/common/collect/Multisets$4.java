/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$4$1;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$4
extends AbstractMultiset {
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;

    Multisets$4(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
    }

    @Override
    public int count(@Nullable Object object) {
        int n2 = this.val$multiset1.count(object);
        if (n2 == 0) {
            return 0;
        }
        int n3 = Math.max(0, n2 - this.val$multiset2.count(object));
        return n3;
    }

    @Override
    Iterator entryIterator() {
        Iterator iterator = this.val$multiset1.entrySet().iterator();
        return new Multisets$4$1(this, iterator);
    }

    @Override
    int distinctElements() {
        return Iterators.size(this.entryIterator());
    }
}

