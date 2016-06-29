/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.h.a.v;
import y.h.bu;
import y.h.cA;
import y.h.ch;
import y.h.cm;
import y.h.fj;
import y.h.gd;

public class cH
extends cA {
    private boolean b = false;

    public cH() {
        this(null);
    }

    public cH(ch ch2) {
        super(cm.w.toString(), ch2);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ch ch2 = this.a(actionEvent);
        if (ch2 == null) return;
        this.a(ch2);
        ch2.getGraph2D().T();
    }

    public void a(ch ch2) {
        y y2;
        bu bu2;
        cH cH2;
        Object object;
        block3 : {
            boolean bl2 = fj.z;
            bu2 = ch2.getGraph2D();
            v v2 = this.a(bu2);
            if (v2 == null) return;
            y2 = new y();
            object = bu2.o();
            while (object.f()) {
                q q2 = object.e();
                cH2 = this;
                if (!bl2) {
                    if (cH2.a(bu2, q2)) {
                        y2.add(q2);
                    }
                    object.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            cH2 = this;
        }
        object = cH2.a(y2, ch2);
        if (!this.b()) return;
        if (object == null) return;
        bu2.a((q)object, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected q a(y y2, ch ch2) {
        bu bu2 = ch2.getGraph2D();
        bu2.r();
        try {
            q q2 = null;
            if (y2.isEmpty()) {
                if (this.c()) {
                    q2 = this.b(ch2);
                }
            } else {
                q2 = this.b(y2, ch2);
            }
            q q3 = q2;
            return q3;
        }
        finally {
            bu2.s();
        }
    }

    protected q b(ch ch2) {
        bu bu2 = ch2.getGraph2D();
        v v2 = this.a(bu2);
        q q2 = v2.b(bu2);
        double d2 = ch2.getCenter().getX();
        double d3 = ch2.getCenter().getY();
        bu2.a(q2, d2, d3);
        this.a(q2, ch2);
        return q2;
    }

    protected q b(y y2, ch ch2) {
        bu bu2 = ch2.getGraph2D();
        v v2 = this.a(bu2);
        q q2 = v2.a(y2);
        q q3 = v2.b(q2);
        v2.c(y2, q3);
        this.a(q3, ch2);
        fj fj2 = bu2.t(q3);
        fj2.calcUnionRect(new Rectangle2D.Double());
        this.a(q3, bu2);
        v2.e(q3);
        this.a(bu2.t(q3));
        this.b(q3, bu2);
        return q3;
    }

    /*
     * Exception decompiling
     */
    protected void a(fj var1_1) {
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

    protected void a(q q2, ch ch2) {
        fj fj2 = ch2.getGraph2D().t(q2);
        if (fj2 instanceof gd) {
            gd gd2 = (gd)fj2;
            gd2.a(0).setLabelText(this.c(q2, ch2));
            gd2.a(1).setLabelText(this.b(q2, ch2));
            if (!fj.z) return;
        }
        fj2.setLabelText(this.c(q2, ch2));
    }

    protected String b(q q2, ch ch2) {
        return "Folder";
    }

    protected String c(q q2, ch ch2) {
        return "Group";
    }

    protected boolean a(bu bu2, q q2) {
        return bu2.v(q2);
    }

    public boolean c() {
        return this.b;
    }
}

