package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import java.awt.*;
import com.google.common.base.*;
import javax.swing.*;
import java.awt.event.*;

class TabButtonComponent$InternalMouseListener extends MouseAdapter
{
    private JPopupMenu popup;
    final /* synthetic */ TabButtonComponent this$0;
    
    private TabButtonComponent$InternalMouseListener(final TabButtonComponent this$0) {
        this.this$0 = this$0;
        this.popup = null;
    }
    
    private void createPopupmenu() {
        if (this.popup == null) {
            (this.popup = new JPopupMenu()).add(GuiUtils.buildMenuItem("Close View", new CloseViewAction((ViewTabPanel)this.this$0.tabPanel)));
            final WorkspaceTabPanelFunctions controller = ((WorkspaceTabPanel)this.this$0.pane.getComponentAt(0)).getController();
            this.popup.add(GuiUtils.buildMenuItem("Close Others", new CloseAllViewsAction(controller, (ViewTabPanel)this.this$0.tabPanel)));
            this.popup.add(GuiUtils.buildMenuItem("Close All", new CloseAllViewsAction(controller)));
        }
    }
    
    @Override
    public void mousePressed(final MouseEvent mouseEvent) {
        final int indexOfTabComponent = this.this$0.pane.indexOfTabComponent(this.this$0);
        this.this$0.pane.setSelectedIndex(indexOfTabComponent);
        if (indexOfTabComponent != 0 && mouseEvent.isPopupTrigger()) {
            this.createPopupmenu();
            this.popup.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
        }
    }
    
    @Override
    public void mouseReleased(final MouseEvent mouseEvent) {
        if (this.this$0.pane.indexOfTabComponent(this.this$0) != 0 && mouseEvent.isPopupTrigger()) {
            this.createPopupmenu();
            this.popup.show(this.this$0, mouseEvent.getX(), mouseEvent.getY());
        }
        if (mouseEvent.getButton() == 2 && mouseEvent.getClickCount() == 1) {
            new CloseViewAction((ViewTabPanel)this.this$0.tabPanel).execute();
        }
    }
}
