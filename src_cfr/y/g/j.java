/*
 * Decompiled with CFR 0_115.
 */
package y.g;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.x;
import y.g.K;
import y.g.p;

public class J {
    private i a;
    private List b;
    private List c;
    private boolean d = true;
    private c e;
    private Map f;
    private static final Object g = new Object();

    public J(i i2, c c2) {
        this.a = i2;
        this.b = new ArrayList(i2.g());
        this.c = new ArrayList(i2.e());
        this.a(c2);
    }

    /*
     * Exception decompiling
     */
    public void a(c var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[FORLOOP]], but top level block is 3[FORLOOP]
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

    public void a(Object object) {
        boolean bl2 = p.c;
        K k2 = (K)this.f.get(object == null ? g : object);
        if (k2 == null) return;
        int n2 = k2.a.size() - 1;
        do {
            if (n2 < 0) return;
            q q2 = (q)k2.a.get(n2);
            this.a(q2);
            --n2;
        } while (!bl2);
    }

    public void b(Object object) {
        boolean bl2;
        int n2;
        int n3;
        block8 : {
            block7 : {
                int n4;
                bl2 = p.c;
                K k2 = (K)this.f.get(object == null ? g : object);
                if (k2 == null) return;
                for (n2 = k2.a.size() - 1; n2 >= 0; --n2) {
                    q q2 = (q)k2.a.get(n2);
                    n4 = (int)this.a.f(q2) ? 1 : 0;
                    if (!bl2) {
                        if (n4 != 0) continue;
                        this.b(q2);
                        if (!bl2) continue;
                    }
                    break block7;
                }
                n4 = n2 = k2.b.size() - 1;
            }
            while (n2 >= 0) {
                d d2 = (d)k2.b.get(n2);
                n3 = (int)this.a.f(d2) ? 1 : 0;
                if (!bl2) {
                    if (n3 == 0) {
                        this.a(d2);
                    }
                    --n2;
                    if (!bl2) continue;
                }
                break block8;
            }
            n3 = k2.c.size() - 1;
        }
        n2 = n3;
        do {
            if (n2 < 0) return;
            d d3 = (d)k2.c.get(n2);
            if (this.a.f(d3.c()) && this.a.f(d3.d()) && !this.a.f(d3)) {
                this.a(d3);
            }
            --n2;
        } while (!bl2);
    }

    public void c(Object object) {
        int n2;
        Object object2;
        boolean bl2;
        int n3;
        block8 : {
            Object object3;
            Object object4;
            block7 : {
                bl2 = p.c;
                object3 = this.a.o();
                while (object3.f()) {
                    q q2 = object3.e();
                    object4 = object2 = this.e.b(q2);
                    if (!bl2) {
                        if (!(object4 == object || object != null && object.equals(object2))) {
                            this.a(q2);
                        }
                        object3.g();
                        if (!bl2) continue;
                    }
                    break block7;
                }
                object4 = this.f.get(object == null ? g : object);
            }
            if ((object3 = (K)object4) == null) return;
            for (n2 = object3.a.size() - 1; n2 >= 0; --n2) {
                object2 = (q)object3.a.get(n2);
                n3 = (int)this.a.f((q)object2) ? 1 : 0;
                if (!bl2) {
                    if (n3 != 0) continue;
                    this.b((q)object2);
                    if (!bl2) continue;
                }
                break block8;
            }
            n3 = object3.b.size() - 1;
        }
        n2 = n3;
        do {
            if (n2 < 0) return;
            object2 = (d)object3.b.get(n2);
            if (!this.a.f((d)object2)) {
                this.a((d)object2);
            }
            --n2;
        } while (!bl2);
    }

    public void a() {
        boolean bl2 = p.c;
        x x2 = this.a.o();
        do {
            if (!x2.f()) return;
            this.a(x2.e());
            x2.g();
        } while (!bl2);
    }

    public void b() {
        this.c();
        this.d();
    }

    public void c() {
        block2 : {
            J j2;
            boolean bl2 = p.c;
            for (int i2 = this.c.size() - 1; i2 >= 0; --i2) {
                q q2 = (q)this.c.get(i2);
                j2 = this;
                if (!bl2) {
                    if (j2.a.f(q2)) continue;
                    this.b(q2);
                    if (!bl2) continue;
                }
                break block2;
            }
            j2 = this;
        }
        j2.c.clear();
    }

    public void d() {
        block2 : {
            J j2;
            boolean bl2 = p.c;
            for (int i2 = this.b.size() - 1; i2 >= 0; --i2) {
                d d2 = (d)this.b.get(i2);
                j2 = this;
                if (!bl2) {
                    if (j2.a.f(d2)) continue;
                    this.a(d2);
                    if (!bl2) continue;
                }
                break block2;
            }
            j2 = this;
        }
        j2.b.clear();
    }

    public void a(q q2) {
        boolean bl2;
        boolean bl3;
        block8 : {
            d d2;
            bl2 = p.c;
            if (!this.a.f(q2)) {
                return;
            }
            d d3 = q2.g();
            while (d3 != null) {
                d2 = d3;
                d3 = d3.h();
                this.b.add(d2);
                bl3 = this.d;
                if (!bl2) {
                    if (bl3) {
                        this.a.d(d2);
                        if (!bl2) continue;
                    }
                    this.a.a(d2);
                    if (!bl2) continue;
                }
                break block8;
            }
            d3 = q2.f();
            while (d3 != null) {
                d2 = d3;
                d3 = d3.g();
                this.b.add(d2);
                bl3 = this.d;
                if (!bl2) {
                    if (bl3) {
                        this.a.d(d2);
                        if (!bl2) continue;
                    }
                    this.a.a(d2);
                    if (!bl2) continue;
                }
                break block8;
            }
            this.c.add(q2);
            bl3 = this.d;
        }
        if (bl3) {
            this.a.c(q2);
            if (!bl2) return;
        }
        this.a.a(q2);
    }

    protected void a(d d2) {
        if (this.d) {
            this.a.e(d2);
            if (!p.c) return;
        }
        this.a.b(d2);
    }

    protected void b(q q2) {
        if (this.d) {
            this.a.d(q2);
            if (!p.c) return;
        }
        this.a.b(q2);
    }
}

