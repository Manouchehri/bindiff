/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.Interners$WeakInterner$Dummy;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;

class Interners$WeakInterner
implements Interner {
    private final MapMakerInternalMap map = new MapMaker().weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();

    private Interners$WeakInterner() {
    }

    @Override
    public Object intern(Object object) {
        Object object2;
        do {
            MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry;
            if ((mapMakerInternalMap$ReferenceEntry = this.map.getEntry(object)) == null || (object2 = mapMakerInternalMap$ReferenceEntry.getKey()) == null) continue;
            return object2;
        } while ((object2 = (Interners$WeakInterner$Dummy)((Object)this.map.putIfAbsent(object, (Object)Interners$WeakInterner$Dummy.VALUE))) != null);
        return object;
    }

    /* synthetic */ Interners$WeakInterner(Interners$1 interners$1) {
        this();
    }
}

