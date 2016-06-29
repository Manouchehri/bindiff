/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import javax.swing.JComponent;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.o;
import y.d.t;
import y.d.y;
import y.g.e;
import y.g.q;
import y.h.G;
import y.h.H;
import y.h.I;
import y.h.J;
import y.h.K;
import y.h.L;
import y.h.a.v;
import y.h.aB;
import y.h.az;
import y.h.bu;
import y.h.cW;
import y.h.cZ;
import y.h.ch;
import y.h.dI;
import y.h.dU;
import y.h.eR;
import y.h.eU;
import y.h.ek;
import y.h.el;
import y.h.en;
import y.h.fL;
import y.h.fj;
import y.h.gU;
import y.h.gX;
import y.h.gn;
import y.h.x;

public class F
extends gX {
    private y.c.q a;
    private boolean b;
    private boolean c = true;
    private boolean d;
    private boolean e = true;
    private boolean f = true;
    private boolean g;
    private KeyListener h;
    private o i;
    private PropertyChangeListener j;
    private int k = 27;
    private L l;
    private y.c.q m;
    private y.c.q n;
    private d o;
    private boolean p;
    private boolean q;
    private boolean r;
    private double s;
    private boolean t;
    private int u;
    private boolean v;
    private List w;
    private List x;
    private boolean y;
    private dU z;
    private en A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private y.c.q F;
    private boolean G;
    private boolean H;
    private boolean I;
    private eU J;
    private eU K;
    private eU L;
    private int M;

    public F(gU gU2) {
        super(gU2);
        this.l = new L(this);
        this.t = true;
        this.u = 10;
        this.v = true;
        this.I = true;
        this.M = 2;
        this.g = false;
        this.j = new G(this);
    }

    public dU a() {
        if (this.z != null) return this.z;
        this.z = this.c();
        return this.z;
    }

    protected dU c() {
        dU dU2 = new dU(this.view);
        dU2.c(true);
        dU2.g(true);
        dU2.b(15.0);
        dU2.c(20.0);
        return dU2;
    }

    public F() {
        this(null);
    }

    @Override
    public void init() {
        this.c = true;
    }

    public boolean e() {
        return this.I;
    }

    public boolean f() {
        return this.D;
    }

    public void a(boolean bl2) {
        this.D = bl2;
    }

    public void a(double d2) {
        this.s = d2;
    }

    public void b(boolean bl2) {
        this.e = bl2;
    }

    @Override
    public void mousePressedLeft(double d2, double d3) {
        this.g = true;
        this.a(d2, d3, false);
    }

    @Override
    public void mouseShiftPressedLeft(double d2, double d3) {
        this.g = true;
        this.a(d2, d3, true);
    }

    /*
     * Exception decompiling
     */
    static int a(byte var0, fj var1_1) {
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

    void a(double d2, double d3, boolean bl2) {
        boolean bl3;
        double d4;
        double d5;
        dU dU2;
        block11 : {
            List<y.c.q> list;
            bl3 = fj.z;
            this.C = bl2;
            if (!this.c) return;
            this.F = null;
            this.L = null;
            this.J = null;
            this.K = null;
            bu bu2 = this.getGraph2D();
            this.a = this.a(d2, d3);
            if (this.a == null) {
                this.reactivateParent();
                return;
            }
            if (!this.d(this.a, d2, d3)) {
                this.c(this.a, d2, d3);
                return;
            }
            if (this.a(bu2, this.a)) {
                this.J = this.a(this.a, d2, d3);
                if (!this.b(this.a, this.J, d2, d3)) {
                    this.a(this.a, this.J, d2, d3);
                    return;
                }
            } else {
                this.J = null;
            }
            if (this.h == null) {
                this.h = new H(this);
                this.view.getCanvasComponent().addKeyListener(this.h);
            }
            if (this.i == null) {
                this.i = new I(this);
                bu2.a(this.i);
            }
            this.view.addPropertyChangeListener("Graph2D", this.j);
            this.l.j();
            this.F = null;
            this.L = null;
            this.view.addDrawable(this.l);
            this.setEditing(true);
            this.n = this.l.a(this.a(bu2.t(this.a)));
            this.m = this.l.a(this.b(d2, d3));
            this.o = this.l.a(this.n, this.m, this.g());
            this.d = false;
            bu2.b(1);
            this.view.setDrawingMode(3);
            this.b = true;
            this.c = false;
            this.p = true;
            this.q = false;
            fj fj2 = this.l.t(this.n);
            d4 = d2 - fj2.getCenterX();
            d5 = d3 - fj2.getCenterY();
            this.a(bu2);
            dU2 = this.a();
            dU2.a(this.view);
            List<y.c.q> list2 = Collections.EMPTY_LIST;
            List<y.c.q> list3 = list = dU2.n() ? Collections.singletonList(this.m) : list2;
            if (this.j() && this.f() || dU2.n()) {
                dU2.a(new t(d2, d3), list, list2, Collections.EMPTY_SET, q.a((Object)null));
                if (!bl3) break block11;
            }
            dU2.f();
        }
        if (this.j() && this.f()) {
            dU2.b(this.A);
            this.A = null;
        }
        if (this.J != null) {
            this.l.t(this.n).getPort(eU.e(this.J)).a(this.l.i(this.o));
            if (!bl3) return;
        }
        t t2 = this.a(bl2, this.a, d4, d5);
        this.l.i(this.o).getSourcePort().b(t2.a, t2.b);
    }

    protected y.c.q a(double d2, double d3) {
        if (!this.e()) return this.getHitInfo(d2, d3).i();
        cW cW2 = this.getHitInfo(d2, d3);
        if (cW2.t()) {
            return cW2.i();
        }
        if (!cW2.p()) return null;
        return cW2.o().b().getNode();
    }

    private void a(bu bu2) {
        block4 : {
            F f2;
            boolean bl2 = fj.z;
            if (!this.y) {
                this.x = null;
                this.w = null;
            }
            this.w = new ArrayList();
            y.c.x x2 = bu2.o();
            while (x2.f()) {
                fj fj2 = bu2.t(x2.e());
                f2 = this;
                if (!bl2) {
                    if (f2.view.getVisibleRect().intersects(fj2.getX(), fj2.getY(), fj2.getWidth(), fj2.getHeight())) {
                        this.w.add(fj2);
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                break block4;
            }
            e.a(this.w, (Comparator)new J(this));
            this.x = new ArrayList(this.w);
            f2 = this;
        }
        e.a(f2.x, (Comparator)new K(this));
    }

    private fj a(double d2, List list) {
        double d3;
        double d4;
        double d5;
        int n2;
        int n3;
        double d6;
        block6 : {
            boolean bl2 = fj.z;
            if (list == null) return null;
            if (list.size() <= 0) return null;
            n2 = 0;
            n3 = list.size() - 1;
            if (((fj)list.get(n2)).getCenterX() > d2) {
                return (fj)list.get(n2);
            }
            if (((fj)list.get(n3)).getCenterX() < d2) {
                return (fj)list.get(n3);
            }
            while (n2 < n3 - 1) {
                int n4 = (n2 + n3) / 2;
                fj fj2 = (fj)list.get(n4);
                d6 = fj2.getCenterX();
                d4 = d2;
                if (!bl2) {
                    if (d6 == d4) {
                        return fj2;
                    }
                    if (fj2.getCenterX() < d2) {
                        n2 = n4;
                        if (!bl2) continue;
                    }
                    n3 = n4;
                    if (!bl2) continue;
                }
                break block6;
            }
            d6 = ((fj)list.get(n2)).getCenterX();
            d4 = d2;
        }
        if ((d5 = Math.abs(d6 - d4)) >= (d3 = Math.abs(((fj)list.get(n3)).getCenterX() - d2))) return (fj)list.get(n3);
        return (fj)list.get(n2);
    }

    private fj b(double d2, List list) {
        double d3;
        double d4;
        double d5;
        int n2;
        int n3;
        double d6;
        block6 : {
            boolean bl2 = fj.z;
            if (list == null) return null;
            if (list.size() <= 0) return null;
            n2 = 0;
            n3 = list.size() - 1;
            if (((fj)list.get(n2)).getCenterY() > d2) {
                return (fj)list.get(n2);
            }
            if (((fj)list.get(n3)).getCenterY() < d2) {
                return (fj)list.get(n3);
            }
            while (n2 < n3 - 1) {
                int n4 = (n2 + n3) / 2;
                fj fj2 = (fj)list.get(n4);
                d6 = fj2.getCenterY();
                d4 = d2;
                if (!bl2) {
                    if (d6 == d4) {
                        return fj2;
                    }
                    if (fj2.getCenterY() < d2) {
                        n2 = n4;
                        if (!bl2) continue;
                    }
                    n3 = n4;
                    if (!bl2) continue;
                }
                break block6;
            }
            d6 = ((fj)list.get(n2)).getCenterY();
            d4 = d2;
        }
        if ((d5 = Math.abs(d6 - d4)) >= (d3 = Math.abs(((fj)list.get(n3)).getCenterY() - d2))) return (fj)list.get(n3);
        return (fj)list.get(n2);
    }

    protected t a(boolean bl2, y.c.q q2, double d2, double d3) {
        if (!bl2) return t.c;
        fj fj2 = this.getGraph2D().t(q2);
        double d4 = fj2.getCenterX() + d2;
        double d5 = fj2.getCenterY() + d3;
        double d6 = this.getGridX(d4) - fj2.getCenterX();
        double d7 = this.getGridY(d5) - fj2.getCenterY();
        return new t(d6, d7);
    }

    private boolean a(bu bu2, y.c.q q2) {
        if (!this.e()) return false;
        if (q2 == null) return false;
        if (bu2.t(q2).portCount() <= 0) return false;
        return true;
    }

    protected eU a(y.c.q q2, double d2, double d3) {
        return this.g(q2, d2, d3);
    }

    private eU g(y.c.q q2, double d2, double d3) {
        fj fj2 = this.view.getGraph2D().t(q2);
        return eU.a(fj2, d2, d3);
    }

    protected aB g() {
        return this.getGraph2D().G().createCopy();
    }

    protected aB h() {
        if (this.l == null) throw new IllegalStateException("EdgeRealizer not yet created!");
        if (this.l.g() >= 1) return this.l.i(this.o);
        throw new IllegalStateException("EdgeRealizer not yet created!");
    }

    protected fj a(fj fj2) {
        return fj2.createCopy();
    }

    protected fj b(double d2, double d3) {
        gn gn2 = new gn();
        gn2.setSize(0.1, 0.1);
        gn2.setVisible(false);
        gn2.setCenter(d2, d3);
        gn2.setShapeType(0);
        return gn2;
    }

    @Override
    public void mouseReleasedRight(double d2, double d3) {
        this.g = false;
        if (!this.p) {
            return;
        }
        bu bu2 = this.getGraph2D();
        aB aB2 = this.l.i(this.o);
        int n2 = aB2.bendCount();
        if (n2 > Math.max(aB2.getMinBendCount(), this.j() ? 1 : 0)) {
            this.a(aB2, n2 - 1);
            this.a(aB2);
            if (this.a().l()) {
                this.a().b(this.A);
                this.A = null;
                x x2 = this.h().lastBend();
                if (x2 != null) {
                    t t2 = this.a().k();
                    double d4 = d2 - t2.a;
                    double d5 = d3 - t2.b;
                    t t3 = new t(d2 - d4, d3 - d5);
                    boolean bl2 = this.B != (this.h().bendCount() % 2 == 1);
                    t t4 = bl2 ? new t(t3.a(), x2.c()) : new t(x2.b(), t3.b());
                    ek ek2 = new ek(null, t4, bl2 ? 1 : 2);
                    ek ek3 = new ek(null, t3, 3);
                    this.A = this.a().a(ek2, ek3);
                }
                this.a().h();
            }
            this.view.updateView();
            if (!fj.z) return;
        }
        this.n();
        bu2.T();
        this.reactivateParent();
    }

    protected void a(aB aB2, int n2) {
        aB2.removeBend(aB2.getBend(n2));
    }

    private void a(aB aB2) {
        fj fj2 = aB2.getTargetRealizer();
        fL fL2 = aB2.getTargetPort();
        this.a(fL2.a(fj2), fL2.b(fj2), aB2);
    }

    @Override
    public void mouseShiftReleasedLeft(double d2, double d3) {
        this.g = false;
        this.c(d2, d3, true);
    }

    @Override
    public void mouseReleasedLeft(double d2, double d3) {
        this.g = false;
        this.c(d2, d3, false);
    }

    public int i() {
        return this.M;
    }

    protected boolean a(MouseEvent mouseEvent) {
        if ((mouseEvent.getModifiers() & this.i()) == 0) return false;
        return true;
    }

    void c(double d2, double d3, boolean bl2) {
        Object object;
        Object object2;
        boolean bl3 = fj.z;
        if (!this.p) {
            return;
        }
        if (this.C != bl2) {
            this.C = bl2;
        }
        Point2D.Double double_ = new Point2D.Double(d2, d3);
        double_.x = this.getGridX(double_.x);
        double_.y = this.getGridY(double_.y);
        boolean bl4 = this.a(double_, this.h(), this.a(this.lastReleaseEvent));
        double d4 = double_.x;
        double d5 = double_.y;
        bu bu2 = this.getGraph2D();
        y.c.q q2 = this.d(d2, d3);
        aB aB2 = this.l.i(this.o);
        if (this.a(this.a, q2, double_.x, double_.y)) {
            if (!this.e) return;
            this.a(aB2, d4, d5);
            this.mouseMoved(d2, d3);
            if (this.a().l()) {
                this.a().b(this.A);
                this.A = null;
                object = this.h().lastBend();
                if (object != null) {
                    object2 = this.a().k();
                    double d6 = d2 - object2.a;
                    double d7 = d3 - object2.b;
                    t t2 = new t(double_.x - d6, double_.y - d7);
                    boolean bl5 = this.B != (this.h().bendCount() % 2 == 1);
                    t t3 = bl5 ? new t(t2.a(), object.c()) : new t(object.b(), t2.b());
                    ek ek2 = new ek(null, t3, bl5 ? 1 : 2);
                    ek ek3 = new ek(null, t2, 3);
                    this.A = this.a().a(ek2, ek3);
                    this.a().h();
                }
            }
            bu2.T();
            if (!bl3) return;
        }
        if (!this.q) {
            if (!this.k()) return;
            this.n();
            return;
        }
        if (this.a == q2 && !this.f) {
            return;
        }
        Object object3 = object2 = this.d ? this.a : q2;
        if (!this.f((y.c.q)object2, double_.x, double_.y)) {
            this.e((y.c.q)object2, double_.x, double_.y);
            return;
        }
        if (this.a(bu2, (y.c.q)object2)) {
            this.K = this.b((y.c.q)object2, d4, d5);
            if (!this.d((y.c.q)object2, this.K, d4, d5)) {
                this.c((y.c.q)object2, this.K, d4, d5);
                return;
            }
        } else {
            this.K = null;
        }
        this.view.removeDrawable(this.l);
        this.l.a(this.o);
        bu2.b(0);
        this.view.setDrawingMode(0);
        object = this.a(bu2, this.a, (y.c.q)object2, aB2);
        this.x = null;
        this.w = null;
        this.a().f();
        if (object != null) {
            block14 : {
                t t4;
                aB2 = bu2.i((d)object);
                fj fj2 = bu2.t((y.c.q)object2);
                double d8 = d4 - fj2.getCenterX();
                double d9 = d5 - fj2.getCenterY();
                if (this.K != null) {
                    t4 = eU.b(this.K);
                    if (!bl3) break block14;
                }
                t4 = this.a((d)object, bl2, (y.c.q)object2, d8, d9, bl4, d4, d5);
            }
            aB2.getTargetPort().b(t4.a, t4.b);
            this.a(bu2.q((d)object).a, bu2.q((d)object).b, aB2);
            this.b((d)object);
            this.a((d)object);
        }
        this.setEditing(false);
        bu2.T();
        this.reactivateParent();
    }

    protected cW c(double d2, double d3) {
        int n2 = 1;
        if (!this.e()) return this.view.getHitInfoFactory().a(d2, d3, n2, true);
        n2 |= 64;
        return this.view.getHitInfoFactory().a(d2, d3, n2, true);
    }

    protected y.c.q d(double d2, double d3) {
        if (!this.e()) return this.c(d2, d3).i();
        cW cW2 = this.c(d2, d3);
        if (cW2.t()) {
            return cW2.i();
        }
        if (!cW2.p()) return null;
        return cW2.o().b().getNode();
    }

    /*
     * Exception decompiling
     */
    private void b(d var1_1) {
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

    protected void a(aB aB2, double d2, double d3) {
        aB2.appendBend(d2, d3);
    }

    protected t b(boolean bl2, y.c.q q2, double d2, double d3) {
        if (!bl2) return t.c;
        fj fj2 = this.getGraph2D().t(q2);
        double d4 = fj2.getCenterX() + d2;
        double d5 = fj2.getCenterY() + d3;
        double d6 = this.getGridX(d4) - fj2.getCenterX();
        double d7 = this.getGridY(d5) - fj2.getCenterY();
        return new t(d6, d7);
    }

    protected eU b(y.c.q q2, double d2, double d3) {
        return this.g(q2, d2, d3);
    }

    protected t a(d d2, boolean bl2, y.c.q q2, double d3, double d4, boolean bl3, double d5, double d6) {
        fj fj2;
        byte by2;
        block4 : {
            aB aB2 = this.getGraph2D().i(d2);
            t t2 = aB2.bendCount() > 0 ? aB2.lastBend().e() : this.getGraph2D().p(d2);
            fj2 = aB2.getTargetRealizer();
            t t3 = bl3 ? new t(d5, d6) : new t(fj2.getCenterX() + d3, fj2.getCenterY() + d4);
            double d7 = t2.a - t3.a;
            double d8 = t2.b - t3.b;
            if (!this.H) return this.b(bl2, q2, d3, d4);
            if (Math.abs(d7) >= 0.1) {
                if (Math.abs(d8) >= 0.1) return this.b(bl2, q2, d3, d4);
            }
            if (Math.abs(d7) > Math.abs(d8)) {
                by2 = (byte)(d7 > 0.0 ? 1 : 3);
                if (!fj.z) break block4;
            }
            by2 = (byte)(d8 > 0.0 ? 2 : 0);
        }
        i i2 = d2.a();
        i2.d(d2);
        int n2 = by2 >= 0 ? F.a(by2, fj2) : 0;
        i2.e(d2);
        if (n2 == 0) {
            return this.b(bl2, q2, d3, d4);
        }
        double d9 = d5 - fj2.getCenterX();
        double d10 = d6 - fj2.getCenterY();
        return new t(d9, d10);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected d a(bu bu2, y.c.q q2, y.c.q q3, aB aB2) {
        v v2;
        if (bu2 == q2.e()) {
            if (bu2 == q3.e()) return bu2.a(q2, q3, aB2);
        }
        if ((v2 = bu2.C()) == null) return bu2.a(q2, q3, aB2);
        bu2.r();
        try {
            d d2 = v2.a(q2, q3);
            bu2.a(d2, aB2);
            return d2;
        }
        finally {
            bu2.s();
        }
    }

    protected boolean a(y.c.q q2, y.c.q q3, double d2, double d3) {
        boolean bl2 = fj.z;
        boolean bl3 = q3 == null;
        if (bl3) return bl3;
        v v2 = v.a(this.getGraph2D());
        if (v2 == null) return bl3;
        fj fj2 = this.getGraph2D().t(q3);
        if (!v2.k(q3)) return bl3;
        if (this.m()) {
            cW cW2 = this.e(d2, d3);
            C c2 = cW2.g();
            while (c2.f()) {
                eR eR2 = (eR)c2.d();
                if (bl2) return bl3;
                if (eR2.f() == q3 && fj2.getLabel(0) == eR2) {
                    return false;
                }
                c2.g();
                if (!bl2) continue;
            }
        }
        int n2 = this.l();
        if (d2 < fj2.getX() + (double)n2) return bl3;
        if (d2 > fj2.getX() + fj2.getWidth() - (double)n2) return bl3;
        if (d3 < fj2.getY() + (double)n2) return bl3;
        if (d3 > fj2.getY() + fj2.getHeight() - (double)n2) return bl3;
        return true;
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

    protected boolean a(int n2, int n3, y.c.q q2) {
        byte by2;
        block3 : {
            if (Math.abs(n2) > Math.abs(n3)) {
                by2 = (byte)(n2 > 0 ? 1 : 3);
                if (!fj.z) break block3;
            }
            by2 = (byte)(n3 > 0 ? 2 : 0);
        }
        if (F.a(by2, this.getGraph2D().t(q2)) == 0) {
            if (Math.abs(n3) <= Math.abs(n2)) return false;
            return true;
        }
        if (Math.abs(n2) <= Math.abs(n3)) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    private boolean a(Point2D.Double var1_1, aB var2_2, boolean var3_3) {
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

    private void a(Point2D.Double double_) {
        this.a(double_.x, double_.y, this.h());
    }

    protected y.c.q a(bu bu2, double d2, double d3) {
        if (!bu2.t(this.a).contains(d2, d3)) return this.d(d2, d3);
        return this.a;
    }

    @Override
    public void mouseMoved(double d2, double d3) {
        this.mouseDraggedLeft(d2, d3);
    }

    @Override
    public void reactivateParent() {
        this.p();
        this.p = false;
        this.c = true;
        this.x = null;
        this.w = null;
        super.reactivateParent();
    }

    public boolean j() {
        return this.r;
    }

    public boolean k() {
        return this.t;
    }

    public int l() {
        return this.u;
    }

    public boolean m() {
        return this.v;
    }

    protected cW e(double d2, double d3) {
        return new cW(this.view, d2, d3, false, 5);
    }

    protected Rectangle2D b(fj fj2) {
        return new Rectangle2D.Double(fj2.getX() - 10.0, fj2.getY() - 10.0, fj2.getWidth() + 20.0, fj2.getHeight() + 20.0);
    }

    protected void a(Graphics2D graphics2D, fj fj2) {
        dI.b(graphics2D, fj2);
    }

    protected void a(Graphics2D graphics2D, eU eU2) {
        y y2 = this.L.k();
        int n2 = (int)Math.floor(y2.c());
        int n3 = (int)Math.floor(y2.d());
        int n4 = (int)Math.ceil(y2.a());
        int n5 = (int)Math.ceil(y2.b());
        dI.a(graphics2D, n2, n3, n4, n5);
    }

    protected void f(double d2, double d3) {
    }

    /*
     * Unable to fully structure code
     */
    private void a(double var1_1, double var3_2, aB var5_3) {
        var17_4 = fj.z;
        if (!this.j()) {
            return;
        }
        var10_5 = new Point2D.Double(var1_1, var3_2);
        if (var5_3.bendCount() != 0) ** GOTO lbl21
        var11_6 = var5_3.getSourceRealizer();
        var6_7 = var5_3.getSourcePort().a((fj)var11_6);
        var8_8 = var5_3.getSourcePort().b((fj)var11_6);
        var12_9 = var10_5.x - var6_7;
        var14_11 = var10_5.y - var8_8;
        if (!this.B) ** GOTO lbl-1000
        var10_5.x = var6_7 + var12_9;
        var10_5.y = var8_8;
        if (var17_4) lbl-1000: // 2 sources:
        {
            var10_5.x = var6_7;
            var10_5.y = var8_8 + var14_11;
        }
        if (var1_1 == var10_5.x) {
            if (var3_2 == var10_5.y) return;
        }
        var5_3.createBend(var10_5.x, var10_5.y, var5_3.lastBend(), 0);
        if (var17_4 == false) return;
lbl21: // 2 sources:
        var11_6 = var5_3.lastBend();
        if (var5_3.bendCount() <= 1) ** GOTO lbl-1000
        var12_10 = var5_3.getPoint(var5_3.bendCount() - 2);
        var6_7 = var12_10.a;
        var8_8 = var12_10.b;
        if (var17_4) lbl-1000: // 2 sources:
        {
            var13_12 = var5_3.getSourceRealizer();
            var6_7 = var5_3.getSourcePort().a(var13_12);
            var8_8 = var5_3.getSourcePort().b(var13_12);
        }
        var13_13 = var10_5.x - var6_7;
        var15_14 = var10_5.y - var8_8;
        if (var5_3.bendCount() <= 1) ** GOTO lbl40
        if (var5_3.bendCount() % 2 == 0 != this.B) ** GOTO lbl37
        var10_5.x = var6_7 + var13_13;
        var10_5.y = var8_8;
        if (!var17_4) ** GOTO lbl46
lbl37: // 2 sources:
        var10_5.x = var6_7;
        var10_5.y = var8_8 + var15_14;
        if (!var17_4) ** GOTO lbl46
lbl40: // 2 sources:
        if (this.B) ** GOTO lbl-1000
        var10_5.x = var6_7 + var13_13;
        var10_5.y = var8_8;
        if (var17_4) lbl-1000: // 2 sources:
        {
            var10_5.x = var6_7;
            var10_5.y = var8_8 + var15_14;
        }
lbl46: // 5 sources:
        var11_6.a(var10_5.x, var10_5.y);
    }

    private boolean o() {
        boolean bl2 = false;
        if (this.lastMoveEvent == null) return bl2;
        if (this.lastDragEvent == null) return bl2;
        if (this.lastDragEvent.getWhen() <= this.lastMoveEvent.getWhen()) return this.a(this.lastMoveEvent);
        bl2 = this.a(this.lastDragEvent);
        if (!fj.z) return bl2;
        return this.a(this.lastMoveEvent);
    }

    protected void a(d d2) {
        if (!this.e()) return;
        aB aB2 = this.view.getGraph2D().i(d2);
        eU.a(this.J, aB2);
        eU.b(this.K, aB2);
    }

    protected void n() {
        this.a().f();
        this.x = null;
        this.w = null;
        this.l.j();
        this.F = null;
        this.p();
        this.getGraph2D().b(0);
        this.view.setDrawingMode(0);
        this.view.removeDrawable(this.l);
        this.view.updateView();
        this.setEditing(false);
        this.reactivateParent();
    }

    protected void c(y.c.q q2, double d2, double d3) {
        this.reactivateParent();
    }

    protected boolean d(y.c.q q2, double d2, double d3) {
        return true;
    }

    protected void a(y.c.q q2, eU eU2, double d2, double d3) {
        this.reactivateParent();
    }

    protected boolean b(y.c.q q2, eU eU2, double d2, double d3) {
        return true;
    }

    protected void e(y.c.q q2, double d2, double d3) {
    }

    protected boolean f(y.c.q q2, double d2, double d3) {
        return true;
    }

    protected void c(y.c.q q2, eU eU2, double d2, double d3) {
    }

    protected boolean d(y.c.q q2, eU eU2, double d2, double d3) {
        return true;
    }

    @Override
    public void cancelEditing() {
        if (!this.isEditing()) return;
        this.n();
    }

    private void p() {
        if (this.h != null) {
            this.view.getCanvasComponent().removeKeyListener(this.h);
            this.h = null;
        }
        if (this.i != null) {
            this.getGraph2D().b(this.i);
            this.i = null;
        }
        this.view.removePropertyChangeListener("Graph2D", this.j);
    }

    static o a(F f2) {
        return f2.i;
    }

    static o a(F f2, o o2) {
        f2.i = o2;
        return f2.i;
    }

    static boolean b(F f2) {
        return f2.C;
    }

    static boolean c(F f2) {
        return f2.g;
    }

    static boolean d(F f2) {
        return f2.p;
    }

    static int e(F f2) {
        return f2.k;
    }

    static KeyListener a(F f2, KeyListener keyListener) {
        f2.h = keyListener;
        return f2.h;
    }

    static y.c.q f(F f2) {
        return f2.a;
    }

    static boolean g(F f2) {
        return f2.G;
    }

    static eU h(F f2) {
        return f2.L;
    }

    static y.c.q i(F f2) {
        return f2.F;
    }
}

