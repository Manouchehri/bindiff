/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.zylib.types.common.ICollectionFilter;
import com.google.security.zynamics.zylib.yfileswrap.gui.zygraph.nodes.ZyGraphNode;
import java.util.Iterator;
import java.util.List;

class CriteriumExecuter$CriteriumFilter
implements ICollectionFilter {
    private final CriteriumTree tree;

    public CriteriumExecuter$CriteriumFilter(CriteriumTree criteriumTree) {
        this.tree = criteriumTree;
    }

    private boolean qualifies(ICriteriumTreeNode iCriteriumTreeNode, ZyGraphNode zyGraphNode) {
        List list = iCriteriumTreeNode.getChildren();
        if (iCriteriumTreeNode.equals(this.tree.getRoot())) {
            if (list.size() == 1) return this.qualifies((ICriteriumTreeNode)list.get(0), zyGraphNode);
            throw new IllegalStateException("Root node has more or less than one child criterium.");
        }
        if (iCriteriumTreeNode.getCriterium().getType() == CriteriumType.AND) {
            ICriteriumTreeNode iCriteriumTreeNode2;
            if (list.size() < 2) {
                throw new IllegalStateException("AND operator has less than two child criteria.");
            }
            Iterator iterator = iCriteriumTreeNode.getChildren().iterator();
            do {
                if (!iterator.hasNext()) return true;
            } while (this.qualifies(iCriteriumTreeNode2 = (ICriteriumTreeNode)iterator.next(), zyGraphNode));
            return false;
        }
        if (iCriteriumTreeNode.getCriterium().getType() == CriteriumType.OR) {
            ICriteriumTreeNode iCriteriumTreeNode3;
            if (list.size() < 2) {
                throw new IllegalStateException("AND operator has less than two child criteria.");
            }
            Iterator iterator = iCriteriumTreeNode.getChildren().iterator();
            do {
                if (!iterator.hasNext()) return false;
            } while (!this.qualifies(iCriteriumTreeNode3 = (ICriteriumTreeNode)iterator.next(), zyGraphNode));
            return true;
        }
        if (iCriteriumTreeNode.getCriterium().getType() != CriteriumType.NOT) {
            if (!(iCriteriumTreeNode instanceof CriteriumTreeNode)) throw new IllegalStateException("Unknown criterium.");
            CriteriumTreeNode criteriumTreeNode = (CriteriumTreeNode)iCriteriumTreeNode;
            return criteriumTreeNode.getCriterium().matches(zyGraphNode);
        }
        if (list.size() != 1) {
            throw new IllegalStateException("NOT operator has more or less than one child criterium.");
        }
        if (this.qualifies((ICriteriumTreeNode)list.get(0), zyGraphNode)) return false;
        return true;
    }

    public boolean qualifies(ZyGraphNode zyGraphNode) {
        return this.qualifies(this.tree.getRoot(), zyGraphNode);
    }
}

