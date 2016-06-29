/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.ConditionBox;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumType;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.JCriteriumTree;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.AddConditionAction;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.tree.TreePath;

public class AddConditionButtonListener
extends AbstractAction {
    private final JCriteriumTree jtree;
    private final ConditionBox selectionBox;
    private final ExpressionTreeActionProvider actionProvider;

    public AddConditionButtonListener(JCriteriumTree jCriteriumTree, ConditionBox conditionBox, ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.jtree = jCriteriumTree;
        this.selectionBox = conditionBox;
        this.actionProvider = expressionTreeActionProvider;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean bl2;
        TreePath treePath = this.jtree.getSelectionPath();
        boolean bl3 = bl2 = treePath.getPathCount() == 1;
        if (!bl2 && ((AbstractCriteriumTreeNode)treePath.getLastPathComponent()).getCriterium().getType() == CriteriumType.CONDITION) {
            this.jtree.setCurrentCriteriumPath(treePath.getParentPath());
        } else {
            this.jtree.setCurrentCriteriumPath(treePath);
        }
        new AddConditionAction(this.selectionBox, this.actionProvider).actionPerformed(actionEvent);
    }
}

