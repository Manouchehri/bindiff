package com.google.security.zynamics.zylib.gui.JCaret;

import javax.swing.*;
import com.google.common.base.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class JCaret
{
    private static final int DEFAULT_BLINK_TIME = 600;
    private static final Color DEFAULT_CARET_COLOR;
    private final List m_listeners;
    private final Timer m_caretTimer;
    private boolean m_isCaretVisible;
    private final Color m_caretColor;
    private final JCaret$InternalListener m_listener;
    
    public JCaret() {
        this(600, JCaret.DEFAULT_CARET_COLOR);
    }
    
    public JCaret(final Color color) {
        this(600, color);
    }
    
    public JCaret(final int n) {
        this(n, JCaret.DEFAULT_CARET_COLOR);
    }
    
    public JCaret(final int n, final Color color) {
        this.m_listeners = new ArrayList();
        this.m_isCaretVisible = false;
        this.m_caretColor = Color.RED;
        this.m_listener = new JCaret$InternalListener(this, null);
        Preconditions.checkArgument(n >= 0, (Object)"Error: Blink period can't be negative");
        Preconditions.checkNotNull(color, (Object)"Error: Caret color can't be null");
        (this.m_caretTimer = new Timer(n, this.m_listener)).setRepeats(true);
        this.m_caretTimer.start();
    }
    
    private void notifyListeners() {
        final Iterator<ICaretListener> iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            iterator.next().caretStatusChanged(this);
        }
    }
    
    public void addCaretListener(final ICaretListener caretListener) {
        Preconditions.checkNotNull(caretListener, (Object)"Error: Listener can't be null");
        if (!this.m_listeners.contains(caretListener)) {
            this.m_listeners.add(caretListener);
        }
    }
    
    public void draw(final Graphics graphics, final int n, final int n2, final int n3) {
        Preconditions.checkNotNull(graphics, (Object)"Error: Graphics context can't be null");
        if (this.isVisible()) {
            final Color color = graphics.getColor();
            graphics.setColor(this.m_caretColor);
            graphics.drawLine(n, n2, n, n2 + n3 - 1);
            graphics.setColor(color);
        }
    }
    
    public boolean isVisible() {
        return this.m_isCaretVisible;
    }
    
    public void removeListener(final ICaretListener caretListener) {
        this.m_listeners.remove(caretListener);
    }
    
    public void setVisible(final boolean isCaretVisible) {
        this.m_isCaretVisible = isCaretVisible;
        this.notifyListeners();
    }
    
    public void stop() {
        this.m_caretTimer.stop();
        this.m_caretTimer.removeActionListener(this.m_listener);
        this.setVisible(false);
    }
    
    static {
        DEFAULT_CARET_COLOR = Color.RED;
    }
}
