/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

class ImmutableSetMultimap$BuilderMultimap
extends AbstractMapBasedMultimap {
    private static final long serialVersionUID = 0;

    ImmutableSetMultimap$BuilderMultimap() {
        super(new LinkedHashMap());
    }

    @Override
    Collection createCollection() {
        return Sets.newLinkedHashSet();
    }
}

