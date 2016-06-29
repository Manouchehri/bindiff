/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Map;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.q;
import y.c.x;
import y.d.f;
import y.d.m;
import y.d.n;
import y.d.t;
import y.d.v;
import y.d.y;
import y.f.C;
import y.f.Q;
import y.f.R;
import y.f.X;
import y.f.aH;
import y.f.aj;
import y.f.b.c;
import y.f.d.A;
import y.f.d.a;
import y.f.d.j;
import y.f.d.k;
import y.f.d.l;
import y.f.d.r;
import y.f.d.u;
import y.g.M;
import y.g.al;
import y.g.o;

public abstract class i
extends a {
    h g;
    private static final double[][] q = new double[][]{{5.0, 1.0, 1.0, 8.0, 3.0, 5.0, 2.0, 5.0}, {5.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 5.0}, {1.0, 1.0, 1.0, 8.0, 3.0, 1.0, 1.0, 5.0}, {1.0, 5.0, 1.0, 1.0, 1.0, 1.0, 0.0, 5.0}};
    private byte r = 0;
    private boolean s = true;
    private c t = null;
    private double u = 0.1;
    protected X h;
    protected y.c.i i;
    protected y.c.A n;
    protected Map o;
    protected y.c.A p;

    public byte c() {
        return this.r;
    }

    /*
     * Exception decompiling
     */
    @Override
    void c(X var1_1, r[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[SIMPLE_IF_TAKEN]], but top level block is 2[FORLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2869)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:817)
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
    @Override
    void a(X var1_1, y.c.c var2_2, int var3_3) {
        var7_4 = a.f;
        var4_5 = new u();
        var5_6 = var1_1.f() + var1_1.h() + var3_3;
        if (var5_6 <= 5000) ** GOTO lbl7
        var4_5.c(20.0);
        if (var7_4 == 0) ** GOTO lbl11
lbl7: // 2 sources:
        if (var5_6 <= 1000) ** GOTO lbl-1000
        var4_5.c(10.0);
        if (var7_4 != 0) lbl-1000: // 2 sources:
        {
            var4_5.c(5.0);
        }
lbl11: // 4 sources:
        var4_5.b(35.0);
        var4_5.a(5.0);
        var4_5.b(true);
        var4_5.c(true);
        var6_7 = this.r == 0 || this.r == 4;
        var4_5.a(var6_7);
        var4_5.a(var1_1, var2_2);
    }

    void b(r[] arrr) {
        this.i = new y.c.i();
        this.g = this.i.u();
        this.n = this.i.t();
        this.p = this.i.t();
        this.c(arrr);
        this.d();
    }

    private k[] e(r[] arrr) {
        k[] arrk;
        q[] arrq;
        int n2;
        int n3;
        block15 : {
            int n4;
            Object object;
            int[] arrn;
            block14 : {
                Object object2;
                y.c.A a2;
                int n5;
                int n6;
                block13 : {
                    n3 = a.f;
                    a2 = this.i.t();
                    arrq = new q[arrr.length];
                    for (int i2 = 0; i2 < arrr.length; ++i2) {
                        arrq[i2] = this.i.d();
                        a2.a((Object)arrq[i2], true);
                        if (n3 == 0) continue;
                    }
                    object2 = this.i.o();
                    while (object2.f()) {
                        q q2 = object2.e();
                        n5 = (int)a2.d(q2) ? 1 : 0;
                        if (n3 == 0) {
                            if (n5 == 0) {
                                int n7 = this.p.a(q2);
                                this.i.a(arrq[n7], q2);
                            }
                            object2.g();
                            if (n3 == 0) continue;
                        }
                        break block13;
                    }
                    n5 = this.i.f();
                }
                object2 = M.a(new int[n5]);
                int n8 = y.a.h.a(this.i, (y.c.A)object2);
                arrk = new k[n8];
                for (int i3 = 0; i3 < n8; ++i3) {
                    arrk[i3] = new k(this);
                    if (n3 == 0) continue;
                }
                arrn = new int[arrr.length];
                x x2 = this.i.o();
                block3 : do {
                    int n9 = x2.f();
                    block4 : while (n9 != 0) {
                        object = x2.e();
                        n6 = a2.d(object);
                        if (n3 != 0) break block14;
                        if (n6 == 0) {
                            arrn[this.p.a((Object)object)] = n4 = object2.a(object);
                            arrk[n4].a((q)object);
                            e e2 = object.l();
                            while (e2.f()) {
                                d d2 = e2.a();
                                n9 = object2.a(d2.d());
                                if (n3 != 0) continue block4;
                                if (n9 == n4) {
                                    arrk[n4].a(d2);
                                }
                                e2.g();
                                if (n3 == 0) continue;
                            }
                        }
                        x2.g();
                        if (n3 == 0) continue block3;
                    }
                    break block3;
                    break;
                } while (true);
                this.i.a(a2);
                n6 = n2 = 0;
            }
            while (n2 < arrr.length) {
                object = arrr[n2];
                n4 = arrn[n2];
                arrk[n4].a((r)object);
                ++n2;
                if (n3 == 0) {
                    if (n3 == 0) continue;
                }
                break block15;
            }
            n2 = 0;
        }
        do {
            if (n2 >= arrq.length) return arrk;
            this.i.a(arrq[n2]);
            ++n2;
        } while (n3 == 0);
        return arrk;
    }

    abstract y.c.y a(r[] var1);

    void a(r[] arrr, y.c.y y2) {
        int n2 = a.f;
        x x2 = y2.a();
        while (x2.f()) {
            r r2 = arrr[this.p.a(x2.e())];
            Q q2 = (Q)this.n.b(x2.e());
            q2.g();
            r2.a(true);
            x2.g();
            if (n2 == 0) continue;
        }
        int n3 = 0;
        do {
            if (n3 >= arrr.length) return;
            if (!arrr[n3].c()) {
                arrr[n3].a();
            }
            ++n3;
        } while (n2 == 0);
    }

    void c(r[] arrr) {
        int n2 = a.f;
        int n3 = 0;
        block0 : do {
            if (n3 >= arrr.length) return;
            D d2 = arrr[n3].b();
            if (d2 != null) {
                y.c.C c2 = d2.m();
                while (c2.f()) {
                    Q q2 = (Q)c2.d();
                    q q3 = this.i.d();
                    this.n.a((Object)q3, q2);
                    this.o.put(q2, q3);
                    this.p.a((Object)q3, n3);
                    c2.g();
                    if (n2 != 0) continue block0;
                    if (n2 == 0) continue;
                }
            }
            ++n3;
        } while (n2 == 0);
    }

    protected void d() {
        al al2 = new al();
        o.a(this, (Object)"create edges in conflict graph");
        this.d(this.h);
        o.a(this, (Object)new StringBuffer().append("Time: ").append(al2).toString());
    }

    protected y.c.A e() {
        y.c.A a2;
        int n2 = a.f;
        y.c.A a3 = this.i.t();
        x x2 = this.i.o();
        while (x2.f()) {
            q q2 = x2.e();
            Q q3 = (Q)this.n.b(q2);
            a2 = a3;
            if (n2 != 0) return a2;
            a2.a((Object)q2, this.a(q3) - q3.k());
            x2.g();
            if (n2 == 0) continue;
        }
        a2 = a3;
        return a2;
    }

    /*
     * Unable to fully structure code
     */
    private void d(X var1_1) {
        block7 : {
            block8 : {
                var8_2 = a.f;
                var2_3 = new D();
                var3_4 = var1_1.o();
                while (var3_4.f()) {
                    var4_5 = var3_4.e();
                    var2_3.add(new j(var4_5, var1_1.s((q)var4_5), 0));
                    var3_4.g();
                    if (var8_2 == 0) {
                        if (var8_2 == 0) continue;
                    }
                    break block7;
                }
                var3_4 = var1_1.p();
                while (var3_4.f()) {
                    block9 : {
                        var4_5 = var3_4.a();
                        v0 = var1_1;
                        if (var8_2 != 0) break block8;
                        var5_6 = v0.l((d)var4_5).a();
                        var6_7 = (t)var5_6.d();
                        var5_6.g();
                        while (var5_6.f()) {
                            var7_8 = (t)var5_6.d();
                            var2_3.add(new j(var4_5, new m((t)var6_7, var7_8), 1));
                            var6_7 = var7_8;
                            var5_6.g();
                            if (var8_2 == 0) {
                                if (var8_2 == 0) continue;
                            }
                            break block9;
                        }
                        var3_4.g();
                    }
                    if (var8_2 == 0) continue;
                }
                v0 = this.i;
            }
            var3_4 = v0.o();
        }
        while (var3_4.f()) {
            var4_5 = (Q)this.n.b(var3_4.e());
            var5_6 = var4_5.e();
            if (var8_2 != 0) return;
            if (!(var5_6 instanceof C)) ** GOTO lbl42
            var6_7 = var1_1.a((C)var5_6);
            var2_3.add(new j(var6_7, (Q)var4_5, 2));
            if (var8_2 == 0) ** GOTO lbl47
lbl42: // 2 sources:
            if (!(var5_6 instanceof aj)) ** GOTO lbl-1000
            var6_7 = var1_1.a((aj)var5_6);
            var2_3.add(new j(var6_7, (Q)var4_5, 2));
            if (var8_2 != 0) lbl-1000: // 2 sources:
            {
                var2_3.add(new j((Object)null, (Q)var4_5, 2));
            }
lbl47: // 4 sources:
            var3_4.g();
            if (var8_2 == 0) continue;
        }
        f.a(var2_3, new l(this));
    }

    double f() {
        return q[this.r][2];
    }

    aH d(r[] arrr) {
        A a2 = new A(arrr, this.h);
        a2.b(q[this.r][0]);
        a2.d(q[this.r][1]);
        a2.f(q[this.r][4]);
        a2.e(q[this.r][3]);
        a2.g(q[this.r][5]);
        a2.c(q[this.r][6]);
        a2.h(q[this.r][7]);
        if (!this.b) return a2;
        a2.a(this.b());
        a2.a(this.u);
        return a2;
    }

    protected void a(Q q2, Q q3, d d2) {
        if (this.r == 4) return;
        double d3 = y.f.d.C.a(q2.d(), q3.d());
        this.g.a((Object)d2, d3);
    }

    protected void a(Q q2, q q3, y y2) {
        if (this.r == 4) return;
        if (this.t != null) {
            if (this.t.d(q3)) return;
        }
        if (!n.a(q2.d(), y2, 0.001)) return;
        A a2 = (A)this.b();
        a2.a(q2, q3, y2);
    }

    protected void a(Q q2, d d2, m m2) {
        if (this.r == 4) return;
        if (!n.a(q2.d(), m2, 0.001)) return;
        A a2 = (A)this.b();
        a2.a(q2, d2, m2);
    }
}

