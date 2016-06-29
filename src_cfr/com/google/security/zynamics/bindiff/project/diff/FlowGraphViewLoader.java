/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedFlowGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.Triple;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class FlowGraphViewLoader
extends CEndlessHelperThread {
    private final TabPanelManager tabPanelManager;
    private final MainWindow window;
    private final Workspace workspace;
    private final LinkedHashSet viewsAddrs;

    public FlowGraphViewLoader(MainWindow mainWindow, TabPanelManager tabPanelManager, Workspace workspace, LinkedHashSet linkedHashSet) {
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.viewsAddrs = (LinkedHashSet)Preconditions.checkNotNull(linkedHashSet);
    }

    private void createFlowgraphView(FlowGraphViewData flowGraphViewData) {
        ViewTabPanel viewTabPanel;
        Diff diff = flowGraphViewData.getGraphs().getDiff();
        if (diff.isFunctionDiff()) {
            FunctionMatchData functionMatchData = diff.getMatches().getFunctionMatches()[0];
            viewTabPanel = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, functionMatchData, flowGraphViewData);
        } else {
            viewTabPanel = new ViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, flowGraphViewData);
        }
        try {
            ViewTabPanelInitializer.initialize(flowGraphViewData.getGraphs(), this);
        }
        catch (Exception var4_4) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.addTab(viewTabPanel);
        ViewTabPanelInitializer.centerSingleGraphs(flowGraphViewData.getGraphs().getSuperGraph());
        ViewTabPanelInitializer.centerCombinedGraph(flowGraphViewData.getGraphs(), viewTabPanel);
        this.tabPanelManager.selectTab(viewTabPanel);
    }

    private FlowGraphViewData loadFlowgraphViewData(Diff diff, IAddress iAddress, IAddress iAddress2) {
        CommentsDatabase commentsDatabase = new CommentsDatabase(this.workspace, true);
        Throwable throwable = null;
        try {
            RawFlowGraph rawFlowGraph = null;
            RawFlowGraph rawFlowGraph2 = null;
            FunctionMatchData functionMatchData = this.loadFunctionMatchData(diff, iAddress, iAddress2);
            if (iAddress != null) {
                this.setDescription("Loading primary raw function data...");
                rawFlowGraph = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, iAddress, ESide.PRIMARY);
            }
            if (iAddress2 != null) {
                this.setDescription("Loading secondary raw function data...");
                rawFlowGraph2 = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, iAddress2, ESide.SECONDARY);
            }
            this.setDescription("Building combined flow graph...");
            RawCombinedFlowGraph rawCombinedFlowGraph = RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(functionMatchData, rawFlowGraph, rawFlowGraph2);
            this.setDescription("Creating flow graph view...");
            GraphsContainer graphsContainer = ViewFlowGraphBuilder.buildViewFlowgraphs(diff, functionMatchData, rawCombinedFlowGraph);
            FlowGraphViewData flowGraphViewData = new FlowGraphViewData(rawFlowGraph, rawFlowGraph2, rawCombinedFlowGraph, graphsContainer, FlowGraphViewData.getViewName(graphsContainer), EViewType.FUNCTION_DIFF_VIEW);
            diff.getViewManager().addView(flowGraphViewData);
            FlowGraphViewData flowGraphViewData2 = flowGraphViewData;
            return flowGraphViewData2;
        }
        catch (Throwable var6_7) {
            throwable = var6_7;
            throw var6_7;
        }
        finally {
            if (commentsDatabase != null) {
                if (throwable != null) {
                    try {
                        commentsDatabase.close();
                    }
                    catch (Throwable var13_14) {
                        throwable.addSuppressed(var13_14);
                    }
                } else {
                    commentsDatabase.close();
                }
            }
        }
    }

    private FunctionMatchData loadFunctionMatchData(Diff diff, IAddress iAddress, IAddress iAddress2) {
        FunctionMatchData functionMatchData = diff.getMatches().getFunctionMatch(iAddress, ESide.PRIMARY);
        if (functionMatchData == null) return functionMatchData;
        try {
            Object object;
            Object object2;
            String string = diff.getDiffName();
            if (!diff.isFunctionDiff()) {
                object = diff.getCallgraph(ESide.PRIMARY).getFunction(iAddress);
                object2 = diff.getCallgraph(ESide.SECONDARY).getFunction(iAddress2);
                if (object != null) {
                    string = object.getName();
                }
                if (object2 != null) {
                    String string2;
                    String string3 = String.valueOf(string);
                    if (object == null) {
                        string2 = object2.getName();
                    } else {
                        String string4 = String.valueOf(object2.getName());
                        string2 = string4.length() != 0 ? " vs ".concat(string4) : new String(" vs ");
                    }
                    String string5 = String.valueOf(string2);
                    string = string5.length() != 0 ? string3.concat(string5) : new String(string3);
                }
            }
            object = new MatchesDatabase(diff.getMatchesDatabase());
            object2 = null;
            try {
                this.setGeneralDescription(String.format("Loading '%s'", string));
                this.setDescription("Please wait...");
                object.loadBasicblockMatches(functionMatchData);
                return functionMatchData;
            }
            catch (Throwable var8_10) {
                object2 = var8_10;
                throw var8_10;
            }
            finally {
                if (object != null) {
                    if (object2 != null) {
                        try {
                            object.close();
                        }
                        catch (Throwable var8_9) {
                            object2.addSuppressed(var8_9);
                        }
                    } else {
                        object.close();
                    }
                }
            }
        }
        catch (IOException | SQLException var5_6) {
            String string;
            String string6 = String.valueOf("Couldn't read flow graph basic block and instruction matches from database: ");
            String string7 = String.valueOf(var5_6.getMessage());
            if (string7.length() != 0) {
                string = string6.concat(string7);
                throw new IOException(string);
            }
            string = new String(string6);
            throw new IOException(string);
        }
    }

    @Override
    protected void runExpensiveCommand() {
        Iterator iterator = this.viewsAddrs.iterator();
        while (iterator.hasNext()) {
            Triple triple = (Triple)iterator.next();
            FlowGraphViewData flowGraphViewData = this.loadFlowgraphViewData((Diff)triple.first(), (IAddress)triple.second(), (IAddress)triple.third());
            this.createFlowgraphView(flowGraphViewData);
        }
    }
}

