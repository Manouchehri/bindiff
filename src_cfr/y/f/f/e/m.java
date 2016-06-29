/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.c.d;
import y.c.i;
import y.c.q;
import y.f.X;
import y.f.f.b.h;
import y.f.f.b.p;
import y.f.h.D;

public class m
implements p {
    private h c;
    private X d;
    D a;
    private short e = 0;
    private int f = 3;
    public int b;
    private boolean g = false;
    private y.f.f.b.m h;

    @Override
    public void a(h h2) {
        this.c = h2;
        this.d = (X)this.c.a();
    }

    @Override
    public void a(int n2) {
        this.b = n2;
    }

    @Override
    public void a(y.f.f.b.m m2) {
        this.h = m2;
    }

    public void a(short s2) {
        this.e = s2;
    }

    public void b(int n2) {
        this.f = n2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void a() {
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

    d a(d d2) {
        d d3;
        d d4 = d2.g();
        if (d4 == null) {
            d3 = d2.c().f();
            return d3;
        }
        d3 = d4;
        return d3;
    }

    d b(d d2) {
        d d3;
        d d4 = d2.i();
        if (d4 == null) {
            d3 = d2.c().h();
            return d3;
        }
        d3 = d4;
        return d3;
    }

    d c(d d2) {
        return this.a.h(d2);
    }
}

