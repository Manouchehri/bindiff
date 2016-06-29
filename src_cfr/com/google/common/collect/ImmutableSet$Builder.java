/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;

public class ImmutableSet$Builder
extends ImmutableCollection$ArrayBasedBuilder {
    public ImmutableSet$Builder() {
        this(4);
    }

    ImmutableSet$Builder(int n2) {
        super(n2);
    }

    @Override
    public ImmutableSet$Builder add(Object object) {
        super.add(object);
        return this;
    }

    @Override
    public /* varargs */ ImmutableSet$Builder add(Object ... arrobject) {
        super.add(arrobject);
        return this;
    }

    @Override
    public ImmutableSet$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    @Override
    public ImmutableSet$Builder addAll(Iterator iterator) {
        super.addAll(iterator);
        return this;
    }

    @Override
    public ImmutableSet build() {
        ImmutableSet immutableSet = ImmutableSet.access$000(this.size, this.contents);
        this.size = immutableSet.size();
        return immutableSet;
    }
}

