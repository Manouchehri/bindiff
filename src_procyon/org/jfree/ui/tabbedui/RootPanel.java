package org.jfree.ui.tabbedui;

import javax.swing.*;

public abstract class RootPanel extends JComponent implements RootEditor
{
    private boolean active;
    
    public final boolean isActive() {
        return this.active;
    }
    
    protected void panelActivated() {
    }
    
    protected void panelDeactivated() {
    }
    
    public final void setActive(final boolean active) {
        if (this.active == active) {
            return;
        }
        this.active = active;
        if (active) {
            this.panelActivated();
        }
        else {
            this.panelDeactivated();
        }
    }
    
    public JComponent getMainPanel() {
        return this;
    }
    
    public JComponent getToolbar() {
        return null;
    }
}
