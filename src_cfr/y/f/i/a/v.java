/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.h;
import y.c.i;
import y.c.p;
import y.f.X;
import y.f.c.a.aO;
import y.f.i.a.H;
import y.f.i.a.I;
import y.f.i.a.M;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.U;
import y.f.i.a.W;
import y.f.i.a.Y;
import y.f.i.a.Z;
import y.f.i.a.aa;
import y.f.i.a.ab;
import y.f.i.a.ac;
import y.f.i.a.ad;
import y.f.i.a.bR;
import y.f.i.a.bc;
import y.f.i.a.bz;
import y.f.i.a.f;
import y.f.i.a.v;
import y.f.i.a.w;
import y.f.i.a.x;
import y.f.y;

public class V {
    private h b;
    int a;
    private Z c;
    private D d = new D();
    private D e = new D();
    private D f = new D();
    private D g = new D();
    private bz h = new bz();
    private Y i;

    D a() {
        return this.d;
    }

    public boolean a(ab ab2) {
        return this.d.add(ab2);
    }

    D b() {
        return this.e;
    }

    boolean a(bR bR2) {
        return this.e.add(bR2);
    }

    boolean b(bR bR2) {
        return this.e.remove(bR2);
    }

    private void a(f f2, aa aa2, byte by2) {
        int n2 = ab.a;
        C c2 = this.b().m();
        do {
            if (!c2.f()) return;
            ((bR)c2.d()).a(f2, aa2, by2);
            c2.g();
        } while (n2 == 0);
    }

    D c() {
        return this.f;
    }

    public boolean a(H h2) {
        return this.f.add(h2);
    }

    public boolean b(H h2) {
        return this.f.remove(h2);
    }

    public void a(Z z2) {
        int n2 = ab.a;
        this.c = z2;
        this.b = y.g.M.b();
        this.a = 0;
        Iterator iterator = this.d.iterator();
        do {
            if (!iterator.hasNext()) return;
            ab ab2 = (ab)iterator.next();
            ab2.a(z2);
        } while (n2 == 0);
    }

    public void d() {
        Object object;
        block2 : {
            int n2 = ab.a;
            D d2 = this.a();
            object = d2.m();
            while (object.f()) {
                ((ab)object.d()).c();
                object.g();
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block2;
            }
            d2.clear();
        }
        object = this.c.a();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.c();
        this.i = null;
        this.c = null;
        this.b = null;
        c c2 = object.c("y.layout.router.polyline.PathSearch.VISITED_NEIGHBORS");
        if (c2 == null) return;
        aO aO2 = (aO)c2.b(object);
        if (aO2 == null) return;
        aO2.a(this.a);
    }

    void a(d d2, U u2) {
        this.b.a((Object)d2, u2);
    }

    public U a(d d2) {
        return (U)this.b.b(d2);
    }

    protected void a(aa aa2) {
        Object object;
        int n2 = ab.a;
        d d2 = aa2.c();
        boolean bl2 = false;
        x x2 = aa2.d();
        ad ad2 = x2.f();
        double d3 = 0.0;
        block0 : while (!bl2) {
            Object object2;
            boolean bl3;
            block14 : {
                block13 : {
                    Object object3;
                    object = this.a().m();
                    while (object.f()) {
                        ((ab)object.d()).b(aa2);
                        object.g();
                        if (n2 != 0) continue block0;
                        if (n2 == 0) continue;
                    }
                    object = this.c(aa2);
                    object2 = object.iterator();
                    while (object2.hasNext()) {
                        object3 = (f)object2.next();
                        object3.a(object3.f() + this.a((f)object3));
                        this.h.a((f)object3, object3.f());
                        object3.a(true);
                        this.a((f)object3, aa2, 1);
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block13;
                    }
                    block3 : while (!this.h.a()) {
                        Object object4;
                        object2 = this.h.b();
                        this.a((f)object2, aa2, 0);
                        object2.a(false);
                        object3 = object2.a();
                        if (aa2.d((R)object3) && this.b((f)object2)) {
                            bl2 = true;
                            object4 = V.a((f)object2, aa2.c());
                            this.a((U)object4);
                            this.a(d2, (U)object4);
                            if (n2 == 0) break;
                        }
                        object4 = this.c.c().r().c((R)object3);
                        this.a += object4.size();
                        Iterator iterator = object4.iterator();
                        while (iterator.hasNext()) {
                            R r2 = (R)iterator.next();
                            this.a((f)object2, r2, aa2);
                            if (n2 != 0) continue block3;
                            if (n2 == 0) continue;
                        }
                        if (d3 >= 1.0) continue;
                        bl3 = this.i.a();
                        if (n2 == 0) {
                            if (!bl3) continue;
                        }
                        break block14;
                    }
                }
                bl3 = bl2;
            }
            if (!bl3) {
                block15 : {
                    object2 = this.a().m();
                    while (object2.f()) {
                        ((ab)object2.d()).c(aa2);
                        object2.g();
                        if (n2 == 0) {
                            if (n2 == 0) continue;
                        }
                        break block15;
                    }
                    if (!this.h.a()) {
                        object2 = ad2.q();
                        d3 = Math.min(1.0, d3 + 0.25);
                        this.a((ad)object2, d3, aa2);
                        x2.a((ad)object2);
                        continue;
                    }
                }
                if (x2.f() == ad2) break;
                x2.a(ad2);
                if (n2 == 0) break;
            }
            if (x2.f() == ad2) continue;
            x2.a(ad2);
            if (n2 == 0) continue;
        }
        object = this.a().m();
        while (object.f()) {
            ((ab)object.d()).d(aa2);
            object.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.e();
    }

    protected void a(ad ad2, double d2, aa aa2) {
        int n2 = ab.a;
        double d3 = 1.0 - Math.min(1.0, Math.max(0.0, d2 - 0.3) * 2.0);
        ad2.b((int)((double)ad2.c() * d3));
        double d4 = 1.0 - Math.min(1.0, d2 * 2.0);
        ad2.l((int)((double)ad2.m() * d4));
        ad2.o((int)((double)ad2.p() * d4));
        ad2.n((int)((double)ad2.o() * d4));
        double d5 = 1.0 - Math.min(1.0, d2 * 3.5);
        ad2.k((int)((double)ad2.l() * d5));
        ad2.h((int)((double)ad2.i() * d5));
        ad2.f((int)((double)ad2.g() * d5));
        ad2.g((int)((double)ad2.h() * d5));
        ad2.i((int)((double)ad2.j() * d5));
        ad2.j((int)((double)ad2.k() * d5));
        ad2.m((int)((double)ad2.n() * d5));
        double d6 = 1.0 - Math.min(1.0, d2 * 10.0);
        ad2.a((int)((double)ad2.b() * d6));
        ad2.c((int)((double)ad2.d() * d6));
        ad2.d((int)((double)ad2.e() * d6));
        ad2.e((int)((double)ad2.f() * d6));
        if (n2 == 0) return;
        i.g = !i.g;
    }

    private double a(f f2) {
        double d2;
        int n2 = ab.a;
        double d3 = 0.0;
        C c2 = this.a().m();
        while (c2.f()) {
            ab ab2 = (ab)c2.d();
            d2 = d3 + ab2.a(f2);
            if (n2 != 0) return d2;
            d3 = d2;
            c2.g();
            if (n2 == 0) continue;
        }
        d2 = d3;
        return d2;
    }

    private void e() {
        int n2 = ab.a;
        C c2 = this.g.m();
        while (c2.f()) {
            ((R)c2.d()).a((HashMap)null);
            c2.g();
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.g.clear();
        this.h.c();
    }

    /*
     * Unable to fully structure code
     */
    public void b(aa var1_1) {
        block11 : {
            var13_2 = ab.a;
            var2_3 = var1_1.b().k();
            if (var2_3 == 0) {
                return;
            }
            var3_4 = System.currentTimeMillis() + var1_1.j();
            var5_5 = this.a().m();
            while (var5_5.f()) {
                ((ab)var5_5.d()).a(var1_1);
                var5_5.g();
                if (var13_2 == 0) {
                    if (var13_2 == 0) continue;
                }
                break block11;
            }
            var5_5 = var1_1.b();
            while (var5_5.f()) {
                var6_6 = var5_5.a();
                var1_1.a((d)var6_6);
                v0 = var1_1.k() LCMP Long.MAX_VALUE;
                if (var13_2 != 0) ** GOTO lbl34
                if (v0) ** GOTO lbl-1000
                this.i = new y.f.i.a.X();
                if (var13_2 != 0) lbl-1000: // 2 sources:
                {
                    var7_7 = System.currentTimeMillis();
                    var9_9 = (var3_4 - var7_7) / (long)var2_3;
                    var11_11 = var7_7 + Math.max(var9_9, var1_1.k());
                    this.i = new W(var7_7, var11_11);
                }
                this.a(var1_1);
                --var2_3;
                var5_5.g();
                if (var13_2 == 0) continue;
            }
            var5_5 = this.a().m();
        }
        do {
            v0 = var5_5.f();
lbl34: // 2 sources:
            if (!v0) break;
            ((ab)var5_5.d()).e(var1_1);
            var5_5.g();
        } while (var13_2 == 0);
        var5_5 = var1_1.i();
        var6_6 = var1_1.b();
        while (var6_6.f()) {
            var7_8 = var6_6.a();
            v1 = var8_12 = this.a(var7_8);
            if (var13_2 == 0) {
                if (v1 != null) {
                    var5_5.a(var7_8, var8_12);
                    var9_10 = var5_5.a(var7_8);
                    if (var9_10 != null) {
                        this.a(var9_10);
                    }
                }
                var6_6.g();
                if (var13_2 == 0) continue;
            }
            ** GOTO lbl56
        }
        var6_6 = this.a().m();
        do {
            if (var6_6.f() == false) return;
            v1 = var6_6.d();
lbl56: // 2 sources:
            ((ab)v1).a((ac)var5_5);
            var6_6.g();
        } while (var13_2 == 0);
    }

    private void a(w w2) {
        int n2 = ab.a;
        Iterator iterator = w2.d().iterator();
        do {
            if (!iterator.hasNext()) return;
            v v2 = (v)iterator.next();
            v2.h().b().a(v2);
        } while (n2 == 0);
    }

    protected void a(U u2) {
        int n2 = ab.a;
        C c2 = this.a().m();
        do {
            if (!c2.f()) return;
            ((ab)c2.d()).a(u2);
            c2.g();
        } while (n2 == 0);
    }

    private D c(aa aa2) {
        int n2 = ab.a;
        D d2 = new D();
        boolean bl2 = false;
        C c2 = this.a().m();
        while (c2.f()) {
            ab ab2 = (ab)c2.d();
            ab2.a(d2);
            c2.g();
            if (n2 == 0) continue;
        }
        int n3 = 0;
        int n4 = aa2.e();
        block1 : do {
            if (n3 >= n4) return d2;
            R r2 = aa2.a(n3);
            f f2 = new f(r2);
            I i2 = this.c.c().r();
            List list = i2.c(r2);
            for (R r3 : list) {
                if (aa2.b(r3)) continue;
                f f3 = new f(r3);
                f3.a(f2);
                f3.a(V.a(f2, r3));
                f3.a(V.a(r2, r3));
                d2.add(f3);
                if (n2 != 0) continue block1;
                if (n2 == 0) continue;
            }
            ++n3;
        } while (n2 == 0);
        return d2;
    }

    private List a(f f2, R r2, y y2, aa aa2) {
        ArrayList<P> arrayList;
        P p2;
        Object object;
        ArrayList<P> arrayList2;
        Object object2;
        Object object3;
        int n2;
        block14 : {
            int n3;
            n2 = ab.a;
            arrayList2 = new ArrayList<P>();
            p2 = V.a(f2.a(), r2);
            if (p2 == null) {
                throw new IllegalArgumentException("neighborCell has no common border with the PartitionCell of currentEntrance");
            }
            D d2 = this.c();
            if (!d2.isEmpty()) {
                int n4;
                int n5;
                int[] arrn = new int[d2.size()];
                int n6 = 0;
                for (p p3 = d2.k(); p3 != null; p3 = p3.a()) {
                    object2 = (H)p3.c();
                    n5 = arrayList2.size();
                    object2.a(f2, r2, p2, arrayList2, aa2);
                    arrn[n6++] = arrayList2.size() - n5;
                    if (n2 == 0) {
                        if (n2 == 0) continue;
                    }
                    break block14;
                }
                if ((n4 = arrayList2.size()) > 1) {
                    int n7 = 0;
                    for (n5 = 0; n5 < arrn.length; ++n5) {
                        int n8;
                        block15 : {
                            int n9 = n7 + arrn[n5];
                            n3 = n7;
                            if (n2 != 0) break block14;
                            int n10 = n3;
                            block2 : do {
                                int n11 = n10;
                                block3 : while (n11 < n9) {
                                    P p4 = (P)arrayList2.get(n10);
                                    n8 = n9;
                                    if (n2 != 0) break block15;
                                    for (int i2 = v1913979; i2 < n4; ++i2) {
                                        object = (P)arrayList2.get(i2);
                                        n11 = (int)p4.c((P)object) ? 1 : 0;
                                        if (n2 != 0) continue block3;
                                        if (n11 != 0 || object.c(p4) || (object3 = P.a(p4, (P)object)) == null) continue;
                                        arrayList2.add((P)object3);
                                        if (n2 == 0) continue;
                                    }
                                    ++n10;
                                    if (n2 == 0) continue block2;
                                }
                                break block2;
                                break;
                            } while (true);
                            n8 = n7 + arrn[n5];
                        }
                        n7 = n8;
                        if (n2 == 0) continue;
                    }
                }
            }
            n3 = arrayList2.add(p2);
        }
        if (y2 != f2.d()) return arrayList2;
        if (f2.c() == null) {
            return arrayList2;
        }
        double d3 = p2.f();
        boolean bl2 = p2.a();
        object2 = f2.c().e();
        M m2 = new M(object2.a() - 0.1, object2.b() + 0.1);
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<P> arrayList3 = new ArrayList<P>();
        for (P p5 : arrayList2) {
            P p6;
            object = p5.e();
            if (m2.b((M)object) > 0.0 || object.c((M)object2)) {
                if (!hashSet.add(object)) continue;
                arrayList = arrayList3;
                if (n2 != 0) return arrayList;
                arrayList.add(p5);
                if (n2 == 0) continue;
            }
            if (object.a() < m2.a() && hashSet.add(object3 = new M(object.a(), m2.a()))) {
                p6 = new P((M)object3, d3, bl2);
                arrayList3.add(p6);
            }
            if (object.b() > m2.b() && hashSet.add(object3 = new M(m2.b(), object.b()))) {
                p6 = new P((M)object3, d3, bl2);
                arrayList3.add(p6);
            }
            if ((object3 = M.a((M)object2, (M)object)) == null || !hashSet.add(object3)) continue;
            p6 = new P((M)object3, d3, bl2);
            arrayList3.add(p6);
            if (n2 == 0) continue;
        }
        arrayList = arrayList3;
        return arrayList;
    }

    private boolean b(f f2) {
        int n2 = ab.a;
        C c2 = this.a().m();
        do {
            if (!c2.f()) return true;
            ab ab2 = (ab)c2.d();
            boolean bl2 = ab2.c(f2);
            if (n2 != 0) return bl2;
            if (!bl2) {
                return false;
            }
            c2.g();
        } while (n2 == 0);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected void a(f var1_1, R var2_2, aa var3_3) {
        block9 : {
            var26_4 = ab.a;
            var4_5 = V.a(var1_1, var2_2);
            var5_6 = this.a(var1_1, var2_2, var4_5, var3_3);
            var6_7 = new f[var5_6.size()];
            var7_8 = new HashSet<M>(var5_6.size());
            var8_9 = new D();
            var9_10 = 0;
            for (Object var11_12 : var5_6) {
                if (!var7_8.add(var11_12.e()) || (var12_13 = this.b(var1_1, var2_2, (P)var11_12)) != null && var12_13.f() < var1_1.f()) continue;
                var6_7[var9_10++] = var12_13;
                var8_9.add(var11_12);
                if (var26_4 == 0) continue;
            }
            var10_11 = var3_3.c();
            var11_12 = var1_1.a();
            var12_14 = var1_1.j() != null ? var1_1.j().e() : 0;
            var13_15 = new P[var8_9.size()];
            var14_16 = new v[var8_9.size()];
            var15_17 = new double[var8_9.size()];
            var9_10 = 0;
            var16_18 = var8_9.iterator();
            while (var16_18.hasNext()) {
                var13_15[var9_10] = var17_19 = (P)var16_18.next();
                var14_16[var9_10] = new v(var10_11, (R)var11_12, var1_1.c(), var17_19, var1_1.d(), var4_5, var12_14);
                var18_20 = var6_7[var9_10];
                v0 = var15_17;
                if (var26_4 == 0) {
                    v0[var9_10] = var18_20 != null ? var18_20.f() - var1_1.f() : Double.MAX_VALUE;
                    ++var9_10;
                    if (var26_4 == 0) continue;
                }
                break block9;
            }
            v0 = this.a(var1_1, var2_2, var13_15, var14_16, var3_3, var15_17);
        }
        var16_18 = v0;
        var9_10 = 0;
        do {
            v1 = var9_10;
            block3 : do {
                if (v1 >= var13_15.length) return;
                var17_19 = var13_15[var9_10];
                var18_21 = var1_1.f() + var16_18[var9_10];
                var20_22 = var6_7[var9_10];
                if (var20_22 == null) ** GOTO lbl-1000
                if (var18_21 >= var20_22.f()) break;
                if (!var20_22.c().d(var17_19)) ** GOTO lbl-1000
                var21_23 = var20_22;
                var21_23.b(null);
                if (var26_4 != 0) lbl-1000: // 2 sources:
                {
                    var21_23 = new f(var2_2);
                    ** if (var26_4 == 0) goto lbl52
                }
                ** GOTO lbl52
lbl-1000: // 2 sources:
                {
                    var21_23 = new f(var2_2);
                }
lbl52: // 3 sources:
                var21_23.a(var1_1);
                var21_23.a(var17_19);
                var21_23.a(var18_21);
                var21_23.a(var14_16[var9_10]);
                if (!var21_23.e()) ** GOTO lbl-1000
                var22_25 = this.a(var21_23, var3_3);
                var24_27 = var18_21 + var22_25;
                this.h.b(var21_23, var24_27);
                this.a(var21_23, var3_3, 2);
                if (var26_4 != 0) lbl-1000: // 2 sources:
                {
                    var21_23.a(true);
                    var21_23.a(var4_5);
                    var22_25 = this.a(var21_23, var3_3);
                    var24_27 = var18_21 + var22_25;
                    this.h.a(var21_23, var24_27);
                    this.a(var21_23, var1_1);
                    this.a(var21_23, var3_3, 1);
                }
                if ((var22_24 = this.a(var1_1, var2_2, var17_19)) == null) break;
                for (f var24_28 : var22_24) {
                    if (var24_28 == var21_23) continue;
                    v1 = (int)this.h.a(var24_28) ? 1 : 0;
                    if (var26_4 != 0) continue block3;
                    if (v1 == 0 || var24_28.f() <= var18_21) continue;
                    this.h.b(var24_28);
                    var24_28.a(false);
                    if (var26_4 == 0) continue;
                }
                break;
            } while (true);
            ++var9_10;
        } while (var26_4 == 0);
    }

    private void a(f f2, f f3) {
        R r2;
        ArrayList<f> arrayList;
        R r3 = f3.a();
        HashMap<R, ArrayList<f>> hashMap = r3.c();
        if (hashMap == null) {
            hashMap = new HashMap<R, ArrayList<f>>();
            this.g.add(r3);
            r3.a(hashMap);
        }
        if ((arrayList = (ArrayList<f>)hashMap.get(r2 = f2.a())) == null) {
            arrayList = new ArrayList<f>();
            hashMap.put(r2, arrayList);
        }
        arrayList.add(f2);
    }

    private List a(f f2, R r2, P p2) {
        ArrayList<f> arrayList;
        int n2 = ab.a;
        HashMap hashMap = f2.a().c();
        if (hashMap == null) {
            return null;
        }
        ArrayList arrayList2 = (ArrayList)hashMap.get(r2);
        if (arrayList2 == null) {
            return null;
        }
        ArrayList<f> arrayList3 = new ArrayList<f>();
        for (f f3 : arrayList2) {
            if (!f3.c().c(p2)) continue;
            arrayList = arrayList3;
            if (n2 != 0) return arrayList;
            arrayList.add(f3);
            if (n2 == 0) continue;
        }
        arrayList = arrayList3;
        return arrayList;
    }

    private f b(f f2, R r2, P p2) {
        f f3;
        int n2 = ab.a;
        List list = this.a(f2, r2, p2);
        if (list == null) {
            return null;
        }
        f f4 = null;
        for (f f5 : list) {
            f3 = f4;
            if (n2 != 0) return f3;
            if (f3 != null && f4.f() <= f5.f()) continue;
            f4 = f5;
            if (n2 == 0) continue;
        }
        f3 = f4;
        return f3;
    }

    /*
     * Unable to fully structure code
     */
    protected double[] a(f var1_1, R var2_2, P[] var3_3, v[] var4_4, aa var5_5, double[] var6_6) {
        var14_7 = ab.a;
        var7_8 = new double[var3_3.length];
        var8_9 = new double[var6_6.length];
        System.arraycopy(var6_6, 0, var8_9, 0, var6_6.length);
        var9_10 = this.a().m();
        while (var9_10.f()) {
            block4 : {
                var10_11 = (ab)var9_10.d();
                v0 = var10_11.a(var1_1, var2_2, var3_3, var4_4, var8_9);
                if (var14_7 != 0) return v0;
                var11_12 = v0;
                var12_13 = true;
                var13_14 = 0;
                do {
                    if (var13_14 >= var11_12.length) return var7_8;
                    v1 = var7_8;
                    v2 = var13_14;
                    v1[v2] = v1[v2] + var11_12[var13_14];
                    v3 = var8_9[var13_14] DCMPL Double.MAX_VALUE;
                    if (var14_7 != 0) break block4;
                    if (v3) ** GOTO lbl23
                    var12_13 = false;
                    if (var14_7 == 0) ** GOTO lbl30
lbl23: // 2 sources:
                    v4 = var8_9;
                    v5 = var13_14;
                    v4[v5] = v4[v5] - var11_12[var13_14];
                    if (var8_9[var13_14] > 0.0) ** GOTO lbl-1000
                    var8_9[var13_14] = 0.0;
                    if (var14_7 != 0) lbl-1000: // 2 sources:
                    {
                        var12_13 = false;
                    }
lbl30: // 4 sources:
                    ++var13_14;
                } while (var14_7 == 0);
                v3 = var12_13;
            }
            if (v3) {
                return var7_8;
            }
            var9_10.g();
            if (var14_7 == 0) continue;
        }
        v0 = var7_8;
        return v0;
    }

    protected double a(f f2, aa aa2) {
        int n2 = ab.a;
        double d2 = 0.0;
        ab ab2 = null;
        C c2 = this.a().m();
        while (c2.f()) {
            ab2 = (ab)c2.d();
            d2 += ab2.b(f2);
            c2.g();
            if (n2 != 0) return d2;
            if (n2 == 0) continue;
        }
        if (ab2 == null) return d2;
        return d2;
    }

    static P a(R r2, R r3) {
        double d2 = Math.max(r3.h(), r2.h());
        double d3 = Math.min(r3.j(), r2.j());
        double d4 = Math.max(r3.i(), r2.i());
        double d5 = Math.min(r3.k(), r2.k());
        return new P(d2, d4, d3, d5);
    }

    static y a(f f2, R r2) {
        R r3 = f2.a();
        double d2 = Math.max(r3.h(), r2.h());
        double d3 = Math.min(r3.j(), r2.j());
        double d4 = Math.max(r3.i(), r2.i());
        if (Math.abs(d2 - d3) > 1.0E-6) {
            if (Math.abs(d4 - r2.i()) >= 1.0E-6) return y.a;
            return y.c;
        }
        if (Math.abs(d2 - r2.h()) >= 1.0E-6) return y.d;
        return y.b;
    }

    static U a(f f2, d d2) {
        int n2 = ab.a;
        if (f2 == null) {
            return null;
        }
        D d3 = new D();
        f f3 = f2;
        do {
            if (f3 == null) return new U(d2, d3, f2.f());
            d3.a(f3);
            f3 = f3.b();
        } while (n2 == 0);
        return new U(d2, d3, f2.f());
    }
}

