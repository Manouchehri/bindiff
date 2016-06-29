package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.*;
import com.google.security.zynamics.zylib.gui.FileChooser.*;
import java.io.*;
import java.awt.event.*;
import com.google.common.base.*;
import com.google.security.zynamics.bindiff.enums.*;
import com.google.security.zynamics.bindiff.config.*;
import com.google.security.zynamics.zylib.gui.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;
import java.util.*;

class DirectoryDiffDialog$InternalButtonListener extends AbstractAction
{
    final /* synthetic */ DirectoryDiffDialog this$0;
    
    private DirectoryDiffDialog$InternalButtonListener(final DirectoryDiffDialog this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(this.this$0.selectAllButton)) {
            this.this$0.selectAll(true);
        }
        else if (actionEvent.getSource().equals(this.this$0.deselectAllButton)) {
            this.this$0.selectAll(false);
        }
        else if (actionEvent.getSource().equals(this.this$0.diffButton)) {
            if (this.this$0.diffsTable.isEditing()) {
                this.this$0.diffsTable.getCellEditor().stopCellEditing();
            }
            if (!this.this$0.validateSelectedDiffs()) {
                return;
            }
            this.this$0.diffButtonPressed = true;
            this.this$0.dispose();
        }
        else {
            this.this$0.diffButtonPressed = false;
            this.this$0.dispose();
        }
    }
}
