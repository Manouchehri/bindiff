/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.d.t;

class H {
    private t a;
    private t b;

    H(t t2, t t3) {
        this.a = t2;
        this.b = t3;
    }

    private boolean e() {
        if (this.a.a() != this.b.a()) return false;
        return true;
    }

    boolean a() {
        if (!this.e()) return false;
        if (this.a.b() <= this.b.b()) return false;
        return true;
    }

    boolean b() {
        if (!this.e()) return false;
        if (this.a.b() >= this.b.b()) return false;
        return true;
    }

    boolean c() {
        if (this.e()) return false;
        if (this.a.a() <= this.b.a()) return false;
        return true;
    }

    int d() {
        if (this.a()) {
            return 0;
        }
        if (this.b()) {
            return 1;
        }
        if (!this.c()) return 3;
        return 2;
    }

    static boolean a(H h2) {
        return h2.e();
    }
}

