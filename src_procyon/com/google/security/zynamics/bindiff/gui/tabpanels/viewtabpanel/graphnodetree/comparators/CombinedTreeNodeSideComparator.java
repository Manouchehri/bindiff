package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.enums.*;

public class CombinedTreeNodeSideComparator implements Comparator
{
    private final ESortOrder order;
    
    public CombinedTreeNodeSideComparator(final ESortOrder order) {
        Preconditions.checkNotNull(order);
        this.order = order;
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        int n = 0;
        if (sortableTreeNode.getMatchState() == sortableTreeNode2.getMatchState()) {
            return 0;
        }
        if (sortableTreeNode.getMatchState() == EMatchState.MATCHED) {
            n = -1;
        }
        else if (sortableTreeNode2.getMatchState() == EMatchState.MATCHED) {
            n = 1;
        }
        else if (sortableTreeNode.getMatchState() == EMatchState.PRIMARY_UNMATCHED) {
            n = -1;
        }
        else if (sortableTreeNode.getMatchState() == EMatchState.SECONDRAY_UNMATCHED) {
            n = 1;
        }
        if (this.order == ESortOrder.DESCENDING) {
            n *= -1;
        }
        return n;
    }
}
