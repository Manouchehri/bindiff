package com.google.security.zynamics.bindiff.gui.components.closeablebuttontab;

import com.google.security.zynamics.zylib.general.*;
import javax.swing.*;
import com.google.common.base.*;
import javax.swing.plaf.basic.*;
import javax.swing.plaf.*;
import java.awt.event.*;
import java.awt.*;

public class TabButton extends JButton
{
    private static final Color ROLL_OVER_COLOR;
    private final ListenerProvider closeTabButtonListeners;
    private final TabButton$InternalButtonListener buttonListener;
    private final TabButton$InternalMouseListener mouseListener;
    private final JTabbedPane pane;
    private final TabButtonComponent tabButtonComponent;
    private final boolean enableClose;
    
    public TabButton(final JTabbedPane pane, final TabButtonComponent tabButtonComponent, final boolean enableClose) {
        this.closeTabButtonListeners = new ListenerProvider();
        this.buttonListener = new TabButton$InternalButtonListener(this, null);
        this.mouseListener = new TabButton$InternalMouseListener(this, null);
        Preconditions.checkNotNull(pane);
        Preconditions.checkNotNull(tabButtonComponent);
        this.pane = pane;
        this.tabButtonComponent = tabButtonComponent;
        this.enableClose = enableClose;
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
    protected void paintComponent(final Graphics graphics) {
        if (!this.enableClose) {
            super.paintComponent(graphics);
            return;
        }
        final Graphics2D graphics2D = (Graphics2D)graphics.create();
        if (this.getModel().isPressed()) {
            graphics2D.translate(1, 1);
        }
        graphics2D.setColor(this.getModel().isRollover() ? TabButton.ROLL_OVER_COLOR : Color.BLACK);
        graphics2D.setStroke(new BasicStroke(3.0f));
        final int width = this.getWidth();
        final int height = this.getHeight();
        graphics2D.drawLine(6, 6, width - 6, height - 6);
        graphics2D.drawLine(width - 6, 6, 6, height - 6);
        graphics2D.dispose();
    }
    
    public void addListener(final ICloseTabButtonListener closeTabButtonListener) {
        this.closeTabButtonListeners.addListener(closeTabButtonListener);
    }
    
    public void removeListener(final ICloseTabButtonListener closeTabButtonListener) {
        this.closeTabButtonListeners.removeListener(closeTabButtonListener);
    }
    
    static {
        ROLL_OVER_COLOR = new Color(160, 0, 0);
    }
}
