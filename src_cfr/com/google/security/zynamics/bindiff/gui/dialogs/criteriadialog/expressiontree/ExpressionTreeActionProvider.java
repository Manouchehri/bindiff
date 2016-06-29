/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider$InternalCriteriumListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.TreePath;

public class ExpressionTreeActionProvider {
    private final JCriteriumTree jtree;
    private final CriteriumTree ctree;
    private final ICriteriumListener internalCriteriumListener;

    public ExpressionTreeActionProvider(JCriteriumTree jCriteriumTree, CriteriumTree criteriumTree) {
        this.internalCriteriumListener = new ExpressionTreeActionProvider$InternalCriteriumListener(this, null);
        this.jtree = jCriteriumTree;
        this.ctree = criteriumTree;
        jCriteriumTree.getModel().setActionProvider(this);
    }

    private ICriteriumTreeNode findNode(ICriteriumTreeNode iCriteriumTreeNode, ICriterium iCriterium) {
        ICriteriumTreeNode iCriteriumTreeNode2;
        ICriteriumTreeNode iCriteriumTreeNode3;
        if (iCriteriumTreeNode.getCriterium() == iCriterium) {
            return iCriteriumTreeNode;
        }
        Iterator iterator = iCriteriumTreeNode.getChildren().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((iCriteriumTreeNode2 = this.findNode(iCriteriumTreeNode3 = (ICriteriumTreeNode)iterator.next(), iCriterium)) == null);
        return iCriteriumTreeNode2;
    }

    public void appendCriterium(ICriterium iCriterium) {
        TreePath treePath = this.jtree.getCurrentCriteriumPath();
        if (treePath == null) {
            return;
        }
        iCriterium.addListener(this.internalCriteriumListener);
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)treePath.getLastPathComponent();
        ICriteriumTreeNode iCriteriumTreeNode = this.findNode(this.ctree.getRoot(), abstractCriteriumTreeNode.getCriterium());
        this.ctree.appendNode(iCriteriumTreeNode, new CriteriumTreeNode(iCriterium));
    }

    public CriteriumTree getCriteriumTree() {
        return this.ctree;
    }

    public JCriteriumTree getJTree() {
        return this.jtree;
    }

    public void insertCriterium(ICriterium iCriterium) {
        TreePath treePath = this.jtree.getCurrentCriteriumPath();
        if (treePath == null) {
            return;
        }
        iCriterium.addListener(this.internalCriteriumListener);
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)treePath.getLastPathComponent();
        ICriteriumTreeNode iCriteriumTreeNode = this.findNode(this.ctree.getRoot(), abstractCriteriumTreeNode.getCriterium());
        this.ctree.insertNode(iCriteriumTreeNode, new CriteriumTreeNode(iCriterium));
    }

    public void remove(TreePath treePath) {
        if (treePath == null) {
            return;
        }
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)treePath.getLastPathComponent();
        ICriteriumTreeNode iCriteriumTreeNode = this.findNode(this.ctree.getRoot(), abstractCriteriumTreeNode.getCriterium());
        this.ctree.removeNode(iCriteriumTreeNode);
    }

    public void removeAll() {
        this.ctree.removeAll();
    }

    static /* synthetic */ JCriteriumTree access$100(ExpressionTreeActionProvider expressionTreeActionProvider) {
        return expressionTreeActionProvider.jtree;
    }
}

