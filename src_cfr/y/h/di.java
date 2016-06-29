/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.o;
import y.c.q;
import y.d.t;
import y.h.a.v;
import y.h.aB;
import y.h.aC;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.ch;
import y.h.dJ;
import y.h.dN;
import y.h.dO;
import y.h.dU;
import y.h.eU;
import y.h.fL;
import y.h.fj;
import y.h.gU;
import y.h.gX;
import y.h.gn;
import y.h.gy;
import y.h.ic;
import y.h.x;

public class dI
extends gX {
    double a;
    double b;
    protected fL c;
    dN d;
    protected D e;
    fj f;
    aB g;
    private boolean h = true;
    private boolean i;
    private boolean j;
    private dO k = new dO();
    private boolean l;
    private t m;
    private double n = 10.0;
    private t o;
    private boolean p = true;
    private boolean q = true;
    private boolean r = true;
    private boolean s = true;
    private t t;
    private boolean u;
    private dU v = new dU(null);
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;
    private o A;
    private PropertyChangeListener B;
    private int C = 2;
    private final Ellipse2D D = new Ellipse2D.Double();

    public dI() {
        this(null);
    }

    public dI(gU gU2) {
        super(gU2);
        this.v.b(false);
        this.v.d(false);
        this.v.c(true);
        this.v.g(true);
        this.v.b(10.0);
        this.v.c(20.0);
        this.B = new dJ(this);
    }

    public void a(boolean bl2) {
        this.w = bl2;
    }

    public boolean a() {
        return this.p;
    }

    public boolean c() {
        return this.q;
    }

    public int e() {
        return this.C;
    }

    protected boolean a(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & this.e()) == 0) return false;
        return true;
    }

    public boolean f() {
        return this.j;
    }

    @Override
    protected cW getHitInfo(double d2, double d3) {
        cW cW2 = new cW(this.view, d2, d3, true, 0);
        this.setLastHitInfo(cW2);
        return cW2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void mousePressedLeft(double var1_1, double var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    private void j() {
        this.view.removeDrawable(this.k);
        this.k.j();
        this.k();
        if (this.l) {
            this.getGraph2D().s();
            this.l = false;
        }
        if (this.isEditing()) {
            this.setEditing(false);
        }
        this.reactivateParent();
    }

    private void a(byte by2) {
        double d2;
        double d3;
        double d4;
        boolean bl2;
        double d5;
        double d6;
        block8 : {
            bl2 = fj.z;
            double d7 = this.f.getCenterY();
            d2 = this.f.getCenterX();
            if (by2 == 1) {
                block7 : {
                    d5 = this.v.m();
                    if (d5 <= 0.0) return;
                    if (this.f.getWidth() / d5 >= 40.0) return;
                    d4 = this.f.getY() - 5.0;
                    d6 = this.f.getY() + this.f.getHeight() + 5.0;
                    for (d3 = d2; d3 > this.f.getX(); d3 -= d5) {
                        this.v.a(new gy(1, 16, new t(d3, d7), d4, d6, this.f, 0.01));
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    d3 = d2 + d5;
                }
                do {
                    if (d3 >= this.f.getX() + this.f.getWidth()) return;
                    this.v.a(new gy(1, 16, new t(d3, d7), d4, d6, this.f, 0.01));
                    d3 += d5;
                } while (!bl2);
            }
            if ((d5 = this.v.m()) <= 0.0) return;
            if (this.f.getHeight() / d5 >= 40.0) return;
            d4 = this.f.getX() - 5.0;
            d6 = this.f.getX() + this.f.getWidth() + 5.0;
            for (d3 = d7; d3 > this.f.getY(); d3 -= d5) {
                this.v.a(new gy(0, 16, new t(d2, d3), d4, d6, this.f, 0.01));
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block8;
            }
            d3 = d7 + d5;
        }
        do {
            if (d3 >= this.f.getY() + this.f.getHeight()) return;
            this.v.a(new gy(0, 16, new t(d2, d3), d4, d6, this.f, 0.01));
            d3 += d5;
        } while (!bl2);
    }

    protected aB a(aB aB2) {
        return aB2.createCopy();
    }

    protected fj a(fj fj2) {
        return fj2.createCopy();
    }

    protected fj a(double d2, double d3) {
        gn gn2 = new gn();
        gn2.setSize(0.1, 0.1);
        gn2.setVisible(false);
        gn2.setCenter(d2, d3);
        gn2.setShapeType(0);
        return gn2;
    }

    private void a(fj fj2, d d2) {
        double d3;
        boolean bl2 = fj.z;
        this.view.getGraph2D();
        if (this.d != null) {
            this.view.removeDrawable(this.d);
        }
        if ((d3 = this.view.getGridResolution()) <= 0.0) {
            d3 = 20.0;
        }
        this.e = this.a(fj2.getNode(), d2, d3);
        Rectangle2D.Double double_ = new Rectangle2D.Double(fj2.getX() - 10.0, fj2.getY() - 10.0, fj2.getWidth() + 20.0, fj2.getHeight() + 20.0);
        C c2 = this.e.m();
        while (c2.f()) {
            t t2 = (t)c2.d();
            Rectangle2D.Double double_2 = new Rectangle2D.Double(t2.a - 10.0, t2.b - 10.0, 20.0, 20.0);
            double_.add(double_2);
            c2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d = new dN(this, this.e, double_, fj2.getNode(), d2);
        this.view.addDrawable(this.d);
        this.view.updateView();
    }

    protected D a(q q2, d d2, double d3) {
        if (!this.p) {
            return this.a(q2, d2);
        }
        if (!this.c()) return this.view.getGraph2D().t(q2).getPortCandidates(d3);
        return this.b(q2, d2);
    }

    private D b(q q2, d d2) {
        D d3;
        boolean bl2 = fj.z;
        D d4 = new D();
        fj fj2 = this.view.getGraph2D().t(q2);
        if (fj2.portCount() > 0) {
            Iterator iterator = fj2.ports();
            while (iterator.hasNext()) {
                d3 = d4;
                if (bl2) return d3;
                d3.add(((eU)iterator.next()).h());
                if (!bl2) continue;
            }
        }
        d3 = d4;
        return d3;
    }

    protected D a(q q2, d d2) {
        double d3;
        double d4;
        D d5 = new D();
        fj fj2 = this.view.getGraph2D().t(q2);
        if (fj2.contains(d4 = fj2.getCenterX(), d3 = fj2.getCenterY())) {
            d5.add(new t(d4, d3));
            Point2D.Double double_ = new Point2D.Double();
            if (fj2.findIntersection(d4, d3, fj2.getX() - 10.0, d3, double_)) {
                d5.add(new t(double_.x, double_.y));
            }
            if (fj2.findIntersection(d4, d3, fj2.getX() + fj2.getWidth() + 10.0, d3, double_)) {
                d5.add(new t(double_.x, double_.y));
            }
            if (fj2.findIntersection(d4, d3, d4, fj2.getY() - 10.0, double_)) {
                d5.add(new t(double_.x, double_.y));
            }
            if (fj2.findIntersection(d4, d3, d4, fj2.getY() + fj2.getHeight() + 10.0, double_)) {
                d5.add(new t(double_.x, double_.y));
            }
        }
        if (this.i && d2.c() == q2) {
            d5.add(this.o);
        }
        if (this.i) return d5;
        if (d2.d() != q2) return d5;
        d5.add(this.o);
        return d5;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void mouseDraggedLeft(double var1_1, double var3_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:420)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:219)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:619)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:45)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:681)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    protected t a(double d2, double d3, boolean bl2, boolean bl3) {
        if (bl3) {
            if (this.v.l()) {
                this.v.h();
            }
            this.m = this.a(d2, d3, Double.MAX_VALUE);
            if (this.m == null) return new t(d2, d3);
            return this.m;
        }
        this.m = null;
        if (bl2) {
            if (!this.v.l()) return new t(d2, d3);
            this.v.h();
            return new t(d2, d3);
        }
        t t2 = this.a(d2, d3, this.n);
        if (t2 != null) {
            this.m = t2;
            return t2;
        }
        if (this.v.l()) {
            t t3 = this.v.b(new t(d2, d3));
            d2 = t3.a;
            d3 = t3.b;
            return t3;
        }
        double d4 = this.n / this.view.getZoom();
        if (!this.s) return new t(d2, d3);
        return this.a(d2, d3, d4, this.f, this.t);
    }

    private t a(double d2, double d3, double d4) {
        t t2;
        boolean bl2 = fj.z;
        t t3 = new t(d2, d3);
        t t4 = null;
        double d5 = d4;
        if (d5 < Double.MAX_VALUE) {
            d5 /= this.view.getZoom();
        }
        C c2 = this.e.m();
        while (c2.f()) {
            t t5 = (t)c2.d();
            t2 = t3;
            if (bl2) return t2;
            double d6 = t.a(t2, t5);
            if (d6 < d5) {
                d5 = d6;
                t4 = t5;
            }
            c2.g();
            if (!bl2) continue;
        }
        t2 = t4;
        return t2;
    }

    protected q b(double d2, double d3) {
        if (this.i) {
            if (!this.c.d().getSourceRealizer().contains(d2, d3)) return this.c(d2, d3).i();
            return this.c.d().getEdge().c();
        }
        if (!this.c.d().getTargetRealizer().contains(d2, d3)) return this.c(d2, d3).i();
        return this.c.d().getEdge().d();
    }

    protected cW c(double d2, double d3) {
        return this.b(d2, d3, 4, true);
    }

    /*
     * Unable to fully structure code
     */
    protected void d(double var1_1, double var3_2) {
        block3 : {
            var7_3 = fj.z;
            if (!this.k.i()) ** GOTO lbl-1000
            var5_4 = this.getGraph2D();
            var6_5 = this.c.d();
            if (var7_3) lbl-1000: // 2 sources:
            {
                var5_4 = this.k;
                var6_5 = this.k.i(this.k.l());
            }
            if (this.i) {
                var5_4.c(var6_5.getEdge(), new t(var1_1, var3_2));
                if (!var7_3) break block3;
            }
            var5_4.d(var6_5.getEdge(), new t(var1_1, var3_2));
        }
        if (this.u == false) return;
        ic.a(this.view, var6_5, var1_1, var3_2, this.i);
    }

    private t a(double d2, double d3, double d4, fj fj2, t t2) {
        double d5;
        t t3;
        double d6;
        double d7;
        t t4 = null;
        boolean bl2 = fj2.contains(d2, d3);
        double d8 = d2;
        double d9 = d3;
        if (this.r) {
            d6 = t2.a - d2;
            if (Math.abs(d6) < d4) {
                d2 = t2.a;
            }
            if (Math.abs(d7 = t2.b - d3) < d4) {
                d3 = t2.b;
            }
        }
        if (this.s && (d5 = Math.sqrt((d6 = d2 - t2.a) * d6 + (d7 = d3 - t2.b) * d7)) > 0.0) {
            boolean bl3 = fj2.contains(d2, d3);
            double d10 = d2 - d4 * d6 / d5;
            double d11 = d3 - d4 * d7 / d5;
            if (fj2.contains(d10, d11) != bl3) {
                Point2D.Double double_ = new Point2D.Double();
                if (bl3) {
                    if (fj2.findIntersection(d2, d3, d10, d11, double_)) {
                        t4 = new t(double_.x, double_.y);
                    }
                } else if (fj2.findIntersection(d10, d11, d2, d3, double_)) {
                    t4 = new t(double_.x, double_.y);
                }
            } else {
                double d12 = d2 + d4 * d6 / d5;
                double d13 = d3 + d4 * d7 / d5;
                if (fj2.contains(d12, d13) != bl3) {
                    Point2D.Double double_ = new Point2D.Double();
                    if (bl3) {
                        if (fj2.findIntersection(d2, d3, d12, d13, double_)) {
                            t4 = new t(double_.x, double_.y);
                        }
                    } else if (fj2.findIntersection(d12, d13, d2, d3, double_)) {
                        t4 = new t(double_.x, double_.y);
                    }
                }
            }
        }
        if (t4 == null && bl2 && (d8 != d2 || d9 != d3) && !fj2.contains(d2, d3)) {
            return new t(d8, d9);
        }
        if (t4 != null) {
            t3 = t4;
            return t3;
        }
        t3 = new t(d2, d3);
        return t3;
    }

    protected boolean a(d d2) {
        return aC.b(d2, this.getGraph2D());
    }

    @Override
    public void mouseShiftReleasedLeft(double d2, double d3) {
        if (this.h) {
            this.mouseReleasedLeft(d2, d3);
            if (!fj.z) return;
        }
        this.a(d2, d3, this.y);
    }

    private void k() {
        if (this.v != null) {
            this.v.f();
        }
        this.view.setViewCursor(this.i());
        this.view.setDrawingMode(0);
        this.view.removeDrawable(this.d);
        this.d = null;
        this.setEditing(false);
        bu bu2 = this.getGraph2D();
        if (this.A != null) {
            bu2.b(this.A);
            this.A = null;
        }
        this.view.removePropertyChangeListener("Graph2D", this.B);
        bu2.T();
    }

    private void l() {
        d d2;
        block6 : {
            q q2;
            q q3;
            q q4;
            boolean bl2 = fj.z;
            if (!this.f()) return;
            bu bu2 = this.getGraph2D();
            v v2 = bu2.C();
            d2 = this.c.d().getEdge();
            if (this.i) {
                block5 : {
                    if (this.c.d().getSourceRealizer() == this.f) return;
                    q4 = this.f.getNode();
                    q2 = d2.d();
                    if (v2 != null && v2.e(d2)) {
                        q3 = v2.c(d2);
                        v2.d(d2).b("HierarchyManager.InterEdgeData.SOURCE_PORT");
                        v2.a(d2, q4, q3);
                        if (!bl2) break block5;
                    }
                    bu2.a(d2, q4, q2);
                }
                this.b(d2);
                if (!bl2) return;
            }
            if (this.c.d().getTargetRealizer() == this.f) return;
            q4 = this.f.getNode();
            q2 = d2.c();
            if (v2 != null && v2.e(d2)) {
                q3 = v2.b(d2);
                v2.d(d2).b("HierarchyManager.InterEdgeData.TARGET_PORT");
                v2.a(d2, q3, q4);
                if (!bl2) break block6;
            }
            bu2.a(d2, q2, q4);
        }
        this.b(d2);
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        this.mouseReleasedLeft(d2, d3);
    }

    @Override
    public void mouseShiftReleasedRight(double d2, double d3) {
        this.mouseShiftReleasedLeft(d2, d3);
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.a(d2, d3, !this.y);
    }

    private void a(double d2, double d3, boolean bl2) {
        if (this.c != null) {
            t t2 = this.a(d2, d3, this.a(this.lastReleaseEvent), bl2);
            d2 = t2.a;
            d3 = t2.b;
            this.d(d2, d3);
            this.l();
            this.m();
            this.d(d2, d3);
            this.a(this.c, d2, d3);
            this.k();
        }
        if (this.l) {
            this.getGraph2D().s();
            this.l = false;
        }
        if (this.isEditing()) {
            this.setEditing(false);
        }
        this.reactivateParent();
    }

    protected void b(d d2) {
    }

    protected void a(fL fL2) {
    }

    protected void a(fL fL2, double d2, double d3) {
        if (!this.a()) return;
        if (!this.c()) return;
        aB aB2 = fL2.d();
        eU eU2 = this.e(d2, d3);
        if (eU2 == null) return;
        if (this.i) {
            eU2.a(aB2);
            if (!fj.z) return;
        }
        eU2.c(aB2);
    }

    private eU e(double d2, double d3) {
        return eU.a(this.f, d2, d3);
    }

    private void m() {
        aB aB2;
        block3 : {
            boolean bl2 = fj.z;
            if (this.k.i()) return;
            aB aB3 = this.k.i(this.k.l());
            for (int i2 = 0; i2 < aB3.bendCount(); ++i2) {
                x x2 = aB3.getBend(i2);
                aB2 = this.g;
                if (!bl2) {
                    if (aB2.bendCount() <= i2) {
                        this.g.addPoint(x2.b(), x2.c());
                        if (!bl2) continue;
                    }
                    this.g.getBend(i2).a(x2.b(), x2.c());
                    if (!bl2) continue;
                }
                break block3;
            }
            aB2 = this.g;
        }
        aB2.setVisible(true);
        this.view.removeDrawable(this.k);
        this.k.j();
    }

    protected void a(Graphics2D graphics2D, t t2, q q2, d d2) {
        this.a(graphics2D, t2, q2, d2, this.g() || !this.isModifierPressed(this.lastDragEvent) ^ this.y, t2.equals(this.m));
    }

    /*
     * Unable to fully structure code
     */
    protected void a(Graphics2D var1_1, t var2_2, q var3_3, d var4_4, boolean var5_5, boolean var6_6) {
        var7_7 = fj.z;
        if (!var5_5) ** GOTO lbl-1000
        if (!var6_6) ** GOTO lbl-1000
        var1_1.setColor(Color.green);
        if (var7_7) lbl-1000: // 2 sources:
        {
            var1_1.setColor(Color.red);
            ** if (!var7_7) goto lbl12
        }
        ** GOTO lbl12
lbl-1000: // 2 sources:
        {
            if (this.y) {
                return;
            }
            var1_1.setColor(Color.gray);
        }
lbl12: // 3 sources:
        this.D.setFrame(var2_2.a() - 3.0, var2_2.b() - 3.0, 6.0, 6.0);
        var1_1.fill(this.D);
        var1_1.setColor(Color.black);
        var1_1.draw(this.D);
    }

    public boolean g() {
        return this.h;
    }

    @Override
    public void cancelEditing() {
        if (!this.isEditing()) return;
        this.mouseReleasedLeft(this.a, this.b);
    }

    protected void a(Graphics2D graphics2D, fj fj2) {
        dI.b(graphics2D, fj2);
    }

    static void b(Graphics2D graphics2D, fj fj2) {
        int n2 = (int)fj2.getX();
        int n3 = (int)fj2.getY();
        int n4 = (int)fj2.getWidth();
        int n5 = (int)fj2.getHeight();
        dI.a(graphics2D, n2, n3, n4, n5);
    }

    static void a(Graphics2D graphics2D, int n2, int n3, int n4, int n5) {
        Color color = graphics2D.getColor();
        graphics2D.setColor(Color.black);
        dI.a(graphics2D, n2, n3, n4, n5, 5);
        dI.a(graphics2D, n2, n3, n4, n5, 3);
        graphics2D.setColor(Color.white);
        dI.a(graphics2D, n2, n3, n4, n5, 4);
        graphics2D.setColor(color);
    }

    private static void a(Graphics2D graphics2D, int n2, int n3, int n4, int n5, int n6) {
        int n7 = n2;
        int n8 = n3;
        graphics2D.drawLine(n7 - n6, n8 - n6, n7, n8 - n6);
        graphics2D.drawLine(n7 - n6, n8 - n6, n7 - n6, n8);
        graphics2D.drawLine(n7 + n6, n8 - n6, n7 += n4, n8 - n6);
        graphics2D.drawLine(n7 + n6, n8 - n6, n7 + n6, n8);
        n7 = n2;
        graphics2D.drawLine(n7 - n6, n8 + n6, n7, (n8 += n5) + n6);
        graphics2D.drawLine(n7 - n6, n8 + n6, n7 - n6, n8);
        graphics2D.drawLine(n7 + n6, n8 + n6, n7 += n4, n8 + n6);
        graphics2D.drawLine(n7 + n6, n8 + n6, n7 + n6, n8);
    }

    private Rectangle2D n() {
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        if (this.f == null) return double_;
        this.f.calcUnionRect(double_);
        return double_;
    }

    public Cursor h() {
        return Cursor.getPredefinedCursor(13);
    }

    public Cursor i() {
        return Cursor.getPredefinedCursor(0);
    }

    static o a(dI dI2) {
        return dI2.A;
    }

    static o a(dI dI2, o o2) {
        dI2.A = o2;
        return dI2.A;
    }

    static double b(dI dI2) {
        return dI2.n;
    }

    static t a(dI dI2, double d2, double d3, double d4, fj fj2, t t2) {
        return dI2.a(d2, d3, d4, fj2, t2);
    }

    static t a(dI dI2, double d2, double d3, double d4) {
        return dI2.a(d2, d3, d4);
    }

    static void c(dI dI2) {
        dI2.j();
    }

    static boolean d(dI dI2) {
        return dI2.z;
    }

    static Rectangle2D e(dI dI2) {
        return dI2.n();
    }
}

