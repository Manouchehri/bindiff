/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class CombinedTreeNodeSideComparator
implements Comparator {
    private final ESortOrder order;

    public CombinedTreeNodeSideComparator(ESortOrder eSortOrder) {
        Preconditions.checkNotNull((Object)eSortOrder);
        this.order = eSortOrder;
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        int n2 = 0;
        if (iSortableTreeNode.getMatchState() == iSortableTreeNode2.getMatchState()) {
            return 0;
        }
        if (iSortableTreeNode.getMatchState() == EMatchState.MATCHED) {
            n2 = -1;
        } else if (iSortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            n2 = 1;
        } else if (iSortableTreeNode.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            n2 = -1;
        } else if (iSortableTreeNode.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            n2 = 1;
        }
        if (this.order != ESortOrder.DESCENDING) return n2;
        n2 *= -1;
        return n2;
    }
}

