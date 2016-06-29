/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;

@VisibleForTesting
class Ordering$IncomparableValueException
extends ClassCastException {
    final Object value;
    private static final long serialVersionUID = 0;

    Ordering$IncomparableValueException(Object object) {
        String string = String.valueOf(object);
        super(new StringBuilder(22 + String.valueOf(string).length()).append("Cannot compare value: ").append(string).toString());
        this.value = object;
    }
}

