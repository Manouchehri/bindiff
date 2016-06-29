/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import y.c.A;
import y.c.d;
import y.c.h;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.aS;
import y.f.aT;
import y.f.b.c;
import y.g.M;
import y.g.ar;
import y.g.e;

public class aR {
    /*
     * Unable to fully structure code
     */
    public static void a(i var0, y.c.c var1_1, int var2_2, int var3_3) {
        var28_4 = X.j;
        if (var0 == null) return;
        if (var1_1 == null) {
            return;
        }
        var4_5 = new i();
        var5_6 = var4_5.u();
        var6_7 = var4_5.t();
        aR.a(var4_5, var5_6, var0, var1_1, var6_7, var3_3);
        var7_8 = new int[var4_5.f()];
        var8_9 = new int[var4_5.f()];
        var9_10 = Double.MAX_VALUE;
        var11_11 = new ar(7);
        var12_12 = M.a(new boolean[var4_5.f()]);
        var13_13 = new y();
        var14_14 = new y();
        var15_15 = var4_5.o();
        while (var15_15.f()) {
            var16_16 = var15_15.e();
            var17_17 = (aT)var6_7.b(var16_16);
            if (!var17_17.b()) ** GOTO lbl-1000
            var13_13.add(var16_16);
            var12_12.a((Object)var16_16, false);
            if (var28_4) lbl-1000: // 2 sources:
            {
                var14_14.add(var16_16);
                var12_12.a((Object)var16_16, true);
            }
            var15_15.g();
            if (!var28_4) continue;
        }
        var15_15 = var13_13.e();
        var16_16 = var14_14.e();
        var17_17 = var6_7;
        var18_18 = new aS((A)var17_17);
        e.a(var16_16, (Comparator)var18_18);
        var19_19 = aR.a(var15_15, (q[])var16_16, var11_11);
        var20_20 = 0;
        block1 : while (var20_20 < var2_2) {
            block16 : {
                var21_22 = 0;
                while (var21_22 < var19_19.length) {
                    var7_8[var19_19[var21_22].d()] = var21_22++;
                    if (var28_4) continue block1;
                    if (!var28_4) continue;
                }
                var21_23 = aR.a(var4_5, var5_6, var7_8);
                block3 : do {
                    var23_25 = false;
                    var24_26 = 1;
                    block4 : do {
                        v0 = var24_26;
                        do {
                            if (v0 < var19_19.length) {
                                v1 = var12_12.d(var19_19[var24_26 - 1]);
                                if (!var28_4) {
                                    if (!(v1 && var12_12.d(var19_19[var24_26]) || (var25_27 = aR.a(var19_19[var24_26 - 1], var19_19[var24_26], var7_8, var5_6)) >= 0.0)) {
                                        v2 = var7_8;
                                        v3 = var19_19[var24_26 - 1].d();
                                        v2[v3] = v2[v3] + 1;
                                        v4 = var7_8;
                                        v5 = var19_19[var24_26].d();
                                        v4[v5] = v4[v5] - 1;
                                        var27_28 = var19_19[var24_26 - 1];
                                        var19_19[var24_26 - 1] = var19_19[var24_26];
                                        var19_19[var24_26] = var27_28;
                                        var21_23 += var25_27;
                                        var23_25 = true;
                                    }
                                    ++var24_26;
                                    if (!var28_4) continue block4;
                                }
                            } else {
                                v1 = var23_25;
                            }
                            if (v1) continue block3;
                            v0 = (int)(var9_10 DCMPL var21_23);
                        } while (var28_4);
                        break;
                    } while (true);
                    break;
                } while (true);
                if (v0 > 0) {
                    for (var24_26 = 0; var24_26 < var7_8.length; ++var24_26) {
                        var8_9[var24_26] = var7_8[var24_26];
                        if (!var28_4) {
                            if (!var28_4) continue;
                        }
                        break block16;
                    }
                    var9_10 = var21_23;
                }
                var19_19 = aR.a(var15_15, (q[])var16_16, var11_11);
                ++var20_20;
            }
            if (!var28_4) continue;
        }
        var20_21 = var4_5.o();
        while (var20_21.f()) {
            var21_24 = var20_21.e();
            var22_29 = (aT)var6_7.b(var21_24);
            var22_29.a(var8_9[var21_24.d()]);
            var20_21.g();
            if (var28_4 != false) return;
            if (!var28_4) continue;
        }
        var4_5.a(var6_7);
        var4_5.a(var5_6);
        var4_5.j();
    }

    private static q[] a(q[] arrq, q[] arrq2, ar ar2) {
        q[] arrq3;
        boolean bl2 = X.j;
        ar2.a(arrq);
        q[] arrq4 = new q[arrq.length + arrq2.length];
        int n2 = 0;
        int n3 = 0;
        for (int i2 = 0; i2 < arrq4.length; ++i2) {
            arrq3 = arrq;
            if (bl2) return arrq3;
            int n4 = arrq3.length - n2 + arrq2.length - n3;
            if (ar2.nextInt(n4) < arrq.length - n2) {
                arrq4[i2] = arrq[n2++];
                if (!bl2) continue;
            }
            arrq4[i2] = arrq2[n3++];
            if (!bl2) continue;
        }
        arrq3 = arrq4;
        return arrq3;
    }

    private static void a(i i2, h h2, i i3, y.c.c c2, A a2, int n2) {
        boolean bl2 = X.j;
        HashMap<Object, q> hashMap = new HashMap<Object, q>();
        d[][] arrd = i3.o();
        while (arrd.f()) {
            q q2 = arrd.e();
            Object object = c2.b(q2);
            if (object != null && !hashMap.containsKey(object)) {
                q q3 = i2.d();
                hashMap.put(object, q3);
                a2.a((Object)q3, object);
            }
            arrd.g();
            if (!bl2) continue;
        }
        arrd = new d[i2.f()][i2.f()];
        if (n2 == 1 || n2 == 2) {
            aR.b(i3, i2, c2, hashMap, h2, arrd);
        }
        if (n2 != 0) {
            if (n2 != 2) return;
        }
        aR.a(i3, i2, c2, hashMap, h2, arrd);
    }

    /*
     * Unable to fully structure code
     */
    private static void a(i var0, i var1_1, y.c.c var2_2, Map var3_3, h var4_4, d[][] var5_5) {
        var17_6 = X.j;
        var6_7 = var1_1.m();
        var7_8 = var0.p();
        do {
            if (var7_8.f() == false) return;
            var8_9 = var7_8.a();
            var9_10 = var2_2.b(var8_9.c());
            var10_11 = var2_2.b(var8_9.d());
            if (var9_10 == null || var10_11 == null || (var11_12 = (q)var3_3.get(var9_10)) == (var12_13 = (q)var3_3.get(var10_11))) ** GOTO lbl18
            var13_14 = Math.min(var11_12.d(), var12_13.d());
            if (var5_5[var13_14][var14_15 = Math.max(var11_12.d(), var12_13.d())] != null) ** GOTO lbl-1000
            var5_5[var13_14][var14_15] = var15_16 = var1_1.a(var6_7[var13_14], var6_7[var14_15]);
            var4_4.a((Object)var15_16, 1);
            if (var17_6) lbl-1000: // 2 sources:
            {
                var15_16 = var5_5[var13_14][var14_15];
                var16_17 = var4_4.a(var15_16);
                var4_4.a((Object)var15_16, var16_17 + 1);
            }
lbl18: // 4 sources:
            var7_8.g();
        } while (!var17_6);
    }

    private static void b(i i2, i i3, y.c.c c2, Map map, h h2, d[][] arrd) {
        boolean bl2 = X.j;
        if (!c.b(i2)) {
            return;
        }
        c c3 = new c(i2);
        A a2 = i3.t();
        x x2 = i2.o();
        block0 : do {
            int n2 = x2.f();
            block1 : while (n2 != 0) {
                q q2 = x2.e();
                if (bl2) return;
                if (c3.d(q2)) {
                    Object object;
                    y y2 = new y();
                    q[] arrq = c3.c(q2).a();
                    while (arrq.f()) {
                        q q3;
                        q q4 = arrq.e();
                        n2 = c3.d(q4);
                        if (bl2) continue block1;
                        if (n2 == 0 && (object = c2.b(q4)) != null && !a2.d(q3 = (q)map.get(object))) {
                            y2.add(q3);
                            a2.a((Object)q3, true);
                        }
                        arrq.g();
                        if (!bl2) continue;
                    }
                    arrq = y2.e();
                    int n3 = 0;
                    block3 : do {
                        int n4 = n3;
                        int n5 = arrq.length - 1;
                        block4 : while (n4 < n5) {
                            object = arrq[n3];
                            n2 = n3 + 1;
                            if (bl2) continue block1;
                            for (int i4 = v842868; i4 < arrq.length; ++i4) {
                                Object object2;
                                d d2;
                                q q5 = arrq[i4];
                                n4 = object.d();
                                n5 = q5.d();
                                if (bl2) continue block4;
                                Object object3 = n4 < n5 ? object : q5;
                                Object object4 = object2 = object.d() < q5.d() ? q5 : object;
                                if (arrd[object3.d()][object2.d()] == null) {
                                    arrd[object3.d()][object2.d()] = d2 = i3.a((q)object3, (q)object2);
                                    h2.a((Object)d2, 10);
                                    if (!bl2) continue;
                                }
                                d2 = arrd[object3.d()][object2.d()];
                                int n6 = h2.a(d2);
                                h2.a((Object)d2, n6 + 10);
                                if (!bl2) continue;
                            }
                            ++n3;
                            if (!bl2) continue block3;
                        }
                        break block3;
                        break;
                    } while (true);
                    x x3 = y2.a();
                    while (x3.f()) {
                        a2.a((Object)x3.e(), false);
                        x3.g();
                        if (bl2) continue block0;
                        if (!bl2) continue;
                    }
                }
                x2.g();
                if (!bl2) continue block0;
            }
            break block0;
            break;
        } while (true);
        i3.a(a2);
    }

    /*
     * Unable to fully structure code
     */
    private static double a(q var0, q var1_1, int[] var2_2, y.c.c var3_3) {
        var10_4 = X.j;
        var4_5 = 0;
        var5_6 = var2_2[var0.d()];
        var6_7 = var2_2[var1_1.d()];
        var7_8 = var0.j();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            v0 = var9_10 = var2_2[var8_9.a(var0).d()];
            v1 = var6_7;
            if (!var10_4) {
                if (v0 != v1) {
                    var4_5 = (int)((double)var4_5 + (double)var3_3.a(var8_9) * (aR.a(var5_6 + 1, var9_10) - aR.a(var5_6, var9_10)));
                }
                var7_8.g();
                if (!var10_4) continue;
            }
            ** GOTO lbl22
        }
        var7_8 = var1_1.j();
        while (var7_8.f()) {
            var8_9 = var7_8.a();
            v0 = var9_10 = var2_2[var8_9.a(var1_1).d()];
            if (var10_4 != false) return v0;
            v1 = var5_6;
lbl22: // 2 sources:
            if (v0 != v1) {
                var4_5 = (int)((double)var4_5 + (double)var3_3.a(var8_9) * (aR.a(var6_7 - 1, var9_10) - aR.a(var6_7, var9_10)));
            }
            var7_8.g();
            if (!var10_4) continue;
        }
        v0 = var4_5;
        return v0;
    }

    private static double a(i i2, y.c.c c2, int[] arrn) {
        boolean bl2 = X.j;
        double d2 = 0.0;
        x x2 = i2.o();
        block0 : do {
            if (!x2.f()) return d2;
            q q2 = x2.e();
            int n2 = arrn[q2.d()];
            y.c.e e2 = q2.l();
            while (e2.f()) {
                d d3 = e2.a();
                int n3 = arrn[d3.d().d()];
                d2 += (double)c2.a(d3) * aR.a(n2, n3);
                e2.g();
                if (bl2) continue block0;
                if (!bl2) continue;
            }
            x2.g();
        } while (!bl2);
        return d2;
    }

    private static double a(int n2, int n3) {
        return Math.pow(Math.abs(n2 - n3), 2.0);
    }
}

