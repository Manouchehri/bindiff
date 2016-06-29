package com.google.security.zynamics.zylib.ZyTree;

import java.util.*;
import com.google.security.zynamics.zylib.general.*;

public class PostorderIterator
{
    private final Stack traversalStack;
    private final IZyTreeNode m_root;
    private boolean m_started;
    
    public PostorderIterator(final IZyTreeNode root) {
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
            return !this.traversalStack.empty();
        }
        if (this.traversalStack.empty()) {
            throw new RuntimeException("Internal Error: Traversal already finished");
        }
        while (!this.traversalStack.empty()) {
            final Pair pair = this.traversalStack.pop();
            final int n = (int)pair.second() + 1;
            if (n > ((IZyTreeNode)pair.first()).getChildren().size()) {
                continue;
            }
            if (n == ((IZyTreeNode)pair.first()).getChildren().size()) {
                this.traversalStack.push(new Pair(pair.first(), n));
                return true;
            }
            this.traversalStack.push(new Pair(pair.first(), n));
            this.pushLongestPathFrom((IZyTreeNode)((IZyTreeNode)pair.first()).getChildren().get(n));
            return true;
        }
        return false;
    }
}
