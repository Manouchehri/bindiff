/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedFrame$1;
import org.jfree.ui.tabbedui.TabbedFrame$MenuBarChangeListener;

public class TabbedFrame
extends JFrame {
    private AbstractTabbedUI tabbedUI;

    public TabbedFrame() {
    }

    public TabbedFrame(String string) {
        super(string);
    }

    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }

    public void init(AbstractTabbedUI abstractTabbedUI) {
        this.tabbedUI = abstractTabbedUI;
        this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedFrame$MenuBarChangeListener(this));
        this.addWindowListener(new TabbedFrame$1(this));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add((Component)abstractTabbedUI, "Center");
        this.setContentPane(jPanel);
        this.setJMenuBar(abstractTabbedUI.getJMenuBar());
    }
}

