/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import y.d.m;
import y.d.n;
import y.d.q;
import y.d.t;
import y.d.u;
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
import y.f.aP;
import y.f.aW;
import y.f.ae;
import y.f.am;

public class aO
implements E {
    private double a = 1.0;
    private double b = 1.0;
    private double c = 1.0;
    private double d = 9.125;
    private byte e;
    private static final aP f = new aP(0, 0.0, new z(0.0, 0.0), 2, 0.0);
    private static final aP g = new aP(0, 0.0, new z(0.0, 0.0), 0, 0.0);

    public aO(byte by2) {
        this.e = by2;
    }

    public byte a() {
        return this.e;
    }

    public void a(double d2, double d3) {
        this.a = d2;
        this.b = d3;
    }

    @Override
    public Object c() {
        if (this.e != 1) return g;
        return f;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public n a(q var1_1, I var2_2, am var3_3, am var4_4, Object var5_5) {
        var6_6 = var5_5 != null ? (aP)var5_5 : (aP)this.c();
        var7_7 = var6_6.a();
        var8_8 = var6_6.d();
        var9_9 = var6_6.b();
        var11_10 = var6_6.c();
        var12_11 = ae.a(var2_2, var3_3, var4_4, this.d);
        var13_12 = var7_7 < 0 ? var12_11.h() - 1 + var7_7 : var7_7;
        var14_13 = var12_11.a(var13_12);
        var15_14 = new n(new t(0.0, 0.0), var1_1);
        var16_15 = var15_14.h();
        if (var14_13 == null) {
            var15_14.e(var3_3.getX() + var16_15.a * 0.5, var3_3.getY() + var16_15.b * 0.5);
            return var15_14;
        }
        var17_16 = var14_13.c();
        var18_17 = var14_13.d();
        if (var14_13.g() != 0.0) ** GOTO lbl24
        var19_18 = var3_3.getX() + var3_3.getWidth() * 0.5 + var2_2.getSourcePoint().a - (var4_4.getX() + var4_4.getWidth() * 0.5 + var2_2.getTargetPoint().a);
        var21_20 = var3_3.getY() + var3_3.getHeight() * 0.5 + var2_2.getSourcePoint().b - (var4_4.getY() + var4_4.getHeight() * 0.5 + var2_2.getTargetPoint().b);
        if (var19_18 != 0.0 || var21_20 != 0.0) ** GOTO lbl-1000
        var18_17 = new t(var17_16.a + 1.0E-6, var17_16.b);
        if (X.j) lbl-1000: // 2 sources:
        {
            var23_21 = Math.sqrt(var19_18 * var19_18 + var21_20 * var21_20);
            var18_17 = new t(var17_16.a + 1.0E-6 * var19_18 / var23_21, var17_16.b + 1.0E-6 * var21_20 / var23_21);
        }
lbl24: // 4 sources:
        var19_19 = this.a(var9_9, var17_16, var18_17, var16_15, var8_8);
        var20_22 = z.a(var19_19, var11_10);
        var20_22 = t.b(var20_22, var17_16);
        var15_14.e(var20_22.a() + var16_15.a * 0.5, var20_22.b() + var16_15.b * 0.5);
        return var15_14;
    }

    @Override
    public y.c.D a(C c2, I i2, am am2, am am3) {
        boolean bl2 = X.j;
        byte[] arrby = aO.a(this.e);
        n n2 = aW.a(c2.getOrientedBox());
        double d2 = n2.e();
        double d3 = n2.f();
        q q2 = new q(d2, d3);
        y.c.D d4 = new y.c.D();
        v v2 = ae.a(i2, am2, am3, this.d);
        u u2 = v2.b();
        if (!u2.f()) {
            n2.e(am2.getX() + d2 * 0.5, am2.getY() + d3 * 0.5);
            B b2 = new B(n2, this.c(), c2, false);
            d4.add(b2);
            return d4;
        }
        double[] arrd = new double[v2.h() - 1];
        double[] arrd2 = new double[v2.h() - 1];
        double d5 = this.a(v2, arrd, arrd2);
        t t2 = u2.a();
        u2.g();
        int n3 = 0;
        do {
            byte by2 = u2.f();
            block1 : do {
                if (by2 == 0) return d4;
                t t3 = t2;
                t2 = u2.a();
                double d6 = t2.a() - t3.a();
                double d7 = t2.b() - t3.b();
                double[] arrd3 = this.a(d6, d7, d2, d3);
                int n4 = 0;
                block2 : do {
                    int n5 = n4;
                    int n6 = arrby.length;
                    block3 : while (n5 < n6) {
                        boolean bl3 = false;
                        by2 = arrby[n4];
                        if (bl2) continue block1;
                        if (by2 == 0) {
                            bl3 = true;
                        }
                        z z2 = this.a(d6, d7, d2, d3, arrby[n4]);
                        z z3 = z.b(z2);
                        z3.b(this.a);
                        int n7 = 0;
                        block4 : do {
                            ++n7;
                            for (int i3 = 0; i3 < arrd3.length; ++i3) {
                                double d8 = arrd3[i3];
                                t t4 = this.a(d8, t3, t2, q2, arrby[n4]);
                                t t5 = z.a(t4, z3);
                                t5 = t.b(t5, t3);
                                double d9 = arrd2[n3] / d5 + d8 * arrd[n3];
                                n5 = n3;
                                n6 = (v2.h() - 2) / 2;
                                if (bl2) continue block3;
                                int n8 = n5 > n6 ? n3 + 1 - v2.h() : n3;
                                aP aP2 = new aP(n8, d8, z3, arrby[n4], d9);
                                n n9 = new n(n2);
                                n9.e(t5.a() + d2 * 0.5, t5.b() + d3 * 0.5);
                                B b3 = new B(n9, aP2, c2, bl3);
                                d4.add(b3);
                                if (!bl2) continue;
                            }
                            z3.a(z2);
                            do {
                                if (z.a(z3, z2).d() < this.b && this.e != 0 && n7 < 5) continue block4;
                                ++n4;
                            } while (bl2);
                            break;
                        } while (true);
                        if (!bl2) continue block2;
                    }
                    break block1;
                    break;
                } while (true);
                break;
            } while (true);
            u2.g();
            ++n3;
        } while (!bl2);
        return d4;
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

    public z a(double d2, double d3, double d4, double d5, byte by2) {
        if (by2 == 0) {
            return new z(0.0, 0.0);
        }
        double d6 = Math.abs(d2);
        double d7 = Math.abs(d3);
        double d8 = d3 / d2;
        if (Double.isNaN(d8)) {
            d8 = 1.0;
        }
        d4 = Math.max(0.01, d4);
        d5 = Math.max(0.01, d5);
        double d9 = d5 / d4;
        double d10 = d4 * 0.5;
        double d11 = d5 * 0.5;
        if (d7 < d6 * d9) {
            double d12 = d11 + Math.abs(d10 * d8);
            if (!aO.a(by2, d2, d3)) return new z(0.0, d12);
            return new z(0.0, - d12);
        }
        double d13 = d10 + Math.abs(d11 / d8);
        if (!aO.b(by2, d2, d3)) return new z(d13, 0.0);
        return new z(- d13, 0.0);
    }

    private static byte[] a(byte by2) {
        if (by2 == 0) {
            return new byte[]{0};
        }
        if (by2 != 1) throw new IllegalArgumentException(new StringBuffer().append("Unknown model mode ").append(by2).toString());
        return new byte[]{3, 4};
    }

    private double[] a(double d2, double d3, double d4, double d5) {
        int n2;
        boolean bl2;
        block4 : {
            bl2 = X.j;
            d2 = Math.abs(d2);
            if ((d3 = Math.abs(d3)) < d2 * d5 / (d4 = Math.max(0.01, d4))) {
                n2 = Math.max(2, (int)Math.floor(d2 / d4));
                if (!bl2) break block4;
            }
            n2 = Math.max(2, (int)Math.floor(d3 / d5));
        }
        n2 = (int)((double)n2 + (this.c - 1.0) * (double)(n2 - 1));
        n2 = Math.min(n2, 20);
        if ((n2 = Math.max(3, n2)) % 2 == 0) {
            ++n2;
        }
        double d6 = 1.0 / (double)(n2 - 1);
        double[] arrd = new double[n2];
        for (int i2 = n2 - 2; i2 > 0; --i2) {
            arrd[i2] = d6 * (double)i2;
            if (bl2) return arrd;
            if (!bl2) continue;
        }
        arrd[n2 - 1] = 1.0;
        return arrd;
    }

    /*
     * Unable to fully structure code
     */
    private t a(double var1_1, t var3_2, t var4_3, q var5_4, byte var6_5) {
        block7 : {
            block6 : {
                var41_6 = X.j;
                var7_7 = var4_3.a() - var3_2.a();
                var9_8 = var4_3.b() - var3_2.b();
                var11_9 = Math.max(1.0E-7, Math.abs(var7_7));
                var13_10 = Math.abs(var9_8);
                var15_11 = var9_8 / var7_7;
                if (Double.isNaN(var15_11)) {
                    var15_11 = 1.0;
                }
                var17_12 = Math.max(0.01, var5_4.a());
                var19_13 = Math.max(0.01, var5_4.b());
                var21_14 = var19_13 / var17_12;
                var33_15 = var17_12 * 0.5;
                var35_16 = var19_13 * 0.5;
                if (var13_10 >= var11_9 * var21_14) ** GOTO lbl32
                if (var7_7 > 0.0) {
                    var25_17 = 1.0 + var33_15;
                    if (!var41_6) break block6;
                }
                var25_17 = - 1.0 + var33_15;
            }
            var29_18 = var7_7 - var25_17;
            var27_19 = var15_11 * var25_17;
            var31_20 = var9_8 - var27_19;
            if (var6_5 == 0) ** GOTO lbl49
            var37_21 = var35_16 + Math.abs(var33_15 * var15_11);
            if (!aO.a(var6_5, var7_7, var9_8)) ** GOTO lbl29
            var27_19 -= var37_21;
            var31_20 -= var37_21;
            if (!var41_6) ** GOTO lbl49
lbl29: // 2 sources:
            var27_19 += var37_21;
            var31_20 += var37_21;
            if (!var41_6) ** GOTO lbl49
lbl32: // 2 sources:
            var37_21 = 1.0 / var15_11;
            if (var9_8 > 0.0) {
                var27_19 = 1.0 + var35_16;
                if (!var41_6) break block7;
            }
            var27_19 = - 1.0 + var35_16;
        }
        var31_20 = var9_8 - var27_19;
        var25_17 = var27_19 / var15_11;
        var29_18 = var7_7 - var25_17;
        if (var6_5 == 0) ** GOTO lbl49
        var39_22 = var33_15 + Math.abs(var35_16 * var37_21);
        if (!aO.b(var6_5, var7_7, var9_8)) ** GOTO lbl-1000
        var25_17 -= var39_22;
        var29_18 -= var39_22;
        if (var41_6) lbl-1000: // 2 sources:
        {
            var25_17 += var39_22;
            var29_18 += var39_22;
        }
lbl49: // 7 sources:
        var37_21 = var29_18 - var25_17;
        var39_22 = var31_20 - var27_19;
        if (var37_21 * var7_7 < 0.0) return new t((var25_17 + var29_18) * 0.5 - var33_15, (var27_19 + var31_20) * 0.5 - var35_16);
        if (var39_22 * var9_8 >= 0.0) return new t(var25_17 + var37_21 * var1_1 - var33_15, var27_19 + var39_22 * var1_1 - var35_16);
        return new t((var25_17 + var29_18) * 0.5 - var33_15, (var27_19 + var31_20) * 0.5 - var35_16);
    }

    private static boolean a(byte by2, double d2, double d3) {
        if (by2 == 2) {
            return true;
        }
        if (by2 == 1) {
            return false;
        }
        if (d2 > 0.0 && by2 == 3) {
            return true;
        }
        if (d2 >= 0.0) return false;
        if (by2 != 4) return false;
        return true;
    }

    private static boolean b(byte by2, double d2, double d3) {
        if (by2 == 2) {
            return true;
        }
        if (by2 == 1) {
            return false;
        }
        if (d3 > 0.0 && by2 == 4) {
            return true;
        }
        if (d3 >= 0.0) return false;
        if (by2 != 3) return false;
        return true;
    }

    private double a(v v2, double[] arrd, double[] arrd2) {
        u u2;
        boolean bl2;
        double d2;
        t t2;
        t t3;
        double d3;
        double d4;
        block4 : {
            bl2 = X.j;
            t2 = null;
            t3 = null;
            u2 = v2.b();
            if (!u2.f()) {
                return 0.0;
            }
            d2 = 0.0;
            t2 = u2.a();
            u2.g();
            while (u2.f()) {
                t3 = t2;
                t2 = u2.a();
                d4 = t3.a() - t2.a();
                double d5 = t3.b() - t2.b();
                d2 += Math.sqrt(d4 * d4 + d5 * d5);
                u2.g();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block4;
            }
            u2 = v2.b();
            t2 = u2.a();
            u2.g();
            d4 = 0.0;
        }
        int n2 = 0;
        while (u2.f()) {
            t3 = t2;
            t2 = u2.a();
            double d6 = t3.a() - t2.a();
            double d7 = t3.b() - t2.b();
            double d8 = Math.sqrt(d6 * d6 + d7 * d7);
            arrd2[n2] = d4;
            arrd[n2] = d8 / d2;
            d3 = d4 + d8;
            if (bl2) return d3;
            d4 = d3;
            ++n2;
            u2.g();
            if (!bl2) continue;
        }
        d3 = d2;
        return d3;
    }
}

