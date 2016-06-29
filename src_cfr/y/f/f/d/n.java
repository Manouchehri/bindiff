/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import java.util.ArrayList;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.q;
import y.f.f.d.O;
import y.f.f.d.a;
import y.f.f.d.o;
import y.f.f.d.v;
import y.g.a.g;

public class N
implements v {
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private a[] g;
    private int h;
    private int i;
    private O j = new O();
    private g k;
    private A l;
    private ArrayList m;
    private ArrayList n;
    private d[] o;
    private d[] p;
    private d[][] q;
    private d[][] r;

    /*
     * Exception decompiling
     */
    @Override
    public int a(i var1_1, q var2_2, q var3_3, h var4_4, h var5_5, int var6_6, ArrayList var7_7, ArrayList var8_8, h var9_9, h var10_10) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [5[DOLOOP]], but top level block is 7[WHILELOOP]
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
    private void a(q var1_1, q var2_2, int[] var3_3, int[] var4_4, int[] var5_5, Object[] var6_6) {
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

    /*
     * Unable to fully structure code
     */
    public void a() {
        var14_1 = o.p;
        var1_2 = 0;
        do {
            if (var1_2 >= this.n.size()) return;
            v0 = this.n.get(var1_2);
            block1 : while ((var2_3 = (ArrayList)v0).size() != 0) {
                block16 : {
                    var3_4 = (a)var2_3.get(0);
                    var4_5 = var3_4.b().a();
                    var5_6 = null;
                    var6_7 = null;
                    var7_8 = 0;
                    block2 : do {
                        if (this.f[var4_5.b()] > 0) {
                            var6_7 = var4_5;
                        }
                        v1 = var6_7;
                        do {
                            if (v1 != null && this.f[this.a(var4_5).b()] > 0) {
                                var5_6 = this.a(var4_5);
                            }
                            var4_5 = this.o[var4_5.b()];
                            if (var5_6 == null && ++var7_8 < var2_3.size() + 3) continue block2;
                            v1 = var5_6;
                        } while (var14_1);
                        break;
                    } while (true);
                    if (v1 == null) break;
                    var8_9 = 0;
                    this.q[0][0] = var5_6;
                    this.r[0][0] = var5_6;
                    var11_12 = 0;
                    var4_5 = this.p[var5_6.b()];
                    while (var4_5 != var5_6) {
                        v2 = var11_12;
                        if (var14_1) break block16;
                        if (v2 != 0) ** GOTO lbl-1000
                        var9_10 = var4_5;
                        var10_11 = this.a(var4_5);
                        if (var14_1) lbl-1000: // 2 sources:
                        {
                            var10_11 = var4_5;
                            var9_10 = this.a(var4_5);
                        }
                        if (this.f[var9_10.b()] > 0) {
                            this.r[var11_12][var8_9] = var9_10;
                        }
                        if (this.f[var10_11.b()] > 0) {
                            if ((var8_9 += var11_12) > 3) {
                                throw new RuntimeException("Too many intervals !!!!");
                            }
                            var11_12 = 1 - var11_12;
                            this.q[var11_12][var8_9] = var10_11;
                            this.r[var11_12][var8_9] = var10_11;
                        }
                        var4_5 = this.p[var4_5.b()];
                        if (!var14_1) continue;
                    }
                    v2 = var8_9;
                }
                if (v2 != 3) break;
                var12_13 = 0;
                while (var12_13 < 4) {
                    block18 : {
                        block17 : {
                            v0 = this.q[0][var12_13];
                            if (var14_1) continue block1;
                            var13_14 = v0;
                            while (var13_14 != this.r[0][var12_13]) {
                                this.c[this.a((d)var13_14).b()] = 10000;
                                var13_14 = this.p[var13_14.b()];
                                if (!var14_1) {
                                    if (!var14_1) continue;
                                }
                                break block17;
                            }
                            var13_14 = this.r[1][var12_13];
                        }
                        while (var13_14 != this.q[1][var12_13]) {
                            this.c[this.a((d)var13_14).b()] = 10000;
                            var13_14 = this.o[var13_14.b()];
                            if (!var14_1) {
                                if (!var14_1) continue;
                            }
                            break block18;
                        }
                        ++var12_13;
                    }
                    if (!var14_1) continue;
                }
                break block1;
            }
            ++var1_2;
        } while (!var14_1);
    }

    private d a(d d2) {
        d[] arrd = this.g[d2.b()].c();
        if (arrd[0] == d2) return arrd[1];
        return arrd[0];
    }
}

