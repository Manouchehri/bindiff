package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.*;
import java.awt.event.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.config.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class InitialFlowGraphSettingsDialog extends BaseDialog
{
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
    
    public InitialFlowGraphSettingsDialog(final Window window) {
        super(window, "Initial Flow Graph Settings");
        this.layoutingPanel = new LayoutingPanel("Layouting", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
        this.buttons = new CPanelTwoButtons(new InitialFlowGraphSettingsDialog$InternalButtonListener(this, null), "Ok", "Cancel");
        this.init();
        this.pack();
        this.setSize(630, 282);
        this.setMinimumSize(new Dimension(630, 282));
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private void save() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final GraphViewSettingsConfigItem initialFlowgraphSettings = instance.getInitialFlowgraphSettings();
        initialFlowgraphSettings.setDefaultGraphLayout(EGraphLayout.getOrdinal(this.layoutingPanel.getDefaultLayout()));
        initialFlowgraphSettings.setAutoLayouting(this.layoutingPanel.getAutoLayouting());
        initialFlowgraphSettings.setProximityBrowsing(this.proximityBrowsingPanel.getProximityBrowsing());
        initialFlowgraphSettings.setAutoProximityBrowsingActivationThreshold(this.proximityBrowsingPanel.getAutoProximityBrowsingActivationThreshold());
        initialFlowgraphSettings.setProximityBrowsingChildDepth(this.proximityBrowsingPanel.getProximityBrowsingChildDepth());
        initialFlowgraphSettings.setProximityBrowsingParentDepth(this.proximityBrowsingPanel.getProximityBrowsingParentDepth());
        initialFlowgraphSettings.setDrawBends(this.edgesPanel.getDrawBends());
        initialFlowgraphSettings.setHierarchicalOrthogonalEdgeRouting(this.hierarchicalLayoutPanel.getOrthogonalEdgeRouting());
        initialFlowgraphSettings.setHierarchicalOrientation(ELayoutOrientation.getOrdinal(this.hierarchicalLayoutPanel.getLayoutOrientation()));
        initialFlowgraphSettings.setHierarchicalMinimumLayerDistance(this.hierarchicalLayoutPanel.getMinimumLayerDistance());
        initialFlowgraphSettings.setHierarchicalMinimumNodeDistance(this.hierarchicalLayoutPanel.getMinimumNodeDistance());
        initialFlowgraphSettings.setOrthogonalLayoutStyle(EOrthogonalLayoutStyle.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalLayoutStyle()));
        initialFlowgraphSettings.setOrthogonalOrientation(ELayoutOrientation.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalOrientation()));
        initialFlowgraphSettings.setOrthogonalMinimumNodeDistance(this.orthogonalLayoutPanel.getMinimumNodeDistance());
        initialFlowgraphSettings.setCircularLayoutStyle(ECircularLayoutStyle.getOrdinal(this.circularLayoutPanel.getCircularLayoutStyle()));
        initialFlowgraphSettings.setCircularMinimumNodeDistance(this.circularLayoutPanel.getMinimumNodeDistance());
        initialFlowgraphSettings.setShowScrollbars(this.controlsPanel.getShowScrollbars());
        initialFlowgraphSettings.setMouseWheelAction(EMouseAction.getOrdinal(this.controlsPanel.getMouseWheelBehaviour()));
        initialFlowgraphSettings.setZoomSensitivity(this.controlsPanel.getZoomSensitivity());
        initialFlowgraphSettings.setScrollSensitivity(this.controlsPanel.getScrollSensitivity());
        initialFlowgraphSettings.setViewSynchronization(this.miscPanel.getViewSynchronization());
        initialFlowgraphSettings.setGradientBackground(this.miscPanel.getGradientBackground());
        initialFlowgraphSettings.setLayoutAnimation(this.miscPanel.getLayoutAnimation());
        initialFlowgraphSettings.setAnimationSpeed(this.miscPanel.getAnimationSpeed());
        instance.write();
    }
    
    private void init() {
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Layouting", this.layoutingPanel);
        tabbedPane.addTab("Browsing", this.proximityBrowsingPanel);
        tabbedPane.addTab("Edges", this.edgesPanel);
        tabbedPane.addTab("Hierarchical", this.hierarchicalLayoutPanel);
        tabbedPane.addTab("Orthogonal", this.orthogonalLayoutPanel);
        tabbedPane.addTab("Circular", this.circularLayoutPanel);
        tabbedPane.addTab("Controls", this.controlsPanel);
        tabbedPane.addTab("Miscellaneous", this.miscPanel);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel.add(tabbedPane, "Center");
        panel.add(this.buttons, "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void setVisible(final boolean visible) {
        this.layoutingPanel.setCurrentValues();
        this.proximityBrowsingPanel.setCurrentValues();
        this.edgesPanel.setCurrentValues();
        this.hierarchicalLayoutPanel.setCurrentValues();
        this.orthogonalLayoutPanel.setCurrentValues();
        this.circularLayoutPanel.setCurrentValues();
        this.controlsPanel.setCurrentValues();
        this.miscPanel.setCurrentValues();
        super.setVisible(visible);
    }
}
