/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.io.PrintStream;
import y.a.L;
import y.a.R;
import y.a.ac;
import y.a.h;
import y.c.B;
import y.c.C;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.y;

class K {
    private q[] a;
    private d[] b;
    private int[] c;
    private int[] d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int h;
    private int i;
    private q j;
    private q k;
    private i l;
    private int m;
    private int n;
    private int o;
    private R p;
    private boolean q = true;
    private y r;
    private y s;
    private L t = new L();
    private boolean u;
    private int v;
    private int w = 5;
    private int x;

    /*
     * Exception decompiling
     */
    public int a(i var1_1, q var2_2, q var3_3, c var4_4, y.c.h var5_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 13[FORLOOP]
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

    /*
     * Unable to fully structure code
     */
    private void a(i var1_1, q var2_2, q var3_3, c var4_4) {
        block16 : {
            block15 : {
                var10_5 = h.a;
                this.l = var1_1;
                this.j = var2_2;
                this.k = var3_3;
                this.h = this.l.f();
                this.i = this.l.h();
                this.n = 2 * this.h - 1;
                this.m = 1;
                this.a = this.l.m();
                this.b = new d[this.i];
                this.c = new int[this.h];
                this.d = new int[this.h];
                this.e = new int[this.i];
                this.f = new int[this.i];
                if (this.q) {
                    this.p = new ac(this.n);
                }
                this.s = new y();
                this.r = new y();
                this.x = this.v = this.w * this.i;
                this.o = 0;
                this.u = false;
                var8_6 = this.l.p();
                while (var8_6.f()) {
                    var5_8 = var8_6.a();
                    var6_9 = var5_8.b();
                    v0 = var7_10 = var4_4.a(var5_8);
                    if (var10_5) break block15;
                    if (v0 < 0) {
                        throw new B("found negative capacity");
                    }
                    if (var7_10 != Integer.MAX_VALUE) ** GOTO lbl-1000
                    this.u = true;
                    if (var10_5) lbl-1000: // 2 sources:
                    {
                        if (var7_10 > this.o) {
                            this.o = var7_10;
                        }
                    }
                    this.b[var6_9] = var5_8;
                    this.f[var6_9] = var7_10;
                    var8_6.g();
                    if (!var10_5) continue;
                }
                v0 = this.u;
            }
            if (v0 != 0) {
                this.o = this.o * this.i + 1;
                if (this.o < 0) {
                    throw new RuntimeException("MaxFlow Error:  Integer-Overflow by infinity scaling!");
                }
                for (var8_7 = 0; var8_7 < this.i; ++var8_7) {
                    v1 = this.f[var8_7];
                    v2 = Integer.MAX_VALUE;
                    if (!var10_5) {
                        if (v1 != v2) continue;
                        this.f[var8_7] = this.o;
                        if (!var10_5) continue;
                    }
                    break;
                }
            } else {
                v1 = Integer.MAX_VALUE / this.j.c();
                v2 = this.o;
            }
            if (v1 < v2) {
                System.err.println("Warning: Integer-Overflow possible!");
            }
            var9_11 = this.j.l();
            while (var9_11.f()) {
                var5_8 = var9_11.a();
                var6_9 = var5_8.b();
                var8_6 = (C)this.f[var6_9];
                v3 = var8_6;
                if (!var10_5) {
                    if (v3 != false) {
                        this.e[var6_9] = var8_6;
                        v4 = this.d;
                        v5 = var5_8.d().d();
                        v4[v5] = v4[v5] + var8_6;
                        v6 = this.d;
                        v7 = this.j.d();
                        v6[v7] = v6[v7] - var8_6;
                    }
                    var9_11.g();
                    if (!var10_5) continue;
                }
                break block16;
            }
            v3 = var9_12 = 0;
        }
        while (var9_12 < this.h) {
            this.c[var9_12] = this.h;
            ++var9_12;
            if (var10_5 != false) return;
            if (!var10_5) continue;
        }
        this.a();
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        var9_1 = h.a;
        this.s.add(this.k);
        this.c[this.k.d()] = 0;
        this.g = new int[this.h];
        this.g[0] = 1;
        block0 : do {
            if (this.s.isEmpty() != false) return;
            var1_2 = this.s.d();
            var2_3 = var1_2.d();
            v0 = this.c[var2_3];
            v1 = 1;
            block1 : do {
                var7_8 = v0 + v1;
                var8_9 = var1_2.l();
                while (var8_9.f()) {
                    var3_4 = var8_9.a();
                    var4_5 = var3_4.b();
                    v2 = this.e[var4_5];
                    if (!var9_1) {
                        if (v2 != 0 && this.c[var6_7 = (var5_6 = var3_4.d()).d()] >= this.h) {
                            this.c[var6_7] = var7_8;
                            this.s.add(var5_6);
                            v3 = this.g;
                            v4 = var7_8;
                            v3[v4] = v3[v4] + 1;
                            if (this.d[var6_7] > 0) {
                                this.p.a(var5_6, var7_8);
                            }
                        }
                        var8_9.g();
                        if (!var9_1) continue;
                    }
                    ** GOTO lbl34
                }
                var8_9 = var1_2.k();
                do {
                    v2 = var8_9.f();
lbl34: // 2 sources:
                    if (v2 == 0) continue block0;
                    var3_4 = var8_9.a();
                    var4_5 = var3_4.b();
                    v0 = this.f[var4_5];
                    v1 = this.e[var4_5];
                    if (var9_1) continue block1;
                    if (v0 != v1 && this.c[var6_7 = (var5_6 = var3_4.c()).d()] >= this.h) {
                        this.c[var6_7] = var7_8;
                        this.s.add(var5_6);
                        v5 = this.g;
                        v6 = var7_8;
                        v5[v6] = v5[v6] + 1;
                        if (this.d[var6_7] > 0) {
                            this.p.a(var5_6, var7_8);
                        }
                    }
                    var8_9.g();
                } while (!var9_1);
                break;
            } while (true);
            break;
        } while (true);
    }

    private void b() {
        boolean bl2 = h.a;
        this.s.add(this.j);
        this.c[this.j.d()] = this.h;
        block0 : do {
            int n2 = this.s.isEmpty();
            block1 : do {
                if (n2 != 0) return;
                q q2 = this.s.d();
                int n3 = q2.d();
                int n4 = this.c[n3] + 1;
                e e2 = q2.l();
                do {
                    int n5;
                    q q3;
                    if (!e2.f()) continue block0;
                    d d2 = e2.a();
                    int n6 = d2.b();
                    n2 = this.e[n6];
                    if (bl2) continue block1;
                    if (n2 != 0 && this.c[n5 = (q3 = d2.d()).d()] == this.n) {
                        this.c[n5] = n4;
                        if (this.d[n5] > 0) {
                            this.p.a(q3, n4);
                        }
                        this.s.add(q3);
                    }
                    e2.g();
                } while (!bl2);
                break;
            } while (true);
            break;
        } while (true);
    }

    /*
     * Unable to fully structure code
     */
    private boolean c() {
        block15 : {
            block14 : {
                block13 : {
                    var11_1 = h.a;
                    var5_2 = new int[this.h];
                    for (var6_3 = 0; var6_3 < this.i; ++var6_3) {
                        v0 = this.e[var6_3];
                        if (!var11_1) {
                            if (v0 < 0 || this.e[var6_3] > this.f[var6_3]) {
                                System.err.println("checkMaxFlow: found wrong flow value!");
                                return false;
                            }
                            var2_5 = this.b[var6_3].c().d();
                            var4_6 = this.b[var6_3].d().d();
                            v1 = var5_2;
                            v2 = var2_5;
                            v1[v2] = v1[v2] - this.e[var6_3];
                            v3 = var5_2;
                            v4 = var4_6;
                            v3[v4] = v3[v4] + this.e[var6_3];
                            if (!var11_1) continue;
                        }
                        break block13;
                    }
                    v0 = var6_3 = 0;
                }
                while (var6_3 < this.h) {
                    v5 = this;
                    if (!var11_1) {
                        if (v5.a[var6_3] != this.j && this.a[var6_3] != this.k && var5_2[var6_3] != 0) {
                            System.err.println("checkMaxFlow: found wrong excess!");
                            return false;
                        }
                        ++var6_3;
                        if (!var11_1) continue;
                    }
                    break block14;
                }
                v5 = this;
            }
            var6_4 = new boolean[v5.h];
            var7_7 = new y();
            var7_7.add(this.j);
            var6_4[this.j.d()] = true;
            block2 : do {
                v6 = var7_7.isEmpty();
                block3 : while (v6 == 0) {
                    var1_8 = var7_7.d();
                    var2_5 = var1_8.d();
                    var10_12 = var1_8.l();
                    while (var10_12.f()) {
                        var8_10 = var10_12.a();
                        var9_11 = var8_10.b();
                        var3_9 = var8_10.d();
                        var4_6 = var3_9.d();
                        v7 = this.e[var9_11];
                        if (!var11_1) {
                            if (v7 < this.f[var9_11] && !var6_4[var4_6]) {
                                var6_4[var4_6] = true;
                                var7_7.add(var3_9);
                            }
                            var10_12.g();
                            if (!var11_1) continue;
                        }
                        ** GOTO lbl58
                    }
                    var10_12 = var1_8.k();
                    do {
                        v7 = var10_12.f();
lbl58: // 2 sources:
                        if (v7 == 0) continue block2;
                        var8_10 = var10_12.a();
                        var9_11 = var8_10.b();
                        var3_9 = var8_10.c();
                        var4_6 = var3_9.d();
                        v6 = this.e[var9_11];
                        if (var11_1) continue block3;
                        if (var11_1) break block15;
                        if (v6 > 0 && !var6_4[var4_6]) {
                            var6_4[var4_6] = true;
                            var7_7.add(var3_9);
                        }
                        var10_12.g();
                    } while (!var11_1);
                }
                break block2;
                break;
            } while (true);
            v8 = var6_4[this.k.d()];
        }
        if (v8 == false) return true;
        System.err.println("checkMaxFlow: t reachable from s!");
        return false;
    }
}

