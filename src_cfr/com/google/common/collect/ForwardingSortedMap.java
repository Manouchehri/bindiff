/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap
extends ForwardingMap
implements SortedMap {
    protected ForwardingSortedMap() {
    }

    @Override
    protected abstract SortedMap delegate();

    public Comparator comparator() {
        return this.delegate().comparator();
    }

    public Object firstKey() {
        return this.delegate().firstKey();
    }

    public SortedMap headMap(Object object) {
        return this.delegate().headMap(object);
    }

    public Object lastKey() {
        return this.delegate().lastKey();
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.delegate().subMap(object, object2);
    }

    public SortedMap tailMap(Object object) {
        return this.delegate().tailMap(object);
    }

    private int unsafeCompare(Object object, Object object2) {
        Comparator comparator = this.comparator();
        if (comparator != null) return comparator.compare(object, object2);
        return ((Comparable)object).compareTo(object2);
    }

    @Beta
    @Override
    protected boolean standardContainsKey(@Nullable Object object) {
        try {
            ForwardingSortedMap forwardingSortedMap = this;
            Object object2 = forwardingSortedMap.tailMap(object).firstKey();
            if (this.unsafeCompare(object2, object) != 0) return false;
            return true;
        }
        catch (ClassCastException var2_3) {
            return false;
        }
        catch (NoSuchElementException var2_4) {
            return false;
        }
        catch (NullPointerException var2_5) {
            return false;
        }
    }

    @Beta
    protected SortedMap standardSubMap(Object object, Object object2) {
        Preconditions.checkArgument(this.unsafeCompare(object, object2) <= 0, "fromKey must be <= toKey");
        return this.tailMap(object).headMap(object2);
    }
}

