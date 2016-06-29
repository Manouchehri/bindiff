/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui.JCaret;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.gui.JCaret.ICaretListener;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$1;
import com.google.security.zynamics.zylib.gui.JCaret.JCaret$InternalListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;

public class JCaret {
    private static final int DEFAULT_BLINK_TIME = 600;
    private static final Color DEFAULT_CARET_COLOR = Color.RED;
    private final List m_listeners = new ArrayList();
    private final Timer m_caretTimer;
    private boolean m_isCaretVisible = false;
    private final Color m_caretColor = Color.RED;
    private final JCaret$InternalListener m_listener;

    public JCaret() {
        this(600, DEFAULT_CARET_COLOR);
    }

    public JCaret(Color color) {
        this(600, color);
    }

    public JCaret(int n2) {
        this(n2, DEFAULT_CARET_COLOR);
    }

    public JCaret(int n2, Color color) {
        this.m_listener = new JCaret$InternalListener(this, null);
        Preconditions.checkArgument(n2 >= 0, "Error: Blink period can't be negative");
        Preconditions.checkNotNull(color, "Error: Caret color can't be null");
        this.m_caretTimer = new Timer(n2, this.m_listener);
        this.m_caretTimer.setRepeats(true);
        this.m_caretTimer.start();
    }

    private void notifyListeners() {
        Iterator iterator = this.m_listeners.iterator();
        while (iterator.hasNext()) {
            ICaretListener iCaretListener = (ICaretListener)iterator.next();
            iCaretListener.caretStatusChanged(this);
        }
    }

    public void addCaretListener(ICaretListener iCaretListener) {
        Preconditions.checkNotNull(iCaretListener, "Error: Listener can't be null");
        if (this.m_listeners.contains(iCaretListener)) return;
        this.m_listeners.add(iCaretListener);
    }

    public void draw(Graphics graphics, int n2, int n3, int n4) {
        Preconditions.checkNotNull(graphics, "Error: Graphics context can't be null");
        if (!this.isVisible()) return;
        Color color = graphics.getColor();
        graphics.setColor(this.m_caretColor);
        graphics.drawLine(n2, n3, n2, n3 + n4 - 1);
        graphics.setColor(color);
    }

    public boolean isVisible() {
        return this.m_isCaretVisible;
    }

    public void removeListener(ICaretListener iCaretListener) {
        this.m_listeners.remove(iCaretListener);
    }

    public void setVisible(boolean bl2) {
        this.m_isCaretVisible = bl2;
        this.notifyListeners();
    }

    public void stop() {
        this.m_caretTimer.stop();
        this.m_caretTimer.removeActionListener(this.m_listener);
        this.setVisible(false);
    }

    static /* synthetic */ boolean access$102(JCaret jCaret, boolean bl2) {
        jCaret.m_isCaretVisible = bl2;
        return jCaret.m_isCaretVisible;
    }

    static /* synthetic */ boolean access$100(JCaret jCaret) {
        return jCaret.m_isCaretVisible;
    }

    static /* synthetic */ void access$200(JCaret jCaret) {
        jCaret.notifyListeners();
    }
}

