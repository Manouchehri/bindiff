package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.selection;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class CSelectionCriteriumPanel$InternalComboboxListener implements ActionListener
{
    final /* synthetic */ CSelectionCriteriumPanel this$0;
    
    private CSelectionCriteriumPanel$InternalComboboxListener(final CSelectionCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.criterium.update();
    }
}
