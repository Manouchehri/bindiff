/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.text.JTextComponent;

public final class JTextObserver
implements FocusListener {
    private static JTextObserver singleton;

    private JTextObserver() {
    }

    public static JTextObserver getInstance() {
        if (singleton != null) return singleton;
        singleton = new JTextObserver();
        return singleton;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
        if (!(focusEvent.getSource() instanceof JTextComponent)) return;
        JTextComponent jTextComponent = (JTextComponent)focusEvent.getSource();
        jTextComponent.selectAll();
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (!(focusEvent.getSource() instanceof JTextComponent)) return;
        JTextComponent jTextComponent = (JTextComponent)focusEvent.getSource();
        jTextComponent.select(0, 0);
    }

    public static void addTextComponent(JTextComponent jTextComponent) {
        if (singleton == null) {
            singleton = new JTextObserver();
        }
        jTextComponent.addFocusListener(singleton);
    }

    public static void removeTextComponent(JTextComponent jTextComponent) {
        if (singleton == null) {
            singleton = new JTextObserver();
        }
        jTextComponent.removeFocusListener(singleton);
    }
}

