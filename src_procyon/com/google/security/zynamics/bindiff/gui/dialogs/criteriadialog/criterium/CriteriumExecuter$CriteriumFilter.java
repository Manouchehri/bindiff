package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.zylib.types.common.*;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import java.util.*;

class CriteriumExecuter$CriteriumFilter implements ICollectionFilter
{
    private final CriteriumTree tree;
    
    public CriteriumExecuter$CriteriumFilter(final CriteriumTree tree) {
        this.tree = tree;
    }
    
    private boolean qualifies(final ICriteriumTreeNode criteriumTreeNode, final ZyGraphNode zyGraphNode) {
        final List children = criteriumTreeNode.getChildren();
        if (criteriumTreeNode.equals(this.tree.getRoot())) {
            if (children.size() != 1) {
                throw new IllegalStateException("Root node has more or less than one child criterium.");
            }
            return this.qualifies(children.get(0), zyGraphNode);
        }
        else if (criteriumTreeNode.getCriterium().getType() == CriteriumType.AND) {
            if (children.size() < 2) {
                throw new IllegalStateException("AND operator has less than two child criteria.");
            }
            final Iterator<ICriteriumTreeNode> iterator = criteriumTreeNode.getChildren().iterator();
            while (iterator.hasNext()) {
                if (!this.qualifies(iterator.next(), zyGraphNode)) {
                    return false;
                }
            }
            return true;
        }
        else if (criteriumTreeNode.getCriterium().getType() == CriteriumType.OR) {
            if (children.size() < 2) {
                throw new IllegalStateException("AND operator has less than two child criteria.");
            }
            final Iterator<ICriteriumTreeNode> iterator2 = criteriumTreeNode.getChildren().iterator();
            while (iterator2.hasNext()) {
                if (this.qualifies(iterator2.next(), zyGraphNode)) {
                    return true;
                }
            }
            return false;
        }
        else if (criteriumTreeNode.getCriterium().getType() == CriteriumType.NOT) {
            if (children.size() != 1) {
                throw new IllegalStateException("NOT operator has more or less than one child criterium.");
            }
            return !this.qualifies(children.get(0), zyGraphNode);
        }
        else {
            if (criteriumTreeNode instanceof CriteriumTreeNode) {
                return ((CriteriumTreeNode)criteriumTreeNode).getCriterium().matches(zyGraphNode);
            }
            throw new IllegalStateException("Unknown criterium.");
        }
    }
    
    public boolean qualifies(final ZyGraphNode zyGraphNode) {
        return this.qualifies(this.tree.getRoot(), zyGraphNode);
    }
}
