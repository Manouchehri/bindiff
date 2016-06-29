package com.google.security.zynamics.bindiff.gui.window;

import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$1;
import com.google.security.zynamics.bindiff.gui.window.MainWindow$InternalWindowListener$1;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingUtilities;

class MainWindow$InternalWindowListener extends WindowAdapter {
   // $FF: synthetic field
   final MainWindow this$0;

   private MainWindow$InternalWindowListener(MainWindow var1) {
      this.this$0 = var1;
   }

   public void windowClosed(WindowEvent var1) {
      this.this$0.removeWindowListener(MainWindow.access$300(this.this$0));
   }

   public void windowClosing(WindowEvent var1) {
      WorkspaceTabPanelFunctions var2 = MainWindow.access$400(this.this$0).getTabPanelManager().getWorkspaceTabPanel().getController();
      var2.getWorkspaceTree().grabFocus();
      SwingUtilities.invokeLater(new MainWindow$InternalWindowListener$1(this));
   }

   // $FF: synthetic method
   MainWindow$InternalWindowListener(MainWindow var1, MainWindow$1 var2) {
      this(var1);
   }
}
