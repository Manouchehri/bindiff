/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y.a.m;
import y.c.A;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.dy;

final class dA {
    private final i a;
    private final A b;
    private final h c;
    private final Map d;
    private final i e;
    private final aV f;
    private final boolean g;
    private final boolean h;
    private int[] i;
    private boolean[][] j;
    private q k;

    dA(i i2, aV aV2, boolean bl2, boolean bl3) {
        this.e = i2;
        this.f = aV2;
        this.g = bl2;
        this.h = bl3;
        this.a = new i();
        this.b = this.a.t();
        this.c = this.a.u();
        this.d = new HashMap();
        this.k = null;
    }

    boolean a(q q2) {
        aX aX2 = this.f.a(q2);
        if (aX2 == null) return false;
        if (1 != aX2.b()) return false;
        return true;
    }

    private boolean a(dy dy2) {
        if (dy2.a == null) return false;
        aX aX2 = this.f.a(dy2.a);
        if (aX2 == null) return false;
        if (1 != aX2.b()) return false;
        return true;
    }

    boolean a(d d2) {
        return this.c.d(d2);
    }

    int b(q q2) {
        return this.i[this.c(q2).d()];
    }

    /*
     * Unable to fully structure code
     */
    dA a(dA var1_1) {
        block18 : {
            block17 : {
                var11_2 = N.x;
                var2_3 = new ArrayList<Object>();
                var3_4 = new ArrayList<Object>();
                var4_5 = var1_1.a;
                var5_6 = var4_5.o();
                while (var5_6.f()) {
                    var6_9 = var1_1.e(var5_6.e());
                    if (var6_9.a == null || this.c(var6_9.a) != null) ** GOTO lbl17
                    var7_12 = this.a.d();
                    this.d.put(var6_9.a, var7_12);
                    this.b.a(var7_12, var6_9);
                    if (var6_9.b != 1) ** GOTO lbl-1000
                    var2_3.add(var7_12);
                    if (var11_2) lbl-1000: // 2 sources:
                    {
                        if (var6_9.b == 2) {
                            var3_4.add(var7_12);
                        }
                    }
lbl17: // 6 sources:
                    var5_6.g();
                    if (!var11_2) continue;
                }
                var5_7 = 0;
                var6_10 = var2_3.size();
                block1 : do {
                    v0 = var5_7;
                    v1 = var6_10;
                    block2 : while (v0 < v1) {
                        var7_12 = (q)var2_3.get(var5_7);
                        v2 = this.a.o();
                        if (var11_2) ** GOTO lbl50
                        var8_13 = v2;
                        while (var8_13.f()) {
                            var9_14 = var8_13.e();
                            v0 = this.e((q)var9_14).b;
                            v1 = 1;
                            if (var11_2) continue block2;
                            if (v0 != v1 && var7_12.a(var9_14) == null) {
                                this.c.a((Object)this.a.a((q)var7_12, var9_14), true);
                            }
                            var8_13.g();
                            if (!var11_2) continue;
                        }
                        ++var5_7;
                        if (!var11_2) continue block1;
                    }
                    break block1;
                    break;
                } while (true);
                var5_7 = 0;
                var6_10 = var3_4.size();
                block4 : do {
                    v3 = var5_7;
                    v4 = var6_10;
                    block5 : while (v3 < v4) {
                        var7_12 = (q)var3_4.get(var5_7);
                        v5 = this.a;
                        if (var11_2) break block17;
                        v2 = var8_13 = v5.o();
lbl50: // 3 sources:
                        while (var8_13.f()) {
                            var9_14 = var8_13.e();
                            v3 = this.e((q)var9_14).b;
                            v4 = 2;
                            if (var11_2) continue block5;
                            if (v3 != v4 && var9_14.a((q)var7_12) == null) {
                                this.c.a((Object)this.a.a(var9_14, (q)var7_12), true);
                            }
                            var8_13.g();
                            if (!var11_2) continue;
                        }
                        ++var5_7;
                        if (!var11_2) continue block4;
                    }
                    break block4;
                    break;
                } while (true);
                v5 = var4_5;
            }
            var5_8 = v5.p();
            while (var5_8.f()) {
                var6_11 = var5_8.a();
                var7_12 = var1_1.e(var6_11.c());
                var8_13 = var1_1.e(var6_11.d());
                if (var11_2) break block18;
                if (var7_12.a == null) ** GOTO lbl-1000
                var9_14 = this.c(var7_12.a);
                if (var8_13.a == null) ** GOTO lbl82
                var10_15 = this.c(var8_13.a);
                if (var9_14.a(var10_15) != null) ** GOTO lbl-1000
                this.c.a((Object)this.a.a(var9_14, var10_15), var1_1.a(var6_11));
                if (var11_2) lbl-1000: // 2 sources:
                {
                    if (var9_14.a(this.k) == null) {
                        this.c.a((Object)this.a.a(var9_14, this.k), var1_1.a(var6_11));
                        ** if (!var11_2) goto lbl82
                    }
                }
                ** GOTO lbl82
lbl-1000: // 2 sources:
                {
                    if (var8_13.a != null && this.k.a(var9_14 = this.c(var8_13.a)) == null) {
                        this.c.a((Object)this.a.a(this.k, var9_14), var1_1.a(var6_11));
                    }
                }
lbl82: // 6 sources:
                var5_8.g();
                if (!var11_2) continue;
            }
            if (this.i.length < this.a.f()) {
                this.i = new int[this.a.f()];
            }
        }
        if (m.a(this.a, this.i) != false) return this;
        throw new IllegalArgumentException("Cyclic sequence constraints!");
    }

    /*
     * Exception decompiling
     */
    void a() {
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

    void b() {
        this.j = null;
    }

    private dy e(q q2) {
        return (dy)this.b.b(q2);
    }

    q c(q q2) {
        return (q)this.d.get(q2);
    }

    q d(q q2) {
        q q3 = this.a.d();
        this.d.put(q2, q3);
        this.b.a((Object)q3, new dy());
        return q3;
    }

    private boolean a(E e2, aV aV2, q q2, q q3) {
        q q4 = this.e((q)q2).a;
        q q5 = this.e((q)q3).a;
        if (q4 == null) return false;
        if (q5 == null) {
            return false;
        }
        aX aX2 = aV2.a(q5);
        if (aX2 == null) return false;
        if (aX2.b() != 12) return false;
        if (!e2.a(q4, aX2.l())) return false;
        return true;
    }

    private boolean b(E e2, aV aV2, q q2, q q3) {
        q q4 = this.e((q)q2).a;
        q q5 = this.e((q)q3).a;
        if (q4 == null) return false;
        if (q5 == null) {
            return false;
        }
        aX aX2 = aV2.a(q5);
        if (aX2 == null) return false;
        if (aX2.b() != 13) return false;
        if (!e2.a(q4, aX2.l())) return false;
        return true;
    }

    private void a(E e2, y y2, byte by2) {
        boolean bl2 = N.x;
        x x2 = y2.a();
        do {
            byte by3;
            if (!x2.f()) return;
            q q2 = this.c(x2.e());
            if (q2 != null && this.e((q)q2).b == 0) {
                this.e((q)q2).b = by2;
            }
            byte by4 = by3 = q2 != null ? this.e((q)q2).b : 0;
            if (by3 != 0 && e2.d(x2.e())) {
                this.a(e2, e2.h(x2.e()), by3);
            }
            x2.g();
        } while (!bl2);
    }

    private int a(q q2, Map map, E e2) {
        Object object;
        boolean bl2 = N.x;
        Object object2 = map.get(q2);
        if (object2 == null) {
            int n2 = 0;
            x x2 = e2.g(q2).a();
            while (x2.f()) {
                q q3;
                object = q3 = this.c(x2.e());
                if (bl2) return (Integer)object;
                if (object != null) {
                    n2 |= this.e((q)q3).b;
                }
                x2.g();
                if (!bl2) continue;
            }
            object2 = new Integer(n2);
            map.put(q2, object2);
        }
        object = object2;
        return (Integer)object;
    }

    static dy a(dA dA2, q q2) {
        return dA2.e(q2);
    }

    static boolean[][] b(dA dA2) {
        return dA2.j;
    }

    static i c(dA dA2) {
        return dA2.a;
    }

    static q d(dA dA2) {
        return dA2.k;
    }

    static int[] e(dA dA2) {
        return dA2.i;
    }

    static int[] a(dA dA2, int[] arrn) {
        dA2.i = arrn;
        return dA2.i;
    }

    static h f(dA dA2) {
        return dA2.c;
    }
}

