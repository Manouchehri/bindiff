/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$CriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JCriteriumTreeModel
extends DefaultTreeModel {
    private final CriteriumTree criteriumTree;
    private final List criteria;
    private ExpressionTreeActionProvider actionProvider;
    private final JTree jtree;
    private final ICriteriumTreeListener internalTreeListener;

    public JCriteriumTreeModel(JTree jTree, CriteriumTree criteriumTree, List list) {
        super(null);
        this.internalTreeListener = new JCriteriumTreeModel$CriteriumTreeListener(this, null);
        this.jtree = jTree;
        this.criteriumTree = criteriumTree;
        this.criteria = list;
        this.criteriumTree.addListener(this.internalTreeListener);
    }

    private AbstractCriteriumTreeNode findParentNode(AbstractCriteriumTreeNode abstractCriteriumTreeNode, ICriterium iCriterium) {
        if (abstractCriteriumTreeNode.getCriterium() == iCriterium) {
            return abstractCriteriumTreeNode;
        }
        int n2 = 0;
        while (n2 < abstractCriteriumTreeNode.getChildCount()) {
            AbstractCriteriumTreeNode abstractCriteriumTreeNode2 = (AbstractCriteriumTreeNode)abstractCriteriumTreeNode.getChildAt(n2);
            AbstractCriteriumTreeNode abstractCriteriumTreeNode3 = this.findParentNode(abstractCriteriumTreeNode2, iCriterium);
            if (abstractCriteriumTreeNode3 != null) {
                return abstractCriteriumTreeNode3;
            }
            ++n2;
        }
        return null;
    }

    @Override
    public void nodeStructureChanged(TreeNode treeNode) {
        Object object;
        AbstractCriteriumTreeNode abstractCriteriumTreeNode;
        HashSet<ICriterium> hashSet = new HashSet<ICriterium>();
        Enumeration<TreePath> enumeration = this.jtree.getExpandedDescendants(new TreePath(this.getRoot()));
        if (enumeration != null) {
            while (enumeration.hasMoreElements()) {
                object = enumeration.nextElement();
                abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)object.getLastPathComponent();
                hashSet.add(abstractCriteriumTreeNode.getCriterium());
            }
        }
        super.nodeStructureChanged(treeNode);
        object = ((AbstractCriteriumTreeNode)this.getRoot()).breadthFirstEnumeration();
        do {
            if (!object.hasMoreElements()) {
                this.jtree.updateUI();
                return;
            }
            abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)object.nextElement();
            if (!hashSet.contains(abstractCriteriumTreeNode.getCriterium())) continue;
            this.jtree.expandPath(new TreePath(abstractCriteriumTreeNode.getPath()));
        } while (true);
    }

    public void setActionProvider(ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.actionProvider = expressionTreeActionProvider;
    }

    public void sortChildren(AbstractCriteriumTreeNode abstractCriteriumTreeNode) {
        Object object2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Enumeration enumeration = abstractCriteriumTreeNode.children();
        while (enumeration.hasMoreElements()) {
            object2 = (AbstractCriteriumTreeNode)enumeration.nextElement();
            CriteriumType object32 = object2.getCriterium().getType();
            if (object32 == CriteriumType.CONDITION) {
                arrayList2.add(object2);
                continue;
            }
            arrayList.add(object2);
        }
        abstractCriteriumTreeNode.removeAllChildren();
        for (AbstractCriteriumTreeNode abstractCriteriumTreeNode2 : arrayList) {
            abstractCriteriumTreeNode.add(abstractCriteriumTreeNode2);
            abstractCriteriumTreeNode2.setParent(abstractCriteriumTreeNode);
        }
        for (AbstractCriteriumTreeNode abstractCriteriumTreeNode3 : arrayList2) {
            abstractCriteriumTreeNode.add(abstractCriteriumTreeNode3);
            abstractCriteriumTreeNode3.setParent(abstractCriteriumTreeNode);
        }
        object2 = arrayList3.iterator();
        while (object2.hasNext()) {
            AbstractCriteriumTreeNode abstractCriteriumTreeNode4 = (AbstractCriteriumTreeNode)object2.next();
            abstractCriteriumTreeNode.add(abstractCriteriumTreeNode4);
            abstractCriteriumTreeNode4.setParent(abstractCriteriumTreeNode);
        }
    }

    static /* synthetic */ AbstractCriteriumTreeNode access$100(JCriteriumTreeModel jCriteriumTreeModel, AbstractCriteriumTreeNode abstractCriteriumTreeNode, ICriterium iCriterium) {
        return jCriteriumTreeModel.findParentNode(abstractCriteriumTreeNode, iCriterium);
    }

    static /* synthetic */ List access$200(JCriteriumTreeModel jCriteriumTreeModel) {
        return jCriteriumTreeModel.criteria;
    }

    static /* synthetic */ ExpressionTreeActionProvider access$300(JCriteriumTreeModel jCriteriumTreeModel) {
        return jCriteriumTreeModel.actionProvider;
    }

    static /* synthetic */ JTree access$400(JCriteriumTreeModel jCriteriumTreeModel) {
        return jCriteriumTreeModel.jtree;
    }
}

