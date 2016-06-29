/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JMenuBar;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedDialog;

class TabbedDialog$MenuBarChangeListener
implements PropertyChangeListener {
    private final TabbedDialog this$0;

    public TabbedDialog$MenuBarChangeListener(TabbedDialog tabbedDialog) {
        this.this$0 = tabbedDialog;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!propertyChangeEvent.getPropertyName().equals("jMenuBar")) return;
        this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
    }
}

