/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.ITreeSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.TreeSearchFieldCombo;
import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.GraphNodeTreeOptionsDialog;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.CombinedCallGraphTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.CombinedFlowGraphTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.SingleCallGraphTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.SingleFlowGraphTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractRootTreeNode;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalClearButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalOptionsButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalSearchFieldListener;
import com.google.security.zynamics.bindiff.gui.window.MainWindow;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import com.google.security.zynamics.zylib.types.graphs.MutableDirectedGraph;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.TreeNode;

public class GraphNodeTreePanel
extends JPanel {
    private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
    private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
    private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    private final TreeSearchFieldCombo filterCombo = new TreeSearchFieldCombo();
    private final JButton clearButton = new JButton(ICON_CLEAR_GRAY);
    private final JButton optionsButton = new JButton(ICON_OPTIONS);
    private final GraphNodeTreePanel$InternalClearButtonListener clearButtonListener;
    private final GraphNodeTreePanel$InternalOptionsButtonListener optionsButtonAction;
    private final GraphNodeTreePanel$InternalSearchFieldListener searchComboListener;
    private final GraphNodeTreeOptionsDialog optionsDialog;
    private AbstractGraphNodeTree tree;

    public GraphNodeTreePanel(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, CombinedGraph combinedGraph) {
        super(new BorderLayout());
        this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, null);
        this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, null);
        this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, null);
        this.optionsDialog = this.createOptionsDialog((Window)viewTabPanelFunctions.getMainWindow(), combinedGraph);
        this.tree = this.createCombinedTree(viewTabPanelFunctions, diff, viewData, combinedGraph);
        this.init();
    }

    public GraphNodeTreePanel(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, SingleGraph singleGraph) {
        super(new BorderLayout());
        this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, null);
        this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, null);
        this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, null);
        this.optionsDialog = this.createOptionsDialog((Window)viewTabPanelFunctions.getMainWindow(), singleGraph);
        this.tree = this.createSingleTree(viewTabPanelFunctions, diff, viewData, singleGraph);
        this.init();
    }

    private void addListeners() {
        this.filterCombo.addListener(this.searchComboListener);
        this.optionsButton.addActionListener(this.optionsButtonAction);
        this.clearButton.addActionListener(this.clearButtonListener);
    }

    private AbstractGraphNodeTree createCombinedTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, CombinedGraph combinedGraph) {
        TreeNodeSearcher treeNodeSearcher = this.createDefaultTreeSearcher();
        GraphNodeMultiFilter graphNodeMultiFilter = this.createDefaultMultiFilter(diff, viewData);
        TreeNodeMultiSorter treeNodeMultiSorter = this.createDefaultMultiSorter();
        if (combinedGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return new CombinedCallGraphTree(viewTabPanelFunctions, diff, viewData, combinedGraph, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        }
        if (combinedGraph.getGraphType() != EGraphType.FLOWGRAPH) throw new IllegalStateException("Combined graph node tree cannot be null.");
        return new CombinedFlowGraphTree(viewTabPanelFunctions, diff, viewData, combinedGraph, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
    }

    private GraphNodeMultiFilter createDefaultMultiFilter(Diff diff, ViewData viewData) {
        RawFlowGraph rawFlowGraph = null;
        RawFlowGraph rawFlowGraph2 = null;
        if (!viewData.isFlowgraphView()) return new GraphNodeMultiFilter(diff, rawFlowGraph, rawFlowGraph2, new CAddress(0), new CAddress(-1), EMatchStateFilter.NONE, ESelectionFilter.NONE, EVisibilityFilter.NONE, ESideFilter.NONE);
        rawFlowGraph = (RawFlowGraph)viewData.getRawGraph(ESide.PRIMARY);
        rawFlowGraph2 = (RawFlowGraph)viewData.getRawGraph(ESide.SECONDARY);
        return new GraphNodeMultiFilter(diff, rawFlowGraph, rawFlowGraph2, new CAddress(0), new CAddress(-1), EMatchStateFilter.NONE, ESelectionFilter.NONE, EVisibilityFilter.NONE, ESideFilter.NONE);
    }

    private TreeNodeMultiSorter createDefaultMultiSorter() {
        TreeNodeMultiSorter treeNodeMultiSorter = new TreeNodeMultiSorter();
        int n2 = 0;
        while (n2 < 5) {
            ESortByCriterium eSortByCriterium = this.optionsDialog.getSortByCriterium(n2);
            ESortOrder eSortOrder = this.optionsDialog.getSortOrder(n2);
            treeNodeMultiSorter.setCriterium(eSortByCriterium, eSortOrder, n2, false);
            ++n2;
        }
        return treeNodeMultiSorter;
    }

    private TreeNodeSearcher createDefaultTreeSearcher() {
        return new TreeNodeSearcher(false, false, true, true, false, false);
    }

    private GraphNodeTreeOptionsDialog createOptionsDialog(Window window, CombinedGraph combinedGraph) {
        boolean bl2 = combinedGraph.getGraphType() == EGraphType.CALLGRAPH;
        GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog = new GraphNodeTreeOptionsDialog(window, "Combined Tree Options", bl2, true);
        GuiHelper.centerChildToParent(window, graphNodeTreeOptionsDialog, true);
        return graphNodeTreeOptionsDialog;
    }

    private GraphNodeTreeOptionsDialog createOptionsDialog(Window window, SingleGraph singleGraph) {
        boolean bl2 = singleGraph.getGraphType() == EGraphType.CALLGRAPH;
        String string = "Primary Tree Options";
        String string2 = "Secondary Tree Options";
        ESide eSide = singleGraph.getSide();
        GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog = new GraphNodeTreeOptionsDialog(window, eSide == ESide.PRIMARY ? string : string2, bl2, false);
        GuiHelper.centerChildToParent(window, graphNodeTreeOptionsDialog, true);
        return graphNodeTreeOptionsDialog;
    }

    private AbstractGraphNodeTree createSingleTree(ViewTabPanelFunctions viewTabPanelFunctions, Diff diff, ViewData viewData, SingleGraph singleGraph) {
        TreeNodeSearcher treeNodeSearcher = this.createDefaultTreeSearcher();
        GraphNodeMultiFilter graphNodeMultiFilter = this.createDefaultMultiFilter(diff, viewData);
        TreeNodeMultiSorter treeNodeMultiSorter = this.createDefaultMultiSorter();
        if (singleGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return new SingleCallGraphTree(viewTabPanelFunctions, diff, viewData, singleGraph, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
        }
        if (singleGraph.getGraphType() != EGraphType.FLOWGRAPH) throw new IllegalStateException("Single graph node tree cannot be null.");
        return new SingleFlowGraphTree(viewTabPanelFunctions, diff, viewData, singleGraph, treeNodeSearcher, graphNodeMultiFilter, treeNodeMultiSorter);
    }

    private void init() {
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.addListeners();
        this.setBorder(new LineBorder(Color.GRAY));
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBackground(Color.WHITE);
        jPanel.setBorder(new EmptyBorder(1, 1, 0, 0));
        JPanel jPanel2 = new JPanel(new BorderLayout());
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setBorder(new EmptyBorder(0, 0, 1, 1));
        jPanel2.add((Component)this.filterCombo, "Center");
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
        JPanel jPanel3 = new JPanel(new BorderLayout());
        jPanel3.setBorder(new EmptyBorder(0, 1, 0, 0));
        jPanel3.add((Component)this.clearButton, "Center");
        jPanel2.add((Component)jPanel3, "East");
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.optionsButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
        JPanel jPanel4 = new JPanel(new BorderLayout());
        jPanel4.setBorder(new EmptyBorder(0, 1, 0, 0));
        jPanel4.add((Component)this.optionsButton, "East");
        jPanel3.add((Component)jPanel4, "East");
        this.filterCombo.setBackground(Color.WHITE);
        this.filterCombo.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.tree.setBorder(new EmptyBorder(1, 1, 1, 1));
        jPanel.add((Component)jPanel2, "North");
        JScrollPane jScrollPane = new JScrollPane(this.tree);
        jPanel.add((Component)jScrollPane, "Center");
        this.add((Component)jPanel, "Center");
    }

    public void dispose() {
        if (this.tree instanceof SingleCallGraphTree) {
            ((SingleCallGraphTree)this.tree).dispose();
        } else if (this.tree instanceof SingleFlowGraphTree) {
            ((SingleFlowGraphTree)this.tree).dispose();
        } else if (this.tree instanceof CombinedCallGraphTree) {
            ((CombinedCallGraphTree)this.tree).dispose();
        } else if (this.tree instanceof CombinedFlowGraphTree) {
            ((CombinedFlowGraphTree)this.tree).dispose();
        }
        this.optionsDialog.dispose();
        this.filterCombo.removeListener(this.searchComboListener);
        this.optionsButton.removeActionListener(this.optionsButtonAction);
        this.clearButton.removeActionListener(this.clearButtonListener);
        this.tree = null;
    }

    public AbstractGraphNodeTree getTree() {
        return this.tree;
    }

    public void updateClearTreeSearchIcons() {
        this.clearButton.setIcon(ICON_CLEAR);
        TreeNode treeNode = this.getTree().getRootNode().getFirstChild();
        if (treeNode == null) return;
        if (treeNode.getChildCount() != this.getTree().getGraph().getNodes().size()) return;
        this.clearButton.setIcon(ICON_CLEAR_GRAY);
    }

    static /* synthetic */ AbstractGraphNodeTree access$300(GraphNodeTreePanel graphNodeTreePanel) {
        return graphNodeTreePanel.tree;
    }

    static /* synthetic */ GraphNodeTreeOptionsDialog access$400(GraphNodeTreePanel graphNodeTreePanel) {
        return graphNodeTreePanel.optionsDialog;
    }

    static /* synthetic */ TreeSearchFieldCombo access$500(GraphNodeTreePanel graphNodeTreePanel) {
        return graphNodeTreePanel.filterCombo;
    }

    static /* synthetic */ ImageIcon access$600() {
        return ICON_CLEAR_GRAY;
    }

    static /* synthetic */ JButton access$700(GraphNodeTreePanel graphNodeTreePanel) {
        return graphNodeTreePanel.clearButton;
    }

    static /* synthetic */ JButton access$800(GraphNodeTreePanel graphNodeTreePanel) {
        return graphNodeTreePanel.optionsButton;
    }
}

