/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Action;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedDialog;

final class TabbedDialog$1
extends WindowAdapter {
    private final TabbedDialog this$0;

    TabbedDialog$1(TabbedDialog tabbedDialog) {
        this.this$0 = tabbedDialog;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        this.this$0.getTabbedUI().getCloseAction().actionPerformed(new ActionEvent(this, 1001, null, 0));
    }
}

