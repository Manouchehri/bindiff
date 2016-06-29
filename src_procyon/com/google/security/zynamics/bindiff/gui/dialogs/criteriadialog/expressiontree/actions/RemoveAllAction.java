package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.actions;

import javax.swing.*;
import com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.expressiontree.*;
import java.awt.event.*;

public class RemoveAllAction extends AbstractAction
{
    private final ExpressionTreeActionProvider actionProvider;
    
    public RemoveAllAction(final ExpressionTreeActionProvider actionProvider) {
        super("Remove All");
        this.actionProvider = actionProvider;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.actionProvider.removeAll();
    }
}
