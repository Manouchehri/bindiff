/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

class ImmutableMultimap$BuilderMultimap
extends AbstractMapBasedMultimap {
    private static final long serialVersionUID = 0;

    ImmutableMultimap$BuilderMultimap() {
        super(new LinkedHashMap());
    }

    @Override
    Collection createCollection() {
        return Lists.newArrayList();
    }
}

