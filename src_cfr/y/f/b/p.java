/*
 * Decompiled with CFR 0_115.
 */
package y.f.b;

import java.util.ArrayList;
import java.util.Collection;
import y.c.d;
import y.c.i;
import y.d.t;
import y.f.I;
import y.f.X;
import y.f.aE;
import y.f.ax;
import y.f.b.c;

final class p {
    public static Collection a(i i2, d d2, boolean bl2) {
        Object object = bl2 ? ax.a : ax.b;
        y.c.c c2 = i2.c(object);
        ArrayList arrayList = null;
        if (c2 == null) return arrayList;
        arrayList = (ArrayList)c2.b(d2);
        if (arrayList == null) return arrayList;
        return new ArrayList(arrayList);
    }

    /*
     * Exception decompiling
     */
    public static void a(X var0, d var1_1, Collection var2_2, Collection var3_3) {
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

    private static int a(boolean[] arrbl) {
        int n2 = 0;
        if (arrbl[0]) {
            n2 |= true;
        }
        if (arrbl[1]) {
            n2 |= 4;
        }
        if (arrbl[2]) {
            n2 |= 2;
        }
        if (!arrbl[3]) return n2;
        n2 |= 8;
        return n2;
    }

    private static boolean[] a(int n2) {
        boolean[] arrbl = new boolean[4];
        if ((n2 & 1) != 0) {
            arrbl[0] = true;
        }
        if ((n2 & 4) != 0) {
            arrbl[1] = true;
        }
        if ((n2 & 2) != 0) {
            arrbl[2] = true;
        }
        if ((n2 & 8) == 0) return arrbl;
        arrbl[3] = true;
        return arrbl;
    }

    private static int b(boolean[] arrbl) {
        int n2;
        int n3 = c.a;
        int n4 = 0;
        for (int i2 = 0; i2 < arrbl.length; ++i2) {
            n2 = arrbl[i2];
            if (n3 != 0) return n2;
            if (n2 == 0) continue;
            ++n4;
            if (n3 == 0) continue;
        }
        n2 = n4;
        return n2;
    }

    private static boolean a(ax ax2, ax ax3) {
        if (ax2.a(1)) {
            if (ax3.a(1)) return true;
        }
        if (ax2.a(2)) {
            if (ax3.a(2)) return true;
        }
        if (ax2.a(4)) {
            if (ax3.a(4)) return true;
        }
        if (!ax2.a(8)) return false;
        if (!ax3.a(8)) return false;
        return true;
    }

    private static ax a(ax ax2, int n2) {
        if (!ax2.b()) return ax.a(n2, ax2.f());
        return ax.a(ax2.c(), ax2.d(), n2, ax2.f());
    }

    /*
     * Unable to fully structure code
     */
    public static Collection a(X var0, d var1_1, Collection var2_2, boolean var3_3) {
        if (!var3_3) ** GOTO lbl-1000
        var4_4 = aE.d(var0, var1_1);
        var5_5 = var0.b(var1_1).getSourcePoint();
        if (c.a != 0) lbl-1000: // 2 sources:
        {
            var4_4 = aE.e(var0, var1_1);
            var5_5 = var0.b(var1_1).getTargetPoint();
        }
        if (var4_4 == null) return var2_2;
        var6_6 = ax.a(var4_4);
        if (var4_4.a()) {
            var5_5 = var3_3 != false ? var0.b(var1_1).getSourcePoint() : var0.b(var1_1).getTargetPoint();
            var6_6 = ax.a(var5_5.a, var5_5.b, var6_6.a());
        }
        if (var2_2 == null) {
            var2_2 = new ArrayList<E>(1);
        }
        var2_2.add(var6_6);
        return var2_2;
    }
}

