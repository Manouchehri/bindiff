package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import javax.swing.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import javax.swing.tree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressionmodel.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import javax.swing.border.*;
import java.awt.*;

class DialogUpdater$InternalTreeSelectionListener implements TreeSelectionListener
{
    final /* synthetic */ DialogUpdater this$0;
    
    private DialogUpdater$InternalTreeSelectionListener(final DialogUpdater this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void valueChanged(final TreeSelectionEvent treeSelectionEvent) {
        final TreePath path = treeSelectionEvent.getPath();
        if (path == null) {
            this.this$0.addConditionButton.setEnabled(false);
            this.this$0.updateDefineConditionPanel((AbstractCriteriumTreeNode)this.this$0.jtree.getModel().getRoot());
        }
        else {
            final AbstractCriteriumTreeNode abstractCriteriumTreeNode = (AbstractCriteriumTreeNode)path.getLastPathComponent();
            boolean allowAppend = abstractCriteriumTreeNode.allowAppend(CriteriumType.CONDITION);
            if (!allowAppend && abstractCriteriumTreeNode.getLevel() > 0) {
                final AbstractCriteriumTreeNode abstractCriteriumTreeNode2 = (AbstractCriteriumTreeNode)abstractCriteriumTreeNode.getParent();
                if (abstractCriteriumTreeNode2.getLevel() != 0 && abstractCriteriumTreeNode2.getCriterium().getType() != CriteriumType.NOT && abstractCriteriumTreeNode.getCriterium().getType() != CriteriumType.NOT) {
                    allowAppend = true;
                }
            }
            this.this$0.addConditionButton.setEnabled(allowAppend);
            this.this$0.updateDefineConditionPanel(abstractCriteriumTreeNode);
        }
    }
}
