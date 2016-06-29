package org.jfree.ui;

import java.awt.event.*;
import javax.swing.text.*;

public final class JTextObserver implements FocusListener
{
    private static JTextObserver singleton;
    
    public static JTextObserver getInstance() {
        if (JTextObserver.singleton == null) {
            JTextObserver.singleton = new JTextObserver();
        }
        return JTextObserver.singleton;
    }
    
    public void focusGained(final FocusEvent focusEvent) {
        if (focusEvent.getSource() instanceof JTextComponent) {
            ((JTextComponent)focusEvent.getSource()).selectAll();
        }
    }
    
    public void focusLost(final FocusEvent focusEvent) {
        if (focusEvent.getSource() instanceof JTextComponent) {
            ((JTextComponent)focusEvent.getSource()).select(0, 0);
        }
    }
    
    public static void addTextComponent(final JTextComponent textComponent) {
        if (JTextObserver.singleton == null) {
            JTextObserver.singleton = new JTextObserver();
        }
        textComponent.addFocusListener(JTextObserver.singleton);
    }
    
    public static void removeTextComponent(final JTextComponent textComponent) {
        if (JTextObserver.singleton == null) {
            JTextObserver.singleton = new JTextObserver();
        }
        textComponent.removeFocusListener(JTextObserver.singleton);
    }
}
