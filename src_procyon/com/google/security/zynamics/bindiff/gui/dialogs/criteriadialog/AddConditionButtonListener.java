package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.nodes.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions.*;
import javax.swing.*;
import javax.swing.tree.*;

public class AddConditionButtonListener extends AbstractAction
{
    private final JCriteriumTree jtree;
    private final ConditionBox selectionBox;
    private final ExpressionTreeActionProvider actionProvider;
    
    public AddConditionButtonListener(final JCriteriumTree jtree, final ConditionBox selectionBox, final ExpressionTreeActionProvider actionProvider) {
        this.jtree = jtree;
        this.selectionBox = selectionBox;
        this.actionProvider = actionProvider;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final TreePath selectionPath = this.jtree.getSelectionPath();
        if (selectionPath.getPathCount() != 1 && ((AbstractCriteriumTreeNode)selectionPath.getLastPathComponent()).getCriterium().getType() == CriteriumType.CONDITION) {
            this.jtree.setCurrentCriteriumPath(selectionPath.getParentPath());
        }
        else {
            this.jtree.setCurrentCriteriumPath(selectionPath);
        }
        new AddConditionAction(this.selectionBox, this.actionProvider).actionPerformed(actionEvent);
    }
}
