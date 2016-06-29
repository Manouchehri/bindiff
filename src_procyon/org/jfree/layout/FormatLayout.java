package org.jfree.layout;

import java.io.*;
import java.awt.*;

public class FormatLayout implements LayoutManager, Serializable
{
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
    
    public FormatLayout(final int n, final int[] rowFormats) {
        this.rowFormats = rowFormats;
        this.rowGap = 2;
        (this.columnGaps = new int[5])[0] = 10;
        this.columnGaps[1] = 5;
        this.columnGaps[2] = 5;
        this.columnGaps[3] = 10;
        this.columnGaps[4] = 5;
        this.rowHeights = new int[n];
        this.columnWidths = new int[6];
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            int n = 0;
            final int length = this.rowHeights.length;
            for (int i = 0; i < this.columnWidths.length; ++i) {
                this.columnWidths[i] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = 0;
            this.totalHeight = 0;
            for (int j = 0; j < length; ++j) {
                switch (this.rowFormats[j % this.rowFormats.length]) {
                    case 1: {
                        this.updateC(j, container.getComponent(n).getPreferredSize());
                        ++n;
                        break;
                    }
                    case 2: {
                        this.updateLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize());
                        n += 2;
                        break;
                    }
                    case 3: {
                        this.updateLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize());
                        n += 3;
                        break;
                    }
                    case 4: {
                        this.updateLCLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize());
                        n += 4;
                        break;
                    }
                    case 6: {
                        this.updateLCBLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize());
                        n += 5;
                        break;
                    }
                    case 5: {
                        this.updateLCLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize());
                        n += 5;
                        break;
                    }
                    case 7: {
                        this.updateLCBLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize(), container.getComponent(n + 5).getPreferredSize());
                        n += 6;
                        break;
                    }
                }
            }
            this.complete();
            return new Dimension(this.totalWidth + insets.left + insets.right, this.totalHeight + (length - 1) * this.rowGap + insets.top + insets.bottom);
        }
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            int n = 0;
            final int length = this.rowHeights.length;
            for (int i = 0; i < this.columnWidths.length; ++i) {
                this.columnWidths[i] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = 0;
            for (int j = 0; j < length; ++j) {
                switch (this.rowFormats[j % this.rowFormats.length]) {
                    case 1: {
                        this.columns0to5Width = Math.max(this.columns0to5Width, container.getComponent(n).getMinimumSize().width);
                        ++n;
                        break;
                    }
                    case 2: {
                        this.updateLC(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize());
                        n += 2;
                        break;
                    }
                    case 3: {
                        this.updateLCB(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize(), container.getComponent(n + 2).getMinimumSize());
                        n += 3;
                        break;
                    }
                    case 4: {
                        this.updateLCLC(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize(), container.getComponent(n + 2).getMinimumSize(), container.getComponent(n + 3).getMinimumSize());
                        n += 3;
                        break;
                    }
                    case 6: {
                        this.updateLCBLC(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize(), container.getComponent(n + 2).getMinimumSize(), container.getComponent(n + 3).getMinimumSize(), container.getComponent(n + 4).getMinimumSize());
                        n += 4;
                        break;
                    }
                    case 5: {
                        this.updateLCLCB(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize(), container.getComponent(n + 2).getMinimumSize(), container.getComponent(n + 3).getMinimumSize(), container.getComponent(n + 4).getMinimumSize());
                        n += 4;
                        break;
                    }
                    case 7: {
                        this.updateLCBLCB(j, container.getComponent(n).getMinimumSize(), container.getComponent(n + 1).getMinimumSize(), container.getComponent(n + 2).getMinimumSize(), container.getComponent(n + 3).getMinimumSize(), container.getComponent(n + 4).getMinimumSize(), container.getComponent(n + 5).getMinimumSize());
                        n += 5;
                        break;
                    }
                }
            }
            this.complete();
            return new Dimension(this.totalWidth + insets.left + insets.right, 0 + (length - 1) * this.rowGap + insets.top + insets.bottom);
        }
    }
    
    public void layoutContainer(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            int n = 0;
            final int length = this.rowHeights.length;
            for (int i = 0; i < this.columnWidths.length; ++i) {
                this.columnWidths[i] = 0;
            }
            this.columns1and2Width = 0;
            this.columns4and5Width = 0;
            this.columns1to4Width = 0;
            this.columns1to5Width = 0;
            this.columns0to5Width = container.getBounds().width - insets.left - insets.right;
            this.totalHeight = 0;
            for (int j = 0; j < length; ++j) {
                switch (this.rowFormats[j % this.rowFormats.length]) {
                    case 1: {
                        this.updateC(j, container.getComponent(n).getPreferredSize());
                        ++n;
                        break;
                    }
                    case 2: {
                        this.updateLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize());
                        n += 2;
                        break;
                    }
                    case 3: {
                        this.updateLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize());
                        n += 3;
                        break;
                    }
                    case 4: {
                        this.updateLCLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize());
                        n += 4;
                        break;
                    }
                    case 6: {
                        this.updateLCBLC(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize());
                        n += 5;
                        break;
                    }
                    case 5: {
                        this.updateLCLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize());
                        n += 5;
                        break;
                    }
                    case 7: {
                        this.updateLCBLCB(j, container.getComponent(n).getPreferredSize(), container.getComponent(n + 1).getPreferredSize(), container.getComponent(n + 2).getPreferredSize(), container.getComponent(n + 3).getPreferredSize(), container.getComponent(n + 4).getPreferredSize(), container.getComponent(n + 5).getPreferredSize());
                        n += 6;
                        break;
                    }
                }
            }
            this.complete();
            int n2 = 0;
            int top = insets.top;
            final int[] array = new int[6];
            array[0] = insets.left;
            array[1] = array[0] + this.columnWidths[0] + this.columnGaps[0];
            array[2] = array[1] + this.columnWidths[1] + this.columnGaps[1];
            array[3] = array[2] + this.columnWidths[2] + this.columnGaps[2];
            array[4] = array[3] + this.columnWidths[3] + this.columnGaps[3];
            array[5] = array[4] + this.columnWidths[4] + this.columnGaps[4];
            final int n3 = this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
            final int n4 = this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
            final int n5 = n3 + this.columnGaps[2] + this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4];
            final int n6 = n5 + this.columnGaps[4] + this.columnWidths[5];
            final int n7 = n6 + this.columnWidths[0] + this.columnGaps[0];
            for (int k = 0; k < length; ++k) {
                switch (this.rowFormats[k % this.rowFormats.length]) {
                    case 1: {
                        final Component component = container.getComponent(n2);
                        component.setBounds(array[0], top, n7, component.getPreferredSize().height);
                        ++n2;
                        break;
                    }
                    case 2: {
                        final Component component2 = container.getComponent(n2);
                        component2.setBounds(array[0], top + (this.rowHeights[k] - component2.getPreferredSize().height) / 2, this.columnWidths[0], component2.getPreferredSize().height);
                        final Component component3 = container.getComponent(n2 + 1);
                        component3.setBounds(array[1], top + (this.rowHeights[k] - component3.getPreferredSize().height) / 2, n6, component3.getPreferredSize().height);
                        n2 += 2;
                        break;
                    }
                    case 3: {
                        final Component component4 = container.getComponent(n2);
                        component4.setBounds(array[0], top + (this.rowHeights[k] - component4.getPreferredSize().height) / 2, this.columnWidths[0], component4.getPreferredSize().height);
                        final Component component5 = container.getComponent(n2 + 1);
                        component5.setBounds(array[1], top + (this.rowHeights[k] - component5.getPreferredSize().height) / 2, n5, component5.getPreferredSize().height);
                        final Component component6 = container.getComponent(n2 + 2);
                        component6.setBounds(array[5], top + (this.rowHeights[k] - component6.getPreferredSize().height) / 2, this.columnWidths[5], component6.getPreferredSize().height);
                        n2 += 3;
                        break;
                    }
                    case 4: {
                        final Component component7 = container.getComponent(n2);
                        component7.setBounds(array[0], top + (this.rowHeights[k] - component7.getPreferredSize().height) / 2, this.columnWidths[0], component7.getPreferredSize().height);
                        final Component component8 = container.getComponent(n2 + 1);
                        component8.setBounds(array[1], top + (this.rowHeights[k] - component8.getPreferredSize().height) / 2, n3, component8.getPreferredSize().height);
                        final Component component9 = container.getComponent(n2 + 2);
                        component9.setBounds(array[3], top + (this.rowHeights[k] - component9.getPreferredSize().height) / 2, this.columnWidths[3], component9.getPreferredSize().height);
                        final Component component10 = container.getComponent(n2 + 3);
                        component10.setBounds(array[4], top + (this.rowHeights[k] - component10.getPreferredSize().height) / 2, n4, component10.getPreferredSize().height);
                        n2 += 4;
                        break;
                    }
                    case 6: {
                        final Component component11 = container.getComponent(n2);
                        component11.setBounds(array[0], top + (this.rowHeights[k] - component11.getPreferredSize().height) / 2, this.columnWidths[0], component11.getPreferredSize().height);
                        final Component component12 = container.getComponent(n2 + 1);
                        component12.setBounds(array[1], top + (this.rowHeights[k] - component12.getPreferredSize().height) / 2, this.columnWidths[1], component12.getPreferredSize().height);
                        final Component component13 = container.getComponent(n2 + 2);
                        component13.setBounds(array[2], top + (this.rowHeights[k] - component13.getPreferredSize().height) / 2, this.columnWidths[2], component13.getPreferredSize().height);
                        final Component component14 = container.getComponent(n2 + 3);
                        component14.setBounds(array[3], top + (this.rowHeights[k] - component14.getPreferredSize().height) / 2, this.columnWidths[3], component14.getPreferredSize().height);
                        final Component component15 = container.getComponent(n2 + 4);
                        component15.setBounds(array[4], top + (this.rowHeights[k] - component15.getPreferredSize().height) / 2, n4, component15.getPreferredSize().height);
                        n2 += 5;
                        break;
                    }
                    case 5: {
                        final Component component16 = container.getComponent(n2);
                        component16.setBounds(array[0], top + (this.rowHeights[k] - component16.getPreferredSize().height) / 2, this.columnWidths[0], component16.getPreferredSize().height);
                        final Component component17 = container.getComponent(n2 + 1);
                        component17.setBounds(array[1], top + (this.rowHeights[k] - component17.getPreferredSize().height) / 2, n3, component17.getPreferredSize().height);
                        final Component component18 = container.getComponent(n2 + 2);
                        component18.setBounds(array[3], top + (this.rowHeights[k] - component18.getPreferredSize().height) / 2, this.columnWidths[3], component18.getPreferredSize().height);
                        final Component component19 = container.getComponent(n2 + 3);
                        component19.setBounds(array[4], top + (this.rowHeights[k] - component19.getPreferredSize().height) / 2, this.columnWidths[4], component19.getPreferredSize().height);
                        final Component component20 = container.getComponent(n2 + 4);
                        component20.setBounds(array[5], top + (this.rowHeights[k] - component20.getPreferredSize().height) / 2, this.columnWidths[5], component20.getPreferredSize().height);
                        n2 += 5;
                        break;
                    }
                    case 7: {
                        final Component component21 = container.getComponent(n2);
                        component21.setBounds(array[0], top + (this.rowHeights[k] - component21.getPreferredSize().height) / 2, this.columnWidths[0], component21.getPreferredSize().height);
                        final Component component22 = container.getComponent(n2 + 1);
                        component22.setBounds(array[1], top + (this.rowHeights[k] - component22.getPreferredSize().height) / 2, this.columnWidths[1], component22.getPreferredSize().height);
                        final Component component23 = container.getComponent(n2 + 2);
                        component23.setBounds(array[2], top + (this.rowHeights[k] - component23.getPreferredSize().height) / 2, this.columnWidths[2], component23.getPreferredSize().height);
                        final Component component24 = container.getComponent(n2 + 3);
                        component24.setBounds(array[3], top + (this.rowHeights[k] - component24.getPreferredSize().height) / 2, this.columnWidths[3], component24.getPreferredSize().height);
                        final Component component25 = container.getComponent(n2 + 4);
                        component25.setBounds(array[4], top + (this.rowHeights[k] - component25.getPreferredSize().height) / 2, this.columnWidths[4], component25.getPreferredSize().height);
                        final Component component26 = container.getComponent(n2 + 5);
                        component26.setBounds(array[5], top + (this.rowHeights[k] - component26.getPreferredSize().height) / 2, this.columnWidths[5], component26.getPreferredSize().height);
                        n2 += 6;
                        break;
                    }
                }
                top = top + this.rowHeights[k] + this.rowGap;
            }
        }
    }
    
    protected void updateC(final int n, final Dimension dimension) {
        this.rowHeights[n] = dimension.height;
        this.totalHeight += this.rowHeights[n];
        this.columns0to5Width = Math.max(this.columns0to5Width, dimension.width);
    }
    
    protected void updateLC(final int n, final Dimension dimension, final Dimension dimension2) {
        this.rowHeights[n] = Math.max(dimension.height, dimension2.height);
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1to5Width = Math.max(this.columns1to5Width, dimension2.width);
    }
    
    protected void updateLCB(final int n, final Dimension dimension, final Dimension dimension2, final Dimension dimension3) {
        this.rowHeights[n] = Math.max(dimension.height, Math.max(dimension2.height, dimension3.height));
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1to4Width = Math.max(this.columns1to4Width, dimension2.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension3.width);
    }
    
    protected void updateLCLC(final int n, final Dimension dimension, final Dimension dimension2, final Dimension dimension3, final Dimension dimension4) {
        this.rowHeights[n] = Math.max(Math.max(dimension.height, dimension2.height), Math.max(dimension3.height, dimension4.height));
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1and2Width = Math.max(this.columns1and2Width, dimension2.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension3.width);
        this.columns4and5Width = Math.max(this.columns4and5Width, dimension4.width);
    }
    
    protected void updateLCBLC(final int n, final Dimension dimension, final Dimension dimension2, final Dimension dimension3, final Dimension dimension4, final Dimension dimension5) {
        this.rowHeights[n] = Math.max(dimension.height, Math.max(Math.max(dimension2.height, dimension3.height), Math.max(dimension4.height, dimension5.height)));
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columnWidths[1] = Math.max(this.columnWidths[1], dimension2.width);
        this.columnWidths[2] = Math.max(this.columnWidths[2], dimension3.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension4.width);
        this.columns4and5Width = Math.max(this.columns4and5Width, dimension5.width);
    }
    
    protected void updateLCLCB(final int n, final Dimension dimension, final Dimension dimension2, final Dimension dimension3, final Dimension dimension4, final Dimension dimension5) {
        this.rowHeights[n] = Math.max(dimension.height, Math.max(Math.max(dimension2.height, dimension3.height), Math.max(dimension4.height, dimension5.height)));
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columns1and2Width = Math.max(this.columns1and2Width, dimension2.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension3.width);
        this.columnWidths[4] = Math.max(this.columnWidths[4], dimension4.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension5.width);
    }
    
    protected void updateLCBLCB(final int n, final Dimension dimension, final Dimension dimension2, final Dimension dimension3, final Dimension dimension4, final Dimension dimension5, final Dimension dimension6) {
        this.rowHeights[n] = Math.max(Math.max(dimension.height, dimension2.height), Math.max(Math.max(dimension3.height, dimension4.height), Math.max(dimension5.height, dimension6.height)));
        this.totalHeight += this.rowHeights[n];
        this.columnWidths[0] = Math.max(this.columnWidths[0], dimension.width);
        this.columnWidths[1] = Math.max(this.columnWidths[1], dimension2.width);
        this.columnWidths[2] = Math.max(this.columnWidths[2], dimension3.width);
        this.columnWidths[3] = Math.max(this.columnWidths[3], dimension4.width);
        this.columnWidths[4] = Math.max(this.columnWidths[4], dimension5.width);
        this.columnWidths[5] = Math.max(this.columnWidths[5], dimension6.width);
    }
    
    public void complete() {
        this.columnWidths[1] = Math.max(this.columnWidths[1], this.columns1and2Width - this.columnGaps[1] - this.columnWidths[2]);
        this.columnWidths[4] = Math.max(this.columnWidths[4], Math.max(this.columns4and5Width - this.columnGaps[4] - this.columnWidths[5], Math.max(this.columns1to4Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3], this.columns1to5Width - this.columnGaps[1] - this.columnGaps[2] - this.columnGaps[3] - this.columnWidths[1] - this.columnWidths[2] - this.columnWidths[3] - this.columnGaps[4])));
        int n = this.columnWidths[0] + this.columnGaps[0] + this.columnWidths[1] + this.columnGaps[1] + this.columnWidths[2];
        int n2 = this.columnWidths[3] + this.columnGaps[3] + this.columnWidths[4] + this.columnGaps[4] + this.columnWidths[5];
        if (this.splitLayout()) {
            if (n > n2) {
                final int n3 = n - n2;
                this.columnWidths[4] += n3;
                n2 += n3;
            }
            else {
                final int n4 = n2 - n;
                this.columnWidths[1] += n4;
                n += n4;
            }
        }
        this.totalWidth = n + this.columnGaps[2] + n2;
        if (this.columns0to5Width > this.totalWidth) {
            final int n5 = this.columns0to5Width - this.totalWidth;
            if (this.splitLayout()) {
                final int n6 = n5 / 2;
                this.columnWidths[1] += n6;
                this.columnWidths[4] = this.columnWidths[4] + n5 - n6;
                this.totalWidth += n5;
            }
            else {
                this.columnWidths[1] += n5;
                this.totalWidth += n5;
            }
        }
    }
    
    private boolean splitLayout() {
        for (int i = 0; i < this.rowFormats.length; ++i) {
            if (this.rowFormats[i] > 3) {
                return true;
            }
        }
        return false;
    }
    
    public void addLayoutComponent(final Component component) {
    }
    
    public void removeLayoutComponent(final Component component) {
    }
    
    public void addLayoutComponent(final String s, final Component component) {
    }
    
    public void removeLayoutComponent(final String s, final Component component) {
    }
}
