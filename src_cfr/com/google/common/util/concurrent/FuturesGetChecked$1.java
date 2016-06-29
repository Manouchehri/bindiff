/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.lang.reflect.Constructor;
import java.util.Arrays;

final class FuturesGetChecked$1
implements Function {
    FuturesGetChecked$1() {
    }

    public Boolean apply(Constructor constructor) {
        return Arrays.asList(constructor.getParameterTypes()).contains(String.class);
    }
}

