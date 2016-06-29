package com.google.security.zynamics.zylib.types.trees;

import java.util.*;

public final class DepthFirstSorter
{
    public static ArrayList getSortedList(final ITreeNode treeNode) {
        final DepthFirstIterator depthFirstIterator = new DepthFirstIterator(treeNode);
        final ArrayList<ITreeNode> list = new ArrayList<ITreeNode>();
        while (depthFirstIterator.hasNext()) {
            list.add(depthFirstIterator.next());
        }
        return list;
    }
}
