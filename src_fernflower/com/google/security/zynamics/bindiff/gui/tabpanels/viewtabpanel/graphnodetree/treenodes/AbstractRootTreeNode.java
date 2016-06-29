package com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.filter.GraphNodeMultiFilter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.ViewTabPanelFunctions;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.AbstractGraphNodeTree;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.searcher.TreeNodeSearcher;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.sorter.TreeNodeMultiSorter;
import com.google.security.zynamics.bindiff.gui.tabpanels.viewtabpanel.graphnodetree.treenodes.AbstractTreeNode;
import com.google.security.zynamics.bindiff.project.diff.Diff;
import com.google.security.zynamics.bindiff.project.userview.ViewData;

public abstract class AbstractRootTreeNode extends AbstractTreeNode {
   private final ViewTabPanelFunctions controller;
   private Diff diff;
   private ViewData view;
   private TreeNodeSearcher searcher;
   private GraphNodeMultiFilter filter;
   private AbstractGraphNodeTree tree;
   private TreeNodeMultiSorter sorter;

   public AbstractRootTreeNode(ViewTabPanelFunctions var1, AbstractGraphNodeTree var2, Diff var3, ViewData var4, TreeNodeSearcher var5, GraphNodeMultiFilter var6, TreeNodeMultiSorter var7) {
      super((AbstractRootTreeNode)null);
      this.controller = (ViewTabPanelFunctions)Preconditions.checkNotNull(var1);
      this.tree = (AbstractGraphNodeTree)Preconditions.checkNotNull(var2);
      this.view = (ViewData)Preconditions.checkNotNull(var4);
      this.searcher = (TreeNodeSearcher)Preconditions.checkNotNull(var5);
      this.filter = (GraphNodeMultiFilter)Preconditions.checkNotNull(var6);
      this.sorter = (TreeNodeMultiSorter)Preconditions.checkNotNull(var7);
      this.diff = var3;
   }

   protected Diff getDiff() {
      return this.diff;
   }

   public void dispose() {
      this.delete();
      this.searcher = null;
      this.filter = null;
      this.sorter = null;
      this.view = null;
      this.tree = null;
      this.diff = null;
   }

   public ViewTabPanelFunctions getController() {
      return this.controller;
   }

   public GraphNodeMultiFilter getFilter() {
      return this.filter;
   }

   public TreeNodeSearcher getSearcher() {
      return this.searcher;
   }

   public abstract ESide getSide();

   public TreeNodeMultiSorter getSorter() {
      return this.sorter;
   }

   public AbstractGraphNodeTree getTree() {
      return this.tree;
   }

   public ViewData getView() {
      return this.view;
   }
}
