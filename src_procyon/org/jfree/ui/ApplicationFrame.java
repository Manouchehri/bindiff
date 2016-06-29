package org.jfree.ui;

import javax.swing.*;
import java.awt.event.*;

public class ApplicationFrame extends JFrame implements WindowListener
{
    public ApplicationFrame(final String s) {
        super(s);
        this.addWindowListener(this);
    }
    
    public void windowClosing(final WindowEvent windowEvent) {
        if (windowEvent.getWindow() == this) {
            this.dispose();
            System.exit(0);
        }
    }
    
    public void windowClosed(final WindowEvent windowEvent) {
    }
    
    public void windowActivated(final WindowEvent windowEvent) {
    }
    
    public void windowDeactivated(final WindowEvent windowEvent) {
    }
    
    public void windowDeiconified(final WindowEvent windowEvent) {
    }
    
    public void windowIconified(final WindowEvent windowEvent) {
    }
    
    public void windowOpened(final WindowEvent windowEvent) {
    }
}
