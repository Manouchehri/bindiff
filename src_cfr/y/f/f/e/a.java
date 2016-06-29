/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Comparator;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.x;
import y.f.X;
import y.f.f.b.d;
import y.f.f.e.b;
import y.f.f.e.c;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;
import y.f.w;
import y.g.M;

public class a
implements d {
    private X b;
    private N c;
    private X d;
    private y.f.h.D e;
    private short f;
    private int g;
    private A h;
    private h i;
    private h j;
    private h k;
    private int l = 4;
    private A m;
    public static int a;

    @Override
    public void a(y.f.h.D d2) {
        this.b = (X)d2.g();
        this.c = d2;
    }

    public void a(short s2) {
        this.f = s2;
    }

    @Override
    public void a(int n2) {
        this.g = n2;
    }

    @Override
    public y.f.h.D b() {
        return this.e;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void a() {
        block25 : {
            block24 : {
                block22 : {
                    var17_1 = a.a;
                    var3_2 = this.c.i();
                    var4_3 = var3_2.a().a();
                    this.d = new w();
                    this.e = new y.f.h.D(this.d);
                    this.h = M.a(new Object[this.b.e()]);
                    this.i = M.b(new Object[this.b.g()]);
                    var5_4 = this.b.o();
                    while (var5_4.f()) {
                        var6_5 = var5_4.e();
                        if (var17_1 == 0) {
                            if (var6_5.c() <= this.l) {
                                var7_6 = this.d.d();
                                this.h.a(var6_5, var7_6);
                            }
                            var5_4.g();
                            if (var17_1 == 0) continue;
                        }
                        break block22;
                    }
                    this.j = M.b(new Object[this.b.g()]);
                    this.k = M.b(new Object[this.b.g()]);
                    this.a(this.j, this.k);
                }
                var2_8 = this.b.o();
                block3 : do {
                    v0 = var2_8.f();
                    block4 : while (v0 != 0) {
                        var5_4 = var2_8.e();
                        if (var5_4.c() != 0) {
                            var1_9 = var5_4.l();
                            var6_5 = var1_9.a();
                            var7_6 = (y.c.q)this.j.b(var6_5);
                            var1_9.b();
                            while (var1_9.f()) {
                                var8_10 = var1_9.a();
                                var9_11 = (y.c.q)this.j.b(var8_10);
                                var10_12 = (y.c.q)this.k.b(var8_10);
                                var11_13 = this.a((y.c.q)var7_6, (y.c.q)var9_11);
                                v0 = var5_4.c();
                                if (var17_1 != 0) continue block4;
                                if (v0 > this.l) {
                                    this.h.a(var5_4, var11_13);
                                }
                                var7_6 = (y.c.q)this.j.b(var8_10);
                                var12_14 /* !! */  = this.d.a((y.c.q)var9_11, (y.c.q)var10_12);
                                this.i.a(var8_10, var12_14 /* !! */ );
                                if (var8_10 == var6_5) break;
                                var1_9.b();
                                if (var17_1 == 0) continue;
                            }
                        }
                        var2_8.g();
                        if (var17_1 == 0) continue block3;
                    }
                    break block3;
                    break;
                } while (true);
                var1_9 = this.b.p();
                while (var1_9.f()) {
                    var5_4 = var1_9.a();
                    v1 = this;
                    if (var17_1 == 0) {
                        block23 : {
                            if (v1.c.n((y.c.d)var5_4)) {
                                this.e.m((y.c.d)this.i.b(var5_4));
                                if (var17_1 == 0) break block23;
                            }
                            this.e.e((y.c.d)this.i.b(var5_4));
                        }
                        var6_5 = this.c.h((y.c.d)var5_4);
                        this.e.b((y.c.d)this.i.b(var5_4), (y.c.d)this.i.b(var6_5));
                        var1_9.g();
                        if (var17_1 == 0) continue;
                    }
                    break block24;
                }
                v1 = this;
            }
            var5_4 = v1.e.m();
            this.d.a("y.layout.orthogonal.general.NodeSplitter.NODE_FACES", (y.c.c)var5_4);
            var6_5 = this.e.m();
            this.d.a("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", (y.c.c)var6_5);
            this.m = this.e.g().t();
            this.d.a("y.layout.orthogonal.ring.FixedSizeNodeSplitter#NODE_SIZE", new c((r)var6_5, this.m));
            try {
                this.e.l();
                var7_6 = (y.c.d)this.i.b(var4_3);
                this.e.b(this.e.i((y.c.d)var7_6));
                var8_10 = this.e.h();
                while (var8_10.f()) {
                    var5_4.a(var8_10.a(), false);
                    var8_10.g();
                    if (var17_1 == 0) {
                        if (var17_1 == 0) continue;
                    }
                    break block25;
                }
                var8_10 = this.b.o();
                while (var8_10.f()) {
                    var9_11 = var8_10.e();
                    if (var17_1 != 0) break;
                    if (var9_11.c() <= this.l) ** GOTO lbl-1000
                    var10_12 = (y.c.d)this.h.b(var9_11);
                    var11_13 = this.e.i((y.c.d)var10_12);
                    this.h.a(var9_11, var11_13);
                    var5_4.a((p)var11_13, true);
                    var12_14 /* !! */  = (y.c.d)this.b.p((y.c.q)var9_11);
                    var14_15 = this.b.q((y.c.q)var9_11);
                    var16_16 = new Dimension((int)var12_14 /* !! */ , (int)var14_15);
                    var6_5.a((p)var11_13, var16_16);
                    if (var17_1 != 0) lbl-1000: // 2 sources:
                    {
                        var10_12 = this.b.r((y.c.q)var9_11);
                        if (var10_12.a > 0.0 || var10_12.b > 0.0) {
                            var11_13 = (y.c.q)this.h.b(var9_11);
                            this.m.a(var11_13, this.b.r((y.c.q)var9_11));
                        }
                    }
                    var8_10.g();
                    if (var17_1 == 0) continue;
                    break;
                }
            }
            catch (Exception var7_7) {
                System.err.println("Internal Error in Face calculation !");
                var7_7.printStackTrace(System.err);
            }
        }
        var7_6 = this.e.h();
        block9 : do {
            if (var7_6.f() == false) return;
            var8_10 = (p)var7_6.d();
            if (var5_4.d(var8_10)) {
                var9_11 = var8_10.a();
                while (var9_11.f()) {
                    var10_12 = var9_11.a();
                    this.e.m(this.e.h((y.c.d)var10_12));
                    this.e.e((y.c.d)var10_12);
                    var9_11.g();
                    if (var17_1 != 0) continue block9;
                    if (var17_1 == 0) continue;
                }
            }
            var7_6.g();
        } while (var17_1 == 0);
    }

    /*
     * Unable to fully structure code
     */
    private y.c.d a(y.c.q var1_1, y.c.q var2_2) {
        if (var1_1.equals(var2_2)) {
            return null;
        }
        var3_3 = this.d.a(var1_1, var2_2);
        var4_4 = var2_2.l();
        if (var4_4.f()) ** GOTO lbl-1000
        var5_5 = this.d.a(var2_2, var1_1);
        if (a.a != 0) lbl-1000: // 2 sources:
        {
            var4_4.g();
            var6_6 = var4_4.a();
            var5_5 = this.d.a(var2_2, var6_6, var1_1, null, 1, 0);
        }
        this.e.b(var3_3, var5_5);
        return var5_5;
    }

    private void a(h h2, h h3) {
        Object object;
        int n2;
        C c2;
        e e2;
        block4 : {
            n2 = a;
            c2 = this.b.o();
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
            e2 = this.b.p();
        }
        c2 = e2;
        do {
            if (!c2.f()) return;
            y.c.d d3 = c2.a();
            object = this.c.h(d3);
            h3.a((Object)d3, h2.b(object));
            h3.a(object, h2.b(d3));
            c2.g();
        } while (n2 == 0);
    }

    private y.c.q a(y.c.d d2) {
        if (d2.c().c() > this.l) return this.d.d();
        y.c.q q2 = (y.c.q)this.h.b(d2.c());
        if (a == 0) return q2;
        return this.d.d();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void c() {
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

    void a(y.c.d d2, D d3) {
        this.b.a(d2, d3);
        d2 = this.c.h(d2);
        d3.n();
        this.b.a(d2, d3);
    }

    private int a(D d2, D d3, int n2, int n3) {
        D d4 = new D();
        d4.addAll(d2);
        d4.addAll(d3);
        if (d4.size() == 0) {
            return (n3 + n2) / 2;
        }
        d4.o();
        return this.a(d4);
    }

    private int a(D d2, D d3, int n2, int n3, int n4) {
        if (n4 >= n3 - n2) {
            return n2 + n4 / 2;
        }
        int n5 = this.a(d2, d3, n2, n3);
        if (n5 - n4 / 2 < n2) {
            n5 = n2 + n4 / 2;
            if (a == 0) return n5;
        }
        if (n5 + n4 / 2 <= n3) return n5;
        return n3 - n4 / 2;
    }

    private int a(D d2) {
        Object object;
        int n2 = a;
        d2.sort(new b(this));
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

    static X a(a a2) {
        return a2.b;
    }
}

