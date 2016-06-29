package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.recursion;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class RecursionCriteriumPanel$InternalComboboxListener implements ActionListener
{
    final /* synthetic */ RecursionCriteriumPanel this$0;
    
    private RecursionCriteriumPanel$InternalComboboxListener(final RecursionCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.criterium.update();
    }
}
