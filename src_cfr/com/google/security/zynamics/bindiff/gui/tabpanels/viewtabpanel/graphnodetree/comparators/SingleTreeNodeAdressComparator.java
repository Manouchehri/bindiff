/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class SingleTreeNodeAdressComparator
implements Comparator {
    private final ESortOrder order;

    public SingleTreeNodeAdressComparator(ESortOrder eSortOrder) {
        this.order = (ESortOrder)((Object)Preconditions.checkNotNull((Object)eSortOrder));
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        int n2 = 0;
        IAddress iAddress = iSortableTreeNode.getAddress();
        IAddress iAddress2 = iSortableTreeNode2.getAddress();
        n2 = iAddress.compareTo(iAddress2);
        if (this.order != ESortOrder.DESCENDING) return n2;
        n2 *= -1;
        return n2;
    }
}

