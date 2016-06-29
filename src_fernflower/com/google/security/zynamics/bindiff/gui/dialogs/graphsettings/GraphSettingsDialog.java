package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.ESettingsDialogType;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.CircularLayoutPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.ControlsPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.EdgesPanel;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.HierarchicalLayoutPanel;
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

public class GraphSettingsDialog extends BaseDialog {
   private static final int DIALOG_WIDTH = 630;
   private static final int DIALOG_HEIGHT = 282;
   private final ProximityBrowsingPanel proximityBrowsingPanel;
   private final EdgesPanel edgesPanel;
   private final HierarchicalLayoutPanel hierarchicalLayoutPanel;
   private final OrthogonalLayoutPanel orthogonalLayoutPanel;
   private final CircularLayoutPanel circularLayoutPanel;
   private final ControlsPanel controlsPanel;
   private final MiscPanel miscPanel;
   private final CPanelTwoButtons buttons = new CPanelTwoButtons(new GraphSettingsDialog$InternalButtonListener(this, (GraphSettingsDialog$1)null), "Ok", "Cancel");
   private final GraphSettings settings;

   public GraphSettingsDialog(Window var1, GraphSettings var2) {
      super(var1, "Graphview Settings");
      this.settings = (GraphSettings)Preconditions.checkNotNull(var2);
      this.proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.NON_INITIAL, var2);
      this.edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.NON_INITIAL, var2);
      this.hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.NON_INITIAL, var2);
      this.orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.NON_INITIAL, var2);
      this.circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.NON_INITIAL, var2);
      this.controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.NON_INITIAL, var2);
      this.miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.NON_INITIAL, var2);
      this.init();
      this.pack();
      this.setSize(630, 282);
      this.setMinimumSize(new Dimension(630, 282));
      GuiHelper.centerChildToParent(var1, this, true);
   }

   private void save() {
      this.settings.getLayoutSettings().setVisibilityWarningThreshold(this.proximityBrowsingPanel.getVisibilityWarningThreshold());
      this.settings.getProximitySettings().setAutoProximityBrowsingActivationThreshold(this.proximityBrowsingPanel.getAutoProximityBrowsingActivationThreshold());
      this.settings.getProximitySettings().setProximityBrowsingChildren(this.proximityBrowsingPanel.getProximityBrowsingChildDepth());
      this.settings.getProximitySettings().setProximityBrowsingParents(this.proximityBrowsingPanel.getProximityBrowsingParentDepth());
      this.settings.setDrawBends(this.edgesPanel.getDrawBends());
      this.settings.getLayoutSettings().setHierarchicOrthogonalEdgeRouting(this.hierarchicalLayoutPanel.getOrthogonalEdgeRouting());
      this.settings.getLayoutSettings().setHierarchicOrientation(this.hierarchicalLayoutPanel.getLayoutOrientation());
      this.settings.getLayoutSettings().setMinimumHierarchicLayerDistance(this.hierarchicalLayoutPanel.getMinimumLayerDistance());
      this.settings.getLayoutSettings().setMinimumHierarchicNodeDistance(this.hierarchicalLayoutPanel.getMinimumNodeDistance());
      this.settings.getLayoutSettings().setOrthogonalLayoutStyle(this.orthogonalLayoutPanel.getOrthogonalLayoutStyle());
      this.settings.getLayoutSettings().setOrthogonalLayoutOrientation(this.orthogonalLayoutPanel.getOrthogonalOrientation());
      this.settings.getLayoutSettings().setMinimumOrthogonalNodeDistance(this.orthogonalLayoutPanel.getMinimumNodeDistance());
      this.settings.getLayoutSettings().setCircularLayoutStyle(this.circularLayoutPanel.getCircularLayoutStyle());
      this.settings.getLayoutSettings().setMinimumCircularNodeDistance(this.circularLayoutPanel.getMinimumNodeDistance());
      this.settings.setShowScrollbars(this.controlsPanel.getShowScrollbars());
      this.settings.getMouseSettings().setMousewheelAction(this.controlsPanel.getMouseWheelBehaviour());
      this.settings.getMouseSettings().setZoomSensitivity(this.controlsPanel.getZoomSensitivity());
      this.settings.getMouseSettings().setScrollSensitivity(this.controlsPanel.getScrollSensitivity());
      this.settings.getDisplaySettings().setGradientBackground(this.miscPanel.getGradientBackground());
      this.settings.getLayoutSettings().setAnimateLayout(this.miscPanel.getLayoutAnimation());
      this.settings.getDisplaySettings().setAnimationSpeed(this.miscPanel.getAnimationSpeed());
      this.settings.getLayoutSettings().updateLayouter();
   }

   private void init() {
      JTabbedPane var1 = new JTabbedPane();
      var1.addTab("Browsing", this.proximityBrowsingPanel);
      var1.addTab("Edges", this.edgesPanel);
      var1.addTab("Hierarchical", this.hierarchicalLayoutPanel);
      var1.addTab("Orthogonal", this.orthogonalLayoutPanel);
      var1.addTab("Circular", this.circularLayoutPanel);
      var1.addTab("Controls", this.controlsPanel);
      var1.addTab("Misc", this.miscPanel);
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBorder(new EmptyBorder(1, 1, 1, 1));
      var2.add(var1, "Center");
      var2.add(this.buttons, "South");
      this.add(var2, "Center");
   }

   public void setVisible(boolean var1) {
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
   static void access$100(GraphSettingsDialog var0) {
      var0.save();
   }
}
