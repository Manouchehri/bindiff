/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.database.MatchesDatabase;
import com.google.security.zynamics.bindiff.enums.EDiffViewMode;
import com.google.security.zynamics.bindiff.enums.EGraphLayout;
import com.google.security.zynamics.bindiff.enums.EGraphSynchronization;
import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.exceptions.GraphLayoutException;
import com.google.security.zynamics.bindiff.graph.AbstractGraphsContainer;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.builders.ViewCallGraphBuilder;
import com.google.security.zynamics.bindiff.graph.builders.ViewFlowGraphBuilder;
import com.google.security.zynamics.bindiff.graph.eventhandlers.GraphLayoutEventHandler;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchAdder;
import com.google.security.zynamics.bindiff.graph.helpers.BasicBlockMatchRemover;
import com.google.security.zynamics.bindiff.graph.helpers.GraphColorizer;
import com.google.security.zynamics.bindiff.graph.helpers.GraphSelector;
import com.google.security.zynamics.bindiff.graph.helpers.GraphViewFitter;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.listeners.GraphViewsListenerManager;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphLayoutSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphProximityBrowsingSettings;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.gui.dialogs.ExportViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.ProgressDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.CriteriaFactory;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumExecuter;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.graphsettings.GraphSettingsDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.printing.PrintGraphPreviewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.searchresultsdialog.SearchResultsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.TabPanelManager;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.projecttabpanel.WorkspaceTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ISavableListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions$InternalEditableContentListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.selectionhistory.SelectionHistory;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.ViewToolbarPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CNormalViewPanel;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.viewpanel.CombinedViewPanel;
import com.google.security.zynamics.bindiff.gui.window.CWindowFunctions;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.io.comments.CommentsWriter;
import com.google.security.zynamics.bindiff.log.Logger;
import com.google.security.zynamics.bindiff.project.Workspace;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.diff.FunctionDiffViewSaver;
import com.google.security.zynamics.bindiff.project.diff.IDiffListener;
import com.google.security.zynamics.bindiff.project.matches.BasicBlockMatchData;
import com.google.security.zynamics.bindiff.project.matches.DiffMetaData;
import com.google.security.zynamics.bindiff.project.matches.FunctionMatchData;
import com.google.security.zynamics.bindiff.project.matches.MatchData;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCallGraph;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawCombinedFunction;
import com.google.security.zynamics.bindiff.project.rawcallgraph.RawFunction;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawCombinedBasicBlock;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawJump;
import com.google.security.zynamics.bindiff.project.userview.FlowGraphViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.project.userview.ViewManager;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import com.google.security.zynamics.zylib.gui.CColorChooser;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.CDefaultLabelEventHandler;
import com.google.security.zynamics.zylib.gui.zygraph.ILabelEditableContentListener;
import com.google.security.zynamics.zylib.gui.zygraph.nodes.IViewNode;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.GraphExporters;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.editmode.ZyEditMode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import y.h.bu;
import y.h.ch;

public class ViewTabPanelFunctions
extends TabPanelFunctions {
    private final ListenerProvider listenerProvider = new ListenerProvider();
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

    public ViewTabPanelFunctions(MainWindow mainWindow, Workspace workspace, ViewTabPanel viewTabPanel, ViewData viewData) {
        super(mainWindow, workspace);
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

    public static boolean isNodeSelectionMatchAddable(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        if (BasicBlockMatchAdder.getAffectedCombinedNodes(binDiffGraph, zyGraphNode) == null) return false;
        return true;
    }

    public static boolean isNodeSelectionMatchDeleteable(BinDiffGraph binDiffGraph, ZyGraphNode zyGraphNode) {
        if (BasicBlockMatchRemover.getAffectedCombinedNodes(binDiffGraph, zyGraphNode) == null) return false;
        return true;
    }

    private void notifySaveableListener() {
        Iterator iterator = this.listenerProvider.iterator();
        while (iterator.hasNext()) {
            ISavableListener iSavableListener = (ISavableListener)iterator.next();
            iSavableListener.isSavable(this.hasChanged());
        }
    }

    private void setCommentsChanged(boolean bl2) {
        this.hasChangedComments = bl2;
        this.notifySaveableListener();
    }

    private void setMatchesChanged(boolean bl2) {
        this.hasChangedMatches = bl2;
        this.notifySaveableListener();
    }

    private boolean showColorChooserDialog() {
        List list = GraphColorizer.getRecentColors();
        this.currentColor = CColorChooser.showDialog(this.viewTabPanel, "Color Nodes", Color.WHITE, list.toArray(new Color[0]));
        if (this.currentColor == null) return false;
        list.add(this.currentColor);
        GraphColorizer.setRecentColors(list);
        return true;
    }

    private void updateFunctionMatchCounts() {
        ViewData viewData = this.viewTabPanel.getView();
        if (!viewData.isFlowgraphView()) {
            if (!viewData.isSingleFunctionDiffView()) return;
        }
        Diff diff = viewData.getGraphs().getDiff();
        IAddress iAddress = viewData.getAddress(ESide.PRIMARY);
        FunctionMatchData functionMatchData = diff.getMatches().getFunctionMatch(iAddress, ESide.PRIMARY);
        RawFlowGraph rawFlowGraph = (RawFlowGraph)viewData.getRawGraph(ESide.PRIMARY);
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        Iterator iterator = rawFlowGraph.getNodes().iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                functionMatchData.setSizeOfMatchedBasicblocks(n2);
                functionMatchData.setSizeOfMatchedJumps(n3);
                functionMatchData.setSizeOfMatchedInstructions(n4);
                return;
            }
            RawBasicBlock rawBasicBlock = (RawBasicBlock)iterator.next();
            if (rawBasicBlock.getMatchState() != EMatchState.MATCHED) continue;
            ++n2;
            for (Object object2 : rawBasicBlock.getOutgoingEdges()) {
                RawJump rawJump = (RawJump)object2;
                if (rawJump.getSource().getMatchState() != EMatchState.MATCHED || rawJump.getTarget().getMatchState() != EMatchState.MATCHED) continue;
                ++n3;
            }
            IAddress iAddress2 = rawBasicBlock.getAddress();
            object2 = functionMatchData.getBasicblockMatch(iAddress2, ESide.PRIMARY);
            n4 += object2.getSizeOfMatchedInstructions();
        } while (true);
    }

    public void addListener(ISavableListener iSavableListener) {
        this.listenerProvider.addListener(iSavableListener);
    }

    public void addNodeMatch(CombinedDiffNode combinedDiffNode, CombinedDiffNode combinedDiffNode2) {
        if (combinedDiffNode == null) return;
        if (combinedDiffNode2 == null) {
            return;
        }
        if (!this.viewTabPanel.getView().isFlowgraphView()) return;
        try {
            BasicBlockMatchAdder.addBasicblockMatch(this.graphs, combinedDiffNode, combinedDiffNode2);
            this.setMatchesChanged(true);
            return;
        }
        catch (GraphLayoutException var3_3) {
            Logger.logException(var3_3, var3_3.getMessage());
            CMessageBox.showError(this.viewTabPanel, var3_3.getMessage());
        }
    }

    public boolean closeView(boolean bl2) {
        ViewData viewData = this.viewTabPanel.getView();
        if (bl2 && this.hasChanged() && !this.saveView()) {
            return false;
        }
        Diff diff = this.viewTabPanel.getDiff();
        diff.getViewManager().removeView(viewData);
        this.getMainWindow().getController().getTabPanelManager().removeTab(this.viewTabPanel);
        this.viewTabPanel.dispose();
        this.dispose();
        this.graphs.dispose();
        this.viewTabPanel = null;
        if (viewData.isCallgraphView()) {
            diff.getCallgraph(ESide.PRIMARY).resetVisibilityAndSelection();
            diff.getCallgraph(ESide.SECONDARY).resetVisibilityAndSelection();
        }
        Iterator iterator = diff.getListener().iterator();
        while (iterator.hasNext()) {
            IDiffListener iDiffListener = (IDiffListener)iterator.next();
            iDiffListener.closedView(diff);
        }
        return true;
    }

    public void colorInvisibleNodes() {
        if (!this.showColorChooserDialog()) return;
        Color color = this.currentColor;
        if (this.settings.isSync()) {
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), color);
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), color);
            GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), color);
            return;
        }
        switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1: {
                if (this.settings.getFocus() == ESide.PRIMARY) {
                    GraphColorizer.colorizeInvisibleNodes(this.graphs.getPrimaryGraph(), color);
                    return;
                }
                GraphColorizer.colorizeInvisibleNodes(this.graphs.getSecondaryGraph(), color);
                return;
            }
            case 2: {
                GraphColorizer.colorizeInvisibleNodes(this.graphs.getCombinedGraph(), color);
                break;
            }
        }
    }

    public void colorSelectedNodes() {
        if (!this.showColorChooserDialog()) return;
        Color color = this.currentColor;
        if (this.settings.isSync()) {
            GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), color);
            GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), color);
            GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), color);
            return;
        }
        switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1: {
                if (this.settings.getFocus() == ESide.PRIMARY) {
                    GraphColorizer.colorizeSelectedNodes(this.graphs.getPrimaryGraph(), color);
                    return;
                }
                GraphColorizer.colorizeSelectedNodes(this.graphs.getSecondaryGraph(), color);
                return;
            }
            case 2: {
                GraphColorizer.colorizeSelectedNodes(this.graphs.getCombinedGraph(), color);
                break;
            }
        }
    }

    public void colorUnslectedNodes() {
        if (!this.showColorChooserDialog()) return;
        Color color = this.currentColor;
        if (this.settings.isSync()) {
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), color);
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), color);
            GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), color);
            return;
        }
        switch (ViewTabPanelFunctions$1.$SwitchMap$com$google$security$zynamics$bindiff$enums$EDiffViewMode[this.settings.getDiffViewMode().ordinal()]) {
            case 1: {
                if (this.settings.getFocus() == ESide.PRIMARY) {
                    GraphColorizer.colorizeUnselectedNodes(this.graphs.getPrimaryGraph(), color);
                    return;
                }
                GraphColorizer.colorizeUnselectedNodes(this.graphs.getSecondaryGraph(), color);
                return;
            }
            case 2: {
                GraphColorizer.colorizeUnselectedNodes(this.graphs.getCombinedGraph(), color);
                break;
            }
        }
    }

    public void deselectLeafs() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectLeafs(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.deselectLeafs(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.deselectLeafs(this.graphs.getCombinedGraph());
    }

    public void deselectPeriphery() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectPeriphery(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.deselectPeriphery(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.deselectPeriphery(this.graphs.getCombinedGraph());
    }

    public void deselectRoots() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.deselectRoots(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.deselectRoots(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.deselectRoots(this.graphs.getCombinedGraph());
    }

    public void dispose() {
        this.graphListenerManager.dispose();
        CDefaultLabelEventHandler cDefaultLabelEventHandler = this.graphs.getPrimaryGraph().getEditMode().getLabelEventHandler();
        CDefaultLabelEventHandler cDefaultLabelEventHandler2 = this.graphs.getSecondaryGraph().getEditMode().getLabelEventHandler();
        CDefaultLabelEventHandler cDefaultLabelEventHandler3 = this.graphs.getCombinedGraph().getEditMode().getLabelEventHandler();
        if (cDefaultLabelEventHandler3 != null) {
            cDefaultLabelEventHandler3.removeEditModeListener(this.labelEditModeListener);
        }
        if (cDefaultLabelEventHandler != null) {
            cDefaultLabelEventHandler.removeEditModeListener(this.labelEditModeListener);
        }
        if (cDefaultLabelEventHandler2 != null) {
            cDefaultLabelEventHandler2.removeEditModeListener(this.labelEditModeListener);
        }
        if (this.selectByCriteriaDlg == null) return;
        this.selectByCriteriaDlg.dispose();
        this.selectByCriteriaDlg = null;
    }

    public void doLayout(EGraphLayout eGraphLayout) {
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            binDiffGraph = this.settings.getFocus() == ESide.PRIMARY ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph();
        }
        if (binDiffGraph == null) return;
        switch (eGraphLayout) {
            case CIRCULAR: {
                binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.CIRCULAR);
                break;
            }
            case HIERARCHICAL: {
                binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.HIERARCHICAL);
                break;
            }
            case ORTHOGONAL: {
                binDiffGraph.getSettings().getLayoutSettings().setDefaultGraphLayout(EGraphLayout.ORTHOGONAL);
            }
        }
        this.graphListenerManager.suppressUpdating(true);
        GraphLayoutEventHandler.handleDoLayoutButtonEvent(binDiffGraph, true);
        this.graphListenerManager.suppressUpdating(false);
    }

    public void exportViewAsImage() {
        MainWindow mainWindow = this.getMainWindow();
        ExportViewDialog exportViewDialog = new ExportViewDialog(mainWindow, "Export View as Image", "", new File(this.graphs.getDiff().getDiffFolder()), this.viewTabPanel.getView().getViewName().toString());
        exportViewDialog.setVisible(true);
        if (!exportViewDialog.isOkPressed()) return;
        try {
            if (exportViewDialog.isCapturePart()) {
                if (exportViewDialog.isPNG()) {
                    GraphExporters.exportPartAsPNG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportPartAsPNG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportPartAsPNG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    return;
                }
                if (exportViewDialog.isJPEG()) {
                    GraphExporters.exportPartAsJPEG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportPartAsJPEG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportPartAsJPEG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    return;
                }
                if (exportViewDialog.isGIF()) {
                    GraphExporters.exportPartAsGIF(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                    GraphExporters.exportPartAsGIF(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                    GraphExporters.exportPartAsGIF(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                    return;
                }
                if (!exportViewDialog.isSVG()) return;
                GraphExporters.exportPartAsSVG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                GraphExporters.exportPartAsSVG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                GraphExporters.exportPartAsSVG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                return;
            }
            if (exportViewDialog.isPNG()) {
                GraphExporters.exportAllAsPNG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                GraphExporters.exportAllAsPNG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                GraphExporters.exportAllAsPNG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                return;
            }
            if (exportViewDialog.isJPEG()) {
                GraphExporters.exportAllAsJPEG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                GraphExporters.exportAllAsJPEG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                GraphExporters.exportAllAsJPEG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                return;
            }
            if (exportViewDialog.isGIF()) {
                GraphExporters.exportAllAsGIF(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
                GraphExporters.exportAllAsGIF(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
                GraphExporters.exportAllAsGIF(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
                return;
            }
            if (!exportViewDialog.isSVG()) return;
            GraphExporters.exportAllAsSVG(this.getGraphs().getPrimaryGraph(), exportViewDialog.getPrimaryImageFile().getPath());
            GraphExporters.exportAllAsSVG(this.getGraphs().getSecondaryGraph(), exportViewDialog.getSecondaryImageFile().getPath());
            GraphExporters.exportAllAsSVG(this.getGraphs().getCombinedGraph(), exportViewDialog.getCombinedImageFile().getPath());
            return;
        }
        catch (Exception var3_3) {
            Logger.logException(var3_3, "Couldn't save exported view images.");
            CMessageBox.showError(mainWindow, "Couldn't save exported view images.");
        }
    }

    public void fitGraphContentToView() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            GraphZoomer.fitContent(this.graphs.getCombinedGraph());
            return;
        }
        if (this.settings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
        GraphZoomer.fitContent(this.graphs.getSuperGraph());
    }

    public void fitGraphs() {
        Dimension dimension = this.viewTabPanel.getNormalViewPanel().getSize();
        long l2 = Math.round((double)dimension.width * (1.0 - GraphPanel.COMBINED_MAIN_DIVIDER_WIDTH - 0.06));
        long l3 = Math.round(dimension.getHeight());
        this.graphs.getCombinedGraph().getView().setSize((int)l2, (int)l3);
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
        }
        throw new IllegalStateException("Unknown view mode.");
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
        if (this.hasChangedMatches) return true;
        if (this.hasChangedComments) return true;
        return false;
    }

    public void invertSelection() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.invertSelection(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.invertSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.invertSelection(this.graphs.getCombinedGraph());
    }

    public void openFlowgraphsViews(ZyGraphNode zyGraphNode) {
        IAddress iAddress;
        IAddress iAddress2;
        WorkspaceTabPanel workspaceTabPanel = this.viewTabPanel.getTabPanelManager().getWorkspaceTabPanel();
        WorkspaceTabPanelFunctions workspaceTabPanelFunctions = workspaceTabPanel.getController();
        Diff diff = this.getGraphs().getDiff();
        if (zyGraphNode instanceof SingleDiffNode) {
            RawFunction rawFunction = (RawFunction)zyGraphNode.getRawNode();
            if (rawFunction.getSide() == ESide.PRIMARY) {
                RawFunction rawFunction2 = rawFunction.getMatchedFunction();
                iAddress = rawFunction.getAddress();
                iAddress2 = rawFunction2 == null ? null : rawFunction2.getAddress();
            } else {
                RawFunction rawFunction3 = rawFunction.getMatchedFunction();
                iAddress = rawFunction3 == null ? null : rawFunction3.getAddress();
                iAddress2 = rawFunction.getAddress();
            }
        } else {
            if (!(zyGraphNode instanceof CombinedDiffNode)) return;
            RawCombinedFunction rawCombinedFunction = (RawCombinedFunction)zyGraphNode.getRawNode();
            iAddress = rawCombinedFunction.getAddress(ESide.PRIMARY);
            iAddress2 = rawCombinedFunction.getAddress(ESide.SECONDARY);
        }
        workspaceTabPanelFunctions.openFlowgraphView(this.getMainWindow(), diff, iAddress, iAddress2);
    }

    public void printView(BinDiffGraph binDiffGraph) {
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

    public void removeListener(ISavableListener iSavableListener) {
        this.listenerProvider.removeListener(iSavableListener);
    }

    public void removeNodeMatch(List list) {
        if (list == null) {
            return;
        }
        if (!this.viewTabPanel.getView().isFlowgraphView()) return;
        try {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
                BasicBlockMatchRemover.removeBasicblockMatch(this.graphs, combinedDiffNode);
                this.setMatchesChanged(true);
            }
            return;
        }
        catch (GraphLayoutException var2_3) {
            Logger.logException(var2_3, var2_3.getMessage());
            CMessageBox.showError(this.viewTabPanel, var2_3.getMessage());
            return;
        }
        catch (Exception var2_4) {
            Logger.logException(var2_4, var2_4.getMessage());
            CMessageBox.showError(this.viewTabPanel, var2_4.getMessage());
        }
    }

    public void resetDefaultPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().resetDefaultPerspective();
            return;
        }
        if (this.settings.getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) return;
        this.viewTabPanel.getCombinedViewPanel().resetDefaultPerspective();
    }

    public boolean saveView() {
        Diff diff = this.graphs.getDiff();
        if (diff.isFunctionDiff()) {
            try {
                SaveFunctionDiffViewDialog saveFunctionDiffViewDialog = new SaveFunctionDiffViewDialog(this.getMainWindow(), "Save Function Diff View", this.getWorkspace(), diff);
                saveFunctionDiffViewDialog.setVisible(true);
                if (!saveFunctionDiffViewDialog.isOkPressed()) return false;
                this.updateFunctionMatchCounts();
                FunctionDiffViewSaver functionDiffViewSaver = new FunctionDiffViewSaver(this, saveFunctionDiffViewDialog.getExportBinaryTargetFile(ESide.PRIMARY), saveFunctionDiffViewDialog.getExportBinaryTargetFile(ESide.SECONDARY), saveFunctionDiffViewDialog.getMatchesDatabaseTargetFile(), saveFunctionDiffViewDialog.isOverrideExportBinary(ESide.PRIMARY), saveFunctionDiffViewDialog.isOverrideExportBinary(ESide.SECONDARY));
                ProgressDialog.show((Window)this.getMainWindow(), "Saving View...", functionDiffViewSaver);
                TabPanelManager tabPanelManager = this.viewTabPanel.getTabPanelManager();
                tabPanelManager.updateSelectedTabTitel(saveFunctionDiffViewDialog.getFunctionDiffName());
                tabPanelManager.udpateSelectedTabIcon();
                this.getMainWindow().updateTitle(this.getWorkspace(), this.viewTabPanel);
            }
            catch (Exception var2_3) {
                Logger.logException(var2_3, "Save function diff view failed.");
                CMessageBox.showError(this.getMainWindow(), "Save function diff view failed.");
                return false;
            }
        } else {
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
                return;
            }
            GraphSelector.selectAncestorsOfSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.selectAncestorsOfSelection(this.graphs.getCombinedGraph());
    }

    public void selectByCriteria() {
        Object object;
        if (this.selectByCriteriaDlg == null) {
            object = new CriteriaFactory(this.graphs);
            this.selectByCriteriaDlg = new CriteriaDialog(SwingUtilities.getWindowAncestor(this.viewTabPanel), (CriteriaFactory)object);
        }
        this.selectByCriteriaDlg.setVisible(true);
        this.selectByCriteriaDlg.setVisible(false);
        object = new HashSet();
        CriteriumTree criteriumTree = this.selectByCriteriaDlg.getCriteriumTree();
        if (this.settings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) {
            if (this.settings.getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) return;
            if (this.selectByCriteriaDlg.doSelectNodes()) {
                object.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getCombinedGraph()));
            }
        } else {
            if (!this.settings.isSync()) {
                if (this.settings.getFocus() == ESide.PRIMARY) {
                    if (!this.selectByCriteriaDlg.doSelectNodes()) return;
                    object.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getPrimaryGraph()));
                    return;
                }
                if (!this.selectByCriteriaDlg.doSelectNodes()) return;
                object.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getSecondaryGraph()));
                return;
            }
            ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
            ArrayList<CombinedDiffNode> arrayList2 = new ArrayList<CombinedDiffNode>();
            ArrayList<SuperDiffNode> arrayList3 = new ArrayList<SuperDiffNode>();
            ArrayList<SuperDiffNode> arrayList4 = new ArrayList<SuperDiffNode>();
            ArrayList<SingleDiffNode> arrayList5 = new ArrayList<SingleDiffNode>();
            ArrayList<SingleDiffNode> arrayList6 = new ArrayList<SingleDiffNode>();
            ArrayList<SingleDiffNode> arrayList7 = new ArrayList<SingleDiffNode>();
            ArrayList<SingleDiffNode> arrayList8 = new ArrayList<SingleDiffNode>();
            if (!this.selectByCriteriaDlg.doSelectNodes()) return;
            object.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getPrimaryGraph()));
            object.addAll(CriteriumExecuter.execute(criteriumTree, this.graphs.getSecondaryGraph()));
            Iterator iterator = this.graphs.getSuperGraph().getNodes().iterator();
            do {
                boolean bl2;
                if (!iterator.hasNext()) {
                    boolean bl3 = this.settings.getLayoutSettings().getAutomaticLayouting();
                    this.settings.getLayoutSettings().setAutomaticLayouting(false);
                    this.graphs.getPrimaryGraph().selectNodes(arrayList5, arrayList6);
                    this.graphs.getSecondaryGraph().selectNodes(arrayList7, arrayList8);
                    this.graphs.getCombinedGraph().selectNodes(arrayList, arrayList2);
                    this.graphs.getSuperGraph().selectNodes(arrayList3, arrayList4);
                    this.settings.getLayoutSettings().setAutomaticLayouting(bl3);
                    return;
                }
                SuperDiffNode superDiffNode = (SuperDiffNode)iterator.next();
                SingleDiffNode singleDiffNode = superDiffNode.getPrimaryDiffNode();
                SingleDiffNode singleDiffNode2 = superDiffNode.getSecondaryDiffNode();
                CombinedDiffNode combinedDiffNode = superDiffNode.getCombinedDiffNode();
                boolean bl4 = bl2 = singleDiffNode != null && object.contains(singleDiffNode) || singleDiffNode2 != null && object.contains(singleDiffNode2);
                if (bl2) {
                    if (singleDiffNode != null) {
                        arrayList5.add(singleDiffNode);
                    }
                    if (singleDiffNode2 != null) {
                        arrayList7.add(singleDiffNode2);
                    }
                    arrayList.add(combinedDiffNode);
                    arrayList3.add(superDiffNode);
                    continue;
                }
                if (singleDiffNode != null) {
                    arrayList6.add(singleDiffNode);
                }
                if (singleDiffNode2 != null) {
                    arrayList8.add(singleDiffNode2);
                }
                arrayList2.add(combinedDiffNode);
                arrayList4.add(superDiffNode);
            } while (true);
        }
        ArrayList<CombinedDiffNode> arrayList = new ArrayList<CombinedDiffNode>();
        ArrayList<CombinedDiffNode> arrayList9 = new ArrayList<CombinedDiffNode>();
        Iterator iterator = this.graphs.getSuperGraph().getNodes().iterator();
        do {
            if (!iterator.hasNext()) {
                this.graphs.getCombinedGraph().selectNodes(arrayList, arrayList9);
                return;
            }
            SuperDiffNode superDiffNode = (SuperDiffNode)iterator.next();
            CombinedDiffNode combinedDiffNode = superDiffNode.getCombinedDiffNode();
            if (object.contains(combinedDiffNode)) {
                arrayList.add(combinedDiffNode);
                continue;
            }
            arrayList9.add(combinedDiffNode);
        } while (true);
    }

    public void selectChildren() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectChildrenOfSelection(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.selectChildrenOfSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.selectChildrenOfSelection(this.graphs.getCombinedGraph());
    }

    public void selectNeighbours() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectNeighboursOfSelection(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.selectNeighboursOfSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.selectNeighboursOfSelection(this.graphs.getCombinedGraph());
    }

    public void selectParents() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectParentsOfSelection(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.selectParentsOfSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.selectParentsOfSelection(this.graphs.getCombinedGraph());
    }

    public void selectSuccessors() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW && !this.settings.isSync()) {
            if (this.settings.getFocus() == ESide.PRIMARY) {
                GraphSelector.selectSuccessorsOfSelection(this.graphs.getPrimaryGraph());
                return;
            }
            GraphSelector.selectSuccessorsOfSelection(this.graphs.getSecondaryGraph());
            return;
        }
        GraphSelector.selectSuccessorsOfSelection(this.graphs.getCombinedGraph());
    }

    public void setCaretIntoJumpToAddressField(ESide eSide) {
        this.viewTabPanel.getToolbar().setCaretIntoJumpToAddressField(eSide);
    }

    public void setCaretIntoSearchField() {
        this.viewTabPanel.getToolbar().setCaretIntoSearchField();
    }

    public void setDefaultNodeColors() {
        Diff diff = this.graphs.getDiff();
        CombinedGraph combinedGraph = this.graphs.getCombinedGraph();
        if (combinedGraph.getGraphType() == EGraphType.CALLGRAPH) {
            Iterator iterator = combinedGraph.getNodes().iterator();
            while (iterator.hasNext()) {
                CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
                ViewCallGraphBuilder.colorizeFunctions((RawCombinedFunction)combinedDiffNode.getRawNode());
            }
            return;
        }
        Iterator iterator = combinedGraph.getNodes().iterator();
        while (iterator.hasNext()) {
            CombinedDiffNode combinedDiffNode = (CombinedDiffNode)iterator.next();
            FunctionMatchData functionMatchData = null;
            RawCombinedBasicBlock rawCombinedBasicBlock = (RawCombinedBasicBlock)combinedDiffNode.getRawNode();
            IAddress iAddress = rawCombinedBasicBlock.getPrimaryFunctionAddress();
            functionMatchData = diff.getMatches().getFunctionMatch(iAddress, ESide.PRIMARY);
            ViewFlowGraphBuilder.colorizeBasicblocks(functionMatchData, rawCombinedBasicBlock);
        }
    }

    public void setViewFocus(ESide eSide) {
        this.settings.setFocusSide(eSide);
    }

    public void showGraphSettingDialog() {
        if (this.settingsDialog == null) {
            this.settingsDialog = new GraphSettingsDialog(this.getMainWindow(), this.getGraphSettings());
        }
        this.settingsDialog.setVisible(true);
    }

    public void showSearchResultsDialog() {
        ViewToolbarPanel viewToolbarPanel = this.viewTabPanel.getToolbar();
        viewToolbarPanel.getSearchResultsDialog().setVisible(true);
    }

    public void switchViewPanel(EDiffViewMode eDiffViewMode) {
        JPanel jPanel = this.getCurrentViewPanel();
        this.viewTabPanel.remove(jPanel);
        this.settings.setDiffViewMode(eDiffViewMode);
        this.viewTabPanel.add((Component)this.getCurrentViewPanel(), "Center");
        this.viewTabPanel.updateUI();
    }

    public void toggleAutoamticLayout() {
        this.settings.getLayoutSettings().setAutomaticLayouting(!this.settings.getLayoutSettings().getAutomaticLayouting());
    }

    public void toggleGraphsPerspective() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            this.viewTabPanel.getNormalViewPanel().toggleGraphsPerspective();
            return;
        }
        if (this.settings.getDiffViewMode() != EDiffViewMode.COMBINED_VIEW) return;
        this.viewTabPanel.getCombinedViewPanel().toggleGraphsPerspective();
    }

    public void toggleGraphSynchronization() {
        if (EGraphSynchronization.SYNC == this.settings.getGraphSyncMode()) {
            this.settings.setGraphSyncMode(EGraphSynchronization.ASYNC);
            return;
        }
        this.settings.setGraphSyncMode(EGraphSynchronization.SYNC);
        GraphLayoutEventHandler.handleReactivateViewSynchronization(this.graphs.getCombinedGraph());
    }

    public void togglePrimaryPerspective() {
        if (this.settings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
        this.viewTabPanel.getNormalViewPanel().togglePrimaryPerspective();
    }

    public void toggleProximityBrowsing() {
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            BinDiffGraph binDiffGraph2 = binDiffGraph = this.settings.getFocus() == ESide.PRIMARY ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph();
        }
        if (!this.settings.getProximitySettings().getProximityBrowsing()) {
            GraphLayoutEventHandler.handleProximityBrowsingActivatedEvent(binDiffGraph);
            return;
        }
        GraphLayoutEventHandler.handleProximityBrowsingDeactivatedEvent(binDiffGraph);
    }

    public void toggleProximityBrowsingFrozen() {
        GraphProximityBrowsingSettings graphProximityBrowsingSettings;
        graphProximityBrowsingSettings.setProximityBrowsingFrozen(!(graphProximityBrowsingSettings = this.settings.getProximitySettings()).getProximityBrowsingFrozen());
        if (!graphProximityBrowsingSettings.getProximityBrowsing()) return;
        if (graphProximityBrowsingSettings.getProximityBrowsingFrozen()) return;
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.isAsync() && this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            binDiffGraph = this.settings.getFocus() == ESide.PRIMARY ? this.graphs.getPrimaryGraph() : this.graphs.getSecondaryGraph();
        }
        GraphLayoutEventHandler.handleSelectionChangedEvent(binDiffGraph, true);
    }

    public void toggleSecondaryPerspective() {
        if (this.settings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
        this.viewTabPanel.getNormalViewPanel().toggleSecondaryPerspective();
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
            Workspace workspace = this.getWorkspace();
            DiffMetaData diffMetaData = this.graphs.getDiff().getMetaData();
            ViewData viewData = this.viewTabPanel.getView();
            String string = diffMetaData.getImageHash(ESide.PRIMARY);
            String string2 = diffMetaData.getImageHash(ESide.SECONDARY);
            CommentsWriter.writeComments(workspace, string, string2, viewData);
            return;
        }
        catch (SQLException var1_2) {
            Logger.logException(var1_2, "Couldn't save view comments.");
            String string = String.valueOf(var1_2.getMessage());
            CMessageBox.showError(this.getMainWindow(), string.length() != 0 ? "Couldn't save view comments: ".concat(string) : new String("Couldn't save view comments: "));
        }
    }

    public void writeFlowgraphMatches() {
        if (!this.hasChangedMatches) {
            return;
        }
        Diff diff = this.graphs.getDiff();
        FlowGraphViewData flowGraphViewData = (FlowGraphViewData)this.viewTabPanel.getView();
        FunctionMatchData functionMatchData = diff.getMatches().getFunctionMatch(flowGraphViewData.getAddress(ESide.PRIMARY), ESide.PRIMARY);
        try {
            MatchesDatabase matchesDatabase = new MatchesDatabase(diff.getMatchesDatabase());
            Throwable throwable = null;
            try {
                matchesDatabase.updateFunctionMatch(functionMatchData.getAddress(ESide.PRIMARY), functionMatchData.getAddress(ESide.SECONDARY), functionMatchData);
                return;
            }
            catch (Throwable var6_8) {
                throwable = var6_8;
                throw var6_8;
            }
            finally {
                if (matchesDatabase != null) {
                    if (throwable != null) {
                        try {
                            matchesDatabase.close();
                        }
                        catch (Throwable var6_7) {
                            throwable.addSuppressed(var6_7);
                        }
                    } else {
                        matchesDatabase.close();
                    }
                }
            }
        }
        catch (SQLException var4_5) {
            Logger.logException(var4_5, "Couldn't save changed basic block matches.");
            String string = String.valueOf(var4_5.getMessage());
            CMessageBox.showError(this.getMainWindow(), string.length() != 0 ? "Couldn't save changed basic block matches.".concat(string) : new String("Couldn't save changed basic block matches."));
        }
    }

    public void zoom(boolean bl2) {
        BinDiffGraph binDiffGraph = this.graphs.getCombinedGraph();
        if (this.settings.getDiffViewMode() == EDiffViewMode.NORMAL_VIEW) {
            binDiffGraph = this.graphs.getPrimaryGraph();
            if (!this.settings.isSync() && this.settings.getFocus() == ESide.SECONDARY) {
                binDiffGraph = this.graphs.getSecondaryGraph();
            }
        }
        if (bl2) {
            binDiffGraph.zoomIn();
            return;
        }
        binDiffGraph.zoomOut();
    }

    public void zoomToSelectedNodes() {
        if (this.settings.getDiffViewMode() == EDiffViewMode.COMBINED_VIEW) {
            GraphZoomer.zoomToNodes(this.graphs.getCombinedGraph(), (Collection)this.graphs.getCombinedGraph().getSelectedNodes());
            return;
        }
        if (this.settings.getDiffViewMode() != EDiffViewMode.NORMAL_VIEW) return;
        GraphZoomer.zoomToNodes(this.graphs.getSuperGraph(), (Collection)this.graphs.getSuperGraph().getSelectedNodes());
    }

    static /* synthetic */ void access$100(ViewTabPanelFunctions viewTabPanelFunctions, boolean bl2) {
        viewTabPanelFunctions.setCommentsChanged(bl2);
    }
}

