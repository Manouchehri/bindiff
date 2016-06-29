/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabLabel
extends JLabel {
    private final JTabbedPane pane;
    private final TabButtonComponent buttonComponent;

    public TabLabel(JTabbedPane jTabbedPane, TabButtonComponent tabButtonComponent) {
        Preconditions.checkNotNull(jTabbedPane);
        Preconditions.checkNotNull(tabButtonComponent);
        this.pane = jTabbedPane;
        this.buttonComponent = tabButtonComponent;
    }

    @Override
    public String getText() {
        if (this.buttonComponent == null) return null;
        int n2 = this.pane.indexOfTabComponent(this.buttonComponent);
        if (n2 == -1) return null;
        return this.pane.getTitleAt(n2);
    }

    @Override
    public void setText(String string) {
        if (this.buttonComponent == null) return;
        int n2 = this.pane.indexOfTabComponent(this.buttonComponent);
        if (n2 == -1) return;
        this.pane.setTitleAt(n2, string);
    }
}

