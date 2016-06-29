/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.CDialogEscaper$1;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class CDialogEscaper {
    public CDialogEscaper(JDialog jDialog) {
        Preconditions.checkNotNull(jDialog, "Error: dialog argument can not be null");
        jDialog.getRootPane().registerKeyboardAction(new CDialogEscaper$1(this, jDialog), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
    }
}

