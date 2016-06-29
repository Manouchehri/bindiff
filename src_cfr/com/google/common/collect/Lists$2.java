/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Lists$AbstractListWrapper;
import java.util.List;
import java.util.ListIterator;

final class Lists$2
extends Lists$AbstractListWrapper {
    private static final long serialVersionUID = 0;

    Lists$2(List list) {
        super(list);
    }

    @Override
    public ListIterator listIterator(int n2) {
        return this.backingList.listIterator(n2);
    }
}

