package com.google.security.zynamics.bindiff.gui.tabpanels;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import java.util.*;
import com.google.common.base.*;
import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;

class TabPanelManager$InternalTabListener implements ChangeListener
{
    final /* synthetic */ TabPanelManager this$0;
    
    private TabPanelManager$InternalTabListener(final TabPanelManager this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void stateChanged(final ChangeEvent changeEvent) {
        final TabPanel tabPanel = (TabPanel)this.this$0.tabbedPane.getSelectedComponent();
        this.this$0.window.updateTitle(this.this$0.workspace, tabPanel);
        this.this$0.window.setJMenuBar(tabPanel.getMenuBar());
        for (final TabPanel tabPanel2 : this.this$0.tabPanels) {
            if (tabPanel2 instanceof ViewTabPanel) {
                if (tabPanel == tabPanel2) {
                    final SearchResultsDialog searchResultsDialog = ((ViewTabPanel)tabPanel2).getToolbar().getSearchResultsDialog();
                    searchResultsDialog.setVisible(searchResultsDialog.getReshowDialog());
                }
                else {
                    final SearchResultsDialog searchResultsDialog2 = ((ViewTabPanel)tabPanel2).getToolbar().getSearchResultsDialog();
                    final boolean reshowDialog = searchResultsDialog2.isVisible() || searchResultsDialog2.getReshowDialog();
                    searchResultsDialog2.setVisible(false);
                    searchResultsDialog2.setReshowDialog(reshowDialog);
                }
            }
        }
    }
}
