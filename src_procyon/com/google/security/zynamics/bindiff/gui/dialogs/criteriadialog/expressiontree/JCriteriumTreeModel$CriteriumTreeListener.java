package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.tree.*;
import javax.swing.*;
import java.util.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

class JCriteriumTreeModel$CriteriumTreeListener implements ICriteriumTreeListener
{
    final /* synthetic */ JCriteriumTreeModel this$0;
    
    private JCriteriumTreeModel$CriteriumTreeListener(final JCriteriumTreeModel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void nodeAppended(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        final AbstractCriteriumTreeNode access$100 = this.this$0.findParentNode((AbstractCriteriumTreeNode)this.this$0.getRoot(), criteriumTreeNode.getCriterium());
        final CriteriumTreeNode criteriumTreeNode3 = new CriteriumTreeNode(criteriumTreeNode2.getCriterium(), this.this$0.criteria, this.this$0.actionProvider);
        access$100.add(criteriumTreeNode3);
        criteriumTreeNode3.setParent(access$100);
        this.this$0.sortChildren(access$100);
        this.this$0.nodeStructureChanged(access$100);
        this.this$0.jtree.setSelectionPath(new TreePath(criteriumTreeNode3.getPath()));
    }
    
    @Override
    public void nodeInserted(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode, final ICriteriumTreeNode criteriumTreeNode2) {
        final AbstractCriteriumTreeNode access$100 = this.this$0.findParentNode((AbstractCriteriumTreeNode)this.this$0.getRoot(), criteriumTreeNode.getCriterium());
        final CriteriumTreeNode parent = new CriteriumTreeNode(criteriumTreeNode2.getCriterium(), this.this$0.criteria, this.this$0.actionProvider);
        final ArrayList<AbstractCriteriumTreeNode> list = new ArrayList<AbstractCriteriumTreeNode>();
        final Enumeration children = access$100.children();
        while (children.hasMoreElements()) {
            list.add(children.nextElement());
        }
        for (final AbstractCriteriumTreeNode abstractCriteriumTreeNode : list) {
            parent.add(abstractCriteriumTreeNode);
            abstractCriteriumTreeNode.setParent(parent);
        }
        access$100.removeAllChildren();
        access$100.add(parent);
        parent.setParent(access$100);
        this.this$0.nodeStructureChanged(access$100);
        this.this$0.jtree.setSelectionPath(new TreePath(parent.getPath()));
    }
    
    @Override
    public void nodeRemoved(final CriteriumTree criteriumTree, final ICriteriumTreeNode criteriumTreeNode) {
        final AbstractCriteriumTreeNode access$100 = this.this$0.findParentNode((AbstractCriteriumTreeNode)this.this$0.getRoot(), criteriumTreeNode.getCriterium());
        access$100.deleteChildren();
        final AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)access$100.getParent();
        abstractCriteriumTreeNode.remove(access$100);
        this.this$0.nodeStructureChanged(access$100);
        this.this$0.jtree.setSelectionPath(new TreePath(abstractCriteriumTreeNode.getPath()));
    }
    
    @Override
    public void removedAll(final CriteriumTree criteriumTree) {
        final CriteriumTreeNode criteriumTreeNode = (CriteriumTreeNode)this.this$0.getRoot();
        criteriumTreeNode.deleteChildren();
        this.this$0.nodeStructureChanged(criteriumTreeNode);
        this.this$0.jtree.setSelectionPath(new TreePath(criteriumTreeNode.getPath()));
    }
}
