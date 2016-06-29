/*
 * Decompiled with CFR 0_115.
 */
package y.d.a;

import java.util.Collection;
import java.util.Iterator;
import y.c.A;
import y.c.D;
import y.c.h;
import y.d.a.b;
import y.d.a.k;
import y.d.a.l;
import y.d.b.o;
import y.f.h.N;

public class a {
    private l a;
    private y.d.b.l b;

    public a() {
        this.a = null;
        this.b = new o();
    }

    public a(y.d.b.l l2) {
        this.a(l2);
    }

    public void a(y.d.b.l l2) {
        this.a = null;
        this.b = l2;
    }

    protected Object a(Object object) {
        if (this.a != null) return this.a.a(object);
        return object;
    }

    protected Object b(Object object) {
        if (this.a != null) return this.a.c(object);
        return object;
    }

    protected Collection a(Collection collection) {
        D d2;
        int n2 = b.b;
        if (this.a == null) {
            return collection;
        }
        D d3 = new D();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            d2 = d3;
            if (n2 != 0) return d2;
            d2.add(this.a.b(iterator.next()));
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    public void a(Collection collection, N n2, A a2, h h2) {
        this.a(collection, n2, a2, h2, null, false);
    }

    /*
     * Exception decompiling
     */
    public void a(Collection var1_1, Object var2_2, A var3_3, h var4_4, k var5_5, boolean var6_6) {
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

