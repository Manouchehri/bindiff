package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels;

import com.google.security.zynamics.bindiff.enums.EGraphType;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.enums.ESortByCriterium;
import com.google.security.zynamics.bindiff.enums.ESortOrder;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EMatchStateFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESelectionFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.ESideFilter;
import com.google.security.zynamics.bindiff.graph.filter.enums.EVisibilityFilter;
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
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$1;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalClearButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalOptionsButtonListener;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.subpanels.GraphNodeTreePanel$InternalSearchFieldListener;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.rawflowgraph.RawFlowGraph;
import com.google.security.zynamics.bindiff.project.userview.ViewData;
import com.google.security.zynamics.bindiff.utils.ImageUtils;
import com.google.security.zynamics.zylib.disassembly.CAddress;
import com.google.security.zynamics.zylib.gui.GuiHelper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.TreeNode;

public class GraphNodeTreePanel extends JPanel {
   private static final ImageIcon ICON_OPTIONS = ImageUtils.getImageIcon("data/buttonicons/options.png");
   private static final ImageIcon ICON_CLEAR = ImageUtils.getImageIcon("data/buttonicons/clear.png");
   private static final ImageIcon ICON_CLEAR_GRAY = ImageUtils.getImageIcon("data/buttonicons/clear-gray.png");
   private final TreeSearchFieldCombo filterCombo = new TreeSearchFieldCombo();
   private final JButton clearButton;
   private final JButton optionsButton;
   private final GraphNodeTreePanel$InternalClearButtonListener clearButtonListener;
   private final GraphNodeTreePanel$InternalOptionsButtonListener optionsButtonAction;
   private final GraphNodeTreePanel$InternalSearchFieldListener searchComboListener;
   private final GraphNodeTreeOptionsDialog optionsDialog;
   private AbstractGraphNodeTree tree;

   public GraphNodeTreePanel(ViewTabPanelFunctions var1, Diff var2, ViewData var3, CombinedGraph var4) {
      super(new BorderLayout());
      this.clearButton = new JButton(ICON_CLEAR_GRAY);
      this.optionsButton = new JButton(ICON_OPTIONS);
      this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, (GraphNodeTreePanel$1)null);
      this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, (GraphNodeTreePanel$1)null);
      this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, (GraphNodeTreePanel$1)null);
      this.optionsDialog = this.createOptionsDialog(var1.getMainWindow(), (CombinedGraph)var4);
      this.tree = this.createCombinedTree(var1, var2, var3, var4);
      this.init();
   }

   public GraphNodeTreePanel(ViewTabPanelFunctions var1, Diff var2, ViewData var3, SingleGraph var4) {
      super(new BorderLayout());
      this.clearButton = new JButton(ICON_CLEAR_GRAY);
      this.optionsButton = new JButton(ICON_OPTIONS);
      this.clearButtonListener = new GraphNodeTreePanel$InternalClearButtonListener(this, (GraphNodeTreePanel$1)null);
      this.optionsButtonAction = new GraphNodeTreePanel$InternalOptionsButtonListener(this, (GraphNodeTreePanel$1)null);
      this.searchComboListener = new GraphNodeTreePanel$InternalSearchFieldListener(this, (GraphNodeTreePanel$1)null);
      this.optionsDialog = this.createOptionsDialog(var1.getMainWindow(), (SingleGraph)var4);
      this.tree = this.createSingleTree(var1, var2, var3, var4);
      this.init();
   }

   private void addListeners() {
      this.filterCombo.addListener(this.searchComboListener);
      this.optionsButton.addActionListener(this.optionsButtonAction);
      this.clearButton.addActionListener(this.clearButtonListener);
   }

   private AbstractGraphNodeTree createCombinedTree(ViewTabPanelFunctions var1, Diff var2, ViewData var3, CombinedGraph var4) {
      TreeNodeSearcher var5 = this.createDefaultTreeSearcher();
      GraphNodeMultiFilter var6 = this.createDefaultMultiFilter(var2, var3);
      TreeNodeMultiSorter var7 = this.createDefaultMultiSorter();
      if(var4.getGraphType() == EGraphType.CALLGRAPH) {
         return new CombinedCallGraphTree(var1, var2, var3, var4, var5, var6, var7);
      } else if(var4.getGraphType() == EGraphType.FLOWGRAPH) {
         return new CombinedFlowGraphTree(var1, var2, var3, var4, var5, var6, var7);
      } else {
         throw new IllegalStateException("Combined graph node tree cannot be null.");
      }
   }

   private GraphNodeMultiFilter createDefaultMultiFilter(Diff var1, ViewData var2) {
      RawFlowGraph var3 = null;
      RawFlowGraph var4 = null;
      if(var2.isFlowgraphView()) {
         var3 = (RawFlowGraph)var2.getRawGraph(ESide.PRIMARY);
         var4 = (RawFlowGraph)var2.getRawGraph(ESide.SECONDARY);
      }

      return new GraphNodeMultiFilter(var1, var3, var4, new CAddress(0L), new CAddress(-1L), EMatchStateFilter.NONE, ESelectionFilter.NONE, EVisibilityFilter.NONE, ESideFilter.NONE);
   }

   private TreeNodeMultiSorter createDefaultMultiSorter() {
      TreeNodeMultiSorter var1 = new TreeNodeMultiSorter();

      for(int var2 = 0; var2 < 5; ++var2) {
         ESortByCriterium var3 = this.optionsDialog.getSortByCriterium(var2);
         ESortOrder var4 = this.optionsDialog.getSortOrder(var2);
         var1.setCriterium(var3, var4, var2, false);
      }

      return var1;
   }

   private TreeNodeSearcher createDefaultTreeSearcher() {
      return new TreeNodeSearcher(false, false, true, true, false, false);
   }

   private GraphNodeTreeOptionsDialog createOptionsDialog(Window var1, CombinedGraph var2) {
      boolean var3 = var2.getGraphType() == EGraphType.CALLGRAPH;
      GraphNodeTreeOptionsDialog var4 = new GraphNodeTreeOptionsDialog(var1, "Combined Tree Options", var3, true);
      GuiHelper.centerChildToParent(var1, var4, true);
      return var4;
   }

   private GraphNodeTreeOptionsDialog createOptionsDialog(Window var1, SingleGraph var2) {
      boolean var3 = var2.getGraphType() == EGraphType.CALLGRAPH;
      String var4 = "Primary Tree Options";
      String var5 = "Secondary Tree Options";
      ESide var6 = var2.getSide();
      GraphNodeTreeOptionsDialog var7 = new GraphNodeTreeOptionsDialog(var1, var6 == ESide.PRIMARY?var4:var5, var3, false);
      GuiHelper.centerChildToParent(var1, var7, true);
      return var7;
   }

   private AbstractGraphNodeTree createSingleTree(ViewTabPanelFunctions var1, Diff var2, ViewData var3, SingleGraph var4) {
      TreeNodeSearcher var5 = this.createDefaultTreeSearcher();
      GraphNodeMultiFilter var6 = this.createDefaultMultiFilter(var2, var3);
      TreeNodeMultiSorter var7 = this.createDefaultMultiSorter();
      if(var4.getGraphType() == EGraphType.CALLGRAPH) {
         return new SingleCallGraphTree(var1, var2, var3, var4, var5, var6, var7);
      } else if(var4.getGraphType() == EGraphType.FLOWGRAPH) {
         return new SingleFlowGraphTree(var1, var2, var3, var4, var5, var6, var7);
      } else {
         throw new IllegalStateException("Single graph node tree cannot be null.");
      }
   }

   private void init() {
      this.clearButton.setToolTipText("Clear Search Results");
      this.optionsButton.setToolTipText("Search Settings");
      this.addListeners();
      this.setBorder(new LineBorder(Color.GRAY));
      JPanel var1 = new JPanel(new BorderLayout());
      var1.setBackground(Color.WHITE);
      var1.setBorder(new EmptyBorder(1, 1, 0, 0));
      JPanel var2 = new JPanel(new BorderLayout());
      var2.setBackground(Color.WHITE);
      var2.setBorder(new EmptyBorder(0, 0, 1, 1));
      var2.add(this.filterCombo, "Center");
      this.clearButton.setBackground(Color.WHITE);
      this.clearButton.setFocusable(false);
      this.clearButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
      JPanel var3 = new JPanel(new BorderLayout());
      var3.setBorder(new EmptyBorder(0, 1, 0, 0));
      var3.add(this.clearButton, "Center");
      var2.add(var3, "East");
      this.optionsButton.setBackground(Color.WHITE);
      this.optionsButton.setFocusable(false);
      this.optionsButton.setPreferredSize(new Dimension(32, this.filterCombo.getPreferredSize().height));
      JPanel var4 = new JPanel(new BorderLayout());
      var4.setBorder(new EmptyBorder(0, 1, 0, 0));
      var4.add(this.optionsButton, "East");
      var3.add(var4, "East");
      this.filterCombo.setBackground(Color.WHITE);
      this.filterCombo.setBorder(new EmptyBorder(0, 0, 0, 0));
      this.tree.setBorder(new EmptyBorder(1, 1, 1, 1));
      var1.add(var2, "North");
      JScrollPane var5 = new JScrollPane(this.tree);
      var1.add(var5, "Center");
      this.add(var1, "Center");
   }

   public void dispose() {
      if(this.tree instanceof SingleCallGraphTree) {
         ((SingleCallGraphTree)this.tree).dispose();
      } else if(this.tree instanceof SingleFlowGraphTree) {
         ((SingleFlowGraphTree)this.tree).dispose();
      } else if(this.tree instanceof CombinedCallGraphTree) {
         ((CombinedCallGraphTree)this.tree).dispose();
      } else if(this.tree instanceof CombinedFlowGraphTree) {
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
      TreeNode var1 = this.getTree().getRootNode().getFirstChild();
      if(var1 != null && var1.getChildCount() == this.getTree().getGraph().getNodes().size()) {
         this.clearButton.setIcon(ICON_CLEAR_GRAY);
      }

   }

   // $FF: synthetic method
   static AbstractGraphNodeTree access$300(GraphNodeTreePanel var0) {
      return var0.tree;
   }

   // $FF: synthetic method
   static GraphNodeTreeOptionsDialog access$400(GraphNodeTreePanel var0) {
      return var0.optionsDialog;
   }

   // $FF: synthetic method
   static TreeSearchFieldCombo access$500(GraphNodeTreePanel var0) {
      return var0.filterCombo;
   }

   // $FF: synthetic method
   static ImageIcon access$600() {
      return ICON_CLEAR_GRAY;
   }

   // $FF: synthetic method
   static JButton access$700(GraphNodeTreePanel var0) {
      return var0.clearButton;
   }

   // $FF: synthetic method
   static JButton access$800(GraphNodeTreePanel var0) {
      return var0.optionsButton;
   }
}
