/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JMenuBar;
import org.jfree.ui.tabbedui.AbstractTabbedUI;
import org.jfree.ui.tabbedui.TabbedFrame;

class TabbedFrame$MenuBarChangeListener
implements PropertyChangeListener {
    private final TabbedFrame this$0;

    public TabbedFrame$MenuBarChangeListener(TabbedFrame tabbedFrame) {
        this.this$0 = tabbedFrame;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (!propertyChangeEvent.getPropertyName().equals("jMenuBar")) return;
        this.this$0.setJMenuBar(this.this$0.getTabbedUI().getJMenuBar());
    }
}

