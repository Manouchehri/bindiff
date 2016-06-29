/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import y.h.bw;
import y.h.ch;
import y.h.fj;

class if
implements LayoutManager,
ScrollPaneConstants {
    protected bw a;
    protected JScrollBar b;
    protected JScrollBar c;
    protected JComponent d;
    Dimension e = new Dimension(-1, -1);
    private JPanel f;

    if() {
    }

    protected Component a(Component component, Component component2) {
        if (component == null) return component2;
        if (component == component2) return component2;
        component.getParent().remove(component);
        return component2;
    }

    @Override
    public void addLayoutComponent(String string, Component component) {
        boolean bl2 = fj.z;
        if (string.equals("CANVAS")) {
            this.a = (bw)this.a(this.a, component);
            if (!bl2) return;
        }
        if (string.equals("VERTICAL_SCROLLBAR")) {
            this.b = (JScrollBar)this.a(this.b, component);
            if (!bl2) return;
        }
        if (string.equals("HORIZONTAL_SCROLLBAR")) {
            this.c = (JScrollBar)this.a(this.c, component);
            if (!bl2) return;
        }
        if (string.equals("CORNER_COMPONENT")) {
            this.d = (JComponent)this.a(this.d, component);
            if (!bl2) return;
        }
        if (!"GLASS_PANE".equals(string)) return;
        this.f = (JPanel)component;
    }

    @Override
    public void removeLayoutComponent(Component component) {
        boolean bl2 = fj.z;
        if (component == this.a) {
            this.a = null;
            if (!bl2) return;
        }
        if (component == this.b) {
            this.b = null;
            if (!bl2) return;
        }
        if (component == this.c) {
            this.c = null;
            if (!bl2) return;
        }
        if (component == this.d) {
            this.d = null;
            if (!bl2) return;
        }
        if (component != this.f) return;
        this.f = null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Dimension preferredLayoutSize(Container var1_1) {
        var10_2 = fj.z;
        var2_3 = (ch)var1_1;
        var3_4 = var2_3.getVerticalScrollBarPolicy();
        var4_5 = var2_3.getHorizontalScrollBarPolicy();
        var5_6 = var2_3.getInsets();
        var6_7 = var5_6.left + var5_6.right;
        var7_8 = var5_6.top + var5_6.bottom;
        var8_9 = null;
        var9_10 = null;
        if (this.a != null) {
            var8_9 = var2_3.getWorldRect();
            var9_10 = this.a.getPreferredSize();
        }
        if (this.f == null) ** GOTO lbl18
        if (var9_10 == null) ** GOTO lbl-1000
        var9_10.setSize(Math.max(var9_10.getWidth(), this.f.getPreferredSize().getWidth()), Math.max(var9_10.getHeight(), this.f.getPreferredSize().getHeight()));
        if (var10_2) lbl-1000: // 2 sources:
        {
            var9_10 = this.f.getPreferredSize();
        }
lbl18: // 4 sources:
        if (var9_10 != null) {
            var6_7 += var9_10.width;
            var7_8 += var9_10.height;
        }
        if (this.b == null || var3_4 == 21) ** GOTO lbl27
        if (var3_4 != 22) ** GOTO lbl-1000
        var6_7 += this.b.getPreferredSize().width;
        if (var10_2) lbl-1000: // 2 sources:
        {
            if (var9_10 != null && var8_9 != null && (double)var8_9.height > (double)var9_10.height / var2_3.getZoom()) {
                var6_7 += this.b.getPreferredSize().width;
            }
        }
lbl27: // 6 sources:
        if (this.c == null) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        if (var4_5 == 31) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        if (var4_5 == 32) {
            if (var10_2 == false) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        }
        if (var9_10 == null) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        if (var8_9 == null) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        if ((double)var8_9.width <= (double)var9_10.width / var2_3.getZoom()) return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
        var7_8 += this.c.getPreferredSize().height;
        return new Dimension(var6_7, var7_8 += this.c.getPreferredSize().height);
    }

    @Override
    public Dimension minimumLayoutSize(Container container) {
        Dimension dimension;
        ch ch2 = (ch)container;
        int n2 = ch2.getVerticalScrollBarPolicy();
        int n3 = ch2.getHorizontalScrollBarPolicy();
        Insets insets = ch2.getInsets();
        int n4 = insets.left + insets.right;
        int n5 = insets.top + insets.bottom;
        if (this.a != null) {
            dimension = this.a.getMinimumSize();
            n4 += dimension.width;
            n5 += dimension.height;
        }
        if (this.b != null && n2 != 21) {
            dimension = this.b.getMinimumSize();
            n4 += dimension.width;
            n5 = Math.max(n5, dimension.height);
        }
        if (this.c != null && n3 != 21) {
            dimension = this.c.getMinimumSize();
            n4 = Math.max(n4, dimension.width);
            n5 += dimension.height;
        }
        if (this.f == null) return new Dimension(n4, n5);
        n4 = Math.max(n4, this.f.getMinimumSize().width);
        n5 = Math.max(n5, this.f.getMinimumSize().height);
        return new Dimension(n4, n5);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void layoutContainer(Container var1_1) {
        var21_2 = fj.z;
        var2_3 = (ch)var1_1;
        var3_4 = new Rectangle(var2_3.getSize());
        var4_5 = false;
        if (this.e.width != var3_4.width || this.e.height != var3_4.height) {
            var4_5 = true;
            this.e.setSize(var3_4.width, var3_4.height);
        }
        var5_6 = var2_3.getVerticalScrollBarPolicy();
        var6_7 = var2_3.getHorizontalScrollBarPolicy();
        var7_8 = var2_3.getInsets();
        var3_4.x = var7_8.left;
        var3_4.y = var7_8.top;
        var3_4.width -= var7_8.left + var7_8.right;
        var3_4.height -= var7_8.top + var7_8.bottom;
        if (var4_5 && var2_3.getFitContentOnResize()) {
            var8_9 = new Rectangle(var3_4);
            if (var6_7 == 32) {
                var8_9.height -= this.c.getPreferredSize().height;
            }
            if (var5_6 == 22) {
                var8_9.width -= this.b.getPreferredSize().width;
            }
            this.a.setBounds(var8_9);
            this.a.i();
        }
        var8_9 = var2_3.getWorldRect();
        var9_10 = var2_3.getSize();
        var10_11 = var2_3.getZoom();
        var12_12 = 1.0;
        var14_13 = new Rectangle(0, var3_4.y, 0, 0);
        var15_14 = var2_3.getViewPoint();
        if (var5_6 != 22) ** GOTO lbl32
        var16_15 = true;
        if (!var21_2) ** GOTO lbl36
lbl32: // 2 sources:
        if (var5_6 != 21) ** GOTO lbl-1000
        var16_15 = false;
        if (var21_2) lbl-1000: // 2 sources:
        {
            v0 = var16_15 = (double)var8_9.y + var12_12 < var15_14.getY() || (double)(var8_9.y + var8_9.height) - var12_12 > var15_14.getY() + (double)var9_10.height / var10_11;
        }
lbl36: // 4 sources:
        if (this.b != null && var16_15) {
            var17_16 = this.b.getPreferredSize().width;
            var3_4.width -= var17_16;
            var14_13.x = var3_4.x + var3_4.width;
            var14_13.width = var17_16;
        }
        var17_17 = new Rectangle(var3_4.x, 0, 0, 0);
        if (var6_7 != 32) ** GOTO lbl45
        var18_18 = true;
        if (!var21_2) ** GOTO lbl52
lbl45: // 2 sources:
        if (var6_7 != 31) ** GOTO lbl48
        var18_18 = false;
        if (!var21_2) ** GOTO lbl52
lbl48: // 2 sources:
        if (!var16_15) ** GOTO lbl-1000
        v1 = var18_18 = (double)var8_9.x + var12_12 < var15_14.getX() || (double)(var8_9.x + var8_9.width) - var12_12 > var15_14.getX() + (double)(var9_10.width - var14_13.width) / var10_11;
        if (var21_2) lbl-1000: // 2 sources:
        {
            v2 = var18_18 = (double)var8_9.x + var12_12 < var15_14.getX() || (double)(var8_9.x + var8_9.width) - var12_12 > var15_14.getX() + (double)var9_10.width / var10_11;
        }
lbl52: // 5 sources:
        if (this.c != null && var18_18) {
            var19_19 = this.c.getPreferredSize().height;
            var3_4.height -= var19_19;
            var17_17.y = var3_4.y + var3_4.height;
            var17_17.height = var19_19;
            if (this.b != null && !var16_15 && var5_6 != 21) {
                v3 = var16_15 = (double)var8_9.y + var12_12 < var15_14.getY() || (double)(var8_9.y + var8_9.height) - var12_12 > var15_14.getY() + (double)var3_4.height / var10_11;
                if (var16_15) {
                    var20_20 = this.b.getPreferredSize().width;
                    var3_4.width -= var20_20;
                    var14_13.x = var3_4.x + var3_4.width;
                    var14_13.width = var20_20;
                }
            }
        }
        var14_13.height = var3_4.height;
        var17_17.width = var3_4.width;
        if (this.a != null) {
            this.a.setBounds(var3_4);
        }
        if (this.d != null && this.b != null && var16_15 && this.c != null && var18_18) {
            this.d.setBounds(var3_4.width, var3_4.height, var14_13.width, var17_17.height);
        }
        if (this.f != null) {
            this.f.setBounds(var3_4);
        }
        var2_3.q();
        if (this.b == null) ** GOTO lbl79
        if (!var16_15) ** GOTO lbl-1000
        this.b.setBounds(var14_13);
        this.b.setVisible(true);
        if (var21_2) lbl-1000: // 2 sources:
        {
            this.b.setVisible(false);
        }
lbl79: // 4 sources:
        if (this.c == null) return;
        if (var18_18) {
            this.c.setBounds(var17_17);
            this.c.setVisible(true);
            if (var21_2 == false) return;
        }
        this.c.setVisible(false);
    }

    /*
     * Unable to fully structure code
     */
    public boolean a(Container var1_1) {
        var16_2 = fj.z;
        var2_3 = (ch)var1_1;
        var3_4 = var2_3.getVerticalScrollBarPolicy();
        var4_5 = var2_3.getHorizontalScrollBarPolicy();
        var5_6 = new Rectangle(var2_3.getSize());
        var6_7 = var2_3.getInsets();
        var5_6.x = var6_7.left;
        var5_6.y = var6_7.top;
        var5_6.width -= var6_7.left + var6_7.right;
        var5_6.height -= var6_7.top + var6_7.bottom;
        var7_8 = var2_3.getWorldRect();
        var8_9 = var2_3.getSize();
        var9_10 = var2_3.getZoom();
        var11_11 = new Rectangle(0, var5_6.y, 0, 0);
        if (var3_4 != 22) ** GOTO lbl18
        var12_12 = true;
        if (!var16_2) ** GOTO lbl22
lbl18: // 2 sources:
        if (var3_4 != 21) ** GOTO lbl-1000
        var12_12 = false;
        if (var16_2) lbl-1000: // 2 sources:
        {
            v0 = var12_12 = (double)var7_8.height > (double)var8_9.height / var9_10;
        }
lbl22: // 4 sources:
        if (this.b != null && var12_12) {
            var13_13 = this.b.getPreferredSize().width;
            var5_6.width -= var13_13;
            var11_11.x = var5_6.x + var5_6.width;
            var11_11.width = var13_13;
        }
        var13_14 = new Rectangle(var5_6.x, 0, 0, 0);
        var14_15 = false;
        if (var4_5 != 32) ** GOTO lbl32
        var14_15 = true;
        if (!var16_2) ** GOTO lbl39
lbl32: // 2 sources:
        if (var4_5 != 31) ** GOTO lbl35
        var14_15 = false;
        if (!var16_2) ** GOTO lbl39
lbl35: // 2 sources:
        if (!var12_12) ** GOTO lbl-1000
        v1 = var14_15 = (double)var7_8.width > (double)(var8_9.width - var11_11.width) / var9_10;
        if (var16_2) lbl-1000: // 2 sources:
        {
            v2 = var14_15 = (double)var7_8.width > (double)var8_9.width / var9_10;
        }
lbl39: // 5 sources:
        if (this.c != null && var14_15) {
            var15_16 = this.c.getPreferredSize().height;
            var5_6.height -= var15_16;
            var13_14.y = var5_6.y + var5_6.height;
            var13_14.height = var15_16;
            if (this.b != null && !var12_12 && var3_4 != 21) {
                var12_12 = (double)var7_8.height > (double)var5_6.height / var2_3.getZoom();
            }
        }
        if (var12_12 != this.b.isVisible()) return true;
        if (var14_15 != this.c.isVisible()) return true;
        return false;
    }
}

