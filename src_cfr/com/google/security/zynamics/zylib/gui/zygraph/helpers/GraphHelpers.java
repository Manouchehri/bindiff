/*
 * Decompiled with CFR 0_115.
 */
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
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeCallback;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.INodeCallback;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class GraphHelpers {
    public static boolean any(IIterableGraph iIterableGraph, INodeFilter iNodeFilter) {
        ArrayList arrayList = new ArrayList();
        iIterableGraph.iterate(new GraphHelpers$1(iNodeFilter, arrayList));
        if (arrayList.size() == 0) return false;
        return true;
    }

    public static boolean areAllChildrenDeselected(IGraphNode iGraphNode) {
        INodeFilter iNodeFilter = StandardFilters.getSelectedFilter();
        if (GraphAlgorithms.collectChildren(iGraphNode, iNodeFilter).size() != 0) return false;
        return true;
    }

    public static boolean areAllParentsDeselected(IGraphNode iGraphNode) {
        INodeFilter iNodeFilter = StandardFilters.getSelectedFilter();
        if (GraphAlgorithms.collectParents(iGraphNode, iNodeFilter).size() != 0) return false;
        return true;
    }

    public static Rectangle2D calculateBoundingBox(Collection collection) {
        Preconditions.checkNotNull(collection, "Node list argument can't be null");
        Preconditions.checkArgument(collection.size() != 0, "Node list argument can't be empty");
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            IViewableNode iViewableNode = (IViewableNode)iterator.next();
            iViewableNode.calcUnionRect(double_);
        }
        return double_;
    }

    public static void expandSelectionDown(ISelectableGraph iSelectableGraph) {
        Preconditions.checkNotNull(iSelectableGraph, "Error: Graph argument can't be null");
        ArrayList arrayList = new ArrayList();
        INodeFilter iNodeFilter = StandardFilters.getDeselectedFilter();
        iSelectableGraph.iterateSelected(new GraphHelpers$2(arrayList, iNodeFilter));
        iSelectableGraph.selectNodes(arrayList, true);
    }

    public static void expandSelectionUp(ISelectableGraph iSelectableGraph) {
        Preconditions.checkNotNull(iSelectableGraph, "Error: Graph argument can't be null");
        ArrayList arrayList = new ArrayList();
        INodeFilter iNodeFilter = StandardFilters.getDeselectedFilter();
        iSelectableGraph.iterateSelected(new GraphHelpers$3(arrayList, iNodeFilter));
        iSelectableGraph.selectNodes(arrayList, true);
    }

    public static List filter(IIterableCollection iIterableCollection, ICollectionFilter iCollectionFilter) {
        ArrayList arrayList = new ArrayList();
        iIterableCollection.iterate(new GraphHelpers$4(iCollectionFilter, arrayList));
        return arrayList;
    }

    public static List getEdges(IEdgeIterableGraph iEdgeIterableGraph) {
        INodeFilter iNodeFilter = StandardFilters.getTrueFilter();
        return GraphHelpers.getEdges(iEdgeIterableGraph, iNodeFilter);
    }

    public static List getEdges(IEdgeIterableGraph iEdgeIterableGraph, INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(iEdgeIterableGraph, "Error: Graph argument can't be null");
        Preconditions.checkNotNull(iNodeFilter, "Error: Filter argument can't be null");
        ArrayList arrayList = new ArrayList();
        iEdgeIterableGraph.iterateEdges(new GraphHelpers$5(iNodeFilter, arrayList));
        return arrayList;
    }

    public static List getInvisibleNodes(IViewableGraph iViewableGraph) {
        ArrayList arrayList = new ArrayList();
        iViewableGraph.iterateInvisible(new GraphHelpers$6(arrayList));
        return arrayList;
    }

    public static List getNodes(IIterableGraph iIterableGraph) {
        INodeFilter iNodeFilter = StandardFilters.getTrueFilter();
        return GraphHelpers.getNodes(iIterableGraph, iNodeFilter);
    }

    public static List getNodes(IIterableGraph iIterableGraph, INodeFilter iNodeFilter) {
        Preconditions.checkNotNull(iIterableGraph, "Error: Graph argument can't be null");
        Preconditions.checkNotNull(iNodeFilter, "Error: Filter argument can't be null");
        ArrayList arrayList = new ArrayList();
        iIterableGraph.iterate(new GraphHelpers$7(iNodeFilter, arrayList));
        return arrayList;
    }

    public static Collection getPredecessorsOfSelection(ISelectableGraph iSelectableGraph) {
        return GraphAlgorithms.getPredecessors(GraphHelpers.getSelectedNodes(iSelectableGraph));
    }

    public static String getSelectedContent(AbstractZyGraph abstractZyGraph) {
        StringBuilder stringBuilder = new StringBuilder();
        IteratorFunctions.iterateSelected(abstractZyGraph, new GraphHelpers$8(stringBuilder));
        return stringBuilder.toString();
    }

    @Deprecated
    public static IFilledList getSelectedNodes(ISelectableGraph iSelectableGraph) {
        Preconditions.checkNotNull(iSelectableGraph, "Error: Graph argument can't be null");
        FilledList filledList = new FilledList();
        iSelectableGraph.iterateSelected(new GraphHelpers$9(filledList));
        return filledList;
    }

    public static Collection getSuccessors(IGraphNode iGraphNode) {
        ArrayList<IGraphNode> arrayList = new ArrayList<IGraphNode>();
        arrayList.add(iGraphNode);
        return GraphAlgorithms.getSuccessors(arrayList);
    }

    public static Collection getSuccessorsOfSelection(ISelectableGraph iSelectableGraph) {
        return GraphAlgorithms.getSuccessors(GraphHelpers.getSelectedNodes(iSelectableGraph));
    }

    public static List getUnselectedNodes(IIterableGraph iIterableGraph) {
        Preconditions.checkNotNull(iIterableGraph, "Error: Graph argument can't be null");
        ArrayList arrayList = new ArrayList();
        iIterableGraph.iterate(new GraphHelpers$10(arrayList));
        return arrayList;
    }

    public static Set getVisibleNodes(IViewableGraph iViewableGraph) {
        HashSet hashSet = new HashSet();
        iViewableGraph.iterateVisible(new GraphHelpers$11(hashSet));
        return hashSet;
    }

    public static void iterate(IIterableCollection iIterableCollection, IFilteredItemCallback iFilteredItemCallback) {
        iIterableCollection.iterate(new GraphHelpers$12(iFilteredItemCallback));
    }

    public static void selectPredecessors(ISelectableGraph iSelectableGraph, IGraphNode iGraphNode) {
        iSelectableGraph.selectNodes((Collection)GraphAlgorithms.getPredecessors(iGraphNode), true);
    }

    public static void selectPredecessorsOfSelection(ISelectableGraph iSelectableGraph) {
        iSelectableGraph.selectNodes(GraphHelpers.getPredecessorsOfSelection(iSelectableGraph), true);
    }

    public static void selectSuccessors(ISelectableGraph iSelectableGraph, IGraphNode iGraphNode) {
        iSelectableGraph.selectNodes((Collection)GraphAlgorithms.getSuccessors(iGraphNode), true);
    }

    public static void selectSuccessorsOfSelection(ISelectableGraph iSelectableGraph) {
        iSelectableGraph.selectNodes(GraphHelpers.getSuccessorsOfSelection(iSelectableGraph), true);
    }

    public static void shrinkSelectionDown(ISelectableGraph iSelectableGraph) {
        ArrayList arrayList = new ArrayList();
        iSelectableGraph.iterateSelected(new GraphHelpers$13(arrayList));
        iSelectableGraph.selectNodes(arrayList, false);
    }

    public static void shrinkSelectionUp(ISelectableGraph iSelectableGraph) {
        ArrayList arrayList = new ArrayList();
        iSelectableGraph.iterateSelected(new GraphHelpers$14(arrayList));
        iSelectableGraph.selectNodes(arrayList, false);
    }

    public static void zoomToSelected(ISelectableGraph iSelectableGraph) {
        IFilledList iFilledList = GraphHelpers.getSelectedNodes(iSelectableGraph);
        if (iFilledList.size() == 0) {
            throw new IllegalStateException("Error: There are no selected nodes");
        }
        ((IZoomableGraph)((Object)iSelectableGraph)).zoomToNodes(iFilledList);
    }
}

