/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.MultimapBuilder$1;
import com.google.common.collect.SetMultimap;

public abstract class MultimapBuilder$SetMultimapBuilder
extends MultimapBuilder {
    MultimapBuilder$SetMultimapBuilder() {
        super(null);
    }

    @Override
    public abstract SetMultimap build();

    @Override
    public SetMultimap build(Multimap multimap) {
        return (SetMultimap)super.build(multimap);
    }
}

