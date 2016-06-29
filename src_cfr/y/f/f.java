/*
 * Decompiled with CFR 0_115.
 */
package y.f;

import java.util.HashMap;
import java.util.Map;
import y.c.c;
import y.c.d;
import y.c.e;
import y.c.i;
import y.d.n;
import y.d.t;
import y.d.z;
import y.f.G;
import y.f.H;
import y.f.S;
import y.f.U;
import y.f.X;
import y.f.aG;
import y.f.an;
import y.f.y;

public class F {
    private final Map a = new HashMap();
    private final Map b = new HashMap();

    private static byte d(i i2) {
        c c2 = i2.c("PARTITION_ORIENTATION_DPKEY");
        if (c2 == null) return 0;
        an an2 = (an)c2.b(i2);
        return an2.b();
    }

    static boolean a(i i2) {
        c c2 = i2.c("PARTITION_ORIENTATION_DPKEY");
        if (c2 == null) return false;
        an an2 = (an)c2.b(i2);
        return an2.b(an2.b());
    }

    public void b(i i2) {
        boolean bl2 = X.j;
        c c2 = i2.c(U.a);
        if (c2 == null) return;
        e e2 = i2.p();
        block0 : do {
            if (!e2.f()) return;
            d d2 = e2.a();
            S[] arrs = (S[])c2.b(d2);
            if (arrs != null) {
                for (int i3 = 0; i3 < arrs.length; ++i3) {
                    S s2 = arrs[i3];
                    aG aG2 = s2.f();
                    aG aG3 = this.a(aG2);
                    this.b.put(aG3, aG2);
                    s2.a(aG3);
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
            }
            e2.g();
        } while (!bl2);
    }

    public void c(i i2) {
        boolean bl2 = X.j;
        c c2 = i2.c(U.a);
        if (c2 == null) return;
        e e2 = i2.p();
        block0 : do {
            if (!e2.f()) return;
            d d2 = e2.a();
            S[] arrs = (S[])c2.b(d2);
            if (arrs != null) {
                for (int i3 = 0; i3 < arrs.length; ++i3) {
                    S s2 = arrs[i3];
                    aG aG2 = s2.f();
                    aG aG3 = (aG)this.b.get(aG2);
                    s2.a(aG3);
                    if (bl2) continue block0;
                    if (!bl2) continue;
                }
            }
            e2.g();
        } while (!bl2);
    }

    public void a(i i2, S s2, y y2) {
        if (this.a.containsKey(s2)) {
            return;
        }
        aG aG2 = s2.f();
        y y3 = F.a(i2, y2);
        H h2 = new H(aG2, y3, null);
        this.a.put(s2, h2);
        aG aG3 = this.a(aG2);
        aG aG4 = this.a(i2, aG3, y3);
        s2.a(aG4);
        F.a(s2, y2);
    }

    /*
     * Unable to fully structure code
     */
    private aG a(aG var1_1) {
        block9 : {
            block8 : {
                var3_2 = X.j;
                var2_3 = new aG(var1_1);
                if (!var1_1.i()) ** GOTO lbl6
                var2_3.a(1);
                if (!var3_2) ** GOTO lbl10
lbl6: // 2 sources:
                if (!var1_1.j()) ** GOTO lbl-1000
                var2_3.a(4);
                if (var3_2) lbl-1000: // 2 sources:
                {
                    var2_3.a(2);
                }
lbl10: // 4 sources:
                if (!var1_1.l()) ** GOTO lbl13
                var2_3.b(16);
                if (!var3_2) ** GOTO lbl17
lbl13: // 2 sources:
                if (!var1_1.m()) ** GOTO lbl-1000
                var2_3.b(8);
                if (var3_2) lbl-1000: // 2 sources:
                {
                    var2_3.b(32);
                }
lbl17: // 4 sources:
                if (!var1_1.u()) ** GOTO lbl20
                var2_3.c(1);
                if (!var3_2) ** GOTO lbl24
lbl20: // 2 sources:
                if (!var1_1.v()) ** GOTO lbl-1000
                var2_3.c(2);
                if (var3_2) lbl-1000: // 2 sources:
                {
                    var2_3.c(4);
                }
lbl24: // 4 sources:
                if (var1_1.p()) {
                    var2_3.d(2);
                    if (!var3_2) break block8;
                }
                var2_3.d(1);
            }
            if (var1_1.q()) {
                var2_3.e(1);
                if (!var3_2) break block9;
            }
            var2_3.e(2);
        }
        if (var1_1.s()) {
            var2_3.f(1);
            if (var3_2 == false) return var2_3;
        }
        var2_3.f(2);
        return var2_3;
    }

    public void a(i i2, S s2) {
        t t2 = s2.a().k();
        t t3 = this.a(i2, t2);
        H h2 = (H)this.a.get(s2);
        if (h2 != null) {
            s2.a(this.a(H.a(h2)));
            F.a(s2, H.b(h2));
            s2.a(H.a(h2));
            this.a.remove(s2);
        }
        s2.a().b(t3);
    }

    private aG a(i i2, aG aG2, y y2) {
        aG aG3 = new aG(aG2);
        byte by2 = this.b(i2, aG2, y2);
        aG3.b(by2);
        aG3.c(1);
        double d2 = this.c(i2, aG2, y2);
        if (aG2.n()) {
            if (aG3.r()) {
                d2 = 3.141592653589793 - d2;
            }
            if (aG3.t()) {
                d2 += 3.141592653589793;
            }
        }
        aG3.a(d2);
        aG3.d(2);
        aG3.e(1);
        aG3.f(1);
        return aG3;
    }

    private byte b(i i2, aG aG2, y y2) {
        byte by2 = aG2.b();
        if (aG2.v() && (y2 == y.c || y2 == y.d) || aG2.w() && (y2 == y.c || y2 == y.b)) {
            by2 = this.a(by2);
        }
        if (!F.a(i2)) return by2;
        return this.a(by2);
    }

    /*
     * Unable to fully structure code
     */
    private double c(i var1_1, aG var2_2, y var3_3) {
        var6_4 = X.j;
        var4_5 = var2_2.d();
        if (!var2_2.p()) ** GOTO lbl6
        var4_5 += 0.0;
        if (!var6_4) ** GOTO lbl17
lbl6: // 2 sources:
        if (var3_3 != y.b) ** GOTO lbl9
        var4_5 += 0.0;
        if (!var6_4) ** GOTO lbl17
lbl9: // 2 sources:
        if (var3_3 != y.a) ** GOTO lbl12
        var4_5 += 1.5707963267948966;
        if (!var6_4) ** GOTO lbl17
lbl12: // 2 sources:
        if (var3_3 != y.d) ** GOTO lbl-1000
        var4_5 += 3.141592653589793;
        if (var6_4) lbl-1000: // 2 sources:
        {
            if (var3_3 == y.c) {
                var4_5 += 4.71238898038469;
            }
        }
lbl17: // 8 sources:
        if (F.a(var1_1) == false) return var4_5;
        return 3.141592653589793 - var4_5;
    }

    private t a(i i2, t t2) {
        byte by2 = F.d(i2);
        if (F.a(i2)) {
            switch (by2) {
                case 0: {
                    return new t(- t2.a(), t2.b());
                }
                case 1: {
                    return new t(t2.b(), t2.a());
                }
                case 3: {
                    return new t(- t2.b(), - t2.a());
                }
                case 2: {
                    return new t(t2.a(), - t2.b());
                }
            }
            if (!X.j) return t2;
        }
        switch (by2) {
            case 0: {
                return t2;
            }
            case 1: {
                return new t(t2.b(), - t2.a());
            }
            case 3: {
                return new t(- t2.b(), t2.a());
            }
            case 2: {
                return new t(- t2.a(), - t2.b());
            }
        }
        return t2;
    }

    private static y a(i i2, y y2) {
        boolean bl2 = F.a(i2);
        y y3 = bl2 && y2.d() ? y2.c() : y2;
        switch (F.d(i2)) {
            case 0: {
                return y3;
            }
            case 2: {
                return y3.c();
            }
            case 1: {
                return y3.b();
            }
            case 3: {
                return y3.a();
            }
        }
        return null;
    }

    private byte a(byte by2) {
        switch (by2) {
            case 16: {
                return 32;
            }
            case 32: {
                return 16;
            }
        }
        return 8;
    }

    public static void a(S s2, y y2) {
        z z2 = F.a(s2.f(), y2);
        n n2 = s2.a();
        n2.c(z2.a(), z2.b());
        s2.a(n2);
    }

    /*
     * Unable to fully structure code
     */
    public static z a(aG var0, y var1_1) {
        var6_2 = X.j;
        var2_3 = 0.0;
        if (!var0.o()) ** GOTO lbl6
        var2_3 = 0.0;
        if (!var6_2) ** GOTO lbl17
lbl6: // 2 sources:
        if (!y.b.equals(var1_1)) ** GOTO lbl9
        var2_3 = 0.0;
        if (!var6_2) ** GOTO lbl17
lbl9: // 2 sources:
        if (!y.c.equals(var1_1)) ** GOTO lbl12
        var2_3 = 1.5707963267948966;
        if (!var6_2) ** GOTO lbl17
lbl12: // 2 sources:
        if (!y.d.equals(var1_1)) ** GOTO lbl-1000
        var2_3 = 3.141592653589793;
        if (var6_2) lbl-1000: // 2 sources:
        {
            if (y.a.equals(var1_1)) {
                var2_3 = 4.71238898038469;
            }
        }
lbl17: // 8 sources:
        var4_4 = var0.d();
        if (var0.n() == false) return F.a(var2_3 + var4_4);
        if (var0.r()) {
            var4_4 = - var4_4;
        }
        if (var0.t() == false) return F.a(var2_3 + var4_4);
        var4_4 -= 3.141592653589793;
        return F.a(var2_3 + var4_4);
    }

    public static z a(double d2) {
        return new z(Math.sin(d2), - Math.cos(d2));
    }
}

