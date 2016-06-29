package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class CombinedTreeNodeAdressComparator implements Comparator
{
    private final ESortOrder order;
    
    public CombinedTreeNodeAdressComparator(final ESortOrder order) {
        Preconditions.checkNotNull(order);
        this.order = order;
    }
    
    public int compare(final ISortableTreeNode sortableTreeNode, final ISortableTreeNode sortableTreeNode2) {
        final IAddress address = sortableTreeNode.getAddress(ESide.PRIMARY);
        final IAddress address2 = sortableTreeNode.getAddress(ESide.SECONDARY);
        final IAddress address3 = sortableTreeNode2.getAddress(ESide.PRIMARY);
        final IAddress address4 = sortableTreeNode2.getAddress(ESide.SECONDARY);
        int n;
        if (address == null && address3 == null) {
            n = address2.compareTo(address4);
        }
        else if (address == null) {
            n = 1;
        }
        else if (address3 == null) {
            n = -1;
        }
        else {
            n = address.compareTo(address3);
        }
        if (this.order == ESortOrder.DESCENDING) {
            n *= -1;
        }
        return n;
    }
}
