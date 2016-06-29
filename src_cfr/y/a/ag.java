/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import y.a.D;
import y.a.S;
import y.a.ah;
import y.a.ai;
import y.a.aj;
import y.a.ak;
import y.a.h;
import y.c.A;
import y.c.C;
import y.c.a;
import y.c.b;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.q;
import y.c.x;
import y.c.y;
import y.g.I;
import y.g.M;

class ag {
    private final D a;
    private int b;
    private S c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private double h;
    private boolean i;

    static void a(C c2, b b2, c c3) {
        boolean bl2 = h.a;
        c2.i();
        do {
            if (!c2.f()) return;
            b2.a(c2.d(), b2.c(c2.d()) + c3.c(c2.d()));
            c2.g();
        } while (!bl2);
    }

    static void b(C c2, b b2, c c3) {
        boolean bl2 = h.a;
        c2.i();
        do {
            if (!c2.f()) return;
            b2.a(c2.d(), b2.c(c2.d()) - c3.c(c2.d()));
            c2.g();
        } while (!bl2);
    }

    static void a(C c2, c c3, a a2) {
        boolean bl2 = h.a;
        c2.i();
        do {
            if (!c2.f()) return;
            a2.a(c2.d(), c3.a(c2.d()));
            c2.g();
        } while (!bl2);
    }

    static int a(d d2, A a2, int n2) {
        boolean bl2 = h.a;
        y y2 = new y();
        y2.add(d2.c());
        a2.a((Object)d2.c(), n2);
        y2.add(d2.d());
        a2.a((Object)d2.d(), - n2);
        block0 : do {
            int n3 = y2.isEmpty();
            block1 : do {
                if (n3 != 0) return 2;
                q q2 = y2.d();
                int n4 = a2.a(q2);
                e e2 = q2.j();
                do {
                    int n5;
                    if (!e2.f()) continue block0;
                    q q3 = e2.a().a(q2);
                    n3 = n5 = a2.a(q3);
                    if (bl2) continue block1;
                    if (bl2) int n6;
                    return n6;
                    if (n3 != n4) {
                        if (n5 == - n4) {
                            return 1;
                        }
                        a2.a((Object)q3, n4);
                        y2.add(q3);
                    }
                    e2.g();
                } while (!bl2);
                break;
            } while (true);
            break;
        } while (true);
        return 2;
    }

    static void a(d d2, int n2, y y2, f f2, A a2) {
        boolean bl2 = h.a;
        if (d2 == null) {
            return;
        }
        y.c.h h2 = M.b();
        y y3 = new y();
        y3.add(d2.c());
        a2.a((Object)d2.c(), 1);
        y3.add(d2.d());
        a2.a((Object)d2.d(), 1);
        block0 : do {
            int n3 = y3.isEmpty();
            block1 : do {
                if (n3 != 0) return;
                q q2 = y3.d();
                int n4 = a2.a(q2);
                y2.add(q2);
                e e2 = q2.j();
                do {
                    if (!e2.f()) continue block0;
                    d d3 = e2.a();
                    q q3 = d3.a(q2);
                    n3 = n4 + 1;
                    if (bl2) continue block1;
                    if (n3 <= n2 && a2.a(q3) <= 0) {
                        a2.a((Object)q3, n4 + 1);
                        y3.add(q3);
                    }
                    if (a2.a(q3) > 0 && !h2.d(d3)) {
                        f2.add(d3);
                        h2.a((Object)d3, true);
                    }
                    e2.g();
                } while (!bl2);
                break;
            } while (true);
            break;
        } while (true);
    }

    ag() {
        this.c(2);
        this.b(Integer.MAX_VALUE);
        this.a(1);
        this.a = new D();
        this.c = S.a();
        this.b = 0;
        this.g = true;
        this.i = false;
        this.h = 1.0;
    }

    void a(double d2) {
        boolean bl2 = h.a;
        if (d2 < 0.0) throw new IllegalArgumentException("Ratio must be within [0,1]");
        if (d2 > 1.0) {
            throw new IllegalArgumentException("Ratio must be within [0,1]");
        }
        this.b(true);
        this.c(2);
        this.b(Integer.MAX_VALUE);
        this.a(4);
        this.d(0);
        this.a(false);
        this.b(1.0);
        this.e(2);
        if (d2 > 0.84) {
            this.d(0);
            if (!bl2) return;
        }
        if (d2 > 0.69) {
            this.d(1);
            if (!bl2) return;
        }
        if (d2 > 0.29) {
            this.d(1);
            this.b(4.0);
            if (!bl2) return;
        }
        this.d(2);
        this.e(2);
    }

    void a(int n2) {
        if (n2 > 1) {
            this.d = n2;
            if (!h.a) return;
        }
        this.d = 2;
    }

    void b(int n2) {
        if (n2 > 1) {
            this.f = n2;
            if (!h.a) return;
        }
        this.f = Integer.MAX_VALUE;
    }

    void c(int n2) {
        if (n2 > 0) {
            this.e = n2;
            if (!h.a) return;
        }
        this.e = 1;
    }

    void d(int n2) {
        this.b = n2;
        this.a.a(n2);
    }

    void b(double d2) {
        this.h = d2;
    }

    void a(boolean bl2) {
        this.i = bl2;
    }

    void e(int n2) {
        this.a.b(n2);
    }

    void b(boolean bl2) {
        this.g = bl2;
    }

    /*
     * Unable to fully structure code
     */
    int a(i var1_1, A var2_2) {
        var14_3 = h.a;
        var3_4 = new I(var1_1);
        var4_5 = var1_1.n();
        if (this.b != 2) ** GOTO lbl7
        var5_6 = new ah(this, var1_1);
        if (!var14_3) ** GOTO lbl11
lbl7: // 2 sources:
        if (!this.i) ** GOTO lbl-1000
        var5_6 = new ak(this, var1_1);
        if (var14_3) lbl-1000: // 2 sources:
        {
            var5_6 = new ai(this, var1_1);
        }
lbl11: // 4 sources:
        var6_7 = h.a(var1_1);
        for (var7_8 = 0; var7_8 < var6_7.length; ++var7_8) {
            var5_6.b(var6_7[var7_8]);
            if (!var14_3) continue;
        }
        var7_9 = aj.a(var1_1, var5_6.e(), var5_6.d(), this.c.a(var4_5, var5_6.e(), var5_6.d()));
        var8_10 = M.a(new int[var1_1.e()]);
        var9_11 = 1;
        while (var5_6.d() < this.f) {
            v0 = var5_6.c();
            if (var14_3 != false) return v0;
            if (v0 == 0) break;
            var10_12 = var5_6.b();
            var3_4.a(var10_12);
            var11_13 = var5_6.a(var10_12.c());
            var12_14 = ag.a(var10_12, var8_10, ++var9_11);
            if (var12_14 == 1) {
                var5_6.c(var11_13);
                if (!var14_3) continue;
            }
            if (var12_14 != 2) throw new IllegalStateException("There shouldn't be more than 2 components after an edge removal.");
            var5_6.a(var11_13, var8_10);
            var13_15 = aj.a(var1_1, var5_6.e(), var5_6.d(), this.c.a(var4_5, var5_6.e(), var5_6.d()));
            if (var13_15.b() != this.e && var13_15.c() <= var7_9.c()) continue;
            var7_9 = var13_15;
            if (!var14_3) continue;
            throw new IllegalStateException("There shouldn't be more than 2 components after an edge removal.");
        }
        ag.a((C)var1_1.o(), (c)var7_9.a(), var2_2);
        var5_6.a();
        var3_4.h();
        v0 = var7_9.b();
        return v0;
    }

    static D a(ag ag2) {
        return ag2.a;
    }

    static double b(ag ag2) {
        return ag2.h;
    }

    static int c(ag ag2) {
        return ag2.d;
    }

    static boolean d(ag ag2) {
        return ag2.g;
    }
}

