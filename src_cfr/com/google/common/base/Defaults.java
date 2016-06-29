/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
public final class Defaults {
    private static final Map DEFAULTS;

    private Defaults() {
    }

    private static void put(Map map, Class class_, Object object) {
        map.put(class_, object);
    }

    @Nullable
    public static Object defaultValue(Class class_) {
        return DEFAULTS.get(Preconditions.checkNotNull(class_));
    }

    static {
        HashMap hashMap = new HashMap();
        Defaults.put(hashMap, Boolean.TYPE, false);
        Defaults.put(hashMap, Character.TYPE, Character.valueOf('\u0000'));
        Defaults.put(hashMap, Byte.TYPE, Byte.valueOf(0));
        Defaults.put(hashMap, Short.TYPE, 0);
        Defaults.put(hashMap, Integer.TYPE, 0);
        Defaults.put(hashMap, Long.TYPE, 0);
        Defaults.put(hashMap, Float.TYPE, Float.valueOf(0.0f));
        Defaults.put(hashMap, Double.TYPE, 0.0);
        DEFAULTS = Collections.unmodifiableMap(hashMap);
    }
}

