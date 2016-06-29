package com.google.security.zynamics.zylib.reflection;

import java.lang.reflect.*;

public class ReflectionHelpers
{
    public static Object getField(final Class clazz, final Object o, final String s) {
        final Field declaredField = clazz.getDeclaredField(s);
        declaredField.setAccessible(true);
        return declaredField.get(o);
    }
    
    public static Object getField(final Object o, final String s) {
        final Field declaredField = o.getClass().getDeclaredField(s);
        declaredField.setAccessible(true);
        return declaredField.get(o);
    }
    
    public static Method getMethod(final Object o, final String s, final Class... array) {
        final Class<?> class1 = o.getClass();
        final Class[] array2 = new Class[array.length];
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            array2[n++] = array[i];
        }
        return class1.getDeclaredMethod(s, (Class<?>[])array2);
    }
    
    public static Object getMethod(final Object o, final String s, final Object... array) {
        final Class<?> class1 = o.getClass();
        final Class[] array2 = new Class[array.length];
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            array2[n++] = array[i].getClass();
        }
        return class1.getDeclaredMethod(s, (Class<?>[])array2);
    }
    
    public static Object getStaticField(final Class clazz, final String s) {
        final Field declaredField = clazz.getDeclaredField(s);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }
}
