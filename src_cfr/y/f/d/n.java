/*
 * Decompiled with CFR 0_115.
 */
package y.f.d;

import java.util.Collection;
import y.c.d;
import y.d.q;
import y.d.t;
import y.d.v;
import y.d.y;
import y.d.z;
import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.K;
import y.f.X;
import y.f.aG;
import y.f.ae;
import y.f.am;
import y.f.d.a;
import y.f.d.m;
import y.f.d.o;
import y.f.d.p;

class n {
    private static final y.d.n[] a = new y.d.n[]{new y.d.n(15.0, 5.0, 30.0, 10.0, 1.0, 0.0), new y.d.n(-15.0, -15.0, 100.0, 30.0, 0.5, 0.5), new y.d.n(50.0, 90.0, 40.0, 15.0, 0.0, -1.0)};
    private static final z b = new z(0.0, -1.0);
    private static final t c = new t(0.0, 0.0);

    private static boolean a(E e2, I i2, am am2, am am3) {
        int n2 = a.f;
        if (e2 instanceof K) {
            return true;
        }
        try {
            int n3 = 0;
            do {
                if (n3 >= a.length) return true;
                Object object = e2.a(a[n3], i2, am2, am3);
                y.d.n n4 = e2.a(a[n3].d(), i2, am2, am3, object);
                boolean bl2 = y.d.n.a(a[n3], n4, 1.0);
                if (n2 != 0) return bl2;
                if (!bl2) {
                    return false;
                }
                ++n3;
            } while (n2 == 0);
            return true;
        }
        catch (UnsupportedOperationException var4_6) {
            return false;
        }
    }

    /*
     * Unable to fully structure code
     */
    static y.c.D a(X var0, d var1_1, C var2_2, E var3_3, boolean var4_4, boolean var5_5, boolean var6_6) {
        var19_7 = a.f;
        var7_8 = new y.c.D();
        var8_9 = var0.b(var1_1);
        var9_10 = var0.a(var1_1.c());
        var10_11 = var0.a(var1_1.d());
        var11_12 = var2_2.getLabelModel();
        var12_13 = var2_2.getModelParameter() == null ? var11_12.c() : var2_2.getModelParameter();
        v0 = var13_14 = var11_12 == null ? var2_2.getOrientedBox() : var11_12.a(var2_2.getOrientedBox().d(), var8_9, var9_10, var10_11, var12_13);
        if (!var4_4) ** GOTO lbl12
        var7_8.add(new B(var13_14, var12_13, var2_2, false));
        if (var19_7 == 0) ** GOTO lbl26
lbl12: // 2 sources:
        if (var3_3 == null || var3_3 == var11_12) ** GOTO lbl24
        var14_15 = var3_3.a(var13_14, var8_9, var9_10, var10_11);
        var15_16 = n.a(var2_2.getOrientedBox(), var3_3, var14_15, var2_2.getPreferredPlacementDescriptor());
        var16_17 = n.a(var0, var1_1, var15_16, var3_3, var5_5, var6_6);
        var17_18 = var16_17.m();
        while (var17_18.f()) {
            var18_19 = (B)var17_18.d();
            v1 = var7_8;
            if (var19_7 != 0) return v1;
            v1.add(n.a(var18_19, var2_2, var11_12, var8_9, var9_10, var10_11));
            var17_18.g();
            if (var19_7 == 0) continue;
lbl24: // 2 sources:
            var7_8.addAll(n.a(var0, var1_1, var2_2, var11_12, var5_5, var6_6));
            break;
        }
lbl26: // 3 sources:
        v1 = var7_8;
        return v1;
    }

    private static B a(B b2, C c2, E e2, I i2, am am2, am am3) {
        Object object = e2.a(b2.d(), i2, am2, am3);
        y.d.n n2 = e2.a(b2.d().d(), i2, am2, am3, object);
        return new B(n2, object, c2);
    }

    private static C a(y.d.n n2, E e2, Object object, aG aG2) {
        D d2 = new D();
        d2.a(e2);
        d2.setModelParameter(object);
        d2.a(aG2);
        d2.a(n2);
        return d2;
    }

    private static y.c.D a(X x2, d d2, C c2, E e2, boolean bl2, boolean bl3) {
        I i2 = x2.b(d2);
        am am2 = x2.a(d2.c());
        am am3 = x2.a(d2.d());
        if (e2 == null) return n.a(x2, d2, c2, bl2, bl3);
        if (!n.a(e2, i2, am2, am3)) return e2.a(c2, i2, am2, am3);
        return n.a(x2, d2, c2, bl2, bl3);
    }

    private static y.c.D a(X x2, d d2, C c2, boolean bl2, boolean bl3) {
        int n2 = a.f;
        y y2 = x2.s(d2.c());
        y y3 = x2.s(d2.d());
        am am2 = x2.a(d2.c());
        am am3 = x2.a(d2.d());
        I i2 = x2.b(d2);
        v v2 = ae.a(i2, am2, am3, 0.0);
        y.c.D d3 = new y.c.D();
        if (v2.h() == 0) {
            return d3;
        }
        aG aG2 = c2.getPreferredPlacementDescriptor();
        double d4 = n.a(v2);
        int n3 = n.a(x2, v2);
        int n4 = 0;
        int n5 = v2.h() - 1;
        do {
            int n6 = n4;
            block1 : do {
                if (n6 >= n5) return d3;
                y.d.m m2 = v2.a(n4);
                if (m2.g() <= 0.0) break;
                p[] arrp = n.a(aG2, m2, bl2);
                int n7 = 0;
                block2 : do {
                    int n8 = n7;
                    block3 : while (n8 < arrp.length) {
                        p p2 = arrp[n7];
                        y.d.n[] arrn = n.a(c2, m2, p2);
                        n6 = 0;
                        if (n2 != 0) continue block1;
                        int n9 = n6;
                        block4 : do {
                            int n10 = n9;
                            block5 : while (n10 < arrn.length) {
                                y.d.n n11 = arrn[n9];
                                double[] arrd = n.a(n11, m2, p2, n3);
                                n8 = 0;
                                if (n2 != 0) continue block3;
                                for (int i3 = v1414560; i3 < arrd.length; ++i3) {
                                    y.d.n n12 = new y.d.n(n11);
                                    z z2 = m2.i();
                                    z2.b(arrd[i3]);
                                    t t2 = z.a(m2.c(), z2);
                                    n.a(n12, m2, t2, p2);
                                    n10 = (int)bl3 ? 1 : 0;
                                    if (n2 != 0) continue block5;
                                    if (n10 != 0) {
                                        ae.b(n12);
                                    }
                                    double d5 = d4;
                                    boolean bl4 = true;
                                    if (aG2.i()) {
                                        bl4 = false;
                                        d5 = Math.min(d5, n.a(y2, n12));
                                    }
                                    if (aG2.k()) {
                                        bl4 = false;
                                        d5 = Math.min(d5, n.a(y3, n12));
                                    }
                                    if (!bl4 && d5 >= 100.0) continue;
                                    Object object = c2.getLabelModel().a(n12, i2, am2, am3);
                                    B b2 = new B(n12, object, c2, false);
                                    double d6 = n.a(b2, aG2, p2);
                                    b2.a(d6);
                                    d3.add(b2);
                                    if (n2 == 0) continue;
                                }
                                ++n9;
                                if (n2 == 0) continue block4;
                            }
                            break block4;
                            break;
                        } while (true);
                        ++n7;
                        if (n2 == 0) continue block2;
                    }
                    break block1;
                    break;
                } while (true);
                break;
            } while (true);
            ++n4;
        } while (n2 == 0);
        return d3;
    }

    private static int a(X x2, v v2) {
        int n2 = (int)Math.floor(30.0 / (double)(v2.h() - 1));
        if (x2.h() > 100) {
            n2 = (int)Math.floor(15.0 / (double)(v2.h() - 1));
            if (a.f == 0) return Math.max(n2, 5);
        }
        if (x2.h() <= 500) return Math.max(n2, 5);
        n2 = (int)Math.floor(10.0 / (double)(v2.h() - 1));
        return Math.max(n2, 5);
    }

    private static double a(v v2) {
        double d2 = v2.k();
        return Math.max(100.0, d2 * 0.2);
    }

    private static p[] a(aG aG2, y.d.m m2, boolean bl2) {
        p[] arrp = n.b(aG2, m2, bl2);
        n.a(arrp);
        n.b(arrp);
        n.a(arrp, aG2);
        return arrp;
    }

    /*
     * Unable to fully structure code
     */
    private static p[] b(aG var0, y.d.m var1_1, boolean var2_2) {
        var18_3 = a.f;
        var3_4 = var1_1.j() < 0.0;
        var4_5 = var1_1.j() > 0.0;
        var5_6 = var1_1.k() < -0.001;
        var6_7 = var1_1.k() > 0.001;
        var7_8 = var5_6 == false && var6_7 == false;
        var8_9 = var0.l();
        var9_10 = var0.n();
        var10_11 = var0.m();
        var11_12 = var0.u();
        var12_13 = var0.v();
        var13_14 = var0.w();
        var14_15 = new p[5];
        var15_16 = 0;
        if (var10_11) {
            var14_15[var15_16++] = new p(1, false, null);
        }
        if (!var9_10 || (!var2_2 || !var6_7 && !var7_8) && (var2_2 || (!var6_7 || !var12_13 && !var13_14) && (!var4_5 || !var7_8 || !var13_14) && (!var3_4 || !var7_8 || !var12_13))) ** GOTO lbl-1000
        var14_15[var15_16++] = new p(0, true, null);
        var14_15[var15_16++] = new p(0, true, null);
        if (var18_3 != 0) lbl-1000: // 2 sources:
        {
            if (var8_9 && (var2_2 && var5_6 || !var2_2 && (var11_12 || var5_6 && (var12_13 || var13_14) || var4_5 && var7_8 && var12_13 || var3_4 && var7_8 && var13_14))) {
                var14_15[var15_16++] = new p(0, false, null);
                var14_15[var15_16++] = new p(0, false, null);
            }
        }
        if (!var9_10 || (!var2_2 || !var5_6) && (var2_2 || !var11_12 && (!var5_6 || !var12_13 && !var13_14) && (!var4_5 || !var7_8 || !var12_13) && (!var3_4 || !var7_8 || !var13_14))) ** GOTO lbl-1000
        var14_15[var15_16++] = new p(2, false, null);
        var14_15[var15_16++] = new p(2, false, null);
        if (var18_3 != 0) lbl-1000: // 2 sources:
        {
            if (var8_9 && (var2_2 && (var6_7 || var7_8) || !var2_2 && (var6_7 && (var12_13 || var13_14) || var4_5 && var7_8 && var13_14 || var3_4 && var7_8 && var12_13))) {
                var14_15[var15_16++] = new p(2, true, null);
                var14_15[var15_16++] = new p(2, true, null);
            }
        }
        if (var15_16 == 0) {
            var14_15[var15_16++] = new p(1, false, null);
            var14_15[var15_16++] = new p(0, false, null);
            var14_15[var15_16++] = new p(0, false, null);
            var14_15[var15_16++] = new p(2, false, null);
            var14_15[var15_16++] = new p(2, false, null);
            if (var18_3 == 0) return var14_15;
        }
        if (var15_16 >= 5) return var14_15;
        var16_17 = new p[var15_16];
        var17_18 = 0;
        do {
            if (var17_18 >= var15_16) return var16_17;
            var16_17[var17_18] = var14_15[var17_18];
            ++var17_18;
            if (var18_3 != 0) return var14_15;
        } while (var18_3 == 0);
        return var16_17;
    }

    private static void a(p[] arrp, aG aG2) {
        int n2;
        int n3 = a.f;
        int n4 = n2 = aG2.h() <= 0.0 ? 40 : (int)Math.ceil(aG2.h());
        if (arrp.length == 1) {
            p.a(arrp[0], 0);
            if (n3 == 0) return;
        }
        if (arrp.length == 2) {
            p.a(arrp[0], 0);
            p.a(arrp[1], n2);
            if (n3 == 0) return;
        }
        if (arrp.length == 3) {
            p.a(arrp[0], 0);
            p.a(arrp[1], 0);
            p.a(arrp[2], n2);
            if (n3 == 0) return;
        }
        if (arrp.length == 4) {
            p.a(arrp[0], 0);
            p.a(arrp[1], n2);
            p.a(arrp[2], 0);
            p.a(arrp[3], n2);
            if (n3 == 0) return;
        }
        if (arrp.length != 5) return;
        p.a(arrp[0], 0);
        p.a(arrp[1], 0);
        p.a(arrp[2], n2);
        p.a(arrp[3], 0);
        p.a(arrp[4], n2);
    }

    private static void a(p[] arrp) {
        int n2 = a.f;
        if (arrp.length < 5) {
            int n3 = 0;
            do {
                if (n3 >= arrp.length) return;
                p.a(arrp[n3], 1.0);
                ++n3;
            } while (n2 == 0);
        }
        if (arrp.length != 5) return;
        p.a(arrp[0], 1.0);
        p.a(arrp[1], 1.0);
        p.a(arrp[2], 2.0);
        p.a(arrp[3], 1.0);
        p.a(arrp[4], 2.0);
    }

    private static void b(p[] arrp) {
        int n2 = a.f;
        if (arrp.length < 5) {
            int n3 = 0;
            do {
                if (n3 >= arrp.length) return;
                p.b(arrp[n3], 0);
                ++n3;
            } while (n2 == 0);
        }
        if (arrp.length != 5) return;
        p.b(arrp[0], 0);
        p.b(arrp[1], 1);
        p.b(arrp[2], 0);
        p.b(arrp[3], 1);
        p.b(arrp[4], 0);
    }

    private static double a(y y2, y.d.n n2) {
        return m.a(y2, n2);
    }

    private static double a(B b2, aG aG2, p p2) {
        double d2 = 0.0;
        double d3 = aG2.m() ? 0.0 : aG2.h();
        if (d3 < 0.0) return 1.0;
        if (Math.abs(d3 - (double)p.a(p2)) >= 0.001) return d2;
        return 1.0;
    }

    private static y.d.n a(q q2, z z2, double d2) {
        z z3 = d2 != 0.0 ? z2.a(d2) : z2;
        return new y.d.n(c, q2, z3);
    }

    /*
     * Exception decompiling
     */
    private static y.d.n[] a(C var0, y.d.m var1_1, p var2_2) {
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

    private static void a(y.d.n n2, y.d.m m2, t t2, p p2) {
        if (p.b(p2) == 1) {
            n2.e(t2.a, t2.b);
            if (a.f == 0) return;
        }
        z z2 = z.c(m2.i());
        if (p.b(p2) == 0) {
            z2 = new z(- z2.a(), - z2.b());
        }
        z2.b((double)p.a(p2) + n2.e() + n2.f());
        t t3 = z.a(t2, z2);
        n2.e(t3.a, t3.b);
        t[] arrt = y.d.n.a(n2);
        double d2 = n.a(m2, arrt);
        z z3 = new z(- z2.a(), - z2.b());
        z3.c();
        z3.b(d2 - (double)Math.abs(p.a(p2)));
        t3 = z.a(t3, z3);
        n2.e(t3.a, t3.b);
    }

    private static double a(y.d.m m2, t[] arrt) {
        double d2;
        int n2 = a.f;
        double d3 = Double.MAX_VALUE;
        for (int i2 = 0; i2 < arrt.length; ++i2) {
            double d4;
            d2 = d4 = n.a(m2, arrt[i2]);
            if (n2 != 0) return d2;
            if (d2 >= d3) continue;
            d3 = d4;
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    private static double[] a(y.d.n n2, y.d.m m2, p p2, int n3) {
        int n4 = a.f;
        t t2 = n2.k();
        z z2 = m2.i();
        z2.c();
        z2.b(Math.max(n2.e(), n2.f()));
        t t3 = z.a(t2, z2);
        y.d.m m3 = new y.d.m(t2, t3);
        t t4 = y.d.n.b(n2, m3, 0.0);
        double d2 = 2.0 * t.a(t2, t4);
        int n5 = (int)Math.floor(m2.g() / (d2 * p.d(p2)));
        n5 = Math.max(n5, 3);
        n5 = Math.min(n5, n3);
        if (n5 % 2 == 0) {
            ++n5;
        }
        double d3 = 1.0 / (double)(n5 - 1 + 2 * p.e(p2));
        double[] arrd = new double[n5];
        int n6 = 0;
        for (int i2 = p.e((p)p2); i2 < n5 + p.e(p2); ++i2) {
            arrd[n6++] = d3 * (double)i2;
            if (n4 != 0) return arrd;
            if (n4 == 0) continue;
        }
        if (p.e(p2) != 0) return arrd;
        arrd[n5 - 1] = 1.0;
        return arrd;
    }

    private static double a(y.d.m m2, t t2) {
        t t3 = m2.c();
        t t4 = m2.d();
        double d2 = t2.a - t3.a;
        double d3 = t2.b - t3.b;
        double d4 = t4.a - t3.a;
        double d5 = t4.b - t3.b;
        double d6 = d2 * d4 + d3 * d5;
        double d7 = d6 * d6 / (d4 * d4 + d5 * d5);
        double d8 = d2 * d2 + d3 * d3 - d7;
        if (d8 >= 0.0) return Math.sqrt(d8);
        d8 = 0.0;
        return Math.sqrt(d8);
    }
}

