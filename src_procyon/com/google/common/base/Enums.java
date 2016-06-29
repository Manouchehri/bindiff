package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.lang.reflect.*;
import java.lang.ref.*;
import java.util.*;

@CheckReturnValue
@GwtCompatible(emulated = true)
@Beta
public final class Enums
{
    @GwtIncompatible("java.lang.ref.WeakReference")
    private static final Map enumConstantCache;
    
    @GwtIncompatible("reflection")
    public static Field getField(final Enum enum1) {
        final Class declaringClass = enum1.getDeclaringClass();
        try {
            return declaringClass.getDeclaredField(enum1.name());
        }
        catch (NoSuchFieldException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public static Optional getIfPresent(final Class clazz, final String s) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(s);
        return Platform.getEnumIfPresent(clazz, s);
    }
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    private static Map populateCache(final Class clazz) {
        final HashMap<String, WeakReference<Enum>> hashMap = new HashMap<String, WeakReference<Enum>>();
        for (final Enum enum1 : EnumSet.allOf((Class<Enum>)clazz)) {
            hashMap.put(enum1.name(), new WeakReference<Enum>(enum1));
        }
        Enums.enumConstantCache.put(clazz, hashMap);
        return hashMap;
    }
    
    @GwtIncompatible("java.lang.ref.WeakReference")
    static Map getEnumConstants(final Class clazz) {
        synchronized (Enums.enumConstantCache) {
            Map populateCache = Enums.enumConstantCache.get(clazz);
            if (populateCache == null) {
                populateCache = populateCache(clazz);
            }
            return populateCache;
        }
    }
    
    public static Converter stringConverter(final Class clazz) {
        return new Enums$StringConverter(clazz);
    }
    
    static {
        enumConstantCache = new WeakHashMap();
    }
}
