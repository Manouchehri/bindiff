/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.BreadthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;

public class BreadthFirstSorter {
    private BreadthFirstSorter() {
    }

    public static ArrayList getSortedList(ITreeNode iTreeNode) {
        BreadthFirstIterator breadthFirstIterator = new BreadthFirstIterator(iTreeNode);
        ArrayList<ITreeNode> arrayList = new ArrayList<ITreeNode>();
        while (breadthFirstIterator.hasNext()) {
            arrayList.add(breadthFirstIterator.next());
        }
        return arrayList;
    }
}

