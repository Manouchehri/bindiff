/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableCollection$ArrayBasedBuilder;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public final class ImmutableList$Builder
extends ImmutableCollection$ArrayBasedBuilder {
    public ImmutableList$Builder() {
        this(4);
    }

    ImmutableList$Builder(int n2) {
        super(n2);
    }

    @Override
    public ImmutableList$Builder add(Object object) {
        super.add(object);
        return this;
    }

    @Override
    public ImmutableList$Builder addAll(Iterable iterable) {
        super.addAll(iterable);
        return this;
    }

    @Override
    public /* varargs */ ImmutableList$Builder add(Object ... arrobject) {
        super.add(arrobject);
        return this;
    }

    @Override
    public ImmutableList$Builder addAll(Iterator iterator) {
        super.addAll(iterator);
        return this;
    }

    @Override
    public ImmutableList build() {
        return ImmutableList.asImmutableList(this.contents, this.size);
    }
}

