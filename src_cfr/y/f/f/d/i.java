/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.d;

import y.f.f.d.o;
import y.f.f.d.u;

class I {
    private u[] a;
    private int b;

    public I(int n2) {
        this.a = new u[n2 + 2];
        this.b = 0;
    }

    public void a(int n2, u u2) {
        ++this.b;
        u2.a = n2;
        u2.d = this.b;
        this.b(this.b, u2);
    }

    public void a() {
        boolean bl2 = o.p;
        for (int i2 = 1; i2 <= this.b; ++i2) {
            this.a[i2] = null;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.b = 0;
    }

    public void b(int n2, u u2) {
        boolean bl2 = o.p;
        this.a[0] = u2;
        int n3 = n2 / 2;
        u u3 = this.a[n3];
        while (u3.a > u2.a) {
            this.a[n2] = u3;
            u3.d = n2;
            n2 = n3;
            u3 = this.a[n3 >>= 1];
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a[n2] = u2;
        u2.d = n2;
    }

    public void c(int n2, u u2) {
        boolean bl2 = o.p;
        this.a[this.b + 1] = this.a[this.b];
        for (int i2 = n2 << 1; i2 <= this.b; i2 <<= 1) {
            u u3 = this.a[i2];
            if (bl2) return;
            if (i2 < this.b && this.a[i2 + 1].a < u3.a) {
                u3 = this.a[++i2];
            }
            if (u2.a <= u3.a) break;
            this.a[n2] = u3;
            u3.d = n2;
            n2 = i2;
            if (!bl2) continue;
        }
        this.a[n2] = u2;
        u2.d = n2;
    }

    public void a(u u2) {
        u u3 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (u2 == u3) return;
        if (u3.a > u2.a) {
            this.c(u2.d, u3);
            if (!o.p) return;
        }
        this.b(u2.d, u3);
    }

    public void a(u u2, int n2) {
        u2.a = n2;
        this.b(u2.d, u2);
    }

    public u b() {
        return this.a[1];
    }

    public boolean c() {
        if (this.b != 0) return false;
        return true;
    }
}

