package com.google.security.zynamics.zylib.gui.zygraph.helpers;

import com.google.security.zynamics.zylib.types.graphs.*;
import java.awt.geom.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.zylib.gui.zygraph.functions.*;
import com.google.security.zynamics.zylib.types.lists.*;
import java.util.*;
import com.google.security.zynamics.zylib.types.common.*;

public class GraphHelpers
{
    public static boolean any(final IIterableGraph iterableGraph, final INodeFilter nodeFilter) {
        final ArrayList list = new ArrayList();
        iterableGraph.iterate(new GraphHelpers$1(nodeFilter, list));
        return list.size() != 0;
    }
    
    public static boolean areAllChildrenDeselected(final IGraphNode graphNode) {
        return GraphAlgorithms.collectChildren(graphNode, StandardFilters.getSelectedFilter()).size() == 0;
    }
    
    public static boolean areAllParentsDeselected(final IGraphNode graphNode) {
        return GraphAlgorithms.collectParents(graphNode, StandardFilters.getSelectedFilter()).size() == 0;
    }
    
    public static Rectangle2D calculateBoundingBox(final Collection collection) {
        Preconditions.checkNotNull(collection, (Object)"Node list argument can't be null");
        Preconditions.checkArgument(collection.size() != 0, (Object)"Node list argument can't be empty");
        final Rectangle2D.Double double1 = new Rectangle2D.Double();
        final Iterator<IViewableNode> iterator = collection.iterator();
        while (iterator.hasNext()) {
            iterator.next().calcUnionRect(double1);
        }
        return double1;
    }
    
    public static void expandSelectionDown(final ISelectableGraph selectableGraph) {
        Preconditions.checkNotNull(selectableGraph, (Object)"Error: Graph argument can't be null");
        final ArrayList list = new ArrayList();
        selectableGraph.iterateSelected(new GraphHelpers$2(list, StandardFilters.getDeselectedFilter()));
        selectableGraph.selectNodes(list, true);
    }
    
    public static void expandSelectionUp(final ISelectableGraph selectableGraph) {
        Preconditions.checkNotNull(selectableGraph, (Object)"Error: Graph argument can't be null");
        final ArrayList list = new ArrayList();
        selectableGraph.iterateSelected(new GraphHelpers$3(list, StandardFilters.getDeselectedFilter()));
        selectableGraph.selectNodes(list, true);
    }
    
    public static List filter(final IIterableCollection collection, final ICollectionFilter collectionFilter) {
        final ArrayList list = new ArrayList();
        collection.iterate(new GraphHelpers$4(collectionFilter, list));
        return list;
    }
    
    public static List getEdges(final IEdgeIterableGraph edgeIterableGraph) {
        return getEdges(edgeIterableGraph, StandardFilters.getTrueFilter());
    }
    
    public static List getEdges(final IEdgeIterableGraph edgeIterableGraph, final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(edgeIterableGraph, (Object)"Error: Graph argument can't be null");
        Preconditions.checkNotNull(nodeFilter, (Object)"Error: Filter argument can't be null");
        final ArrayList list = new ArrayList();
        edgeIterableGraph.iterateEdges(new GraphHelpers$5(nodeFilter, list));
        return list;
    }
    
    public static List getInvisibleNodes(final IViewableGraph viewableGraph) {
        final ArrayList list = new ArrayList();
        viewableGraph.iterateInvisible(new GraphHelpers$6(list));
        return list;
    }
    
    public static List getNodes(final IIterableGraph iterableGraph) {
        return getNodes(iterableGraph, StandardFilters.getTrueFilter());
    }
    
    public static List getNodes(final IIterableGraph iterableGraph, final INodeFilter nodeFilter) {
        Preconditions.checkNotNull(iterableGraph, (Object)"Error: Graph argument can't be null");
        Preconditions.checkNotNull(nodeFilter, (Object)"Error: Filter argument can't be null");
        final ArrayList list = new ArrayList();
        iterableGraph.iterate(new GraphHelpers$7(nodeFilter, list));
        return list;
    }
    
    public static Collection getPredecessorsOfSelection(final ISelectableGraph selectableGraph) {
        return GraphAlgorithms.getPredecessors(getSelectedNodes(selectableGraph));
    }
    
    public static String getSelectedContent(final AbstractZyGraph abstractZyGraph) {
        final StringBuilder sb = new StringBuilder();
        IteratorFunctions.iterateSelected(abstractZyGraph, new GraphHelpers$8(sb));
        return sb.toString();
    }
    
    @Deprecated
    public static IFilledList getSelectedNodes(final ISelectableGraph selectableGraph) {
        Preconditions.checkNotNull(selectableGraph, (Object)"Error: Graph argument can't be null");
        final FilledList list = new FilledList();
        selectableGraph.iterateSelected(new GraphHelpers$9(list));
        return list;
    }
    
    public static Collection getSuccessors(final IGraphNode graphNode) {
        final ArrayList<IGraphNode> list = new ArrayList<IGraphNode>();
        list.add(graphNode);
        return GraphAlgorithms.getSuccessors(list);
    }
    
    public static Collection getSuccessorsOfSelection(final ISelectableGraph selectableGraph) {
        return GraphAlgorithms.getSuccessors(getSelectedNodes(selectableGraph));
    }
    
    public static List getUnselectedNodes(final IIterableGraph iterableGraph) {
        Preconditions.checkNotNull(iterableGraph, (Object)"Error: Graph argument can't be null");
        final ArrayList list = new ArrayList();
        iterableGraph.iterate(new GraphHelpers$10(list));
        return list;
    }
    
    public static Set getVisibleNodes(final IViewableGraph viewableGraph) {
        final HashSet set = new HashSet();
        viewableGraph.iterateVisible(new GraphHelpers$11(set));
        return set;
    }
    
    public static void iterate(final IIterableCollection collection, final IFilteredItemCallback filteredItemCallback) {
        collection.iterate(new GraphHelpers$12(filteredItemCallback));
    }
    
    public static void selectPredecessors(final ISelectableGraph selectableGraph, final IGraphNode graphNode) {
        selectableGraph.selectNodes(GraphAlgorithms.getPredecessors(graphNode), true);
    }
    
    public static void selectPredecessorsOfSelection(final ISelectableGraph selectableGraph) {
        selectableGraph.selectNodes(getPredecessorsOfSelection(selectableGraph), true);
    }
    
    public static void selectSuccessors(final ISelectableGraph selectableGraph, final IGraphNode graphNode) {
        selectableGraph.selectNodes(GraphAlgorithms.getSuccessors(graphNode), true);
    }
    
    public static void selectSuccessorsOfSelection(final ISelectableGraph selectableGraph) {
        selectableGraph.selectNodes(getSuccessorsOfSelection(selectableGraph), true);
    }
    
    public static void shrinkSelectionDown(final ISelectableGraph selectableGraph) {
        final ArrayList list = new ArrayList();
        selectableGraph.iterateSelected(new GraphHelpers$13(list));
        selectableGraph.selectNodes(list, false);
    }
    
    public static void shrinkSelectionUp(final ISelectableGraph selectableGraph) {
        final ArrayList list = new ArrayList();
        selectableGraph.iterateSelected(new GraphHelpers$14(list));
        selectableGraph.selectNodes(list, false);
    }
    
    public static void zoomToSelected(final ISelectableGraph selectableGraph) {
        final IFilledList selectedNodes = getSelectedNodes(selectableGraph);
        if (selectedNodes.size() == 0) {
            throw new IllegalStateException("Error: There are no selected nodes");
        }
        ((IZoomableGraph)selectableGraph).zoomToNodes(selectedNodes);
    }
}
