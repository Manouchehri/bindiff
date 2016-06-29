package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.actions.CloseAllViewsAction;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.actions.CloseViewAction;
import com.google.security.zynamics.bindiff.utils.GuiUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

class TabButtonComponent$InternalMouseListener extends MouseAdapter {
   private JPopupMenu popup;
   // $FF: synthetic field
   final TabButtonComponent this$0;

   private TabButtonComponent$InternalMouseListener(TabButtonComponent var1) {
      this.this$0 = var1;
      this.popup = null;
   }

   private void createPopupmenu() {
      if(this.popup == null) {
         this.popup = new JPopupMenu();
         this.popup.add(GuiUtils.buildMenuItem("Close View", new CloseViewAction((ViewTabPanel)TabButtonComponent.access$100(this.this$0))));
         WorkspaceTabPanelFunctions var1 = ((WorkspaceTabPanel)TabButtonComponent.access$200(this.this$0).getComponentAt(0)).getController();
         this.popup.add(GuiUtils.buildMenuItem("Close Others", new CloseAllViewsAction(var1, (ViewTabPanel)TabButtonComponent.access$100(this.this$0))));
         this.popup.add(GuiUtils.buildMenuItem("Close All", new CloseAllViewsAction(var1)));
      }

   }

   public void mousePressed(MouseEvent var1) {
      int var2 = TabButtonComponent.access$200(this.this$0).indexOfTabComponent(this.this$0);
      TabButtonComponent.access$200(this.this$0).setSelectedIndex(var2);
      if(var2 != 0 && var1.isPopupTrigger()) {
         this.createPopupmenu();
         this.popup.show(this.this$0, var1.getX(), var1.getY());
      }

   }

   public void mouseReleased(MouseEvent var1) {
      int var2 = TabButtonComponent.access$200(this.this$0).indexOfTabComponent(this.this$0);
      if(var2 != 0 && var1.isPopupTrigger()) {
         this.createPopupmenu();
         this.popup.show(this.this$0, var1.getX(), var1.getY());
      }

      if(var1.getButton() == 2 && var1.getClickCount() == 1) {
         CloseViewAction var3 = new CloseViewAction((ViewTabPanel)TabButtonComponent.access$100(this.this$0));
         var3.execute();
      }

   }

   // $FF: synthetic method
   TabButtonComponent$InternalMouseListener(TabButtonComponent var1, TabButtonComponent$1 var2) {
      this(var1);
   }
}
