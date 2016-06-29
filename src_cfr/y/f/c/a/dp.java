/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.p;
import y.c.q;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bs;
import y.f.c.a.db;
import y.f.c.a.dq;
import y.f.c.a.dr;
import y.f.c.a.ds;
import y.g.ap;

class dp {
    private static final double a = Math.sqrt(2.0);
    private D b;
    private D c;
    private Map d;
    private Map e;
    private db f;

    void a(db db2) {
        this.f = db2;
    }

    /*
     * Exception decompiling
     */
    public void a(X var1_1, aU var2_2, aV var3_3, aP var4_4, h var5_5, ap var6_6) {
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

    private static boolean a(aV aV2, d d2) {
        if (aV2 == null) return false;
        if (aV2.a(d2) == null) return false;
        if (aV2.a(d2).k() == null) {
            return false;
        }
        bs bs2 = aV2.a(d2).k().h();
        if (bs2.b() != 1) return false;
        return true;
    }

    private static double b(aV aV2, d d2) {
        if (aV2 == null) return 0.0;
        if (aV2.a(d2) == null) return 0.0;
        if (aV2.a(d2).k() != null) return aV2.a(d2).k().i();
        return 0.0;
    }

    /*
     * Unable to fully structure code
     */
    public void a(X var1_1, aU var2_2, aV var3_3, HashSet var4_4) {
        block38 : {
            block36 : {
                var15_5 = N.x;
                var5_6 = new ArrayList<Object>(50);
                for (var6_7 = this.b.k(); var6_7 != null; var6_7 = var6_7.a()) {
                    var7_8 = (ds)var6_7.c();
                    v0 = var7_8.b.k();
                    if (var15_5) break block36;
                    for (var8_9 = v1384164; var8_9 != null; var8_9 = var8_9.a()) {
                        block37 : {
                            var9_10 = (d)var8_9.c();
                            v1 = var1_1.f(var9_10);
                            if (var15_5) ** GOTO lbl72
                            if (!v1) {
                                var1_1.e(var9_10);
                                var10_11 = var1_1.b(var9_10);
                                var10_11.clearPoints();
                                if (!var15_5) break block37;
                            }
                            var10_11 = var1_1.b(var9_10);
                        }
                        var11_12 = var7_8.d.b(var9_10.c());
                        var5_6.clear();
                        while (var11_12 != null) {
                            var12_13 = var1_1.b(var11_12);
                            v2 = var11_12.c();
                            v3 = var9_10.c();
                            if (var15_5) ** GOTO lbl82
                            if (v2 != v3) ** GOTO lbl-1000
                            var10_11.setSourcePoint(var12_13.getSourcePoint());
                            if (var15_5) lbl-1000: // 2 sources:
                            {
                                var13_14 = (reference)var1_1.p(var11_12);
                                var5_6.add(var13_14);
                                if (var7_8.b.size() > 1) {
                                    var4_4.add(new dr(var9_10, var13_14, null));
                                }
                            }
                            for (var13_15 = 0; var13_15 < var12_13.pointCount(); ++var13_15) {
                                var5_6.add(var12_13.getPoint(var13_15));
                                if (!var15_5) {
                                    if (!var15_5) continue;
                                }
                                ** GOTO lbl-1000
                            }
                            if (var11_12.d() != var9_10.d()) ** GOTO lbl-1000
                            var10_11.setTargetPoint(var12_13.getTargetPoint());
                            if (var15_5) lbl-1000: // 3 sources:
                            {
                                var13_16 = var1_1.q(var11_12);
                                var5_6.add(var13_16);
                                if (var7_8.b.size() > 1) {
                                    var4_4.add(new dr(var9_10, var13_16, null));
                                }
                            }
                            var11_12 = this.a(var11_12.d(), var9_10);
                            if (!var15_5) continue;
                        }
                        var12_13 = var1_1.p(var9_10);
                        for (var13_14 = 0; var13_14 < var5_6.size(); ++var13_14) {
                            var14_19 = (t)var5_6.get((int)var13_14);
                            v1 = var4_4.contains(new dr(var9_10, var14_19, null));
                            if (!var15_5) {
                                if (v1 && var14_19.b < var12_13.b) {
                                    var14_19 = new t(var14_19.a, var12_13.b);
                                    var4_4.add(new dr(var9_10, var14_19, null));
                                }
                                if (!var12_13.equals(var14_19)) {
                                    var10_11.addPoint(var14_19.a, var14_19.b);
                                }
                                var12_13 = var14_19;
                                if (!var15_5) continue;
                            }
                            ** GOTO lbl72
                        }
                        if (!var15_5) continue;
                    }
                    if (!var15_5) continue;
                }
                v0 = var6_7 = this.c.k();
            }
            while (var6_7 != null) {
                var7_8 = (ds)var6_7.c();
                v4 = var7_8.b.k();
                if (var15_5) break block38;
                for (var8_9 = v1384336; var8_9 != null; var8_9 = var8_9.a()) {
                    var9_10 = (d)var8_9.c();
                    v5 = var1_1;
                    if (var15_5) ** GOTO lbl141
                    v1 = v5.f(var9_10);
lbl72: // 3 sources:
                    block7 : do {
                        block39 : {
                            if (!v1) {
                                var1_1.e(var9_10);
                                var10_11 = var1_1.b(var9_10);
                                var10_11.clearPoints();
                                if (!var15_5) break block39;
                            }
                            var10_11 = var1_1.b(var9_10);
                        }
                        v2 = var7_8.d;
                        v3 = var9_10.d();
lbl82: // 2 sources:
                        block8 : do {
                            var11_12 = v2.a(v3);
                            var5_6.clear();
                            while (var11_12 != null) {
                                var12_13 = var1_1.b(var11_12);
                                v2 = var11_12.d();
                                v3 = var9_10.d();
                                if (var15_5) continue block8;
                                if (v2 != v3) ** GOTO lbl-1000
                                var10_11.setTargetPoint(var12_13.getTargetPoint());
                                if (var15_5) lbl-1000: // 2 sources:
                                {
                                    var13_17 = var1_1.q(var11_12);
                                    var5_6.add(var13_17);
                                    if (var7_8.b.size() > 1) {
                                        var4_4.add(new dr(var9_10, var13_17, null));
                                    }
                                }
                                for (var13_14 = (reference)(var12_13.pointCount() - 1); var13_14 >= 0; --var13_14) {
                                    var5_6.add(var12_13.getPoint((int)var13_14));
                                    if (!var15_5) {
                                        if (!var15_5) continue;
                                    }
                                    ** GOTO lbl-1000
                                }
                                if (var11_12.c() != var9_10.c()) ** GOTO lbl-1000
                                var10_11.setSourcePoint(var12_13.getSourcePoint());
                                if (var15_5) lbl-1000: // 3 sources:
                                {
                                    var13_18 = var1_1.p(var11_12);
                                    var5_6.add(var13_18);
                                    if (var7_8.b.size() > 1) {
                                        var4_4.add(new dr(var9_10, var13_18, null));
                                    }
                                }
                                var11_12 = this.b(var11_12.c(), var9_10);
                                if (!var15_5) continue;
                            }
                            break block8;
                            break;
                        } while (true);
                        var12_13 = var10_11.pointCount() > 0 ? var10_11.getPoint(var10_11.pointCount() - 1) : var1_1.p(var9_10);
                        for (var13_14 = var5_6.size() - 1; var13_14 >= 0; --var13_14) {
                            var14_19 = (t)var5_6.get((int)var13_14);
                            v1 = var4_4.contains(new dr(var9_10, var14_19, null));
                            if (var15_5) continue block7;
                            if (v1 && var14_19.b < var12_13.b) {
                                var14_19 = new t(var14_19.a, var12_13.b);
                                var4_4.add(new dr(var9_10, var14_19, null));
                            }
                            if (!var12_13.equals(var14_19)) {
                                var10_11.addPoint(var14_19.a, var14_19.b);
                            }
                            var12_13 = var14_19;
                            if (!var15_5) continue;
                        }
                        break;
                    } while (true);
                    if (!var15_5) continue;
                }
                var6_7 = var6_7.a();
                if (!var15_5) continue;
            }
            v4 = var6_7 = this.b.k();
        }
        while (var6_7 != null) {
            var7_8 = ((ds)var6_7.c()).d;
            v6 = var1_1.f((q)var7_8);
            if (!var15_5) {
                if (v6) {
                    var1_1.a((q)var7_8);
                }
                var6_7 = var6_7.a();
                if (!var15_5) continue;
            }
            ** GOTO lbl143
        }
        var6_7 = this.c.k();
        do {
            if (var6_7 == null) return;
            v5 = var6_7.c();
lbl141: // 2 sources:
            var7_8 = ((ds)v5).d;
            v6 = var1_1.f((q)var7_8);
lbl143: // 2 sources:
            if (v6) {
                var1_1.a((q)var7_8);
            }
            var6_7 = var6_7.a();
        } while (!var15_5);
    }

    private static boolean a(t t2, t t3) {
        if (Math.abs(t2.a - t3.a) >= 0.001) return false;
        if (t2.b >= t3.b) return false;
        return true;
    }

    private static boolean b(t t2, t t3) {
        if (Math.abs(t2.b - t3.b) >= 0.001) return false;
        return true;
    }

    public void a(X x2, aV aV2, HashSet hashSet) {
        boolean bl2 = N.x;
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            A a2 = aV2.a(d2);
            if (!(d2.e() || dp.a(d2, aV2) || a2.g() == null && a2.h() == null || !dp.a(aV2, d2))) {
                dp.a(d2, x2, aV2, hashSet);
            }
            e2.g();
        } while (!bl2);
    }

    private static boolean a(d d2, aV aV2) {
        if (aV2.a(d2.c()).j() != aV2.a(d2.d()).j()) return false;
        return true;
    }

    private static void a(D d2, t t2) {
        if (!d2.isEmpty()) {
            if (d2.i().equals(t2)) return;
        }
        d2.add(t2);
    }

    private static void a(D d2, double d3, double d4) {
        t t2 = (t)d2.i();
        if (t2 != null && t2.a == d3) {
            if (t2.b == d4) return;
        }
        d2.add(new t(d3, d4));
    }

    private static boolean b(d d2, aV aV2) {
        if (aV2 == null) return false;
        if (aV2.a(d2) == null) return false;
        if (aV2.a(d2).k() == null) {
            return false;
        }
        bs bs2 = aV2.a(d2).k().h();
        if (bs2.c() != 1) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private static void a(d var0, X var1_1, aV var2_2, HashSet var3_3) {
        var21_4 = N.x;
        var4_5 = var1_1.m(var0);
        if (var4_5.size() < 4) {
            return;
        }
        var5_6 = (t[])var4_5.toArray(new t[var4_5.size()]);
        var6_7 = dp.b(var0, var2_2);
        var7_8 = dp.b(var2_2, var0);
        var9_9 = var7_8 / dp.a;
        var11_10 = new D();
        var12_11 = var5_6[0];
        var13_12 = var5_6[1];
        var14_13 = 2;
        while (var14_13 + 1 < var5_6.length) {
            var15_14 = var5_6[var14_13];
            var16_15 = var5_6[var14_13 + 1];
            if (var21_4 != false) return;
            if (!var6_7 && !var3_3.contains(new dr(var0, var13_12, null)) && !var3_3.contains(new dr(var0, var15_14, null)) || !dp.a(var12_11, var13_12) || !dp.b(var13_12, var15_14) || !dp.a(var15_14, var16_15)) ** GOTO lbl-1000
            var17_16 = Math.abs(var13_12.a - var15_14.a);
            if (var17_16 <= 2.0 * var9_9) ** GOTO lbl-1000
            dp.a(var11_10, var12_11);
            dp.a(var11_10, var13_12.a, var13_12.b - var9_9);
            if (var13_12.a >= var15_14.a) ** GOTO lbl-1000
            dp.a(var11_10, var13_12.a + var9_9, var13_12.b);
            dp.a(var11_10, var15_14.a - var9_9, var15_14.b);
            if (var21_4) lbl-1000: // 2 sources:
            {
                dp.a(var11_10, var13_12.a - var9_9, var13_12.b);
                dp.a(var11_10, var15_14.a + var9_9, var15_14.b);
            }
            var12_11 = new t(var15_14.a, var15_14.b + var9_9);
            dp.a(var11_10, var12_11);
            if (var21_4) lbl-1000: // 2 sources:
            {
                var19_17 = var17_16 / 2.0;
                dp.a(var11_10, var12_11);
                dp.a(var11_10, var13_12.a, var13_12.b - var19_17);
                var12_11 = new t(var15_14.a, var15_14.b + var19_17);
                dp.a(var11_10, var12_11);
                ** if (!var21_4) goto lbl41
            }
            ** GOTO lbl41
lbl-1000: // 2 sources:
            {
                dp.a(var11_10, var12_11);
                dp.a(var11_10, var13_12);
                var12_11 = var15_14;
            }
lbl41: // 3 sources:
            var13_12 = var16_15;
            if (var14_13 + 3 >= var5_6.length) {
                dp.a(var11_10, var12_11);
                dp.a(var11_10, var13_12);
                if (var14_13 + 2 < var5_6.length) {
                    dp.a(var11_10, var5_6[var14_13 + 2]);
                }
            }
            var14_13 += 2;
            if (!var21_4) continue;
        }
        var1_1.a(var0, dp.a(var11_10));
    }

    private static D a(D d2) {
        int n2;
        boolean bl2 = N.x;
        if (d2.size() < 3) {
            return d2;
        }
        D d3 = new D();
        C c2 = d2.m();
        t t2 = (t)c2.d();
        d3.add(t2);
        c2.g();
        double d4 = t2.a();
        double d5 = t2.b();
        if (!c2.f()) return d3;
        t2 = (t)c2.d();
        double d6 = t2.a();
        double d7 = t2.b();
        c2.g();
        while (c2.f()) {
            t t3 = (t)c2.d();
            double d8 = t3.a();
            double d9 = t3.b();
            double d10 = (d4 - d8) * (d7 - d9) / (d5 - d9) + d8;
            n2 = Math.abs(d10 - d6) DCMPL 0.5;
            if (bl2) return d3;
            if (n2 > 0) {
                d3.add(t2);
                d4 = d6;
                d5 = d7;
            }
            t2 = t3;
            d6 = d8;
            d7 = d9;
            c2.g();
            if (!bl2) continue;
        }
        n2 = d3.add(t2);
        return d3;
    }

    private d a(q q2, d d2) {
        if (q2 == d2.d()) {
            return null;
        }
        ds ds2 = (ds)this.d.get(q2);
        if (ds2 == null) {
            return null;
        }
        d d3 = (d)ds2.i.get(d2);
        if (d3 != null) return d3;
        return ds2.e;
    }

    private d b(q q2, d d2) {
        if (q2 == d2.c()) {
            return null;
        }
        ds ds2 = (ds)this.e.get(q2);
        if (ds2 == null) {
            return null;
        }
        d d3 = (d)ds2.i.get(d2);
        if (d3 == null) {
            d3 = ds2.f;
        }
        if (d3 == null) return d3;
        if (!this.d.containsKey(d3.c())) return d3;
        return null;
    }

    public void a(X x2) {
        this.d = null;
        this.e = null;
        this.b = null;
        this.c = null;
    }
}

