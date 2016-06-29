package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.gui.dialogs.graphnodetreeoptionsdialog.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.project.userview.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.gui.components.treesearchfield.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.*;
import com.google.security.zynamics.bindiff.graph.filter.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.*;
import com.google.security.zynamics.bindiff.project.rawflowgraph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.filter.enums.*;
import com.google.security.zynamics.zylib.disassembly.*;
import com.google.security.zynamics.zylib.gui.*;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.*;
import javax.swing.border.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.utils.*;

public class GraphNodeTreePanel extends JPanel
{
    private static final ImageIcon ICON_OPTIONS;
    private static final ImageIcon ICON_CLEAR;
    private static final ImageIcon ICON_CLEAR_GRAY;
    private final TreeSearchFieldCombo filterCombo;
    private final JButton clearButton;
    private final JButton optionsButton;
    private final GraphNodeTreePanel$InternalClearButtonListener clearButtonListener;
    private final GraphNodeTreePanel$InternalOptionsButtonListener optionsButtonAction;
    private final GraphNodeTreePanel$InternalSearchFieldListener searchComboListener;
    private final GraphNodeTreeOptionsDialog optionsDialog;
    private AbstractGraphNodeTree tree;
    
    public GraphNodeTreePanel(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final CombinedGraph combinedGraph) {
        super(new BorderLayout());
        this.filterCombo = new TreeSearchFieldCombo();
        this.clearButton = new JButton(GraphNodeTreePanel.ICON_CLEAR_GRAY);
        this.optionsButton = new JButton(GraphNodeTreePanel.ICON_OPTIONS);
        this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, null);
        this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, null);
        this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, null);
        this.optionsDialog = this.createOptionsDialog(viewTabPanelFunctions.getMainWindow(), combinedGraph);
        this.tree = this.createCombinedTree(viewTabPanelFunctions, diff, viewData, combinedGraph);
        this.init();
    }
    
    public GraphNodeTreePanel(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final SingleGraph singleGraph) {
        super(new BorderLayout());
        this.filterCombo = new TreeSearchFieldCombo();
        this.clearButton = new JButton(GraphNodeTreePanel.ICON_CLEAR_GRAY);
        this.optionsButton = new JButton(GraphNodeTreePanel.ICON_OPTIONS);
        this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, null);
        this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, null);
        this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, null);
        this.optionsDialog = this.createOptionsDialog(viewTabPanelFunctions.getMainWindow(), singleGraph);
        this.tree = this.createSingleTree(viewTabPanelFunctions, diff, viewData, singleGraph);
        this.init();
    }
    
    private void addListeners() {
        this.filterCombo.addListener(this.searchComboListener);
        this.optionsButton.addActionListener(this.optionsButtonAction);
        this.clearButton.addActionListener(this.clearButtonListener);
    }
    
    private AbstractGraphNodeTree createCombinedTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final CombinedGraph combinedGraph) {
        final TreeNodeSearcher defaultTreeSearcher = this.createDefaultTreeSearcher();
        final GraphNodeMultiFilter defaultMultiFilter = this.createDefaultMultiFilter(diff, viewData);
        final TreeNodeMultiSorter defaultMultiSorter = this.createDefaultMultiSorter();
        if (combinedGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return new CombinedCallGraphTree(viewTabPanelFunctions, diff, viewData, combinedGraph, defaultTreeSearcher, defaultMultiFilter, defaultMultiSorter);
        }
        if (combinedGraph.getGraphType() == EGraphType.FLOWGRAPH) {
            return new CombinedFlowGraphTree(viewTabPanelFunctions, diff, viewData, combinedGraph, defaultTreeSearcher, defaultMultiFilter, defaultMultiSorter);
        }
        throw new IllegalStateException("Combined graph node tree cannot be null.");
    }
    
    private GraphNodeMultiFilter createDefaultMultiFilter(final Diff diff, final ViewData viewData) {
        RawFlowGraph rawFlowGraph = null;
        RawFlowGraph rawFlowGraph2 = null;
        if (viewData.isFlowgraphView()) {
            rawFlowGraph = (RawFlowGraph)viewData.getRawGraph(ESide.PRIMARY);
            rawFlowGraph2 = (RawFlowGraph)viewData.getRawGraph(ESide.SECONDARY);
        }
        return new GraphNodeMultiFilter(diff, rawFlowGraph, rawFlowGraph2, new CAddress(0L), new CAddress(-1L), EMatchStateFilter.NONE, ESelectionFilter.NONE, EVisibilityFilter.NONE, ESideFilter.NONE);
    }
    
    private TreeNodeMultiSorter createDefaultMultiSorter() {
        final TreeNodeMultiSorter treeNodeMultiSorter = new TreeNodeMultiSorter();
        for (int i = 0; i < 5; ++i) {
            treeNodeMultiSorter.setCriterium(this.optionsDialog.getSortByCriterium(i), this.optionsDialog.getSortOrder(i), i, false);
        }
        return treeNodeMultiSorter;
    }
    
    private TreeNodeSearcher createDefaultTreeSearcher() {
        return new TreeNodeSearcher(false, false, true, true, false, false);
    }
    
    private GraphNodeTreeOptionsDialog createOptionsDialog(final Window window, final CombinedGraph combinedGraph) {
        final GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog = new GraphNodeTreeOptionsDialog(window, "Combined Tree Options", combinedGraph.getGraphType() == EGraphType.CALLGRAPH, true);
        GuiHelper.centerChildToParent(window, graphNodeTreeOptionsDialog, true);
        return graphNodeTreeOptionsDialog;
    }
    
    private GraphNodeTreeOptionsDialog createOptionsDialog(final Window window, final SingleGraph singleGraph) {
        final boolean b = singleGraph.getGraphType() == EGraphType.CALLGRAPH;
        final String s = "Primary Tree Options";
        final String s2 = "Secondary Tree Options";
        final GraphNodeTreeOptionsDialog graphNodeTreeOptionsDialog = new GraphNodeTreeOptionsDialog(window, (singleGraph.getSide() == ESide.PRIMARY) ? s : s2, b, false);
        GuiHelper.centerChildToParent(window, graphNodeTreeOptionsDialog, true);
        return graphNodeTreeOptionsDialog;
    }
    
    private AbstractGraphNodeTree createSingleTree(final ViewTabPanelFunctions viewTabPanelFunctions, final Diff diff, final ViewData viewData, final SingleGraph singleGraph) {
        final TreeNodeSearcher defaultTreeSearcher = this.createDefaultTreeSearcher();
        final GraphNodeMultiFilter defaultMultiFilter = this.createDefaultMultiFilter(diff, viewData);
        final TreeNodeMultiSorter defaultMultiSorter = this.createDefaultMultiSorter();
        if (singleGraph.getGraphType() == EGraphType.CALLGRAPH) {
            return new SingleCallGraphTree(viewTabPanelFunctions, diff, viewData, singleGraph, defaultTreeSearcher, defaultMultiFilter, defaultMultiSorter);
        }
        if (singleGraph.getGraphType() == EGraphType.FLOWGRAPH) {
            return new SingleFlowGraphTree(viewTabPanelFunctions, diff, viewData, singleGraph, defaultTreeSearcher, defaultMultiFilter, defaultMultiSorter);
        }
        throw new IllegalStateException("Single graph node tree cannot be null.");
    }
    
    private void init() {
        this.clearButton.setToolTipText("Clear Search Results");
        this.optionsButton.setToolTipText("Search Settings");
        this.addListeners();
        this.setBorder(new LineBorder(Color.GRAY));
        final JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(1, 1, 0, 0));
        final JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBackground(Color.WHITE);
        panel2.setBorder(new EmptyBorder(0, 0, 1, 1));
        panel2.add(this.filterCombo, "Center");
        this.clearButton.setBackground(Color.WHITE);
        this.clearButton.setFocusable(false);
        this.clearButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
        final JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new EmptyBorder(0, 1, 0, 0));
        panel3.add(this.clearButton, "Center");
        panel2.add(panel3, "East");
        this.optionsButton.setBackground(Color.WHITE);
        this.optionsButton.setFocusable(false);
        this.optionsButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
        final JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(new EmptyBorder(0, 1, 0, 0));
        panel4.add(this.optionsButton, "East");
        panel3.add(panel4, "East");
        this.filterCombo.setBackground(Color.WHITE);
        this.filterCombo.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.tree.setBorder(new EmptyBorder(1, 1, 1, 1));
        panel.add(panel2, "North");
        panel.add(new JScrollPane(this.tree), "Center");
        this.add(panel, "Center");
    }
    
    public void dispose() {
        if (this.tree instanceof SingleCallGraphTree) {
            ((SingleCallGraphTree)this.tree).dispose();
        }
        else if (this.tree instanceof SingleFlowGraphTree) {
            ((SingleFlowGraphTree)this.tree).dispose();
        }
        else if (this.tree instanceof CombinedCallGraphTree) {
            ((CombinedCallGraphTree)this.tree).dispose();
        }
        else if (this.tree instanceof CombinedFlowGraphTree) {
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
        this.clearButton.setIcon(GraphNodeTreePanel.ICON_CLEAR);
        final TreeNode firstChild = this.getTree().getRootNode().getFirstChild();
        if (firstChild != null && firstChild.getChildCount() == this.getTree().getGraph().getNodes().size()) {
            this.clearButton.setIcon(GraphNodeTreePanel.ICON_CLEAR_GRAY);
        }
    }
    
    static {
        ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
        ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
        ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
    }
}
