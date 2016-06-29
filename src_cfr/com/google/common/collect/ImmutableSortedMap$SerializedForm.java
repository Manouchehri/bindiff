/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap$SerializedForm;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedMap$Builder;
import java.util.Comparator;

class ImmutableSortedMap$SerializedForm
extends ImmutableMap$SerializedForm {
    private final Comparator comparator;
    private static final long serialVersionUID = 0;

    ImmutableSortedMap$SerializedForm(ImmutableSortedMap immutableSortedMap) {
        super(immutableSortedMap);
        this.comparator = immutableSortedMap.comparator();
    }

    @Override
    Object readResolve() {
        ImmutableSortedMap$Builder immutableSortedMap$Builder = new ImmutableSortedMap$Builder(this.comparator);
        return this.createMap(immutableSortedMap$Builder);
    }
}

