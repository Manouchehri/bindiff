/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.comparators;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.ISortableTreeNode;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.util.Comparator;

public class CombinedTreeNodeAdressComparator
implements Comparator {
    private final ESortOrder order;

    public CombinedTreeNodeAdressComparator(ESortOrder eSortOrder) {
        Preconditions.checkNotNull((Object)eSortOrder);
        this.order = eSortOrder;
    }

    public int compare(ISortableTreeNode iSortableTreeNode, ISortableTreeNode iSortableTreeNode2) {
        int n2 = 0;
        IAddress iAddress = iSortableTreeNode.getAddress(ESide.PRIMARY);
        IAddress iAddress2 = iSortableTreeNode.getAddress(ESide.SECONDARY);
        IAddress iAddress3 = iSortableTreeNode2.getAddress(ESide.PRIMARY);
        IAddress iAddress4 = iSortableTreeNode2.getAddress(ESide.SECONDARY);
        n2 = iAddress == null && iAddress3 == null ? iAddress2.compareTo(iAddress4) : (iAddress == null ? 1 : (iAddress3 == null ? -1 : iAddress.compareTo(iAddress3)));
        if (this.order != ESortOrder.DESCENDING) return n2;
        n2 *= -1;
        return n2;
    }
}

