/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.TimeLimiter;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Beta
public final class FakeTimeLimiter
implements TimeLimiter {
    @Override
    public Object newProxy(Object object, Class class_, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(class_);
        Preconditions.checkNotNull((Object)timeUnit);
        return object;
    }

    @Override
    public Object callWithTimeout(Callable callable, long l2, TimeUnit timeUnit, boolean bl2) {
        Preconditions.checkNotNull((Object)timeUnit);
        return callable.call();
    }
}

