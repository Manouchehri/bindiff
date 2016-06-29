/*
 * Decompiled with CFR 0_115.
 */
package y.f.i;

import y.c.d;
import y.c.i;
import y.c.q;
import y.f.i.v;

class aQ {
    d[] a;
    q[] b;
    int c;
    int d;
    private i e;

    public aQ(i i2) {
        this.e = i2;
        this.a = new d[200];
        this.c = 0;
        this.b = new q[200];
        this.d = 0;
    }

    public d a(q q2, q q3) {
        if (this.c == 0) {
            return this.e.a(q2, q3);
        }
        d d2 = this.a[--this.c];
        this.e.a(d2, q2, q3);
        this.e.b(d2);
        return d2;
    }

    public void a(d d2) {
        this.e.a(d2);
        if (this.c >= this.a.length) {
            d[] arrd = new d[2 * this.c];
            System.arraycopy(this.a, 0, arrd, 0, this.a.length);
            this.a = arrd;
        }
        this.a[this.c++] = d2;
    }

    public q a() {
        if (this.d == 0) {
            return this.e.d();
        }
        q q2 = this.b[--this.d];
        this.e.b(q2);
        return q2;
    }

    public void a(q q2) {
        block5 : {
            int n2 = v.f;
            while (q2.b() > 0) {
                this.a(q2.g());
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block5;
            }
            while (q2.c() > 0) {
                this.a(q2.f());
                if (n2 == 0) {
                    if (n2 == 0) continue;
                }
                break block5;
            }
            this.e.a(q2);
        }
        if (this.d >= this.b.length) {
            q[] arrq = new q[2 * this.d];
            System.arraycopy(this.b, 0, arrq, 0, this.b.length);
            this.b = arrq;
        }
        this.b[this.d++] = q2;
    }
}

