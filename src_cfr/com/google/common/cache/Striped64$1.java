/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class Striped64$1
implements PrivilegedExceptionAction {
    Striped64$1() {
    }

    public Unsafe run() {
        reference var1_1 = Unsafe.class;
        Field[] arrfield = var1_1.getDeclaredFields();
        int n2 = arrfield.length;
        int n3 = 0;
        while (n3 < n2) {
            Field field = arrfield[n3];
            field.setAccessible(true);
            Object object = field.get(null);
            if (var1_1.isInstance(object)) {
                return (Unsafe)var1_1.cast(object);
            }
            ++n3;
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}

