/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.project.Workspace;
import java.awt.Component;
import java.util.Iterator;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class TabPanelManager$InternalTabListener
implements ChangeListener {
    final /* synthetic */ TabPanelManager this$0;

    private TabPanelManager$InternalTabListener(TabPanelManager tabPanelManager) {
        this.this$0 = tabPanelManager;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        TabPanel tabPanel = (TabPanel)TabPanelManager.access$500(this.this$0).getSelectedComponent();
        TabPanelManager.access$300(this.this$0).updateTitle(TabPanelManager.access$600(this.this$0), tabPanel);
        TabPanelManager.access$300(this.this$0).setJMenuBar(tabPanel.getMenuBar());
        Iterator iterator = TabPanelManager.access$700(this.this$0).iterator();
        while (iterator.hasNext()) {
            ViewToolbarPanel viewToolbarPanel;
            SearchResultsDialog searchResultsDialog;
            TabPanel tabPanel2 = (TabPanel)iterator.next();
            if (!(tabPanel2 instanceof ViewTabPanel)) continue;
            if (tabPanel == tabPanel2) {
                viewToolbarPanel = ((ViewTabPanel)tabPanel2).getToolbar();
                searchResultsDialog = viewToolbarPanel.getSearchResultsDialog();
                searchResultsDialog.setVisible(searchResultsDialog.getReshowDialog());
                continue;
            }
            viewToolbarPanel = ((ViewTabPanel)tabPanel2).getToolbar();
            searchResultsDialog = viewToolbarPanel.getSearchResultsDialog();
            boolean bl2 = searchResultsDialog.isVisible() || searchResultsDialog.getReshowDialog();
            searchResultsDialog.setVisible(false);
            searchResultsDialog.setReshowDialog(bl2);
        }
    }

    /* synthetic */ TabPanelManager$InternalTabListener(TabPanelManager tabPanelManager, TabPanelManager$1 tabPanelManager$1) {
        this(tabPanelManager);
    }
}

