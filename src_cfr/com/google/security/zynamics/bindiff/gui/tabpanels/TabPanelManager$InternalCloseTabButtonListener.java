/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.zylib.gui.CMessageBox;

class TabPanelManager$InternalCloseTabButtonListener
implements ICloseTabButtonListener {
    final /* synthetic */ TabPanelManager this$0;

    private TabPanelManager$InternalCloseTabButtonListener(TabPanelManager tabPanelManager) {
        this.this$0 = tabPanelManager;
    }

    @Override
    public boolean closing(TabButtonComponent tabButtonComponent) {
        ViewTabPanel viewTabPanel = (ViewTabPanel)tabButtonComponent.getTabPanel();
        ViewData viewData = viewTabPanel.getView();
        if (!viewTabPanel.getController().hasChanged()) {
            viewTabPanel.getController().closeView(false);
            return true;
        }
        viewTabPanel.getTabPanelManager().selectTab(viewTabPanel);
        int n2 = CMessageBox.showYesNoCancelQuestion(TabPanelManager.access$300(this.this$0), String.format("'%s' has been modified. Save?", viewData.getViewName()));
        if (n2 == 2) {
            return false;
        }
        viewTabPanel.getController().closeView(n2 == 0);
        return true;
    }

    /* synthetic */ TabPanelManager$InternalCloseTabButtonListener(TabPanelManager tabPanelManager, TabPanelManager$1 tabPanelManager$1) {
        this(tabPanelManager);
    }
}

