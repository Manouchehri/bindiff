/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class TreeNodeSelectionComparator
implements Comparator {
    private final ESortOrder order;

    public TreeNodeSelectionComparator(ESortOrder eSortOrder) {
        this.order = (ESortOrder)((Object)Preconditions.checkNotNull((Object)eSortOrder));
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        int n2 = 0;
        if (!iSortableTreeNode.isSelected() && iSortableTreeNode2.isSelected()) {
            n2 = 1;
        } else if (iSortableTreeNode.isSelected() && !iSortableTreeNode2.isSelected()) {
            n2 = -1;
        }
        if (this.order != ESortOrder.DESCENDING) return n2;
        n2 *= -1;
        return n2;
    }
}

