package org.jfree.ui.tabbedui;

import java.beans.*;
import org.jfree.util.*;

class AbstractTabbedUI$TabEnableChangeListener implements PropertyChangeListener
{
    private final AbstractTabbedUI this$0;
    
    public AbstractTabbedUI$TabEnableChangeListener(final AbstractTabbedUI this$0) {
        this.this$0 = this$0;
    }
    
    public void propertyChange(final PropertyChangeEvent propertyChangeEvent) {
        if (!propertyChangeEvent.getPropertyName().equals("enabled")) {
            Log.debug("PropertyName");
            return;
        }
        if (!(propertyChangeEvent.getSource() instanceof RootEditor)) {
            Log.debug("Source");
            return;
        }
        this.this$0.updateRootEditorEnabled((RootEditor)propertyChangeEvent.getSource());
    }
}
