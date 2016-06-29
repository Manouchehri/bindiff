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

public class LCBLayout
implements LayoutManager,
Serializable {
    private static final long serialVersionUID = -2531780832406163833L;
    private static final int COLUMNS = 3;
    private int[] colWidth = new int[3];
    private int[] rowHeight;
    private int labelGap = 10;
    private int buttonGap = 6;
    private int vGap = 2;

    public LCBLayout(int n2) {
        this.rowHeight = new int[n2];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension preferredLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            int n2;
            int n3;
            Insets insets = container.getInsets();
            int n4 = container.getComponentCount();
            int n5 = n4 / 3;
            for (n2 = 0; n2 < 3; ++n2) {
                for (n3 = 0; n3 < n5; ++n3) {
                    Component component = container.getComponent(n3 * 3 + n2);
                    Dimension dimension = component.getPreferredSize();
                    if (this.colWidth[n2] < dimension.width) {
                        this.colWidth[n2] = dimension.width;
                    }
                    if (this.rowHeight[n3] >= dimension.height) continue;
                    this.rowHeight[n3] = dimension.height;
                }
            }
            n2 = this.vGap * (n5 - 1);
            n3 = 0;
            do {
                if (n3 >= n5) {
                    n3 = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
                    return new Dimension(insets.left + insets.right + n3 + this.labelGap + this.buttonGap, insets.top + insets.bottom + n2 + this.vGap);
                }
                n2 += this.rowHeight[n3];
                ++n3;
            } while (true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension minimumLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            int n2;
            int n3;
            Insets insets = container.getInsets();
            int n4 = container.getComponentCount();
            int n5 = n4 / 3;
            for (n2 = 0; n2 < 3; ++n2) {
                for (n3 = 0; n3 < n5; ++n3) {
                    Component component = container.getComponent(n3 * 3 + n2);
                    Dimension dimension = component.getMinimumSize();
                    if (this.colWidth[n2] < dimension.width) {
                        this.colWidth[n2] = dimension.width;
                    }
                    if (this.rowHeight[n3] >= dimension.height) continue;
                    this.rowHeight[n3] = dimension.height;
                }
            }
            n2 = this.vGap * (n5 - 1);
            n3 = 0;
            do {
                if (n3 >= n5) {
                    n3 = this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2];
                    return new Dimension(insets.left + insets.right + n3 + this.labelGap + this.buttonGap, insets.top + insets.bottom + n2 + this.vGap);
                }
                n2 += this.rowHeight[n3];
                ++n3;
            } while (true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void layoutContainer(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            int n2;
            int n3;
            Insets insets = container.getInsets();
            int n4 = container.getComponentCount();
            int n5 = n4 / 3;
            for (n3 = 0; n3 < 3; ++n3) {
                for (n2 = 0; n2 < n5; ++n2) {
                    Component component = container.getComponent(n2 * 3 + n3);
                    Dimension dimension = component.getPreferredSize();
                    if (this.colWidth[n3] < dimension.width) {
                        this.colWidth[n3] = dimension.width;
                    }
                    if (this.rowHeight[n2] >= dimension.height) continue;
                    this.rowHeight[n2] = dimension.height;
                }
            }
            n3 = this.vGap * (n5 - 1);
            for (n2 = 0; n2 < n5; n3 += this.rowHeight[n2], ++n2) {
            }
            n2 = this.colWidth[0] + this.colWidth[1] + this.colWidth[2];
            int n6 = container.getWidth() - insets.left - insets.right - this.labelGap - this.buttonGap;
            this.colWidth[1] = this.colWidth[1] + (n6 - n2);
            int n7 = insets.left;
            int n8 = 0;
            while (n8 < 3) {
                int n9 = insets.top;
                for (int i2 = 0; i2 < n5; ++i2) {
                    int n10 = i2 * 3 + n8;
                    if (n10 < n4) {
                        Component component = container.getComponent(n10);
                        Dimension dimension = component.getPreferredSize();
                        int n11 = dimension.height;
                        int n12 = (this.rowHeight[i2] - n11) / 2;
                        container.getComponent(n10).setBounds(n7, n9 + n12, this.colWidth[n8], n11);
                    }
                    n9 = n9 + this.rowHeight[i2] + this.vGap;
                }
                n7 += this.colWidth[n8];
                if (n8 == 0) {
                    n7 += this.labelGap;
                }
                if (n8 == 1) {
                    n7 += this.buttonGap;
                }
                ++n8;
            }
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

