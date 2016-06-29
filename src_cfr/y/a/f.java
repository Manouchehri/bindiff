/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import y.a.G;
import y.a.H;
import y.a.I;
import y.a.J;
import y.a.ab;
import y.a.h;
import y.a.m;
import y.c.A;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.a.a;

class F {
    private i a;
    private int[] b;
    private int[] c;
    private int[] d;
    private q e;
    private int[] f;
    private int[] g;
    private d[] h;
    private int[] i;
    private I[] j;
    private H k;
    private boolean[] l;
    private I m;
    private int[] n;
    private int[] o;
    private int p;
    private int q;
    private boolean[] r;
    private int[] s;
    private int[] t;
    private int[] u;
    private d[] v;
    private int[] w;
    private int[] x;
    private ArrayList y;
    private ArrayList z;
    private H[] A;
    private H[] B;

    F() {
    }

    public int a(i i2, A a2, c c2, c c3, c c4, q q2, boolean bl2) {
        return this.a(i2, a2, c2, c3, c4, q2, bl2, Long.MAX_VALUE);
    }

    public int a(i i2, A a2, c c2, c c3, c c4, q q2, boolean bl2, long l2) {
        F f2;
        boolean bl3;
        block5 : {
            bl3 = h.a;
            if (i2.f() < 1) {
                return 0;
            }
            if (i2.f() == 1) {
                a2.a((Object)i2.k(), 0);
                return 1;
            }
            long l3 = System.currentTimeMillis();
            this.a = i2;
            this.a(a2, c2, c3, bl2, q2, c4, l2, l3);
            while (System.currentTimeMillis() - l3 < l2) {
                f2 = this;
                if (!bl3) {
                    d d2 = f2.e();
                    if (d2 == null) break;
                    d d3 = this.a(d2);
                    this.b(d2, d3);
                    if (!bl3) continue;
                }
                break block5;
            }
            f2 = this;
        }
        int n2 = f2.f();
        x x2 = i2.o();
        do {
            if (!x2.f()) return n2;
            a2.a((Object)x2.e(), this.d[x2.e().d()]);
            x2.g();
        } while (!bl3);
        return n2;
    }

    /*
     * Exception decompiling
     */
    private void a(A var1_1, c var2_2, c var3_3, boolean var4_4, q var5_5, c var6_6, long var7_7, long var9_8) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [18[SIMPLE_IF_TAKEN]], but top level block is 4[WHILELOOP]
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

    private boolean a() {
        boolean bl2 = h.a;
        int n2 = 0;
        int n3 = 0;
        do {
            if (n3 >= this.b.length) return (boolean)0;
            int n4 = this.b[n3];
            int n5 = n2 += n4;
            if (bl2) return (boolean)n5;
            if (n5 < 0) {
                return true;
            }
            ++n3;
        } while (!bl2);
        return (boolean)0;
    }

    private void b() {
        boolean bl2 = h.a;
        y y2 = m.a(this.a);
        x x2 = y2.a();
        do {
            int n2 = x2.f();
            block1 : do {
                if (n2 == 0) return;
                q q2 = x2.e();
                int n3 = this.d[q2.d()];
                e e2 = q2.l();
                while (e2.f()) {
                    d d2 = e2.a();
                    n2 = n3 + this.c[d2.b()];
                    if (bl2) continue block1;
                    if (n2 > this.d[d2.d().d()]) {
                        this.d[d2.d().d()] = n3 + this.c[d2.b()];
                    }
                    e2.g();
                    if (!bl2) continue;
                }
                break block1;
                break;
            } while (true);
            x2.g();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private void a(long var1_1) {
        var11_2 = h.a;
        var3_3 = new ab();
        var3_3.a(this.a, this.d, this.c, var1_1);
        var4_4 = new ArrayList<q>();
        var4_4.add(this.e);
        var5_5 = new boolean[this.p];
        var6_6 = new e[this.p];
        var7_7 = this.a.o();
        while (var7_7.f()) {
            var6_6[var7_7.e().d()] = var7_7.e().j();
            var7_7.g();
            if (var11_2 != false) return;
            if (!var11_2) continue;
        }
        do lbl-1000: // 3 sources:
        {
            v0 = var4_4.isEmpty();
            block2 : do {
                if (v0 != false) return;
                var7_7 = (q)var4_4.get(var4_4.size() - 1);
                var5_5[var7_7.d()] = true;
                var8_8 = var6_6[var7_7.d()];
                while (var8_8.f()) {
                    var9_9 = var8_8.a();
                    var10_10 = var9_9.a((q)var7_7);
                    v0 = var5_5[var10_10.d()];
                    if (var11_2) continue block2;
                    if (!v0 && this.d[var9_9.d().d()] - this.d[var9_9.c().d()] - this.c[var9_9.b()] == 0) {
                        this.l[var9_9.b()] = true;
                        var4_4.add(var10_10);
                        if (!var11_2) break block2;
                    }
                    var8_8.g();
                    if (!var11_2) continue;
                }
                break block2;
                break;
            } while (true);
            if (var4_4.get(var4_4.size() - 1) != var7_7) ** GOTO lbl-1000
            var4_4.remove(var4_4.size() - 1);
        } while (!var11_2);
    }

    /*
     * Unable to fully structure code
     */
    private void c() {
        var9_1 = h.a;
        var1_2 = new ArrayList<q>();
        var1_2.add(this.e);
        var2_3 = new boolean[this.p];
        var3_4 = new e[this.p];
        var4_5 = this.a.o();
        while (var4_5.f()) {
            var3_4[var4_5.e().d()] = var4_5.e().j();
            var4_5.g();
            if (var9_1 != false) return;
            if (!var9_1) continue;
        }
        do lbl-1000: // 3 sources:
        {
            v0 = var1_2.isEmpty();
            block2 : do {
                if (v0 != false) return;
                var4_5 = (q)var1_2.get(var1_2.size() - 1);
                var2_3[var4_5.d()] = true;
                var5_6 = var3_4[var4_5.d()];
                while (var5_6.f()) {
                    var6_7 = var5_6.a();
                    var7_8 = var6_7.a((q)var4_5);
                    v0 = var2_3[var7_8.d()];
                    if (var9_1) continue block2;
                    if (!v0 && this.l[var6_7.b()]) {
                        var8_9 = this.A[var6_7.b()];
                        var8_9.d = var7_8.d();
                        this.j[var4_5.d()].a(var8_9);
                        this.h[var7_8.d()] = var6_7;
                        this.m.a(this.B[var6_7.b()]);
                        var1_2.add(var7_8);
                        if (!var9_1) break block2;
                    }
                    var5_6.g();
                    if (!var9_1) continue;
                }
                break block2;
                break;
            } while (true);
            if (var1_2.get(var1_2.size() - 1) != var4_5) ** GOTO lbl-1000
            var1_2.remove(var1_2.size() - 1);
        } while (!var9_1);
    }

    private void d() {
        boolean bl2 = h.a;
        this.a(this.e, null, 1, 0);
        int n2 = this.a.f();
        a a2 = new a(this.a, n2 + 1);
        x x2 = this.a.o();
        while (x2.f()) {
            q q2 = x2.e();
            a2.a(q2, n2 - this.i[q2.d()]);
            x2.g();
            if (bl2) return;
            if (!bl2) continue;
        }
        while (!a2.a()) {
            this.a(a2.c());
            if (bl2) return;
            if (!bl2) continue;
        }
        a2.b();
    }

    /*
     * Unable to fully structure code
     */
    private void a(q var1_1) {
        block8 : {
            var9_2 = h.a;
            if (var1_1 == this.e) {
                return;
            }
            var2_3 = this.h[var1_1.d()];
            var3_4 = this.b[var2_3.b()];
            var4_5 = 0;
            var7_6 = new J(null);
            if (this.o != null) ** GOTO lbl28
            var8_7 = var1_1.j();
            while (var8_7.f()) {
                var5_8 = var8_7.a();
                var6_9 = var5_8.b();
                v0 = this;
                if (var9_2) break block8;
                if (!v0.l[var6_9]) ** GOTO lbl22
                if (var5_8 == var2_3) ** GOTO lbl26
                if (!this.a(var5_8, var2_3)) ** GOTO lbl20
                var3_4 += this.n[var6_9] - this.b[var6_9];
                if (!var9_2) ** GOTO lbl26
lbl20: // 2 sources:
                var3_4 += this.b[var6_9] - this.n[var6_9];
                if (!var9_2) ** GOTO lbl26
lbl22: // 2 sources:
                if (!this.a(var2_3, var5_8)) ** GOTO lbl-1000
                var3_4 -= this.b[var6_9];
                if (var9_2) lbl-1000: // 2 sources:
                {
                    var3_4 += this.b[var6_9];
                }
lbl26: // 6 sources:
                var8_7.g();
                if (!var9_2) continue;
lbl28: // 2 sources:
                var8_7 = var1_1.j();
                while (var8_7.f()) {
                    var5_8 = var8_7.a();
                    var6_9 = var5_8.b();
                    v0 = this;
                    if (var9_2) break block8;
                    if (!v0.l[var6_9]) ** GOTO lbl-1000
                    if (var5_8 == var2_3) ** GOTO lbl52
                    if (!this.a(var5_8, var2_3)) ** GOTO lbl-1000
                    F.b(this.o[var6_9], this.n[var6_9], 0, this.b[var6_9], var7_6);
                    F.a(var4_5, var3_4, var7_6.a, var7_6.b, var7_6);
                    if (var9_2) lbl-1000: // 2 sources:
                    {
                        F.b(0, this.b[var6_9], this.o[var6_9], this.n[var6_9], var7_6);
                        F.a(var4_5, var3_4, var7_6.a, var7_6.b, var7_6);
                    }
                    var4_5 = var7_6.a;
                    var3_4 = var7_6.b;
                    if (var9_2) lbl-1000: // 2 sources:
                    {
                        block9 : {
                            if (this.a(var5_8, var2_3)) {
                                F.b(var4_5, var3_4, 0, this.b[var6_9], var7_6);
                                if (!var9_2) break block9;
                            }
                            F.a(var4_5, var3_4, 0, this.b[var6_9], var7_6);
                        }
                        var4_5 = var7_6.a;
                        var3_4 = var7_6.b;
                    }
lbl52: // 4 sources:
                    var8_7.g();
                    if (!var9_2) continue;
                }
                break block0;
            }
            this.n[var2_3.b()] = var3_4;
            v0 = this;
        }
        if (v0.o == null) return;
        this.o[var2_3.b()] = var4_5;
    }

    private boolean a(d d2, d d3) {
        if (d2.c() == d3.d()) return true;
        if (d2.d() == d3.c()) return true;
        return false;
    }

    private void a(q q2, q q3, int n2, int n3) {
        this.b(q2, q3, n2, n3);
    }

    /*
     * Unable to fully structure code
     */
    private void b(q var1_1, q var2_2, int var3_3, int var4_4) {
        var27_5 = h.a;
        var5_6 = 0;
        var6_7 = var2_2 == null ? -1 : var2_2.d();
        var7_8 = var1_1.d();
        var8_9 = this.t;
        var8_9[0] = var7_8;
        var9_10 = this.u;
        var9_10[var7_8] = 0;
        var10_11 = this.c;
        var11_12 = this.j;
        var12_13 = this.d;
        var13_14 = this.h;
        var14_15 = this.s;
        var15_16 = this.g;
        var16_17 = this.i;
        var17_18 = this.f;
        var18_19 = this.w;
        var19_20 = this.x;
        var20_21 = var3_3;
        do lbl-1000: // 3 sources:
        {
            if (var5_6 < 0) return;
            var21_22 = var8_9[var5_6];
            if (var14_15[var21_22] % 2 != 0) ** GOTO lbl49
            var22_23 = var9_10[var21_22];
            v0 = var14_15;
            v1 = var21_22;
            v0[v1] = v0[v1] + 1;
            var15_16[var21_22] = var20_21;
            var16_17[var21_22] = var4_4;
            if (var21_22 == var6_7) {
                var23_24 = var13_14[var6_7];
                var24_25 = var23_24.b();
                var25_26 = var18_19[var24_25];
                var26_27 = var19_20[var24_25];
                var22_23 = var25_26 == var6_7 ? - var10_11[var24_25] - var12_13[var25_26] + var12_13[var26_27] : var10_11[var24_25] + var12_13[var25_26] - var12_13[var26_27];
            }
            v2 = var12_13;
            v3 = var21_22;
            v2[v3] = v2[v3] + var22_23;
            ++var4_4;
            var23_24 = var11_12[var21_22].a;
            do {
                if (var23_24 == null) ** GOTO lbl-1000
                var24_25 = var23_24.d;
                var9_10[var24_25] = var22_23;
                var8_9[++var5_6] = var24_25;
                var23_24 = var23_24.a;
                if (var27_5 != false) return;
            } while (!var27_5);
lbl49: // 2 sources:
            v4 = var14_15;
            v5 = var21_22;
            v4[v5] = v4[v5] + 1;
            var17_18[var21_22] = var20_21++;
            --var5_6;
            --var4_4;
        } while (!var27_5);
    }

    private boolean a(d d2, q q2) {
        if (this.a(d2, q2, this.e)) return false;
        return true;
    }

    private boolean a(d d2, q q2, q q3) {
        int n2 = d2.d().d();
        int n3 = d2.c().d();
        return this.a(n2, n3, q2.d(), q3.d());
    }

    /*
     * Unable to fully structure code
     */
    private boolean a(int var1_1, int var2_2, int var3_3, int var4_4) {
        if (this.f[var1_1] <= this.f[var2_2]) ** GOTO lbl-1000
        var5_5 = this.f[var2_2];
        var6_6 = this.g[var2_2];
        if (h.a) lbl-1000: // 2 sources:
        {
            var5_5 = this.f[var1_1];
            var6_6 = this.g[var1_1];
        }
        var7_7 = this.f[var3_3];
        var8_8 = this.f[var4_4];
        if (var6_6 <= var7_7 && var6_6 <= var8_8 && var5_5 >= var7_7) {
            if (var5_5 >= var8_8) return false;
        }
        if (var6_6 <= var7_7) {
            if (var5_5 >= var7_7) return true;
        }
        if (var6_6 > var8_8) return false;
        if (var5_5 >= var8_8) return true;
        return false;
    }

    /*
     * Unable to fully structure code
     */
    private q a(q var1_1, q var2_2, ArrayList var3_3, boolean[] var4_4) {
        block8 : {
            block7 : {
                var10_5 = h.a;
                var7_6 = var1_1.d();
                var8_7 = var2_2.d();
                this.z.clear();
                while (this.i[var7_6] < this.i[var8_7]) {
                    var6_8 = this.h[var8_7];
                    this.z.add(var6_8);
                    if (!var10_5) {
                        var4_4[var6_8.b()] = var6_8.d() != var2_2;
                        var2_2 = var6_8.a(var2_2);
                        var8_7 = var2_2.d();
                        if (!var10_5) continue;
                    }
                    break block7;
                }
                while (this.i[var7_6] > this.i[var8_7]) {
                    var5_9 = this.h[var7_6];
                    var3_3.add(var5_9);
                    v0 = var4_4;
                    v1 = var5_9.b();
                    v2 = var5_9.c();
                    v3 = var1_1;
                    if (!var10_5) {
                        v0[v1] = v2 != v3;
                        var1_1 = var5_9.a(var1_1);
                        var7_6 = var1_1.d();
                        if (!var10_5) continue;
                    }
                    ** GOTO lbl36
                }
            }
            while (var1_1 != var2_2) {
                var5_9 = this.h[var7_6];
                v4 = (int)var3_3.add(var5_9) ? 1 : 0;
                if (!var10_5) {
                    v0 = var4_4;
                    v1 = var5_9.b();
                    v2 = var5_9.c();
                    v3 = var1_1;
lbl36: // 2 sources:
                    v0[v1] = v2 != v3;
                    var1_1 = var5_9.a(var1_1);
                    var7_6 = var1_1.d();
                    var6_8 = this.h[var8_7];
                    this.z.add(var6_8);
                    var4_4[var6_8.b()] = var6_8.d() != var2_2;
                    var2_2 = var6_8.a(var2_2);
                    var8_7 = var2_2.d();
                    if (!var10_5) continue;
                }
                break block8;
            }
            v4 = this.z.size() - 1;
        }
        var9_10 = v4;
        do {
            if (var9_10 < 0) return var1_1;
            var3_3.add(this.z.get(var9_10));
            --var9_10;
        } while (!var10_5);
        return var1_1;
    }

    private d e() {
        boolean bl2 = h.a;
        int[] arrn = this.n;
        int[] arrn2 = this.o;
        H h2 = this.k;
        int n2 = 0;
        while (n2++ < this.p) {
            if (h2 == null) {
                h2 = this.m.a;
            }
            if (arrn2 == null && arrn[h2.c] < 0 || arrn2 != null && arrn2[h2.c] < 0) {
                d d2 = h2.e;
                this.k = h2.a;
                return d2;
            }
            h2 = h2.a;
            if (!bl2) continue;
        }
        this.k = h2;
        return null;
    }

    /*
     * Unable to fully structure code
     */
    private d a(d var1_1) {
        var20_2 = h.a;
        var2_3 = -1;
        var3_4 = Integer.MAX_VALUE;
        var4_5 = var1_1.c().d();
        var5_6 = var1_1.d().d();
        var6_7 = this.f;
        var7_8 = var6_7[var5_6];
        if (var6_7[var4_5] <= var6_7[var5_6]) ** GOTO lbl-1000
        var8_9 = var6_7[var5_6];
        var9_10 = this.g[var5_6];
        if (var20_2) lbl-1000: // 2 sources:
        {
            var8_9 = var6_7[var4_5];
            var9_10 = this.g[var4_5];
        }
        var10_11 = this.w;
        var11_12 = this.x;
        var12_13 = this.d;
        var13_14 = this.c;
        var14_15 = this.q - 1;
        do {
            if (var14_15 < 0) return this.v[var2_3];
            var16_17 = var11_12[var14_15];
            var15_16 = var10_11[var14_15];
            var17_18 = var12_13[var16_17] - var12_13[var15_16] - var13_14[var14_15];
            if (var3_4 > var17_18) {
                var18_19 = var6_7[var15_16];
                var19_20 = var6_7[var16_17];
                if ((var9_10 > var19_20 || var8_9 < var19_20 || (var9_10 > var18_19 || var8_9 < var18_19) && (var9_10 > var7_8 || var8_9 < var7_8)) && (var9_10 <= var19_20 && var8_9 >= var19_20 || var9_10 <= var18_19 && var8_9 >= var18_19 && var9_10 <= var7_8 && var8_9 >= var7_8)) {
                    var3_4 = var17_18;
                    var2_3 = var14_15;
                }
            }
            --var14_15;
        } while (!var20_2);
        return this.v[var2_3];
    }

    /*
     * Unable to fully structure code
     */
    private void b(d var1_1, d var2_2) {
        block11 : {
            var21_3 = h.a;
            this.y.clear();
            var5_4 = var1_1.b();
            var6_5 = var2_2.b();
            var7_6 = var2_2.c();
            var8_7 = var2_2.d();
            if (!this.a(var1_1, var8_7)) ** GOTO lbl-1000
            var3_8 = var7_6;
            this.r[var6_5] = true;
            var4_9 = this.a(var7_6, var8_7, this.y, this.r);
            if (var21_3) lbl-1000: // 2 sources:
            {
                var3_8 = var8_7;
                this.r[var6_5] = false;
                var4_9 = this.a(var8_7, var7_6, this.y, this.r);
            }
            var9_10 = var2_2;
            var10_11 = true;
            var11_12 = this.n[var5_4];
            var12_13 = this.o == null ? 0 : this.o[var5_4];
            var13_14 = this.r[var5_4];
            var14_15 = var3_8.d();
            var15_16 = new J(null);
            if (this.o != null) ** GOTO lbl51
            for (var16_17 = 0; var16_17 < this.y.size(); ++var16_17) {
                var17_18 = (d)this.y.get(var16_17);
                var18_19 = var17_18.b();
                v0 = this.r[var18_19];
                v1 = var13_14;
                if (var21_3) break block11;
                if (v0 != v1) ** GOTO lbl-1000
                v2 = this.n;
                v3 = var18_19;
                v2[v3] = v2[v3] - var11_12;
                if (var21_3) lbl-1000: // 2 sources:
                {
                    v4 = this.n;
                    v5 = var18_19;
                    v4[v5] = v4[v5] + var11_12;
                }
                if (!var10_11) continue;
                this.h[var14_15] = var9_10;
                var19_20 = var14_15;
                var3_8 = var17_18.a(var3_8);
                var14_15 = var3_8.d();
                var20_21 = this.A[var18_19];
                this.j[var14_15].b(var20_21);
                if (var17_18 != var1_1) {
                    this.j[var19_20].a(var20_21);
                    var20_21.d = var14_15;
                    var9_10 = var17_18;
                    if (!var21_3) continue;
                }
                var10_11 = false;
                if (!var21_3) continue;
lbl51: // 5 sources:
                for (var16_17 = 0; var16_17 < this.y.size(); ++var16_17) {
                    var17_18 = (d)this.y.get(var16_17);
                    var18_19 = var17_18.b();
                    v0 = this.r[var18_19];
                    v1 = var13_14;
                    if (!var21_3) {
                        block12 : {
                            if (v0 == v1) {
                                F.b(this.o[var18_19], this.n[var18_19], var12_13, var11_12, var15_16);
                                if (!var21_3) break block12;
                            }
                            F.a(this.o[var18_19], this.n[var18_19], var12_13, var11_12, var15_16);
                        }
                        this.o[var18_19] = var15_16.a;
                        this.n[var18_19] = var15_16.b;
                        if (!var10_11) continue;
                        this.h[var14_15] = var9_10;
                        var19_20 = var14_15;
                        var3_8 = var17_18.a(var3_8);
                        var14_15 = var3_8.d();
                        var20_21 = this.A[var18_19];
                        this.j[var14_15].b(var20_21);
                        if (var17_18 != var1_1) {
                            this.j[var19_20].a(var20_21);
                            var20_21.d = var14_15;
                            var9_10 = var17_18;
                            if (!var21_3) continue;
                        }
                        var10_11 = false;
                        if (!var21_3) continue;
                    }
                    break block11;
                }
            }
            if (this.o != null) ** GOTO lbl82
            v6 = this.n[var6_5] = this.r[var5_4] == this.r[var6_5] ? - var11_12 : var11_12;
            if (!var21_3) ** GOTO lbl92
lbl82: // 2 sources:
            v0 = this.r[var5_4];
            v1 = this.r[var6_5];
        }
        if (v0 != v1) ** GOTO lbl-1000
        F.a(var12_13, var11_12, var15_16);
        this.o[var6_5] = var15_16.a;
        this.n[var6_5] = var15_16.b;
        if (var21_3) lbl-1000: // 2 sources:
        {
            this.o[var6_5] = var12_13;
            this.n[var6_5] = var11_12;
        }
lbl92: // 4 sources:
        this.l[var5_4] = false;
        this.l[var6_5] = true;
        this.m.b(this.B[var5_4]);
        this.m.a(this.B[var6_5]);
        var16_17 = var4_9.d();
        var17_18 = this.A[var6_5];
        if (this.a(var1_1, var7_6)) {
            var17_18.d = var8_7.d();
            this.j[var7_6.d()].a((H)var17_18);
            this.a(var4_9, var8_7, this.g[var16_17], this.i[var16_17]);
            if (var21_3 == false) return;
        }
        var17_18.d = var7_6.d();
        this.j[var8_7.d()].a((H)var17_18);
        this.a(var4_9, var7_6, this.g[var16_17], this.i[var16_17]);
    }

    private int f() {
        int n2;
        int n3;
        int n4;
        block5 : {
            int n5;
            boolean bl2 = h.a;
            int n6 = Integer.MAX_VALUE;
            n2 = -2147483647;
            for (n5 = 0; n5 < this.d.length; ++n5) {
                int n7;
                n3 = n7 = this.d[n5];
                n4 = n6;
                if (bl2) return n3 + n4;
                if (n3 < n4) {
                    n6 = n7;
                }
                if (n7 <= n2) continue;
                n2 = n7;
                if (!bl2) continue;
            }
            if (n6 != 0) {
                n5 = 0;
                while (n5 < this.d.length) {
                    int[] arrn = this.d;
                    int n8 = n5++;
                    arrn[n8] = arrn[n8] - n6;
                    if (!bl2) {
                        if (!bl2) continue;
                    }
                    break block5;
                }
                n2 -= n6;
            }
        }
        n3 = n2;
        n4 = 1;
        return n3 + n4;
    }

    private static void a(int n2, int n3, int n4, int n5, J j2) {
        int n6;
        int n7 = n3 + n5;
        int n8 = (n3 & n5 | (n3 | n5) & ~ n7) >>> 31;
        j2.a = n6 = n2 + n4 + n8;
        j2.b = n7;
    }

    private static void b(int n2, int n3, int n4, int n5, J j2) {
        int n6;
        int n7 = n3 - n5;
        int n8 = (~ n3 & n5 | ~ (n3 ^ n5) & n7) >>> 31;
        j2.a = n6 = n2 - n4 - n8;
        j2.b = n7;
    }

    private static void a(int n2, int n3, J j2) {
        int n4;
        int n5 = ~ n3 + 1;
        int n6 = (~ n3 & ~ n5) >>> 31;
        j2.a = n4 = ~ n2 + n6;
        j2.b = n5;
    }
}

