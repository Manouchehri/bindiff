/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.Collection;
import y.c.c;
import y.c.d;
import y.c.q;
import y.f.X;
import y.f.aE;
import y.f.c.a.A;
import y.f.c.a.aP;
import y.f.c.a.aU;
import y.f.c.a.aV;

class bQ {
    private static final Object a = "AutoEdgeGroupConstraintHandler.TEST_SOURCE_GROUP_ID";
    private static final Object b = "AutoEdgeGroupConstraintHandler.TEST_TARGET_GROUP_ID";

    private static boolean a(d d2, aV aV2, boolean bl2, c c2) {
        if (bl2) {
            if (c2 != null && c2.b(d2.c()) != null) {
                return false;
            }
            A a2 = aV2.a(d2);
            if (a2 == null) return true;
            if (a2.c() != null && !a2.c().g()) {
                return false;
            }
            if (a2.d() == null) return true;
            if (a2.d().isEmpty()) return true;
            return false;
        }
        if (c2 != null && c2.b(d2.d()) != null) {
            return false;
        }
        A a3 = aV2.a(d2);
        if (a3 == null) return true;
        if (a3.e() != null && !a3.e().g()) {
            return false;
        }
        if (a3.f() == null) return true;
        if (a3.f().isEmpty()) return true;
        return false;
    }

    /*
     * Exception decompiling
     */
    static void a(X var0, aU var1_1, aV var2_2, aP var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[WHILELOOP]], but top level block is 11[WHILELOOP]
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

    private static boolean a(d d2, y.c.A a2) {
        if (a2.a(d2.c()) <= a2.a(d2.d())) return false;
        return true;
    }
}

