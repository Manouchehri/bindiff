/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.D;
import y.c.d;
import y.c.e;
import y.d.m;
import y.d.t;
import y.d.v;
import y.f.X;
import y.f.a;
import y.f.ah;
import y.f.i.a.ab;

class aH
extends a {
    public static final Object a = "y.layout.router.polyline.SelfCrossingRemovalStage.LAYOUT_DESCRIPTOR_DPKEY";
    private final boolean b;

    aH(boolean bl2) {
        this.b = bl2;
    }

    @Override
    public void c(X x2) {
        int n2 = ab.a;
        if (this.a() != null) {
            this.a().c(x2);
        }
        e e2 = x2.p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            while (this.b(d2, x2)) {
            }
            if (this.b) {
                this.a(d2, x2);
            }
            e2.g();
        } while (n2 == 0);
    }

    private void a(d d2, X x2) {
        int n2 = ab.a;
        t[] arrt = x2.l(d2).f();
        int n3 = 0;
        do {
            m m2;
            m m3;
            if (n3 > arrt.length - 4) return;
            m m4 = new m(arrt[n3], arrt[n3 + 1]);
            m m5 = new m(arrt[n3 + 2], arrt[n3 + 3]);
            m m6 = m4.a() ? m4 : (m2 = m5.a() ? m5 : null);
            m m7 = m4.b() ? m4 : (m3 = m5.b() ? m5 : null);
            if (m2 != null && m3 != null) {
                double d3 = Math.min(m2.c().b, m2.d().b);
                double d4 = Math.max(m2.c().b, m2.d().b);
                double d5 = m2.c().a;
                double d6 = Math.min(m3.c().a, m3.d().a);
                double d7 = Math.max(m3.c().a, m3.d().a);
                double d8 = m3.c().b;
                if (d3 < d8 && d4 > d8 || d6 < d5 && d7 > d5) {
                    D d9 = new D();
                    for (int i2 = 0; i2 <= n3; ++i2) {
                        d9.add(arrt[i2]);
                        if (n2 == 0) continue;
                    }
                    t t2 = new t(d5, d8);
                    d9.add(t2);
                    for (int i3 = n3 + 3; i3 < arrt.length; ++i3) {
                        d9.add(arrt[i3]);
                        if (n2 != 0) return;
                        if (n2 == 0) continue;
                    }
                    x2.a(d2, d9);
                    return;
                }
            }
            ++n3;
        } while (n2 == 0);
    }

    /*
     * Exception decompiling
     */
    private boolean b(d var1_1, X var2_2) {
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
}

