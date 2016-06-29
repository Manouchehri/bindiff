package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.enums.*;

public class FunctionTreeNodeTypeComparator implements Comparator
{
    private final ESortOrder order;
    
    public FunctionTreeNodeTypeComparator(final ESortOrder eSortOrder) {
        this.order = (ESortOrder)Preconditions.checkNotNull(eSortOrder);
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        int compareTo = Integer.valueOf(EFunctionType.getOrdinal(sortableTreeNode.getFunctionType())).compareTo(Integer.valueOf(EFunctionType.getOrdinal(sortableTreeNode2.getFunctionType())));
        if (this.order == ESortOrder.DESCENDING) {
            compareTo *= -1;
        }
        return compareTo;
    }
}
