package org.jfree.ui.tabbedui;

import java.beans.*;

class TabbedFrame$MenuBarChangeListener implements PropertyChangeListener
{
    private final TabbedFrame this$0;
    
    public TabbedFrame$MenuBarChangeListener(final TabbedFrame this$0) {
        this.this$0 = this$0;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("jMenuBar")) {
            this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
        }
    }
}
