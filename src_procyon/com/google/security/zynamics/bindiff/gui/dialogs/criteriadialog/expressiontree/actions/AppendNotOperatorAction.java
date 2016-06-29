package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import java.awt.event.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.operators.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.criterium.*;

public class AppendNotOperatorAction extends AbstractAction
{
    private final ExpressionTreeActionProvider actionProvider;
    
    public AppendNotOperatorAction(final ExpressionTreeActionProvider actionProvider) {
        super("Append NOT");
        this.actionProvider = actionProvider;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.actionProvider.appendCriterium(new NotCriterium());
    }
}
