/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.Icon;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.q;
import y.d.e;
import y.d.t;
import y.e.a;
import y.f.I;
import y.h.C;
import y.h.O;
import y.h.aA;
import y.h.bu;
import y.h.dr;
import y.h.dy;
import y.h.fJ;
import y.h.fL;
import y.h.fj;
import y.h.h;
import y.h.hC;
import y.h.hk;
import y.h.ij;
import y.h.x;
import y.h.y;
import y.h.z;

public abstract class aB
implements I {
    static final int xb = 1;
    static final int ob = 2;
    public static final byte PATH_UNCLIPPED = 0;
    public static final byte PATH_CLIPPED_AT_SOURCE = 4;
    public static final byte PATH_CLIPPED_AT_TARGET = 8;
    public static final byte PATH_CLIPPED_AT_SOURCE_AND_TARGET = 12;
    public static final byte PATH_INVISBLE = 28;
    Object vb;
    Object zb;
    private boolean rb;
    int pb;
    private d qb;
    private Color kb;
    private dr dc;
    private h ib;
    private h yb;
    private ArrayList cc;
    private byte gc;
    private boolean tb;
    private fL sb;
    private fL ec;
    private float mb;
    private float jb;
    private float bc;
    private float ac;
    private boolean fc;
    private static Color wb = Color.orange;
    private static dr lb = dr.e;
    private static Color ub = Color.green;
    protected z bends;
    protected GeneralPath path;
    Rectangle2D.Float nb;

    protected aB() {
        this.g();
        this.kb = Color.black;
        this.dc = dr.a;
        this.yb = this.ib = h.a;
        this.setSourcePort(new fL());
        this.setTargetPort(new fL());
    }

    protected aB(aB aB2) {
        this.g();
        this.b(aB2);
    }

    void b(aB aB2) {
        aB aB3;
        boolean bl2 = fj.z;
        this.kb = aB2.getLineColor();
        this.dc = aB2.getLineType();
        this.yb = aB2.getArrow();
        this.ib = aB2.getSourceArrow();
        this.vb = aB2.vb;
        this.zb = aB2.zb;
        int n2 = aB2.labelCount();
        if (n2 > 0) {
            this.cc = new ArrayList(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                aB3 = this;
                if (!bl2) {
                    aB3.addLabel((aA)aB2.getLabel(i2).clone());
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            aB3 = aB2;
        }
        y y2 = aB3.bends();
        while (y2.f()) {
            x x2 = this.appendBend(y2.a().b(), y2.a().c());
            if (bl2) return;
            if (x2 != null) {
                x2.a(y2.a().d());
            }
            y2.g();
            if (!bl2) continue;
        }
        this.setSourcePort(aB2.getSourcePort().a());
        this.setTargetPort(aB2.getTargetPort().a());
        this.tb = aB2.isSelected();
        this.setVisible(aB2.isVisible());
        this.fc = aB2.fc;
        this.rb = true;
    }

    public aB createCopy() {
        return this.createCopy(this);
    }

    public abstract aB createCopy(aB var1);

    private void g() {
        this.pb = 1;
        this.path = new GeneralPath(1, 2);
        this.bends = new z();
        this.rb = true;
    }

    protected void bindEdge(d d2) {
        this.qb = d2;
        this.setDirty();
    }

    public fj getTargetRealizer() {
        return ((bu)this.qb.a()).t(this.qb.d());
    }

    public fj getSourceRealizer() {
        return ((bu)this.qb.a()).t(this.qb.c());
    }

    public d getEdge() {
        return this.qb;
    }

    bu i() {
        if (this.qb == null) return null;
        return (bu)this.qb.a();
    }

    public void setPorts(fL fL2, fL fL3) {
        this.setSourcePort(fL2);
        this.setTargetPort(fL3);
    }

    public void setSourcePort(fL fL2) {
        fL2.a(this);
        this.sb = fL2;
        this.setDirty();
    }

    public void setTargetPort(fL fL2) {
        fL2.a(this);
        this.ec = fL2;
        this.setDirty();
    }

    public fL getSourcePort() {
        return this.sb;
    }

    public fL getTargetPort() {
        return this.ec;
    }

    public abstract x createBend(double var1, double var3, x var5, int var6);

    public abstract void reInsertBend(x var1, x var2, int var3);

    public abstract x insertBend(double var1, double var3);

    public abstract x removeBend(x var1);

    public void bendChanged(x x2, double d2, double d3) {
    }

    protected void labelBoundsChanged() {
    }

    public x appendBend(double d2, double d3) {
        return this.createBend(d2, d3, this.lastBend(), 0);
    }

    public int bendPos(x x2) {
        return this.bends.indexOf(x2);
    }

    public int bendCount() {
        return this.bends.size();
    }

    public x getBend(int n2) {
        return (x)this.bends.a(n2);
    }

    public y bends() {
        return this.bends.b();
    }

    public x firstBend() {
        if (this.bends.size() != 0) return (x)this.bends.f();
        return null;
    }

    public x lastBend() {
        if (this.bends.size() != 0) return (x)this.bends.i();
        return null;
    }

    public int getMinBendCount() {
        return 0;
    }

    public void clearBends() {
        this.bends.clear();
        this.setDirty();
    }

    @Override
    public t getPoint(int n2) {
        x x2 = this.getBend(n2);
        if (x2 == null) return null;
        return new t(x2.b(), x2.c());
    }

    @Override
    public int pointCount() {
        return this.bendCount();
    }

    @Override
    public t getSourcePoint() {
        fL fL2 = this.getSourcePort();
        return new t(fL2.g(), fL2.h());
    }

    @Override
    public t getTargetPoint() {
        fL fL2 = this.getTargetPort();
        return new t(fL2.g(), fL2.h());
    }

    @Override
    public void setSourcePoint(t t2) {
        this.getSourcePort().b(t2.a(), t2.b());
    }

    @Override
    public void setTargetPoint(t t2) {
        this.getTargetPort().b(t2.a(), t2.b());
    }

    @Override
    public void setPoint(int n2, double d2, double d3) {
        x x2 = this.getBend(n2);
        if (x2 == null) return;
        x2.a(d2, d3);
    }

    @Override
    public void addPoint(double d2, double d3) {
        this.appendBend(d2, d3);
    }

    @Override
    public void clearPoints() {
        this.clearBends();
    }

    public void registerObstacles(C c2) {
    }

    public void paintSloppy(Graphics2D graphics2D) {
        if (!this.isVisible()) {
            return;
        }
        this.d(graphics2D, hk.e(graphics2D));
        if (!aB.e(graphics2D, true)) return;
        this.paintLabels(graphics2D);
    }

    void c(Graphics2D graphics2D) {
        this.d(graphics2D, true);
    }

    /*
     * Unable to fully structure code
     */
    private void d(Graphics2D var1_1, boolean var2_2) {
        block8 : {
            var18_3 = fj.z;
            var3_4 = this.path;
            if (!var2_2 && var3_4.getPathIterator(null).isDone()) {
                return;
            }
            var4_5 = var1_1.getStroke();
            var5_6 = var1_1.getColor();
            var6_7 = aB.b(this, var1_1);
            if (!var6_7 || aB.wb == null) ** GOTO lbl-1000
            var1_1.setColor(aB.wb);
            if (var18_3) lbl-1000: // 2 sources:
            {
                if ((var7_8 = this.getLineColor()) == null) return;
                var1_1.setColor((Color)var7_8);
                if (var18_3) {
                    return;
                }
            }
            var1_1.setStroke(dr.a);
            if (!var2_2) ** GOTO lbl36
            var7_8 = this.getSourceRealizer();
            var12_10 = this.sb.a((fj)var7_8);
            var14_11 = this.sb.b((fj)var7_8);
            for (var16_12 = this.bends.k(); var16_12 != null; var16_12 = var16_12.a()) {
                var17_18 = (x)var16_12.c();
                var8_13 = var17_18.b();
                var10_15 = var17_18.c();
                var1_1.drawLine((int)var12_10, (int)var14_11, (int)var8_13, (int)var10_15);
                var12_10 = var8_13;
                var14_11 = var10_15;
                if (!var18_3) {
                    if (!var18_3) continue;
                }
                break block8;
            }
            var7_8 = this.getTargetRealizer();
            var8_13 = this.ec.a((fj)var7_8);
            var10_15 = this.ec.b((fj)var7_8);
            var1_1.drawLine((int)var12_10, (int)var14_11, (int)var8_13, (int)var10_15);
        }
        if (!var18_3) ** GOTO lbl50
lbl36: // 2 sources:
        var7_9 = this.getSourceArrow() != h.a;
        v0 = var8_14 = this.getTargetArrow() != h.a;
        if (!var7_9 && !var8_14) ** GOTO lbl-1000
        var9_19 = new GeneralPath(var3_4.getWindingRule());
        if (var7_9) {
            var10_16 = this.getSourceIntersection();
            var9_19.moveTo((float)var10_16.getX(), (float)var10_16.getY());
        }
        var9_19.append(var3_4, var7_9);
        if (var8_14) {
            var10_17 = this.getTargetIntersection();
            var9_19.lineTo((float)var10_17.getX(), (float)var10_17.getY());
        }
        var1_1.draw(var9_19);
        if (var18_3) lbl-1000: // 2 sources:
        {
            var1_1.draw(var3_4);
        }
lbl50: // 4 sources:
        var1_1.setStroke(var4_5);
        var1_1.setColor(var5_6);
    }

    public void repaint() {
        d d2 = this.getEdge();
        if (d2 == null) return;
        i i2 = d2.a();
        if (!(i2 instanceof bu)) return;
        Rectangle2D.Double double_ = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
        this.calcUnionRect(double_);
        ((bu)i2).a(double_.x, double_.y, double_.width, double_.height);
    }

    /*
     * Unable to fully structure code
     */
    public void paint(Graphics2D var1_1) {
        if ((this.pb & 1) == 0) {
            return;
        }
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((this.pb & 2) == 0) {
            return;
        }
        var2_2 = var1_1.getColor();
        var3_3 = var1_1.getStroke();
        var4_4 = this.path;
        if (this instanceof fJ && (!this.qb.e() || this.bendCount() >= 2) && (var5_5 = O.getBridgeCalculator(this, var1_1)) != null) {
            var6_7 = new GeneralPath();
            var7_9 = var5_5.a(var4_4.getPathIterator(null, 1.0));
            var6_7.append(var7_9, true);
            var4_4 = var6_7;
        }
        if (this.fc) {
            var4_4 = ij.a(var4_4);
        }
        if (!(var5_6 = aB.b(this, var1_1)) || aB.wb == null) ** GOTO lbl26
        var1_1.setColor(aB.wb);
        if (aB.lb == null) ** GOTO lbl25
        var6_8 = (int)(this.dc.getLineWidth() - aB.lb.getLineWidth());
        if (var6_8 < 0) ** GOTO lbl-1000
        var1_1.setStroke(new BasicStroke(this.dc.getLineWidth() + 4.0f, 2, 2));
        if (fj.z) lbl-1000: // 2 sources:
        {
            var1_1.setStroke(aB.lb);
        }
lbl25: // 4 sources:
        var1_1.draw(var4_4);
lbl26: // 2 sources:
        if (this.kb != null) {
            var1_1.setColor(this.kb);
            var1_1.setStroke(this.dc);
            var1_1.draw(var4_4);
            this.paintArrows(var1_1);
        }
        if (aB.e(var1_1, false)) {
            this.paintLabels(var1_1);
        }
        this.paintPorts(var1_1);
        if (var5_6) {
            this.paintHighlightedBends(var1_1);
        }
        this.paintBends(var1_1);
        var1_1.setStroke(var3_3);
        var1_1.setColor(var2_2);
    }

    protected void paintHighlightedBends(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        graphics2D.setStroke(dr.a);
        if (this.bendCount() <= 0) return;
        Ellipse2D.Double double_ = hC.a().m;
        double_.height = 6.0;
        double_.width = 6.0;
        y y2 = this.bends.b();
        do {
            if (!y2.f()) return;
            x x2 = y2.a();
            graphics2D.setColor(ub);
            double_.x = x2.b() - 3.0;
            double_.y = x2.c() - 3.0;
            graphics2D.fill(double_);
            graphics2D.setColor(Color.darkGray);
            graphics2D.draw(double_);
            y2.g();
        } while (!bl2);
    }

    protected void paintBends(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        if (this.bends.isEmpty()) return;
        boolean bl3 = hk.b(graphics2D);
        p p2 = this.bends.k();
        do {
            if (p2 == null) return;
            x x2 = (x)p2.c();
            if (x2.d() && bl3) {
                x2.a(graphics2D);
            }
            p2 = p2.a();
        } while (!bl2);
    }

    protected void paintPorts(Graphics2D graphics2D) {
        this.sb.a(graphics2D, this.getSourceRealizer());
        this.ec.a(graphics2D, this.getTargetRealizer());
    }

    /*
     * Unable to fully structure code
     */
    protected void paintArrows(Graphics2D var1_1) {
        var17_2 = fj.z;
        if (this.ib == h.a && this.yb == h.a) {
            return;
        }
        var2_3 = this.path.getPathIterator(null);
        var11_4 = hC.a();
        var12_5 = var11_4.b;
        var13_6 = var11_4.c;
        var2_3.currentSegment(var13_6);
        var2_3.next();
        var3_7 = var13_6[0];
        var4_8 = var13_6[1];
        var2_3.currentSegment(var13_6);
        var2_3.next();
        var14_9 = this.getArrowScaleFactor();
        if (this.ib == h.a) ** GOTO lbl33
        var16_10 = this.isPathClippedAtSource();
        if (!var16_10) ** GOTO lbl-1000
        var5_11 = this.mb - var3_7;
        var7_12 = this.jb - var4_8;
        if (var17_2) lbl-1000: // 2 sources:
        {
            var5_11 = var3_7 - var13_6[0];
            var7_12 = var4_8 - var13_6[1];
        }
        if ((var9_13 = Math.sqrt(var5_11 * var5_11 + var7_12 * var7_12)) > 0.0) {
            var5_11 /= var9_13;
            var7_12 /= var9_13;
            if (var16_10) {
                var3_7 = (float)((double)var3_7 + this.ib.c() * var5_11 * var14_9);
                var4_8 = (float)((double)var4_8 + this.ib.c() * var7_12 * var14_9);
            }
            var12_5.setTransform(var5_11, var7_12, - var7_12, var5_11, var3_7, var4_8);
            if (var14_9 != 1.0) {
                var12_5.scale(var14_9, var14_9);
            }
            this.ib.a(var1_1, var12_5);
        }
lbl33: // 4 sources:
        if (this.yb == h.a) return;
        while (!var2_3.isDone()) {
            var3_7 = var13_6[0];
            var4_8 = var13_6[1];
            var2_3.currentSegment(var13_6);
            var2_3.next();
            if (var17_2 != false) return;
            if (!var17_2) continue;
        }
        if (!(var16_10 = this.isPathClippedAtTarget())) ** GOTO lbl-1000
        var5_11 = this.bc - var13_6[0];
        var7_12 = this.ac - var13_6[1];
        if (var17_2) lbl-1000: // 2 sources:
        {
            var5_11 = var13_6[0] - var3_7;
            var7_12 = var13_6[1] - var4_8;
        }
        if ((var9_13 = Math.sqrt(var5_11 * var5_11 + var7_12 * var7_12)) <= 0.0) return;
        var5_11 /= var9_13;
        var7_12 /= var9_13;
        if (var16_10) {
            v0 = var13_6;
            v0[0] = (float)((double)v0[0] + this.yb.c() * var5_11 * var14_9);
            v1 = var13_6;
            v1[1] = (float)((double)v1[1] + this.yb.c() * var7_12 * var14_9);
        }
        var12_5.setTransform(var5_11, var7_12, - var7_12, var5_11, var13_6[0], var13_6[1]);
        if (var14_9 != 1.0) {
            var12_5.scale(var14_9, var14_9);
        }
        this.yb.a(var1_1, var12_5);
    }

    public double getArrowScaleFactor() {
        double d2 = this.getLineType().getLineWidth();
        if (d2 == 1.0) return d2;
        return 1.0 + (d2 - 1.0) / 8.0;
    }

    protected void paintLabels(Graphics2D graphics2D) {
        boolean bl2 = fj.z;
        if (this.cc == null) return;
        int n2 = this.cc.size() - 1;
        do {
            if (n2 < 0) return;
            aA aA2 = this.getLabel(n2);
            if (aA2.isVisible() && (aA2.getText().length() != 0 || aA2.getIcon() != null)) {
                aA2.paint(graphics2D);
            }
            --n2;
        } while (!bl2);
    }

    static boolean b(aB aB2, Graphics2D graphics2D) {
        if (!aB2.isSelected()) return false;
        if (!hk.b(graphics2D)) return false;
        return true;
    }

    static boolean e(Graphics2D graphics2D, boolean bl2) {
        Object object = graphics2D.getRenderingHint(hk.c);
        if (bl2) {
            return hk.e.equals(object);
        }
        if (hk.f.equals(object)) return false;
        return true;
    }

    protected abstract byte calculatePath(Point2D var1, Point2D var2);

    public static final byte calculateClippingAndIntersection(aB aB2, GeneralPath generalPath, GeneralPath generalPath2, Point2D point2D, Point2D point2D2) {
        return ij.a(aB2, generalPath, generalPath2, point2D, point2D2);
    }

    /*
     * Unable to fully structure code
     */
    protected final void recalculateFeatures() {
        var9_1 = fj.z;
        var1_2 = hC.a();
        var2_3 = var1_2.h;
        var3_4 = var1_2.g;
        this.h();
        this.pb &= -13;
        var4_5 = this.calculatePath(var2_3, var3_4);
        this.pb |= 12 & var4_5;
        var5_6 = this.path.getPathIterator(null);
        var6_7 = true;
        if (!var5_6.isDone()) ** GOTO lbl14
        var6_7 = false;
        if (!var9_1) ** GOTO lbl-1000
lbl14: // 2 sources:
        this.mb = (float)var2_3.x;
        this.jb = (float)var2_3.y;
        this.bc = (float)var3_4.x;
        this.ac = (float)var3_4.y;
        if (!var6_7) ** GOTO lbl-1000
        this.pb |= 2;
        if (var9_1) lbl-1000: // 3 sources:
        {
            this.pb &= -3;
            var7_8 = this.getTargetPort();
            this.bc = (float)var7_8.a(this.getTargetRealizer());
            this.ac = (float)var7_8.b(this.getTargetRealizer());
            var8_9 = this.getSourcePort();
            this.mb = (float)var8_9.a(this.getSourceRealizer());
            this.jb = (float)var8_9.b(this.getSourceRealizer());
        }
        this.rb = false;
    }

    public boolean hasVisiblePath() {
        if ((this.pb & 3) != 3) return false;
        return true;
    }

    public Point2D getSourceIntersection() {
        if (!this.isDirty()) return new Point2D.Float(this.mb, this.jb);
        this.recalculateFeatures();
        return new Point2D.Float(this.mb, this.jb);
    }

    public Point2D getTargetIntersection() {
        if (!this.isDirty()) return new Point2D.Float(this.bc, this.ac);
        this.recalculateFeatures();
        return new Point2D.Float(this.bc, this.ac);
    }

    public boolean isReversedPathRenderingEnabled() {
        return this.fc;
    }

    public void setReversedPathRenderingEnabled(boolean bl2) {
        if (bl2 == this.fc) return;
        this.fc = bl2;
    }

    public Color getLineColor() {
        return this.kb;
    }

    public void setLineColor(Color color) {
        this.kb = color;
    }

    public static Color getSelectionColor() {
        return wb;
    }

    public static void setSelectionColor(Color color) {
        wb = color;
    }

    public static void setHighlightedBendColor(Color color) {
        ub = color;
    }

    public static Color getHighlightedBendColor() {
        return ub;
    }

    public dr getLineType() {
        return this.dc;
    }

    public void setLineType(dr dr2) {
        if (this.dc == dr2) return;
        if (this.dc.getLineWidth() != dr2.getLineWidth() && (this.ib.c() != 0.0 || this.yb.c() != 0.0)) {
            this.setDirty();
        }
        this.dc = dr2;
    }

    public static void setSelectionStroke(dr dr2) {
        lb = dr2;
    }

    public static Stroke getSelectionStroke() {
        return lb;
    }

    public h getArrow() {
        return this.yb;
    }

    public void setArrow(h h2) {
        this.setTargetArrow(h2);
    }

    public h getTargetArrow() {
        return this.yb;
    }

    public void setTargetArrow(h h2) {
        if (h2 == this.yb) return;
        if (this.yb.d() != h2.d() || this.yb.c() != h2.c()) {
            this.setDirty();
        }
        this.yb = h2;
    }

    public h getSourceArrow() {
        return this.ib;
    }

    public void setSourceArrow(h h2) {
        if (h2 == this.ib) return;
        if (this.ib.d() != h2.d() || this.ib.c() != h2.c()) {
            this.setDirty();
        }
        this.ib = h2;
    }

    public void setLayer(byte by2) {
        this.gc = by2;
    }

    public byte getLayer() {
        return this.gc;
    }

    public void setVisible(boolean bl2) {
        if (bl2) {
            this.pb |= 1;
            if (!fj.z) return;
        }
        this.pb &= -2;
    }

    public boolean isVisible() {
        if ((this.pb & 1) != 1) return false;
        return true;
    }

    public boolean isPathClippedAtSource() {
        if ((this.pb & 4) != 4) return false;
        return true;
    }

    public boolean isPathClippedAtTarget() {
        if ((this.pb & 8) != 8) return false;
        return true;
    }

    public void setSelected(boolean bl2) {
        if (bl2 == this.tb) return;
        this.tb = bl2;
        bu bu2 = this.i();
        if (bu2 != null) {
            bu2.e(this.getEdge());
        }
        this.f();
    }

    void f() {
    }

    public boolean isSelected() {
        return this.tb;
    }

    public void setDirty() {
        if (this.cc != null) {
            for (int i2 = this.cc.size() - 1; i2 >= 0; --i2) {
                aA aA2 = this.getLabel(i2);
                aA2.setOffsetDirty();
            }
        }
        this.rb = true;
        this.h();
    }

    protected boolean isDirty() {
        return this.rb;
    }

    public GeneralPath getPath() {
        if (!this.isDirty()) return this.path;
        this.recalculateFeatures();
        return this.path;
    }

    public dy getMouseInputEditorProvider() {
        if (!(this instanceof dy)) return null;
        return (dy)((Object)this);
    }

    public void addLabel(aA aA2) {
        aA2.bindRealizer(this);
        if (this.cc == null) {
            this.cc = new ArrayList<E>(1);
        }
        this.cc.add(aA2);
    }

    public void removeLabel(aA aA2) {
        if (this.cc == null) return;
        this.cc.remove(aA2);
        this.rb = true;
    }

    public void removeLabel(int n2) {
        if (this.cc == null) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n2).append(", Size: 0").toString());
        }
        try {
            this.cc.remove(n2);
            this.rb = true;
            return;
        }
        catch (IndexOutOfBoundsException var2_2) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Index: ").append(n2).append(", Size: ").append(this.cc.size()).toString());
        }
    }

    public aA getLabel() {
        if (this.labelCount() != 0) return this.getLabel(0);
        this.addLabel(this.createEdgeLabel());
        return this.getLabel(0);
    }

    public int labelCount() {
        if (this.cc == null) return 0;
        int n2 = this.cc.size();
        return n2;
    }

    public aA getLabel(int n2) {
        if (this.cc != null) return (aA)this.cc.get(n2);
        throw new ArrayIndexOutOfBoundsException(0);
    }

    public void setLabelText(String string) {
        this.getLabel().setText(string);
    }

    public String getLabelText() {
        return this.getLabel().getText();
    }

    public aA createEdgeLabel() {
        return new aA();
    }

    public boolean contains(double d2, double d3) {
        if ((this.pb & 2) == 0) {
            return false;
        }
        if (this.isDirty() || this.nb == null) {
            this.nb = this.b(this.nb);
        }
        double d4 = this.nb.x - 5.0f;
        double d5 = this.nb.y - 5.0f;
        double d6 = d4 + (double)this.nb.width + 10.0;
        double d7 = d5 + (double)this.nb.height + 10.0;
        if (d2 <= d4) return false;
        if (d2 >= d6) return false;
        if (d3 <= d5) return false;
        if (d3 >= d7) return false;
        boolean bl2 = this.containsSeg(d2, d3) > 0;
        if (!bl2) return bl2;
        Point2D point2D = this.getSourceIntersection();
        if (point2D.distanceSq(d2, d3) < 25.0) {
            return false;
        }
        Point2D point2D2 = this.getTargetIntersection();
        if (point2D2.distanceSq(d2, d3) >= 25.0) return bl2;
        return false;
    }

    public int containsSeg(double d2, double d3) {
        PathIterator pathIterator;
        boolean bl2 = fj.z;
        int n2 = 1;
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((pathIterator = this.path.getPathIterator(null)).isDone()) {
            return 0;
        }
        float[] arrf = hC.a().c;
        pathIterator.currentSegment(arrf);
        pathIterator.next();
        float f2 = arrf[0];
        float f3 = arrf[1];
        do {
            if (pathIterator.isDone()) return 0;
            pathIterator.currentSegment(arrf);
            int n3 = (int)(Line2D.ptSegDistSq(f2, f3, arrf[0], arrf[1], d2, d3) DCMPG 25.0);
            if (bl2) return n3;
            if (n3 < 0) {
                return n2;
            }
            ++n2;
            pathIterator.next();
            f2 = arrf[0];
            f3 = arrf[1];
        } while (!bl2);
        return 0;
    }

    public void calcUnionRect(Rectangle2D rectangle2D) {
        if (this.isDirty() || this.nb == null) {
            this.nb = this.b(this.nb);
        }
        e.a(rectangle2D, this.nb, rectangle2D);
    }

    public boolean pathIntersects(Rectangle2D rectangle2D, boolean bl2) {
        boolean bl3;
        boolean bl4;
        block9 : {
            bl3 = fj.z;
            if (this.isDirty()) {
                this.recalculateFeatures();
            }
            if (this.nb != null && !this.nb.intersects(rectangle2D)) {
                return false;
            }
            PathIterator pathIterator = this.path.getPathIterator(null);
            if (pathIterator.isDone()) {
                return false;
            }
            float[] arrf = hC.a().c;
            pathIterator.currentSegment(arrf);
            pathIterator.next();
            float f2 = arrf[0];
            float f3 = arrf[1];
            while (!pathIterator.isDone()) {
                pathIterator.currentSegment(arrf);
                bl4 = rectangle2D.intersectsLine(f2, f3, arrf[0], arrf[1]);
                if (!bl3) {
                    if (bl4) {
                        return true;
                    }
                    pathIterator.next();
                    f2 = arrf[0];
                    f3 = arrf[1];
                    if (!bl3) continue;
                }
                break block9;
            }
            bl4 = bl2;
        }
        if (!bl4) return false;
        int n2 = this.labelCount() - 1;
        do {
            if (n2 < 0) return false;
            aA aA2 = this.getLabel(n2);
            boolean bl5 = aA2.isVisible();
            if (bl3) return bl5;
            if (bl5 && (aA2.getText().length() != 0 || aA2.getIcon() != null)) {
                y.d.y y2 = aA2.getBox();
                if (rectangle2D.intersects(y2.c, y2.d, y2.a, y2.b)) {
                    return true;
                }
            }
            --n2;
        } while (!bl3);
        return false;
    }

    void h() {
        this.nb = null;
    }

    public boolean intersects(Rectangle2D rectangle2D) {
        Object object;
        boolean bl2 = fj.z;
        if (!this.isDirty() && this.nb != null) {
            return this.nb.intersects(rectangle2D);
        }
        if (this.bends.size() > 0) {
            for (object = this.bends.k(); object != null; object = object.a()) {
                x x2 = (x)object.c();
                if (!rectangle2D.contains(x2.b(), x2.c())) continue;
                return true;
            }
        }
        if (rectangle2D.contains((Point2D)(object = this.getTargetIntersection()))) {
            return true;
        }
        object = this.getSourceIntersection();
        if (rectangle2D.contains((Point2D)object)) {
            return true;
        }
        this.nb = this.b(this.nb);
        return this.nb.intersects(rectangle2D);
    }

    Rectangle2D.Float b(Rectangle2D.Float float_) {
        Rectangle2D rectangle2D;
        boolean bl2 = fj.z;
        Point2D point2D = this.getTargetIntersection();
        float_ = new Rectangle2D.Float((float)point2D.getX(), (float)point2D.getY(), 1.0f, 1.0f);
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((rectangle2D = this.path.getBounds2D()).getWidth() > 0.0 || rectangle2D.getHeight() > 0.0) {
            float_.add(rectangle2D);
        }
        double d2 = float_.getX();
        double d3 = d2 + float_.getWidth();
        double d4 = float_.getY();
        double d5 = d4 + float_.getHeight();
        for (int i2 = this.labelCount() - 1; i2 >= 0; --i2) {
            aA aA2 = this.getLabel(i2);
            if (bl2) return float_;
            if (!aA2.isVisible() || aA2.getText().length() == 0 && aA2.getIcon() == null) continue;
            y.d.y y2 = aA2.getBox();
            d3 = Math.max(y2.c + y2.a, d3);
            d2 = Math.min(y2.c, d2);
            d5 = Math.max(y2.d + y2.b, d5);
            d4 = Math.min(y2.d, d4);
            if (!bl2) continue;
        }
        float_.setFrame(d2, d4, d3 - d2, d5 - d4);
        return float_;
    }

    public void write(ObjectOutputStream objectOutputStream) {
        boolean bl2;
        block5 : {
            bl2 = fj.z;
            objectOutputStream.writeByte(6);
            objectOutputStream.writeInt(this.bends.size());
            y y2 = this.bends();
            while (y2.f()) {
                objectOutputStream.writeFloat((float)y2.a().b());
                objectOutputStream.writeFloat((float)y2.a().c());
                y2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            objectOutputStream.writeObject(this.getLineColor());
            objectOutputStream.writeByte(this.getArrow().a());
        }
        if (this.getArrow().a() == 0) {
            objectOutputStream.writeObject(this.getArrow().b());
        }
        objectOutputStream.writeByte(this.getSourceArrow().a());
        if (this.getSourceArrow().a() == 0) {
            objectOutputStream.writeObject(this.getSourceArrow().b());
        }
        dr.a(objectOutputStream, this.dc);
        objectOutputStream.writeObject(y.e.h.a(this.sb.getClass().getName()));
        this.sb.a(objectOutputStream);
        objectOutputStream.writeObject(y.e.h.a(this.ec.getClass().getName()));
        this.ec.a(objectOutputStream);
        objectOutputStream.writeInt(this.labelCount());
        for (int i2 = 0; i2 < this.labelCount(); ++i2) {
            this.getLabel(i2).write(objectOutputStream);
            if (bl2) return;
            if (!bl2) continue;
        }
        objectOutputStream.writeBoolean(this.isVisible());
        objectOutputStream.writeBoolean(this.fc);
    }

    public void read(ObjectInputStream objectInputStream) {
        boolean bl2 = fj.z;
        byte by2 = objectInputStream.readByte();
        switch (by2) {
            case 0: {
                this.b(objectInputStream);
                if (!bl2) return;
            }
            case 1: {
                this.c(objectInputStream);
                if (!bl2) return;
            }
            case 2: {
                this.d(objectInputStream);
                if (!bl2) return;
            }
            case 3: {
                this.e(objectInputStream);
                if (!bl2) return;
            }
            case 4: {
                this.f(objectInputStream);
                if (!bl2) return;
            }
            case 5: {
                this.f(objectInputStream);
                this.setVisible(objectInputStream.readBoolean());
                if (!bl2) return;
            }
            case 6: {
                this.f(objectInputStream);
                this.setVisible(objectInputStream.readBoolean());
                this.fc = objectInputStream.readBoolean();
                if (!bl2) return;
            }
        }
        throw new a(by2);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void f(ObjectInputStream var1_1) {
        block10 : {
            var7_2 = fj.z;
            var2_3 = var1_1.readInt();
            for (var3_4 = 0; var3_4 < var2_3; ++var3_4) {
                this.appendBend(var1_1.readFloat(), var1_1.readFloat());
                if (!var7_2) {
                    if (!var7_2) continue;
                }
                break block10;
            }
            this.setLineColor((Color)var1_1.readObject());
            var3_4 = var1_1.readByte();
        }
        if (var3_4 == 0) ** GOTO lbl-1000
        this.setArrow(h.a((byte)var3_4));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var4_5 = h.a((String)var1_1.readObject())) != null) {
                this.setArrow((h)var4_5);
            }
        }
        if ((var3_4 = var1_1.readByte()) == 0) ** GOTO lbl-1000
        this.setSourceArrow(h.a((byte)var3_4));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var4_5 = h.a((String)var1_1.readObject())) != null) {
                this.setSourceArrow((h)var4_5);
            }
        }
        this.dc = dr.a(var1_1);
        try {
            var4_5 = y.e.h.b((String)var1_1.readObject());
            this.sb = (fL)Class.forName((String)var4_5).newInstance();
            this.sb.a(var1_1);
            this.setSourcePort(this.sb);
            var4_5 = y.e.h.b((String)var1_1.readObject());
            this.ec = (fL)Class.forName((String)var4_5).newInstance();
            this.ec.a(var1_1);
            this.setTargetPort(this.ec);
        }
        catch (IllegalAccessException var4_6) {
            throw new a("Could not construct Port!");
        }
        catch (InstantiationException var4_7) {
            throw new a("Could not instantiate Port!");
        }
        var4_8 = var1_1.readInt();
        var5_9 = 0;
        do {
            if (var5_9 >= var4_8) return;
            var6_10 = this.createEdgeLabel();
            this.addLabel(var6_10);
            var6_10.read(var1_1);
            ++var5_9;
        } while (!var7_2);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void e(ObjectInputStream var1_1) {
        block10 : {
            var7_2 = fj.z;
            var2_3 = var1_1.readInt();
            for (var3_4 = 0; var3_4 < var2_3; ++var3_4) {
                this.appendBend(var1_1.readFloat(), var1_1.readFloat());
                if (!var7_2) {
                    if (!var7_2) continue;
                }
                break block10;
            }
            this.setLineColor((Color)var1_1.readObject());
            var3_4 = var1_1.readByte();
        }
        if (var3_4 == 0) ** GOTO lbl-1000
        this.setArrow(h.a((byte)var3_4));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var4_5 = h.a((String)var1_1.readObject())) != null) {
                this.setArrow((h)var4_5);
            }
        }
        if ((var3_4 = var1_1.readByte()) == 0) ** GOTO lbl-1000
        this.setSourceArrow(h.a((byte)var3_4));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var4_5 = h.a((String)var1_1.readObject())) != null) {
                this.setSourceArrow((h)var4_5);
            }
        }
        this.dc = dr.a(var1_1.readByte(), var1_1.readByte());
        try {
            var4_5 = y.e.h.b((String)var1_1.readObject());
            this.sb = (fL)Class.forName((String)var4_5).newInstance();
            this.sb.a(var1_1);
            this.setSourcePort(this.sb);
            var4_5 = y.e.h.b((String)var1_1.readObject());
            this.ec = (fL)Class.forName((String)var4_5).newInstance();
            this.ec.a(var1_1);
            this.setTargetPort(this.ec);
        }
        catch (IllegalAccessException var4_6) {
            throw new a("Could not construct Port!");
        }
        catch (InstantiationException var4_7) {
            throw new a("Could not instantiate Port!");
        }
        var4_8 = var1_1.readInt();
        var5_9 = 0;
        do {
            if (var5_9 >= var4_8) return;
            var6_10 = this.createEdgeLabel();
            this.addLabel(var6_10);
            var6_10.read(var1_1);
            ++var5_9;
        } while (!var7_2);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void d(ObjectInputStream var1_1) {
        block12 : {
            block11 : {
                var7_2 = fj.z;
                var2_3 = var1_1.readInt();
                for (var3_4 = 0; var3_4 < var2_3; ++var3_4) {
                    this.appendBend(var1_1.readFloat(), var1_1.readFloat());
                    if (!var7_2) {
                        if (!var7_2) continue;
                    }
                    break block11;
                }
                var3_4 = var1_1.readInt();
            }
            for (var4_5 = 0; var4_5 < var3_4; ++var4_5) {
                var5_6 = this.createEdgeLabel();
                this.addLabel((aA)var5_6);
                var5_6.read(var1_1);
                if (!var7_2) {
                    if (!var7_2) continue;
                }
                break block12;
            }
            this.setLineColor((Color)var1_1.readObject());
            var4_5 = var1_1.readByte();
        }
        if (var4_5 == 0) ** GOTO lbl-1000
        this.setArrow(h.a((byte)var4_5));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var5_6 = h.a((String)var1_1.readObject())) != null) {
                this.setArrow((h)var5_6);
            }
        }
        if ((var4_5 = var1_1.readByte()) == 0) ** GOTO lbl-1000
        this.setSourceArrow(h.a((byte)var4_5));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var5_6 = h.a((String)var1_1.readObject())) != null) {
                this.setSourceArrow((h)var5_6);
            }
        }
        this.dc = dr.a(var1_1.readByte(), var1_1.readByte());
        try {
            var5_6 = y.e.h.b((String)var1_1.readObject());
            this.sb = (fL)Class.forName((String)var5_6).newInstance();
            this.sb.a(var1_1);
            this.setSourcePort(this.sb);
            var5_6 = y.e.h.b((String)var1_1.readObject());
            this.ec = (fL)Class.forName((String)var5_6).newInstance();
            this.ec.a(var1_1);
            this.setTargetPort(this.ec);
            return;
        }
        catch (IllegalAccessException var6_7) {
            throw new a("Could not construct Port!");
        }
        catch (InstantiationException var6_8) {
            throw new a("Could not instantiate Port!");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void c(ObjectInputStream var1_1) {
        block16 : {
            block15 : {
                var7_2 = fj.z;
                var2_3 = var1_1.readInt();
                for (var3_4 = 0; var3_4 < var2_3; ++var3_4) {
                    this.appendBend(var1_1.readFloat(), var1_1.readFloat());
                    if (!var7_2) {
                        if (!var7_2) continue;
                    }
                    break block15;
                }
                var3_4 = var1_1.readInt();
            }
            for (var4_5 = 0; var4_5 < var3_4; ++var4_5) {
                var5_6 = this.createEdgeLabel();
                var5_6.read(var1_1);
                this.addLabel((aA)var5_6);
                if (!var7_2) {
                    if (!var7_2) continue;
                }
                break block16;
            }
            this.setLineColor((Color)var1_1.readObject());
            var4_5 = var1_1.readByte();
        }
        if (var4_5 == 0) ** GOTO lbl-1000
        this.setArrow(h.a((byte)var4_5));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var5_6 = h.a((String)var1_1.readObject())) != null) {
                this.setArrow((h)var5_6);
            }
        }
        if ((var4_5 = var1_1.readByte()) == 0) ** GOTO lbl-1000
        this.setSourceArrow(h.a((byte)var4_5));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var5_6 = h.a((String)var1_1.readObject())) != null) {
                this.setSourceArrow((h)var5_6);
            }
        }
        this.dc = dr.a(var1_1.readByte(), var1_1.readByte());
        try {
            if (!var1_1.readBoolean()) ** GOTO lbl-1000
            this.sb = new fL();
            if (var7_2) lbl-1000: // 2 sources:
            {
                if ((var5_6 = (String)var1_1.readObject()).startsWith("y.graph")) {
                    var5_6 = "y.view.Port";
                }
                this.sb = (fL)Class.forName((String)var5_6).newInstance();
                this.sb.a(var1_1);
            }
            if (!var1_1.readBoolean()) ** GOTO lbl-1000
            this.ec = new fL();
            if (var7_2) lbl-1000: // 2 sources:
            {
                if ((var5_6 = (String)var1_1.readObject()).startsWith("y.graph")) {
                    var5_6 = "y.view.Port";
                }
                this.ec = (fL)Class.forName((String)var5_6).newInstance();
                this.ec.a(var1_1);
            }
            this.setPorts(this.sb, this.ec);
            return;
        }
        catch (IllegalAccessException var6_7) {
            throw new a("Could not construct Port!");
        }
        catch (InstantiationException var6_8) {
            throw new a("Could not instantiate Port!");
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    void b(ObjectInputStream var1_1) {
        block11 : {
            var7_2 = fj.z;
            var2_3 = var1_1.readInt();
            for (var3_4 = 0; var3_4 < var2_3; ++var3_4) {
                v0 = this;
                if (!var7_2) {
                    v0.appendBend(var1_1.readFloat(), var1_1.readFloat());
                    if (!var7_2) continue;
                }
                break block11;
            }
            v0 = this;
        }
        var3_5 = v0.createEdgeLabel();
        var3_5.read(var1_1);
        this.addLabel(var3_5);
        this.setLineColor((Color)var1_1.readObject());
        var4_6 = var1_1.readByte();
        if (var4_6 == 0) ** GOTO lbl-1000
        this.setArrow(h.a(var4_6));
        if (var7_2) lbl-1000: // 2 sources:
        {
            if ((var5_7 = h.a((String)var1_1.readObject())) != null) {
                this.setArrow((h)var5_7);
            }
        }
        this.dc = dr.a(var1_1.readByte(), var1_1.readByte());
        try {
            if (!var1_1.readBoolean()) ** GOTO lbl-1000
            this.sb = new fL();
            if (var7_2) lbl-1000: // 2 sources:
            {
                if ((var5_7 = (String)var1_1.readObject()).startsWith("y.graph")) {
                    var5_7 = "y.view.Port";
                }
                this.sb = (fL)Class.forName((String)var5_7).newInstance();
                this.sb.a(var1_1);
            }
            if (!var1_1.readBoolean()) ** GOTO lbl-1000
            this.ec = new fL();
            if (var7_2) lbl-1000: // 2 sources:
            {
                if ((var5_7 = (String)var1_1.readObject()).startsWith("y.graph")) {
                    var5_7 = "y.view.Port";
                }
                this.ec = (fL)Class.forName((String)var5_7).newInstance();
                this.ec.a(var1_1);
            }
            this.setPorts(this.sb, this.ec);
            return;
        }
        catch (IllegalAccessException var6_8) {
            throw new a("Could not construct Port!");
        }
        catch (InstantiationException var6_9) {
            throw new a("Could not instantiate Port!");
        }
    }
}

