/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CriteriumTreeNode
implements ICriteriumTreeNode {
    private final List children = new ArrayList();
    private ICriteriumTreeNode parent;
    private final ICriterium criterium;

    public CriteriumTreeNode(ICriterium iCriterium) {
        this.criterium = iCriterium;
    }

    public static void append(ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        iCriteriumTreeNode.getChildren().add(iCriteriumTreeNode2);
        iCriteriumTreeNode2.setParent(iCriteriumTreeNode);
    }

    public static void insert(ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        Iterator iterator = iCriteriumTreeNode.getChildren().iterator();
        do {
            if (!iterator.hasNext()) {
                iCriteriumTreeNode.getChildren().clear();
                iCriteriumTreeNode.getChildren().add(iCriteriumTreeNode2);
                iCriteriumTreeNode2.setParent(iCriteriumTreeNode);
                return;
            }
            ICriteriumTreeNode iCriteriumTreeNode3 = (ICriteriumTreeNode)iterator.next();
            iCriteriumTreeNode2.getChildren().add(iCriteriumTreeNode3);
            iCriteriumTreeNode3.setParent(iCriteriumTreeNode2);
        } while (true);
    }

    public static void remove(ICriteriumTreeNode iCriteriumTreeNode) {
        Iterator iterator = iCriteriumTreeNode.getChildren().iterator();
        do {
            if (!iterator.hasNext()) {
                iCriteriumTreeNode.getChildren().clear();
                return;
            }
            ICriteriumTreeNode iCriteriumTreeNode2 = (ICriteriumTreeNode)iterator.next();
            CriteriumTreeNode.remove(iCriteriumTreeNode2);
        } while (true);
    }

    @Override
    public List getChildren() {
        return this.children;
    }

    @Override
    public ICriterium getCriterium() {
        return this.criterium;
    }

    @Override
    public ICriteriumTreeNode getParent() {
        return this.parent;
    }

    @Override
    public void setParent(ICriteriumTreeNode iCriteriumTreeNode) {
        this.parent = iCriteriumTreeNode;
    }
}

