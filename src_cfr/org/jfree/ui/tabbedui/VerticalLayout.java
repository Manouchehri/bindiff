/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui.tabbedui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;

public class VerticalLayout
implements LayoutManager {
    private final boolean useSizeFromParent;

    public VerticalLayout() {
        this(true);
    }

    public VerticalLayout(boolean bl2) {
        this.useSizeFromParent = bl2;
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
    public Dimension preferredLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            Component[] arrcomponent = container.getComponents();
            int n2 = insets.top + insets.bottom;
            int n3 = insets.left + insets.right;
            int n4 = 0;
            while (n4 < arrcomponent.length) {
                if (arrcomponent[n4].isVisible()) {
                    Dimension dimension = arrcomponent[n4].getPreferredSize();
                    n2 += dimension.height;
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
    public Dimension minimumLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            Component[] arrcomponent = container.getComponents();
            int n2 = insets.top + insets.bottom;
            int n3 = insets.left + insets.right;
            int n4 = 0;
            while (n4 < arrcomponent.length) {
                if (arrcomponent[n4].isVisible()) {
                    Dimension dimension = arrcomponent[n4].getMinimumSize();
                    n2 += dimension.height;
                    if (dimension.width > n3) {
                        n3 = dimension.width;
                    }
                }
                ++n4;
            }
            return new Dimension(n3 + insets.left + insets.right, n2 + insets.top + insets.bottom);
        }
    }

    public boolean isUseSizeFromParent() {
        return this.useSizeFromParent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void layoutContainer(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Component[] arrcomponent;
            int n2;
            Insets insets = container.getInsets();
            int n3 = insets.left + insets.right;
            if (this.isUseSizeFromParent()) {
                arrcomponent = container.getBounds();
                n2 = arrcomponent.width - n3;
            } else {
                n2 = this.preferredLayoutSize((Container)container).width - n3;
            }
            arrcomponent = container.getComponents();
            int n4 = insets.top;
            int n5 = 0;
            while (n5 < arrcomponent.length) {
                Component component = arrcomponent[n5];
                if (component.isVisible()) {
                    Dimension dimension = component.getPreferredSize();
                    component.setBounds(insets.left, n4, n2, dimension.height);
                    n4 += dimension.height;
                }
                ++n5;
            }
            return;
        }
    }
}

