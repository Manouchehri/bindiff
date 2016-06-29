/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs.directorydiff;

import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.directorydiff.DirectoryDiffDialog$1;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.table.TableCellEditor;

class DirectoryDiffDialog$InternalButtonListener
extends AbstractAction {
    final /* synthetic */ DirectoryDiffDialog this$0;

    private DirectoryDiffDialog$InternalButtonListener(DirectoryDiffDialog directoryDiffDialog) {
        this.this$0 = directoryDiffDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(DirectoryDiffDialog.access$200(this.this$0))) {
            DirectoryDiffDialog.access$300(this.this$0, true);
            return;
        }
        if (actionEvent.getSource().equals(DirectoryDiffDialog.access$400(this.this$0))) {
            DirectoryDiffDialog.access$300(this.this$0, false);
            return;
        }
        if (!actionEvent.getSource().equals(DirectoryDiffDialog.access$500(this.this$0))) {
            DirectoryDiffDialog.access$802(this.this$0, false);
            this.this$0.dispose();
            return;
        }
        if (DirectoryDiffDialog.access$600(this.this$0).isEditing()) {
            DirectoryDiffDialog.access$600(this.this$0).getCellEditor().stopCellEditing();
        }
        if (!DirectoryDiffDialog.access$700(this.this$0)) return;
        DirectoryDiffDialog.access$802(this.this$0, true);
        this.this$0.dispose();
    }

    /* synthetic */ DirectoryDiffDialog$InternalButtonListener(DirectoryDiffDialog directoryDiffDialog, DirectoryDiffDialog$1 directoryDiffDialog$1) {
        this(directoryDiffDialog);
    }
}

