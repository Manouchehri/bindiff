/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SimpleTimeLimiter$1;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public final class SimpleTimeLimiter
implements TimeLimiter {
    private final ExecutorService executor;

    public SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService)Preconditions.checkNotNull(executorService);
    }

    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }

    @Override
    public Object newProxy(Object object, Class class_, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(class_);
        Preconditions.checkNotNull((Object)timeUnit);
        Preconditions.checkArgument(l2 > 0, "bad timeout: %s", l2);
        Preconditions.checkArgument(class_.isInterface(), "interfaceType must be an interface type");
        Set set = SimpleTimeLimiter.findInterruptibleMethods(class_);
        SimpleTimeLimiter$1 simpleTimeLimiter$1 = new SimpleTimeLimiter$1(this, object, l2, timeUnit, set);
        return SimpleTimeLimiter.newProxy(class_, simpleTimeLimiter$1);
    }

    @Override
    public Object callWithTimeout(Callable callable, long l2, TimeUnit timeUnit, boolean bl2) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull((Object)timeUnit);
        Preconditions.checkArgument(l2 > 0, "timeout must be positive: %s", l2);
        Future future = this.executor.submit(callable);
        try {
            if (!bl2) return Uninterruptibles.getUninterruptibly(future, l2, timeUnit);
            try {
                return future.get(l2, timeUnit);
            }
            catch (InterruptedException var7_6) {
                future.cancel(true);
                throw var7_6;
            }
        }
        catch (ExecutionException var7_7) {
            throw SimpleTimeLimiter.throwCause(var7_7, true);
        }
        catch (TimeoutException var7_8) {
            future.cancel(true);
            throw new UncheckedTimeoutException(var7_8);
        }
    }

    private static Exception throwCause(Exception exception, boolean bl2) {
        Throwable throwable = exception.getCause();
        if (throwable == null) {
            throw exception;
        }
        if (bl2) {
            StackTraceElement[] arrstackTraceElement = (StackTraceElement[])ObjectArrays.concat(throwable.getStackTrace(), exception.getStackTrace(), StackTraceElement.class);
            throwable.setStackTrace(arrstackTraceElement);
        }
        if (throwable instanceof Exception) {
            throw (Exception)throwable;
        }
        if (!(throwable instanceof Error)) throw exception;
        throw (Error)throwable;
    }

    private static Set findInterruptibleMethods(Class class_) {
        HashSet hashSet = Sets.newHashSet();
        Method[] arrmethod = class_.getMethods();
        int n2 = arrmethod.length;
        int n3 = 0;
        while (n3 < n2) {
            Method method = arrmethod[n3];
            if (SimpleTimeLimiter.declaresInterruptedEx(method)) {
                hashSet.add(method);
            }
            ++n3;
        }
        return hashSet;
    }

    private static boolean declaresInterruptedEx(Method method) {
        Class<?>[] arrclass = method.getExceptionTypes();
        int n2 = arrclass.length;
        int n3 = 0;
        while (n3 < n2) {
            Class class_ = arrclass[n3];
            if (class_ == InterruptedException.class) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private static Object newProxy(Class class_, InvocationHandler invocationHandler) {
        Object object = Proxy.newProxyInstance(class_.getClassLoader(), new Class[]{class_}, invocationHandler);
        return class_.cast(object);
    }

    static /* synthetic */ Exception access$000(Exception exception, boolean bl2) {
        return SimpleTimeLimiter.throwCause(exception, bl2);
    }
}

