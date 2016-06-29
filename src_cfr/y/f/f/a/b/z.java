/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.a.b;

import y.c.d;
import y.c.e;
import y.c.f;
import y.c.h;
import y.c.i;
import y.c.q;
import y.f.f.a.a.b;
import y.f.f.a.a.n;
import y.f.f.a.a.p;
import y.f.f.a.b.a;

public class z {
    /*
     * Unable to fully structure code
     */
    public static void a(a var0, h var1_1, h var2_2) {
        var14_3 = a.c;
        var3_4 = var0.d();
        var4_5 = var0.b();
        var6_6 = var3_4.n();
        var7_7 = 0;
        do {
            if (var7_7 >= var6_6.length) return;
            var5_8 = false;
            var8_9 = var6_6[var7_7];
            var9_10 = var8_9.c();
            var10_11 = var8_9.d();
            var11_12 = var4_5.a(var9_10);
            var12_13 = var4_5.a(var10_11);
            if (!var11_12.d()) {
                var13_14 = (b)n.a(var11_12);
                var9_10 = var13_14.b_();
                var5_8 = true;
            }
            if (var12_13.d()) ** GOTO lbl-1000
            var13_14 = (b)n.a(var12_13);
            var10_11 = var13_14.b_();
            var5_8 = true;
            if (var5_8) lbl-1000: // 2 sources:
            {
                var13_14 = var3_4.a(var9_10, var10_11);
                var0.q((d)var13_14);
                var0.d(var8_9, (d)var13_14);
                if (var1_1 != null) {
                    var1_1.a(var13_14, var1_1.b(var8_9));
                }
                if (var2_2 != null) {
                    var2_2.a(var13_14, var2_2.b(var8_9));
                }
                var3_4.d(var8_9);
            }
            ++var7_7;
        } while (!var14_3);
    }

    /*
     * Exception decompiling
     */
    public static void a(a var0, f var1_1) {
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
    private static void a(a var0, f var1_1, q var2_2, q var3_3) {
        var5_4 = a.c;
        var4_5 = var1_1.a();
        while (var4_5.f()) {
            v0 = var4_5.a().c();
            v1 = var2_2;
            if (!var5_4) {
                if (v0 == v1) break;
                var0.o(var4_5.a());
                var4_5.g();
                if (!var5_4) continue;
            }
            ** GOTO lbl17
        }
        while (var4_5.f()) {
            v2 = var4_5;
            if (!var5_4) {
                v0 = v2.a().c();
                v1 = var3_3;
lbl17: // 2 sources:
                if (v0 == v1) break;
                var4_5.g();
                if (!var5_4) continue;
            }
            ** GOTO lbl23
        }
        do {
            v2 = var4_5;
lbl23: // 2 sources:
            if (v2.f() == false) return;
            var0.o(var4_5.a());
            var4_5.g();
        } while (!var5_4);
    }
}

