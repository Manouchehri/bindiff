/*
 * Decompiled with CFR 0_115.
 */
package y.f.g;

import y.c.D;
import y.c.f;
import y.c.p;
import y.c.q;
import y.c.y;
import y.f.c.a.aQ;
import y.f.c.a.aV;
import y.f.c.a.aX;
import y.f.c.a.bt;
import y.f.g.C;
import y.f.g.F;
import y.f.g.d;

final class G
implements aQ {
    int a;
    y b;
    byte c;
    f d;
    private final F e;

    @Override
    public void a() {
        if (this.a < 0) {
            throw new IllegalStateException();
        }
        this.e.b(this.c());
    }

    public G(F f2, byte by2, int n2) {
        this.e = f2;
        this.b = new y();
        this.d = new f();
        this.a = n2;
        this.c = by2;
    }

    @Override
    public void a(q q2) {
        C c2 = (C)this.e.b.a(q2);
        c2.a(this);
        c2.b(this.b.size());
        this.b.add(q2);
    }

    @Override
    public int c() {
        if (!this.e.c) return this.a;
        this.e.c();
        return this.a;
    }

    @Override
    public bt b() {
        return null;
    }

    @Override
    public void a(bt bt2) {
    }

    @Override
    public y d() {
        return this.b;
    }

    @Override
    public byte e() {
        return this.c;
    }

    @Override
    public void a(D d2) {
        boolean bl2 = d.d;
        if (d2.size() != this.b.size()) {
            throw new IllegalArgumentException();
        }
        p p2 = d2.k();
        p p3 = this.b.k();
        int n2 = 0;
        do {
            if (p2 == null) return;
            q q2 = (q)p2.c();
            p3.a(q2);
            C c2 = (C)this.e.b.a(q2);
            c2.b(n2);
            ++n2;
            p2 = p2.a();
            p3 = p3.a();
        } while (!bl2);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void b(q var1_1) {
        var6_2 = d.d;
        var2_3 = 0;
        var3_4 = this.b.k();
        do {
            if (var3_4 == null) return;
            var4_5 = (q)var3_4.c();
            if (var4_5 != var1_1) ** GOTO lbl-1000
            this.b.h(var3_4);
            if (var6_2) lbl-1000: // 2 sources:
            {
                var5_6 = (C)this.e.b.a(var4_5);
                var5_6.b(var2_3);
                ++var2_3;
            }
            var3_4 = var3_4.a();
        } while (!var6_2);
    }

    @Override
    public D f() {
        return this.d;
    }

    @Override
    public void a(y.c.d d2) {
        this.d.add(d2);
    }
}

