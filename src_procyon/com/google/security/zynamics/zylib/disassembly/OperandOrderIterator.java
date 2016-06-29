package com.google.security.zynamics.zylib.disassembly;

import java.util.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.general.*;

public class OperandOrderIterator
{
    private final Stack m_traversalStack;
    private final IOperandTreeNode m_root;
    private boolean m_started;
    
    public OperandOrderIterator(final IOperandTreeNode root) {
        this.m_traversalStack = new Stack();
        this.m_started = false;
        Preconditions.checkNotNull(root, (Object)"Internal Error: Root node can't be null");
        this.m_root = root;
    }
    
    private void pushLongestPathFrom(final IOperandTreeNode operandTreeNode) {
        IOperandTreeNode operandTreeNode2 = operandTreeNode;
        while (true) {
            this.m_traversalStack.push(new Pair(operandTreeNode2, 0));
            if (operandTreeNode2.getChildren().size() <= 1 || operandTreeNode2.getType() == ExpressionType.EXPRESSION_LIST) {
                break;
            }
            operandTreeNode2 = (IOperandTreeNode)operandTreeNode2.getChildren().get(0);
        }
    }
    
    public IOperandTreeNode current() {
        return (IOperandTreeNode)((Pair)this.m_traversalStack.lastElement()).first();
    }
    
    public boolean next() {
        if (!this.m_started) {
            this.pushLongestPathFrom(this.m_root);
            this.m_started = true;
        }
        else {
            if (this.m_traversalStack.empty()) {
                throw new RuntimeException("Internal Error: Traversal already finished");
            }
            final Pair pair = this.m_traversalStack.pop();
            final IOperandTreeNode operandTreeNode = (IOperandTreeNode)pair.first();
            final int intValue = (int)pair.second();
            if (intValue < operandTreeNode.getChildren().size()) {
                if (((IOperandTreeNode)pair.first()).getChildren().size() > 1) {
                    this.m_traversalStack.add(pair);
                }
                this.pushLongestPathFrom((IOperandTreeNode)operandTreeNode.getChildren().get(intValue));
                return true;
            }
            if (this.m_traversalStack.empty()) {
                return false;
            }
            do {
                final Pair pair2 = this.m_traversalStack.pop();
                if ((int)pair2.second() < ((IOperandTreeNode)pair2.first()).getChildren().size() - 1) {
                    this.m_traversalStack.push(new Pair(pair2.first(), (int)pair2.second() + 1));
                    return true;
                }
            } while (!this.m_traversalStack.empty());
        }
        return !this.m_traversalStack.empty();
    }
}
