package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;

public class TreeNodeVisibilityComparator implements Comparator
{
    private final ESortOrder order;
    
    public TreeNodeVisibilityComparator(final ESortOrder eSortOrder) {
        this.order = (ESortOrder)Preconditions.checkNotNull(eSortOrder);
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        int n = 0;
        if (!sortableTreeNode.isVisible() && sortableTreeNode2.isVisible()) {
            n = 1;
        }
        else if (sortableTreeNode.isVisible() && !sortableTreeNode2.isVisible()) {
            n = -1;
        }
        if (this.order == ESortOrder.DESCENDING) {
            n *= -1;
        }
        return n;
    }
}
