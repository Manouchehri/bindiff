/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.FuturesGetChecked$1;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$ClassValueValidator;
import com.google.common.util.concurrent.FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

final class FuturesGetChecked {
    private static final Ordering WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new FuturesGetChecked$1()).reverse();

    static Object getChecked(Future future, Class class_) {
        return FuturesGetChecked.getChecked(FuturesGetChecked.bestGetCheckedTypeValidator(), future, class_);
    }

    @VisibleForTesting
    static Object getChecked(FuturesGetChecked$GetCheckedTypeValidator futuresGetChecked$GetCheckedTypeValidator, Future future, Class class_) {
        futuresGetChecked$GetCheckedTypeValidator.validateClass(class_);
        try {
            return future.get();
        }
        catch (InterruptedException var3_3) {
            Thread.currentThread().interrupt();
            throw FuturesGetChecked.newWithCause(class_, var3_3);
        }
        catch (ExecutionException var3_4) {
            FuturesGetChecked.wrapAndThrowExceptionOrError(var3_4.getCause(), class_);
            throw new AssertionError();
        }
    }

    static Object getChecked(Future future, Class class_, long l2, TimeUnit timeUnit) {
        FuturesGetChecked.bestGetCheckedTypeValidator().validateClass(class_);
        try {
            return future.get(l2, timeUnit);
        }
        catch (InterruptedException var5_4) {
            Thread.currentThread().interrupt();
            throw FuturesGetChecked.newWithCause(class_, var5_4);
        }
        catch (TimeoutException var5_5) {
            throw FuturesGetChecked.newWithCause(class_, var5_5);
        }
        catch (ExecutionException var5_6) {
            FuturesGetChecked.wrapAndThrowExceptionOrError(var5_6.getCause(), class_);
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

    private static void wrapAndThrowExceptionOrError(Throwable throwable, Class class_) {
        if (throwable instanceof Error) {
            throw new ExecutionError((Error)throwable);
        }
        if (!(throwable instanceof RuntimeException)) throw FuturesGetChecked.newWithCause(class_, throwable);
        throw new UncheckedExecutionException(throwable);
    }

    private static boolean hasConstructorUsableByGetChecked(Class class_) {
        try {
            FuturesGetChecked.newWithCause(class_, new Exception());
            return true;
        }
        catch (Exception var1_1) {
            return false;
        }
    }

    private static Exception newWithCause(Class class_, Throwable throwable) {
        Constructor constructor;
        Exception exception;
        List list = Arrays.asList(class_.getConstructors());
        Object object = FuturesGetChecked.preferringStrings(list).iterator();
        do {
            if (object.hasNext()) continue;
            object = String.valueOf(class_);
            throw new IllegalArgumentException(new StringBuilder(82 + String.valueOf(object).length()).append("No appropriate constructor for exception of type ").append((String)object).append(" in response to chained exception").toString(), throwable);
        } while ((exception = (Exception)FuturesGetChecked.newFromConstructor(constructor = (Constructor)object.next(), throwable)) == null);
        if (exception.getCause() != null) return exception;
        exception.initCause(throwable);
        return exception;
    }

    private static List preferringStrings(List list) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(list);
    }

    @Nullable
    private static Object newFromConstructor(Constructor constructor, Throwable throwable) {
        Class<?>[] arrclass = constructor.getParameterTypes();
        Object[] arrobject = new Object[arrclass.length];
        for (int i2 = 0; i2 < arrclass.length; ++i2) {
            Class class_ = arrclass[i2];
            if (class_.equals(String.class)) {
                arrobject[i2] = throwable.toString();
                continue;
            }
            if (!class_.equals(Throwable.class)) return null;
            arrobject[i2] = throwable;
        }
        try {
            return constructor.newInstance(arrobject);
        }
        catch (IllegalArgumentException var4_5) {
            return null;
        }
        catch (InstantiationException var4_6) {
            return null;
        }
        catch (IllegalAccessException var4_7) {
            return null;
        }
        catch (InvocationTargetException var4_8) {
            return null;
        }
    }

    @VisibleForTesting
    static boolean isCheckedException(Class class_) {
        if (RuntimeException.class.isAssignableFrom(class_)) return false;
        return true;
    }

    @VisibleForTesting
    static void checkExceptionClassValidity(Class class_) {
        Preconditions.checkArgument(FuturesGetChecked.isCheckedException(class_), "Futures.getChecked exception type (%s) must not be a RuntimeException", class_);
        Preconditions.checkArgument(FuturesGetChecked.hasConstructorUsableByGetChecked(class_), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", class_);
    }

    private FuturesGetChecked() {
    }
}

