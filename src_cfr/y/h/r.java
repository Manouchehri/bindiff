/*
 * Decompiled with CFR 0_115.
 */
package y.h;

import java.util.Iterator;
import y.h.O;
import y.h.P;
import y.h.Q;
import y.h.U;
import y.h.bu;
import y.h.cg;
import y.h.fj;
import y.h.hP;

final class R
implements cg {
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    private cg f;
    private final O g;

    R(O o2) {
        this.g = o2;
        this.c = true;
        U u2 = new U();
        u2.a(this.a);
        u2.b(this.c);
        u2.c(this.d);
        this.f = u2;
    }

    @Override
    public Iterator a(bu bu2, int n2) {
        cg cg2 = this.e() ? new hP(this.f, this.c()) : this.f;
        return cg2.a(bu2, n2);
    }

    @Override
    public Iterator b(bu bu2, int n2) {
        cg cg2 = this.e() ? new hP(this.f, this.c()) : this.f;
        return cg2.b(bu2, n2);
    }

    boolean a() {
        return this.b;
    }

    void a(boolean bl2) {
        U u2;
        if (this.b == bl2) return;
        this.b = bl2;
        if (this.b) {
            u2 = new Q(this.g, null);
            u2.a = this.a;
            this.f = u2;
            if (!fj.z) return;
        }
        u2 = new U();
        u2.a(this.a);
        u2.b(this.c);
        u2.c(this.d);
        this.f = u2;
    }

    boolean b() {
        return this.c;
    }

    void b(boolean bl2) {
        this.c = bl2;
        if (this.b) return;
        ((U)this.f).b(bl2);
    }

    boolean c() {
        return this.d;
    }

    void c(boolean bl2) {
        this.d = bl2;
        if (this.b) return;
        ((U)this.f).c(bl2);
    }

    boolean d() {
        return this.a;
    }

    void d(boolean bl2) {
        this.a = bl2;
        if (!this.b) {
            ((U)this.f).a(bl2);
            if (!fj.z) return;
        }
        ((Q)this.f).a = bl2;
    }

    public boolean e() {
        return this.e;
    }

    public void e(boolean bl2) {
        this.e = bl2;
    }
}

