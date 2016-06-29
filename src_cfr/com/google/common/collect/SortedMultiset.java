/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedIterable;
import com.google.common.collect.SortedMultisetBridge;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;

@Beta
@GwtCompatible(emulated=1)
public interface SortedMultiset
extends SortedIterable,
SortedMultisetBridge {
    @Override
    public Comparator comparator();

    public Multiset$Entry firstEntry();

    public Multiset$Entry lastEntry();

    public Multiset$Entry pollFirstEntry();

    public Multiset$Entry pollLastEntry();

    @Override
    public NavigableSet elementSet();

    @Override
    public Set entrySet();

    @Override
    public Iterator iterator();

    public SortedMultiset descendingMultiset();

    public SortedMultiset headMultiset(Object var1, BoundType var2);

    public SortedMultiset subMultiset(Object var1, BoundType var2, Object var3, BoundType var4);

    public SortedMultiset tailMultiset(Object var1, BoundType var2);
}

