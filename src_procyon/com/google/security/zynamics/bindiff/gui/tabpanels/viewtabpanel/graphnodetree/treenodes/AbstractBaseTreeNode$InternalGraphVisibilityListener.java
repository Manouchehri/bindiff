package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.*;

class AbstractBaseTreeNode$InternalGraphVisibilityListener implements IZyGraphVisibilityListener
{
    final /* synthetic */ AbstractBaseTreeNode this$0;
    
    private AbstractBaseTreeNode$InternalGraphVisibilityListener(final AbstractBaseTreeNode this$0) {
        this.this$0 = this$0;
    }
    
    private void handleNotifcationAndUpdateTreeNodes() {
        boolean b = this.this$0.getFilter().getVisibilityFilterValue() != EVisibilityFilter.NONE;
        if (!b) {
            final Iterator iterator = this.this$0.getSorter().iterator();
            while (iterator.hasNext()) {
                b = (iterator.next().first() == ESortByCriterium.VISIBILITY);
                if (b) {
                    break;
                }
            }
        }
        if (b) {
            this.this$0.updateTreeNodes(false);
        }
    }
    
    @Override
    public void nodeDeleted() {
        this.handleNotifcationAndUpdateTreeNodes();
    }
    
    @Override
    public void visibilityChanged() {
        this.handleNotifcationAndUpdateTreeNodes();
    }
}
