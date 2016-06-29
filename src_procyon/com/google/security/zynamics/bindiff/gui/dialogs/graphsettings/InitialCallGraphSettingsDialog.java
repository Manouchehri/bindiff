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

public class InitialCallGraphSettingsDialog extends BaseDialog
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
    
    public InitialCallGraphSettingsDialog(final Window window) {
        super(window, "Initial Call Graph Settings");
        this.layoutingPanel = new LayoutingPanel("Layouting", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.INITIAL_CALLGRAPH_SETTING);
        this.buttons = new CPanelTwoButtons(new InitialCallGraphSettingsDialog$InternalButtonListener(this, null), "Ok", "Cancel");
        this.init();
        this.pack();
        this.setSize(630, 282);
        this.setMinimumSize(new Dimension(630, 282));
        GuiHelper.centerChildToParent(window, this, true);
    }
    
    private void save() {
        final BinDiffConfigFile instance = BinDiffConfigFile.getInstance();
        final GraphViewSettingsConfigItem initialCallgraphSettings = instance.getInitialCallgraphSettings();
        initialCallgraphSettings.setDefaultGraphLayout(EGraphLayout.getOrdinal(this.layoutingPanel.getDefaultLayout()));
        initialCallgraphSettings.setAutoLayouting(this.layoutingPanel.getAutoLayouting());
        initialCallgraphSettings.setProximityBrowsing(this.proximityBrowsingPanel.getProximityBrowsing());
        initialCallgraphSettings.setAutoProximityBrowsingActivationThreshold(this.proximityBrowsingPanel.getAutoProximityBrowsingActivationThreshold());
        initialCallgraphSettings.setProximityBrowsingChildDepth(this.proximityBrowsingPanel.getProximityBrowsingChildDepth());
        initialCallgraphSettings.setProximityBrowsingParentDepth(this.proximityBrowsingPanel.getProximityBrowsingParentDepth());
        initialCallgraphSettings.setVisibilityWarningThreshold(this.proximityBrowsingPanel.getVisibilityWarningThreshold());
        initialCallgraphSettings.setDrawBends(this.edgesPanel.getDrawBends());
        initialCallgraphSettings.setHierarchicalOrthogonalEdgeRouting(this.hierarchicalLayoutPanel.getOrthogonalEdgeRouting());
        initialCallgraphSettings.setHierarchicalOrientation(ELayoutOrientation.getOrdinal(this.hierarchicalLayoutPanel.getLayoutOrientation()));
        initialCallgraphSettings.setHierarchicalMinimumLayerDistance(this.hierarchicalLayoutPanel.getMinimumLayerDistance());
        initialCallgraphSettings.setHierarchicalMinimumNodeDistance(this.hierarchicalLayoutPanel.getMinimumNodeDistance());
        initialCallgraphSettings.setOrthogonalLayoutStyle(EOrthogonalLayoutStyle.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalLayoutStyle()));
        initialCallgraphSettings.setOrthogonalOrientation(ELayoutOrientation.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalOrientation()));
        initialCallgraphSettings.setOrthogonalMinimumNodeDistance(this.orthogonalLayoutPanel.getMinimumNodeDistance());
        initialCallgraphSettings.setCircularLayoutStyle(ECircularLayoutStyle.getOrdinal(this.circularLayoutPanel.getCircularLayoutStyle()));
        initialCallgraphSettings.setCircularMinimumNodeDistance(this.circularLayoutPanel.getMinimumNodeDistance());
        initialCallgraphSettings.setShowScrollbars(this.controlsPanel.getShowScrollbars());
        initialCallgraphSettings.setMouseWheelAction(EMouseAction.getOrdinal(this.controlsPanel.getMouseWheelBehaviour()));
        initialCallgraphSettings.setZoomSensitivity(this.controlsPanel.getZoomSensitivity());
        initialCallgraphSettings.setScrollSensitivity(this.controlsPanel.getScrollSensitivity());
        initialCallgraphSettings.setViewSynchronization(this.miscPanel.getViewSynchronization());
        initialCallgraphSettings.setGradientBackground(this.miscPanel.getGradientBackground());
        initialCallgraphSettings.setLayoutAnimation(this.miscPanel.getLayoutAnimation());
        initialCallgraphSettings.setAnimationSpeed(this.miscPanel.getAnimationSpeed());
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
