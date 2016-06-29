/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.f.f.b.h;
import y.f.h.p;

public class l {
    h a;
    i b;

    /*
     * Exception decompiling
     */
    public void a(h var1_1, c var2_2) {
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
    private final void a(c var1_1, d[] var2_2, int var3_3, int var4_4, p var5_5, p var6_6) {
        block19 : {
            block18 : {
                var15_7 = h.a;
                if (var3_3 <= 1) {
                    return;
                }
                var7_8 = var2_2[0];
                v0 = var8_10 = var7_8.i() == null ? var7_8.c().h() : var7_8.i();
                if (this.a.b(var8_10) != var6_6 && var7_8.c().a() == 6) {
                    v1 = var8_11 = var8_10.i() == null ? var8_10.c().h() : var8_10.i();
                }
                if (this.a.b((d)var8_12) != var6_6) ** GOTO lbl27
                while (var4_4 < 0) {
                    v2 = this.a.d(var7_8);
                    v3 = 1;
                    if (var15_7 == 0) {
                        if (v2 <= v3 || this.a.d((d)var8_12) >= 3) break;
                        ++var4_4;
                        this.a.a(var7_8, this.a.d(var7_8) - 1);
                        this.a.a((d)var8_12, this.a.d((d)var8_12) + 1);
                        if (var15_7 == 0) continue;
                    }
                    ** GOTO lbl22
                }
                while (var4_4 > 0) {
                    v2 = this.a.d((d)var8_12);
                    v3 = 1;
lbl22: // 2 sources:
                    if (v2 <= v3 || this.a.d(var7_8) >= 3) break;
                    --var4_4;
                    this.a.a(var7_8, this.a.d(var7_8) + 1);
                    this.a.a((d)var8_12, this.a.d((d)var8_12) - 1);
                    if (var15_7 == 0) continue;
                }
lbl27: // 4 sources:
                var7_8 = var2_2[var3_3 - 1];
                var8_13 = var7_8.d();
                var9_16 = this.a.a(var7_8);
                var10_17 = var8_13.f();
                while (this.a.b(var10_17) != var5_5) {
                    var10_17 = var10_17.g();
                    if (var15_7 == 0) {
                        if (var15_7 == 0) continue;
                    }
                    break block18;
                }
                if (var10_17 == var7_8 || this.a.b(var9_16) != var6_6) ** GOTO lbl57
                while (var4_4 < 0) {
                    v4 = this.a.d(var10_17);
                    v5 = 1;
                    if (var15_7 == 0) {
                        if (v4 <= v5 || this.a.d(var9_16) >= 3) break;
                        ++var4_4;
                        this.a.a(var10_17, this.a.d(var10_17) - 1);
                        this.a.a(var9_16, this.a.d(var9_16) + 1);
                        if (var15_7 == 0) continue;
                    }
                    ** GOTO lbl51
                }
                while (var4_4 > 0) {
                    v4 = this.a.d(var9_16);
                    if (var15_7 == 0) {
                        v5 = 1;
lbl51: // 2 sources:
                        if (v4 <= v5 || this.a.d(var10_17) >= 3) break;
                        --var4_4;
                        this.a.a(var10_17, this.a.d(var10_17) + 1);
                        this.a.a(var9_16, this.a.d(var9_16) - 1);
                        if (var15_7 == 0) continue;
                    }
                    break block19;
                }
            }
            v4 = var7_9 = 1;
        }
        while (var7_9 < var3_3) {
            var8_15 = var2_2[var7_9].c();
            var9_16 = var2_2[var7_9];
            if (var15_7 != 0) return;
            v6 = var10_17 = var9_16.i() == null ? var8_15.h() : var9_16.i();
            if (this.a.b(var10_17) != var6_6) {
                throw new IllegalStateException("Wrong face!");
            }
            var11_18 = this.a.d(var9_16);
            if (var4_4 >= 0) ** GOTO lbl72
            ++var4_4;
            var12_19 = 1;
            if (var15_7 == 0) ** GOTO lbl81
lbl72: // 2 sources:
            if (var4_4 <= 0) ** GOTO lbl-1000
            if (var8_15.a() != 4) ** GOTO lbl-1000
            --var4_4;
            var12_19 = 3;
            if (var15_7 != 0) lbl-1000: // 2 sources:
            {
                var12_19 = 2;
                ** if (var15_7 == 0) goto lbl81
            }
            ** GOTO lbl81
lbl-1000: // 2 sources:
            {
                var12_19 = 2;
            }
lbl81: // 4 sources:
            if ((var13_20 = var12_19 - var11_18) == 0) ** GOTO lbl98
            var14_21 = this.a.d(var10_17);
            if (var14_21 - var13_20 < 1 || var14_21 - var13_20 >= 4) ** GOTO lbl-1000
            this.a.a(var10_17, var14_21 - var13_20);
            this.a.a(var9_16, var11_18 + var13_20);
            if (var15_7 != 0) lbl-1000: // 2 sources:
            {
                if (var8_15.a() != 6) throw new IllegalStateException("Incompatible degree!");
                v7 = var10_17 = var10_17.i() == null ? var8_15.h() : var10_17.i();
                if (this.a.b(var10_17) != var6_6) {
                    throw new IllegalStateException("Wrong face!");
                }
                var14_21 = this.a.d(var10_17);
                if (var14_21 - var13_20 < 1) throw new IllegalStateException("Could not assign new angle!");
                if (var14_21 - var13_20 >= 4) throw new IllegalStateException("Could not assign new angle!");
                this.a.a(var10_17, var14_21 - var13_20);
                this.a.a(var9_16, var11_18 + var13_20);
                if (var15_7 != 0) {
                    throw new IllegalStateException("Could not assign new angle!");
                }
            }
lbl98: // 5 sources:
            ++var7_9;
            if (var15_7 == 0) continue;
        }
        if (var4_4 == 0) return;
        throw new IllegalStateException("Could not compensate directions changes.");
    }
}

