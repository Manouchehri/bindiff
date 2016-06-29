/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Enums$StringConverter;
import com.google.common.base.Optional;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible(emulated=1)
@Beta
public final class Enums {
    @GwtIncompatible(value="java.lang.ref.WeakReference")
    private static final Map enumConstantCache = new WeakHashMap();

    private Enums() {
    }

    @GwtIncompatible(value="reflection")
    public static Field getField(Enum enum_) {
        Class class_ = enum_.getDeclaringClass();
        try {
            return class_.getDeclaredField(enum_.name());
        }
        catch (NoSuchFieldException var2_2) {
            throw new AssertionError(var2_2);
        }
    }

    public static Optional getIfPresent(Class class_, String string) {
        Preconditions.checkNotNull(class_);
        Preconditions.checkNotNull(string);
        return Platform.getEnumIfPresent(class_, string);
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    private static Map populateCache(Class class_) {
        HashMap<String, WeakReference<Enum>> hashMap = new HashMap<String, WeakReference<Enum>>();
        Iterator iterator = EnumSet.allOf(class_).iterator();
        do {
            if (!iterator.hasNext()) {
                enumConstantCache.put(class_, hashMap);
                return hashMap;
            }
            Enum enum_ = (Enum)iterator.next();
            hashMap.put(enum_.name(), new WeakReference<Enum>(enum_));
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @GwtIncompatible(value="java.lang.ref.WeakReference")
    static Map getEnumConstants(Class class_) {
        Map map = enumConstantCache;
        synchronized (map) {
            Map map2 = (Map)enumConstantCache.get(class_);
            if (map2 != null) return map2;
            return Enums.populateCache(class_);
        }
    }

    public static Converter stringConverter(Class class_) {
        return new Enums$StringConverter(class_);
    }
}

