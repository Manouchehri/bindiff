package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GraphViewSettingsConfigItem;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialCallGraphSettingsDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.CircularLayoutPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ControlsPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.EdgesPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.HierarchicalLayoutPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.LayoutingPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.MiscPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.OrthogonalLayoutPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ProximityBrowsingPanel;
import com.google.security.zynamics.zylib.gui.CPanelTwoButtons;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class InitialCallGraphSettingsDialog extends BaseDialog {
   private static final int DIALOG_WIDTH = 630;
   private static final int DIALOG_HEIGHT = 282;
   private final LayoutingPanel layoutingPanel;
   private final ProximityBrowsingPanel proximityBrowsingPanel;
   private final EdgesPanel edgesPanel;
   private final HierarchicalLayoutPanel hierarchicalLayoutPanel;
   private final OrthogonalLayoutPanel orthogonalLayoutPanel;
   private final CircularLayoutPanel circularLayoutPanel;
   private final ControlsPanel controlsPanel;
   private final MiscPanel miscPanel;
   private final CPanelTwoButtons buttons;

   public InitialCallGraphSettingsDialog(Window var1) {
      super(var1, "Initial Call Graph Settings");
      this.layoutingPanel = new LayoutingPanel("Layouting", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
      this.buttons = new CPanelTwoButtons(new InitialCallGraphSettingsDialog$InternalButtonListener(this, (InitialCallGraphSettingsDialog$1)null), "Ok", "Cancel");
      this.init();
      this.pack();
      this.setSize(630, 282);
      this.setMinimumSize(new Dimension(630, 282));
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private void save() {
      BinDiffConfigFile var1 = BinDiffConfigFile.getInstance();
      GraphViewSettingsConfigItem var2 = var1.getInitialCallgraphSettings();
      var2.setDefaultGraphLayout(EGraphLayout.getOrdinal(this.layoutingPanel.getDefaultLayout()));
      var2.setAutoLayouting(this.layoutingPanel.getAutoLayouting());
      var2.setProximityBrowsing(this.proximityBrowsingPanel.getProximityBrowsing());
      var2.setAutoProximityBrowsingActivationThreshold(this.proximityBrowsingPanel.getAutoProximityBrowsingActivationThreshold());
      var2.setProximityBrowsingChildDepth(this.proximityBrowsingPanel.getProximityBrowsingChildDepth());
      var2.setProximityBrowsingParentDepth(this.proximityBrowsingPanel.getProximityBrowsingParentDepth());
      var2.setVisibilityWarningThreshold(this.proximityBrowsingPanel.getVisibilityWarningThreshold());
      var2.setDrawBends(this.edgesPanel.getDrawBends());
      var2.setHierarchicalOrthogonalEdgeRouting(this.hierarchicalLayoutPanel.getOrthogonalEdgeRouting());
      var2.setHierarchicalOrientation(ELayoutOrientation.getOrdinal(this.hierarchicalLayoutPanel.getLayoutOrientation()));
      var2.setHierarchicalMinimumLayerDistance(this.hierarchicalLayoutPanel.getMinimumLayerDistance());
      var2.setHierarchicalMinimumNodeDistance(this.hierarchicalLayoutPanel.getMinimumNodeDistance());
      var2.setOrthogonalLayoutStyle(EOrthogonalLayoutStyle.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalLayoutStyle()));
      var2.setOrthogonalOrientation(ELayoutOrientation.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalOrientation()));
      var2.setOrthogonalMinimumNodeDistance(this.orthogonalLayoutPanel.getMinimumNodeDistance());
      var2.setCircularLayoutStyle(ECircularLayoutStyle.getOrdinal(this.circularLayoutPanel.getCircularLayoutStyle()));
      var2.setCircularMinimumNodeDistance(this.circularLayoutPanel.getMinimumNodeDistance());
      var2.setShowScrollbars(this.controlsPanel.getShowScrollbars());
      var2.setMouseWheelAction(EMouseAction.getOrdinal(this.controlsPanel.getMouseWheelBehaviour()));
      var2.setZoomSensitivity(this.controlsPanel.getZoomSensitivity());
      var2.setScrollSensitivity(this.controlsPanel.getScrollSensitivity());
      var2.setViewSynchronization(this.miscPanel.getViewSynchronization());
      var2.setGradientBackground(this.miscPanel.getGradientBackground());
      var2.setLayoutAnimation(this.miscPanel.getLayoutAnimation());
      var2.setAnimationSpeed(this.miscPanel.getAnimationSpeed());
      var1.write();
   }

   private void init() {
      JTabbedPane var1 = new JTabbedPane();
      var1.addTab("Layouting", this.layoutingPanel);
      var1.addTab("Browsing", this.proximityBrowsingPanel);
      var1.addTab("Edges", this.edgesPanel);
      var1.addTab("Hierarchical", this.hierarchicalLayoutPanel);
      var1.addTab("Orthogonal", this.orthogonalLayoutPanel);
      var1.addTab("Circular", this.circularLayoutPanel);
      var1.addTab("Controls", this.controlsPanel);
      var1.addTab("Miscellaneous", this.miscPanel);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(1, 1, 1, 1));
      var2.add(var1, "Center");
      var2.add(this.buttons, "South");
      this.add(var2, "Center");
   }

   public void setVisible(boolean var1) {
      this.layoutingPanel.setCurrentValues();
      this.proximityBrowsingPanel.setCurrentValues();
      this.edgesPanel.setCurrentValues();
      this.hierarchicalLayoutPanel.setCurrentValues();
      this.orthogonalLayoutPanel.setCurrentValues();
      this.circularLayoutPanel.setCurrentValues();
      this.controlsPanel.setCurrentValues();
      this.miscPanel.setCurrentValues();
      super.setVisible(var1);
   }

   // $FF: synthetic method
   static void access$100(InitialCallGraphSettingsDialog var0) {
      var0.save();
   }
}
