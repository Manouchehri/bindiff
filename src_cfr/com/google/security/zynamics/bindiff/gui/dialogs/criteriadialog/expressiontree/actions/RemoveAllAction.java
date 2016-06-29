/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class RemoveAllAction
extends AbstractAction {
    private final ExpressionTreeActionProvider actionProvider;

    public RemoveAllAction(ExpressionTreeActionProvider expressionTreeActionProvider) {
        super("Remove All");
        this.actionProvider = expressionTreeActionProvider;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionProvider.removeAll();
    }
}

