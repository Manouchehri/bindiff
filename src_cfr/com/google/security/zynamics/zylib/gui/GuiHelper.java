/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.gui;

import com.google.security.zynamics.zylib.gui.GuiHelper$ComponentFilter;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GuiHelper
implements WindowStateListener {
    public static final int DEFAULT_FONTSIZE = 12;
    public static final Font MONOSPACED_FONT = new Font("Monospaced", 0, 12);
    public static final Font DEFAULT_FONT = new Font("SansSerif", 0, 12);
    private static final GuiHelper instance = new GuiHelper();
    private Field metacityWindowManager = null;
    private Field awtWindowManager = null;
    private boolean needsWindowFix = false;

    private GuiHelper() {
        List<String> list = Arrays.asList("gnome", "gnome-shell", "mate", "cinnamon");
        String string = System.getenv("DESKTOP_SESSION");
        if (string == null) return;
        if (!list.contains(string.toLowerCase())) return;
        try {
            Class class_ = Class.forName("sun.awt.X11.XWM");
            this.awtWindowManager = class_.getDeclaredField("awt_wmgr");
            this.awtWindowManager.setAccessible(true);
            Field field = class_.getDeclaredField("OTHER_WM");
            field.setAccessible(true);
            if (!this.awtWindowManager.get(null).equals(field.get(null))) return;
            this.metacityWindowManager = class_.getDeclaredField("METACITY_WM");
            this.metacityWindowManager.setAccessible(true);
            this.needsWindowFix = true;
            return;
        }
        catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException var3_4) {
            // empty catch block
        }
    }

    @Override
    public void windowStateChanged(WindowEvent windowEvent) {
        try {
            this.awtWindowManager.set(null, this.metacityWindowManager.get(null));
            return;
        }
        catch (IllegalAccessException | IllegalArgumentException var2_2) {
            // empty catch block
        }
    }

    public static final void applyWindowFix(Window window) {
        if (!GuiHelper.instance.needsWindowFix) {
            return;
        }
        window.removeWindowStateListener(instance);
        window.addWindowStateListener(instance);
        instance.windowStateChanged(null);
    }

    public static final void centerChildToParent(Component component, Component component2, boolean bl2) {
        int n2 = component.getX() + component.getWidth() / 2 - component2.getWidth() / 2;
        int n3 = component.getY() + component.getHeight() / 2 - component2.getHeight() / 2;
        if (bl2) {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension dimension = new Dimension(toolkit.getScreenSize());
            if ((double)(n2 + component2.getWidth()) > dimension.getWidth()) {
                n2 = (int)(dimension.getWidth() - (double)component2.getWidth());
            }
            if ((double)(n3 + component2.getHeight()) > dimension.getHeight()) {
                n3 = (int)(dimension.getHeight() - (double)component2.getHeight());
            }
            if (n2 < 0) {
                n2 = 0;
            }
            if (n3 < 0) {
                n3 = 0;
            }
        }
        component2.setLocation(n2, n3);
    }

    public static final void centerOnScreen(Window window) {
        window.setLocationRelativeTo(null);
    }

    public static Component findComponentAt(Container container, Point point) {
        Point point2 = new Point(point.x, point.y);
        SwingUtilities.convertPointFromScreen(point2, container);
        if (!container.contains(point2.x, point2.y)) {
            return container;
        }
        int n2 = container.getComponentCount();
        Component[] arrcomponent = container.getComponents();
        int n3 = 0;
        while (n3 < n2) {
            Component component = arrcomponent[n3];
            Point point3 = component.getLocation();
            if (component.contains(point2.x - point3.x, point2.y - point3.y) && component.isVisible()) {
                if (!(component instanceof Container)) return component;
                Container container2 = (Container)component;
                Component component2 = GuiHelper.findComponentAt(container2, point);
                if (component2 != null) {
                    return component2;
                }
            }
            ++n3;
        }
        return container;
    }

    public static JComponent findComponentByPredicate(JComponent jComponent, GuiHelper$ComponentFilter guiHelper$ComponentFilter) {
        Component[] arrcomponent = jComponent.getComponents();
        int n2 = arrcomponent.length;
        int n3 = 0;
        while (n3 < n2) {
            Component component = arrcomponent[n3];
            if (component instanceof JComponent) {
                if (guiHelper$ComponentFilter.accept((JComponent)component)) {
                    return (JComponent)component;
                }
                JComponent jComponent2 = GuiHelper.findComponentByPredicate((JComponent)component, guiHelper$ComponentFilter);
                if (jComponent2 != null) {
                    return jComponent2;
                }
            }
            ++n3;
        }
        return null;
    }

    public static String getDefaultFont() {
        return DEFAULT_FONT.getName();
    }

    public static String getMonospaceFont() {
        return MONOSPACED_FONT.getName();
    }
}

