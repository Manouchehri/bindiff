/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists$TransformingSequentialList$1;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

class Lists$TransformingSequentialList
extends AbstractSequentialList
implements Serializable {
    final List fromList;
    final Function function;
    private static final long serialVersionUID = 0;

    Lists$TransformingSequentialList(List list, Function function) {
        this.fromList = (List)Preconditions.checkNotNull(list);
        this.function = (Function)Preconditions.checkNotNull(function);
    }

    @Override
    public void clear() {
        this.fromList.clear();
    }

    @Override
    public int size() {
        return this.fromList.size();
    }

    @Override
    public ListIterator listIterator(int n2) {
        return new Lists$TransformingSequentialList$1(this, this.fromList.listIterator(n2));
    }
}

