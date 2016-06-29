package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.tables.*;
import com.google.common.base.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.general.*;

public class CloseViewsAction extends AbstractAction
{
    private final WorkspaceTabPanelFunctions controller;
    private final AbstractTable table;
    
    public CloseViewsAction(final AbstractTable abstractTable, final int n) {
        this.table = (AbstractTable)Preconditions.checkNotNull(abstractTable);
        this.controller = abstractTable.getController();
    }
    
    public CloseViewsAction(final WorkspaceTabPanelFunctions workspaceTabPanelFunctions) {
        this.controller = (WorkspaceTabPanelFunctions)Preconditions.checkNotNull(workspaceTabPanelFunctions);
        this.table = null;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (this.table == null) {
            final Diff selectedDiff = this.controller.getSelectedDiff();
            final HashSet<Diff> set = new HashSet<Diff>();
            if (selectedDiff != null) {
                set.add(selectedDiff);
            }
            this.controller.closeViews(this.controller.getOpenViews(set));
        }
        else {
            final HashSet<ViewTabPanel> set2 = new HashSet<ViewTabPanel>();
            Diff diff = this.table.getDiff();
            final boolean b = diff == null;
            for (final int n : this.table.getSelectedRows()) {
                if (b) {
                    diff = AbstractTable.getRowDiff(this.table, n);
                }
                final Pair viewAddressPair = AbstractTable.getViewAddressPair(this.table, n);
                if (viewAddressPair != null) {
                    final ViewTabPanel tabPanel = this.controller.getMainWindow().getController().getTabPanelManager().getTabPanel((IAddress)viewAddressPair.first(), (IAddress)viewAddressPair.second(), diff);
                    if (tabPanel != null) {
                        set2.add(tabPanel);
                    }
                }
            }
            this.controller.closeViews(set2);
        }
    }
}
