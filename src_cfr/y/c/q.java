/*
 * Decompiled with CFR 0_115.
 */
package y.c;

import java.util.Comparator;
import y.c.D;
import y.c.I;
import y.c.d;
import y.c.e;
import y.c.i;
import y.c.r;
import y.c.s;
import y.c.t;
import y.c.u;
import y.c.v;
import y.c.w;
import y.c.x;

public class q
extends I {
    i a;
    d b;
    d c;
    d d;
    d e;
    int f;
    int g;
    int h;

    protected q(i i2) {
        i2.g(this);
    }

    public q a(i i2) {
        return i2.d();
    }

    public int a() {
        return this.f + this.g;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        if (!this.a.e) return this.h;
        this.a.A();
        return this.h;
    }

    public i e() {
        return this.a;
    }

    public d f() {
        return this.c;
    }

    public d g() {
        return this.b;
    }

    public d h() {
        return this.d;
    }

    public d i() {
        return this.e;
    }

    public e j() {
        return new u(this);
    }

    public e k() {
        return new s(this);
    }

    public e l() {
        return new v(this);
    }

    public e a(d d2) {
        return new v(this, d2);
    }

    public x m() {
        return new r(this);
    }

    public x n() {
        return new w(this);
    }

    public x o() {
        return new t(this);
    }

    public d a(q q2) {
        boolean bl2 = D.e;
        if (q2.g < this.f) {
            return q2.b(this);
        }
        d d2 = this.c;
        do {
            if (d2 == null) return null;
            if (d2.f == q2) {
                return d2;
            }
            d2 = d2.a;
        } while (!bl2);
        return null;
    }

    public d b(q q2) {
        boolean bl2 = D.e;
        if (q2.f < this.g) {
            return q2.a(this);
        }
        d d2 = this.b;
        do {
            if (d2 == null) return null;
            if (d2.e == q2) {
                return d2;
            }
            d2 = d2.b;
        } while (!bl2);
        return null;
    }

    public d c(q q2) {
        d d2 = this.a(q2);
        if (d2 != null) return d2;
        return this.b(q2);
    }

    public void a(Comparator comparator) {
        if (this.g <= 1) return;
        if (this.g > 2 || comparator == null) {
            this.b(comparator, new d[this.g]);
            if (!D.e) return;
        }
        this.b(comparator, null);
    }

    public void b(Comparator comparator) {
        if (this.f <= 1) return;
        if (this.f > 2 || comparator == null) {
            this.a(comparator, new d[this.f]);
            if (!D.e) return;
        }
        this.a(comparator, null);
    }

    public String toString() {
        if (this.e() == null) return "node without a graph";
        return new StringBuffer().append("node index:").append(this.d()).toString();
    }

    void a(i i2, int n2) {
        this.a(n2);
        this.a = i2;
    }

    void b(i i2) {
        this.a = i2;
    }

    void b(d d2) {
        block2 : {
            d2.c = this.d;
            d2.a = null;
            if (this.d != null) {
                this.d.a = d2;
                if (!D.e) break block2;
            }
            this.c = d2;
        }
        this.d = d2;
        ++this.f;
    }

    void c(d d2) {
        block2 : {
            d2.a = this.c;
            d2.c = null;
            if (this.c != null) {
                this.c.c = d2;
                if (!D.e) break block2;
            }
            this.d = d2;
        }
        this.c = d2;
        ++this.f;
    }

    /*
     * Unable to fully structure code
     */
    void a(d var1_1, d var2_2, int var3_3) {
        var5_4 = D.e;
        if (var3_3 != 0) ** GOTO lbl21
        if (var2_2 == null) {
            this.b(var1_1);
            if (var5_4 == false) return;
        }
        if (var2_2 == this.d) {
            this.b(var1_1);
            if (var5_4 == false) return;
        }
        if (this.d != null) ** GOTO lbl-1000
        var1_1.c = null;
        var1_1.a = null;
        this.c = this.d = var1_1;
        if (var5_4) lbl-1000: // 2 sources:
        {
            var4_5 = var2_2.a;
            var2_2.a = var1_1;
            var1_1.a = var4_5;
            var4_5.c = var1_1;
            var1_1.c = var2_2;
        }
        ++this.f;
        if (var5_4 == false) return;
lbl21: // 2 sources:
        if (var2_2 == null) {
            this.b(var1_1);
            if (var5_4 == false) return;
        }
        if (var2_2 == this.c) {
            this.c(var1_1);
            if (var5_4 == false) return;
        }
        if (this.d != null) ** GOTO lbl-1000
        var1_1.c = null;
        var1_1.a = null;
        this.c = this.d = var1_1;
        if (var5_4) lbl-1000: // 2 sources:
        {
            var4_5 = var2_2.c;
            var2_2.c = var1_1;
            var1_1.c = var4_5;
            var4_5.a = var1_1;
            var1_1.a = var2_2;
        }
        ++this.f;
    }

    void d(d d2) {
        block2 : {
            d2.d = this.e;
            d2.b = null;
            if (this.e != null) {
                this.e.b = d2;
                if (!D.e) break block2;
            }
            this.b = d2;
        }
        this.e = d2;
        ++this.g;
    }

    void e(d d2) {
        block2 : {
            d2.b = this.b;
            d2.d = null;
            if (this.b != null) {
                this.b.d = d2;
                if (!D.e) break block2;
            }
            this.e = d2;
        }
        this.b = d2;
        ++this.g;
    }

    /*
     * Unable to fully structure code
     */
    void b(d var1_1, d var2_2, int var3_3) {
        var5_4 = D.e;
        if (var3_3 != 0) ** GOTO lbl21
        if (var2_2 == null) {
            this.d(var1_1);
            if (var5_4 == false) return;
        }
        if (var2_2 == this.e) {
            this.d(var1_1);
            if (var5_4 == false) return;
        }
        if (this.e != null) ** GOTO lbl-1000
        var1_1.d = null;
        var1_1.b = null;
        this.b = this.e = var1_1;
        if (var5_4) lbl-1000: // 2 sources:
        {
            var4_5 = var2_2.b;
            var2_2.b = var1_1;
            var1_1.b = var4_5;
            var4_5.d = var1_1;
            var1_1.d = var2_2;
        }
        ++this.g;
        if (var5_4 == false) return;
lbl21: // 2 sources:
        if (var2_2 == null) {
            this.d(var1_1);
            if (var5_4 == false) return;
        }
        if (var2_2 == this.b) {
            this.e(var1_1);
            if (var5_4 == false) return;
        }
        if (this.e != null) ** GOTO lbl-1000
        var1_1.d = null;
        var1_1.b = null;
        this.b = this.e = var1_1;
        if (var5_4) lbl-1000: // 2 sources:
        {
            var4_5 = var2_2.d;
            var2_2.d = var1_1;
            var1_1.d = var4_5;
            var4_5.b = var1_1;
            var1_1.b = var2_2;
        }
        ++this.g;
    }

    void f(d d2) {
        block5 : {
            boolean bl2;
            block4 : {
                bl2 = D.e;
                if (d2 != this.c) {
                    d2.c.a = d2.a;
                    if (!bl2) break block4;
                }
                this.c = d2.a;
            }
            if (d2 != this.d) {
                d2.a.c = d2.c;
                if (!bl2) break block5;
            }
            this.d = d2.c;
        }
        --this.f;
    }

    void g(d d2) {
        block5 : {
            boolean bl2;
            block4 : {
                bl2 = D.e;
                if (d2 != this.b) {
                    d2.d.b = d2.b;
                    if (!bl2) break block4;
                }
                this.b = d2.b;
            }
            if (d2 != this.e) {
                d2.b.d = d2.d;
                if (!bl2) break block5;
            }
            this.e = d2.d;
        }
        --this.g;
    }

    void p() {
        this.d = null;
        this.e = null;
        this.b = null;
        this.c = null;
        this.g = 0;
        this.f = 0;
    }

    void a(Comparator comparator, d[] arrd) {
        d d2;
        int n2;
        int n3;
        boolean bl2;
        block5 : {
            bl2 = D.e;
            if (this.f < 2) {
                return;
            }
            if (this.f == 2 && comparator != null) {
                if (comparator.compare(this.c, this.d) <= 0) return;
                this.d = this.c;
                this.d.c = this.c = this.d.a;
                this.c.a = this.d;
                this.c.c = null;
                this.d.a = null;
                return;
            }
            n2 = this.f;
            n3 = 0;
            d2 = this.c;
            while (d2 != null) {
                arrd[n3] = d2;
                ++n3;
                d2 = d2.a;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            y.g.e.a(arrd, 0, n2, comparator);
        }
        d d3 = this.c = arrd[0];
        d3.c = null;
        for (n3 = 1; n3 < n2; ++n3) {
            d2 = arrd[n3];
            d2.c = d3;
            d3.a = d2;
            d3 = d2;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.d = d2;
        d2.a = null;
    }

    void b(Comparator comparator, d[] arrd) {
        d d2;
        int n2;
        int n3;
        boolean bl2;
        block5 : {
            bl2 = D.e;
            if (this.g < 2) {
                return;
            }
            if (this.g == 2 && comparator != null) {
                if (comparator.compare(this.b, this.e) <= 0) return;
                this.e = this.b;
                this.e.d = this.b = this.e.b;
                this.b.b = this.e;
                this.b.d = null;
                this.e.b = null;
                return;
            }
            n2 = this.g;
            n3 = 0;
            d2 = this.b;
            while (d2 != null) {
                arrd[n3] = d2;
                ++n3;
                d2 = d2.b;
                if (!bl2) {
                    if (!bl2) continue;
                }
                break block5;
            }
            y.g.e.a(arrd, 0, n2, comparator);
        }
        d d3 = this.b = arrd[0];
        d3.d = null;
        for (n3 = 1; n3 < n2; ++n3) {
            d2 = arrd[n3];
            d2.d = d3;
            d3.b = d2;
            d3 = d2;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.e = d2;
        d2.b = null;
    }
}

