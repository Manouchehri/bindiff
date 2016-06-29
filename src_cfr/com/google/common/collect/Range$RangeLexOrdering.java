/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Cut;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Range$1;
import java.io.Serializable;

class Range$RangeLexOrdering
extends Ordering
implements Serializable {
    private static final long serialVersionUID = 0;

    private Range$RangeLexOrdering() {
    }

    public int compare(Range range, Range range2) {
        return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
    }

    /* synthetic */ Range$RangeLexOrdering(Range$1 range$1) {
        this();
    }
}

