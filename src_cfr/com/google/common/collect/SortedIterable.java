/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible
interface SortedIterable
extends Iterable {
    public Comparator comparator();

    public Iterator iterator();
}

