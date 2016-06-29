package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import javax.swing.tree.*;

public class ExpressionTreeActionProvider
{
    private final JCriteriumTree jtree;
    private final CriteriumTree ctree;
    private final ICriteriumListener internalCriteriumListener;
    
    public ExpressionTreeActionProvider(final JCriteriumTree jtree, final CriteriumTree ctree) {
        this.internalCriteriumListener = new ExpressionTreeActionProvider$InternalCriteriumListener(this, null);
        this.jtree = jtree;
        this.ctree = ctree;
        jtree.getModel().setActionProvider(this);
    }
    
    private ICriteriumTreeNode findNode(final ICriteriumTreeNode criteriumTreeNode, final ICriterium criterium) {
        if (criteriumTreeNode.getCriterium() == criterium) {
            return criteriumTreeNode;
        }
        final Iterator<ICriteriumTreeNode> iterator = criteriumTreeNode.getChildren().iterator();
        while (iterator.hasNext()) {
            final ICriteriumTreeNode node = this.findNode(iterator.next(), criterium);
            if (node != null) {
                return node;
            }
        }
        return null;
    }
    
    public void appendCriterium(final ICriterium criterium) {
        final TreePath currentCriteriumPath = this.jtree.getCurrentCriteriumPath();
        if (currentCriteriumPath == null) {
            return;
        }
        criterium.addListener(this.internalCriteriumListener);
        this.ctree.appendNode(this.findNode(this.ctree.getRoot(), ((AbstractCriteriumTreeNode)currentCriteriumPath.getLastPathComponent()).getCriterium()), new CriteriumTreeNode(criterium));
    }
    
    public CriteriumTree getCriteriumTree() {
        return this.ctree;
    }
    
    public JCriteriumTree getJTree() {
        return this.jtree;
    }
    
    public void insertCriterium(final ICriterium criterium) {
        final TreePath currentCriteriumPath = this.jtree.getCurrentCriteriumPath();
        if (currentCriteriumPath == null) {
            return;
        }
        criterium.addListener(this.internalCriteriumListener);
        this.ctree.insertNode(this.findNode(this.ctree.getRoot(), ((AbstractCriteriumTreeNode)currentCriteriumPath.getLastPathComponent()).getCriterium()), new CriteriumTreeNode(criterium));
    }
    
    public void remove(final TreePath treePath) {
        if (treePath == null) {
            return;
        }
        this.ctree.removeNode(this.findNode(this.ctree.getRoot(), ((AbstractCriteriumTreeNode)treePath.getLastPathComponent()).getCriterium()));
    }
    
    public void removeAll() {
        this.ctree.removeAll();
    }
}
