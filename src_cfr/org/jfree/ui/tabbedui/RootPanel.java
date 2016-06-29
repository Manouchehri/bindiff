/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import javax.swing.JComponent;
import org.jfree.ui.tabbedui.RootEditor;

public abstract class RootPanel
extends JComponent
implements RootEditor {
    private boolean active;

    @Override
    public final boolean isActive() {
        return this.active;
    }

    protected void panelActivated() {
    }

    protected void panelDeactivated() {
    }

    @Override
    public final void setActive(boolean bl2) {
        if (this.active == bl2) {
            return;
        }
        this.active = bl2;
        if (bl2) {
            this.panelActivated();
            return;
        }
        this.panelDeactivated();
    }

    @Override
    public JComponent getMainPanel() {
        return this;
    }

    @Override
    public JComponent getToolbar() {
        return null;
    }
}

