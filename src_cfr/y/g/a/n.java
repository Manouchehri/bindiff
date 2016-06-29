/*
 * Decompiled with CFR 0_115.
 */
package y.g.a;

import y.g.a.d;
import y.g.a.o;

class n {
    private o[] a;
    private int b;
    private int c;

    public n(int n2) {
        this.a = new o[n2 + 2];
        this.b = 0;
        this.c = n2;
    }

    public o a(double d2, Object object) {
        Object object2;
        if (this.b == this.c) {
            this.c += 1024;
            object2 = new o[this.c + 2];
            System.arraycopy(this.a, 0, object2, 0, this.a.length);
            this.a = object2;
        }
        ++this.b;
        object2 = new o(d2, object, this.b);
        this.a(this.b, (o)object2);
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

    public void a(int n2, o o2) {
        boolean bl2 = d.a;
        this.a[0] = o2;
        int n3 = n2 / 2;
        o o3 = this.a[n3];
        while (o3.a > o2.a) {
            this.a[n2] = o3;
            o3.c = n2;
            n2 = n3;
            o3 = this.a[n3 >>= 1];
            if (bl2) return;
            if (!bl2) continue;
        }
        this.a[n2] = o2;
        o2.c = n2;
    }

    public void b(int n2, o o2) {
        boolean bl2 = d.a;
        this.a[this.b + 1] = this.a[this.b];
        for (int i2 = n2 << 1; i2 <= this.b; i2 <<= 1) {
            o o3 = this.a[i2];
            if (bl2) return;
            if (i2 < this.b && this.a[i2 + 1].a < o3.a) {
                o3 = this.a[++i2];
            }
            if (o2.a <= o3.a) break;
            this.a[n2] = o3;
            o3.c = n2;
            n2 = i2;
            if (!bl2) continue;
        }
        this.a[n2] = o2;
        o2.c = n2;
    }

    public void a(o o2) {
        o o3 = this.a[this.b];
        this.a[this.b] = null;
        --this.b;
        if (o2 == o3) return;
        if (o3.a > o2.a) {
            this.b(o2.c, o3);
            if (!d.a) return;
        }
        this.a(o2.c, o3);
    }

    public void a(o o2, double d2) {
        o2.a = d2;
        this.a(o2.c, o2);
    }

    public void b(o o2, double d2) {
        o2.a = d2;
        this.b(o2.c, o2);
    }

    public void c(o o2, double d2) {
        if (d2 < o2.a) {
            this.a(o2, d2);
            if (!d.a) return;
        }
        this.b(o2, d2);
    }

    public o b() {
        return this.a[1];
    }

    public boolean c() {
        if (this.b != 0) return false;
        return true;
    }
}

