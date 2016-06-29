/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import com.google.security.zynamics.bindiff.log.Logger;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

class SaveFunctionDiffViewDialog$InternalButtonListener
implements ActionListener {
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;

    private SaveFunctionDiffViewDialog$InternalButtonListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        this.this$0 = saveFunctionDiffViewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == SaveFunctionDiffViewDialog.access$300(this.this$0)) {
            try {
                if (!SaveFunctionDiffViewDialog.access$400(this.this$0)) {
                    return;
                }
                SaveFunctionDiffViewDialog.access$502(this.this$0, true);
            }
            catch (IOException var2_2) {
                Logger.logSevere("Save function diff view failed. Couldn't calculate source BinExport MD5.", new Object[0]);
                MessageBox.showError(this.this$0.getParent(), "Save function diff view failed. Couldn't calculate source BinExport MD5.");
                return;
            }
        }
        this.this$0.dispose();
    }

    /* synthetic */ SaveFunctionDiffViewDialog$InternalButtonListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog, SaveFunctionDiffViewDialog$1 saveFunctionDiffViewDialog$1) {
        this(saveFunctionDiffViewDialog);
    }
}

