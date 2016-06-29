/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public final class Primitives {
    private static final Map PRIMITIVE_TO_WRAPPER_TYPE;
    private static final Map WRAPPER_TO_PRIMITIVE_TYPE;

    private Primitives() {
    }

    private static void add(Map map, Map map2, Class class_, Class class_2) {
        map.put(class_, class_2);
        map2.put(class_2, class_);
    }

    public static Set allPrimitiveTypes() {
        return PRIMITIVE_TO_WRAPPER_TYPE.keySet();
    }

    public static Set allWrapperTypes() {
        return WRAPPER_TO_PRIMITIVE_TYPE.keySet();
    }

    public static boolean isWrapperType(Class class_) {
        return WRAPPER_TO_PRIMITIVE_TYPE.containsKey(Preconditions.checkNotNull(class_));
    }

    public static Class wrap(Class class_) {
        Class class_2;
        Preconditions.checkNotNull(class_);
        Class class_3 = (Class)PRIMITIVE_TO_WRAPPER_TYPE.get(class_);
        if (class_3 == null) {
            class_2 = class_;
            return class_2;
        }
        class_2 = class_3;
        return class_2;
    }

    public static Class unwrap(Class class_) {
        Class class_2;
        Preconditions.checkNotNull(class_);
        Class class_3 = (Class)WRAPPER_TO_PRIMITIVE_TYPE.get(class_);
        if (class_3 == null) {
            class_2 = class_;
            return class_2;
        }
        class_2 = class_3;
        return class_2;
    }

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        Primitives.add(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        Primitives.add(hashMap, hashMap2, Byte.TYPE, Byte.class);
        Primitives.add(hashMap, hashMap2, Character.TYPE, Character.class);
        Primitives.add(hashMap, hashMap2, Double.TYPE, Double.class);
        Primitives.add(hashMap, hashMap2, Float.TYPE, Float.class);
        Primitives.add(hashMap, hashMap2, Integer.TYPE, Integer.class);
        Primitives.add(hashMap, hashMap2, Long.TYPE, Long.class);
        Primitives.add(hashMap, hashMap2, Short.TYPE, Short.class);
        Primitives.add(hashMap, hashMap2, Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(hashMap);
        WRAPPER_TO_PRIMITIVE_TYPE = Collections.unmodifiableMap(hashMap2);
    }
}

