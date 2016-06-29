/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.f;
import y.d.t;
import y.d.y;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.aF;
import y.f.ae;
import y.f.ax;
import y.f.i.aA;
import y.f.i.aB;
import y.f.i.aC;
import y.f.i.aJ;
import y.f.i.ad;
import y.f.i.ag;
import y.f.i.ai;
import y.f.i.al;
import y.f.i.an;
import y.f.i.ao;
import y.f.i.au;
import y.f.i.aw;
import y.f.i.ay;
import y.f.i.n;
import y.f.i.v;
import y.g.M;

class av {
    private X a;
    private byte b;
    private double c;
    private boolean d;
    private boolean e;
    private Rectangle2D f;
    private boolean g;
    private double h;
    private boolean i;
    private long j;
    private y.f.i.ax k;
    private y.f.i.ax l;
    private D m;
    private D n;
    private aC o;
    private D p;
    private y.c.y q;
    private y.c.f r;
    private D s;
    private D t;
    private y.f.i.aF u;
    private y.f.i.aF v;
    private au w;
    private an x;
    private int y = 0;
    private int z = 0;
    private boolean A;

    public av(X x2, y.c.f f2) {
        this.a = x2;
        this.q = new y.c.y(x2.o());
        this.r = f2;
        this.i();
    }

    private void i() {
        this.j = 0;
        this.b = 2;
        this.c = 3.0;
        this.g = false;
        this.i = false;
        this.d = false;
        this.e = false;
    }

    /*
     * Unable to fully structure code
     */
    private ao a(double var1_1, double var3_2, double var5_3, double var7_4) {
        var10_5 = v.f;
        if (!this.A) ** GOTO lbl12
        if (!this.e) ** GOTO lbl6
        var9_6 = new ai(var1_1, var3_2, var1_1 + var5_3, var3_2 + var7_4, true);
        if (var10_5 == 0) ** GOTO lbl10
lbl6: // 2 sources:
        if (!this.d) ** GOTO lbl-1000
        var9_7 = new al(var1_1, var3_2, var1_1 + var5_3, var3_2 + var7_4, true);
        if (var10_5 != 0) lbl-1000: // 2 sources:
        {
            var9_9 = new ao(var1_1, var3_2, var1_1 + var5_3, var3_2 + var7_4, true);
        }
lbl10: // 4 sources:
        this.s.add(var9_10);
        if (var10_5 == 0) return var9_17;
lbl12: // 2 sources:
        if (!this.e) ** GOTO lbl15
        var9_11 = new ai(var3_2, var1_1, var3_2 + var7_4, var1_1 + var5_3, false);
        if (var10_5 == 0) ** GOTO lbl19
lbl15: // 2 sources:
        if (!this.d) ** GOTO lbl-1000
        var9_13 = new al(var3_2, var1_1, var3_2 + var7_4, var1_1 + var5_3, false);
        if (var10_5 != 0) lbl-1000: // 2 sources:
        {
            var9_15 = new ao(var3_2, var1_1, var3_2 + var7_4, var1_1 + var5_3, false);
        }
lbl19: // 4 sources:
        this.t.add(var9_16);
        return var9_17;
    }

    private void a(ag ag2, ag ag3, byte by2) {
        int n2 = v.f;
        q q2 = (q)ag2.f();
        aJ aJ2 = (aJ)this.x.b(ag3);
        aJ aJ3 = (aJ)this.w.b(q2);
        if (this.A) {
            switch (by2) {
                case 1: {
                    aJ3.b(ag3);
                    aJ2.d(q2);
                    if (n2 == 0) break;
                }
                case 2: {
                    aJ3.d(ag3);
                    aJ2.b(q2);
                }
            }
            if (n2 == 0) return;
        }
        switch (by2) {
            case 1: {
                aJ3.f(ag3);
                aJ2.h(q2);
                if (n2 == 0) return;
            }
            case 2: {
                aJ3.h(ag3);
                aJ2.f(q2);
            }
        }
    }

    private void b(ag ag2, ag ag3, byte by2) {
        int n2 = v.f;
        q q2 = (q)ag2.f();
        aJ aJ2 = (aJ)this.x.b(ag3);
        aJ aJ3 = (aJ)this.w.b(q2);
        if (this.A) {
            switch (by2) {
                case 1: {
                    if ((q)aJ2.b() == q2) break;
                    aJ3.a(ag3);
                    aJ2.c(q2);
                    if (n2 == 0) break;
                }
                case 2: {
                    if ((q)aJ2.a() == q2) break;
                    aJ3.c(ag3);
                    aJ2.a(q2);
                }
            }
            if (n2 == 0) return;
        }
        switch (by2) {
            case 1: {
                if ((q)aJ2.d() == q2) return;
                aJ3.e(ag3);
                aJ2.g(q2);
                if (n2 == 0) return;
            }
            case 2: {
                if ((q)aJ2.c() == q2) return;
                aJ3.g(ag3);
                aJ2.e(q2);
            }
        }
    }

    private void j() {
        C c2;
        int n2;
        X x2;
        block4 : {
            n2 = v.f;
            c2 = this.a.p();
            while (c2.f()) {
                block5 : {
                    d d2 = c2.a();
                    this.a.a(d2, t.b(this.a.n(d2)));
                    this.a.b(d2, t.b(this.a.o(d2)));
                    x2 = this.a;
                    if (n2 != 0) break block4;
                    I i2 = x2.g(d2);
                    for (int i3 = 0; i3 < i2.pointCount(); ++i3) {
                        t t2 = i2.getPoint(i3);
                        i2.setPoint(i3, t2.b, t2.a);
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block5;
                    }
                    c2.g();
                }
                if (n2 == 0) continue;
            }
            x2 = this.a;
        }
        c2 = x2.o();
        do {
            if (!c2.f()) return;
            q q2 = c2.e();
            double d2 = this.a.m(q2);
            double d3 = this.a.n(q2);
            double d4 = this.a.p(q2);
            double d5 = this.a.q(q2);
            this.a.b(q2, d5, d4);
            this.a.c(q2, d3, d2);
            c2.g();
        } while (n2 == 0);
    }

    private void k() {
        this.f.setFrame(this.f.getY(), this.f.getX(), this.f.getHeight(), this.f.getWidth());
    }

    public void a(byte by2) {
        this.b = by2;
    }

    public void a(double d2) {
        this.h = d2;
        this.i = true;
    }

    public void b(double d2) {
        if (Math.abs(d2) > 0.0) {
            this.c = Math.abs(d2);
            if (v.f == 0) return;
        }
        this.c = 0.5;
    }

    public void a(boolean bl2) {
        this.d = bl2;
    }

    public void b(boolean bl2) {
        this.e = bl2;
    }

    public D a() {
        return this.s;
    }

    public D b() {
        return this.t;
    }

    public c c() {
        return this.v;
    }

    public c d() {
        return this.w;
    }

    public c e() {
        return this.u;
    }

    public String f() {
        return new StringBuffer().append("\n===Orthogonal Sweepline===\nNumber of obstacles (nodes) = ").append(this.a.f()).append("\n").append("Number of additional obstacles (edge segments) = ").append(this.y).append("\n").append("BoundingBox = ").append(this.f).append("\n").append("Halo = ").append(this.c).append("\n").append("Number of vertical sight patches = ").append(this.s.size()).append("\n").append("Number of horizontal sight patches = ").append(this.t.size()).append("\n").append("Number of sight patch intersections = ").append(this.z).append("\n").append("===Orthogonal Sweepline===\n").toString();
    }

    private void l() {
        int n2;
        block3 : {
            if (this.g) {
                return;
            }
            this.f = this.m();
            if (this.i) {
                n2 = (int)this.h;
                if (v.f == 0) break block3;
            }
            n2 = (int)(10.0 * this.c);
        }
        this.f.setFrame(this.f.getX() - (double)n2, this.f.getY() - (double)n2, this.f.getWidth() + (double)(2 * n2), this.f.getHeight() + (double)(2 * n2));
    }

    private Rectangle2D m() {
        if (this.a.i()) {
            return new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0);
        }
        Rectangle2D rectangle2D = ae.a(this.a, this.q.a(), this.r.a());
        return new Rectangle2D.Double((int)rectangle2D.getX(), (int)rectangle2D.getY(), (int)rectangle2D.getWidth(), (int)rectangle2D.getHeight());
    }

    private void n() {
        this.o = new aC();
        this.p = new D();
        this.k = new y.f.i.ax(this, this.o);
        this.l = new y.f.i.ax(this, this.o);
        this.m = new D();
        this.n = new D();
    }

    private void o() {
        int n2 = v.f;
        this.x = new an();
        this.v = new y.f.i.aF();
        this.w = new au();
        x x2 = this.q.a();
        do {
            if (!x2.f()) return;
            this.w.a((q)x2.d(), new aJ());
            x2.g();
        } while (n2 == 0);
    }

    private void p() {
        int n2;
        C c2;
        block3 : {
            n2 = v.f;
            this.u = new y.f.i.aF();
            c2 = this.t.m();
            while (c2.f()) {
                this.u.a((ao)c2.d(), new D());
                c2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block3;
            }
            c2 = this.s.m();
        }
        do {
            if (!c2.f()) return;
            this.u.a((ao)c2.d(), new D());
            c2.g();
        } while (n2 == 0);
    }

    private void q() {
        Object object;
        x x2;
        int n2;
        block8 : {
            D d2;
            block7 : {
                n2 = v.f;
                if (this.A) {
                    d2 = this.s;
                    if (n2 == 0) break block7;
                }
                d2 = this.t;
            }
            C c2 = d2.m();
            while (c2.f()) {
                object = (ao)c2.d();
                ag ag2 = object.o();
                aJ aJ2 = (aJ)this.x.b(ag2);
                this.v.a((ao)object, aJ2);
                c2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block8;
            }
            if (this.A) {
                x2 = this.q.a();
                do {
                    if (!x2.f()) return;
                    object = (aJ)this.w.b((q)x2.d());
                    object.a = this.a(object.a);
                    object.b = this.a(object.b);
                    object.c = this.a(object.c);
                    object.d = this.a(object.d);
                    x2.g();
                } while (n2 == 0);
            }
        }
        x2 = this.q.a();
        do {
            if (!x2.f()) return;
            object = (aJ)this.w.b((q)x2.d());
            object.e = this.a(object.e);
            object.f = this.a(object.f);
            object.g = this.a(object.g);
            object.h = this.a(object.h);
            x2.g();
        } while (n2 == 0);
    }

    private D a(D d2) {
        int n2 = v.f;
        D d3 = new D();
        ao ao2 = null;
        C c2 = d2.m();
        do {
            if (!c2.f()) return d3;
            ag ag2 = (ag)c2.d();
            ao ao3 = (ao)ag2.f();
            if (ao3 != ao2 && ao3 != null) {
                d3.add(ao3);
            }
            ao2 = ao3;
            c2.g();
        } while (n2 == 0);
        return d3;
    }

    private void r() {
        C c2;
        C c3;
        D d2;
        ao ao2;
        al al2;
        int n2 = v.f;
        if (this.A) {
            c2 = this.s.m();
            block0 : do {
                if (!c2.f()) return;
                ao2 = (ao)c2.d();
                d2 = ((al)ao2).b;
                c3 = d2.m();
                while (c3.f()) {
                    al2 = (al)c3.d();
                    al2.a(false, (al)ao2);
                    c3.g();
                    if (n2 != 0) continue block0;
                    if (n2 == 0) continue;
                }
                c2.g();
            } while (n2 == 0);
        }
        c2 = this.t.m();
        block2 : do {
            if (!c2.f()) return;
            ao2 = (ao)c2.d();
            d2 = ((al)ao2).b;
            c3 = d2.m();
            while (c3.f()) {
                al2 = (al)c3.d();
                al2.a(false, (al)ao2);
                c3.g();
                if (n2 != 0) continue block2;
                if (n2 == 0) continue;
            }
            c2.g();
        } while (n2 == 0);
    }

    private void s() {
        this.o = null;
        this.p = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    public void g() {
        int n2 = v.f;
        this.l();
        this.o();
        if (this.e) {
            this.d = true;
        }
        if (this.b == 8) {
            this.t();
            this.u();
            this.p();
            this.h();
            if (n2 == 0) return;
        }
        if (this.b == 4) {
            this.u();
            if (n2 == 0) return;
        }
        this.t();
    }

    void h() {
        int n2;
        D d2;
        Object object;
        block3 : {
            n2 = v.f;
            d2 = new D();
            object = this.t.m();
            while (object.f()) {
                d2.add(new aA((ao)object.d()));
                object.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block3;
            }
            object = this.s.m();
        }
        while (object.f()) {
            d2.add(new aA((ao)object.d()));
            object.g();
            if (n2 == 0) continue;
        }
        object = new Rectangle2D.Double();
        Rectangle2D.Double double_ = new Rectangle2D.Double();
        Rectangle2D.Double double_2 = new Rectangle2D.Double();
        f.a(d2, new aw(this, (Rectangle2D.Double)object, double_, double_2));
    }

    private void t() {
        this.A = true;
        this.s = new D();
        this.x();
    }

    private void u() {
        this.A = false;
        this.t = new D();
        this.k();
        this.j();
        this.x();
        this.j();
        this.k();
    }

    private void v() {
        ++this.j;
        ag ag2 = new ag(this.f.getX(), this.f.getY(), this.f.getY() + this.f.getHeight(), 8, this.j);
        this.k.a(this.f.getY(), ag2);
    }

    private void w() {
        int n2 = v.f;
        C c2 = this.k.a().m();
        do {
            if (!c2.f()) return;
            ag ag2 = (ag)c2.d();
            double d2 = ag2.a();
            double d3 = ag2.b();
            ag ag3 = (ag)this.k.b(d3, ag2);
            ao ao2 = this.a(d2, d3, this.f.getX() + this.f.getWidth() - d2, this.f.getY() + this.f.getHeight() - d3);
            ag3.a(ao2);
            ag2.a(ao2);
            ao2.a(ag3, ag2);
            if (this.d) {
                ((al)ao2).a(true, ag3.a);
            }
            c2.g();
        } while (n2 == 0);
    }

    private void x() {
        double d2;
        block6 : {
            int n2 = v.f;
            this.n();
            this.B();
            this.C();
            this.p.sort(new aB());
            D d3 = this.p;
            this.v();
            C c2 = d3.m();
            double d4 = ((ag)c2.d()).a();
            while (c2.f()) {
                ag ag2 = (ag)c2.d();
                d2 = ag2.a() DCMPL d4;
                if (n2 == 0) {
                    if (d2 > 0) {
                        d4 = ag2.a();
                        this.y();
                        this.z();
                        this.m.clear();
                        this.n.clear();
                    }
                    if (ag2.d() == 8) {
                        this.m.add(ag2);
                    }
                    if (ag2.d() == -8) {
                        this.n.add(ag2);
                    }
                    c2.g();
                    if (n2 == 0) continue;
                }
                break block6;
            }
            this.y();
            this.z();
            this.m.clear();
            this.n.clear();
            this.w();
            this.q();
            d2 = (double)this.d ? 1 : 0;
        }
        if (d2 != false) {
            this.r();
        }
        this.s();
    }

    /*
     * Exception decompiling
     */
    private void y() {
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

    /*
     * Unable to fully structure code
     */
    private void z() {
        var19_1 = v.f;
        if (this.m.isEmpty()) {
            return;
        }
        var1_2 = this.m.m();
        while (var1_2.f()) {
            block17 : {
                var5_6 = (ag)var1_2.d();
                var12_11 = var5_6.b();
                var14_12 = var5_6.c();
                var2_3 = this.k.a().m();
                if (var19_1 != 0) return;
                var3_4 = false;
                while (var2_3.f()) {
                    v0 = var3_4;
                    if (var19_1 != 0) break block17;
                    if (v0) break;
                    var4_5 = (ag)var2_3.d();
                    var8_9 = var4_5.b();
                    var10_10 = var4_5.c();
                    if (var10_10 < var12_11) ** GOTO lbl-1000
                    if (var8_9 <= var14_12) ** GOTO lbl23
                    var3_4 = true;
                    if (var19_1 == 0) ** GOTO lbl-1000
lbl23: // 2 sources:
                    var16_13 = (ag)this.k.b(var8_9, var4_5);
                    var6_7 = null;
                    if (var8_9 < var12_11) {
                        ++this.j;
                        var6_7 = new ag(var5_6.a(), var8_9, var12_11, 8, this.j);
                        this.k.a(var8_9, var6_7);
                    }
                    var7_8 = null;
                    if (var10_10 > var14_12) {
                        ++this.j;
                        var7_8 = new ag(var5_6.a(), var14_12, var10_10, 8, this.j);
                        this.k.a(var14_12, var7_8);
                    }
                    var17_14 = null;
                    if (var5_6.a() <= var4_5.a()) ** GOTO lbl51
                    var18_15 = this.a(var4_5.a(), var8_9, var5_6.a() - var4_5.a(), var10_10 - var8_9);
                    if (var16_13.f() instanceof d) {
                        var18_15.n();
                    }
                    var16_13.a(var18_15);
                    var4_5.a(var18_15);
                    var18_15.a(var16_13, var4_5);
                    if (!this.d) ** GOTO lbl-1000
                    if (var6_7 != null) {
                        var6_7.a(true, (ao)var18_15);
                    }
                    if (var7_8 != null) {
                        var7_8.a(true, (ao)var18_15);
                    }
                    if (var17_14 != null) {
                        var17_14.a(true, (ao)var18_15);
                    }
                    ((al)var18_15).a(true, var16_13.a);
                    if (var19_1 == 0) ** GOTO lbl-1000
lbl51: // 2 sources:
                    if (!this.d) ** GOTO lbl-1000
                    if (var6_7 != null) {
                        var18_15 = var4_5.a.m();
                        while (var18_15.f()) {
                            var6_7.a(true, (ao)var18_15.d());
                            var18_15.g();
                            if (var19_1 == 0) {
                                if (var19_1 == 0) continue;
                            }
                            break;
                        }
                    } else if (var7_8 != null) {
                        var18_15 = var4_5.a.m();
                        while (var18_15.f()) {
                            var7_8.a(true, (ao)var18_15.d());
                            var18_15.g();
                            if (var19_1 == 0) {
                                if (var19_1 == 0) continue;
                            }
                            break;
                        }
                    } else lbl-1000: // 8 sources:
                    {
                        var2_3.g();
                    }
                    if (var19_1 == 0) continue;
                }
                v0 = this.l.a(var5_6.b(), var5_6);
            }
            var1_2.g();
            if (var19_1 == 0) continue;
        }
        this.A();
    }

    /*
     * Unable to fully structure code
     */
    private void A() {
        block22 : {
            var23_1 = v.f;
            var1_2 = this.l.a().m();
            var2_3 = this.k.a().m();
            if (var1_2.k() == 0) {
                return;
            }
            if (var2_3.k() == 0) {
                return;
            }
            var16_4 = new D();
            var1_2.i();
            while (var1_2.f()) {
                var5_5 = (ag)var1_2.d();
                v0 = var5_5.f();
                if (var23_1 == 0) {
                    if (v0 instanceof d) {
                        var16_4.add(var5_5);
                    }
                    var1_2.g();
                    if (var23_1 == 0) continue;
                }
                break block22;
            }
            var1_2.i();
            v0 = var2_3.d();
        }
        var17_6 = (ag)v0;
        var18_7 = var17_6.b();
        var20_8 = var17_6.c();
        if (this.x.b(var17_6) == null) {
            this.x.a(var17_6, new aJ());
        }
        var2_3.g();
        block1 : do {
            v1 = var2_3.f();
            block2 : while (v1) {
                var3_9 = (ag)var2_3.d();
                var6_11 = var3_9.b();
                var8_12 = var3_9.c();
                v2 = this.x.b(var3_9);
                if (var23_1 != 0) ** GOTO lbl78
                if (v2 == null) {
                    this.x.a(var3_9, new aJ());
                }
                var22_15 = false;
                while (var1_2.f()) {
                    v1 = var22_15;
                    if (var23_1 != 0) continue block2;
                    if (v1) break;
                    var4_10 = (ag)var1_2.d();
                    var10_13 = var4_10.b();
                    var12_14 = var4_10.c();
                    if (var4_10.f() instanceof d) {
                        var1_2.g();
                        if (var23_1 == 0) continue;
                    }
                    if (var12_14 <= var18_7) {
                        block23 : {
                            if (var12_14 == var18_7) {
                                this.b(var4_10, var17_6, 2);
                                if (var23_1 == 0) break block23;
                            }
                            this.a(var16_4, var4_10, var17_6, 2);
                        }
                        var1_2.g();
                        if (var23_1 == 0) continue;
                    }
                    if (var10_13 >= var20_8 && var12_14 <= var6_11) {
                        if (var10_13 == var20_8) {
                            this.b(var4_10, var17_6, 1);
                        }
                        if (var10_13 > var20_8) {
                            this.a(var16_4, var4_10, var17_6, 1);
                        }
                        if (var12_14 == var6_11) {
                            this.b(var4_10, var3_9, 2);
                        }
                        if (var12_14 < var6_11) {
                            this.a(var16_4, var4_10, var3_9, 2);
                        }
                        var1_2.g();
                        if (var23_1 == 0) continue;
                    }
                    var22_15 = true;
                    if (var23_1 == 0) continue;
                }
                var17_6 = var3_9;
                var18_7 = var6_11;
                var20_8 = var8_12;
                var2_3.g();
                if (var23_1 == 0) continue block1;
            }
            break block1;
            break;
        } while (true);
        do {
            if (var1_2.f() == false) return;
            v2 = var1_2.d();
lbl78: // 2 sources:
            var4_10 = (ag)v2;
            var10_13 = var4_10.b();
            var12_14 = var4_10.c();
            if (var4_10.f() instanceof d) ** GOTO lbl92
            if (var10_13 < var20_8) ** GOTO lbl87
            if (var10_13 != var20_8) ** GOTO lbl-1000
            this.b(var4_10, var17_6, 1);
            if (var23_1 != 0) lbl-1000: // 2 sources:
            {
                this.a(var16_4, var4_10, var17_6, 1);
            }
lbl87: // 4 sources:
            if (var12_14 > var18_7) ** GOTO lbl92
            if (var12_14 != var18_7) ** GOTO lbl-1000
            this.b(var4_10, var17_6, 2);
            if (var23_1 != 0) lbl-1000: // 2 sources:
            {
                this.a(var16_4, var4_10, var17_6, 2);
            }
lbl92: // 5 sources:
            var1_2.g();
        } while (var23_1 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private void a(D var1_1, ag var2_2, ag var3_3, byte var4_4) {
        block6 : {
            var20_5 = v.f;
            var5_6 = false;
            var6_7 = var2_2.b();
            var8_8 = var2_2.c();
            var10_9 = var3_3.b();
            var12_10 = var3_3.c();
            if (var4_4 != 2) ** GOTO lbl21
            var14_11 = var1_1.m();
            block0 : while (var14_11.f()) {
                v0 = var5_6;
                if (var20_5 == 0) {
                    if (v0) break;
                    var15_12 = (ag)var14_11.d();
                    var16_13 = var15_12.b();
                    var18_14 = var15_12.c();
                    if (var18_14 >= var8_8 && var18_14 <= var10_9) {
                        var5_6 = true;
                    }
                    var14_11.g();
                    if (var20_5 == 0) continue;
                }
                break block6;
lbl21: // 2 sources:
                var14_11 = var1_1.m();
                while (var14_11.f()) {
                    v0 = var5_6;
                    if (var20_5 == 0) {
                        if (v0) break block0;
                        var15_12 = (ag)var14_11.d();
                        var16_13 = var15_12.b();
                        var18_14 = var15_12.c();
                        if (var16_13 <= var6_7 && var16_13 >= var12_10) {
                            var5_6 = true;
                        }
                        var14_11.g();
                        if (var20_5 == 0) continue;
                    }
                    break block6;
                }
                break block0;
            }
            v0 = var5_6;
        }
        if (v0 != false) return;
        this.a(var2_2, var3_3, var4_4);
    }

    private void B() {
        int n2 = v.f;
        c c2 = this.a.c(n.b);
        x x2 = this.q.a();
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            y y2 = this.a.s(q2);
            if (c2 != null && c2.d(q2)) {
                y2 = new y(this.a.j(q2) - 0.5, this.a.k(q2) - 0.5, 1.0, 1.0);
            }
            double d2 = y2.c();
            double d3 = d2 + y2.a();
            double d4 = y2.d();
            double d5 = d4 + y2.b();
            ++this.j;
            ag ag2 = this.a(this.p, d2, d4, d5, this.j, q2);
            this.x.a(ag2, new aJ());
            this.b(this.p, d3, d4, d5, this.j, q2);
            x2.g();
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    boolean a(q var1_1, t var2_2, t var3_3, c var4_4) {
        var13_5 = v.f;
        var5_6 = 0;
        if (!this.A) ** GOTO lbl16
        if (var2_2.a != var3_3.a || var2_2.b >= var3_3.b) ** GOTO lbl7
        var5_6 = 2;
        if (var13_5 == 0) ** GOTO lbl27
lbl7: // 2 sources:
        if (var2_2.a != var3_3.a || var2_2.b <= var3_3.b) ** GOTO lbl10
        var5_6 = 1;
        if (var13_5 == 0) ** GOTO lbl27
lbl10: // 2 sources:
        if (var2_2.b != var3_3.b || var2_2.a >= var3_3.a) ** GOTO lbl13
        var5_6 = 4;
        if (var13_5 == 0) ** GOTO lbl27
lbl13: // 2 sources:
        if (var2_2.b != var3_3.b || var2_2.a <= var3_3.a) ** GOTO lbl27
        var5_6 = 8;
        if (var13_5 == 0) ** GOTO lbl27
lbl16: // 2 sources:
        if (var2_2.a != var3_3.a || var2_2.b >= var3_3.b) ** GOTO lbl19
        var5_6 = 4;
        if (var13_5 == 0) ** GOTO lbl27
lbl19: // 2 sources:
        if (var2_2.a != var3_3.a || var2_2.b <= var3_3.b) ** GOTO lbl22
        var5_6 = 8;
        if (var13_5 == 0) ** GOTO lbl27
lbl22: // 2 sources:
        if (var2_2.b != var3_3.b || var2_2.a >= var3_3.a) ** GOTO lbl-1000
        var5_6 = 2;
        if (var13_5 != 0) lbl-1000: // 2 sources:
        {
            if (var2_2.b == var3_3.b && var2_2.a > var3_3.a) {
                var5_6 = 1;
            }
        }
lbl27: // 12 sources:
        var6_7 = ax.a(aE.a(var5_6)).a();
        var7_8 = this.a.c(aF.a);
        var8_9 = this.a.c(aF.b);
        var9_10 = var1_1.j();
        do {
            if (var9_10.f() == false) return false;
            var10_11 = var9_10.a();
            v0 = var4_4.d(var10_11);
            if (var13_5 != 0) return v0;
            if (!v0) {
                if (var10_11.c() == var1_1 && (var11_12 = aE.d(this.a, var10_11)) != null && var11_12.a() && (var11_12.g() || var11_12.b() == var5_6)) {
                    var12_13 = this.a.p(var10_11);
                    if (var2_2.a == var3_3.a && Math.abs(var2_2.a - var12_13.a) < 1.0) {
                        return true;
                    }
                    if (var2_2.b == var3_3.b && Math.abs(var2_2.b - var12_13.b) < 1.0) {
                        return true;
                    }
                }
                if (var10_11.d() == var1_1 && (var11_12 = aE.e(this.a, var10_11)) != null && var11_12.a() && (var11_12.g() || var11_12.b() == var5_6)) {
                    var12_13 = this.a.q(var10_11);
                    if (var2_2.a == var3_3.a && Math.abs(var2_2.a - var12_13.a) < 1.0) {
                        return true;
                    }
                    if (var2_2.b == var3_3.b && Math.abs(var2_2.b - var12_13.b) < 1.0) {
                        return true;
                    }
                }
                if (this.a(var10_11, true, var6_7, var1_1, var2_2, var3_3)) {
                    return true;
                }
                if (this.a(var10_11, false, var6_7, var1_1, var2_2, var3_3)) {
                    return true;
                }
            }
            var9_10.g();
        } while (var13_5 == 0);
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(d var1_1, boolean var2_2, int var3_3, q var4_4, t var5_5, t var6_6) {
        var11_7 = v.f;
        var7_8 = ad.a(this.a, var1_1, var2_2);
        if (var7_8 == null) return false;
        if (var7_8.isEmpty() != false) return false;
        var8_9 = var7_8.iterator();
        do lbl-1000: // 4 sources:
        {
            if (var8_9.hasNext() == false) return false;
            var9_10 = (ax)var8_9.next();
            if (!var9_10.b()) ** GOTO lbl-1000
            v0 = var9_10.a(var3_3);
            if (var11_7 != 0) return v0;
            if (!v0) ** GOTO lbl-1000
            var10_11 = t.b(this.a.l(var4_4), new t(var9_10.c(), var9_10.d()));
            if (var5_5.a != var6_6.a || Math.abs(var5_5.a - var10_11.a) >= 1.0) continue;
            return true;
        } while (var5_5.b != var6_6.b || Math.abs(var5_5.b - var10_11.b) >= 1.0);
        return true;
    }

    private void C() {
        h h2;
        h h3;
        int n2;
        Object object;
        block11 : {
            n2 = v.f;
            h2 = M.b(new boolean[this.a.g()]);
            object = this.r.a();
            while (object.f()) {
                h3 = h2;
                if (n2 == 0) {
                    h3.a((Object)object.a(), true);
                    object.g();
                    if (n2 == 0) continue;
                }
                break block11;
            }
            h3 = this.a.c(n.b);
        }
        object = h3;
        e e2 = this.r.a();
        do {
            int n3 = e2.f();
            block2 : do {
                if (n3 == 0) return;
                d d2 = e2.a();
                double d3 = this.c;
                double d4 = this.c;
                if (object != null && object.d(d2.c())) {
                    d4 = 1.0;
                    d3 = 1.0;
                }
                boolean bl2 = true;
                boolean bl3 = false;
                D d5 = this.a.m(d2);
                if (d5.isEmpty()) break;
                p p2 = d5.k();
                t t2 = (t)p2.c();
                int n4 = 0;
                for (p2 = p2.a(); p2 != null; p2 = p2.a(), ++n4) {
                    t t3 = (t)p2.c();
                    n3 = Math.abs(t2.a - t3.a) DCMPG 0.01;
                    if (n2 != 0) continue block2;
                    if (n3 < 0) {
                        Object object2;
                        if (n4 == 0 && this.a(d2.c(), t2, t3, h2)) {
                            t2 = t3;
                            if (n2 == 0) continue;
                        }
                        if (n4 == d5.size() - 2 && this.a(d2.d(), t3, t2, h2)) {
                            t2 = t3;
                            if (n2 == 0) continue;
                        }
                        double d6 = Math.min(t2.b, t3.b);
                        double d7 = Math.max(t2.b, t3.b);
                        if (n4 == d5.size() - 3) {
                            object2 = (t)p2.a().c();
                            if (this.a(d2.d(), (t)object2, t3, h2)) {
                                d3 = - d3;
                                d3 = Math.max(d3, 0.5 * (d6 - d7));
                            }
                        }
                        ++this.j;
                        object2 = this.a(this.p, t2.a - d4, d6 - d3, d7 + d3, this.j, d2);
                        ag ag2 = this.b(this.p, t2.a + d4, d6 - d3, d7 + d3, this.j, d2);
                        bl3 = true;
                        ++this.y;
                    }
                    bl2 = false;
                    t2 = t3;
                    if (n2 == 0) continue;
                }
                break;
            } while (true);
            e2.g();
        } while (n2 == 0);
    }

    private ag a(D d2, double d3, double d4, double d5, long l2, Object object) {
        ag ag2 = new ag(d3, d4, d5, 8, l2);
        ag2.a(object);
        d2.add(ag2);
        return ag2;
    }

    private ag b(D d2, double d3, double d4, double d5, long l2, Object object) {
        ag ag2 = new ag(d3, d4, d5, -8, l2);
        ag2.a(object);
        d2.add(ag2);
        return ag2;
    }

    static y.f.i.aF a(av av2) {
        return av2.u;
    }

    static int b(av av2) {
        return av2.z++;
    }
}

