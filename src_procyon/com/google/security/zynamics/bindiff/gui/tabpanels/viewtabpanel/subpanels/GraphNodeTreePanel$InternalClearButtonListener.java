package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.utils.*;

class GraphNodeTreePanel$InternalClearButtonListener implements ActionListener
{
    final /* synthetic */ GraphNodeTreePanel this$0;
    
    private GraphNodeTreePanel$InternalClearButtonListener(final GraphNodeTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getFilter().clearSettings(false);
        this.this$0.optionsDialog.setDefaults(1);
        ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getSearcher().setSearchString("");
        this.this$0.filterCombo.clear();
        this.this$0.clearButton.setIcon(GraphNodeTreePanel.ICON_CLEAR_GRAY);
    }
}
