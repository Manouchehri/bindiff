/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.LayoutManager;
import java.beans.PropertyChangeListener;
import javax.swing.JApplet;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedApplet$MenuBarChangeListener;

public class TabbedApplet
extends JApplet {
    private AbstractTabbedUI tabbedUI;

    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }

    public void init(AbstractTabbedUI abstractTabbedUI) {
        this.tabbedUI = abstractTabbedUI;
        this.tabbedUI.addPropertyChangeListener("jMenuBar", new TabbedApplet$MenuBarChangeListener(this));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add((Component)abstractTabbedUI, "Center");
        this.setContentPane(jPanel);
        this.setJMenuBar(abstractTabbedUI.getJMenuBar());
    }
}

