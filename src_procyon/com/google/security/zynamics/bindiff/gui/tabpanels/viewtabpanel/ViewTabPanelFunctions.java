package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.graph.listeners.*;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.*;
import com.google.security.zynamics.bindiff.gui.window.*;
import com.google.security.zynamics.bindiff.project.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import com.google.security.zynamics.bindiff.log.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.exceptions.*;
import com.google.security.zynamics.zylib.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.eventhandlers.*;
import java.io.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.*;
import com.google.security.zynamics.bindiff.project.rawcallgraph.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.gui.ProgressDialogs.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.graph.builders.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.settings.*;
import com.google.security.zynamics.bindiff.io.comments.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.project.matches.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.database.*;

public class ViewTabPanelFunctions extends TabPanelFunctions
{
    private final ListenerProvider listenerProvider;
    private final ViewTabPanelFunctions$InternalEditableContentListener labelEditModeListener;
    private final GraphsContainer graphs;
    private final GraphSettings settings;
    private final GraphViewsListenerManager graphListenerManager;
    private ViewTabPanel viewTabPanel;
    private Color currentColor;
    private CriteriaDialog selectByCriteriaDlg;
    private GraphSettingsDialog settingsDialog;
    private boolean hasChangedMatches;
    private boolean hasChangedComments;
    
    public ViewTabPanelFunctions(final MainWindow mainWindow, final Workspace workspace, final ViewTabPanel viewTabPanel, final ViewData viewData) {
        super(mainWindow, workspace);
        this.listenerProvider = new ListenerProvider();
        this.labelEditModeListener = new ViewTabPanelFunctions$InternalEditableContentListener(this, null);
        this.currentColor = null;
        this.selectByCriteriaDlg = null;
        this.settingsDialog = null;
        this.hasChangedMatches = false;
        this.hasChangedComments = false;
        this.viewTabPanel = (ViewTabPanel)Preconditions.checkNotNull(viewTabPanel);
        Preconditions.checkNotNull(viewData);
        this.graphs = viewData.getGraphs();
        this.settings = this.graphs.getSettings();
        this.graphListenerManager = new GraphViewsListenerManager(this.graphs, this);
        this.graphs.getCombinedGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
        this.graphs.getPrimaryGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
        this.graphs.getSecondaryGraph().getEditMode().getLabelEventHandler().addEditModeListener(this.labelEditModeListener);
    }
    
    public static boolean isNodeSelectionMatchAddable(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        return BasicBlockMatchAdder.getAffectedCombinedNodes(binDiffGraph, zyGraphNode) != null;
    }
    
    public static boolean isNodeSelectionMatchDeleteable(final BinDiffGraph binDiffGraph, final ZyGraphNode zyGraphNode) {
        return BasicBlockMatchRemover.getAffectedCombinedNodes(binDiffGraph, zyGraphNode) != null;
    }
    
    private void notifySaveableListener() {
        final Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            iterator.next().isSavable(this.hasChanged());
        }
    }
    
    private void setCommentsChanged(final boolean hasChangedComments) {
        this.hasChangedComments = hasChangedComments;
        this.notifySaveableListener();
    }
    
    private void setMatchesChanged(final boolean hasChangedMatches) {
        this.hasChangedMatches = hasChangedMatches;
        this.notifySaveableListener();
    }
    
    private boolean showColorChooserDialog() {
        final List recentColors = GraphColorizer.getRecentColors();
        this.currentColor = CColorChooser.showDialog(this.viewTabPanel, "Color Nodes", Color.WHITE, recentColors.toArray(new Color[0]));
        if (this.currentColor != null) {
            recentColors.add(this.currentColor);
            GraphColorizer.setRecentColors(recentColors);
            return true;
        }
        return false;
    }
    
    private void updateFunctionMatchCounts() {
        final ViewData view = this.viewTabPanel.getView();
        if (view.isFlowgraphView() || view.isSingleFunctionDiffView()) {
            final FunctionMatchData functionMatch = view.getGraphs().getDiff().getMatches().getFunctionMatch(view.getAddress(ESide.PRIMARY), ESide.PRIMARY);
            final RawFlowGraph rawFlowGraph = (RawFlowGraph)view.getRawGraph(ESide.PRIMARY);
            int sizeOfMatchedBasicblocks = 0;
            int sizeOfMatchedJumps = 0;
            int sizeOfMatchedInstructions = 0;
            for (final RawBasicBlock rawBasicBlock : rawFlowGraph.getNodes()) {
                if (rawBasicBlock.getMatchState() == EMatchState.MATCHED) {
                    ++sizeOfMatchedBasicblocks;
                    for (final RawJump rawJump : rawBasicBlock.getOutgoingEdges()) {
                        if (rawJump.getSource().getMatchState() == EMatchState.MATCHED && rawJump.getTarget().getMatchState() == EMatchState.MATCHED) {
                            ++sizeOfMatchedJumps;
                        }
                    }
                    sizeOfMatchedInstructions += functionMatch.getBasicblockMatch(rawBasicBlock.getAddress(), ESide.PRIMARY).getSizeOfMatchedInstructions();
                }
            }
            functionMatch.setSizeOfMatchedBasicblocks(sizeOfMatchedBasicblocks);
            functionMatch.setSizeOfMatchedJumps(sizeOfMatchedJumps);
            functionMatch.setSizeOfMatchedInstructions(sizeOfMatchedInstructions);
        }
    }
    
    public void addListener(final ISavableListener savableListener) {
        this.listenerProvider.addListener(savableListener);
    }
    
    public void addNodeMatch(final CombinedDiffNode combinedDiffNode, final CombinedDiffNode combinedDiffNode2) {
        if (combinedDiffNode == null || combinedDiffNode2 == null) {
            return;
        }
        if (this.viewTabPanel.getView().isFlowgraphView()) {
            try {
                BasicBlockMatchAdder.addBasicblockMatch(this.graphs, combinedDiffNode, combinedDiffNode2);
                this.setMatchesChanged(true);
            }
            catch (GraphLayoutException ex) {
                Logger.logException(ex, ex.getMessage());
                CMessageBox.showError(this.viewTabPanel, ex.getMessage());
            }
        }
    }
    
    public boolean closeView(final boolean b) {
        final ViewData view = this.viewTabPanel.getView();
        if (b && this.hasChanged() && !this.saveView()) {
            return false;
        }
        final Diff diff = this.viewTabPanel.getDiff();
        diff.getViewManager().removeView(view);
        this.getMainWindow().getController().getTabPanelManager().removeTab(this.viewTabPanel);
        this.viewTabPanel.dispose();
        this.dispose();
        this.graphs.dispose();
        this.viewTabPanel = null;
        if (view.isCallgraphView()) {
            diff.getCallgraph(ESide.PRIMARY).resetVisibilityAndSelection();
            diff.getCallgraph(ESide.SECONDARY).resetVisibilityAndSelection();
        }
        final Iterator iterator = diff.getListener().iterator();
        while (iterator.hasNext()) {
            iterator.next().closedView(diff);
        }
        return true;
    }
    
    public void colorInvisibleNodes() {
        if (this.showColorChooserDialog()) {
            final Color currentColor = this.currentColor;
            if (this.settings.isSync()) {
                GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), currentColor);
                GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), currentColor);
                GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), currentColor);
            }
            else {
                switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
                    case 1: {
                        if (this.settings.getFocus() == ESide.PRIMARY) {
                            GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), currentColor);
                            break;
                        }
                        GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), currentColor);
                        break;
                    }
                    case 2: {
                        GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), currentColor);
                        break;
                    }
                }
            }
        }
    }
    
    public void colorSelectedNodes() {
        if (this.showColorChooserDialog()) {
            final Color currentColor = this.currentColor;
            if (this.settings.isSync()) {
                GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), currentColor);
                GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), currentColor);
                GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), currentColor);
            }
            else {
                switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
                    case 1: {
                        if (this.settings.getFocus() == ESide.PRIMARY) {
                            GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), currentColor);
                            break;
                        }
                        GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), currentColor);
                        break;
                    }
                    case 2: {
                        GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), currentColor);
                        break;
                    }
                }
            }
        }
    }
    
    public void colorUnslectedNodes() {
        if (this.showColorChooserDialog()) {
            final Color currentColor = this.currentColor;
            if (this.settings.isSync()) {
                GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), currentColor);
                GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), currentColor);
                GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), currentColor);
            }
            else {
                switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
                    case 1: {
                        if (this.settings.getFocus() == ESide.PRIMARY) {
                            GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), currentColor);
                            break;
                        }
                        GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), currentColor);
                        break;
                    }
                    case 2: {
                        GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), currentColor);
                        break;
                    }
                }
            }
        }
    }
    
    public void deselectLeafs() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectLeafs(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.deselectLeafs(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.deselectLeafs(this.graphs.getCombinedGraph());
        }
    }
    
    public void deselectPeriphery() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectPeriphery(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.deselectPeriphery(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.deselectPeriphery(this.graphs.getCombinedGraph());
        }
    }
    
    public void deselectRoots() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectRoots(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.deselectRoots(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.deselectRoots(this.graphs.getCombinedGraph());
        }
    }
    
    public void dispose() {
        this.graphListenerManager.dispose();
        final CDefaultLabelEventHandler labelEventHandler = this.graphs.getPrimaryGraph().getEditMode().getLabelEventHandler();
        final CDefaultLabelEventHandler labelEventHandler2 = this.graphs.getSecondaryGraph().getEditMode().getLabelEventHandler();
        final CDefaultLabelEventHandler labelEventHandler3 = this.graphs.getCombinedGraph().getEditMode().getLabelEventHandler();
        if (labelEventHandler3 != null) {
            labelEventHandler3.removeEditModeListener(this.labelEditModeListener);
        }
        if (labelEventHandler != null) {
            labelEventHandler.removeEditModeListener(this.labelEditModeListener);
        }
        if (labelEventHandler2 != null) {
            labelEventHandler2.removeEditModeListener(this.labelEditModeListener);
        }
        if (this.selectByCriteriaDlg != null) {
            this.selectByCriteriaDlg.dispose();
            this.selectByCriteriaDlg = null;
        }
    }
    
    public void doLayout(final EGraphLayout eGraphLayout) {
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                binDiffGraph = this.graphs.getPrimaryGraph();
            }
            else {
                binDiffGraph = this.graphs.getSecondaryGraph();
            }
        }
        if (binDiffGraph != null) {
            switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EGraphLayout[eGraphLayout.ordinal()]) {
                case 1: {
                    binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.CIRCULAR);
                    break;
                }
                case 2: {
                    binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.HIERARCHICAL);
                    break;
                }
                case 3: {
                    binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.ORTHOGONAL);
                    break;
                }
            }
            this.graphListenerManager.suppressUpdating(true);
            GraphLayoutEventHandler.handleDoLayoutButtonEvent(binDiffGraph, true);
            this.graphListenerManager.suppressUpdating(false);
        }
    }
    
    public void exportViewAsImage() {
        final MainWindow mainWindow = this.getMainWindow();
        final ExportViewDialog exportViewDialog = new ExportViewDialog(mainWindow, "Export View as Image", "", new File(this.graphs.getDiff().getDiffFolder()), this.viewTabPanel.getView().getViewName().toString());
        exportViewDialog.setVisible(true);
        if (exportViewDialog.isOkPressed()) {
            try {
                if (exportViewDialog.isCapturePart()) {
                    if (exportViewDialog.isPNG()) {
                        GraphExporters.exportPartAsPNG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                        GraphExporters.exportPartAsPNG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                        GraphExporters.exportPartAsPNG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    }
                    else if (exportViewDialog.isJPEG()) {
                        GraphExporters.exportPartAsJPEG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                        GraphExporters.exportPartAsJPEG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                        GraphExporters.exportPartAsJPEG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    }
                    else if (exportViewDialog.isGIF()) {
                        GraphExporters.exportPartAsGIF(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                        GraphExporters.exportPartAsGIF(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                        GraphExporters.exportPartAsGIF(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    }
                    else if (exportViewDialog.isSVG()) {
                        GraphExporters.exportPartAsSVG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                        GraphExporters.exportPartAsSVG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                        GraphExporters.exportPartAsSVG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    }
                }
                else if (exportViewDialog.isPNG()) {
                    GraphExporters.exportAllAsPNG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportAllAsPNG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportAllAsPNG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                }
                else if (exportViewDialog.isJPEG()) {
                    GraphExporters.exportAllAsJPEG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportAllAsJPEG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportAllAsJPEG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                }
                else if (exportViewDialog.isGIF()) {
                    GraphExporters.exportAllAsGIF(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportAllAsGIF(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportAllAsGIF(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                }
                else if (exportViewDialog.isSVG()) {
                    GraphExporters.exportAllAsSVG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportAllAsSVG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportAllAsSVG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                }
            }
            catch (Exception ex) {
                Logger.logException(ex, "Couldn't save exported view images.");
                CMessageBox.showError(mainWindow, "Couldn't save exported view images.");
            }
        }
    }
    
    public void fitGraphContentToView() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            GraphZoomer.fitContent(this.graphs.getCombinedGraph());
        }
        else if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            GraphZoomer.fitContent(this.graphs.getSuperGraph());
        }
    }
    
    public void fitGraphs() {
        final Dimension size = this.viewTabPanel.getNormalViewPanel().getSize();
        this.graphs.getCombinedGraph().getView().setSize((int)Math.round(size.width * (1.0 - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH - 0.06)), (int)Math.round(size.getHeight()));
        GraphViewFitter.fitSingleViewToSuperViewContent(this.graphs.getSuperGraph());
        this.graphs.getCombinedGraph().getGraph().U();
        this.graphs.getCombinedGraph().getView().setZoom(this.graphs.getCombinedGraph().getView().getZoom() * 0.9);
        this.graphs.getCombinedGraph().getGraph().T();
        this.graphs.getPrimaryGraph().getGraph().T();
        this.graphs.getSecondaryGraph().getGraph().T();
    }
    
    public JPanel getCurrentViewPanel() {
        switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1: {
                return this.viewTabPanel.getNormalViewPanel();
            }
            case 2: {
                return this.viewTabPanel.getCombinedViewPanel();
            }
            default: {
                throw new IllegalStateException("Unknown view mode.");
            }
        }
    }
    
    public GraphViewsListenerManager getGraphListenerManager() {
        return this.graphListenerManager;
    }
    
    public GraphsContainer getGraphs() {
        return this.graphs;
    }
    
    public GraphSettings getGraphSettings() {
        return this.settings;
    }
    
    public TabPanelManager getTabPanelManager() {
        return this.viewTabPanel.getTabPanelManager();
    }
    
    public ViewTabPanel getViewTabPanel() {
        return this.viewTabPanel;
    }
    
    public boolean hasChanged() {
        return this.hasChangedMatches || this.hasChangedComments;
    }
    
    public void invertSelection() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.invertSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.invertSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.invertSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void openFlowgraphsViews(final ZyGraphNode zyGraphNode) {
        final WorkspaceTabPanelFunctions controller = this.viewTabPanel.getTabPanelManager().getWorkspaceTabPanel().getController();
        final Diff diff = this.getGraphs().getDiff();
        IAddress address;
        IAddress address2;
        if (zyGraphNode instanceof SingleDiffNode) {
            final RawFunction rawFunction = (RawFunction)zyGraphNode.getRawNode();
            if (rawFunction.getSide() == ESide.PRIMARY) {
                final RawFunction matchedFunction = rawFunction.getMatchedFunction();
                address = rawFunction.getAddress();
                address2 = ((matchedFunction == null) ? null : matchedFunction.getAddress());
            }
            else {
                final RawFunction matchedFunction2 = rawFunction.getMatchedFunction();
                address = ((matchedFunction2 == null) ? null : matchedFunction2.getAddress());
                address2 = rawFunction.getAddress();
            }
        }
        else {
            if (!(zyGraphNode instanceof CombinedDiffNode)) {
                return;
            }
            final RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)zyGraphNode.getRawNode();
            address = rawCombinedFunction.getAddress(ESide.PRIMARY);
            address2 = rawCombinedFunction.getAddress(ESide.SECONDARY);
        }
        controller.openFlowgraphView(this.getMainWindow(), diff, address, address2);
    }
    
    public void printView(final BinDiffGraph binDiffGraph) {
        new PrintGraphPreviewDialog(this.getMainWindow(), binDiffGraph.getView());
    }
    
    public void redoSelection() {
        this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getPrimaryGraph().getSelectionHistory().redo();
        this.graphs.getSecondaryGraph().getSelectionHistory().redo();
        this.graphs.getCombinedGraph().getSelectionHistory().redo();
        this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(true);
        this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(true);
        this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(true);
    }
    
    public void removeListener(final ISavableListener savableListener) {
        this.listenerProvider.removeListener(savableListener);
    }
    
    public void removeNodeMatch(final List list) {
        if (list == null) {
            return;
        }
        if (this.viewTabPanel.getView().isFlowgraphView()) {
            try {
                final Iterator<CombinedDiffNode> iterator = list.iterator();
                while (iterator.hasNext()) {
                    BasicBlockMatchRemover.removeBasicblockMatch(this.graphs, iterator.next());
                    this.setMatchesChanged(true);
                }
            }
            catch (GraphLayoutException ex) {
                Logger.logException(ex, ex.getMessage());
                CMessageBox.showError(this.viewTabPanel, ex.getMessage());
            }
            catch (Exception ex2) {
                Logger.logException(ex2, ex2.getMessage());
                CMessageBox.showError(this.viewTabPanel, ex2.getMessage());
            }
        }
    }
    
    public void resetDefaultPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().resetDefaultPerspective();
        }
        else if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            this.viewTabPanel.getCombinedViewPanel().resetDefaultPerspective();
        }
    }
    
    public boolean saveView() {
        final Diff diff = this.graphs.getDiff();
        Label_0182: {
            if (diff.isFunctionDiff()) {
                try {
                    final SaveFunctionDiffViewDialog saveFunctionDiffViewDialog = new SaveFunctionDiffViewDialog(this.getMainWindow(), "Save Function Diff View", this.getWorkspace(), diff);
                    saveFunctionDiffViewDialog.setVisible(true);
                    if (saveFunctionDiffViewDialog.isOkPressed()) {
                        this.updateFunctionMatchCounts();
                        ProgressDialog.show(this.getMainWindow(), "Saving View...", new FunctionDiffViewSaver(this, saveFunctionDiffViewDialog.getExportBinaryTargetFile(ESide.PRIMARY), saveFunctionDiffViewDialog.getExportBinaryTargetFile(ESide.SECONDARY), saveFunctionDiffViewDialog.getMatchesDatabaseTargetFile(), saveFunctionDiffViewDialog.isOverrideExportBinary(ESide.PRIMARY), saveFunctionDiffViewDialog.isOverrideExportBinary(ESide.SECONDARY)));
                        final TabPanelManager tabPanelManager = this.viewTabPanel.getTabPanelManager();
                        tabPanelManager.updateSelectedTabTitel(saveFunctionDiffViewDialog.getFunctionDiffName());
                        tabPanelManager.udpateSelectedTabIcon();
                        this.getMainWindow().updateTitle(this.getWorkspace(), this.viewTabPanel);
                        break Label_0182;
                    }
                    return false;
                }
                catch (Exception ex) {
                    Logger.logException(ex, "Save function diff view failed.");
                    CMessageBox.showError(this.getMainWindow(), "Save function diff view failed.");
                    return false;
                }
            }
            this.updateFunctionMatchCounts();
            this.writeComments();
            this.writeFlowgraphMatches();
        }
        this.setMatchesChanged(false);
        this.setCommentsChanged(false);
        return true;
    }
    
    public void selectAncestors() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectAncestorsOfSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.selectAncestorsOfSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.selectAncestorsOfSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void selectByCriteria() {
        if (this.selectByCriteriaDlg == null) {
            this.selectByCriteriaDlg = new CriteriaDialog(SwingUtilities.getWindowAncestor(this.viewTabPanel), new CriteriaFactory(this.graphs));
        }
        this.selectByCriteriaDlg.setVisible(true);
        this.selectByCriteriaDlg.setVisible(false);
        final HashSet set = new HashSet();
        final CriteriumTree criteriumTree = this.selectByCriteriaDlg.getCriteriumTree();
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            if (this.settings.isSync()) {
                final ArrayList<CombinedDiffNode> list = new ArrayList<CombinedDiffNode>();
                final ArrayList<CombinedDiffNode> list2 = new ArrayList<CombinedDiffNode>();
                final ArrayList<SuperDiffNode> list3 = new ArrayList<SuperDiffNode>();
                final ArrayList<SuperDiffNode> list4 = new ArrayList<SuperDiffNode>();
                final ArrayList<SingleDiffNode> list5 = new ArrayList<SingleDiffNode>();
                final ArrayList<SingleDiffNode> list6 = new ArrayList<SingleDiffNode>();
                final ArrayList<SingleDiffNode> list7 = new ArrayList<SingleDiffNode>();
                final ArrayList<SingleDiffNode> list8 = new ArrayList<SingleDiffNode>();
                if (this.selectByCriteriaDlg.doSelectNodes()) {
                    set.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getPrimaryGraph()));
                    set.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getSecondaryGraph()));
                    for (final SuperDiffNode superDiffNode : this.graphs.getSuperGraph().getNodes()) {
                        final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
                        final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
                        final CombinedDiffNode combinedDiffNode = superDiffNode.getCombinedDiffNode();
                        if ((primaryDiffNode != null && set.contains(primaryDiffNode)) || (secondaryDiffNode != null && set.contains(secondaryDiffNode))) {
                            if (primaryDiffNode != null) {
                                list5.add(primaryDiffNode);
                            }
                            if (secondaryDiffNode != null) {
                                list7.add(secondaryDiffNode);
                            }
                            list.add(combinedDiffNode);
                            list3.add(superDiffNode);
                        }
                        else {
                            if (primaryDiffNode != null) {
                                list6.add(primaryDiffNode);
                            }
                            if (secondaryDiffNode != null) {
                                list8.add(secondaryDiffNode);
                            }
                            list2.add(combinedDiffNode);
                            list4.add(superDiffNode);
                        }
                    }
                    final boolean automaticLayouting = this.settings.getLayoutSettings().getAutomaticLayouting();
                    this.settings.getLayoutSettings().setAutomaticLayouting(false);
                    this.graphs.getPrimaryGraph().selectNodes(list5, list6);
                    this.graphs.getSecondaryGraph().selectNodes(list7, list8);
                    this.graphs.getCombinedGraph().selectNodes(list, list2);
                    this.graphs.getSuperGraph().selectNodes(list3, list4);
                    this.settings.getLayoutSettings().setAutomaticLayouting(automaticLayouting);
                }
            }
            else if (this.settings.getFocus() == ESide.PRIMARY) {
                if (this.selectByCriteriaDlg.doSelectNodes()) {
                    set.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getPrimaryGraph()));
                }
            }
            else if (this.selectByCriteriaDlg.doSelectNodes()) {
                set.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getSecondaryGraph()));
            }
        }
        else if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            if (this.selectByCriteriaDlg.doSelectNodes()) {
                set.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getCombinedGraph()));
            }
            final ArrayList<CombinedDiffNode> list9 = new ArrayList<CombinedDiffNode>();
            final ArrayList<CombinedDiffNode> list10 = new ArrayList<CombinedDiffNode>();
            final Iterator<SuperDiffNode> iterator2 = (Iterator<SuperDiffNode>)this.graphs.getSuperGraph().getNodes().iterator();
            while (iterator2.hasNext()) {
                final CombinedDiffNode combinedDiffNode2 = iterator2.next().getCombinedDiffNode();
                if (set.contains(combinedDiffNode2)) {
                    list9.add(combinedDiffNode2);
                }
                else {
                    list10.add(combinedDiffNode2);
                }
            }
            this.graphs.getCombinedGraph().selectNodes(list9, list10);
        }
    }
    
    public void selectChildren() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectChildrenOfSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.selectChildrenOfSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.selectChildrenOfSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void selectNeighbours() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectNeighboursOfSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.selectNeighboursOfSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.selectNeighboursOfSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void selectParents() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectParentsOfSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.selectParentsOfSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.selectParentsOfSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void selectSuccessors() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectSuccessorsOfSelection(this.graphs.getPrimaryGraph());
            }
            else {
                GraphSelector.selectSuccessorsOfSelection(this.graphs.getSecondaryGraph());
            }
        }
        else {
            GraphSelector.selectSuccessorsOfSelection(this.graphs.getCombinedGraph());
        }
    }
    
    public void setCaretIntoJumpToAddressField(final ESide caretIntoJumpToAddressField) {
        this.viewTabPanel.getToolbar().setCaretIntoJumpToAddressField(caretIntoJumpToAddressField);
    }
    
    public void setCaretIntoSearchField() {
        this.viewTabPanel.getToolbar().setCaretIntoSearchField();
    }
    
    public void setDefaultNodeColors() {
        final Diff diff = this.graphs.getDiff();
        final CombinedGraph combinedGraph = this.graphs.getCombinedGraph();
        if (combinedGraph.getGraphType() == EGraphType.CALLGRAPH) {
            final Iterator iterator = combinedGraph.getNodes().iterator();
            while (iterator.hasNext()) {
                ViewCallGraphBuilder.colorizeFunctions((RawCombinedFunction)iterator.next().getRawNode());
            }
        }
        else {
            final Iterator iterator2 = combinedGraph.getNodes().iterator();
            while (iterator2.hasNext()) {
                final RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)iterator2.next().getRawNode();
                ViewFlowGraphBuilder.colorizeBasicblocks(diff.getMatches().getFunctionMatch(rawCombinedBasicBlock.getPrimaryFunctionAddress(), ESide.PRIMARY), rawCombinedBasicBlock);
            }
        }
    }
    
    public void setViewFocus(final ESide focusSide) {
        this.settings.setFocusSide(focusSide);
    }
    
    public void showGraphSettingDialog() {
        if (this.settingsDialog == null) {
            this.settingsDialog = new GraphSettingsDialog(this.getMainWindow(), this.getGraphSettings());
        }
        this.settingsDialog.setVisible(true);
    }
    
    public void showSearchResultsDialog() {
        this.viewTabPanel.getToolbar().getSearchResultsDialog().setVisible(true);
    }
    
    public void switchViewPanel(final EDiffViewMode diffViewMode) {
        this.viewTabPanel.remove(this.getCurrentViewPanel());
        this.settings.setDiffViewMode(diffViewMode);
        this.viewTabPanel.add(this.getCurrentViewPanel(), "Center");
        this.viewTabPanel.updateUI();
    }
    
    public void toggleAutoamticLayout() {
        this.settings.getLayoutSettings().setAutomaticLayouting(!this.settings.getLayoutSettings().getAutomaticLayouting());
    }
    
    public void toggleGraphsPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().toggleGraphsPerspective();
        }
        else if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            this.viewTabPanel.getCombinedViewPanel().toggleGraphsPerspective();
        }
    }
    
    public void toggleGraphSynchronization() {
        if (EGraphSynchronization.SYNC == this.settings.getGraphSyncMode()) {
            this.settings.setGraphSyncMode(EGraphSynchronization.ASYNC);
        }
        else {
            this.settings.setGraphSyncMode(EGraphSynchronization.SYNC);
            GraphLayoutEventHandler.handleReactivateViewSynchronization(this.graphs.getCombinedGraph());
        }
    }
    
    public void togglePrimaryPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().togglePrimaryPerspective();
        }
    }
    
    public void toggleProximityBrowsing() {
        BinDiffGraph combinedGraph = this.graphs.getCombinedGraph();
        if (this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            combinedGraph = ((this.settings.getFocus() == ESide.PRIMARY) ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph());
        }
        if (!this.settings.getProximitySettings().getProximityBrowsing()) {
            GraphLayoutEventHandler.handleProximityBrowsingActivatedEvent(combinedGraph);
        }
        else {
            GraphLayoutEventHandler.handleProximityBrowsingDeactivatedEvent(combinedGraph);
        }
    }
    
    public void toggleProximityBrowsingFrozen() {
        final GraphProximityBrowsingSettings proximitySettings = this.settings.getProximitySettings();
        proximitySettings.setProximityBrowsingFrozen(!proximitySettings.getProximityBrowsingFrozen());
        if (proximitySettings.getProximityBrowsing() && !proximitySettings.getProximityBrowsingFrozen()) {
            BinDiffGraph combinedGraph = this.graphs.getCombinedGraph();
            if (this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
                combinedGraph = ((this.settings.getFocus() == ESide.PRIMARY) ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph());
            }
            GraphLayoutEventHandler.handleSelectionChangedEvent(combinedGraph, true);
        }
    }
    
    public void toggleSecondaryPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().toggleSecondaryPerspective();
        }
    }
    
    public void undoSelection() {
        this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(false);
        this.graphs.getPrimaryGraph().getSelectionHistory().undo();
        this.graphs.getSecondaryGraph().getSelectionHistory().undo();
        this.graphs.getCombinedGraph().getSelectionHistory().undo();
        this.graphs.getPrimaryGraph().getSelectionHistory().setEnabled(true);
        this.graphs.getSecondaryGraph().getSelectionHistory().setEnabled(true);
        this.graphs.getCombinedGraph().getSelectionHistory().setEnabled(true);
    }
    
    public void writeComments() {
        if (!this.hasChangedComments) {
            return;
        }
        try {
            final Workspace workspace = this.getWorkspace();
            final DiffMetaData metaData = this.graphs.getDiff().getMetaData();
            CommentsWriter.writeComments(workspace, metaData.getImageHash(ESide.PRIMARY), metaData.getImageHash(ESide.SECONDARY), this.viewTabPanel.getView());
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Couldn't save view comments.");
            final MainWindow mainWindow = this.getMainWindow();
            final String s = "Couldn't save view comments: ";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(mainWindow, (value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public void writeFlowgraphMatches() {
        if (!this.hasChangedMatches) {
            return;
        }
        final Diff diff = this.graphs.getDiff();
        final FunctionMatchData functionMatch = diff.getMatches().getFunctionMatch(((FlowGraphViewData)this.viewTabPanel.getView()).getAddress(ESide.PRIMARY), ESide.PRIMARY);
        try (final MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase())) {
            matchesDatabase.updateFunctionMatch(functionMatch.getAddress(ESide.PRIMARY), functionMatch.getAddress(ESide.SECONDARY), functionMatch);
        }
        catch (SQLException ex) {
            Logger.logException(ex, "Couldn't save changed basic block matches.");
            final MainWindow mainWindow = this.getMainWindow();
            final String s = "Couldn't save changed basic block matches.";
            final String value = String.valueOf(ex.getMessage());
            CMessageBox.showError(mainWindow, (value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
    
    public void zoom(final boolean b) {
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            binDiffGraph = this.graphs.getPrimaryGraph();
            if (!this.settings.isSync() && this.settings.getFocus() == ESide.SECONDARY) {
                binDiffGraph = this.graphs.getSecondaryGraph();
            }
        }
        if (b) {
            binDiffGraph.zoomIn();
        }
        else {
            binDiffGraph.zoomOut();
        }
    }
    
    public void zoomToSelectedNodes() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            GraphZoomer.zoomToNodes(this.graphs.getCombinedGraph(), this.graphs.getCombinedGraph().getSelectedNodes());
        }
        else if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            GraphZoomer.zoomToNodes(this.graphs.getSuperGraph(), this.graphs.getSuperGraph().getSelectedNodes());
        }
    }
}
