/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import y.c.d;
import y.c.e;
import y.c.x;
import y.f.h.D;
import y.f.h.a.a;
import y.f.h.a.f;
import y.f.h.a.i;
import y.f.h.a.j;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.o;
import y.f.h.a.r;
import y.f.h.a.s;
import y.f.h.p;
import y.f.h.q;

public class b {
    D a;
    y.c.i b;
    n[] c;
    protected f[] d = new f[2];
    protected f e = new f();
    private f h = new f();
    s f;
    public static boolean g;

    public b() {
        this(new j());
    }

    b(s s2) {
        this.d[0] = new f();
        this.d[1] = new f();
        this.f = s2;
    }

    public String toString() {
        String string;
        boolean bl2 = g;
        String string2 = "";
        if (this.c == null) return "nodes not initialized yet";
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            string = new StringBuffer().append(string2).append(this.c[i2].toString()).append("\n").toString();
            if (bl2) return string;
            string2 = string;
            if (!bl2) continue;
            return "nodes not initialized yet";
        }
        string = string2;
        return string;
    }

    protected void a() {
        boolean bl2 = g;
        for (int i2 = 0; i2 < 2; ++i2) {
            this.d[i2].b();
            if (bl2) return;
            if (!bl2) continue;
        }
        this.h.b();
        this.e.b();
    }

    boolean b() {
        boolean bl2 = g;
        this.c = new n[this.b.f()];
        x x2 = this.b.o();
        while (x2.f()) {
            int n2 = x2.e().d();
            this.c[n2] = new n(x2.e(), -1, null);
            if (bl2) return true;
            y.c.q q2 = x2.e();
            block1 : do {
                e e2 = q2.l();
                while (e2.f()) {
                    q2 = e2.a().d();
                    if (bl2) continue block1;
                    if (q2 == e2.a().c() && !this.b(e2.a())) {
                        this.c[n2].a(e2.a());
                        this.b.d(e2.a());
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            x2.g();
            if (!bl2) continue;
        }
        this.f.a(this.b);
        this.a(this.f);
        this.e();
        return true;
    }

    private void e() {
        boolean bl2 = g;
        int n2 = 0;
        block0 : do {
            if (n2 >= this.c.length) return;
            if (this.c[n2].q() != null) {
                Iterator iterator = this.c[n2].q().iterator();
                while (iterator.hasNext()) {
                    this.b.e((d)iterator.next());
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
            }
            ++n2;
        } while (!bl2);
    }

    private d a(d d2) {
        if (this.a == null) return null;
        d d3 = this.a.h(d2);
        if (d3 == null) return this.a.g(d2);
        return d3;
    }

    private boolean b(d d2) {
        if (this.a != null) return this.a.n(this.a.d(d2));
        return false;
    }

    /*
     * Exception decompiling
     */
    private boolean a(s var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP], 3[DOLOOP]], but top level block is 4[WHILELOOP]
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

    protected static m a(r r2, r r3, int n2, int n3, int n4) {
        if (!r3.u()) return r3.s();
        return b.b(r2, r3, n2, n3, n4);
    }

    protected static m b(r r2, r r3, int n2, int n3, int n4) {
        a a2;
        boolean bl2;
        block3 : {
            bl2 = g;
            if (r2.f(n2) == r3.f(n3)) return r2.f(n2);
            a a3 = a2 = r2.f() < r3.f() ? new a(r2, r3, 1) : new a(r3, r2, 1);
            if (n2 == 0) {
                r2.e(a2);
                if (!bl2) break block3;
            }
            r2.d(a2);
        }
        if (n3 == 0) {
            r3.e(a2);
            if (!bl2) return a2;
        }
        r3.d(a2);
        return a2;
    }

    protected void a(n n2, int n3, int n4) {
        boolean bl2 = g;
        do {
            if (!n2.d(n4)) return;
            n2.a(n2.c().c(), n3 ^ 1, n3);
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    protected boolean a(n var1_1, n var2_2, m var3_3) {
        var24_4 = b.g;
        var4_5 = var1_1.f();
        var5_6 = false;
        var6_7 = 0;
        var7_8 = new boolean[2];
        var8_9 = var2_2;
        var9_10 = null;
        var10_11 = 0;
        var11_12 = var8_9;
        var12_13 = 0;
        this.d[0].b();
        this.d[1].b();
        this.e.b();
        this.e.a(var3_3);
        var13_14 = 0;
        var14_15 = false;
        var15_16 = false;
        while (!var5_6 && var6_7 < 2) {
            block31 : {
                block30 : {
                    block29 : {
                        block27 : {
                            var14_15 = var14_15 != false || var15_16 != false || var8_9.c(var4_5) != false;
                            var7_8[0] = var8_9.u() == false;
                            var7_8[1] = false;
                            var16_17 = null;
                            var17_18 = null;
                            var18_19 = null;
                            var19_20 = 0;
                            if (!var14_15 && var8_9.d(var4_5)) {
                                this.a(var8_9, 1, var4_5);
                            }
                            var20_21 = 0;
                            block1 : do {
                                v0 = var20_21;
                                block2 : while (v0 < 2) {
                                    v1 = var7_8[var20_21];
                                    if (var24_4) break block27;
                                    if (v1 != 0) ** GOTO lbl96
                                    var11_12 = var8_9;
                                    var12_13 = var20_21;
                                    if (var20_21 != 1 || var14_15 || var9_10 == null) ** GOTO lbl-1000
                                    var16_17 = var8_9;
                                    var13_14 = var20_21;
                                    var17_18 = var8_9.f(var20_21 ^ 1);
                                    if (var24_4) lbl-1000: // 2 sources:
                                    {
                                        var17_18 = var8_9.f(var20_21);
                                        var16_17 = var17_18.a(var8_9);
                                    }
                                    var21_22 = false;
                                    while (!var21_22 && !var7_8[var20_21]) {
                                        if (!(var16_17 instanceof i)) ** GOTO lbl61
                                        var22_24 = (i)var16_17;
                                        var21_22 = true;
                                        if (!var14_15) ** GOTO lbl54
                                        if (var20_21 != 1 || var7_8[0]) ** GOTO lbl58
                                        b.a(var8_9, var18_19, 0, var19_20, 1);
                                        var7_8[0] = true;
                                        if (!var24_4) ** GOTO lbl58
lbl54: // 2 sources:
                                        if (var20_21 != 1) ** GOTO lbl-1000
                                        var7_8[0] = true;
                                        if (var24_4) lbl-1000: // 2 sources:
                                        {
                                            var17_18 = b.a((r)var11_12, (r)var22_24, var12_13, var22_24.a(var17_18, var20_21 ^ 1), 1);
                                        }
lbl58: // 5 sources:
                                        var18_19 = var22_24;
                                        var19_20 = var22_24.a(var17_18, var20_21 ^ 1);
                                        if (!var24_4) continue;
lbl61: // 2 sources:
                                        if (!(var16_17 instanceof n)) continue;
                                        var22_24 = var16_17;
                                        v0 = (int)var22_24.c(var4_5) ? 1 : 0;
                                        if (var24_4) continue block2;
                                        if (v0 != 0) {
                                            ++var6_7;
                                            var7_8[var20_21] = true;
                                            b.a((r)var11_12, var16_17, var12_13, var22_24.a(var17_18, 1 ^ var13_14), 1);
                                            var15_16 = true;
                                            v2 = var21_22 = var7_8[0] == false;
                                            if (!var24_4) break;
                                        }
                                        if (var22_24.e(var4_5)) {
                                            var13_14 = var22_24.a(var17_18, var13_14 ^ 1) ^ 1;
                                            if (var22_24.d(var4_5)) {
                                                this.a((n)var22_24, var13_14, var4_5);
                                            }
                                            if (!var22_24.m().isEmpty()) {
                                                block28 : {
                                                    var23_25 = var22_24.o();
                                                    var12_13 = var13_14;
                                                    var11_12 = var22_24;
                                                    if (var12_13 == 1) {
                                                        var22_24.e(var23_25);
                                                        if (!var24_4) break block28;
                                                    }
                                                    var22_24.d(var23_25);
                                                }
                                                var17_18 = var23_25;
                                                this.d[var20_21].a(var23_25);
                                                if (var14_15) {
                                                    if (var20_21 == 1 && !var7_8[0]) {
                                                        b.a(var8_9, var18_19, 0, var19_20, 1);
                                                    }
                                                    if (!var7_8[var20_21 ^ 1]) {
                                                        ++var6_7;
                                                    }
                                                    var7_8[var20_21 ^ 1] = true;
                                                }
                                            }
                                        }
                                        var17_18 = var16_17.c(var17_18);
                                        var16_17 = var17_18.a(var16_17);
                                        if (!var24_4) continue;
                                    }
lbl96: // 4 sources:
                                    ++var20_21;
                                    if (!var24_4) continue block1;
                                }
                                break block1;
                                break;
                            } while (true);
                            v1 = var6_7;
                        }
                        if (v1 >= 2) continue;
                        v3 = var7_8[0];
                        if (var24_4 != false) return v3;
                        v4 = var20_21 = v3 == false ? 0 : 1;
                        if (var9_10 == null) ** GOTO lbl-1000
                        if (var10_11 == var20_21) {
                            var9_10.d();
                        }
                        if (var20_21 != 0) ** GOTO lbl-1000
                        var8_9.r().b(var9_10.r());
                        if (var24_4) lbl-1000: // 2 sources:
                        {
                            var8_9.r().a(var9_10.r());
                            if (var24_4) {
                                ** if (var20_21 != 0) goto lbl116
                            }
                        }
                        ** GOTO lbl119
lbl-1000: // 2 sources:
                        {
                            var8_9.e(var3_3);
                            if (!var24_4) break block29;
                        }
lbl116: // 2 sources:
                        var8_9.d(var3_3);
                    }
                    var8_9.o();
lbl119: // 2 sources:
                    this.e.a(this.d[var20_21]);
                    if (!var14_15) {
                        this.e.d(this.d[var20_21 ^ 1]);
                    }
                    if (var18_19.f() != var4_5) ** GOTO lbl-1000
                    var5_6 = true;
                    var21_23 = this.e.d();
                    while (var21_23.hasNext()) {
                        var22_24 = (m)var21_23.next();
                        var22_24.b(var18_19);
                        var22_24.j();
                        if (!var24_4) {
                            if (!var24_4) continue;
                        }
                        break block30;
                    }
                    if (var19_20 == 0) {
                        var18_19.r().b(this.e);
                        if (!var24_4) break block31;
                    }
                }
                var18_19.r().c(this.e);
            }
            this.e.b();
            if (var24_4) lbl-1000: // 2 sources:
            {
                var18_19.e();
                var9_10 = var18_19;
                var10_11 = var19_20;
                var8_9 = var18_19.b();
                var6_7 = 0;
            }
            this.d[0].b();
            this.d[1].b();
            if (!var24_4) continue;
        }
        v3 = var5_6;
        return v3;
    }

    protected void c() {
        boolean bl2 = g;
        int n2 = 0;
        do {
            if (n2 >= this.c.length) return;
            this.c[n2].e();
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void f() {
        var9_1 = b.g;
        var1_2 = new ArrayList<n>();
        var2_3 = new int[this.c.length];
        var3_4 = 0;
        do {
            if (var3_4 >= this.c.length) return;
            if (var2_3[this.c[var3_4].f()] != 0) ** GOTO lbl30
            var2_3[this.c[var3_4].f()] = 1;
            var1_2.add(this.c[var3_4]);
            block1 : do {
                v0 = var1_2.isEmpty();
                block2 : while (!v0) {
                    v1 = var1_2.remove(var1_2.size() - 1);
                    block3 : do {
                        if ((var5_6 = var2_3[(var4_5 = (n)v1).f()]) < 0) {
                            var4_5.r().c();
                        }
                        var6_7 = var4_5.r().d();
                        do lbl-1000: // 4 sources:
                        {
                            if (!var6_7.hasNext()) continue block1;
                            var7_8 = (m)var6_7.next();
                            v1 = var7_8.d();
                            if (var9_1) continue block3;
                            if (v1 == null) ** GOTO lbl-1000
                            v0 = var7_8.k();
                            if (var9_1) continue block2;
                            if (!v0 || (var8_9 = var7_8.a(var4_5).b()).j() != var7_8) ** GOTO lbl-1000
                            var1_2.add(var8_9);
                            var2_3[var8_9.f()] = var5_6 * var7_8.h();
                        } while (!var9_1);
                        break;
                    } while (true);
                }
                break block1;
                break;
            } while (true);
lbl30: // 3 sources:
            ++var3_4;
        } while (!var9_1);
    }

    private void g() {
        boolean bl2 = g;
        e e2 = this.b.p();
        while (e2.f()) {
            this.b.d(e2.a());
            e2.g();
            if (!bl2) continue;
        }
        int n2 = 0;
        block1 : do {
            n n3;
            Iterator iterator;
            int n4 = n2;
            block2 : do {
                if (n4 >= this.c.length) return;
                n3 = this.c[n2];
                iterator = n3.r().d();
                while (iterator.hasNext()) {
                    m m2 = (m)iterator.next();
                    if (m2.d() == null) continue;
                    n4 = (int)m2.k() ? 1 : 0;
                    if (bl2) continue block2;
                    if (n4 == 0) continue;
                    for (d d2 : m2.d()) {
                        if (d2.c() != n3.i()) continue;
                        this.b.e(d2);
                        if (!bl2 && !bl2) continue;
                    }
                }
                break block2;
                break;
            } while (true);
            if (n3.q() != null) {
                iterator = n3.q().iterator();
                while (iterator.hasNext()) {
                    this.b.e((d)iterator.next());
                    if (bl2) continue block1;
                    if (!bl2) continue;
                }
            }
            ++n2;
        } while (!bl2);
    }

    private void h() {
        boolean bl2 = g;
        y.c.D d2 = new y.c.D();
        int n2 = 0;
        block0 : do {
            Object object;
            int n3 = n2;
            int n4 = this.c.length;
            block1 : do {
                if (n3 >= n4) return;
                object = this.c[n2].r().d();
                while (object.hasNext()) {
                    Object object2;
                    m m2 = (m)object.next();
                    if (m2.d() == null) continue;
                    n3 = m2.a(this.c[n2]).f();
                    n4 = n2;
                    if (bl2) continue block1;
                    if (n3 <= n4) continue;
                    if (m2.k()) {
                        block9 : {
                            d2.clear();
                            object2 = m2.d().iterator();
                            while (object2.hasNext()) {
                                d2.a(this.a((d)object2.next()));
                                if (!bl2) {
                                    if (!bl2) continue;
                                }
                                break block9;
                            }
                            m2.d().addAll(d2);
                        }
                        if (!bl2) continue;
                    }
                    object2 = m2.d().iterator();
                    while (object2.hasNext()) {
                        this.b.d((d)object2.next());
                        if (!bl2 && !bl2) continue;
                    }
                }
                break block1;
                break;
            } while (true);
            if (this.c[n2].q() != null) {
                object = new y.c.D();
                for (Object object2 : this.c[n2].q()) {
                    object.b(object2);
                    object.b(this.a((d)object2));
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
                this.c[n2].a((y.c.D)object);
            }
            ++n2;
        } while (!bl2);
    }

    private boolean b(D d2) {
        if (d2 == null) {
            return false;
        }
        this.a = d2;
        return this.a(d2.g());
    }

    /*
     * Exception decompiling
     */
    public boolean a(y.c.i var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[DOLOOP]], but top level block is 2[WHILELOOP]
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

    private void i() {
        this.f();
        this.c();
        this.h();
        this.g();
    }

    public boolean a(D d2) {
        int n2;
        block4 : {
            boolean bl2 = g;
            if (!this.b(d2)) return false;
            this.i();
            d2.l();
            q q2 = d2.h();
            if (!q2.f()) {
                return true;
            }
            p p2 = q2.a();
            p2 = null;
            int n3 = 0;
            q q3 = d2.h();
            while (q3.f()) {
                int n4;
                n2 = n4 = q3.a().a().k();
                if (!bl2) {
                    if (n2 > n3) {
                        n3 = n4;
                        p2 = q3.a();
                    }
                    q3.g();
                    if (!bl2) continue;
                }
                break block4;
            }
            d2.b(p2);
            n2 = d2.n();
        }
        if (n2 == 0) throw new RuntimeException("Constructed planar embedding was corrupt!");
        return true;
    }

    public y.c.f d() {
        y.c.f f2;
        boolean bl2 = g;
        y.c.f f3 = new y.c.f();
        Iterator iterator = this.h.d();
        while (iterator.hasNext()) {
            f2 = f3;
            if (bl2) return f2;
            f2.addAll(((m)iterator.next()).d());
            if (!bl2) continue;
        }
        f2 = f3;
        return f2;
    }
}

