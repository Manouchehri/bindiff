/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.io.PrintStream;
import java.util.Comparator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.e;
import y.c.h;
import y.c.x;
import y.f.X;
import y.f.f.b.d;
import y.f.f.e.a;
import y.f.f.e.j;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;
import y.f.w;
import y.g.M;

public class i
implements d {
    private X a;
    private N b;
    private X c;
    private y.f.h.D d;
    private short e;
    private int f;
    private A g;
    private h h;
    private h i;
    private h j;

    @Override
    public void a(y.f.h.D d2) {
        this.a = (X)d2.g();
        this.b = d2;
    }

    public void a(short s2) {
        this.e = s2;
    }

    @Override
    public void a(int n2) {
        this.f = n2;
    }

    @Override
    public y.f.h.D b() {
        return this.d;
    }

    @Override
    public void a() {
        Object object4;
        Object object3;
        int n2;
        Object object2;
        Object object;
        block25 : {
            Object object5;
            y.c.d d2;
            block24 : {
                e e2;
                i i2;
                block22 : {
                    n2 = a.a;
                    p p2 = this.b.i();
                    d2 = p2.a().a();
                    this.c = new w();
                    this.d = new y.f.h.D(this.c);
                    this.g = M.a(new Object[this.a.e()]);
                    this.h = M.b(new Object[this.a.g()]);
                    object4 = this.a.o();
                    while (object4.f()) {
                        object2 = object4.e();
                        if (n2 == 0) {
                            if (object2.c() < 5) {
                                object3 = this.c.d();
                                this.g.a(object2, object3);
                            }
                            object4.g();
                            if (n2 == 0) continue;
                        }
                        break block22;
                    }
                    this.i = M.b(new Object[this.a.g()]);
                    this.j = M.b(new Object[this.a.g()]);
                    this.a(this.i, this.j);
                }
                x x2 = this.a.o();
                block3 : do {
                    int n3 = x2.f();
                    block4 : while (n3 != 0) {
                        object4 = x2.e();
                        if (object4.c() != 0) {
                            e2 = object4.l();
                            object2 = e2.a();
                            object3 = (y.c.q)this.i.b(object2);
                            e2.b();
                            while (e2.f()) {
                                object = e2.a();
                                y.c.q q2 = (y.c.q)this.i.b(object);
                                object5 = (y.c.q)this.j.b(object);
                                y.c.d d3 = this.a((y.c.q)object3, q2);
                                n3 = object4.c();
                                if (n2 != 0) continue block4;
                                if (n3 > 4) {
                                    this.g.a(object4, d3);
                                }
                                object3 = (y.c.q)this.i.b(object);
                                y.c.d d4 = this.c.a(q2, (y.c.q)object5);
                                this.h.a(object, d4);
                                if (object == object2) break;
                                e2.b();
                                if (n2 == 0) continue;
                            }
                        }
                        x2.g();
                        if (n2 == 0) continue block3;
                    }
                    break block3;
                    break;
                } while (true);
                e2 = this.a.p();
                while (e2.f()) {
                    object4 = e2.a();
                    i2 = this;
                    if (n2 == 0) {
                        block23 : {
                            if (i2.b.n((y.c.d)object4)) {
                                this.d.m((y.c.d)this.h.b(object4));
                                if (n2 == 0) break block23;
                            }
                            this.d.e((y.c.d)this.h.b(object4));
                        }
                        object2 = this.b.h((y.c.d)object4);
                        this.d.b((y.c.d)this.h.b(object4), (y.c.d)this.h.b(object2));
                        e2.g();
                        if (n2 == 0) continue;
                    }
                    break block24;
                }
                i2 = this;
            }
            object4 = i2.d.m();
            this.c.a("y.layout.orthogonal.general.NodeSplitter.NODE_FACES", (c)object4);
            try {
                this.d.l();
                object2 = (y.c.d)this.h.b(d2);
                this.d.b(this.d.i((y.c.d)object2));
                object3 = this.d.h();
                while (object3.f()) {
                    object4.a(object3.a(), false);
                    object3.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block25;
                }
                object3 = this.a.o();
                while (object3.f()) {
                    object = object3.e();
                    if (n2 == 0) {
                        if (object.c() > 4) {
                            y.c.d d5 = (y.c.d)this.g.b(object);
                            object5 = this.d.i(d5);
                            this.g.a(object, object5);
                            object4.a((p)object5, true);
                        }
                        object3.g();
                        if (n2 == 0) continue;
                    }
                    break;
                }
            }
            catch (Exception var6_6) {
                System.err.println("Internal Error in Face calculation !");
                var6_6.printStackTrace(System.err);
            }
        }
        object2 = this.d.h();
        block9 : do {
            if (!object2.f()) return;
            object3 = (p)object2.d();
            if (object4.d(object3)) {
                object = object3.a();
                while (object.f()) {
                    y.c.d d6 = object.a();
                    this.d.m(this.d.h(d6));
                    this.d.e(d6);
                    object.g();
                    if (n2 != 0) continue block9;
                    if (n2 == 0) continue;
                }
            }
            object2.g();
        } while (n2 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private y.c.d a(y.c.q var1_1, y.c.q var2_2) {
        if (var1_1.equals(var2_2)) {
            return null;
        }
        var3_3 = this.c.a(var1_1, var2_2);
        var4_4 = var2_2.l();
        if (var4_4.f()) ** GOTO lbl-1000
        var5_5 = this.c.a(var2_2, var1_1);
        if (a.a != 0) lbl-1000: // 2 sources:
        {
            var4_4.g();
            var6_6 = var4_4.a();
            var5_5 = this.c.a(var2_2, var6_6, var1_1, null, 1, 0);
        }
        this.d.b(var3_3, var5_5);
        return var5_5;
    }

    private void a(h h2, h h3) {
        Object object;
        int n2;
        C c2;
        e e2;
        block4 : {
            n2 = a.a;
            c2 = this.a.o();
            while (c2.f()) {
                block5 : {
                    y.c.q q2 = c2.e();
                    e2 = q2.l();
                    if (n2 != 0) break block4;
                    object = e2;
                    while (object.f()) {
                        y.c.d d2 = object.a();
                        y.c.q q3 = this.a(d2);
                        h2.a((Object)d2, q3);
                        object.g();
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block5;
                    }
                    c2.g();
                }
                if (n2 == 0) continue;
            }
            e2 = this.a.p();
        }
        c2 = e2;
        do {
            if (!c2.f()) return;
            y.c.d d3 = c2.a();
            object = this.b.h(d3);
            h3.a((Object)d3, h2.b(object));
            h3.a(object, h2.b(d3));
            c2.g();
        } while (n2 == 0);
    }

    private y.c.q a(y.c.d d2) {
        if (d2.c().c() >= 5) return this.c.d();
        y.c.q q2 = (y.c.q)this.g.b(d2.c());
        if (a.a == 0) return q2;
        return this.c.d();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void c() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [29[SIMPLE_IF_TAKEN]], but top level block is 1[WHILELOOP]
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

    private int a(D d2, D d3, int n2, int n3) {
        Integer n4;
        C c2;
        int n5;
        D d4;
        int n6;
        block6 : {
            n5 = a.a;
            d4 = new D();
            if (d2.size() == 0 && d3.size() == 0) {
                return (n3 + n2) / 2;
            }
            if (d2.size() > 0 && d3.size() == 0) {
                return this.a(d2);
            }
            if (d2.size() == 0 && d3.size() > 0) {
                return this.a(d3);
            }
            c2 = d2.m();
            while (c2.f()) {
                n4 = (Integer)c2.d();
                d4.add(n4);
                c2.g();
                if (n5 == 0) {
                    if (n5 == 0) continue;
                }
                break block6;
            }
            c2 = d3.m();
        }
        while (c2.f()) {
            n4 = (Integer)c2.d();
            n6 = (int)d4.add(n4) ? 1 : 0;
            if (n5 != 0) return n6;
            c2.g();
            if (n5 == 0) continue;
        }
        n6 = this.a(d4);
        return n6;
    }

    private int a(D d2) {
        Object object;
        int n2 = a.a;
        d2.sort(new j(this));
        C c2 = d2.m();
        for (int i2 = 0; i2 < d2.size() / 2; ++i2) {
            object = c2;
            if (n2 != 0) return (Integer)object;
            object.g();
            if (n2 == 0) continue;
        }
        object = c2.d();
        return (Integer)object;
    }
}

