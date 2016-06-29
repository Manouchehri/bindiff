/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.layout;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.io.Serializable;

public class FormatLayout
implements LayoutManager,
Serializable {
    private static final long serialVersionUID = 2866692886323930722L;
    public static final int C = 1;
    public static final int LC = 2;
    public static final int LCB = 3;
    public static final int LCLC = 4;
    public static final int LCLCB = 5;
    public static final int LCBLC = 6;
    public static final int LCBLCB = 7;
    private int[] rowFormats;
    private int rowGap;
    private int[] columnGaps;
    private int[] rowHeights;
    private int totalHeight;
    private int[] columnWidths;
    private int totalWidth;
    private int columns1and2Width;
    private int columns4and5Width;
    private int columns1to4Width;
    private int columns1to5Width;
    private int columns0to5Width;

    public FormatLayout(int n2, int[] arrn) {
        this.rowFormats = arrn;
        this.rowGap = 2;
        this.columnGaps = new int[5];
        this.columnGaps[0] = 10;
        this.columnGaps[1] = 5;
        this.columnGaps[2] = 5;
        this.columnGaps[3] = 10;
        this.columnGaps[4] = 5;
        this.rowHeights = new int[n2];
        this.columnWidths = new int[6];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Dimension preferredLayoutSize(Container container) {
        Object object = container.getTreeLock();
        synchronized (object) {
            int n2;
            Insets insets = container.getInsets();
            int n3 = 0;
            int n4 = this.rowHeights.length;
            for (n2 = 0; n2 < this.columnWidths.length; ++n2) {
                this.columnWidths[n2] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = 0;
            this.totalHeight = 0;
            n2 = 0;
            do {
                if (n2 >= n4) {
                    this.complete();
                    return new Dimension(this.totalWidth + insets.left + insets.right, this.totalHeight + (n4 - 1) * this.rowGap + insets.top + insets.bottom);
                }
                int n5 = this.rowFormats[n2 % this.rowFormats.length];
                switch (n5) {
                    Component component;
                    Component component2;
                    Component component3;
                    Component component4;
                    Component component5;
                    case 1: {
                        component = container.getComponent(n3);
                        this.updateC(n2, component.getPreferredSize());
                        ++n3;
                        break;
                    }
                    case 2: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        this.updateLC(n2, component.getPreferredSize(), component4.getPreferredSize());
                        n3 += 2;
                        break;
                    }
                    case 3: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        this.updateLCB(n2, component.getPreferredSize(), component4.getPreferredSize(), component3.getPreferredSize());
                        n3 += 3;
                        break;
                    }
                    case 4: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component2 = container.getComponent(n3 + 3);
                        this.updateLCLC(n2, component.getPreferredSize(), component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize());
                        n3 += 4;
                        break;
                    }
                    case 6: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component2 = container.getComponent(n3 + 3);
                        component5 = container.getComponent(n3 + 4);
                        this.updateLCBLC(n2, component.getPreferredSize(), component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component5.getPreferredSize());
                        n3 += 5;
                        break;
                    }
                    case 5: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component2 = container.getComponent(n3 + 3);
                        component5 = container.getComponent(n3 + 4);
                        this.updateLCLCB(n2, component.getPreferredSize(), component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component5.getPreferredSize());
                        n3 += 5;
                        break;
                    }
                    case 7: {
                        component = container.getComponent(n3);
                        component4 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component2 = container.getComponent(n3 + 3);
                        component5 = container.getComponent(n3 + 4);
                        Component component6 = container.getComponent(n3 + 5);
                        this.updateLCBLCB(n2, component.getPreferredSize(), component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component5.getPreferredSize(), component6.getPreferredSize());
                        n3 += 6;
                    }
                }
                ++n2;
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
            Insets insets = container.getInsets();
            int n3 = 0;
            int n4 = this.rowHeights.length;
            for (n2 = 0; n2 < this.columnWidths.length; ++n2) {
                this.columnWidths[n2] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = 0;
            n2 = 0;
            int n5 = 0;
            do {
                if (n5 >= n4) {
                    this.complete();
                    return new Dimension(this.totalWidth + insets.left + insets.right, 0 + (n4 - 1) * this.rowGap + insets.top + insets.bottom);
                }
                int n6 = this.rowFormats[n5 % this.rowFormats.length];
                switch (n6) {
                    Component component;
                    Component component2;
                    Component component3;
                    Component component4;
                    Component component5;
                    case 1: {
                        component4 = container.getComponent(n3);
                        this.columns0to5Width = Math.max(this.columns0to5Width, component4.getMinimumSize().width);
                        ++n3;
                        break;
                    }
                    case 2: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        this.updateLC(n5, component4.getMinimumSize(), component2.getMinimumSize());
                        n3 += 2;
                        break;
                    }
                    case 3: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        this.updateLCB(n5, component4.getMinimumSize(), component2.getMinimumSize(), component3.getMinimumSize());
                        n3 += 3;
                        break;
                    }
                    case 4: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component5 = container.getComponent(n3 + 3);
                        this.updateLCLC(n5, component4.getMinimumSize(), component2.getMinimumSize(), component3.getMinimumSize(), component5.getMinimumSize());
                        n3 += 3;
                        break;
                    }
                    case 6: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component5 = container.getComponent(n3 + 3);
                        component = container.getComponent(n3 + 4);
                        this.updateLCBLC(n5, component4.getMinimumSize(), component2.getMinimumSize(), component3.getMinimumSize(), component5.getMinimumSize(), component.getMinimumSize());
                        n3 += 4;
                        break;
                    }
                    case 5: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component5 = container.getComponent(n3 + 3);
                        component = container.getComponent(n3 + 4);
                        this.updateLCLCB(n5, component4.getMinimumSize(), component2.getMinimumSize(), component3.getMinimumSize(), component5.getMinimumSize(), component.getMinimumSize());
                        n3 += 4;
                        break;
                    }
                    case 7: {
                        component4 = container.getComponent(n3);
                        component2 = container.getComponent(n3 + 1);
                        component3 = container.getComponent(n3 + 2);
                        component5 = container.getComponent(n3 + 3);
                        component = container.getComponent(n3 + 4);
                        Component component6 = container.getComponent(n3 + 5);
                        this.updateLCBLCB(n5, component4.getMinimumSize(), component2.getMinimumSize(), component3.getMinimumSize(), component5.getMinimumSize(), component.getMinimumSize(), component6.getMinimumSize());
                        n3 += 5;
                    }
                }
                ++n5;
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
            int[] arrn;
            Component component;
            Component component2;
            Component component3;
            Component component4;
            int n2;
            Component component5;
            Component component6;
            Insets insets = container.getInsets();
            int n3 = 0;
            int n4 = this.rowHeights.length;
            for (n2 = 0; n2 < this.columnWidths.length; ++n2) {
                this.columnWidths[n2] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = container.getBounds().width - insets.left - insets.right;
            this.totalHeight = 0;
            block22 : for (n2 = 0; n2 < n4; ++n2) {
                int n5 = this.rowFormats[n2 % this.rowFormats.length];
                switch (n5) {
                    case 1: {
                        component4 = container.getComponent(n3);
                        this.updateC(n2, component4.getPreferredSize());
                        ++n3;
                        continue block22;
                    }
                    case 2: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        this.updateLC(n2, component4.getPreferredSize(), component3.getPreferredSize());
                        n3 += 2;
                        continue block22;
                    }
                    case 3: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        component2 = container.getComponent(n3 + 2);
                        this.updateLCB(n2, component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize());
                        n3 += 3;
                        continue block22;
                    }
                    case 4: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        component2 = container.getComponent(n3 + 2);
                        component = container.getComponent(n3 + 3);
                        this.updateLCLC(n2, component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component.getPreferredSize());
                        n3 += 4;
                        continue block22;
                    }
                    case 6: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        component2 = container.getComponent(n3 + 2);
                        component = container.getComponent(n3 + 3);
                        component6 = container.getComponent(n3 + 4);
                        this.updateLCBLC(n2, component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component.getPreferredSize(), component6.getPreferredSize());
                        n3 += 5;
                        continue block22;
                    }
                    case 5: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        component2 = container.getComponent(n3 + 2);
                        component = container.getComponent(n3 + 3);
                        component6 = container.getComponent(n3 + 4);
                        this.updateLCLCB(n2, component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component.getPreferredSize(), component6.getPreferredSize());
                        n3 += 5;
                        continue block22;
                    }
                    case 7: {
                        component4 = container.getComponent(n3);
                        component3 = container.getComponent(n3 + 1);
                        component2 = container.getComponent(n3 + 2);
                        component = container.getComponent(n3 + 3);
                        component6 = container.getComponent(n3 + 4);
                        component5 = container.getComponent(n3 + 5);
                        this.updateLCBLCB(n2, component4.getPreferredSize(), component3.getPreferredSize(), component2.getPreferredSize(), component.getPreferredSize(), component6.getPreferredSize(), component5.getPreferredSize());
                        n3 += 6;
                    }
                }
            }
            this.complete();
            n3 = 0;
            n2 = insets.top;
            arrn = new int[]{insets.left, arrn[0] + this.columnWidths[0] + this.columnGaps[0], arrn[1] + this.columnWidths[1] + this.columnGaps[1], arrn[2] + this.columnWidths[2] + this.columnGaps[2], arrn[3] + this.columnWidths[3] + this.columnGaps[3], arrn[4] + this.columnWidths[4] + this.columnGaps[4]};
            int n6 = this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
            int n7 = this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
            int n8 = n6 + this.columnGaps[2] + this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4];
            int n9 = n8 + this.columnGaps[4] + this.columnWidths[5];
            int n10 = n9 + this.columnWidths[0] + this.columnGaps[0];
            int n11 = 0;
            while (n11 < n4) {
                int n12 = this.rowFormats[n11 % this.rowFormats.length];
                switch (n12) {
                    case 1: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2, n10, component4.getPreferredSize().height);
                        ++n3;
                        break;
                    }
                    case 2: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, n9, component3.getPreferredSize().height);
                        n3 += 2;
                        break;
                    }
                    case 3: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, n8, component3.getPreferredSize().height);
                        component2 = container.getComponent(n3 + 2);
                        component2.setBounds(arrn[5], n2 + (this.rowHeights[n11] - component2.getPreferredSize().height) / 2, this.columnWidths[5], component2.getPreferredSize().height);
                        n3 += 3;
                        break;
                    }
                    case 4: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, n6, component3.getPreferredSize().height);
                        component2 = container.getComponent(n3 + 2);
                        component2.setBounds(arrn[3], n2 + (this.rowHeights[n11] - component2.getPreferredSize().height) / 2, this.columnWidths[3], component2.getPreferredSize().height);
                        component = container.getComponent(n3 + 3);
                        component.setBounds(arrn[4], n2 + (this.rowHeights[n11] - component.getPreferredSize().height) / 2, n7, component.getPreferredSize().height);
                        n3 += 4;
                        break;
                    }
                    case 6: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, this.columnWidths[1], component3.getPreferredSize().height);
                        component2 = container.getComponent(n3 + 2);
                        component2.setBounds(arrn[2], n2 + (this.rowHeights[n11] - component2.getPreferredSize().height) / 2, this.columnWidths[2], component2.getPreferredSize().height);
                        component = container.getComponent(n3 + 3);
                        component.setBounds(arrn[3], n2 + (this.rowHeights[n11] - component.getPreferredSize().height) / 2, this.columnWidths[3], component.getPreferredSize().height);
                        component6 = container.getComponent(n3 + 4);
                        component6.setBounds(arrn[4], n2 + (this.rowHeights[n11] - component6.getPreferredSize().height) / 2, n7, component6.getPreferredSize().height);
                        n3 += 5;
                        break;
                    }
                    case 5: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, n6, component3.getPreferredSize().height);
                        component2 = container.getComponent(n3 + 2);
                        component2.setBounds(arrn[3], n2 + (this.rowHeights[n11] - component2.getPreferredSize().height) / 2, this.columnWidths[3], component2.getPreferredSize().height);
                        component = container.getComponent(n3 + 3);
                        component.setBounds(arrn[4], n2 + (this.rowHeights[n11] - component.getPreferredSize().height) / 2, this.columnWidths[4], component.getPreferredSize().height);
                        component6 = container.getComponent(n3 + 4);
                        component6.setBounds(arrn[5], n2 + (this.rowHeights[n11] - component6.getPreferredSize().height) / 2, this.columnWidths[5], component6.getPreferredSize().height);
                        n3 += 5;
                        break;
                    }
                    case 7: {
                        component4 = container.getComponent(n3);
                        component4.setBounds(arrn[0], n2 + (this.rowHeights[n11] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        component3 = container.getComponent(n3 + 1);
                        component3.setBounds(arrn[1], n2 + (this.rowHeights[n11] - component3.getPreferredSize().height) / 2, this.columnWidths[1], component3.getPreferredSize().height);
                        component2 = container.getComponent(n3 + 2);
                        component2.setBounds(arrn[2], n2 + (this.rowHeights[n11] - component2.getPreferredSize().height) / 2, this.columnWidths[2], component2.getPreferredSize().height);
                        component = container.getComponent(n3 + 3);
                        component.setBounds(arrn[3], n2 + (this.rowHeights[n11] - component.getPreferredSize().height) / 2, this.columnWidths[3], component.getPreferredSize().height);
                        component6 = container.getComponent(n3 + 4);
                        component6.setBounds(arrn[4], n2 + (this.rowHeights[n11] - component6.getPreferredSize().height) / 2, this.columnWidths[4], component6.getPreferredSize().height);
                        component5 = container.getComponent(n3 + 5);
                        component5.setBounds(arrn[5], n2 + (this.rowHeights[n11] - component5.getPreferredSize().height) / 2, this.columnWidths[5], component5.getPreferredSize().height);
                        n3 += 6;
                    }
                }
                n2 = n2 + this.rowHeights[n11] + this.rowGap;
                ++n11;
            }
            return;
        }
    }

    protected void updateC(int n2, Dimension dimension) {
        this.rowHeights[n2] = dimension.height;
        this.totalHeight += this.rowHeights[n2];
        this.columns0to5Width = Math.max(this.columns0to5Width, dimension.width);
    }

    protected void updateLC(int n2, Dimension dimension, Dimension dimension2) {
        this.rowHeights[n2] = Math.max(dimension.height, dimension2.height);
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1to5Width = Math.max(this.columns1to5Width, dimension2.width);
    }

    protected void updateLCB(int n2, Dimension dimension, Dimension dimension2, Dimension dimension3) {
        this.rowHeights[n2] = Math.max(dimension.height, Math.max(dimension2.height, dimension3.height));
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1to4Width = Math.max(this.columns1to4Width, dimension2.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension3.width);
    }

    protected void updateLCLC(int n2, Dimension dimension, Dimension dimension2, Dimension dimension3, Dimension dimension4) {
        this.rowHeights[n2] = Math.max(Math.max(dimension.height, dimension2.height), Math.max(dimension3.height, dimension4.height));
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1and2Width = Math.max(this.columns1and2Width, dimension2.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension3.width);
        this.columns4and5Width = Math.max(this.columns4and5Width, dimension4.width);
    }

    protected void updateLCBLC(int n2, Dimension dimension, Dimension dimension2, Dimension dimension3, Dimension dimension4, Dimension dimension5) {
        this.rowHeights[n2] = Math.max(dimension.height, Math.max(Math.max(dimension2.height, dimension3.height), Math.max(dimension4.height, dimension5.height)));
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columnWidths[1] = Math.max(this.columnWidths[1], dimension2.width);
        this.columnWidths[2] = Math.max(this.columnWidths[2], dimension3.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension4.width);
        this.columns4and5Width = Math.max(this.columns4and5Width, dimension5.width);
    }

    protected void updateLCLCB(int n2, Dimension dimension, Dimension dimension2, Dimension dimension3, Dimension dimension4, Dimension dimension5) {
        this.rowHeights[n2] = Math.max(dimension.height, Math.max(Math.max(dimension2.height, dimension3.height), Math.max(dimension4.height, dimension5.height)));
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1and2Width = Math.max(this.columns1and2Width, dimension2.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension3.width);
        this.columnWidths[4] = Math.max(this.columnWidths[4], dimension4.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension5.width);
    }

    protected void updateLCBLCB(int n2, Dimension dimension, Dimension dimension2, Dimension dimension3, Dimension dimension4, Dimension dimension5, Dimension dimension6) {
        this.rowHeights[n2] = Math.max(Math.max(dimension.height, dimension2.height), Math.max(Math.max(dimension3.height, dimension4.height), Math.max(dimension5.height, dimension6.height)));
        this.totalHeight += this.rowHeights[n2];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columnWidths[1] = Math.max(this.columnWidths[1], dimension2.width);
        this.columnWidths[2] = Math.max(this.columnWidths[2], dimension3.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension4.width);
        this.columnWidths[4] = Math.max(this.columnWidths[4], dimension5.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension6.width);
    }

    public void complete() {
        int n2;
        this.columnWidths[1] = Math.max(this.columnWidths[1], this.columns1and2Width - this.columnGaps[1] - this.columnWidths[2]);
        this.columnWidths[4] = Math.max(this.columnWidths[4], Math.max(this.columns4and5Width - this.columnGaps[4] - this.columnWidths[5], Math.max(this.columns1to4Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3], this.columns1to5Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3] - this.columnGaps[4])));
        int n3 = this.columnWidths[0] + this.columnGaps[0] + this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
        int n4 = this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
        if (this.splitLayout()) {
            if (n3 > n4) {
                n2 = n3 - n4;
                this.columnWidths[4] = this.columnWidths[4] + n2;
                n4 += n2;
            } else {
                n2 = n4 - n3;
                this.columnWidths[1] = this.columnWidths[1] + n2;
                n3 += n2;
            }
        }
        this.totalWidth = n3 + this.columnGaps[2] + n4;
        if (this.columns0to5Width <= this.totalWidth) return;
        n2 = this.columns0to5Width - this.totalWidth;
        if (this.splitLayout()) {
            int n5 = n2 / 2;
            this.columnWidths[1] = this.columnWidths[1] + n5;
            this.columnWidths[4] = this.columnWidths[4] + n2 - n5;
            this.totalWidth += n2;
            return;
        }
        this.columnWidths[1] = this.columnWidths[1] + n2;
        this.totalWidth += n2;
    }

    private boolean splitLayout() {
        int n2 = 0;
        while (n2 < this.rowFormats.length) {
            if (this.rowFormats[n2] > 3) {
                return true;
            }
            ++n2;
        }
        return false;
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

