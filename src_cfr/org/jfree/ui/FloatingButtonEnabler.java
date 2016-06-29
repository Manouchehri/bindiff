/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;

public final class FloatingButtonEnabler
extends MouseAdapter {
    private static FloatingButtonEnabler singleton;

    private FloatingButtonEnabler() {
    }

    public static FloatingButtonEnabler getInstance() {
        if (singleton != null) return singleton;
        singleton = new FloatingButtonEnabler();
        return singleton;
    }

    public void addButton(AbstractButton abstractButton) {
        abstractButton.addMouseListener(this);
        abstractButton.setBorderPainted(false);
    }

    public void removeButton(AbstractButton abstractButton) {
        abstractButton.addMouseListener(this);
        abstractButton.setBorderPainted(true);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (!(mouseEvent.getSource() instanceof AbstractButton)) return;
        AbstractButton abstractButton = (AbstractButton)mouseEvent.getSource();
        if (!abstractButton.isEnabled()) return;
        abstractButton.setBorderPainted(true);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        if (!(mouseEvent.getSource() instanceof AbstractButton)) return;
        AbstractButton abstractButton = (AbstractButton)mouseEvent.getSource();
        abstractButton.setBorderPainted(false);
        if (abstractButton.getParent() == null) return;
        abstractButton.getParent().repaint();
    }
}

