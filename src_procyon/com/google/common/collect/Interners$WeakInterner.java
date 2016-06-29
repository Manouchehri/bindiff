package com.google.common.collect;

import com.google.common.base.*;

class Interners$WeakInterner implements Interner
{
    private final MapMakerInternalMap map;
    
    private Interners$WeakInterner() {
        this.map = new MapMaker().weakKeys().keyEquivalence(Equivalence.equals()).makeCustomMap();
    }
    
    @Override
    public Object intern(final Object o) {
        while (true) {
            final MapMakerInternalMap$ReferenceEntry entry = this.map.getEntry(o);
            if (entry != null) {
                final Object key = entry.getKey();
                if (key != null) {
                    return key;
                }
            }
            if (this.map.putIfAbsent(o, Interners$WeakInterner$Dummy.VALUE) == null) {
                return o;
            }
        }
    }
}
