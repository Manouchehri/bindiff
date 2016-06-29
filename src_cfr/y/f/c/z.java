/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.am;
import y.f.c.a;
import y.g.M;
import y.g.al;

public class Z
extends a {
    private boolean C = false;
    private double D;
    private double E;
    private double F = 10.0;
    private double G = 2.0;
    protected A o;
    protected A p;
    private int H = 1;
    al q = new al(false);
    al r = new al(false);
    al s = new al(false);
    al t = new al(false);
    al u = new al(false);
    al v = new al(false);
    al w = new al(false);
    al x = new al(false);
    al y = new al(false);
    al z = new al(false);
    al A = new al(false);
    al B = new al(false);

    protected void f() {
        this.q.c();
        this.D = Math.max(this.b(), this.a());
        if (this.D < 1.0) {
            this.D = 1.0;
        }
        this.E = (double)((int)(this.c() / this.D)) * this.D;
        this.o = M.a(new Object[this.g.f()]);
        this.p = M.a(new Object[this.g.f()]);
        this.q.c();
    }

    @Override
    protected void a(y[] arry, c c2) {
        boolean bl2 = a.i;
        this.r.c();
        this.f();
        this.b(arry);
        double d2 = this.i();
        double d3 = Double.POSITIVE_INFINITY;
        int n2 = 0;
        while (n2 < this.H && d2 < d3) {
            block9 : {
                D d4;
                int n3;
                block8 : {
                    block7 : {
                        y.a.a.a();
                        ++n2;
                        d3 = d2;
                        for (n3 = 1; n3 < arry.length; ++n3) {
                            d4 = this.a(arry[n3], -1);
                            this.a(d4, -1);
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break block7;
                        }
                        n3 = arry.length - 2;
                    }
                    while (n3 >= 0) {
                        d4 = this.a(arry[n3], 1);
                        this.a(d4, 1);
                        --n3;
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block8;
                    }
                    n3 = 1;
                }
                while (n3 < arry.length - 1) {
                    d4 = this.a(arry[n3], 0);
                    this.a(d4, 0);
                    ++n3;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block9;
                }
                this.h();
                d2 = this.i();
            }
            if (!bl2) continue;
        }
        y.a.a.a();
        D d5 = this.g();
        this.a(d5);
        this.r.c();
    }

    protected boolean a(D d2) {
        int n2;
        boolean bl2 = a.i;
        this.s.c();
        int n3 = 0;
        double[] arrd = new double[2];
        double[] arrd2 = new double[2];
        double[] arrd3 = new double[2];
        block0 : do {
            int n4 = 0;
            D d3 = d2;
            block1 : do {
                C c2 = d3.m();
                block2 : do {
                    n2 = c2.f();
                    do {
                        if (n2 != 0) {
                            int n5;
                            block9 : {
                                y y2 = (y)c2.d();
                                q q2 = y2.b();
                                arrd[0] = this.a(q2, true);
                                arrd[1] = this.a(q2, false);
                                p p2 = y2.k();
                                d3 = y2;
                                if (bl2) continue block1;
                                for (p p3 = (v992720).k().a(); p3 != null; p3 = p3.a()) {
                                    q2 = (q)p3.c();
                                    arrd2[0] = this.a(q2, true);
                                    arrd2[1] = this.a(q2, false);
                                    arrd3[0] = Math.max(arrd[0], arrd2[0]);
                                    arrd3[1] = Math.min(arrd[1], arrd2[1]);
                                    n5 = arrd3[1] DCMPG arrd3[0];
                                    if (!bl2) {
                                        if (n5 < 0) {
                                            p p4 = p3.b();
                                            if (p4 != null && p4 != p2) {
                                                n3 |= (n4 |= this.a(p2, p4, arrd));
                                            }
                                            p2 = p3;
                                            arrd[0] = arrd2[0];
                                            arrd[1] = arrd2[1];
                                            if (!bl2) continue;
                                        }
                                        arrd[0] = arrd3[0];
                                        arrd[1] = arrd3[1];
                                        if (!bl2) continue;
                                    }
                                    break block9;
                                }
                                n5 = n3 | (n4 |= this.a(p2, y2.l(), arrd));
                            }
                            n3 = n5;
                            c2.g();
                            if (!bl2) continue block2;
                        }
                        if (n4 != 0) continue block0;
                        this.s.c();
                        n2 = n3;
                    } while (bl2);
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
        return (boolean)n2;
    }

    protected D g() {
        boolean bl2 = a.i;
        this.t.c();
        A a2 = M.a(new Object[this.g.f()]);
        D d2 = new D();
        x x2 = this.g.o();
        block0 : do {
            boolean bl3 = x2.f();
            block1 : while (bl3) {
                q q2 = x2.e();
                if (bl2) return d2;
                if (a2.b(q2) == null && this.h(q2)) {
                    int n2;
                    y y2;
                    block7 : {
                        while (q2.b() == 1) {
                            bl3 = this.h(q2.n().e());
                            if (bl2) continue block1;
                            if (!bl3) break;
                            q2 = q2.n().e();
                            if (!bl2) continue;
                        }
                        y2 = new y();
                        y2.add(q2);
                        a2.a((Object)q2, y2);
                        while (q2.c() == 1) {
                            q2 = q2.o().e();
                            n2 = (int)this.h(q2) ? 1 : 0;
                            if (!bl2) {
                                if (n2 == 0) break;
                                y2.add(q2);
                                a2.a((Object)q2, y2);
                                if (!bl2) continue;
                            }
                            break block7;
                        }
                        n2 = y2.size();
                    }
                    if (n2 > 1) {
                        d2.add(y2);
                    }
                }
                x2.g();
                if (!bl2) continue block0;
            }
            break block0;
            break;
        } while (true);
        this.t.c();
        return d2;
    }

    protected boolean a(p p2, p p3, double[] arrd) {
        double d2;
        boolean bl2 = a.i;
        this.u.c();
        boolean bl3 = false;
        if (p2 == p3) {
            this.u.c();
            return false;
        }
        q q2 = (q)p2.c();
        q q3 = (q)p3.c();
        double d3 = (arrd[0] + arrd[1]) / 2.0;
        if (arrd[0] <= -1.7976931348623157E308) {
            arrd[0] = Math.min(this.g.j(q2), this.g.j(q3));
            d2 = arrd[0];
            if (q2.b() == 1) {
                d2 = Math.min(d2, this.g.j(q2.n().e()));
            }
            if (q3.c() == 1) {
                d2 = Math.min(d2, this.g.j(q3.o().e()));
            }
            arrd[0] = d2;
            if (arrd[0] > arrd[1]) {
                arrd[0] = arrd[1];
            }
            d3 = arrd[0];
        }
        if (arrd[1] >= Double.MAX_VALUE) {
            arrd[1] = Math.max(this.g.j(q2), this.g.j(q3));
            d2 = arrd[1];
            if (q2.b() == 1) {
                d2 = Math.max(d2, this.g.j(q2.n().e()));
            }
            if (q3.c() == 1) {
                d2 = Math.max(d2, this.g.j(q3.o().e()));
            }
            arrd[1] = d2;
            if (arrd[1] < arrd[0]) {
                arrd[1] = arrd[0];
            }
            d3 = arrd[1];
        }
        block0 : do {
            q q4 = (q)p2.c();
            if (!bl3 && Math.abs(this.g.j(q4) - d3) > 5.0) {
                bl3 = true;
            }
            this.g.a(q4, d3, this.g.k(q4));
            p2 = p2.a();
            do {
                if (p2 != p3.a()) continue block0;
                this.u.c();
            } while (bl2);
            break;
        } while (true);
        return bl3;
    }

    protected boolean h(q q2) {
        if (q2.b() == 1) {
            if (q2.c() >= 2) return false;
            return true;
        }
        if (q2.c() != 1) return false;
        if (q2.b() >= 2) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected void h() {
        var8_1 = a.i;
        this.v.c();
        var1_2 = new y(this.g.o());
        var2_3 = new boolean[this.g.f()];
        var3_4 = 0;
        block0 : do lbl-1000: // 3 sources:
        {
            v0 = var1_2.isEmpty();
            block1 : while (!v0 && var3_4 < this.g.f() * this.g.f()) {
                ++var3_4;
                var4_5 = var1_2.d();
                var2_3[var4_5.d()] = true;
                var5_6 = this.a(var4_5, var4_5.j());
                if (Math.abs(var5_6 = this.a(var4_5, var5_6)) <= 1.0E-5) ** GOTO lbl-1000
                this.b(var4_5, var5_6);
                if (var8_1 != false) return;
                var7_7 = var4_5.m();
                do {
                    if (!var7_7.f()) continue block0;
                    v0 = var2_3[var7_7.e().d()];
                    if (var8_1) continue block1;
                    if (v0) {
                        var2_3[var7_7.e().d()] = false;
                        var1_2.b(var7_7.e());
                    }
                    var7_7.g();
                } while (!var8_1);
            }
            break block0;
            break;
        } while (true);
        this.v.c();
    }

    /*
     * Unable to fully structure code
     */
    protected void a(D var1_1, int var2_2) {
        var7_3 = a.i;
        this.w.c();
        var3_4 = var1_1.m();
        while (var3_4.f()) {
            var4_5 = (y)var3_4.d();
            var5_6 = this.a(var4_5.m(), var2_2);
            if (var7_3 != false) return;
            if (var5_6 >= 0.0) ** GOTO lbl-1000
            var5_6 = this.a(var4_5.b(), var5_6);
            this.a(var4_5.m(), var5_6);
            if (var7_3) lbl-1000: // 2 sources:
            {
                var5_6 = this.a((q)var4_5.i(), var5_6);
                this.a(var4_5.m(), var5_6);
            }
            var3_4.g();
            if (!var7_3) continue;
        }
        this.w.c();
    }

    /*
     * Unable to fully structure code
     */
    protected D a(y var1_1, int var2_2) {
        block6 : {
            var13_3 = a.i;
            this.x.c();
            var3_4 = new D();
            var4_5 = var1_1.a();
            while (var4_5.f()) {
                var5_7 = new y();
                var5_7.add(var4_5.e());
                v0 = var3_4.add(var5_7);
                if (!var13_3) {
                    var4_5.g();
                    if (!var13_3) continue;
                }
                break block6;
            }
            v0 = false;
        }
        var4_6 = v0;
        block1 : do {
            var4_6 = false;
            var5_7 = var3_4.k();
            block2 : while (var5_7 != null) {
                v1 = var5_7.c();
                do {
                    var6_8 = (y)v1;
                    if ((var5_7 = var5_7.a()) == null) continue block2;
                    var7_9 = (y)var5_7.c();
                    v2 = this.a((q)var6_8.i(), var7_9.b());
                    if (!var13_3) {
                        if (!v2 || (var8_10 = this.a(var6_8.m(), var2_2)) < (var10_11 = this.a(var7_9.m(), var2_2))) continue block2;
                        var4_6 = true;
                        var6_8.a(var7_9.m());
                        var12_12 = var5_7;
                        var3_4.h((p)var12_12);
                        var5_7 = var5_7.a();
                        if (!var13_3) continue block2;
                    }
                    ** GOTO lbl36
                    v2 = var4_6;
lbl36: // 2 sources:
                    if (v2) continue block1;
                    this.x.c();
                    v1 = var3_4;
                } while (var13_3);
            }
            break;
        } while (true);
        return v1;
    }

    protected double a(q q2, e e2) {
        boolean bl2 = a.i;
        double d2 = 0.0;
        double d3 = 0.0;
        e2.i();
        while (e2.f()) {
            d d4 = e2.a();
            double d5 = this.a(d4);
            d3 += d5;
            d2 += d5 * (this.g.j(d4.a(q2)) - this.g.j(q2));
            e2.g();
            if (bl2) return d2 / d3;
            if (!bl2) continue;
        }
        if (d2 != 0.0) return d2 / d3;
        return 0.0;
    }

    protected boolean a(q q2, q q3) {
        if (this.o.b(q2) == q3) {
            if (this.a(q3) - this.b(q2) - 1.0E-5 >= this.b(q2, false)) return false;
            return true;
        }
        if (this.p.b(q2) != q3) return false;
        if (this.a(q2) - this.b(q3) - 1.0E-5 >= this.b(q2, true)) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    protected double a(q var1_1, double var2_2) {
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
    protected double a(C var1_1, int var2_2) {
        var7_3 = a.i;
        this.y.c();
        var3_4 = 0;
        var4_5 = 0.0;
        var1_1.i();
        while (var1_1.f()) {
            ++var3_4;
            var6_6 = (q)var1_1.d();
            if (var7_3 != false) return var4_5 / (double)var3_4;
            if (var2_2 != -1) ** GOTO lbl13
            var4_5 += this.a(var6_6, var6_6.k());
            if (!var7_3) ** GOTO lbl17
lbl13: // 2 sources:
            if (var2_2 != 0) ** GOTO lbl-1000
            var4_5 += this.a(var6_6, var6_6.j());
            if (var7_3) lbl-1000: // 2 sources:
            {
                var4_5 += this.a(var6_6, var6_6.l());
            }
lbl17: // 4 sources:
            var1_1.g();
            if (!var7_3) continue;
        }
        this.y.c();
        return var4_5 / (double)var3_4;
    }

    /*
     * Unable to fully structure code
     */
    protected void b(q var1_1, double var2_2) {
        var4_3 = this.g.j(var1_1) + var2_2;
        if (!this.C) ** GOTO lbl7
        if (this.e.b(var1_1) != null) ** GOTO lbl-1000
        var4_3 = (double)((int)((var4_3 + this.E / 2.0) / this.E)) * this.E;
        if (a.i) lbl-1000: // 2 sources:
        {
            var4_3 = (double)((int)((var4_3 + this.D / 2.0) / this.D)) * this.D;
        }
lbl7: // 4 sources:
        this.g.a(var1_1, var4_3, this.g.k(var1_1));
    }

    protected void a(C c2, double d2) {
        boolean bl2 = a.i;
        c2.i();
        do {
            if (!c2.f()) return;
            q q2 = (q)c2.d();
            this.b(q2, d2);
            c2.g();
        } while (!bl2);
    }

    protected double i() {
        boolean bl2 = a.i;
        this.A.c();
        double d2 = 0.0;
        x x2 = this.g.o();
        while (x2.f()) {
            block3 : {
                e e2 = x2.e().j();
                while (e2.f()) {
                    d d3 = e2.a();
                    d2 += this.a(d3) * Math.abs(this.g.j(d3.c()) - this.g.j(d3.d()));
                    e2.g();
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block3;
                }
                x2.g();
            }
            if (!bl2) continue;
        }
        this.A.c();
        return d2;
    }

    protected double a(d d2) {
        if (this.e.b(d2.c()) == null) {
            if (this.e.b(d2.d()) != null) return this.G * 1.0;
            return 1.0;
        }
        if (this.e.b(d2.d()) != null) return this.F * 1.0;
        return this.G * 1.0;
    }

    protected double a(q q2, boolean bl2) {
        if (bl2) {
            q q3 = (q)this.p.b(q2);
            if (q3 != null) return this.b(q3) + this.b(q2, true) + this.e(q2);
            return -1.7976931348623157E308;
        }
        q q4 = (q)this.o.b(q2);
        if (q4 != null) return this.a(q4) - this.b(q2, false) - this.f(q2);
        return Double.MAX_VALUE;
    }

    /*
     * Unable to fully structure code
     */
    protected double b(q var1_1, boolean var2_2) {
        if (!var2_2) ** GOTO lbl-1000
        if (this.p.b(var1_1) == null) {
            return 0.0;
        }
        var3_3 = (q)this.p.b(var1_1);
        if (a.i) lbl-1000: // 2 sources:
        {
            if (this.o.b(var1_1) == null) {
                return 0.0;
            }
            var3_3 = (q)this.o.b(var1_1);
        }
        var4_4 = (d)this.e.b(var1_1);
        var5_5 = (d)this.e.b(var3_3);
        if (var4_4 == null) return this.c();
        if (var5_5 == null) {
            return this.c();
        }
        if (var4_4.d() == var5_5.c()) return this.b();
        if (var4_4.d() != var5_5.d()) return this.a();
        return this.b();
    }

    /*
     * Unable to fully structure code
     */
    protected void b(y[] var1_1) {
        var8_2 = a.i;
        this.B.c();
        this.a(this.g, var1_1);
        var2_3 = 0;
        while (var2_3 < var1_1.length) {
            block4 : {
                var3_4 = 0.0;
                var5_5 = null;
                if (var8_2 != false) return;
                var6_6 = var1_1[var2_3].a();
                while (var6_6.f()) {
                    var7_7 = var6_6.e();
                    if (var8_2) break block4;
                    if (var5_5 != null) {
                        this.o.a((Object)var5_5, var7_7);
                        this.p.a((Object)var7_7, var5_5);
                    }
                    var5_5 = var7_7;
                    var3_4 += this.g.a(var7_7).getWidth() / 2.0 + this.c(var7_7) + this.b(var7_7, true);
                    if (!this.C) ** GOTO lbl23
                    if (this.e.b(var7_7) != null) ** GOTO lbl-1000
                    var3_4 = (double)((int)((var3_4 + this.E / 2.0) / this.E)) * this.E;
                    if (var8_2) lbl-1000: // 2 sources:
                    {
                        var3_4 = (double)((int)((var3_4 + this.D / 2.0) / this.D)) * this.D;
                    }
lbl23: // 4 sources:
                    this.g.a(var7_7, var3_4, this.g.k(var7_7));
                    var3_4 += this.g.a(var7_7).getWidth() / 2.0 + this.d(var7_7);
                    var6_6.g();
                    if (!var8_2) continue;
                }
                ++var2_3;
            }
            if (!var8_2) continue;
        }
        this.B.c();
    }
}

