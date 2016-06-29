/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.A;
import y.c.C;
import y.c.D;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.x;
import y.d.t;
import y.f.X;
import y.f.ae;
import y.f.f.b.i;
import y.f.f.b.j;
import y.f.f.b.n;
import y.f.f.b.o;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;
import y.f.h.r;

public class h {
    private D b;
    private static double c = 0.001;
    private N d;
    private y.f.h.D e;
    private y.c.h f;
    private A g;
    private boolean h;
    public static int a;

    public h(y.c.i i2) {
        this(new N(i2));
        this.h = true;
    }

    /*
     * Unable to fully structure code
     */
    public h(N var1_1) {
        super();
        this.d = var1_1;
        if (!(this.d instanceof y.f.h.D)) ** GOTO lbl-1000
        this.e = (y.f.h.D)this.d;
        if (h.a != 0) lbl-1000: // 2 sources:
        {
            this.e = null;
            this.g = this.a().t();
        }
        this.b = new D();
        this.f = this.a().u();
    }

    public h(y.f.h.D d2) {
        this((N)d2);
    }

    public y.c.i a() {
        return this.d.g();
    }

    public N b() {
        return this.d;
    }

    public d a(d d2) {
        return this.d.h(d2);
    }

    public void a(d d2, d d3) {
        this.d.b(d2, d3);
    }

    public q c() {
        return this.d.h();
    }

    public void a(p p2) {
        this.d.b(p2);
    }

    public p d() {
        return this.d.i();
    }

    public int e() {
        return this.d.j();
    }

    public p b(d d2) {
        return this.d.i(d2);
    }

    public void f() {
        this.d.l();
    }

    public r g() {
        return this.d.m();
    }

    public void a(r r2) {
        this.d.a(r2);
    }

    public boolean h() {
        return this.d.n();
    }

    public boolean c(d d2) {
        return this.d.n(d2);
    }

    protected void a(y.c.q q2, int n2) {
        if (this.e == null) {
            this.j(q2).a(n2);
            if (a == 0) return;
        }
        this.e.a(q2, n2);
    }

    protected int a(y.c.q q2) {
        if (this.e != null) return this.e.a(q2);
        return this.j(q2).a();
    }

    public boolean b(y.c.q q2) {
        if (this.a(q2) != 1) return false;
        return true;
    }

    public void c(y.c.q q2) {
        this.a(q2, 1);
    }

    public boolean d(y.c.q q2) {
        if (this.a(q2) != 0) return false;
        return true;
    }

    public void e(y.c.q q2) {
        this.a(q2, 0);
    }

    public void f(y.c.q q2) {
        this.a(q2, 2);
    }

    public boolean g(y.c.q q2) {
        if (this.a(q2) != 2) return false;
        return true;
    }

    public void a(d d2, int n2) {
        this.q(d2).a(n2);
    }

    public void a(d d2, double d3) {
        this.q(d2).a((int)Math.floor(d3 + c));
    }

    public int d(d d2) {
        return this.q(d2).a();
    }

    public String e(d d2) {
        return this.q(d2).b();
    }

    public void a(d d2, String string) {
        this.q(d2).a(string);
    }

    public void a(d d2, char c2) {
        char[] arrc = new char[]{c2};
        this.q(d2).a(new String(arrc));
    }

    public void a(d d2, o o2) {
        this.q(d2).a(o2.toString());
    }

    public void f(d d2) {
        d d3 = this.a(d2);
        String string = this.e(d2);
        if (string == null) {
            this.a(d3, (String)null);
            if (a == 0) return;
        }
        this.a(d3, h.a(string));
    }

    public static String a(String string) {
        o o2;
        StringBuffer stringBuffer;
        int n2 = a;
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int n3 = string.length() - 1; n3 >= 0; o2 = o2.c(), --n3) {
            o2 = o.a(string.charAt(n3));
            stringBuffer = stringBuffer2.append(o2.toString());
            if (n2 != 0) return stringBuffer.toString();
            if (n2 == 0) continue;
        }
        stringBuffer = stringBuffer2;
        return stringBuffer.toString();
    }

    /*
     * Unable to fully structure code
     */
    public void a(y.c.h var1_1, d var2_2, o var3_3) {
        block15 : {
            var21_4 = h.a;
            var5_5 = new boolean[this.e()];
            var6_6 = new d[this.e()];
            var7_7 = this.g();
            var8_8 = 0;
            var9_9 = this.c();
            while (var9_9.f()) {
                var10_10 = var9_9.a();
                var7_7.a((p)var10_10, var8_8);
                var6_6[var8_8] = null;
                var5_5[var8_8] = false;
                ++var8_8;
                var9_9.g();
                if (var21_4 == 0) {
                    if (var21_4 == 0) continue;
                }
                break block15;
            }
            var9_9 = this.c();
        }
        var10_10 = this.a(var2_2);
        var11_11 = this.b((d)var10_10);
        this.a(this.a((d)var10_10), var3_3.toString());
        var6_6[var7_7.a((Object)var11_11)] = var10_10;
        var4_13 = var11_11;
        for (var12_12 = 0; var12_12 < this.e(); ++var12_12) {
            do {
                if (var21_4 != 0) return;
                if (!var5_5[var7_7.a(var4_13)] && var6_6[var7_7.a(var4_13)] != null) break;
                var9_9.g();
                if (!var9_9.f()) {
                    var9_9 = this.c();
                }
                var4_13 = var9_9.a();
            } while (var21_4 == 0);
            var13_14 = var6_6[var7_7.a(var4_13)];
            var14_15 = o.a(this.e(this.a(var13_14)).charAt(0));
            var14_15 = var14_15.c();
            var15_16 = var4_13.a();
            while (var15_16.a() != var13_14) {
                var15_16.g();
                if (var21_4 == 0) {
                    if (var21_4 == 0) continue;
                }
                ** GOTO lbl46
            }
            var10_10 = var13_14;
            block4 : do {
                var15_16.b();
                var13_14 = var15_16.a();
lbl46: // 2 sources:
                var16_17 = var14_15;
                var16_17 = var16_17.c();
                var16_17 = var16_17.b(this.d(var13_14));
                var17_18 = (String)var1_1.b(var13_14);
                var18_19 = null;
                if (var17_18.length() > 0) {
                    var19_20 = new StringBuffer(var16_17.toString());
                    var20_21 = 0;
                    block5 : do {
                        v0 = var20_21;
                        v1 = var17_18.length();
                        while (v0 < v1) {
                            v0 = var17_18.charAt(var20_21);
                            v1 = 60;
                            if (var21_4 != 0) continue;
                            if (v0 == v1) {
                                var16_17 = var16_17.b();
                            }
                            if (var17_18.charAt(var20_21) == '>') {
                                var16_17 = var16_17.a();
                            }
                            var19_20.append(var16_17.toString());
                            ++var20_21;
                            if (var21_4 == 0) continue block5;
                        }
                        break block5;
                        break;
                    } while (true);
                    var18_19 = var19_20.toString();
                } else {
                    var18_19 = var16_17.toString();
                }
                this.a(var13_14, var18_19);
                var6_6[var7_7.a((Object)this.b((d)this.a((d)var13_14)))] = this.a(var13_14);
                var14_15 = o.a(var18_19.charAt(var18_19.length() - 1));
                do {
                    if (var13_14 != var10_10) continue block4;
                    var5_5[var7_7.a((Object)var4_13)] = true;
                } while (var21_4 != 0);
                break;
            } while (true);
            if (var21_4 == 0) continue;
        }
        this.a(var7_7);
    }

    public int[] h(y.c.q q2) {
        int[] arrn;
        int n2 = a;
        int[] arrn2 = new int[]{0, 0, 0, 0};
        e e2 = q2.l();
        while (e2.f()) {
            d d2 = e2.a();
            o o2 = o.a(this.e(d2).charAt(0));
            arrn = arrn2;
            if (n2 != 0) return arrn;
            int n3 = o2.f();
            arrn[n3] = arrn[n3] + 1;
            e2.g();
            if (n2 == 0) continue;
        }
        arrn = arrn2;
        return arrn;
    }

    /*
     * Unable to fully structure code
     */
    public int[][] i(y.c.q var1_1) {
        var6_2 = h.a;
        var2_3 = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        var3_4 = var1_1.l();
        do {
            if (var3_4.f() == false) return var2_3;
            var4_5 = var3_4.a();
            var5_6 = o.a(this.e(var4_5).charAt(0));
            if (!this.d(var4_5.d()) && !this.b(var4_5.d())) ** GOTO lbl12
            v0 = var2_3[var5_6.f()];
            v0[1] = v0[1] + 1;
            if (var6_2 == 0) ** GOTO lbl21
lbl12: // 2 sources:
            if (this.d(this.a(var4_5)) != 1) ** GOTO lbl16
            v1 = var2_3[var5_6.f()];
            v1[0] = v1[0] + 1;
            if (var6_2 == 0) ** GOTO lbl21
lbl16: // 2 sources:
            if (this.d(this.a(var4_5)) != 3) ** GOTO lbl-1000
            v2 = var2_3[var5_6.f()];
            v2[2] = v2[2] + 1;
            if (var6_2 != 0) lbl-1000: // 2 sources:
            {
                y.g.o.a((Object)new StringBuffer().append("Cannot classify edge : ").append(var4_5).toString());
            }
lbl21: // 5 sources:
            var3_4.g();
        } while (var6_2 == 0);
        return var2_3;
    }

    public int g(d d2) {
        o o2 = o.a(this.e(d2).charAt(0));
        return o2.f();
    }

    public o h(d d2) {
        return o.a(this.e(d2).charAt(0));
    }

    public int i(d d2) {
        i i2 = this.q(d2);
        return i2.c();
    }

    public boolean j(d d2) {
        i i2 = this.q(d2);
        if (i2.c() == Integer.MIN_VALUE) return false;
        return true;
    }

    public void b(d d2, int n2) {
        i i2 = this.q(d2);
        i2.b(n2);
    }

    public double k(d d2) {
        i i2 = this.q(d2);
        return i2.d();
    }

    public void b(d d2, double d3) {
        i i2 = this.q(d2);
        i2.a(d3);
    }

    public void c(d d2, int n2) {
        i.a(this.q(d2), n2);
    }

    public void d(d d2, int n2) {
        i.b(this.q(d2), n2);
    }

    public int l(d d2) {
        return i.a(this.q(d2));
    }

    public int m(d d2) {
        return i.b(this.q(d2));
    }

    public void a(n n2) {
        this.b.add(n2);
    }

    public C i() {
        return this.b.m();
    }

    public f e(d d2, int n2) {
        int n3 = a;
        y.f.h.D d3 = (y.f.h.D)this.b();
        if (this.e(d2).length() != 1) {
            throw new RuntimeException(new StringBuffer().append("Shape not simple: ").append(this.e(d2)).toString());
        }
        o o2 = this.h(d2);
        o o3 = o2.c();
        int n4 = this.d(d2);
        int n5 = this.d(this.a(d2));
        f f2 = d3.a(d2, n2);
        e e2 = f2.a();
        do {
            d d4;
            block8 : {
                block7 : {
                    if (!e2.f()) return f2;
                    d4 = e2.a();
                    this.a(d4, o2);
                    this.a(this.a(d4), o3);
                    if (d4.d() != d2.d()) {
                        this.a(this.a(d4), 2);
                        if (n3 == 0) break block7;
                    }
                    this.a(this.a(d4), n5);
                }
                if (d4.c() != d2.c()) {
                    this.a(d4, 2);
                    if (n3 == 0) break block8;
                }
                this.a(d4, n4);
            }
            if (d4.d() != d2.d()) {
                this.e(d4.d());
            }
            e2.g();
        } while (n3 == 0);
        return f2;
    }

    /*
     * Unable to fully structure code
     */
    public void n(d var1_1) {
        var14_2 = h.a;
        if (this.d.n(var1_1)) {
            throw new IllegalArgumentException(new StringBuffer().append("Edge: ").append(var1_1).append(" is inserted !").toString());
        }
        var2_3 = this.e(var1_1);
        if (var2_3.length() == 1) {
            return;
        }
        var3_4 = this.a(var1_1);
        var4_5 = this.e(var3_4);
        var5_6 = (y.f.h.D)this.b();
        var6_7 = var5_6.a(var1_1, var2_3.length() - 1);
        var7_8 = 0;
        var8_9 = var6_7.a();
        do {
            if (var8_9.f() == false) return;
            var9_10 = var8_9.a();
            var10_11 = this.a(var9_10);
            var11_12 = var9_10.d();
            if (var7_8 != 0) ** GOTO lbl-1000
            this.a(var9_10, this.d(var1_1));
            if (var14_2 != 0) lbl-1000: // 2 sources:
            {
                var12_13 = o.a(var2_3.charAt(var7_8 - 1)).f();
                var13_14 = o.a(var2_3.charAt(var7_8)).f();
                this.a(var9_10, o.a(var12_13 - var13_14).f());
            }
            if (var7_8 != var2_3.length() - 1) ** GOTO lbl-1000
            this.a(var10_11, this.d(var3_4));
            if (var14_2 != 0) lbl-1000: // 2 sources:
            {
                var12_13 = o.a(var4_5.charAt(var4_5.length() - var7_8 - 2)).f();
                var13_14 = o.a(var4_5.charAt(var4_5.length() - var7_8 - 1)).f();
                this.a(var10_11, o.a(var12_13 - var13_14).f());
                this.f(var11_12);
                var5_6.d(var11_12);
            }
            if (var2_3.charAt(var7_8) != '+') {
                this.a(var9_10, var2_3.charAt(var7_8));
            }
            if (var4_5.charAt(var4_5.length() - var7_8 - 1) != '+') {
                this.a(var10_11, var4_5.charAt(var4_5.length() - var7_8 - 1));
            }
            ++var7_8;
            var8_9.g();
        } while (var14_2 == 0);
    }

    /*
     * Exception decompiling
     */
    public void j() {
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

    /*
     * Unable to fully structure code
     */
    public void k() {
        var16_1 = h.a;
        var1_2 = (X)this.a();
        var2_3 = (y.f.h.D)this.b();
        var3_4 = var1_2.o();
        while (var3_4.f()) {
            var4_5 = var3_4.e();
            if (var16_1 != 0) return;
            if (!this.g(var4_5)) ** GOTO lbl37
            var5_6 = var4_5.l();
            var6_7 = var5_6.a();
            var5_6.g();
            var7_8 = var5_6.a();
            var8_9 = var2_3.h(var6_7);
            var9_10 = var2_3.h(var7_8);
            var10_11 = var1_2.p(var8_9);
            var11_12 = var1_2.q(var7_8);
            var12_13 = var1_2.l(var4_5);
            var13_14 = var1_2.k(var8_9);
            var13_14.add(var12_13);
            var13_14.a(var1_2.k(var7_8));
            var14_15 = var2_3.h(var4_5);
            var15_16 = var2_3.h(var14_15);
            if (var14_15.c() != var8_9.c() || var14_15.d() != var7_8.d()) ** GOTO lbl-1000
            var1_2.c(var14_15, var10_11);
            var1_2.d(var14_15, var11_12);
            var1_2.b(var14_15, var13_14);
            ae.a(var1_2, var15_16, var14_15);
            if (var16_1 != 0) lbl-1000: // 2 sources:
            {
                if (var14_15.c() != var9_10.c()) throw new RuntimeException("Error in remove bend");
                if (var14_15.d() != var6_7.d()) throw new RuntimeException("Error in remove bend");
                var1_2.c(var15_16, var10_11);
                var1_2.d(var15_16, var11_12);
                var1_2.b(var15_16, var13_14);
                ae.a(var1_2, var14_15, var15_16);
                if (var16_1 != 0) {
                    throw new RuntimeException("Error in remove bend");
                }
            }
lbl37: // 5 sources:
            var3_4.g();
            if (var16_1 == 0) continue;
        }
        var2_3.k();
    }

    /*
     * Unable to fully structure code
     */
    public void l() {
        block24 : {
            block22 : {
                var10_1 = h.a;
                y.g.o.a(this, (Object)"Check if all necessary data is set..");
                var1_2 = this.a().p();
                while (var1_2.f()) {
                    var2_3 = var1_2.a();
                    v0 = this.e(var2_3);
                    if (var10_1 == 0) {
                        if (v0 == null) {
                            throw new RuntimeException("Null shape !");
                        }
                        if (this.e(var2_3).length() == 0) {
                            throw new RuntimeException("Empty shape !");
                        }
                        if (this.d(var2_3) < 0) throw new RuntimeException("Angle out of bounds !");
                        if (this.d(var2_3) > 4) {
                            throw new RuntimeException("Angle out of bounds !");
                        }
                        var1_2.g();
                        if (var10_1 == 0) continue;
                    }
                    ** GOTO lbl23
                }
                y.g.o.a(this, 0, "Check if reverse directions are compatible..");
                var1_2 = this.a().p();
                while (var1_2.f()) {
                    var2_5 = var1_2.a();
                    v0 = this.e(var2_5);
lbl23: // 2 sources:
                    var3_12 = v0;
                    var4_15 = h.a((String)var3_12);
                    if (var10_1 == 0) {
                        if (!var4_15.equals(h.a((String)var3_12))) {
                            throw new RuntimeException(new StringBuffer().append("Shapes are not compatible for ").append(var2_4).append(" !").toString());
                        }
                        var1_2.g();
                        if (var10_1 == 0) continue;
                    }
                    break block22;
                }
                y.g.o.a(this, 0, "Check if sum of angles around a node is four..");
            }
            var1_2 = this.a().o();
            while (var1_2.f()) {
                var2_7 = var1_2.e();
                var3_13 = 0;
                v1 = var2_7.c();
                if (var10_1 == 0) {
                    block23 : {
                        if (v1 == 0) {
                            var3_13 = 4;
                        }
                        var4_15 = var2_7.l();
                        while (var4_15.f()) {
                            var3_13 += this.d(var4_15.a());
                            var4_15.g();
                            if (var10_1 == 0) {
                                if (var10_1 == 0) continue;
                            }
                            break block23;
                        }
                        if (var3_13 != 4) {
                            throw new RuntimeException(new StringBuffer().append("Node [").append(var2_7).append("] has anglesum != 4 (").append(var3_13).append(") !").toString());
                        }
                        var1_2.g();
                    }
                    if (var10_1 == 0) continue;
                }
                ** GOTO lbl58
            }
            y.g.o.a(this, 0, "Check if angles are compatible with shape..");
            var1_2 = this.a().o();
            block4 : do {
                v1 = (int)var1_2.f() ? 1 : 0;
lbl58: // 3 sources:
                block5 : while (v1 != 0) {
                    var2_9 = var1_2.e();
                    if (var10_1 != 0) break block24;
                    var3_12 = var2_9.l();
                    while (var3_12.f()) {
                        var4_15 = var3_12.a();
                        var5_16 = this.d.j((d)var4_15);
                        var6_17 = this.g((d)var4_15);
                        var7_18 = this.g(var5_16);
                        var8_19 = this.d(var5_16);
                        v1 = var9_20 = (var7_18 - var6_17) % 4;
                        if (var10_1 != 0) continue block5;
                        if (v1 < 0) {
                            var9_20 += 4;
                        }
                        if (var9_20 != var8_19 % 4) {
                            throw new RuntimeException(new StringBuffer().append("Angle <-> shape inconsistency ( ").append(var4_15).append("[").append(this.e((d)var4_15)).append("],  ").append(var5_16).append("[").append(this.e(var5_16)).append("], angle field ").append(var8_19).append(", shape: ").append(var9_20).append(" )").append(" !").toString());
                        }
                        var3_12.g();
                        if (var10_1 == 0) continue;
                    }
                    var1_2.g();
                    if (var10_1 == 0) continue block4;
                }
                break block4;
                break;
            } while (true);
            y.g.o.a(this, 0, "Check if outer face is set correctly..");
        }
        if (this.d() == null) {
            throw new RuntimeException("No outer face defined !");
        }
        var1_2 = this.d();
        var2_10 = false;
        var3_14 = this.c();
        while (var3_14.f()) {
            var4_15 = var3_14.a();
            if (var10_1 != 0) return;
            if (var1_2 == var4_15) {
                var2_11 = true;
            }
            var3_14.g();
            if (var10_1 == 0) continue;
        }
        if (var2_11 != false) return;
        throw new RuntimeException(new StringBuffer().append("Non existing face set to outer face : ").append(var1_2).toString());
    }

    public void m() {
        int n2 = a;
        e e2 = this.a().p();
        do {
            if (!e2.f()) return;
            d d2 = e2.a();
            if (this.e(d2) == null) {
                throw new RuntimeException("Null shape !");
            }
            if (this.e(d2).length() != 1) {
                throw new RuntimeException("non-simple shape !");
            }
            e2.g();
        } while (n2 == 0);
    }

    public void n() {
        int n2 = a;
        this.m();
        q q2 = this.c();
        do {
            int n3;
            int n4;
            p p2;
            block5 : {
                if (!q2.f()) return;
                p2 = q2.a();
                n3 = 0;
                n4 = 0;
                e e2 = p2.a();
                while (e2.f()) {
                    n3 += this.d(e2.a());
                    ++n4;
                    e2.g();
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block5;
                }
                if (this.d() != p2 && n3 != 2 * n4 - 4) {
                    throw new RuntimeException(new StringBuffer().append("Inner Face ( ").append(p2).append(" ) has wrong angle sum (").append(n3).append(" != ").append(2 * n4 - 4).append(" ) !").toString());
                }
            }
            if (this.d() == p2 && n3 != 2 * n4 + 4) {
                throw new RuntimeException(new StringBuffer().append("Outer Face ( ").append(p2).append(" ) has wrong angle sum (").append(n3).append(" != ").append(2 * n4 + 4).append(" ) !").toString());
            }
            q2.g();
        } while (n2 == 0);
    }

    public void o() {
        if (this.h()) return;
        throw new RuntimeException("Graph is not planar !");
    }

    protected boolean o(d d2) {
        d d3 = this.d.j(this.d.h(d2));
        int n2 = this.d(d3);
        if (n2 == 1) {
            return true;
        }
        if (n2 != 3) throw new RuntimeException(new StringBuffer().append("Undefined Angle: ").append(n2).toString());
        return false;
    }

    protected boolean p(d d2) {
        d d3 = this.d.k(d2);
        if (!this.d(d2.c())) {
            return false;
        }
        if (!this.g(d2.d())) return false;
        if (!this.g(d3.d())) {
            return false;
        }
        if (this.d(d2) != 0) return false;
        if (!this.o(d3)) return false;
        if (this.o(d2)) return false;
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean[] p() {
        block14 : {
            var9_1 = h.a;
            var1_2 = new boolean[this.a().g()];
            var2_3 = this.a().o();
            block0 : do {
                v0 = var2_3.f();
                block1 : while (v0) {
                    var3_4 = var2_3.e();
                    v1 = this;
                    if (var9_1 != 0) break block14;
                    if (!v1.d((y.c.q)var3_4)) ** GOTO lbl33
                    var4_5 = var3_4.l();
                    while (var4_5.f()) {
                        var5_6 = var4_5.a();
                        v0 = this.g(var5_6.d());
                        if (var9_1 != 0) continue block1;
                        if (!v0) ** GOTO lbl31
                        var6_7 = this.d.j((d)var5_6);
                        var7_8 = this.d.k((d)var5_6);
                        if (this.d(var6_7) != 0) ** GOTO lbl25
                        if (this.g(var6_7.d())) ** GOTO lbl-1000
                        var1_2[var5_6.b()] = true;
                        if (var9_1 != 0) lbl-1000: // 2 sources:
                        {
                            if (this.o(var6_7) && this.o((d)var5_6)) {
                                var1_2[var5_6.b()] = true;
                            }
                        }
lbl25: // 6 sources:
                        if (this.d((d)var5_6) != 0) ** GOTO lbl31
                        if (this.g(var7_8.d())) ** GOTO lbl-1000
                        var1_2[var5_6.b()] = true;
                        if (var9_1 != 0) lbl-1000: // 2 sources:
                        {
                            if (!this.o(var7_8) && !this.o((d)var5_6)) {
                                var1_2[var5_6.b()] = true;
                            }
                        }
lbl31: // 7 sources:
                        var4_5.g();
                        if (var9_1 == 0) continue;
                    }
lbl33: // 3 sources:
                    var2_3.g();
                    if (var9_1 == 0) continue block0;
                }
                break block0;
                break;
            } while (true);
            v1 = this;
        }
        var2_3 = v1.d.h();
        do {
            v2 = var2_3.f();
            block4 : do {
                block15 : {
                    if (v2 == false) return var1_2;
                    var3_4 = var2_3.a();
                    var4_5 = null;
                    var5_6 = var3_4.a();
                    while (var5_6.f()) {
                        var4_5 = var5_6.a();
                        v3 = this.d(var4_5.c());
                        if (var9_1 == 0) {
                            if (v3 != false ? this.p((d)var4_5) == false : this.d(var4_5.d()) == false) break;
                            var5_6.g();
                            if (var9_1 == 0) continue;
                        }
                        break block15;
                    }
                    v3 = var5_6.f();
                }
                if (!v3) ** GOTO lbl-1000
                var5_6.b();
                if (var9_1 != 0) lbl-1000: // 2 sources:
                {
                    var5_6.i();
                }
                while (var5_6.a() != var4_5) {
                    var6_7 = var5_6.a();
                    var7_8 = this.d.k(var6_7);
                    v2 = this.p(var6_7);
                    if (var9_1 != 0) continue block4;
                    if (!v2) ** GOTO lbl70
                    var8_9 = this.d.h(this.d.j(this.d.h(var7_8)));
                    if (!var1_2[var8_9.b()]) ** GOTO lbl-1000
                    var1_2[var6_7.b()] = true;
                    if (var9_1 != 0) lbl-1000: // 2 sources:
                    {
                        var1_2[var7_8.b()] = true;
                    }
lbl70: // 4 sources:
                    var5_6.b();
                    if (var9_1 == 0) continue;
                }
                break block4;
                break;
            } while (true);
            var2_3.g();
        } while (var9_1 == 0);
        return var1_2;
    }

    public void q() {
        this.a().a(this.f);
        if (this.e == null) {
            this.a().a(this.g);
        }
        if (!this.h) return;
        this.d.e();
    }

    protected j j(y.c.q q2) {
        j j2 = (j)this.g.b(q2);
        if (j2 != null) return j2;
        j2 = this.r();
        this.g.a((Object)q2, j2);
        return j2;
    }

    protected j r() {
        return new j();
    }

    protected i q(d d2) {
        i i2 = (i)this.f.b(d2);
        if (i2 != null) return i2;
        i2 = this.s();
        this.f.a((Object)d2, i2);
        return i2;
    }

    protected i s() {
        return new i(this);
    }
}

