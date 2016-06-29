package org.jfree.util;

import java.lang.reflect.*;
import java.net.*;
import java.io.*;
import java.util.*;

public final class ObjectUtilities
{
    public static final String THREAD_CONTEXT = "ThreadContext";
    public static final String CLASS_CONTEXT = "ClassContext";
    private static String classLoaderSource;
    private static ClassLoader classLoader;
    static Class class$org$jfree$util$ObjectUtilities;
    
    public static String getClassLoaderSource() {
        return ObjectUtilities.classLoaderSource;
    }
    
    public static void setClassLoaderSource(final String classLoaderSource) {
        ObjectUtilities.classLoaderSource = classLoaderSource;
    }
    
    public static boolean equal(final Object o, final Object o2) {
        return o == o2 || (o != null && o.equals(o2));
    }
    
    public static int hashCode(final Object o) {
        int hashCode = 0;
        if (o != null) {
            hashCode = o.hashCode();
        }
        return hashCode;
    }
    
    public static Object clone(final Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null 'object' argument.");
        }
        if (o instanceof PublicCloneable) {
            return ((PublicCloneable)o).clone();
        }
        try {
            final Method method = o.getClass().getMethod("clone", (Class<?>[])null);
            if (Modifier.isPublic(method.getModifiers())) {
                return method.invoke(o, (Object[])null);
            }
        }
        catch (NoSuchMethodException ex) {
            Log.warn("Object without clone() method is impossible.");
        }
        catch (IllegalAccessException ex2) {
            Log.warn("Object.clone(): unable to call method.");
        }
        catch (InvocationTargetException ex3) {
            Log.warn("Object without clone() method is impossible.");
        }
        throw new CloneNotSupportedException("Failed to clone.");
    }
    
    public static Collection deepClone(final Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Null 'collection' argument.");
        }
        final Collection collection2 = (Collection)clone(collection);
        collection2.clear();
        for (final Object next : collection) {
            if (next != null) {
                collection2.add(clone(next));
            }
            else {
                collection2.add(null);
            }
        }
        return collection2;
    }
    
    public static synchronized void setClassLoader(final ClassLoader classLoader) {
        ObjectUtilities.classLoader = classLoader;
    }
    
    public static ClassLoader getClassLoader() {
        return ObjectUtilities.classLoader;
    }
    
    public static synchronized ClassLoader getClassLoader(final Class clazz) {
        if (ObjectUtilities.classLoader != null) {
            return ObjectUtilities.classLoader;
        }
        if ("ThreadContext".equals(ObjectUtilities.classLoaderSource)) {
            final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
        }
        final ClassLoader classLoader = clazz.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return classLoader;
    }
    
    public static URL getResource(final String s, final Class clazz) {
        final ClassLoader classLoader = getClassLoader(clazz);
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResource(s);
    }
    
    public static URL getResourceRelative(final String s, final Class clazz) {
        final ClassLoader classLoader = getClassLoader(clazz);
        final String convertName = convertName(s, clazz);
        if (classLoader == null) {
            return null;
        }
        return classLoader.getResource(convertName);
    }
    
    private static String convertName(final String s, Class componentType) {
        if (s.startsWith("/")) {
            return s.substring(1);
        }
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
        }
        final String name = componentType.getName();
        final int lastIndex = name.lastIndexOf(46);
        if (lastIndex == -1) {
            return s;
        }
        return name.substring(0, lastIndex).replace('.', '/') + "/" + s;
    }
    
    public static InputStream getResourceAsStream(final String s, final Class clazz) {
        final URL resource = getResource(s, clazz);
        if (resource == null) {
            return null;
        }
        try {
            return resource.openStream();
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public static InputStream getResourceRelativeAsStream(final String s, final Class clazz) {
        final URL resourceRelative = getResourceRelative(s, clazz);
        if (resourceRelative == null) {
            return null;
        }
        try {
            return resourceRelative.openStream();
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public static Object loadAndInstantiate(final String s, final Class clazz) {
        try {
            return getClassLoader(clazz).loadClass(s).newInstance();
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static Object loadAndInstantiate(final String s, final Class clazz, final Class clazz2) {
        try {
            final Class<?> loadClass = getClassLoader(clazz).loadClass(s);
            if (clazz2.isAssignableFrom(loadClass)) {
                return loadClass.newInstance();
            }
        }
        catch (Exception ex) {
            return null;
        }
        return null;
    }
    
    public static boolean isJDK14() {
        final ClassLoader classLoader = getClassLoader((ObjectUtilities.class$org$jfree$util$ObjectUtilities == null) ? (ObjectUtilities.class$org$jfree$util$ObjectUtilities = class$("org.jfree.util.ObjectUtilities")) : ObjectUtilities.class$org$jfree$util$ObjectUtilities);
        if (classLoader != null) {
            try {
                classLoader.loadClass("java.util.RandomAccess");
                return true;
            }
            catch (ClassNotFoundException ex) {
                return false;
            }
            catch (Exception ex2) {}
        }
        try {
            final String property = System.getProperty("java.vm.specification.version");
            return property != null && ArrayUtilities.compareVersionArrays(parseVersions(property), new String[] { "1", "4" }) >= 0;
        }
        catch (Exception ex3) {
            return false;
        }
    }
    
    private static String[] parseVersions(final String s) {
        if (s == null) {
            return new String[0];
        }
        final ArrayList list = new ArrayList<String>();
        final StringTokenizer stringTokenizer = new StringTokenizer(s, ".");
        while (stringTokenizer.hasMoreTokens()) {
            list.add(stringTokenizer.nextToken());
        }
        return list.toArray(new String[list.size()]);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        ObjectUtilities.classLoaderSource = "ThreadContext";
    }
}
