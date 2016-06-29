/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseAllViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CloseViewAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class TabButtonComponent$InternalMouseListener
extends MouseAdapter {
    private JPopupMenu popup;
    final /* synthetic */ TabButtonComponent this$0;

    private TabButtonComponent$InternalMouseListener(TabButtonComponent tabButtonComponent) {
        this.this$0 = tabButtonComponent;
        this.popup = null;
    }

    private void createPopupmenu() {
        if (this.popup != null) return;
        this.popup = new JPopupMenu();
        this.popup.add(GuiUtils.buildMenuItem("Close View", new CloseViewAction((ViewTabPanel)TabButtonComponent.access$100(this.this$0))));
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = ((WorkspaceTabPanel)TabButtonComponent.access$200(this.this$0).getComponentAt(0)).getController();
        this.popup.add(GuiUtils.buildMenuItem("Close Others", new CloseAllViewsAction(workspaceTabPanelFunctions, (ViewTabPanel)TabButtonComponent.access$100(this.this$0))));
        this.popup.add(GuiUtils.buildMenuItem("Close All", new CloseAllViewsAction(workspaceTabPanelFunctions)));
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        int n2 = TabButtonComponent.access$200(this.this$0).indexOfTabComponent(this.this$0);
        TabButtonComponent.access$200(this.this$0).setSelectedIndex(n2);
        if (n2 == 0) return;
        if (!mouseEvent.isPopupTrigger()) return;
        this.createPopupmenu();
        this.popup.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        int n2 = TabButtonComponent.access$200(this.this$0).indexOfTabComponent(this.this$0);
        if (n2 != 0 && mouseEvent.isPopupTrigger()) {
            this.createPopupmenu();
            this.popup.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
        }
        if (mouseEvent.getButton() != 2) return;
        if (mouseEvent.getClickCount() != 1) return;
        CloseViewAction closeViewAction = new CloseViewAction((ViewTabPanel)TabButtonComponent.access$100(this.this$0));
        closeViewAction.execute();
    }

    /* synthetic */ TabButtonComponent$InternalMouseListener(TabButtonComponent tabButtonComponent, TabButtonComponent$1 tabButtonComponent$1) {
        this(tabButtonComponent);
    }
}

