package org.jfree.ui.tabbedui;

import java.beans.*;
import javax.swing.*;
import java.awt.*;

public class TabbedApplet extends JApplet
{
    private AbstractTabbedUI tabbedUI;
    
    protected final AbstractTabbedUI getTabbedUI() {
        return this.tabbedUI;
    }
    
    public void init(final AbstractTabbedUI tabbedUI) {
        (this.tabbedUI = tabbedUI).addPropertyChangeListener("jMenuBar", new TabbedApplet$MenuBarChangeListener(this));
        final JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(tabbedUI, "Center");
        this.setContentPane(contentPane);
        this.setJMenuBar(tabbedUI.getJMenuBar());
    }
}
