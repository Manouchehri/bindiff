package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class WorkspaceTreePanel extends JPanel {
   private final WorkspaceTree workspaceTree;

   public WorkspaceTreePanel(WorkspaceTabPanelFunctions var1) {
      super(new BorderLayout());
      Preconditions.checkNotNull(var1);
      this.workspaceTree = new WorkspaceTree(var1);
      JScrollPane var2 = new JScrollPane(this.workspaceTree);
      var2.setBorder((Border)null);
      this.add(var2, "Center");
   }

   public WorkspaceTree getWorkspaceTree() {
      return this.workspaceTree;
   }
}
