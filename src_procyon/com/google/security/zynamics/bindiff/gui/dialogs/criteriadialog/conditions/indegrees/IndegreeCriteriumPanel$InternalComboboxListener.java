package com.google.security.zynamics.bindiff.gui.dialogs.criteriadialog.conditions.indegrees;

import javax.swing.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.*;

class IndegreeCriteriumPanel$InternalComboboxListener implements ActionListener
{
    final /* synthetic */ IndegreeCriteriumPanel this$0;
    
    private IndegreeCriteriumPanel$InternalComboboxListener(final IndegreeCriteriumPanel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.this$0.criterium.update();
    }
}
