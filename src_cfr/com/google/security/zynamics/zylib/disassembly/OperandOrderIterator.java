/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.disassembly;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.disassembly.ExpressionType;
import com.google.security.zynamics.zylib.disassembly.IOperandTreeNode;
import com.google.security.zynamics.zylib.general.Pair;
import java.util.List;
import java.util.Stack;

public class OperandOrderIterator {
    private final Stack m_traversalStack = new Stack();
    private final IOperandTreeNode m_root;
    private boolean m_started = false;

    public OperandOrderIterator(IOperandTreeNode iOperandTreeNode) {
        Preconditions.checkNotNull(iOperandTreeNode, "Internal Error: Root node can't be null");
        this.m_root = iOperandTreeNode;
    }

    private void pushLongestPathFrom(IOperandTreeNode iOperandTreeNode) {
        IOperandTreeNode iOperandTreeNode2 = iOperandTreeNode;
        do {
            this.m_traversalStack.push(new Pair(iOperandTreeNode2, 0));
            if (iOperandTreeNode2.getChildren().size() <= 1) return;
            if (iOperandTreeNode2.getType() == ExpressionType.EXPRESSION_LIST) {
                return;
            }
            iOperandTreeNode2 = (IOperandTreeNode)iOperandTreeNode2.getChildren().get(0);
        } while (true);
    }

    public IOperandTreeNode current() {
        return (IOperandTreeNode)((Pair)this.m_traversalStack.lastElement()).first();
    }

    public boolean next() {
        if (!this.m_started) {
            this.pushLongestPathFrom(this.m_root);
            this.m_started = true;
        } else {
            if (this.m_traversalStack.empty()) {
                throw new RuntimeException("Internal Error: Traversal already finished");
            }
            Pair pair = (Pair)this.m_traversalStack.pop();
            IOperandTreeNode iOperandTreeNode = (IOperandTreeNode)pair.first();
            int n2 = (Integer)pair.second();
            if (n2 < iOperandTreeNode.getChildren().size()) {
                if (((IOperandTreeNode)pair.first()).getChildren().size() > 1) {
                    this.m_traversalStack.add(pair);
                }
                this.pushLongestPathFrom((IOperandTreeNode)iOperandTreeNode.getChildren().get(n2));
                return true;
            }
            if (this.m_traversalStack.empty()) {
                return false;
            }
            do {
                Pair pair2;
                if ((Integer)(pair2 = (Pair)this.m_traversalStack.pop()).second() >= ((IOperandTreeNode)pair2.first()).getChildren().size() - 1) continue;
                this.m_traversalStack.push(new Pair(pair2.first(), (Integer)pair2.second() + 1));
                return true;
            } while (!this.m_traversalStack.empty());
        }
        if (this.m_traversalStack.empty()) return false;
        return true;
    }
}

