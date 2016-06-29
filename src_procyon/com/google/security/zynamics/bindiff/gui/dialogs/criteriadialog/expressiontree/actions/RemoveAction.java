package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import java.awt.event.*;
import javax.swing.tree.*;

public class RemoveAction extends AbstractAction
{
    private final AbstractCriteriumTreeNode node;
    private final ExpressionTreeActionProvider actionProvider;
    
    public RemoveAction(final AbstractCriteriumTreeNode node, final ExpressionTreeActionProvider actionProvider) {
        super("Remove");
        this.node = node;
        this.actionProvider = actionProvider;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.actionProvider.remove(new TreePath(this.node.getPath()));
    }
}
