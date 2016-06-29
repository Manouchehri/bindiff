/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder$1;

public abstract class MultimapBuilder$ListMultimapBuilder
extends MultimapBuilder {
    MultimapBuilder$ListMultimapBuilder() {
        super(null);
    }

    @Override
    public abstract ListMultimap build();

    @Override
    public ListMultimap build(Multimap multimap) {
        return (ListMultimap)super.build(multimap);
    }
}

