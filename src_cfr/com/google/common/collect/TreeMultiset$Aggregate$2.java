/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$Aggregate;
import com.google.common.collect.TreeMultiset$AvlNode;
import javax.annotation.Nullable;

final class TreeMultiset$Aggregate$2
extends TreeMultiset$Aggregate {
    TreeMultiset$Aggregate$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    int nodeAggregate(TreeMultiset$AvlNode treeMultiset$AvlNode) {
        return 1;
    }

    @Override
    long treeAggregate(@Nullable TreeMultiset$AvlNode treeMultiset$AvlNode) {
        if (treeMultiset$AvlNode == null) {
            return 0;
        }
        long l2 = TreeMultiset$AvlNode.access$400(treeMultiset$AvlNode);
        return l2;
    }
}

