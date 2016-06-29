package org.jfree.layout;

import java.io.*;
import java.awt.*;

public class RadialLayout implements LayoutManager, Serializable
{
    private static final long serialVersionUID = -7582156799248315534L;
    private int minWidth;
    private int minHeight;
    private int maxCompWidth;
    private int maxCompHeight;
    private int preferredWidth;
    private int preferredHeight;
    private boolean sizeUnknown;
    
    public RadialLayout() {
        this.minWidth = 0;
        this.minHeight = 0;
        this.maxCompWidth = 0;
        this.maxCompHeight = 0;
        this.preferredWidth = 0;
        this.preferredHeight = 0;
        this.sizeUnknown = true;
    }
    
    public void addLayoutComponent(final Component component) {
    }
    
    public void removeLayoutComponent(final Component component) {
    }
    
    public void addLayoutComponent(final String s, final Component component) {
    }
    
    public void removeLayoutComponent(final String s, final Component component) {
    }
    
    private void setSizes(final Container container) {
        final int componentCount = container.getComponentCount();
        this.preferredWidth = 0;
        this.preferredHeight = 0;
        this.minWidth = 0;
        this.minHeight = 0;
        for (int i = 0; i < componentCount; ++i) {
            final Component component = container.getComponent(i);
            if (component.isVisible()) {
                final Dimension preferredSize = component.getPreferredSize();
                if (this.maxCompWidth < preferredSize.width) {
                    this.maxCompWidth = preferredSize.width;
                }
                if (this.maxCompHeight < preferredSize.height) {
                    this.maxCompHeight = preferredSize.height;
                }
                this.preferredWidth += preferredSize.width;
                this.preferredHeight += preferredSize.height;
            }
        }
        this.preferredWidth /= 2;
        this.preferredHeight /= 2;
        this.minWidth = this.preferredWidth;
        this.minHeight = this.preferredHeight;
    }
    
    public Dimension preferredLayoutSize(final Container sizes) {
        final Dimension dimension = new Dimension(0, 0);
        this.setSizes(sizes);
        final Insets insets = sizes.getInsets();
        dimension.width = this.preferredWidth + insets.left + insets.right;
        dimension.height = this.preferredHeight + insets.top + insets.bottom;
        this.sizeUnknown = false;
        return dimension;
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        final Dimension dimension = new Dimension(0, 0);
        final Insets insets = container.getInsets();
        dimension.width = this.minWidth + insets.left + insets.right;
        dimension.height = this.minHeight + insets.top + insets.bottom;
        this.sizeUnknown = false;
        return dimension;
    }
    
    public void layoutContainer(final Container sizes) {
        final Insets insets = sizes.getInsets();
        final int n = sizes.getSize().width - (insets.left + insets.right);
        final int n2 = sizes.getSize().height - (insets.top + insets.bottom);
        final int componentCount = sizes.getComponentCount();
        final int n3 = 0;
        final int n4 = 0;
        if (this.sizeUnknown) {
            this.setSizes(sizes);
        }
        if (componentCount < 2) {
            final Component component = sizes.getComponent(0);
            if (component.isVisible()) {
                final Dimension preferredSize = component.getPreferredSize();
                component.setBounds(n3, n4, preferredSize.width, preferredSize.height);
            }
        }
        else {
            double radians = Math.toRadians(90.0);
            final double n5 = 6.283185307179586 / componentCount;
            final int n6 = n / 2;
            final int n7 = n2 / 2;
            final int n8 = n6 - this.maxCompWidth;
            final int n9 = n7 - this.maxCompHeight;
            for (int i = 0; i < componentCount; ++i) {
                final Component component2 = sizes.getComponent(i);
                if (component2.isVisible()) {
                    final Dimension preferredSize2 = component2.getPreferredSize();
                    component2.setBounds((int)(n6 - n8 * Math.cos(radians) - preferredSize2.getWidth() / 2.0 + insets.left), (int)(n7 - n9 * Math.sin(radians) - preferredSize2.getHeight() / 2.0 + insets.top), preferredSize2.width, preferredSize2.height);
                }
                radians += n5;
            }
        }
    }
    
    public String toString() {
        return this.getClass().getName();
    }
    
    public static void main(final String[] array) {
        final Frame frame = new Frame();
        final Panel panel = new Panel();
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
