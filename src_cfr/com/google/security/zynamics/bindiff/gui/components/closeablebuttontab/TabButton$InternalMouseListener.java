/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractButton;

class TabButton$InternalMouseListener
extends MouseAdapter {
    final /* synthetic */ TabButton this$0;

    private TabButton$InternalMouseListener(TabButton tabButton) {
        this.this$0 = tabButton;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        Component component = mouseEvent.getComponent();
        if (!(component instanceof AbstractButton)) return;
        AbstractButton abstractButton = (AbstractButton)component;
        abstractButton.setBorderPainted(false);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        Component component = mouseEvent.getComponent();
        if (!(component instanceof AbstractButton)) return;
        AbstractButton abstractButton = (AbstractButton)component;
        abstractButton.setBorderPainted(false);
    }

    /* synthetic */ TabButton$InternalMouseListener(TabButton tabButton, TabButton$1 tabButton$1) {
        this(tabButton);
    }
}

