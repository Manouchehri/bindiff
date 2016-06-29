/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.enums.ESide;
import com.google.security.zynamics.bindiff.gui.components.MessageBox;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.SaveFunctionDiffViewDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class SaveFunctionDiffViewDialog$InternalCheckboxListener
implements ActionListener {
    final /* synthetic */ SaveFunctionDiffViewDialog this$0;

    private SaveFunctionDiffViewDialog$InternalCheckboxListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog) {
        this.this$0 = saveFunctionDiffViewDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() != SaveFunctionDiffViewDialog.access$600(this.this$0) || !SaveFunctionDiffViewDialog.access$600(this.this$0).isSelected()) {
            if (actionEvent.getSource() != SaveFunctionDiffViewDialog.access$700(this.this$0)) return;
            if (!SaveFunctionDiffViewDialog.access$700(this.this$0).isSelected()) return;
        }
        Object[] arrobject = new Object[1];
        arrobject[0] = this.this$0.getExportBinaryTargetFile(actionEvent.getSource() == SaveFunctionDiffViewDialog.access$600(this.this$0) ? ESide.PRIMARY : ESide.SECONDARY).getName();
        MessageBox.showWarning(this.this$0, String.format("There is already a '%s' file with different content existing!\nIf you choose override make sure that the new and the existing disassembly are\nstructurally identical, e.g. only comments have been added or modified. Otherwise,\nexisting older saved views may not be loadable anymore!", arrobject));
    }

    /* synthetic */ SaveFunctionDiffViewDialog$InternalCheckboxListener(SaveFunctionDiffViewDialog saveFunctionDiffViewDialog, SaveFunctionDiffViewDialog$1 saveFunctionDiffViewDialog$1) {
        this(saveFunctionDiffViewDialog);
    }
}

