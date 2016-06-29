/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.AbstractCriteriumTreeNode;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class RemoveAction
extends AbstractAction {
    private final AbstractCriteriumTreeNode node;
    private final ExpressionTreeActionProvider actionProvider;

    public RemoveAction(AbstractCriteriumTreeNode abstractCriteriumTreeNode, ExpressionTreeActionProvider expressionTreeActionProvider) {
        super("Remove");
        this.node = abstractCriteriumTreeNode;
        this.actionProvider = expressionTreeActionProvider;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionProvider.remove(new TreePath(this.node.getPath()));
    }
}

