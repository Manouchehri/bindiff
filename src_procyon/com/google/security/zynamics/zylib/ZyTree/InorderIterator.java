package com.google.security.zynamics.zylib.ZyTree;

import java.util.*;
import com.google.security.zynamics.zylib.general.*;

public class InorderIterator
{
    private final Stack traversalStack;
    private final IZyTreeNode m_root;
    private boolean m_started;
    
    public InorderIterator(final IZyTreeNode root) {
        this.traversalStack = new Stack();
        this.m_started = false;
        this.m_root = root;
    }
    
    private void pushLongestPathFrom(final IZyTreeNode zyTreeNode) {
        IZyTreeNode zyTreeNode2 = zyTreeNode;
        while (true) {
            this.traversalStack.push(new Pair(zyTreeNode2, 0));
            if (zyTreeNode2.getChildren().size() == 0) {
                break;
            }
            zyTreeNode2 = (IZyTreeNode)zyTreeNode2.getChildren().get(0);
        }
    }
    
    public IZyTreeNode current() {
        return (IZyTreeNode)((Pair)this.traversalStack.lastElement()).first();
    }
    
    public boolean next() {
        if (!this.m_started) {
            this.pushLongestPathFrom(this.m_root);
            this.m_started = true;
        }
        else {
            if (this.traversalStack.empty()) {
                throw new RuntimeException("Internal Error: Traversal already finished");
            }
            final Pair pair = this.traversalStack.pop();
            final IZyTreeNode zyTreeNode = (IZyTreeNode)pair.first();
            final int intValue = (int)pair.second();
            if (this.traversalStack.empty()) {
                if (intValue == zyTreeNode.getChildren().size()) {
                    return false;
                }
                if (zyTreeNode.getChildren().size() == 0) {
                    throw new RuntimeException("Error");
                }
                if (zyTreeNode.getChildren().size() == 1) {
                    this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(intValue));
                }
                else {
                    this.traversalStack.push(new Pair(((IZyTreeNode)pair.first()).getChildren().get(intValue), 0));
                }
            }
            else if (intValue == zyTreeNode.getChildren().size()) {
                final Pair pair2 = this.traversalStack.pop();
                this.traversalStack.push(new Pair(pair2.first(), (int)pair2.second() + 1));
            }
            else {
                if (zyTreeNode.getChildren().size() == 0) {
                    throw new RuntimeException("Error");
                }
                if (zyTreeNode.getChildren().size() == 1) {
                    this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(intValue));
                }
                else {
                    this.traversalStack.push(new Pair(((IZyTreeNode)pair.first()).getChildren().get(intValue), 0));
                }
            }
        }
        return !this.traversalStack.empty();
    }
}
