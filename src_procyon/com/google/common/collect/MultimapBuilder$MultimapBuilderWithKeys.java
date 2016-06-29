package com.google.common.collect;

import java.util.*;
import com.google.common.base.*;

public abstract class MultimapBuilder$MultimapBuilderWithKeys
{
    private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;
    
    abstract Map createMap();
    
    public MultimapBuilder$ListMultimapBuilder arrayListValues() {
        return this.arrayListValues(2);
    }
    
    public MultimapBuilder$ListMultimapBuilder arrayListValues(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$1(this, n);
    }
    
    public MultimapBuilder$ListMultimapBuilder linkedListValues() {
        return new MultimapBuilder$MultimapBuilderWithKeys$2(this);
    }
    
    public MultimapBuilder$SetMultimapBuilder hashSetValues() {
        return this.hashSetValues(2);
    }
    
    public MultimapBuilder$SetMultimapBuilder hashSetValues(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$3(this, n);
    }
    
    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues() {
        return this.linkedHashSetValues(2);
    }
    
    public MultimapBuilder$SetMultimapBuilder linkedHashSetValues(final int n) {
        CollectPreconditions.checkNonnegative(n, "expectedValuesPerKey");
        return new MultimapBuilder$MultimapBuilderWithKeys$4(this, n);
    }
    
    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues() {
        return this.treeSetValues(Ordering.natural());
    }
    
    public MultimapBuilder$SortedSetMultimapBuilder treeSetValues(final Comparator comparator) {
        Preconditions.checkNotNull(comparator, (Object)"comparator");
        return new MultimapBuilder$MultimapBuilderWithKeys$5(this, comparator);
    }
    
    public MultimapBuilder$SetMultimapBuilder enumSetValues(final Class clazz) {
        Preconditions.checkNotNull(clazz, (Object)"valueClass");
        return new MultimapBuilder$MultimapBuilderWithKeys$6(this, clazz);
    }
}
