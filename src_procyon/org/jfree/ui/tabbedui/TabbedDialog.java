package org.jfree.ui.tabbedui;

import java.beans.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TabbedDialog extends JDialog
{
    private AbstractTabbedUI tabbedUI;
    
    public TabbedDialog() {
    }
    
    public TabbedDialog(final Dialog dialog) {
        super(dialog);
    }
    
    public TabbedDialog(final Dialog dialog, final boolean b) {
        super(dialog, b);
    }
    
    public TabbedDialog(final Dialog dialog, final String s) {
        super(dialog, s);
    }
    
    public TabbedDialog(final Dialog dialog, final String s, final boolean b) {
        super(dialog, s, b);
    }
    
    public TabbedDialog(final Frame frame) {
        super(frame);
    }
    
    public TabbedDialog(final Frame frame, final boolean b) {
        super(frame, b);
    }
    
    public TabbedDialog(final Frame frame, final String s) {
        super(frame, s);
    }
    
    public TabbedDialog(final Frame frame, final String s, final boolean b) {
        super(frame, s, b);
    }
    
    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }
    
    public void init(final AbstractTabbedUI tabbedUI) {
        (this.tabbedUI = tabbedUI).addPropertyChangeListener("jMenuBar", new TabbedDialog$MenuBarChangeListener(this));
        this.addWindowListener(new TabbedDialog$1(this));
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(tabbedUI, "Center");
        this.setContentPane(contentPane);
        this.setJMenuBar(tabbedUI.getJMenuBar());
    }
}
