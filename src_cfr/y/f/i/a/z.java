/*
 * Decompiled with CFR 0_115.
 */
package y.f.i.a;

import y.c.d;
import y.c.e;
import y.c.h;
import y.f.X;
import y.f.b.c;
import y.f.i.a.aU;
import y.f.i.a.ab;
import y.f.i.a.y;
import y.g.M;

public class Z {
    private final y a;
    private final X b;
    private final c c;
    private h d;
    private long e;

    public Z(X x2, c c2, y y2) {
        this.b = x2;
        this.c = c2;
        this.a = y2;
    }

    public X a() {
        return this.b;
    }

    public c b() {
        return this.c;
    }

    public y c() {
        return this.a;
    }

    void a(long l2) {
        this.e = l2;
    }

    public long d() {
        long l2 = System.currentTimeMillis() - this.e;
        return Math.max(0, this.a.b() - l2);
    }

    aU a(d d2) {
        return (aU)this.e().b(d2);
    }

    private h e() {
        h h2;
        int n2 = ab.a;
        if (this.d == null) {
            this.d = M.b();
            e e2 = this.b.p();
            while (e2.f()) {
                d d2 = e2.a();
                h2 = this.d;
                if (n2 != 0) return h2;
                h2.a((Object)d2, new aU(d2));
                e2.g();
                if (n2 == 0) continue;
            }
        }
        h2 = this.d;
        return h2;
    }
}

