/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CPathLabel$1
implements ActionListener {
    final /* synthetic */ CPathLabel this$0;

    CPathLabel$1(CPathLabel cPathLabel) {
        this.this$0 = cPathLabel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        StringSelection stringSelection = new StringSelection(CPathLabel.access$001(this.this$0));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, stringSelection);
    }
}

