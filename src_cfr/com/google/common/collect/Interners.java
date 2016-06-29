/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners$1;
import com.google.common.collect.Interners$InternerFunction;
import com.google.common.collect.Interners$WeakInterner;
import com.google.common.collect.MapMaker;
import java.util.concurrent.ConcurrentMap;

@Beta
public final class Interners {
    private Interners() {
    }

    public static Interner newStrongInterner() {
        ConcurrentMap concurrentMap = new MapMaker().makeMap();
        return new Interners$1(concurrentMap);
    }

    @GwtIncompatible(value="java.lang.ref.WeakReference")
    public static Interner newWeakInterner() {
        return new Interners$WeakInterner(null);
    }

    public static Function asFunction(Interner interner) {
        return new Interners$InternerFunction((Interner)Preconditions.checkNotNull(interner));
    }
}

