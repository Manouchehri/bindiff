/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.ArrayList;
import y.d.e;
import y.d.m;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.y;
import y.d.z;
import y.f.B;
import y.f.C;
import y.f.D;
import y.f.E;
import y.f.I;
import y.f.X;
import y.f.aK;
import y.f.aV;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aJ
implements E {
    private int a = 63;
    private double b = 2.0;
    private double c;
    private boolean d = true;
    private boolean e = false;
    private boolean f = false;
    private static final z g = new z(1.0, 0.0);

    public aJ() {
        this(63);
    }

    public aJ(int n2) {
        this.a = n2;
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.e;
    }

    public void a(double d2) {
        this.b = Math.abs(d2);
    }

    @Override
    public Object c() {
        if ((this.a & 128) != 0) {
            return new aK(128);
        }
        if ((this.a & 64) != 0) {
            return new aK(64);
        }
        if ((this.a & 16) != 0) {
            return new aK(16);
        }
        if ((this.a & 8) == 0) return new aK(128);
        return new aK(8);
    }

    private Object[] d() {
        ArrayList<aK> arrayList = new ArrayList<aK>();
        arrayList.add(new aK(1));
        arrayList.add(new aK(2));
        arrayList.add(new aK(4));
        arrayList.add(new aK(8));
        arrayList.add(new aK(16));
        arrayList.add(new aK(32));
        arrayList.add(new aK(64));
        arrayList.add(new aK(128));
        arrayList.add(new aK(256));
        return arrayList.toArray();
    }

    @Override
    public Object a(n n2, I i2, am am2, am am3) {
        if (ae.a(n2)) {
            throw new IllegalArgumentException(new StringBuffer().append("Invalid label bounds: ").append(n2).toString());
        }
        D d2 = new D();
        d2.a(n2);
        y.c.D d3 = this.a(d2, i2, am2, am3);
        if (!d3.isEmpty()) return aW.a(d3, n2.k()).b();
        return this.c();
    }

    public static Object a(int n2) {
        switch (n2) {
            case 1: 
            case 2: 
            case 4: 
            case 8: 
            case 16: 
            case 32: 
            case 64: 
            case 128: 
            case 256: {
                return new aK(n2);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Invalid position: ").append(n2).toString());
    }

    public static int a(Object object) {
        try {
            return ((aK)object).a();
        }
        catch (ClassCastException var1_1) {
            throw new IllegalArgumentException("Invalid model parameter type.");
        }
    }

    public boolean b(Object object) {
        if (!(object instanceof aK)) return false;
        int n2 = ((aK)object).a();
        if ((this.a() & n2) == 0) return false;
        return true;
    }

    @Override
    public n a(q q2, I i2, am am2, am am3, Object object) {
        aK aK2 = (aK)(object instanceof aK ? object : this.c());
        return this.a(q2, i2, am2, am3, aK.a(aK2));
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public y.c.D a(C var1_1, I var2_2, am var3_3, am var4_4) {
        var12_5 = X.j;
        var5_6 = new y.c.D();
        var6_7 = this.d();
        var7_8 = 0;
        do {
            if (var7_8 >= var6_7.length) return var5_6;
            var8_9 = aK.a((aK)var6_7[var7_8]);
            if ((this.a & var8_9) == 0) ** GOTO lbl21
            var9_10 = false;
            if (var8_9 != 128) ** GOTO lbl13
            var9_10 = true;
            if (!var12_5) ** GOTO lbl18
lbl13: // 2 sources:
            if (var8_9 != 64) ** GOTO lbl-1000
            var9_10 = true;
            if (var12_5) lbl-1000: // 2 sources:
            {
                if (var8_9 == 256) {
                    var9_10 = true;
                }
            }
lbl18: // 6 sources:
            var10_11 = var1_1.getOrientedBox().d();
            var11_12 = this.a(var10_11, var2_2, var3_3, var4_4, var8_9);
            var5_6.add(new B(var11_12, var6_7[var7_8], var1_1, var9_10));
lbl21: // 2 sources:
            ++var7_8;
        } while (!var12_5);
        return var5_6;
    }

    /*
     * Unable to fully structure code
     */
    protected n a(q var1_1, I var2_2, am var3_3, am var4_4, int var5_5) {
        block13 : {
            block12 : {
                var22_6 = X.j;
                var6_7 = new n(new t(0.0, 0.0), var1_1);
                var6_7.a(6.283185307179586 - this.c);
                var7_8 = ae.a(var2_2, var3_3, var4_4, 0.0).f();
                if (var7_8.length < 2) {
                    var8_9 = var6_7.h();
                    var6_7.e(var3_3.getX() + var8_9.a * 0.5, var3_3.getY() - var8_9.b * 0.5);
                    if (this.b() == false) return var6_7;
                    ae.b(var6_7);
                    return var6_7;
                }
                if (var7_8.length == 2 && t.a(var7_8[0], var7_8[1]) < 1.0E-4) {
                    var6_7.e(var7_8[0].a, var7_8[0].b);
                    if (this.b() == false) return var6_7;
                    ae.b(var6_7);
                    return var6_7;
                }
                var8_10 = 0;
                var9_11 = 0.0;
                for (var11_12 = 0; var11_12 < var7_8.length - 1; ++var11_12) {
                    v0 = var9_11 + t.a(var7_8[var11_12], var7_8[var11_12 + 1]);
                    if (!var22_6) {
                        var9_11 = v0;
                        if (!var22_6) continue;
                    }
                    break block12;
                }
                v0 = var9_11 / 2.0;
            }
            var11_13 = v0;
            var9_11 = 0.0;
            for (var13_14 = 0; var13_14 < var7_8.length - 1; ++var13_14) {
                v1 = (int)(var9_11 += t.a(var7_8[var13_14], var7_8[var13_14 + 1]) DCMPL var11_13);
                if (!var22_6) {
                    if (v1 <= 0) continue;
                    var8_10 = var13_14;
                    if (!var22_6) break;
                    if (!var22_6) continue;
                }
                break block13;
            }
            var13_14 = 0;
            v1 = var5_5;
        }
        if (v1 != 2 && var5_5 != 128 && var5_5 != 16) ** GOTO lbl-1000
        var13_14 = var8_10;
        if (var22_6) lbl-1000: // 2 sources:
        {
            if (var5_5 == 4 || var5_5 == 256 || var5_5 == 32) {
                var13_14 = var7_8.length - 2;
            }
        }
        if (!(var14_15 = var7_8[var13_14]).equals(var15_16 = var7_8[var13_14 + 1])) ** GOTO lbl52
        var16_17 = var3_3.getX() + var3_3.getWidth() * 0.5 + var2_2.getSourcePoint().a - (var4_4.getX() + var4_4.getWidth() * 0.5 + var2_2.getTargetPoint().a);
        var18_19 = var3_3.getY() + var3_3.getHeight() * 0.5 + var2_2.getSourcePoint().b - (var4_4.getY() + var4_4.getHeight() * 0.5 + var2_2.getTargetPoint().b);
        if (var16_17 != 0.0 || var18_19 != 0.0) ** GOTO lbl-1000
        var15_16 = new t(var14_15.a + 1.0E-4, var14_15.b);
        if (var22_6) lbl-1000: // 2 sources:
        {
            var20_20 = Math.sqrt(var16_17 * var16_17 + var18_19 * var18_19);
            var15_16 = new t(var14_15.a + 1.0E-4 * var16_17 / var20_20, var14_15.b + 1.0E-4 * var18_19 / var20_20);
        }
lbl52: // 4 sources:
        if (this.d) {
            var16_17 = z.d(new z(var15_16, var14_15), new z(1.0, 0.0)) - this.c;
            var6_7.a(aJ.b(var16_17));
        }
        var16_18 = new m(var14_15, var15_16);
        if (var5_5 != 1 && var5_5 != 64 && var5_5 != 8) ** GOTO lbl62
        if (!aJ.a(var3_3, var14_15, 5.0)) ** GOTO lbl60
        this.b(var6_7, var16_18, var3_3, var5_5, var13_14 == var8_10);
        if (!var22_6) ** GOTO lbl71
lbl60: // 2 sources:
        this.a(var6_7, var16_18, var14_15, var5_5);
        if (!var22_6) ** GOTO lbl71
lbl62: // 2 sources:
        if (var5_5 != 4 && var5_5 != 256 && var5_5 != 32) ** GOTO lbl-1000
        if (!aJ.a(var4_4, var15_16, 5.0)) ** GOTO lbl-1000
        this.a(var6_7, var16_18, var4_4, var5_5, var13_14 == var8_10);
        if (var22_6) lbl-1000: // 2 sources:
        {
            this.a(var6_7, var16_18, var15_16, var5_5);
            ** if (!var22_6) goto lbl71
        }
        ** GOTO lbl71
lbl-1000: // 2 sources:
        {
            var17_21 = new t((var14_15.a + var15_16.a) / 2.0, (var14_15.b + var15_16.b) / 2.0);
            this.a(var6_7, var16_18, var17_21, var5_5);
        }
lbl71: // 5 sources:
        if (this.b() == false) return var6_7;
        ae.b(var6_7);
        return var6_7;
    }

    private static boolean a(am am2, t t2, double d2) {
        if (am2.getX() - d2 >= t2.a) return false;
        if (am2.getX() + am2.getWidth() + d2 <= t2.a) return false;
        if (am2.getY() - d2 >= t2.b) return false;
        if (am2.getY() + am2.getHeight() + d2 <= t2.b) return false;
        return true;
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
    private void a(n var1_1, m var2_2, t var3_3, int var4_4) {
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

    private void a(n n2, m m2, am am2, int n3, boolean bl2) {
        this.a(n2, m2.d(), m2.c(), am2, n3, false, bl2);
    }

    private void b(n n2, m m2, am am2, int n3, boolean bl2) {
        this.a(n2, m2.c(), m2.d(), am2, n3, true, bl2);
    }

    private void a(n n2, t t2, t t3, am am2, int n3, boolean bl2, boolean bl3) {
        y y2 = new y(am2.getX(), am2.getY(), am2.getWidth(), am2.getHeight());
        m m2 = new m(t2, t3);
        byte by2 = aJ.a(m2);
        t t4 = this.a(by2, m2, n2, am2, n3, bl2, bl3);
        n2.a(t4);
        double d2 = aV.a(y2, n2);
        y y3 = n2.h();
        if (Math.abs(t2.a - t3.a) <= 1.0E-4) return;
        if (Math.abs(t2.b - t3.b) <= 1.0E-4) return;
        if (d2 >= 2.5) {
            if (d2 <= 6.0) return;
        }
        if (by2 != 0 && by2 != 1 || t3.a >= y2.c() - 5.0 - y3.a * 0.5 && t3.a <= y2.c() + y2.a() + 5.0 + y3.a * 0.5) {
            if (by2 != 2) {
                if (by2 != 3) return;
            }
            if (t3.b >= y2.d() - 5.0 - y3.b * 0.5) {
                if (t3.b <= y2.d() + y2.b() + 5.0 + y3.b * 0.5) return;
            }
        }
        boolean bl4 = true;
        boolean bl5 = bl4;
        if (!bl5) return;
        byte by3 = aJ.b(m2);
        t t5 = this.a(by3, m2, n2, am2, n3, bl2, bl3);
        n2.a(t5);
        double d3 = aV.a(y2, n2);
        if (d3 >= 2.5) {
            if (d3 <= d2) return;
            if (d2 <= 2.5) return;
        }
        n2.a(t4);
    }

    /*
     * Unable to fully structure code
     */
    private t a(byte var1_1, m var2_2, n var3_3, am var4_4, int var5_5, boolean var6_6, boolean var7_7) {
        block22 : {
            block21 : {
                block20 : {
                    block19 : {
                        var23_8 = X.j;
                        var8_9 = new n(var3_3);
                        var9_10 = var2_2.c();
                        var10_11 = var2_2.d();
                        var11_12 = z.d(var2_2.i(), aJ.g);
                        var13_13 = var8_9.h();
                        if (var1_1 != 0) ** GOTO lbl28
                        if (this.f) {
                            v0 = var14_14 = var6_6 != false && var5_5 == 1 || var6_6 == false && var5_5 == 4 ? 1 : 0;
                            if (!var23_8) break block19;
                        }
                        v1 = var14_14 = (var5_5 == 1 || var5_5 == 4) && var11_12 <= 1.5707963267948966 || (var5_5 == 8 || var5_5 == 32) && var11_12 > 1.5707963267948966 ? 1 : 0;
                    }
                    if ((var15_15 = var4_4.getY() - 5.0 - var13_13.b() * 0.5) >= var10_11.b) ** GOTO lbl-1000
                    var15_15 = var10_11.b;
                    if (var14_14 != 0) lbl-1000: // 2 sources:
                    {
                        v2 = Math.min(var9_10.a, var10_11.a) - var13_13.a;
                    } else {
                        v2 = Math.max(var9_10.a, var10_11.a) + var13_13.a;
                    }
                    var17_17 = v2;
                    var8_9.e(var17_17, var15_15);
                    var19_18 = var5_5 == 64 || var5_5 == 256 ? var8_9.k() : aJ.a(n.a(var8_9), var2_2);
                    var20_19 = aJ.a(var2_2, var19_18, 1.0, 0.0);
                    var8_9.d(var20_19.a - var19_18.a, 0.0);
                    if (var5_5 == 64 || var5_5 == 256) ** GOTO lbl90
                    var21_20 = var14_14 != 0 ? - this.b : this.b;
                    var8_9.d(var21_20, 0.0);
                    if (!var23_8) ** GOTO lbl90
lbl28: // 2 sources:
                    if (var1_1 != 1) ** GOTO lbl49
                    if (this.f) {
                        v3 = var14_14 = var6_6 != false && var5_5 == 8 || var6_6 == false && var5_5 == 32 ? 1 : 0;
                        if (!var23_8) break block20;
                    }
                    v4 = var14_14 = (var5_5 == 8 || var5_5 == 32) && var11_12 > 4.71238898038469 || (var5_5 == 1 || var5_5 == 4) && var11_12 <= 4.71238898038469 ? 1 : 0;
                }
                if ((var15_15 = var4_4.getY() + var4_4.getHeight() + 5.0 + var13_13.b() * 0.5) <= var10_11.b) ** GOTO lbl-1000
                var15_15 = var10_11.b;
                if (var14_14 != 0) lbl-1000: // 2 sources:
                {
                    v5 = Math.min(var9_10.a, var10_11.a) - var13_13.a;
                } else {
                    v5 = Math.max(var9_10.a, var10_11.a) + var13_13.a;
                }
                var17_17 = v5;
                var8_9.e(var17_17, var15_15);
                var19_18 = var5_5 == 64 || var5_5 == 256 ? var8_9.k() : aJ.a(n.a(var8_9), var2_2);
                var20_19 = aJ.a(var2_2, var19_18, 1.0, 0.0);
                var8_9.d(var20_19.a - var19_18.a, 0.0);
                if (var5_5 == 64 || var5_5 == 256) ** GOTO lbl90
                var21_20 = var14_14 != 0 ? - this.b : this.b;
                var8_9.d(var21_20, 0.0);
                if (!var23_8) ** GOTO lbl90
lbl49: // 2 sources:
                if (var1_1 != 2) ** GOTO lbl70
                if (this.f) {
                    v6 = var14_14 = var6_6 != false && var5_5 == 1 || var6_6 == false && var5_5 == 4 ? 1 : 0;
                    if (!var23_8) break block21;
                }
                v7 = var14_14 = var5_5 == 8 || var5_5 == 32 ? 1 : 0;
            }
            if ((var15_15 = var4_4.getX() - 5.0 - var13_13.a() * 0.5) >= var10_11.a) ** GOTO lbl-1000
            var15_15 = var10_11.a;
            if (var14_14 != 0) lbl-1000: // 2 sources:
            {
                v8 = Math.max(var9_10.b, var10_11.b) + var13_13.b;
            } else {
                v8 = Math.min(var9_10.b, var10_11.b) - var13_13.b;
            }
            var17_17 = v8;
            var8_9.e(var15_15, var17_17);
            var19_18 = var5_5 == 64 || var5_5 == 256 ? var8_9.k() : aJ.a(n.a(var8_9), var2_2);
            var20_19 = aJ.a(var2_2, var19_18, 0.0, 1.0);
            var8_9.d(0.0, var20_19.b - var19_18.b);
            if (var5_5 == 64 || var5_5 == 256) ** GOTO lbl90
            var21_20 = var14_14 != 0 ? this.b : - this.b;
            var8_9.d(0.0, var21_20);
            if (!var23_8) ** GOTO lbl90
lbl70: // 2 sources:
            if (var1_1 != 3) ** GOTO lbl90
            if (this.f) {
                v9 = var14_14 = var6_6 != false && var5_5 == 8 || var6_6 == false && var5_5 == 32 ? 1 : 0;
                if (!var23_8) break block22;
            }
            v10 = var14_14 = var5_5 == 8 || var5_5 == 32 ? 1 : 0;
        }
        if ((var15_15 = var4_4.getX() + var4_4.getWidth() + 5.0 + var13_13.a() * 0.5) <= var10_11.a) ** GOTO lbl-1000
        var15_15 = var10_11.a;
        if (var14_14 != 0) lbl-1000: // 2 sources:
        {
            v11 = Math.max(var9_10.b, var10_11.b) + var13_13.b;
        } else {
            v11 = Math.min(var9_10.b, var10_11.b) - var13_13.b;
        }
        var17_17 = v11;
        var8_9.e(var15_15, var17_17);
        var19_18 = var5_5 == 64 || var5_5 == 256 ? var8_9.k() : aJ.a(n.a(var8_9), var2_2);
        var20_19 = aJ.a(var2_2, var19_18, 0.0, 1.0);
        var8_9.d(0.0, var20_19.b - var19_18.b);
        if (var5_5 != 64 && var5_5 != 256) {
            var21_20 = var14_14 != 0 ? this.b : - this.b;
            var8_9.d(0.0, var21_20);
        }
lbl90: // 10 sources:
        if (var7_7 == false) return var8_9.a();
        if (t.a(var8_9.k(), var9_10) <= t.a(var8_9.k(), var10_11)) return var8_9.a();
        var14_14 = 128;
        if (var5_5 > 4) ** GOTO lbl-1000
        var14_14 = 2;
        if (var23_8) lbl-1000: // 2 sources:
        {
            if (var5_5 <= 32) {
                var14_14 = 16;
            }
        }
        var15_16 = new t((var9_10.a + var10_11.a) / 2.0, (var9_10.b + var10_11.b) / 2.0);
        this.a(var8_9, var2_2, var15_16, var14_14);
        return var8_9.a();
    }

    private static t a(t[] arrt, m m2) {
        boolean bl2 = X.j;
        double d2 = Double.MAX_VALUE;
        t t2 = null;
        int n2 = 0;
        do {
            if (n2 >= arrt.length) return t2;
            double d3 = aJ.a(m2, arrt[n2]);
            if (d3 < d2) {
                t2 = arrt[n2];
                d2 = d3;
            }
            ++n2;
        } while (!bl2);
        return t2;
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

    private static t a(m m2, t t2, double d2, double d3) {
        t t3 = m2.d();
        t t4 = m2.c();
        double d4 = t2.a();
        double d5 = t2.b();
        return e.a(t3.a(), t3.b(), t4.a(), t4.b(), d4, d5, d4 + d2, d5 + d3);
    }
}

