/*
 * Decompiled with CFR 0_115.
 */
package y.f.f.e;

import y.f.f.e.a;
import y.f.f.e.h;

class f {
    private h[] a;
    private int b;

    f(int n2) {
        this.a = new h[n2 + 2];
        this.b = 0;
    }

    public void a(int n2, h h2) {
        ++this.b;
        h2.a = n2;
        h2.d = this.b;
        this.b(this.b, h2);
    }

    public void a() {
        int n2 = a.a;
        for (int i2 = 1; i2 <= this.b; ++i2) {
            this.a[i2] = null;
            if (n2 != 0) return;
            if (n2 == 0) continue;
        }
        this.b = 0;
    }

    public void b(int n2, h h2) {
        int n3 = a.a;
        this.a[0] = h2;
        int n4 = n2 / 2;
        h h3 = this.a[n4];
        while (h3.a > h2.a) {
            this.a[n2] = h3;
            h3.d = n2;
            n2 = n4;
            h3 = this.a[n4 >>= 1];
            if (n3 != 0) return;
            if (n3 == 0) continue;
        }
        this.a[n2] = h2;
        h2.d = n2;
    }

    public void c(int n2, h h2) {
        int n3 = a.a;
        this.a[this.b + 1] = this.a[this.b];
        for (int i2 = n2 << 1; i2 <= this.b; i2 <<= 1) {
            h h3 = this.a[i2];
            if (n3 != 0) return;
            if (i2 < this.b && this.a[i2 + 1].a < h3.a) {
                h3 = this.a[++i2];
            }
            if (h2.a <= h3.a) break;
            this.a[n2] = h3;
            h3.d = n2;
            n2 = i2;
            if (n3 == 0) continue;
        }
        this.a[n2] = h2;
        h2.d = n2;
    }

    public void a(h h2) {
        h h3 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (h2 == h3) return;
        if (h3.a > h2.a) {
            this.c(h2.d, h3);
            if (a.a == 0) return;
        }
        this.b(h2.d, h3);
    }

    public void a(h h2, int n2) {
        h2.a = n2;
        this.b(h2.d, h2);
    }

    public h b() {
        return this.a[1];
    }

    public boolean c() {
        if (this.b != 0) return false;
        return true;
    }
}

