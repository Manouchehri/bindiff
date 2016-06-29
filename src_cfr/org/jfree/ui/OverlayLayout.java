/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;

public final class OverlayLayout
implements LayoutManager {
    private boolean ignoreInvisible;

    public OverlayLayout(boolean bl2) {
        this.ignoreInvisible = bl2;
    }

    public OverlayLayout() {
    }

    @Override
    public void addLayoutComponent(String string, Component component) {
    }

    @Override
    public void removeLayoutComponent(Component component) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void layoutContainer(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            Rectangle rectangle = container.getBounds();
            int n2 = rectangle.width - insets.left - insets.right;
            int n3 = rectangle.height - insets.top - insets.bottom;
            Component[] arrcomponent = container.getComponents();
            int n4 = 0;
            while (n4 < arrcomponent.length) {
                Component component = arrcomponent[n4];
                if (arrcomponent[n4].isVisible() || !this.ignoreInvisible) {
                    component.setBounds(insets.left, insets.top, n2, n3);
                }
                ++n4;
            }
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension minimumLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            Component[] arrcomponent = container.getComponents();
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            while (n4 < arrcomponent.length) {
                if (arrcomponent[n4].isVisible() || !this.ignoreInvisible) {
                    Dimension dimension = arrcomponent[n4].getMinimumSize();
                    if (dimension.height > n2) {
                        n2 = dimension.height;
                    }
                    if (dimension.width > n3) {
                        n3 = dimension.width;
                    }
                }
                ++n4;
            }
            return new Dimension(n3 + insets.left + insets.right, n2 + insets.top + insets.bottom);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension preferredLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            Component[] arrcomponent = container.getComponents();
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            while (n4 < arrcomponent.length) {
                if (arrcomponent[n4].isVisible() || !this.ignoreInvisible) {
                    Dimension dimension = arrcomponent[n4].getPreferredSize();
                    if (dimension.height > n2) {
                        n2 = dimension.height;
                    }
                    if (dimension.width > n3) {
                        n3 = dimension.width;
                    }
                }
                ++n4;
            }
            return new Dimension(n3 + insets.left + insets.right, n2 + insets.top + insets.bottom);
        }
    }
}

