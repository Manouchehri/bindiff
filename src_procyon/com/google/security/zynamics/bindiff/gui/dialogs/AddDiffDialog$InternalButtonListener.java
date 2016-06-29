package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.project.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.awt.event.*;
import com.google.common.base.*;
import java.io.*;
import com.google.security.zynamics.bindiff.utils.*;
import javax.swing.*;
import com.google.security.zynamics.zylib.general.*;
import com.google.security.zynamics.bindiff.database.*;
import com.google.security.zynamics.zylib.gui.*;
import java.sql.*;
import com.google.security.zynamics.bindiff.resources.*;
import com.google.security.zynamics.bindiff.enums.*;
import java.awt.*;
import javax.swing.border.*;

class AddDiffDialog$InternalButtonListener extends AbstractAction
{
    final /* synthetic */ AddDiffDialog this$0;
    
    private AddDiffDialog$InternalButtonListener(final AddDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.addButton)) {
            if (!this.this$0.validateDiffSources()) {
                return;
            }
            this.this$0.diffPressed = true;
        }
        this.this$0.dispose();
    }
}
