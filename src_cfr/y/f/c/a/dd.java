/*
 * Decompiled with CFR 0_115.
 */
package y.f.c.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import y.c.A;
import y.c.C;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.x;
import y.c.y;
import y.f.X;
import y.f.b.f;
import y.f.c.a.E;
import y.f.c.a.N;
import y.f.c.a.aP;
import y.f.c.a.aQ;
import y.f.c.a.aU;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.as;
import y.f.c.a.bK;
import y.f.c.a.da;
import y.f.c.a.dg;
import y.g.M;

class dd
extends dg {
    X a;
    aV b;
    A c;
    ArrayList d;
    boolean e;

    dd(E e2, X x2, aV aV2) {
        Object object;
        Object object2;
        Object object3;
        boolean bl2 = N.x;
        super(e2, null);
        this.e = true;
        this.a = x2;
        this.b = aV2;
        this.d = new ArrayList();
        c c2 = x2.c(f.d);
        c c3 = x2.c(f.b);
        c c4 = x2.c(f.c);
        if (c2 == null || c3 == null || c4 == null) {
            this.e = false;
            return;
        }
        this.c = M.a();
        y.f.b.c c5 = new y.f.b.c(x2);
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        this.d.add(this);
        this.c.a((Object)null, this);
        Object object4 = x2.o();
        while (object4.f()) {
            block8 : {
                object3 = object4.e();
                object2 = c3.b(object3);
                if (c5.d((q)object3) && !c5.b((q)object3).isEmpty()) {
                    object = new dg(e2, (q)object3);
                    hashMap.put(object2, object);
                    this.d.add(object);
                    this.c.a(object3, object);
                    if (!bl2) break block8;
                }
                hashMap.put(object2, object3);
            }
            object4.g();
            if (!bl2) continue;
        }
        object4 = null;
        object3 = x2.o();
        while (object3.f()) {
            object2 = object3.e();
            object = c4.b(object2);
            if (!hashMap.containsKey(object)) {
                object4 = object;
                break;
            }
            object3.g();
        }
        object3 = x2.o();
        while (object3.f()) {
            object2 = object3.e();
            object = c3.b(object2);
            Object object5 = c4.b(object2);
            Object v2 = hashMap.get(object);
            Object v3 = hashMap.get(object5);
            if (bl2) return;
            dg dg2 = v3 == null ? this : v3;
            as as2 = (as)aV2.a((q)object2);
            as2.a(dg2.f);
            this.a(v2, dg2);
            object3.g();
            if (!bl2) continue;
        }
        if (this.d.size() <= 1) {
            this.e = false;
        }
        c5.c();
    }

    void a(aU aU2, aP aP2) {
        boolean bl2 = N.x;
        int n2 = 0;
        do {
            if (n2 >= aU2.b()) return;
            aQ aQ2 = aU2.a(n2);
            y y2 = aQ2.d();
            this.a(aQ2, y2.k(), aP2, this);
            ++n2;
        } while (!bl2);
    }

    void a(aU aU2, A a2) {
        boolean bl2 = N.x;
        for (Object object2 : this.d) {
            object2.g = null;
            object2.h = null;
            object2.A = null;
            object2.B = null;
            if (!bl2) continue;
        }
        int n2 = 0;
        while (n2 < aU2.b()) {
            block8 : {
                Object object2;
                object2 = aU2.a(n2);
                y y2 = object2.d();
                if (bl2) return;
                for (p p2 = y2.k(); p2 != null; p2 = p2.a()) {
                    q q2 = (q)p2.c();
                    if (!bl2) {
                        if (a2 != null && a2.d(q2)) continue;
                        dg dg2 = this.a((Object)q2);
                        if (dg2 == null) {
                            aX aX2 = this.b.a(q2);
                            dg2 = this.C.f(aX2.l());
                        }
                        if (dg2.g == null) {
                            dg2.g = object2;
                        }
                        if (dg2.A == null && object2.e() != 2 && object2.e() != 3) {
                            dg2.A = object2;
                        }
                        if (object2.e() != 2 && object2.e() != 3) {
                            dg2.B = object2;
                        }
                        dg2.h = object2;
                        if (!bl2) continue;
                    }
                    break block8;
                }
                ++n2;
            }
            if (!bl2) continue;
        }
        this.d();
    }

    void a(aV aV2) {
        Object object;
        byte by2;
        Object object2;
        boolean bl2;
        Object object3;
        block12 : {
            block13 : {
                dd dd2;
                bl2 = N.x;
                A a2 = M.a(new boolean[this.a.e()]);
                x x2 = this.a.o();
                while (x2.f()) {
                    object2 = x2.e();
                    object = (as)aV2.a((q)object2);
                    by2 = object.b();
                    if (bl2) break block12;
                    if (by2 == 1) {
                        object3 = object.g();
                        if (!a2.d(object2) && object2.g().c() == object3.c()) {
                            a2.a(object2, true);
                            block1 : do {
                                int n2 = object.b();
                                int n3 = 1;
                                block2 : while (n2 == n3) {
                                    p p2;
                                    dg dg2;
                                    int n4;
                                    block14 : {
                                        q q2 = object3.c();
                                        q q3 = object3.d();
                                        D d2 = this.a(q2);
                                        D d3 = this.a(q3);
                                        dd2 = this;
                                        if (bl2) break block13;
                                        dg dg3 = dd2;
                                        while (!d2.isEmpty()) {
                                            n4 = d3.isEmpty();
                                            if (!bl2) {
                                                if (n4 != 0 || d2.i() != d3.i()) break;
                                                dg3 = (dg)d2.j();
                                                d3.j();
                                                if (!bl2) continue;
                                            }
                                            break block14;
                                        }
                                        object.a(dg3.f);
                                        n4 = object.j();
                                    }
                                    int n5 = n4;
                                    for (p2 = d2.k(); p2 != null; p2 = p2.a()) {
                                        dg2 = (dg)p2.c();
                                        n2 = dg2.h.c();
                                        n3 = n5;
                                        if (bl2) continue block2;
                                        if (n2 < n3) continue;
                                        object.a(dg2.f);
                                        if (!bl2) break;
                                        if (!bl2) continue;
                                    }
                                    for (p2 = d3.k(); p2 != null; p2 = p2.a()) {
                                        dg2 = (dg)p2.c();
                                        n2 = dg2.g.c();
                                        n3 = n5;
                                        if (bl2) continue block2;
                                        if (n2 > n3) continue;
                                        object.a(dg2.f);
                                        if (!bl2) break;
                                        if (!bl2) continue;
                                    }
                                    object2 = object2.f().d();
                                    object = (as)aV2.a((q)object2);
                                    if (!bl2) continue block1;
                                }
                                break block1;
                                break;
                            } while (true);
                        }
                    }
                    x2.g();
                    if (!bl2) continue;
                }
                dd2 = this;
            }
            by2 = dd2.C.a();
        }
        byte by3 = by2;
        object2 = this.a.o();
        do {
            if (!object2.f()) return;
            object = object2.e();
            object3 = aV2.a((q)object);
            if (object3.b() == 1) {
                this.a(object).b(object);
                if (by3 != 0) {
                    this.a(object3.l(), (as)object3);
                }
            }
            object2.g();
        } while (!bl2);
    }

    void a(q q2, as as2) {
        bK bK2 = as2.h();
        bK bK3 = this.C.a(q2);
        bK bK4 = this.C.b(q2);
        if (bK2 == null) return;
        int n2 = bK2.j();
        if (bK3 != null && bK3.j() > n2) {
            as2.a(bK3);
        }
        if (bK4 == null) return;
        if (bK4.j() >= n2) return;
        as2.a(bK4);
    }

    D a(q q2) {
        D d2;
        boolean bl2 = N.x;
        D d3 = new D();
        dg dg2 = this.a((Object)q2);
        while (dg2 != null) {
            d2 = d3;
            if (bl2) return d2;
            d2.add(dg2);
            dg2 = this.a(dg2);
            if (!bl2) continue;
        }
        d2 = d3;
        return d2;
    }

    void a(q q2, dg dg2) {
        ((as)this.b.a(q2)).a(dg2.f);
    }

    dg a(Object object) {
        if (object instanceof dg && (object = ((dg)object).f) == null) {
            return null;
        }
        if (!(object instanceof q)) throw new IllegalStateException("Item has no parent");
        q q2 = this.b.a((q)object).l();
        dg dg2 = this.C.f(q2);
        if (dg2 == null) throw new IllegalStateException("Item has no parent");
        return dg2;
    }

    void a(Object object, dg dg2) {
        dg2.b(object);
    }

    public boolean a() {
        return this.e;
    }

    /*
     * Unable to fully structure code
     */
    boolean a(d var1_1, aV var2_2) {
        var3_3 = var1_1.c();
        var4_4 = var1_1.d();
        var5_5 = var2_2.a(var3_3);
        var6_6 = var2_2.a(var4_4);
        var7_7 = null;
        if (var6_6.b() != 9) ** GOTO lbl-1000
        var8_8 = var6_6.f();
        var9_9 = var2_2.a(var8_8);
        if (var9_9.b() == 15) {
            var10_10 = this.a((Object)var8_8);
            var11_11 = var3_3;
            if (var5_5.b() == 8) {
                var11_11 = var5_5.f();
            }
            if (this.C.a(var11_11, var10_10.f)) {
                var7_7 = this.a(var10_10);
            }
        }
        if (var7_7 == null) lbl-1000: // 2 sources:
        {
            if (var5_5.b() == 8 && (var9_9 = var2_2.a(var8_8 = var5_5.f())).b() == 15) {
                var10_10 = this.a((Object)var8_8);
                var11_11 = var4_4;
                if (var6_6.b() == 9) {
                    var11_11 = var6_6.f();
                }
                if (this.C.a(var11_11, var10_10.f)) {
                    var7_7 = this.a(var10_10);
                }
            }
        }
        if (var7_7 == null) return false;
        if (var6_6.b() == 9) {
            this.a(var4_4, var7_7);
            var7_7.b(var4_4);
            this.a(var7_7.f, (as)var6_6);
        }
        if (var5_5.b() != 8) return true;
        this.a(var3_3, var7_7);
        var7_7.b(var3_3);
        this.a(var7_7.f, (as)var5_5);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public void a(aU var1_1, aV var2_2) {
        var15_3 = N.x;
        var3_4 = this.a.p();
        do {
            block7 : {
                if (var3_4.f() == false) return;
                var4_5 = var3_4.a();
                if (this.a(var4_5, var2_2)) ** GOTO lbl63
                var5_6 = var4_5.c();
                var6_7 = var4_5.d();
                var7_8 = var2_2.a(var5_6);
                var8_9 = var2_2.a(var6_7);
                v0 = var8_9.b();
                v1 = 9;
                block1 : do lbl-1000: // 3 sources:
                {
                    if (v0 != v1) ** GOTO lbl49
                    var9_10 = var8_9.f();
                    var10_11 = var2_2.a((q)var9_10);
                    var11_13 = this.a(this.a(var9_10));
                    if (var10_11.b() == 15 && var7_8.b() == 8 && var7_8.j() >= var11_13.g.c() && var7_8.j() <= var11_13.h.c()) {
                        this.a(var6_7, (dg)var11_13);
                        this.a(var5_6, (dg)var11_13);
                        var11_13.b(var6_7);
                        this.a(var11_13.f, (as)var7_8);
                        var11_13.b(var5_6);
                        this.a(var11_13.f, (as)var8_9);
                        if (!var15_3) break block7;
                    }
                    var12_14 = null;
                    if (var7_8.b() == 8) {
                        var13_16 = var7_8.f();
                        var14_17 = var2_2.a(var13_16);
                        var12_14 = var14_17.b() == 15 ? this.a(this.a((Object)var13_16)) : this.a((Object)var7_8.f());
                        this.a(var5_6, var12_14);
                        var12_14.b(var5_6);
                        this.a(var12_14.f, (as)var7_8);
                    } else {
                        var12_14 = this.a((Object)var5_6);
                    }
                    var13_15 = var8_9.j();
                    var14_17 = var12_14;
                    while (var14_17 != this) {
                        v0 = var14_17.h.c();
                        v1 = var13_15;
                        if (var15_3) ** GOTO lbl-1000
                        if (v0 >= v1) break;
                        var14_17 = this.a(var14_17);
                        if (!var15_3) continue;
                    }
                    this.a(var6_7, (dg)var14_17);
                    var14_17.b(var6_7);
                    this.a(var14_17.f, (as)var8_9);
                    if (!var15_3) break block7;
lbl49: // 2 sources:
                    if (var7_8.b() != 8) break block7;
                    var9_10 = this.a((Object)var6_7);
                    var10_12 = var7_8.j();
                    var11_13 = var9_10;
                    while (var11_13 != this) {
                        v0 = var11_13.g.c();
                        v1 = var10_12;
                        if (var15_3) continue block1;
                        if (v0 <= v1) break block1;
                        var11_13 = this.a(var11_13);
                        if (!var15_3) continue;
                    }
                    break block1;
                    break;
                } while (true);
                this.a(var5_6, (dg)var11_13);
                var11_13.b(var5_6);
                this.a(var11_13.f, (as)var7_8);
            }
            var3_4.g();
        } while (!var15_3);
    }

    /*
     * Unable to fully structure code
     */
    public void b(aU var1_1, aV var2_2) {
        var11_3 = N.x;
        var3_4 = this.a.o();
        do {
            if (var3_4.f() == false) return;
            var4_5 = var3_4.e();
            var5_6 = var2_2.a(var4_5);
            if (var5_6.b() != 10) ** GOTO lbl31
            var6_7 = var4_5.g().c();
            var7_8 = var2_2.a(var6_7);
            var8_9 = var4_5.f().d();
            var9_10 = var2_2.a(var8_9);
            var10_11 = this.a((Object)var6_7);
            if (var7_8.b() != 15 || var9_10.b() != 15) ** GOTO lbl23
            if (!this.C.a(var7_8.l(), var9_10.l())) ** GOTO lbl17
            var10_11 = this.a((Object)var9_10.l());
            if (!var11_3) ** GOTO lbl28
lbl17: // 2 sources:
            if (!this.C.a(var9_10.l(), var7_8.l())) ** GOTO lbl20
            var10_11 = this.a((Object)var7_8.l());
            if (!var11_3) ** GOTO lbl28
lbl20: // 2 sources:
            if (var9_10.l() != var7_8.l()) ** GOTO lbl28
            var10_11 = this.a((Object)var7_8.l());
            if (!var11_3) ** GOTO lbl28
lbl23: // 2 sources:
            if (var7_8.b() != 15) ** GOTO lbl-1000
            var10_11 = this.a((Object)var7_8.l());
            if (var11_3) lbl-1000: // 2 sources:
            {
                if (var9_10.b() == 15) {
                    var10_11 = this.a((Object)var9_10.l());
                }
            }
lbl28: // 9 sources:
            this.a(var4_5, var10_11);
            var10_11.b(var4_5);
            this.a(var10_11.f, (as)var5_6);
lbl31: // 2 sources:
            var3_4.g();
        } while (!var11_3);
    }

    public void c(aU aU2, aV aV2) {
        boolean bl2 = N.x;
        int n2 = 0;
        do {
            int n3 = n2;
            block1 : do {
                if (n3 >= aU2.b()) return;
                da da2 = this.b(n2);
                for (p p2 = da2.k(); p2 != null; p2 = p2.a()) {
                    n3 = p2.c() instanceof dg;
                    if (bl2) continue block1;
                    if (n3 == 0) continue;
                    dg dg2 = (dg)p2.c();
                    dg2.a(aU2, n2, aV2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    private dg a(int var1_1, q var2_2, boolean var3_3) {
        var21_4 = N.x;
        var4_5 = var3_3 == false ? 1 : 0;
        var5_6 = var3_3 != false ? 1 : 0;
        var6_7 = new HashMap<Object, Integer>();
        var7_8 = new HashSet<Object>();
        var8_9 = this.a(var2_2, true);
        var9_10 = new HashMap<Object, Integer>();
        var10_11 = new D();
        var11_12 = var8_9.a();
        block0 : do {
            v0 = var11_12.f();
            block1 : while (v0 != 0) {
                var12_13 = var11_12.e();
                v1 = var13_14 = this.a(var12_13);
                if (var21_4) ** GOTO lbl39
                if (v1 == null) ** GOTO lbl22
                if (!var9_10.containsKey(var13_14)) ** GOTO lbl-1000
                var14_17 = (Integer)var9_10.get(var13_14);
                var9_10.put(var13_14, new Integer(var14_17 + 1));
                if (var21_4) lbl-1000: // 2 sources:
                {
                    var9_10.put(var13_14, new Integer(1));
                }
lbl22: // 4 sources:
                var14_16 = this.a((q)var12_13);
                var15_18 = var14_16.size();
                for (var16_21 = var14_16.k(); var16_21 != null; --var15_18, var16_21 = var16_21.a()) {
                    var17_25 = (dg)var16_21.c();
                    v0 = var17_25.h.c() + var5_6;
                    if (var21_4) continue block1;
                    if (v0 < var1_1 || var17_25.g.c() - var4_5 > var1_1 || var7_8.contains(var17_25)) continue;
                    var10_11.add(var17_25);
                    var7_8.add(var17_25);
                    var6_7.put(var17_25, new Integer(var15_18));
                    if (!var21_4) continue;
                }
                var11_12.g();
                if (!var21_4) continue block0;
            }
            break block0;
            break;
        } while (true);
        if (var3_3) {
            var11_12 = var10_11.m();
            while (var11_12.f()) {
                v1 = (dg)var11_12.d();
lbl39: // 2 sources:
                if (var9_10.containsKey(var12_13 = v1) && (var13_15 = ((Integer)var9_10.get(var12_13)).intValue()) == var8_9.size()) {
                    return var12_13;
                }
                var11_12.g();
                if (!var21_4) continue;
            }
        }
        var11_12 = this.a(var2_2, false);
        var12_13 = new D();
        var13_14 = new y();
        var7_8.clear();
        var9_10.clear();
        var14_16 = var11_12.a();
        block4 : do {
            v2 = var14_16.f();
            block5 : while (v2 != 0) {
                var15_20 = var14_16.e();
                v3 = var16_21 = this.a(var15_20);
                if (var21_4) ** GOTO lbl84
                if (v3 == null) ** GOTO lbl61
                if (!var9_10.containsKey(var16_21)) ** GOTO lbl-1000
                var17_26 = (Integer)var9_10.get(var16_21);
                var9_10.put(var16_21, new Integer(var17_26 + 1));
                if (var21_4) lbl-1000: // 2 sources:
                {
                    var9_10.put(var16_21, new Integer(1));
                }
lbl61: // 4 sources:
                var17_25 = this.a((q)var15_20);
                var18_27 = var17_25.size();
                for (var19_30 = var17_25.k(); var19_30 != null; var19_30 = var19_30.a()) {
                    var20_33 = (dg)var19_30.c();
                    v2 = var20_33.h.c() + var5_6;
                    if (var21_4) continue block5;
                    if (v2 < var1_1 || var20_33.g.c() - var4_5 > var1_1) continue;
                    if (var7_8.contains(var20_33)) ** GOTO lbl76
                    var12_13.add(var20_33);
                    var7_8.add(var20_33);
                    if (!var6_7.containsKey(var20_33)) ** GOTO lbl-1000
                    var13_14.add(var20_33);
                    if (var21_4) lbl-1000: // 2 sources:
                    {
                        var10_11.add(var20_33);
                        var6_7.put(var20_33, new Integer(var18_27));
                    }
lbl76: // 4 sources:
                    --var18_27;
                    if (!var21_4) continue;
                }
                var14_16.g();
                if (!var21_4) continue block4;
            }
            break block4;
            break;
        } while (true);
        if (!var3_3) {
            var14_16 = var12_13.m();
            while (var14_16.f()) {
                v3 = (dg)var14_16.d();
lbl84: // 2 sources:
                var15_20 = v3;
                v4 = var9_10.containsKey(var15_20);
                if (!var21_4) {
                    if (v4 && (var16_23 = ((Integer)var9_10.get(var15_20)).intValue()) == var11_12.size()) {
                        return var15_20;
                    }
                    var14_16.g();
                    if (!var21_4) continue;
                }
                break;
            }
        } else {
            v4 = var13_14.isEmpty();
        }
        v5 = var14_16 = v4 != false ? var10_11 : var13_14;
        if (var14_16.isEmpty()) {
            return null;
        }
        var15_19 = (dg)var14_16.f();
        var16_24 = (Integer)var6_7.get(var15_19);
        var17_25 = var14_16.m();
        while (var17_25.f()) {
            v6 = (dg)var17_25.d();
            if (var21_4 != false) return v6;
            var18_29 = v6;
            var19_32 = (Integer)var6_7.get(var18_29);
            if (var16_24 < var19_32) {
                var15_19 = var18_29;
                var16_24 = var19_32;
            }
            var17_25.g();
            if (!var21_4) continue;
        }
        v6 = var15_19;
        return v6;
    }

    /*
     * Unable to fully structure code
     */
    private y a(q var1_1, boolean var2_2) {
        var7_3 = N.x;
        var3_4 = new y();
        var4_5 = new y();
        if (!var2_2) ** GOTO lbl-1000
        var4_5.a(var1_1.n());
        if (var7_3) lbl-1000: // 2 sources:
        {
            var4_5.a(var1_1.o());
        }
        while (!var4_5.isEmpty()) {
            v0 = var4_5;
            if (var7_3 != false) return v0;
            var5_6 = v0.d();
            var6_7 = this.b.a(var5_6);
            if (var6_7.b() == 6 || var6_7.b() == 7) {
                if (var2_2) {
                    var4_5.a(var5_6.o());
                    if (!var7_3) continue;
                }
                var4_5.a(var5_6.o());
                if (!var7_3) continue;
            }
            var3_4.add(var5_6);
            if (!var7_3) continue;
        }
        v0 = var3_4;
        return v0;
    }

    void a(aU aU2) {
        boolean bl2 = N.x;
        int n2 = 0;
        do {
            int n3 = n2;
            int n4 = aU2.b();
            block1 : do {
                if (n3 >= n4) return;
                aQ aQ2 = aU2.a(n2);
                for (p p2 = aQ2.d().k(); p2 != null; p2 = p2.a()) {
                    dg dg2;
                    q q2 = (q)p2.c();
                    aX aX2 = this.b.a(q2);
                    n3 = aX2.b();
                    n4 = 6;
                    if (bl2) continue block1;
                    if (n3 == n4) {
                        dg2 = this.a(n2, q2, true);
                        ((as)aX2).a(dg2.f);
                        this.a((Object)q2, dg2);
                        this.a(dg2.f, (as)aX2);
                        if (!bl2) continue;
                    }
                    if (aX2.b() != 7) continue;
                    dg2 = this.a(n2, q2, false);
                    ((as)aX2).a(dg2.f);
                    this.a((Object)q2, dg2);
                    this.a(dg2.f, (as)aX2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }

    public void d(aU aU2, aV aV2) {
        int n2;
        Object object;
        boolean bl2;
        block5 : {
            bl2 = N.x;
            for (n2 = 0; n2 < this.d.size(); ++n2) {
                object = (dg)this.d.get(n2);
                object.e();
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            n2 = 0;
        }
        do {
            int n3 = n2;
            int n4 = aU2.b();
            block2 : do {
                if (n3 >= n4) return;
                object = aU2.a(n2);
                for (p p2 = object.d().k(); p2 != null; p2 = p2.a()) {
                    q q2 = (q)p2.c();
                    dg dg2 = this.a((Object)q2);
                    da da2 = dg2.b(n2);
                    da2.add(q2);
                    aX aX2 = aV2.a(q2);
                    n3 = aX2.b();
                    n4 = 12;
                    if (bl2) continue block2;
                    if (n3 != n4) continue;
                    dg dg3 = this.a(dg2);
                    dg3.b(n2).add(dg2);
                    if (!bl2) continue;
                }
                break;
            } while (true);
            ++n2;
        } while (!bl2);
    }
}

