/*
 * Decompiled with CFR 0_115.
 */
package y.f.h;

import y.c.D;
import y.c.d;
import y.c.e;
import y.c.h;
import y.f.h.O;
import y.f.h.P;
import y.f.h.T;
import y.f.h.U;
import y.f.h.i;
import y.f.h.l;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;

public class N {
    protected y.c.i a;
    public D b;
    protected p c;
    private h e;
    private final l f;
    public static boolean d;

    public N(y.c.i i2) {
        this.f = new O(this);
        this.a = i2;
        this.e = i2.u();
        this.b = new D();
    }

    public y.c.i g() {
        return this.a;
    }

    public d g(d d2) {
        d d3 = this.a.a(d2.d(), d2.c());
        this.b(d2, d3);
        this.o(d3).c(true);
        return d3;
    }

    public void b(d d2, d d3) {
        this.o(d2).a(d3);
        this.o(d3).a(d2);
    }

    public d h(d d2) {
        return this.o(d2).g();
    }

    public q h() {
        return new T(this.b);
    }

    public void b(p p2) {
        this.c = p2;
    }

    public p i() {
        return this.c;
    }

    public int j() {
        return this.b.size();
    }

    public p i(d d2) {
        return this.o(d2).i();
    }

    public void a(d d2, p p2) {
        this.o(d2).a(p2);
    }

    public void k() {
        i i2 = new i(this);
        i2.d();
        i2.e();
    }

    public void l() {
        this.a(this.f);
    }

    public void a(l l2) {
        boolean bl2 = d;
        this.b = new D();
        if (this.a.h() == 0) {
            return;
        }
        boolean[] arrbl = new boolean[this.a.h()];
        e e2 = this.a.p();
        while (e2.f()) {
            d d2 = e2.a();
            if (bl2) return;
            if (!arrbl[d2.b()]) {
                this.a(d2, l2, arrbl);
            }
            e2.g();
            if (!bl2) continue;
        }
        this.b(null);
    }

    public p a(d d2, l l2, boolean[] arrbl) {
        boolean bl2;
        boolean bl3 = d;
        p p2 = new p();
        d d3 = d2;
        boolean bl4 = true;
        while (bl4) {
            p2.a(d2);
            this.o(d2).a(p2);
            arrbl[d2.b()] = true;
            d d4 = l2.a(d2);
            bl2 = arrbl[d4.b()];
            if (bl3) return p2;
            if (bl2) {
                if (d4 != d3) throw new RuntimeException("Graph is not Planar !");
                bl4 = false;
                if (bl3) {
                    throw new RuntimeException("Graph is not Planar !");
                }
            }
            d2 = d4;
            if (!bl3) continue;
        }
        bl2 = this.b.add(p2);
        return p2;
    }

    public r m() {
        return new U();
    }

    public void a(r r2) {
        ((U)r2).a();
    }

    public d j(d d2) {
        d d3;
        d d4 = d2.g();
        if (d4 == null) {
            d3 = d2.c().f();
            return d3;
        }
        d3 = d4;
        return d3;
    }

    public d k(d d2) {
        d d3;
        d d4 = d2.i();
        if (d4 == null) {
            d3 = d2.c().h();
            return d3;
        }
        d3 = d4;
        return d3;
    }

    protected d l(d d2) {
        return this.j(this.h(d2));
    }

    /*
     * Exception decompiling
     */
    public boolean n() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 23[SIMPLE_IF_TAKEN]
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

    public void e() {
        block3 : {
            N n2;
            boolean bl2 = d;
            e e2 = this.a.p();
            while (e2.f()) {
                d d2 = e2.a();
                n2 = this;
                if (!bl2) {
                    if (n2.n(d2)) {
                        this.a.a(d2);
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block3;
            }
            n2 = this;
        }
        n2.a.a(this.e);
    }

    public boolean o() {
        boolean bl2 = d;
        if (this.i() == null) {
            return false;
        }
        p p2 = this.i();
        boolean bl3 = false;
        q q2 = this.h();
        do {
            if (!q2.f()) return bl3;
            p p3 = q2.a();
            if (p2 == p3) {
                bl3 = true;
            }
            q2.g();
        } while (!bl2);
        return bl3;
    }

    public String toString() {
        StringBuffer stringBuffer;
        boolean bl2 = d;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Facelist:\n");
        q q2 = this.h();
        while (q2.f()) {
            p p2 = q2.a();
            stringBuffer = stringBuffer2.append("Face :");
            if (bl2) return stringBuffer.toString();
            if (p2 == this.c) {
                stringBuffer2.append("  --> Outer-Face <---");
            }
            stringBuffer2.append("\n");
            stringBuffer2.append(p2);
            stringBuffer2.append("\n");
            q2.g();
            if (!bl2) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }

    public void m(d d2) {
        this.a(d2, true);
    }

    public void a(d d2, boolean bl2) {
        this.o(d2).c(bl2);
    }

    public boolean n(d d2) {
        return this.o(d2).h();
    }

    protected P o(d d2) {
        P p2 = (P)this.e.b(d2);
        if (p2 != null) return p2;
        p2 = this.d_();
        this.e.a((Object)d2, p2);
        return p2;
    }

    protected P d_() {
        return new P();
    }
}

