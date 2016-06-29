/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Set;

abstract class ImmutableMap$IteratorBasedImmutableMap
extends ImmutableMap {
    ImmutableMap$IteratorBasedImmutableMap() {
    }

    abstract UnmodifiableIterator entryIterator();

    @Override
    ImmutableSet createEntrySet() {
        return new ImmutableMap$IteratorBasedImmutableMap$1EntrySetImpl(this);
    }
}

