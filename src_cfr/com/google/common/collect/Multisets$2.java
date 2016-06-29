/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$2$1;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

final class Multisets$2
extends AbstractMultiset {
    final /* synthetic */ Multiset val$multiset1;
    final /* synthetic */ Multiset val$multiset2;

    Multisets$2(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
    }

    @Override
    public int count(Object object) {
        int n2 = this.val$multiset1.count(object);
        if (n2 == 0) {
            return 0;
        }
        int n3 = Math.min(n2, this.val$multiset2.count(object));
        return n3;
    }

    @Override
    Set createElementSet() {
        return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
    }

    @Override
    Iterator entryIterator() {
        Iterator iterator = this.val$multiset1.entrySet().iterator();
        return new Multisets$2$1(this, iterator);
    }

    @Override
    int distinctElements() {
        return this.elementSet().size();
    }
}

