package org.jfree.ui.tabbedui;

import java.beans.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class TabbedFrame extends JFrame
{
    private AbstractTabbedUI tabbedUI;
    
    public TabbedFrame() {
    }
    
    public TabbedFrame(final String s) {
        super(s);
    }
    
    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }
    
    public void init(final AbstractTabbedUI tabbedUI) {
        (this.tabbedUI = tabbedUI).addPropertyChangeListener("jMenuBar", new TabbedFrame$MenuBarChangeListener(this));
        this.addWindowListener(new TabbedFrame$1(this));
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(tabbedUI, "Center");
        this.setContentPane(contentPane);
        this.setJMenuBar(tabbedUI.getJMenuBar());
    }
}
