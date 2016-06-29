/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.C;
import y.c.D;
import y.d.t;
import y.f.g.d;

class y {
    public y.d.y a = null;
    public D b = new D();
    public boolean c = false;
    private D d = new D();
    private y.d.y e = null;
    private boolean f = true;

    y() {
    }

    public boolean a() {
        return this.f;
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    /*
     * Unable to fully structure code
     */
    void a(y.d.y var1_1, double var2_2) {
        var11_3 = d.d;
        var4_4 = var1_1.a() / 2.0;
        var6_5 = var1_1.b() / 2.0;
        if (this.a == null) ** GOTO lbl18
        if (var1_1.a() > this.a.a() || var1_1.b() > this.a.b()) ** GOTO lbl9
        var8_6 = new y.d.y(this.a.c() + var4_4, this.a.d() + var6_5, this.a.a() - var1_1.a(), this.a.b() - var1_1.b());
        this.e = y.a((y.d.y)var8_6, var2_2, false);
        if (!var11_3) ** GOTO lbl18
lbl9: // 2 sources:
        if (var1_1.a() > this.a.a()) ** GOTO lbl13
        var8_6 = new y.d.y(this.a.c() + var4_4, this.a.d() + this.a.b(), this.a.a() - var1_1.a(), 0.0);
        this.e = y.a((y.d.y)var8_6, var2_2, false);
        if (!var11_3) ** GOTO lbl18
lbl13: // 2 sources:
        if (var1_1.b() > this.a.b()) ** GOTO lbl-1000
        var8_6 = new y.d.y(this.a.c() + this.a.a() / 2.0, this.a.d() + var6_5, 0.0, this.a.b() - var1_1.b());
        this.e = y.a((y.d.y)var8_6, var2_2, false);
        if (var11_3) lbl-1000: // 2 sources:
        {
            this.e = null;
        }
lbl18: // 6 sources:
        if (this.b == null) return;
        var8_6 = this.b.m();
        do {
            if (var8_6.f() == false) return;
            var9_7 = (y.d.y)var8_6.d();
            var10_8 = new y.d.y(var9_7.c() - var4_4, var9_7.d() - var6_5, var9_7.a() + var1_1.a(), var9_7.b() + var1_1.b());
            this.d.add(y.a(var10_8, var2_2, true));
            var8_6.g();
        } while (!var11_3);
    }

    static y.d.y a(y.d.y y2, double d2, boolean bl2) {
        if (y2 == null) {
            return null;
        }
        if (!bl2) return new y.d.y((int)Math.ceil(y2.c / d2), (int)Math.ceil(y2.d / d2), Math.max(1, (int)Math.floor(y2.a / d2) - 1), Math.max(1, (int)Math.floor(y2.b / d2) - 1));
        return new y.d.y((int)Math.floor(y2.c / d2), (int)Math.floor(y2.d / d2), (int)Math.ceil(y2.a / d2) + 1, (int)Math.ceil(y2.b / d2) + 1);
    }

    boolean b() {
        if (this.a == null) return false;
        if (this.e != null) return false;
        return true;
    }

    int c() {
        if (this.e == null) return Integer.MAX_VALUE;
        return (int)Math.ceil(Math.sqrt(this.e.a() * this.e.a() + this.e.b() * this.e.b()));
    }

    boolean a(t t2) {
        boolean bl2;
        boolean bl3 = d.d;
        if (this.d != null) {
            C c2 = this.d.m();
            while (c2.f()) {
                y.d.y y2 = (y.d.y)c2.d();
                bl2 = y.a(y2, t2);
                if (!bl3) {
                    if (bl2) {
                        return false;
                    }
                    c2.g();
                    if (!bl3) continue;
                }
                break;
            }
        } else {
            bl2 = this.a();
        }
        if (!bl2) return true;
        if (this.e == null) return true;
        return y.a(this.e, t2);
    }

    private static boolean a(y.d.y y2, t t2) {
        if (t2.a < y2.c) return false;
        if (t2.a - y2.c > y2.a) return false;
        if (t2.b < y2.d) return false;
        if (t2.b - y2.d > y2.b) return false;
        return true;
    }
}

