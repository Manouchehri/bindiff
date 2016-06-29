package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.NormalGraphPanel;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;

public class CNormalViewPanel extends JPanel {
   private static final double DEFAULT_DIVIDER_LOCATION = 0.5D;
   private final JSplitPane mainSplitter = new JSplitPane(1);
   private final NormalGraphPanel primaryPanel;
   private final NormalGraphPanel secondaryPanel;
   private final ViewTabPanelFunctions controller;

   public CNormalViewPanel(Diff var1, ViewTabPanelFunctions var2, ViewData var3) {
      super(new BorderLayout());
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var2);
      Preconditions.checkNotNull(var3);
      this.primaryPanel = new NormalGraphPanel(var2, var1, var3, ESide.PRIMARY);
      this.secondaryPanel = new NormalGraphPanel(var2, var1, var3, ESide.SECONDARY);
      this.initPanel(var3);
      this.showSupergraph(var3);
   }

   private void initPanel(ViewData var1) {
      this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.mainSplitter.setLeftComponent(this.primaryPanel);
      this.mainSplitter.setRightComponent(this.secondaryPanel);
      this.mainSplitter.setMinimumSize(new Dimension(0, 0));
      this.mainSplitter.setOneTouchExpandable(true);
      this.mainSplitter.setDoubleBuffered(true);
      this.mainSplitter.setContinuousLayout(true);
      this.mainSplitter.setResizeWeight(0.5D);
      this.mainSplitter.setDividerLocation(0.5D);
      this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
      this.add(this.mainSplitter, "Center");
      if(var1.isFlowgraphView()) {
         if(var1.getAddress(ESide.PRIMARY) == null) {
            this.mainSplitter.setDividerLocation(0.0D);
         } else if(var1.getAddress(ESide.SECONDARY) == null) {
            this.mainSplitter.setDividerLocation(4192);
         }
      }

   }

   private void showSupergraph(ViewData var1) {
   }

   public void dispose() {
      this.primaryPanel.dispose();
      this.secondaryPanel.dispose();
   }

   public ViewTabPanelFunctions getController() {
      return this.controller;
   }

   public NormalGraphPanel getPrimaryPanel() {
      return this.primaryPanel;
   }

   public NormalGraphPanel getSecondaryPanel() {
      return this.secondaryPanel;
   }

   public void resetDefaultPerspective() {
      this.primaryPanel.resetDefaultPerspective();
      this.secondaryPanel.resetDefaultPerspective();
      this.mainSplitter.setResizeWeight(0.5D);
      this.mainSplitter.setDividerLocation(0.5D);
   }

   public void toggleGraphsPerspective() {
      this.primaryPanel.toggleGraphsPerspective();
      this.secondaryPanel.toggleGraphsPerspective();
   }

   public void togglePrimaryPerspective() {
      if((double)this.mainSplitter.getRightComponent().getSize().width == 0.0D) {
         this.resetDefaultPerspective();
      } else {
         this.primaryPanel.setMainDividerLocationAndResizeWeight(0.2D);
         this.mainSplitter.setDividerLocation(1.0D);
      }

   }

   public void toggleSecondaryPerspective() {
      if(this.mainSplitter.getDividerLocation() != 0) {
         this.secondaryPanel.setMainDividerLocationAndResizeWeight(0.8D);
         this.mainSplitter.setDividerLocation(0.0D);
      } else {
         this.resetDefaultPerspective();
      }

   }
}
