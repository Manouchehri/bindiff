/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import y.c.D;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.d.c;
import y.d.m;
import y.d.t;
import y.f.X;
import y.f.a;
import y.f.aE;
import y.f.ah;
import y.f.am;
import y.f.an;
import y.f.ax;
import y.f.i.L;
import y.f.i.M;
import y.f.i.N;
import y.f.i.O;
import y.f.i.P;
import y.f.i.Q;
import y.f.i.R;
import y.f.i.S;
import y.f.i.U;
import y.f.i.V;
import y.f.i.W;
import y.f.i.v;
import y.g.a.d;
import y.g.e;

public class K
extends a {
    public static final Object a = "y.layout.router.OrthogonalSegmentDistributionStage.AFFECTED_EDGES";
    private X b;
    private boolean c;
    private Comparator d;
    private int[] e;
    private int[] f;
    private double g = 10.0;
    private Object h = a;
    private boolean i;
    private double n = 10.0;
    private double o;
    private double p;
    private boolean q;
    private boolean r = true;
    private boolean s = true;
    private byte t;

    public K() {
        this.d = new L(this);
    }

    @Override
    public void c(X x2) {
        this.b = x2;
        this.a(x2);
        if (x2.h() == 0) {
            return;
        }
        int n2 = x2.g() * 2;
        byte[] arrby = new byte[n2 * (n2 - 1) / 2];
        this.t = 0;
        this.a(x2, arrby);
        an an2 = new an(3);
        an2.a(new M(this, arrby));
        an2.c(x2);
        this.a(arrby);
        this.q = true;
        this.t = 0;
        this.b(x2);
        an2 = new an(3);
        this.q = false;
        an2.a(new N(this));
        an2.c(x2);
    }

    private void a(X x2, byte[] arrby) {
        List list = this.f(x2);
        list.addAll(this.e(x2));
        e.a(list, null);
        this.a(list, arrby);
    }

    private void b(X x2) {
        List list = this.f(x2);
        list.addAll(this.e(x2));
        e.a(list, null);
        this.a(list);
    }

    private void a(List list) {
        int n2 = v.f;
        ArrayList<R> arrayList = new ArrayList<R>();
        double d2 = -1.7976931348623157E308;
        c c2 = new c(-1.7976931348623157E308);
        for (int i2 = 0; i2 < list.size(); ++i2) {
            W w2;
            R r2 = (R)list.get(i2);
            byte by2 = r2.k();
            if (n2 != 0) return;
            if (by2 == 0) {
                if (Math.abs(r2.j() - d2) < 5.0) {
                    arrayList.add(r2);
                    if (n2 == 0) continue;
                }
                if (arrayList.size() > 0) {
                    this.a(arrayList, c2, i2, list);
                }
                arrayList.add(r2);
                d2 = r2.j();
                if (n2 == 0) continue;
            }
            if (by2 == 2) {
                if (arrayList.size() > 0) {
                    this.a(arrayList, c2, i2, list);
                }
                w2 = (W)r2;
                c2.c(w2.b().c().b() - 2.0, w2.b().d().b() + 2.0, r2.j());
                if (n2 == 0) continue;
            }
            if (by2 != 1) continue;
            if (arrayList.size() > 0) {
                this.a(arrayList, c2, i2, list);
            }
            w2 = (W)r2;
            c2.c(w2.b().c().b(), w2.b().d().b(), r2.j());
            if (n2 == 0) continue;
        }
        this.a(arrayList, c2, list.size(), list);
    }

    private void a(List list, byte[] arrby) {
        int n2;
        ArrayList<R> arrayList;
        block9 : {
            int n3 = v.f;
            arrayList = new ArrayList<R>();
            double d2 = -1.7976931348623157E308;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                R r2 = (R)list.get(i2);
                byte by2 = r2.k();
                n2 = by2;
                if (n3 == 0) {
                    if (n2 == 0) {
                        if (Math.abs(r2.j() - d2) < 5.0) {
                            arrayList.add(r2);
                            if (n3 == 0) continue;
                        }
                        if (arrayList.size() > 1) {
                            this.b(arrayList, arrby);
                        }
                        arrayList.clear();
                        arrayList.add(r2);
                        d2 = r2.j();
                        if (n3 == 0) continue;
                    }
                    if (by2 == 2) {
                        if (arrayList.size() > 1) {
                            this.b(arrayList, arrby);
                        }
                        arrayList.clear();
                        if (n3 == 0) continue;
                    }
                    if (by2 != 1) continue;
                    if (arrayList.size() > 1) {
                        this.b(arrayList, arrby);
                    }
                    arrayList.clear();
                    if (n3 == 0) continue;
                }
                break block9;
            }
            n2 = arrayList.size();
        }
        if (n2 > 1) {
            this.b(arrayList, arrby);
        }
        arrayList.clear();
    }

    /*
     * Unable to fully structure code
     */
    private void a(byte[] var1_1) {
        block24 : {
            block23 : {
                block22 : {
                    block21 : {
                        block20 : {
                            var16_2 = v.f;
                            var2_3 = new i();
                            var3_4 = new q[this.b.g() * 2];
                            for (var4_5 = 0; var4_5 < this.b.g() * 2; ++var4_5) {
                                var3_4[var4_5] = var2_3.d();
                                if (var16_2 == 0) {
                                    if (var16_2 == 0) continue;
                                }
                                break block20;
                            }
                            var4_5 = 1;
                        }
                        block1 : do {
                            v0 = var4_5;
                            block2 : while (v0 < this.b.g() * 2) {
                                v1 = 0;
                                if (var16_2 != 0) break block21;
                                for (var5_7 = v1860187; var5_7 < var4_5; ++var5_7) {
                                    v0 = var6_8 = var1_1[var4_5 * (var4_5 - 1) / 2 + var5_7];
                                    if (var16_2 != 0) continue block2;
                                    if (v0 > 0) {
                                        var2_3.a(var3_4[var4_5], var3_4[var5_7]);
                                        if (var16_2 == 0) continue;
                                    }
                                    if (var6_8 >= 0) continue;
                                    var2_3.a(var3_4[var5_7], var3_4[var4_5]);
                                    if (var16_2 == 0) continue;
                                }
                                ++var4_5;
                                if (var16_2 == 0) continue block1;
                            }
                            break block1;
                            break;
                        } while (true);
                        v1 = var2_3.e();
                    }
                    var4_6 = new int[v1];
                    var5_7 = var2_3.e() / 2;
                    var6_8 = 1;
                    block4 : do lbl-1000: // 3 sources:
                    {
                        v2 = var6_8;
                        block5 : while (v2 != 0) {
                            var6_8 = 0;
                            y.a.m.b(var2_3, var4_6);
                            var7_9 = var2_3.p();
                            do {
                                if (!var7_9.f()) ** GOTO lbl-1000
                                var8_10 = var7_9.a();
                                var9_12 = var8_10.c().d();
                                var10_14 = var8_10.d().d();
                                v2 = var4_6[var9_12];
                                if (var16_2 != 0) continue block5;
                                if (v2 < var4_6[var10_14]) {
                                    var9_12 = var9_12 >= var5_7 ? var9_12 - var5_7 : var9_12 + var5_7;
                                    var10_14 = var10_14 >= var5_7 ? var10_14 - var5_7 : var10_14 + var5_7;
                                    var2_3.a(var8_10);
                                    var2_3.a(var3_4[var9_12].b(var3_4[var10_14]));
                                    var6_8 = 1;
                                    if (var16_2 == 0) continue block4;
                                }
                                var7_9.g();
                            } while (var16_2 == 0);
                        }
                        break block4;
                        break;
                    } while (true);
                    var7_9 = new d(var2_3);
                    var8_11 = 1;
                    var9_13 = new int[var2_3.e()];
                    for (var10_14 = 0; var10_14 < var4_6.length; ++var10_14) {
                        var4_6[var10_14] = 0;
                        if (var16_2 == 0) {
                            if (var16_2 == 0) continue;
                        }
                        break block22;
                    }
                    var10_14 = 0;
                }
                while (var10_14 < var3_4.length) {
                    var11_15 = var3_4[var10_14];
                    v3 = var11_15.b();
                    if (var16_2 != 0) break block23;
                    if (v3 != 0) ** GOTO lbl-1000
                    v4 = var12_17 = var10_14 < var5_7 ? var10_14 + var5_7 : var10_14 - var5_7;
                    if (var4_6[var12_17] == 0) ** GOTO lbl-1000
                    var4_6[var10_14] = - var4_6[var12_17];
                    var7_9.a(var11_15, var4_6[var10_14]);
                    if (var16_2 != 0) lbl-1000: // 2 sources:
                    {
                        var4_6[var10_14] = var8_11;
                        var7_9.a(var11_15, var8_11++);
                        ** if (var16_2 == 0) goto lbl79
                    }
                    ** GOTO lbl79
lbl-1000: // 2 sources:
                    {
                        var9_13[var10_14] = var11_15.b();
                    }
lbl79: // 3 sources:
                    ++var10_14;
                    if (var16_2 == 0) continue;
                }
                v3 = 1;
            }
            var10_14 = v3;
            block9 : do {
                v5 = var7_9.a();
                block10 : while (!v5) {
                    var11_15 = var7_9.c();
                    var4_6[var11_15.d()] = var10_14++;
                    var12_18 = var11_15.f();
                    do {
                        if (var12_18 == null) continue block9;
                        var13_19 = var12_18.d();
                        var14_20 = var9_13[var13_19.d()];
                        v6 = var9_13;
                        v7 = var13_19.d();
                        v6[v7] = v6[v7] - 1;
                        v8 = var14_20;
                        if (var16_2 != 0) break block24;
                        if (var16_2 != 0) continue block10;
                        if (v8 != 1) ** GOTO lbl107
                        v9 = var15_21 = var13_19.d() < var5_7 ? var3_4[var13_19.d() + var5_7] : var3_4[var13_19.d() - var5_7];
                        if (var4_6[var15_21.d()] == 0) ** GOTO lbl-1000
                        var7_9.a(var13_19, - var4_6[var15_21.d()]);
                        if (var16_2 != 0) lbl-1000: // 2 sources:
                        {
                            var4_6[var13_19.d()] = var8_11;
                            var7_9.a(var13_19, var8_11++);
                        }
lbl107: // 4 sources:
                        var12_18 = var12_18.g();
                    } while (var16_2 == 0);
                }
                break block9;
                break;
            } while (true);
            v8 = var11_16 = 0;
        }
        while (var11_16 < var4_6.length) {
            var4_6[var11_16] = - var4_6[var11_16];
            ++var11_16;
            if (var16_2 != 0) return;
            if (var16_2 == 0) continue;
        }
        this.e = new int[this.b.g()];
        this.f = new int[this.b.g()];
        System.arraycopy(var4_6, 0, this.e, 0, this.e.length);
        System.arraycopy(var4_6, this.e.length, this.f, 0, this.f.length);
    }

    private y.c.c d(X x2) {
        y.c.c c2 = x2.c(this.h);
        if (c2 != null) return c2;
        return new O(this);
    }

    private void a(List arrayList, c c2, int n2, List list) {
        ArrayList<Q> arrayList2;
        block14 : {
            int n3;
            int n4;
            Object object;
            block12 : {
                n3 = v.f;
                if (arrayList.size() < 2) {
                    if (arrayList.size() > 0) {
                        object = (Q)arrayList.get(0);
                        this.a(c2, (Q)object);
                    }
                    arrayList.clear();
                    if (n3 == 0) return;
                }
                object = new ArrayList(arrayList.size() * 2);
                for (Q q2 : arrayList) {
                    n4 = q2.f();
                    if (n3 == 0) {
                        double d2;
                        double d3;
                        if (n4 != 0) {
                            this.a(c2, q2);
                            if (n3 == 0) continue;
                        }
                        if ((d2 = q2.a().c().b()) <= (d3 = q2.a().d().b())) {
                            object.add(new P(3, d2, q2));
                            object.add(new P(4, d3, q2));
                            if (n3 == 0) continue;
                        }
                        object.add(new P(3, d3, q2));
                        object.add(new P(4, d2, q2));
                        if (n3 == 0) continue;
                    }
                    break block12;
                }
                e.a((List)object, null);
                n4 = 0;
            }
            int n5 = n4;
            double d4 = 0.0;
            double d5 = 0.0;
            ArrayList<Q> arrayList3 = new ArrayList<Q>();
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                P p2 = (P)iterator.next();
                if (p2.k() == 3) {
                    block13 : {
                        if (n5 == 0) {
                            d4 = p2.j();
                            if (n3 == 0) break block13;
                        }
                        d4 = Math.min(p2.j(), d4);
                    }
                    arrayList3.add(p2.a());
                    ++n5;
                    if (n3 == 0) continue;
                }
                d5 = Math.max(p2.j(), d5);
                if (--n5 != 0) continue;
                arrayList2 = arrayList3;
                if (n3 == 0) {
                    if (arrayList2.size() > 1) {
                        c c3 = this.a(n2, list, arrayList3, d4 - 10.0, d5 + 10.0);
                        this.a(arrayList3, c2, c3);
                    }
                    arrayList3.clear();
                    if (n3 == 0) continue;
                }
                break block14;
            }
            arrayList2 = arrayList;
        }
        arrayList2.clear();
    }

    private void a(c c2, Q q2) {
        double d2 = q2.a().c().b();
        double d3 = q2.a().d().b();
        double d4 = Math.min(d2, d3);
        double d5 = Math.max(d2, d3);
        c2.c(d4, d5, q2.a().c().a());
    }

    /*
     * Unable to fully structure code
     */
    private void b(List var1_1, byte[] var2_2) {
        block7 : {
            var12_3 = v.f;
            var3_4 = new ArrayList<P>(var1_1.size() * 2);
            for (Q var5_7 : var1_1) {
                v0 = var5_7.f();
                if (var12_3 == 0) {
                    if (v0 != 0) continue;
                    var6_9 = var5_7.a().c().b();
                    if (var6_9 <= (var8_10 = var5_7.a().d().b())) {
                        var3_4.add(new P(3, var6_9, var5_7));
                        var3_4.add(new P(4, var8_10, var5_7));
                        if (var12_3 == 0) continue;
                    }
                    var3_4.add(new P(3, var8_10, var5_7));
                    var3_4.add(new P(4, var6_9, var5_7));
                    if (var12_3 == 0) continue;
                }
                break block7;
            }
            e.a(var3_4, null);
            v0 = 0;
        }
        var4_6 = v0;
        var5_8 = 0.0;
        var7_11 = 0.0;
        var9_12 = new ArrayList<Q>();
        var10_13 = var3_4.iterator();
        do lbl-1000: // 4 sources:
        {
            block8 : {
                if (var10_13.hasNext() == false) return;
                var11_14 = (P)var10_13.next();
                if (var11_14.k() != 3) ** GOTO lbl36
                if (var4_6 == 0) {
                    var5_8 = var11_14.j();
                    if (var12_3 == 0) break block8;
                }
                var5_8 = Math.min(var11_14.j(), var5_8);
            }
            var9_12.add(var11_14.a());
            ++var4_6;
            if (var12_3 == 0) ** GOTO lbl-1000
lbl36: // 2 sources:
            var7_11 = Math.max(var11_14.j(), var7_11);
            if (--var4_6 != 0) ** GOTO lbl-1000
            if (var9_12.size() > 1) {
                this.c(var9_12, var2_2);
            }
            var9_12.clear();
        } while (var12_3 == 0);
    }

    private c a(int n2, List list, List list2, double d2, double d3) {
        double d4;
        int n3 = v.f;
        int n4 = list2.size();
        double d5 = -1.7976931348623157E308;
        for (Q q2 : list2) {
            am am2;
            double d6;
            y.c.d d7 = q2.e();
            if (q2.h()) {
                am2 = ((X)d7.a()).a(d7.c());
                d6 = am2.getX() + am2.getWidth();
                d5 = Math.max(d5, d6 + 1.0);
            }
            if (!q2.i()) continue;
            am2 = ((X)d7.a()).a(d7.c());
            d6 = am2.getX() + am2.getWidth();
            d5 = Math.max(d5, d6 + 1.0);
            if (n3 == 0) continue;
        }
        c c2 = new c(Double.MAX_VALUE);
        double d8 = d4 = ((R)list.get(n2 - 1)).j() + this.b() * (double)(n4 + 1);
        for (int i2 = n2; i2 < list.size(); ++i2) {
            double d9;
            W w2;
            byte by2;
            double d10;
            R r2 = (R)list.get(i2);
            d8 = r2.j();
            if (n3 != 0) return c2;
            if (d5 > -1.7976931348623157E308) {
                if (d8 > d5) {
                    break;
                }
            } else if (d8 > d4) break;
            if ((by2 = r2.k()) == 0) continue;
            if (by2 == 2) {
                w2 = (W)r2;
                d10 = w2.b().c().b();
                d9 = w2.b().d().b();
                if (d9 <= d2 || d10 >= d3) continue;
                d10 = Math.max(d2, d10);
                d9 = Math.min(d9, d3);
                c2.a(d10, d9, r2.j());
                if (n3 == 0) continue;
            }
            if (by2 != 1) continue;
            w2 = (W)r2;
            d10 = w2.b().c().b() - 2.0;
            d9 = w2.b().d().b() + 2.0;
            if (d9 <= d2 || d10 >= d3) continue;
            d10 = Math.max(d10, d2);
            d9 = Math.min(d9, d3);
            c2.a(d10, d9, r2.j());
            if (n3 == 0) continue;
        }
        c2.a(d2 - 20.0, d3 + 20.0, d8);
        return c2;
    }

    /*
     * Unable to fully structure code
     */
    private void a(List var1_1, c var2_2, c var3_3) {
        var25_4 = v.f;
        var4_5 = new S();
        var4_5.c(Double.NaN);
        var4_5.a(this.d);
        if (this.i) {
            var4_5.a(this.n);
            var4_5.b(this.q != false ? this.o : this.p);
        }
        var7_6 = this.n;
        var9_7 = 0;
        var10_8 = 0;
        block0 : do {
            var5_9 = this.b();
            block1 : do {
                block9 : {
                    var4_5.a();
                    for (Q var12_13 : var1_1) {
                        var13_15 = var12_13.a();
                        var4_5.a(var12_13, 0.0, var5_9, var13_15.c().b(), var12_13.b(), var13_15.d().b(), var12_13.c(), var12_13.d());
                        if (var25_4 == 0) {
                            if (var25_4 == 0) continue;
                        }
                        break block9;
                    }
                    var4_5.a(var3_3);
                    var4_5.b(var2_2);
                    var4_5.c();
                }
                var11_10 = var4_5.d();
                var13_14 = var1_1.size();
                v0 = this.s;
                do lbl-1000: // 3 sources:
                {
                    if (v0 != 0 && var4_5.d() > 0.001 && (var5_9 -= var11_10 / (double)(var13_14 + 1)) > 0.1 && ++var9_7 <= 20) continue block1;
                    var4_5.a(var7_6 /= 2.0);
                    v0 = this.i;
                    if (var25_4 != 0) ** GOTO lbl-1000
                    if (v0 != 0 && this.r && var4_5.d() > 0.0 && var7_6 >= 1.0 && var10_8 <= 20) continue block0;
                    v0 = var4_5.d() DCMPL 0.001;
                } while (var25_4 != 0);
                break;
            } while (true);
            break;
        } while (true);
        if (v0 > 0) {
            return;
        }
        for (Q var12_13 : var1_1) {
            var13_16 = var4_5.a(var12_13);
            var15_17 = var12_13.e();
            if (var12_13.f() || Double.isNaN(var13_16)) continue;
            var16_18 = ((X)var15_17.a()).m(var15_17);
            var17_19 = var16_18.b(var12_13.g());
            var18_20 = (t)var17_19.c();
            var19_21 = var16_18.b(var12_13.g() + 1);
            var20_22 = (t)var19_21.c();
            var18_20 = new t(var13_16, var18_20.b);
            var20_22 = new t(var13_16, var20_22.b);
            var21_23 = Math.min(var18_20.b, var20_22.b);
            if (var21_23 + 2.0 < (var23_24 = Math.max(var18_20.b, var20_22.b)) - 2.0) {
                var21_23 += 1.0;
                var23_24 -= 1.0;
            }
            var2_2.b(var21_23, var23_24, var13_16);
            var17_19.a(var18_20);
            var19_21.a(var20_22);
            this.b.a(var15_17, var16_18);
            if (var25_4 == 0) continue;
        }
        var4_5.a();
    }

    private void c(List list, byte[] arrby) {
        int n2 = v.f;
        S s2 = new S();
        U[] arru = new U[list.size()];
        int n3 = 0;
        for (Q q2 : list) {
            m m2 = q2.a();
            arru[n3] = s2.a(q2, 0.0, 10.0, m2.c().b(), q2.b(), m2.d().b(), q2.c());
            ++n3;
            if (n2 == 0) continue;
        }
        V v2 = new V(null);
        int n4 = this.b.g();
        int n5 = 0;
        do {
            int n6 = n5;
            int n7 = arru.length;
            block2 : do {
                if (n6 >= n7) return;
                U u2 = arru[n5];
                for (int i2 = n5 + 1; i2 < arru.length; ++i2) {
                    boolean bl2;
                    U u3 = arru[i2];
                    int n8 = Q.a((Q)u2.c()).b();
                    int n9 = Q.a((Q)u3.c()).b();
                    n6 = n8;
                    n7 = n9;
                    if (n2 != 0) continue block2;
                    if (n6 == n7) continue;
                    int n10 = v2.compare(u2, u3);
                    Q q3 = (Q)u2.c();
                    m m3 = q3.a();
                    boolean bl3 = m3.c().b() >= m3.d().b();
                    Q q4 = (Q)u3.c();
                    m m4 = q4.a();
                    boolean bl4 = bl2 = m4.c().b() >= m4.d().b();
                    if (U.a(u2) == 3 && U.a(u3) == 3) {
                        n10 = - n10;
                    }
                    this.a(n8, n9, bl3, bl2, n4, n10, arrby);
                    this.a(n8, n9, !bl3, !bl2, n4, - n10, arrby);
                    if (n2 == 0) continue;
                }
                break;
            } while (true);
            ++n5;
        } while (n2 == 0);
    }

    private void a(int n2, int n3, boolean bl2, boolean bl3, int n4, int n5, byte[] arrby) {
        int n6;
        if (!bl2) {
            n2 += n4;
        }
        if (!bl3) {
            n3 += n4;
        }
        if (n2 < n3) {
            n6 = n3;
            n3 = n2;
            n2 = n6;
            n5 = - n5;
        }
        if (n5 == 0) return;
        n6 = n2 * (n2 - 1) / 2 + n3;
        byte by2 = arrby[n6];
        if (n5 > 0) {
            if (by2 >= 127) return;
            arrby[n6] = (byte)(by2 + 1);
            if (v.f == 0) return;
        }
        if (by2 <= -128) return;
        arrby[n6] = (byte)(by2 - 1);
    }

    private List e(X x2) {
        ArrayList<W> arrayList;
        int n2 = v.f;
        ArrayList<W> arrayList2 = new ArrayList<W>(x2.e() * 2);
        x x3 = x2.o();
        while (x3.f()) {
            q q2 = x3.e();
            arrayList2.add(new W(q2, 0));
            arrayList = arrayList2;
            if (n2 != 0) return arrayList;
            arrayList.add(new W(q2, 1));
            x3.g();
            if (n2 == 0) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    /*
     * Exception decompiling
     */
    private List f(X var1_1) {
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
    private boolean a(X var1_1, y.c.d var2_2, y.c.c var3_3, boolean var4_4) {
        var18_5 = v.f;
        if (var3_3 == null) return false;
        var5_6 = (Collection)var3_3.b(var2_2);
        if (var5_6 == null) {
            return false;
        }
        var6_7 = var5_6.iterator();
        do lbl-1000: // 3 sources:
        {
            if (var6_7.hasNext() == false) return false;
            var7_8 = (ax)var6_7.next();
            if (!var7_8.b()) ** GOTO lbl-1000
            v0 = var4_4;
            if (var18_5 != 0) return v0;
            if (!v0) ** GOTO lbl-1000
            var8_9 = var1_1.a(var2_2.c());
            var9_10 = var1_1.l(var2_2).c();
            if (var18_5 != 0) lbl-1000: // 2 sources:
            {
                var8_9 = var1_1.a(var2_2.d());
                var9_10 = var1_1.l(var2_2).d();
            }
            var10_11 = var8_9.getX() + 0.5 * var8_9.getWidth() + var7_8.c(this.t);
            var12_12 = var8_9.getY() + 0.5 * var8_9.getHeight() + var7_8.d(this.t);
            var14_13 = var9_10.a();
            var16_14 = var9_10.b();
        } while (Math.abs(var10_11 - var14_13) >= 0.001 || Math.abs(var12_12 - var16_14) >= 0.001);
        return true;
    }

    private boolean a(y.c.d d2, y.c.c c2) {
        if (c2 == null) return false;
        aE aE2 = (aE)c2.b(d2);
        if (aE2 == null) return false;
        if (!aE2.a()) return false;
        return true;
    }

    public void a(Object object) {
        this.h = object;
    }

    public double b() {
        return this.g;
    }

    static int[] a(K k2) {
        return k2.e;
    }

    static int[] b(K k2) {
        return k2.f;
    }

    static byte a(K k2, byte by2) {
        k2.t = by2;
        return k2.t;
    }

    static void a(K k2, X x2, byte[] arrby) {
        k2.a(x2, arrby);
    }

    static void a(K k2, X x2) {
        k2.b(x2);
    }
}

