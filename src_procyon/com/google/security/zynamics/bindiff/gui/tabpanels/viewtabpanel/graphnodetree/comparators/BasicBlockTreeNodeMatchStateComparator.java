package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.enums.*;

public class BasicBlockTreeNodeMatchStateComparator implements Comparator
{
    private final ESortOrder sortOrder;
    
    public BasicBlockTreeNodeMatchStateComparator(final ESortOrder eSortOrder) {
        this.sortOrder = (ESortOrder)Preconditions.checkNotNull(eSortOrder);
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        int n = 0;
        if (sortableTreeNode.getMatchState() == EMatchState.MATCHED && sortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            if (sortableTreeNode.getMatchType() == sortableTreeNode2.getMatchType()) {
                return 0;
            }
            if (sortableTreeNode.getMatchType() == EMatchType.IDENTICAL) {
                n = -1;
            }
            else if (sortableTreeNode.getMatchType() == EMatchType.INSTRUCTIONS_CHANGED) {
                n = 1;
            }
        }
        else if (sortableTreeNode.getMatchState() != EMatchState.MATCHED && sortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            n = 1;
        }
        else if (sortableTreeNode.getMatchState() == EMatchState.MATCHED && sortableTreeNode2.getMatchState() != EMatchState.MATCHED) {
            n = -1;
        }
        if (this.sortOrder == ESortOrder.DESCENDING) {
            n *= -1;
        }
        return n;
    }
}
