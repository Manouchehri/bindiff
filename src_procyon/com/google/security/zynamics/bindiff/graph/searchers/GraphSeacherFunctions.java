package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.zylib.gui.zygraph.realizers.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.util.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.bindiff.graph.helpers.*;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.*;
import com.google.security.zynamics.bindiff.graph.*;

public class GraphSeacherFunctions
{
    private static void markResults(final SearchResult searchResult, final boolean b) {
        final Color color = b ? Colors.SEARCH_HIGHLIGHT_COLOR : searchResult.getOriginalBorderColor();
        final SingleDiffNode singleDiffNode = (SingleDiffNode)searchResult.getObject();
        if (b) {
            singleDiffNode.setBackgroundColor(searchResult.getLine(), searchResult.getPosition(), searchResult.getLength(), Colors.SEARCH_HIGHLIGHT_COLOR);
        }
        else {
            final int line = searchResult.getLine();
            for (final CStyleRunData cStyleRunData : searchResult.getOriginalTextBackgroundStyleRun()) {
                Color color2 = cStyleRunData.getColor();
                final ESide side = singleDiffNode.getSide();
                if (color2 != null) {
                    if (singleDiffNode.isSelected()) {
                        if ((side == ESide.PRIMARY && color2 == Colors.PRIMARY_BASE) || (side == ESide.SECONDARY && color2 == Colors.SECONDARY_BASE)) {
                            color2 = color2.darker();
                        }
                    }
                    else if (side == ESide.PRIMARY && color2.equals(Colors.PRIMARY_BASE.darker())) {
                        color2 = Colors.PRIMARY_BASE;
                    }
                    else if (side == ESide.SECONDARY && color2 == Colors.SECONDARY_BASE) {
                        color2 = Colors.SECONDARY_BASE;
                    }
                }
                singleDiffNode.setBackgroundColor(line, cStyleRunData.getStart(), cStyleRunData.getLength(), color2);
            }
        }
        singleDiffNode.getRealizer().getRealizer().setLineColor(color);
        final CombinedDiffNode combinedDiffNode = singleDiffNode.getCombinedDiffNode();
        final SingleDiffNode primaryDiffNode = combinedDiffNode.getPrimaryDiffNode();
        final SingleDiffNode secondaryDiffNode = combinedDiffNode.getSecondaryDiffNode();
        combinedDiffNode.getRealizer().getRealizer().setLineColor(color);
        if (primaryDiffNode != null && secondaryDiffNode != null && !primaryDiffNode.getRealizer().getRealizer().getLineColor().equals(secondaryDiffNode.getRealizer().getRealizer().getLineColor())) {
            combinedDiffNode.getRealizer().getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
        }
    }
    
    public static void clearResults(final GraphsContainer graphsContainer) {
        final Iterator iterator = graphsContainer.iterator();
        while (iterator.hasNext()) {
            iterator.next().getGraphSearcher().clearResults();
        }
    }
    
    public static boolean getHasChanged(final GraphsContainer graphsContainer, final String s) {
        final Iterator iterator = graphsContainer.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getGraphSearcher().getHasChanged(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static void highlightResults(final List list) {
        final Iterator<SearchResult> iterator = list.iterator();
        while (iterator.hasNext()) {
            markResults(iterator.next(), true);
        }
    }
    
    public static void highlightSubObjectResults(final GraphsContainer graphsContainer) {
        for (final BinDiffGraph binDiffGraph : graphsContainer) {
            if (!(binDiffGraph instanceof SingleGraph)) {
                continue;
            }
            final Iterator iterator2 = binDiffGraph.getGraphSearcher().getSubObjectResults().iterator();
            while (iterator2.hasNext()) {
                markResults(iterator2.next(), true);
            }
        }
    }
    
    public static boolean isEmpty(final GraphsContainer graphsContainer) {
        final Iterator iterator = graphsContainer.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getGraphSearcher().getObjectResults().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public static void iterateObjectResults(final GraphsContainer graphsContainer, final boolean b, final boolean b2) {
        final BinDiffGraph focusedGraph = graphsContainer.getFocusedGraph();
        final GraphSearcher graphSearcher = focusedGraph.getGraphSearcher();
        final Window windowAncestor = SwingUtilities.getWindowAncestor(graphsContainer.getCombinedGraph().getView());
        if (b) {
            graphSearcher.previous();
            if (graphSearcher.isBeforeFirst()) {
                CMessageBox.showInformation(windowAncestor, "All search results were displayed. Going back to the last one.");
            }
        }
        else {
            graphSearcher.next();
            if (graphSearcher.isAfterLast()) {
                CMessageBox.showInformation(windowAncestor, "All search results were displayed. Going back to the first one.");
            }
        }
        final Object current = graphSearcher.current();
        if (current == null) {
            return;
        }
        jumpToResultObject(focusedGraph, current, b2);
    }
    
    public static void jumpToFirstResultObject(final BinDiffGraph binDiffGraph, final boolean b) {
        final List objectResults = binDiffGraph.getGraphSearcher().getObjectResults();
        if (!objectResults.isEmpty()) {
            jumpToResultObject(binDiffGraph, objectResults.get(0), b);
        }
    }
    
    public static void jumpToResultObject(final BinDiffGraph binDiffGraph, final Object o, final boolean b) {
        if (o == null) {
            return;
        }
        if (o instanceof ZyGraphNode) {
            BinDiffGraph binDiffGraph2 = binDiffGraph;
            Object o2 = o;
            if (binDiffGraph instanceof SuperGraph) {
                binDiffGraph2 = binDiffGraph.getPrimaryGraph();
                o2 = ((SuperDiffNode)o).getPrimaryDiffNode();
                if (o2 == null) {
                    binDiffGraph2 = binDiffGraph.getSecondaryGraph();
                    o2 = ((SuperDiffNode)o).getSecondaryDiffNode();
                }
            }
            if (b) {
                GraphZoomer.zoomToNode(binDiffGraph2, (ZyGraphNode)o2);
            }
            else {
                GraphMover.moveToNode(binDiffGraph2, (ZyGraphNode)o2);
            }
        }
    }
    
    public static void removeHightlighing(final List list) {
        final Iterator<SearchResult> iterator = list.iterator();
        while (iterator.hasNext()) {
            removeSubObjectHightlighing(iterator.next());
        }
    }
    
    public static void removeSubObjectHightlighing(final SearchResult searchResult) {
        markResults(searchResult, false);
    }
    
    public static void search(final GraphsContainer graphsContainer, final String s) {
        clearResults(graphsContainer);
        for (final BinDiffGraph binDiffGraph : graphsContainer) {
            binDiffGraph.getGraphSearcher().search(GraphHelpers.getNodes(binDiffGraph), GraphHelpers.getEdges(binDiffGraph), s);
        }
        final List objectResults = graphsContainer.getPrimaryGraph().getGraphSearcher().getObjectResults();
        final List objectResults2 = graphsContainer.getSecondaryGraph().getGraphSearcher().getObjectResults();
        final SuperGraph superGraph = graphsContainer.getSuperGraph();
        final CombinedGraph combinedGraph = graphsContainer.getCombinedGraph();
        ((SuperGraphSearcher)superGraph.getGraphSearcher()).setObjectResults(superGraph, objectResults, objectResults2);
        ((CombinedGraphSearcher)combinedGraph.getGraphSearcher()).setObjectResults(combinedGraph, objectResults, objectResults2);
    }
}
