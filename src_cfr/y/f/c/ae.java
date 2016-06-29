/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.f;
import y.c.q;
import y.c.x;
import y.d.n;
import y.d.t;
import y.d.y;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.am;
import y.f.c.K;
import y.f.c.a;
import y.f.c.aF;
import y.g.e;

class aE {
    private X a;
    private A b;
    private boolean c;
    private static Comparator d = new aF(false);
    private static Comparator e = new aF(true);
    private A f;
    private A g;
    private c h;
    private boolean i = false;

    public aE(X x2, A a2, A a3, c c2) {
        this.a = x2;
        this.f = a2;
        this.g = a3;
        this.h = c2;
        this.i = true;
    }

    public void a(boolean bl2) {
        this.c = bl2;
    }

    public boolean a() {
        return this.c;
    }

    /*
     * Exception decompiling
     */
    public y.c.y[] a(y.c.y[] var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[FORLOOP]], but top level block is 14[FORLOOP]
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

    private void a(q q2, S s2) {
        D d2 = (D)this.b.b(q2);
        if (d2 == null) {
            d2 = new D();
            this.b.a((Object)q2, d2);
        }
        d2.add(s2);
    }

    /*
     * Unable to fully structure code
     */
    private void d() {
        var25_1 = a.i;
        var1_2 = new ArrayList<S>(5);
        var2_3 = new ArrayList<S>(5);
        var3_4 = new ArrayList<S>(5);
        var4_5 = this.a.o();
        block4 : do {
            v0 = var4_5.f();
            if (v0 == 0) return;
            var5_6 = var4_5.e();
            var6_7 = (D)this.b.b(var5_6);
            if (var6_7 == null) ** GOTO lbl109
            var7_8 = (S[])var6_7.toArray(new S[var6_7.size()]);
            var8_9 = (d)this.g.b(var5_6);
            if (var8_9 == null) {
                throw new IllegalStateException("realEdge == null: Can't be!!!");
            }
            var9_10 = 0.0;
            var11_11 = 0.0;
            var13_12 = 0.0;
            var15_14 = 0;
            block5 : do {
                v1 = var15_14;
                v2 = var7_8.length;
                while (v1 < v2) {
                    var16_16 = var7_8[var15_14];
                    var17_17 = var16_16.f().b();
                    v1 = var17_17;
                    v2 = 16;
                    if (var25_1) continue;
                    if (v1 != v2) ** GOTO lbl32
                    var9_10 = Math.max(var9_10, var16_16.b());
                    if (!var25_1) ** GOTO lbl36
lbl32: // 2 sources:
                    if (var17_17 != 32) ** GOTO lbl-1000
                    var11_11 = Math.max(var11_11, var16_16.b());
                    if (var25_1) lbl-1000: // 2 sources:
                    {
                        var13_12 = Math.max(var13_12, var16_16.b());
                    }
lbl36: // 4 sources:
                    ++var15_14;
                    if (!var25_1) continue block5;
                }
                break block5;
                break;
            } while (true);
            if (var13_12 > var9_10 * 2.0) {
                var9_10 = var13_12 / 2.0;
            }
            if (var13_12 > var11_11 * 2.0) {
                var11_11 = var13_12 / 2.0;
            }
            var15_13 = new byte[]{1, 4, 0, 2};
            var16_15 = 0.0;
            var18_18 = 0;
            block7 : do {
                v3 = var18_18;
                v4 = var15_13.length;
                block8 : while (v3 < v4) {
                    block22 : {
                        block21 : {
                            var1_2.clear();
                            var2_3.clear();
                            var3_4.clear();
                            v0 = 0;
                            if (var25_1 != false) return;
                            block9 : for (var19_20 = v1402835; var19_20 < var7_8.length; ++var19_20) {
                                var20_23 = var7_8[var19_20];
                                var21_25 = var20_23.f();
                                v3 = aE.a(var21_25);
                                v4 = var15_13[var18_18];
                                if (var25_1) continue block8;
                                if (v3 != v4) continue;
                                var22_28 = var21_25.b();
                                switch (var22_28) {
                                    case 16: {
                                        var1_2.add(var20_23);
                                        if (!var25_1) continue block9;
                                    }
                                    case 32: {
                                        var2_3.add(var20_23);
                                        if (!var25_1) continue block9;
                                    }
                                }
                                var3_4.add(var20_23);
                                if (!var25_1) continue;
                            }
                            var19_21 = var16_15;
                            var21_26 = var16_15;
                            for (var23_29 = 0; var23_29 < var1_2.size(); var19_21 += var24_30.c(), ++var23_29) {
                                var24_30 = (S)var1_2.get(var23_29);
                                var24_30.a(var11_11, var19_21);
                                if (!var25_1) {
                                    if (!var25_1) continue;
                                }
                                break block21;
                            }
                            var23_29 = 0;
                        }
                        while (var23_29 < var2_3.size()) {
                            var24_30 = (S)var2_3.get(var23_29);
                            var24_30.a(var11_11 - var24_30.b(), var21_26);
                            var21_26 += var24_30.c();
                            ++var23_29;
                            if (!var25_1) {
                                if (!var25_1) continue;
                            }
                            break block22;
                        }
                        var16_15 = Math.max(var19_21, var21_26);
                    }
                    for (var23_29 = 0; var23_29 < var3_4.size(); var16_15 += var24_30.c(), ++var23_29) {
                        var24_30 = (S)var3_4.get(var23_29);
                        var24_30.a(var11_11 - var24_30.b() / 2.0, var16_15);
                        if (var25_1) continue block7;
                        if (!var25_1) continue;
                    }
                    ++var18_18;
                    if (!var25_1) continue block7;
                }
                break block7;
                break;
            } while (true);
            this.a.b(var5_6, var9_10 + var11_11, var16_15);
            var18_19 = new t((- var9_10 + var11_11) / 2.0 + var11_11, (- var16_15) / 2.0);
            this.a.b(var5_6.g(), var18_19);
            var19_22 = new t((- var9_10 + var11_11) / 2.0 + var11_11, var16_15 / 2.0);
            this.a.a(var5_6.f(), var19_22);
            if (this.h.d(var8_9)) {
                for (var20_24 = 0; var20_24 < var7_8.length; ++var20_24) {
                    var21_27 = var7_8[var20_24];
                    var21_27.a(var21_27.d(), var16_15 - var21_27.c() - var21_27.e());
                    if (var25_1) continue block4;
                    if (!var25_1) continue;
                }
            }
lbl109: // 5 sources:
            var4_5.g();
        } while (!var25_1);
    }

    public S[] a(d d2) {
        c c2 = this.a.c(U.a);
        if (c2 != null) return (S[])c2.b(d2);
        return null;
    }

    private S[] a(q q2) {
        D d2 = (D)this.b.b(q2);
        if (d2 == null) return null;
        return (S[])d2.toArray(new S[d2.size()]);
    }

    private boolean e() {
        if (!this.a()) {
            return false;
        }
        c c2 = this.a.c(U.a);
        if (c2 != null) return true;
        return false;
    }

    public void a(f f2) {
        boolean bl2 = a.i;
        if (!this.e()) {
            return;
        }
        x x2 = this.a.o();
        while (x2.f()) {
            q q2 = x2.e();
            S[] arrs = this.a(q2);
            if (bl2) return;
            if (arrs != null) {
                d d2 = (d)this.g.b(q2);
                if (d2 == null) {
                    throw new IllegalStateException("realEdge == null: Can't be!!!");
                }
                am am2 = this.a.h(q2);
                double d3 = am2.getX();
                double d4 = am2.getY();
                double d5 = am2.getWidth();
                double d6 = am2.getHeight();
                for (int i2 = 0; i2 < arrs.length; ++i2) {
                    double d7 = arrs[i2].d();
                    double d8 = arrs[i2].e();
                    arrs[i2].a(d7 + d3, d8 + d4);
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break;
                }
            } else {
                x2.g();
            }
            if (!bl2) continue;
        }
        this.b(f2);
        this.b();
        this.a.a(this.b);
    }

    public void b() {
        boolean bl2 = a.i;
        y.c.e e2 = this.a.p();
        do {
            Object[] arrobject;
            d d2;
            if (!e2.f()) return;
            if (e2.a().e() && (arrobject = this.a(d2 = e2.a())) != null) {
                int n2;
                block11 : {
                    t t2;
                    int n3;
                    t t3;
                    t[] arrt;
                    int n4;
                    block10 : {
                        e.a(arrobject, d);
                        D d3 = this.a.m(d2);
                        arrt = (t[])d3.toArray(new t[d3.size()]);
                        t2 = arrt[0];
                        for (n3 = 1; n3 < arrt.length; ++n3) {
                            t3 = arrt[n3];
                            n4 = (int)(t2.b() DCMPL t3.b());
                            if (!bl2) {
                                if (n4 == 0) {
                                    this.a(t2, t3, (S[])arrobject, true);
                                    if (!bl2) break;
                                }
                                t2 = t3;
                                if (!bl2) continue;
                            }
                            break block10;
                        }
                        n4 = n3;
                    }
                    if (n4 >= arrt.length) {
                        // empty if block
                    }
                    t2 = arrt[arrt.length - 1];
                    for (n3 = arrt.length - 2; n3 >= 0; --n3) {
                        t3 = arrt[n3];
                        n2 = (int)(t2.b() DCMPL t3.b());
                        if (!bl2) {
                            if (n2 == 0) {
                                this.a(t2, t3, (S[])arrobject, false);
                                if (!bl2) break;
                            }
                            t2 = t3;
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    n2 = n3;
                }
                if (n2 < 0) {
                    // empty if block
                }
            }
            e2.g();
        } while (!bl2);
    }

    public void b(f f2) {
        boolean bl2 = a.i;
        y.c.e e2 = f2.a();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            Object[] arrobject = this.a(d2);
            if (arrobject != null) {
                int n2;
                block11 : {
                    t[] arrt;
                    t t2;
                    int n3;
                    int n4;
                    t t3;
                    block10 : {
                        e.a(arrobject, d);
                        D d3 = this.a.m(d2);
                        arrt = (t[])d3.toArray(new t[d3.size()]);
                        t3 = arrt[0];
                        for (n4 = 1; n4 < arrt.length; ++n4) {
                            t2 = arrt[n4];
                            n3 = (int)(t3.b() DCMPL t2.b());
                            if (!bl2) {
                                if (n3 == 0) {
                                    this.a(t3, t2, (S[])arrobject, true);
                                    if (!bl2) break;
                                }
                                t3 = t2;
                                if (!bl2) continue;
                            }
                            break block10;
                        }
                        n3 = n4;
                    }
                    if (n3 >= arrt.length) {
                        // empty if block
                    }
                    t3 = arrt[arrt.length - 1];
                    for (n4 = arrt.length - 2; n4 >= 0; --n4) {
                        t2 = arrt[n4];
                        n2 = (int)(t3.b() DCMPL t2.b());
                        if (!bl2) {
                            if (n2 == 0) {
                                this.a(t3, t2, (S[])arrobject, false);
                                if (!bl2) break;
                            }
                            t3 = t2;
                            if (!bl2) continue;
                        }
                        break block11;
                    }
                    n2 = n4;
                }
                if (n2 < 0) {
                    // empty if block
                }
            }
            e2.g();
        } while (!bl2);
    }

    void a(t t2, t t3, S[] arrs, boolean bl2) {
        S s2;
        double d2;
        int n2;
        double d3;
        boolean bl3;
        boolean bl4 = a.i;
        boolean bl5 = bl3 = t2.a() < t3.a();
        if (bl3) {
            if (bl2) {
                d3 = t2.a() + 10.0;
                d2 = t2.b();
                n2 = 0;
                do {
                    if (n2 >= arrs.length) return;
                    s2 = arrs[n2];
                    if (s2.f().a() == 2) {
                        return;
                    }
                    s2.a(d3, d2 - s2.c() / 2.0);
                    d3 += s2.b() + 10.0;
                    ++n2;
                } while (!bl4);
            }
            d3 = t2.a() + 10.0;
            d2 = t2.b();
            n2 = arrs.length - 1;
            do {
                if (n2 < 0) return;
                s2 = arrs[n2];
                if (s2.f().a() != 2) {
                    return;
                }
                y y2 = s2.a().h();
                s2.a(d3, d2 - s2.c() / 2.0);
                d3 += s2.b() + 10.0;
                --n2;
            } while (!bl4);
        }
        if (bl2) {
            d3 = t2.a() - 10.0;
            d2 = t2.b();
            n2 = 0;
            do {
                if (n2 >= arrs.length) return;
                s2 = arrs[n2];
                if (s2.f().a() == 2) {
                    return;
                }
                s2.a(d3 - s2.b(), d2 - s2.c() / 2.0);
                d3 -= s2.b() + 10.0;
                ++n2;
            } while (!bl4);
        }
        d3 = t2.a() - 10.0;
        d2 = t2.b();
        n2 = arrs.length - 1;
        do {
            if (n2 < 0) return;
            s2 = arrs[n2];
            if (s2.f().a() != 2) {
                return;
            }
            s2.a(d3 - s2.b(), d2 - s2.c() / 2.0);
            d3 -= s2.b() + 10.0;
            --n2;
        } while (!bl4);
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(d var1_1, List var2_2) {
        var5_3 = a.i;
        var3_4 = var1_1;
        var4_5 = this.f.a(var3_4.c());
        while (this.g.b(var3_4.c()) != null) {
            v0 = var2_2.get(var4_5);
            v1 = K.p;
            if (!var5_3) {
                if (v0 == v1) return true;
                if (var2_2.get(var4_5) == K.q) {
                    return true;
                }
                var3_4 = var3_4.c().g();
                --var4_5;
                if (!var5_3) continue;
            }
            ** GOTO lbl22
        }
        var3_4 = var1_1;
        var4_5 = this.f.a(var3_4.c()) + 1;
        do {
            if (this.g.b(var3_4.d()) == null) return false;
            var3_4 = var3_4.d().f();
            v0 = var2_2.get(var4_5);
            v1 = K.p;
lbl22: // 2 sources:
            if (v0 == v1) return true;
            if (var2_2.get(var4_5) == K.q) {
                return true;
            }
            ++var4_5;
        } while (!var5_3);
        return false;
    }

    public void c() {
        this.h = null;
        this.g = null;
        this.b = null;
        this.f = null;
        this.a = null;
    }

    private static byte a(aG aG2) {
        byte by2 = aG2.a();
        if (by2 != 7) return by2;
        return 0;
    }
}

