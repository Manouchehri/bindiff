/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.config.BinDiffConfigFile;
import com.google.security.zynamics.bindiff.config.GeneralSettingsConfigItem;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog;
import com.google.security.zynamics.bindiff.gui.dialogs.NewDiffDialog$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class NewDiffDialog$InternalPrimaryFileChooserListener
implements ActionListener {
    final /* synthetic */ NewDiffDialog this$0;

    private NewDiffDialog$InternalPrimaryFileChooserListener(NewDiffDialog newDiffDialog) {
        this.this$0 = newDiffDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        BinDiffConfigFile binDiffConfigFile = BinDiffConfigFile.getInstance();
        File file = NewDiffDialog.access$800(this.this$0, "Choose Primary File", NewDiffDialog.access$600(this.this$0) == null ? new File(binDiffConfigFile.getMainSettings().getNewDiffLastPrimaryDir()) : NewDiffDialog.access$600(this.this$0), NewDiffDialog.access$700());
        if (file != null) {
            NewDiffDialog.access$900(this.this$0).setText(file.getPath());
            NewDiffDialog.access$602(this.this$0, file.getParentFile());
            binDiffConfigFile.getMainSettings().setNewDiffLastPrimaryDir(NewDiffDialog.access$600(this.this$0).getPath());
        }
        NewDiffDialog.access$1000(this.this$0);
    }

    /* synthetic */ NewDiffDialog$InternalPrimaryFileChooserListener(NewDiffDialog newDiffDialog, NewDiffDialog$1 newDiffDialog$1) {
        this(newDiffDialog);
    }
}

