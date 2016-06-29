package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.zygraph.functions.IteratorFunctions;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$1;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$10;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$11;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$12;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$13;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$14;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$2;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$3;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$4;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$5;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$6;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$7;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$8;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers$9;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeFilter;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.ISelectableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IViewableNode;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IZoomableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.StandardFilters;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.types.common.IFilteredItemCallback;
import com.google.security.zynamics.zylib.types.common.IIterableCollection;
import com.google.security.zynamics.zylib.types.graphs.GraphAlgorithms;
import com.google.security.zynamics.zylib.types.graphs.IGraphNode;
import com.google.security.zynamics.zylib.types.lists.FilledList;
import com.google.security.zynamics.zylib.types.lists.IFilledList;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GraphHelpers {
   public static boolean any(IIterableGraph var0, INodeFilter var1) {
      ArrayList var2 = new ArrayList();
      var0.iterate(new GraphHelpers$1(var1, var2));
      return var2.size() != 0;
   }

   public static boolean areAllChildrenDeselected(IGraphNode var0) {
      INodeFilter var1 = StandardFilters.getSelectedFilter();
      return GraphAlgorithms.collectChildren(var0, var1).size() == 0;
   }

   public static boolean areAllParentsDeselected(IGraphNode var0) {
      INodeFilter var1 = StandardFilters.getSelectedFilter();
      return GraphAlgorithms.collectParents(var0, var1).size() == 0;
   }

   public static Rectangle2D calculateBoundingBox(Collection var0) {
      Preconditions.checkNotNull(var0, "Node list argument can\'t be null");
      Preconditions.checkArgument(var0.size() != 0, "Node list argument can\'t be empty");
      Double var1 = new Double();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         IViewableNode var3 = (IViewableNode)var2.next();
         var3.calcUnionRect(var1);
      }

      return var1;
   }

   public static void expandSelectionDown(ISelectableGraph var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      ArrayList var1 = new ArrayList();
      INodeFilter var2 = StandardFilters.getDeselectedFilter();
      var0.iterateSelected(new GraphHelpers$2(var1, var2));
      var0.selectNodes(var1, true);
   }

   public static void expandSelectionUp(ISelectableGraph var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      ArrayList var1 = new ArrayList();
      INodeFilter var2 = StandardFilters.getDeselectedFilter();
      var0.iterateSelected(new GraphHelpers$3(var1, var2));
      var0.selectNodes(var1, true);
   }

   public static List filter(IIterableCollection var0, ICollectionFilter var1) {
      ArrayList var2 = new ArrayList();
      var0.iterate(new GraphHelpers$4(var1, var2));
      return var2;
   }

   public static List getEdges(IEdgeIterableGraph var0) {
      INodeFilter var1 = StandardFilters.getTrueFilter();
      return getEdges(var0, var1);
   }

   public static List getEdges(IEdgeIterableGraph var0, INodeFilter var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      Preconditions.checkNotNull(var1, "Error: Filter argument can\'t be null");
      ArrayList var2 = new ArrayList();
      var0.iterateEdges(new GraphHelpers$5(var1, var2));
      return var2;
   }

   public static List getInvisibleNodes(IViewableGraph var0) {
      ArrayList var1 = new ArrayList();
      var0.iterateInvisible(new GraphHelpers$6(var1));
      return var1;
   }

   public static List getNodes(IIterableGraph var0) {
      INodeFilter var1 = StandardFilters.getTrueFilter();
      return getNodes(var0, var1);
   }

   public static List getNodes(IIterableGraph var0, INodeFilter var1) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      Preconditions.checkNotNull(var1, "Error: Filter argument can\'t be null");
      ArrayList var2 = new ArrayList();
      var0.iterate(new GraphHelpers$7(var1, var2));
      return var2;
   }

   public static Collection getPredecessorsOfSelection(ISelectableGraph var0) {
      return GraphAlgorithms.getPredecessors((Collection)getSelectedNodes(var0));
   }

   public static String getSelectedContent(AbstractZyGraph var0) {
      StringBuilder var1 = new StringBuilder();
      IteratorFunctions.iterateSelected(var0, new GraphHelpers$8(var1));
      return var1.toString();
   }

   @Deprecated
   public static IFilledList getSelectedNodes(ISelectableGraph var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      FilledList var1 = new FilledList();
      var0.iterateSelected(new GraphHelpers$9(var1));
      return var1;
   }

   public static Collection getSuccessors(IGraphNode var0) {
      ArrayList var1 = new ArrayList();
      var1.add(var0);
      return GraphAlgorithms.getSuccessors((Collection)var1);
   }

   public static Collection getSuccessorsOfSelection(ISelectableGraph var0) {
      return GraphAlgorithms.getSuccessors((Collection)getSelectedNodes(var0));
   }

   public static List getUnselectedNodes(IIterableGraph var0) {
      Preconditions.checkNotNull(var0, "Error: Graph argument can\'t be null");
      ArrayList var1 = new ArrayList();
      var0.iterate(new GraphHelpers$10(var1));
      return var1;
   }

   public static Set getVisibleNodes(IViewableGraph var0) {
      HashSet var1 = new HashSet();
      var0.iterateVisible(new GraphHelpers$11(var1));
      return var1;
   }

   public static void iterate(IIterableCollection var0, IFilteredItemCallback var1) {
      var0.iterate(new GraphHelpers$12(var1));
   }

   public static void selectPredecessors(ISelectableGraph var0, IGraphNode var1) {
      var0.selectNodes(GraphAlgorithms.getPredecessors(var1), true);
   }

   public static void selectPredecessorsOfSelection(ISelectableGraph var0) {
      var0.selectNodes(getPredecessorsOfSelection(var0), true);
   }

   public static void selectSuccessors(ISelectableGraph var0, IGraphNode var1) {
      var0.selectNodes(GraphAlgorithms.getSuccessors(var1), true);
   }

   public static void selectSuccessorsOfSelection(ISelectableGraph var0) {
      var0.selectNodes(getSuccessorsOfSelection(var0), true);
   }

   public static void shrinkSelectionDown(ISelectableGraph var0) {
      ArrayList var1 = new ArrayList();
      var0.iterateSelected(new GraphHelpers$13(var1));
      var0.selectNodes(var1, false);
   }

   public static void shrinkSelectionUp(ISelectableGraph var0) {
      ArrayList var1 = new ArrayList();
      var0.iterateSelected(new GraphHelpers$14(var1));
      var0.selectNodes(var1, false);
   }

   public static void zoomToSelected(ISelectableGraph var0) {
      IFilledList var1 = getSelectedNodes(var0);
      if(var1.size() == 0) {
         throw new IllegalStateException("Error: There are no selected nodes");
      } else {
         ((IZoomableGraph)var0).zoomToNodes(var1);
      }
   }
}
