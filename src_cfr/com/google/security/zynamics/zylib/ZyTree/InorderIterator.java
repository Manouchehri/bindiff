/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.ZyTree;

import com.google.security.zynamics.zylib.ZyTree.IZyTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.List;
import java.util.Stack;

public class InorderIterator {
    private final Stack traversalStack = new Stack();
    private final IZyTreeNode m_root;
    private boolean m_started = false;

    public InorderIterator(IZyTreeNode iZyTreeNode) {
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
        if (!this.m_started) {
            this.pushLongestPathFrom(this.m_root);
            this.m_started = true;
        } else {
            if (this.traversalStack.empty()) {
                throw new RuntimeException("Internal Error: Traversal already finished");
            }
            Pair pair = (Pair)this.traversalStack.pop();
            IZyTreeNode iZyTreeNode = (IZyTreeNode)pair.first();
            int n2 = (Integer)pair.second();
            if (this.traversalStack.empty()) {
                if (n2 == iZyTreeNode.getChildren().size()) {
                    return false;
                }
                if (iZyTreeNode.getChildren().size() == 0) {
                    throw new RuntimeException("Error");
                }
                if (iZyTreeNode.getChildren().size() == 1) {
                    this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(n2));
                } else {
                    this.traversalStack.push(new Pair(((IZyTreeNode)pair.first()).getChildren().get(n2), 0));
                }
            } else if (n2 == iZyTreeNode.getChildren().size()) {
                Pair pair2 = (Pair)this.traversalStack.pop();
                this.traversalStack.push(new Pair(pair2.first(), (Integer)pair2.second() + 1));
            } else {
                if (iZyTreeNode.getChildren().size() == 0) {
                    throw new RuntimeException("Error");
                }
                if (iZyTreeNode.getChildren().size() == 1) {
                    this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(n2));
                } else {
                    this.traversalStack.push(new Pair(((IZyTreeNode)pair.first()).getChildren().get(n2), 0));
                }
            }
        }
        if (this.traversalStack.empty()) return false;
        return true;
    }
}

