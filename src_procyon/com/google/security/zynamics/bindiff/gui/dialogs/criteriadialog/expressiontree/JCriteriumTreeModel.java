package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import javax.swing.tree.*;
import java.util.*;

public class JCriteriumTreeModel extends DefaultTreeModel
{
    private final CriteriumTree criteriumTree;
    private final List criteria;
    private ExpressionTreeActionProvider actionProvider;
    private final JTree jtree;
    private final ICriteriumTreeListener internalTreeListener;
    
    public JCriteriumTreeModel(final JTree jtree, final CriteriumTree criteriumTree, final List criteria) {
        super(null);
        this.internalTreeListener = new JCriteriumTreeModel$CriteriumTreeListener(this, null);
        this.jtree = jtree;
        this.criteriumTree = criteriumTree;
        this.criteria = criteria;
        this.criteriumTree.addListener(this.internalTreeListener);
    }
    
    private AbstractCriteriumTreeNode findParentNode(final AbstractCriteriumTreeNode abstractCriteriumTreeNode, final ICriterium criterium) {
        if (abstractCriteriumTreeNode.getCriterium() == criterium) {
            return abstractCriteriumTreeNode;
        }
        for (int i = 0; i < abstractCriteriumTreeNode.getChildCount(); ++i) {
            final AbstractCriteriumTreeNode parentNode = this.findParentNode((AbstractCriteriumTreeNode)abstractCriteriumTreeNode.getChildAt(i), criterium);
            if (parentNode != null) {
                return parentNode;
            }
        }
        return null;
    }
    
    @Override
    public void nodeStructureChanged(final TreeNode treeNode) {
        final HashSet<ICriterium> set = new HashSet<ICriterium>();
        final Enumeration<TreePath> expandedDescendants = this.jtree.getExpandedDescendants(new TreePath(this.getRoot()));
        if (expandedDescendants != null) {
            while (expandedDescendants.hasMoreElements()) {
                set.add(((AbstractCriteriumTreeNode)expandedDescendants.nextElement().getLastPathComponent()).getCriterium());
            }
        }
        super.nodeStructureChanged(treeNode);
        final Enumeration breadthFirstEnumeration = ((AbstractCriteriumTreeNode)this.getRoot()).breadthFirstEnumeration();
        while (breadthFirstEnumeration.hasMoreElements()) {
            final AbstractCriteriumTreeNode abstractCriteriumTreeNode = breadthFirstEnumeration.nextElement();
            if (set.contains(abstractCriteriumTreeNode.getCriterium())) {
                this.jtree.expandPath(new TreePath(abstractCriteriumTreeNode.getPath()));
            }
        }
        this.jtree.updateUI();
    }
    
    public void setActionProvider(final ExpressionTreeActionProvider actionProvider) {
        this.actionProvider = actionProvider;
    }
    
    public void sortChildren(final AbstractCriteriumTreeNode parent) {
        final ArrayList<AbstractCriteriumTreeNode> list = new ArrayList<AbstractCriteriumTreeNode>();
        final ArrayList<AbstractCriteriumTreeNode> list2 = new ArrayList<AbstractCriteriumTreeNode>();
        final ArrayList<AbstractCriteriumTreeNode> list3 = (ArrayList<AbstractCriteriumTreeNode>)new ArrayList<Object>();
        final Enumeration children = parent.children();
        while (children.hasMoreElements()) {
            final AbstractCriteriumTreeNode abstractCriteriumTreeNode = children.nextElement();
            if (abstractCriteriumTreeNode.getCriterium().getType() == CriteriumType.CONDITION) {
                list2.add(abstractCriteriumTreeNode);
            }
            else {
                list.add(abstractCriteriumTreeNode);
            }
        }
        parent.removeAllChildren();
        for (final AbstractCriteriumTreeNode abstractCriteriumTreeNode2 : list) {
            parent.add(abstractCriteriumTreeNode2);
            abstractCriteriumTreeNode2.setParent(parent);
        }
        for (final AbstractCriteriumTreeNode abstractCriteriumTreeNode3 : list2) {
            parent.add(abstractCriteriumTreeNode3);
            abstractCriteriumTreeNode3.setParent(parent);
        }
        for (final AbstractCriteriumTreeNode abstractCriteriumTreeNode4 : list3) {
            parent.add(abstractCriteriumTreeNode4);
            abstractCriteriumTreeNode4.setParent(parent);
        }
    }
}
