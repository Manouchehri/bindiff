package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;

public class SingleTreeNodeAdressComparator implements Comparator
{
    private final ESortOrder order;
    
    public SingleTreeNodeAdressComparator(final ESortOrder eSortOrder) {
        this.order = (ESortOrder)Preconditions.checkNotNull(eSortOrder);
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        int compareTo = sortableTreeNode.getAddress().compareTo(sortableTreeNode2.getAddress());
        if (this.order == ESortOrder.DESCENDING) {
            compareTo *= -1;
        }
        return compareTo;
    }
}
