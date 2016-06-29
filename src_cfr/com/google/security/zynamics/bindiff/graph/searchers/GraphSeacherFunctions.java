/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.searchers;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.CombinedGraph;
import com.google.security.zynamics.bindiff.graph.GraphsContainer;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.helpers.GraphMover;
import com.google.security.zynamics.bindiff.graph.helpers.GraphZoomer;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.searchers.CombinedGraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.GraphSearcher;
import com.google.security.zynamics.bindiff.graph.searchers.SearchResult;
import com.google.security.zynamics.bindiff.graph.searchers.SuperGraphSearcher;
import com.google.security.zynamics.bindiff.resources.Colors;
import com.google.security.zynamics.zylib.gui.CMessageBox;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.GraphHelpers;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IEdgeIterableGraph;
import com.google.security.zynamics.zylib.gui.zygraph.helpers.IIterableGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.awt.Color;
import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingUtilities;
import y.h.ch;
import y.h.fj;

public class GraphSeacherFunctions {
    private static void markResults(SearchResult searchResult, boolean bl2) {
        Object object2;
        Color color = bl2 ? Colors.SEARCH_HIGHLIGHT_COLOR : searchResult.getOriginalBorderColor();
        SingleDiffNode singleDiffNode = (SingleDiffNode)searchResult.getObject();
        if (bl2) {
            singleDiffNode.setBackgroundColor(searchResult.getLine(), searchResult.getPosition(), searchResult.getLength(), Colors.SEARCH_HIGHLIGHT_COLOR);
        } else {
            int n2 = searchResult.getLine();
            for (Object object2 : searchResult.getOriginalTextBackgroundStyleRun()) {
                Color color2 = object2.getColor();
                ESide eSide = singleDiffNode.getSide();
                if (color2 != null) {
                    if (singleDiffNode.isSelected()) {
                        if (eSide == ESide.PRIMARY && color2 == Colors.PRIMARY_BASE || eSide == ESide.SECONDARY && color2 == Colors.SECONDARY_BASE) {
                            color2 = color2.darker();
                        }
                    } else if (eSide == ESide.PRIMARY && color2.equals(Colors.PRIMARY_BASE.darker())) {
                        color2 = Colors.PRIMARY_BASE;
                    } else if (eSide == ESide.SECONDARY && color2 == Colors.SECONDARY_BASE) {
                        color2 = Colors.SECONDARY_BASE;
                    }
                }
                singleDiffNode.setBackgroundColor(n2, object2.getStart(), object2.getLength(), color2);
            }
        }
        singleDiffNode.getRealizer().getRealizer().setLineColor(color);
        CombinedDiffNode combinedDiffNode = singleDiffNode.getCombinedDiffNode();
        SingleDiffNode singleDiffNode2 = combinedDiffNode.getPrimaryDiffNode();
        object2 = combinedDiffNode.getSecondaryDiffNode();
        combinedDiffNode.getRealizer().getRealizer().setLineColor(color);
        if (singleDiffNode2 == null) return;
        if (object2 == null) return;
        if (singleDiffNode2.getRealizer().getRealizer().getLineColor().equals(object2.getRealizer().getRealizer().getLineColor())) return;
        combinedDiffNode.getRealizer().getRealizer().setLineColor(Colors.MIXED_BASE_COLOR.darker());
    }

    public static void clearResults(GraphsContainer graphsContainer) {
        Iterator iterator = graphsContainer.iterator();
        while (iterator.hasNext()) {
            BinDiffGraph binDiffGraph = (BinDiffGraph)iterator.next();
            binDiffGraph.getGraphSearcher().clearResults();
        }
    }

    public static boolean getHasChanged(GraphsContainer graphsContainer, String string) {
        BinDiffGraph binDiffGraph;
        Iterator iterator = graphsContainer.iterator();
        do {
            if (!iterator.hasNext()) return false;
        } while (!(binDiffGraph = (BinDiffGraph)iterator.next()).getGraphSearcher().getHasChanged(string));
        return true;
    }

    public static void highlightResults(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SearchResult searchResult = (SearchResult)iterator.next();
            GraphSeacherFunctions.markResults(searchResult, true);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void highlightSubObjectResults(GraphsContainer var0) {
        var1_1 = var0.iterator();
        block0 : do lbl-1000: // 3 sources:
        {
            if (var1_1.hasNext() == false) return;
            var2_2 = (BinDiffGraph)var1_1.next();
            if (!(var2_2 instanceof SingleGraph)) ** GOTO lbl-1000
            var3_3 = var2_2.getGraphSearcher().getSubObjectResults().iterator();
            do {
                if (!var3_3.hasNext()) continue block0;
                var4_4 = (SearchResult)var3_3.next();
                GraphSeacherFunctions.markResults(var4_4, true);
            } while (true);
            break;
        } while (true);
    }

    public static boolean isEmpty(GraphsContainer graphsContainer) {
        BinDiffGraph binDiffGraph;
        Iterator iterator = graphsContainer.iterator();
        do {
            if (!iterator.hasNext()) return true;
        } while ((binDiffGraph = (BinDiffGraph)iterator.next()).getGraphSearcher().getObjectResults().isEmpty());
        return false;
    }

    public static void iterateObjectResults(GraphsContainer graphsContainer, boolean bl2, boolean bl3) {
        Object object;
        BinDiffGraph binDiffGraph = graphsContainer.getFocusedGraph();
        GraphSearcher graphSearcher = binDiffGraph.getGraphSearcher();
        Window window = SwingUtilities.getWindowAncestor(graphsContainer.getCombinedGraph().getView());
        if (bl2) {
            graphSearcher.previous();
            if (graphSearcher.isBeforeFirst()) {
                CMessageBox.showInformation(window, "All search results were displayed. Going back to the last one.");
            }
        } else {
            graphSearcher.next();
            if (graphSearcher.isAfterLast()) {
                CMessageBox.showInformation(window, "All search results were displayed. Going back to the first one.");
            }
        }
        if ((object = graphSearcher.current()) == null) {
            return;
        }
        GraphSeacherFunctions.jumpToResultObject(binDiffGraph, object, bl3);
    }

    public static void jumpToFirstResultObject(BinDiffGraph binDiffGraph, boolean bl2) {
        List list = binDiffGraph.getGraphSearcher().getObjectResults();
        if (list.isEmpty()) return;
        Object e2 = list.get(0);
        GraphSeacherFunctions.jumpToResultObject(binDiffGraph, e2, bl2);
    }

    public static void jumpToResultObject(BinDiffGraph binDiffGraph, Object object, boolean bl2) {
        if (object == null) {
            return;
        }
        if (!(object instanceof ZyGraphNode)) return;
        BinDiffGraph binDiffGraph2 = binDiffGraph;
        Object object2 = object;
        if (binDiffGraph instanceof SuperGraph) {
            binDiffGraph2 = binDiffGraph.getPrimaryGraph();
            object2 = ((SuperDiffNode)object).getPrimaryDiffNode();
            if (object2 == null) {
                binDiffGraph2 = binDiffGraph.getSecondaryGraph();
                object2 = ((SuperDiffNode)object).getSecondaryDiffNode();
            }
        }
        if (bl2) {
            GraphZoomer.zoomToNode(binDiffGraph2, (ZyGraphNode)object2);
            return;
        }
        GraphMover.moveToNode(binDiffGraph2, (ZyGraphNode)object2);
    }

    public static void removeHightlighing(List list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            SearchResult searchResult = (SearchResult)iterator.next();
            GraphSeacherFunctions.removeSubObjectHightlighing(searchResult);
        }
    }

    public static void removeSubObjectHightlighing(SearchResult searchResult) {
        GraphSeacherFunctions.markResults(searchResult, false);
    }

    public static void search(GraphsContainer graphsContainer, String string) {
        GraphSeacherFunctions.clearResults(graphsContainer);
        Object object = graphsContainer.iterator();
        do {
            Object object2;
            Object object3;
            Object object4;
            if (!object.hasNext()) {
                object = graphsContainer.getPrimaryGraph().getGraphSearcher().getObjectResults();
                object4 = graphsContainer.getSecondaryGraph().getGraphSearcher().getObjectResults();
                object2 = graphsContainer.getSuperGraph();
                object3 = graphsContainer.getCombinedGraph();
                ((SuperGraphSearcher)object2.getGraphSearcher()).setObjectResults((SuperGraph)object2, (List)object, (List)object4);
                ((CombinedGraphSearcher)object3.getGraphSearcher()).setObjectResults((CombinedGraph)object3, (List)object, (List)object4);
                return;
            }
            object4 = (BinDiffGraph)object.next();
            object2 = GraphHelpers.getNodes((IIterableGraph)object4);
            object3 = GraphHelpers.getEdges((IEdgeIterableGraph)object4);
            object4.getGraphSearcher().search((List)object2, (List)object3, string);
        } while (true);
    }
}

