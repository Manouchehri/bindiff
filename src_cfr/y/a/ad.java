/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import y.a.Z;
import y.a.ae;
import y.a.af;
import y.a.h;
import y.c.A;
import y.c.c;
import y.c.d;
import y.c.i;
import y.c.q;
import y.c.x;
import y.g.M;

class ad {
    ad() {
    }

    /*
     * Unable to fully structure code
     */
    private static void a(List var0, y.c.h var1_1) {
        var4_2 = h.a;
        var2_3 = var0.listIterator();
        do lbl-1000: // 3 sources:
        {
            if (var2_3.hasNext() == false) return;
            var3_4 = (d)var2_3.next();
            if (var3_4.c().a() != 1 && var3_4.d().a() != 1) ** GOTO lbl-1000
            var1_1.a((Object)var3_4, 0.0);
        } while (!var4_2);
    }

    private void a(i i2, d[] arrd) {
        boolean bl2 = h.a;
        int n2 = arrd.length - 1;
        do {
            if (n2 < 0) return;
            if (!i2.f(arrd[n2])) {
                i2.e(arrd[n2]);
            }
            --n2;
        } while (!bl2);
    }

    private void a(i i2, A a2, A a3) {
        boolean bl2 = h.a;
        x x2 = i2.o();
        do {
            if (!x2.f()) return;
            a3.a((Object)x2.e(), a2.a(x2.e()));
            x2.g();
        } while (!bl2);
    }

    private static ArrayList a(List list) {
        ArrayList<d> arrayList;
        boolean bl2 = h.a;
        ArrayList<d> arrayList2 = new ArrayList<d>();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            q q2 = (q)listIterator.next();
            for (d d2 = q2.f(); d2 != null; d2 = d2.g()) {
                arrayList = arrayList2;
                if (bl2) return arrayList;
                arrayList.add(d2);
                if (!bl2 && !bl2) continue;
            }
        }
        arrayList = arrayList2;
        return arrayList;
    }

    private void b(List list, y.c.h h2) {
        boolean bl2 = h.a;
        ListIterator listIterator = list.listIterator();
        do {
            if (!listIterator.hasNext()) return;
            h2.a(listIterator.next(), 0.0);
        } while (!bl2);
    }

    private ArrayList a(ArrayList arrayList) {
        ArrayList arrayList2;
        boolean bl2 = h.a;
        ArrayList arrayList3 = new ArrayList();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            arrayList2 = arrayList3;
            if (bl2) return arrayList2;
            arrayList2.add(listIterator.next());
            if (!bl2) continue;
        }
        arrayList2 = arrayList3;
        return arrayList2;
    }

    private List a(i i2, A a2, int n2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean bl2;
        block5 : {
            bl2 = h.a;
            arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < n2; ++i3) {
                arrayList2.add(new ArrayList());
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            if (n2 == 1) {
                ArrayList arrayList3;
                x x2 = i2.o();
                while (x2.f()) {
                    arrayList3 = (ArrayList)arrayList2.get(0);
                    if (bl2) return arrayList3;
                    arrayList3.add(x2.e());
                    x2.g();
                    if (!bl2) continue;
                }
                arrayList3 = arrayList2;
                return arrayList3;
            }
        }
        x x3 = i2.o();
        while (x3.f()) {
            arrayList = (ArrayList)arrayList2.get(a2.a(x3.e()));
            if (bl2) return arrayList;
            arrayList.add(x3.e());
            x3.g();
            if (!bl2) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    /*
     * Unable to fully structure code
     */
    private double a(d[] var1_1, A var2_2, int var3_3, boolean var4_4) {
        var17_5 = h.a;
        var5_6 = new double[var3_3][var3_3];
        var6_7 = var1_1.length;
        if (!var4_4) ** GOTO lbl10
        for (var7_8 = var6_7 - 1; var7_8 >= 0; --var7_8) {
            block7 : {
                var8_10 = var2_2.a(var1_1[var7_8].c());
                var9_11 = var2_2.a(var1_1[var7_8].d());
                var5_6[var8_10][var9_11] = var5_6[var8_10][var9_11] + 1.0;
                if (!var17_5) continue;
lbl10: // 3 sources:
                for (var7_8 = var6_7 - 1; var7_8 >= 0; --var7_8) {
                    var8_10 = var2_2.a(var1_1[var7_8].c());
                    var9_11 = var2_2.a(var1_1[var7_8].d());
                    var5_6[var8_10][var9_11] = var5_6[var8_10][var9_11] + 1.0;
                    var5_6[var9_11][var8_10] = var5_6[var9_11][var8_10] + 1.0;
                    if (!var17_5) {
                        if (!var17_5) continue;
                    }
                    break block7;
                }
                var7_8 = var3_3 - 1;
            }
            while (var7_8 >= 0) {
                var5_6[var7_8][var7_8] = var5_6[var7_8][var7_8] / 2.0;
                --var7_8;
                if (!var17_5) continue;
            }
            break block0;
        }
        var7_9 = 0.0;
        var9_12 = 0.0;
        var11_13 = var3_3 - 1;
        while (var11_13 >= 0) {
            block8 : {
                var7_9 += var5_6[var11_13][var11_13];
                var12_14 = 0.0;
                var14_15 = 0.0;
                if (var17_5 != false) return var7_9 - var9_12;
                for (var16_16 = var3_3 - 1; var16_16 >= 0; var12_14 += var5_6[var11_13][var16_16], var14_15 += var5_6[var16_16][var11_13], --var16_16) {
                    if (!var17_5) {
                        if (!var17_5) continue;
                    }
                    break block8;
                }
                var9_12 += var12_14 * var14_15;
                --var11_13;
            }
            if (!var17_5) continue;
        }
        var7_9 /= (double)var6_7;
        var9_12 /= (double)(var6_7 * var6_7);
        return var7_9 - var9_12;
    }

    private int a(i i2, List list, A a2, List list2, int n2) {
        int n3;
        boolean bl2 = h.a;
        boolean[] arrbl = new boolean[i2.e()];
        h.a(i2, (q)list.get(0), false, arrbl);
        ListIterator listIterator = list.listIterator();
        do {
            if (!listIterator.hasNext()) return n2;
        } while (arrbl[((q)listIterator.next()).d()]);
        ArrayList<q> arrayList = new ArrayList<q>();
        ArrayList arrayList2 = (ArrayList)list2.get(a2.a((q)list.get(0)));
        ListIterator listIterator2 = list.listIterator();
        while (listIterator2.hasNext()) {
            int n4;
            q q2 = (q)listIterator2.next();
            if (arrbl[q2.d()]) continue;
            a2.a((Object)q2, n2);
            arrayList.add(q2);
            n3 = n4 = arrayList2.indexOf(q2);
            if (bl2) return n3;
            if (n3 < 0) continue;
            arrayList2.remove(n4);
            if (!bl2) continue;
        }
        list2.add(arrayList);
        n3 = n2 + 1;
        return n3;
    }

    private af c(List list, y.c.h h2) {
        af af2;
        boolean bl2 = h.a;
        double d2 = -1.7976931348623157E308;
        af af3 = new af(null);
        af3.a = -1.0;
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            d d3 = (d)listIterator.next();
            if (h2.c(d3) <= d2) continue;
            d2 = h2.c(d3);
            af3.a = h2.c(d3);
            af2 = af3;
            if (bl2) return af2;
            af2.b = d3;
            if (!bl2) continue;
        }
        af2 = af3;
        return af2;
    }

    /*
     * Unable to fully structure code
     */
    private d a(List var1_1, List var2_2, y.c.h var3_3, A var4_4, boolean var5_5, int var6_6) {
        block7 : {
            var16_7 = h.a;
            var7_8 = null;
            if (var6_6 == -1) ** GOTO lbl45
            if (var5_5) ** GOTO lbl-1000
            var8_9 = -1.7976931348623157E308;
            var10_11 = new af(null);
            var10_11.a = -1.0;
            var11_13 = var2_2.listIterator();
            while (var11_13.hasNext()) {
                var12_14 = (d)var11_13.next();
                if (var3_3.c(var12_14) <= var8_9) continue;
                var10_11.a = var8_9 = var3_3.c(var12_14);
                var10_11.b = var12_14;
                if (!var16_7) {
                    if (!var16_7) continue;
                }
                break block7;
            }
            var1_1.set(var6_6, var10_11);
        }
        if (var16_7) lbl-1000: // 2 sources:
        {
            block8 : {
                var8_9 = -1.7976931348623157E308;
                var10_12 = -1.7976931348623157E308;
                var12_14 = new af(null);
                var13_15 = new af(null);
                var12_14.a = -1.0;
                var13_15.a = -1.0;
                var14_16 = var2_2.listIterator();
                while (var14_16.hasNext()) {
                    var15_17 = (d)var14_16.next();
                    if (var4_4.a(var15_17.c()) == var6_6) {
                        if (var3_3.c(var15_17) <= var8_9) continue;
                        var8_9 = var3_3.c(var15_17);
                        var12_14.b = var15_17;
                        var12_14.a = var8_9;
                        if (!var16_7) continue;
                    }
                    if (var3_3.c(var15_17) <= var10_12) continue;
                    var10_12 = var3_3.c(var15_17);
                    var13_15.b = var15_17;
                    var13_15.a = var10_12;
                    if (!var16_7) {
                        if (!var16_7) continue;
                    }
                    break block8;
                }
                var1_1.set(var6_6, var12_14);
            }
            var1_1.add(var13_15);
        }
lbl45: // 4 sources:
        var9_18 = -1.7976931348623157E308;
        var11_13 = var1_1.listIterator();
        while (var11_13.hasNext()) {
            var8_10 = (af)var11_13.next();
            if (var8_10.a <= var9_18) continue;
            var9_18 = var8_10.a;
            v0 = var8_10.b;
            if (var16_7 != false) return v0;
            var7_8 = v0;
            if (!var16_7) continue;
        }
        v0 = var7_8;
        return v0;
    }

    /*
     * Unable to fully structure code
     */
    int a(i var1_1, A var2_2, int var3_3, int var4_4, boolean var5_5, c var6_6) {
        var24_7 = h.a;
        if (var1_1.g() == 0) {
            return h.a(var1_1, var2_2);
        }
        var7_8 = var1_1.n();
        var8_9 = h.a(var1_1, var2_2);
        var10_10 = this.a(var1_1, var2_2, var8_9);
        var11_11 = new ArrayList<af>();
        var12_12 = -1.7976931348623157E308;
        var14_13 = M.a(new int[var1_1.e()]);
        var15_14 = 0;
        if (var8_9 >= var3_3) {
            var12_12 = this.a(var7_8, var2_2, var8_9, var5_5);
            this.a(var1_1, var2_2, var14_13);
            var15_14 = var8_9;
        }
        var16_15 = var1_1.u();
        var18_16 = null;
        var19_17 = null;
        var20_18 = -1;
        var21_19 = 0;
        var22_20 = var10_10.listIterator();
        while (var22_20.hasNext()) {
            block10 : {
                var23_22 = (ArrayList)var22_20.next();
                var18_16 = ad.a(var23_22);
                if (var6_6 == null) {
                    Z.a(var1_1, var23_22, var18_16, var16_15, var5_5);
                    if (!var24_7) break block10;
                }
                Z.a(var1_1, var23_22, var18_16, var16_15, var5_5, var6_6);
            }
            ad.a(var18_16, var16_15);
            var11_11.add(this.c(var18_16, var16_15));
        }
        block1 : do {
            var19_17 = this.a(var11_11, var18_16, var16_15, var2_2, (boolean)var21_19, var20_18);
            var1_1.d(var19_17);
            var20_18 = var2_2.a(var19_17.c());
            var17_24 = this.a((ArrayList)var10_10.get(var20_18));
            var9_23 = this.a(var1_1, var17_24, var2_2, var10_10, var8_9);
            if (var9_23 <= var8_9) ** GOTO lbl46
            var21_19 = 1;
            if (var9_23 >= var3_3 && var9_23 <= var4_4 && (var22_21 = this.a(var7_8, var2_2, var9_23, var5_5)) > var12_12) {
                var12_12 = var22_21;
                var15_14 = var9_23;
                this.a(var1_1, var2_2, var14_13);
            }
            var8_9 = var9_23;
            if (!var24_7) ** GOTO lbl49
lbl46: // 2 sources:
            v0 = 0;
            do {
                block11 : {
                    var21_19 = v0;
lbl49: // 2 sources:
                    var18_16 = ad.a(var17_24);
                    this.b(var18_16, var16_15);
                    if (var6_6 == null) {
                        Z.a(var1_1, var17_24, var18_16, var16_15, var5_5);
                        if (!var24_7) break block11;
                    }
                    Z.a(var1_1, var17_24, var18_16, var16_15, var5_5, var6_6);
                }
                ad.a(var18_16, var16_15);
                if (var9_23 < var4_4 && var1_1.g() != 0) continue block1;
                this.a(var1_1, var7_8);
                this.a(var1_1, var14_13, var2_2);
                var1_1.a(var16_15);
                v0 = var15_14;
            } while (var24_7);
            break;
        } while (true);
        return v0;
    }
}

