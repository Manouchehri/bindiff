/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.FluentIterable;
import java.util.Iterator;
import java.util.List;

final class Iterables$10
extends FluentIterable {
    final /* synthetic */ List val$list;
    final /* synthetic */ int val$numberToSkip;

    Iterables$10(List list, int n2) {
        this.val$list = list;
        this.val$numberToSkip = n2;
    }

    public Iterator iterator() {
        int n2 = Math.min(this.val$list.size(), this.val$numberToSkip);
        return this.val$list.subList(n2, this.val$list.size()).iterator();
    }
}

