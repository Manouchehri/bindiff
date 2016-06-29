package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.graph.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.enums.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.resources.*;
import javax.swing.border.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;

public abstract class GraphPanel extends JPanel
{
    public static double COMBINED_MAIN_DIVIDER_WIDTH;
    public static double PRIMARY_MAIN_DIVIDER_WIDTH;
    public static double SECONDRAY_MAIN_DIVIDER_WIDTH;
    public static double OVERVIEW_DIVIDER_HEIGHT;
    public static double NODETREE_DIVIDER_WIDTH;
    private final EGraph graphType;
    private final JSplitPane mainSplitter;
    private final JSplitPane overviewSplitter;
    private final JSplitPane treeSplitter;
    private final JPanel graphPanel;
    private final JPanel overviewPanel;
    private final JPanel treePanel;
    private final GraphNodeTreePanel graphTreePanel;
    private final SelectionHistoryTreePanel selectionHistoryPanel;
    private final BinDiffGraph graph;
    private final ViewData view;
    private final GraphPanel$InternalSettingsChangedListener settingsListener;
    
    public GraphPanel(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final BinDiffGraph binDiffGraph, final EGraph graphType) {
        super(new BorderLayout());
        this.mainSplitter = new JSplitPane(1);
        this.overviewSplitter = new JSplitPane(0);
        this.treeSplitter = new JSplitPane(0);
        this.graphPanel = new JPanel(new BorderLayout());
        this.overviewPanel = new JPanel(new BorderLayout());
        this.treePanel = new JPanel(new BorderLayout());
        this.settingsListener = new GraphPanel$InternalSettingsChangedListener(this, null);
        Preconditions.checkNotNull(viewTabPanelFunctions);
        Preconditions.checkNotNull(diff);
        this.view = (ViewData)Preconditions.checkNotNull(viewData);
        this.graph = (BinDiffGraph)Preconditions.checkNotNull(binDiffGraph);
        this.graphType = graphType;
        this.graphPanel.add(binDiffGraph.getView(), "Center");
        this.overviewPanel.add(new GraphOverviewPanel(binDiffGraph.getView()));
        if (graphType == EGraph.PRIMARY_GRAPH) {
            this.graphTreePanel = new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (SingleGraph)binDiffGraph);
        }
        else if (graphType == EGraph.SECONDARY_GRAPH) {
            this.graphTreePanel = new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (SingleGraph)binDiffGraph);
        }
        else if (graphType == EGraph.COMBINED_GRAPH) {
            this.graphTreePanel = new GraphNodeTreePanel(viewTabPanelFunctions, diff, viewData, (CombinedGraph)binDiffGraph);
        }
        else {
            this.graphTreePanel = null;
        }
        this.treePanel.setBorder(new TitledBorder(""));
        this.treePanel.add((this.graphTreePanel == null) ? new JPanel() : this.graphTreePanel, "Center");
        if (binDiffGraph instanceof SingleGraph) {
            (this.selectionHistoryPanel = new SelectionHistoryTreePanel(viewTabPanelFunctions, binDiffGraph, ((SingleGraph)binDiffGraph).getSelectionHistory())).setBorder(new TitledBorder(""));
        }
        else if (binDiffGraph instanceof CombinedGraph) {
            (this.selectionHistoryPanel = new SelectionHistoryTreePanel(viewTabPanelFunctions, binDiffGraph, ((CombinedGraph)binDiffGraph).getSelectionHistory())).setBorder(new TitledBorder(""));
        }
        else {
            this.selectionHistoryPanel = null;
        }
        binDiffGraph.getSettings().addListener(this.settingsListener);
        this.createPanel();
    }
    
    private void createPanel() {
        if (EGraph.PRIMARY_GRAPH == this.graphType || EGraph.COMBINED_GRAPH == this.graphType) {
            this.mainSplitter.setLeftComponent(this.overviewSplitter);
            this.mainSplitter.setRightComponent(this.graphPanel);
        }
        else {
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
        this.add(this.mainSplitter, "Center");
    }
    
    private void setFocusBorder(final GraphSettings graphSettings) {
        if (graphSettings.isAsync()) {
            if ((graphSettings.getFocus() == ESide.PRIMARY && this.graphType == EGraph.PRIMARY_GRAPH) || (graphSettings.getFocus() == ESide.SECONDARY && this.graphType == EGraph.SECONDARY_GRAPH)) {
                this.setBorder(BorderFactory.createBevelBorder(0));
                this.mainSplitter.setBorder(BorderFactory.createLineBorder(Colors.GRAY64, 3));
            }
            else {
                this.setBorder(BorderFactory.createBevelBorder(0));
                this.mainSplitter.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Colors.GRAY192, 2), new LineBorder(Colors.GRAY64, 1)));
            }
        }
        else {
            this.setBorder(new EmptyBorder(0, 0, 0, 0));
            this.mainSplitter.setBorder(new EmptyBorder(0, 0, 0, 0));
        }
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
        if (this.graphType == EGraph.COMBINED_GRAPH || this.graphType == EGraph.PRIMARY_GRAPH) {
            return this.mainSplitter.getRightComponent().getSize();
        }
        return this.mainSplitter.getLeftComponent().getSize();
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
            this.mainSplitter.setResizeWeight(GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        }
        else if (this.graphType == EGraph.PRIMARY_GRAPH) {
            this.mainSplitter.setResizeWeight(GraphPanel.PRIMARY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(GraphPanel.PRIMARY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        }
        else {
            this.mainSplitter.setResizeWeight(GraphPanel.SECONDRAY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setDividerLocation(GraphPanel.SECONDRAY_MAIN_DIVIDER_WIDTH);
            this.mainSplitter.setLastDividerLocation(this.mainSplitter.getDividerLocation());
        }
        this.treeSplitter.setResizeWeight(GraphPanel.NODETREE_DIVIDER_WIDTH);
        this.treeSplitter.setDividerLocation(GraphPanel.NODETREE_DIVIDER_WIDTH);
        this.treeSplitter.setLastDividerLocation(this.treeSplitter.getDividerLocation());
        this.overviewSplitter.setResizeWeight(GraphPanel.OVERVIEW_DIVIDER_HEIGHT);
        this.overviewSplitter.setDividerLocation(GraphPanel.OVERVIEW_DIVIDER_HEIGHT);
        this.overviewSplitter.setLastDividerLocation(this.overviewSplitter.getDividerLocation());
    }
    
    public void setLastMainDividerPositionAndDefaulResizeWeights(final int dividerLocation) {
        this.mainSplitter.setDividerLocation(dividerLocation);
        if (this.graphType == EGraph.COMBINED_GRAPH) {
            this.mainSplitter.setResizeWeight(GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH);
        }
        else if (this.graphType == EGraph.PRIMARY_GRAPH) {
            this.mainSplitter.setResizeWeight(GraphPanel.PRIMARY_MAIN_DIVIDER_WIDTH);
        }
        else {
            this.mainSplitter.setResizeWeight(GraphPanel.SECONDRAY_MAIN_DIVIDER_WIDTH);
        }
    }
    
    public void setMainDividerLocationAndResizeWeight(final double n) {
        this.mainSplitter.setResizeWeight(n);
        this.mainSplitter.setDividerLocation(n);
    }
    
    public void toggleGraphsPerspective() {
        if (this.graphType == EGraph.PRIMARY_GRAPH || this.graphType == EGraph.COMBINED_GRAPH) {
            if (this.mainSplitter.getDividerLocation() == 0.0) {
                this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
            }
            else {
                this.mainSplitter.setDividerLocation(0.0);
            }
        }
        else if (this.graphType == EGraph.SECONDARY_GRAPH) {
            if (this.mainSplitter.getRightComponent().getSize().width == 0.0) {
                this.mainSplitter.setDividerLocation(this.mainSplitter.getLastDividerLocation());
            }
            else {
                this.mainSplitter.setDividerLocation(1.0);
            }
        }
    }
    
    static {
        GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH = 0.15;
        GraphPanel.PRIMARY_MAIN_DIVIDER_WIDTH = 0.3;
        GraphPanel.SECONDRAY_MAIN_DIVIDER_WIDTH = 0.7;
        GraphPanel.OVERVIEW_DIVIDER_HEIGHT = 0.25;
        GraphPanel.NODETREE_DIVIDER_WIDTH = 0.75;
    }
}
