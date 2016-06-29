/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractRangeSet;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;
import com.google.common.collect.TreeRangeSet$1;
import com.google.common.collect.TreeRangeSet$AsRanges;
import com.google.common.collect.TreeRangeSet$Complement;
import com.google.common.collect.TreeRangeSet$SubRangeSet;
import java.util.Collection;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible(value="uses NavigableMap")
public class TreeRangeSet
extends AbstractRangeSet {
    @VisibleForTesting
    final NavigableMap rangesByLowerBound;
    private transient Set asRanges;
    private transient Set asDescendingSetOfRanges;
    private transient RangeSet complement;

    public static TreeRangeSet create() {
        return new TreeRangeSet(new TreeMap());
    }

    public static TreeRangeSet create(RangeSet rangeSet) {
        TreeRangeSet treeRangeSet = TreeRangeSet.create();
        treeRangeSet.addAll(rangeSet);
        return treeRangeSet;
    }

    private TreeRangeSet(NavigableMap navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    @Override
    public Set asRanges() {
        Set set;
        Set set2 = this.asRanges;
        if (set2 == null) {
            set = this.asRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.values());
            return set;
        }
        set = set2;
        return set;
    }

    @Override
    public Set asDescendingSetOfRanges() {
        Set set;
        Set set2 = this.asDescendingSetOfRanges;
        if (set2 == null) {
            set = this.asDescendingSetOfRanges = new TreeRangeSet$AsRanges(this, this.rangesByLowerBound.descendingMap().values());
            return set;
        }
        set = set2;
        return set;
    }

    @Nullable
    @Override
    public Range rangeContaining(Comparable comparable) {
        Preconditions.checkNotNull(comparable);
        Map.Entry entry = this.rangesByLowerBound.floorEntry(Cut.belowValue(comparable));
        if (entry == null) return null;
        if (!((Range)entry.getValue()).contains(comparable)) return null;
        return (Range)entry.getValue();
    }

    @Override
    public boolean encloses(Range range) {
        Preconditions.checkNotNull(range);
        Map.Entry entry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entry == null) return false;
        if (!((Range)entry.getValue()).encloses(range)) return false;
        return true;
    }

    @Nullable
    private Range rangeEnclosing(Range range) {
        Preconditions.checkNotNull(range);
        Map.Entry entry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (entry == null) return null;
        if (!((Range)entry.getValue()).encloses(range)) return null;
        Range range2 = (Range)entry.getValue();
        return range2;
    }

    @Override
    public Range span() {
        Map.Entry entry = this.rangesByLowerBound.firstEntry();
        Map.Entry entry2 = this.rangesByLowerBound.lastEntry();
        if (entry != null) return Range.create(((Range)entry.getValue()).lowerBound, ((Range)entry2.getValue()).upperBound);
        throw new NoSuchElementException();
    }

    @Override
    public void add(Range range) {
        Object object;
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Cut cut = range.lowerBound;
        Cut cut2 = range.upperBound;
        Map.Entry entry = this.rangesByLowerBound.lowerEntry(cut);
        if (entry != null) {
            object = (Range)entry.getValue();
            if (object.upperBound.compareTo(cut) >= 0) {
                if (object.upperBound.compareTo(cut2) >= 0) {
                    cut2 = object.upperBound;
                }
                cut = object.lowerBound;
            }
        }
        if ((object = this.rangesByLowerBound.floorEntry(cut2)) != null) {
            Range range2 = (Range)object.getValue();
            if (range2.upperBound.compareTo(cut2) >= 0) {
                cut2 = range2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        this.replaceRangeWithSameLowerBound(Range.create(cut, cut2));
    }

    @Override
    public void remove(Range range) {
        Object object;
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry entry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (entry != null) {
            object = (Range)entry.getValue();
            if (object.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && object.upperBound.compareTo(range.upperBound) >= 0) {
                    this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, object.upperBound));
                }
                this.replaceRangeWithSameLowerBound(Range.create(object.lowerBound, range.lowerBound));
            }
        }
        if ((object = this.rangesByLowerBound.floorEntry(range.upperBound)) != null) {
            Range range2 = (Range)object.getValue();
            if (range.hasUpperBound() && range2.upperBound.compareTo(range.upperBound) >= 0) {
                this.replaceRangeWithSameLowerBound(Range.create(range.upperBound, range2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    private void replaceRangeWithSameLowerBound(Range range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
            return;
        }
        this.rangesByLowerBound.put(range.lowerBound, range);
    }

    @Override
    public RangeSet complement() {
        RangeSet rangeSet;
        RangeSet rangeSet2 = this.complement;
        if (rangeSet2 == null) {
            rangeSet = this.complement = new TreeRangeSet$Complement(this);
            return rangeSet;
        }
        rangeSet = rangeSet2;
        return rangeSet;
    }

    @Override
    public RangeSet subRangeSet(Range range) {
        TreeRangeSet treeRangeSet;
        if (range.equals(Range.all())) {
            treeRangeSet = this;
            return treeRangeSet;
        }
        treeRangeSet = new TreeRangeSet$SubRangeSet(this, range);
        return treeRangeSet;
    }

    /* synthetic */ TreeRangeSet(NavigableMap navigableMap, TreeRangeSet$1 treeRangeSet$1) {
        this(navigableMap);
    }

    static /* synthetic */ Range access$600(TreeRangeSet treeRangeSet, Range range) {
        return treeRangeSet.rangeEnclosing(range);
    }
}

