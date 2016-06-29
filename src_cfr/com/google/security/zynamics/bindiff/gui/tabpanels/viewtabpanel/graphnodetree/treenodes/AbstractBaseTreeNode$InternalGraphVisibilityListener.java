/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractBaseTreeNode$1;
import com.google.security.zynamics.zylib.general.Pair;
import com.google.security.zynamics.zylib.gui.zygraph.IZyGraphVisibilityListener;
import java.util.Iterator;

class AbstractBaseTreeNode$InternalGraphVisibilityListener
implements IZyGraphVisibilityListener {
    final /* synthetic */ AbstractBaseTreeNode this$0;

    private AbstractBaseTreeNode$InternalGraphVisibilityListener(AbstractBaseTreeNode abstractBaseTreeNode) {
        this.this$0 = abstractBaseTreeNode;
    }

    private void handleNotifcationAndUpdateTreeNodes() {
        boolean bl2;
        boolean bl3 = bl2 = this.this$0.getFilter().getVisibilityFilterValue() != EVisibilityFilter.NONE;
        if (!bl2) {
            Pair pair;
            Iterator iterator = this.this$0.getSorter().iterator();
            do {
                if (!iterator.hasNext()) return;
            } while (!(bl2 = (pair = (Pair)iterator.next()).first() == ESortByCriterium.VISIBILITY));
        }
        if (!bl2) return;
        this.this$0.updateTreeNodes(false);
    }

    @Override
    public void nodeDeleted() {
        this.handleNotifcationAndUpdateTreeNodes();
    }

    @Override
    public void visibilityChanged() {
        this.handleNotifcationAndUpdateTreeNodes();
    }

    /* synthetic */ AbstractBaseTreeNode$InternalGraphVisibilityListener(AbstractBaseTreeNode abstractBaseTreeNode, AbstractBaseTreeNode$1 abstractBaseTreeNode$1) {
        this(abstractBaseTreeNode);
    }
}

