/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.ZyTree;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.List;
import java.util.Stack;

public class PostorderIterator {
    private final Stack traversalStack = new Stack();
    private final IZyTreeNode m_root;
    private boolean m_started = false;

    public PostorderIterator(IZyTreeNode iZyTreeNode) {
        this.m_root = iZyTreeNode;
    }

    private void pushLongestPathFrom(IZyTreeNode iZyTreeNode) {
        IZyTreeNode iZyTreeNode2 = iZyTreeNode;
        do {
            this.traversalStack.push(new Pair(iZyTreeNode2, 0));
            if (iZyTreeNode2.getChildren().size() == 0) {
                return;
            }
            iZyTreeNode2 = (IZyTreeNode)iZyTreeNode2.getChildren().get(0);
        } while (true);
    }

    public IZyTreeNode current() {
        return (IZyTreeNode)((Pair)this.traversalStack.lastElement()).first();
    }

    public boolean next() {
        Pair pair;
        int n2;
        if (!this.m_started) {
            this.pushLongestPathFrom(this.m_root);
            this.m_started = true;
            if (!this.traversalStack.empty()) return true;
            return false;
        }
        if (this.traversalStack.empty()) {
            throw new RuntimeException("Internal Error: Traversal already finished");
        }
        do {
            if (!this.traversalStack.empty()) continue;
            return false;
        } while ((n2 = (Integer)(pair = (Pair)this.traversalStack.pop()).second() + 1) > ((IZyTreeNode)pair.first()).getChildren().size());
        if (n2 == ((IZyTreeNode)pair.first()).getChildren().size()) {
            this.traversalStack.push(new Pair(pair.first(), n2));
            return true;
        }
        this.traversalStack.push(new Pair(pair.first(), n2));
        this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(n2));
        return true;
    }
}

