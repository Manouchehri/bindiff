/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut$AboveAll;
import com.google.common.collect.Cut$AboveValue;
import com.google.common.collect.Cut$BelowAll;
import com.google.common.collect.Cut$BelowValue;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
abstract class Cut
implements Serializable,
Comparable {
    final Comparable endpoint;
    private static final long serialVersionUID = 0;

    Cut(@Nullable Comparable comparable) {
        this.endpoint = comparable;
    }

    abstract boolean isLessThan(Comparable var1);

    abstract BoundType typeAsLowerBound();

    abstract BoundType typeAsUpperBound();

    abstract Cut withLowerBoundType(BoundType var1, DiscreteDomain var2);

    abstract Cut withUpperBoundType(BoundType var1, DiscreteDomain var2);

    abstract void describeAsLowerBound(StringBuilder var1);

    abstract void describeAsUpperBound(StringBuilder var1);

    abstract Comparable leastValueAbove(DiscreteDomain var1);

    abstract Comparable greatestValueBelow(DiscreteDomain var1);

    Cut canonical(DiscreteDomain discreteDomain) {
        return this;
    }

    public int compareTo(Cut cut) {
        if (cut == Cut.belowAll()) {
            return 1;
        }
        if (cut == Cut.aboveAll()) {
            return -1;
        }
        int n2 = Range.compareOrThrow(this.endpoint, cut.endpoint);
        if (n2 == 0) return Booleans.compare(this instanceof Cut$AboveValue, cut instanceof Cut$AboveValue);
        return n2;
    }

    Comparable endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object object) {
        if (!(object instanceof Cut)) return false;
        Cut cut = (Cut)object;
        try {
            int n2 = this.compareTo(cut);
            if (n2 != 0) return false;
            return true;
        }
        catch (ClassCastException var3_4) {
            // empty catch block
        }
        return false;
    }

    static Cut belowAll() {
        return Cut$BelowAll.access$000();
    }

    static Cut aboveAll() {
        return Cut$AboveAll.access$100();
    }

    static Cut belowValue(Comparable comparable) {
        return new Cut$BelowValue(comparable);
    }

    static Cut aboveValue(Comparable comparable) {
        return new Cut$AboveValue(comparable);
    }
}

