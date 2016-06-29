/*
 * Decompiled with CFR 0_115.
 */
package y.f.c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import y.c.A;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.p;
import y.c.q;
import y.d.t;
import y.f.I;
import y.f.U;
import y.f.X;
import y.f.c.a;
import y.f.c.aA;
import y.g.ap;

class az {
    private c a;
    private c b;
    private A c;
    private A d;
    private h e;
    private h f;
    private X g;
    private D h;
    private D i;
    private D j;
    private D k;
    private Map l;
    private Map m;
    private Set n;
    private Set o;
    private h p;
    private ap q;
    private A r;
    private c s;
    private h t;
    private c u;
    private D v;

    public az(X x2, A a2, D d2, A a3, c c2, c c3, h h2, h h3) {
        this.v = d2;
        this.g = x2;
        this.a = c2;
        this.b = c3;
        this.c = a2;
        this.d = a3;
        this.e = h2;
        this.f = h3;
        c c4 = x2.c(U.a);
        if (c4 == null) return;
        this.p = x2.u();
        this.q = new ap(this.p, x2, U.a);
    }

    public void a(A a2, c c2, h h2, c c3) {
        this.r = a2;
        this.t = h2;
        this.s = c2;
        this.u = c3;
    }

    public boolean a() {
        return true;
    }

    public Object a(q q2) {
        aA aA2 = (aA)this.l.get(q2);
        if (aA2 == null) {
            aA2 = (aA)this.m.get(q2);
        }
        if (aA2 == null) {
            return null;
        }
        Object object = aA2.a;
        return object;
    }

    /*
     * Exception decompiling
     */
    public void a(D var1_1) {
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

    public void b(D d2) {
        aA aA2;
        p p2;
        boolean bl2;
        block3 : {
            bl2 = a.i;
            this.n = new HashSet();
            for (p2 = this.h.k(); p2 != null; p2 = p2.a()) {
                aA2 = (aA)p2.c();
                this.n.add(this.c.b(aA2.d));
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block3;
            }
            this.o = new HashSet();
        }
        p2 = this.i.k();
        do {
            if (p2 == null) return;
            aA2 = (aA)p2.c();
            this.o.add(this.c.b(aA2.d));
            p2 = p2.a();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    public void b() {
        block30 : {
            var10_1 = a.i;
            for (var1_2 = this.h.k(); var1_2 != null; var1_2 = var1_2.a()) {
                v0 = var1_2.c();
                block1 : do {
                    var2_3 = (aA)v0;
                    for (var3_4 = var2_3.b.k(); var3_4 != null; var3_4 = var3_4.a()) {
                        block29 : {
                            var4_5 = (d)var3_4.c();
                            v0 = this.g;
                            if (var10_1) continue block1;
                            if (!v0.f((d)var4_5)) {
                                this.g.e((d)var4_5);
                                var5_6 = this.g.b(var4_5);
                                var5_6.clearPoints();
                                if (!var10_1) break block29;
                            }
                            var5_6 = this.g.b(var4_5);
                        }
                        v1 = var2_3.d;
                        v2 = var4_5.c();
                        block3 : do {
                            var6_7 = v1.b(v2);
                            while (var6_7 != null) {
                                var7_8 = this.g.b(var6_7);
                                v1 = var6_7.c();
                                v2 = var4_5.c();
                                if (var10_1) continue block3;
                                if (v1 != v2) ** GOTO lbl-1000
                                var5_6.setSourcePoint(var7_8.getSourcePoint());
                                if (var10_1) lbl-1000: // 2 sources:
                                {
                                    var8_9 = this.g.p((d)var6_7);
                                    var5_6.addPoint(var8_9.a, var8_9.b);
                                }
                                for (var8_10 = 0; var8_10 < var7_8.pointCount(); ++var8_10) {
                                    var9_13 = var7_8.getPoint(var8_10);
                                    var5_6.addPoint(var9_13.a, var9_13.b);
                                    if (!var10_1) {
                                        if (!var10_1) continue;
                                    }
                                    ** GOTO lbl-1000
                                }
                                if (var6_7.d() != var4_5.d()) ** GOTO lbl-1000
                                var5_6.setTargetPoint(var7_8.getTargetPoint());
                                if (var10_1) lbl-1000: // 3 sources:
                                {
                                    var8_11 = this.g.q((d)var6_7);
                                    var5_6.addPoint(var8_11.a, var8_11.b);
                                }
                                var6_7 = this.a(var6_7.d(), (d)var4_5);
                                if (!var10_1) continue;
                            }
                            break block3;
                            break;
                        } while (true);
                        if (!var10_1) continue;
                    }
                    break;
                } while (true);
                if (!var10_1) continue;
            }
            var1_2 = new ArrayList<E>(50);
            for (var2_3 = this.i.k(); var2_3 != null; var2_3 = var2_3.a()) {
                var3_4 = (aA)var2_3.c();
                v3 = var3_4.b.k();
                if (var10_1) break block30;
                var4_5 = v3;
                while (var4_5 != null) {
                    block34 : {
                        block31 : {
                            var5_6 = (d)var4_5.c();
                            v4 = this.g;
                            if (var10_1) ** GOTO lbl115
                            if (!v4.f((d)var5_6)) {
                                this.g.e((d)var5_6);
                                var6_7 = this.g.b(var5_6);
                                var6_7.clearPoints();
                                if (!var10_1) break block31;
                            }
                            var6_7 = this.g.b(var5_6);
                        }
                        v5 = var3_4.d;
                        v6 = var5_6.d();
                        block8 : do {
                            var7_8 = v5.a(v6);
                            var1_2.clear();
                            while (var7_8 != null) {
                                block33 : {
                                    block32 : {
                                        var8_12 = this.g.b(var7_8);
                                        v5 = var7_8.d();
                                        v6 = var5_6.d();
                                        if (var10_1) continue block8;
                                        if (v5 != v6) ** GOTO lbl-1000
                                        var6_7.setTargetPoint(var8_12.getTargetPoint());
                                        if (var10_1) lbl-1000: // 2 sources:
                                        {
                                            var1_2.add(this.g.q((d)var7_8));
                                        }
                                        for (var9_14 = var8_12.pointCount() - 1; var9_14 >= 0; --var9_14) {
                                            var1_2.add(var8_12.getPoint(var9_14));
                                            if (!var10_1) {
                                                if (!var10_1) continue;
                                            }
                                            break block32;
                                        }
                                        if (var7_8.c() == var5_6.c()) {
                                            var6_7.setSourcePoint(var8_12.getSourcePoint());
                                            if (!var10_1) break block33;
                                        }
                                    }
                                    var1_2.add(this.g.p((d)var7_8));
                                }
                                var7_8 = this.b(var7_8.c(), (d)var5_6);
                                if (!var10_1) continue;
                            }
                            break block8;
                            break;
                        } while (true);
                        for (var8_9 = (reference)(var1_2.size() - 1); var8_9 >= 0; --var8_9) {
                            var9_13 = (t)var1_2.get((int)var8_9);
                            var6_7.addPoint(var9_13.a, var9_13.b);
                            if (!var10_1) {
                                if (!var10_1) continue;
                            }
                            break block34;
                        }
                        var4_5 = var4_5.a();
                    }
                    if (!var10_1) continue;
                }
                if (!var10_1) continue;
            }
            v3 = var2_3 = this.h.k();
        }
        while (var2_3 != null) {
            var3_4 = ((aA)var2_3.c()).d;
            v7 = this.g.f((q)var3_4);
            if (!var10_1) {
                if (v7) {
                    this.g.a((q)var3_4);
                }
                var2_3 = var2_3.a();
                if (!var10_1) continue;
            }
            ** GOTO lbl117
        }
        var2_3 = this.i.k();
        do {
            if (var2_3 == null) return;
            v4 = var2_3.c();
lbl115: // 2 sources:
            var3_4 = ((aA)v4).d;
            v7 = this.g.f((q)var3_4);
lbl117: // 2 sources:
            if (v7) {
                this.g.a((q)var3_4);
            }
            var2_3 = var2_3.a();
        } while (!var10_1);
    }

    private d a(q q2, d d2) {
        if (q2 == d2.d()) {
            return null;
        }
        aA aA2 = (aA)this.l.get(q2);
        if (aA2 == null) {
            return null;
        }
        d d3 = (d)aA2.i.get(d2);
        if (d3 != null) return d3;
        return aA2.e;
    }

    private d b(q q2, d d2) {
        if (q2 == d2.c()) {
            return null;
        }
        aA aA2 = (aA)this.m.get(q2);
        if (aA2 == null) {
            return null;
        }
        d d3 = (d)aA2.i.get(d2);
        if (d3 == null) {
            d3 = aA2.f;
        }
        if (d3 == null) return d3;
        if (!this.l.containsKey(d3.c())) return d3;
        return null;
    }

    public void c() {
        if (this.q != null) {
            this.q.b();
            this.g.a(this.p);
            this.p = null;
            this.q = null;
        }
        this.d = null;
        this.c = null;
        this.g = null;
        this.e = null;
        this.a = null;
        this.j = null;
        this.h = null;
        this.l = null;
        this.f = null;
        this.b = null;
        this.k = null;
        this.i = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
    }

    Set d() {
        return this.o;
    }

    Set e() {
        return this.n;
    }
}

