/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelpers {
    public static Object getField(Class class_, Object object, String string) {
        Field field = class_.getDeclaredField(string);
        field.setAccessible(true);
        return field.get(object);
    }

    public static Object getField(Object object, String string) {
        Class class_ = object.getClass();
        Field field = class_.getDeclaredField(string);
        field.setAccessible(true);
        return field.get(object);
    }

    public static /* varargs */ Method getMethod(Object object, String string, Class ... arrclass) {
        Class class_ = object.getClass();
        Class[] arrclass2 = new Class[arrclass.length];
        int n2 = 0;
        Class[] arrclass3 = arrclass;
        int n3 = arrclass3.length;
        int n4 = 0;
        while (n4 < n3) {
            Class class_2 = arrclass3[n4];
            arrclass2[n2++] = class_2;
            ++n4;
        }
        return class_.getDeclaredMethod(string, arrclass2);
    }

    public static /* varargs */ Object getMethod(Object object, String string, Object ... arrobject) {
        Class class_ = object.getClass();
        Class[] arrclass = new Class[arrobject.length];
        int n2 = 0;
        Object[] arrobject2 = arrobject;
        int n3 = arrobject2.length;
        int n4 = 0;
        while (n4 < n3) {
            Object object2 = arrobject2[n4];
            arrclass[n2++] = object2.getClass();
            ++n4;
        }
        return class_.getDeclaredMethod(string, arrclass);
    }

    public static Object getStaticField(Class class_, String string) {
        Field field = class_.getDeclaredField(string);
        field.setAccessible(true);
        return field.get(null);
    }
}

