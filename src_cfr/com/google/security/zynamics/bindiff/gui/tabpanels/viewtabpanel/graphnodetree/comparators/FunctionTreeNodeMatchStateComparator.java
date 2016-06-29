/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.EMatchType;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import java.util.Comparator;

public class FunctionTreeNodeMatchStateComparator
implements Comparator {
    private final ESortOrder order;

    public FunctionTreeNodeMatchStateComparator(ESortOrder eSortOrder) {
        this.order = (ESortOrder)((Object)Preconditions.checkNotNull((Object)eSortOrder));
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        int n2 = 0;
        if (iSortableTreeNode.getMatchState() == EMatchState.MATCHED && iSortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            if (iSortableTreeNode.getMatchType() == iSortableTreeNode2.getMatchType()) {
                return 0;
            }
            if (iSortableTreeNode.getMatchType() != EMatchType.IDENTICAL && iSortableTreeNode2.getMatchType() == EMatchType.IDENTICAL) {
                n2 = 1;
            } else if (iSortableTreeNode.getMatchType() == EMatchType.IDENTICAL && iSortableTreeNode2.getMatchType() != EMatchType.IDENTICAL) {
                n2 = -1;
            } else if (iSortableTreeNode.getMatchType() == EMatchType.INSTRUCTIONS_CHANGED && iSortableTreeNode2.getMatchType() == EMatchType.STRUCTURAL_CHANGED) {
                n2 = -1;
            } else if (iSortableTreeNode.getMatchType() == EMatchType.STRUCTURAL_CHANGED && iSortableTreeNode2.getMatchType() == EMatchType.INSTRUCTIONS_CHANGED) {
                n2 = 1;
            }
        } else if (iSortableTreeNode.getMatchState() != EMatchState.MATCHED && iSortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            n2 = 1;
        } else if (iSortableTreeNode.getMatchState() == EMatchState.MATCHED && iSortableTreeNode2.getMatchState() != EMatchState.MATCHED) {
            n2 = -1;
        }
        if (this.order != ESortOrder.DESCENDING) return n2;
        n2 *= -1;
        return n2;
    }
}

