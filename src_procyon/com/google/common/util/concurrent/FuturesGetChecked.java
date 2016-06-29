package com.google.common.util.concurrent;

import com.google.common.collect.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;
import java.util.*;
import java.lang.reflect.*;
import javax.annotation.*;
import com.google.common.base.*;

final class FuturesGetChecked
{
    private static final Ordering WITH_STRING_PARAM_FIRST;
    
    static Object getChecked(final Future future, final Class clazz) {
        return getChecked(bestGetCheckedTypeValidator(), future, clazz);
    }
    
    @VisibleForTesting
    static Object getChecked(final FuturesGetChecked$GetCheckedTypeValidator futuresGetChecked$GetCheckedTypeValidator, final Future future, final Class clazz) {
        futuresGetChecked$GetCheckedTypeValidator.validateClass(clazz);
        try {
            return future.get();
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw newWithCause(clazz, ex);
        }
        catch (ExecutionException ex2) {
            wrapAndThrowExceptionOrError(ex2.getCause(), clazz);
            throw new AssertionError();
        }
    }
    
    static Object getChecked(final Future future, final Class clazz, final long n, final TimeUnit timeUnit) {
        bestGetCheckedTypeValidator().validateClass(clazz);
        try {
            return future.get(n, timeUnit);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw newWithCause(clazz, ex);
        }
        catch (TimeoutException ex2) {
            throw newWithCause(clazz, ex2);
        }
        catch (ExecutionException ex3) {
            wrapAndThrowExceptionOrError(ex3.getCause(), clazz);
            throw new AssertionError();
        }
    }
    
    private static FuturesGetChecked$GetCheckedTypeValidator bestGetCheckedTypeValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder.BEST_VALIDATOR;
    }
    
    @VisibleForTesting
    static FuturesGetChecked$GetCheckedTypeValidator weakSetValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator.INSTANCE;
    }
    
    @VisibleForTesting
    static FuturesGetChecked$GetCheckedTypeValidator classValueValidator() {
        return FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator.INSTANCE;
    }
    
    private static void wrapAndThrowExceptionOrError(final Throwable t, final Class clazz) {
        if (t instanceof Error) {
            throw new ExecutionError((Error)t);
        }
        if (t instanceof RuntimeException) {
            throw new UncheckedExecutionException(t);
        }
        throw newWithCause(clazz, t);
    }
    
    private static boolean hasConstructorUsableByGetChecked(final Class clazz) {
        try {
            newWithCause(clazz, new Exception());
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    private static Exception newWithCause(final Class clazz, final Throwable t) {
        final Iterator<Constructor> iterator = preferringStrings(Arrays.asList(clazz.getConstructors())).iterator();
        while (iterator.hasNext()) {
            final Exception ex = (Exception)newFromConstructor(iterator.next(), t);
            if (ex != null) {
                if (ex.getCause() == null) {
                    ex.initCause(t);
                }
                return ex;
            }
        }
        final String value = String.valueOf(clazz);
        throw new IllegalArgumentException(new StringBuilder(82 + String.valueOf(value).length()).append("No appropriate constructor for exception of type ").append(value).append(" in response to chained exception").toString(), t);
    }
    
    private static List preferringStrings(final List list) {
        return FuturesGetChecked.WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }
    
    @Nullable
    private static Object newFromConstructor(final Constructor constructor, final Throwable t) {
        final Class<?>[] parameterTypes = constructor.getParameterTypes();
        final Object[] array = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; ++i) {
            final Class<?> clazz = parameterTypes[i];
            if (clazz.equals(String.class)) {
                array[i] = t.toString();
            }
            else {
                if (!clazz.equals(Throwable.class)) {
                    return null;
                }
                array[i] = t;
            }
        }
        try {
            return constructor.newInstance(array);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
        catch (InstantiationException ex2) {
            return null;
        }
        catch (IllegalAccessException ex3) {
            return null;
        }
        catch (InvocationTargetException ex4) {
            return null;
        }
    }
    
    @VisibleForTesting
    static boolean isCheckedException(final Class clazz) {
        return !RuntimeException.class.isAssignableFrom(clazz);
    }
    
    @VisibleForTesting
    static void checkExceptionClassValidity(final Class clazz) {
        Preconditions.checkArgument(isCheckedException(clazz), "Futures.getChecked exception type (%s) must not be a RuntimeException", clazz);
        Preconditions.checkArgument(hasConstructorUsableByGetChecked(clazz), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", clazz);
    }
    
    static {
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new FuturesGetChecked$1()).reverse();
    }
}
