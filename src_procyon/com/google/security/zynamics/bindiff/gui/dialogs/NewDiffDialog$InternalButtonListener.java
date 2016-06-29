package com.google.security.zynamics.bindiff.gui.dialogs;

import java.io.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import com.google.common.base.*;
import javax.swing.border.*;
import java.awt.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.bindiff.project.diff.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.zylib.gui.*;

class NewDiffDialog$InternalButtonListener extends AbstractAction
{
    final /* synthetic */ NewDiffDialog this$0;
    
    private NewDiffDialog$InternalButtonListener(final NewDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.diffButton)) {
            if (!this.this$0.validateDiffSources()) {
                return;
            }
            this.this$0.diffPressed = true;
        }
        this.this$0.dispose();
    }
}
