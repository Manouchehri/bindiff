/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BoundType;
import com.google.common.collect.ContiguousSet;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range$1;
import com.google.common.collect.Range$2;
import com.google.common.collect.Range$3;
import com.google.common.collect.Range$RangeLexOrdering;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Range
implements Predicate,
Serializable {
    private static final Function LOWER_BOUND_FN = new Range$1();
    private static final Function UPPER_BOUND_FN = new Range$2();
    static final Ordering RANGE_LEX_ORDERING = new Range$RangeLexOrdering(null);
    private static final Range ALL = new Range(Cut.belowAll(), Cut.aboveAll());
    final Cut lowerBound;
    final Cut upperBound;
    private static final long serialVersionUID = 0;

    static Function lowerBoundFn() {
        return LOWER_BOUND_FN;
    }

    static Function upperBoundFn() {
        return UPPER_BOUND_FN;
    }

    static Range create(Cut cut, Cut cut2) {
        return new Range(cut, cut2);
    }

    public static Range open(Comparable comparable, Comparable comparable2) {
        return Range.create(Cut.aboveValue(comparable), Cut.belowValue(comparable2));
    }

    public static Range closed(Comparable comparable, Comparable comparable2) {
        return Range.create(Cut.belowValue(comparable), Cut.aboveValue(comparable2));
    }

    @Deprecated
    @GoogleInternal
    public static Range closedOrEmpty(Comparable comparable, Comparable comparable2) {
        Range range;
        if (comparable.compareTo(comparable2) > 0) {
            range = Range.closedOpen(comparable, comparable);
            return range;
        }
        range = Range.closed(comparable, comparable2);
        return range;
    }

    public static Range closedOpen(Comparable comparable, Comparable comparable2) {
        return Range.create(Cut.belowValue(comparable), Cut.belowValue(comparable2));
    }

    public static Range openClosed(Comparable comparable, Comparable comparable2) {
        return Range.create(Cut.aboveValue(comparable), Cut.aboveValue(comparable2));
    }

    public static Range range(Comparable comparable, BoundType boundType, Comparable comparable2, BoundType boundType2) {
        Preconditions.checkNotNull((Object)boundType);
        Preconditions.checkNotNull((Object)boundType2);
        Cut cut = boundType == BoundType.OPEN ? Cut.aboveValue(comparable) : Cut.belowValue(comparable);
        Cut cut2 = boundType2 == BoundType.OPEN ? Cut.belowValue(comparable2) : Cut.aboveValue(comparable2);
        return Range.create(cut, cut2);
    }

    public static Range lessThan(Comparable comparable) {
        return Range.create(Cut.belowAll(), Cut.belowValue(comparable));
    }

    public static Range atMost(Comparable comparable) {
        return Range.create(Cut.belowAll(), Cut.aboveValue(comparable));
    }

    public static Range upTo(Comparable comparable, BoundType boundType) {
        switch (Range$3.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 1: {
                return Range.lessThan(comparable);
            }
            case 2: {
                return Range.atMost(comparable);
            }
        }
        throw new AssertionError();
    }

    public static Range greaterThan(Comparable comparable) {
        return Range.create(Cut.aboveValue(comparable), Cut.aboveAll());
    }

    public static Range atLeast(Comparable comparable) {
        return Range.create(Cut.belowValue(comparable), Cut.aboveAll());
    }

    public static Range downTo(Comparable comparable, BoundType boundType) {
        switch (Range$3.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()]) {
            case 1: {
                return Range.greaterThan(comparable);
            }
            case 2: {
                return Range.atLeast(comparable);
            }
        }
        throw new AssertionError();
    }

    public static Range all() {
        return ALL;
    }

    public static Range singleton(Comparable comparable) {
        return Range.closed(comparable, comparable);
    }

    public static Range encloseAll(Iterable iterable) {
        Comparable comparable;
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof ContiguousSet) {
            return ((ContiguousSet)iterable).range();
        }
        Iterator iterator = iterable.iterator();
        Comparable comparable2 = comparable = (Comparable)Preconditions.checkNotNull(iterator.next());
        while (iterator.hasNext()) {
            Comparable comparable3 = (Comparable)Preconditions.checkNotNull(iterator.next());
            comparable = (Comparable)Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable)Ordering.natural().max(comparable2, comparable3);
        }
        return Range.closed(comparable, comparable2);
    }

    private Range(Cut cut, Cut cut2) {
        String string;
        this.lowerBound = (Cut)Preconditions.checkNotNull(cut);
        this.upperBound = (Cut)Preconditions.checkNotNull(cut2);
        if (cut.compareTo(cut2) <= 0 && cut != Cut.aboveAll()) {
            if (cut2 != Cut.belowAll()) return;
        }
        String string2 = String.valueOf(Range.toString(cut, cut2));
        if (string2.length() != 0) {
            string = "Invalid range: ".concat(string2);
            throw new IllegalArgumentException(string);
        }
        string = new String("Invalid range: ");
        throw new IllegalArgumentException(string);
    }

    public boolean hasLowerBound() {
        if (this.lowerBound == Cut.belowAll()) return false;
        return true;
    }

    public Comparable lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public boolean hasUpperBound() {
        if (this.upperBound == Cut.aboveAll()) return false;
        return true;
    }

    public Comparable upperEndpoint() {
        return this.upperBound.endpoint();
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public boolean contains(Comparable comparable) {
        Preconditions.checkNotNull(comparable);
        if (!this.lowerBound.isLessThan(comparable)) return false;
        if (this.upperBound.isLessThan(comparable)) return false;
        return true;
    }

    @Deprecated
    public boolean apply(Comparable comparable) {
        return this.contains(comparable);
    }

    public boolean containsAll(Iterable iterable) {
        Object object;
        Object object2;
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            object = Range.cast(iterable);
            object2 = object.comparator();
            if (Ordering.natural().equals(object2) || object2 == null) {
                if (!this.contains((Comparable)object.first())) return false;
                if (!this.contains((Comparable)object.last())) return false;
                return true;
            }
        }
        object = iterable.iterator();
        do {
            if (!object.hasNext()) return true;
        } while (this.contains((Comparable)(object2 = (Comparable)object.next())));
        return false;
    }

    public boolean encloses(Range range) {
        if (this.lowerBound.compareTo(range.lowerBound) > 0) return false;
        if (this.upperBound.compareTo(range.upperBound) < 0) return false;
        return true;
    }

    public boolean isConnected(Range range) {
        if (this.lowerBound.compareTo(range.upperBound) > 0) return false;
        if (range.lowerBound.compareTo(this.upperBound) > 0) return false;
        return true;
    }

    public Range intersection(Range range) {
        int n2 = this.lowerBound.compareTo(range.lowerBound);
        int n3 = this.upperBound.compareTo(range.upperBound);
        if (n2 >= 0 && n3 <= 0) {
            return this;
        }
        if (n2 <= 0 && n3 >= 0) {
            return range;
        }
        Cut cut = n2 >= 0 ? this.lowerBound : range.lowerBound;
        Cut cut2 = n3 <= 0 ? this.upperBound : range.upperBound;
        return Range.create(cut, cut2);
    }

    public Range span(Range range) {
        int n2 = this.lowerBound.compareTo(range.lowerBound);
        int n3 = this.upperBound.compareTo(range.upperBound);
        if (n2 <= 0 && n3 >= 0) {
            return this;
        }
        if (n2 >= 0 && n3 <= 0) {
            return range;
        }
        Cut cut = n2 <= 0 ? this.lowerBound : range.lowerBound;
        Cut cut2 = n3 >= 0 ? this.upperBound : range.upperBound;
        return Range.create(cut, cut2);
    }

    public Range canonical(DiscreteDomain discreteDomain) {
        Range range;
        Preconditions.checkNotNull(discreteDomain);
        Cut cut = this.lowerBound.canonical(discreteDomain);
        Cut cut2 = this.upperBound.canonical(discreteDomain);
        if (cut == this.lowerBound && cut2 == this.upperBound) {
            range = this;
            return range;
        }
        range = Range.create(cut, cut2);
        return range;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Range)) return false;
        Range range = (Range)object;
        if (!this.lowerBound.equals(range.lowerBound)) return false;
        if (!this.upperBound.equals(range.upperBound)) return false;
        return true;
    }

    public int hashCode() {
        return this.lowerBound.hashCode() * 31 + this.upperBound.hashCode();
    }

    public String toString() {
        return Range.toString(this.lowerBound, this.upperBound);
    }

    private static String toString(Cut cut, Cut cut2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        cut.describeAsLowerBound(stringBuilder);
        stringBuilder.append('\u2025');
        cut2.describeAsUpperBound(stringBuilder);
        return stringBuilder.toString();
    }

    private static SortedSet cast(Iterable iterable) {
        return (SortedSet)iterable;
    }

    Object readResolve() {
        if (!this.equals(ALL)) return this;
        return Range.all();
    }

    static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }
}

