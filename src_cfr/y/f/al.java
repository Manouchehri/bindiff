/*
 * Decompiled with CFR 0_115.
 */
package y.f;

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
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.Q;
import y.f.X;
import y.f.aM;
import y.f.aV;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aL
implements E {
    private double a;
    private boolean b;
    private boolean c;
    private boolean d;
    private double e;
    private byte f;
    private static final z g = new z(1.0, 0.0);

    public byte a() {
        return this.f;
    }

    public void a(double d2) {
        this.a = d2;
    }

    public boolean b() {
        return this.d;
    }

    @Override
    public Object c() {
        return new aM(0, 0.0, false);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public n a(q var1_1, I var2_2, am var3_3, am var4_4, Object var5_5) {
        block13 : {
            block12 : {
                block11 : {
                    var23_6 = X.j;
                    var6_7 = var5_5 != null ? (aM)var5_5 : (aM)this.c();
                    var7_8 = var6_7.a();
                    var8_9 = var6_7.b();
                    var10_10 = var6_7.c();
                    var11_11 = new n(new t(0.0, 0.0), var1_1);
                    var11_11.a(6.283185307179586 - this.e);
                    var12_12 = ae.a(var2_2, var3_3, var4_4, 0.0);
                    if (var12_12.h() >= 2 && (var12_12.h() != 2 || t.a(var12_12.c(), var12_12.d()) >= 1.0E-4)) ** GOTO lbl19
                    if (var12_12.h() >= 2) ** GOTO lbl-1000
                    var13_13 = var11_11.h();
                    var11_11.e(var3_3.getX() + var13_13.a * 0.5, var3_3.getY() + var13_13.b * 0.5);
                    if (var23_6) lbl-1000: // 2 sources:
                    {
                        var13_14 = var12_12.c();
                        var11_11.e(var13_14.a, var13_14.b);
                    }
                    if (this.b() == false) return var11_11;
                    ae.b(var11_11);
                    return var11_11;
lbl19: // 1 sources:
                    if (var7_8 < 0) {
                        var13_15 = Math.max(0, var12_12.h() - 1 + var7_8);
                        if (!var23_6) break block11;
                    }
                    var13_16 = Math.min(var12_12.h() - 2, var7_8);
                }
                if ((var14_17 = var12_12.a(var13_16)) == null) {
                    var15_18 = var11_11.h();
                    var11_11.e(var3_3.getX() + var15_18.a * 0.5, var3_3.getY() + var15_18.b * 0.5);
                    if (this.b() == false) return var11_11;
                    ae.b(var11_11);
                    return var11_11;
                }
                var15_19 = var14_17.c();
                var16_20 = var14_17.d();
                if (var14_17.g() != 0.0) ** GOTO lbl41
                var17_21 = var3_3.getX() + var3_3.getWidth() * 0.5 + var2_2.getSourcePoint().a - (var4_4.getX() + var4_4.getWidth() * 0.5 + var2_2.getTargetPoint().a);
                var19_22 = var3_3.getY() + var3_3.getHeight() * 0.5 + var2_2.getSourcePoint().b - (var4_4.getY() + var4_4.getHeight() * 0.5 + var2_2.getTargetPoint().b);
                if (var17_21 != 0.0 || var19_22 != 0.0) ** GOTO lbl-1000
                var16_20 = new t(var15_19.a + 1.0E-6, var15_19.b);
                if (var23_6) lbl-1000: // 2 sources:
                {
                    var21_24 = Math.sqrt(var17_21 * var17_21 + var19_22 * var19_22);
                    var16_20 = new t(var15_19.a + 1.0E-6 * var17_21 / var21_24, var15_19.b + 1.0E-6 * var19_22 / var21_24);
                }
                var14_17 = new m(var15_19, var16_20);
lbl41: // 2 sources:
                if (this.c) {
                    var11_11.a(aL.b(z.d(var14_17.i(), aL.g) - this.e));
                }
                var17_21 = 0.0;
                if (this.f != 0) {
                    var17_21 = var10_10 != false ? - this.a : this.a;
                }
                var19_23 = new n(var11_11);
                if (var13_16 == 0 && aL.a(var3_3, var15_19, 5.0)) {
                    this.b(var19_23, var14_17, var3_3, var17_21);
                    if (!var23_6) break block12;
                }
                this.a(var19_23, var14_17, var15_19, var17_21);
            }
            var20_26 = new n(var11_11);
            if (var13_16 >= var12_12.h() - 2 && aL.a(var4_4, var16_20, 5.0)) {
                this.a(var20_26, var14_17, var4_4, var17_21);
                if (!var23_6) break block13;
            }
            this.a(var20_26, var14_17, var16_20, var17_21);
        }
        var21_25 = new t(var19_23.b() * (1.0 - var8_9) + var20_26.b() * var8_9, var19_23.c() * (1.0 - var8_9) + var20_26.c() * var8_9);
        var11_11.a(var21_25);
        if (this.b() == false) return var11_11;
        ae.b(var11_11);
        return var11_11;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public y.c.D a(C var1_1, I var2_2, am var3_3, am var4_4) {
        var20_5 = X.j;
        var5_6 = new y.c.D();
        var6_7 = ae.a(var2_2, var3_3, var4_4, 0.0).f();
        if (var6_7.length < 2 || var6_7.length == 2 && t.a(var6_7[0], var6_7[1]) < 1.0E-4) {
            block15 : {
                var7_8 = new n(var1_1.getOrientedBox());
                if (var6_7.length < 2) {
                    var7_8.e(var3_3.getX() + var7_8.e() * 0.5, var3_3.getY() - var7_8.f() * 0.5);
                    if (!var20_5) break block15;
                }
                var7_8.e(var6_7[0].a, var6_7[0].b);
            }
            var5_6.add(new B(var7_8, this.c(), var1_1, false));
            return var5_6;
        }
        var7_9 = 0;
        do {
            block17 : {
                block16 : {
                    if (var7_9 >= var6_7.length - 1) return var5_6;
                    var8_10 = var6_7[var7_9];
                    var9_11 = var6_7[var7_9 + 1];
                    if (!var8_10.equals(var9_11)) ** GOTO lbl26
                    var10_13 = var3_3.getX() + var3_3.getWidth() * 0.5 + var2_2.getSourcePoint().a - (var4_4.getX() + var4_4.getWidth() * 0.5 + var2_2.getTargetPoint().a);
                    var12_15 = var3_3.getY() + var3_3.getHeight() * 0.5 + var2_2.getSourcePoint().b - (var4_4.getY() + var4_4.getHeight() * 0.5 + var2_2.getTargetPoint().b);
                    if (var10_13 != 0.0 || var12_15 != 0.0) ** GOTO lbl-1000
                    var9_11 = new t(var8_10.a + 1.0E-4, var8_10.b);
                    if (var20_5) lbl-1000: // 2 sources:
                    {
                        var14_17 = Math.sqrt(var10_13 * var10_13 + var12_15 * var12_15);
                        var9_11 = new t(var8_10.a + 1.0E-4 * var10_13 / var14_17, var8_10.b + 1.0E-4 * var12_15 / var14_17);
                    }
lbl26: // 4 sources:
                    var10_12 = new m(var8_10, var9_11);
                    var11_14 = 6.283185307179586 - this.e;
                    if (this.c) {
                        var11_14 = aL.b(z.d(var10_12.i(), aL.g) - this.e);
                    }
                    var13_16 = var7_9 > (var6_7.length - 2) / 2 ? var7_9 + 1 - var6_7.length : var7_9;
                    var14_17 = this.f == 0 ? 0.0 : this.a;
                    var16_20 = new n(var1_1.getOrientedBox());
                    var16_20.a(var11_14);
                    if (var7_9 == 0 && aL.a(var3_3, var8_10, 5.0)) {
                        this.b(var16_20, var10_12, var3_3, var14_17);
                        if (!var20_5) break block16;
                    }
                    this.a(var16_20, var10_12, var8_10, var14_17);
                }
                var17_21 = new aM(var13_16, 0.0, false);
                var5_6.add(new B(var16_20, var17_21, var1_1));
                var18_22 = new n(var1_1.getOrientedBox());
                var18_22.a(var11_14);
                if (var7_9 == var6_7.length - 2 && aL.a(var4_4, var9_11, 5.0)) {
                    this.a(var18_22, var10_12, var4_4, var14_17);
                    if (!var20_5) break block17;
                }
                this.a(var18_22, var10_12, var9_11, var14_17);
            }
            var19_23 = new aM(var13_16, 1.0, false);
            var5_6.add(new B(var18_22, var19_23, var1_1));
            this.a(var5_6, var1_1, var16_20, var18_22, var10_12, var7_9, false);
            if (this.f == 1) {
                block19 : {
                    block18 : {
                        var14_18 = new n(var1_1.getOrientedBox());
                        var14_18.a(var11_14);
                        if (var7_9 == 0 && aL.a(var3_3, var8_10, 5.0)) {
                            this.b(var14_18, var10_12, var3_3, - this.a);
                            if (!var20_5) break block18;
                        }
                        this.a(var14_18, var10_12, var8_10, - this.a);
                    }
                    var15_19 = new aM(var13_16, 0.0, true);
                    var5_6.add(new B(var14_18, var15_19, var1_1));
                    var16_20 = new n(var1_1.getOrientedBox());
                    var16_20.a(var11_14);
                    if (var7_9 == var6_7.length - 2 && aL.a(var4_4, var9_11, 5.0)) {
                        this.a(var16_20, var10_12, var4_4, - this.a);
                        if (!var20_5) break block19;
                    }
                    this.a(var16_20, var10_12, var9_11, - this.a);
                }
                var17_21 = new aM(var13_16, 1.0, true);
                var5_6.add(new B(var16_20, var17_21, var1_1));
                this.a(var5_6, var1_1, var14_18, var16_20, var10_12, var13_16, true);
            }
            ++var7_9;
        } while (!var20_5);
        return var5_6;
    }

    private void a(y.c.D d2, C c2, n n2, n n3, m m2, int n4, boolean bl2) {
        Object object;
        Object object2;
        int n5;
        boolean bl3 = X.j;
        t[] arrt = n.a(n2);
        int n6 = aL.b(arrt, m2);
        t t2 = n6 > 0 ? arrt[n6 - 1] : arrt[3];
        m m3 = new m(arrt[n6], t2);
        t t3 = n6 < 3 ? arrt[n6 + 1] : arrt[0];
        m m4 = new m(arrt[n6], t3);
        t[] arrt2 = n.a(n3);
        t t4 = aL.a(arrt2[n6], m3, arrt[n6]);
        double d3 = t.a(arrt[n6], t4);
        int n7 = (int)Math.floor((d3 - m4.g()) / m4.g());
        t t5 = aL.a(arrt2[n6], m4, arrt[n6]);
        double d4 = t.a(arrt[n6], t5);
        int n8 = (int)Math.floor((d4 - m3.g()) / m3.g());
        boolean bl4 = n7 >= n8;
        double d5 = bl4 ? d3 : d4;
        m m5 = bl4 ? m3 : m4;
        m m6 = bl4 ? m4 : m3;
        int n9 = n5 = bl4 ? n7 : n8;
        if (n5 > 0 && n5 % 2 == 0) {
            ++n5;
        }
        double d6 = (d5 - (double)(n5 + 1) * m6.g()) / (double)(n5 + 1);
        z z2 = m2.i();
        z2.c();
        z z3 = m6.i();
        z3.c();
        z3.b(d6 + m6.g());
        t t6 = z.a(n2.a(), z3);
        t t7 = aL.a(t6, m5, n2.a(), m2);
        if (t7 == null) {
            t7 = t6;
        }
        z2.b(t.a(n2.a(), t7));
        Object object3 = n2.a();
        double d7 = t.a(n2.a(), n3.a());
        if (n5 > 0) {
            int n10 = 0;
            do {
                if (n10 >= n5) return;
                object2 = new n(n2);
                object = z.a((t)object3, z2);
                double d8 = t.a(n2.a(), (t)object);
                object2.a((t)object);
                aM aM2 = new aM(n4, d8 / d7, bl2);
                d2.add(new B((n)object2, aM2, c2));
                object3 = object;
                ++n10;
            } while (!bl3);
        }
        n n11 = new n(n2);
        object2 = t.c(n3.k(), n2.k());
        n11.b((t)object2);
        object = new aM(n4, 0.5, bl2);
        d2.add(new B(n11, object, c2));
    }

    private static boolean a(am am2, t t2, double d2) {
        if (am2.getX() - d2 >= t2.a) return false;
        if (am2.getX() + am2.getWidth() + d2 <= t2.a) return false;
        if (am2.getY() - d2 >= t2.b) return false;
        if (am2.getY() + am2.getHeight() + d2 <= t2.b) return false;
        return true;
    }

    @Override
    public Object a(n n2, I i2, am am2, am am3) {
        Object object;
        if (ae.a(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
        }
        D d2 = new D();
        d2.a(n2);
        y.c.D d3 = this.a(d2, i2, am2, am3);
        if (d3.isEmpty()) {
            return this.c();
        }
        Q q2 = aW.a(d3, n2.k());
        if (q2 != null) {
            object = q2.b();
            return object;
        }
        object = this.c();
        return object;
    }

    private static double b(double d2) {
        double d3;
        boolean bl2 = X.j;
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
     * Exception decompiling
     */
    private void a(n var1_1, m var2_2, t var3_3, double var4_4) {
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

    private void a(n n2, m m2, am am2, double d2) {
        this.a(n2, m2.d(), m2.c(), am2, false, d2);
    }

    private void b(n n2, m m2, am am2, double d2) {
        this.a(n2, m2.c(), m2.d(), am2, true, d2);
    }

    private void a(n n2, t t2, t t3, am am2, boolean bl2, double d2) {
        y y2 = new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
        m m2 = new m(t2, t3);
        byte by2 = aL.a(m2);
        t t4 = this.a(by2, m2, n2, am2, bl2, d2);
        n2.a(t4);
        double d3 = aV.a(y2, n2);
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
        byte by3 = aL.b(m2);
        t t5 = this.a(by3, m2, n2, am2, bl2, d2);
        n2.a(t5);
        double d4 = aV.a(y2, n2);
        if (d4 >= 2.5) {
            if (d4 <= d3) return;
            if (d3 <= 2.5) return;
        }
        n2.a(t4);
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

    private static boolean c(double d2) {
        if (d2 > 0.0) return true;
        if (d2 != 0.0) return false;
        if (Double.doubleToLongBits(d2) != 0) return false;
        return true;
    }

    private static boolean d(double d2) {
        if (d2 < 0.0) return true;
        if (d2 != 0.0) return false;
        if (Double.doubleToLongBits(d2) >= 0) return false;
        return true;
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
        return arrt[aL.b(arrt, m2)];
    }

    private static int b(t[] arrt, m m2) {
        int n2;
        boolean bl2 = X.j;
        double d2 = Double.MAX_VALUE;
        int n3 = -1;
        for (int i2 = 0; i2 < arrt.length; ++i2) {
            double d3 = aL.a(m2, arrt[i2]);
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

    private static double a(m m2, t t2) {
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

    private static t a(t t2, m m2, t t3) {
        double d2 = t2.a();
        double d3 = t2.b();
        t t4 = m2.c();
        t t5 = m2.d();
        double d4 = t5.a() - t4.a();
        double d5 = t5.b() - t4.b();
        double d6 = t3.a();
        double d7 = t3.b();
        double d8 = - d5;
        double d9 = d4;
        return e.a(d2, d3, d2 + d4, d3 + d5, d6, d7, d6 + d8, d7 + d9);
    }

    private static t a(t t2, m m2, t t3, m m3) {
        double d2 = t2.a();
        double d3 = t2.b();
        t t4 = m2.c();
        t t5 = m2.d();
        double d4 = t5.a() - t4.a();
        double d5 = t5.b() - t4.b();
        double d6 = t3.a();
        double d7 = t3.b();
        t t6 = m3.c();
        t t7 = m3.d();
        double d8 = t7.a() - t6.a();
        double d9 = t7.b() - t6.b();
        return e.a(d2, d3, d2 + d4, d3 + d5, d6, d7, d6 + d8, d7 + d9);
    }

    private static t a(m m2, t t2, double d2, double d3) {
        t t3 = m2.d();
        t t4 = m2.c();
        double d4 = t2.a();
        double d5 = t2.b();
        return e.a(t3.a(), t3.b(), t4.a(), t4.b(), d4, d5, d4 + d2, d5 + d3);
    }
}

