package org.jfree.ui;

import javax.swing.*;
import java.awt.event.*;

public final class FloatingButtonEnabler extends MouseAdapter
{
    private static FloatingButtonEnabler singleton;
    
    public static FloatingButtonEnabler getInstance() {
        if (FloatingButtonEnabler.singleton == null) {
            FloatingButtonEnabler.singleton = new FloatingButtonEnabler();
        }
        return FloatingButtonEnabler.singleton;
    }
    
    public void addButton(final AbstractButton abstractButton) {
        abstractButton.addMouseListener(this);
        abstractButton.setBorderPainted(false);
    }
    
    public void removeButton(final AbstractButton abstractButton) {
        abstractButton.addMouseListener(this);
        abstractButton.setBorderPainted(true);
    }
    
    public void mouseEntered(final MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof AbstractButton) {
            final AbstractButton abstractButton = (AbstractButton)mouseEvent.getSource();
            if (abstractButton.isEnabled()) {
                abstractButton.setBorderPainted(true);
            }
        }
    }
    
    public void mouseExited(final MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof AbstractButton) {
            final AbstractButton abstractButton = (AbstractButton)mouseEvent.getSource();
            abstractButton.setBorderPainted(false);
            if (abstractButton.getParent() != null) {
                abstractButton.getParent().repaint();
            }
        }
    }
}
