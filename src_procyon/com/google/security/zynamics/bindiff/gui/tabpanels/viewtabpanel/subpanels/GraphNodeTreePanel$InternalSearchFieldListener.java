package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.event.*;
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

class GraphNodeTreePanel$InternalSearchFieldListener implements ITreeSearchFieldListener
{
    final /* synthetic */ GraphNodeTreePanel this$0;
    
    private GraphNodeTreePanel$InternalSearchFieldListener(final GraphNodeTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void searchChanged(final String searchString) {
        ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getSearcher().setSearchString(searchString);
        this.this$0.updateClearTreeSearchIcons();
    }
}
