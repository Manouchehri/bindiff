package org.jfree.ui.tabbedui;

import java.beans.*;

class TabbedDialog$MenuBarChangeListener implements PropertyChangeListener
{
    private final TabbedDialog this$0;
    
    public TabbedDialog$MenuBarChangeListener(final TabbedDialog this$0) {
        this.this$0 = this$0;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("jMenuBar")) {
            this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
        }
    }
}
