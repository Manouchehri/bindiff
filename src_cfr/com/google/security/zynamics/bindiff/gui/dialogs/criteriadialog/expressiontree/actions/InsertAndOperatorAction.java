/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.AndCriterium;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class InsertAndOperatorAction
extends AbstractAction {
    private final ExpressionTreeActionProvider actionProvider;

    public InsertAndOperatorAction(ExpressionTreeActionProvider expressionTreeActionProvider) {
        super("Insert AND");
        this.actionProvider = expressionTreeActionProvider;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionProvider.insertCriterium(new AndCriterium());
    }
}

