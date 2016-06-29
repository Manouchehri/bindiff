package com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.menubar.WorkspaceMenuBar;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.projecttree.WorkspaceTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.treenodepanels.DefaultTreeNodeContextPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class WorkspaceTabPanel extends TabPanel {
   private static final Icon ICON = ImageUtils.getImageIcon("data/tabicons/workspace-tab.png");
   private final WorkspaceMenuBar menuBar;
   private final JSplitPane splitPanel = new JSplitPane(1, true);
   private final JPanel treeNodeContextContainer = new JPanel(new BorderLayout());
   private final WorkspaceTreePanel workspaceTreePanel;
   private final WorkspaceTabPanelFunctions controller;

   public WorkspaceTabPanel(MainWindow var1, Workspace var2) {
      Preconditions.checkNotNull(var2);
      this.controller = new WorkspaceTabPanelFunctions((MainWindow)Preconditions.checkNotNull(var1), var2);
      this.workspaceTreePanel = new WorkspaceTreePanel(this.controller);
      this.menuBar = new WorkspaceMenuBar(this.controller);
      var1.setJMenuBar(this.menuBar);
      this.initPanel();
      this.controller.loadDefaultWorkspace();
   }

   private void initPanel() {
      this.setBorder(new LineBorder(Color.GRAY));
      this.splitPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.treeNodeContextContainer.add(new DefaultTreeNodeContextPanel());
      this.splitPanel.setOneTouchExpandable(true);
      this.splitPanel.setRightComponent(this.treeNodeContextContainer);
      this.splitPanel.setLeftComponent(this.workspaceTreePanel);
      this.splitPanel.setDividerLocation(BinDiffConfigFile.getInstance().getMainSettings().getWorkspaceTreeDividerPosition());
      this.add(this.splitPanel, "Center");
   }

   public WorkspaceTabPanelFunctions getController() {
      return this.controller;
   }

   public int getDividerLocation() {
      return this.splitPanel.getDividerLocation();
   }

   public Icon getIcon() {
      return ICON;
   }

   public JMenuBar getMenuBar() {
      return this.menuBar;
   }

   public String getTitle() {
      return "Workspace";
   }

   public JPanel getTreeNodeContextContainer() {
      return this.treeNodeContextContainer;
   }

   public WorkspaceTree getWorkspaceTree() {
      return this.workspaceTreePanel.getWorkspaceTree();
   }
}
