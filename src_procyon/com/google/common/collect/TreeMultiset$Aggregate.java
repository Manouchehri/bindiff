package com.google.common.collect;

import javax.annotation.*;

enum TreeMultiset$Aggregate
{
    SIZE("SIZE", 0), 
    DISTINCT("DISTINCT", 1);
    
    private TreeMultiset$Aggregate(final String s, final int n) {
    }
    
    abstract int nodeAggregate(final TreeMultiset$AvlNode p0);
    
    abstract long treeAggregate(@Nullable final TreeMultiset$AvlNode p0);
}
