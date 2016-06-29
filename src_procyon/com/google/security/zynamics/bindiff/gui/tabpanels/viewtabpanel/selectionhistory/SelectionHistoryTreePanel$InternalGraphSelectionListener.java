package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory;

import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.*;
import javax.swing.tree.*;

class SelectionHistoryTreePanel$InternalGraphSelectionListener implements IZyGraphSelectionListener
{
    private SelectionSnapshot lastSnapshot;
    final /* synthetic */ SelectionHistoryTreePanel this$0;
    
    private SelectionHistoryTreePanel$InternalGraphSelectionListener(final SelectionHistoryTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void selectionChanged() {
        final SelectionSnapshot lastSnapshot = new SelectionSnapshot(GraphNodeFilter.filterNodes(this.this$0.graph, GraphNodeFilter$Criterium.SELECTED));
        if (lastSnapshot.getNumberOfSelectedNodes() != 0 && !lastSnapshot.equals(this.lastSnapshot)) {
            this.this$0.selectionHistory.addSnapshot(lastSnapshot);
            this.lastSnapshot = lastSnapshot;
        }
        this.this$0.updateUI();
    }
}
