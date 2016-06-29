/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.g.a.d;
import y.g.a.q;

class p {
    private q[] a;
    private int b;
    private int c;

    public p(int n2) {
        this.a = new q[n2 + 2];
        this.b = 0;
        this.c = n2;
    }

    public q a(int n2, Object object) {
        Object object2;
        if (this.b == this.c) {
            this.c += 1024;
            object2 = new q[this.c + 2];
            System.arraycopy(this.a, 0, object2, 0, this.a.length);
            this.a = object2;
        }
        ++this.b;
        object2 = new q(n2, object, this.b);
        this.a(this.b, (q)object2);
        return object2;
    }

    public void a() {
        boolean bl2 = d.a;
        for (int i2 = 1; i2 <= this.b; ++i2) {
            this.a[i2] = null;
            if (bl2) return;
            if (!bl2) continue;
        }
        this.b = 0;
    }

    public void a(int n2, q q2) {
        boolean bl2 = d.a;
        this.a[0] = q2;
        int n3 = n2 / 2;
        q q3 = this.a[n3];
        while (q3.a > q2.a) {
            this.a[n2] = q3;
            q3.c = n2;
            n2 = n3;
            q3 = this.a[n3 >>= 1];
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a[n2] = q2;
        q2.c = n2;
        this.a[0] = null;
    }

    public void b(int n2, q q2) {
        boolean bl2 = d.a;
        this.a[this.b + 1] = this.a[this.b];
        for (int i2 = n2 << 1; i2 <= this.b; i2 <<= 1) {
            q q3 = this.a[i2];
            if (bl2) return;
            if (i2 < this.b && this.a[i2 + 1].a < q3.a) {
                q3 = this.a[++i2];
            }
            if (q2.a <= q3.a) break;
            this.a[n2] = q3;
            q3.c = n2;
            n2 = i2;
            if (!bl2) continue;
        }
        this.a[n2] = q2;
        q2.c = n2;
        this.a[this.b + 1] = null;
    }

    public void a(q q2) {
        q q3 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (q2 == q3) return;
        if (q3.a > q2.a) {
            this.b(q2.c, q3);
            if (!d.a) return;
        }
        this.a(q2.c, q3);
    }

    public void a(q q2, int n2) {
        q2.a = n2;
        this.a(q2.c, q2);
    }

    public void b(q q2, int n2) {
        q2.a = n2;
        this.b(q2.c, q2);
    }

    public void c(q q2, int n2) {
        if (n2 < q2.a) {
            this.a(q2, n2);
            if (!d.a) return;
        }
        this.b(q2, n2);
    }

    public q b() {
        return this.a[1];
    }

    public boolean c() {
        if (this.b != 0) return false;
        return true;
    }
}

