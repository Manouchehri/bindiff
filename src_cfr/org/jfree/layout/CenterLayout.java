/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.io.Serializable;

public class CenterLayout
implements LayoutManager,
Serializable {
    private static final long serialVersionUID = 469319532333015042L;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension preferredLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            Insets insets = container.getInsets();
            if (container.getComponentCount() <= 0) return new Dimension(insets.left + insets.right, insets.top + insets.bottom);
            Component component = container.getComponent(0);
            Dimension dimension = component.getPreferredSize();
            return new Dimension((int)dimension.getWidth() + insets.left + insets.right, (int)dimension.getHeight() + insets.top + insets.bottom);
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
            if (container.getComponentCount() <= 0) return new Dimension(insets.left + insets.right, insets.top + insets.bottom);
            Component component = container.getComponent(0);
            Dimension dimension = component.getMinimumSize();
            return new Dimension(dimension.width + insets.left + insets.right, dimension.height + insets.top + insets.bottom);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void layoutContainer(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            if (container.getComponentCount() <= 0) return;
            Insets insets = container.getInsets();
            Dimension dimension = container.getSize();
            Component component = container.getComponent(0);
            Dimension dimension2 = component.getPreferredSize();
            int n2 = insets.left + Math.max((dimension.width - insets.left - insets.right - dimension2.width) / 2, 0);
            int n3 = insets.top + Math.max((dimension.height - insets.top - insets.bottom - dimension2.height) / 2, 0);
            component.setBounds(n2, n3, dimension2.width, dimension2.height);
            return;
        }
    }

    public void addLayoutComponent(Component component) {
    }

    @Override
    public void removeLayoutComponent(Component component) {
    }

    @Override
    public void addLayoutComponent(String string, Component component) {
    }

    public void removeLayoutComponent(String string, Component component) {
    }
}

