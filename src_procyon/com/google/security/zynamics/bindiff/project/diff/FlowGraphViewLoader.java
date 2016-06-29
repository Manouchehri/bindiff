package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.project.builders.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.database.*;
import java.io.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.zylib.general.*;
import java.util.*;

public class FlowGraphViewLoader extends CEndlessHelperThread
{
    private final TabPanelManager tabPanelManager;
    private final MainWindow window;
    private final Workspace workspace;
    private final LinkedHashSet viewsAddrs;
    
    public FlowGraphViewLoader(final MainWindow mainWindow, final TabPanelManager tabPanelManager, final Workspace workspace, final LinkedHashSet set) {
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.viewsAddrs = (LinkedHashSet)Preconditions.checkNotNull(set);
    }
    
    private void createFlowgraphView(final FlowGraphViewData flowGraphViewData) {
        final Diff diff = flowGraphViewData.getGraphs().getDiff();
        ViewTabPanel viewTabPanel;
        if (diff.isFunctionDiff()) {
            viewTabPanel = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, diff.getMatches().getFunctionMatches()[0], flowGraphViewData);
        }
        else {
            viewTabPanel = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, flowGraphViewData);
        }
        try {
            ViewTabPanelInitializer.initialize(flowGraphViewData.getGraphs(), this);
        }
        catch (Exception ex) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.addTab(viewTabPanel);
        ViewTabPanelInitializer.centerSingleGraphs(flowGraphViewData.getGraphs().getSuperGraph());
        ViewTabPanelInitializer.centerCombinedGraph(flowGraphViewData.getGraphs(), viewTabPanel);
        this.tabPanelManager.selectTab(viewTabPanel);
    }
    
    private FlowGraphViewData loadFlowgraphViewData(final Diff diff, final IAddress address, final IAddress address2) {
        try (final CommentsDatabase commentsDatabase = new CommentsDatabase(this.workspace, true)) {
            RawFlowGraph loadRawFlowgraph = null;
            RawFlowGraph loadRawFlowgraph2 = null;
            final FunctionMatchData loadFunctionMatchData = this.loadFunctionMatchData(diff, address, address2);
            if (address != null) {
                this.setDescription("Loading primary raw function data...");
                loadRawFlowgraph = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, address, ESide.PRIMARY);
            }
            if (address2 != null) {
                this.setDescription("Loading secondary raw function data...");
                loadRawFlowgraph2 = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, address2, ESide.SECONDARY);
            }
            this.setDescription("Building combined flow graph...");
            final RawCombinedFlowGraph buildRawCombinedFlowgraph = RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(loadFunctionMatchData, loadRawFlowgraph, loadRawFlowgraph2);
            this.setDescription("Creating flow graph view...");
            final GraphsContainer buildViewFlowgraphs = ViewFlowGraphBuilder.buildViewFlowgraphs(diff, loadFunctionMatchData, buildRawCombinedFlowgraph);
            final FlowGraphViewData flowGraphViewData = new FlowGraphViewData(loadRawFlowgraph, loadRawFlowgraph2, buildRawCombinedFlowgraph, buildViewFlowgraphs, ViewData.getViewName(buildViewFlowgraphs), EViewType.FUNCTION_DIFF_VIEW);
            diff.getViewManager().addView(flowGraphViewData);
            return flowGraphViewData;
        }
    }
    
    private FunctionMatchData loadFunctionMatchData(final Diff diff, final IAddress address, final IAddress address2) {
        final FunctionMatchData functionMatch = diff.getMatches().getFunctionMatch(address, ESide.PRIMARY);
        if (functionMatch != null) {
            try {
                String s = diff.getDiffName();
                if (!diff.isFunctionDiff()) {
                    final RawFunction function = diff.getCallgraph(ESide.PRIMARY).getFunction(address);
                    final RawFunction function2 = diff.getCallgraph(ESide.SECONDARY).getFunction(address2);
                    if (function != null) {
                        s = function.getName();
                    }
                    if (function2 != null) {
                        final String value = String.valueOf(s);
                        String name;
                        if (function == null) {
                            name = function2.getName();
                        }
                        else {
                            final String s2 = " vs ";
                            final String value2 = String.valueOf(function2.getName());
                            name = ((value2.length() != 0) ? s2.concat(value2) : new String(s2));
                        }
                        final String value3 = String.valueOf(name);
                        s = ((value3.length() != 0) ? value.concat(value3) : new String(value));
                    }
                }
                try (final MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase())) {
                    this.setGeneralDescription(String.format("Loading '%s'", s));
                    this.setDescription("Please wait...");
                    matchesDatabase.loadBasicblockMatches(functionMatch);
                }
            }
            catch (IOException | SQLException ex3) {
                final SQLException ex2;
                final SQLException ex = ex2;
                final String value4 = String.valueOf("Couldn't read flow graph basic block and instruction matches from database: ");
                final String value5 = String.valueOf(ex.getMessage());
                throw new IOException((value5.length() != 0) ? value4.concat(value5) : new String(value4));
            }
        }
        return functionMatch;
    }
    
    @Override
    protected void runExpensiveCommand() {
        for (final Triple triple : this.viewsAddrs) {
            this.createFlowgraphView(this.loadFlowgraphViewData((Diff)triple.first(), (IAddress)triple.second(), (IAddress)triple.third()));
        }
    }
}
