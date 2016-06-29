/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableEnumSet$1;
import java.io.Serializable;
import java.util.EnumSet;

class ImmutableEnumSet$EnumSerializedForm
implements Serializable {
    final EnumSet delegate;
    private static final long serialVersionUID = 0;

    ImmutableEnumSet$EnumSerializedForm(EnumSet enumSet) {
        this.delegate = enumSet;
    }

    Object readResolve() {
        return new ImmutableEnumSet((EnumSet)this.delegate.clone(), null);
    }
}

