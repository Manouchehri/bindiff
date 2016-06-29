package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;
import java.awt.event.*;

public class AddConditionAction extends AbstractAction
{
    private final ICriteriumCreator condition;
    private final ExpressionTreeActionProvider actionProvider;
    
    public AddConditionAction(final ICriteriumCreator condition, final ExpressionTreeActionProvider actionProvider) {
        super(condition.getCriteriumDescription());
        this.condition = condition;
        this.actionProvider = actionProvider;
    }
    
    public AddConditionAction(final JComboBox comboBox, final ExpressionTreeActionProvider actionProvider) {
        this.condition = (ICriteriumCreator)((CriteriumWrapper)comboBox.getSelectedItem()).getObject();
        this.actionProvider = actionProvider;
        if (this.condition != null) {
            this.putValue("Name", this.condition.getCriteriumDescription());
        }
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.actionProvider.appendCriterium(this.condition.createCriterium());
    }
}
