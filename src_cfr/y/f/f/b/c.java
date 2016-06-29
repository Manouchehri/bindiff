/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.b;

import y.c.C;
import y.c.d;
import y.c.e;
import y.c.f;
import y.c.i;
import y.c.x;
import y.f.f.b.h;
import y.f.f.b.o;
import y.f.h.D;
import y.f.h.N;
import y.f.h.p;
import y.f.h.q;

public class c {
    private static final int a = o.a.f();
    private static final int b = o.b.f();
    private static final int c = o.c.f();
    private static final int d = o.d.f();
    private static final String[] e = new String[4];
    private f f = new f();
    private D g;
    private h h;
    private i i;

    public void a(i i2) {
        int n2 = h.a;
        e e2 = i2.p();
        do {
            if (!e2.f()) return;
            if (e2.a().e()) {
                this.f.c(e2.a());
                i2.d(e2.a());
            }
            e2.g();
        } while (n2 == 0);
    }

    public void a(h h2) {
        this.h = h2;
        this.g = (D)this.h.b();
        this.i = this.g.g();
    }

    private o a(y.c.q q2) {
        int[][] arrn = this.h.i(q2);
        int[] arrn2 = this.h.h(q2);
        int n2 = arrn[a][0] + arrn[b][2];
        int n3 = arrn2[a] + arrn2[b];
        int n4 = arrn[b][0] + arrn[c][2];
        int n5 = arrn2[b] + arrn2[c];
        int n6 = arrn[c][0] + arrn[d][2];
        int n7 = arrn2[c] + arrn2[d];
        int n8 = arrn[d][0] + arrn[a][2];
        int n9 = arrn2[d] + arrn2[a];
        int n10 = n2;
        int n11 = n3;
        int n12 = a;
        if (n4 < n10 || n4 == n10 && n5 < n11) {
            n10 = n4;
            n11 = n5;
            n12 = b;
        }
        if (n6 < n10 || n6 == n10 && n7 < n11) {
            n10 = n6;
            n11 = n7;
            n12 = c;
        }
        if (n8 >= n10) {
            if (n8 != n10) return o.a(n12);
            if (n9 >= n11) return o.a(n12);
        }
        n10 = n8;
        n11 = n9;
        n12 = d;
        return o.a(n12);
    }

    /*
     * Unable to fully structure code
     */
    private void a(y.c.q var1_1, o var2_2, f var3_3) {
        var12_4 = h.a;
        if (var3_3 == null) return;
        if (var3_3.size() == 0) {
            return;
        }
        var4_5 = null;
        var5_6 = var1_1.l();
        while (var5_6.f()) {
            if (this.h.d(var5_6.a()) > 0) {
                var4_5 = var5_6.a();
                break;
            }
            var5_6.g();
        }
        var5_6 = null;
        var6_7 = null;
        if (var4_5 != null) {
            block8 : {
                var5_6 = null;
                var7_8 = this.h.h(var4_5);
                var8_9 = var1_1.a(var4_5);
                for (var9_10 = 0; var9_10 < var8_9.k(); ++var9_10) {
                    var10_12 = var8_9.a();
                    if (var12_4 == 0) {
                        if (this.a((o)var7_8, this.h.h(var10_12), var2_2)) break;
                        var5_6 = var10_12;
                        var8_9.b();
                        if (var12_4 == 0) continue;
                    }
                    break block8;
                }
                var8_9 = var1_1.a((d)var5_6);
                var8_9.b();
            }
            var6_7 = var8_9.a();
        }
        var7_8 = var3_3.d();
        this.i.e((d)var7_8);
        if (var4_5 != null) ** GOTO lbl-1000
        var8_9 = this.g.g((d)var7_8);
        this.h.a((d)var7_8, c.e[var2_2.f()]);
        this.h.f((d)var7_8);
        this.h.a((d)var7_8, 3);
        this.h.a((d)var8_9, 1);
        this.g.l();
        this.g.b(this.g.h().a());
        if (var12_4 != 0) lbl-1000: // 2 sources:
        {
            this.g.a((d)var6_7, (d)var7_8);
            var8_9 = this.h.a((d)var7_8);
            this.h.a((d)var7_8, c.e[var2_2.f()]);
            this.h.f((d)var7_8);
            this.h.a((d)var7_8, this.a((d)var5_6, (d)var7_8));
            this.h.a((d)var8_9, 1);
            this.h.a((d)var6_7, this.a((d)var8_9, (d)var6_7));
            this.g.k();
        }
        var5_6 = var7_8;
        var6_7 = var8_9;
        var9_11 = var3_3.a();
        do {
            if (var9_11.f() == false) return;
            var10_12 = var9_11.a();
            this.i.e(var10_12);
            this.g.a((d)var6_7, var10_12);
            var11_13 = this.h.a(var10_12);
            this.h.a(var10_12, c.e[var2_2.f()]);
            this.h.f(var10_12);
            this.h.a(var10_12, 0);
            this.h.a(var11_13, 1);
            this.h.a((d)var6_7, 0);
            this.g.k();
            var5_6 = var10_12;
            var6_7 = var11_13;
            var9_11.g();
        } while (var12_4 == 0);
    }

    private boolean a(o o2, o o3, o o4) {
        int n2;
        String string = "^>_<^>_<";
        int n3 = string.indexOf(o2.toString());
        int n4 = string.indexOf(o3.toString(), n3);
        if (n4 <= (n2 = string.indexOf(o4.toString(), n3))) return false;
        return true;
    }

    private int a(d d2, d d3) {
        String string = "^>_<^>_<";
        char c2 = this.h.e(d2).charAt(0);
        char c3 = this.h.e(d3).charAt(0);
        int n2 = string.indexOf(c2);
        int n3 = string.indexOf(c3, n2);
        return n3 - n2;
    }

    public void a() {
        int n2 = h.a;
        f[] arrf = new f[this.i.f()];
        C c2 = this.f.a();
        while (c2.f()) {
            d d2 = c2.a();
            int n3 = d2.c().d();
            if (arrf[n3] == null) {
                arrf[n3] = new f();
            }
            arrf[n3].add(d2);
            c2.g();
            if (n2 == 0) continue;
        }
        c2 = this.i.o();
        do {
            if (!c2.f()) return;
            y.c.q q2 = c2.e();
            if (arrf[q2.d()] != null) {
                this.a(q2, this.a(q2), arrf[q2.d()]);
            }
            c2.g();
        } while (n2 == 0);
    }

    static {
        c.e[c.a] = "^>_<";
        c.e[c.b] = ">_<^";
        c.e[c.c] = "_<^>";
        c.e[c.d] = "<^>_";
    }
}

