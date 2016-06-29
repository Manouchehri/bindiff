/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.CriteriumWrapper;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriterium;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.ICriteriumCreator;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.ExpressionTreeActionProvider;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;

public class AddConditionAction
extends AbstractAction {
    private final ICriteriumCreator condition;
    private final ExpressionTreeActionProvider actionProvider;

    public AddConditionAction(ICriteriumCreator iCriteriumCreator, ExpressionTreeActionProvider expressionTreeActionProvider) {
        super(iCriteriumCreator.getCriteriumDescription());
        this.condition = iCriteriumCreator;
        this.actionProvider = expressionTreeActionProvider;
    }

    public AddConditionAction(JComboBox jComboBox, ExpressionTreeActionProvider expressionTreeActionProvider) {
        this.condition = (ICriteriumCreator)((CriteriumWrapper)jComboBox.getSelectedItem()).getObject();
        this.actionProvider = expressionTreeActionProvider;
        if (this.condition == null) return;
        this.putValue("Name", this.condition.getCriteriumDescription());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.actionProvider.appendCriterium(this.condition.createCriterium());
    }
}

