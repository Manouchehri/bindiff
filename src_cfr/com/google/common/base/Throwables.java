/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables$1;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Throwables {
    private static final String JAVA_LANG_ACCESS_CLASSNAME = "sun.misc.JavaLangAccess";
    @VisibleForTesting
    static final String SHARED_SECRETS_CLASSNAME = "sun.misc.SharedSecrets";
    @Nullable
    private static final Object jla = Throwables.getJLA();
    @Nullable
    private static final Method getStackTraceElementMethod = jla == null ? null : Throwables.getGetMethod();
    @Nullable
    private static final Method getStackTraceDepthMethod = jla == null ? null : Throwables.getSizeMethod();

    private Throwables() {
    }

    public static void propagateIfInstanceOf(@Nullable Throwable throwable, Class class_) {
        if (throwable == null) return;
        if (!class_.isInstance(throwable)) return;
        throw (Throwable)class_.cast(throwable);
    }

    public static void propagateIfPossible(@Nullable Throwable throwable) {
        Throwables.propagateIfInstanceOf(throwable, Error.class);
        Throwables.propagateIfInstanceOf(throwable, RuntimeException.class);
    }

    public static void propagateIfPossible(@Nullable Throwable throwable, Class class_) {
        Throwables.propagateIfInstanceOf(throwable, class_);
        Throwables.propagateIfPossible(throwable);
    }

    public static void propagateIfPossible(@Nullable Throwable throwable, Class class_, Class class_2) {
        Preconditions.checkNotNull(class_2);
        Throwables.propagateIfInstanceOf(throwable, class_);
        Throwables.propagateIfPossible(throwable, class_2);
    }

    public static RuntimeException propagate(Throwable throwable) {
        Throwables.propagateIfPossible((Throwable)Preconditions.checkNotNull(throwable));
        throw new RuntimeException(throwable);
    }

    @CheckReturnValue
    public static Throwable getRootCause(Throwable throwable) {
        Throwable throwable2;
        while ((throwable2 = throwable.getCause()) != null) {
            throwable = throwable2;
        }
        return throwable;
    }

    @CheckReturnValue
    @Beta
    public static List getCausalChain(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>(4);
        while (throwable != null) {
            arrayList.add(throwable);
            throwable = throwable.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    @CheckReturnValue
    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @CheckReturnValue
    @Beta
    public static List lazyStackTrace(Throwable throwable) {
        List<StackTraceElement> list;
        if (Throwables.lazyStackTraceIsLazy()) {
            list = Throwables.jlaStackTrace(throwable);
            return list;
        }
        list = Collections.unmodifiableList(Arrays.asList(throwable.getStackTrace()));
        return list;
    }

    @CheckReturnValue
    @Beta
    public static boolean lazyStackTraceIsLazy() {
        boolean bl2;
        boolean bl3 = getStackTraceElementMethod != null;
        if (getStackTraceDepthMethod != null) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    private static List jlaStackTrace(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        return new Throwables$1(throwable);
    }

    private static /* varargs */ Object invokeAccessibleNonThrowingMethod(Method method, Object object, Object ... arrobject) {
        try {
            return method.invoke(object, arrobject);
        }
        catch (IllegalAccessException var3_3) {
            throw new RuntimeException(var3_3);
        }
        catch (InvocationTargetException var3_4) {
            throw Throwables.propagate(var3_4.getCause());
        }
    }

    @Nullable
    private static Object getJLA() {
        try {
            Class class_ = Class.forName("sun.misc.SharedSecrets", false, null);
            Method method = class_.getMethod("getJavaLangAccess", new Class[0]);
            return method.invoke(null, new Object[0]);
        }
        catch (ThreadDeath var0_1) {
            throw var0_1;
        }
        catch (Throwable var0_2) {
            return null;
        }
    }

    @Nullable
    private static Method getGetMethod() {
        return Throwables.getJlaMethod("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @Nullable
    private static Method getSizeMethod() {
        return Throwables.getJlaMethod("getStackTraceDepth", Throwable.class);
    }

    @Nullable
    private static /* varargs */ Method getJlaMethod(String string, Class ... arrclass) {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(string, arrclass);
        }
        catch (ThreadDeath var2_2) {
            throw var2_2;
        }
        catch (Throwable var2_3) {
            return null;
        }
    }

    static /* synthetic */ Method access$000() {
        return getStackTraceElementMethod;
    }

    static /* synthetic */ Object access$100() {
        return jla;
    }

    static /* synthetic */ Object access$200(Method method, Object object, Object[] arrobject) {
        return Throwables.invokeAccessibleNonThrowingMethod(method, object, arrobject);
    }

    static /* synthetic */ Method access$300() {
        return getStackTraceDepthMethod;
    }
}

