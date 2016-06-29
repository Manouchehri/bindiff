/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import y.c.D;
import y.d.e;
import y.d.m;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.v;
import y.d.y;
import y.d.z;
import y.f.B;
import y.f.C;
import y.f.I;
import y.f.ae;
import y.f.am;
import y.h.fj;
import y.h.gv;
import y.h.hB;

class ik {
    private double a = 5.0;
    private boolean b = true;
    private boolean c = false;
    private double d = 0.0;
    private byte e = 0;
    private boolean f = false;
    private static final z g = new z(1.0, 0.0);

    public byte a() {
        return this.e;
    }

    public void a(byte by2) {
        this.e = by2;
    }

    public double b() {
        return this.a;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public boolean c() {
        return this.b;
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public boolean d() {
        return this.c;
    }

    public void b(boolean bl2) {
        this.c = bl2;
    }

    public double e() {
        return this.d;
    }

    public void b(double d2) {
        this.d = d2;
    }

    public boolean f() {
        return this.f;
    }

    public void c(boolean bl2) {
        this.f = bl2;
    }

    /*
     * Unable to fully structure code
     */
    public n a(q var1_1, I var2_2, am var3_3, am var4_4, gv var5_5) {
        block11 : {
            var32_6 = fj.z;
            var6_7 = var5_5.a();
            var7_8 = var5_5.b();
            var9_9 = new n(new t(0.0, 0.0), var1_1);
            var9_9.a(6.283185307179586 - this.d);
            var10_10 = ae.a(var2_2, var3_3, var4_4, 0.0);
            if (var10_10.h() >= 2 && (var10_10.h() != 2 || t.a(var10_10.c(), var10_10.d()) >= 1.0E-4)) ** GOTO lbl17
            if (var10_10.h() >= 2) ** GOTO lbl-1000
            var11_11 = var9_9.h();
            var9_9.e(var3_3.getX() + var11_11.a * 0.5, var3_3.getY() + var11_11.b * 0.5);
            if (var32_6) lbl-1000: // 2 sources:
            {
                var11_12 = var10_10.c();
                var9_9.e(var11_12.a, var11_12.b);
            }
            if (this.d() == false) return var9_9;
            ae.b(var9_9);
            return var9_9;
lbl17: // 1 sources:
            if (var6_7 < 0) {
                var11_13 = Math.max(0, var10_10.h() - 1 + var6_7);
                if (!var32_6) break block11;
            }
            var11_14 = Math.min(var10_10.h() - 2, var6_7);
        }
        if ((var12_15 = var10_10.a(var11_14)) == null) {
            var13_16 = var9_9.h();
            var9_9.e(var3_3.getX() + var13_16.a * 0.5, var3_3.getY() + var13_16.b * 0.5);
            if (this.d() == false) return var9_9;
            ae.b(var9_9);
            return var9_9;
        }
        var13_17 = var12_15.c();
        var14_18 = var12_15.d();
        if (var12_15.g() != 0.0) ** GOTO lbl39
        var15_19 = var3_3.getX() + var3_3.getWidth() * 0.5 + var2_2.getSourcePoint().a - (var4_4.getX() + var4_4.getWidth() * 0.5 + var2_2.getTargetPoint().a);
        var17_20 = var3_3.getY() + var3_3.getHeight() * 0.5 + var2_2.getSourcePoint().b - (var4_4.getY() + var4_4.getHeight() * 0.5 + var2_2.getTargetPoint().b);
        if (var15_19 != 0.0 || var17_20 != 0.0) ** GOTO lbl-1000
        var14_18 = new t(var13_17.a + 1.0E-6, var13_17.b);
        if (var32_6) lbl-1000: // 2 sources:
        {
            var19_22 = Math.sqrt(var15_19 * var15_19 + var17_20 * var17_20);
            var14_18 = new t(var13_17.a + 1.0E-6 * var15_19 / var19_22, var13_17.b + 1.0E-6 * var17_20 / var19_22);
        }
        var12_15 = new m(var13_17, var14_18);
lbl39: // 2 sources:
        if (this.b) {
            var9_9.a(ik.c(z.d(var12_15.i(), ik.g) - this.d));
        }
        var15_19 = Math.abs(var5_5.c());
        var17_21 = new n(var9_9);
        this.a(var17_21, var12_15, var13_17, var15_19);
        if (var11_14 == 0 && this.a(var3_3, var17_21)) {
            this.b(var17_21, var12_15, var3_3, var15_19);
        }
        var18_25 = new n(var9_9);
        this.a(var18_25, var12_15, var14_18, var15_19);
        if (var11_14 >= var10_10.h() - 2 && this.a(var4_4, var18_25)) {
            this.a(var18_25, var12_15, var4_4, var15_19);
        }
        if (t.a(var17_21.a(), var18_25.a()) < 1.0E-4) {
            var19_23 = var12_15.i();
            var19_23.c();
            var18_25.d(var19_23.a(), var19_23.b());
        }
        if (0.0 <= var7_8 && var7_8 <= 1.0) ** GOTO lbl-1000
        var20_26 = var18_25.b() - var17_21.b();
        var24_28 = Math.sqrt(var20_26 * var20_26 + (var22_27 = var18_25.c() - var17_21.c()) * var22_27);
        v0 = var26_29 = var24_28 != 0.0 ? var7_8 / var24_28 : 0.0;
        if (var7_8 >= 0.0) ** GOTO lbl-1000
        var28_30 = var17_21.b() + var26_29 * var20_26;
        var30_31 = var17_21.c() + var26_29 * var22_27;
        if (var32_6) lbl-1000: // 2 sources:
        {
            var28_30 = var18_25.b() + var26_29 * var20_26;
            var30_31 = var18_25.c() + var26_29 * var22_27;
        }
        var19_24 = new t(var28_30, var30_31);
        if (var32_6) lbl-1000: // 2 sources:
        {
            var19_24 = new t(var17_21.b() * (1.0 - var7_8) + var18_25.b() * var7_8, var17_21.c() * (1.0 - var7_8) + var18_25.c() * var7_8);
        }
        var9_9.a(var19_24);
        if (this.d() == false) return var9_9;
        ae.b(var9_9);
        return var9_9;
    }

    private gv g() {
        return this.a(0, 0.0);
    }

    private gv a(int n2, double d2) {
        return new gv(n2, d2, this.b(), this.f(), this.a(), this.e());
    }

    public D a(C c2, I i2, am am2, am am3, Object object) {
        D d2;
        boolean bl2;
        n[] arrn;
        Object object2;
        n[] arrn2;
        int n2;
        int n3;
        v v2;
        block15 : {
            bl2 = fj.z;
            d2 = new D();
            v2 = ae.a(i2, am2, am3, 0.0);
            if (v2.h() < 2 || v2.h() == 2 && v2.a(0).g() < 1.0E-4) {
                n n4;
                block14 : {
                    n4 = new n(c2.getOrientedBox());
                    if (v2.h() < 2) {
                        n4.e(am2.getX() + n4.e() * 0.5, am2.getY() - n4.f() * 0.5);
                        if (!bl2) break block14;
                    }
                    n4.e(v2.c().a, v2.c().b);
                }
                if (this.d()) {
                    ae.b(n4);
                }
                d2.add(new B(n4, this.g(), c2, false));
                return d2;
            }
            double d3 = c2.getModelParameter() == null ? this.b() : ((gv)object).c();
            arrn = new n[v2.h() - 1];
            arrn2 = new n[v2.h() - 1];
            for (n3 = 0; n3 < v2.h() - 1; ++n3) {
                arrn[n3] = new n(0.0, 0.0, 0.0, 0.0);
                arrn2[n3] = new n(0.0, 0.0, 0.0, 0.0);
                this.a(v2, n3, c2.getOrientedBox().d(), i2, am2, am3, arrn[n3], arrn2[n3], d3);
                n2 = (int)(t.a(arrn[n3].a(), arrn2[n3].a()) DCMPG 1.0E-4);
                if (!bl2) {
                    if (n2 < 0) {
                        object2 = v2.a(n3).i();
                        object2.c();
                        arrn2[n3].d(object2.a(), object2.b());
                    }
                    if (!this.d()) continue;
                    ae.b(arrn[n3]);
                    ae.b(arrn2[n3]);
                    if (!bl2) continue;
                }
                break block15;
            }
            n2 = 0;
        }
        n3 = n2;
        do {
            Object object3;
            double[] arrd;
            int n5;
            block17 : {
                double d4;
                int n6;
                boolean bl3;
                double d5;
                block16 : {
                    if (n3 >= v2.h() - 1) return d2;
                    object2 = arrn[n3].k();
                    t t2 = arrn2[n3].k();
                    d5 = t2.a() - object2.a();
                    d4 = t2.b() - object2.b();
                    n5 = n3 > (v2.h() - 2) / 2 ? n3 + 1 - v2.h() : n3;
                    bl3 = v2.h() == 2;
                    arrd = this.a(n3, v2, arrn, arrn2);
                    if (arrd[0] > 0.0) {
                        gv gv2 = this.a(n5, arrd[0]);
                        d2.add(new B(arrn[n3].f(d5 * arrd[0], d4 * arrd[0]), gv2, c2));
                        if (!bl2) break block16;
                    }
                    d2.add(new B(arrn[n3], this.a(n5, 0.0), c2));
                }
                int n7 = n6 = bl3 ? -1 : n5;
                if (arrd[1] < 1.0) {
                    object3 = this.a(n6, arrd[1]);
                    d2.add(new B(arrn[n3].f(d5 * arrd[1], d4 * arrd[1]), object3, c2));
                    if (!bl2) break block17;
                }
                d2.add(new B(arrn2[n3], this.a(n6, 1.0), c2));
            }
            if (arrd[0] < 0.5 && arrd[1] > 0.5) {
                object3 = new n(arrn[n3]);
                t t3 = t.c(arrn2[n3].k(), (t)object2);
                object3.b(t3);
                if (this.d()) {
                    ae.b((n)object3);
                }
                d2.add(new B((n)object3, this.a(n5, 0.5), c2));
            }
            ++n3;
        } while (!bl2);
        return d2;
    }

    private static double c(double d2) {
        double d3;
        boolean bl2 = fj.z;
        if (d2 < 0.0) {
            d2 += 6.283185307179586;
        }
        while (d2 > 6.283185307179586) {
            d3 = d2 - 6.283185307179586;
            if (bl2) return d3;
            d2 = d3;
            if (!bl2) continue;
        }
        d3 = d2;
        return d3;
    }

    private static byte a(m m2) {
        double d2 = z.d(m2.i(), g);
        if (d2 >= 0.7853981633974483 && d2 < 2.356194490192345) {
            return 0;
        }
        if (d2 >= 2.356194490192345 && d2 < 3.9269908169872414) {
            return 2;
        }
        if (d2 < 3.9269908169872414) return 3;
        if (d2 >= 5.497787143782138) return 3;
        return 1;
    }

    private static byte b(m m2) {
        double d2 = z.d(m2.i(), g);
        if (d2 >= 0.7853981633974483 && d2 < 2.356194490192345) {
            if (d2 > 1.5707963267948966) return 2;
            return 3;
        }
        if (d2 >= 2.356194490192345 && d2 < 3.9269908169872414) {
            if (d2 > 3.141592653589793) return 1;
            return 0;
        }
        if (d2 >= 3.9269908169872414 && d2 < 5.497787143782138) {
            if (d2 > 4.71238898038469) return 3;
            return 2;
        }
        if (d2 > 3.141592653589793) return 1;
        return 0;
    }

    /*
     * Unable to fully structure code
     */
    private void a(n var1_1, m var2_2, t var3_3, double var4_4) {
        var12_5 = fj.z;
        if (0 == this.a()) {
            var1_1.e(var3_3.a, var3_3.b);
            if (var12_5 == false) return;
        }
        var6_6 = z.c(var2_2.i());
        if (2 == this.a()) {
            var6_6 = new z(- var6_6.a(), - var6_6.b());
        }
        var6_6.b(Math.abs(var4_4) + var1_1.e() + var1_1.f());
        var7_7 = z.a(var3_3, var6_6);
        var1_1.e(var7_7.a, var7_7.b);
        var8_8 = Double.MAX_VALUE;
        if (!this.f) ** GOTO lbl-1000
        var8_8 = ik.b(var2_2, var1_1.k());
        if (var12_5) lbl-1000: // 2 sources:
        {
            var10_9 = n.a(var1_1);
            for (var11_10 = 0; var11_10 < var10_9.length; ++var11_10) {
                var8_8 = Math.min(var8_8, ik.b(var2_2, var10_9[var11_10]));
                if (var12_5 != false) return;
                if (!var12_5) continue;
            }
        }
        var10_9 = new z(- var6_6.a(), - var6_6.b());
        var10_9.c();
        var10_9.b(var8_8 - Math.abs(var4_4));
        var7_7 = z.a(var7_7, (z)var10_9);
        var1_1.e(var7_7.a, var7_7.b);
    }

    private void a(n n2, m m2, am am2, double d2) {
        this.a(n2, m2.d(), m2.c(), am2, false, d2);
    }

    private void b(n n2, m m2, am am2, double d2) {
        this.a(n2, m2.c(), m2.d(), am2, true, d2);
    }

    private void a(n n2, t t2, t t3, am am2, boolean bl2, double d2) {
        y y2 = new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
        m m2 = new m(t2, t3);
        byte by2 = ik.a(m2);
        t t4 = this.a(by2, m2, n2, am2, bl2, d2);
        n2.a(t4);
        double d3 = ik.a(y2, n2);
        y y3 = n2.h();
        if (Math.abs(t2.a - t3.a) <= 1.0E-4) return;
        if (Math.abs(t2.b - t3.b) <= 1.0E-4) return;
        if (d3 >= 2.5) {
            if (d3 <= 6.0) return;
        }
        if (by2 != 0 && by2 != 1 || t3.a >= y2.c() - 5.0 - y3.a * 0.5 && t3.a <= y2.c() + y2.a() + 5.0 + y3.a * 0.5) {
            if (by2 != 2) {
                if (by2 != 3) return;
            }
            if (t3.b >= y2.d() - 5.0 - y3.b * 0.5) {
                if (t3.b <= y2.d() + y2.b() + 5.0 + y3.b * 0.5) return;
            }
        }
        boolean bl3 = true;
        boolean bl4 = bl3;
        if (!bl4) return;
        byte by3 = ik.b(m2);
        t t5 = this.a(by3, m2, n2, am2, bl2, d2);
        n2.a(t5);
        double d4 = ik.a(y2, n2);
        if (d4 >= 2.5) {
            if (d4 <= d3) return;
            if (d3 <= 2.5) return;
        }
        n2.a(t4);
    }

    private static double a(y y2, n n2) {
        return hB.a(y2, n2);
    }

    /*
     * Exception decompiling
     */
    private t a(byte var1_1, m var2_2, n var3_3, am var4_4, boolean var5_5, double var6_6) {
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

    private static double a(m m2, z z2, double d2) {
        double d3 = z.d(m2.i(), z2);
        if (d3 == 1.5707963267948966) {
            return d2;
        }
        if (d3 <= 1.5707963267948966) return d2 / Math.sin(d3);
        d3 = 3.141592653589793 - d3;
        return d2 / Math.sin(d3);
    }

    private static t a(t[] arrt, m m2) {
        return arrt[ik.b(arrt, m2)];
    }

    private static int b(t[] arrt, m m2) {
        int n2;
        boolean bl2 = fj.z;
        double d2 = Double.MAX_VALUE;
        int n3 = -1;
        for (int i2 = 0; i2 < arrt.length; ++i2) {
            double d3 = ik.b(m2, arrt[i2]);
            n2 = (int)(d3 DCMPG d2);
            if (bl2) return n2;
            if (n2 >= 0) continue;
            n3 = i2;
            d2 = d3;
            if (!bl2) continue;
        }
        n2 = n3;
        return n2;
    }

    private static double a(m m2, n n2) {
        double d2;
        double d3;
        t[] arrt;
        boolean bl2;
        block4 : {
            bl2 = fj.z;
            arrt = n.a(n2);
            double d4 = ik.a(m2, arrt[0]);
            if (d4 == 0.0) {
                return 0.0;
            }
            for (int i2 = 1; i2 < arrt.length; ++i2) {
                double d5;
                d3 = d5 = ik.a(m2, arrt[i2]);
                if (!bl2) {
                    if (d3 == 0.0) return 0.0;
                    if (d5 == d4) continue;
                    return 0.0;
                }
                break block4;
            }
            d3 = Double.MAX_VALUE;
        }
        double d6 = d3;
        for (int i3 = 0; i3 < arrt.length; ++i3) {
            d2 = Math.min(d6, ik.b(m2, arrt[i3]));
            if (bl2) return d2;
            d6 = d2;
            if (!bl2) continue;
        }
        d2 = d6;
        return d2;
    }

    private static double a(m m2, t t2) {
        t t3 = m2.c();
        t t4 = m2.d();
        double d2 = (t4.a() - t3.a()) * (t2.b() - t3.b()) - (t4.b() - t3.b()) * (t2.a() - t3.a());
        if (Double.isNaN(d2)) {
            return d2;
        }
        if (d2 > 0.0) {
            return 1.0;
        }
        if (d2 >= -0.0) return d2;
        return -1.0;
    }

    private static double b(m m2, t t2) {
        t t3 = m2.c();
        t t4 = m2.d();
        double d2 = t2.a - t3.a;
        double d3 = t2.b - t3.b;
        double d4 = t4.a - t3.a;
        double d5 = t4.b - t3.b;
        double d6 = d2 * d4 + d3 * d5;
        double d7 = d6 * d6 / (d4 * d4 + d5 * d5);
        double d8 = d2 * d2 + d3 * d3 - d7;
        if (d8 >= 0.0) return Math.sqrt(d8);
        d8 = 0.0;
        return Math.sqrt(d8);
    }

    /*
     * Unable to fully structure code
     */
    private double[] a(int var1_1, v var2_2, n[] var3_3, n[] var4_4) {
        var27_5 = fj.z;
        var5_6 = new double[]{0.0, 1.0};
        var6_7 = var2_2.f();
        var7_8 = Math.sqrt(var3_3[var1_1].f() * var3_3[var1_1].f() + var3_3[var1_1].e() * var3_3[var1_1].e());
        var9_9 = 30.0 + var7_8;
        var11_10 = t.a(var3_3[var1_1].k(), var4_4[var1_1].k());
        if (var1_1 <= 0) ** GOTO lbl34
        var13_11 = new z(var6_7[var1_1 + 1], var6_7[var1_1]);
        var14_13 = new z(var6_7[var1_1 - 1], var6_7[var1_1]);
        var15_14 = e.a(var3_3[var1_1 - 1].k(), var14_13, var3_3[var1_1].k(), var13_11);
        if (var15_14 == null) ** GOTO lbl34
        var16_15 = z.d(var13_11, var14_13);
        if ((this.a() != 1 || var16_15 >= 3.141592653589793) && (this.a() != 2 || var16_15 <= 3.141592653589793)) ** GOTO lbl-1000
        var18_16 = t.a(var6_7[var1_1], var6_7[var1_1 + 1]);
        var20_17 = t.a(var6_7[var1_1 - 1], var6_7[var1_1]);
        if (var20_17 + var7_8 < var18_16 && t.a(var6_7[var1_1], var15_14) > var20_17) {
            var22_18 = new m(var6_7[var1_1 - 1], z.a(var6_7[var1_1 - 1], z.c(var13_11)));
            var24_22 = ik.a(var22_18, var23_21 = new n(var4_4[var1_1]));
            if (var24_22 > 0.0) {
                var26_23 = new z(var6_7[var1_1], var6_7[var1_1 + 1]);
                var26_23.c();
                var26_23.b(var24_22);
                var23_21.d(var26_23.a(), var26_23.b());
            }
            var15_14 = var23_21.k();
        }
        if (t.a(var6_7[var1_1], var15_14) <= var18_16) ** GOTO lbl-1000
        var5_6[0] = 1.0;
        if (var27_5) lbl-1000: // 2 sources:
        {
            if ((var22_19 = t.a(var15_14, var3_3[var1_1].k())) < var11_10) {
                var5_6[0] = var22_19 / var11_10;
                ** if (!var27_5) goto lbl34
            }
        }
        ** GOTO lbl34
lbl-1000: // 2 sources:
        {
            if (t.a(var15_14, var4_4[var1_1].k()) > var11_10) {
                var5_6[0] = - Math.min(Math.abs(var9_9), t.a(var15_14, var3_3[var1_1].k()));
            }
        }
lbl34: // 7 sources:
        if (var1_1 >= var6_7.length - 2) ** GOTO lbl61
        var13_11 = new z(var6_7[var1_1], var6_7[var1_1 + 1]);
        var14_13 = new z(var6_7[var1_1 + 2], var6_7[var1_1 + 1]);
        var15_14 = e.a(var3_3[var1_1 + 1].k(), var14_13, var3_3[var1_1].k(), var13_11);
        if (var15_14 == null) ** GOTO lbl61
        var16_15 = z.d(var14_13, var13_11);
        if ((this.a() != 1 || var16_15 >= 3.141592653589793) && (this.a() != 2 || var16_15 <= 3.141592653589793)) ** GOTO lbl-1000
        var18_16 = t.a(var6_7[var1_1], var6_7[var1_1 + 1]);
        var20_17 = t.a(var6_7[var1_1 + 2], var6_7[var1_1 + 1]);
        if (var20_17 + var7_8 < var18_16 && t.a(var6_7[var1_1 + 1], var15_14) > var20_17) {
            var22_18 = new m(var6_7[var1_1 + 2], z.a(var6_7[var1_1 + 2], z.c(var13_11)));
            var24_22 = ik.a(var22_18, var23_21 = new n(var3_3[var1_1]));
            if (var24_22 > 0.0) {
                var26_23 = new z(var6_7[var1_1 + 1], var6_7[var1_1]);
                var26_23.c();
                var26_23.b(var24_22);
                var23_21.d(var26_23.a(), var26_23.b());
            }
            var15_14 = var23_21.k();
        }
        if (t.a(var6_7[var1_1 + 1], var15_14) <= var18_16) ** GOTO lbl-1000
        var5_6[1] = 0.0;
        if (var27_5) lbl-1000: // 2 sources:
        {
            if ((var22_20 = t.a(var15_14, var3_3[var1_1].k()) / var11_10) < 1.0) {
                var5_6[1] = var22_20;
                ** if (!var27_5) goto lbl61
            }
        }
        ** GOTO lbl61
lbl-1000: // 2 sources:
        {
            if ((var18_16 = t.a(var15_14, var3_3[var1_1].k()) / var11_10) > 1.0) {
                var5_6[1] = Math.max(1.0001, Math.min(Math.abs(var9_9), t.a(var15_14, var4_4[var1_1].k())));
            }
        }
lbl61: // 7 sources:
        if (var5_6[0] <= var5_6[1]) return var5_6;
        var13_12 = var5_6[0];
        var5_6[0] = var5_6[1];
        var5_6[1] = var13_12;
        return var5_6;
    }

    /*
     * Unable to fully structure code
     */
    public gv a(n var1_1, I var2_2, am var3_3, am var4_4, gv var5_5, byte var6_6, boolean var7_7) {
        var51_8 = fj.z;
        var8_9 = ae.a(var2_2, var3_3, var4_4, 0.0);
        var9_10 = var8_9.h();
        if (var9_10 < 2) return this.g();
        if (var9_10 == 2 && var8_9.a(0).g() < 1.0E-4) {
            return this.g();
        }
        var10_11 = Double.MAX_VALUE;
        var12_12 = Double.MAX_VALUE;
        var14_13 = null;
        var15_14 = null;
        var16_15 = var1_1.k();
        var17_16 = -1;
        if (var6_6 != 1 && var6_6 != 2 && (var5_5 == null || var5_5.e() != this.a())) ** GOTO lbl18
        if (var5_5.a() >= 0) ** GOTO lbl-1000
        var17_16 = Math.max(0, var9_10 - 1 + var5_5.a());
        if (var51_8) lbl-1000: // 2 sources:
        {
            var17_16 = Math.min(var9_10 - 2, var5_5.a());
        }
lbl18: // 4 sources:
        var18_17 = new n[var8_9.h() - 1];
        var19_18 = new n[var8_9.h() - 1];
        var20_19 = new double[var8_9.h() - 1];
        for (var21_20 = 0; var21_20 < var9_10 - 1; ++var21_20) {
            var18_17[var21_20] = new n(0.0, 0.0, 0.0, 0.0);
            var19_18[var21_20] = new n(0.0, 0.0, 0.0, 0.0);
            var22_21 = var8_9.a(var21_20);
            var20_19[var21_20] = 2 != var6_6 && var5_5 != null ? var5_5.c() : (this.a() == 0 ? this.b() : this.a(var1_1, var22_21));
            this.a(var8_9, var21_20, var1_1.d(), var2_2, var3_3, var4_4, var18_17[var21_20], var19_18[var21_20], var20_19[var21_20]);
            if (!var51_8) continue;
        }
        for (var21_20 = 0; var21_20 < var9_10 - 1; ++var21_20) {
            v0 = var6_6;
            v1 = 1;
            if (var51_8) ** GOTO lbl98
            if (v0 == v1 && (var6_6 != 1 || var17_16 != var21_20)) continue;
            var24_33 = var18_17[var21_20].k();
            if (t.a(var24_33, var25_34 = var19_18[var21_20].k()) < 1.0E-4) {
                var26_35 = var8_9.a(var21_20).i();
                var26_35.c();
                var25_34 = z.a(var25_34, (z)var26_35);
            }
            var26_35 = ik.a(var16_15, var24_33, new z(var25_34, var24_33));
            var27_38 = var26_35.a - var24_33.a;
            var29_43 = var26_35.b - var24_33.b;
            var31_44 = var25_34.a - var24_33.a;
            var33_45 = var25_34.b - var24_33.b;
            if (var31_44 == 0.0 && var33_45 == 0.0) {
                var31_44 = 1.0;
                var33_45 = 0.0;
            }
            if (var31_44 >= 1.0E-4 || var31_44 <= -1.0E-4) ** GOTO lbl49
            var22_22 = var29_43 / var33_45;
            if (!var51_8) ** GOTO lbl53
lbl49: // 2 sources:
            if (var33_45 >= 1.0E-4 || var33_45 <= -1.0E-4) ** GOTO lbl-1000
            var22_23 = var27_38 / var31_44;
            if (var51_8) lbl-1000: // 2 sources:
            {
                var22_24 = (var27_38 / var31_44 + var29_43 / var33_45) / 2.0;
            }
lbl53: // 4 sources:
            var35_46 = this.a(var21_20, var8_9, var18_17, var19_18);
            if (var22_25 < 0.0) {
                var22_26 = - Math.sqrt(var27_38 * var27_38 + var29_43 * var29_43);
            }
            if (2 == var6_6 || var5_5 == null) ** GOTO lbl62
            if (var17_16 != var21_20 || var5_5.b() >= 0.0) ** GOTO lbl-1000
            var22_27 = Math.max(var22_26, var5_5.b());
            var35_46[0] = Math.min(var35_46[0], var5_5.b());
            if (var51_8) lbl-1000: // 2 sources:
            {
                var22_28 = Math.max(var35_46[0], var22_27);
            }
lbl62: // 4 sources:
            if (var22_28 > 1.0) {
                var27_38 = var25_34.a - var26_35.a;
                var29_43 = var25_34.b - var26_35.b;
                var22_29 = Math.max(Math.sqrt(var27_38 * var27_38 + var29_43 * var29_43), 1.0000001);
            }
            if (2 == var6_6 || var5_5 == null) ** GOTO lbl72
            if (var17_16 != var21_20 || var5_5.b() <= 1.0) ** GOTO lbl-1000
            var22_30 = Math.min(var22_29, var5_5.b());
            var35_46[1] = Math.max(var35_46[1], var5_5.b());
            if (var51_8) lbl-1000: // 2 sources:
            {
                var22_31 = Math.min(var35_46[1], var22_30);
            }
lbl72: // 4 sources:
            var36_47 = var22_31 > 1.0 || var21_20 == var9_10 - 2 ? var21_20 + 1 - var9_10 : var21_20;
            var37_48 = new gv(var36_47, var22_31, var20_19[var21_20], this.f(), this.a(), this.e());
            var38_49 = this.a(var1_1.d(), var2_2, var3_3, var4_4, var37_48);
            var39_50 = t.a(var38_49.k(), var16_15);
            var41_51 = Math.abs(var37_48.c());
            var43_52 = var8_9.a(var21_20);
            var44_53 = var43_52.g();
            var46_54 = ik.a(var16_15, var43_52.c(), var43_52.i());
            var47_55 = t.a(var24_33, var46_54);
            var49_56 = t.a(var25_34, var46_54);
            if (var47_55 <= var44_53 || var49_56 >= var47_55) ** GOTO lbl-1000
            var41_51 += 1.1 * Math.abs(var49_56);
            if (var51_8) lbl-1000: // 2 sources:
            {
                if (var49_56 > var44_53 && var47_55 < var49_56) {
                    var41_51 += 1.1 * Math.abs(var47_55);
                }
            }
            if (var6_6 == 2 && var17_16 != var21_20) {
                var41_51 += 5.0;
            }
            if (var39_50 + 1.0E-4 >= var10_11 && (var39_50 >= 1.0E-4 || var41_51 >= var12_12)) continue;
            var14_13 = var37_48;
            var10_11 = var39_50;
            var12_12 = var41_51;
            var15_14 = var35_46;
            if (!var51_8) continue;
        }
        if (var14_13.a() < 0) {
            v0 = var14_13.a();
            v1 = var9_10 - 1;
lbl98: // 2 sources:
            v2 = v0 + v1;
        } else {
            v2 = var14_13.a();
        }
        var21_20 = v2;
        var22_32 = var18_17[var21_20];
        var23_57 = var19_18[var21_20];
        var24_33 = var22_32.k();
        var25_34 = var23_57.k();
        if (var5_5 == null) {
            block24 : {
                var18_17 = new n[var8_9.h() - 1];
                var19_18 = new n[var8_9.h() - 1];
                var20_19 = new double[var8_9.h() - 1];
                for (var26_36 = 0; var26_36 < var9_10 - 1; ++var26_36) {
                    var18_17[var26_36] = new n(0.0, 0.0, 0.0, 0.0);
                    var19_18[var26_36] = new n(0.0, 0.0, 0.0, 0.0);
                    var27_40 = var8_9.a(var26_36);
                    v3 = var20_19;
                    v4 = var26_36;
                    if (!var51_8) {
                        v3[v4] = var14_13 != null ? var14_13.c() : (this.a() == 0 ? this.b() : this.a(var1_1, var27_40));
                        this.a(var8_9, var26_36, var1_1.d(), var2_2, var3_3, var4_4, var18_17[var26_36], var19_18[var26_36], var14_13.c());
                        if (!var51_8) continue;
                    }
                    break block24;
                }
                var15_14 = this.a(var21_20, var8_9, var18_17, var19_18);
                if (var14_13.b() < 0.0) {
                    var15_14[0] = Math.min(var15_14[0], var14_13.b());
                }
                if (var14_13.b() > 1.0) {
                    var15_14[1] = Math.max(var15_14[1], var14_13.b());
                }
                var15_14[0] = Math.min(var15_14[0], var14_13.b());
                v3 = var15_14;
                v4 = 1;
            }
            v3[v4] = Math.max(var15_14[1], var14_13.b());
        }
        var26_37 = new double[4];
        if (var15_14[0] >= 0.0) ** GOTO lbl139
        var27_41 = new z(var25_34, var24_33);
        var27_41.c();
        var27_41.b((double)var15_14[0]);
        var26_37[0] = var24_33.a() + var27_41.a();
        var26_37[1] = var24_33.b() + var27_41.b();
        if (!var51_8) ** GOTO lbl147
lbl139: // 2 sources:
        if (var15_14[0] <= 0.0) ** GOTO lbl-1000
        var27_39 = var25_34.a() - var24_33.a();
        var29_43 = var25_34.b() - var24_33.b();
        var26_37[0] = var24_33.a() + var27_39 * var15_14[0];
        var26_37[1] = var24_33.b() + var29_43 * var15_14[0];
        if (var51_8) lbl-1000: // 2 sources:
        {
            var26_37[0] = var24_33.a();
            var26_37[1] = var24_33.b();
        }
lbl147: // 4 sources:
        if (var15_14[1] <= 1.0) ** GOTO lbl154
        var27_39 = new z(var25_34, var24_33);
        var27_39.c();
        var27_39.b(var15_14[1]);
        var26_37[2] = var25_34.a() + var27_39.a();
        var26_37[3] = var25_34.b() + var27_39.b();
        if (!var51_8) ** GOTO lbl162
lbl154: // 2 sources:
        if (var15_14[1] >= 1.0) ** GOTO lbl-1000
        var27_42 = var25_34.a() - var24_33.a();
        var29_43 = var25_34.b() - var24_33.b();
        var26_37[2] = var24_33.a() + var27_42 * var15_14[1];
        var26_37[3] = var24_33.b() + var29_43 * var15_14[1];
        if (var51_8) lbl-1000: // 2 sources:
        {
            var26_37[2] = var25_34.a();
            var26_37[3] = var25_34.b();
        }
lbl162: // 4 sources:
        if (var7_7) {
            var27_39 = var8_9.a(var21_20);
            var28_58 = (var14_13.f() - z.d(new z(1.0, 0.0), var27_39.i())) % 6.283185307179586;
            var30_59 = new gv(var14_13.a(), var14_13.b(), var14_13.c(), var14_13.d(), var14_13.e(), var28_58);
            var30_59.a(var26_37[0], var26_37[1], var26_37[2], var26_37[3]);
            return var30_59;
        }
        var14_13.a(var26_37[0], var26_37[1], var26_37[2], var26_37[3]);
        return var14_13;
    }

    private double a(n n2, m m2) {
        double d2;
        n n3 = new n(n2);
        t t2 = n2.k();
        if (this.c()) {
            d2 = ik.c(z.d(m2.i(), g) - n3.j());
            n3.a(d2);
            n3.b(t2);
        }
        d2 = z.d(m2.i(), new m(m2.c(), t2).i());
        double d3 = this.f ? ik.b(m2, t2) : ik.a(m2, n3);
        if (d2 <= 3.141592653589793) return d3;
        return - d3;
    }

    private static t a(t t2, t t3, z z2) {
        double d2 = t2.a - t3.a;
        double d3 = t2.b - t3.b;
        double d4 = z2.a();
        double d5 = z2.b();
        double d6 = d4 * d4 + d5 * d5;
        double d7 = (d2 * d4 + d3 * d5) / d6;
        return new t(t3.a + d7 * d4, t3.b + d7 * d5);
    }

    /*
     * Unable to fully structure code
     */
    private void a(v var1_1, int var2_2, q var3_3, I var4_4, am var5_5, am var6_6, n var7_7, n var8_8, double var9_9) {
        var11_10 = var1_1.a(var2_2);
        var12_11 = var11_10.c();
        var13_12 = var11_10.d();
        if (var11_10.g() != 0.0) ** GOTO lbl13
        var14_13 = var5_5.getX() + var5_5.getWidth() * 0.5 + var4_4.getSourcePoint().a - (var6_6.getX() + var6_6.getWidth() * 0.5 + var4_4.getTargetPoint().a);
        var16_14 = var5_5.getY() + var5_5.getHeight() * 0.5 + var4_4.getSourcePoint().b - (var6_6.getY() + var6_6.getHeight() * 0.5 + var4_4.getTargetPoint().b);
        if (var14_13 != 0.0 || var16_14 != 0.0) ** GOTO lbl-1000
        var13_12 = new t(var12_11.a + 1.0E-4, var12_11.b);
        if (fj.z) lbl-1000: // 2 sources:
        {
            var18_15 = Math.sqrt(var14_13 * var14_13 + var16_14 * var16_14);
            var13_12 = new t(var12_11.a + 1.0E-4 * var14_13 / var18_15, var12_11.b + 1.0E-4 * var16_14 / var18_15);
        }
        var11_10 = new m(var12_11, var13_12);
lbl13: // 2 sources:
        var14_13 = 6.283185307179586 - this.d;
        if (this.b) {
            var14_13 = ik.c(z.d(var11_10.i(), ik.g) - this.d);
        }
        var7_7.a(var3_3);
        var7_7.a(var14_13);
        this.a(var7_7, var11_10, var12_11, var9_9);
        if (var2_2 == 0 && this.a(var5_5, var7_7)) {
            this.b(var7_7, var11_10, var5_5, var9_9);
        }
        var8_8.a(var3_3);
        var8_8.a(var14_13);
        this.a(var8_8, var11_10, var13_12, var9_9);
        if (var2_2 != var1_1.h() - 2) return;
        if (this.a(var6_6, var8_8) == false) return;
        this.a(var8_8, var11_10, var6_6, var9_9);
    }

    private boolean a(am am2, n n2) {
        y y2 = new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
        return n.a(n2, y2, 5.0);
    }

    private static t a(m m2, t t2, double d2, double d3) {
        t t3 = m2.d();
        t t4 = m2.c();
        double d4 = t2.a();
        double d5 = t2.b();
        return e.a(t3.a(), t3.b(), t4.a(), t4.b(), d4, d5, d4 + d2, d5 + d3);
    }
}

