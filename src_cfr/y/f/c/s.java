/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import y.c.A;
import y.c.c;
import y.c.p;
import y.c.q;
import y.c.y;
import y.f.X;
import y.f.c.a;
import y.f.c.v;
import y.g.am;

public class S
implements v {
    protected v a;
    protected A b;
    private y c;
    private A d;
    private A e;

    public S(v v2) {
        this.a = v2;
    }

    @Override
    public void a(X x2, y[] arry, c c2) {
        if (!(c2 instanceof A)) throw new IllegalStateException("Expected NodeMap layerID!");
        this.e = (A)c2;
        if (a.i) {
            throw new IllegalStateException("Expected NodeMap layerID!");
        }
        this.d = x2.t();
        this.c = new y();
        this.a(x2, arry, this.e);
        this.a.a(x2, arry, this.e);
        this.b(x2, arry, this.e);
        if (this.e != c2) {
            throw new IllegalStateException("Expected NodeMap layerID!");
        }
        x2.a(this.d);
        this.d = null;
        this.c = null;
        this.b = null;
    }

    @Override
    public void a(A a2) {
        this.b = a2;
        this.a.a(a2);
    }

    @Override
    public void a(double d2) {
        this.a.a(d2);
    }

    @Override
    public void d(double d2) {
        this.a.d(d2);
    }

    @Override
    public void b(double d2) {
        this.a.b(d2);
    }

    @Override
    public void c(double d2) {
        this.a.c(d2);
    }

    /*
     * Exception decompiling
     */
    protected void a(X var1_1, y[] var2_2, A var3_3) {
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

    protected void b(X x2, y[] arry, A a2) {
        boolean bl2 = a.i;
        p p2 = this.c.k();
        do {
            if (p2 == null) return;
            am am2 = (am)p2.c();
            q q2 = (q)am2.a;
            y y2 = (y)am2.b;
            y2.h((p)this.d.b(q2));
            x2.a(q2);
            p2 = p2.a();
        } while (!bl2);
    }
}

