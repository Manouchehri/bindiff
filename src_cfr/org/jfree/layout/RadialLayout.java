/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.layout;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.io.Serializable;

public class RadialLayout
implements LayoutManager,
Serializable {
    private static final long serialVersionUID = -7582156799248315534L;
    private int minWidth = 0;
    private int minHeight = 0;
    private int maxCompWidth = 0;
    private int maxCompHeight = 0;
    private int preferredWidth = 0;
    private int preferredHeight = 0;
    private boolean sizeUnknown = true;

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

    private void setSizes(Container container) {
        int n2 = container.getComponentCount();
        this.preferredWidth = 0;
        this.preferredHeight = 0;
        this.minWidth = 0;
        this.minHeight = 0;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.preferredWidth /= 2;
                this.preferredHeight /= 2;
                this.minWidth = this.preferredWidth;
                this.minHeight = this.preferredHeight;
                return;
            }
            Component component = container.getComponent(n3);
            if (component.isVisible()) {
                Dimension dimension = component.getPreferredSize();
                if (this.maxCompWidth < dimension.width) {
                    this.maxCompWidth = dimension.width;
                }
                if (this.maxCompHeight < dimension.height) {
                    this.maxCompHeight = dimension.height;
                }
                this.preferredWidth += dimension.width;
                this.preferredHeight += dimension.height;
            }
            ++n3;
        } while (true);
    }

    @Override
    public Dimension preferredLayoutSize(Container container) {
        Dimension dimension = new Dimension(0, 0);
        this.setSizes(container);
        Insets insets = container.getInsets();
        dimension.width = this.preferredWidth + insets.left + insets.right;
        dimension.height = this.preferredHeight + insets.top + insets.bottom;
        this.sizeUnknown = false;
        return dimension;
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension = new Dimension(0, 0);
        Insets insets = container.getInsets();
        dimension.width = this.minWidth + insets.left + insets.right;
        dimension.height = this.minHeight + insets.top + insets.bottom;
        this.sizeUnknown = false;
        return dimension;
    }

    @Override
    public void layoutContainer(Container container) {
        Insets insets = container.getInsets();
        int n2 = container.getSize().width - (insets.left + insets.right);
        int n3 = container.getSize().height - (insets.top + insets.bottom);
        int n4 = container.getComponentCount();
        int n5 = 0;
        int n6 = 0;
        if (this.sizeUnknown) {
            this.setSizes(container);
        }
        if (n4 < 2) {
            Component component = container.getComponent(0);
            if (!component.isVisible()) return;
            Dimension dimension = component.getPreferredSize();
            component.setBounds(n5, n6, dimension.width, dimension.height);
            return;
        }
        double d2 = Math.toRadians(90.0);
        double d3 = 6.283185307179586 / (double)n4;
        int n7 = n2 / 2;
        int n8 = n3 / 2;
        int n9 = n7 - this.maxCompWidth;
        int n10 = n8 - this.maxCompHeight;
        int n11 = 0;
        while (n11 < n4) {
            Component component = container.getComponent(n11);
            if (component.isVisible()) {
                Dimension dimension = component.getPreferredSize();
                n5 = (int)((double)n7 - (double)n9 * Math.cos(d2) - dimension.getWidth() / 2.0 + (double)insets.left);
                n6 = (int)((double)n8 - (double)n10 * Math.sin(d2) - dimension.getHeight() / 2.0 + (double)insets.top);
                component.setBounds(n5, n6, dimension.width, dimension.height);
            }
            d2 += d3;
            ++n11;
        }
    }

    public String toString() {
        return this.getClass().getName();
    }

    public static void main(String[] arrstring) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        panel.setLayout(new RadialLayout());
        panel.add(new Checkbox("One"));
        panel.add(new Checkbox("Two"));
        panel.add(new Checkbox("Three"));
        panel.add(new Checkbox("Four"));
        panel.add(new Checkbox("Five"));
        panel.add(new Checkbox("One"));
        panel.add(new Checkbox("Two"));
        panel.add(new Checkbox("Three"));
        panel.add(new Checkbox("Four"));
        panel.add(new Checkbox("Five"));
        frame.add(panel);
        frame.setSize(300, 500);
        frame.setVisible(true);
    }
}

