/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.ui.tabbedui.AbstractTabbedUI;

class AbstractTabbedUI$TabChangeHandler
implements ChangeListener {
    private final JTabbedPane pane;
    private final AbstractTabbedUI this$0;

    public AbstractTabbedUI$TabChangeHandler(AbstractTabbedUI abstractTabbedUI, JTabbedPane jTabbedPane) {
        this.this$0 = abstractTabbedUI;
        this.pane = jTabbedPane;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        this.this$0.setSelectedEditor(this.pane.getSelectedIndex());
    }
}

