package org.jfree.ui.tabbedui;

import java.awt.*;

public class VerticalLayout implements LayoutManager
{
    private final boolean useSizeFromParent;
    
    public VerticalLayout() {
        this(true);
    }
    
    public VerticalLayout(final boolean useSizeFromParent) {
        this.useSizeFromParent = useSizeFromParent;
    }
    
    public void addLayoutComponent(final String s, final Component component) {
    }
    
    public void removeLayoutComponent(final Component component) {
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final Component[] components = container.getComponents();
            int n = insets.top + insets.bottom;
            int width = insets.left + insets.right;
            for (int i = 0; i < components.length; ++i) {
                if (components[i].isVisible()) {
                    final Dimension preferredSize = components[i].getPreferredSize();
                    n += preferredSize.height;
                    if (preferredSize.width > width) {
                        width = preferredSize.width;
                    }
                }
            }
            return new Dimension(width + insets.left + insets.right, n + insets.top + insets.bottom);
        }
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final Component[] components = container.getComponents();
            int n = insets.top + insets.bottom;
            int width = insets.left + insets.right;
            for (int i = 0; i < components.length; ++i) {
                if (components[i].isVisible()) {
                    final Dimension minimumSize = components[i].getMinimumSize();
                    n += minimumSize.height;
                    if (minimumSize.width > width) {
                        width = minimumSize.width;
                    }
                }
            }
            return new Dimension(width + insets.left + insets.right, n + insets.top + insets.bottom);
        }
    }
    
    public boolean isUseSizeFromParent() {
        return this.useSizeFromParent;
    }
    
    public void layoutContainer(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final int n = insets.left + insets.right;
            int n2;
            if (this.isUseSizeFromParent()) {
                n2 = container.getBounds().width - n;
            }
            else {
                n2 = this.preferredLayoutSize(container).width - n;
            }
            final Component[] components = container.getComponents();
            int top = insets.top;
            for (int i = 0; i < components.length; ++i) {
                final Component component = components[i];
                if (component.isVisible()) {
                    final Dimension preferredSize = component.getPreferredSize();
                    component.setBounds(insets.left, top, n2, preferredSize.height);
                    top += preferredSize.height;
                }
            }
        }
    }
}
