/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.project.diff;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.CommentsDatabase;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EFunctionType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.EViewType;
import com.google.security.zynamics.bindiff.exceptions.GraphCreationException;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.FunctionDiffViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelInitializer;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.matches.FunctionDiffSocketXmlData;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.builders.RawCombinedFlowGraphBuilder;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.DiffLoader;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionDiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.bindiff.utils.CFileUtils;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.CEndlessHelperThread;
import java.io.File;
import java.util.List;

public class FunctionDiffViewLoader
extends CEndlessHelperThread {
    private final FunctionDiffSocketXmlData data;
    private final MainWindow window;
    private final TabPanelManager tabPanelManager;
    private final Workspace workspace;
    private FlowGraphViewData viewData;

    public FunctionDiffViewLoader(FunctionDiffSocketXmlData functionDiffSocketXmlData, MainWindow mainWindow, TabPanelManager tabPanelManager, Workspace workspace) {
        this.data = (FunctionDiffSocketXmlData)Preconditions.checkNotNull(functionDiffSocketXmlData);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.viewData = null;
    }

    private void createSingleFunctionDiffFlowgraphView(Diff diff, FunctionMatchData functionMatchData, RawFlowGraph rawFlowGraph, RawFlowGraph rawFlowGraph2, RawCombinedFlowGraph rawCombinedFlowGraph) {
        GraphsContainer graphsContainer = ViewFlowGraphBuilder.buildViewFlowgraphs(diff, functionMatchData, rawCombinedFlowGraph);
        RawFunction rawFunction = diff.getFunction(functionMatchData.getIAddress(ESide.PRIMARY), ESide.PRIMARY);
        RawFunction rawFunction2 = diff.getFunction(functionMatchData.getIAddress(ESide.SECONDARY), ESide.SECONDARY);
        String string = diff.getMatchesDatabase().getName();
        string = CFileUtils.forceFilenameEndsNotWithExtension(string, "BinDiff");
        if (!this.workspace.isLoaded() || this.workspace.isLoaded() && diff.getMatchesDatabase().getParent().indexOf(this.workspace.getWorkspaceDirPath()) != 0) {
            string = String.format("%s vs %s", rawFunction.getName(), rawFunction2.getName());
        }
        this.viewData = new FlowGraphViewData(rawFlowGraph, rawFlowGraph2, rawCombinedFlowGraph, graphsContainer, string, EViewType.SINGLE_FUNCTION_DIFF_VIEW);
        diff.getViewManager().addView(this.viewData);
        FunctionDiffViewTabPanel functionDiffViewTabPanel = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, functionMatchData, this.viewData);
        try {
            ViewTabPanelInitializer.initialize(this.viewData.getGraphs(), this);
        }
        catch (Exception var11_11) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.addTab(functionDiffViewTabPanel);
        ViewTabPanelInitializer.centerSingleGraphs(this.viewData.getGraphs().getSuperGraph());
        ViewTabPanelInitializer.centerCombinedGraph(this.viewData.getGraphs(), functionDiffViewTabPanel);
        this.tabPanelManager.selectTab(functionDiffViewTabPanel);
    }

    @Override
    protected void runExpensiveCommand() {
        File file = new File(this.data.getMatchesDBPath());
        MatchesDatabase matchesDatabase = new MatchesDatabase(file);
        Throwable throwable = null;
        try {
            FunctionDiffMetaData functionDiffMetaData = matchesDatabase.loadFunctionDiffMetaData(true);
            File file2 = new File(this.data.getFlowgraphsPath(ESide.PRIMARY));
            File file3 = new File(this.data.getFlowgraphsPath(ESide.SECONDARY));
            Diff diff = this.data.getDiff();
            if (diff == null) {
                diff = new Diff(functionDiffMetaData, file, file2, file3, true);
            }
            DiffLoader diffLoader = new DiffLoader();
            diffLoader.loadDiff(diff, this.data);
            if (diff.getCallgraph(ESide.PRIMARY).getNodes().size() != 1) {
                throw new IllegalStateException("Primary callgraph of a single function diff has more than one vertex.");
            }
            if (diff.getCallgraph(ESide.SECONDARY).getNodes().size() != 1) {
                throw new IllegalStateException("Secondary callgraph of a single function diff has more than one vertex.");
            }
            RawFunction rawFunction = (RawFunction)diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
            RawFunction rawFunction2 = (RawFunction)diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
            rawFunction.setSizeOfBasicblocks(functionDiffMetaData.getSizeOfBasicblocks(ESide.PRIMARY));
            rawFunction2.setSizeOfBasicblocks(functionDiffMetaData.getSizeOfBasicblocks(ESide.SECONDARY));
            rawFunction.setSizeOfJumps(functionDiffMetaData.getSizeOfJumps(ESide.PRIMARY));
            rawFunction2.setSizeOfJumps(functionDiffMetaData.getSizeOfJumps(ESide.SECONDARY));
            rawFunction.setSizeOfInstructions(functionDiffMetaData.getSizeOfInstructions(ESide.PRIMARY));
            rawFunction2.setSizeOfInstructions(functionDiffMetaData.getSizeOfInstructions(ESide.SECONDARY));
            IAddress iAddress = rawFunction.getAddress();
            IAddress iAddress2 = rawFunction2.getAddress();
            functionDiffMetaData.setFunctionAddr(iAddress, ESide.PRIMARY);
            functionDiffMetaData.setFunctionAddr(iAddress2, ESide.SECONDARY);
            functionDiffMetaData.setFunctionName(rawFunction.getName(), ESide.PRIMARY);
            functionDiffMetaData.setFunctionName(rawFunction2.getName(), ESide.SECONDARY);
            functionDiffMetaData.setFunctionType(rawFunction.getFunctionType(), ESide.PRIMARY);
            functionDiffMetaData.setFunctionType(rawFunction2.getFunctionType(), ESide.SECONDARY);
            functionDiffMetaData.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
            functionDiffMetaData.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
            FunctionMatchData functionMatchData = diff.getMatches().getFunctionMatch(iAddress, ESide.PRIMARY);
            matchesDatabase.loadBasicblockMatches(functionMatchData);
            CommentsDatabase commentsDatabase = null;
            if (this.workspace.isLoaded()) {
                commentsDatabase = new CommentsDatabase(this.workspace, true);
            }
            RawFlowGraph rawFlowGraph = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, iAddress, ESide.PRIMARY);
            RawFlowGraph rawFlowGraph2 = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, iAddress2, ESide.SECONDARY);
            RawCombinedFlowGraph rawCombinedFlowGraph = RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(functionMatchData, rawFlowGraph, rawFlowGraph2);
            this.createSingleFunctionDiffFlowgraphView(diff, functionMatchData, rawFlowGraph, rawFlowGraph2, rawCombinedFlowGraph);
            return;
        }
        catch (Throwable var4_6) {
            throwable = var4_6;
            throw var4_6;
        }
        finally {
            if (matchesDatabase != null) {
                if (throwable != null) {
                    try {
                        matchesDatabase.close();
                    }
                    catch (Throwable var4_5) {
                        throwable.addSuppressed(var4_5);
                    }
                } else {
                    matchesDatabase.close();
                }
            }
        }
    }
}

