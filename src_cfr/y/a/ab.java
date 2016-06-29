/*
 * Decompiled with CFR 0_115.
 */
package y.a;

import java.util.ArrayList;
import java.util.List;
import y.a.h;
import y.c.d;
import y.c.i;
import y.c.p;
import y.c.q;
import y.c.y;
import y.g.c;

class ab {
    private y a;
    private p[] b;
    private List c;
    private int d;
    private int[] e;
    private int[] f;
    private int[] g;
    private int h;
    private c i;

    public int a(i i2, int[] arrn, int[] arrn2, long l2) {
        int n2;
        int n3;
        boolean bl2;
        int n4;
        block8 : {
            int n5;
            block7 : {
                bl2 = h.a;
                long l3 = System.currentTimeMillis();
                this.b = new p[i2.e()];
                this.a = new y();
                this.e = arrn;
                this.f = arrn2;
                this.g = new int[i2.e()];
                this.h = 0;
                this.i = new c(this.b.length);
                this.c = new ArrayList(i2.e() * 2);
                this.d = 0;
                q q2 = i2.k();
                int n6 = q2.d();
                this.i.b(q2);
                this.b[n6] = this.a.a(q2);
                while (!this.i.e() && System.currentTimeMillis() - l3 < l2) {
                    this.b();
                    if (this.a.size() + this.d >= i2.e()) continue;
                    this.a();
                    if (!bl2) continue;
                }
                int n7 = 0;
                for (n3 = this.c.size() - 1; n3 >= 0; --n3) {
                    Object e2 = this.c.get(n3);
                    n5 = e2 instanceof Integer;
                    if (!bl2) {
                        if (n5 != 0) {
                            n7 += ((Integer)e2).intValue();
                            if (!bl2) continue;
                        }
                        int[] arrn3 = this.e;
                        int n8 = ((q)e2).d();
                        arrn3[n8] = arrn3[n8] + n7;
                        if (!bl2) continue;
                    }
                    break block7;
                }
                n3 = Integer.MAX_VALUE;
                n5 = 0;
            }
            n4 = n5;
            for (n2 = this.e.length - 1; n2 >= 0; --n2) {
                n3 = Math.min(n3, this.e[n2]);
                n4 = Math.max(n4, this.e[n2]);
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block8;
            }
            n2 = arrn.length - 1;
        }
        while (n2 >= 0) {
            arrn[n2] = arrn[n2] - n3;
            --n2;
            if (bl2) return n4 - n3 + 1;
            if (!bl2) continue;
        }
        this.b = null;
        this.a = null;
        this.c = null;
        this.f = null;
        this.i = null;
        this.e = null;
        return n4 - n3 + 1;
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        block15 : {
            var9_1 = h.a;
            ++this.h;
            var1_2 = Integer.MAX_VALUE;
            var2_3 = true;
            var3_4 = this.a.k();
            while (var3_4 != null) {
                var4_6 = (q)var3_4.c();
                var5_8 = true;
                if (!var9_1) {
                    block14 : {
                        for (var6_11 = var4_6.g(); var6_11 != null; var6_11 = var6_11.h()) {
                            var7_12 = var6_11.c();
                            v0 = this.b[var7_12.d()];
                            if (!var9_1) {
                                if (v0 != null) continue;
                                var5_8 = false;
                                var8_13 = this.e[var4_6.d()] - this.e[var7_12.d()] - this.f[var6_11.b()];
                                if (var8_13 <= 0) continue;
                                if (var8_13 < var1_2) {
                                    var1_2 = var8_13;
                                    this.i.c();
                                    ++this.h;
                                    this.i.a(var7_12);
                                    this.g[var7_12.d()] = this.h;
                                    var2_3 = true;
                                    if (!var9_1) continue;
                                }
                                if (!var2_3 || var8_13 != var1_2 || this.g[var7_12.d()] >= this.h) continue;
                                this.i.a(var7_12);
                                this.g[var7_12.d()] = this.h;
                                if (!var9_1) continue;
                            }
                            break block14;
                        }
                        for (var6_11 = var4_6.f(); var6_11 != null; var6_11 = var6_11.g()) {
                            var7_12 = var6_11.d();
                            v0 = this.b[var7_12.d()];
                            if (!var9_1) {
                                if (v0 != null) continue;
                                var5_8 = false;
                                var8_13 = this.e[var7_12.d()] - this.e[var4_6.d()] - this.f[var6_11.b()];
                                if (var8_13 <= 0) continue;
                                if (var8_13 < var1_2) {
                                    var1_2 = var8_13;
                                    this.i.c();
                                    ++this.h;
                                    this.i.a(var7_12);
                                    this.g[var7_12.d()] = this.h;
                                    var2_3 = false;
                                    if (!var9_1) continue;
                                }
                                if (var2_3 || var8_13 != var1_2 || this.g[var7_12.d()] >= this.h) continue;
                                this.i.a(var7_12);
                                this.g[var7_12.d()] = this.h;
                                if (!var9_1) continue;
                            }
                            break block14;
                        }
                        if (var5_8) {
                            this.c.add(var4_6);
                            ++this.d;
                            this.a.h(this.b[var4_6.d()]);
                        }
                        v0 = var3_4 = var3_4.a();
                    }
                    if (!var9_1) continue;
                }
                ** GOTO lbl-1000
            }
            if (var2_3) {
                v1 = - var1_2;
            } else lbl-1000: // 2 sources:
            {
                v1 = var1_2;
            }
            var3_5 = v1;
            this.c.add(new Integer(var3_5));
            for (var4_6 = this.a.k(); var4_6 != null; var4_6 = var4_6.a()) {
                v2 = this;
                if (!var9_1) {
                    v3 = v2.e;
                    v4 = ((q)var4_6.c()).d();
                    v3[v4] = v3[v4] + var3_5;
                    if (!var9_1) continue;
                }
                break block15;
            }
            v2 = this;
        }
        var4_7 = v2.i.d();
        do {
            if (var4_7 <= 0) return;
            var5_10 = (q)this.i.a();
            this.b[var5_10.d()] = this.a.a(var5_10);
            this.i.a(var5_10);
            --var4_7;
        } while (!var9_1);
    }

    /*
     * Unable to fully structure code
     */
    private void b() {
        var7_1 = h.a;
        do lbl-1000: // 3 sources:
        {
            if (this.i.e() != false) return;
            var1_2 = true;
            v0 = this.i.a();
            block1 : do lbl-1000: // 3 sources:
            {
                var2_3 = (q)v0;
                var3_4 = var2_3.d();
                for (var4_5 = var2_3.f(); var4_5 != null; var4_5 = var4_5.g()) {
                    var5_6 = var4_5.d();
                    v0 = this.b[var5_6.d()];
                    if (var7_1) ** GOTO lbl-1000
                    if (v0 != null) continue;
                    var6_7 = this.e[var5_6.d()] - this.e[var3_4] - this.f[var4_5.b()];
                    if (var6_7 == 0) {
                        this.i.a(var5_6);
                        this.b[var5_6.d()] = this.a.a(var5_6);
                        if (!var7_1) continue;
                    }
                    var1_2 = false;
                    if (!var7_1) continue;
                }
                for (var4_5 = var2_3.g(); var4_5 != null; var4_5 = var4_5.h()) {
                    var5_6 = var4_5.c();
                    v0 = this.b[var5_6.d()];
                    if (var7_1) continue block1;
                    if (v0 != null) continue;
                    var6_7 = this.e[var3_4] - this.e[var5_6.d()] - this.f[var4_5.b()];
                    if (var6_7 == 0) {
                        this.i.a(var5_6);
                        this.b[var5_6.d()] = this.a.a(var5_6);
                        if (!var7_1) continue;
                    }
                    var1_2 = false;
                    if (!var7_1) continue;
                }
                break;
            } while (true);
            if (!var1_2) ** GOTO lbl-1000
            this.c.add(var2_3);
            ++this.d;
            this.a.h(this.b[var3_4]);
        } while (!var7_1);
    }
}

