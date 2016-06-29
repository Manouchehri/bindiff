/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.types.trees;

import com.google.security.zynamics.zylib.types.trees.DepthFirstIterator;
import com.google.security.zynamics.zylib.types.trees.ITreeNode;
import java.util.ArrayList;

public final class DepthFirstSorter {
    private DepthFirstSorter() {
    }

    public static ArrayList getSortedList(ITreeNode iTreeNode) {
        DepthFirstIterator depthFirstIterator = new DepthFirstIterator(iTreeNode);
        ArrayList<ITreeNode> arrayList = new ArrayList<ITreeNode>();
        while (depthFirstIterator.hasNext()) {
            arrayList.add(depthFirstIterator.next());
        }
        return arrayList;
    }
}

