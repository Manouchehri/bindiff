/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.RootEditor;
import org.jfree.util.Log;

class AbstractTabbedUI$TabEnableChangeListener
implements PropertyChangeListener {
    private final AbstractTabbedUI this$0;

    public AbstractTabbedUI$TabEnableChangeListener(AbstractTabbedUI abstractTabbedUI) {
        this.this$0 = abstractTabbedUI;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!propertyChangeEvent.getPropertyName().equals("enabled")) {
            Log.debug("PropertyName");
            return;
        }
        if (!(propertyChangeEvent.getSource() instanceof RootEditor)) {
            Log.debug("Source");
            return;
        }
        RootEditor rootEditor = (RootEditor)propertyChangeEvent.getSource();
        this.this$0.updateRootEditorEnabled(rootEditor);
    }
}

