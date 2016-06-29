package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.menubar.*;
import com.google.security.zynamics.bindiff.graph.backgroundrendering.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.common.base.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import y.h.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.utils.*;

public class ViewTabPanel extends TabPanel
{
    private static final ImageIcon CALLGRAPHS_ICON;
    private static final ImageIcon FLOWGRAPHS_IDENTICAL_MATCHED_ICON;
    private static final ImageIcon FLOWGRAPHS_INSTRUCTION_CHANGED_ONLY_ICON;
    private static final ImageIcon FLOWGRAPHS_STRUTURAL_CHANGED_ICON;
    private static final ImageIcon FLOWGRAPH_PRIMARY_UNMATCHED_ICON;
    private static final ImageIcon FLOWGRAPH_SECONDARY_UNMATCHED_ICON;
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
    
    public ViewTabPanel(final MainWindow mainWindow, final TabPanelManager tabPanelManager, final Workspace workspace, final Diff diff, final ViewData viewData) {
        Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        Preconditions.checkNotNull(workspace);
        Preconditions.checkNotNull(diff);
        Preconditions.checkNotNull(viewData);
        final GraphsContainer graphs = viewData.getGraphs();
        final GraphSettings settings = graphs.getSettings();
        this.controller = new ViewTabPanelFunctions(mainWindow, workspace, this, viewData);
        this.viewMenuBar = new ViewMenuBar(this.controller);
        this.toolbar = new ViewToolbarPanel(this.controller);
        this.normalViewPanel = new CNormalViewPanel(diff, this.controller, viewData);
        this.combinedViewPanel = new CombinedViewPanel(diff, this.controller, viewData);
        this.textViewPanel = new TextViewPanel();
        this.viewData = viewData;
        final ch view = graphs.getPrimaryGraph().getView();
        final ch view2 = graphs.getSecondaryGraph().getView();
        final ch view3 = graphs.getCombinedGraph().getView();
        this.primaryViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, view, EGraph.PRIMARY_GRAPH, settings);
        this.secondaryViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, view2, EGraph.SECONDARY_GRAPH, settings);
        this.combinedViewBackgroundRendererManager = new BackgroundRendererManager(this.viewData, view3, EGraph.COMBINED_GRAPH, settings);
        this.add(this.toolbar, "North");
        this.add(this.controller.getCurrentViewPanel(), "Center");
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
            return ViewTabPanel.CALLGRAPHS_ICON;
        }
        if (this.viewData.isFlowgraphView()) {
            if (((FlowGraphViewData)this.viewData).isMatched()) {
                if (((FlowGraphViewData)this.viewData).isMatchedIdentical()) {
                    return ViewTabPanel.FLOWGRAPHS_IDENTICAL_MATCHED_ICON;
                }
                if (((FlowGraphViewData)this.viewData).isChangedOnlyInstructions()) {
                    return ViewTabPanel.FLOWGRAPHS_INSTRUCTION_CHANGED_ONLY_ICON;
                }
                if (((FlowGraphViewData)this.viewData).isChangedStructural()) {
                    return ViewTabPanel.FLOWGRAPHS_STRUTURAL_CHANGED_ICON;
                }
            }
            else {
                if (((FlowGraphViewData)this.viewData).getRawGraph(ESide.PRIMARY) == null) {
                    return ViewTabPanel.FLOWGRAPH_SECONDARY_UNMATCHED_ICON;
                }
                if (((FlowGraphViewData)this.viewData).getRawGraph(ESide.SECONDARY) == null) {
                    return ViewTabPanel.FLOWGRAPH_PRIMARY_UNMATCHED_ICON;
                }
            }
        }
        return null;
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
    
    static {
        CALLGRAPHS_ICON = ImageUtils.getImageIcon("data/tabicons/callgraphs-tab.png");
        FLOWGRAPHS_IDENTICAL_MATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs-identical-matched-tab.png");
        FLOWGRAPHS_INSTRUCTION_CHANGED_ONLY_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs-changed-instructions-only-tab.png");
        FLOWGRAPHS_STRUTURAL_CHANGED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraphs_structural-changed-tab.png");
        FLOWGRAPH_PRIMARY_UNMATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraph-primary-unmatched-tab.png");
        FLOWGRAPH_SECONDARY_UNMATCHED_ICON = ImageUtils.getImageIcon("data/tabicons/flowgraph-secondary-unmatched-tab.png");
    }
}
