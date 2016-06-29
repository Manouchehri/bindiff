/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$4$1;
import com.google.common.collect.Sets$SetView;
import java.util.Iterator;
import java.util.Set;

final class Sets$4
extends Sets$SetView {
    final /* synthetic */ Set val$set1;
    final /* synthetic */ Set val$set2;

    Sets$4(Set set, Set set2) {
        this.val$set1 = set;
        this.val$set2 = set2;
        super(null);
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = this.val$set1.iterator();
        Iterator iterator2 = this.val$set2.iterator();
        return new Sets$4$1(this, iterator, iterator2);
    }

    @Override
    public int size() {
        return Iterators.size(this.iterator());
    }

    @Override
    public boolean isEmpty() {
        return this.val$set1.equals(this.val$set2);
    }

    @Override
    public boolean contains(Object object) {
        return this.val$set1.contains(object) ^ this.val$set2.contains(object);
    }
}

