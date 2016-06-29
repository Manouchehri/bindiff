/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BaseDialog$1
implements ActionListener {
    final /* synthetic */ BaseDialog this$0;

    BaseDialog$1(BaseDialog baseDialog) {
        this.this$0 = baseDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.setVisible(false);
        this.this$0.dispose();
    }
}

