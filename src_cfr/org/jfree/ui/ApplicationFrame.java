/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

public class ApplicationFrame
extends JFrame
implements WindowListener {
    public ApplicationFrame(String string) {
        super(string);
        this.addWindowListener(this);
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if (windowEvent.getWindow() != this) return;
        this.dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
    }
}

