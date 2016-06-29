package com.google.security.zynamics.zylib.gml;

import com.google.common.base.*;
import com.google.security.zynamics.zylib.types.graphs.*;
import com.google.security.zynamics.zylib.types.trees.*;
import java.util.*;

public final class GmlConverter
{
    public static String toGml(final IDirectedGraph directedGraph) {
        Preconditions.checkNotNull(directedGraph, (Object)"Error: Graph argument can not be null");
        final StringBuilder sb = new StringBuilder();
        sb.append("graph\n");
        sb.append("[\n");
        int n = 0;
        final HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        for (final Object next : directedGraph.getNodes()) {
            sb.append("\tnode\n");
            sb.append("\t[\n");
            sb.append(new StringBuilder(16).append("\tid ").append(n).append("\n").toString());
            final StringBuilder sb2 = sb;
            final String value = String.valueOf(next);
            sb2.append(new StringBuilder(10 + String.valueOf(value).length()).append("\tlabel \"").append(value).append("\"\n").toString());
            sb.append("\t]\n");
            hashMap.put(next, n);
            ++n;
        }
        for (final IGraphEdge graphEdge : directedGraph.getEdges()) {
            sb.append("\tedge\n");
            sb.append("\t[\n");
            final StringBuilder sb3 = sb;
            final String value2 = String.valueOf(hashMap.get(graphEdge.getSource()));
            sb3.append(new StringBuilder(9 + String.valueOf(value2).length()).append("\tsource ").append(value2).append("\n").toString());
            final StringBuilder sb4 = sb;
            final String value3 = String.valueOf(hashMap.get(graphEdge.getTarget()));
            sb4.append(new StringBuilder(9 + String.valueOf(value3).length()).append("\ttarget ").append(value3).append("\n").toString());
            sb.append("\tgraphics\n");
            sb.append("\t[\n");
            sb.append("\t\tfill \"#000000\"\n");
            sb.append("\t\ttargetArrow \"standard\"\n");
            sb.append("\t]\n");
            sb.append("\t]\n");
        }
        sb.append("]\n");
        return sb.toString();
    }
    
    public static String toGml(final ITree tree) {
        Preconditions.checkNotNull(tree, (Object)"Error: Graph argument can not be null");
        final StringBuilder sb = new StringBuilder();
        sb.append("graph\n");
        sb.append("[\n");
        int n = 0;
        final HashMap<ITreeNode, Integer> hashMap = new HashMap<ITreeNode, Integer>();
        final Stack<ITreeNode> stack = new Stack<ITreeNode>();
        stack.push(tree.getRootNode());
        while (!stack.isEmpty()) {
            final ITreeNode treeNode = stack.pop();
            sb.append("\tnode\n");
            sb.append("\t[\n");
            sb.append(new StringBuilder(16).append("\tid ").append(n).append("\n").toString());
            final StringBuilder sb2 = sb;
            final String value = String.valueOf(treeNode);
            sb2.append(new StringBuilder(10 + String.valueOf(value).length()).append("\tlabel \"").append(value).append("\"\n").toString());
            sb.append("\t]\n");
            hashMap.put(treeNode, n);
            ++n;
            final ITreeNode parent = treeNode.getParent();
            if (parent != null) {
                sb.append("\tedge\n");
                sb.append("\t[\n");
                final StringBuilder sb3 = sb;
                final String value2 = String.valueOf(hashMap.get(parent));
                sb3.append(new StringBuilder(9 + String.valueOf(value2).length()).append("\tsource ").append(value2).append("\n").toString());
                final StringBuilder sb4 = sb;
                final String value3 = String.valueOf(hashMap.get(treeNode));
                sb4.append(new StringBuilder(9 + String.valueOf(value3).length()).append("\ttarget ").append(value3).append("\n").toString());
                sb.append("\tgraphics\n");
                sb.append("\t[\n");
                sb.append("\t\tfill \"#000000\"\n");
                sb.append("\t\ttargetArrow \"standard\"\n");
                sb.append("\t]\n");
                sb.append("\t]\n");
            }
            final Iterator iterator = treeNode.getChildren().iterator();
            while (iterator.hasNext()) {
                stack.push(iterator.next());
            }
        }
        sb.append("]\n");
        return sb.toString();
    }
}
