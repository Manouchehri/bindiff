/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.MultimapBuilder$ListMultimapBuilder;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$1;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5;
import com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.MultimapBuilder$SortedSetMultimapBuilder;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

public abstract class MultimapBuilder$MultimapBuilderWithKeys {
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

    MultimapBuilder$MultimapBuilderWithKeys() {
    }

    abstract Map createMap();

    public MultimapBuilder$ListMultimapBuilder arrayListValues() {
        return this.arrayListValues(2);
    }

    public MultimapBuilder$ListMultimapBuilder arrayListValues(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$1(this, n2);
    }

    public MultimapBuilder$ListMultimapBuilder linkedListValues() {
        return new MultimapBuilder$MultimapBuilderWithKeys$2(this);
    }

    public MultimapBuilder$SetMultimapBuilder hashSetValues() {
        return this.hashSetValues(2);
    }

    public MultimapBuilder$SetMultimapBuilder hashSetValues(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$3(this, n2);
    }

    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues() {
        return this.linkedHashSetValues(2);
    }

    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues(int n2) {
        CollectPreconditions.checkNonnegative(n2, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$4(this, n2);
    }

    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues() {
        return this.treeSetValues(Ordering.natural());
    }

    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues(Comparator comparator) {
        Preconditions.checkNotNull(comparator, "comparator");
        return new MultimapBuilder$MultimapBuilderWithKeys$5(this, comparator);
    }

    public MultimapBuilder$SetMultimapBuilder enumSetValues(Class class_) {
        Preconditions.checkNotNull(class_, "valueClass");
        return new MultimapBuilder$MultimapBuilderWithKeys$6(this, class_);
    }
}

