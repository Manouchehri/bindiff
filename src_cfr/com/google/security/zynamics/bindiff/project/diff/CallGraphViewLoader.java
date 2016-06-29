/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedCallGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedCallGraph;
import com.google.security.zynamics.bindiff.project.userview.CallGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;

public class CallGraphViewLoader
extends CEndlessHelperThread {
    private Diff diff;
    private MainWindow window;
    private TabPanelManager tabPanelManager;
    private Workspace workspace;

    public CallGraphViewLoader(Diff diff, MainWindow mainWindow, TabPanelManager tabPanelManager, Workspace workspace) {
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
    }

    private void createCallgraphView(CallGraphViewData callGraphViewData) {
        Preconditions.checkNotNull(this.tabPanelManager);
        Preconditions.checkNotNull(this.workspace);
        ViewTabPanel viewTabPanel = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, this.diff, callGraphViewData);
        this.tabPanelManager.addTab(viewTabPanel);
        this.setDescription("Creating view...");
        try {
            ViewTabPanelInitializer.initialize(callGraphViewData.getGraphs(), this);
        }
        catch (Exception var3_3) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.selectTab(viewTabPanel);
    }

    private CallGraphViewData loadCallgraphViewData() {
        RawCallGraph rawCallGraph = this.diff.getCallgraph(ESide.PRIMARY);
        RawCallGraph rawCallGraph2 = this.diff.getCallgraph(ESide.SECONDARY);
        this.setDescription("Building raw callgraph...");
        RawCombinedCallGraph rawCombinedCallGraph = RawCombinedCallGraphBuilder.buildCombinedCallgraph(this.diff.getMatches(), rawCallGraph, rawCallGraph2);
        this.setDescription("Building view callgraph...");
        GraphsContainer graphsContainer = ViewCallGraphBuilder.buildDiffCallgraphs(this.diff, rawCombinedCallGraph);
        CallGraphViewData callGraphViewData = new CallGraphViewData(rawCallGraph, rawCallGraph2, graphsContainer, FlowGraphViewData.getViewName(graphsContainer), this.diff.getMetaData().getImageName(ESide.PRIMARY), this.diff.getMetaData().getImageName(ESide.SECONDARY), EViewType.FUNCTION_DIFF_VIEW);
        this.diff.getViewManager().addView(callGraphViewData);
        return callGraphViewData;
    }

    @Override
    protected void runExpensiveCommand() {
        CallGraphViewData callGraphViewData = this.loadCallgraphViewData();
        this.createCallgraphView(callGraphViewData);
        this.diff = null;
        this.tabPanelManager = null;
        this.workspace = null;
    }
}

