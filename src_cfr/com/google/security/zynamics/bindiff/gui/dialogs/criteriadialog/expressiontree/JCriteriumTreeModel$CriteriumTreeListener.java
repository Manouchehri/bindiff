/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.CriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.ICriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ICriteriumTreeListener;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.CriteriumTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

class JCriteriumTreeModel$CriteriumTreeListener
implements ICriteriumTreeListener {
    final /* synthetic */ JCriteriumTreeModel this$0;

    private JCriteriumTreeModel$CriteriumTreeListener(JCriteriumTreeModel jCriteriumTreeModel) {
        this.this$0 = jCriteriumTreeModel;
    }

    @Override
    public void nodeAppended(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = JCriteriumTreeModel.access$100(this.this$0, (AbstractCriteriumTreeNode)this.this$0.getRoot(), iCriteriumTreeNode.getCriterium());
        CriteriumTreeNode criteriumTreeNode = new CriteriumTreeNode(iCriteriumTreeNode2.getCriterium(), JCriteriumTreeModel.access$200(this.this$0), JCriteriumTreeModel.access$300(this.this$0));
        abstractCriteriumTreeNode.add(criteriumTreeNode);
        criteriumTreeNode.setParent(abstractCriteriumTreeNode);
        this.this$0.sortChildren(abstractCriteriumTreeNode);
        this.this$0.nodeStructureChanged(abstractCriteriumTreeNode);
        JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(criteriumTreeNode.getPath()));
    }

    @Override
    public void nodeInserted(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode, ICriteriumTreeNode iCriteriumTreeNode2) {
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = JCriteriumTreeModel.access$100(this.this$0, (CriteriumTreeNode)this.this$0.getRoot(), iCriteriumTreeNode.getCriterium());
        CriteriumTreeNode criteriumTreeNode = new CriteriumTreeNode(iCriteriumTreeNode2.getCriterium(), JCriteriumTreeModel.access$200(this.this$0), JCriteriumTreeModel.access$300(this.this$0));
        ArrayList<AbstractCriteriumTreeNode> arrayList = new ArrayList<AbstractCriteriumTreeNode>();
        Enumeration enumeration = abstractCriteriumTreeNode.children();
        while (enumeration.hasMoreElements()) {
            arrayList.add((AbstractCriteriumTreeNode)enumeration.nextElement());
        }
        Iterator iterator = arrayList.iterator();
        do {
            if (!iterator.hasNext()) {
                abstractCriteriumTreeNode.removeAllChildren();
                abstractCriteriumTreeNode.add(criteriumTreeNode);
                criteriumTreeNode.setParent(abstractCriteriumTreeNode);
                this.this$0.nodeStructureChanged(abstractCriteriumTreeNode);
                JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(criteriumTreeNode.getPath()));
                return;
            }
            AbstractCriteriumTreeNode abstractCriteriumTreeNode2 = (AbstractCriteriumTreeNode)iterator.next();
            criteriumTreeNode.add(abstractCriteriumTreeNode2);
            abstractCriteriumTreeNode2.setParent(criteriumTreeNode);
        } while (true);
    }

    @Override
    public void nodeRemoved(CriteriumTree criteriumTree, ICriteriumTreeNode iCriteriumTreeNode) {
        AbstractCriteriumTreeNode abstractCriteriumTreeNode = JCriteriumTreeModel.access$100(this.this$0, (CriteriumTreeNode)this.this$0.getRoot(), iCriteriumTreeNode.getCriterium());
        abstractCriteriumTreeNode.deleteChildren();
        AbstractCriteriumTreeNode abstractCriteriumTreeNode2 = (AbstractCriteriumTreeNode)abstractCriteriumTreeNode.getParent();
        abstractCriteriumTreeNode2.remove(abstractCriteriumTreeNode);
        this.this$0.nodeStructureChanged(abstractCriteriumTreeNode);
        JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(abstractCriteriumTreeNode2.getPath()));
    }

    @Override
    public void removedAll(CriteriumTree criteriumTree) {
        CriteriumTreeNode criteriumTreeNode = (CriteriumTreeNode)this.this$0.getRoot();
        criteriumTreeNode.deleteChildren();
        this.this$0.nodeStructureChanged(criteriumTreeNode);
        JCriteriumTreeModel.access$400(this.this$0).setSelectionPath(new TreePath(criteriumTreeNode.getPath()));
    }

    /* synthetic */ JCriteriumTreeModel$CriteriumTreeListener(JCriteriumTreeModel jCriteriumTreeModel, JCriteriumTreeModel$1 jCriteriumTreeModel$1) {
        this(jCriteriumTreeModel);
    }
}

