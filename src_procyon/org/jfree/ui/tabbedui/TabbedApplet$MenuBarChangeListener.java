package org.jfree.ui.tabbedui;

import java.beans.*;

class TabbedApplet$MenuBarChangeListener implements PropertyChangeListener
{
    private final TabbedApplet this$0;
    
    public TabbedApplet$MenuBarChangeListener(final TabbedApplet this$0) {
        this.this$0 = this$0;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("jMenuBar")) {
            this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
        }
    }
}
