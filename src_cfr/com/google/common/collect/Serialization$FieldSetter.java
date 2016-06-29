/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.Serialization$1;
import java.lang.reflect.Field;

final class Serialization$FieldSetter {
    private final Field field;

    private Serialization$FieldSetter(Field field) {
        this.field = field;
        field.setAccessible(true);
    }

    void set(Object object, Object object2) {
        try {
            this.field.set(object, object2);
            return;
        }
        catch (IllegalAccessException var3_3) {
            throw new AssertionError(var3_3);
        }
    }

    void set(Object object, int n2) {
        try {
            this.field.set(object, n2);
            return;
        }
        catch (IllegalAccessException var3_3) {
            throw new AssertionError(var3_3);
        }
    }

    /* synthetic */ Serialization$FieldSetter(Field field, Serialization$1 serialization$1) {
        this(field);
    }
}

