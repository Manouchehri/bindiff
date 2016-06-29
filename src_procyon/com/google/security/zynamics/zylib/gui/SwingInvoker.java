package com.google.security.zynamics.zylib.gui;

import javax.swing.*;

public abstract class SwingInvoker
{
    protected abstract void operation();
    
    public void invokeAndWait() {
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeAndWait(new SwingInvoker$1(this));
            }
            catch (Exception ex) {}
        }
        else {
            this.operation();
        }
    }
    
    public void invokeLater() {
        if (!SwingUtilities.isEventDispatchThread()) {
            try {
                SwingUtilities.invokeLater(new SwingInvoker$2(this));
            }
            catch (Exception ex) {}
        }
        else {
            this.operation();
        }
    }
}
