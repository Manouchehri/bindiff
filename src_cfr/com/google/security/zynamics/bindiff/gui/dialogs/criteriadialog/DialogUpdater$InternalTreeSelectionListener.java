/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.DialogUpdater$1;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTreeModel;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

class DialogUpdater$InternalTreeSelectionListener
implements TreeSelectionListener {
    final /* synthetic */ DialogUpdater this$0;

    private DialogUpdater$InternalTreeSelectionListener(DialogUpdater dialogUpdater) {
        this.this$0 = dialogUpdater;
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        AbstractCriteriumTreeNode abstractCriteriumTreeNode;
        TreePath treePath = treeSelectionEvent.getPath();
        if (treePath == null) {
            DialogUpdater.access$700(this.this$0).setEnabled(false);
            DialogUpdater.access$400(this.this$0, (AbstractCriteriumTreeNode)DialogUpdater.access$200(this.this$0).getModel().getRoot());
            return;
        }
        AbstractCriteriumTreeNode abstractCriteriumTreeNode2 = (AbstractCriteriumTreeNode)treePath.getLastPathComponent();
        boolean bl2 = abstractCriteriumTreeNode2.allowAppend(CriteriumType.CONDITION);
        if (!bl2 && abstractCriteriumTreeNode2.getLevel() > 0 && (abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)abstractCriteriumTreeNode2.getParent()).getLevel() != 0 && abstractCriteriumTreeNode.getCriterium().getType() != CriteriumType.NOT && abstractCriteriumTreeNode2.getCriterium().getType() != CriteriumType.NOT) {
            bl2 = true;
        }
        DialogUpdater.access$700(this.this$0).setEnabled(bl2);
        DialogUpdater.access$400(this.this$0, abstractCriteriumTreeNode2);
    }

    /* synthetic */ DialogUpdater$InternalTreeSelectionListener(DialogUpdater dialogUpdater, DialogUpdater$1 dialogUpdater$1) {
        this(dialogUpdater);
    }
}

