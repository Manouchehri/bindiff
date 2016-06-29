/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CDialogAboutEx;
import com.google.security.zynamics.zylib.gui.CDialogAboutEx$1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CDialogAboutEx$InternalActionListener
implements ActionListener {
    final /* synthetic */ CDialogAboutEx this$0;

    private CDialogAboutEx$InternalActionListener(CDialogAboutEx cDialogAboutEx) {
        this.this$0 = cDialogAboutEx;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.this$0.dispose();
    }

    /* synthetic */ CDialogAboutEx$InternalActionListener(CDialogAboutEx cDialogAboutEx, CDialogAboutEx$1 cDialogAboutEx$1) {
        this(cDialogAboutEx);
    }
}

