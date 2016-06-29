/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.j2objc.annotations.Weak;
import java.util.ListIterator;

@GwtCompatible(emulated=1)
class RegularImmutableAsList
extends ImmutableAsList {
    @Weak
    private final ImmutableCollection delegate;
    private final ImmutableList delegateList;

    RegularImmutableAsList(ImmutableCollection immutableCollection, ImmutableList immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection immutableCollection, Object[] arrobject) {
        this(immutableCollection, ImmutableList.asImmutableList(arrobject));
    }

    @Override
    ImmutableCollection delegateCollection() {
        return this.delegate;
    }

    ImmutableList delegateList() {
        return this.delegateList;
    }

    @Override
    public UnmodifiableListIterator listIterator(int n2) {
        return this.delegateList.listIterator(n2);
    }

    @GwtIncompatible(value="not present in emulated superclass")
    @Override
    int copyIntoArray(Object[] arrobject, int n2) {
        return this.delegateList.copyIntoArray(arrobject, n2);
    }

    public Object get(int n2) {
        return this.delegateList.get(n2);
    }
}

