/*
 * Decompiled with CFR 0_115.
 */
package y.f.a;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import y.a.b;
import y.a.h;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.g;
import y.d.m;
import y.d.o;
import y.d.t;
import y.d.y;
import y.f.I;
import y.f.X;
import y.f.a.A;
import y.f.a.B;
import y.f.a.C;
import y.f.a.E;
import y.f.a.F;
import y.f.a.f;
import y.f.ae;
import y.f.am;
import y.f.c;
import y.g.M;

class z
extends c {
    private int n = 10;
    private int o = 10;
    private int p = 1;
    private X q;
    private HashMap r;
    private y.c.c s;
    private y.c.c t;
    private y.c.c u;
    private byte v = 0;
    private byte w = 1;

    z() {
    }

    public void a(int n2) {
        this.n = n2;
    }

    public void b(int n2) {
        this.o = n2;
    }

    private D a(q q2) {
        if (this.t != null) return (D)this.t.b(q2);
        return null;
    }

    private D a(d d2) {
        if (this.u != null) return (D)this.u.b(d2);
        return null;
    }

    private boolean b(q q2) {
        if (this.s == null) return true;
        if (this.s.a(q2) == 0) return true;
        return false;
    }

    private boolean c(q q2) {
        if (this.s == null) return false;
        if (this.s.a(q2) != 1) return false;
        return true;
    }

    @Override
    public void a(X x2) {
        int n2;
        block5 : {
            Object object;
            n2 = f.u;
            this.r = new HashMap();
            this.q = x2;
            this.s = x2.c("NODE_SHAPE_DP");
            this.t = x2.c("NODE_TO_LABEL_BOXES");
            this.u = x2.c("EDGE_TO_MULTI_EDGES");
            this.o = Math.max(1, this.o);
            this.p = Math.max(1, this.p);
            q q3 = this.a();
            y.c.f f2 = y.a.A.a((i)x2, q3);
            Object object2 = f2.a();
            while (object2.f()) {
                object = object2.a();
                ae.a(x2.g((d)object));
                object2.g();
                if (n2 == 0) continue;
            }
            object2 = new y.c.y(x2.o());
            object = x2.t();
            this.b(q3, (y.c.A)object);
            y.c.A a2 = x2.t();
            this.a(q3, a2);
            y.c.A a3 = x2.t();
            this.a(a3);
            object2.sort(new F((y.c.A)object, a2, a3));
            D d2 = this.n();
            y.c.A a4 = x2.t();
            y.c.C c2 = object2.a();
            while (c2.f()) {
                q q2 = c2.e();
                if (q2 != q3) {
                    d d3 = this.f(q2);
                    this.a(d3, a4, d2);
                }
                c2.g();
                if (n2 == 0) continue;
            }
            c2 = f2.a();
            while (c2.f()) {
                d d4 = c2.a();
                x2.c(d4);
                ae.a(x2.g(d4));
                c2.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block5;
            }
            x2.a(a4);
            x2.a(a3);
            x2.a((y.c.A)object);
            x2.a(a2);
        }
        if (!i.g) return;
        f.u = ++n2;
    }

    private void a(y.c.A a2) {
        int n2 = f.u;
        x x2 = this.q.o();
        block0 : do {
            x x3;
            block7 : {
                if (!x2.f()) return;
                q q2 = x2.e();
                if (q2.c() > 4) {
                    t t2 = this.q.l(q2);
                    t t3 = q2.b() > 0 ? this.q.l(q2.g().c()) : null;
                    double d2 = t3 == null ? 3.141592653589793 : z.b(t2, t3);
                    A a3 = new A(this, t2, d2);
                    y.c.f f2 = new y.c.f(q2.l());
                    f2.sort(a3);
                    y.c.y y2 = new y.c.y();
                    e e2 = f2.a();
                    while (e2.f()) {
                        y2.add(e2.a().d());
                        e2.g();
                        if (n2 != 0) continue block0;
                        if (n2 == 0) continue;
                    }
                    int n3 = 1;
                    block2 : do {
                        boolean bl2 = y2.isEmpty();
                        block3 : while (!bl2) {
                            boolean bl3 = true;
                            x3 = y2.a();
                            if (n2 != 0) break block7;
                            x x4 = x3;
                            while (x4.f()) {
                                bl2 = bl3;
                                if (n2 != 0) continue block3;
                                if (bl2) {
                                    a2.a(y2.b(x4), n3);
                                }
                                bl3 = !bl3;
                                x4.g();
                                if (n2 == 0) continue;
                            }
                            ++n3;
                            if (n2 == 0) continue block2;
                        }
                        break block2;
                        break;
                    } while (true);
                }
                x3 = x2;
            }
            x3.g();
        } while (n2 == 0);
    }

    private static double b(t t2, t t3) {
        double d2 = t3.a - t2.a;
        double d3 = t3.b - t2.b;
        return Math.atan2(d3, d2);
    }

    private t a(m m2) {
        return t.c(m2.c(), m2.d());
    }

    /*
     * Unable to fully structure code
     */
    private void a(d var1_1, y.c.A var2_2, D var3_3) {
        var12_4 = f.u;
        var4_5 = var1_1.d();
        var5_6 = M.a(new boolean[this.q.f()]);
        var6_7 = this.e(var4_5);
        var7_8 = var6_7.a();
        while (var7_8.f()) {
            var5_6.a((Object)var7_8.e(), true);
            var7_8.g();
            if (var12_4 == 0) continue;
        }
        var7_8 = new m(this.q.q(var1_1), this.q.p(var1_1));
        var8_9 = this.a((m)var7_8, var6_7, this.o);
        var9_10 = this.a(var5_6, var8_9, var3_3);
        do lbl-1000: // 3 sources:
        {
            if (var7_8.g() <= 10.0) return;
            this.a(var6_7.a(), var2_2);
            var10_11 = var7_8.c();
            var11_12 = this.a((m)var7_8);
            ae.a(this.q, var6_7.a(), var11_12.a() - var10_11.a(), var11_12.b() - var10_11.b());
            if (!this.a(var1_1, var9_10)) ** GOTO lbl22
            var7_8 = new m(this.a((m)var7_8), var7_8.d());
            if (var12_4 == 0) ** GOTO lbl-1000
lbl22: // 2 sources:
            var7_8 = new m(var7_8.c(), this.a((m)var7_8));
            this.b(var6_7.a(), var2_2);
        } while (var12_4 == 0);
    }

    /*
     * Exception decompiling
     */
    private D[] a(y.c.A var1_1, y var2_2, D var3_3) {
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
    private y a(m var1_1, y.c.y var2_2, double var3_3) {
        var20_4 = f.u;
        var5_5 = var1_1.d().a() - var1_1.c().a();
        var7_6 = var1_1.d().b() - var1_1.c().b();
        var9_7 = Double.MAX_VALUE;
        var11_8 = Double.MAX_VALUE;
        var13_9 = -1.7976931348623157E308;
        var15_10 = -1.7976931348623157E308;
        var17_11 = var2_2.a();
        do {
            if (var17_11.f() == false) return new y(var9_7 - var3_3, var11_8 - var3_3, var13_9 - var9_7 + 2.0 * var3_3, var15_10 - var11_8 + 2.0 * var3_3);
            var18_12 = var17_11.e();
            var19_13 = this.q.h(var18_12);
            if (var5_5 <= 0.0) ** GOTO lbl-1000
            var9_7 = Math.min(var9_7, var19_13.getX());
            var13_9 = Math.max(var13_9, var19_13.getX() + var19_13.getWidth() + var5_5);
            if (var20_4 != 0) lbl-1000: // 2 sources:
            {
                var9_7 = Math.min(var9_7, var19_13.getX() + var5_5);
                var13_9 = Math.max(var13_9, var19_13.getX() + var19_13.getWidth());
            }
            if (var7_6 <= 0.0) ** GOTO lbl-1000
            var11_8 = Math.min(var11_8, var19_13.getY());
            var15_10 = Math.max(var15_10, var19_13.getY() + var19_13.getHeight() + var7_6);
            if (var20_4 != 0) lbl-1000: // 2 sources:
            {
                var11_8 = Math.min(var11_8, var19_13.getY() + var7_6);
                var15_10 = Math.max(var15_10, var19_13.getY() + var19_13.getHeight());
            }
            var17_11.g();
        } while (var20_4 == 0);
        return new y(var9_7 - var3_3, var11_8 - var3_3, var13_9 - var9_7 + 2.0 * var3_3, var15_10 - var11_8 + 2.0 * var3_3);
    }

    private void a(x x2, y.c.A a2) {
        int n2 = f.u;
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            a2.a((Object)q2, this.q.l(q2));
            x2.g();
        } while (n2 == 0);
    }

    private void b(x x2, y.c.A a2) {
        int n2 = f.u;
        do {
            if (!x2.f()) return;
            q q2 = x2.e();
            this.q.a(q2, (t)a2.b(q2));
            x2.g();
        } while (n2 == 0);
    }

    private double d(q q2) {
        return Math.max(this.q.p(q2), this.q.q(q2)) * 0.5;
    }

    private boolean a(d d2, D[] arrd) {
        int n2;
        int n3 = f.u;
        double d3 = t.a(this.q.p(d2), this.q.q(d2));
        if (d3 < (double)this.n) {
            return false;
        }
        D d4 = this.a(d2);
        if (d4 != null) {
            y.c.C c2 = d4.m();
            while (c2.f()) {
                C c3 = (C)c2.d();
                d3 = c3.a(this.q).g();
                n2 = d3 DCMPG (double)this.n;
                if (n3 == 0) {
                    if (n2 < 0) {
                        return false;
                    }
                    c2.g();
                    if (n3 == 0) continue;
                }
                break;
            }
        } else {
            n2 = this.a(arrd, d2);
        }
        if (n2 == 0) return true;
        return false;
    }

    private boolean a(B b2, B b3) {
        q q2 = (q)b2.i();
        q q3 = (q)b3.i();
        if (!y.a(b2.h(), b3.h())) {
            return false;
        }
        if (this.b(q2) && this.b(q3)) {
            return true;
        }
        if (this.c(q2) && this.c(q3)) {
            double d2 = Math.max(b2.h().a(), b2.h().b()) * 0.5;
            double d3 = Math.max(b3.h().a(), b3.h().b()) * 0.5;
            if (t.a(this.q.l(q2), this.q.l(q3)) - d2 - d3 >= 0.0) return false;
            return true;
        }
        B b4 = this.b(q2) ? b2 : b3;
        B b5 = this.c(q2) ? b2 : b3;
        double d4 = b4.h().a();
        double d5 = b4.h().b();
        double d6 = Math.sqrt(d5 * d5 + d4 * d4) * 0.5;
        double d7 = Math.max(b5.h().a(), b5.h().b()) * 0.5;
        if (t.a(this.q.l(q2), this.q.l(q3)) - d7 - d6 >= 0.0) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(q var1_1, m var2_2) {
        if (!y.a(this.q.s(var1_1), var2_2.h())) {
            return false;
        }
        var3_3 = 0.0;
        if (!this.c(var1_1)) ** GOTO lbl-1000
        var3_3 = z.a(var2_2, this.q.l(var1_1)) - this.d(var1_1) - (double)this.p;
        if (f.u != 0) lbl-1000: // 2 sources:
        {
            var5_4 = t.a(this.q.l(var1_1), this.q.o(var1_1));
            var3_3 = z.a(var2_2, this.q.l(var1_1)) - var5_4 - (double)this.p;
        }
        if (var3_3 >= 0.0) return false;
        return true;
    }

    private static y a(y y2, double d2) {
        t t2 = y2.e();
        return new y(t2.a() - d2, t2.b() - d2, y2.a() + 2.0 * d2, y2.b() + 2.0 * d2);
    }

    private boolean b(B b2, B b3) {
        q q2 = (q)b2.i();
        y y2 = b3.h();
        if (!y.a(b2.d(), y2)) {
            return false;
        }
        if (this.b(q2)) {
            return true;
        }
        double d2 = Math.sqrt(y2.b() * y2.b() + y2.a() * y2.a()) * 0.5;
        double d3 = Math.max(b2.d().a(), b2.d().b()) * 0.5;
        t t2 = new t(y2.c() + y2.a() * 0.5, y2.d() + y2.b() * 0.5);
        if (t.a(this.q.l(q2), t2) - d3 - d2 >= 0.0) return false;
        return true;
    }

    private boolean c(B b2, B b3) {
        int n2 = b2.c() ? 1 : 0;
        if ((n2 += b3.c() ? 1 : 0) != 1) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private static double a(m var0, t var1_1) {
        var2_2 = var0.c().a;
        var4_3 = var0.d().a;
        var6_4 = var0.c().b;
        var8_5 = var0.d().b;
        var10_6 = var1_1.a();
        var12_7 = var1_1.b();
        var14_8 = 0.0;
        var16_9 = (var10_6 -= var2_2) * (var4_3 -= var2_2) + (var12_7 -= var6_4) * (var8_5 -= var6_4);
        if (var16_9 <= 0.0) ** GOTO lbl15
        var16_9 = (var10_6 = var4_3 - var10_6) * var4_3 + (var12_7 = var8_5 - var12_7) * var8_5;
        if (var16_9 > 0.0) ** GOTO lbl-1000
        var14_8 = 0.0;
        if (f.u != 0) lbl-1000: // 2 sources:
        {
            var14_8 = var16_9 * var16_9 / (var4_3 * var4_3 + var8_5 * var8_5);
        }
lbl15: // 4 sources:
        if ((var18_10 = var10_6 * var10_6 + var12_7 * var12_7 - var14_8) >= 0.0) return Math.sqrt(var18_10);
        return 0.0;
    }

    /*
     * Exception decompiling
     */
    private boolean a(D[] var1_1, d var2_2) {
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

    private D n() {
        Object object2;
        Object object;
        Object object3;
        D d2;
        int n3;
        int n2;
        D d22;
        y y2;
        block11 : {
            z z2;
            n3 = f.u;
            d22 = new D();
            n2 = 1;
            object2 = this.q.o();
            while (object2.f()) {
                q q2 = object2.e();
                d22.add(new B(this, (Object)q2, n2++, (o)this.q.s(q2), this.q.s(q2), 0));
                z2 = this;
                if (n3 == 0) {
                    d2 = z2.a(q2);
                    if (d2 != null && !d2.isEmpty()) {
                        object3 = this.q.l(q2);
                        object = d2.m();
                        while (object.f()) {
                            y2 = (y)object.d();
                            y y3 = new y(object3.a() + y2.c(), object3.b() + y2.d(), y2.a(), y2.b());
                            d22.add(new B(this, (Object)q2, n2++, (o)y3, y2, 2));
                            object.g();
                            if (n3 == 0) {
                                if (n3 == 0) continue;
                            }
                            break;
                        }
                    } else {
                        object2.g();
                    }
                    if (n3 == 0) continue;
                }
                break block11;
            }
            z2 = this;
        }
        object2 = z2.q.p();
        while (object2.f()) {
            d d3 = object2.a();
            d22.add(new B(this, d3, n2++, this.b(d3), 1));
            d2 = this.a(d3);
            if (d2 != null && !d2.isEmpty()) {
                object3 = d2.m();
                while (object3.f()) {
                    object = (C)object3.d();
                    y2 = object.a(this.q);
                    d22.add(new B(this, (Object)d3, n2++, (o)y2, 1, (C)object));
                    object3.g();
                    if (n3 == 0) {
                        if (n3 == 0) continue;
                    }
                    break;
                }
            } else {
                object2.g();
            }
            if (n3 == 0) continue;
        }
        object2 = new E(this, true);
        y.d.f.a(d22, (g)object2);
        return d22;
    }

    private m b(d d2) {
        return new m(this.q.p(d2), this.q.q(d2));
    }

    private y.c.y e(q q2) {
        y.c.y y2 = new y.c.y(q2);
        z.a(q2, y2);
        return y2;
    }

    private static void a(q q2, y.c.y y2) {
        int n2 = f.u;
        x x2 = q2.o();
        do {
            if (!x2.f()) return;
            q q3 = x2.e();
            y2.b(q3);
            z.a(q3, y2);
            x2.g();
        } while (n2 == 0);
    }

    private d f(q q2) {
        e e2 = q2.k();
        if (e2.k() > 1) {
            System.out.println(new StringBuffer().append("wrong tree structure: node ").append(q2).append(" has multiple parents").toString());
        }
        if (!e2.f()) return null;
        d d2 = e2.a();
        return d2;
    }

    public void a(q q2, y.c.A a2) {
        this.c(q2, a2);
    }

    private double c(q q2, y.c.A a2) {
        q q3;
        int n2 = f.u;
        double d2 = this.q.p(q2) * this.q.q(q2);
        for (d d3 = q2.f(); d3 != null; d2 += this.c((q)q3, (y.c.A)a2), d3 = d3.g()) {
            q3 = d3.d();
            if (n2 != 0) return d2;
            if (n2 == 0) continue;
        }
        a2.a((Object)q2, d2);
        return d2;
    }

    public void b(q q2, y.c.A a2) {
        b.a((i)this.q, new y.c.y(q2), a2);
    }

    public q a() {
        return y.a.A.d(this.q);
    }

    @Override
    public boolean b(X x2) {
        if (!y.a.A.b(x2)) return false;
        if (!h.c(x2)) return false;
        return true;
    }

    static X a(z z2) {
        return z2.q;
    }

    static double a(t t2, t t3) {
        return z.b(t2, t3);
    }

    static HashMap b(z z2) {
        return z2.r;
    }

    static boolean a(z z2, B b2, B b3) {
        return z2.b(b2, b3);
    }

    static boolean b(z z2, B b2, B b3) {
        return z2.c(b2, b3);
    }

    static boolean c(z z2, B b2, B b3) {
        return z2.a(b2, b3);
    }

    static boolean a(z z2, q q2, m m2) {
        return z2.a(q2, m2);
    }
}

