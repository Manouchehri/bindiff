/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedDialog$1;
import org.jfree.ui.tabbedui.TabbedDialog$MenuBarChangeListener;

public class TabbedDialog
extends JDialog {
    private AbstractTabbedUI tabbedUI;

    public TabbedDialog() {
    }

    public TabbedDialog(Dialog dialog) {
        super(dialog);
    }

    public TabbedDialog(Dialog dialog, boolean bl2) {
        super(dialog, bl2);
    }

    public TabbedDialog(Dialog dialog, String string) {
        super(dialog, string);
    }

    public TabbedDialog(Dialog dialog, String string, boolean bl2) {
        super(dialog, string, bl2);
    }

    public TabbedDialog(Frame frame) {
        super(frame);
    }

    public TabbedDialog(Frame frame, boolean bl2) {
        super(frame, bl2);
    }

    public TabbedDialog(Frame frame, String string) {
        super(frame, string);
    }

    public TabbedDialog(Frame frame, String string, boolean bl2) {
        super(frame, string, bl2);
    }

    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }

    public void init(AbstractTabbedUI abstractTabbedUI) {
        this.tabbedUI = abstractTabbedUI;
        this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedDialog$MenuBarChangeListener(this));
        this.addWindowListener(new TabbedDialog$1(this));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add((Component)abstractTabbedUI, "Center");
        this.setContentPane(jPanel);
        this.setJMenuBar(abstractTabbedUI.getJMenuBar());
    }
}

