/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gml;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.types.graphs.IDirectedGraph;
import com.google.security.zynamics.zylib.types.graphs.IGraphEdge;
import com.google.security.zynamics.zylib.types.trees.ITree;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public final class GmlConverter {
    public static String toGml(IDirectedGraph iDirectedGraph) {
        String string;
        Preconditions.checkNotNull(iDirectedGraph, "Error: Graph argument can not be null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("graph\n");
        stringBuilder.append("[\n");
        int n2 = 0;
        HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        for (Object object2 : iDirectedGraph.getNodes()) {
            stringBuilder.append("\tnode\n");
            stringBuilder.append("\t[\n");
            int n3 = n2;
            stringBuilder.append(new StringBuilder(16).append("\tid ").append(n3).append("\n").toString());
            string = String.valueOf(object2);
            stringBuilder.append(new StringBuilder(10 + String.valueOf(string).length()).append("\tlabel \"").append(string).append("\"\n").toString());
            stringBuilder.append("\t]\n");
            hashMap.put(object2, n2);
            ++n2;
        }
        Iterator iterator = iDirectedGraph.getEdges().iterator();
        do {
            Object object2;
            if (!iterator.hasNext()) {
                stringBuilder.append("]\n");
                return stringBuilder.toString();
            }
            object2 = (IGraphEdge)iterator.next();
            stringBuilder.append("\tedge\n");
            stringBuilder.append("\t[\n");
            string = String.valueOf(hashMap.get(object2.getSource()));
            stringBuilder.append(new StringBuilder(9 + String.valueOf(string).length()).append("\tsource ").append(string).append("\n").toString());
            string = String.valueOf(hashMap.get(object2.getTarget()));
            stringBuilder.append(new StringBuilder(9 + String.valueOf(string).length()).append("\ttarget ").append(string).append("\n").toString());
            stringBuilder.append("\tgraphics\n");
            stringBuilder.append("\t[\n");
            stringBuilder.append("\t\tfill \"#000000\"\n");
            stringBuilder.append("\t\ttargetArrow \"standard\"\n");
            stringBuilder.append("\t]\n");
            stringBuilder.append("\t]\n");
        } while (true);
    }

    public static String toGml(ITree iTree) {
        Preconditions.checkNotNull(iTree, "Error: Graph argument can not be null");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("graph\n");
        stringBuilder.append("[\n");
        int n2 = 0;
        HashMap<ITreeNode, Integer> hashMap = new HashMap<ITreeNode, Integer>();
        Stack<ITreeNode> stack = new Stack<ITreeNode>();
        stack.push(iTree.getRootNode());
        block0 : do {
            Object object;
            if (stack.isEmpty()) {
                stringBuilder.append("]\n");
                return stringBuilder.toString();
            }
            ITreeNode iTreeNode = (ITreeNode)stack.pop();
            stringBuilder.append("\tnode\n");
            stringBuilder.append("\t[\n");
            int n3 = n2;
            stringBuilder.append(new StringBuilder(16).append("\tid ").append(n3).append("\n").toString());
            Object object2 = String.valueOf(iTreeNode);
            stringBuilder.append(new StringBuilder(10 + String.valueOf(object2).length()).append("\tlabel \"").append((String)object2).append("\"\n").toString());
            stringBuilder.append("\t]\n");
            hashMap.put(iTreeNode, n2);
            ++n2;
            object2 = iTreeNode.getParent();
            if (object2 != null) {
                stringBuilder.append("\tedge\n");
                stringBuilder.append("\t[\n");
                object = String.valueOf(hashMap.get(object2));
                stringBuilder.append(new StringBuilder(9 + String.valueOf(object).length()).append("\tsource ").append((String)object).append("\n").toString());
                object = String.valueOf(hashMap.get(iTreeNode));
                stringBuilder.append(new StringBuilder(9 + String.valueOf(object).length()).append("\ttarget ").append((String)object).append("\n").toString());
                stringBuilder.append("\tgraphics\n");
                stringBuilder.append("\t[\n");
                stringBuilder.append("\t\tfill \"#000000\"\n");
                stringBuilder.append("\t\ttargetArrow \"standard\"\n");
                stringBuilder.append("\t]\n");
                stringBuilder.append("\t]\n");
            }
            object = iTreeNode.getChildren().iterator();
            do {
                if (!object.hasNext()) continue block0;
                ITreeNode iTreeNode2 = (ITreeNode)object.next();
                stack.push(iTreeNode2);
            } while (true);
            break;
        } while (true);
    }
}

