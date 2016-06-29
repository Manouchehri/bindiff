/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import y.c.D;
import y.c.c;
import y.c.d;
import y.c.e;
import y.d.m;
import y.d.s;
import y.d.t;
import y.f.X;
import y.f.i.a.I;
import y.f.i.a.K;
import y.f.i.a.P;
import y.f.i.a.R;
import y.f.i.a.Z;
import y.f.i.a.ab;
import y.f.i.a.bT;
import y.f.i.a.bU;
import y.f.i.a.bV;
import y.f.i.a.bc;
import y.f.i.a.v;
import y.f.y;

class bS
extends K {
    private HashMap a;
    private List b;

    bS() {
    }

    @Override
    public void a() {
        super.a();
        this.a = null;
        this.b = null;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void a(R var1_1, List var2_2) {
        var13_3 = ab.a;
        var3_4 = (List)this.a.get(var1_1);
        if (var3_4 == null) return;
        for (bU var5_6 : var3_4) {
            block3 : {
                var6_7 = bU.a(var5_6);
                var7_8 = null;
                var9_10 = 0;
                for (var10_11 = 0; var10_11 < bU.b(var5_6).length; ++var10_11) {
                    var8_9 = bU.b(var5_6)[var10_11];
                    v0 = var7_8;
                    if (var13_3 != 0) break block3;
                    if (v0 == null || var7_8.g().a(var8_9.d())) ** GOTO lbl-1000
                    var11_12 = var10_11 - var9_10 + 1;
                    var12_13 = this.a(var6_7, var5_6, var9_10, var11_12);
                    this.a(var7_8, var12_13);
                    if (var13_3 != 0) lbl-1000: // 2 sources:
                    {
                        if (var7_8 != null) continue;
                    }
                    var7_8 = this.a(var2_2, var8_9, var7_8, bU.c(var5_6) + var10_11, var6_7);
                    var9_10 = var10_11;
                    if (var7_8 == null) break;
                    if (var13_3 == 0) continue;
                }
                v0 = var7_8;
            }
            if (v0 == null) continue;
            this.a(var7_8, this.a(var6_7, var5_6, var9_10, bU.b(var5_6).length - var9_10));
            if (var13_3 != 0) return;
            if (var13_3 == 0) continue;
        }
        this.a.remove(var1_1);
    }

    private bU a(d d2, bU bU2, int n2, int n3) {
        m[] arrm = new m[n3];
        System.arraycopy(bU.b(bU2), n2, arrm, 0, n3);
        return new bU(d2, arrm, bU.c(bU2) + n2, null);
    }

    /*
     * Unable to fully structure code
     */
    private R a(List var1_1, m var2_2, R var3_3, int var4_4, d var5_5) {
        var10_6 = ab.a;
        var6_7 = null;
        var7_8 = this.a(var1_1, var2_2);
        var8_9 = var7_8.iterator();
        do lbl-1000: // 4 sources:
        {
            if (var8_9.hasNext() == false) return var6_7;
            var9_10 = (R)var8_9.next();
            if (!var9_10.g().a(var2_2.d())) ** GOTO lbl11
            var6_7 = var9_10;
            if (var10_6 == 0) ** GOTO lbl-1000
lbl11: // 2 sources:
            if (var9_10 == var3_3) ** GOTO lbl-1000
            this.a(var9_10, new bU(var5_5, new m[]{var2_2}, var4_4, null));
        } while (var10_6 == 0);
        return var6_7;
    }

    private void a(R r2, bU bU2) {
        ArrayList<bU> arrayList = (ArrayList<bU>)this.a.get(r2);
        if (arrayList == null) {
            arrayList = new ArrayList<bU>();
            this.a.put(r2, arrayList);
        }
        arrayList.add(bU2);
    }

    private List a(List list, m m2) {
        ArrayList<R> arrayList;
        int n2 = ab.a;
        ArrayList<R> arrayList2 = new ArrayList<R>();
        for (R r2 : list) {
            if (!m2.a(r2.g())) continue;
            arrayList = arrayList2;
            if (n2 != 0) return arrayList;
            arrayList.add(r2);
            if (n2 == 0) continue;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    @Override
    public void b(R r2) {
        int n2 = ab.a;
        List list = (List)this.a.get(r2);
        if (list == null) return;
        if (list.size() <= 0) return;
        bc bc2 = r2.b();
        Iterator iterator = list.iterator();
        do {
            if (!iterator.hasNext()) return;
            bU bU2 = (bU)iterator.next();
            y.d.y y2 = r2.g();
            t t2 = bU.b(bU2)[0].c();
            t t3 = bU.b(bU2)[bU.b(bU2).length - 1].d();
            bV bV2 = this.a(y2, t2, true);
            bV bV3 = this.a(y2, t3, false);
            v v2 = new v(bU.a(bU2), r2, bV2.a, bV3.a, bV2.b, bV3.b, bU.c(bU2));
            bc2.a(v2);
        } while (n2 == 0);
    }

    private bV a(y.d.y y2, t t2, boolean bl2) {
        y y3;
        double d2 = y2.c();
        double d3 = d2 + y2.a();
        double d4 = y2.d();
        double d5 = d4 + y2.b();
        double d6 = t2.a();
        double d7 = t2.b();
        if (d6 < d2 + 1.0E-6) {
            y y4;
            if (bl2) {
                y4 = y.b;
                return new bV(y4, new P(d7, d7, d2, true), null);
            }
            y4 = y.d;
            return new bV(y4, new P(d7, d7, d2, true), null);
        }
        if (d6 > d3 - 1.0E-6) {
            y y5;
            if (bl2) {
                y5 = y.d;
                return new bV(y5, new P(d7, d7, d3, true), null);
            }
            y5 = y.b;
            return new bV(y5, new P(d7, d7, d3, true), null);
        }
        if (d7 < d4 + 1.0E-6) {
            y y6;
            if (bl2) {
                y6 = y.c;
                return new bV(y6, new P(d6, d6, d4, false), null);
            }
            y6 = y.a;
            return new bV(y6, new P(d6, d6, d4, false), null);
        }
        if (d7 <= d5 - 1.0E-6) return new bV(null, null, null);
        if (bl2) {
            y3 = y.a;
            return new bV(y3, new P(d6, d6, d5, false), null);
        }
        y3 = y.c;
        return new bV(y3, new P(d6, d6, d5, false), null);
    }

    @Override
    public void a(R r2) {
        if (this.b == null) return;
        this.a.put(r2, this.b);
        this.b = null;
    }

    @Override
    public void a(Z z2, I i2) {
        int n2 = ab.a;
        super.a(z2, i2);
        X x2 = z2.a();
        this.a = new HashMap();
        y.f.i.a.y y2 = z2.c();
        c c2 = x2.c(y2.h());
        if (y2.f() == 0) return;
        if (c2 == null) {
            return;
        }
        this.b = new D();
        e e2 = x2.p();
        do {
            boolean bl2 = e2.f();
            block1 : do {
                if (!bl2) return;
                d d2 = e2.a();
                if (c2.d(d2)) break;
                s s2 = x2.l(d2).j();
                if (y.f.i.a.y.b(d2, x2)) {
                    m[] arrm = y.f.i.a.y.c(d2, x2);
                    this.b.add(new bU(d2, arrm, 0, null));
                    if (n2 == 0) break;
                }
                int n3 = 0;
                while (s2.f()) {
                    m m2 = s2.a();
                    bl2 = this.a(m2);
                    if (n2 != 0) continue block1;
                    if (bl2) {
                        this.b.add(new bU(d2, new m[]{m2}, n3, null));
                    }
                    s2.g();
                    ++n3;
                    if (n2 == 0) continue;
                }
                break block1;
                break;
            } while (true);
            e2.g();
        } while (n2 == 0);
    }

    private boolean a(m m2) {
        if (m2.b()) return true;
        if (m2.a()) return true;
        return false;
    }
}

