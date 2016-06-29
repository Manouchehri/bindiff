package com.google.common.collect;

import javax.annotation.*;
import java.util.*;
import com.google.common.base.*;

enum TreeMultiset$Aggregate$1
{
    TreeMultiset$Aggregate$1(final String s, final int n) {
    }
    
    @Override
    int nodeAggregate(final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return treeMultiset$AvlNode.elemCount;
    }
    
    @Override
    long treeAggregate(@Nullable final TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return (treeMultiset$AvlNode == null) ? 0L : treeMultiset$AvlNode.totalCount;
    }
}
