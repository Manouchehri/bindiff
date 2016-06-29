package y.h;

import y.f.*;
import java.util.*;
import y.c.*;
import java.awt.*;
import java.awt.geom.*;
import y.d.*;
import y.e.*;
import java.io.*;

public abstract class aB implements I
{
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
    private static Color wb;
    private static dr lb;
    private static Color ub;
    protected z bends;
    protected GeneralPath path;
    Rectangle2D.Float nb;
    
    protected aB() {
        this.g();
        this.kb = Color.black;
        this.dc = dr.a;
        final h a = h.a;
        this.ib = a;
        this.yb = a;
        this.setSourcePort(new fL());
        this.setTargetPort(new fL());
    }
    
    protected aB(final aB ab) {
        this.g();
        this.b(ab);
    }
    
    void b(final aB ab) {
        final boolean z = fj.z;
        this.kb = ab.getLineColor();
        this.dc = ab.getLineType();
        this.yb = ab.getArrow();
        this.ib = ab.getSourceArrow();
        this.vb = ab.vb;
        this.zb = ab.zb;
        final int labelCount = ab.labelCount();
        aB ab2 = null;
        Label_0110: {
            if (labelCount > 0) {
                this.cc = new ArrayList(labelCount);
                int i = 0;
                while (i < labelCount) {
                    ab2 = this;
                    if (z) {
                        break Label_0110;
                    }
                    this.addLabel((aA)ab.getLabel(i).clone());
                    ++i;
                    if (z) {
                        break;
                    }
                }
            }
            ab2 = ab;
        }
        final y bends = ab2.bends();
        while (bends.f()) {
            final x appendBend = this.appendBend(bends.a().b(), bends.a().c());
            if (z) {
                return;
            }
            if (appendBend != null) {
                appendBend.a(bends.a().d());
            }
            bends.g();
            if (z) {
                break;
            }
        }
        this.setSourcePort(ab.getSourcePort().a());
        this.setTargetPort(ab.getTargetPort().a());
        this.tb = ab.isSelected();
        this.setVisible(ab.isVisible());
        this.fc = ab.fc;
        this.rb = true;
    }
    
    public aB createCopy() {
        return this.createCopy(this);
    }
    
    public abstract aB createCopy(final aB p0);
    
    private void g() {
        this.pb = 1;
        this.path = new GeneralPath(1, 2);
        this.bends = new z();
        this.rb = true;
    }
    
    protected void bindEdge(final d qb) {
        this.qb = qb;
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
        if (this.qb != null) {
            return (bu)this.qb.a();
        }
        return null;
    }
    
    public void setPorts(final fL sourcePort, final fL targetPort) {
        this.setSourcePort(sourcePort);
        this.setTargetPort(targetPort);
    }
    
    public void setSourcePort(final fL sb) {
        sb.a(this);
        this.sb = sb;
        this.setDirty();
    }
    
    public void setTargetPort(final fL ec) {
        ec.a(this);
        this.ec = ec;
        this.setDirty();
    }
    
    public fL getSourcePort() {
        return this.sb;
    }
    
    public fL getTargetPort() {
        return this.ec;
    }
    
    public abstract x createBend(final double p0, final double p1, final x p2, final int p3);
    
    public abstract void reInsertBend(final x p0, final x p1, final int p2);
    
    public abstract x insertBend(final double p0, final double p1);
    
    public abstract x removeBend(final x p0);
    
    public void bendChanged(final x x, final double n, final double n2) {
    }
    
    protected void labelBoundsChanged() {
    }
    
    public x appendBend(final double n, final double n2) {
        return this.createBend(n, n2, this.lastBend(), 0);
    }
    
    public int bendPos(final x x) {
        return this.bends.indexOf(x);
    }
    
    public int bendCount() {
        return this.bends.size();
    }
    
    public x getBend(final int n) {
        return (x)this.bends.a(n);
    }
    
    public y bends() {
        return this.bends.b();
    }
    
    public x firstBend() {
        if (this.bends.size() == 0) {
            return null;
        }
        return (x)this.bends.f();
    }
    
    public x lastBend() {
        if (this.bends.size() == 0) {
            return null;
        }
        return (x)this.bends.i();
    }
    
    public int getMinBendCount() {
        return 0;
    }
    
    public void clearBends() {
        this.bends.clear();
        this.setDirty();
    }
    
    public t getPoint(final int n) {
        final x bend = this.getBend(n);
        if (bend != null) {
            return new t(bend.b(), bend.c());
        }
        return null;
    }
    
    public int pointCount() {
        return this.bendCount();
    }
    
    public t getSourcePoint() {
        final fL sourcePort = this.getSourcePort();
        return new t(sourcePort.g(), sourcePort.h());
    }
    
    public t getTargetPoint() {
        final fL targetPort = this.getTargetPort();
        return new t(targetPort.g(), targetPort.h());
    }
    
    public void setSourcePoint(final t t) {
        this.getSourcePort().b(t.a(), t.b());
    }
    
    public void setTargetPoint(final t t) {
        this.getTargetPort().b(t.a(), t.b());
    }
    
    public void setPoint(final int n, final double n2, final double n3) {
        final x bend = this.getBend(n);
        if (bend != null) {
            bend.a(n2, n3);
        }
    }
    
    public void addPoint(final double n, final double n2) {
        this.appendBend(n, n2);
    }
    
    public void clearPoints() {
        this.clearBends();
    }
    
    public void registerObstacles(final C c) {
    }
    
    public void paintSloppy(final Graphics2D graphics2D) {
        if (!this.isVisible()) {
            return;
        }
        this.d(graphics2D, hk.e(graphics2D));
        if (e(graphics2D, true)) {
            this.paintLabels(graphics2D);
        }
    }
    
    void c(final Graphics2D graphics2D) {
        this.d(graphics2D, true);
    }
    
    private void d(final Graphics2D graphics2D, final boolean b) {
        final boolean z = fj.z;
        final GeneralPath path = this.path;
        if (!b && path.getPathIterator(null).isDone()) {
            return;
        }
        final Stroke stroke = graphics2D.getStroke();
        final Color color = graphics2D.getColor();
        Label_0093: {
            if (b(this, graphics2D) && aB.wb != null) {
                graphics2D.setColor(aB.wb);
                if (!z) {
                    break Label_0093;
                }
            }
            final Color lineColor = this.getLineColor();
            if (lineColor != null) {
                graphics2D.setColor(lineColor);
                if (!z) {
                    break Label_0093;
                }
            }
            return;
        }
        graphics2D.setStroke(dr.a);
        Label_0397: {
            Label_0260: {
                if (b) {
                    final fj sourceRealizer = this.getSourceRealizer();
                    double a = this.sb.a(sourceRealizer);
                    double b2 = this.sb.b(sourceRealizer);
                    p p2 = this.bends.k();
                    while (true) {
                        while (p2 != null) {
                            final x x = (x)p2.c();
                            final double b3 = x.b();
                            final double c = x.c();
                            graphics2D.drawLine((int)a, (int)b2, (int)b3, (int)c);
                            a = b3;
                            b2 = c;
                            p2 = p2.a();
                            if (!z) {
                                if (z) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (z) {
                                    break Label_0260;
                                }
                                break Label_0397;
                            }
                        }
                        final fj targetRealizer = this.getTargetRealizer();
                        graphics2D.drawLine((int)a, (int)b2, (int)this.ec.a(targetRealizer), (int)this.ec.b(targetRealizer));
                        continue;
                    }
                }
            }
            final boolean b4 = this.getSourceArrow() != h.a;
            final boolean b5 = this.getTargetArrow() != h.a;
            if (b4 || b5) {
                final GeneralPath generalPath = new GeneralPath(path.getWindingRule());
                if (b4) {
                    final Point2D sourceIntersection = this.getSourceIntersection();
                    generalPath.moveTo((float)sourceIntersection.getX(), (float)sourceIntersection.getY());
                }
                generalPath.append(path, b4);
                if (b5) {
                    final Point2D targetIntersection = this.getTargetIntersection();
                    generalPath.lineTo((float)targetIntersection.getX(), (float)targetIntersection.getY());
                }
                graphics2D.draw(generalPath);
                if (!z) {
                    break Label_0397;
                }
            }
            graphics2D.draw(path);
        }
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
    }
    
    public void repaint() {
        final d edge = this.getEdge();
        if (edge != null) {
            final i a = edge.a();
            if (a instanceof bu) {
                final Rectangle2D.Double double1 = new Rectangle2D.Double(0.0, 0.0, -1.0, -1.0);
                this.calcUnionRect(double1);
                ((bu)a).a(double1.x, double1.y, double1.width, double1.height);
            }
        }
    }
    
    public void paint(final Graphics2D graphics2D) {
        if ((this.pb & 0x1) == 0x0) {
            return;
        }
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if ((this.pb & 0x2) == 0x0) {
            return;
        }
        final Color color = graphics2D.getColor();
        final Stroke stroke = graphics2D.getStroke();
        GeneralPath generalPath = this.path;
        if (this instanceof fJ && (!this.qb.e() || this.bendCount() >= 2)) {
            final C bridgeCalculator = O.getBridgeCalculator(this, graphics2D);
            if (bridgeCalculator != null) {
                final GeneralPath generalPath2 = new GeneralPath();
                generalPath2.append(bridgeCalculator.a(generalPath.getPathIterator(null, 1.0)), true);
                generalPath = generalPath2;
            }
        }
        if (this.fc) {
            generalPath = ij.a(generalPath);
        }
        final boolean b = b(this, graphics2D);
        if (b && aB.wb != null) {
            graphics2D.setColor(aB.wb);
            Label_0223: {
                if (aB.lb != null) {
                    if ((int)(this.dc.getLineWidth() - aB.lb.getLineWidth()) >= 0) {
                        graphics2D.setStroke(new BasicStroke(this.dc.getLineWidth() + 4.0f, 2, 2));
                        if (!fj.z) {
                            break Label_0223;
                        }
                    }
                    graphics2D.setStroke(aB.lb);
                }
            }
            graphics2D.draw(generalPath);
        }
        if (this.kb != null) {
            graphics2D.setColor(this.kb);
            graphics2D.setStroke(this.dc);
            graphics2D.draw(generalPath);
            this.paintArrows(graphics2D);
        }
        if (e(graphics2D, false)) {
            this.paintLabels(graphics2D);
        }
        this.paintPorts(graphics2D);
        if (b) {
            this.paintHighlightedBends(graphics2D);
        }
        this.paintBends(graphics2D);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
    }
    
    protected void paintHighlightedBends(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        graphics2D.setStroke(dr.a);
        if (this.bendCount() > 0) {
            final Ellipse2D.Double m;
            final Ellipse2D.Double double2;
            final Ellipse2D.Double double1 = double2 = (m = hC.a().m);
            final double n = 6.0;
            double2.height = n;
            m.width = n;
            final y b = this.bends.b();
            while (b.f()) {
                final x a = b.a();
                graphics2D.setColor(aB.ub);
                double1.x = a.b() - 3.0;
                double1.y = a.c() - 3.0;
                graphics2D.fill(double1);
                graphics2D.setColor(Color.darkGray);
                graphics2D.draw(double1);
                b.g();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void paintBends(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (!this.bends.isEmpty()) {
            final boolean b = hk.b(graphics2D);
            p p = this.bends.k();
            while (p != null) {
                final x x = (x)p.c();
                if (x.d() && b) {
                    x.a(graphics2D);
                }
                p = p.a();
                if (z) {
                    break;
                }
            }
        }
    }
    
    protected void paintPorts(final Graphics2D graphics2D) {
        this.sb.a(graphics2D, this.getSourceRealizer());
        this.ec.a(graphics2D, this.getTargetRealizer());
    }
    
    protected void paintArrows(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (this.ib == h.a && this.yb == h.a) {
            return;
        }
        final PathIterator pathIterator = this.path.getPathIterator(null);
        final hC a = hC.a();
        final AffineTransform b = a.b;
        final float[] c = a.c;
        pathIterator.currentSegment(c);
        pathIterator.next();
        float n = c[0];
        float n2 = c[1];
        pathIterator.currentSegment(c);
        pathIterator.next();
        final double arrowScaleFactor = this.getArrowScaleFactor();
        if (this.ib != h.a) {
            final boolean pathClippedAtSource = this.isPathClippedAtSource();
            double n3 = 0.0;
            double n4 = 0.0;
            Label_0165: {
                if (pathClippedAtSource) {
                    n3 = this.mb - n;
                    n4 = this.jb - n2;
                    if (!z) {
                        break Label_0165;
                    }
                }
                n3 = n - c[0];
                n4 = n2 - c[1];
            }
            final double sqrt = Math.sqrt(n3 * n3 + n4 * n4);
            if (sqrt > 0.0) {
                final double n5 = n3 / sqrt;
                final double n6 = n4 / sqrt;
                if (pathClippedAtSource) {
                    n += (float)(this.ib.c() * n5 * arrowScaleFactor);
                    n2 += (float)(this.ib.c() * n6 * arrowScaleFactor);
                }
                b.setTransform(n5, n6, -n6, n5, n, n2);
                if (arrowScaleFactor != 1.0) {
                    b.scale(arrowScaleFactor, arrowScaleFactor);
                }
                this.ib.a(graphics2D, b);
            }
        }
        if (this.yb != h.a) {
            while (!pathIterator.isDone()) {
                n = c[0];
                n2 = c[1];
                pathIterator.currentSegment(c);
                pathIterator.next();
                if (z) {
                    return;
                }
                if (z) {
                    break;
                }
            }
            final boolean pathClippedAtTarget = this.isPathClippedAtTarget();
            double n7 = 0.0;
            double n8 = 0.0;
            Label_0404: {
                if (pathClippedAtTarget) {
                    n7 = this.bc - c[0];
                    n8 = this.ac - c[1];
                    if (!z) {
                        break Label_0404;
                    }
                }
                n7 = c[0] - n;
                n8 = c[1] - n2;
            }
            final double sqrt2 = Math.sqrt(n7 * n7 + n8 * n8);
            if (sqrt2 > 0.0) {
                final double n9 = n7 / sqrt2;
                final double n10 = n8 / sqrt2;
                if (pathClippedAtTarget) {
                    final float[] array = c;
                    final int n11 = 0;
                    array[n11] += (float)(this.yb.c() * n9 * arrowScaleFactor);
                    final float[] array2 = c;
                    final int n12 = 1;
                    array2[n12] += (float)(this.yb.c() * n10 * arrowScaleFactor);
                }
                b.setTransform(n9, n10, -n10, n9, c[0], c[1]);
                if (arrowScaleFactor != 1.0) {
                    b.scale(arrowScaleFactor, arrowScaleFactor);
                }
                this.yb.a(graphics2D, b);
            }
        }
    }
    
    public double getArrowScaleFactor() {
        double n = this.getLineType().getLineWidth();
        if (n != 1.0) {
            n = 1.0 + (n - 1.0) / 8.0;
        }
        return n;
    }
    
    protected void paintLabels(final Graphics2D graphics2D) {
        final boolean z = fj.z;
        if (this.cc != null) {
            int i = this.cc.size() - 1;
            while (i >= 0) {
                final aA label = this.getLabel(i);
                if (label.isVisible() && (label.getText().length() != 0 || label.getIcon() != null)) {
                    label.paint(graphics2D);
                }
                --i;
                if (z) {
                    break;
                }
            }
        }
    }
    
    static boolean b(final aB ab, final Graphics2D graphics2D) {
        return ab.isSelected() && hk.b(graphics2D);
    }
    
    static boolean e(final Graphics2D graphics2D, final boolean b) {
        final Object renderingHint = graphics2D.getRenderingHint(hk.c);
        if (b) {
            return hk.e.equals(renderingHint);
        }
        return !hk.f.equals(renderingHint);
    }
    
    protected abstract byte calculatePath(final Point2D p0, final Point2D p1);
    
    public static final byte calculateClippingAndIntersection(final aB ab, final GeneralPath generalPath, final GeneralPath generalPath2, final Point2D point2D, final Point2D point2D2) {
        return ij.a(ab, generalPath, generalPath2, point2D, point2D2);
    }
    
    protected final void recalculateFeatures() {
        final boolean z = fj.z;
        final hC a = hC.a();
        final Point2D.Double h = a.h;
        final Point2D.Double g = a.g;
        this.h();
        this.pb &= 0xFFFFFFF3;
        this.pb |= (0xC & this.calculatePath(h, g));
        final PathIterator pathIterator = this.path.getPathIterator(null);
        boolean b = true;
        Label_0123: {
            if (pathIterator.isDone()) {
                b = false;
                if (!z) {
                    break Label_0123;
                }
            }
            this.mb = (float)h.x;
            this.jb = (float)h.y;
            this.bc = (float)g.x;
            this.ac = (float)g.y;
        }
        Label_0222: {
            if (b) {
                this.pb |= 0x2;
                if (!z) {
                    break Label_0222;
                }
            }
            this.pb &= 0xFFFFFFFD;
            final fL targetPort = this.getTargetPort();
            this.bc = (float)targetPort.a(this.getTargetRealizer());
            this.ac = (float)targetPort.b(this.getTargetRealizer());
            final fL sourcePort = this.getSourcePort();
            this.mb = (float)sourcePort.a(this.getSourceRealizer());
            this.jb = (float)sourcePort.b(this.getSourceRealizer());
        }
        this.rb = false;
    }
    
    public boolean hasVisiblePath() {
        return (this.pb & 0x3) == 0x3;
    }
    
    public Point2D getSourceIntersection() {
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        return new Point2D.Float(this.mb, this.jb);
    }
    
    public Point2D getTargetIntersection() {
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        return new Point2D.Float(this.bc, this.ac);
    }
    
    public boolean isReversedPathRenderingEnabled() {
        return this.fc;
    }
    
    public void setReversedPathRenderingEnabled(final boolean fc) {
        if (fc != this.fc) {
            this.fc = fc;
        }
    }
    
    public Color getLineColor() {
        return this.kb;
    }
    
    public void setLineColor(final Color kb) {
        this.kb = kb;
    }
    
    public static Color getSelectionColor() {
        return aB.wb;
    }
    
    public static void setSelectionColor(final Color wb) {
        aB.wb = wb;
    }
    
    public static void setHighlightedBendColor(final Color ub) {
        aB.ub = ub;
    }
    
    public static Color getHighlightedBendColor() {
        return aB.ub;
    }
    
    public dr getLineType() {
        return this.dc;
    }
    
    public void setLineType(final dr dc) {
        if (this.dc != dc) {
            if (this.dc.getLineWidth() != dc.getLineWidth() && (this.ib.c() != 0.0 || this.yb.c() != 0.0)) {
                this.setDirty();
            }
            this.dc = dc;
        }
    }
    
    public static void setSelectionStroke(final dr lb) {
        aB.lb = lb;
    }
    
    public static Stroke getSelectionStroke() {
        return aB.lb;
    }
    
    public h getArrow() {
        return this.yb;
    }
    
    public void setArrow(final h targetArrow) {
        this.setTargetArrow(targetArrow);
    }
    
    public h getTargetArrow() {
        return this.yb;
    }
    
    public void setTargetArrow(final h yb) {
        if (yb != this.yb) {
            if (this.yb.d() != yb.d() || this.yb.c() != yb.c()) {
                this.setDirty();
            }
            this.yb = yb;
        }
    }
    
    public h getSourceArrow() {
        return this.ib;
    }
    
    public void setSourceArrow(final h ib) {
        if (ib != this.ib) {
            if (this.ib.d() != ib.d() || this.ib.c() != ib.c()) {
                this.setDirty();
            }
            this.ib = ib;
        }
    }
    
    public void setLayer(final byte gc) {
        this.gc = gc;
    }
    
    public byte getLayer() {
        return this.gc;
    }
    
    public void setVisible(final boolean b) {
        if (b) {
            this.pb |= 0x1;
            if (!fj.z) {
                return;
            }
        }
        this.pb &= 0xFFFFFFFE;
    }
    
    public boolean isVisible() {
        return (this.pb & 0x1) == 0x1;
    }
    
    public boolean isPathClippedAtSource() {
        return (this.pb & 0x4) == 0x4;
    }
    
    public boolean isPathClippedAtTarget() {
        return (this.pb & 0x8) == 0x8;
    }
    
    public void setSelected(final boolean tb) {
        if (tb != this.tb) {
            this.tb = tb;
            final bu i = this.i();
            if (i != null) {
                i.e((Object)this.getEdge());
            }
            this.f();
        }
    }
    
    void f() {
    }
    
    public boolean isSelected() {
        return this.tb;
    }
    
    public void setDirty() {
        if (this.cc != null) {
            for (int i = this.cc.size() - 1; i >= 0; --i) {
                this.getLabel(i).setOffsetDirty();
            }
        }
        this.rb = true;
        this.h();
    }
    
    protected boolean isDirty() {
        return this.rb;
    }
    
    public GeneralPath getPath() {
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        return this.path;
    }
    
    public dy getMouseInputEditorProvider() {
        if (this instanceof dy) {
            return (dy)this;
        }
        return null;
    }
    
    public void addLabel(final aA aa) {
        aa.bindRealizer(this);
        if (this.cc == null) {
            this.cc = new ArrayList(1);
        }
        this.cc.add(aa);
    }
    
    public void removeLabel(final aA aa) {
        if (this.cc != null) {
            this.cc.remove(aa);
            this.rb = true;
        }
    }
    
    public void removeLabel(final int n) {
        if (this.cc == null) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: 0");
        }
        try {
            this.cc.remove(n);
            this.rb = true;
        }
        catch (IndexOutOfBoundsException ex) {
            throw new IndexOutOfBoundsException("Index: " + n + ", Size: " + this.cc.size());
        }
    }
    
    public aA getLabel() {
        if (this.labelCount() == 0) {
            this.addLabel(this.createEdgeLabel());
        }
        return this.getLabel(0);
    }
    
    public int labelCount() {
        return (this.cc != null) ? this.cc.size() : 0;
    }
    
    public aA getLabel(final int n) {
        if (this.cc == null) {
            throw new ArrayIndexOutOfBoundsException(0);
        }
        return this.cc.get(n);
    }
    
    public void setLabelText(final String text) {
        this.getLabel().setText(text);
    }
    
    public String getLabelText() {
        return this.getLabel().getText();
    }
    
    public aA createEdgeLabel() {
        return new aA();
    }
    
    public boolean contains(final double n, final double n2) {
        if ((this.pb & 0x2) == 0x0) {
            return false;
        }
        if (this.isDirty() || this.nb == null) {
            this.nb = this.b(this.nb);
        }
        final double n3 = this.nb.x - 5.0f;
        final double n4 = this.nb.y - 5.0f;
        final double n5 = n3 + this.nb.width + 10.0;
        final double n6 = n4 + this.nb.height + 10.0;
        if (n > n3 && n < n5 && n2 > n4 && n2 < n6) {
            final boolean b = this.containsSeg(n, n2) > 0;
            if (b) {
                if (this.getSourceIntersection().distanceSq(n, n2) < 25.0) {
                    return false;
                }
                if (this.getTargetIntersection().distanceSq(n, n2) < 25.0) {
                    return false;
                }
            }
            return b;
        }
        return false;
    }
    
    public int containsSeg(final double n, final double n2) {
        final boolean z = fj.z;
        int n3 = 1;
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        final PathIterator pathIterator = this.path.getPathIterator(null);
        if (pathIterator.isDone()) {
            return 0;
        }
        final float[] c = hC.a().c;
        pathIterator.currentSegment(c);
        pathIterator.next();
        float n4 = c[0];
        float n5 = c[1];
        double n6 = 0.0;
        while (!pathIterator.isDone()) {
            pathIterator.currentSegment(c);
            n6 = dcmpg(Line2D.ptSegDistSq(n4, n5, c[0], c[1], n, n2), 25.0);
            if (z) {
                return (int)n6;
            }
            if (n6 < 0) {
                return n3;
            }
            ++n3;
            pathIterator.next();
            n4 = c[0];
            n5 = c[1];
            if (z) {
                break;
            }
        }
        return (int)n6;
    }
    
    public void calcUnionRect(final Rectangle2D rectangle2D) {
        if (this.isDirty() || this.nb == null) {
            this.nb = this.b(this.nb);
        }
        e.a(rectangle2D, this.nb, rectangle2D);
    }
    
    public boolean pathIntersects(final Rectangle2D rectangle2D, final boolean b) {
        final boolean z = fj.z;
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        if (this.nb != null && !this.nb.intersects(rectangle2D)) {
            return false;
        }
        final PathIterator pathIterator = this.path.getPathIterator(null);
        if (pathIterator.isDone()) {
            return false;
        }
        final float[] c = hC.a().c;
        pathIterator.currentSegment(c);
        pathIterator.next();
        float n = c[0];
        float n2 = c[1];
        while (true) {
            while (!pathIterator.isDone()) {
                pathIterator.currentSegment(c);
                final boolean intersectsLine = rectangle2D.intersectsLine(n, n2, c[0], c[1]);
                if (z) {
                    boolean visible = false;
                    if (intersectsLine) {
                        int i = this.labelCount() - 1;
                        while (i >= 0) {
                            final aA label = this.getLabel(i);
                            visible = label.isVisible();
                            if (z) {
                                break;
                            }
                            if (visible && (label.getText().length() != 0 || label.getIcon() != null)) {
                                final y.d.y box = label.getBox();
                                if (rectangle2D.intersects(box.c, box.d, box.a, box.b)) {
                                    return true;
                                }
                            }
                            --i;
                            if (z) {
                                break;
                            }
                        }
                    }
                    return visible;
                }
                if (intersectsLine) {
                    return true;
                }
                pathIterator.next();
                n = c[0];
                n2 = c[1];
                if (z) {
                    break;
                }
            }
            continue;
        }
    }
    
    void h() {
        this.nb = null;
    }
    
    public boolean intersects(final Rectangle2D rectangle2D) {
        final boolean z = fj.z;
        if (!this.isDirty() && this.nb != null) {
            return this.nb.intersects(rectangle2D);
        }
        if (this.bends.size() > 0) {
            p p = this.bends.k();
            while (p != null) {
                final x x = (x)p.c();
                if (rectangle2D.contains(x.b(), x.c())) {
                    return true;
                }
                p = p.a();
                if (z) {
                    break;
                }
            }
        }
        if (rectangle2D.contains(this.getTargetIntersection())) {
            return true;
        }
        if (rectangle2D.contains(this.getSourceIntersection())) {
            return true;
        }
        this.nb = this.b(this.nb);
        return this.nb.intersects(rectangle2D);
    }
    
    Rectangle2D.Float b(Rectangle2D.Float float1) {
        final boolean z = fj.z;
        final Point2D targetIntersection = this.getTargetIntersection();
        float1 = new Rectangle2D.Float((float)targetIntersection.getX(), (float)targetIntersection.getY(), 1.0f, 1.0f);
        if (this.isDirty()) {
            this.recalculateFeatures();
        }
        final Rectangle2D bounds2D = this.path.getBounds2D();
        if (bounds2D.getWidth() > 0.0 || bounds2D.getHeight() > 0.0) {
            float1.add(bounds2D);
        }
        double n = float1.getX();
        double max = n + float1.getWidth();
        double n2 = float1.getY();
        double max2 = n2 + float1.getHeight();
        int i = this.labelCount() - 1;
        while (i >= 0) {
            final aA label = this.getLabel(i);
            if (z) {
                return float1;
            }
            if (label.isVisible() && (label.getText().length() != 0 || label.getIcon() != null)) {
                final y.d.y box = label.getBox();
                max = Math.max(box.c + box.a, max);
                n = Math.min(box.c, n);
                max2 = Math.max(box.d + box.b, max2);
                n2 = Math.min(box.d, n2);
            }
            --i;
            if (z) {
                break;
            }
        }
        float1.setFrame(n, n2, max - n, max2 - n2);
        return float1;
    }
    
    public void write(final ObjectOutputStream objectOutputStream) {
        final boolean z = fj.z;
        objectOutputStream.writeByte(6);
        objectOutputStream.writeInt(this.bends.size());
        final y bends = this.bends();
        while (true) {
            while (bends.f()) {
                objectOutputStream.writeFloat((float)bends.a().b());
                objectOutputStream.writeFloat((float)bends.a().c());
                bends.g();
                if (z) {
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
                    int i = 0;
                    while (i < this.labelCount()) {
                        this.getLabel(i).write(objectOutputStream);
                        ++i;
                        if (z) {
                            return;
                        }
                        if (z) {
                            break;
                        }
                    }
                    objectOutputStream.writeBoolean(this.isVisible());
                    objectOutputStream.writeBoolean(this.fc);
                    return;
                }
                if (z) {
                    break;
                }
            }
            objectOutputStream.writeObject(this.getLineColor());
            objectOutputStream.writeByte(this.getArrow().a());
            continue;
        }
    }
    
    public void read(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final byte byte1 = objectInputStream.readByte();
        Label_0114: {
            switch (byte1) {
                case 0: {
                    this.b(objectInputStream);
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 1: {
                    this.c(objectInputStream);
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 2: {
                    this.d(objectInputStream);
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 3: {
                    this.e(objectInputStream);
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 4: {
                    this.f(objectInputStream);
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 5: {
                    this.f(objectInputStream);
                    this.setVisible(objectInputStream.readBoolean());
                    if (z) {
                        break Label_0114;
                    }
                    return;
                }
                case 6: {
                    this.f(objectInputStream);
                    this.setVisible(objectInputStream.readBoolean());
                    this.fc = objectInputStream.readBoolean();
                    if (z) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new a(byte1);
    }
    
    void f(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final int int1 = objectInputStream.readInt();
        byte byte1 = 0;
        while (true) {
            while (byte1 < int1) {
                this.appendBend(objectInputStream.readFloat(), objectInputStream.readFloat());
                ++byte1;
                if (z) {
                    Label_0101: {
                        if (byte1 != 0) {
                            this.setArrow(h.a(byte1));
                            if (!z) {
                                break Label_0101;
                            }
                        }
                        final h a = h.a((String)objectInputStream.readObject());
                        if (a != null) {
                            this.setArrow(a);
                        }
                    }
                    final byte byte2 = objectInputStream.readByte();
                    Label_0146: {
                        if (byte2 != 0) {
                            this.setSourceArrow(h.a(byte2));
                            if (!z) {
                                break Label_0146;
                            }
                        }
                        final h a2 = h.a((String)objectInputStream.readObject());
                        if (a2 != null) {
                            this.setSourceArrow(a2);
                        }
                    }
                    this.dc = dr.a(objectInputStream);
                    try {
                        (this.sb = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                        this.setSourcePort(this.sb);
                        (this.ec = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                        this.setTargetPort(this.ec);
                    }
                    catch (IllegalAccessException ex) {
                        throw new a("Could not construct Port!");
                    }
                    catch (InstantiationException ex2) {
                        throw new a("Could not instantiate Port!");
                    }
                    final int int2 = objectInputStream.readInt();
                    int i = 0;
                    while (i < int2) {
                        final aA edgeLabel = this.createEdgeLabel();
                        this.addLabel(edgeLabel);
                        edgeLabel.read(objectInputStream);
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            this.setLineColor((Color)objectInputStream.readObject());
            byte1 = objectInputStream.readByte();
            continue;
        }
    }
    
    void e(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final int int1 = objectInputStream.readInt();
        byte byte1 = 0;
        while (true) {
            while (byte1 < int1) {
                this.appendBend(objectInputStream.readFloat(), objectInputStream.readFloat());
                ++byte1;
                if (z) {
                    Label_0101: {
                        if (byte1 != 0) {
                            this.setArrow(h.a(byte1));
                            if (!z) {
                                break Label_0101;
                            }
                        }
                        final h a = h.a((String)objectInputStream.readObject());
                        if (a != null) {
                            this.setArrow(a);
                        }
                    }
                    final byte byte2 = objectInputStream.readByte();
                    Label_0146: {
                        if (byte2 != 0) {
                            this.setSourceArrow(h.a(byte2));
                            if (!z) {
                                break Label_0146;
                            }
                        }
                        final h a2 = h.a((String)objectInputStream.readObject());
                        if (a2 != null) {
                            this.setSourceArrow(a2);
                        }
                    }
                    this.dc = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                    try {
                        (this.sb = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                        this.setSourcePort(this.sb);
                        (this.ec = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                        this.setTargetPort(this.ec);
                    }
                    catch (IllegalAccessException ex) {
                        throw new a("Could not construct Port!");
                    }
                    catch (InstantiationException ex2) {
                        throw new a("Could not instantiate Port!");
                    }
                    final int int2 = objectInputStream.readInt();
                    int i = 0;
                    while (i < int2) {
                        final aA edgeLabel = this.createEdgeLabel();
                        this.addLabel(edgeLabel);
                        edgeLabel.read(objectInputStream);
                        ++i;
                        if (z) {
                            break;
                        }
                    }
                    return;
                }
                if (z) {
                    break;
                }
            }
            this.setLineColor((Color)objectInputStream.readObject());
            byte1 = objectInputStream.readByte();
            continue;
        }
    }
    
    void d(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final int int1 = objectInputStream.readInt();
        int i = 0;
        while (true) {
            while (i < int1) {
                this.appendBend(objectInputStream.readFloat(), objectInputStream.readFloat());
                ++i;
                if (z) {
                    byte byte1 = 0;
                    while (true) {
                        while (byte1 < i) {
                            final aA edgeLabel = this.createEdgeLabel();
                            this.addLabel(edgeLabel);
                            edgeLabel.read(objectInputStream);
                            ++byte1;
                            if (z) {
                                Label_0149: {
                                    if (byte1 != 0) {
                                        this.setArrow(h.a(byte1));
                                        if (!z) {
                                            break Label_0149;
                                        }
                                    }
                                    final h a = h.a((String)objectInputStream.readObject());
                                    if (a != null) {
                                        this.setArrow(a);
                                    }
                                }
                                final byte byte2 = objectInputStream.readByte();
                                Label_0197: {
                                    if (byte2 != 0) {
                                        this.setSourceArrow(h.a(byte2));
                                        if (!z) {
                                            break Label_0197;
                                        }
                                    }
                                    final h a2 = h.a((String)objectInputStream.readObject());
                                    if (a2 != null) {
                                        this.setSourceArrow(a2);
                                    }
                                }
                                this.dc = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                                try {
                                    (this.sb = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                                    this.setSourcePort(this.sb);
                                    (this.ec = (fL)Class.forName(y.e.h.b((String)objectInputStream.readObject())).newInstance()).a(objectInputStream);
                                    this.setTargetPort(this.ec);
                                }
                                catch (IllegalAccessException ex) {
                                    throw new a("Could not construct Port!");
                                }
                                catch (InstantiationException ex2) {
                                    throw new a("Could not instantiate Port!");
                                }
                                return;
                            }
                            if (z) {
                                break;
                            }
                        }
                        this.setLineColor((Color)objectInputStream.readObject());
                        byte1 = objectInputStream.readByte();
                        continue;
                    }
                }
                if (z) {
                    break;
                }
            }
            i = objectInputStream.readInt();
            continue;
        }
    }
    
    void c(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final int int1 = objectInputStream.readInt();
        int i = 0;
        while (true) {
            while (i < int1) {
                this.appendBend(objectInputStream.readFloat(), objectInputStream.readFloat());
                ++i;
                if (z) {
                    byte byte1 = 0;
                    while (true) {
                        while (byte1 < i) {
                            final aA edgeLabel = this.createEdgeLabel();
                            edgeLabel.read(objectInputStream);
                            this.addLabel(edgeLabel);
                            ++byte1;
                            if (z) {
                                Label_0149: {
                                    if (byte1 != 0) {
                                        this.setArrow(h.a(byte1));
                                        if (!z) {
                                            break Label_0149;
                                        }
                                    }
                                    final h a = h.a((String)objectInputStream.readObject());
                                    if (a != null) {
                                        this.setArrow(a);
                                    }
                                }
                                final byte byte2 = objectInputStream.readByte();
                                Label_0197: {
                                    if (byte2 != 0) {
                                        this.setSourceArrow(h.a(byte2));
                                        if (!z) {
                                            break Label_0197;
                                        }
                                    }
                                    final h a2 = h.a((String)objectInputStream.readObject());
                                    if (a2 != null) {
                                        this.setSourceArrow(a2);
                                    }
                                }
                                this.dc = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                                try {
                                    Label_0283: {
                                        if (objectInputStream.readBoolean()) {
                                            this.sb = new fL();
                                            if (!z) {
                                                break Label_0283;
                                            }
                                        }
                                        String s = (String)objectInputStream.readObject();
                                        if (s.startsWith("y.graph")) {
                                            s = "y.view.Port";
                                        }
                                        (this.sb = (fL)Class.forName(s).newInstance()).a(objectInputStream);
                                    }
                                    Label_0354: {
                                        if (objectInputStream.readBoolean()) {
                                            this.ec = new fL();
                                            if (!z) {
                                                break Label_0354;
                                            }
                                        }
                                        String s2 = (String)objectInputStream.readObject();
                                        if (s2.startsWith("y.graph")) {
                                            s2 = "y.view.Port";
                                        }
                                        (this.ec = (fL)Class.forName(s2).newInstance()).a(objectInputStream);
                                    }
                                    this.setPorts(this.sb, this.ec);
                                }
                                catch (IllegalAccessException ex) {
                                    throw new a("Could not construct Port!");
                                }
                                catch (InstantiationException ex2) {
                                    throw new a("Could not instantiate Port!");
                                }
                                return;
                            }
                            if (z) {
                                break;
                            }
                        }
                        this.setLineColor((Color)objectInputStream.readObject());
                        byte1 = objectInputStream.readByte();
                        continue;
                    }
                }
                if (z) {
                    break;
                }
            }
            i = objectInputStream.readInt();
            continue;
        }
    }
    
    void b(final ObjectInputStream objectInputStream) {
        final boolean z = fj.z;
        final int int1 = objectInputStream.readInt();
        int i = 0;
        while (true) {
            while (i < int1) {
                final aB ab = this;
                if (z) {
                    final aA edgeLabel = ab.createEdgeLabel();
                    edgeLabel.read(objectInputStream);
                    this.addLabel(edgeLabel);
                    this.setLineColor((Color)objectInputStream.readObject());
                    final byte byte1 = objectInputStream.readByte();
                    Label_0119: {
                        if (byte1 != 0) {
                            this.setArrow(h.a(byte1));
                            if (!z) {
                                break Label_0119;
                            }
                        }
                        final h a = h.a((String)objectInputStream.readObject());
                        if (a != null) {
                            this.setArrow(a);
                        }
                    }
                    this.dc = dr.a(objectInputStream.readByte(), objectInputStream.readByte());
                    try {
                        Label_0205: {
                            if (objectInputStream.readBoolean()) {
                                this.sb = new fL();
                                if (!z) {
                                    break Label_0205;
                                }
                            }
                            String s = (String)objectInputStream.readObject();
                            if (s.startsWith("y.graph")) {
                                s = "y.view.Port";
                            }
                            (this.sb = (fL)Class.forName(s).newInstance()).a(objectInputStream);
                        }
                        Label_0276: {
                            if (objectInputStream.readBoolean()) {
                                this.ec = new fL();
                                if (!z) {
                                    break Label_0276;
                                }
                            }
                            String s2 = (String)objectInputStream.readObject();
                            if (s2.startsWith("y.graph")) {
                                s2 = "y.view.Port";
                            }
                            (this.ec = (fL)Class.forName(s2).newInstance()).a(objectInputStream);
                        }
                        this.setPorts(this.sb, this.ec);
                    }
                    catch (IllegalAccessException ex) {
                        throw new a("Could not construct Port!");
                    }
                    catch (InstantiationException ex2) {
                        throw new a("Could not instantiate Port!");
                    }
                    return;
                }
                this.appendBend(objectInputStream.readFloat(), objectInputStream.readFloat());
                ++i;
                if (z) {
                    break;
                }
            }
            final aB ab = this;
            continue;
        }
    }
    
    static {
        aB.wb = Color.orange;
        aB.lb = dr.e;
        aB.ub = Color.green;
    }
}
