/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.io.Serializable;

final class HashBiMap$InverseSerializedForm
implements Serializable {
    private final HashBiMap bimap;

    HashBiMap$InverseSerializedForm(HashBiMap hashBiMap) {
        this.bimap = hashBiMap;
    }

    Object readResolve() {
        return this.bimap.inverse();
    }
}

