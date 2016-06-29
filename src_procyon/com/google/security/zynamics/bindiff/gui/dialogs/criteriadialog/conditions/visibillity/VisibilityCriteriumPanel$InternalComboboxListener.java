package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.visibillity;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

class VisibilityCriteriumPanel$InternalComboboxListener implements ActionListener
{
    final /* synthetic */ VisibilityCriteriumPanel this$0;
    
    private VisibilityCriteriumPanel$InternalComboboxListener(final VisibilityCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.criterium.update();
    }
}
