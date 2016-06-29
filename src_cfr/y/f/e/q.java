/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import y.a.b;
import y.f.X;
import y.f.aN;
import y.f.ad;
import y.f.ae;
import y.f.aj;
import y.f.as;
import y.f.c;
import y.f.e;
import y.f.e.A;
import y.f.e.a;
import y.f.e.a.J;
import y.f.e.a.Y;
import y.f.e.a.am;
import y.f.e.a.aw;
import y.f.e.a.ax;
import y.f.e.a.ay;
import y.f.e.a.h;
import y.f.e.a.o;
import y.f.e.a.p;
import y.f.e.d;
import y.f.e.i;
import y.f.e.t;
import y.f.e.x;
import y.f.e.y;
import y.f.e.z;
import y.g.M;

public class q
extends c {
    private long t;
    private double u = 0.6;
    private long v = 30000;
    public static final Object n = d.n;
    public static final Object o = "y.layout.organic.SmartOrganicLayouter.GROUP_NODE_MODE_DATA";
    public static final Object p = "GROUP_NODE_MODE_NORMAL";
    public static final Object q = "GROUP_NODE_MODE_FIX_BOUNDS";
    public static final Object r = "GROUP_NODE_MODE_FIX_CONTENTS";
    public static final Object s = d.p;
    private byte w = 0;
    private double x = 0.5;
    private double y = 0.4;
    private double z;
    private double A;
    private boolean B;
    private boolean C;
    private double D;
    private boolean E;
    private y.f.b.a F;
    private i G;
    private boolean H;
    private short I;
    private boolean J;
    private double K;
    private boolean L;
    private double M;
    private boolean N;
    private boolean O;
    private y.c.A P;

    public double a() {
        return this.y;
    }

    public boolean n() {
        return this.N;
    }

    public q() {
        this.A = this.z = 40.0;
        this.F = new y.f.b.h();
        this.G = i.a;
        this.I = 1;
        this.L = false;
        this.M = 0.5;
        this.N = true;
        this.d(false);
        ((aN)this.c()).a(1);
    }

    public y.f.b.a o() {
        return this.F;
    }

    /*
     * Exception decompiling
     */
    protected void a(X var1_1, e var2_2) {
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
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void c(X x2) {
        Object object;
        y.c.h h2 = x2.u();
        y.c.A a2 = x2.t();
        q.a(x2, h2, a2, this.p());
        y.c.q q2 = null;
        y.d.t t2 = null;
        Object object2 = x2.o();
        while (object2.f()) {
            object = object2.e();
            if (!a2.d(object)) {
                q2 = object;
                t2 = x2.l((y.c.q)object);
                break;
            }
            object2.g();
        }
        object2 = null;
        if (this.L) {
            object2 = new y(this, x2);
            object2.a(a2);
        }
        object = null;
        if (this.e() instanceof e) {
            object = (e)this.e();
            this.a(x2, (e)object);
        }
        as as2 = null;
        y.c.h h3 = null;
        if (this.l() && this.d() instanceof as) {
            as2 = (as)this.d();
            if (x2.c(as.a) == null) {
                h3 = h2;
                x2.a(as.a, h3);
            }
        }
        aN aN2 = null;
        t t3 = null;
        if (this.j() && this.c() instanceof aN) {
            aN2 = (aN)this.c();
            y.c.c c2 = x2.c(aN.a);
            if (c2 == null) {
                t3 = new t(this, a2);
                x2.a(aN.a, t3);
            }
        }
        try {
            super.c(x2);
            Object var14_13 = null;
            if (object != null) {
                this.b(x2, (e)object);
            }
            if (h3 != null) {
                x2.d_(as.a);
            }
            if (t3 != null) {
                x2.d_(aN.a);
            }
            x2.a(h2);
            x2.a(a2);
            if (this.L) {
                object2.a();
            }
            if (q2 == null) return;
            double d2 = t2.a - x2.j(q2);
            double d3 = t2.b - x2.k(q2);
            if (d2 == 0.0) {
                if (d3 == 0.0) return;
            }
            ae.a(x2, x2.o(), d2, d3);
            return;
        }
        catch (Throwable var13_19) {
            Object var14_14 = null;
            if (object != null) {
                this.b(x2, (e)object);
            }
            if (h3 != null) {
                x2.d_(as.a);
            }
            if (t3 != null) {
                x2.d_(aN.a);
            }
            x2.a(h2);
            x2.a(a2);
            if (this.L) {
                object2.a();
            }
            if (q2 == null) throw var13_19;
            double d4 = t2.a - x2.j(q2);
            double d5 = t2.b - x2.k(q2);
            if (d4 == 0.0) {
                if (d5 == 0.0) throw var13_19;
            }
            ae.a(x2, x2.o(), d4, d5);
            throw var13_19;
        }
    }

    protected void b(X x2, e e2) {
        if (this.J) {
            x2.d_(e.b);
        }
        e2.b(this.K);
    }

    @Override
    protected boolean b(X x2) {
        if (x2 == null) return false;
        return true;
    }

    private void d(X x2) {
        boolean bl2 = i.b;
        if (!this.O) return;
        this.P = x2.t();
        y.c.x x3 = x2.o();
        do {
            y.c.q q2;
            y.d.y y2;
            block3 : {
                if (!x3.f()) return;
                q2 = x3.e();
                y2 = x2.s(q2);
                aj[] arraj = x2.a_(q2);
                for (int i2 = 0; i2 < arraj.length; ++i2) {
                    aj aj2 = arraj[i2];
                    y2 = this.a(y2, aj2.getBox());
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block3;
                }
                this.P.a((Object)q2, x2.r(q2));
            }
            y.d.t t2 = x2.l(q2);
            double d2 = Math.floor(Math.max(t2.a() - y2.c(), y2.c() + y2.a() - t2.a()) + 1.0E-5);
            double d3 = Math.floor(Math.max(t2.b() - y2.d(), y2.d() + y2.b() - t2.b()) + 1.0E-5);
            x2.b(q2, 2.0 * d2, 2.0 * d3);
            x2.a(q2, t2);
            x3.g();
        } while (!bl2);
    }

    private void e(X x2) {
        boolean bl2 = i.b;
        if (!this.O) return;
        y.c.x x3 = x2.o();
        while (x3.f()) {
            y.c.q q2 = x3.e();
            y.d.t t2 = x2.l(q2);
            x2.a(q2, (y.d.q)this.P.b(q2));
            x2.a(q2, t2);
            x3.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        x2.a(this.P);
    }

    private y.d.y a(y.d.y y2, y.d.y y3) {
        y.d.y y4;
        if (y2 != null && y3 != null) {
            double d2 = Math.min(y2.c(), y3.c());
            double d3 = Math.max(y2.c() + y2.a(), y3.c() + y3.a());
            double d4 = Math.min(y2.d(), y3.d());
            double d5 = Math.max(y2.d() + y2.b(), y3.d() + y3.b());
            return new y.d.y(d2, d4, d3 - d2, d5 - d4);
        }
        if (y2 == null) {
            y4 = y3;
            return y4;
        }
        y4 = y2;
        return y4;
    }

    private y.c.c a(X x2, y.c.c c2) {
        y.f.b.c c3;
        y.c.A a2;
        block9 : {
            y.f.b.c c4;
            y.c.c c5;
            Object object;
            Object object2;
            y.c.A a3;
            boolean bl2;
            block8 : {
                bl2 = i.b;
                c4 = new y.f.b.c(x2);
                a3 = M.a();
                a2 = M.a();
                object = x2.o();
                while (object.f()) {
                    object2 = object.e();
                    c5 = a2;
                    if (!bl2) {
                        c5.a(object2, c2.d(object2));
                        object.g();
                        if (!bl2) continue;
                    }
                    break block8;
                }
                c5 = x2.c(o);
            }
            object = c5;
            object2 = x2.o();
            while (object2.f()) {
                y.c.q q2 = object2.e();
                c3 = c4;
                if (!bl2) {
                    if (c3.d(q2) && this.a(q2, (y.c.c)object) && !a3.d(q2)) {
                        y.c.y y2 = c4.c(q2);
                        y.c.x x3 = y2.a();
                        while (x3.f()) {
                            y.c.q q3 = x3.e();
                            a2.a((Object)q3, false);
                            a3.a((Object)q3, true);
                            x3.g();
                            if (!bl2) {
                                if (!bl2) continue;
                            }
                            break;
                        }
                    } else {
                        object2.g();
                    }
                    if (!bl2) continue;
                }
                break block9;
            }
            c3 = c4;
        }
        c3.c();
        return a2;
    }

    private boolean a(y.c.q q2, y.c.c c2) {
        if (this.I == 2) return true;
        if (c2 == null) return false;
        if (c2.b(q2) != r) return false;
        return true;
    }

    private boolean a(y.c.q q2, y.c.c c2, X x2) {
        if (this.I == 3) {
            y.c.c c3 = x2.c(y.f.e.a.as.a);
            if (c3 == null) return true;
            return c3.d(q2);
        }
        if (c2 == null) return false;
        if (c2.b(q2) != q) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    @Override
    protected void a(X var1_1) {
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

    private void f(X x2) {
        boolean bl2 = i.b;
        switch (this.I) {
            default: {
                if (!bl2) break;
            }
            case 3: {
                x2.d_(y.f.e.a.as.a);
                if (!bl2) break;
            }
            case 2: {
                x2.d_(d.o);
            }
        }
        this.I = 1;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private static void a(X var0, y.c.a var1_1, y.c.a var2_2, int var3_3) {
        block24 : {
            var14_4 = i.b;
            var4_5 = var0.c(q.n);
            var5_6 = var0.c(q.o);
            if (var5_6 == null && var4_5 == null) ** GOTO lbl96
            var6_7 = new int[var0.e()];
            if (var4_5 == null || var3_3 == 0) ** GOTO lbl28
            if (var3_3 != 1) ** GOTO lbl20
            var7_8 = new int[var0.e()];
            var8_9 = M.a((int[])var7_8);
            b.a((y.c.i)var0, var4_5, (y.c.A)var8_9);
            var9_12 = var0.o();
            while (var9_12.f()) {
                var10_14 = var4_5.d(var9_12.e());
                var11_15 = var7_8[var9_12.e().d()];
                if (!var14_4) {
                    var6_7[var9_12.e().d()] = var10_14 == false && (var11_15 < 0 || var11_15 >= 5);
                    var9_12.g();
                    if (!var14_4) continue;
                }
                break block24;
lbl20: // 2 sources:
                var7_8 = var0.o();
                while (var7_8.f()) {
                    var8_10 = var4_5.d(var7_8.e());
                    if (!var14_4) {
                        var6_7[var7_8.e().d()] = var8_10 == false;
                        var7_8.g();
                        if (!var14_4) continue;
                    }
                    break block24;
                }
                break block2;
            }
lbl28: // 4 sources:
            if (y.f.b.c.b(var0)) {
                var7_8 = new y.f.b.c(var0);
                try {
                    block25 : {
                        var8_11 = 0;
                        var9_12 = var0.o();
                        while (var9_12.f()) {
                            var10_14 = var9_12.e();
                            v0 = (int)var7_8.d((y.c.q)var10_14) ? 1 : 0;
                            if (!var14_4) {
                                if (v0 != 0) {
                                    var11_15 = var3_3 == 0 || var4_5 == null || var4_5.d(var10_14) != false;
                                    v1 = var12_17 = var5_6 != null ? var5_6.b(var10_14) : null;
                                    if (var12_17 == null) {
                                        var12_17 = q.p;
                                    }
                                    if (var12_17 == q.r && var11_15 != false) {
                                        ++var8_11;
                                    }
                                    if (var12_17 == q.q) {
                                        var6_7[var10_14.d()] = var11_15 == false;
                                    }
                                }
                                var9_12.g();
                                if (!var14_4) continue;
                            }
                            break block25;
                        }
                        v0 = var8_11;
                    }
                    if (v0 > 0) {
                        var9_12 = var0.o();
                        while (var9_12.f()) {
                            var10_14 = var9_12.e();
                            var11_16 = var7_8.a((y.c.q)var10_14);
                            if (!var14_4) {
                                var12_17 = null;
                                while (var11_16 != var7_8.b()) {
                                    if (var5_6.b(var11_16) == q.r) {
                                        var12_17 = var11_16;
                                    }
                                    var11_16 = var7_8.a(var11_16);
                                    if (!var14_4) continue;
                                    if (var12_17 == null) break;
                                    var6_7[var10_14.d()] = var12_17.d() + 2;
                                    break;
                                }
                                var9_12.g();
                                if (!var14_4) continue;
                            }
                            break;
                        }
                    } else {
                        var7_8.c();
                    }
                }
                catch (Throwable var13_18) {
                    var7_8.c();
                    throw var13_18;
                }
            }
        }
        var7_8 = var0.p();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            var9_13 = var6_7[var8_9.c().d()];
            var10_14 = var6_7[var8_9.d().d()];
            if (var14_4 != false) return;
            if (var9_13 != false && var10_14 != false) ** GOTO lbl84
            var1_1.a(var8_9, true);
            if (!var14_4) ** GOTO lbl88
lbl84: // 2 sources:
            if (var9_13 == var10_14) ** GOTO lbl-1000
            var1_1.a(var8_9, true);
            if (var14_4) lbl-1000: // 2 sources:
            {
                var1_1.a(var8_9, false);
            }
lbl88: // 4 sources:
            var7_8.g();
            if (!var14_4) continue;
        }
        var7_8 = var0.o();
        do {
            if (var7_8.f() == false) return;
            var2_2.a((Object)var7_8.e(), var6_7[var7_8.e().d()] == false);
            var7_8.g();
        } while (!var14_4);
lbl96: // 2 sources:
        var6_7 = var0.p();
        while (var6_7.f()) {
            var7_8 = var6_7.a();
            var1_1.a(var7_8, true);
            var6_7.g();
            if (var14_4 != false) return;
            if (!var14_4) continue;
        }
        var6_7 = var0.o();
        do {
            if (var6_7.f() == false) return;
            var2_2.a((Object)var6_7.e(), true);
            var6_7.g();
        } while (!var14_4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void g(X x2) {
        boolean bl2 = i.b;
        this.I = 1;
        y.c.c c2 = x2.c(n);
        y.c.c c3 = x2.c(o);
        if (c3 == null) {
            if (c2 == null) return;
        }
        if (!y.f.b.c.b(x2)) return;
        y.f.b.c c4 = new y.f.b.c(x2);
        try {
            y.f.b.c c5;
            block19 : {
                Object object;
                int n2;
                Object object2;
                int n3;
                block18 : {
                    n2 = 0;
                    int n4 = 0;
                    object2 = x2.o();
                    while (object2.f()) {
                        object = object2.e();
                        n3 = (int)c4.d((y.c.q)object) ? 1 : 0;
                        if (!bl2) {
                            if (n3 != 0) {
                                Object object3;
                                boolean bl3 = this.w == 0 || c2 == null || c2.d(object);
                                Object object4 = object3 = c3 != null ? c3.b(object) : null;
                                if (object3 == null) {
                                    object3 = p;
                                }
                                if (object3 == r && bl3) {
                                    ++n2;
                                }
                                if (object3 == q) {
                                    ++n4;
                                }
                            }
                            object2.g();
                            if (!bl2) continue;
                        }
                        break block18;
                    }
                    n3 = n4;
                }
                if (n3 > 0) {
                    object2 = M.a();
                    this.I = 3;
                    object = x2.o();
                    while (object.f()) {
                        y.c.q q2 = object.e();
                        c5 = c4;
                        if (!bl2) {
                            if (c5.d(q2) && c3.b(q2) == q) {
                                object2.a((Object)q2, true);
                            }
                            object.g();
                            if (!bl2) continue;
                        }
                        break block19;
                    }
                    x2.a(y.f.e.a.as.a, (y.c.c)object2);
                } else if (n2 > 0) {
                    this.I = 2;
                    object2 = M.a();
                    object = x2.o();
                    while (object.f()) {
                        y.c.q q3 = object.e();
                        c5 = c4;
                        if (!bl2) {
                            if (c5.d(q3) && (this.w == 0 || c2 == null || c2.d(q3)) && c3.b(q3) == r) {
                                object2.a((Object)q3, true);
                            }
                            object.g();
                            if (!bl2) continue;
                        }
                        break block19;
                    }
                    x2.a(d.o, (y.c.c)object2);
                }
                c5 = c4;
            }
            c5.c();
            return;
        }
        catch (Throwable var11_14) {
            c4.c();
            throw var11_14;
        }
    }

    private boolean s() {
        if (this.G != i.a) {
            return true;
        }
        boolean bl2 = false;
        boolean bl3 = bl2;
        if (bl3) {
            return true;
        }
        if (this.I == 3) {
            return true;
        }
        if (this.I != 2) return this.H;
        return false;
    }

    private J t() {
        y.f.e.a.aj aj2 = new y.f.e.a.aj();
        aj2.a(true);
        aj2.a(this.A);
        J j2 = new J(aj2, J.a, 0.0, 50.0);
        j2.a(J.a);
        j2.c(0.0);
        return j2;
    }

    /*
     * Unable to fully structure code
     */
    private ay h(X var1_1) {
        var8_2 = i.b;
        var2_3 = new ay(false);
        var2_3.m();
        if (this.w != 0) {
            var3_4 = new x(this);
            var2_3.e((am)var3_4);
        }
        if (!y.f.b.c.c(var1_1)) ** GOTO lbl-1000
        var3_4 = new h();
        if (var8_2) lbl-1000: // 2 sources:
        {
            var3_4 = new y.f.e.a.x();
            if (this.I == 3) {
                var2_3.a(new y.f.e.a.as());
            }
        }
        var3_4.d(this.x);
        var2_3.a((p)var3_4);
        var2_3.a(this.q());
        var2_3.b(this.q());
        var2_3.h(this.C);
        var4_5 = (o)var2_3.z();
        var4_5.a((long)((double)this.v * this.u * 0.8));
        var5_6 = this.u;
        if (!this.H) ** GOTO lbl-1000
        var4_5.a(0.6 - 0.57 * var5_6);
        var4_5.b(0.3 - 0.29 * var5_6);
        var3_4.c(var3_4.f() * 10.0);
        if (var8_2) lbl-1000: // 2 sources:
        {
            var4_5.a(0.6 - 0.585 * var5_6);
            var4_5.b(0.3 - 0.295 * var5_6);
        }
        this.G.a(var2_3);
        if (this.H == false) return var2_3;
        var7_7 = this.t();
        var7_7.c(var3_4.e());
        var2_3.a(var7_7);
        return var2_3;
    }

    private void u() {
        this.t = System.currentTimeMillis();
    }

    private boolean v() {
        if (System.currentTimeMillis() - this.t <= this.v) return false;
        return true;
    }

    private a w() {
        if (this.w != 0) {
            return null;
        }
        a a2 = new a();
        a2.h(this.C);
        return a2;
    }

    private d x() {
        return new d();
    }

    private void a(a a2) {
        a2.m();
        if (!this.k()) {
            a2.e(true);
        }
        a2.a(new y.f.b.i());
        a2.g(this.u > 0.0);
        a2.c((int)this.z);
        a2.h(this.C);
        a2.i(this.B);
        if (this.u > 0.1) {
            a2.b(2 + (int)(this.u * 8.0));
            a2.a(8 + (int)(this.u * 22.0));
            a2.d(15);
            if (!i.b) return;
        }
        a2.b(2 + (int)(28.0 * this.u / 0.1));
        a2.a(25 + (int)(92.0 * this.u / 0.1));
        a2.d(15);
    }

    /*
     * Unable to fully structure code
     */
    private void a(d var1_1, y.c.c var2_2) {
        var3_3 = i.b;
        var1_1.m();
        var1_1.c((int)this.z);
        var1_1.c(2);
        var1_1.b(0);
        var1_1.h(false);
        var1_1.g(this.C);
        var1_1.b(this.w);
        if (this.x != 0.0) ** GOTO lbl15
        var1_1.c(0.0);
        var1_1.b(0);
        var1_1.a(0);
        var1_1.a(0.0);
        if (!var3_3) ** GOTO lbl67
lbl15: // 2 sources:
        if (this.x >= 0.2) ** GOTO lbl21
        var1_1.c(0.0);
        var1_1.b(1);
        var1_1.a(0);
        var1_1.a(0.1);
        if (!var3_3) ** GOTO lbl67
lbl21: // 2 sources:
        if (this.x >= 0.4) ** GOTO lbl27
        var1_1.c(0.0);
        var1_1.b(1);
        var1_1.a(1);
        var1_1.a(0.2);
        if (!var3_3) ** GOTO lbl67
lbl27: // 2 sources:
        if (this.x >= 0.5) ** GOTO lbl33
        var1_1.c(0.0);
        var1_1.b(1);
        var1_1.a(1);
        var1_1.a(0.3);
        if (!var3_3) ** GOTO lbl67
lbl33: // 2 sources:
        if (this.x >= 0.6) ** GOTO lbl39
        var1_1.c(0.0);
        var1_1.b(2);
        var1_1.a(1);
        var1_1.a(0.4);
        if (!var3_3) ** GOTO lbl67
lbl39: // 2 sources:
        if (this.x >= 0.7) ** GOTO lbl45
        var1_1.c(0.0);
        var1_1.b(2);
        var1_1.a(2);
        var1_1.a(0.8);
        if (!var3_3) ** GOTO lbl67
lbl45: // 2 sources:
        if (this.x >= 0.8) ** GOTO lbl51
        var1_1.c(0.1);
        var1_1.b(2);
        var1_1.a(2);
        var1_1.a(1.0);
        if (!var3_3) ** GOTO lbl67
lbl51: // 2 sources:
        if (this.x >= 0.9) ** GOTO lbl57
        var1_1.c(0.3);
        var1_1.b(2);
        var1_1.a(2);
        var1_1.a(1.0);
        if (!var3_3) ** GOTO lbl67
lbl57: // 2 sources:
        if (this.x >= 1.0) ** GOTO lbl-1000
        var1_1.c(0.6);
        var1_1.b(2);
        var1_1.a(2);
        var1_1.a(1.0);
        if (var3_3) lbl-1000: // 2 sources:
        {
            var1_1.c(4.0);
            var1_1.b(2);
            var1_1.a(2);
            var1_1.a(1.0);
        }
lbl67: // 11 sources:
        if (!this.n()) {
            var1_1.a(this.a());
        }
        var1_1.i(this.B != false || this.O != false);
        var1_1.a((long)((double)this.v * this.u * 0.8));
        var1_1.b(2.0 - this.u);
        var1_1.d(1.0 + this.u * this.u * 100.0);
        var1_1.a(new A(new z(this.o(), var2_2)));
    }

    public void a(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException("Ratio must lie within [0,1]");
        if (d2 > 1.0) {
            throw new IllegalArgumentException("Ratio must lie within [0,1]");
        }
        this.u = d2;
    }

    public byte p() {
        return this.w;
    }

    public void b(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException("Compactness must lie within [0,1]");
        if (d2 > 1.0) {
            throw new IllegalArgumentException("Compactness must lie within [0,1]");
        }
        this.x = d2;
    }

    public double q() {
        return this.z;
    }

    public void c(double d2) {
        this.z = d2;
    }

    public void g(boolean bl2) {
        this.B = bl2;
    }

    public void h(boolean bl2) {
        this.C = bl2;
    }

    public double r() {
        return this.D;
    }

    public void d(double d2) {
        this.D = d2;
    }

    static double a(q q2) {
        return q2.M;
    }

    static boolean a(q q2, y.c.q q3, y.c.c c2, X x2) {
        return q2.a(q3, c2, x2);
    }

    static boolean a(q q2, y.c.q q3, y.c.c c2) {
        return q2.a(q3, c2);
    }
}

