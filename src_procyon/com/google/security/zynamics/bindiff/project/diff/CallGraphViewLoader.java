package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.project.builders.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.graph.*;

public class CallGraphViewLoader extends CEndlessHelperThread
{
    private Diff diff;
    private MainWindow window;
    private TabPanelManager tabPanelManager;
    private Workspace workspace;
    
    public CallGraphViewLoader(final Diff diff, final MainWindow mainWindow, final TabPanelManager tabPanelManager, final Workspace workspace) {
        this.diff = (Diff)Preconditions.checkNotNull(diff);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
    }
    
    private void createCallgraphView(final CallGraphViewData callGraphViewData) {
        Preconditions.checkNotNull(this.tabPanelManager);
        Preconditions.checkNotNull(this.workspace);
        final ViewTabPanel viewTabPanel = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, this.diff, callGraphViewData);
        this.tabPanelManager.addTab(viewTabPanel);
        this.setDescription("Creating view...");
        try {
            ViewTabPanelInitializer.initialize(callGraphViewData.getGraphs(), this);
        }
        catch (Exception ex) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.selectTab(viewTabPanel);
    }
    
    private CallGraphViewData loadCallgraphViewData() {
        final RawCallGraph callgraph = this.diff.getCallgraph(ESide.PRIMARY);
        final RawCallGraph callgraph2 = this.diff.getCallgraph(ESide.SECONDARY);
        this.setDescription("Building raw callgraph...");
        final RawCombinedCallGraph buildCombinedCallgraph = RawCombinedCallGraphBuilder.buildCombinedCallgraph(this.diff.getMatches(), callgraph, callgraph2);
        this.setDescription("Building view callgraph...");
        final GraphsContainer buildDiffCallgraphs = ViewCallGraphBuilder.buildDiffCallgraphs(this.diff, buildCombinedCallgraph);
        final CallGraphViewData callGraphViewData = new CallGraphViewData(callgraph, callgraph2, buildDiffCallgraphs, ViewData.getViewName(buildDiffCallgraphs), this.diff.getMetaData().getImageName(ESide.PRIMARY), this.diff.getMetaData().getImageName(ESide.SECONDARY), EViewType.FUNCTION_DIFF_VIEW);
        this.diff.getViewManager().addView(callGraphViewData);
        return callGraphViewData;
    }
    
    @Override
    protected void runExpensiveCommand() {
        this.createCallgraphView(this.loadCallgraphViewData());
        this.diff = null;
        this.tabPanelManager = null;
        this.workspace = null;
    }
}
