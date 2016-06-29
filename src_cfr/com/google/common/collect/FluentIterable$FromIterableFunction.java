/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.FluentIterable$1;

class FluentIterable$FromIterableFunction
implements Function {
    private FluentIterable$FromIterableFunction() {
    }

    public FluentIterable apply(Iterable iterable) {
        return FluentIterable.from(iterable);
    }

    /* synthetic */ FluentIterable$FromIterableFunction(FluentIterable$1 fluentIterable$1) {
        this();
    }
}

