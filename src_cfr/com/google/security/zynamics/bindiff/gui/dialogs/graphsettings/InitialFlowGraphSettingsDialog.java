/*
 * Decompiled with CFR 0_115.
 */
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
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog$1;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.InitialFlowGraphSettingsDialog$InternalButtonListener;
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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class InitialFlowGraphSettingsDialog
extends BaseDialog {
    private static final int DIALOG_WIDTH = 630;
    private static final int DIALOG_HEIGHT = 282;
    private final LayoutingPanel layoutingPanel = new LayoutingPanel("Layouting", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final ProximityBrowsingPanel proximityBrowsingPanel = new ProximityBrowsingPanel("Proximity Browsing", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final EdgesPanel edgesPanel = new EdgesPanel("Edges", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final HierarchicalLayoutPanel hierarchicalLayoutPanel = new HierarchicalLayoutPanel("Hierarchical Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final OrthogonalLayoutPanel orthogonalLayoutPanel = new OrthogonalLayoutPanel("Orthogonal Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final CircularLayoutPanel circularLayoutPanel = new CircularLayoutPanel("Circular Layout", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final ControlsPanel controlsPanel = new ControlsPanel("Controls", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final MiscPanel miscPanel = new MiscPanel("Miscellaneous", ESettingsDialogType.INITIAL_FLOWGRAPH_SETTINGS);
    private final CPanelTwoButtons buttons;

    public InitialFlowGraphSettingsDialog(Window window) {
        super(window, "Initial Flow Graph Settings");
        this.buttons = new CPanelTwoButtons(new InitialFlowGraphSettingsDialog$InternalButtonListener(this, null), "Ok", "Cancel");
        this.init();
        this.pack();
        this.setSize(630, 282);
        this.setMinimumSize(new Dimension(630, 282));
        GuiHelper.centerChildToParent(window, this, true);
    }

    private void save() {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        GraphViewSettingsConfigItem graphViewSettingsConfigItem = binDiffConfigFile.getInitialFlowgraphSettings();
        graphViewSettingsConfigItem.setDefaultGraphLayout(EGraphLayout.getOrdinal(this.layoutingPanel.getDefaultLayout()));
        graphViewSettingsConfigItem.setAutoLayouting(this.layoutingPanel.getAutoLayouting());
        graphViewSettingsConfigItem.setProximityBrowsing(this.proximityBrowsingPanel.getProximityBrowsing());
        graphViewSettingsConfigItem.setAutoProximityBrowsingActivationThreshold(this.proximityBrowsingPanel.getAutoProximityBrowsingActivationThreshold());
        graphViewSettingsConfigItem.setProximityBrowsingChildDepth(this.proximityBrowsingPanel.getProximityBrowsingChildDepth());
        graphViewSettingsConfigItem.setProximityBrowsingParentDepth(this.proximityBrowsingPanel.getProximityBrowsingParentDepth());
        graphViewSettingsConfigItem.setDrawBends(this.edgesPanel.getDrawBends());
        graphViewSettingsConfigItem.setHierarchicalOrthogonalEdgeRouting(this.hierarchicalLayoutPanel.getOrthogonalEdgeRouting());
        graphViewSettingsConfigItem.setHierarchicalOrientation(ELayoutOrientation.getOrdinal(this.hierarchicalLayoutPanel.getLayoutOrientation()));
        graphViewSettingsConfigItem.setHierarchicalMinimumLayerDistance(this.hierarchicalLayoutPanel.getMinimumLayerDistance());
        graphViewSettingsConfigItem.setHierarchicalMinimumNodeDistance(this.hierarchicalLayoutPanel.getMinimumNodeDistance());
        graphViewSettingsConfigItem.setOrthogonalLayoutStyle(EOrthogonalLayoutStyle.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalLayoutStyle()));
        graphViewSettingsConfigItem.setOrthogonalOrientation(ELayoutOrientation.getOrdinal(this.orthogonalLayoutPanel.getOrthogonalOrientation()));
        graphViewSettingsConfigItem.setOrthogonalMinimumNodeDistance(this.orthogonalLayoutPanel.getMinimumNodeDistance());
        graphViewSettingsConfigItem.setCircularLayoutStyle(ECircularLayoutStyle.getOrdinal(this.circularLayoutPanel.getCircularLayoutStyle()));
        graphViewSettingsConfigItem.setCircularMinimumNodeDistance(this.circularLayoutPanel.getMinimumNodeDistance());
        graphViewSettingsConfigItem.setShowScrollbars(this.controlsPanel.getShowScrollbars());
        graphViewSettingsConfigItem.setMouseWheelAction(EMouseAction.getOrdinal(this.controlsPanel.getMouseWheelBehaviour()));
        graphViewSettingsConfigItem.setZoomSensitivity(this.controlsPanel.getZoomSensitivity());
        graphViewSettingsConfigItem.setScrollSensitivity(this.controlsPanel.getScrollSensitivity());
        graphViewSettingsConfigItem.setViewSynchronization(this.miscPanel.getViewSynchronization());
        graphViewSettingsConfigItem.setGradientBackground(this.miscPanel.getGradientBackground());
        graphViewSettingsConfigItem.setLayoutAnimation(this.miscPanel.getLayoutAnimation());
        graphViewSettingsConfigItem.setAnimationSpeed(this.miscPanel.getAnimationSpeed());
        binDiffConfigFile.write();
    }

    private void init() {
        JTabbedPane jTabbedPane = new JTabbedPane();
        jTabbedPane.addTab("Layouting", this.layoutingPanel);
        jTabbedPane.addTab("Browsing", this.proximityBrowsingPanel);
        jTabbedPane.addTab("Edges", this.edgesPanel);
        jTabbedPane.addTab("Hierarchical", this.hierarchicalLayoutPanel);
        jTabbedPane.addTab("Orthogonal", this.orthogonalLayoutPanel);
        jTabbedPane.addTab("Circular", this.circularLayoutPanel);
        jTabbedPane.addTab("Controls", this.controlsPanel);
        jTabbedPane.addTab("Miscellaneous", this.miscPanel);
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
        jPanel.add((Component)jTabbedPane, "Center");
        jPanel.add((Component)this.buttons, "South");
        this.add((Component)jPanel, "Center");
    }

    @Override
    public void setVisible(boolean bl2) {
        this.layoutingPanel.setCurrentValues();
        this.proximityBrowsingPanel.setCurrentValues();
        this.edgesPanel.setCurrentValues();
        this.hierarchicalLayoutPanel.setCurrentValues();
        this.orthogonalLayoutPanel.setCurrentValues();
        this.circularLayoutPanel.setCurrentValues();
        this.controlsPanel.setCurrentValues();
        this.miscPanel.setCurrentValues();
        super.setVisible(bl2);
    }

    static /* synthetic */ void access$100(InitialFlowGraphSettingsDialog initialFlowGraphSettingsDialog) {
        initialFlowGraphSettingsDialog.save();
    }
}

