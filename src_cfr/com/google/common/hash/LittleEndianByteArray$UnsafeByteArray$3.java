/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class LittleEndianByteArray$UnsafeByteArray$3
implements PrivilegedExceptionAction {
    LittleEndianByteArray$UnsafeByteArray$3() {
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

