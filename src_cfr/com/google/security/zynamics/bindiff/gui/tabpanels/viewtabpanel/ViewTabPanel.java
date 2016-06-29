/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.EGraph;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.BackgroundRendererManager;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.ViewMenuBar;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.NormalGraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CNormalViewPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CombinedViewPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.TextViewPanel;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import y.h.ch;

public class ViewTabPanel
extends TabPanel {
    private static final ImageIcon CALLGRAPHS_ICON = ImageUtils.getImageIcon("data/tabicons/callgraphs-tab.png");
    private static final ImageIcon FLOWGRAPHS_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs-identical-matched-tab.png");
    private static final ImageIcon FLOWGRAPHS_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs-changed-instructions-only-tab.png");
    private static final ImageIcon FLOWGRAPHS_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs_structural-changed-tab.png");
    private static final ImageIcon FLOWGRAPH_PRIMARY_UNMATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraph-primary-unmatched-tab.png");
    private static final ImageIcon FLOWGRAPH_SECONDARY_UNMATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraph-secondary-unmatched-tab.png");
    private final ViewMenuBar viewMenuBar;
    private ViewToolbarPanel toolbar;
    private ViewData viewData;
    private final ViewTabPanelFunctions controller;
    private final BackgroundRendererManager primaryViewBackgroundRendererManager;
    private final BackgroundRendererManager secondaryViewBackgroundRendererManager;
    private final BackgroundRendererManager combinedViewBackgroundRendererManager;
    private final CNormalViewPanel normalViewPanel;
    private final CombinedViewPanel combinedViewPanel;
    private final TextViewPanel textViewPanel;
    private TabPanelManager tabPanelManager;

    public ViewTabPanel(MainWindow mainWindow, TabPanelManager tabPanelManager, Workspace workspace, Diff diff, ViewData viewData) {
        Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        Preconditions.checkNotNull(workspace);
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(viewData);
        GraphsContainer graphsContainer = viewData.getGraphs();
        GraphSettings graphSettings = graphsContainer.getSettings();
        this.controller = new ViewTabPanelFunctions(mainWindow, workspace, this, viewData);
        this.viewMenuBar = new ViewMenuBar(this.controller);
        this.toolbar = new ViewToolbarPanel(this.controller);
        this.normalViewPanel = new CNormalViewPanel(diff, this.controller, viewData);
        this.combinedViewPanel = new CombinedViewPanel(diff, this.controller, viewData);
        this.textViewPanel = new TextViewPanel();
        this.viewData = viewData;
        ch ch2 = graphsContainer.getPrimaryGraph().getView();
        ch ch3 = graphsContainer.getSecondaryGraph().getView();
        ch ch4 = graphsContainer.getCombinedGraph().getView();
        this.primaryViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, ch2, EGraph.PRIMARY_GRAPH, graphSettings);
        this.secondaryViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, ch3, EGraph.SECONDARY_GRAPH, graphSettings);
        this.combinedViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, ch4, EGraph.COMBINED_GRAPH, graphSettings);
        this.add((Component)this.toolbar, "North");
        this.add((Component)this.controller.getCurrentViewPanel(), "Center");
        mainWindow.setJMenuBar(this.viewMenuBar);
        this.updateUI();
    }

    public void dispose() {
        this.primaryViewBackgroundRendererManager.removeListener();
        this.secondaryViewBackgroundRendererManager.removeListener();
        this.combinedViewBackgroundRendererManager.removeListener();
        this.viewMenuBar.dispose();
        this.toolbar.dispose();
        this.normalViewPanel.dispose();
        this.combinedViewPanel.dispose();
        this.tabPanelManager = null;
        this.toolbar = null;
        this.viewData = null;
    }

    public GraphPanel getCombinedGraphPanel() {
        return this.combinedViewPanel.getGraphPanel();
    }

    public CombinedViewPanel getCombinedViewPanel() {
        return this.combinedViewPanel;
    }

    public ViewTabPanelFunctions getController() {
        return this.controller;
    }

    public Diff getDiff() {
        return this.viewData.getGraphs().getDiff();
    }

    @Override
    public Icon getIcon() {
        if (this.viewData.isCallgraphView()) {
            return CALLGRAPHS_ICON;
        }
        if (!this.viewData.isFlowgraphView()) return null;
        if (((FlowGraphViewData)this.viewData).isMatched()) {
            if (((FlowGraphViewData)this.viewData).isMatchedIdentical()) {
                return FLOWGRAPHS_IDENTICAL_MATCHED_ICON;
            }
            if (((FlowGraphViewData)this.viewData).isChangedOnlyInstructions()) {
                return FLOWGRAPHS_INSTRUCTION_CHANGED_ONLY_ICON;
            }
            if (!((FlowGraphViewData)this.viewData).isChangedStructural()) return null;
            return FLOWGRAPHS_STRUTURAL_CHANGED_ICON;
        }
        if (((FlowGraphViewData)this.viewData).getRawGraph(ESide.PRIMARY) == null) {
            return FLOWGRAPH_SECONDARY_UNMATCHED_ICON;
        }
        if (((FlowGraphViewData)this.viewData).getRawGraph(ESide.SECONDARY) != null) return null;
        return FLOWGRAPH_PRIMARY_UNMATCHED_ICON;
    }

    @Override
    public JMenuBar getMenuBar() {
        return this.viewMenuBar;
    }

    public CNormalViewPanel getNormalViewPanel() {
        return this.normalViewPanel;
    }

    public GraphPanel getPrimaryGraphPanel() {
        return this.normalViewPanel.getPrimaryPanel();
    }

    public GraphPanel getSecondaryGraphPanel() {
        return this.normalViewPanel.getSecondaryPanel();
    }

    public TabPanelManager getTabPanelManager() {
        return this.tabPanelManager;
    }

    public TextViewPanel getTextViewPanel() {
        return this.textViewPanel;
    }

    @Override
    public String getTitle() {
        return this.viewData.getViewName();
    }

    public ViewToolbarPanel getToolbar() {
        return this.toolbar;
    }

    public ViewData getView() {
        return this.viewData;
    }
}

