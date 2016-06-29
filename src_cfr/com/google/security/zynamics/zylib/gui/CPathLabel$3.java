/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.CPathLabel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;

class CPathLabel$3
extends MouseAdapter {
    final /* synthetic */ CPathLabel this$0;

    CPathLabel$3(CPathLabel cPathLabel) {
        this.this$0 = cPathLabel;
    }

    private void handlePopupEvent(MouseEvent mouseEvent) {
        if (!mouseEvent.isPopupTrigger()) return;
        this.this$0.m_popup.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.handlePopupEvent(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.handlePopupEvent(mouseEvent);
    }
}

