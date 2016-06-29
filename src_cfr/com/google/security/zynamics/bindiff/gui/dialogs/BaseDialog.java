/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.dialogs;

import com.google.security.zynamics.bindiff.gui.dialogs.BaseDialog$1;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class BaseDialog
extends JDialog {
    public BaseDialog(Window window, String string) {
        super(window, Dialog.ModalityType.APPLICATION_MODAL);
        this.init();
        this.setTitle(string);
    }

    public BaseDialog(Window window, String string, int n2, int n3) {
        this(window, string);
        this.setSize(n2, n3);
        this.setMinimumSize(new Dimension(n2, n3));
    }

    private void init() {
        this.getRootPane().registerKeyboardAction(new BaseDialog$1(this), "doEscape", KeyStroke.getKeyStroke(27, 0, false), 2);
    }

    @Override
    public void setVisible(boolean bl2) {
        if (bl2) {
            UIManager.put("TabbedPane.tabAreaInsets", new Insets(2, 2, 0, 2));
            UIManager.put("TabbedPane.contentBorderInsets", new Insets(4, 2, 3, 2));
            SwingUtilities.updateComponentTreeUI(this);
        }
        super.setVisible(bl2);
    }
}

