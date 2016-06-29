package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.*;
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

class GraphNodeTreePanel$InternalOptionsButtonListener implements ActionListener
{
    final /* synthetic */ GraphNodeTreePanel this$0;
    
    private GraphNodeTreePanel$InternalOptionsButtonListener(final GraphNodeTreePanel this$0) {
        this.this$0 = this$0;
    }
    
    private void setFilter(final boolean b) {
        final GraphNodeMultiFilter filter = ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getFilter();
        filter.setFilter(this.this$0.optionsDialog.getStartAddress(), this.this$0.optionsDialog.getEndAddress(), this.this$0.optionsDialog.getMatchStateFilter(), this.this$0.optionsDialog.getSelectionFilter(), this.this$0.optionsDialog.getVisibilityFilter(), this.this$0.optionsDialog.getSideFilter(), false);
        if (b) {
            filter.notifyListeners();
        }
    }
    
    private void setSearcher(final boolean b) {
        final TreeNodeSearcher searcher = ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getSearcher();
        searcher.setSearchSettings(this.this$0.optionsDialog.getRegEx(), this.this$0.optionsDialog.getCaseSensitive(), this.this$0.optionsDialog.getPrimarySide(), this.this$0.optionsDialog.getSecondarySide(), this.this$0.optionsDialog.getUseTemporaryResult(), this.this$0.optionsDialog.getHighlightGraphNodes());
        if (b) {
            searcher.notifyListeners();
        }
    }
    
    private void setSorter(final boolean b) {
        final TreeNodeMultiSorter sorter = ((AbstractRootTreeNode)this.this$0.tree.getModel().getRoot()).getSorter();
        for (int i = 0; i < 5; ++i) {
            sorter.setCriterium(this.this$0.optionsDialog.getSortByCriterium(i), this.this$0.optionsDialog.getSortOrder(i), i, false);
        }
        if (b) {
            sorter.notifyListeners();
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.optionsButton)) {
            this.this$0.optionsDialog.setVisible(true);
            if (this.this$0.optionsDialog.getOkPressed()) {
                this.setSearcher(false);
                this.setFilter(false);
                this.setSorter(true);
                this.this$0.updateClearTreeSearchIcons();
            }
        }
    }
}
