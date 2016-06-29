package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.*;
import com.google.security.zynamics.bindiff.graph.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.graph.nodes.*;
import com.google.security.zynamics.zylib.gui.zygraph.edges.*;
import java.util.*;
import com.google.security.zynamics.bindiff.graph.edges.*;
import y.c.*;
import com.google.security.zynamics.bindiff.graph.synchronizer.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.*;

public class GraphElementMover
{
    private static List getAffectedSuperDiffNodes(final AbstractZyGraph abstractZyGraph, final SingleDiffNode singleDiffNode) {
        final HashSet<SingleDiffNode> set = new HashSet<SingleDiffNode>();
        if (singleDiffNode.isSelected()) {
            final Iterator<SingleDiffNode> iterator = abstractZyGraph.getSelectedNodes().iterator();
            while (iterator.hasNext()) {
                set.add(iterator.next());
            }
            for (final SingleDiffNode next : ((singleDiffNode.getSide() == ESide.PRIMARY) ? ((BinDiffGraph)abstractZyGraph).getSecondaryGraph() : ((BinDiffGraph)abstractZyGraph).getPrimaryGraph()).getSelectedNodes()) {
                if (next.getCombinedRawNode().getMatchState() != EMatchState.MATCHED) {
                    set.add(next);
                }
            }
        }
        else {
            set.add(singleDiffNode);
        }
        final ArrayList<SuperDiffNode> list = new ArrayList<SuperDiffNode>();
        final Iterator<Object> iterator3 = set.iterator();
        while (iterator3.hasNext()) {
            list.add(iterator3.next().getSuperDiffNode());
        }
        return list;
    }
    
    private static void moveBends(final List list, final ESide eSide, final double n, final double n2) {
        final HashSet<CBend> set = new HashSet<CBend>();
        for (final SuperDiffNode superDiffNode : list) {
            final Iterator iterator2 = superDiffNode.getRawNode().getOutgoingEdges().iterator();
            while (iterator2.hasNext()) {
                set.addAll((Collection<?>)iterator2.next().getBends());
            }
            final Iterator iterator3 = superDiffNode.getRawNode().getIncomingEdges().iterator();
            while (iterator3.hasNext()) {
                set.addAll((Collection<?>)iterator3.next().getBends());
            }
        }
        for (final SuperDiffNode superDiffNode2 : list) {
            SingleDiffNode singleDiffNode = superDiffNode2.getPrimaryDiffNode();
            if (eSide == ESide.PRIMARY) {
                singleDiffNode = superDiffNode2.getSecondaryDiffNode();
            }
            if (singleDiffNode != null) {
                final Iterator iterator5 = singleDiffNode.getRawNode().getOutgoingEdges().iterator();
                while (iterator5.hasNext()) {
                    set.addAll((Collection<?>)iterator5.next().getBends());
                }
                final Iterator iterator6 = singleDiffNode.getRawNode().getIncomingEdges().iterator();
                while (iterator6.hasNext()) {
                    set.addAll((Collection<?>)iterator6.next().getBends());
                }
            }
        }
        for (final CBend cBend : set) {
            cBend.setX(cBend.getX() + n);
            cBend.setY(cBend.getY() + n2);
        }
    }
    
    public static void moveNodes(final AbstractZyGraph abstractZyGraph, final q q, final double n, final double n2) {
        final ZyGraphNode node = abstractZyGraph.getNode(q);
        if (node instanceof SingleDiffNode && ((BinDiffGraph)abstractZyGraph).getSettings().isSync()) {
            final SingleDiffNode singleDiffNode = (SingleDiffNode)node;
            final List affectedSuperDiffNodes = getAffectedSuperDiffNodes(abstractZyGraph, singleDiffNode);
            for (final SuperDiffNode superDiffNode : affectedSuperDiffNodes) {
                final IZyNodeRealizer realizer = superDiffNode.getRealizer();
                realizer.setX(realizer.getX() + n);
                realizer.setY(realizer.getY() + n2);
                GraphViewCanvasSynchronizer.adoptSuperWorldRect(((BinDiffGraph)abstractZyGraph).getSuperGraph());
                if (singleDiffNode.getSide() != ESide.PRIMARY) {
                    final SingleDiffNode primaryDiffNode = superDiffNode.getPrimaryDiffNode();
                    if (primaryDiffNode == null) {
                        continue;
                    }
                    primaryDiffNode.getRealizer().setX(superDiffNode.getX());
                    primaryDiffNode.getRealizer().setY(superDiffNode.getY());
                }
                else {
                    if (singleDiffNode.getSide() == ESide.SECONDARY) {
                        continue;
                    }
                    final SingleDiffNode secondaryDiffNode = superDiffNode.getSecondaryDiffNode();
                    if (secondaryDiffNode == null) {
                        continue;
                    }
                    secondaryDiffNode.getRealizer().setX(superDiffNode.getX());
                    secondaryDiffNode.getRealizer().setY(superDiffNode.getY());
                }
            }
            moveBends(affectedSuperDiffNodes, singleDiffNode.getSide(), n, n2);
        }
        ((BinDiffGraph)abstractZyGraph).getPrimaryGraph().getGraph().T();
        ((BinDiffGraph)abstractZyGraph).getSecondaryGraph().getGraph().T();
    }
}
