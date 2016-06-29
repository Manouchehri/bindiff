/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.x;
import y.d.m;
import y.d.t;
import y.d.v;
import y.f.F;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.am;
import y.f.c.a.A;
import y.f.c.a.B;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bs;
import y.f.c.a.cC;
import y.f.y;
import y.g.e;
import y.g.q;

class cB {
    private static final Object a = "y.layout.hierarchic.incremental.EdgeLabelingSupport.InstanceDPKey";
    private static final Comparator b = new cC(false);
    private boolean c = false;
    private F d;

    public cB(F f2) {
        this.d = f2;
        this.c = true;
    }

    static void a(cB cB2, i i2) {
        i2.a(a, q.a(cB2));
    }

    static void a(i i2) {
        if (i2 == null) return;
        if (i2.c(a) == null) return;
        i2.d_(a);
    }

    static cB b(i i2) {
        c c2 = i2.c(a);
        if (c2 != null) return (cB)c2.b(i2);
        return null;
    }

    /*
     * Unable to fully structure code
     */
    public List a(X var1_1, aU var2_2, aV var3_3, aP var4_4) {
        block14 : {
            var23_5 = N.x;
            if (!this.b(var1_1)) {
                return null;
            }
            var5_6 = new ArrayList<aQ>(60);
            var6_7 = this.a(var1_1);
            for (var7_8 = 0; var7_8 < var2_2.b(); ++var7_8) {
                block15 : {
                    var8_10 = var2_2.a(var7_8);
                    v0 = this.c;
                    if (var23_5) break block14;
                    var9_11 = v0 == 0;
                    block1 : for (var10_13 = var8_10.d().k(); var10_13 != null; var10_13 = var10_13.a()) {
                        v1 = var9_11;
                        if (var23_5) break block15;
                        if (v1) break;
                        var11_14 = (y.c.q)var10_13.c();
                        var12_15 = var3_3.a((y.c.q)var11_14);
                        if (var12_15.b() == 1) continue;
                        for (var13_16 = var11_14.f(); var13_16 != null; var13_16 = var13_16.g()) {
                            v1 = var9_11;
                            if (!var23_5) {
                                block16 : {
                                    if (v1) continue block1;
                                    var14_17 = var3_3.a(var13_16.d());
                                    if (var14_17.b() == 1) {
                                        var15_18 = (S[])var6_7.b(var14_17.g());
                                        if (!var23_5) break block16;
                                    }
                                    var15_18 = (S[])var6_7.b(var13_16);
                                }
                                if (var15_18 == null || var15_18.length <= 0) continue;
                                var9_11 = true;
                                if (!var23_5) continue block1;
                                if (!var23_5) continue;
                            }
                            break block15;
                        }
                        if (!var23_5) continue;
                    }
                    v1 = this.c;
                }
                if (v1 && !var9_11 || var7_8 >= var2_2.b() - 1) continue;
                var5_6.add(var4_4.a(true, ++var7_8));
                if (!var23_5) continue;
            }
            v0 = var2_2.b();
        }
        var7_9 = new y.c.q[v0];
        var8_10 = var1_1.t();
        var1_1.a(new StringBuffer().append(this.getClass().getName()).append(".map").toString(), (c)var8_10);
        var9_12 = var1_1.p();
        block3 : do {
            v2 = var9_12.f();
            block4 : while (v2 != 0) {
                var10_13 = var9_12.a();
                var11_14 = var3_3.a(var10_13.c());
                var12_15 = var3_3.a(var10_13.d());
                if (var23_5 != false) return var5_6;
                if (var11_14.b() == 1 || var12_15.b() != 1) ** GOTO lbl92
                var13_16 = var12_15.g();
                var14_17 = var3_3.a(var13_16);
                var15_18 = this.a(var1_1, var13_16);
                if (var15_18 == null || var15_18.length <= 0) ** GOTO lbl92
                var16_19 = 0;
                var17_20 = var10_13;
                var18_21 = var3_3.a(var17_20.d());
                while (var18_21.b() == 1) {
                    var19_22 = var17_20.d();
                    v2 = var20_23 = var2_2.a(var18_21.j()).e();
                    if (var23_5) continue block4;
                    if (v2 == 0 || var20_23 == 1) {
                        var7_9[var16_19++] = var19_22;
                    }
                    var17_20 = var19_22.f();
                    var18_21 = var3_3.a(var17_20.d());
                    if (!var23_5) continue;
                }
                var19_22 = null;
                if (var16_19 < 1) {
                    throw new IllegalStateException("Did not find edge label position");
                }
                var20_23 = var14_17.i();
                for (var21_24 = 0; var21_24 < var15_18.length; ++var21_24) {
                    var22_25 = var15_18[var21_24].f();
                    v2 = (byte)var22_25.i() ? 1 : 0;
                    if (var23_5) continue block4;
                    if (v2 == 0) ** GOTO lbl80
                    var19_22 = var7_9[var20_23 != 0 ? var16_19 - 1 : 0];
                    if (!var23_5) ** GOTO lbl90
lbl80: // 2 sources:
                    if (!var22_25.j()) ** GOTO lbl83
                    var19_22 = var7_9[var16_19 / 2];
                    if (!var23_5) ** GOTO lbl90
lbl83: // 2 sources:
                    if (!var22_25.k()) ** GOTO lbl86
                    var19_22 = var7_9[var20_23 != 0 ? 0 : var16_19 - 1];
                    if (!var23_5) ** GOTO lbl90
lbl86: // 2 sources:
                    if (cB.a(var22_25) != 0) ** GOTO lbl-1000
                    var19_22 = var7_9[var16_19 / 2];
                    if (var23_5) lbl-1000: // 2 sources:
                    {
                        var19_22 = var7_9[0];
                    }
lbl90: // 6 sources:
                    this.a(var19_22, var15_18[var21_24], (y.c.A)var8_10);
                    if (!var23_5) continue;
                }
lbl92: // 4 sources:
                var9_12.g();
                if (!var23_5) continue block3;
            }
            break block3;
            break;
        } while (true);
        this.a(var1_1, var3_3, (y.c.A)var8_10);
        return var5_6;
    }

    protected c a(X x2) {
        return x2.c(U.a);
    }

    private void a(y.c.q q2, S s2, y.c.A a2) {
        ArrayList<S> arrayList = (ArrayList<S>)a2.b(q2);
        if (arrayList == null) {
            arrayList = new ArrayList<S>(6);
            a2.a((Object)q2, arrayList);
        }
        arrayList.add(s2);
    }

    /*
     * Exception decompiling
     */
    private void a(X var1_1, aV var2_2, y.c.A var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[DOLOOP]], but top level block is 4[WHILELOOP]
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

    public S[] a(X x2, d d2) {
        c c2 = this.a(x2);
        if (c2 != null) return (S[])c2.b(d2);
        return null;
    }

    private S[] a(y.c.q q2, y.c.A a2) {
        List list = (List)a2.b(q2);
        if (list == null) return null;
        return list.toArray(new S[list.size()]);
    }

    private boolean b(X x2) {
        c c2 = this.a(x2);
        if (c2 != null) return true;
        return false;
    }

    public void a(X x2, aU aU2, aV aV2, aP aP2, List list) {
        Object object;
        boolean bl2 = N.x;
        if (!this.b(x2)) {
            return;
        }
        String string = new StringBuffer().append(this.getClass().getName()).append(".map").toString();
        y.c.A a2 = (y.c.A)x2.c(string);
        x2.d_(string);
        x x3 = x2.o();
        while (x3.f()) {
            block7 : {
                object = x3.e();
                S[] arrs = this.a((y.c.q)object, a2);
                if (arrs != null && arrs.length > 0) {
                    d d2 = aV2.a((y.c.q)object).g();
                    if (d2 == null) {
                        throw new IllegalStateException("realEdge == null: Cannot be!!!");
                    }
                    am am2 = x2.h((y.c.q)object);
                    double d3 = am2.getX();
                    double d4 = am2.getY();
                    for (int i2 = 0; i2 < arrs.length; ++i2) {
                        S s2 = arrs[i2];
                        s2.a(s2.d() + d3, s2.e() + d4);
                        this.d.a((i)x2, s2);
                        if (!bl2) {
                            if (!bl2) continue;
                        }
                        break block7;
                    }
                    double d5 = x2.q((d)object.g()).a;
                    double d6 = x2.k((y.c.q)object);
                    am2.setSize(0.0, 0.0);
                    x2.a(object.f(), t.c);
                    x2.b(object.g(), t.c);
                    am2.setLocation(d5, d6);
                }
                x3.g();
            }
            if (!bl2) continue;
        }
        for (int i3 = 0; i3 < list.size(); ++i3) {
            object = (aQ)list.get(i3);
            object.a();
            if (bl2) return;
            if (!bl2) continue;
        }
        x2.a(a2);
    }

    boolean a(d d2, v v2) {
        m m2 = v2.a(0);
        if (!d2.e()) return true;
        if (!m2.b()) return true;
        if (v2.i() != 3) return true;
        return false;
    }

    public void a(X x2, aU aU2, aV aV2) {
        boolean bl2 = N.x;
        y.c.e e2 = x2.p();
        block0 : do {
            S[] arrs;
            if (!e2.f()) return;
            d d2 = e2.a();
            if (d2.e() && (arrs = this.a(x2, d2)) != null && arrs.length > 0) {
                int n2;
                Object object;
                block12 : {
                    int n3;
                    v v2 = x2.l(d2);
                    int n4 = v2.i();
                    boolean bl3 = this.a(d2, v2);
                    if (n4 >= 3) {
                        block11 : {
                            int n5;
                            for (n2 = 1; n2 < n4 - 1; ++n2) {
                                object = v2.a(n2);
                                n5 = (int)object.b() ? 1 : 0;
                                if (!bl2) {
                                    if (n5 != 0 && bl3) {
                                        this.a((m)object, arrs, true, true, x2);
                                        if (!bl2) break;
                                    }
                                    if (!object.a() || bl3) continue;
                                    this.a((m)object, arrs, true, x2);
                                    if (!bl2) break;
                                    if (!bl2) continue;
                                }
                                break block11;
                            }
                            n5 = n2 = n4 - 2;
                        }
                        while (n2 > 0) {
                            object = v2.a(n2);
                            n3 = (int)object.b() ? 1 : 0;
                            if (!bl2) {
                                if (n3 != 0 && bl3) {
                                    this.a((m)object, arrs, false, false, x2);
                                    if (!bl2) break;
                                }
                                if (object.a() && !bl3) {
                                    this.a((m)object, arrs, false, x2);
                                    if (!bl2) break;
                                }
                                --n2;
                                if (!bl2) continue;
                            }
                            break block12;
                        }
                    }
                    n3 = n2 = 0;
                }
                while (n2 < arrs.length) {
                    object = arrs[n2];
                    this.d.a((i)x2, (S)object);
                    ++n2;
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
            }
            e2.g();
        } while (!bl2);
    }

    private boolean a(v v2, boolean bl2) {
        int n2 = v2.h() - 1;
        if (n2 != 3) {
            if (!bl2) return false;
            if (n2 != 5) return false;
        }
        m m2 = v2.a(0);
        m m3 = v2.a(n2 - 1);
        if (!m2.b()) return false;
        if (!m3.b()) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public void b(X var1_1, aU var2_2, aV var3_3) {
        var16_4 = N.x;
        var4_5 = 0;
        block0 : do {
            if (var4_5 >= var2_2.b()) return;
            var5_6 = var2_2.a(var4_5);
            var6_7 = var5_6.f().k();
            while (var6_7 != null) {
                block12 : {
                    var7_8 = (d)var6_7.c();
                    var8_9 = this.a(var1_1, var7_8);
                    if (var16_4) continue block0;
                    if (var8_9 == null || var8_9.length <= 0) ** GOTO lbl47
                    var9_10 = var1_1.l(var7_8);
                    var13_14 = this.a(var9_10, var12_13 = (var11_12 = (var10_11 = var3_3.a(var7_8).k()).h().d()) != 0);
                    if (!var13_14) ** GOTO lbl-1000
                    this.a(var9_10.a(0), var8_9, true, false, var1_1);
                    if (var16_4) lbl-1000: // 4 sources:
                    {
                        for (var14_15 = 1; var14_15 < var9_10.i(); ++var14_15) {
                            var15_16 = var9_10.a(var14_15);
                            v0 = var15_16.b();
                            if (!var16_4) {
                                if (!v0) continue;
                                this.a((m)var15_16, var8_9, true, true, var1_1);
                                if (!var16_4) break;
                                if (!var16_4) continue;
                            }
                            break;
                        }
                    } else {
                        v0 = var13_14;
                    }
                    if (!v0) ** GOTO lbl-1000
                    this.a(var9_10.a(var9_10.i() - 1), var8_9, false, true, var1_1);
                    if (var16_4) lbl-1000: // 4 sources:
                    {
                        for (var14_15 = var9_10.i() - 2; var14_15 >= 0; --var14_15) {
                            var15_16 = var9_10.a(var14_15);
                            v1 = (int)var15_16.b() ? 1 : 0;
                            if (!var16_4) {
                                if (v1 == 0) continue;
                                this.a((m)var15_16, var8_9, false, false, var1_1);
                                if (!var16_4) break;
                                if (!var16_4) continue;
                            }
                            break;
                        }
                    } else {
                        v1 = var14_15 = 0;
                    }
                    while (var14_15 < var8_9.length) {
                        var15_16 = var8_9[var14_15];
                        this.d.a((i)var1_1, (S)var15_16);
                        ++var14_15;
                        if (!var16_4) {
                            if (!var16_4) continue;
                        }
                        break block12;
                    }
lbl47: // 3 sources:
                    var6_7 = var6_7.a();
                }
                if (!var16_4) continue;
            }
            ++var4_5;
        } while (!var16_4);
    }

    /*
     * Unable to fully structure code
     */
    private void a(m var1_1, S[] var2_2, boolean var3_3, X var4_4) {
        block6 : {
            var29_5 = N.x;
            var5_6 = var1_1.c();
            var6_7 = var1_1.d();
            var7_8 = new S[var2_2.length];
            for (var8_9 = 0; var8_9 < var2_2.length; ++var8_9) {
                var7_8[var8_9] = var2_2[var8_9];
                if (!var29_5) {
                    if (!var29_5) continue;
                }
                break block6;
            }
            this.a(var7_8);
        }
        var8_10 = var1_1.k() > 0.0 ? y.c : y.a;
        var9_11 = var8_10 == y.c && var3_3 != false || var8_10 == y.a && var3_3 == false;
        var10_12 = var5_6.a();
        var14_14 = var12_13 = var9_11 != false ? Math.min(var5_6.b(), var6_7.b()) + 10.0 : Math.max(var5_6.b(), var6_7.b()) - 10.0;
        var16_15 = var12_13;
        var18_16 = -1.0;
        v0 = var20_17 = var3_3 != false ? 0 : var7_8.length - 1;
        do {
            if (!var3_3) ** GOTO lbl25
            v1 = var20_17;
            if (var29_5) ** GOTO lbl26
            if (v1 >= var7_8.length) return;
            ** GOTO lbl27
lbl25: // 1 sources:
            v1 = var20_17;
lbl26: // 2 sources:
            if (v1 < 0) return;
lbl27: // 2 sources:
            var21_18 = var7_8[var20_17];
            var22_19 = var21_18.f();
            if ((double)var22_19.a() != var18_16) {
                var16_15 = var9_11 != false ? Math.max(var14_14, var16_15) : Math.min(var14_14, var16_15);
                var14_14 = var16_15;
                var18_16 = var22_19.a();
            }
            if (var3_3 && var22_19.k() || !var3_3 && !var22_19.k()) ** GOTO lbl50
            var23_20 = var21_18.b();
            var25_21 = var21_18.c();
            if (!var22_19.l() && !var22_19.n()) ** GOTO lbl-1000
            if (!this.a(var22_19, var8_10)) ** GOTO lbl-1000
            var27_22 = var9_11 != false ? var14_14 : var14_14 - var25_21;
            var21_18.a(var10_12 - var23_20 - this.a(var21_18), var27_22);
            var14_14 += (var25_21 + 10.0) * (double)(var9_11 != false ? 1 : -1);
            if (var29_5) lbl-1000: // 2 sources:
            {
                var27_22 = var9_11 != false ? var16_15 : var16_15 - var25_21;
                var21_18.a(var10_12 + this.a(var21_18), var27_22);
                var16_15 += (var25_21 + 10.0) * (double)(var9_11 != false ? 1 : -1);
                ** if (!var29_5) goto lbl50
            }
            ** GOTO lbl50
lbl-1000: // 2 sources:
            {
                var27_22 = var9_11 != false ? Math.max(var14_14, var16_15) : Math.min(var14_14, var16_15) - var25_21;
                var21_18.a(var10_12 - var23_20 * 0.5, var27_22);
                var14_14 = var16_15 = (var27_22 += var9_11 != false ? var25_21 + 10.0 : -10.0);
            }
lbl50: // 4 sources:
            var20_17 += var3_3 != false ? 1 : -1;
        } while (!var29_5);
    }

    private void a(S[] arrs) {
        e.a(arrs, b);
    }

    private void a(List list) {
        e.a(list, b);
    }

    /*
     * Unable to fully structure code
     */
    private void a(m var1_1, S[] var2_2, boolean var3_3, boolean var4_4, X var5_5) {
        block6 : {
            var31_6 = N.x;
            var6_7 = var1_1.c();
            var7_8 = var1_1.d();
            var8_9 = new S[var2_2.length];
            for (var9_10 = 0; var9_10 < var2_2.length; ++var9_10) {
                var8_9[var9_10] = var2_2[var9_10];
                if (!var31_6) {
                    if (!var31_6) continue;
                }
                break block6;
            }
            this.a(var8_9);
        }
        var9_11 = var1_1.j() > 0.0 ? y.b : y.d;
        var10_12 = var9_11 == y.b && var4_4 != false || var9_11 == y.d && var4_4 == false;
        var11_13 = var6_7.b();
        var15_15 = var13_14 = var10_12 != false ? Math.min(var6_7.a(), var7_8.a()) + 10.0 : Math.max(var6_7.a(), var7_8.a()) - 10.0;
        var17_16 = var13_14;
        var19_17 = var3_3 != false && var4_4 != false || var3_3 == false && var4_4 == false;
        var20_18 = -1.0;
        v0 = var22_19 = var19_17 != false ? 0 : var8_9.length - 1;
        do {
            if (!var19_17) ** GOTO lbl26
            v1 = var22_19;
            if (var31_6) ** GOTO lbl27
            if (v1 >= var8_9.length) return;
            ** GOTO lbl28
lbl26: // 1 sources:
            v1 = var22_19;
lbl27: // 2 sources:
            if (v1 < 0) return;
lbl28: // 2 sources:
            var23_20 = var8_9[var22_19];
            var24_21 = var23_20.f();
            if ((double)var24_21.a() != var20_18) {
                var17_16 = var10_12 != false ? Math.max(var15_15, var17_16) : Math.min(var15_15, var17_16);
                var15_15 = var17_16;
                var20_18 = var24_21.a();
            }
            if (var3_3 && var24_21.k() || !var3_3 && !var24_21.k()) ** GOTO lbl51
            var25_22 = var23_20.b();
            var27_23 = var23_20.c();
            if (!var24_21.l() && !var24_21.n()) ** GOTO lbl-1000
            if (!this.a(var24_21, var9_11)) ** GOTO lbl-1000
            var29_24 = var10_12 != false ? var15_15 : var15_15 - var25_22;
            var23_20.a(var29_24, var11_13 - var27_23 - this.a(var23_20));
            var15_15 += (var25_22 + 10.0) * (double)(var10_12 != false ? 1 : -1);
            if (var31_6) lbl-1000: // 2 sources:
            {
                var29_24 = var10_12 != false ? var17_16 : var17_16 - var25_22;
                var23_20.a(var29_24, var11_13 + this.a(var23_20));
                var17_16 += (var25_22 + 10.0) * (double)(var10_12 != false ? 1 : -1);
                ** if (!var31_6) goto lbl51
            }
            ** GOTO lbl51
lbl-1000: // 2 sources:
            {
                var29_24 = var10_12 != false ? Math.max(var15_15, var17_16) : Math.min(var15_15, var17_16) - var25_22;
                var23_20.a(var29_24, var11_13 - var27_23 * 0.5);
                var15_15 = var17_16 = (var29_24 += var10_12 != false ? var25_22 + 10.0 : -10.0);
            }
lbl51: // 4 sources:
            var22_19 += var19_17 != false ? 1 : -1;
        } while (!var31_6);
    }

    private boolean a(aG aG2, y y2) {
        if (aG2.l()) {
            if (y2 == y.a) return true;
            if (y2 == y.b) return true;
        }
        if (!aG2.n()) return false;
        if (y2 == y.c) return true;
        if (y2 != y.d) return false;
        return true;
    }

    public y.d.q a(X x2, d d2, byte by2, double[] arrd, boolean bl2, boolean bl3) {
        return this.a(x2, d2, by2, arrd, bl2, bl3, 0);
    }

    /*
     * Unable to fully structure code
     */
    public y.d.q a(X var1_1, d var2_2, byte var3_3, double[] var4_4, boolean var5_5, boolean var6_6, byte var7_7) {
        block23 : {
            block22 : {
                var25_8 = N.x;
                var10_9 = var5_5 != 0 ? (var6_6 ? y.b : y.d) : (var6_6 != false ? y.c : y.a);
                var11_10 = new double[]{0.0, 0.0};
                var12_11 = new double[]{0.0, 0.0};
                var13_12 = this.a(var1_1, var2_2);
                if (var13_12 == null || var13_12.length <= 0) ** GOTO lbl130
                var14_13 = new ArrayList<Object>();
                for (var15_15 = 0; var15_15 < var13_12.length; ++var15_15) {
                    var16_16 = var13_12[var15_15];
                    var17_18 = var16_16.f();
                    v0 = var7_7;
                    if (!var25_8) {
                        if (v0 != 0 && (var7_7 != 2 || !var17_18.i()) && !var17_18.j() && (var7_7 != 1 || var17_18.i() || var17_18.j())) continue;
                        var14_13.add(var16_16);
                        this.d.a((i)var1_1, var16_16, var10_9);
                        if (!var25_8) continue;
                    }
                    break block22;
                }
                this.a(var14_13);
                v0 = -1;
            }
            var15_15 = v0;
            for (Object var17_18 : var14_13) {
                var18_19 = var17_18.f();
                v1 = var18_19.a();
                if (var25_8) break block23;
                if (v1 != var15_15) {
                    block24 : {
                        if (var5_5 != 0) {
                            var11_10[0] = var11_10[1] = Math.max(var11_10[0], var11_10[1]);
                            if (!var25_8) break block24;
                        }
                        var12_11[0] = var12_11[1] = Math.max(var12_11[0], var12_11[1]);
                    }
                    var15_15 = var18_19.a();
                }
                v2 = var19_20 = var18_19.l() == false && var18_19.n() == false;
                if (var19_20) ** GOTO lbl73
                var20_21 = this.a(var18_19, var10_9);
                var21_24 = var20_21 != false ? 0 : 1;
                v3 = var22_25 = var20_21 != false ? 0 : 1;
                if (var3_3 != 0) ** GOTO lbl56
                if (var11_10[var21_24] <= 0.0) ** GOTO lbl-1000
                v4 = var11_10;
                v5 = var21_24;
                v4[v5] = v4[v5] + 10.0;
                if (var25_8) lbl-1000: // 2 sources:
                {
                    if (var5_5 == 0) {
                        v6 = var11_10;
                        v7 = var21_24;
                        v6[v7] = v6[v7] + this.a((S)var17_18);
                    }
                }
                v8 = var11_10;
                v9 = var21_24;
                v8[v9] = v8[v9] + var17_18.b();
                var23_26 = var17_18.c();
                if (var5_5 != 0) {
                    var23_26 += this.a((S)var17_18);
                }
                var12_11[var22_25] = Math.max(var12_11[var22_25], var23_26);
                if (!var25_8) continue;
lbl56: // 2 sources:
                if (var12_11[var22_25] <= 0.0) ** GOTO lbl-1000
                v10 = var12_11;
                v11 = var22_25;
                v10[v11] = v10[v11] + 10.0;
                if (var25_8) lbl-1000: // 2 sources:
                {
                    if (var5_5 != 0) {
                        v12 = var12_11;
                        v13 = var22_25;
                        v12[v13] = v12[v13] + this.a((S)var17_18);
                    }
                }
                v14 = var12_11;
                v15 = var22_25;
                v14[v15] = v14[v15] + var17_18.c();
                var23_26 = var17_18.b();
                if (var5_5 == 0) {
                    var23_26 += this.a((S)var17_18);
                }
                var11_10[var21_24] = Math.max(var11_10[var21_24], var23_26);
                if (!var25_8) continue;
lbl73: // 2 sources:
                if (var3_3 == 0) {
                    if (var5_5 != 0) {
                        if (var11_10[0] > 0.0) {
                            v16 = var11_10;
                            v16[0] = v16[0] + 10.0;
                        }
                        if (var11_10[1] > 0.0) {
                            v17 = var11_10;
                            v17[1] = v17[1] + 10.0;
                        }
                        v18 = var11_10;
                        v18[0] = v18[0] + var17_18.b();
                        v19 = var11_10;
                        v19[1] = v19[1] + var17_18.b();
                        var12_11[0] = Math.max(var12_11[0], var17_18.c() * 0.5);
                        var12_11[1] = Math.max(var12_11[1], var17_18.c() * 0.5);
                        if (!var25_8) continue;
                    }
                    var20_22 = var17_18.b() * 0.5;
                    if (var11_10[0] > 0.0 || var11_10[1] > 0.0) {
                        var20_22 += 5.0;
                    }
                    v20 = var11_10;
                    v20[0] = v20[0] + var20_22;
                    v21 = var11_10;
                    v21[1] = v21[1] + var20_22;
                    var12_11[0] = Math.max(var12_11[0], var17_18.c());
                    var12_11[1] = Math.max(var12_11[1], var17_18.c());
                    if (!var25_8) continue;
                }
                if (var5_5 != 0) {
                    var11_10[0] = Math.max(var11_10[0], var17_18.b());
                    var11_10[1] = Math.max(var11_10[1], var17_18.b());
                    var20_23 = var17_18.c() * 0.5;
                    if (var12_11[0] > 0.0 || var12_11[1] > 0.0) {
                        var20_23 += 5.0;
                    }
                    v22 = var12_11;
                    v22[0] = v22[0] + var20_23;
                    v23 = var12_11;
                    v23[1] = v23[1] + var20_23;
                    if (!var25_8) continue;
                }
                var11_10[0] = Math.max(var11_10[0], var17_18.b() * 0.5);
                var11_10[1] = Math.max(var11_10[1], var17_18.b() * 0.5);
                if (var12_11[0] > 0.0) {
                    v24 = var12_11;
                    v24[0] = v24[0] + 10.0;
                }
                if (var12_11[1] > 0.0) {
                    v25 = var12_11;
                    v25[1] = v25[1] + 10.0;
                }
                v26 = var12_11;
                v26[0] = v26[0] + var17_18.c();
                v27 = var12_11;
                v27[1] = v27[1] + var17_18.c();
                if (!var25_8) continue;
            }
            v28 = var11_10;
            v28[0] = v28[0] + (var11_10[0] != 0.0 ? 10.0 : 0.0);
            v29 = var11_10;
            v29[1] = v29[1] + (var11_10[1] != 0.0 ? 10.0 : 0.0);
            v30 = var12_11;
            v30[0] = v30[0] + (var12_11[0] != 0.0 ? 10.0 : 0.0);
            v31 = var12_11;
            v31[1] = v31[1] + (var12_11[1] != 0.0 ? 10.0 : 0.0);
lbl130: // 2 sources:
            v1 = var5_5;
        }
        if (v1 != 0) {
            var4_4[0] = var12_11[0];
            var4_4[1] = var12_11[1];
            var16_17 = var12_11[0] + var12_11[1];
            if (var25_8 == false) return new y.d.q(var14_14 += (var14_14 = Math.max(var11_10[0], var11_10[1])) != 0.0 ? 10.0 : 0.0, var16_17);
        }
        var4_4[0] = var11_10[0];
        var4_4[1] = var11_10[1];
        var14_14 = var11_10[0] + var11_10[1];
        var16_17 += (var16_17 = Math.max(var12_11[0], var12_11[1])) != 0.0 ? 10.0 : 0.0;
        return new y.d.q(var14_14 += (var14_14 = Math.max(var11_10[0], var11_10[1])) != 0.0 ? 10.0 : 0.0, var16_17);
    }

    /*
     * Unable to fully structure code
     */
    public double a(X var1_1, aV var2_2, y.c.q var3_3, y.c.q var4_4) {
        var17_5 = N.x;
        var5_6 = 0.0;
        if (var3_3 == null) return var5_6;
        if (var4_4 == null) return var5_6;
        var7_7 = var2_2.a(var3_3);
        if (var7_7.b() == 3 && var7_7.k() > var2_2.a(var7_7.f()).k()) {
            var7_7 = var2_2.a(var7_7.f());
        }
        var8_8 = var7_7.d();
        do {
            if (var8_8 == null) return var5_6;
            var9_9 = (d)var8_8.c();
            var10_10 = var2_2.a(var4_4);
            v0 = var11_11 = var10_10.b() == 3 && var10_10.g() == var9_9 && var10_10.k() < var2_2.a(var10_10.f()).k();
            if (var9_9.d() != var4_4 && (!var11_11 || var9_9.d() != var10_10.f())) ** GOTO lbl-1000
            var12_12 = this.a(var2_2, var9_9);
            var14_13 = this.a(var1_1, var9_9, 0, new double[2], true, true);
            var15_14 = var14_13.a() + 2.0 * var12_12;
            var5_6 = Math.max(var5_6, var15_14);
            if (var17_5) lbl-1000: // 2 sources:
            {
                if (var9_9.c() == var4_4 || var11_11 && var9_9.c() == var10_10.f()) {
                    var12_12 = this.a(var2_2, var9_9);
                    var14_13 = this.a(var1_1, var9_9, 0, new double[2], true, false);
                    var15_14 = var14_13.a() + 2.0 * var12_12;
                    var5_6 = Math.max(var5_6, var15_14);
                }
            }
            var8_8 = var8_8.a();
        } while (!var17_5);
        return var5_6;
    }

    private double a(aV aV2, d d2) {
        B b2 = aV2.a(d2).k();
        byte by2 = b2.h().d();
        if (by2 != 1) return 0.0;
        boolean bl2 = true;
        boolean bl3 = bl2;
        if (!bl3) return 0.0;
        double d3 = b2.i() / Math.sqrt(2.0);
        return d3;
    }

    private double a(S s2) {
        aG aG2 = s2.f();
        if (!aG2.l() && !aG2.n()) {
            return 0.0;
        }
        double d2 = Math.max(0.0, aG2.h());
        return d2;
    }

    private static byte a(aG aG2) {
        byte by2 = aG2.a();
        if (by2 != 7) return by2;
        return 0;
    }
}

