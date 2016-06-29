package org.jfree.ui;

import java.awt.*;

public final class OverlayLayout implements LayoutManager
{
    private boolean ignoreInvisible;
    
    public OverlayLayout(final boolean ignoreInvisible) {
        this.ignoreInvisible = ignoreInvisible;
    }
    
    public OverlayLayout() {
    }
    
    public void addLayoutComponent(final String s, final Component component) {
    }
    
    public void removeLayoutComponent(final Component component) {
    }
    
    public void layoutContainer(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final Rectangle bounds = container.getBounds();
            final int n = bounds.width - insets.left - insets.right;
            final int n2 = bounds.height - insets.top - insets.bottom;
            final Component[] components = container.getComponents();
            for (int i = 0; i < components.length; ++i) {
                final Component component = components[i];
                if (components[i].isVisible() || !this.ignoreInvisible) {
                    component.setBounds(insets.left, insets.top, n, n2);
                }
            }
        }
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final Component[] components = container.getComponents();
            int height = 0;
            int width = 0;
            for (int i = 0; i < components.length; ++i) {
                if (components[i].isVisible() || !this.ignoreInvisible) {
                    final Dimension minimumSize = components[i].getMinimumSize();
                    if (minimumSize.height > height) {
                        height = minimumSize.height;
                    }
                    if (minimumSize.width > width) {
                        width = minimumSize.width;
                    }
                }
            }
            return new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom);
        }
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final Component[] components = container.getComponents();
            int height = 0;
            int width = 0;
            for (int i = 0; i < components.length; ++i) {
                if (components[i].isVisible() || !this.ignoreInvisible) {
                    final Dimension preferredSize = components[i].getPreferredSize();
                    if (preferredSize.height > height) {
                        height = preferredSize.height;
                    }
                    if (preferredSize.width > width) {
                        width = preferredSize.width;
                    }
                }
            }
            return new Dimension(width + insets.left + insets.right, height + insets.top + insets.bottom);
        }
    }
}
