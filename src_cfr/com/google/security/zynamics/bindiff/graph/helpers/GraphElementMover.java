/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.graph.helpers;

import com.google.security.zynamics.bindiff.enums.EMatchState;
import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.graph.BinDiffGraph;
import com.google.security.zynamics.bindiff.graph.SingleGraph;
import com.google.security.zynamics.bindiff.graph.SuperGraph;
import com.google.security.zynamics.bindiff.graph.edges.SingleViewEdge;
import com.google.security.zynamics.bindiff.graph.nodes.CombinedViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SingleViewNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperDiffNode;
import com.google.security.zynamics.bindiff.graph.nodes.SuperViewNode;
import com.google.security.zynamics.bindiff.graph.settings.GraphSettings;
import com.google.security.zynamics.bindiff.graph.synchronizer.GraphViewCanvasSynchronizer;
import com.google.security.zynamics.zylib.gui.zygraph.edges.CBend;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.AbstractZyGraph;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.realizers.IZyNodeRealizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import y.c.q;
import y.h.bu;

public class GraphElementMover {
    private static List getAffectedSuperDiffNodes(AbstractZyGraph abstractZyGraph, SingleDiffNode singleDiffNode) {
        Iterator iterator22;
        Object object;
        HashSet<SingleDiffNode> hashSet = new HashSet<SingleDiffNode>();
        if (singleDiffNode.isSelected()) {
            for (Iterator iterator22 : abstractZyGraph.getSelectedNodes()) {
                hashSet.add((SingleDiffNode)((Object)iterator22));
            }
            object = singleDiffNode.getSide() == ESide.PRIMARY ? ((BinDiffGraph)abstractZyGraph).getSecondaryGraph() : ((BinDiffGraph)abstractZyGraph).getPrimaryGraph();
            for (Object singleDiffNode2 : object.getSelectedNodes()) {
                if (((SingleDiffNode)singleDiffNode2).getCombinedRawNode().getMatchState() == EMatchState.MATCHED) continue;
                hashSet.add((SingleDiffNode)singleDiffNode2);
            }
        } else {
            hashSet.add(singleDiffNode);
        }
        object = new ArrayList();
        iterator22 = hashSet.iterator();
        while (iterator22.hasNext()) {
            SingleDiffNode singleDiffNode2 = (SingleDiffNode)iterator22.next();
            SuperDiffNode superDiffNode = singleDiffNode2.getSuperDiffNode();
            object.add(superDiffNode);
        }
        return object;
    }

    private static void moveBends(List list, ESide eSide, double d2, double d3) {
        HashSet hashSet = new HashSet();
        for (Object object22 : list) {
            for (Iterator iterator2 : object22.getRawNode().getOutgoingEdges()) {
                hashSet.addAll(iterator2.getBends());
            }
            for (Iterator iterator2 : object22.getRawNode().getIncomingEdges()) {
                hashSet.addAll(iterator2.getBends());
            }
        }
        for (Object object22 : list) {
            Object object3 = object22.getPrimaryDiffNode();
            if (eSide == ESide.PRIMARY) {
                object3 = object22.getSecondaryDiffNode();
            }
            if (object3 == null) continue;
            for (SingleViewEdge singleViewEdge2 : object3.getRawNode().getOutgoingEdges()) {
                hashSet.addAll(singleViewEdge2.getBends());
            }
            for (SingleViewEdge singleViewEdge2 : object3.getRawNode().getIncomingEdges()) {
                hashSet.addAll(singleViewEdge2.getBends());
            }
        }
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object object22;
            object22 = (CBend)iterator.next();
            object22.setX(object22.getX() + d2);
            object22.setY(object22.getY() + d3);
        }
    }

    public static void moveNodes(AbstractZyGraph abstractZyGraph, q q2, double d2, double d3) {
        ZyGraphNode zyGraphNode = abstractZyGraph.getNode(q2);
        if (zyGraphNode instanceof SingleDiffNode && ((BinDiffGraph)abstractZyGraph).getSettings().isSync()) {
            SingleDiffNode singleDiffNode = (SingleDiffNode)zyGraphNode;
            List list = GraphElementMover.getAffectedSuperDiffNodes(abstractZyGraph, singleDiffNode);
            for (SuperDiffNode superDiffNode : list) {
                SingleDiffNode singleDiffNode2;
                IZyNodeRealizer iZyNodeRealizer = superDiffNode.getRealizer();
                iZyNodeRealizer.setX(iZyNodeRealizer.getX() + d2);
                iZyNodeRealizer.setY(iZyNodeRealizer.getY() + d3);
                GraphViewCanvasSynchronizer.adoptSuperWorldRect(((BinDiffGraph)abstractZyGraph).getSuperGraph());
                if (singleDiffNode.getSide() != ESide.PRIMARY) {
                    singleDiffNode2 = superDiffNode.getPrimaryDiffNode();
                    if (singleDiffNode2 == null) continue;
                    singleDiffNode2.getRealizer().setX(superDiffNode.getX());
                    singleDiffNode2.getRealizer().setY(superDiffNode.getY());
                    continue;
                }
                if (singleDiffNode.getSide() == ESide.SECONDARY || (singleDiffNode2 = superDiffNode.getSecondaryDiffNode()) == null) continue;
                singleDiffNode2.getRealizer().setX(superDiffNode.getX());
                singleDiffNode2.getRealizer().setY(superDiffNode.getY());
            }
            GraphElementMover.moveBends(list, singleDiffNode.getSide(), d2, d3);
        }
        ((BinDiffGraph)abstractZyGraph).getPrimaryGraph().getGraph().T();
        ((BinDiffGraph)abstractZyGraph).getSecondaryGraph().getGraph().T();
    }
}

