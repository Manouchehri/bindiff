/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Set;
import java.util.SortedSet;

interface SortedMultisetBridge
extends Multiset {
    @Override
    public SortedSet elementSet();
}

