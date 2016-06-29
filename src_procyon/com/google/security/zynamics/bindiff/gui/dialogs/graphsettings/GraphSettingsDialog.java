package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.panels.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import java.awt.event.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.gui.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class GraphSettingsDialog extends BaseDialog
{
    private static final int DIALOG_WIDTH = 630;
    private static final int DIALOG_HEIGHT = 282;
    private final ProximityBrowsingPanel proximityBrowsingPanel;
    private final EdgesPanel edgesPanel;
    private final HierarchicalLayoutPanel hierarchicalLayoutPanel;
    private final OrthogonalLayoutPanel orthogonalLayoutPanel;
    private final CircularLayoutPanel circularLayoutPanel;
    private final ControlsPanel controlsPanel;
    private final MiscPanel miscPanel;
    private final CPanelTwoButtons buttons;
    private final GraphSettings settings;
    
    public GraphSettingsDialog(final Window window, final GraphSettings graphSettings) {
        super(window, "Graphview Settings");
        this.buttons = new CPanelTwoButtons(new GraphSettingsDialog$InternalButtonListener(this, null), "Ok", "Cancel");
        this.settings = (GraphSettings)Preconditions.checkNotNull(graphSettings);
        this.proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.NON_INITIAL, graphSettings);
        this.init();
        this.pack();
        this.setSize(630, 282);
        this.setMinimumSize(new Dimension(630, 282));
        GuiHelper.centerChildToParent(window, this, true);
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
        final JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Browsing", this.proximityBrowsingPanel);
        tabbedPane.addTab("Edges", this.edgesPanel);
        tabbedPane.addTab("Hierarchical", this.hierarchicalLayoutPanel);
        tabbedPane.addTab("Orthogonal", this.orthogonalLayoutPanel);
        tabbedPane.addTab("Circular", this.circularLayoutPanel);
        tabbedPane.addTab("Controls", this.controlsPanel);
        tabbedPane.addTab("Misc", this.miscPanel);
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel.add(tabbedPane, "Center");
        panel.add(this.buttons, "South");
        this.add(panel, "Center");
    }
    
    @Override
    public void setVisible(final boolean visible) {
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
