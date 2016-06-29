/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$Itr;
import com.google.common.collect.Maps;
import java.util.Map;

class AbstractMapBasedMultimap$2
extends AbstractMapBasedMultimap$Itr {
    final /* synthetic */ AbstractMapBasedMultimap this$0;

    AbstractMapBasedMultimap$2(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        this.this$0 = abstractMapBasedMultimap;
        super(abstractMapBasedMultimap);
    }

    @Override
    Map.Entry output(Object object, Object object2) {
        return Maps.immutableEntry(object, object2);
    }
}

