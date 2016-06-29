/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableBiMap$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableMap$SerializedForm;

class ImmutableBiMap$SerializedForm
extends ImmutableMap$SerializedForm {
    private static final long serialVersionUID = 0;

    ImmutableBiMap$SerializedForm(ImmutableBiMap immutableBiMap) {
        super(immutableBiMap);
    }

    @Override
    Object readResolve() {
        ImmutableBiMap$Builder immutableBiMap$Builder = new ImmutableBiMap$Builder();
        return this.createMap(immutableBiMap$Builder);
    }
}

