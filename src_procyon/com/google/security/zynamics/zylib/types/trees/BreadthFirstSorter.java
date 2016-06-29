package com.google.security.zynamics.zylib.types.trees;

import java.util.*;

public class BreadthFirstSorter
{
    public static ArrayList getSortedList(final ITreeNode treeNode) {
        final BreadthFirstIterator breadthFirstIterator = new BreadthFirstIterator(treeNode);
        final ArrayList<ITreeNode> list = new ArrayList<ITreeNode>();
        while (breadthFirstIterator.hasNext()) {
            list.add(breadthFirstIterator.next());
        }
        return list;
    }
}
