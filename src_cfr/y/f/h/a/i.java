/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import y.f.h.a.f;
import y.f.h.a.h;
import y.f.h.a.m;
import y.f.h.a.n;
import y.f.h.a.r;

class i
extends r {
    private n b;
    private n c;
    private h d;
    private boolean e = false;

    i(n n2, n n3) {
        this.b = n2;
        this.c = n3;
    }

    public String toString() {
        if (this.a == null) return new StringBuffer().append(this.f()).append("^").append(this.c.f()).toString();
        return new StringBuffer().append(this.f()).append("^").append(this.c.f()).append(": ").append(this.a.toString()).toString();
    }

    @Override
    String a() {
        return new StringBuffer().append(this.f()).append("^").append(this.c.f()).toString();
    }

    @Override
    n b() {
        return this.b;
    }

    n c() {
        return this.c;
    }

    void d() {
        this.a.c();
        if (this.c == null) return;
        this.c.j().g();
    }

    void e() {
        this.e = true;
        if (this.d != null) {
            this.d.b();
        }
        this.d = null;
    }

    void a(h h2) {
        this.d = h2;
    }

    @Override
    int f() {
        return this.b.f();
    }

    boolean a(int n2) {
        if (this.c.l() >= n2) return false;
        return true;
    }

    boolean b(int n2) {
        if (this.c.l() != n2) return false;
        return true;
    }

    @Override
    boolean g() {
        return this.e;
    }
}

