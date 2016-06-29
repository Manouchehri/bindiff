/*
 * Decompiled with CFR 0_115.
 */
package y.h.a;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import y.c.i;
import y.c.x;
import y.h.O;
import y.h.a.a;
import y.h.a.h;
import y.h.a.q;
import y.h.a.r;
import y.h.a.v;
import y.h.bu;
import y.h.eR;
import y.h.fj;
import y.h.gn;
import y.h.gt;
import y.h.hk;

public class p
extends gn
implements a,
h,
gt {
    public static final Icon defaultClosedGroupIcon;
    public static final Icon defaultOpenGroupIcon;
    private boolean ue;
    private Icon bf;
    private Icon we;
    private boolean ze = false;
    private double af = 100.0;
    private double pe = 80.0;
    private boolean re = true;
    private boolean df;
    private double gf = 15.0;
    private double cf = 15.0;
    private double ef = 15.0;
    private double te = 15.0;
    private double ff = 0.0;
    private double hf = 0.0;
    private double xe = 0.0;
    private double qe = 0.0;
    private eR ve;
    private boolean se = false;
    private boolean ye = true;
    static Class class$y$view$hierarchy$AutoBoundsFeature;

    public p() {
        this.lb();
    }

    public p(fj fj2) {
        super(fj2);
        if (fj2 instanceof h) {
            this.b((h)((Object)fj2));
            if (v.a == 0) return;
        }
        this.bf = defaultClosedGroupIcon;
        this.we = defaultOpenGroupIcon;
    }

    /*
     * Unable to fully structure code
     */
    private void b(h var1_1) {
        if (!(var1_1 instanceof p)) ** GOTO lbl-1000
        var2_2 = (p)var1_1;
        this.af = var2_2.af;
        this.pe = var2_2.pe;
        this.bf = var2_2.bf;
        this.we = var2_2.we;
        this.ze = var2_2.ze;
        this.ve = var2_2.ve;
        this.gf = var2_2.gf;
        this.cf = var2_2.cf;
        this.ef = var2_2.ef;
        this.te = var2_2.te;
        this.ff = var2_2.ff;
        this.hf = var2_2.hf;
        this.xe = var2_2.xe;
        this.qe = var2_2.qe;
        this.se = var2_2.se;
        this.ye = var2_2.ye;
        this.df = var2_2.df;
        if (v.a != 0) lbl-1000: // 2 sources:
        {
            this.ze = var1_1.isGroupClosed();
            var2_2 = var1_1.getMinimalInsets();
            this.gf = var2_2.a;
            this.cf = var2_2.c;
            this.ef = var2_2.b;
            this.te = var2_2.d;
            var3_3 = var1_1.getBorderInsets();
            this.ff = var3_3.a;
            this.hf = var3_3.c;
            this.xe = var3_3.b;
            this.qe = var3_3.d;
        }
        if (this.ve == null) return;
        this.ve = (eR)this.ve.clone();
        this.ve.a(this);
    }

    private void lb() {
        eR eR2 = this.getLabel();
        eR2.setPosition(102);
        eR2.setFontSize(16);
        eR2.setBackgroundColor(Color.darkGray);
        eR2.setTextColor(Color.white);
        eR2.setAlignment(2);
        eR2.setAutoSizePolicy(1);
        eR2.a(0.0);
        this.bf = defaultClosedGroupIcon;
        this.we = defaultOpenGroupIcon;
    }

    @Override
    public fj createCopy(fj fj2) {
        p p2 = new p(fj2);
        if (fj2 instanceof h) return p2;
        p2.b(this);
        return p2;
    }

    @Override
    public y.d.r getAutoBoundsInsets() {
        int n2 = v.a;
        double d2 = 0.0;
        double d3 = 0.0;
        double d4 = 0.0;
        double d5 = 0.0;
        if (this.labelCount() <= 0) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
        eR eR2 = this.getLabel();
        if (!eR2.isVisible()) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
        switch (eR2.getPosition()) {
            case 102: 
            case 117: 
            case 118: {
                if (eR2.getAutoSizePolicy() == 2) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                if (eR2.getAutoSizePolicy() == 3) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                d2 = eR2.getHeight();
                if (n2 == 0) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
            }
            case 101: 
            case 119: 
            case 120: {
                if (eR2.getAutoSizePolicy() == 2) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                if (eR2.getAutoSizePolicy() == 3) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                d3 = eR2.getHeight();
                if (n2 == 0) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
            }
            case 115: {
                if (eR2.getAutoSizePolicy() == 1) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                if (eR2.getAutoSizePolicy() == 3) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                d4 = eR2.getWidth();
                if (n2 == 0) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
            }
            case 116: {
                if (eR2.getAutoSizePolicy() == 1) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                if (eR2.getAutoSizePolicy() == 3) return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
                d5 = eR2.getWidth();
            }
        }
        return new y.d.r(this.gf + d2, this.ef + d4, this.cf + d3, this.te + d5);
    }

    public void setAutoBoundsInsets(Insets insets) {
        this.setAutoBoundsInsets(new y.d.r(insets));
    }

    @Override
    public void setAutoBoundsInsets(y.d.r r2) {
        this.setBorderInsets(r2);
    }

    @Override
    public boolean isAutoBoundsEnabled() {
        if (!this.re) return false;
        if (this.ze) return false;
        return true;
    }

    @Override
    public void setAutoBoundsEnabled(boolean bl2) {
        if (!this.re && bl2) {
            if (!this.ze && !this.kb()) {
                Rectangle2D rectangle2D = this.calcMinimumInsetBounds();
                double d2 = rectangle2D.getX() + rectangle2D.getWidth();
                double d3 = rectangle2D.getY() + rectangle2D.getHeight();
                this.qe = this.x + this.width > d2 ? this.x + this.width - d2 : 0.0;
                this.ff = this.y < rectangle2D.getY() ? rectangle2D.getY() - this.y : 0.0;
                this.hf = this.y + this.height > d3 ? this.y + this.height - d3 : 0.0;
                this.xe = this.x < rectangle2D.getX() ? rectangle2D.getX() - this.x : 0.0;
            }
            this.re = bl2;
            this.recalculateBounds();
            if (v.a == 0) return;
        }
        this.re = bl2;
    }

    @Override
    public Rectangle2D getMinimalAutoBounds() {
        return this.calcMinimumInsetBounds();
    }

    public void updateAutoSizeBounds() {
        this.recalculateBounds();
    }

    public void setMinimalInsets(Insets insets) {
        this.setMinimalInsets(new y.d.r(insets));
    }

    public void setMinimalInsets(y.d.r r2) {
        this.cf = r2.c;
        this.gf = r2.a;
        this.ef = r2.b;
        this.te = r2.d;
        this.recalculateBounds();
    }

    @Override
    public y.d.r getMinimalInsets() {
        return new y.d.r(this.gf, this.ef, this.cf, this.te);
    }

    public void setBorderInsets(Insets insets) {
        this.setBorderInsets(new y.d.r(insets));
    }

    public void setBorderInsets(y.d.r r2) {
        this.ff = r2.a;
        this.hf = r2.c;
        this.qe = r2.d;
        this.xe = r2.b;
        this.recalculateBounds();
    }

    @Override
    public y.d.r getBorderInsets() {
        return new y.d.r(this.ff, this.xe, this.hf, this.qe);
    }

    public Icon getClosedGroupIcon() {
        return this.bf;
    }

    public void setClosedGroupIcon(Icon icon) {
        this.bf = icon;
        if (!this.ze) return;
        this.getStateLabel().setIcon(this.bf);
    }

    public Icon getOpenGroupIcon() {
        return this.we;
    }

    public void setOpenGroupIcon(Icon icon) {
        this.we = icon;
        if (this.ze) return;
        this.getStateLabel().setIcon(this.we);
    }

    public double getClosedWidth() {
        return this.af;
    }

    public void setClosedWidth(double d2) {
        this.af = d2;
    }

    public double getClosedHeight() {
        return this.pe;
    }

    public void setClosedHeight(double d2) {
        this.pe = d2;
    }

    @Override
    public void setGroupClosed(boolean bl2) {
        this.getStateLabel().setIcon(bl2 ? this.bf : this.we);
        if (this.ze == bl2) return;
        this.ze = bl2;
        if (bl2) {
            gt gt2 = this.getSizeConstraintProvider();
            if (gt2 != null) {
                double d2 = gt2.getMinimumSize().a();
                double d3 = gt2.getMinimumSize().b();
                if (this.af < d2) {
                    this.af = d2;
                }
                if (this.pe < d3) {
                    this.pe = d3;
                }
            }
            super.setFrame(this.x, this.y, this.af, this.pe);
            if (v.a == 0) return;
        }
        this.af = this.width;
        this.pe = this.height;
        this.setBoundsDirty();
        this.recalculateBounds();
    }

    @Override
    public boolean isGroupClosed() {
        return this.ze;
    }

    public void setInnerGraphDisplayEnabled(boolean bl2) {
        this.se = bl2;
    }

    public boolean isInnerGraphDisplayEnabled() {
        return this.se;
    }

    @Override
    public void paintSloppy(Graphics2D graphics2D) {
        if (this.ue) {
            this.recalculateBounds();
        }
        super.paintSloppy(graphics2D);
        this.paintGroupState(graphics2D, true);
    }

    @Override
    protected void paintNode(Graphics2D graphics2D) {
        v v2;
        int n2 = v.a;
        if (this.isBoundsDirty()) {
            this.recalculateBounds();
        }
        if ((v2 = this.getHierarchyManager()) != null) {
            block6 : {
                Color color = this.getFillColor();
                if (color != null && this.ye) {
                    Color color2 = color;
                    int n3 = v2.o(this.getNode());
                    if (n3 > 0) {
                        color2 = new Color(Math.max(color.getRed() - 20 * n3, 0), Math.max(color.getGreen() - 20 * n3, 0), Math.max(color.getBlue() - 20 * n3, 0), color.getAlpha());
                    }
                    this.setFillColor(color2);
                    this.paintShapeNode(graphics2D);
                    this.setFillColor(color);
                    if (n2 == 0) break block6;
                }
                this.paintShapeNode(graphics2D);
            }
            if (this.isGroupClosed() && this.isInnerGraphDisplayEnabled()) {
                this.paintInnerGraph(graphics2D);
            }
            this.paintGroupState(graphics2D, false);
            if (n2 == 0) return;
        }
        this.paintShapeNode(graphics2D);
    }

    protected void paintGroupState(Graphics2D graphics2D, boolean bl2) {
        if (!p.f(graphics2D, bl2)) return;
        this.getStateLabel().paint(graphics2D);
    }

    private static boolean f(Graphics2D graphics2D, boolean bl2) {
        Object object = graphics2D.getRenderingHint(hk.o);
        if (bl2) {
            return hk.q.equals(object);
        }
        if (hk.r.equals(object)) return false;
        return true;
    }

    protected void paintShapeNode(Graphics2D graphics2D) {
        super.paintNode(graphics2D);
    }

    public void setGroupDepthFillColorEnabled(boolean bl2) {
        this.ye = bl2;
    }

    public boolean isGroupDepthFillColorEnabled() {
        return this.ye;
    }

    public void setStateLabel(eR eR2) {
        this.ve = eR2;
        eR2.a(this);
    }

    public eR getStateLabel() {
        if (this.ve != null) return this.ve;
        this.ve = new eR();
        this.ve.setPosition(117);
        this.ve.a(1.0);
        this.ve.a(this);
        return this.ve;
    }

    @Override
    public Rectangle2D.Double getBoundingBox() {
        if (!this.ue) return super.getBoundingBox();
        this.recalculateBounds();
        return super.getBoundingBox();
    }

    private boolean kb() {
        y.c.q q2 = this.getNode();
        if (q2 == null) {
            return true;
        }
        v v2 = this.getHierarchyManager();
        if (v2 == null) return true;
        if (!v2.p(q2).f()) return true;
        return false;
    }

    protected void recalculateBounds() {
        if (!this.re) {
            return;
        }
        if (!this.df) {
            if (this.ze) return;
            if (this.kb()) {
                return;
            }
        }
        Rectangle2D rectangle2D = this.calcMinimumBounds();
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setLocation(rectangle2D.getX(), rectangle2D.getY());
        this.ue = false;
        gt gt2 = this.getSizeConstraintProvider();
        if (gt2 != null) {
            rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), Math.max(rectangle2D.getWidth(), gt2.getMinimumSize().a()), Math.max(rectangle2D.getHeight(), gt2.getMinimumSize().b()));
        }
        if (this.df) {
            Dimension2D dimension2D = this.calculateMinimalLabelSize();
            rectangle2D.setFrame(rectangle2D.getX(), rectangle2D.getY(), Math.max(rectangle2D.getWidth(), dimension2D.getWidth()), Math.max(rectangle2D.getHeight(), dimension2D.getHeight()));
        }
        this.setSize(rectangle2D.getWidth(), rectangle2D.getHeight());
        this.setLocation(rectangle2D.getX(), rectangle2D.getY());
        this.ue = false;
    }

    protected Rectangle2D calcMinimumInsetBounds() {
        y.d.r r2 = this.getAutoBoundsInsets();
        if (this.ze) return new Rectangle2D.Double(this.x, this.y, r2.b + r2.d, r2.a + r2.c);
        if (this.kb()) return new Rectangle2D.Double(this.x, this.y, r2.b + r2.d, r2.a + r2.c);
        Rectangle2D rectangle2D = this.calcMinimumGroupBounds();
        rectangle2D.setFrame(rectangle2D.getX() - r2.b, rectangle2D.getY() - r2.a, rectangle2D.getWidth() + r2.b + r2.d, rectangle2D.getHeight() + r2.a + r2.c);
        return rectangle2D;
    }

    protected Rectangle2D calcMinimumBounds() {
        if (this.ze) return new Rectangle2D.Double(this.x, this.y, this.width, this.height);
        if (this.kb()) return new Rectangle2D.Double(this.x, this.y, this.width, this.height);
        Rectangle2D rectangle2D = this.calcMinimumInsetBounds();
        rectangle2D.setFrame(rectangle2D.getX() - this.xe, rectangle2D.getY() - this.ff, rectangle2D.getWidth() + this.xe + this.qe, rectangle2D.getHeight() + this.ff + this.hf);
        return rectangle2D;
    }

    protected Rectangle2D calcMinimumGroupBounds() {
        int n2 = v.a;
        Rectangle2D.Double double_ = new Rectangle2D.Double(-1.0, -1.0, -1.0, -1.0);
        v v2 = this.getHierarchyManager();
        if (v2 == null) return double_;
        y.c.q q2 = this.getNode();
        bu bu2 = (bu)q2.e();
        if (!v2.k(q2)) return double_;
        x x2 = v2.p(q2);
        do {
            if (!x2.f()) return double_;
            bu2.t(x2.e()).calcUnionRect(double_);
            x2.g();
        } while (n2 == 0);
        return double_;
    }

    protected v getHierarchyManager() {
        y.c.q q2 = this.getNode();
        if (q2 != null) return v.a(q2.e());
        return null;
    }

    protected boolean isBoundsDirty() {
        return this.ue;
    }

    protected void setBoundsDirty() {
        this.ue = true;
    }

    /*
     * Unable to fully structure code
     */
    protected void paintInnerGraph(Graphics2D var1_1) {
        var25_2 = v.a;
        var2_3 = this.getHierarchyManager();
        if (var2_3 == null) {
            return;
        }
        var3_4 = this.getNode();
        if (var3_4 == null) return;
        if (!var2_3.j(var3_4)) {
            return;
        }
        var4_5 = (bu)var2_3.m(var3_4);
        var5_6 = this.getHeight() - this.gf - this.cf;
        var7_7 = this.getWidth() - this.ef - this.te;
        var9_8 = this.getX() + this.ef + 0.5 * var7_7;
        var11_9 = this.getY() + this.gf + 0.5 * var5_6;
        if (this.labelCount() > 0 && (var13_10 = this.getLabel()).isVisible()) {
            block0 : switch (var13_10.getModel()) {
                case 1: {
                    switch (var13_10.getPosition()) {
                        case 102: 
                        case 117: 
                        case 118: {
                            var5_6 -= var13_10.getHeight();
                            var11_9 += var13_10.getHeight() / 2.0;
                            if (var25_2 == 0) break block0;
                        }
                        case 101: 
                        case 119: 
                        case 120: {
                            var5_6 -= var13_10.getHeight();
                            var11_9 -= var13_10.getHeight() / 2.0;
                            if (var25_2 == 0) break block0;
                        }
                        case 115: {
                            var7_7 -= var13_10.getWidth();
                            var9_8 += var13_10.getWidth() / 2.0;
                            if (var25_2 == 0) break block0;
                        }
                        case 116: {
                            var7_7 -= var13_10.getWidth();
                            var9_8 -= var13_10.getWidth() / 2.0;
                        }
                    }
                }
            }
        }
        if (var7_7 <= 5.0) return;
        if (var5_6 <= 5.0) {
            return;
        }
        var13_11 = 1.0;
        var15_12 = 1.0;
        var17_13 = 1.0;
        var19_14 = var1_1.getTransform();
        var1_1.translate(var9_8, var11_9);
        var20_15 = var4_5.a();
        var13_11 = var7_7 / var20_15.getWidth();
        var15_12 = var5_6 / var20_15.getHeight();
        var17_13 = Math.min(var13_11, var15_12);
        var1_1.scale(var17_13, var17_13);
        var1_1.translate(- var20_15.getCenterX(), - var20_15.getCenterY());
        var21_16 = var17_13 * var19_14.getScaleX();
        var23_17 = (Double)var1_1.getRenderingHint(hk.y);
        var24_18 = new O();
        if (var23_17 != null && var21_16 <= var23_17) ** GOTO lbl-1000
        var24_18.paint(var1_1, var4_5);
        if (var25_2 != 0) lbl-1000: // 2 sources:
        {
            if (var23_17 == null || 4.0 * var21_16 > var23_17) {
                var24_18.paintSloppy(var1_1, var4_5);
            }
        }
        var1_1.setTransform(var19_14);
    }

    @Override
    public double getY() {
        if (!this.ue) return super.getY();
        this.recalculateBounds();
        return super.getY();
    }

    @Override
    public double getCenterX() {
        if (!this.ue) return super.getCenterX();
        this.recalculateBounds();
        return super.getCenterX();
    }

    @Override
    public boolean contains(double d2, double d3) {
        if (!this.ue) return super.contains(d2, d3);
        this.recalculateBounds();
        return super.contains(d2, d3);
    }

    @Override
    public double getHeight() {
        if (!this.ue) return super.getHeight();
        this.recalculateBounds();
        return super.getHeight();
    }

    @Override
    public double getX() {
        if (!this.ue) return super.getX();
        this.recalculateBounds();
        return super.getX();
    }

    @Override
    public boolean findIntersection(double d2, double d3, double d4, double d5, Point2D point2D) {
        if (!this.ue) return super.findIntersection(d2, d3, d4, d5, point2D);
        this.recalculateBounds();
        return super.findIntersection(d2, d3, d4, d5, point2D);
    }

    @Override
    public double getWidth() {
        if (!this.ue) return super.getWidth();
        this.recalculateBounds();
        return super.getWidth();
    }

    @Override
    public double getCenterY() {
        if (!this.ue) return super.getCenterY();
        this.recalculateBounds();
        return super.getCenterY();
    }

    @Override
    public y.d.q getMinimumSize() {
        y.d.q q2;
        int n2 = v.a;
        y.d.r r2 = this.getAutoBoundsInsets();
        double d2 = r2.b + r2.d;
        double d3 = r2.a + r2.c;
        if (this.isConsiderNodeLabelSize()) {
            Dimension2D dimension2D = this.calculateMinimalLabelSize();
            q2 = new y.d.q(Math.max(d2, dimension2D.getWidth()), Math.max(d3, dimension2D.getHeight()));
            if (n2 == 0) return q2;
        }
        if (!this.ze) return new y.d.q(d2, d3);
        q2 = new y.d.q(1.0, 1.0);
        if (n2 == 0) return q2;
        return new y.d.q(d2, d3);
    }

    @Override
    public y.d.q getMaximumSize() {
        return new y.d.q(2.147483647E9, 2.147483647E9);
    }

    /*
     * Unable to fully structure code
     */
    protected Dimension2D calculateMinimalLabelSize() {
        var13_1 = v.a;
        var1_2 = new Dimension();
        if (this.labelCount() <= 0) return var1_2;
        var2_3 = this.getLabel();
        var3_4 = var2_3.getAutoSizePolicy();
        if (var3_4 != 4) ** GOTO lbl10
        var4_5 = var2_3.getContentWidth();
        var6_6 = var2_3.getContentHeight();
        if (var13_1 == 0) ** GOTO lbl22
lbl10: // 2 sources:
        if (var3_4 == 0) ** GOTO lbl-1000
        var8_7 = var2_3.getContentWidth();
        var10_8 = var2_3.getContentHeight();
        var2_3.internalSetAutoSizePolicy(0);
        var2_3.calculateSize();
        var4_5 = var2_3.getContentWidth();
        var6_6 = var2_3.getContentHeight();
        var2_3.internalSetAutoSizePolicy(var3_4);
        var2_3.setContentSize(var8_7, var10_8);
        if (var13_1 != 0) lbl-1000: // 2 sources:
        {
            var4_5 = var2_3.getContentWidth();
            var6_6 = var2_3.getContentHeight();
        }
lbl22: // 4 sources:
        var8_7 = 0.0;
        var10_8 = 0.0;
        var12_9 = this.getStateLabel();
        if (var12_9 != null) {
            var8_7 = var12_9.getWidth();
            var10_8 = var12_9.getHeight();
        }
        var1_2.setSize(var4_5 + var8_7, Math.max(var6_6, var10_8));
        return var1_2;
    }

    @Override
    protected void labelBoundsChanged(eR eR2) {
        if (!this.df) return;
        if (this.labelCount() <= 0 || eR2 != this.getLabel()) {
            if (eR2 != this.getStateLabel()) return;
        }
        this.setBoundsDirty();
    }

    @Override
    public boolean intersects(double d2, double d3, double d4, double d5) {
        if (!this.isGroupClosed()) {
            this.ue = true;
        }
        if (!this.ue) return super.intersects(d2, d3, d4, d5);
        this.recalculateBounds();
        return super.intersects(d2, d3, d4, d5);
    }

    @Override
    public void calcUnionRect(Rectangle2D rectangle2D) {
        if (!this.isGroupClosed()) {
            this.ue = true;
        }
        if (this.ue) {
            this.recalculateBounds();
        }
        super.calcUnionRect(rectangle2D);
    }

    @Override
    public boolean findBBIntersection(double d2, double d3, double d4, double d5, Point2D point2D) {
        if (!this.ue) return super.findBBIntersection(d2, d3, d4, d5, point2D);
        this.recalculateBounds();
        return super.findBBIntersection(d2, d3, d4, d5, point2D);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void write(ObjectOutputStream var1_1) {
        var2_2 = v.a;
        var1_1.writeByte(4);
        super.write(var1_1);
        if (!this.isGroupClosed()) ** GOTO lbl-1000
        var1_1.writeDouble(this.width);
        var1_1.writeDouble(this.height);
        if (var2_2 != 0) lbl-1000: // 2 sources:
        {
            var1_1.writeDouble(this.af);
            var1_1.writeDouble(this.pe);
        }
        if (this.we != p.defaultOpenGroupIcon) ** GOTO lbl-1000
        var1_1.writeBoolean(true);
        if (var2_2 != 0) lbl-1000: // 2 sources:
        {
            var1_1.writeBoolean(false);
            var1_1.writeObject(this.we);
        }
        if (this.bf != p.defaultClosedGroupIcon) ** GOTO lbl-1000
        var1_1.writeBoolean(true);
        if (var2_2 != 0) lbl-1000: // 2 sources:
        {
            var1_1.writeBoolean(false);
            var1_1.writeObject(this.bf);
        }
        var1_1.writeBoolean(this.ze);
        var1_1.writeBoolean(this.se);
        var1_1.writeDouble(this.gf);
        var1_1.writeDouble(this.cf);
        var1_1.writeDouble(this.ef);
        var1_1.writeDouble(this.te);
        var1_1.writeDouble(this.ff);
        var1_1.writeDouble(this.hf);
        var1_1.writeDouble(this.xe);
        var1_1.writeDouble(this.qe);
        var1_1.writeBoolean(this.ye);
        var1_1.writeBoolean(this.df);
    }

    @Override
    public void read(ObjectInputStream objectInputStream) {
        int n2 = v.a;
        byte by2 = objectInputStream.readByte();
        super.read(objectInputStream);
        switch (by2) {
            boolean bl2;
            case 0: {
                this.af = objectInputStream.readDouble();
                this.pe = objectInputStream.readDouble();
                this.we = (Icon)objectInputStream.readObject();
                this.bf = (Icon)objectInputStream.readObject();
                this.ze = objectInputStream.readBoolean();
                this.se = objectInputStream.readBoolean();
                if (n2 == 0) return;
            }
            case 1: {
                this.af = objectInputStream.readDouble();
                this.pe = objectInputStream.readDouble();
                this.we = (Icon)objectInputStream.readObject();
                this.bf = (Icon)objectInputStream.readObject();
                this.ze = objectInputStream.readBoolean();
                this.se = objectInputStream.readBoolean();
                this.gf = objectInputStream.readDouble();
                this.cf = objectInputStream.readDouble();
                this.ef = objectInputStream.readDouble();
                this.te = objectInputStream.readDouble();
                this.ff = objectInputStream.readDouble();
                this.hf = objectInputStream.readDouble();
                this.xe = objectInputStream.readDouble();
                this.qe = objectInputStream.readDouble();
                if (n2 == 0) return;
            }
            case 2: {
                this.af = objectInputStream.readDouble();
                this.pe = objectInputStream.readDouble();
                this.we = (Icon)objectInputStream.readObject();
                this.bf = (Icon)objectInputStream.readObject();
                bl2 = objectInputStream.readBoolean();
                this.se = objectInputStream.readBoolean();
                this.gf = objectInputStream.readDouble();
                this.cf = objectInputStream.readDouble();
                this.ef = objectInputStream.readDouble();
                this.te = objectInputStream.readDouble();
                this.ff = objectInputStream.readDouble();
                this.hf = objectInputStream.readDouble();
                this.xe = objectInputStream.readDouble();
                this.qe = objectInputStream.readDouble();
                this.ye = objectInputStream.readBoolean();
                this.setGroupClosed(bl2);
                if (n2 == 0) return;
            }
            case 3: {
                this.af = objectInputStream.readDouble();
                this.pe = objectInputStream.readDouble();
                this.we = (Icon)objectInputStream.readObject();
                this.bf = (Icon)objectInputStream.readObject();
                bl2 = objectInputStream.readBoolean();
                this.se = objectInputStream.readBoolean();
                this.gf = objectInputStream.readDouble();
                this.cf = objectInputStream.readDouble();
                this.ef = objectInputStream.readDouble();
                this.te = objectInputStream.readDouble();
                this.ff = objectInputStream.readDouble();
                this.hf = objectInputStream.readDouble();
                this.xe = objectInputStream.readDouble();
                this.qe = objectInputStream.readDouble();
                this.ye = objectInputStream.readBoolean();
                this.df = objectInputStream.readBoolean();
                this.setGroupClosed(bl2);
                if (n2 == 0) return;
            }
            case 4: {
                block12 : {
                    block11 : {
                        this.af = objectInputStream.readDouble();
                        this.pe = objectInputStream.readDouble();
                        if (objectInputStream.readBoolean()) {
                            this.we = defaultOpenGroupIcon;
                            if (n2 == 0) break block11;
                        }
                        this.we = (Icon)objectInputStream.readObject();
                    }
                    if (objectInputStream.readBoolean()) {
                        this.bf = defaultClosedGroupIcon;
                        if (n2 == 0) break block12;
                    }
                    this.bf = (Icon)objectInputStream.readObject();
                }
                bl2 = objectInputStream.readBoolean();
                this.se = objectInputStream.readBoolean();
                this.gf = objectInputStream.readDouble();
                this.cf = objectInputStream.readDouble();
                this.ef = objectInputStream.readDouble();
                this.te = objectInputStream.readDouble();
                this.ff = objectInputStream.readDouble();
                this.hf = objectInputStream.readDouble();
                this.xe = objectInputStream.readDouble();
                this.qe = objectInputStream.readDouble();
                this.ye = objectInputStream.readBoolean();
                this.df = objectInputStream.readBoolean();
                this.setGroupClosed(bl2);
                if (n2 == 0) return;
            }
        }
        throw new y.e.a(4, by2);
    }

    @Override
    public void setSize(double d2, double d3) {
        super.setSize(d2, d3);
        if (this.ve == null) return;
        this.ve.setOffsetDirty();
    }

    public boolean isConsiderNodeLabelSize() {
        return this.df;
    }

    public void setConsiderNodeLabelSize(boolean bl2) {
        this.df = bl2;
        this.setBoundsDirty();
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        Class class_ = class$y$view$hierarchy$AutoBoundsFeature == null ? (p.class$y$view$hierarchy$AutoBoundsFeature = p.class$("y.h.a.a")) : class$y$view$hierarchy$AutoBoundsFeature;
        Class class_2 = class_;
        Icon icon = null;
        Icon icon2 = null;
        try {
            icon = new ImageIcon(class_2.getResource("resource/default_closed_group_icon.gif"));
            icon2 = new ImageIcon(class_2.getResource("resource/default_open_group_icon.gif"));
        }
        catch (Exception var3_3) {
            // empty catch block
        }
        if (icon == null) {
            icon = new q();
        }
        if (icon2 == null) {
            icon2 = new r();
        }
        defaultClosedGroupIcon = icon;
        defaultOpenGroupIcon = icon2;
    }
}

