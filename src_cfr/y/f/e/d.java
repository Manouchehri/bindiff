/*
 * Decompiled with CFR 0_115.
 */
package y.f.e;

import java.util.List;
import java.util.Map;
import y.a.a;
import y.c.A;
import y.c.D;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aN;
import y.f.ad;
import y.f.ah;
import y.f.b.j;
import y.f.c;
import y.f.e.C;
import y.f.e.e;
import y.f.e.f;
import y.f.e.g;
import y.f.e.h;
import y.f.e.i;
import y.g.al;
import y.g.ar;

public class d
extends c {
    public static final Object n = "SPHERE_OF_ACTION_NODES";
    public static final Object o = "y.layout.organic.OrganicLayouter.FIXED_GROUP_NODES_DPKEY";
    private byte q = 1;
    public static final Object p = "OrganicLayouter.EDGE_LENGTH_DATA";
    private byte r = 0;
    private double s = 0.65;
    private double t = Math.max(0.1, 1.0);
    private double u;
    private double v = 80.0;
    private double w;
    private double x;
    private h y;
    private double z;
    private double A = 3.0;
    private boolean B = true;
    private int C;
    private X D;
    private g[] E;
    private int F;
    private g[] G;
    private ar H;
    private boolean I = true;
    private long J = 30000;
    private double K = 0.0;
    private double L;
    private al M;
    private double N;
    private double O;
    private double[] P;
    private double[] Q;
    private boolean R = false;
    private boolean S = false;
    private byte T = 1;
    private byte U = 1;
    private int V = 1000;
    private y.f.b.c W;
    private List X;
    private List Y;
    private Map Z;
    private byte[] aa;
    private double ab;
    private double ac;
    private int ad = 1;
    private int ae = 1;
    private int af = 1;
    private y.f.b.a ag = new y.f.b.h();
    private double ah = 0.2;
    private int[] ai;
    private byte aj;

    public d() {
        super.a(new f(this, null));
        this.d(false);
        ((aN)this.c()).a(1);
    }

    public void a(int n2) {
        if (n2 > 2) throw new IllegalArgumentException("Repulsion must lie within [0,2]");
        if (n2 < 0) {
            throw new IllegalArgumentException("Repulsion must lie within [0,2]");
        }
        this.U = (byte)n2;
    }

    public void b(int n2) {
        if (n2 > 2) throw new IllegalArgumentException("Attraction must lie within [0,2]");
        if (n2 < 0) {
            throw new IllegalArgumentException("Attraction must lie within [0,2]");
        }
        this.T = (byte)n2;
    }

    public y.f.b.a a() {
        return this.ag;
    }

    public void a(y.f.b.a a2) {
        this.ag = a2;
    }

    public double n() {
        return this.ah;
    }

    public void a(double d2) {
        if (d2 < 0.0) throw new IllegalArgumentException(new StringBuffer().append(d2).append(" not in [0,1]").toString());
        if (d2 > 1.0) throw new IllegalArgumentException(new StringBuffer().append(d2).append(" not in [0,1]").toString());
        this.ah = d2;
        if (!i.b) return;
        throw new IllegalArgumentException(new StringBuffer().append(d2).append(" not in [0,1]").toString());
    }

    public byte o() {
        return this.aj;
    }

    public void b(double d2) {
        this.t = d2;
    }

    public void g(boolean bl2) {
        this.S = bl2;
    }

    public boolean p() {
        return this.S;
    }

    public void h(boolean bl2) {
        this.R = bl2;
    }

    public boolean q() {
        return this.R;
    }

    public void c(double d2) {
        this.K = d2;
    }

    public void b(byte by2) {
        this.r = by2;
        if (this.r == 0) return;
        this.c(2);
    }

    public byte r() {
        return this.r;
    }

    public void c(byte by2) {
        this.q = by2;
    }

    public void a(long l2) {
        this.J = l2;
    }

    public void d(double d2) {
        this.A = d2;
    }

    public void c(int n2) {
        this.v = n2;
    }

    public void i(boolean bl2) {
        this.B = bl2;
    }

    @Override
    public boolean b(X x2) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a(X var1_1) {
        var18_2 = i.b;
        if (var1_1 == null) {
            return;
        }
        this.D = var1_1;
        var2_3 = y.f.b.c.b(var1_1);
        var3_4 = null;
        if (var2_3) {
            if (!this.d(var1_1)) {
                return;
            }
        } else {
            var3_4 = new C(var1_1);
            if (this.q()) {
                var3_4.a();
            }
            if (!this.a(var1_1, null)) {
                return;
            }
        }
        try {
            block20 : {
                var4_5 = new h();
                var7_7 = (long)(this.A * (double)d.e(this.G.length) + (double)(20 * this.G.length));
                var7_7 = Math.max(var7_7, 10000);
                var9_8 = this.t * this.t * (double)this.G.length;
                var11_9 = this.V;
                try {
                    for (var5_6 = 0; this.w > var9_8 && var5_6 < var7_7; ++var5_6) {
                        var12_10 = this.d((int)(var5_6 & Integer.MAX_VALUE));
                        if (var11_9-- == 0) {
                            if (this.M.d() > this.J) {
                                var5_6 = var7_7;
                            }
                            a.a();
                            var11_9 = this.V;
                        }
                        if (this.r != 1 || var12_10.m) {
                            this.f(var12_10, var4_5);
                            this.e(var12_10, var4_5);
                            this.d(var12_10, var4_5);
                        }
                        if (!this.I) ** GOTO lbl-1000
                        this.a(var12_10, var4_5);
                        this.b(var12_10, var4_5);
                        if (var18_2) lbl-1000: // 2 sources:
                        {
                            this.a(this.T, var12_10, var4_5);
                            this.b(this.U, var12_10, var4_5);
                        }
                        var13_12 = Math.sqrt(var4_5.a * var4_5.a + var4_5.b * var4_5.b + var4_5.c * var4_5.c);
                        this.a(var12_10, var4_5, var13_12);
                        this.b(var12_10, var4_5, var13_12);
                        if (!var2_3) continue;
                        this.b(var12_10);
                        this.a(var12_10);
                        if (!var18_2) continue;
                        break block20;
                    }
                    break block20;
                }
                catch (a var12_11) {}
                ** GOTO lbl54
                finally {
                    this.u();
                }
            }
            var17_14 = null;
            if (var2_3) {
                this.s();
                if (var18_2 == false) return;
            }
            if (this.q() == false) return;
            var3_4.b();
            return;
        }
        catch (Throwable var16_16) {
            var17_15 = null;
            if (var2_3) {
                this.s();
                if (var18_2 == false) throw var16_16;
            }
            if (this.q() == false) throw var16_16;
            var3_4.b();
            throw var16_16;
        }
    }

    /*
     * Exception decompiling
     */
    private boolean d(X var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
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

    private double a(y.f.b.c c2, q q2) {
        double d2;
        boolean bl2 = i.b;
        y y2 = c2.b(q2);
        double d3 = 0.0;
        for (p p2 = y2.k(); p2 != null; d3 += d2 * d2 * 3.0, p2 = p2.a()) {
            q q3 = (q)p2.c();
            g g2 = this.E[q3.d()];
            if (c2.d(q3) && !c2.b(q3).isEmpty() && g2.o != 3) {
                g2.r = d2 = this.a(c2, q3);
                g2.k = d2;
                if (!bl2) continue;
            }
            d2 = this.E[q3.d()].k;
            if (!bl2) continue;
        }
        double d4 = d3 / (double)(y2.size() + 1);
        d4 = d.e(Math.sqrt(d4) + this.v * 0.9);
        return Math.sqrt(d4 * (double)y2.size()) * 0.5 + this.v;
    }

    /*
     * Unable to fully structure code
     */
    private void s() {
        var13_1 = i.b;
        if (this.X == null) ** GOTO lbl11
        for (var1_2 = 0; var1_2 < this.X.size(); ++var1_2) {
            var2_3 = (y.c.d)this.X.get(var1_2);
            v0 = (int)this.D.f(var2_3) ? 1 : 0;
            if (!var13_1) {
                if (v0 == 0) continue;
                this.D.a(var2_3);
                if (!var13_1) continue;
            }
            ** GOTO lbl13
        }
lbl11: // 3 sources:
        if (this.Y != null) {
            v0 = var1_2 = 0;
lbl13: // 3 sources:
            while (var1_2 < this.Y.size()) {
                var2_3 = (y.c.d)this.Y.get(var1_2);
                this.D.e(var2_3);
                var3_4 = this.D.b(var2_3);
                if (!var13_1) {
                    if (var3_4.pointCount() > 0) {
                        var4_5 = this.E[var2_3.c().d()].p.a;
                        var5_6 = this.D.o(var4_5);
                        var6_7 = (t)this.Z.get(var4_5);
                        var7_8 = var5_6.a - var6_7.a;
                        var9_9 = var5_6.b - var6_7.b;
                        for (var11_10 = 0; var11_10 < var3_4.pointCount(); ++var11_10) {
                            var12_11 = var3_4.getPoint(var11_10);
                            var3_4.setPoint(var11_10, var12_11.a + var7_8, var12_11.b + var9_9);
                            if (!var13_1) {
                                if (!var13_1) continue;
                            }
                            break;
                        }
                    } else {
                        ++var1_2;
                    }
                    if (!var13_1) continue;
                }
                break;
            }
        } else {
            new j(null, new e(this)).c(this.D);
            this.X = null;
            this.ai = null;
            this.aa = null;
        }
        if (this.W != null) {
            this.W.c();
            this.W = null;
        }
        this.Y = null;
    }

    /*
     * Exception decompiling
     */
    private boolean a(X var1_1, int[] var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 9[FORLOOP]
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
    private void t() {
        var12_1 = i.b;
        var1_2 = new D();
        var2_3 = this.D.t();
        var3_4 = new Object();
        var4_5 = new Object();
        var5_6 = this.D.c(d.n);
        var6_7 = this.D.o();
        block0 : do {
            v0 = var6_7.f();
            block1 : while (v0) {
                var7_8 = var6_7.e();
                v1 = var5_6.d(var7_8);
                if (var12_1) ** GOTO lbl29
                if (v1) {
                    var8_10 = var7_8.m();
                    while (var8_10.f()) {
                        var9_12 = var8_10.e();
                        v0 = var5_6.d(var9_12);
                        if (var12_1) continue block1;
                        if (v0 && var2_3.b(var9_12) == null) {
                            var2_3.a((Object)var9_12, var3_4);
                            var1_2.b(var9_12);
                        }
                        var8_10.g();
                        if (!var12_1) continue;
                    }
                }
                var6_7.g();
                if (!var12_1) continue block0;
            }
            break block0;
            break;
        } while (true);
        do {
            v1 = var1_2.isEmpty();
lbl29: // 2 sources:
            if (v1) break;
            v2 = var1_2.g();
            block4 : do {
                var6_7 = (q)v2;
                var7_9 = 0;
                var8_11 = 0;
                var9_13 = 0;
                if (var12_1 != false) return;
                var10_14 = var6_7.m();
                while (var10_14.f()) {
                    var11_15 = var10_14.e();
                    v2 = var2_3.b(var11_15);
                    if (var12_1) continue block4;
                    if (v2 == null && var5_6.d(var11_15)) {
                        var2_3.a((Object)var11_15, var3_4);
                        var1_2.b(var11_15);
                    }
                    if (var5_6.d(var11_15) || var2_3.b(var11_15) == var4_5) {
                        var8_11 = (int)((double)var8_11 + this.E[var11_15.d()].h);
                        var9_13 = (int)((double)var9_13 + this.E[var11_15.d()].i);
                        ++var7_9;
                    }
                    var10_14.g();
                    if (!var12_1) continue;
                }
                break block4;
                break;
            } while (true);
            if (var7_9 > 0) {
                this.E[var6_7.d()].h = var8_11 / var7_9;
                this.E[var6_7.d()].i = var9_13 / var7_9;
            }
            var2_3.a(var6_7, var4_5);
        } while (!var12_1);
        this.D.a(var2_3);
    }

    private g d(int n2) {
        int n3 = this.G.length;
        int n4 = n3 - n2 % n3 - 1;
        int n5 = this.H.nextInt(n4 + 1);
        g g2 = this.G[n5];
        this.G[n5] = this.G[n4];
        this.G[n4] = g2;
        return g2;
    }

    /*
     * Exception decompiling
     */
    private void a(g var1_1, h var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
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

    private void b(g g2, h h2) {
        boolean bl2 = i.b;
        g g3 = g2;
        if (g3 != null && g3.o == 3) {
            for (p p2 = g3.s.k(); p2 != null; g4.h += g3.h, g4.i += g3.i, g4.j += g3.j, p2 = p2.a()) {
                g g4 = this.E[((q)p2.c()).d()];
                double d2 = g4.h;
                double d3 = g4.i;
                double d4 = g4.j;
                g4.f = g2.f;
                this.c(g4, h2);
                g4.h = d2;
                g4.i = d3;
                g4.j = d4;
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        this.c(g2, h2);
    }

    /*
     * Unable to fully structure code
     */
    private void c(g var1_1, h var2_2) {
        var26_3 = i.b;
        var7_4 = 0.0;
        var5_5 = 0.0;
        var3_6 = 0.0;
        for (var9_7 = this.F - 1; var9_7 >= 0; --var9_7) {
            block9 : {
                var10_8 = this.E[var9_7];
                if (var26_3 != false) return;
                if (var10_8.f == var1_1.f) continue;
                var11_9 = var10_8.p;
                if (var11_9 == null || var11_9.o != 3) ** GOTO lbl-1000
                if (var11_9 == var1_1 || var11_9 == var1_1.p) continue;
                var12_10 = var1_1.h - (var11_9.h + var10_8.h);
                var14_11 = var1_1.i - (var11_9.i + var10_8.i);
                var16_12 = var1_1.j - (var11_9.j + var10_8.j);
                if (var26_3) lbl-1000: // 2 sources:
                {
                    var12_10 = var1_1.h - var10_8.h;
                    var14_11 = var1_1.i - var10_8.i;
                    var16_12 = var1_1.j - var10_8.j;
                }
                if ((var18_13 = var12_10 * var12_10 + var14_11 * var14_11 + var16_12 * var16_12) == 0.0) continue;
                var20_14 = 1.0;
                var22_15 = Math.sqrt(var18_13);
                if (this.B) {
                    var24_16 = Math.max(1.0E-6, var22_15 - (var1_1.k + var10_8.k));
                    if (!var26_3) break block9;
                }
                var24_16 = var22_15;
            }
            switch (this.U) {
                case 0: {
                    var20_14 = this.O / (var24_16 * var22_15);
                    if (!var26_3) ** GOTO lbl38
                }
                case 1: {
                    var20_14 = this.O / (var24_16 * var24_16 * var22_15);
                    if (!var26_3) ** GOTO lbl38
                }
                case 2: {
                    var20_14 = this.O / (var24_16 * var24_16 * var24_16 * var22_15);
                    if (!var26_3) ** GOTO lbl38
                }
            }
            var20_14 = this.O / (Math.pow(var24_16, this.U + 1) * var22_15);
lbl38: // 4 sources:
            var3_6 += var12_10 * var20_14;
            var5_5 += var14_11 * var20_14;
            var7_4 += var16_12 * var20_14;
            if (!var26_3) continue;
        }
        var2_2.a += var3_6;
        var2_2.b += var5_5;
        var2_2.c += var7_4;
    }

    /*
     * Unable to fully structure code
     */
    private void a(int var1_1, g var2_2, h var3_3) {
        block52 : {
            block49 : {
                block48 : {
                    var32_4 = i.b;
                    var8_5 = 0.0;
                    var6_6 = 0.0;
                    var4_7 = 0.0;
                    ++this.C;
                    var2_2.f = this.C;
                    var10_8 = var2_2.a.d();
                    if (var2_2.o == 1) {
                        var11_9 = Math.pow(var2_2.q / var2_2.r, 3.0) * this.ac;
                        if (!var32_4) break block48;
                    }
                    var11_9 = 0.0;
                }
                v0 = var13_10 = this.aa != null;
                if (var2_2.o != 3) ** GOTO lbl73
                for (var14_11 = this.W.f((q)var2_2.a).k(); var14_11 != null; var14_11 = var14_11.a()) {
                    block50 : {
                        var15_12 = (y.c.d)var14_11.c();
                        var16_14 = this.E[var15_12.c().d()];
                        var17_15 = this.E[var15_12.d().d()];
                        var17_15.f = this.C;
                        v1 = var16_14.p;
                        if (var32_4) break block49;
                        if (v1 == null || var16_14.p.o != 3) ** GOTO lbl-1000
                        var18_18 = var16_14.p.h + var16_14.h - (var2_2.h + var17_15.h);
                        var20_19 = var16_14.p.i + var16_14.i - (var2_2.i + var17_15.i);
                        var22_20 = var16_14.p.j + var16_14.j - (var2_2.j + var17_15.j);
                        if (var32_4) lbl-1000: // 2 sources:
                        {
                            var18_18 = var16_14.h - (var2_2.h + var17_15.h);
                            var20_19 = var16_14.i - (var2_2.i + var17_15.i);
                            var22_20 = var16_14.j - (var2_2.j + var17_15.j);
                        }
                        var24_21 = var18_18 * var18_18 + var20_19 * var20_19 + var22_20 * var22_20;
                        var26_22 = 1.0;
                        if (this.B) {
                            var28_23 = Math.sqrt(var24_21);
                            var30_24 = var28_23 - (var16_14.k + var17_15.k);
                            if (var30_24 <= 0.0) continue;
                            var26_22 = this.ab * Math.pow(var30_24, this.ad + 1) / var28_23;
                            if (!var32_4) break block50;
                        }
                        var26_22 = this.ab * Math.pow(var24_21, (double)this.ad * 0.5);
                    }
                    var4_7 += var18_18 * var26_22;
                    var6_6 += var20_19 * var26_22;
                    var8_5 += var22_20 * var26_22;
                    if (!var32_4) continue;
                }
                for (var14_11 = this.W.g((q)var2_2.a).k(); var14_11 != null; var14_11 = var14_11.a()) {
                    block51 : {
                        var15_12 = (y.c.d)var14_11.c();
                        var16_14 = this.E[var15_12.d().d()];
                        var17_15 = this.E[var15_12.c().d()];
                        var17_15.f = this.C;
                        v1 = var16_14.p;
                        if (var32_4) break block49;
                        if (v1 == null || var16_14.p.o != 3) ** GOTO lbl-1000
                        var18_18 = var16_14.p.h + var16_14.h - (var2_2.h + var17_15.h);
                        var20_19 = var16_14.p.i + var16_14.i - (var2_2.i + var17_15.i);
                        var22_20 = var16_14.p.j + var16_14.j - (var2_2.j + var17_15.j);
                        if (var32_4) lbl-1000: // 2 sources:
                        {
                            var18_18 = var16_14.h - (var2_2.h + var17_15.h);
                            var20_19 = var16_14.i - (var2_2.i + var17_15.i);
                            var22_20 = var16_14.j - (var2_2.j + var17_15.j);
                        }
                        var24_21 = var18_18 * var18_18 + var20_19 * var20_19 + var22_20 * var22_20;
                        var26_22 = 1.0;
                        if (this.B) {
                            var28_23 = Math.sqrt(var24_21);
                            var30_24 = var28_23 - (var16_14.k + var17_15.k);
                            if (var30_24 <= 0.0) continue;
                            var26_22 = this.ab * Math.pow(var30_24, this.ad + 1) / var28_23;
                            if (!var32_4) break block51;
                        }
                        var26_22 = this.ab * Math.pow(var24_21, (double)this.ad * 0.5);
                    }
                    var4_7 += var18_18 * var26_22;
                    var6_6 += var20_19 * var26_22;
                    var8_5 += var22_20 * var26_22;
                    if (!var32_4) continue;
                }
lbl73: // 3 sources:
                v1 = var2_2;
            }
            block32 : for (var14_11 = (v1464210).a.g(); var14_11 != null; var14_11 = var14_11.h()) {
                var15_13 = var14_11.b();
                var16_14 = this.E[var14_11.c().d()];
                v2 = var23_27 = var16_14.p;
                if (var32_4) break block52;
                if (v2 == null || var23_27.o != 3) ** GOTO lbl-1000
                var17_16 = var23_27.h + var16_14.h - var2_2.h;
                var19_25 = var23_27.i + var16_14.i - var2_2.i;
                var21_26 = var23_27.j + var16_14.j - var2_2.j;
                if (var32_4) lbl-1000: // 2 sources:
                {
                    var17_16 = var16_14.h - var2_2.h;
                    var19_25 = var16_14.i - var2_2.i;
                    var21_26 = var16_14.j - var2_2.j;
                }
                var24_21 = var17_16 * var17_16 + var19_25 * var19_25 + var21_26 * var21_26;
                var26_22 = 1.0;
                if (!var13_10 || this.aa[var15_13] == 0) ** GOTO lbl110
                block0 : switch (this.aa[var15_13]) {
                    default: {
                        if (!var32_4) continue block32;
                    }
                    case 1: {
                        var16_14.f = this.C;
                        var26_22 = var11_9 * Math.pow(var24_21, (double)this.af * 0.5);
                        if (!var32_4) break;
                    }
                    case 3: {
                        if (this.B) {
                            var28_23 = Math.sqrt(var24_21);
                            var30_24 = var28_23 - (var16_14.k + var2_2.k);
                            if (var30_24 <= 0.0) continue block32;
                            var26_22 = this.ab * Math.pow(var30_24, this.ad + 1) / var28_23;
                            if (!var32_4) break;
                        }
                        var26_22 = this.ab * Math.pow(var24_21, (double)this.ad * 0.5);
                        if (!var32_4) break;
                    }
                    case 2: {
                        var16_14.f = this.C;
                        if (!var32_4) continue block32;
lbl110: // 2 sources:
                        if (this.B) {
                            var28_23 = Math.sqrt(var24_21);
                            var30_24 = var28_23 - (var16_14.k + var2_2.k);
                            if (var30_24 <= 0.0) continue block32;
                            switch (var1_1) {
                                case 0: {
                                    var26_22 = var30_24 * this.N / var28_23;
                                    if (!var32_4) break block0;
                                }
                                case 1: {
                                    var26_22 = var30_24 * var30_24 * this.N / var28_23;
                                    if (!var32_4) break block0;
                                }
                                case 2: {
                                    var26_22 = var30_24 * var30_24 * var30_24 * this.N / var28_23;
                                    if (!var32_4) break block0;
                                }
                            }
                            var26_22 = this.N * Math.pow(var30_24, var1_1 + 1) / var28_23;
                            if (!var32_4) break;
                        }
                        switch (var1_1) {
                            case 0: {
                                var26_22 = this.N;
                                if (!var32_4) break block0;
                            }
                            case 1: {
                                var26_22 = this.N * Math.sqrt(var24_21);
                                if (!var32_4) break block0;
                            }
                            case 2: {
                                var26_22 = this.N * var24_21;
                                if (!var32_4) break block0;
                            }
                        }
                        var26_22 = this.N * Math.pow(var24_21, (double)var1_1 * 0.5);
                    }
                }
                var4_7 += var17_16 * var26_22;
                var6_6 += var19_25 * var26_22;
                var8_5 += var21_26 * var26_22;
                if (!var32_4) continue;
            }
            v2 = var2_2;
        }
        block33 : for (var14_11 = (v1464363).a.f(); var14_11 != null; var14_11 = var14_11.g()) {
            var15_12 = (y.c.d)var14_11.b();
            var16_14 = this.E[var14_11.d().d()];
            var23_27 = var16_14.p;
            if (var32_4 != false) return;
            if (var23_27 == null || var23_27.o != 3) ** GOTO lbl-1000
            var17_17 = var23_27.h + var16_14.h - var2_2.h;
            var19_25 = var23_27.i + var16_14.i - var2_2.i;
            var21_26 = var23_27.j + var16_14.j - var2_2.j;
            if (var32_4) lbl-1000: // 2 sources:
            {
                var17_17 = var16_14.h - var2_2.h;
                var19_25 = var16_14.i - var2_2.i;
                var21_26 = var16_14.j - var2_2.j;
            }
            var24_21 = var17_17 * var17_17 + var19_25 * var19_25 + var21_26 * var21_26;
            var26_22 = 1.0;
            if (!var13_10 || this.aa[var15_12] == 0) ** GOTO lbl178
            block15 : switch (this.aa[var15_12]) {
                default: {
                    if (!var32_4) continue block33;
                }
                case 1: {
                    var16_14.f = this.C;
                    var26_22 = Math.pow(var16_14.q / var16_14.r, 3.0) * this.ac * Math.pow(var24_21, (double)this.af * 0.5);
                    if (!var32_4) break;
                }
                case 3: {
                    if (this.B) {
                        var28_23 = Math.sqrt(var24_21);
                        var30_24 = var28_23 - (var16_14.k + var2_2.k);
                        if (var30_24 <= 0.0) continue block33;
                        var26_22 = this.ab * Math.pow(var30_24, this.ad + 1) / var28_23;
                        if (!var32_4) break;
                    }
                    var26_22 = this.ab * Math.pow(var24_21, (double)this.ad * 0.5);
                    if (!var32_4) break;
                }
                case 2: {
                    var16_14.f = this.C;
                    if (!var32_4) continue block33;
lbl178: // 2 sources:
                    if (this.B) {
                        var28_23 = Math.sqrt(var24_21);
                        var30_24 = var28_23 - (var16_14.k + var2_2.k);
                        if (var30_24 <= 0.0) continue block33;
                        switch (var1_1) {
                            case 0: {
                                var26_22 = var30_24 * this.N / var28_23;
                                if (!var32_4) break block15;
                            }
                            case 1: {
                                var26_22 = var30_24 * var30_24 * this.N / var28_23;
                                if (!var32_4) break block15;
                            }
                            case 2: {
                                var26_22 = var30_24 * var30_24 * var30_24 * this.N / var28_23;
                                if (!var32_4) break block15;
                            }
                        }
                        var26_22 = this.N * Math.pow(var30_24, var1_1 + 1) / var28_23;
                        if (!var32_4) break;
                    }
                    switch (var1_1) {
                        case 0: {
                            var26_22 = this.N;
                            if (!var32_4) break block15;
                        }
                        case 1: {
                            var26_22 = this.N * Math.sqrt(var24_21);
                            if (!var32_4) break block15;
                        }
                        case 2: {
                            var26_22 = this.N * var24_21;
                            if (!var32_4) break block15;
                        }
                    }
                    var26_22 = this.N * Math.pow(var24_21, (double)var1_1 * 0.5);
                }
            }
            var4_7 += var17_17 * var26_22;
            var6_6 += var19_25 * var26_22;
            var8_5 += var21_26 * var26_22;
            if (!var32_4) continue;
        }
        var3_3.a += var4_7;
        var3_3.b += var6_6;
        var3_3.c += var8_5;
    }

    private void b(int n2, g g2, h h2) {
        boolean bl2 = i.b;
        g g3 = g2;
        if (g3 != null && g3.o == 3) {
            for (p p2 = g3.s.k(); p2 != null; g4.h += g3.h, g4.i += g3.i, g4.j += g3.j, p2 = p2.a()) {
                g g4 = this.E[((q)p2.c()).d()];
                double d2 = g4.h;
                double d3 = g4.i;
                double d4 = g4.j;
                g4.f = g2.f;
                this.c(n2, g4, h2);
                g4.h = d2;
                g4.i = d3;
                g4.j = d4;
                if (bl2) return;
                if (!bl2) continue;
            }
        }
        this.c(n2, g2, h2);
    }

    /*
     * Unable to fully structure code
     */
    private void c(int var1_1, g var2_2, h var3_3) {
        var28_4 = i.b;
        var8_5 = 0.0;
        var6_6 = 0.0;
        var4_7 = 0.0;
        var10_8 = this.aa != null;
        for (var11_9 = this.F - 1; var11_9 >= 0; --var11_9) {
            var12_10 = this.E[var11_9];
            if (var28_4 != false) return;
            if (var10_8 && var12_10.f == var2_2.f) continue;
            var19_14 = var12_10.p;
            if (var19_14 == null || var19_14.o != 3) ** GOTO lbl-1000
            if (var19_14 == var2_2 || var19_14 == var2_2.p) continue;
            var13_11 = var2_2.h - (var19_14.h + var12_10.h);
            var15_12 = var2_2.i - (var19_14.i + var12_10.i);
            var17_13 = var2_2.j - (var19_14.j + var12_10.j);
            if (var28_4) lbl-1000: // 2 sources:
            {
                var13_11 = var2_2.h - var12_10.h;
                var15_12 = var2_2.i - var12_10.i;
                var17_13 = var2_2.j - var12_10.j;
            }
            if ((var20_15 = var13_11 * var13_11 + var15_12 * var15_12 + var17_13 * var17_13) == 0.0) continue;
            var22_16 = 1.0;
            if (!this.B) ** GOTO lbl40
            var24_17 = Math.sqrt(var20_15);
            var26_18 = var24_17 - (var2_2.k + var12_10.k);
            if (var26_18 > 0.0) ** GOTO lbl28
            var22_16 = this.O / (1.0E-8 * var24_17);
            if (!var28_4) ** GOTO lbl51
lbl28: // 2 sources:
            switch (var1_1) {
                case 0: {
                    var22_16 = this.O / (var26_18 * var24_17);
                    if (!var28_4) ** GOTO lbl51
                }
                case 1: {
                    var22_16 = this.O / (var26_18 * var26_18 * var24_17);
                    if (!var28_4) ** GOTO lbl51
                }
                case 2: {
                    var22_16 = this.O / (var26_18 * var26_18 * var26_18 * var24_17);
                    if (!var28_4) ** GOTO lbl51
                }
            }
            var22_16 = this.O / (Math.pow(var26_18, var1_1 + 1) * var24_17);
            if (!var28_4) ** GOTO lbl51
lbl40: // 2 sources:
            switch (var1_1) {
                case 0: {
                    var22_16 = this.O / var20_15;
                    if (!var28_4) ** GOTO lbl51
                }
                case 1: {
                    var22_16 = this.O / (var20_15 * Math.sqrt(var20_15));
                    if (!var28_4) ** GOTO lbl51
                }
                case 2: {
                    var22_16 = this.O / (var20_15 * var20_15);
                    if (!var28_4) ** GOTO lbl51
                }
            }
            var22_16 = this.O / Math.pow(var20_15, (double)(var1_1 + 2) * 0.5);
lbl51: // 9 sources:
            var4_7 += var13_11 * var22_16;
            var6_6 += var15_12 * var22_16;
            var8_5 += var17_13 * var22_16;
            if (!var28_4) continue;
        }
        var3_3.a += var4_7;
        var3_3.b += var6_6;
        var3_3.c += var8_5;
    }

    private void d(g g2, h h2) {
        double d2 = this.y.c / (double)this.G.length - g2.j;
        h2.c += d2 * (double)this.G.length / this.x;
    }

    private void e(g g2, h h2) {
        if (this.L == 0.0) return;
        double d2 = this.y.a / (double)this.G.length - g2.h;
        double d3 = this.y.b / (double)this.G.length - g2.i;
        double d4 = this.y.c / (double)this.G.length - g2.j;
        h2.a += d2 * this.L;
        h2.b += d3 * this.L;
        h2.c += d4 * this.L;
    }

    private void f(g g2, h h2) {
        double d2 = 1.0E-4 * (g2.g + 2.0);
        if (d2 <= 0.0) return;
        h2.a = this.H.a(- d2, d2);
        h2.b = this.H.a(- d2, d2);
        h2.c = this.H.a(- d2, d2);
    }

    private void a(g g2) {
        if (g2.r == 0.0) {
            return;
        }
        double d2 = Math.min(g2.q, g2.r);
        if (d2 <= 0.0) return;
        if (g2.k < d2 - 10.0) {
            g2.k = (9.0 * g2.k + d2) / 10.0;
            if (!i.b) return;
        }
        if (g2.k <= d2 + 10.0) return;
        g2.k = (3.0 * g2.k + d2) / 4.0;
    }

    private void b(g g2) {
        boolean bl2 = i.b;
        g g3 = g2.p;
        if (g3 == null) return;
        if (g3.o != 1) return;
        D d2 = g3.s;
        double d3 = this.v + 1.0;
        for (p p2 = d2.k(); p2 != null; p2 = p2.a()) {
            g g4 = this.E[((q)p2.c()).d()];
            double d4 = g3.h - g4.h;
            double d5 = g3.i - g4.i;
            double d6 = g3.j - g4.j;
            double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6) + g4.k;
            if (bl2) return;
            if (d7 <= d3) continue;
            d3 = d7;
            if (!bl2) continue;
        }
        g3.q = d3;
    }

    /*
     * Unable to fully structure code
     */
    void a(g var1_1, h var2_2, double var3_3) {
        block5 : {
            var7_4 = i.b;
            if (var3_3 == 0.0) return;
            if (var1_1.e == 0.0) return;
            var5_5 = (var2_2.a * var1_1.b + var2_2.b * var1_1.c + var2_2.c * var1_1.d) / (var3_3 * var1_1.e);
            this.x -= var1_1.g * var1_1.g;
            this.w -= var1_1.g;
            if (var1_1.l * var5_5 > 0.0) {
                var1_1.g += var5_5 * 0.45;
                if (!var7_4) break block5;
            }
            var1_1.g += var5_5 * 0.15;
        }
        if (var1_1.g <= this.z) ** GOTO lbl-1000
        var1_1.g = this.z;
        if (var7_4) lbl-1000: // 2 sources:
        {
            if (var1_1.g < 0.1) {
                var1_1.g = 0.1;
            }
        }
        if (this.r == 1 && !var1_1.m) {
            var1_1.g *= 1.0 - 0.066 * (double)(var1_1.n + 1);
        }
        this.w += var1_1.g;
        this.x += var1_1.g * var1_1.g;
        var1_1.l = var5_5;
    }

    void b(g g2, h h2, double d2) {
        if (d2 <= 0.0) return;
        double d3 = g2.g / d2;
        double d4 = h2.a * d3;
        g2.h += d4;
        this.y.a += d4;
        double d5 = h2.b * d3;
        g2.i += d5;
        this.y.b += d5;
        double d6 = h2.c * d3;
        g2.j += d6;
        this.y.c += d6;
        g2.e = d2;
        g2.b = h2.a;
        g2.c = h2.b;
        g2.d = h2.c;
    }

    private void u() {
        g g2;
        g[] arrg;
        boolean bl2 = i.b;
        if (this.W != null) {
            for (p p2 = this.W.c((q)this.W.b()).k(); p2 != null; p2 = p2.a()) {
                arrg = this.E;
                if (!bl2) {
                    g2 = arrg[((q)p2.c()).d()];
                    g g3 = g2.p;
                    if (g3 == null || g3.o != 3) continue;
                    g2.h += g3.h;
                    g2.i += g3.i;
                    g2.j += g3.j;
                    if (!bl2) continue;
                }
                break;
            }
        } else {
            arrg = this.E;
        }
        int n2 = arrg.length - 1;
        do {
            if (n2 < 0) return;
            g2 = this.E[n2];
            this.D.a(g2.a, g2.h, g2.i);
            --n2;
        } while (!bl2);
    }

    private static int e(int n2) {
        return n2 * n2;
    }

    private static double e(double d2) {
        return d2 * d2;
    }

    private double a(y.c.d d2) {
        double d3 = this.v;
        y.c.c c2 = this.D.c(p);
        if (c2 != null && c2.a(d2) > 0) {
            d3 = c2.a(d2);
        }
        if (this.r != 1) return d3;
        y.c.c c3 = this.D.c(n);
        if (c3.d(d2.c())) return d3;
        if (c3.d(d2.d())) return d3;
        double d4 = this.D.j(d2.c()) - this.D.j(d2.d());
        double d5 = this.D.k(d2.c()) - this.D.k(d2.d());
        d3 = Math.sqrt(d4 * d4 + d5 * d5) * 0.95 + 1.0;
        if (!this.B) return d3;
        d3 -= this.E[d2.c().d()].k + this.E[d2.d().d()].k;
        return Math.max(1.0, d3);
    }
}

