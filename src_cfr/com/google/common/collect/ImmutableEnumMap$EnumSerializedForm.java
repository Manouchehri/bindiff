/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableEnumMap$1;
import java.io.Serializable;
import java.util.EnumMap;

class ImmutableEnumMap$EnumSerializedForm
implements Serializable {
    final EnumMap delegate;
    private static final long serialVersionUID = 0;

    ImmutableEnumMap$EnumSerializedForm(EnumMap enumMap) {
        this.delegate = enumMap;
    }

    Object readResolve() {
        return new ImmutableEnumMap(this.delegate, null);
    }
}

