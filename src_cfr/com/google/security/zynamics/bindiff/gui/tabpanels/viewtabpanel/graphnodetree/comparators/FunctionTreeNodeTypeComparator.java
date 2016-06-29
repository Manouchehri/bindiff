/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class FunctionTreeNodeTypeComparator
implements Comparator {
    private final ESortOrder order;

    public FunctionTreeNodeTypeComparator(ESortOrder eSortOrder) {
        this.order = (ESortOrder)((Object)Preconditions.checkNotNull((Object)eSortOrder));
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        Integer n2 = EFunctionType.getOrdinal(iSortableTreeNode.getFunctionType());
        Integer n3 = EFunctionType.getOrdinal(iSortableTreeNode2.getFunctionType());
        int n4 = n2.compareTo(n3);
        if (this.order != ESortOrder.DESCENDING) return n4;
        n4 *= -1;
        return n4;
    }
}

