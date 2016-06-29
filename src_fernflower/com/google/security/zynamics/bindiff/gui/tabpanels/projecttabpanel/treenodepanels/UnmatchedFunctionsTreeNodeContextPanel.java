package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.AbstractTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.subpanels.UnmatchedFunctionViewsPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import java.util.List;
import javax.swing.JSplitPane;
import javax.swing.border.Border;

public class UnmatchedFunctionsTreeNodeContextPanel extends AbstractTreeNodeContextPanel {
   private final ESide side;
   private final UnmatchedFunctionViewsPanel primaryUnmatchedFunctionViewPanel;
   private final UnmatchedFunctionViewsPanel secondaryUnmatchedFunctionViewPanel;

   public UnmatchedFunctionsTreeNodeContextPanel(Diff var1, WorkspaceTabPanelFunctions var2, ESide var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.side = var3;
      this.primaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(var1, var2, ESide.PRIMARY);
      this.secondaryUnmatchedFunctionViewPanel = new UnmatchedFunctionViewsPanel(var1, var2, ESide.SECONDARY);
      this.init();
   }

   private void init() {
      JSplitPane var1 = new JSplitPane(0, true);
      var1.setBorder((Border)null);
      var1.setOneTouchExpandable(true);
      var1.setResizeWeight(1.0D);
      var1.setDividerLocation(0.2D);
      var1.setTopComponent(this.side == ESide.PRIMARY?this.primaryUnmatchedFunctionViewPanel:this.secondaryUnmatchedFunctionViewPanel);
      var1.setBottomComponent(this.side == ESide.PRIMARY?this.secondaryUnmatchedFunctionViewPanel:this.primaryUnmatchedFunctionViewPanel);
      this.add(var1, "Center");
   }

   public List getTables() {
      return this.side == ESide.PRIMARY?this.primaryUnmatchedFunctionViewPanel.getTables():this.secondaryUnmatchedFunctionViewPanel.getTables();
   }
}
