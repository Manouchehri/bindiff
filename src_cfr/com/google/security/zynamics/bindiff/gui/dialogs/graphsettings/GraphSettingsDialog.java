/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.graphsettings;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ECircularLayoutStyle;
import com.google.security.zynamics.bindiff.enums.ELayoutOrientation;
import com.google.security.zynamics.bindiff.enums.EMouseAction;
import com.google.security.zynamics.bindiff.enums.EOrthogonalLayoutStyle;
import com.google.security.zynamics.bindiff.graph.settings.GraphDisplaySettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphMouseSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GraphSettingsDialog
extends BaseDialog {
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

    public GraphSettingsDialog(Window window, GraphSettings graphSettings) {
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
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Browsing", this.proximityBrowsingPanel);
        jTabbedPane.addTab("Edges", this.edgesPanel);
        jTabbedPane.addTab("Hierarchical", this.hierarchicalLayoutPanel);
        jTabbedPane.addTab("Orthogonal", this.orthogonalLayoutPanel);
        jTabbedPane.addTab("Circular", this.circularLayoutPanel);
        jTabbedPane.addTab("Controls", this.controlsPanel);
        jTabbedPane.addTab("Misc", this.miscPanel);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        jPanel.add((Component)jTabbedPane, "Center");
        jPanel.add((Component)this.buttons, "South");
        this.add((Component)jPanel, "Center");
    }

    @Override
    public void setVisible(boolean bl2) {
        this.proximityBrowsingPanel.setCurrentValues();
        this.edgesPanel.setCurrentValues();
        this.hierarchicalLayoutPanel.setCurrentValues();
        this.orthogonalLayoutPanel.setCurrentValues();
        this.circularLayoutPanel.setCurrentValues();
        this.controlsPanel.setCurrentValues();
        this.miscPanel.setCurrentValues();
        super.setVisible(bl2);
    }

    static /* synthetic */ void access$100(GraphSettingsDialog graphSettingsDialog) {
        graphSettingsDialog.save();
    }
}

