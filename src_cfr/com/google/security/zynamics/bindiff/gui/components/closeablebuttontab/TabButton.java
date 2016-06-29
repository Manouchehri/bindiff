/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.ICloseTabButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$1;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$InternalButtonListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButton$InternalMouseListener;
import com.google.security.zynamics.bindiff.gui.components.closeablebuttontab.TabButtonComponent;
import com.google.security.zynamics.zylib.general.ListenerProvider;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

public class TabButton
extends JButton {
    private static final Color ROLL_OVER_COLOR = new Color(160, 0, 0);
    private final ListenerProvider closeTabButtonListeners = new ListenerProvider();
    private final TabButton$InternalButtonListener buttonListener;
    private final TabButton$InternalMouseListener mouseListener;
    private final JTabbedPane pane;
    private final TabButtonComponent tabButtonComponent;
    private final boolean enableClose;

    public TabButton(JTabbedPane jTabbedPane, TabButtonComponent tabButtonComponent, boolean bl2) {
        this.buttonListener = new TabButton$InternalButtonListener(this, null);
        this.mouseListener = new TabButton$InternalMouseListener(this, null);
        Preconditions.checkNotNull(jTabbedPane);
        Preconditions.checkNotNull(tabButtonComponent);
        this.pane = jTabbedPane;
        this.tabButtonComponent = tabButtonComponent;
        this.enableClose = bl2;
        int n2 = 17;
        this.setPreferredSize(new Dimension(17, 17));
        this.setToolTipText("Close View");
        this.setUI(new BasicButtonUI());
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        this.setBorderPainted(false);
        this.addMouseListener(this.mouseListener);
        this.setRolloverEnabled(true);
        this.addActionListener(this.buttonListener);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if (!this.enableClose) {
            super.paintComponent(graphics);
            return;
        }
        Graphics2D graphics2D = (Graphics2D)graphics.create();
        if (this.getModel().isPressed()) {
            graphics2D.translate(1, 1);
        }
        graphics2D.setColor(!this.getModel().isRollover() ? Color.BLACK : ROLL_OVER_COLOR);
        graphics2D.setStroke(new BasicStroke(3.0f));
        int n2 = this.getWidth();
        int n3 = this.getHeight();
        int n4 = 6;
        graphics2D.drawLine(6, 6, n2 - 6, n3 - 6);
        graphics2D.drawLine(n2 - 6, 6, 6, n3 - 6);
        graphics2D.dispose();
    }

    public void addListener(ICloseTabButtonListener iCloseTabButtonListener) {
        this.closeTabButtonListeners.addListener(iCloseTabButtonListener);
    }

    public void removeListener(ICloseTabButtonListener iCloseTabButtonListener) {
        this.closeTabButtonListeners.removeListener(iCloseTabButtonListener);
    }

    static /* synthetic */ TabButtonComponent access$200(TabButton tabButton) {
        return tabButton.tabButtonComponent;
    }

    static /* synthetic */ JTabbedPane access$300(TabButton tabButton) {
        return tabButton.pane;
    }

    static /* synthetic */ ListenerProvider access$400(TabButton tabButton) {
        return tabButton.closeTabButtonListeners;
    }
}

