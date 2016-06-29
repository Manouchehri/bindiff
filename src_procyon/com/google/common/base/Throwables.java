package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public final class Throwables
{
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    @VisibleForTesting
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
    @Nullable
    private static final Object jla;
    @Nullable
    private static final Method getStackTraceElementMethod;
    @Nullable
    private static final Method getStackTraceDepthMethod;
    
    public static void propagateIfInstanceOf(@Nullable final Throwable t, final Class clazz) {
        if (t != null && clazz.isInstance(t)) {
            throw (Throwable)clazz.cast(t);
        }
    }
    
    public static void propagateIfPossible(@Nullable final Throwable t) {
        propagateIfInstanceOf(t, Error.class);
        propagateIfInstanceOf(t, RuntimeException.class);
    }
    
    public static void propagateIfPossible(@Nullable final Throwable t, final Class clazz) {
        propagateIfInstanceOf(t, clazz);
        propagateIfPossible(t);
    }
    
    public static void propagateIfPossible(@Nullable final Throwable t, final Class clazz, final Class clazz2) {
        Preconditions.checkNotNull(clazz2);
        propagateIfInstanceOf(t, clazz);
        propagateIfPossible(t, clazz2);
    }
    
    public static RuntimeException propagate(final Throwable t) {
        propagateIfPossible((Throwable)Preconditions.checkNotNull(t));
        throw new RuntimeException(t);
    }
    
    @CheckReturnValue
    public static Throwable getRootCause(Throwable t) {
        Throwable cause;
        while ((cause = t.getCause()) != null) {
            t = cause;
        }
        return t;
    }
    
    @CheckReturnValue
    @Beta
    public static List getCausalChain(Throwable cause) {
        Preconditions.checkNotNull(cause);
        final ArrayList<Throwable> list = new ArrayList<Throwable>(4);
        while (cause != null) {
            list.add(cause);
            cause = cause.getCause();
        }
        return Collections.unmodifiableList((List<?>)list);
    }
    
    @CheckReturnValue
    public static String getStackTraceAsString(final Throwable t) {
        final StringWriter stringWriter = new StringWriter();
        t.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
    
    @CheckReturnValue
    @Beta
    public static List lazyStackTrace(final Throwable t) {
        return lazyStackTraceIsLazy() ? jlaStackTrace(t) : Collections.unmodifiableList((List<?>)Arrays.asList((T[])t.getStackTrace()));
    }
    
    @CheckReturnValue
    @Beta
    public static boolean lazyStackTraceIsLazy() {
        return Throwables.getStackTraceElementMethod != null & Throwables.getStackTraceDepthMethod != null;
    }
    
    private static List jlaStackTrace(final Throwable t) {
        Preconditions.checkNotNull(t);
        return new Throwables$1(t);
    }
    
    private static Object invokeAccessibleNonThrowingMethod(final Method method, final Object o, final Object... array) {
        try {
            return method.invoke(o, array);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        catch (InvocationTargetException ex2) {
            throw propagate(ex2.getCause());
        }
    }
    
    @Nullable
    private static Object getJLA() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", (Class<?>[])new Class[0]).invoke(null, new Object[0]);
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    @Nullable
    private static Method getGetMethod() {
        return getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
    }
    
    @Nullable
    private static Method getSizeMethod() {
        return getJlaMethod("getStackTraceDepth", Throwable.class);
    }
    
    @Nullable
    private static Method getJlaMethod(final String s, final Class... array) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(s, (Class<?>[])array);
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    static {
        jla = getJLA();
        getStackTraceElementMethod = ((Throwables.jla == null) ? null : getGetMethod());
        getStackTraceDepthMethod = ((Throwables.jla == null) ? null : getSizeMethod());
    }
}
