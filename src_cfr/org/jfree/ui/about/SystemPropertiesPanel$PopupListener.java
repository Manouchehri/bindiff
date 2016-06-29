/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.about;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import org.jfree.ui.about.SystemPropertiesPanel;

class SystemPropertiesPanel$PopupListener
extends MouseAdapter {
    private final SystemPropertiesPanel this$0;

    public SystemPropertiesPanel$PopupListener(SystemPropertiesPanel systemPropertiesPanel) {
        this.this$0 = systemPropertiesPanel;
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.maybeShowPopup(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.maybeShowPopup(mouseEvent);
    }

    private void maybeShowPopup(MouseEvent mouseEvent) {
        if (!mouseEvent.isPopupTrigger()) return;
        this.this$0.getCopyPopupMenu().show(this.this$0.getTable(), mouseEvent.getX(), mouseEvent.getY());
    }
}

