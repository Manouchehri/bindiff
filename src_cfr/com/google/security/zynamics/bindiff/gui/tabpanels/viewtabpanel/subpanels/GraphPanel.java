/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.settings.IGraphSettingsChangedListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistoryTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphOverviewPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel$InternalSettingsChangedListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.resources.Colors;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import y.h.ch;

public abstract class GraphPanel
extends JPanel {
    public static double COMBINED_MAIN_DIVIDER_WIDTH = 0.15;
    public static double PRIMARY_MAIN_DIVIDER_WIDTH = 0.3;
    public static double SECONDRAY_MAIN_DIVIDER_WIDTH = 0.7;
    public static double OVERVIEW_DIVIDER_HEIGHT = 0.25;
    public static double NODETREE_DIVIDER_WIDTH = 0.75;
    private final EGraph graphType;
    private final JSplitPane mainSplitter = new JSplitPane(1);
    private final JSplitPane overviewSplitter = new JSplitPane(0);
    private final JSplitPane treeSplitter = new JSplitPane(0);
    private final JPanel graphPanel = new JPanel(new BorderLayout());
    private final JPanel overviewPanel = new JPanel(new BorderLayout());
    private final JPanel treePanel = new JPanel(new BorderLayout());
    private final GraphNodeTreePanel graphTreePanel;
    private final SelectionHistoryTreePanel selectionHistoryPanel;
    private final BinDiffGraph graph;
    private final ViewData view;
    private final GraphPanel$InternalSettingsChangedListener settingsListener;

    public GraphPanel(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, BinDiffGraph binDiffGraph, EGraph eGraph) {
        super(new BorderLayout());
        this.settingsListener = new GraphPanel$InternalSettingsChangedListener(this, null);
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(diff);
        this.view = (ViewData)Preconditions.checkNotNull(viewData);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.graphType = eGraph;
        this.graphPanel.add((Component)binDiffGraph.getView(), "Center");
        this.overviewPanel.add(new GraphOverviewPanel(binDiffGraph.getView()));
        this.graphTreePanel = eGraph == EGraph.PRIMARY_GRAPH ? new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (SingleGraph)binDiffGraph) : (eGraph == EGraph.SECONDARY_GRAPH ? new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (SingleGraph)binDiffGraph) : (eGraph == EGraph.COMBINED_GRAPH ? new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (CombinedGraph)binDiffGraph) : null));
        this.treePanel.setBorder(new TitledBorder(""));
        this.treePanel.add((Component)(this.graphTreePanel == null ? new JPanel() : this.graphTreePanel), "Center");
        if (binDiffGraph instanceof SingleGraph) {
            SelectionHistory selectionHistory = ((SingleGraph)binDiffGraph).getSelectionHistory();
            this.selectionHistoryPanel = new SelectionHistoryTreePanel(viewTabPanelFunctions, binDiffGraph, selectionHistory);
            this.selectionHistoryPanel.setBorder(new TitledBorder(""));
        } else if (binDiffGraph instanceof CombinedGraph) {
            SelectionHistory selectionHistory = ((CombinedGraph)binDiffGraph).getSelectionHistory();
            this.selectionHistoryPanel = new SelectionHistoryTreePanel(viewTabPanelFunctions, binDiffGraph, selectionHistory);
            this.selectionHistoryPanel.setBorder(new TitledBorder(""));
        } else {
            this.selectionHistoryPanel = null;
        }
        binDiffGraph.getSettings().addListener(this.settingsListener);
        this.createPanel();
    }

    private void createPanel() {
        if (EGraph.PRIMARY_GRAPH == this.graphType || EGraph.COMBINED_GRAPH == this.graphType) {
            this.mainSplitter.setLeftComponent(this.overviewSplitter);
            this.mainSplitter.setRightComponent(this.graphPanel);
        } else {
            this.mainSplitter.setLeftComponent(this.graphPanel);
            this.mainSplitter.setRightComponent(this.overviewSplitter);
        }
        this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.mainSplitter.setContinuousLayout(true);
        this.setFocusBorder(this.graph.getSettings());
        this.overviewSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.treeSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.overviewSplitter.setTopComponent(this.overviewPanel);
        this.overviewSplitter.setBottomComponent(this.treeSplitter);
        this.treeSplitter.setTopComponent(this.treePanel);
        this.treeSplitter.setBottomComponent(this.selectionHistoryPanel);
        this.overviewSplitter.setMinimumSize(new Dimension(0, 0));
        this.overviewSplitter.setOneTouchExpandable(true);
        this.overviewSplitter.setContinuousLayout(true);
        this.overviewSplitter.setDoubleBuffered(true);
        this.treeSplitter.setMinimumSize(new Dimension(0, 0));
        this.treeSplitter.setOneTouchExpandable(true);
        this.treeSplitter.setContinuousLayout(true);
        this.treeSplitter.setDoubleBuffered(true);
        this.mainSplitter.setMinimumSize(new Dimension(0, 0));
        this.mainSplitter.setOneTouchExpandable(true);
        this.mainSplitter.setDoubleBuffered(true);
        this.resetDefaultPerspective();
        this.add((Component)this.mainSplitter, "Center");
    }

    private void setFocusBorder(GraphSettings graphSettings) {
        if (!graphSettings.isAsync()) {
            this.setBorder(new EmptyBorder(0, 0, 0, 0));
            this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
            return;
        }
        if (graphSettings.getFocus() == ESide.PRIMARY && this.graphType == EGraph.PRIMARY_GRAPH || graphSettings.getFocus() == ESide.SECONDARY && this.graphType == EGraph.SECONDARY_GRAPH) {
            this.setBorder(BorderFactory.createBevelBorder(0));
            this.mainSplitter.setBorder(BorderFactory.createLineBorder(Colors.GRAY64, 3));
            return;
        }
        this.setBorder(BorderFactory.createBevelBorder(0));
        LineBorder lineBorder = new LineBorder(Colors.GRAY64, 1);
        LineBorder lineBorder2 = new LineBorder(Colors.GRAY192, 2);
        this.mainSplitter.setBorder(BorderFactory.createCompoundBorder(lineBorder2, lineBorder));
    }

    protected ViewData getView() {
        return this.view;
    }

    public void dispose() {
        this.graph.getSettings().removeListener(this.settingsListener);
        this.graphTreePanel.dispose();
        this.selectionHistoryPanel.dispose();
    }

    public BinDiffGraph getGraph() {
        return this.graph;
    }

    public Dimension getGraphComponentSize() {
        if (this.graphType == EGraph.COMBINED_GRAPH) return this.mainSplitter.getRightComponent().getSize();
        if (this.graphType != EGraph.PRIMARY_GRAPH) return this.mainSplitter.getLeftComponent().getSize();
        return this.mainSplitter.getRightComponent().getSize();
    }

    public int getMainDividerLoction() {
        return this.mainSplitter.getDividerLocation();
    }

    public JSplitPane getMainSplitter() {
        return this.mainSplitter;
    }

    public AbstractGraphNodeTree getTree() {
        return this.graphTreePanel.getTree();
    }

    public void resetDefaultPerspective() {
        if (this.graphType == EGraph.COMBINED_GRAPH) {
            this.mainSplitter.setResizeWeight(COMBINED_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(COMBINED_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        } else if (this.graphType == EGraph.PRIMARY_GRAPH) {
            this.mainSplitter.setResizeWeight(PRIMARY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(PRIMARY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        } else {
            this.mainSplitter.setResizeWeight(SECONDRAY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(SECONDRAY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        }
        this.treeSplitter.setResizeWeight(NODETREE_DIVIDER_WIDTH);
        this.treeSplitter.setDividerLocation(NODETREE_DIVIDER_WIDTH);
        this.treeSplitter.setLastDividerLocation(this.treeSplitter.getDividerLocation());
        this.overviewSplitter.setResizeWeight(OVERVIEW_DIVIDER_HEIGHT);
        this.overviewSplitter.setDividerLocation(OVERVIEW_DIVIDER_HEIGHT);
        this.overviewSplitter.setLastDividerLocation(this.overviewSplitter.getDividerLocation());
    }

    public void setLastMainDividerPositionAndDefaulResizeWeights(int n2) {
        this.mainSplitter.setDividerLocation(n2);
        if (this.graphType == EGraph.COMBINED_GRAPH) {
            this.mainSplitter.setResizeWeight(COMBINED_MAIN_DIVIDER_WIDTH);
            return;
        }
        if (this.graphType == EGraph.PRIMARY_GRAPH) {
            this.mainSplitter.setResizeWeight(PRIMARY_MAIN_DIVIDER_WIDTH);
            return;
        }
        this.mainSplitter.setResizeWeight(SECONDRAY_MAIN_DIVIDER_WIDTH);
    }

    public void setMainDividerLocationAndResizeWeight(double d2) {
        this.mainSplitter.setResizeWeight(d2);
        this.mainSplitter.setDividerLocation(d2);
    }

    public void toggleGraphsPerspective() {
        if (this.graphType == EGraph.PRIMARY_GRAPH || this.graphType == EGraph.COMBINED_GRAPH) {
            if ((double)this.mainSplitter.getDividerLocation() == 0.0) {
                this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
                return;
            }
            this.mainSplitter.setDividerLocation(0.0);
            return;
        }
        if (this.graphType != EGraph.SECONDARY_GRAPH) return;
        if ((double)this.mainSplitter.getRightComponent().getSize().width == 0.0) {
            this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
            return;
        }
        this.mainSplitter.setDividerLocation(1.0);
    }

    static /* synthetic */ void access$100(GraphPanel graphPanel, GraphSettings graphSettings) {
        graphPanel.setFocusBorder(graphSettings);
    }

    static /* synthetic */ BinDiffGraph access$200(GraphPanel graphPanel) {
        return graphPanel.graph;
    }
}

