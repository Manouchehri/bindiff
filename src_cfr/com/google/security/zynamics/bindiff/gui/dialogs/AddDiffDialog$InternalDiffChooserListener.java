/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.AddDiffDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class AddDiffDialog$InternalDiffChooserListener
implements ActionListener {
    final /* synthetic */ AddDiffDialog this$0;

    private AddDiffDialog$InternalDiffChooserListener(AddDiffDialog addDiffDialog) {
        this.this$0 = addDiffDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        File file = AddDiffDialog.access$500(this.this$0, "Choose Diff", new File(binDiffConfigFile.getMainSettings().getAddExistingDiffLastDir()));
        if (file == null) return;
        if (!file.exists()) return;
        AddDiffDialog.access$600(this.this$0).setText(file.getPath());
        binDiffConfigFile.getMainSettings().setAddExistingDiffLastDir(file.getParent());
        AddDiffDialog.access$700(this.this$0);
    }

    /* synthetic */ AddDiffDialog$InternalDiffChooserListener(AddDiffDialog addDiffDialog, AddDiffDialog$1 addDiffDialog$1) {
        this(addDiffDialog);
    }
}

