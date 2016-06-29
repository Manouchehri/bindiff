/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;

public abstract class MultimapBuilder$SortedSetMultimapBuilder
extends MultimapBuilder$SetMultimapBuilder {
    MultimapBuilder$SortedSetMultimapBuilder() {
    }

    @Override
    public abstract SortedSetMultimap build();

    @Override
    public SortedSetMultimap build(Multimap multimap) {
        return (SortedSetMultimap)super.build(multimap);
    }
}

