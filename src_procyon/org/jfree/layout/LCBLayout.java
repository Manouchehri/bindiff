package org.jfree.layout;

import java.io.*;
import java.awt.*;

public class LCBLayout implements LayoutManager, Serializable
{
    private static final long serialVersionUID = -2531780832406163833L;
    private static final int COLUMNS = 3;
    private int[] colWidth;
    private int[] rowHeight;
    private int labelGap;
    private int buttonGap;
    private int vGap;
    
    public LCBLayout(final int n) {
        this.labelGap = 10;
        this.buttonGap = 6;
        this.vGap = 2;
        this.colWidth = new int[3];
        this.rowHeight = new int[n];
    }
    
    public Dimension preferredLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final int n = container.getComponentCount() / 3;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < n; ++j) {
                    final Dimension preferredSize = container.getComponent(j * 3 + i).getPreferredSize();
                    if (this.colWidth[i] < preferredSize.width) {
                        this.colWidth[i] = preferredSize.width;
                    }
                    if (this.rowHeight[j] < preferredSize.height) {
                        this.rowHeight[j] = preferredSize.height;
                    }
                }
            }
            int n2 = this.vGap * (n - 1);
            for (int k = 0; k < n; ++k) {
                n2 += this.rowHeight[k];
            }
            return new Dimension(insets.left + insets.right + (this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2]) + this.labelGap + this.buttonGap, insets.top + insets.bottom + n2 + this.vGap);
        }
    }
    
    public Dimension minimumLayoutSize(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final int n = container.getComponentCount() / 3;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < n; ++j) {
                    final Dimension minimumSize = container.getComponent(j * 3 + i).getMinimumSize();
                    if (this.colWidth[i] < minimumSize.width) {
                        this.colWidth[i] = minimumSize.width;
                    }
                    if (this.rowHeight[j] < minimumSize.height) {
                        this.rowHeight[j] = minimumSize.height;
                    }
                }
            }
            int n2 = this.vGap * (n - 1);
            for (int k = 0; k < n; ++k) {
                n2 += this.rowHeight[k];
            }
            return new Dimension(insets.left + insets.right + (this.colWidth[0] + this.labelGap + this.colWidth[1] + this.buttonGap + this.colWidth[2]) + this.labelGap + this.buttonGap, insets.top + insets.bottom + n2 + this.vGap);
        }
    }
    
    public void layoutContainer(final Container container) {
        synchronized (container.getTreeLock()) {
            final Insets insets = container.getInsets();
            final int componentCount = container.getComponentCount();
            final int n = componentCount / 3;
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < n; ++j) {
                    final Dimension preferredSize = container.getComponent(j * 3 + i).getPreferredSize();
                    if (this.colWidth[i] < preferredSize.width) {
                        this.colWidth[i] = preferredSize.width;
                    }
                    if (this.rowHeight[j] < preferredSize.height) {
                        this.rowHeight[j] = preferredSize.height;
                    }
                }
            }
            int n2 = this.vGap * (n - 1);
            for (int k = 0; k < n; ++k) {
                n2 += this.rowHeight[k];
            }
            this.colWidth[1] += container.getWidth() - insets.left - insets.right - this.labelGap - this.buttonGap - (this.colWidth[0] + this.colWidth[1] + this.colWidth[2]);
            int left = insets.left;
            for (int l = 0; l < 3; ++l) {
                int top = insets.top;
                for (int n3 = 0; n3 < n; ++n3) {
                    final int n4 = n3 * 3 + l;
                    if (n4 < componentCount) {
                        final int height = container.getComponent(n4).getPreferredSize().height;
                        container.getComponent(n4).setBounds(left, top + (this.rowHeight[n3] - height) / 2, this.colWidth[l], height);
                    }
                    top = top + this.rowHeight[n3] + this.vGap;
                }
                left += this.colWidth[l];
                if (l == 0) {
                    left += this.labelGap;
                }
                if (l == 1) {
                    left += this.buttonGap;
                }
            }
        }
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
