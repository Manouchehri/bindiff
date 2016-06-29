package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import com.google.common.collect.*;
import java.util.*;
import java.lang.reflect.*;

@Beta
public final class SimpleTimeLimiter implements TimeLimiter
{
    private final ExecutorService executor;
    
    public SimpleTimeLimiter(final ExecutorService executorService) {
        this.executor = (ExecutorService)Preconditions.checkNotNull(executorService);
    }
    
    public SimpleTimeLimiter() {
        this(Executors.newCachedThreadPool());
    }
    
    @Override
    public Object newProxy(final Object o, final Class clazz, final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(o);
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(n > 0L, "bad timeout: %s", n);
        Preconditions.checkArgument(clazz.isInterface(), (Object)"interfaceType must be an interface type");
        return newProxy(clazz, new SimpleTimeLimiter$1(this, o, n, timeUnit, findInterruptibleMethods(clazz)));
    }
    
    @Override
    public Object callWithTimeout(final Callable callable, final long n, final TimeUnit timeUnit, final boolean b) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(n > 0L, "timeout must be positive: %s", n);
        final Future<Object> submit = this.executor.submit((Callable<Object>)callable);
        try {
            if (b) {
                try {
                    return submit.get(n, timeUnit);
                }
                catch (InterruptedException ex) {
                    submit.cancel(true);
                    throw ex;
                }
            }
            return Uninterruptibles.getUninterruptibly(submit, n, timeUnit);
        }
        catch (ExecutionException ex2) {
            throw throwCause(ex2, true);
        }
        catch (TimeoutException ex3) {
            submit.cancel(true);
            throw new UncheckedTimeoutException(ex3);
        }
    }
    
    private static Exception throwCause(final Exception ex, final boolean b) {
        final Throwable cause = ex.getCause();
        if (cause == null) {
            throw ex;
        }
        if (b) {
            cause.setStackTrace((StackTraceElement[])ObjectArrays.concat(cause.getStackTrace(), ex.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw (Exception)cause;
        }
        if (cause instanceof Error) {
            throw (Error)cause;
        }
        throw ex;
    }
    
    private static Set findInterruptibleMethods(final Class clazz) {
        final HashSet hashSet = Sets.newHashSet();
        for (final Method method : clazz.getMethods()) {
            if (declaresInterruptedEx(method)) {
                hashSet.add(method);
            }
        }
        return hashSet;
    }
    
    private static boolean declaresInterruptedEx(final Method method) {
        final Class<?>[] exceptionTypes = method.getExceptionTypes();
        for (int length = exceptionTypes.length, i = 0; i < length; ++i) {
            if (exceptionTypes[i] == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }
    
    private static Object newProxy(final Class clazz, final InvocationHandler invocationHandler) {
        return clazz.cast(Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, invocationHandler));
    }
}
