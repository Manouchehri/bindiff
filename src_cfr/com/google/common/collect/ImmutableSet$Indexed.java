/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet$Indexed$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;

abstract class ImmutableSet$Indexed
extends ImmutableSet {
    ImmutableSet$Indexed() {
    }

    abstract Object get(int var1);

    @Override
    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    @Override
    ImmutableList createAsList() {
        return new ImmutableSet$Indexed$1(this);
    }
}

