package com.google.security.zynamics.bindiff.project.diff;

import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import com.google.security.zynamics.bindiff.io.matches.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.utils.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.detachedviewstabpanel.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import java.io.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.bindiff.project.builders.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.zylib.disassembly.*;

public class FunctionDiffViewLoader extends CEndlessHelperThread
{
    private final FunctionDiffSocketXmlData data;
    private final MainWindow window;
    private final TabPanelManager tabPanelManager;
    private final Workspace workspace;
    private FlowGraphViewData viewData;
    
    public FunctionDiffViewLoader(final FunctionDiffSocketXmlData functionDiffSocketXmlData, final MainWindow mainWindow, final TabPanelManager tabPanelManager, final Workspace workspace) {
        this.data = (FunctionDiffSocketXmlData)Preconditions.checkNotNull(functionDiffSocketXmlData);
        this.window = (MainWindow)Preconditions.checkNotNull(mainWindow);
        this.tabPanelManager = (TabPanelManager)Preconditions.checkNotNull(tabPanelManager);
        this.workspace = (Workspace)Preconditions.checkNotNull(workspace);
        this.viewData = null;
    }
    
    private void createSingleFunctionDiffFlowgraphView(final Diff diff, final FunctionMatchData functionMatchData, final RawFlowGraph rawFlowGraph, final RawFlowGraph rawFlowGraph2, final RawCombinedFlowGraph rawCombinedFlowGraph) {
        final GraphsContainer buildViewFlowgraphs = ViewFlowGraphBuilder.buildViewFlowgraphs(diff, functionMatchData, rawCombinedFlowGraph);
        final RawFunction function = diff.getFunction(functionMatchData.getIAddress(ESide.PRIMARY), ESide.PRIMARY);
        final RawFunction function2 = diff.getFunction(functionMatchData.getIAddress(ESide.SECONDARY), ESide.SECONDARY);
        String s = CFileUtils.forceFilenameEndsNotWithExtension(diff.getMatchesDatabase().getName(), "BinDiff");
        if (!this.workspace.isLoaded() || (this.workspace.isLoaded() && diff.getMatchesDatabase().getParent().indexOf(this.workspace.getWorkspaceDirPath()) != 0)) {
            s = String.format("%s vs %s", function.getName(), function2.getName());
        }
        this.viewData = new FlowGraphViewData(rawFlowGraph, rawFlowGraph2, rawCombinedFlowGraph, buildViewFlowgraphs, s, EViewType.SINGLE_FUNCTION_DIFF_VIEW);
        diff.getViewManager().addView(this.viewData);
        final FunctionDiffViewTabPanel functionDiffViewTabPanel = new FunctionDiffViewTabPanel(this.window, this.tabPanelManager, this.workspace, diff, functionMatchData, this.viewData);
        try {
            ViewTabPanelInitializer.initialize(this.viewData.getGraphs(), this);
        }
        catch (Exception ex) {
            throw new GraphCreationException("An error occurred while initializing the graph.");
        }
        this.tabPanelManager.addTab(functionDiffViewTabPanel);
        ViewTabPanelInitializer.centerSingleGraphs(this.viewData.getGraphs().getSuperGraph());
        ViewTabPanelInitializer.centerCombinedGraph(this.viewData.getGraphs(), functionDiffViewTabPanel);
        this.tabPanelManager.selectTab(functionDiffViewTabPanel);
    }
    
    @Override
    protected void runExpensiveCommand() {
        final File file = new File(this.data.getMatchesDBPath());
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(file)) {
            final FunctionDiffMetaData loadFunctionDiffMetaData = matchesDatabase.loadFunctionDiffMetaData(true);
            final File file2 = new File(this.data.getFlowgraphsPath(ESide.PRIMARY));
            final File file3 = new File(this.data.getFlowgraphsPath(ESide.SECONDARY));
            Diff diff = this.data.getDiff();
            if (diff == null) {
                diff = new Diff(loadFunctionDiffMetaData, file, file2, file3, true);
            }
            new DiffLoader().loadDiff(diff, this.data);
            if (diff.getCallgraph(ESide.PRIMARY).getNodes().size() != 1) {
                throw new IllegalStateException("Primary callgraph of a single function diff has more than one vertex.");
            }
            if (diff.getCallgraph(ESide.SECONDARY).getNodes().size() != 1) {
                throw new IllegalStateException("Secondary callgraph of a single function diff has more than one vertex.");
            }
            final RawFunction rawFunction = diff.getCallgraph(ESide.PRIMARY).getNodes().get(0);
            final RawFunction rawFunction2 = diff.getCallgraph(ESide.SECONDARY).getNodes().get(0);
            rawFunction.setSizeOfBasicblocks(loadFunctionDiffMetaData.getSizeOfBasicblocks(ESide.PRIMARY));
            rawFunction2.setSizeOfBasicblocks(loadFunctionDiffMetaData.getSizeOfBasicblocks(ESide.SECONDARY));
            rawFunction.setSizeOfJumps(loadFunctionDiffMetaData.getSizeOfJumps(ESide.PRIMARY));
            rawFunction2.setSizeOfJumps(loadFunctionDiffMetaData.getSizeOfJumps(ESide.SECONDARY));
            rawFunction.setSizeOfInstructions(loadFunctionDiffMetaData.getSizeOfInstructions(ESide.PRIMARY));
            rawFunction2.setSizeOfInstructions(loadFunctionDiffMetaData.getSizeOfInstructions(ESide.SECONDARY));
            final IAddress address = rawFunction.getAddress();
            final IAddress address2 = rawFunction2.getAddress();
            loadFunctionDiffMetaData.setFunctionAddr(address, ESide.PRIMARY);
            loadFunctionDiffMetaData.setFunctionAddr(address2, ESide.SECONDARY);
            loadFunctionDiffMetaData.setFunctionName(rawFunction.getName(), ESide.PRIMARY);
            loadFunctionDiffMetaData.setFunctionName(rawFunction2.getName(), ESide.SECONDARY);
            loadFunctionDiffMetaData.setFunctionType(rawFunction.getFunctionType(), ESide.PRIMARY);
            loadFunctionDiffMetaData.setFunctionType(rawFunction2.getFunctionType(), ESide.SECONDARY);
            loadFunctionDiffMetaData.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.PRIMARY), ESide.PRIMARY);
            loadFunctionDiffMetaData.setFlowgraphOffset(this.data.getFlowgraphOffset(ESide.SECONDARY), ESide.SECONDARY);
            final FunctionMatchData functionMatch = diff.getMatches().getFunctionMatch(address, ESide.PRIMARY);
            matchesDatabase.loadBasicblockMatches(functionMatch);
            CommentsDatabase commentsDatabase = null;
            if (this.workspace.isLoaded()) {
                commentsDatabase = new CommentsDatabase(this.workspace, true);
            }
            final RawFlowGraph loadRawFlowgraph = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, address, ESide.PRIMARY);
            final RawFlowGraph loadRawFlowgraph2 = DiffLoader.loadRawFlowgraph(commentsDatabase, diff, address2, ESide.SECONDARY);
            this.createSingleFunctionDiffFlowgraphView(diff, functionMatch, loadRawFlowgraph, loadRawFlowgraph2, RawCombinedFlowGraphBuilder.buildRawCombinedFlowgraph(functionMatch, loadRawFlowgraph, loadRawFlowgraph2));
        }
    }
}
