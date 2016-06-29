/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import java.util.ArrayList;
import y.c.B;
import y.c.C;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.x;
import y.f.f.d.I;
import y.f.f.d.N;
import y.f.f.d.a;
import y.f.f.d.o;
import y.f.f.d.r;
import y.f.f.d.u;
import y.f.f.d.v;

public class q
implements v {
    protected a[] a;
    private i h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int[] l;
    private int[] m;
    private int n;
    private int o;
    private I p;
    private ArrayList q;
    private d[] r;
    private d[] s;
    private int[] t;
    Object[] b;
    int c;
    y.c.q d;
    y.c.q e;
    h f;
    u[] g;

    @Override
    public int a(i i2, y.c.q q2, y.c.q q3, h h2, h h3, int n2, ArrayList arrayList, ArrayList arrayList2, h h4, h h5) {
        try {
            return this.b(i2, q2, q3, h2, h3, n2, arrayList, arrayList2, h4, h5);
        }
        catch (r var11_11) {
            N n3 = new N();
            return n3.a(i2, q2, q3, h2, h3, n2, arrayList, arrayList2, h4, h5);
        }
    }

    /*
     * Unable to fully structure code
     */
    protected int b(i var1_1, y.c.q var2_2, y.c.q var3_3, h var4_4, h var5_5, int var6_6, ArrayList var7_7, ArrayList var8_8, h var9_9, h var10_10) {
        block26 : {
            block25 : {
                var24_11 = o.p;
                this.c = var6_6;
                this.d = var2_2;
                this.e = var3_3;
                this.n = var1_1.h();
                this.o = var1_1.f();
                this.h = var1_1;
                this.i = new int[this.n];
                this.j = new int[this.n];
                this.k = new int[this.o];
                this.l = new int[this.o];
                this.m = new int[this.n];
                this.b = new Object[this.o];
                this.t = new int[this.n];
                this.r = new d[this.n];
                this.s = new d[this.n];
                this.f = var4_4;
                this.a = new a[this.n];
                this.q = new ArrayList<E>(var1_1.f());
                this.p = new I(this.o);
                var11_12 = 0;
                block0 : do {
                    v0 = var11_12;
                    block1 : while (v0 < var7_7.size()) {
                        var12_15 = (a)var7_7.get(var11_12);
                        v1 /* !! */  = var12_15.b();
                        if (var24_11) break block25;
                        var13_17 = v1 /* !! */ ;
                        while (var13_17.f()) {
                            var14_20 = var13_17.a();
                            var15_23 = var14_20.b();
                            this.a[var14_20.b()] = var12_15;
                            this.i[var15_23] = var12_15.a();
                            v0 = this.i[var15_23];
                            if (var24_11) continue block1;
                            if (v0 < 0) {
                                throw new B("found negative capacity");
                            }
                            var13_17.g();
                            if (!var24_11) continue;
                        }
                        ++var11_12;
                        if (!var24_11) continue block0;
                    }
                    break block0;
                    break;
                } while (true);
                v1 /* !! */  = var11_13 = this.h.p();
            }
            while (var11_13.f()) {
                var12_15 = var11_13.a();
                this.r[var12_15.b()] = (d)var10_10.b(var12_15);
                this.s[var12_15.b()] = (d)var9_9.b(var12_15);
                var11_13.g();
                if (!var24_11) {
                    if (!var24_11) continue;
                }
                break block26;
            }
            this.g = new u[this.o];
        }
        var11_13 = var1_1.o();
        while (var11_13.f()) {
            var12_15 = var11_13.e();
            v2 = this;
            if (!var24_11) {
                v2.g[var12_15.d()] = new u((y.c.q)var12_15, var12_15.d());
                var11_13.g();
                if (!var24_11) continue;
            }
            ** GOTO lbl65
        }
        block5 : do {
            v2 = this;
lbl65: // 2 sources:
            var11_14 = var13_18 = v2.a();
            var12_16 = 0;
            var14_21 = 0;
            block6 : do {
                v3 = var14_21;
                v4 = var8_8.size();
                block7 : while (v3 < v4) {
                    v5 = var8_8.get(var14_21);
                    do {
                        var15_24 = (ArrayList)v5;
                        var16_26 = false;
                        var17_27 = 0;
                        var18_28 = 0;
                        v6 = 0;
                        if (!var24_11) {
                            for (var19_29 = v1574606; var19_29 < var15_24.size(); ++var19_29) {
                                block28 : {
                                    block27 : {
                                        var20_30 = (a)var15_24.get(var19_29);
                                        v3 = this.m[var20_30.b[0].b()];
                                        v4 = 1;
                                        if (var24_11) continue block7;
                                        if (v3 != v4 || this.m[var20_30.b[1].b()] != 1) continue;
                                        ++var12_16;
                                        var21_31 = this.s[var20_30.b[0].b()];
                                        var22_32 = 0;
                                        while (this.m[var21_31.b()] == 1) {
                                            var22_32 += var4_4.a(this.a[var21_31.b()].b(var21_31));
                                            var21_31 = this.s[var21_31.b()];
                                            if (!var24_11) {
                                                if (!var24_11) continue;
                                            }
                                            break block27;
                                        }
                                        var22_32 += var4_4.a(this.a[var21_31.b()].b(var21_31));
                                    }
                                    var23_33 = 0;
                                    var21_31 = this.s[var20_30.b[1].b()];
                                    while (this.m[var21_31.b()] == 1) {
                                        var23_33 += var4_4.a(this.a[var21_31.b()].b(var21_31));
                                        var21_31 = this.s[var21_31.b()];
                                        if (!var24_11) {
                                            if (!var24_11) continue;
                                        }
                                        break block28;
                                    }
                                    var23_33 += var4_4.a(this.a[var21_31.b()].b(var21_31));
                                }
                                if (var23_33 > 400 || var22_32 > 400) {
                                    block29 : {
                                        if (var23_33 < var22_32) {
                                            this.a(var20_30);
                                            if (!var24_11) break block29;
                                        }
                                        this.b(var20_30);
                                    }
                                    var16_26 = true;
                                }
                                var18_28 += var23_33;
                                var17_27 += var22_32;
                                if (!var24_11) continue;
                            }
                            if (!var16_26) {
                                for (var19_29 = 0; var19_29 < var15_24.size(); ++var19_29) {
                                    var20_30 = (a)var15_24.get(var19_29);
                                    v3 = this.m[var20_30.b[0].b()];
                                    v4 = 1;
                                    if (var24_11) continue block7;
                                    if (v3 != v4 || this.m[var20_30.b[1].b()] != 1) continue;
                                    if (var18_28 < var17_27) {
                                        this.a(var20_30);
                                        if (!var24_11) continue;
                                    }
                                    this.b(var20_30);
                                    if (!var24_11) continue;
                                }
                            }
                            ++var14_21;
                            if (!var24_11) continue block6;
                        }
                        ** GOTO lbl133
                        v6 = var12_16;
lbl133: // 2 sources:
                        if (v6 > 0) continue block5;
                        v5 = this.h.p();
                    } while (var24_11);
                }
                break;
            } while (true);
            break;
        } while (true);
        var13_19 = v5;
        while (var13_19.f()) {
            var14_22 = var13_19.a();
            v7 = var14_22.b();
            if (var24_11 != false) return v7;
            var15_25 = v7;
            var5_5.a((Object)var14_22, this.m[var15_25]);
            var13_19.g();
            if (!var24_11) continue;
        }
        v7 = var11_14;
        return v7;
    }

    protected void a(a a2) {
        boolean bl2;
        d d2;
        block3 : {
            bl2 = o.p;
            d2 = a2.b[0];
            while (this.m[d2.b()] == 1) {
                this.i[this.a[d2.b()].b((d)d2).b()] = 0;
                d2 = this.s[d2.b()];
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            d2 = this.r[a2.b[0].b()];
        }
        do {
            if (this.m[this.a[d2.b()].b(d2).b()] != 1) return;
            this.i[this.a[d2.b()].b((d)d2).b()] = 0;
            d2 = this.r[d2.b()];
        } while (!bl2);
    }

    protected void b(a a2) {
        boolean bl2;
        d d2;
        block3 : {
            bl2 = o.p;
            d2 = a2.b[1];
            while (this.m[d2.b()] == 1) {
                this.i[this.a[d2.b()].b((d)d2).b()] = 0;
                d2 = this.s[d2.b()];
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            d2 = this.r[a2.b[1].b()];
        }
        do {
            if (this.m[this.a[d2.b()].b(d2).b()] != 1) return;
            this.i[this.a[d2.b()].b((d)d2).b()] = 0;
            d2 = this.r[d2.b()];
        } while (!bl2);
    }

    /*
     * Exception decompiling
     */
    protected int a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[DOLOOP]], but top level block is 5[WHILELOOP]
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
     * Exception decompiling
     */
    private void a(y.c.q var1_1, y.c.q var2_2, int[] var3_3, int[] var4_4, int[] var5_5, Object[] var6_6) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[FORLOOP]], but top level block is 11[SIMPLE_IF_TAKEN]
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
}

