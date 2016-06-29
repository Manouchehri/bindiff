/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.jfree.util.ArrayUtilities;
import org.jfree.util.Log;
import org.jfree.util.PublicCloneable;

public final class ObjectUtilities {
    public static final String THREAD_CONTEXT = "ThreadContext";
    public static final String CLASS_CONTEXT = "ClassContext";
    private static String classLoaderSource = "ThreadContext";
    private static ClassLoader classLoader;
    static Class class$org$jfree$util$ObjectUtilities;

    private ObjectUtilities() {
    }

    public static String getClassLoaderSource() {
        return classLoaderSource;
    }

    public static void setClassLoaderSource(String string) {
        classLoaderSource = string;
    }

    public static boolean equal(Object object, Object object2) {
        if (object == object2) {
            return true;
        }
        if (object == null) return false;
        return object.equals(object2);
    }

    public static int hashCode(Object object) {
        int n2 = 0;
        if (object == null) return n2;
        return object.hashCode();
    }

    public static Object clone(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Null 'object' argument.");
        }
        if (object instanceof PublicCloneable) {
            PublicCloneable publicCloneable = (PublicCloneable)object;
            return publicCloneable.clone();
        }
        try {
            Method method = object.getClass().getMethod("clone", null);
            if (!Modifier.isPublic(method.getModifiers())) throw new CloneNotSupportedException("Failed to clone.");
            return method.invoke(object, null);
        }
        catch (NoSuchMethodException var1_3) {
            Log.warn("Object without clone() method is impossible.");
            throw new CloneNotSupportedException("Failed to clone.");
        }
        catch (IllegalAccessException var1_4) {
            Log.warn("Object.clone(): unable to call method.");
            throw new CloneNotSupportedException("Failed to clone.");
        }
        catch (InvocationTargetException var1_5) {
            Log.warn("Object without clone() method is impossible.");
        }
        throw new CloneNotSupportedException("Failed to clone.");
    }

    public static Collection deepClone(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Null 'collection' argument.");
        }
        Collection collection2 = (Collection)ObjectUtilities.clone(collection);
        collection2.clear();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e2 = iterator.next();
            if (e2 != null) {
                collection2.add(ObjectUtilities.clone(e2));
                continue;
            }
            collection2.add(null);
        }
        return collection2;
    }

    public static synchronized void setClassLoader(ClassLoader classLoader) {
        ObjectUtilities.classLoader = classLoader;
    }

    public static ClassLoader getClassLoader() {
        return classLoader;
    }

    public static synchronized ClassLoader getClassLoader(Class class_) {
        ClassLoader classLoader;
        if (ObjectUtilities.classLoader != null) {
            return ObjectUtilities.classLoader;
        }
        if ("ThreadContext".equals(classLoaderSource) && (classLoader = Thread.currentThread().getContextClassLoader()) != null) {
            return classLoader;
        }
        classLoader = class_.getClassLoader();
        if (classLoader != null) return classLoader;
        return ClassLoader.getSystemClassLoader();
    }

    public static URL getResource(String string, Class class_) {
        ClassLoader classLoader = ObjectUtilities.getClassLoader(class_);
        if (classLoader != null) return classLoader.getResource(string);
        return null;
    }

    public static URL getResourceRelative(String string, Class class_) {
        ClassLoader classLoader = ObjectUtilities.getClassLoader(class_);
        String string2 = ObjectUtilities.convertName(string, class_);
        if (classLoader != null) return classLoader.getResource(string2);
        return null;
    }

    private static String convertName(String string, Class class_) {
        if (string.startsWith("/")) {
            return string.substring(1);
        }
        while (class_.isArray()) {
            class_ = class_.getComponentType();
        }
        String string2 = class_.getName();
        int n2 = string2.lastIndexOf(46);
        if (n2 == -1) {
            return string;
        }
        String string3 = string2.substring(0, n2);
        return new StringBuffer().append(string3.replace('.', '/')).append("/").append(string).toString();
    }

    public static InputStream getResourceAsStream(String string, Class class_) {
        URL uRL = ObjectUtilities.getResource(string, class_);
        if (uRL == null) {
            return null;
        }
        try {
            return uRL.openStream();
        }
        catch (IOException var3_3) {
            return null;
        }
    }

    public static InputStream getResourceRelativeAsStream(String string, Class class_) {
        URL uRL = ObjectUtilities.getResourceRelative(string, class_);
        if (uRL == null) {
            return null;
        }
        try {
            return uRL.openStream();
        }
        catch (IOException var3_3) {
            return null;
        }
    }

    public static Object loadAndInstantiate(String string, Class class_) {
        try {
            ClassLoader classLoader = ObjectUtilities.getClassLoader(class_);
            Class class_2 = classLoader.loadClass(string);
            return class_2.newInstance();
        }
        catch (Exception var2_3) {
            return null;
        }
    }

    public static Object loadAndInstantiate(String string, Class class_, Class class_2) {
        try {
            ClassLoader classLoader = ObjectUtilities.getClassLoader(class_);
            Class class_3 = classLoader.loadClass(string);
            if (!class_2.isAssignableFrom(class_3)) return null;
            return class_3.newInstance();
        }
        catch (Exception var3_4) {
            return null;
        }
    }

    public static boolean isJDK14() {
        Class class_ = class$org$jfree$util$ObjectUtilities == null ? (ObjectUtilities.class$org$jfree$util$ObjectUtilities = ObjectUtilities.class$("org.jfree.util.ObjectUtilities")) : class$org$jfree$util$ObjectUtilities;
        ClassLoader classLoader = ObjectUtilities.getClassLoader(class_);
        if (classLoader != null) {
            try {
                classLoader.loadClass("java.util.RandomAccess");
                return true;
            }
            catch (ClassNotFoundException var1_1) {
                return false;
            }
            catch (Exception var1_2) {
                // empty catch block
            }
        }
        try {
            String string = System.getProperty("java.vm.specification.version");
            if (string == null) {
                return false;
            }
            String[] arrstring = ObjectUtilities.parseVersions(string);
            String[] arrstring2 = new String[]{"1", "4"};
            if (ArrayUtilities.compareVersionArrays((Comparable[])arrstring, (Comparable[])arrstring2) < 0) return false;
            return true;
        }
        catch (Exception var1_4) {
            return false;
        }
    }

    private static String[] parseVersions(String string) {
        if (string == null) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

