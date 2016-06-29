/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import java.io.IOException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class SaveFunctionDiffViewDialog$InternalDocumentListener
implements DocumentListener {
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;

    private SaveFunctionDiffViewDialog$InternalDocumentListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        this.this$0 = saveFunctionDiffViewDialog;
    }

    private void update() {
        try {
            SaveFunctionDiffViewDialog.access$800(this.this$0);
            return;
        }
        catch (IOException var1_1) {
            // empty catch block
        }
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        this.update();
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        this.update();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        this.update();
    }

    /* synthetic */ SaveFunctionDiffViewDialog$InternalDocumentListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog, SaveFunctionDiffViewDialog$1 saveFunctionDiffViewDialog$1) {
        this(saveFunctionDiffViewDialog);
    }
}

