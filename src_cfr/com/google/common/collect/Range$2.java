/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

final class Range$2
implements Function {
    Range$2() {
    }

    public Cut apply(Range range) {
        return range.upperBound;
    }
}

