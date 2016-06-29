/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$Itr;
import com.google.common.collect.Maps;
import java.util.Map;

class ImmutableMultimap$1
extends ImmutableMultimap$Itr {
    final /* synthetic */ ImmutableMultimap this$0;

    ImmutableMultimap$1(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
        super(immutableMultimap, null);
    }

    @Override
    Map.Entry output(Object object, Object object2) {
        return Maps.immutableEntry(object, object2);
    }
}

