/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDialogEscaper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

class CDialogEscaper$1
implements ActionListener {
    final /* synthetic */ JDialog val$dialog;
    final /* synthetic */ CDialogEscaper this$0;

    CDialogEscaper$1(CDialogEscaper cDialogEscaper, JDialog jDialog) {
        this.this$0 = cDialogEscaper;
        this.val$dialog = jDialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.val$dialog.setVisible(false);
        this.val$dialog.dispose();
    }
}

