/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.collect.Cut;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$RangeMapEntry;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap
extends AbstractMap {
    final /* synthetic */ TreeRangeMap$SubRangeMap this$1;

    TreeRangeMap$SubRangeMap$SubRangeMapAsMap(TreeRangeMap$SubRangeMap treeRangeMap$SubRangeMap) {
        this.this$1 = treeRangeMap$SubRangeMap;
    }

    @Override
    public boolean containsKey(Object object) {
        if (this.get(object) == null) return false;
        return true;
    }

    @Override
    public Object get(Object object) {
        try {
            if (!(object instanceof Range)) return null;
            Range range = (Range)object;
            if (!TreeRangeMap$SubRangeMap.access$200(this.this$1).encloses(range)) return null;
            if (range.isEmpty()) {
                return null;
            }
            TreeRangeMap$RangeMapEntry treeRangeMap$RangeMapEntry = null;
            if (range.lowerBound.compareTo(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$1).lowerBound) == 0) {
                Map.Entry entry = TreeRangeMap.access$000(this.this$1.this$0).floorEntry(range.lowerBound);
                if (entry != null) {
                    treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)entry.getValue();
                }
            } else {
                treeRangeMap$RangeMapEntry = (TreeRangeMap$RangeMapEntry)TreeRangeMap.access$000(this.this$1.this$0).get(range.lowerBound);
            }
            if (treeRangeMap$RangeMapEntry == null) return null;
            if (!treeRangeMap$RangeMapEntry.getKey().isConnected(TreeRangeMap$SubRangeMap.access$200(this.this$1))) return null;
            if (!treeRangeMap$RangeMapEntry.getKey().intersection(TreeRangeMap$SubRangeMap.access$200(this.this$1)).equals(range)) return null;
            return treeRangeMap$RangeMapEntry.getValue();
        }
        catch (ClassCastException var2_3) {
            return null;
        }
    }

    @Override
    public Object remove(Object object) {
        Object object2 = this.get(object);
        if (object2 == null) return null;
        Range range = (Range)object;
        this.this$1.this$0.remove(range);
        return object2;
    }

    @Override
    public void clear() {
        this.this$1.clear();
    }

    private boolean removeEntryIf(Predicate predicate) {
        ArrayList arrayList = Lists.newArrayList();
        for (Object object2 : this.entrySet()) {
            if (!predicate.apply(object2)) continue;
            arrayList.add(object2.getKey());
        }
        for (Object object2 : arrayList) {
            this.this$1.this$0.remove((Range)object2);
        }
        if (arrayList.isEmpty()) return false;
        return true;
    }

    @Override
    public Set keySet() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(this, this);
    }

    @Override
    public Set entrySet() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(this);
    }

    Iterator entryIterator() {
        if (TreeRangeMap$SubRangeMap.access$200(this.this$1).isEmpty()) {
            return Iterators.emptyIterator();
        }
        Cut cut = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$000(this.this$1.this$0).floorKey(TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$1).lowerBound), TreeRangeMap$SubRangeMap.access$200((TreeRangeMap$SubRangeMap)this.this$1).lowerBound);
        Iterator iterator = TreeRangeMap.access$000(this.this$1.this$0).tailMap(cut, true).values().iterator();
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(this, iterator);
    }

    @Override
    public Collection values() {
        return new TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(this, this);
    }

    static /* synthetic */ boolean access$300(TreeRangeMap$SubRangeMap$SubRangeMapAsMap treeRangeMap$SubRangeMap$SubRangeMapAsMap, Predicate predicate) {
        return treeRangeMap$SubRangeMap$SubRangeMapAsMap.removeEntryIf(predicate);
    }
}

