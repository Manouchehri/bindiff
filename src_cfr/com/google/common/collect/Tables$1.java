/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Collections;
import java.util.Map;

final class Tables$1
implements Function {
    Tables$1() {
    }

    public Map apply(Map map) {
        return Collections.unmodifiableMap(map);
    }
}

