package com.google.security.zynamics.zylib.gui;

import java.lang.reflect.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class GuiHelper implements WindowStateListener
{
    public static final int DEFAULT_FONTSIZE = 12;
    public static final Font MONOSPACED_FONT;
    public static final Font DEFAULT_FONT;
    private static final GuiHelper instance;
    private Field metacityWindowManager;
    private Field awtWindowManager;
    private boolean needsWindowFix;
    
    private GuiHelper() {
        this.metacityWindowManager = null;
        this.awtWindowManager = null;
        this.needsWindowFix = false;
        final List<String> list = Arrays.asList("gnome", "gnome-shell", "mate", "cinnamon");
        final String getenv = System.getenv("DESKTOP_SESSION");
        if (getenv != null && list.contains(getenv.toLowerCase())) {
            try {
                final Class<?> forName = Class.forName("sun.awt.X11.XWM");
                (this.awtWindowManager = forName.getDeclaredField("awt_wmgr")).setAccessible(true);
                final Field declaredField = forName.getDeclaredField("OTHER_WM");
                declaredField.setAccessible(true);
                if (this.awtWindowManager.get(null).equals(declaredField.get(null))) {
                    (this.metacityWindowManager = forName.getDeclaredField("METACITY_WM")).setAccessible(true);
                    this.needsWindowFix = true;
                }
            }
            catch (ClassNotFoundException ex) {}
            catch (NoSuchFieldException ex2) {}
            catch (SecurityException ex3) {}
            catch (IllegalArgumentException ex4) {}
            catch (IllegalAccessException ex5) {}
        }
    }
    
    @Override
    public void windowStateChanged(final WindowEvent windowEvent) {
        try {
            this.awtWindowManager.set(null, this.metacityWindowManager.get(null));
        }
        catch (IllegalArgumentException ex) {}
        catch (IllegalAccessException ex2) {}
    }
    
    public static final void applyWindowFix(final Window window) {
        if (!GuiHelper.instance.needsWindowFix) {
            return;
        }
        window.removeWindowStateListener(GuiHelper.instance);
        window.addWindowStateListener(GuiHelper.instance);
        GuiHelper.instance.windowStateChanged(null);
    }
    
    public static final void centerChildToParent(final Component component, final Component component2, final boolean b) {
        int n = component.getX() + component.getWidth() / 2 - component2.getWidth() / 2;
        int n2 = component.getY() + component.getHeight() / 2 - component2.getHeight() / 2;
        if (b) {
            final Dimension dimension = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
            if (n + component2.getWidth() > dimension.getWidth()) {
                n = (int)(dimension.getWidth() - component2.getWidth());
            }
            if (n2 + component2.getHeight() > dimension.getHeight()) {
                n2 = (int)(dimension.getHeight() - component2.getHeight());
            }
            if (n < 0) {
                n = 0;
            }
            if (n2 < 0) {
                n2 = 0;
            }
        }
        component2.setLocation(n, n2);
    }
    
    public static final void centerOnScreen(final Window window) {
        window.setLocationRelativeTo(null);
    }
    
    public static Component findComponentAt(final Container container, final Point point) {
        final Point point2 = new Point(point.x, point.y);
        SwingUtilities.convertPointFromScreen(point2, container);
        if (!container.contains(point2.x, point2.y)) {
            return container;
        }
        final int componentCount = container.getComponentCount();
        for (final Component component : container.getComponents()) {
            final Point location = component.getLocation();
            if (component.contains(point2.x - location.x, point2.y - location.y) && component.isVisible()) {
                if (!(component instanceof Container)) {
                    return component;
                }
                final Component component2 = findComponentAt((Container)component, point);
                if (component2 != null) {
                    return component2;
                }
            }
        }
        return container;
    }
    
    public static JComponent findComponentByPredicate(final JComponent component, final GuiHelper$ComponentFilter guiHelper$ComponentFilter) {
        for (final Component component2 : component.getComponents()) {
            if (component2 instanceof JComponent) {
                if (guiHelper$ComponentFilter.accept((JComponent)component2)) {
                    return (JComponent)component2;
                }
                final JComponent componentByPredicate = findComponentByPredicate((JComponent)component2, guiHelper$ComponentFilter);
                if (componentByPredicate != null) {
                    return componentByPredicate;
                }
            }
        }
        return null;
    }
    
    public static String getDefaultFont() {
        return GuiHelper.DEFAULT_FONT.getName();
    }
    
    public static String getMonospaceFont() {
        return GuiHelper.MONOSPACED_FONT.getName();
    }
    
    static {
        MONOSPACED_FONT = new Font("Monospaced", 0, 12);
        DEFAULT_FONT = new Font("SansSerif", 0, 12);
        instance = new GuiHelper();
    }
}
