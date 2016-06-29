/*
 * Decompiled with CFR 0_115.
 */
package y.f.h.a;

import y.f.h.a.i;

class h {
    i a;
    h b;
    h c;

    h(i i2, h h2, h h3) {
        this.a = i2;
        this.b = h2;
        this.c = h3;
    }

    i a() {
        return this.a;
    }

    void a(h h2) {
        this.b = h2;
    }

    void b(h h2) {
        this.c = h2;
    }

    void b() {
        this.b.b(this.c);
        this.c.a(this.b);
    }

    h a(i i2) {
        h h2 = new h(i2, this.b, this);
        this.b.b(h2);
        this.a(h2);
        return h2;
    }
}

